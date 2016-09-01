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
import com.bydan.erp.nomina.util.GastoEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.GastoEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.GastoEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.GastoEmpleado;
import com.bydan.erp.nomina.business.logic.GastoEmpleadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class GastoEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(GastoEmpleadoLogic.class);
	
	protected GastoEmpleadoDataAccess gastoempleadoDataAccess; 	
	protected GastoEmpleado gastoempleado;
	protected List<GastoEmpleado> gastoempleados;
	protected Object gastoempleadoObject;	
	protected List<Object> gastoempleadosObject;
	
	public static ClassValidator<GastoEmpleado> gastoempleadoValidator = new ClassValidator<GastoEmpleado>(GastoEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected GastoEmpleadoLogicAdditional gastoempleadoLogicAdditional=null;
	
	public GastoEmpleadoLogicAdditional getGastoEmpleadoLogicAdditional() {
		return this.gastoempleadoLogicAdditional;
	}
	
	public void setGastoEmpleadoLogicAdditional(GastoEmpleadoLogicAdditional gastoempleadoLogicAdditional) {
		try {
			this.gastoempleadoLogicAdditional=gastoempleadoLogicAdditional;
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
	
	
	
	
	public  GastoEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.gastoempleadoDataAccess = new GastoEmpleadoDataAccess();
			
			this.gastoempleados= new ArrayList<GastoEmpleado>();
			this.gastoempleado= new GastoEmpleado();
			
			this.gastoempleadoObject=new Object();
			this.gastoempleadosObject=new ArrayList<Object>();
				
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
			
			this.gastoempleadoDataAccess.setConnexionType(this.connexionType);
			this.gastoempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  GastoEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.gastoempleadoDataAccess = new GastoEmpleadoDataAccess();
			this.gastoempleados= new ArrayList<GastoEmpleado>();
			this.gastoempleado= new GastoEmpleado();
			this.gastoempleadoObject=new Object();
			this.gastoempleadosObject=new ArrayList<Object>();
			
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
			
			this.gastoempleadoDataAccess.setConnexionType(this.connexionType);
			this.gastoempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public GastoEmpleado getGastoEmpleado() throws Exception {	
		GastoEmpleadoLogicAdditional.checkGastoEmpleadoToGet(gastoempleado,this.datosCliente,this.arrDatoGeneral);
		GastoEmpleadoLogicAdditional.updateGastoEmpleadoToGet(gastoempleado,this.arrDatoGeneral);
		
		return gastoempleado;
	}
		
	public void setGastoEmpleado(GastoEmpleado newGastoEmpleado) {
		this.gastoempleado = newGastoEmpleado;
	}
	
	public GastoEmpleadoDataAccess getGastoEmpleadoDataAccess() {
		return gastoempleadoDataAccess;
	}
	
	public void setGastoEmpleadoDataAccess(GastoEmpleadoDataAccess newgastoempleadoDataAccess) {
		this.gastoempleadoDataAccess = newgastoempleadoDataAccess;
	}
	
	public List<GastoEmpleado> getGastoEmpleados() throws Exception {		
		this.quitarGastoEmpleadosNulos();
		
		GastoEmpleadoLogicAdditional.checkGastoEmpleadoToGets(gastoempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (GastoEmpleado gastoempleadoLocal: gastoempleados ) {
			GastoEmpleadoLogicAdditional.updateGastoEmpleadoToGet(gastoempleadoLocal,this.arrDatoGeneral);
		}
		
		return gastoempleados;
	}
	
	public void setGastoEmpleados(List<GastoEmpleado> newGastoEmpleados) {
		this.gastoempleados = newGastoEmpleados;
	}
	
	public Object getGastoEmpleadoObject() {	
		this.gastoempleadoObject=this.gastoempleadoDataAccess.getEntityObject();
		return this.gastoempleadoObject;
	}
		
	public void setGastoEmpleadoObject(Object newGastoEmpleadoObject) {
		this.gastoempleadoObject = newGastoEmpleadoObject;
	}
	
	public List<Object> getGastoEmpleadosObject() {		
		this.gastoempleadosObject=this.gastoempleadoDataAccess.getEntitiesObject();
		return this.gastoempleadosObject;
	}
		
	public void setGastoEmpleadosObject(List<Object> newGastoEmpleadosObject) {
		this.gastoempleadosObject = newGastoEmpleadosObject;
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
		
		if(this.gastoempleadoDataAccess!=null) {
			this.gastoempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			gastoempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			gastoempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		gastoempleado = new  GastoEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			gastoempleado=gastoempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.gastoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleado);
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
		gastoempleado = new  GastoEmpleado();
		  		  
        try {
			
			gastoempleado=gastoempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.gastoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		gastoempleado = new  GastoEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			gastoempleado=gastoempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.gastoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleado);
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
		gastoempleado = new  GastoEmpleado();
		  		  
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
		gastoempleado = new  GastoEmpleado();
		  		  
        try {
			
			gastoempleado=gastoempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.gastoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		gastoempleado = new  GastoEmpleado();
		  		  
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
		gastoempleado = new  GastoEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =gastoempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		gastoempleado = new  GastoEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=gastoempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		gastoempleado = new  GastoEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =gastoempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		gastoempleado = new  GastoEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=gastoempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		gastoempleado = new  GastoEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =gastoempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		gastoempleado = new  GastoEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=gastoempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		gastoempleados = new  ArrayList<GastoEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastoempleados=gastoempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoEmpleado(gastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
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
		gastoempleados = new  ArrayList<GastoEmpleado>();
		  		  
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
		gastoempleados = new  ArrayList<GastoEmpleado>();
		  		  
        try {			
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastoempleados=gastoempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarGastoEmpleado(gastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		gastoempleados = new  ArrayList<GastoEmpleado>();
		  		  
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
		gastoempleados = new  ArrayList<GastoEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoEmpleado(gastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
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
		gastoempleados = new  ArrayList<GastoEmpleado>();
		  		  
        try {
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoEmpleado(gastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
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
		gastoempleados = new  ArrayList<GastoEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGastoEmpleado(gastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
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
		gastoempleados = new  ArrayList<GastoEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGastoEmpleado(gastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		gastoempleado = new  GastoEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastoempleado=gastoempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGastoEmpleado(gastoempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleado);
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
		gastoempleado = new  GastoEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastoempleado=gastoempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGastoEmpleado(gastoempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		gastoempleados = new  ArrayList<GastoEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastoempleados=gastoempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoEmpleado(gastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
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
		gastoempleados = new  ArrayList<GastoEmpleado>();
		  		  
        try {
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastoempleados=gastoempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoEmpleado(gastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosGastoEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		gastoempleados = new  ArrayList<GastoEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getTodosGastoEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGastoEmpleado(gastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
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
	
	public  void  getTodosGastoEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		gastoempleados = new  ArrayList<GastoEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGastoEmpleado(gastoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarGastoEmpleado(GastoEmpleado gastoempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(gastoempleado.getIsNew() || gastoempleado.getIsChanged()) { 
			this.invalidValues = gastoempleadoValidator.getInvalidValues(gastoempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(gastoempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarGastoEmpleado(List<GastoEmpleado> GastoEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(GastoEmpleado gastoempleadoLocal:gastoempleados) {				
			estaValidadoObjeto=this.validarGuardarGastoEmpleado(gastoempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarGastoEmpleado(List<GastoEmpleado> GastoEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGastoEmpleado(gastoempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarGastoEmpleado(GastoEmpleado GastoEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGastoEmpleado(gastoempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(GastoEmpleado gastoempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+gastoempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=GastoEmpleadoConstantesFunciones.getGastoEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"gastoempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(GastoEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(GastoEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveGastoEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-saveGastoEmpleadoWithConnection");connexion.begin();			
			
			GastoEmpleadoLogicAdditional.checkGastoEmpleadoToSave(this.gastoempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GastoEmpleadoLogicAdditional.updateGastoEmpleadoToSave(this.gastoempleado,this.arrDatoGeneral);
			
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.gastoempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowGastoEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGastoEmpleado(this.gastoempleado)) {
				GastoEmpleadoDataAccess.save(this.gastoempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.gastoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GastoEmpleadoLogicAdditional.checkGastoEmpleadoToSaveAfter(this.gastoempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGastoEmpleado();
			
			connexion.commit();			
			
			if(this.gastoempleado.getIsDeleted()) {
				this.gastoempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveGastoEmpleado()throws Exception {	
		try {	
			
			GastoEmpleadoLogicAdditional.checkGastoEmpleadoToSave(this.gastoempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GastoEmpleadoLogicAdditional.updateGastoEmpleadoToSave(this.gastoempleado,this.arrDatoGeneral);
			
			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.gastoempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGastoEmpleado(this.gastoempleado)) {			
				GastoEmpleadoDataAccess.save(this.gastoempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.gastoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GastoEmpleadoLogicAdditional.checkGastoEmpleadoToSaveAfter(this.gastoempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.gastoempleado.getIsDeleted()) {
				this.gastoempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveGastoEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-saveGastoEmpleadosWithConnection");connexion.begin();			
			
			GastoEmpleadoLogicAdditional.checkGastoEmpleadoToSaves(gastoempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowGastoEmpleados();
			
			Boolean validadoTodosGastoEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GastoEmpleado gastoempleadoLocal:gastoempleados) {		
				if(gastoempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GastoEmpleadoLogicAdditional.updateGastoEmpleadoToSave(gastoempleadoLocal,this.arrDatoGeneral);
	        	
				GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),gastoempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGastoEmpleado(gastoempleadoLocal)) {
					GastoEmpleadoDataAccess.save(gastoempleadoLocal, connexion);				
				} else {
					validadoTodosGastoEmpleado=false;
				}
			}
			
			if(!validadoTodosGastoEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GastoEmpleadoLogicAdditional.checkGastoEmpleadoToSavesAfter(gastoempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGastoEmpleados();
			
			connexion.commit();		
			
			this.quitarGastoEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveGastoEmpleados()throws Exception {				
		 try {	
			GastoEmpleadoLogicAdditional.checkGastoEmpleadoToSaves(gastoempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosGastoEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GastoEmpleado gastoempleadoLocal:gastoempleados) {				
				if(gastoempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GastoEmpleadoLogicAdditional.updateGastoEmpleadoToSave(gastoempleadoLocal,this.arrDatoGeneral);
	        	
				GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),gastoempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGastoEmpleado(gastoempleadoLocal)) {				
					GastoEmpleadoDataAccess.save(gastoempleadoLocal, connexion);				
				} else {
					validadoTodosGastoEmpleado=false;
				}
			}
			
			if(!validadoTodosGastoEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GastoEmpleadoLogicAdditional.checkGastoEmpleadoToSavesAfter(gastoempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarGastoEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GastoEmpleadoParameterReturnGeneral procesarAccionGastoEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GastoEmpleado> gastoempleados,GastoEmpleadoParameterReturnGeneral gastoempleadoParameterGeneral)throws Exception {
		 try {	
			GastoEmpleadoParameterReturnGeneral gastoempleadoReturnGeneral=new GastoEmpleadoParameterReturnGeneral();
	
			GastoEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,gastoempleados,gastoempleadoParameterGeneral,gastoempleadoReturnGeneral);
			
			return gastoempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GastoEmpleadoParameterReturnGeneral procesarAccionGastoEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GastoEmpleado> gastoempleados,GastoEmpleadoParameterReturnGeneral gastoempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-procesarAccionGastoEmpleadosWithConnection");connexion.begin();			
			
			GastoEmpleadoParameterReturnGeneral gastoempleadoReturnGeneral=new GastoEmpleadoParameterReturnGeneral();
	
			GastoEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,gastoempleados,gastoempleadoParameterGeneral,gastoempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return gastoempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GastoEmpleadoParameterReturnGeneral procesarEventosGastoEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GastoEmpleado> gastoempleados,GastoEmpleado gastoempleado,GastoEmpleadoParameterReturnGeneral gastoempleadoParameterGeneral,Boolean isEsNuevoGastoEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			GastoEmpleadoParameterReturnGeneral gastoempleadoReturnGeneral=new GastoEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				gastoempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GastoEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,gastoempleados,gastoempleado,gastoempleadoParameterGeneral,gastoempleadoReturnGeneral,isEsNuevoGastoEmpleado,clases);
			
			return gastoempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public GastoEmpleadoParameterReturnGeneral procesarEventosGastoEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GastoEmpleado> gastoempleados,GastoEmpleado gastoempleado,GastoEmpleadoParameterReturnGeneral gastoempleadoParameterGeneral,Boolean isEsNuevoGastoEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-procesarEventosGastoEmpleadosWithConnection");connexion.begin();			
			
			GastoEmpleadoParameterReturnGeneral gastoempleadoReturnGeneral=new GastoEmpleadoParameterReturnGeneral();
	
			gastoempleadoReturnGeneral.setGastoEmpleado(gastoempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				gastoempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GastoEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,gastoempleados,gastoempleado,gastoempleadoParameterGeneral,gastoempleadoReturnGeneral,isEsNuevoGastoEmpleado,clases);
			
			this.connexion.commit();
			
			return gastoempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GastoEmpleadoParameterReturnGeneral procesarImportacionGastoEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,GastoEmpleadoParameterReturnGeneral gastoempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-procesarImportacionGastoEmpleadosWithConnection");connexion.begin();			
			
			GastoEmpleadoParameterReturnGeneral gastoempleadoReturnGeneral=new GastoEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.gastoempleados=new ArrayList<GastoEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.gastoempleado=new GastoEmpleado();
				
				
				if(conColumnasBase) {this.gastoempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.gastoempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.gastoempleado.setdia(Integer.parseInt(arrColumnas[iColumn++]));
				this.gastoempleado.settotal_ingreso_actual(Double.parseDouble(arrColumnas[iColumn++]));
				this.gastoempleado.settotal_ingreso_otro(Double.parseDouble(arrColumnas[iColumn++]));
				this.gastoempleado.settotal_ingreso(Double.parseDouble(arrColumnas[iColumn++]));
				this.gastoempleado.setgasto_vivienda(Double.parseDouble(arrColumnas[iColumn++]));
				this.gastoempleado.setgasto_educacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.gastoempleado.setgasto_salud(Double.parseDouble(arrColumnas[iColumn++]));
				this.gastoempleado.setgasto_vestimenta(Double.parseDouble(arrColumnas[iColumn++]));
				this.gastoempleado.setgasto_alimentacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.gastoempleado.settotal_gasto_actual(Double.parseDouble(arrColumnas[iColumn++]));
				this.gastoempleado.settotal_gasto(Double.parseDouble(arrColumnas[iColumn++]));
				this.gastoempleado.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.gastoempleado.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.gastoempleado.setvalor_maximo(Double.parseDouble(arrColumnas[iColumn++]));
				this.gastoempleado.setvalor_maximo_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.gastoempleados.add(this.gastoempleado);
			}
			
			this.saveGastoEmpleados();
			
			this.connexion.commit();
			
			gastoempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			gastoempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return gastoempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarGastoEmpleadosEliminados() throws Exception {				
		
		List<GastoEmpleado> gastoempleadosAux= new ArrayList<GastoEmpleado>();
		
		for(GastoEmpleado gastoempleado:gastoempleados) {
			if(!gastoempleado.getIsDeleted()) {
				gastoempleadosAux.add(gastoempleado);
			}
		}
		
		gastoempleados=gastoempleadosAux;
	}
	
	public void quitarGastoEmpleadosNulos() throws Exception {				
		
		List<GastoEmpleado> gastoempleadosAux= new ArrayList<GastoEmpleado>();
		
		for(GastoEmpleado gastoempleado : this.gastoempleados) {
			if(gastoempleado==null) {
				gastoempleadosAux.add(gastoempleado);
			}
		}
		
		//this.gastoempleados=gastoempleadosAux;
		
		this.gastoempleados.removeAll(gastoempleadosAux);
	}
	
	public void getSetVersionRowGastoEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(gastoempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((gastoempleado.getIsDeleted() || (gastoempleado.getIsChanged()&&!gastoempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=gastoempleadoDataAccess.getSetVersionRowGastoEmpleado(connexion,gastoempleado.getId());
				
				if(!gastoempleado.getVersionRow().equals(timestamp)) {	
					gastoempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				gastoempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowGastoEmpleado()throws Exception {	
		
		if(gastoempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((gastoempleado.getIsDeleted() || (gastoempleado.getIsChanged()&&!gastoempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=gastoempleadoDataAccess.getSetVersionRowGastoEmpleado(connexion,gastoempleado.getId());
			
			try {							
				if(!gastoempleado.getVersionRow().equals(timestamp)) {	
					gastoempleado.setVersionRow(timestamp);
				}
				
				gastoempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowGastoEmpleadosWithConnection()throws Exception {	
		if(gastoempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(GastoEmpleado gastoempleadoAux:gastoempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(gastoempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(gastoempleadoAux.getIsDeleted() || (gastoempleadoAux.getIsChanged()&&!gastoempleadoAux.getIsNew())) {
						
						timestamp=gastoempleadoDataAccess.getSetVersionRowGastoEmpleado(connexion,gastoempleadoAux.getId());
						
						if(!gastoempleado.getVersionRow().equals(timestamp)) {	
							gastoempleadoAux.setVersionRow(timestamp);
						}
								
						gastoempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowGastoEmpleados()throws Exception {	
		if(gastoempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(GastoEmpleado gastoempleadoAux:gastoempleados) {
					if(gastoempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(gastoempleadoAux.getIsDeleted() || (gastoempleadoAux.getIsChanged()&&!gastoempleadoAux.getIsNew())) {
						
						timestamp=gastoempleadoDataAccess.getSetVersionRowGastoEmpleado(connexion,gastoempleadoAux.getId());
						
						if(!gastoempleadoAux.getVersionRow().equals(timestamp)) {	
							gastoempleadoAux.setVersionRow(timestamp);
						}
						
													
						gastoempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public GastoEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyGastoEmpleadoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleado,String finalQueryGlobalEjercicio,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalEstadoGastoEmpleado) throws Exception {
		GastoEmpleadoParameterReturnGeneral  gastoempleadoReturnGeneral =new GastoEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-cargarCombosLoteForeignKeyGastoEmpleadoWithConnection");connexion.begin();
			
			gastoempleadoReturnGeneral =new GastoEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			gastoempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			gastoempleadoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			gastoempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			gastoempleadoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			gastoempleadoReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			gastoempleadoReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			gastoempleadoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			gastoempleadoReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			gastoempleadoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<EstadoGastoEmpleado> estadogastoempleadosForeignKey=new ArrayList<EstadoGastoEmpleado>();
			EstadoGastoEmpleadoLogic estadogastoempleadoLogic=new EstadoGastoEmpleadoLogic();
			estadogastoempleadoLogic.setConnexion(this.connexion);
			estadogastoempleadoLogic.getEstadoGastoEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoGastoEmpleado.equals("NONE")) {
				estadogastoempleadoLogic.getTodosEstadoGastoEmpleados(finalQueryGlobalEstadoGastoEmpleado,new Pagination());
				estadogastoempleadosForeignKey=estadogastoempleadoLogic.getEstadoGastoEmpleados();
			}

			gastoempleadoReturnGeneral.setestadogastoempleadosForeignKey(estadogastoempleadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return gastoempleadoReturnGeneral;
	}
	
	public GastoEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyGastoEmpleado(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleado,String finalQueryGlobalEjercicio,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalEstadoGastoEmpleado) throws Exception {
		GastoEmpleadoParameterReturnGeneral  gastoempleadoReturnGeneral =new GastoEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			gastoempleadoReturnGeneral =new GastoEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			gastoempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			gastoempleadoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			gastoempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			gastoempleadoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			gastoempleadoReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			gastoempleadoReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			gastoempleadoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			gastoempleadoReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			gastoempleadoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<EstadoGastoEmpleado> estadogastoempleadosForeignKey=new ArrayList<EstadoGastoEmpleado>();
			EstadoGastoEmpleadoLogic estadogastoempleadoLogic=new EstadoGastoEmpleadoLogic();
			estadogastoempleadoLogic.setConnexion(this.connexion);
			estadogastoempleadoLogic.getEstadoGastoEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoGastoEmpleado.equals("NONE")) {
				estadogastoempleadoLogic.getTodosEstadoGastoEmpleados(finalQueryGlobalEstadoGastoEmpleado,new Pagination());
				estadogastoempleadosForeignKey=estadogastoempleadoLogic.getEstadoGastoEmpleados();
			}

			gastoempleadoReturnGeneral.setestadogastoempleadosForeignKey(estadogastoempleadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return gastoempleadoReturnGeneral;
	}
	
	
	public void deepLoad(GastoEmpleado gastoempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			GastoEmpleadoLogicAdditional.updateGastoEmpleadoToGet(gastoempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		gastoempleado.setEmpresa(gastoempleadoDataAccess.getEmpresa(connexion,gastoempleado));
		gastoempleado.setSucursal(gastoempleadoDataAccess.getSucursal(connexion,gastoempleado));
		gastoempleado.setEmpleado(gastoempleadoDataAccess.getEmpleado(connexion,gastoempleado));
		gastoempleado.setEjercicio(gastoempleadoDataAccess.getEjercicio(connexion,gastoempleado));
		gastoempleado.setPais(gastoempleadoDataAccess.getPais(connexion,gastoempleado));
		gastoempleado.setCiudad(gastoempleadoDataAccess.getCiudad(connexion,gastoempleado));
		gastoempleado.setAnio(gastoempleadoDataAccess.getAnio(connexion,gastoempleado));
		gastoempleado.setMes(gastoempleadoDataAccess.getMes(connexion,gastoempleado));
		gastoempleado.setUsuario(gastoempleadoDataAccess.getUsuario(connexion,gastoempleado));
		gastoempleado.setEstadoGastoEmpleado(gastoempleadoDataAccess.getEstadoGastoEmpleado(connexion,gastoempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				gastoempleado.setEmpresa(gastoempleadoDataAccess.getEmpresa(connexion,gastoempleado));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				gastoempleado.setSucursal(gastoempleadoDataAccess.getSucursal(connexion,gastoempleado));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				gastoempleado.setEmpleado(gastoempleadoDataAccess.getEmpleado(connexion,gastoempleado));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				gastoempleado.setEjercicio(gastoempleadoDataAccess.getEjercicio(connexion,gastoempleado));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				gastoempleado.setPais(gastoempleadoDataAccess.getPais(connexion,gastoempleado));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				gastoempleado.setCiudad(gastoempleadoDataAccess.getCiudad(connexion,gastoempleado));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				gastoempleado.setAnio(gastoempleadoDataAccess.getAnio(connexion,gastoempleado));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				gastoempleado.setMes(gastoempleadoDataAccess.getMes(connexion,gastoempleado));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				gastoempleado.setUsuario(gastoempleadoDataAccess.getUsuario(connexion,gastoempleado));
				continue;
			}

			if(clas.clas.equals(EstadoGastoEmpleado.class)) {
				gastoempleado.setEstadoGastoEmpleado(gastoempleadoDataAccess.getEstadoGastoEmpleado(connexion,gastoempleado));
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
			gastoempleado.setEmpresa(gastoempleadoDataAccess.getEmpresa(connexion,gastoempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setSucursal(gastoempleadoDataAccess.getSucursal(connexion,gastoempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setEmpleado(gastoempleadoDataAccess.getEmpleado(connexion,gastoempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setEjercicio(gastoempleadoDataAccess.getEjercicio(connexion,gastoempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setPais(gastoempleadoDataAccess.getPais(connexion,gastoempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setCiudad(gastoempleadoDataAccess.getCiudad(connexion,gastoempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setAnio(gastoempleadoDataAccess.getAnio(connexion,gastoempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setMes(gastoempleadoDataAccess.getMes(connexion,gastoempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setUsuario(gastoempleadoDataAccess.getUsuario(connexion,gastoempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoGastoEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setEstadoGastoEmpleado(gastoempleadoDataAccess.getEstadoGastoEmpleado(connexion,gastoempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		gastoempleado.setEmpresa(gastoempleadoDataAccess.getEmpresa(connexion,gastoempleado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(gastoempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		gastoempleado.setSucursal(gastoempleadoDataAccess.getSucursal(connexion,gastoempleado));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(gastoempleado.getSucursal(),isDeep,deepLoadType,clases);
				
		gastoempleado.setEmpleado(gastoempleadoDataAccess.getEmpleado(connexion,gastoempleado));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(gastoempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		gastoempleado.setEjercicio(gastoempleadoDataAccess.getEjercicio(connexion,gastoempleado));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(gastoempleado.getEjercicio(),isDeep,deepLoadType,clases);
				
		gastoempleado.setPais(gastoempleadoDataAccess.getPais(connexion,gastoempleado));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(gastoempleado.getPais(),isDeep,deepLoadType,clases);
				
		gastoempleado.setCiudad(gastoempleadoDataAccess.getCiudad(connexion,gastoempleado));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(gastoempleado.getCiudad(),isDeep,deepLoadType,clases);
				
		gastoempleado.setAnio(gastoempleadoDataAccess.getAnio(connexion,gastoempleado));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(gastoempleado.getAnio(),isDeep,deepLoadType,clases);
				
		gastoempleado.setMes(gastoempleadoDataAccess.getMes(connexion,gastoempleado));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(gastoempleado.getMes(),isDeep,deepLoadType,clases);
				
		gastoempleado.setUsuario(gastoempleadoDataAccess.getUsuario(connexion,gastoempleado));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(gastoempleado.getUsuario(),isDeep,deepLoadType,clases);
				
		gastoempleado.setEstadoGastoEmpleado(gastoempleadoDataAccess.getEstadoGastoEmpleado(connexion,gastoempleado));
		EstadoGastoEmpleadoLogic estadogastoempleadoLogic= new EstadoGastoEmpleadoLogic(connexion);
		estadogastoempleadoLogic.deepLoad(gastoempleado.getEstadoGastoEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				gastoempleado.setEmpresa(gastoempleadoDataAccess.getEmpresa(connexion,gastoempleado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(gastoempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				gastoempleado.setSucursal(gastoempleadoDataAccess.getSucursal(connexion,gastoempleado));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(gastoempleado.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				gastoempleado.setEmpleado(gastoempleadoDataAccess.getEmpleado(connexion,gastoempleado));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(gastoempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				gastoempleado.setEjercicio(gastoempleadoDataAccess.getEjercicio(connexion,gastoempleado));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(gastoempleado.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				gastoempleado.setPais(gastoempleadoDataAccess.getPais(connexion,gastoempleado));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(gastoempleado.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				gastoempleado.setCiudad(gastoempleadoDataAccess.getCiudad(connexion,gastoempleado));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(gastoempleado.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				gastoempleado.setAnio(gastoempleadoDataAccess.getAnio(connexion,gastoempleado));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(gastoempleado.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				gastoempleado.setMes(gastoempleadoDataAccess.getMes(connexion,gastoempleado));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(gastoempleado.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				gastoempleado.setUsuario(gastoempleadoDataAccess.getUsuario(connexion,gastoempleado));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(gastoempleado.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoGastoEmpleado.class)) {
				gastoempleado.setEstadoGastoEmpleado(gastoempleadoDataAccess.getEstadoGastoEmpleado(connexion,gastoempleado));
				EstadoGastoEmpleadoLogic estadogastoempleadoLogic= new EstadoGastoEmpleadoLogic(connexion);
				estadogastoempleadoLogic.deepLoad(gastoempleado.getEstadoGastoEmpleado(),isDeep,deepLoadType,clases);				
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
			gastoempleado.setEmpresa(gastoempleadoDataAccess.getEmpresa(connexion,gastoempleado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(gastoempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setSucursal(gastoempleadoDataAccess.getSucursal(connexion,gastoempleado));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(gastoempleado.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setEmpleado(gastoempleadoDataAccess.getEmpleado(connexion,gastoempleado));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(gastoempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setEjercicio(gastoempleadoDataAccess.getEjercicio(connexion,gastoempleado));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(gastoempleado.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setPais(gastoempleadoDataAccess.getPais(connexion,gastoempleado));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(gastoempleado.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setCiudad(gastoempleadoDataAccess.getCiudad(connexion,gastoempleado));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(gastoempleado.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setAnio(gastoempleadoDataAccess.getAnio(connexion,gastoempleado));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(gastoempleado.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setMes(gastoempleadoDataAccess.getMes(connexion,gastoempleado));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(gastoempleado.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setUsuario(gastoempleadoDataAccess.getUsuario(connexion,gastoempleado));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(gastoempleado.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoGastoEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastoempleado.setEstadoGastoEmpleado(gastoempleadoDataAccess.getEstadoGastoEmpleado(connexion,gastoempleado));
			EstadoGastoEmpleadoLogic estadogastoempleadoLogic= new EstadoGastoEmpleadoLogic(connexion);
			estadogastoempleadoLogic.deepLoad(gastoempleado.getEstadoGastoEmpleado(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(GastoEmpleado gastoempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			GastoEmpleadoLogicAdditional.updateGastoEmpleadoToSave(gastoempleado,this.arrDatoGeneral);
			
GastoEmpleadoDataAccess.save(gastoempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(gastoempleado.getEmpresa(),connexion);

		SucursalDataAccess.save(gastoempleado.getSucursal(),connexion);

		EmpleadoDataAccess.save(gastoempleado.getEmpleado(),connexion);

		EjercicioDataAccess.save(gastoempleado.getEjercicio(),connexion);

		PaisDataAccess.save(gastoempleado.getPais(),connexion);

		CiudadDataAccess.save(gastoempleado.getCiudad(),connexion);

		AnioDataAccess.save(gastoempleado.getAnio(),connexion);

		MesDataAccess.save(gastoempleado.getMes(),connexion);

		UsuarioDataAccess.save(gastoempleado.getUsuario(),connexion);

		EstadoGastoEmpleadoDataAccess.save(gastoempleado.getEstadoGastoEmpleado(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(gastoempleado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(gastoempleado.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(gastoempleado.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(gastoempleado.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(gastoempleado.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(gastoempleado.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(gastoempleado.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(gastoempleado.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(gastoempleado.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoGastoEmpleado.class)) {
				EstadoGastoEmpleadoDataAccess.save(gastoempleado.getEstadoGastoEmpleado(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(gastoempleado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(gastoempleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(gastoempleado.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(gastoempleado.getSucursal(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(gastoempleado.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(gastoempleado.getEmpleado(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(gastoempleado.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(gastoempleado.getEjercicio(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(gastoempleado.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(gastoempleado.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(gastoempleado.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(gastoempleado.getCiudad(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(gastoempleado.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(gastoempleado.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(gastoempleado.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(gastoempleado.getMes(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(gastoempleado.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(gastoempleado.getUsuario(),isDeep,deepLoadType,clases);
				

		EstadoGastoEmpleadoDataAccess.save(gastoempleado.getEstadoGastoEmpleado(),connexion);
		EstadoGastoEmpleadoLogic estadogastoempleadoLogic= new EstadoGastoEmpleadoLogic(connexion);
		estadogastoempleadoLogic.deepLoad(gastoempleado.getEstadoGastoEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(gastoempleado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(gastoempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(gastoempleado.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(gastoempleado.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(gastoempleado.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(gastoempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(gastoempleado.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(gastoempleado.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(gastoempleado.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(gastoempleado.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(gastoempleado.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(gastoempleado.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(gastoempleado.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(gastoempleado.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(gastoempleado.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(gastoempleado.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(gastoempleado.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(gastoempleado.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoGastoEmpleado.class)) {
				EstadoGastoEmpleadoDataAccess.save(gastoempleado.getEstadoGastoEmpleado(),connexion);
				EstadoGastoEmpleadoLogic estadogastoempleadoLogic= new EstadoGastoEmpleadoLogic(connexion);
				estadogastoempleadoLogic.deepSave(gastoempleado.getEstadoGastoEmpleado(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(GastoEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(gastoempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(gastoempleado);
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
			this.deepLoad(this.gastoempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(GastoEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(gastoempleados!=null) {
				for(GastoEmpleado gastoempleado:gastoempleados) {
					this.deepLoad(gastoempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(gastoempleados);
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
			if(gastoempleados!=null) {
				for(GastoEmpleado gastoempleado:gastoempleados) {
					this.deepLoad(gastoempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(gastoempleados);
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
			this.getNewConnexionToDeep(GastoEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(gastoempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(GastoEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(gastoempleados!=null) {
				for(GastoEmpleado gastoempleado:gastoempleados) {
					this.deepSave(gastoempleado,isDeep,deepLoadType,clases);
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
			if(gastoempleados!=null) {
				for(GastoEmpleado gastoempleado:gastoempleados) {
					this.deepSave(gastoempleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getGastoEmpleadosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,GastoEmpleadoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoEmpleadosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,GastoEmpleadoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoEmpleadosFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,GastoEmpleadoConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoEmpleadosFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,GastoEmpleadoConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoEmpleadosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,GastoEmpleadoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoEmpleadosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,GastoEmpleadoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoEmpleadosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,GastoEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoEmpleadosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,GastoEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoEmpleadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GastoEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoEmpleadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GastoEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoEmpleadosFK_IdEstadoGastoEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_gasto_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoGastoEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoGastoEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_gasto_empleado,GastoEmpleadoConstantesFunciones.IDESTADOGASTOEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoGastoEmpleado);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoGastoEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoEmpleadosFK_IdEstadoGastoEmpleado(String sFinalQuery,Pagination pagination,Long id_estado_gasto_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoGastoEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoGastoEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_gasto_empleado,GastoEmpleadoConstantesFunciones.IDESTADOGASTOEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoGastoEmpleado);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoGastoEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoEmpleadosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,GastoEmpleadoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoEmpleadosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,GastoEmpleadoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoEmpleadosFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,GastoEmpleadoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoEmpleadosFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,GastoEmpleadoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoEmpleadosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,GastoEmpleadoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoEmpleadosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,GastoEmpleadoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoEmpleadosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,GastoEmpleadoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoEmpleadosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,GastoEmpleadoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			GastoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(this.gastoempleados);
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
			if(GastoEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,GastoEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,GastoEmpleado gastoempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(GastoEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(gastoempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GastoEmpleadoDataAccess.TABLENAME, gastoempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GastoEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GastoEmpleadoLogic.registrarAuditoriaDetallesGastoEmpleado(connexion,gastoempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(gastoempleado.getIsDeleted()) {
					/*if(!gastoempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,GastoEmpleadoDataAccess.TABLENAME, gastoempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////GastoEmpleadoLogic.registrarAuditoriaDetallesGastoEmpleado(connexion,gastoempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GastoEmpleadoDataAccess.TABLENAME, gastoempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(gastoempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GastoEmpleadoDataAccess.TABLENAME, gastoempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GastoEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GastoEmpleadoLogic.registrarAuditoriaDetallesGastoEmpleado(connexion,gastoempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesGastoEmpleado(Connexion connexion,GastoEmpleado gastoempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(gastoempleado.getIsNew()||!gastoempleado.getid_empresa().equals(gastoempleado.getGastoEmpleadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getid_empresa()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getid_empresa().toString();
				}
				if(gastoempleado.getid_empresa()!=null)
				{
					strValorNuevo=gastoempleado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getid_sucursal().equals(gastoempleado.getGastoEmpleadoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getid_sucursal()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getid_sucursal().toString();
				}
				if(gastoempleado.getid_sucursal()!=null)
				{
					strValorNuevo=gastoempleado.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getid_empleado().equals(gastoempleado.getGastoEmpleadoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getid_empleado()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getid_empleado().toString();
				}
				if(gastoempleado.getid_empleado()!=null)
				{
					strValorNuevo=gastoempleado.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getid_ejercicio().equals(gastoempleado.getGastoEmpleadoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getid_ejercicio().toString();
				}
				if(gastoempleado.getid_ejercicio()!=null)
				{
					strValorNuevo=gastoempleado.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getid_pais().equals(gastoempleado.getGastoEmpleadoOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getid_pais()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getid_pais().toString();
				}
				if(gastoempleado.getid_pais()!=null)
				{
					strValorNuevo=gastoempleado.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getid_ciudad().equals(gastoempleado.getGastoEmpleadoOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getid_ciudad()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getid_ciudad().toString();
				}
				if(gastoempleado.getid_ciudad()!=null)
				{
					strValorNuevo=gastoempleado.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getid_anio().equals(gastoempleado.getGastoEmpleadoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getid_anio()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getid_anio().toString();
				}
				if(gastoempleado.getid_anio()!=null)
				{
					strValorNuevo=gastoempleado.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getid_mes().equals(gastoempleado.getGastoEmpleadoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getid_mes()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getid_mes().toString();
				}
				if(gastoempleado.getid_mes()!=null)
				{
					strValorNuevo=gastoempleado.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getdia().equals(gastoempleado.getGastoEmpleadoOriginal().getdia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getdia()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getdia().toString();
				}
				if(gastoempleado.getdia()!=null)
				{
					strValorNuevo=gastoempleado.getdia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.DIA,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getid_usuario().equals(gastoempleado.getGastoEmpleadoOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getid_usuario()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getid_usuario().toString();
				}
				if(gastoempleado.getid_usuario()!=null)
				{
					strValorNuevo=gastoempleado.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getid_estado_gasto_empleado().equals(gastoempleado.getGastoEmpleadoOriginal().getid_estado_gasto_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getid_estado_gasto_empleado()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getid_estado_gasto_empleado().toString();
				}
				if(gastoempleado.getid_estado_gasto_empleado()!=null)
				{
					strValorNuevo=gastoempleado.getid_estado_gasto_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.IDESTADOGASTOEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.gettotal_ingreso_actual().equals(gastoempleado.getGastoEmpleadoOriginal().gettotal_ingreso_actual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().gettotal_ingreso_actual()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().gettotal_ingreso_actual().toString();
				}
				if(gastoempleado.gettotal_ingreso_actual()!=null)
				{
					strValorNuevo=gastoempleado.gettotal_ingreso_actual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.TOTALINGRESOACTUAL,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.gettotal_ingreso_otro().equals(gastoempleado.getGastoEmpleadoOriginal().gettotal_ingreso_otro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().gettotal_ingreso_otro()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().gettotal_ingreso_otro().toString();
				}
				if(gastoempleado.gettotal_ingreso_otro()!=null)
				{
					strValorNuevo=gastoempleado.gettotal_ingreso_otro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.TOTALINGRESOOTRO,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.gettotal_ingreso().equals(gastoempleado.getGastoEmpleadoOriginal().gettotal_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().gettotal_ingreso()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().gettotal_ingreso().toString();
				}
				if(gastoempleado.gettotal_ingreso()!=null)
				{
					strValorNuevo=gastoempleado.gettotal_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.TOTALINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getgasto_vivienda().equals(gastoempleado.getGastoEmpleadoOriginal().getgasto_vivienda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getgasto_vivienda()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getgasto_vivienda().toString();
				}
				if(gastoempleado.getgasto_vivienda()!=null)
				{
					strValorNuevo=gastoempleado.getgasto_vivienda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.GASTOVIVIENDA,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getgasto_educacion().equals(gastoempleado.getGastoEmpleadoOriginal().getgasto_educacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getgasto_educacion()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getgasto_educacion().toString();
				}
				if(gastoempleado.getgasto_educacion()!=null)
				{
					strValorNuevo=gastoempleado.getgasto_educacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.GASTOEDUCACION,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getgasto_salud().equals(gastoempleado.getGastoEmpleadoOriginal().getgasto_salud()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getgasto_salud()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getgasto_salud().toString();
				}
				if(gastoempleado.getgasto_salud()!=null)
				{
					strValorNuevo=gastoempleado.getgasto_salud().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.GASTOSALUD,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getgasto_vestimenta().equals(gastoempleado.getGastoEmpleadoOriginal().getgasto_vestimenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getgasto_vestimenta()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getgasto_vestimenta().toString();
				}
				if(gastoempleado.getgasto_vestimenta()!=null)
				{
					strValorNuevo=gastoempleado.getgasto_vestimenta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.GASTOVESTIMENTA,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getgasto_alimentacion().equals(gastoempleado.getGastoEmpleadoOriginal().getgasto_alimentacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getgasto_alimentacion()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getgasto_alimentacion().toString();
				}
				if(gastoempleado.getgasto_alimentacion()!=null)
				{
					strValorNuevo=gastoempleado.getgasto_alimentacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.GASTOALIMENTACION,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.gettotal_gasto_actual().equals(gastoempleado.getGastoEmpleadoOriginal().gettotal_gasto_actual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().gettotal_gasto_actual()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().gettotal_gasto_actual().toString();
				}
				if(gastoempleado.gettotal_gasto_actual()!=null)
				{
					strValorNuevo=gastoempleado.gettotal_gasto_actual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.TOTALGASTOACTUAL,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.gettotal_gasto().equals(gastoempleado.getGastoEmpleadoOriginal().gettotal_gasto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().gettotal_gasto()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().gettotal_gasto().toString();
				}
				if(gastoempleado.gettotal_gasto()!=null)
				{
					strValorNuevo=gastoempleado.gettotal_gasto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.TOTALGASTO,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getfecha().equals(gastoempleado.getGastoEmpleadoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getfecha()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getfecha().toString();
				}
				if(gastoempleado.getfecha()!=null)
				{
					strValorNuevo=gastoempleado.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getporcentaje().equals(gastoempleado.getGastoEmpleadoOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getporcentaje()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getporcentaje().toString();
				}
				if(gastoempleado.getporcentaje()!=null)
				{
					strValorNuevo=gastoempleado.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getvalor_maximo().equals(gastoempleado.getGastoEmpleadoOriginal().getvalor_maximo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getvalor_maximo()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getvalor_maximo().toString();
				}
				if(gastoempleado.getvalor_maximo()!=null)
				{
					strValorNuevo=gastoempleado.getvalor_maximo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.VALORMAXIMO,strValorActual,strValorNuevo);
			}	
			
			if(gastoempleado.getIsNew()||!gastoempleado.getvalor_maximo_porcentaje().equals(gastoempleado.getGastoEmpleadoOriginal().getvalor_maximo_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastoempleado.getGastoEmpleadoOriginal().getvalor_maximo_porcentaje()!=null)
				{
					strValorActual=gastoempleado.getGastoEmpleadoOriginal().getvalor_maximo_porcentaje().toString();
				}
				if(gastoempleado.getvalor_maximo_porcentaje()!=null)
				{
					strValorNuevo=gastoempleado.getvalor_maximo_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoEmpleadoConstantesFunciones.VALORMAXIMOPORCENTAJE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveGastoEmpleadoRelacionesWithConnection(GastoEmpleado gastoempleado) throws Exception {

		if(!gastoempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGastoEmpleadoRelacionesBase(gastoempleado,true);
		}
	}

	public void saveGastoEmpleadoRelaciones(GastoEmpleado gastoempleado)throws Exception {

		if(!gastoempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGastoEmpleadoRelacionesBase(gastoempleado,false);
		}
	}

	public void saveGastoEmpleadoRelacionesBase(GastoEmpleado gastoempleado,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("GastoEmpleado-saveRelacionesWithConnection");}
	

			this.setGastoEmpleado(gastoempleado);

			if(GastoEmpleadoLogicAdditional.validarSaveRelaciones(gastoempleado,this)) {

				GastoEmpleadoLogicAdditional.updateRelacionesToSave(gastoempleado,this);

				if((gastoempleado.getIsNew()||gastoempleado.getIsChanged())&&!gastoempleado.getIsDeleted()) {
					this.saveGastoEmpleado();
					this.saveGastoEmpleadoRelacionesDetalles();

				} else if(gastoempleado.getIsDeleted()) {
					this.saveGastoEmpleadoRelacionesDetalles();
					this.saveGastoEmpleado();
				}

				GastoEmpleadoLogicAdditional.updateRelacionesToSaveAfter(gastoempleado,this);

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
	
	
	private void saveGastoEmpleadoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfGastoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GastoEmpleadoConstantesFunciones.getClassesForeignKeysOfGastoEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGastoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GastoEmpleadoConstantesFunciones.getClassesRelationshipsOfGastoEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

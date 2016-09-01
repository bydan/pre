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
import com.bydan.erp.nomina.util.EvaluacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.EvaluacionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EvaluacionEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.EvaluacionEmpleado;
import com.bydan.erp.nomina.business.logic.EvaluacionEmpleadoLogicAdditional;
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
public class EvaluacionEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EvaluacionEmpleadoLogic.class);
	
	protected EvaluacionEmpleadoDataAccess evaluacionempleadoDataAccess; 	
	protected EvaluacionEmpleado evaluacionempleado;
	protected List<EvaluacionEmpleado> evaluacionempleados;
	protected Object evaluacionempleadoObject;	
	protected List<Object> evaluacionempleadosObject;
	
	public static ClassValidator<EvaluacionEmpleado> evaluacionempleadoValidator = new ClassValidator<EvaluacionEmpleado>(EvaluacionEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EvaluacionEmpleadoLogicAdditional evaluacionempleadoLogicAdditional=null;
	
	public EvaluacionEmpleadoLogicAdditional getEvaluacionEmpleadoLogicAdditional() {
		return this.evaluacionempleadoLogicAdditional;
	}
	
	public void setEvaluacionEmpleadoLogicAdditional(EvaluacionEmpleadoLogicAdditional evaluacionempleadoLogicAdditional) {
		try {
			this.evaluacionempleadoLogicAdditional=evaluacionempleadoLogicAdditional;
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
	
	
	
	
	public  EvaluacionEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.evaluacionempleadoDataAccess = new EvaluacionEmpleadoDataAccess();
			
			this.evaluacionempleados= new ArrayList<EvaluacionEmpleado>();
			this.evaluacionempleado= new EvaluacionEmpleado();
			
			this.evaluacionempleadoObject=new Object();
			this.evaluacionempleadosObject=new ArrayList<Object>();
				
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
			
			this.evaluacionempleadoDataAccess.setConnexionType(this.connexionType);
			this.evaluacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EvaluacionEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.evaluacionempleadoDataAccess = new EvaluacionEmpleadoDataAccess();
			this.evaluacionempleados= new ArrayList<EvaluacionEmpleado>();
			this.evaluacionempleado= new EvaluacionEmpleado();
			this.evaluacionempleadoObject=new Object();
			this.evaluacionempleadosObject=new ArrayList<Object>();
			
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
			
			this.evaluacionempleadoDataAccess.setConnexionType(this.connexionType);
			this.evaluacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EvaluacionEmpleado getEvaluacionEmpleado() throws Exception {	
		EvaluacionEmpleadoLogicAdditional.checkEvaluacionEmpleadoToGet(evaluacionempleado,this.datosCliente,this.arrDatoGeneral);
		EvaluacionEmpleadoLogicAdditional.updateEvaluacionEmpleadoToGet(evaluacionempleado,this.arrDatoGeneral);
		
		return evaluacionempleado;
	}
		
	public void setEvaluacionEmpleado(EvaluacionEmpleado newEvaluacionEmpleado) {
		this.evaluacionempleado = newEvaluacionEmpleado;
	}
	
	public EvaluacionEmpleadoDataAccess getEvaluacionEmpleadoDataAccess() {
		return evaluacionempleadoDataAccess;
	}
	
	public void setEvaluacionEmpleadoDataAccess(EvaluacionEmpleadoDataAccess newevaluacionempleadoDataAccess) {
		this.evaluacionempleadoDataAccess = newevaluacionempleadoDataAccess;
	}
	
	public List<EvaluacionEmpleado> getEvaluacionEmpleados() throws Exception {		
		this.quitarEvaluacionEmpleadosNulos();
		
		EvaluacionEmpleadoLogicAdditional.checkEvaluacionEmpleadoToGets(evaluacionempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (EvaluacionEmpleado evaluacionempleadoLocal: evaluacionempleados ) {
			EvaluacionEmpleadoLogicAdditional.updateEvaluacionEmpleadoToGet(evaluacionempleadoLocal,this.arrDatoGeneral);
		}
		
		return evaluacionempleados;
	}
	
	public void setEvaluacionEmpleados(List<EvaluacionEmpleado> newEvaluacionEmpleados) {
		this.evaluacionempleados = newEvaluacionEmpleados;
	}
	
	public Object getEvaluacionEmpleadoObject() {	
		this.evaluacionempleadoObject=this.evaluacionempleadoDataAccess.getEntityObject();
		return this.evaluacionempleadoObject;
	}
		
	public void setEvaluacionEmpleadoObject(Object newEvaluacionEmpleadoObject) {
		this.evaluacionempleadoObject = newEvaluacionEmpleadoObject;
	}
	
	public List<Object> getEvaluacionEmpleadosObject() {		
		this.evaluacionempleadosObject=this.evaluacionempleadoDataAccess.getEntitiesObject();
		return this.evaluacionempleadosObject;
	}
		
	public void setEvaluacionEmpleadosObject(List<Object> newEvaluacionEmpleadosObject) {
		this.evaluacionempleadosObject = newEvaluacionEmpleadosObject;
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
		
		if(this.evaluacionempleadoDataAccess!=null) {
			this.evaluacionempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			evaluacionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			evaluacionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		evaluacionempleado = new  EvaluacionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			evaluacionempleado=evaluacionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.evaluacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleado);
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
		evaluacionempleado = new  EvaluacionEmpleado();
		  		  
        try {
			
			evaluacionempleado=evaluacionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.evaluacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		evaluacionempleado = new  EvaluacionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			evaluacionempleado=evaluacionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.evaluacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleado);
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
		evaluacionempleado = new  EvaluacionEmpleado();
		  		  
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
		evaluacionempleado = new  EvaluacionEmpleado();
		  		  
        try {
			
			evaluacionempleado=evaluacionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.evaluacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		evaluacionempleado = new  EvaluacionEmpleado();
		  		  
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
		evaluacionempleado = new  EvaluacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =evaluacionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		evaluacionempleado = new  EvaluacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=evaluacionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		evaluacionempleado = new  EvaluacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =evaluacionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		evaluacionempleado = new  EvaluacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=evaluacionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		evaluacionempleado = new  EvaluacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =evaluacionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		evaluacionempleado = new  EvaluacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=evaluacionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		evaluacionempleados = new  ArrayList<EvaluacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionEmpleado(evaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
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
		evaluacionempleados = new  ArrayList<EvaluacionEmpleado>();
		  		  
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
		evaluacionempleados = new  ArrayList<EvaluacionEmpleado>();
		  		  
        try {			
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEvaluacionEmpleado(evaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		evaluacionempleados = new  ArrayList<EvaluacionEmpleado>();
		  		  
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
		evaluacionempleados = new  ArrayList<EvaluacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionEmpleado(evaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
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
		evaluacionempleados = new  ArrayList<EvaluacionEmpleado>();
		  		  
        try {
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionEmpleado(evaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
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
		evaluacionempleados = new  ArrayList<EvaluacionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEvaluacionEmpleado(evaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
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
		evaluacionempleados = new  ArrayList<EvaluacionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEvaluacionEmpleado(evaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		evaluacionempleado = new  EvaluacionEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionempleado=evaluacionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEvaluacionEmpleado(evaluacionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleado);
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
		evaluacionempleado = new  EvaluacionEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionempleado=evaluacionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEvaluacionEmpleado(evaluacionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		evaluacionempleados = new  ArrayList<EvaluacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionempleados=evaluacionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionEmpleado(evaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
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
		evaluacionempleados = new  ArrayList<EvaluacionEmpleado>();
		  		  
        try {
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionempleados=evaluacionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionEmpleado(evaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEvaluacionEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		evaluacionempleados = new  ArrayList<EvaluacionEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getTodosEvaluacionEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEvaluacionEmpleado(evaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
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
	
	public  void  getTodosEvaluacionEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		evaluacionempleados = new  ArrayList<EvaluacionEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEvaluacionEmpleado(evaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEvaluacionEmpleado(EvaluacionEmpleado evaluacionempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(evaluacionempleado.getIsNew() || evaluacionempleado.getIsChanged()) { 
			this.invalidValues = evaluacionempleadoValidator.getInvalidValues(evaluacionempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(evaluacionempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEvaluacionEmpleado(List<EvaluacionEmpleado> EvaluacionEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EvaluacionEmpleado evaluacionempleadoLocal:evaluacionempleados) {				
			estaValidadoObjeto=this.validarGuardarEvaluacionEmpleado(evaluacionempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEvaluacionEmpleado(List<EvaluacionEmpleado> EvaluacionEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEvaluacionEmpleado(evaluacionempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEvaluacionEmpleado(EvaluacionEmpleado EvaluacionEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEvaluacionEmpleado(evaluacionempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EvaluacionEmpleado evaluacionempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+evaluacionempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EvaluacionEmpleadoConstantesFunciones.getEvaluacionEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"evaluacionempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EvaluacionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EvaluacionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEvaluacionEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-saveEvaluacionEmpleadoWithConnection");connexion.begin();			
			
			EvaluacionEmpleadoLogicAdditional.checkEvaluacionEmpleadoToSave(this.evaluacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EvaluacionEmpleadoLogicAdditional.updateEvaluacionEmpleadoToSave(this.evaluacionempleado,this.arrDatoGeneral);
			
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.evaluacionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEvaluacionEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEvaluacionEmpleado(this.evaluacionempleado)) {
				EvaluacionEmpleadoDataAccess.save(this.evaluacionempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.evaluacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EvaluacionEmpleadoLogicAdditional.checkEvaluacionEmpleadoToSaveAfter(this.evaluacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEvaluacionEmpleado();
			
			connexion.commit();			
			
			if(this.evaluacionempleado.getIsDeleted()) {
				this.evaluacionempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEvaluacionEmpleado()throws Exception {	
		try {	
			
			EvaluacionEmpleadoLogicAdditional.checkEvaluacionEmpleadoToSave(this.evaluacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EvaluacionEmpleadoLogicAdditional.updateEvaluacionEmpleadoToSave(this.evaluacionempleado,this.arrDatoGeneral);
			
			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.evaluacionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEvaluacionEmpleado(this.evaluacionempleado)) {			
				EvaluacionEmpleadoDataAccess.save(this.evaluacionempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.evaluacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EvaluacionEmpleadoLogicAdditional.checkEvaluacionEmpleadoToSaveAfter(this.evaluacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.evaluacionempleado.getIsDeleted()) {
				this.evaluacionempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEvaluacionEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-saveEvaluacionEmpleadosWithConnection");connexion.begin();			
			
			EvaluacionEmpleadoLogicAdditional.checkEvaluacionEmpleadoToSaves(evaluacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEvaluacionEmpleados();
			
			Boolean validadoTodosEvaluacionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EvaluacionEmpleado evaluacionempleadoLocal:evaluacionempleados) {		
				if(evaluacionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EvaluacionEmpleadoLogicAdditional.updateEvaluacionEmpleadoToSave(evaluacionempleadoLocal,this.arrDatoGeneral);
	        	
				EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),evaluacionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEvaluacionEmpleado(evaluacionempleadoLocal)) {
					EvaluacionEmpleadoDataAccess.save(evaluacionempleadoLocal, connexion);				
				} else {
					validadoTodosEvaluacionEmpleado=false;
				}
			}
			
			if(!validadoTodosEvaluacionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EvaluacionEmpleadoLogicAdditional.checkEvaluacionEmpleadoToSavesAfter(evaluacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEvaluacionEmpleados();
			
			connexion.commit();		
			
			this.quitarEvaluacionEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEvaluacionEmpleados()throws Exception {				
		 try {	
			EvaluacionEmpleadoLogicAdditional.checkEvaluacionEmpleadoToSaves(evaluacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEvaluacionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EvaluacionEmpleado evaluacionempleadoLocal:evaluacionempleados) {				
				if(evaluacionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EvaluacionEmpleadoLogicAdditional.updateEvaluacionEmpleadoToSave(evaluacionempleadoLocal,this.arrDatoGeneral);
	        	
				EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),evaluacionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEvaluacionEmpleado(evaluacionempleadoLocal)) {				
					EvaluacionEmpleadoDataAccess.save(evaluacionempleadoLocal, connexion);				
				} else {
					validadoTodosEvaluacionEmpleado=false;
				}
			}
			
			if(!validadoTodosEvaluacionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EvaluacionEmpleadoLogicAdditional.checkEvaluacionEmpleadoToSavesAfter(evaluacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEvaluacionEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EvaluacionEmpleadoParameterReturnGeneral procesarAccionEvaluacionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EvaluacionEmpleado> evaluacionempleados,EvaluacionEmpleadoParameterReturnGeneral evaluacionempleadoParameterGeneral)throws Exception {
		 try {	
			EvaluacionEmpleadoParameterReturnGeneral evaluacionempleadoReturnGeneral=new EvaluacionEmpleadoParameterReturnGeneral();
	
			EvaluacionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,evaluacionempleados,evaluacionempleadoParameterGeneral,evaluacionempleadoReturnGeneral);
			
			return evaluacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EvaluacionEmpleadoParameterReturnGeneral procesarAccionEvaluacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EvaluacionEmpleado> evaluacionempleados,EvaluacionEmpleadoParameterReturnGeneral evaluacionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-procesarAccionEvaluacionEmpleadosWithConnection");connexion.begin();			
			
			EvaluacionEmpleadoParameterReturnGeneral evaluacionempleadoReturnGeneral=new EvaluacionEmpleadoParameterReturnGeneral();
	
			EvaluacionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,evaluacionempleados,evaluacionempleadoParameterGeneral,evaluacionempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return evaluacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EvaluacionEmpleadoParameterReturnGeneral procesarEventosEvaluacionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EvaluacionEmpleado> evaluacionempleados,EvaluacionEmpleado evaluacionempleado,EvaluacionEmpleadoParameterReturnGeneral evaluacionempleadoParameterGeneral,Boolean isEsNuevoEvaluacionEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			EvaluacionEmpleadoParameterReturnGeneral evaluacionempleadoReturnGeneral=new EvaluacionEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				evaluacionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EvaluacionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,evaluacionempleados,evaluacionempleado,evaluacionempleadoParameterGeneral,evaluacionempleadoReturnGeneral,isEsNuevoEvaluacionEmpleado,clases);
			
			return evaluacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EvaluacionEmpleadoParameterReturnGeneral procesarEventosEvaluacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EvaluacionEmpleado> evaluacionempleados,EvaluacionEmpleado evaluacionempleado,EvaluacionEmpleadoParameterReturnGeneral evaluacionempleadoParameterGeneral,Boolean isEsNuevoEvaluacionEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-procesarEventosEvaluacionEmpleadosWithConnection");connexion.begin();			
			
			EvaluacionEmpleadoParameterReturnGeneral evaluacionempleadoReturnGeneral=new EvaluacionEmpleadoParameterReturnGeneral();
	
			evaluacionempleadoReturnGeneral.setEvaluacionEmpleado(evaluacionempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				evaluacionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EvaluacionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,evaluacionempleados,evaluacionempleado,evaluacionempleadoParameterGeneral,evaluacionempleadoReturnGeneral,isEsNuevoEvaluacionEmpleado,clases);
			
			this.connexion.commit();
			
			return evaluacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EvaluacionEmpleadoParameterReturnGeneral procesarImportacionEvaluacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EvaluacionEmpleadoParameterReturnGeneral evaluacionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-procesarImportacionEvaluacionEmpleadosWithConnection");connexion.begin();			
			
			EvaluacionEmpleadoParameterReturnGeneral evaluacionempleadoReturnGeneral=new EvaluacionEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.evaluacionempleados=new ArrayList<EvaluacionEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.evaluacionempleado=new EvaluacionEmpleado();
				
				
				if(conColumnasBase) {this.evaluacionempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.evaluacionempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.evaluacionempleado.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.evaluacionempleado.setesta_evaluado(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.evaluacionempleado.setobservacion1(arrColumnas[iColumn++]);
			this.evaluacionempleado.setobservacion2(arrColumnas[iColumn++]);
			this.evaluacionempleado.setobservacion3(arrColumnas[iColumn++]);
			this.evaluacionempleado.setobservacion4(arrColumnas[iColumn++]);
				
				this.evaluacionempleados.add(this.evaluacionempleado);
			}
			
			this.saveEvaluacionEmpleados();
			
			this.connexion.commit();
			
			evaluacionempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			evaluacionempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return evaluacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEvaluacionEmpleadosEliminados() throws Exception {				
		
		List<EvaluacionEmpleado> evaluacionempleadosAux= new ArrayList<EvaluacionEmpleado>();
		
		for(EvaluacionEmpleado evaluacionempleado:evaluacionempleados) {
			if(!evaluacionempleado.getIsDeleted()) {
				evaluacionempleadosAux.add(evaluacionempleado);
			}
		}
		
		evaluacionempleados=evaluacionempleadosAux;
	}
	
	public void quitarEvaluacionEmpleadosNulos() throws Exception {				
		
		List<EvaluacionEmpleado> evaluacionempleadosAux= new ArrayList<EvaluacionEmpleado>();
		
		for(EvaluacionEmpleado evaluacionempleado : this.evaluacionempleados) {
			if(evaluacionempleado==null) {
				evaluacionempleadosAux.add(evaluacionempleado);
			}
		}
		
		//this.evaluacionempleados=evaluacionempleadosAux;
		
		this.evaluacionempleados.removeAll(evaluacionempleadosAux);
	}
	
	public void getSetVersionRowEvaluacionEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(evaluacionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((evaluacionempleado.getIsDeleted() || (evaluacionempleado.getIsChanged()&&!evaluacionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=evaluacionempleadoDataAccess.getSetVersionRowEvaluacionEmpleado(connexion,evaluacionempleado.getId());
				
				if(!evaluacionempleado.getVersionRow().equals(timestamp)) {	
					evaluacionempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				evaluacionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEvaluacionEmpleado()throws Exception {	
		
		if(evaluacionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((evaluacionempleado.getIsDeleted() || (evaluacionempleado.getIsChanged()&&!evaluacionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=evaluacionempleadoDataAccess.getSetVersionRowEvaluacionEmpleado(connexion,evaluacionempleado.getId());
			
			try {							
				if(!evaluacionempleado.getVersionRow().equals(timestamp)) {	
					evaluacionempleado.setVersionRow(timestamp);
				}
				
				evaluacionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEvaluacionEmpleadosWithConnection()throws Exception {	
		if(evaluacionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EvaluacionEmpleado evaluacionempleadoAux:evaluacionempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(evaluacionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(evaluacionempleadoAux.getIsDeleted() || (evaluacionempleadoAux.getIsChanged()&&!evaluacionempleadoAux.getIsNew())) {
						
						timestamp=evaluacionempleadoDataAccess.getSetVersionRowEvaluacionEmpleado(connexion,evaluacionempleadoAux.getId());
						
						if(!evaluacionempleado.getVersionRow().equals(timestamp)) {	
							evaluacionempleadoAux.setVersionRow(timestamp);
						}
								
						evaluacionempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEvaluacionEmpleados()throws Exception {	
		if(evaluacionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EvaluacionEmpleado evaluacionempleadoAux:evaluacionempleados) {
					if(evaluacionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(evaluacionempleadoAux.getIsDeleted() || (evaluacionempleadoAux.getIsChanged()&&!evaluacionempleadoAux.getIsNew())) {
						
						timestamp=evaluacionempleadoDataAccess.getSetVersionRowEvaluacionEmpleado(connexion,evaluacionempleadoAux.getId());
						
						if(!evaluacionempleadoAux.getVersionRow().equals(timestamp)) {	
							evaluacionempleadoAux.setVersionRow(timestamp);
						}
						
													
						evaluacionempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EvaluacionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyEvaluacionEmpleadoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalEstructura,String finalQueryGlobalEmpleado,String finalQueryGlobalEmpleadoEvalua,String finalQueryGlobalTipoEvaluacionEmpleado,String finalQueryGlobalAnio,String finalQueryGlobalSemestre,String finalQueryGlobalTrimestre,String finalQueryGlobalBimestre,String finalQueryGlobalMes) throws Exception {
		EvaluacionEmpleadoParameterReturnGeneral  evaluacionempleadoReturnGeneral =new EvaluacionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-cargarCombosLoteForeignKeyEvaluacionEmpleadoWithConnection");connexion.begin();
			
			evaluacionempleadoReturnGeneral =new EvaluacionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			evaluacionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			evaluacionempleadoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			evaluacionempleadoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			evaluacionempleadoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			evaluacionempleadoReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			evaluacionempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Empleado> empleadoevaluasForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoevaluaLogic=new EmpleadoLogic();
			empleadoevaluaLogic.setConnexion(this.connexion);
			empleadoevaluaLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoEvalua.equals("NONE")) {
				empleadoevaluaLogic.getTodosEmpleados(finalQueryGlobalEmpleadoEvalua,new Pagination());
				empleadoevaluasForeignKey=empleadoevaluaLogic.getEmpleados();
			}

			evaluacionempleadoReturnGeneral.setempleadoevaluasForeignKey(empleadoevaluasForeignKey);


			List<TipoEvaluacionEmpleado> tipoevaluacionempleadosForeignKey=new ArrayList<TipoEvaluacionEmpleado>();
			TipoEvaluacionEmpleadoLogic tipoevaluacionempleadoLogic=new TipoEvaluacionEmpleadoLogic();
			tipoevaluacionempleadoLogic.setConnexion(this.connexion);
			tipoevaluacionempleadoLogic.getTipoEvaluacionEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoEvaluacionEmpleado.equals("NONE")) {
				tipoevaluacionempleadoLogic.getTodosTipoEvaluacionEmpleados(finalQueryGlobalTipoEvaluacionEmpleado,new Pagination());
				tipoevaluacionempleadosForeignKey=tipoevaluacionempleadoLogic.getTipoEvaluacionEmpleados();
			}

			evaluacionempleadoReturnGeneral.settipoevaluacionempleadosForeignKey(tipoevaluacionempleadosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			evaluacionempleadoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Semestre> semestresForeignKey=new ArrayList<Semestre>();
			SemestreLogic semestreLogic=new SemestreLogic();
			semestreLogic.setConnexion(this.connexion);
			semestreLogic.getSemestreDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSemestre.equals("NONE")) {
				semestreLogic.getTodosSemestres(finalQueryGlobalSemestre,new Pagination());
				semestresForeignKey=semestreLogic.getSemestres();
			}

			evaluacionempleadoReturnGeneral.setsemestresForeignKey(semestresForeignKey);


			List<Trimestre> trimestresForeignKey=new ArrayList<Trimestre>();
			TrimestreLogic trimestreLogic=new TrimestreLogic();
			trimestreLogic.setConnexion(this.connexion);
			trimestreLogic.getTrimestreDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTrimestre.equals("NONE")) {
				trimestreLogic.getTodosTrimestres(finalQueryGlobalTrimestre,new Pagination());
				trimestresForeignKey=trimestreLogic.getTrimestres();
			}

			evaluacionempleadoReturnGeneral.settrimestresForeignKey(trimestresForeignKey);


			List<Bimestre> bimestresForeignKey=new ArrayList<Bimestre>();
			BimestreLogic bimestreLogic=new BimestreLogic();
			bimestreLogic.setConnexion(this.connexion);
			bimestreLogic.getBimestreDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBimestre.equals("NONE")) {
				bimestreLogic.getTodosBimestres(finalQueryGlobalBimestre,new Pagination());
				bimestresForeignKey=bimestreLogic.getBimestres();
			}

			evaluacionempleadoReturnGeneral.setbimestresForeignKey(bimestresForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			evaluacionempleadoReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return evaluacionempleadoReturnGeneral;
	}
	
	public EvaluacionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyEvaluacionEmpleado(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalEstructura,String finalQueryGlobalEmpleado,String finalQueryGlobalEmpleadoEvalua,String finalQueryGlobalTipoEvaluacionEmpleado,String finalQueryGlobalAnio,String finalQueryGlobalSemestre,String finalQueryGlobalTrimestre,String finalQueryGlobalBimestre,String finalQueryGlobalMes) throws Exception {
		EvaluacionEmpleadoParameterReturnGeneral  evaluacionempleadoReturnGeneral =new EvaluacionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			evaluacionempleadoReturnGeneral =new EvaluacionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			evaluacionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			evaluacionempleadoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			evaluacionempleadoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			evaluacionempleadoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			evaluacionempleadoReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			evaluacionempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Empleado> empleadoevaluasForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoevaluaLogic=new EmpleadoLogic();
			empleadoevaluaLogic.setConnexion(this.connexion);
			empleadoevaluaLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoEvalua.equals("NONE")) {
				empleadoevaluaLogic.getTodosEmpleados(finalQueryGlobalEmpleadoEvalua,new Pagination());
				empleadoevaluasForeignKey=empleadoevaluaLogic.getEmpleados();
			}

			evaluacionempleadoReturnGeneral.setempleadoevaluasForeignKey(empleadoevaluasForeignKey);


			List<TipoEvaluacionEmpleado> tipoevaluacionempleadosForeignKey=new ArrayList<TipoEvaluacionEmpleado>();
			TipoEvaluacionEmpleadoLogic tipoevaluacionempleadoLogic=new TipoEvaluacionEmpleadoLogic();
			tipoevaluacionempleadoLogic.setConnexion(this.connexion);
			tipoevaluacionempleadoLogic.getTipoEvaluacionEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoEvaluacionEmpleado.equals("NONE")) {
				tipoevaluacionempleadoLogic.getTodosTipoEvaluacionEmpleados(finalQueryGlobalTipoEvaluacionEmpleado,new Pagination());
				tipoevaluacionempleadosForeignKey=tipoevaluacionempleadoLogic.getTipoEvaluacionEmpleados();
			}

			evaluacionempleadoReturnGeneral.settipoevaluacionempleadosForeignKey(tipoevaluacionempleadosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			evaluacionempleadoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Semestre> semestresForeignKey=new ArrayList<Semestre>();
			SemestreLogic semestreLogic=new SemestreLogic();
			semestreLogic.setConnexion(this.connexion);
			semestreLogic.getSemestreDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSemestre.equals("NONE")) {
				semestreLogic.getTodosSemestres(finalQueryGlobalSemestre,new Pagination());
				semestresForeignKey=semestreLogic.getSemestres();
			}

			evaluacionempleadoReturnGeneral.setsemestresForeignKey(semestresForeignKey);


			List<Trimestre> trimestresForeignKey=new ArrayList<Trimestre>();
			TrimestreLogic trimestreLogic=new TrimestreLogic();
			trimestreLogic.setConnexion(this.connexion);
			trimestreLogic.getTrimestreDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTrimestre.equals("NONE")) {
				trimestreLogic.getTodosTrimestres(finalQueryGlobalTrimestre,new Pagination());
				trimestresForeignKey=trimestreLogic.getTrimestres();
			}

			evaluacionempleadoReturnGeneral.settrimestresForeignKey(trimestresForeignKey);


			List<Bimestre> bimestresForeignKey=new ArrayList<Bimestre>();
			BimestreLogic bimestreLogic=new BimestreLogic();
			bimestreLogic.setConnexion(this.connexion);
			bimestreLogic.getBimestreDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBimestre.equals("NONE")) {
				bimestreLogic.getTodosBimestres(finalQueryGlobalBimestre,new Pagination());
				bimestresForeignKey=bimestreLogic.getBimestres();
			}

			evaluacionempleadoReturnGeneral.setbimestresForeignKey(bimestresForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			evaluacionempleadoReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return evaluacionempleadoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEvaluacionEmpleadoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CalificacionEmpleadoLogic calificacionempleadoLogic=new CalificacionEmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEvaluacionEmpleadoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CalificacionEmpleado.class));
											
			

			calificacionempleadoLogic.setConnexion(this.getConnexion());
			calificacionempleadoLogic.setDatosCliente(this.datosCliente);
			calificacionempleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EvaluacionEmpleado evaluacionempleado:this.evaluacionempleados) {
				

				classes=new ArrayList<Classe>();
				classes=CalificacionEmpleadoConstantesFunciones.getClassesForeignKeysOfCalificacionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				calificacionempleadoLogic.setCalificacionEmpleados(evaluacionempleado.calificacionempleados);
				calificacionempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EvaluacionEmpleado evaluacionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EvaluacionEmpleadoLogicAdditional.updateEvaluacionEmpleadoToGet(evaluacionempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		evaluacionempleado.setEmpresa(evaluacionempleadoDataAccess.getEmpresa(connexion,evaluacionempleado));
		evaluacionempleado.setSucursal(evaluacionempleadoDataAccess.getSucursal(connexion,evaluacionempleado));
		evaluacionempleado.setEjercicio(evaluacionempleadoDataAccess.getEjercicio(connexion,evaluacionempleado));
		evaluacionempleado.setPeriodo(evaluacionempleadoDataAccess.getPeriodo(connexion,evaluacionempleado));
		evaluacionempleado.setEstructura(evaluacionempleadoDataAccess.getEstructura(connexion,evaluacionempleado));
		evaluacionempleado.setEmpleado(evaluacionempleadoDataAccess.getEmpleado(connexion,evaluacionempleado));
		evaluacionempleado.setEmpleadoEvalua(evaluacionempleadoDataAccess.getEmpleadoEvalua(connexion,evaluacionempleado));
		evaluacionempleado.setTipoEvaluacionEmpleado(evaluacionempleadoDataAccess.getTipoEvaluacionEmpleado(connexion,evaluacionempleado));
		evaluacionempleado.setAnio(evaluacionempleadoDataAccess.getAnio(connexion,evaluacionempleado));
		evaluacionempleado.setSemestre(evaluacionempleadoDataAccess.getSemestre(connexion,evaluacionempleado));
		evaluacionempleado.setTrimestre(evaluacionempleadoDataAccess.getTrimestre(connexion,evaluacionempleado));
		evaluacionempleado.setBimestre(evaluacionempleadoDataAccess.getBimestre(connexion,evaluacionempleado));
		evaluacionempleado.setMes(evaluacionempleadoDataAccess.getMes(connexion,evaluacionempleado));
		evaluacionempleado.setCalificacionEmpleados(evaluacionempleadoDataAccess.getCalificacionEmpleados(connexion,evaluacionempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				evaluacionempleado.setEmpresa(evaluacionempleadoDataAccess.getEmpresa(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				evaluacionempleado.setSucursal(evaluacionempleadoDataAccess.getSucursal(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				evaluacionempleado.setEjercicio(evaluacionempleadoDataAccess.getEjercicio(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				evaluacionempleado.setPeriodo(evaluacionempleadoDataAccess.getPeriodo(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				evaluacionempleado.setEstructura(evaluacionempleadoDataAccess.getEstructura(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				evaluacionempleado.setEmpleado(evaluacionempleadoDataAccess.getEmpleado(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				evaluacionempleado.setEmpleadoEvalua(evaluacionempleadoDataAccess.getEmpleadoEvalua(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(TipoEvaluacionEmpleado.class)) {
				evaluacionempleado.setTipoEvaluacionEmpleado(evaluacionempleadoDataAccess.getTipoEvaluacionEmpleado(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				evaluacionempleado.setAnio(evaluacionempleadoDataAccess.getAnio(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(Semestre.class)) {
				evaluacionempleado.setSemestre(evaluacionempleadoDataAccess.getSemestre(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(Trimestre.class)) {
				evaluacionempleado.setTrimestre(evaluacionempleadoDataAccess.getTrimestre(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(Bimestre.class)) {
				evaluacionempleado.setBimestre(evaluacionempleadoDataAccess.getBimestre(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				evaluacionempleado.setMes(evaluacionempleadoDataAccess.getMes(connexion,evaluacionempleado));
				continue;
			}

			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				evaluacionempleado.setCalificacionEmpleados(evaluacionempleadoDataAccess.getCalificacionEmpleados(connexion,evaluacionempleado));

				if(this.isConDeep) {
					CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(this.connexion);
					calificacionempleadoLogic.setCalificacionEmpleados(evaluacionempleado.getCalificacionEmpleados());
					ArrayList<Classe> classesLocal=CalificacionEmpleadoConstantesFunciones.getClassesForeignKeysOfCalificacionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					calificacionempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(calificacionempleadoLogic.getCalificacionEmpleados());
					evaluacionempleado.setCalificacionEmpleados(calificacionempleadoLogic.getCalificacionEmpleados());
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
			evaluacionempleado.setEmpresa(evaluacionempleadoDataAccess.getEmpresa(connexion,evaluacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setSucursal(evaluacionempleadoDataAccess.getSucursal(connexion,evaluacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setEjercicio(evaluacionempleadoDataAccess.getEjercicio(connexion,evaluacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setPeriodo(evaluacionempleadoDataAccess.getPeriodo(connexion,evaluacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setEstructura(evaluacionempleadoDataAccess.getEstructura(connexion,evaluacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setEmpleado(evaluacionempleadoDataAccess.getEmpleado(connexion,evaluacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setEmpleadoEvalua(evaluacionempleadoDataAccess.getEmpleadoEvalua(connexion,evaluacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEvaluacionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setTipoEvaluacionEmpleado(evaluacionempleadoDataAccess.getTipoEvaluacionEmpleado(connexion,evaluacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setAnio(evaluacionempleadoDataAccess.getAnio(connexion,evaluacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Semestre.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setSemestre(evaluacionempleadoDataAccess.getSemestre(connexion,evaluacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Trimestre.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setTrimestre(evaluacionempleadoDataAccess.getTrimestre(connexion,evaluacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bimestre.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setBimestre(evaluacionempleadoDataAccess.getBimestre(connexion,evaluacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setMes(evaluacionempleadoDataAccess.getMes(connexion,evaluacionempleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CalificacionEmpleado.class));
			evaluacionempleado.setCalificacionEmpleados(evaluacionempleadoDataAccess.getCalificacionEmpleados(connexion,evaluacionempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		evaluacionempleado.setEmpresa(evaluacionempleadoDataAccess.getEmpresa(connexion,evaluacionempleado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(evaluacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		evaluacionempleado.setSucursal(evaluacionempleadoDataAccess.getSucursal(connexion,evaluacionempleado));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(evaluacionempleado.getSucursal(),isDeep,deepLoadType,clases);
				
		evaluacionempleado.setEjercicio(evaluacionempleadoDataAccess.getEjercicio(connexion,evaluacionempleado));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(evaluacionempleado.getEjercicio(),isDeep,deepLoadType,clases);
				
		evaluacionempleado.setPeriodo(evaluacionempleadoDataAccess.getPeriodo(connexion,evaluacionempleado));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(evaluacionempleado.getPeriodo(),isDeep,deepLoadType,clases);
				
		evaluacionempleado.setEstructura(evaluacionempleadoDataAccess.getEstructura(connexion,evaluacionempleado));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(evaluacionempleado.getEstructura(),isDeep,deepLoadType,clases);
				
		evaluacionempleado.setEmpleado(evaluacionempleadoDataAccess.getEmpleado(connexion,evaluacionempleado));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(evaluacionempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		evaluacionempleado.setEmpleadoEvalua(evaluacionempleadoDataAccess.getEmpleadoEvalua(connexion,evaluacionempleado));
		EmpleadoLogic empleadoevaluaLogic= new EmpleadoLogic(connexion);
		empleadoevaluaLogic.deepLoad(evaluacionempleado.getEmpleadoEvalua(),isDeep,deepLoadType,clases);
				
		evaluacionempleado.setTipoEvaluacionEmpleado(evaluacionempleadoDataAccess.getTipoEvaluacionEmpleado(connexion,evaluacionempleado));
		TipoEvaluacionEmpleadoLogic tipoevaluacionempleadoLogic= new TipoEvaluacionEmpleadoLogic(connexion);
		tipoevaluacionempleadoLogic.deepLoad(evaluacionempleado.getTipoEvaluacionEmpleado(),isDeep,deepLoadType,clases);
				
		evaluacionempleado.setAnio(evaluacionempleadoDataAccess.getAnio(connexion,evaluacionempleado));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(evaluacionempleado.getAnio(),isDeep,deepLoadType,clases);
				
		evaluacionempleado.setSemestre(evaluacionempleadoDataAccess.getSemestre(connexion,evaluacionempleado));
		SemestreLogic semestreLogic= new SemestreLogic(connexion);
		semestreLogic.deepLoad(evaluacionempleado.getSemestre(),isDeep,deepLoadType,clases);
				
		evaluacionempleado.setTrimestre(evaluacionempleadoDataAccess.getTrimestre(connexion,evaluacionempleado));
		TrimestreLogic trimestreLogic= new TrimestreLogic(connexion);
		trimestreLogic.deepLoad(evaluacionempleado.getTrimestre(),isDeep,deepLoadType,clases);
				
		evaluacionempleado.setBimestre(evaluacionempleadoDataAccess.getBimestre(connexion,evaluacionempleado));
		BimestreLogic bimestreLogic= new BimestreLogic(connexion);
		bimestreLogic.deepLoad(evaluacionempleado.getBimestre(),isDeep,deepLoadType,clases);
				
		evaluacionempleado.setMes(evaluacionempleadoDataAccess.getMes(connexion,evaluacionempleado));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(evaluacionempleado.getMes(),isDeep,deepLoadType,clases);
				

		evaluacionempleado.setCalificacionEmpleados(evaluacionempleadoDataAccess.getCalificacionEmpleados(connexion,evaluacionempleado));

		for(CalificacionEmpleado calificacionempleado:evaluacionempleado.getCalificacionEmpleados()) {
			CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
			calificacionempleadoLogic.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				evaluacionempleado.setEmpresa(evaluacionempleadoDataAccess.getEmpresa(connexion,evaluacionempleado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(evaluacionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				evaluacionempleado.setSucursal(evaluacionempleadoDataAccess.getSucursal(connexion,evaluacionempleado));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(evaluacionempleado.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				evaluacionempleado.setEjercicio(evaluacionempleadoDataAccess.getEjercicio(connexion,evaluacionempleado));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(evaluacionempleado.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				evaluacionempleado.setPeriodo(evaluacionempleadoDataAccess.getPeriodo(connexion,evaluacionempleado));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(evaluacionempleado.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				evaluacionempleado.setEstructura(evaluacionempleadoDataAccess.getEstructura(connexion,evaluacionempleado));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(evaluacionempleado.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				evaluacionempleado.setEmpleado(evaluacionempleadoDataAccess.getEmpleado(connexion,evaluacionempleado));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(evaluacionempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				evaluacionempleado.setEmpleadoEvalua(evaluacionempleadoDataAccess.getEmpleadoEvalua(connexion,evaluacionempleado));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(evaluacionempleado.getEmpleadoEvalua(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoEvaluacionEmpleado.class)) {
				evaluacionempleado.setTipoEvaluacionEmpleado(evaluacionempleadoDataAccess.getTipoEvaluacionEmpleado(connexion,evaluacionempleado));
				TipoEvaluacionEmpleadoLogic tipoevaluacionempleadoLogic= new TipoEvaluacionEmpleadoLogic(connexion);
				tipoevaluacionempleadoLogic.deepLoad(evaluacionempleado.getTipoEvaluacionEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				evaluacionempleado.setAnio(evaluacionempleadoDataAccess.getAnio(connexion,evaluacionempleado));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(evaluacionempleado.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Semestre.class)) {
				evaluacionempleado.setSemestre(evaluacionempleadoDataAccess.getSemestre(connexion,evaluacionempleado));
				SemestreLogic semestreLogic= new SemestreLogic(connexion);
				semestreLogic.deepLoad(evaluacionempleado.getSemestre(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Trimestre.class)) {
				evaluacionempleado.setTrimestre(evaluacionempleadoDataAccess.getTrimestre(connexion,evaluacionempleado));
				TrimestreLogic trimestreLogic= new TrimestreLogic(connexion);
				trimestreLogic.deepLoad(evaluacionempleado.getTrimestre(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bimestre.class)) {
				evaluacionempleado.setBimestre(evaluacionempleadoDataAccess.getBimestre(connexion,evaluacionempleado));
				BimestreLogic bimestreLogic= new BimestreLogic(connexion);
				bimestreLogic.deepLoad(evaluacionempleado.getBimestre(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				evaluacionempleado.setMes(evaluacionempleadoDataAccess.getMes(connexion,evaluacionempleado));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(evaluacionempleado.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				evaluacionempleado.setCalificacionEmpleados(evaluacionempleadoDataAccess.getCalificacionEmpleados(connexion,evaluacionempleado));

				for(CalificacionEmpleado calificacionempleado:evaluacionempleado.getCalificacionEmpleados()) {
					CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
					calificacionempleadoLogic.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);
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
			evaluacionempleado.setEmpresa(evaluacionempleadoDataAccess.getEmpresa(connexion,evaluacionempleado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(evaluacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setSucursal(evaluacionempleadoDataAccess.getSucursal(connexion,evaluacionempleado));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(evaluacionempleado.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setEjercicio(evaluacionempleadoDataAccess.getEjercicio(connexion,evaluacionempleado));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(evaluacionempleado.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setPeriodo(evaluacionempleadoDataAccess.getPeriodo(connexion,evaluacionempleado));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(evaluacionempleado.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setEstructura(evaluacionempleadoDataAccess.getEstructura(connexion,evaluacionempleado));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(evaluacionempleado.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setEmpleado(evaluacionempleadoDataAccess.getEmpleado(connexion,evaluacionempleado));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(evaluacionempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setEmpleadoEvalua(evaluacionempleadoDataAccess.getEmpleadoEvalua(connexion,evaluacionempleado));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(evaluacionempleado.getEmpleadoEvalua(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEvaluacionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setTipoEvaluacionEmpleado(evaluacionempleadoDataAccess.getTipoEvaluacionEmpleado(connexion,evaluacionempleado));
			TipoEvaluacionEmpleadoLogic tipoevaluacionempleadoLogic= new TipoEvaluacionEmpleadoLogic(connexion);
			tipoevaluacionempleadoLogic.deepLoad(evaluacionempleado.getTipoEvaluacionEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setAnio(evaluacionempleadoDataAccess.getAnio(connexion,evaluacionempleado));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(evaluacionempleado.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Semestre.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setSemestre(evaluacionempleadoDataAccess.getSemestre(connexion,evaluacionempleado));
			SemestreLogic semestreLogic= new SemestreLogic(connexion);
			semestreLogic.deepLoad(evaluacionempleado.getSemestre(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Trimestre.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setTrimestre(evaluacionempleadoDataAccess.getTrimestre(connexion,evaluacionempleado));
			TrimestreLogic trimestreLogic= new TrimestreLogic(connexion);
			trimestreLogic.deepLoad(evaluacionempleado.getTrimestre(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bimestre.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setBimestre(evaluacionempleadoDataAccess.getBimestre(connexion,evaluacionempleado));
			BimestreLogic bimestreLogic= new BimestreLogic(connexion);
			bimestreLogic.deepLoad(evaluacionempleado.getBimestre(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionempleado.setMes(evaluacionempleadoDataAccess.getMes(connexion,evaluacionempleado));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(evaluacionempleado.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CalificacionEmpleado.class));
			evaluacionempleado.setCalificacionEmpleados(evaluacionempleadoDataAccess.getCalificacionEmpleados(connexion,evaluacionempleado));

			for(CalificacionEmpleado calificacionempleado:evaluacionempleado.getCalificacionEmpleados()) {
				CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
				calificacionempleadoLogic.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EvaluacionEmpleado evaluacionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EvaluacionEmpleadoLogicAdditional.updateEvaluacionEmpleadoToSave(evaluacionempleado,this.arrDatoGeneral);
			
EvaluacionEmpleadoDataAccess.save(evaluacionempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(evaluacionempleado.getEmpresa(),connexion);

		SucursalDataAccess.save(evaluacionempleado.getSucursal(),connexion);

		EjercicioDataAccess.save(evaluacionempleado.getEjercicio(),connexion);

		PeriodoDataAccess.save(evaluacionempleado.getPeriodo(),connexion);

		EstructuraDataAccess.save(evaluacionempleado.getEstructura(),connexion);

		EmpleadoDataAccess.save(evaluacionempleado.getEmpleado(),connexion);

		EmpleadoDataAccess.save(evaluacionempleado.getEmpleadoEvalua(),connexion);

		TipoEvaluacionEmpleadoDataAccess.save(evaluacionempleado.getTipoEvaluacionEmpleado(),connexion);

		AnioDataAccess.save(evaluacionempleado.getAnio(),connexion);

		SemestreDataAccess.save(evaluacionempleado.getSemestre(),connexion);

		TrimestreDataAccess.save(evaluacionempleado.getTrimestre(),connexion);

		BimestreDataAccess.save(evaluacionempleado.getBimestre(),connexion);

		MesDataAccess.save(evaluacionempleado.getMes(),connexion);

		for(CalificacionEmpleado calificacionempleado:evaluacionempleado.getCalificacionEmpleados()) {
			calificacionempleado.setid_evaluacion_empleado(evaluacionempleado.getId());
			CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(evaluacionempleado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(evaluacionempleado.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(evaluacionempleado.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(evaluacionempleado.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(evaluacionempleado.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(evaluacionempleado.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(evaluacionempleado.getEmpleadoEvalua(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoEvaluacionEmpleado.class)) {
				TipoEvaluacionEmpleadoDataAccess.save(evaluacionempleado.getTipoEvaluacionEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(evaluacionempleado.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Semestre.class)) {
				SemestreDataAccess.save(evaluacionempleado.getSemestre(),connexion);
				continue;
			}

			if(clas.clas.equals(Trimestre.class)) {
				TrimestreDataAccess.save(evaluacionempleado.getTrimestre(),connexion);
				continue;
			}

			if(clas.clas.equals(Bimestre.class)) {
				BimestreDataAccess.save(evaluacionempleado.getBimestre(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(evaluacionempleado.getMes(),connexion);
				continue;
			}


			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CalificacionEmpleado calificacionempleado:evaluacionempleado.getCalificacionEmpleados()) {
					calificacionempleado.setid_evaluacion_empleado(evaluacionempleado.getId());
					CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(evaluacionempleado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(evaluacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(evaluacionempleado.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(evaluacionempleado.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(evaluacionempleado.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(evaluacionempleado.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(evaluacionempleado.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(evaluacionempleado.getPeriodo(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(evaluacionempleado.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(evaluacionempleado.getEstructura(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(evaluacionempleado.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(evaluacionempleado.getEmpleado(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(evaluacionempleado.getEmpleadoEvalua(),connexion);
		EmpleadoLogic empleadoevaluaLogic= new EmpleadoLogic(connexion);
		empleadoevaluaLogic.deepLoad(evaluacionempleado.getEmpleadoEvalua(),isDeep,deepLoadType,clases);
				

		TipoEvaluacionEmpleadoDataAccess.save(evaluacionempleado.getTipoEvaluacionEmpleado(),connexion);
		TipoEvaluacionEmpleadoLogic tipoevaluacionempleadoLogic= new TipoEvaluacionEmpleadoLogic(connexion);
		tipoevaluacionempleadoLogic.deepLoad(evaluacionempleado.getTipoEvaluacionEmpleado(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(evaluacionempleado.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(evaluacionempleado.getAnio(),isDeep,deepLoadType,clases);
				

		SemestreDataAccess.save(evaluacionempleado.getSemestre(),connexion);
		SemestreLogic semestreLogic= new SemestreLogic(connexion);
		semestreLogic.deepLoad(evaluacionempleado.getSemestre(),isDeep,deepLoadType,clases);
				

		TrimestreDataAccess.save(evaluacionempleado.getTrimestre(),connexion);
		TrimestreLogic trimestreLogic= new TrimestreLogic(connexion);
		trimestreLogic.deepLoad(evaluacionempleado.getTrimestre(),isDeep,deepLoadType,clases);
				

		BimestreDataAccess.save(evaluacionempleado.getBimestre(),connexion);
		BimestreLogic bimestreLogic= new BimestreLogic(connexion);
		bimestreLogic.deepLoad(evaluacionempleado.getBimestre(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(evaluacionempleado.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(evaluacionempleado.getMes(),isDeep,deepLoadType,clases);
				

		for(CalificacionEmpleado calificacionempleado:evaluacionempleado.getCalificacionEmpleados()) {
			CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
			calificacionempleado.setid_evaluacion_empleado(evaluacionempleado.getId());
			CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
			calificacionempleadoLogic.deepSave(calificacionempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(evaluacionempleado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(evaluacionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(evaluacionempleado.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(evaluacionempleado.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(evaluacionempleado.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(evaluacionempleado.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(evaluacionempleado.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(evaluacionempleado.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(evaluacionempleado.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(evaluacionempleado.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(evaluacionempleado.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(evaluacionempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(evaluacionempleado.getEmpleadoEvalua(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(evaluacionempleado.getEmpleadoEvalua(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoEvaluacionEmpleado.class)) {
				TipoEvaluacionEmpleadoDataAccess.save(evaluacionempleado.getTipoEvaluacionEmpleado(),connexion);
				TipoEvaluacionEmpleadoLogic tipoevaluacionempleadoLogic= new TipoEvaluacionEmpleadoLogic(connexion);
				tipoevaluacionempleadoLogic.deepSave(evaluacionempleado.getTipoEvaluacionEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(evaluacionempleado.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(evaluacionempleado.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Semestre.class)) {
				SemestreDataAccess.save(evaluacionempleado.getSemestre(),connexion);
				SemestreLogic semestreLogic= new SemestreLogic(connexion);
				semestreLogic.deepSave(evaluacionempleado.getSemestre(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Trimestre.class)) {
				TrimestreDataAccess.save(evaluacionempleado.getTrimestre(),connexion);
				TrimestreLogic trimestreLogic= new TrimestreLogic(connexion);
				trimestreLogic.deepSave(evaluacionempleado.getTrimestre(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bimestre.class)) {
				BimestreDataAccess.save(evaluacionempleado.getBimestre(),connexion);
				BimestreLogic bimestreLogic= new BimestreLogic(connexion);
				bimestreLogic.deepSave(evaluacionempleado.getBimestre(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(evaluacionempleado.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(evaluacionempleado.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CalificacionEmpleado calificacionempleado:evaluacionempleado.getCalificacionEmpleados()) {
					CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
					calificacionempleado.setid_evaluacion_empleado(evaluacionempleado.getId());
					CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
					calificacionempleadoLogic.deepSave(calificacionempleado,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EvaluacionEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(evaluacionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(evaluacionempleado);
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
			this.deepLoad(this.evaluacionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EvaluacionEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(evaluacionempleados!=null) {
				for(EvaluacionEmpleado evaluacionempleado:evaluacionempleados) {
					this.deepLoad(evaluacionempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(evaluacionempleados);
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
			if(evaluacionempleados!=null) {
				for(EvaluacionEmpleado evaluacionempleado:evaluacionempleados) {
					this.deepLoad(evaluacionempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(evaluacionempleados);
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
			this.getNewConnexionToDeep(EvaluacionEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(evaluacionempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EvaluacionEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(evaluacionempleados!=null) {
				for(EvaluacionEmpleado evaluacionempleado:evaluacionempleados) {
					this.deepSave(evaluacionempleado,isDeep,deepLoadType,clases);
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
			if(evaluacionempleados!=null) {
				for(EvaluacionEmpleado evaluacionempleado:evaluacionempleados) {
					this.deepSave(evaluacionempleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEvaluacionEmpleadosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,EvaluacionEmpleadoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,EvaluacionEmpleadoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionEmpleadosFK_IdBimestreWithConnection(String sFinalQuery,Pagination pagination,Long id_bimestre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBimestre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBimestre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bimestre,EvaluacionEmpleadoConstantesFunciones.IDBIMESTRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBimestre);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBimestre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdBimestre(String sFinalQuery,Pagination pagination,Long id_bimestre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBimestre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBimestre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bimestre,EvaluacionEmpleadoConstantesFunciones.IDBIMESTRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBimestre);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBimestre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionEmpleadosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionEmpleadosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EvaluacionEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EvaluacionEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionEmpleadosFK_IdEmpleadoEvaluaWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_evalua)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoEvalua= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoEvalua.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_evalua,EvaluacionEmpleadoConstantesFunciones.IDEMPLEADOEVALUA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoEvalua);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoEvalua","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdEmpleadoEvalua(String sFinalQuery,Pagination pagination,Long id_empleado_evalua)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoEvalua= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoEvalua.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_evalua,EvaluacionEmpleadoConstantesFunciones.IDEMPLEADOEVALUA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoEvalua);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoEvalua","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionEmpleadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EvaluacionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EvaluacionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionEmpleadosFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EvaluacionEmpleadoConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EvaluacionEmpleadoConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionEmpleadosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,EvaluacionEmpleadoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,EvaluacionEmpleadoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionEmpleadosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,EvaluacionEmpleadoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,EvaluacionEmpleadoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionEmpleadosFK_IdSemestreWithConnection(String sFinalQuery,Pagination pagination,Long id_semestre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSemestre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSemestre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_semestre,EvaluacionEmpleadoConstantesFunciones.IDSEMESTRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSemestre);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSemestre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdSemestre(String sFinalQuery,Pagination pagination,Long id_semestre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSemestre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSemestre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_semestre,EvaluacionEmpleadoConstantesFunciones.IDSEMESTRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSemestre);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSemestre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionEmpleadosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionEmpleadosFK_IdTipoEvaluacionEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_evaluacion_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoEvaluacionEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoEvaluacionEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_evaluacion_empleado,EvaluacionEmpleadoConstantesFunciones.IDTIPOEVALUACIONEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoEvaluacionEmpleado);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoEvaluacionEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdTipoEvaluacionEmpleado(String sFinalQuery,Pagination pagination,Long id_tipo_evaluacion_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoEvaluacionEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoEvaluacionEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_evaluacion_empleado,EvaluacionEmpleadoConstantesFunciones.IDTIPOEVALUACIONEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoEvaluacionEmpleado);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoEvaluacionEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionEmpleadosFK_IdTrimestreWithConnection(String sFinalQuery,Pagination pagination,Long id_trimestre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTrimestre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTrimestre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_trimestre,EvaluacionEmpleadoConstantesFunciones.IDTRIMESTRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTrimestre);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTrimestre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionEmpleadosFK_IdTrimestre(String sFinalQuery,Pagination pagination,Long id_trimestre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTrimestre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTrimestre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_trimestre,EvaluacionEmpleadoConstantesFunciones.IDTRIMESTRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTrimestre);

			EvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTrimestre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(this.evaluacionempleados);
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
			if(EvaluacionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EvaluacionEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EvaluacionEmpleado evaluacionempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EvaluacionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(evaluacionempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EvaluacionEmpleadoDataAccess.TABLENAME, evaluacionempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EvaluacionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EvaluacionEmpleadoLogic.registrarAuditoriaDetallesEvaluacionEmpleado(connexion,evaluacionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(evaluacionempleado.getIsDeleted()) {
					/*if(!evaluacionempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EvaluacionEmpleadoDataAccess.TABLENAME, evaluacionempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EvaluacionEmpleadoLogic.registrarAuditoriaDetallesEvaluacionEmpleado(connexion,evaluacionempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EvaluacionEmpleadoDataAccess.TABLENAME, evaluacionempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(evaluacionempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EvaluacionEmpleadoDataAccess.TABLENAME, evaluacionempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EvaluacionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EvaluacionEmpleadoLogic.registrarAuditoriaDetallesEvaluacionEmpleado(connexion,evaluacionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEvaluacionEmpleado(Connexion connexion,EvaluacionEmpleado evaluacionempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_empresa().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_empresa()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_empresa().toString();
				}
				if(evaluacionempleado.getid_empresa()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_sucursal().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_sucursal()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_sucursal().toString();
				}
				if(evaluacionempleado.getid_sucursal()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_ejercicio().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_ejercicio().toString();
				}
				if(evaluacionempleado.getid_ejercicio()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_periodo().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_periodo()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_periodo().toString();
				}
				if(evaluacionempleado.getid_periodo()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_estructura().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_estructura()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_estructura().toString();
				}
				if(evaluacionempleado.getid_estructura()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_empleado().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_empleado()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_empleado().toString();
				}
				if(evaluacionempleado.getid_empleado()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_empleado_evalua().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_empleado_evalua()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_empleado_evalua()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_empleado_evalua().toString();
				}
				if(evaluacionempleado.getid_empleado_evalua()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_empleado_evalua().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDEMPLEADOEVALUA,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_tipo_evaluacion_empleado().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_tipo_evaluacion_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_tipo_evaluacion_empleado()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_tipo_evaluacion_empleado().toString();
				}
				if(evaluacionempleado.getid_tipo_evaluacion_empleado()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_tipo_evaluacion_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDTIPOEVALUACIONEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getfecha().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getfecha()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getfecha().toString();
				}
				if(evaluacionempleado.getfecha()!=null)
				{
					strValorNuevo=evaluacionempleado.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getesta_evaluado().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getesta_evaluado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getesta_evaluado()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getesta_evaluado().toString();
				}
				if(evaluacionempleado.getesta_evaluado()!=null)
				{
					strValorNuevo=evaluacionempleado.getesta_evaluado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.ESTAEVALUADO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_anio().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_anio()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_anio().toString();
				}
				if(evaluacionempleado.getid_anio()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_semestre().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_semestre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_semestre()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_semestre().toString();
				}
				if(evaluacionempleado.getid_semestre()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_semestre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDSEMESTRE,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_trimestre().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_trimestre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_trimestre()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_trimestre().toString();
				}
				if(evaluacionempleado.getid_trimestre()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_trimestre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDTRIMESTRE,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_bimestre().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_bimestre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_bimestre()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_bimestre().toString();
				}
				if(evaluacionempleado.getid_bimestre()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_bimestre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDBIMESTRE,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getid_mes().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_mes()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getid_mes().toString();
				}
				if(evaluacionempleado.getid_mes()!=null)
				{
					strValorNuevo=evaluacionempleado.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getobservacion1().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getobservacion1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getobservacion1()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getobservacion1();
				}
				if(evaluacionempleado.getobservacion1()!=null)
				{
					strValorNuevo=evaluacionempleado.getobservacion1() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.OBSERVACION1,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getobservacion2().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getobservacion2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getobservacion2()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getobservacion2();
				}
				if(evaluacionempleado.getobservacion2()!=null)
				{
					strValorNuevo=evaluacionempleado.getobservacion2() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.OBSERVACION2,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getobservacion3().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getobservacion3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getobservacion3()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getobservacion3();
				}
				if(evaluacionempleado.getobservacion3()!=null)
				{
					strValorNuevo=evaluacionempleado.getobservacion3() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.OBSERVACION3,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionempleado.getIsNew()||!evaluacionempleado.getobservacion4().equals(evaluacionempleado.getEvaluacionEmpleadoOriginal().getobservacion4()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionempleado.getEvaluacionEmpleadoOriginal().getobservacion4()!=null)
				{
					strValorActual=evaluacionempleado.getEvaluacionEmpleadoOriginal().getobservacion4();
				}
				if(evaluacionempleado.getobservacion4()!=null)
				{
					strValorNuevo=evaluacionempleado.getobservacion4() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionEmpleadoConstantesFunciones.OBSERVACION4,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEvaluacionEmpleadoRelacionesWithConnection(EvaluacionEmpleado evaluacionempleado,List<CalificacionEmpleado> calificacionempleados) throws Exception {

		if(!evaluacionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEvaluacionEmpleadoRelacionesBase(evaluacionempleado,calificacionempleados,true);
		}
	}

	public void saveEvaluacionEmpleadoRelaciones(EvaluacionEmpleado evaluacionempleado,List<CalificacionEmpleado> calificacionempleados)throws Exception {

		if(!evaluacionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEvaluacionEmpleadoRelacionesBase(evaluacionempleado,calificacionempleados,false);
		}
	}

	public void saveEvaluacionEmpleadoRelacionesBase(EvaluacionEmpleado evaluacionempleado,List<CalificacionEmpleado> calificacionempleados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EvaluacionEmpleado-saveRelacionesWithConnection");}
	
			evaluacionempleado.setCalificacionEmpleados(calificacionempleados);

			this.setEvaluacionEmpleado(evaluacionempleado);

			if(EvaluacionEmpleadoLogicAdditional.validarSaveRelaciones(evaluacionempleado,this)) {

				EvaluacionEmpleadoLogicAdditional.updateRelacionesToSave(evaluacionempleado,this);

				if((evaluacionempleado.getIsNew()||evaluacionempleado.getIsChanged())&&!evaluacionempleado.getIsDeleted()) {
					this.saveEvaluacionEmpleado();
					this.saveEvaluacionEmpleadoRelacionesDetalles(calificacionempleados);

				} else if(evaluacionempleado.getIsDeleted()) {
					this.saveEvaluacionEmpleadoRelacionesDetalles(calificacionempleados);
					this.saveEvaluacionEmpleado();
				}

				EvaluacionEmpleadoLogicAdditional.updateRelacionesToSaveAfter(evaluacionempleado,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CalificacionEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresCalificacionEmpleados(calificacionempleados,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEvaluacionEmpleadoRelacionesDetalles(List<CalificacionEmpleado> calificacionempleados)throws Exception {
		try {
	

			Long idEvaluacionEmpleadoActual=this.getEvaluacionEmpleado().getId();

			CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_EvaluacionEmpleado=new CalificacionEmpleadoLogic();
			calificacionempleadoLogic_Desde_EvaluacionEmpleado.setCalificacionEmpleados(calificacionempleados);

			calificacionempleadoLogic_Desde_EvaluacionEmpleado.setConnexion(this.getConnexion());
			calificacionempleadoLogic_Desde_EvaluacionEmpleado.setDatosCliente(this.datosCliente);

			for(CalificacionEmpleado calificacionempleado_Desde_EvaluacionEmpleado:calificacionempleadoLogic_Desde_EvaluacionEmpleado.getCalificacionEmpleados()) {
				calificacionempleado_Desde_EvaluacionEmpleado.setid_evaluacion_empleado(idEvaluacionEmpleadoActual);
			}

			calificacionempleadoLogic_Desde_EvaluacionEmpleado.saveCalificacionEmpleados();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEvaluacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EvaluacionEmpleadoConstantesFunciones.getClassesForeignKeysOfEvaluacionEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EvaluacionEmpleadoConstantesFunciones.getClassesRelationshipsOfEvaluacionEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

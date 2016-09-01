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
import com.bydan.erp.nomina.util.CalificacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.CalificacionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CalificacionEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.CalificacionEmpleado;
import com.bydan.erp.nomina.business.logic.CalificacionEmpleadoLogicAdditional;
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
public class CalificacionEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CalificacionEmpleadoLogic.class);
	
	protected CalificacionEmpleadoDataAccess calificacionempleadoDataAccess; 	
	protected CalificacionEmpleado calificacionempleado;
	protected List<CalificacionEmpleado> calificacionempleados;
	protected Object calificacionempleadoObject;	
	protected List<Object> calificacionempleadosObject;
	
	public static ClassValidator<CalificacionEmpleado> calificacionempleadoValidator = new ClassValidator<CalificacionEmpleado>(CalificacionEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CalificacionEmpleadoLogicAdditional calificacionempleadoLogicAdditional=null;
	
	public CalificacionEmpleadoLogicAdditional getCalificacionEmpleadoLogicAdditional() {
		return this.calificacionempleadoLogicAdditional;
	}
	
	public void setCalificacionEmpleadoLogicAdditional(CalificacionEmpleadoLogicAdditional calificacionempleadoLogicAdditional) {
		try {
			this.calificacionempleadoLogicAdditional=calificacionempleadoLogicAdditional;
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
	
	
	
	
	public  CalificacionEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.calificacionempleadoDataAccess = new CalificacionEmpleadoDataAccess();
			
			this.calificacionempleados= new ArrayList<CalificacionEmpleado>();
			this.calificacionempleado= new CalificacionEmpleado();
			
			this.calificacionempleadoObject=new Object();
			this.calificacionempleadosObject=new ArrayList<Object>();
				
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
			
			this.calificacionempleadoDataAccess.setConnexionType(this.connexionType);
			this.calificacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CalificacionEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.calificacionempleadoDataAccess = new CalificacionEmpleadoDataAccess();
			this.calificacionempleados= new ArrayList<CalificacionEmpleado>();
			this.calificacionempleado= new CalificacionEmpleado();
			this.calificacionempleadoObject=new Object();
			this.calificacionempleadosObject=new ArrayList<Object>();
			
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
			
			this.calificacionempleadoDataAccess.setConnexionType(this.connexionType);
			this.calificacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CalificacionEmpleado getCalificacionEmpleado() throws Exception {	
		CalificacionEmpleadoLogicAdditional.checkCalificacionEmpleadoToGet(calificacionempleado,this.datosCliente,this.arrDatoGeneral);
		CalificacionEmpleadoLogicAdditional.updateCalificacionEmpleadoToGet(calificacionempleado,this.arrDatoGeneral);
		
		return calificacionempleado;
	}
		
	public void setCalificacionEmpleado(CalificacionEmpleado newCalificacionEmpleado) {
		this.calificacionempleado = newCalificacionEmpleado;
	}
	
	public CalificacionEmpleadoDataAccess getCalificacionEmpleadoDataAccess() {
		return calificacionempleadoDataAccess;
	}
	
	public void setCalificacionEmpleadoDataAccess(CalificacionEmpleadoDataAccess newcalificacionempleadoDataAccess) {
		this.calificacionempleadoDataAccess = newcalificacionempleadoDataAccess;
	}
	
	public List<CalificacionEmpleado> getCalificacionEmpleados() throws Exception {		
		this.quitarCalificacionEmpleadosNulos();
		
		CalificacionEmpleadoLogicAdditional.checkCalificacionEmpleadoToGets(calificacionempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (CalificacionEmpleado calificacionempleadoLocal: calificacionempleados ) {
			CalificacionEmpleadoLogicAdditional.updateCalificacionEmpleadoToGet(calificacionempleadoLocal,this.arrDatoGeneral);
		}
		
		return calificacionempleados;
	}
	
	public void setCalificacionEmpleados(List<CalificacionEmpleado> newCalificacionEmpleados) {
		this.calificacionempleados = newCalificacionEmpleados;
	}
	
	public Object getCalificacionEmpleadoObject() {	
		this.calificacionempleadoObject=this.calificacionempleadoDataAccess.getEntityObject();
		return this.calificacionempleadoObject;
	}
		
	public void setCalificacionEmpleadoObject(Object newCalificacionEmpleadoObject) {
		this.calificacionempleadoObject = newCalificacionEmpleadoObject;
	}
	
	public List<Object> getCalificacionEmpleadosObject() {		
		this.calificacionempleadosObject=this.calificacionempleadoDataAccess.getEntitiesObject();
		return this.calificacionempleadosObject;
	}
		
	public void setCalificacionEmpleadosObject(List<Object> newCalificacionEmpleadosObject) {
		this.calificacionempleadosObject = newCalificacionEmpleadosObject;
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
		
		if(this.calificacionempleadoDataAccess!=null) {
			this.calificacionempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			calificacionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			calificacionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		calificacionempleado = new  CalificacionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			calificacionempleado=calificacionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.calificacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleado);
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
		calificacionempleado = new  CalificacionEmpleado();
		  		  
        try {
			
			calificacionempleado=calificacionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.calificacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		calificacionempleado = new  CalificacionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			calificacionempleado=calificacionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.calificacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleado);
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
		calificacionempleado = new  CalificacionEmpleado();
		  		  
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
		calificacionempleado = new  CalificacionEmpleado();
		  		  
        try {
			
			calificacionempleado=calificacionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.calificacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		calificacionempleado = new  CalificacionEmpleado();
		  		  
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
		calificacionempleado = new  CalificacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =calificacionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		calificacionempleado = new  CalificacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=calificacionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		calificacionempleado = new  CalificacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =calificacionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		calificacionempleado = new  CalificacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=calificacionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		calificacionempleado = new  CalificacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =calificacionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		calificacionempleado = new  CalificacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=calificacionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		calificacionempleados = new  ArrayList<CalificacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCalificacionEmpleado(calificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
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
		calificacionempleados = new  ArrayList<CalificacionEmpleado>();
		  		  
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
		calificacionempleados = new  ArrayList<CalificacionEmpleado>();
		  		  
        try {			
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCalificacionEmpleado(calificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		calificacionempleados = new  ArrayList<CalificacionEmpleado>();
		  		  
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
		calificacionempleados = new  ArrayList<CalificacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCalificacionEmpleado(calificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
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
		calificacionempleados = new  ArrayList<CalificacionEmpleado>();
		  		  
        try {
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCalificacionEmpleado(calificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
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
		calificacionempleados = new  ArrayList<CalificacionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCalificacionEmpleado(calificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
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
		calificacionempleados = new  ArrayList<CalificacionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCalificacionEmpleado(calificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		calificacionempleado = new  CalificacionEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calificacionempleado=calificacionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCalificacionEmpleado(calificacionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleado);
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
		calificacionempleado = new  CalificacionEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calificacionempleado=calificacionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCalificacionEmpleado(calificacionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		calificacionempleados = new  ArrayList<CalificacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calificacionempleados=calificacionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCalificacionEmpleado(calificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
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
		calificacionempleados = new  ArrayList<CalificacionEmpleado>();
		  		  
        try {
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calificacionempleados=calificacionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCalificacionEmpleado(calificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCalificacionEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		calificacionempleados = new  ArrayList<CalificacionEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getTodosCalificacionEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCalificacionEmpleado(calificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
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
	
	public  void  getTodosCalificacionEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		calificacionempleados = new  ArrayList<CalificacionEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCalificacionEmpleado(calificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCalificacionEmpleado(CalificacionEmpleado calificacionempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(calificacionempleado.getIsNew() || calificacionempleado.getIsChanged()) { 
			this.invalidValues = calificacionempleadoValidator.getInvalidValues(calificacionempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(calificacionempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCalificacionEmpleado(List<CalificacionEmpleado> CalificacionEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CalificacionEmpleado calificacionempleadoLocal:calificacionempleados) {				
			estaValidadoObjeto=this.validarGuardarCalificacionEmpleado(calificacionempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCalificacionEmpleado(List<CalificacionEmpleado> CalificacionEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCalificacionEmpleado(calificacionempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCalificacionEmpleado(CalificacionEmpleado CalificacionEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCalificacionEmpleado(calificacionempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CalificacionEmpleado calificacionempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+calificacionempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CalificacionEmpleadoConstantesFunciones.getCalificacionEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"calificacionempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CalificacionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CalificacionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCalificacionEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-saveCalificacionEmpleadoWithConnection");connexion.begin();			
			
			CalificacionEmpleadoLogicAdditional.checkCalificacionEmpleadoToSave(this.calificacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CalificacionEmpleadoLogicAdditional.updateCalificacionEmpleadoToSave(this.calificacionempleado,this.arrDatoGeneral);
			
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.calificacionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCalificacionEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCalificacionEmpleado(this.calificacionempleado)) {
				CalificacionEmpleadoDataAccess.save(this.calificacionempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.calificacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CalificacionEmpleadoLogicAdditional.checkCalificacionEmpleadoToSaveAfter(this.calificacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCalificacionEmpleado();
			
			connexion.commit();			
			
			if(this.calificacionempleado.getIsDeleted()) {
				this.calificacionempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCalificacionEmpleado()throws Exception {	
		try {	
			
			CalificacionEmpleadoLogicAdditional.checkCalificacionEmpleadoToSave(this.calificacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CalificacionEmpleadoLogicAdditional.updateCalificacionEmpleadoToSave(this.calificacionempleado,this.arrDatoGeneral);
			
			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.calificacionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCalificacionEmpleado(this.calificacionempleado)) {			
				CalificacionEmpleadoDataAccess.save(this.calificacionempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.calificacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CalificacionEmpleadoLogicAdditional.checkCalificacionEmpleadoToSaveAfter(this.calificacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.calificacionempleado.getIsDeleted()) {
				this.calificacionempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCalificacionEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-saveCalificacionEmpleadosWithConnection");connexion.begin();			
			
			CalificacionEmpleadoLogicAdditional.checkCalificacionEmpleadoToSaves(calificacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCalificacionEmpleados();
			
			Boolean validadoTodosCalificacionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CalificacionEmpleado calificacionempleadoLocal:calificacionempleados) {		
				if(calificacionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CalificacionEmpleadoLogicAdditional.updateCalificacionEmpleadoToSave(calificacionempleadoLocal,this.arrDatoGeneral);
	        	
				CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),calificacionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCalificacionEmpleado(calificacionempleadoLocal)) {
					CalificacionEmpleadoDataAccess.save(calificacionempleadoLocal, connexion);				
				} else {
					validadoTodosCalificacionEmpleado=false;
				}
			}
			
			if(!validadoTodosCalificacionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CalificacionEmpleadoLogicAdditional.checkCalificacionEmpleadoToSavesAfter(calificacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCalificacionEmpleados();
			
			connexion.commit();		
			
			this.quitarCalificacionEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCalificacionEmpleados()throws Exception {				
		 try {	
			CalificacionEmpleadoLogicAdditional.checkCalificacionEmpleadoToSaves(calificacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCalificacionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CalificacionEmpleado calificacionempleadoLocal:calificacionempleados) {				
				if(calificacionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CalificacionEmpleadoLogicAdditional.updateCalificacionEmpleadoToSave(calificacionempleadoLocal,this.arrDatoGeneral);
	        	
				CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),calificacionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCalificacionEmpleado(calificacionempleadoLocal)) {				
					CalificacionEmpleadoDataAccess.save(calificacionempleadoLocal, connexion);				
				} else {
					validadoTodosCalificacionEmpleado=false;
				}
			}
			
			if(!validadoTodosCalificacionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CalificacionEmpleadoLogicAdditional.checkCalificacionEmpleadoToSavesAfter(calificacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCalificacionEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CalificacionEmpleadoParameterReturnGeneral procesarAccionCalificacionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CalificacionEmpleado> calificacionempleados,CalificacionEmpleadoParameterReturnGeneral calificacionempleadoParameterGeneral)throws Exception {
		 try {	
			CalificacionEmpleadoParameterReturnGeneral calificacionempleadoReturnGeneral=new CalificacionEmpleadoParameterReturnGeneral();
	
			CalificacionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,calificacionempleados,calificacionempleadoParameterGeneral,calificacionempleadoReturnGeneral);
			
			return calificacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CalificacionEmpleadoParameterReturnGeneral procesarAccionCalificacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CalificacionEmpleado> calificacionempleados,CalificacionEmpleadoParameterReturnGeneral calificacionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-procesarAccionCalificacionEmpleadosWithConnection");connexion.begin();			
			
			CalificacionEmpleadoParameterReturnGeneral calificacionempleadoReturnGeneral=new CalificacionEmpleadoParameterReturnGeneral();
	
			CalificacionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,calificacionempleados,calificacionempleadoParameterGeneral,calificacionempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return calificacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CalificacionEmpleadoParameterReturnGeneral procesarEventosCalificacionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CalificacionEmpleado> calificacionempleados,CalificacionEmpleado calificacionempleado,CalificacionEmpleadoParameterReturnGeneral calificacionempleadoParameterGeneral,Boolean isEsNuevoCalificacionEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			CalificacionEmpleadoParameterReturnGeneral calificacionempleadoReturnGeneral=new CalificacionEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				calificacionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CalificacionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,calificacionempleados,calificacionempleado,calificacionempleadoParameterGeneral,calificacionempleadoReturnGeneral,isEsNuevoCalificacionEmpleado,clases);
			
			return calificacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CalificacionEmpleadoParameterReturnGeneral procesarEventosCalificacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CalificacionEmpleado> calificacionempleados,CalificacionEmpleado calificacionempleado,CalificacionEmpleadoParameterReturnGeneral calificacionempleadoParameterGeneral,Boolean isEsNuevoCalificacionEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-procesarEventosCalificacionEmpleadosWithConnection");connexion.begin();			
			
			CalificacionEmpleadoParameterReturnGeneral calificacionempleadoReturnGeneral=new CalificacionEmpleadoParameterReturnGeneral();
	
			calificacionempleadoReturnGeneral.setCalificacionEmpleado(calificacionempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				calificacionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CalificacionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,calificacionempleados,calificacionempleado,calificacionempleadoParameterGeneral,calificacionempleadoReturnGeneral,isEsNuevoCalificacionEmpleado,clases);
			
			this.connexion.commit();
			
			return calificacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CalificacionEmpleadoParameterReturnGeneral procesarImportacionCalificacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CalificacionEmpleadoParameterReturnGeneral calificacionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-procesarImportacionCalificacionEmpleadosWithConnection");connexion.begin();			
			
			CalificacionEmpleadoParameterReturnGeneral calificacionempleadoReturnGeneral=new CalificacionEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.calificacionempleados=new ArrayList<CalificacionEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.calificacionempleado=new CalificacionEmpleado();
				
				
				if(conColumnasBase) {this.calificacionempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.calificacionempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.calificacionempleado.setvalor_conocimiento(Double.parseDouble(arrColumnas[iColumn++]));
				this.calificacionempleado.setvalor_eficiencia(Double.parseDouble(arrColumnas[iColumn++]));
				this.calificacionempleado.setvalor_obtenido(Double.parseDouble(arrColumnas[iColumn++]));
				this.calificacionempleado.setvalor_peso(Double.parseDouble(arrColumnas[iColumn++]));
				this.calificacionempleado.setverificado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.calificacionempleados.add(this.calificacionempleado);
			}
			
			this.saveCalificacionEmpleados();
			
			this.connexion.commit();
			
			calificacionempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			calificacionempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return calificacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCalificacionEmpleadosEliminados() throws Exception {				
		
		List<CalificacionEmpleado> calificacionempleadosAux= new ArrayList<CalificacionEmpleado>();
		
		for(CalificacionEmpleado calificacionempleado:calificacionempleados) {
			if(!calificacionempleado.getIsDeleted()) {
				calificacionempleadosAux.add(calificacionempleado);
			}
		}
		
		calificacionempleados=calificacionempleadosAux;
	}
	
	public void quitarCalificacionEmpleadosNulos() throws Exception {				
		
		List<CalificacionEmpleado> calificacionempleadosAux= new ArrayList<CalificacionEmpleado>();
		
		for(CalificacionEmpleado calificacionempleado : this.calificacionempleados) {
			if(calificacionempleado==null) {
				calificacionempleadosAux.add(calificacionempleado);
			}
		}
		
		//this.calificacionempleados=calificacionempleadosAux;
		
		this.calificacionempleados.removeAll(calificacionempleadosAux);
	}
	
	public void getSetVersionRowCalificacionEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(calificacionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((calificacionempleado.getIsDeleted() || (calificacionempleado.getIsChanged()&&!calificacionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=calificacionempleadoDataAccess.getSetVersionRowCalificacionEmpleado(connexion,calificacionempleado.getId());
				
				if(!calificacionempleado.getVersionRow().equals(timestamp)) {	
					calificacionempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				calificacionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCalificacionEmpleado()throws Exception {	
		
		if(calificacionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((calificacionempleado.getIsDeleted() || (calificacionempleado.getIsChanged()&&!calificacionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=calificacionempleadoDataAccess.getSetVersionRowCalificacionEmpleado(connexion,calificacionempleado.getId());
			
			try {							
				if(!calificacionempleado.getVersionRow().equals(timestamp)) {	
					calificacionempleado.setVersionRow(timestamp);
				}
				
				calificacionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCalificacionEmpleadosWithConnection()throws Exception {	
		if(calificacionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CalificacionEmpleado calificacionempleadoAux:calificacionempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(calificacionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(calificacionempleadoAux.getIsDeleted() || (calificacionempleadoAux.getIsChanged()&&!calificacionempleadoAux.getIsNew())) {
						
						timestamp=calificacionempleadoDataAccess.getSetVersionRowCalificacionEmpleado(connexion,calificacionempleadoAux.getId());
						
						if(!calificacionempleado.getVersionRow().equals(timestamp)) {	
							calificacionempleadoAux.setVersionRow(timestamp);
						}
								
						calificacionempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCalificacionEmpleados()throws Exception {	
		if(calificacionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CalificacionEmpleado calificacionempleadoAux:calificacionempleados) {
					if(calificacionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(calificacionempleadoAux.getIsDeleted() || (calificacionempleadoAux.getIsChanged()&&!calificacionempleadoAux.getIsNew())) {
						
						timestamp=calificacionempleadoDataAccess.getSetVersionRowCalificacionEmpleado(connexion,calificacionempleadoAux.getId());
						
						if(!calificacionempleadoAux.getVersionRow().equals(timestamp)) {	
							calificacionempleadoAux.setVersionRow(timestamp);
						}
						
													
						calificacionempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CalificacionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyCalificacionEmpleadoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalEmpleado,String finalQueryGlobalEvaluacionEmpleado,String finalQueryGlobalFormatoNomiFactorNomi,String finalQueryGlobalFormatoNomiPreguntaNomi,String finalQueryGlobalTipoCalificacionEmpleado) throws Exception {
		CalificacionEmpleadoParameterReturnGeneral  calificacionempleadoReturnGeneral =new CalificacionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-cargarCombosLoteForeignKeyCalificacionEmpleadoWithConnection");connexion.begin();
			
			calificacionempleadoReturnGeneral =new CalificacionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			calificacionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			calificacionempleadoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			calificacionempleadoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			calificacionempleadoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			calificacionempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<EvaluacionEmpleado> evaluacionempleadosForeignKey=new ArrayList<EvaluacionEmpleado>();
			EvaluacionEmpleadoLogic evaluacionempleadoLogic=new EvaluacionEmpleadoLogic();
			evaluacionempleadoLogic.setConnexion(this.connexion);
			evaluacionempleadoLogic.getEvaluacionEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEvaluacionEmpleado.equals("NONE")) {
				evaluacionempleadoLogic.getTodosEvaluacionEmpleados(finalQueryGlobalEvaluacionEmpleado,new Pagination());
				evaluacionempleadosForeignKey=evaluacionempleadoLogic.getEvaluacionEmpleados();
			}

			calificacionempleadoReturnGeneral.setevaluacionempleadosForeignKey(evaluacionempleadosForeignKey);


			List<FormatoNomiFactorNomi> formatonomifactornomisForeignKey=new ArrayList<FormatoNomiFactorNomi>();
			FormatoNomiFactorNomiLogic formatonomifactornomiLogic=new FormatoNomiFactorNomiLogic();
			formatonomifactornomiLogic.setConnexion(this.connexion);
			formatonomifactornomiLogic.getFormatoNomiFactorNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNomiFactorNomi.equals("NONE")) {
				formatonomifactornomiLogic.getTodosFormatoNomiFactorNomis(finalQueryGlobalFormatoNomiFactorNomi,new Pagination());
				formatonomifactornomisForeignKey=formatonomifactornomiLogic.getFormatoNomiFactorNomis();
			}

			calificacionempleadoReturnGeneral.setformatonomifactornomisForeignKey(formatonomifactornomisForeignKey);


			List<FormatoNomiPreguntaNomi> formatonomipreguntanomisForeignKey=new ArrayList<FormatoNomiPreguntaNomi>();
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic=new FormatoNomiPreguntaNomiLogic();
			formatonomipreguntanomiLogic.setConnexion(this.connexion);
			formatonomipreguntanomiLogic.getFormatoNomiPreguntaNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNomiPreguntaNomi.equals("NONE")) {
				formatonomipreguntanomiLogic.getTodosFormatoNomiPreguntaNomis(finalQueryGlobalFormatoNomiPreguntaNomi,new Pagination());
				formatonomipreguntanomisForeignKey=formatonomipreguntanomiLogic.getFormatoNomiPreguntaNomis();
			}

			calificacionempleadoReturnGeneral.setformatonomipreguntanomisForeignKey(formatonomipreguntanomisForeignKey);


			List<TipoCalificacionEmpleado> tipocalificacionempleadosForeignKey=new ArrayList<TipoCalificacionEmpleado>();
			TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic=new TipoCalificacionEmpleadoLogic();
			tipocalificacionempleadoLogic.setConnexion(this.connexion);
			tipocalificacionempleadoLogic.getTipoCalificacionEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCalificacionEmpleado.equals("NONE")) {
				tipocalificacionempleadoLogic.getTodosTipoCalificacionEmpleados(finalQueryGlobalTipoCalificacionEmpleado,new Pagination());
				tipocalificacionempleadosForeignKey=tipocalificacionempleadoLogic.getTipoCalificacionEmpleados();
			}

			calificacionempleadoReturnGeneral.settipocalificacionempleadosForeignKey(tipocalificacionempleadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return calificacionempleadoReturnGeneral;
	}
	
	public CalificacionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyCalificacionEmpleado(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalEmpleado,String finalQueryGlobalEvaluacionEmpleado,String finalQueryGlobalFormatoNomiFactorNomi,String finalQueryGlobalFormatoNomiPreguntaNomi,String finalQueryGlobalTipoCalificacionEmpleado) throws Exception {
		CalificacionEmpleadoParameterReturnGeneral  calificacionempleadoReturnGeneral =new CalificacionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			calificacionempleadoReturnGeneral =new CalificacionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			calificacionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			calificacionempleadoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			calificacionempleadoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			calificacionempleadoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			calificacionempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<EvaluacionEmpleado> evaluacionempleadosForeignKey=new ArrayList<EvaluacionEmpleado>();
			EvaluacionEmpleadoLogic evaluacionempleadoLogic=new EvaluacionEmpleadoLogic();
			evaluacionempleadoLogic.setConnexion(this.connexion);
			evaluacionempleadoLogic.getEvaluacionEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEvaluacionEmpleado.equals("NONE")) {
				evaluacionempleadoLogic.getTodosEvaluacionEmpleados(finalQueryGlobalEvaluacionEmpleado,new Pagination());
				evaluacionempleadosForeignKey=evaluacionempleadoLogic.getEvaluacionEmpleados();
			}

			calificacionempleadoReturnGeneral.setevaluacionempleadosForeignKey(evaluacionempleadosForeignKey);


			List<FormatoNomiFactorNomi> formatonomifactornomisForeignKey=new ArrayList<FormatoNomiFactorNomi>();
			FormatoNomiFactorNomiLogic formatonomifactornomiLogic=new FormatoNomiFactorNomiLogic();
			formatonomifactornomiLogic.setConnexion(this.connexion);
			formatonomifactornomiLogic.getFormatoNomiFactorNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNomiFactorNomi.equals("NONE")) {
				formatonomifactornomiLogic.getTodosFormatoNomiFactorNomis(finalQueryGlobalFormatoNomiFactorNomi,new Pagination());
				formatonomifactornomisForeignKey=formatonomifactornomiLogic.getFormatoNomiFactorNomis();
			}

			calificacionempleadoReturnGeneral.setformatonomifactornomisForeignKey(formatonomifactornomisForeignKey);


			List<FormatoNomiPreguntaNomi> formatonomipreguntanomisForeignKey=new ArrayList<FormatoNomiPreguntaNomi>();
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic=new FormatoNomiPreguntaNomiLogic();
			formatonomipreguntanomiLogic.setConnexion(this.connexion);
			formatonomipreguntanomiLogic.getFormatoNomiPreguntaNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNomiPreguntaNomi.equals("NONE")) {
				formatonomipreguntanomiLogic.getTodosFormatoNomiPreguntaNomis(finalQueryGlobalFormatoNomiPreguntaNomi,new Pagination());
				formatonomipreguntanomisForeignKey=formatonomipreguntanomiLogic.getFormatoNomiPreguntaNomis();
			}

			calificacionempleadoReturnGeneral.setformatonomipreguntanomisForeignKey(formatonomipreguntanomisForeignKey);


			List<TipoCalificacionEmpleado> tipocalificacionempleadosForeignKey=new ArrayList<TipoCalificacionEmpleado>();
			TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic=new TipoCalificacionEmpleadoLogic();
			tipocalificacionempleadoLogic.setConnexion(this.connexion);
			tipocalificacionempleadoLogic.getTipoCalificacionEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCalificacionEmpleado.equals("NONE")) {
				tipocalificacionempleadoLogic.getTodosTipoCalificacionEmpleados(finalQueryGlobalTipoCalificacionEmpleado,new Pagination());
				tipocalificacionempleadosForeignKey=tipocalificacionempleadoLogic.getTipoCalificacionEmpleados();
			}

			calificacionempleadoReturnGeneral.settipocalificacionempleadosForeignKey(tipocalificacionempleadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return calificacionempleadoReturnGeneral;
	}
	
	
	public void deepLoad(CalificacionEmpleado calificacionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CalificacionEmpleadoLogicAdditional.updateCalificacionEmpleadoToGet(calificacionempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		calificacionempleado.setEmpresa(calificacionempleadoDataAccess.getEmpresa(connexion,calificacionempleado));
		calificacionempleado.setSucursal(calificacionempleadoDataAccess.getSucursal(connexion,calificacionempleado));
		calificacionempleado.setEjercicio(calificacionempleadoDataAccess.getEjercicio(connexion,calificacionempleado));
		calificacionempleado.setPeriodo(calificacionempleadoDataAccess.getPeriodo(connexion,calificacionempleado));
		calificacionempleado.setEmpleado(calificacionempleadoDataAccess.getEmpleado(connexion,calificacionempleado));
		calificacionempleado.setEvaluacionEmpleado(calificacionempleadoDataAccess.getEvaluacionEmpleado(connexion,calificacionempleado));
		calificacionempleado.setFormatoNomiFactorNomi(calificacionempleadoDataAccess.getFormatoNomiFactorNomi(connexion,calificacionempleado));
		calificacionempleado.setFormatoNomiPreguntaNomi(calificacionempleadoDataAccess.getFormatoNomiPreguntaNomi(connexion,calificacionempleado));
		calificacionempleado.setTipoCalificacionEmpleado(calificacionempleadoDataAccess.getTipoCalificacionEmpleado(connexion,calificacionempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				calificacionempleado.setEmpresa(calificacionempleadoDataAccess.getEmpresa(connexion,calificacionempleado));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				calificacionempleado.setSucursal(calificacionempleadoDataAccess.getSucursal(connexion,calificacionempleado));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				calificacionempleado.setEjercicio(calificacionempleadoDataAccess.getEjercicio(connexion,calificacionempleado));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				calificacionempleado.setPeriodo(calificacionempleadoDataAccess.getPeriodo(connexion,calificacionempleado));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				calificacionempleado.setEmpleado(calificacionempleadoDataAccess.getEmpleado(connexion,calificacionempleado));
				continue;
			}

			if(clas.clas.equals(EvaluacionEmpleado.class)) {
				calificacionempleado.setEvaluacionEmpleado(calificacionempleadoDataAccess.getEvaluacionEmpleado(connexion,calificacionempleado));
				continue;
			}

			if(clas.clas.equals(FormatoNomiFactorNomi.class)) {
				calificacionempleado.setFormatoNomiFactorNomi(calificacionempleadoDataAccess.getFormatoNomiFactorNomi(connexion,calificacionempleado));
				continue;
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				calificacionempleado.setFormatoNomiPreguntaNomi(calificacionempleadoDataAccess.getFormatoNomiPreguntaNomi(connexion,calificacionempleado));
				continue;
			}

			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				calificacionempleado.setTipoCalificacionEmpleado(calificacionempleadoDataAccess.getTipoCalificacionEmpleado(connexion,calificacionempleado));
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
			calificacionempleado.setEmpresa(calificacionempleadoDataAccess.getEmpresa(connexion,calificacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setSucursal(calificacionempleadoDataAccess.getSucursal(connexion,calificacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setEjercicio(calificacionempleadoDataAccess.getEjercicio(connexion,calificacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setPeriodo(calificacionempleadoDataAccess.getPeriodo(connexion,calificacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setEmpleado(calificacionempleadoDataAccess.getEmpleado(connexion,calificacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setEvaluacionEmpleado(calificacionempleadoDataAccess.getEvaluacionEmpleado(connexion,calificacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiFactorNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setFormatoNomiFactorNomi(calificacionempleadoDataAccess.getFormatoNomiFactorNomi(connexion,calificacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setFormatoNomiPreguntaNomi(calificacionempleadoDataAccess.getFormatoNomiPreguntaNomi(connexion,calificacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setTipoCalificacionEmpleado(calificacionempleadoDataAccess.getTipoCalificacionEmpleado(connexion,calificacionempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		calificacionempleado.setEmpresa(calificacionempleadoDataAccess.getEmpresa(connexion,calificacionempleado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(calificacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		calificacionempleado.setSucursal(calificacionempleadoDataAccess.getSucursal(connexion,calificacionempleado));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(calificacionempleado.getSucursal(),isDeep,deepLoadType,clases);
				
		calificacionempleado.setEjercicio(calificacionempleadoDataAccess.getEjercicio(connexion,calificacionempleado));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(calificacionempleado.getEjercicio(),isDeep,deepLoadType,clases);
				
		calificacionempleado.setPeriodo(calificacionempleadoDataAccess.getPeriodo(connexion,calificacionempleado));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(calificacionempleado.getPeriodo(),isDeep,deepLoadType,clases);
				
		calificacionempleado.setEmpleado(calificacionempleadoDataAccess.getEmpleado(connexion,calificacionempleado));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(calificacionempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		calificacionempleado.setEvaluacionEmpleado(calificacionempleadoDataAccess.getEvaluacionEmpleado(connexion,calificacionempleado));
		EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
		evaluacionempleadoLogic.deepLoad(calificacionempleado.getEvaluacionEmpleado(),isDeep,deepLoadType,clases);
				
		calificacionempleado.setFormatoNomiFactorNomi(calificacionempleadoDataAccess.getFormatoNomiFactorNomi(connexion,calificacionempleado));
		FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
		formatonomifactornomiLogic.deepLoad(calificacionempleado.getFormatoNomiFactorNomi(),isDeep,deepLoadType,clases);
				
		calificacionempleado.setFormatoNomiPreguntaNomi(calificacionempleadoDataAccess.getFormatoNomiPreguntaNomi(connexion,calificacionempleado));
		FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
		formatonomipreguntanomiLogic.deepLoad(calificacionempleado.getFormatoNomiPreguntaNomi(),isDeep,deepLoadType,clases);
				
		calificacionempleado.setTipoCalificacionEmpleado(calificacionempleadoDataAccess.getTipoCalificacionEmpleado(connexion,calificacionempleado));
		TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
		tipocalificacionempleadoLogic.deepLoad(calificacionempleado.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				calificacionempleado.setEmpresa(calificacionempleadoDataAccess.getEmpresa(connexion,calificacionempleado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(calificacionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				calificacionempleado.setSucursal(calificacionempleadoDataAccess.getSucursal(connexion,calificacionempleado));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(calificacionempleado.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				calificacionempleado.setEjercicio(calificacionempleadoDataAccess.getEjercicio(connexion,calificacionempleado));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(calificacionempleado.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				calificacionempleado.setPeriodo(calificacionempleadoDataAccess.getPeriodo(connexion,calificacionempleado));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(calificacionempleado.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				calificacionempleado.setEmpleado(calificacionempleadoDataAccess.getEmpleado(connexion,calificacionempleado));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(calificacionempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EvaluacionEmpleado.class)) {
				calificacionempleado.setEvaluacionEmpleado(calificacionempleadoDataAccess.getEvaluacionEmpleado(connexion,calificacionempleado));
				EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
				evaluacionempleadoLogic.deepLoad(calificacionempleado.getEvaluacionEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomiFactorNomi.class)) {
				calificacionempleado.setFormatoNomiFactorNomi(calificacionempleadoDataAccess.getFormatoNomiFactorNomi(connexion,calificacionempleado));
				FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
				formatonomifactornomiLogic.deepLoad(calificacionempleado.getFormatoNomiFactorNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				calificacionempleado.setFormatoNomiPreguntaNomi(calificacionempleadoDataAccess.getFormatoNomiPreguntaNomi(connexion,calificacionempleado));
				FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
				formatonomipreguntanomiLogic.deepLoad(calificacionempleado.getFormatoNomiPreguntaNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				calificacionempleado.setTipoCalificacionEmpleado(calificacionempleadoDataAccess.getTipoCalificacionEmpleado(connexion,calificacionempleado));
				TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
				tipocalificacionempleadoLogic.deepLoad(calificacionempleado.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);				
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
			calificacionempleado.setEmpresa(calificacionempleadoDataAccess.getEmpresa(connexion,calificacionempleado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(calificacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setSucursal(calificacionempleadoDataAccess.getSucursal(connexion,calificacionempleado));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(calificacionempleado.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setEjercicio(calificacionempleadoDataAccess.getEjercicio(connexion,calificacionempleado));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(calificacionempleado.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setPeriodo(calificacionempleadoDataAccess.getPeriodo(connexion,calificacionempleado));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(calificacionempleado.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setEmpleado(calificacionempleadoDataAccess.getEmpleado(connexion,calificacionempleado));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(calificacionempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setEvaluacionEmpleado(calificacionempleadoDataAccess.getEvaluacionEmpleado(connexion,calificacionempleado));
			EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
			evaluacionempleadoLogic.deepLoad(calificacionempleado.getEvaluacionEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiFactorNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setFormatoNomiFactorNomi(calificacionempleadoDataAccess.getFormatoNomiFactorNomi(connexion,calificacionempleado));
			FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
			formatonomifactornomiLogic.deepLoad(calificacionempleado.getFormatoNomiFactorNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setFormatoNomiPreguntaNomi(calificacionempleadoDataAccess.getFormatoNomiPreguntaNomi(connexion,calificacionempleado));
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
			formatonomipreguntanomiLogic.deepLoad(calificacionempleado.getFormatoNomiPreguntaNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			calificacionempleado.setTipoCalificacionEmpleado(calificacionempleadoDataAccess.getTipoCalificacionEmpleado(connexion,calificacionempleado));
			TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
			tipocalificacionempleadoLogic.deepLoad(calificacionempleado.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CalificacionEmpleado calificacionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CalificacionEmpleadoLogicAdditional.updateCalificacionEmpleadoToSave(calificacionempleado,this.arrDatoGeneral);
			
CalificacionEmpleadoDataAccess.save(calificacionempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(calificacionempleado.getEmpresa(),connexion);

		SucursalDataAccess.save(calificacionempleado.getSucursal(),connexion);

		EjercicioDataAccess.save(calificacionempleado.getEjercicio(),connexion);

		PeriodoDataAccess.save(calificacionempleado.getPeriodo(),connexion);

		EmpleadoDataAccess.save(calificacionempleado.getEmpleado(),connexion);

		EvaluacionEmpleadoDataAccess.save(calificacionempleado.getEvaluacionEmpleado(),connexion);

		FormatoNomiFactorNomiDataAccess.save(calificacionempleado.getFormatoNomiFactorNomi(),connexion);

		FormatoNomiPreguntaNomiDataAccess.save(calificacionempleado.getFormatoNomiPreguntaNomi(),connexion);

		TipoCalificacionEmpleadoDataAccess.save(calificacionempleado.getTipoCalificacionEmpleado(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(calificacionempleado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(calificacionempleado.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(calificacionempleado.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(calificacionempleado.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(calificacionempleado.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(EvaluacionEmpleado.class)) {
				EvaluacionEmpleadoDataAccess.save(calificacionempleado.getEvaluacionEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(FormatoNomiFactorNomi.class)) {
				FormatoNomiFactorNomiDataAccess.save(calificacionempleado.getFormatoNomiFactorNomi(),connexion);
				continue;
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				FormatoNomiPreguntaNomiDataAccess.save(calificacionempleado.getFormatoNomiPreguntaNomi(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				TipoCalificacionEmpleadoDataAccess.save(calificacionempleado.getTipoCalificacionEmpleado(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(calificacionempleado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(calificacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(calificacionempleado.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(calificacionempleado.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(calificacionempleado.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(calificacionempleado.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(calificacionempleado.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(calificacionempleado.getPeriodo(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(calificacionempleado.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(calificacionempleado.getEmpleado(),isDeep,deepLoadType,clases);
				

		EvaluacionEmpleadoDataAccess.save(calificacionempleado.getEvaluacionEmpleado(),connexion);
		EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
		evaluacionempleadoLogic.deepLoad(calificacionempleado.getEvaluacionEmpleado(),isDeep,deepLoadType,clases);
				

		FormatoNomiFactorNomiDataAccess.save(calificacionempleado.getFormatoNomiFactorNomi(),connexion);
		FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
		formatonomifactornomiLogic.deepLoad(calificacionempleado.getFormatoNomiFactorNomi(),isDeep,deepLoadType,clases);
				

		FormatoNomiPreguntaNomiDataAccess.save(calificacionempleado.getFormatoNomiPreguntaNomi(),connexion);
		FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
		formatonomipreguntanomiLogic.deepLoad(calificacionempleado.getFormatoNomiPreguntaNomi(),isDeep,deepLoadType,clases);
				

		TipoCalificacionEmpleadoDataAccess.save(calificacionempleado.getTipoCalificacionEmpleado(),connexion);
		TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
		tipocalificacionempleadoLogic.deepLoad(calificacionempleado.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(calificacionempleado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(calificacionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(calificacionempleado.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(calificacionempleado.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(calificacionempleado.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(calificacionempleado.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(calificacionempleado.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(calificacionempleado.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(calificacionempleado.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(calificacionempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EvaluacionEmpleado.class)) {
				EvaluacionEmpleadoDataAccess.save(calificacionempleado.getEvaluacionEmpleado(),connexion);
				EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
				evaluacionempleadoLogic.deepSave(calificacionempleado.getEvaluacionEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomiFactorNomi.class)) {
				FormatoNomiFactorNomiDataAccess.save(calificacionempleado.getFormatoNomiFactorNomi(),connexion);
				FormatoNomiFactorNomiLogic formatonomifactornomiLogic= new FormatoNomiFactorNomiLogic(connexion);
				formatonomifactornomiLogic.deepSave(calificacionempleado.getFormatoNomiFactorNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)) {
				FormatoNomiPreguntaNomiDataAccess.save(calificacionempleado.getFormatoNomiPreguntaNomi(),connexion);
				FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
				formatonomipreguntanomiLogic.deepSave(calificacionempleado.getFormatoNomiPreguntaNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCalificacionEmpleado.class)) {
				TipoCalificacionEmpleadoDataAccess.save(calificacionempleado.getTipoCalificacionEmpleado(),connexion);
				TipoCalificacionEmpleadoLogic tipocalificacionempleadoLogic= new TipoCalificacionEmpleadoLogic(connexion);
				tipocalificacionempleadoLogic.deepSave(calificacionempleado.getTipoCalificacionEmpleado(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CalificacionEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(calificacionempleado);
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
			this.deepLoad(this.calificacionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CalificacionEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(calificacionempleados!=null) {
				for(CalificacionEmpleado calificacionempleado:calificacionempleados) {
					this.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(calificacionempleados);
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
			if(calificacionempleados!=null) {
				for(CalificacionEmpleado calificacionempleado:calificacionempleados) {
					this.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(calificacionempleados);
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
			this.getNewConnexionToDeep(CalificacionEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(calificacionempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CalificacionEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(calificacionempleados!=null) {
				for(CalificacionEmpleado calificacionempleado:calificacionempleados) {
					this.deepSave(calificacionempleado,isDeep,deepLoadType,clases);
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
			if(calificacionempleados!=null) {
				for(CalificacionEmpleado calificacionempleado:calificacionempleados) {
					this.deepSave(calificacionempleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCalificacionEmpleadosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,CalificacionEmpleadoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCalificacionEmpleadosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,CalificacionEmpleadoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCalificacionEmpleadosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,CalificacionEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCalificacionEmpleadosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,CalificacionEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCalificacionEmpleadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CalificacionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCalificacionEmpleadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CalificacionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCalificacionEmpleadosFK_IdEvaluacionEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_evaluacion_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEvaluacionEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEvaluacionEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_evaluacion_empleado,CalificacionEmpleadoConstantesFunciones.IDEVALUACIONEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEvaluacionEmpleado);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEvaluacionEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCalificacionEmpleadosFK_IdEvaluacionEmpleado(String sFinalQuery,Pagination pagination,Long id_evaluacion_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEvaluacionEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEvaluacionEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_evaluacion_empleado,CalificacionEmpleadoConstantesFunciones.IDEVALUACIONEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEvaluacionEmpleado);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEvaluacionEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCalificacionEmpleadosFK_IdFormatoNomiFactorNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_nomi_factor_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNomiFactorNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNomiFactorNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nomi_factor_nomi,CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIFACTORNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNomiFactorNomi);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNomiFactorNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCalificacionEmpleadosFK_IdFormatoNomiFactorNomi(String sFinalQuery,Pagination pagination,Long id_formato_nomi_factor_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNomiFactorNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNomiFactorNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nomi_factor_nomi,CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIFACTORNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNomiFactorNomi);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNomiFactorNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCalificacionEmpleadosFK_IdFormatoNomiPreguntaNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_nomi_pregunta_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNomiPreguntaNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNomiPreguntaNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nomi_pregunta_nomi,CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIPREGUNTANOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNomiPreguntaNomi);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNomiPreguntaNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCalificacionEmpleadosFK_IdFormatoNomiPreguntaNomi(String sFinalQuery,Pagination pagination,Long id_formato_nomi_pregunta_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNomiPreguntaNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNomiPreguntaNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nomi_pregunta_nomi,CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIPREGUNTANOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNomiPreguntaNomi);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNomiPreguntaNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCalificacionEmpleadosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,CalificacionEmpleadoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCalificacionEmpleadosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,CalificacionEmpleadoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCalificacionEmpleadosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CalificacionEmpleadoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCalificacionEmpleadosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CalificacionEmpleadoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCalificacionEmpleadosFK_IdTipoCalificacionEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_calificacion_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalificacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCalificacionEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCalificacionEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_calificacion_empleado,CalificacionEmpleadoConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCalificacionEmpleado);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCalificacionEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCalificacionEmpleadosFK_IdTipoCalificacionEmpleado(String sFinalQuery,Pagination pagination,Long id_tipo_calificacion_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCalificacionEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCalificacionEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_calificacion_empleado,CalificacionEmpleadoConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCalificacionEmpleado);

			CalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCalificacionEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(this.calificacionempleados);
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
			if(CalificacionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CalificacionEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CalificacionEmpleado calificacionempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CalificacionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(calificacionempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CalificacionEmpleadoDataAccess.TABLENAME, calificacionempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CalificacionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CalificacionEmpleadoLogic.registrarAuditoriaDetallesCalificacionEmpleado(connexion,calificacionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(calificacionempleado.getIsDeleted()) {
					/*if(!calificacionempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CalificacionEmpleadoDataAccess.TABLENAME, calificacionempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CalificacionEmpleadoLogic.registrarAuditoriaDetallesCalificacionEmpleado(connexion,calificacionempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CalificacionEmpleadoDataAccess.TABLENAME, calificacionempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(calificacionempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CalificacionEmpleadoDataAccess.TABLENAME, calificacionempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CalificacionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CalificacionEmpleadoLogic.registrarAuditoriaDetallesCalificacionEmpleado(connexion,calificacionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCalificacionEmpleado(Connexion connexion,CalificacionEmpleado calificacionempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getid_empresa().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getid_empresa()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getid_empresa().toString();
				}
				if(calificacionempleado.getid_empresa()!=null)
				{
					strValorNuevo=calificacionempleado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getid_sucursal().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getid_sucursal()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getid_sucursal().toString();
				}
				if(calificacionempleado.getid_sucursal()!=null)
				{
					strValorNuevo=calificacionempleado.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getid_ejercicio().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getid_ejercicio().toString();
				}
				if(calificacionempleado.getid_ejercicio()!=null)
				{
					strValorNuevo=calificacionempleado.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getid_periodo().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getid_periodo()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getid_periodo().toString();
				}
				if(calificacionempleado.getid_periodo()!=null)
				{
					strValorNuevo=calificacionempleado.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getid_empleado().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getid_empleado()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getid_empleado().toString();
				}
				if(calificacionempleado.getid_empleado()!=null)
				{
					strValorNuevo=calificacionempleado.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getid_evaluacion_empleado().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getid_evaluacion_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getid_evaluacion_empleado()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getid_evaluacion_empleado().toString();
				}
				if(calificacionempleado.getid_evaluacion_empleado()!=null)
				{
					strValorNuevo=calificacionempleado.getid_evaluacion_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.IDEVALUACIONEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getid_formato_nomi_factor_nomi().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getid_formato_nomi_factor_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getid_formato_nomi_factor_nomi()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getid_formato_nomi_factor_nomi().toString();
				}
				if(calificacionempleado.getid_formato_nomi_factor_nomi()!=null)
				{
					strValorNuevo=calificacionempleado.getid_formato_nomi_factor_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIFACTORNOMI,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getid_formato_nomi_pregunta_nomi().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getid_formato_nomi_pregunta_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getid_formato_nomi_pregunta_nomi()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getid_formato_nomi_pregunta_nomi().toString();
				}
				if(calificacionempleado.getid_formato_nomi_pregunta_nomi()!=null)
				{
					strValorNuevo=calificacionempleado.getid_formato_nomi_pregunta_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIPREGUNTANOMI,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getid_tipo_calificacion_empleado().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getid_tipo_calificacion_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getid_tipo_calificacion_empleado()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getid_tipo_calificacion_empleado().toString();
				}
				if(calificacionempleado.getid_tipo_calificacion_empleado()!=null)
				{
					strValorNuevo=calificacionempleado.getid_tipo_calificacion_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getvalor_conocimiento().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getvalor_conocimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getvalor_conocimiento()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getvalor_conocimiento().toString();
				}
				if(calificacionempleado.getvalor_conocimiento()!=null)
				{
					strValorNuevo=calificacionempleado.getvalor_conocimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.VALORCONOCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getvalor_eficiencia().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getvalor_eficiencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getvalor_eficiencia()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getvalor_eficiencia().toString();
				}
				if(calificacionempleado.getvalor_eficiencia()!=null)
				{
					strValorNuevo=calificacionempleado.getvalor_eficiencia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.VALOREFICIENCIA,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getvalor_obtenido().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getvalor_obtenido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getvalor_obtenido()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getvalor_obtenido().toString();
				}
				if(calificacionempleado.getvalor_obtenido()!=null)
				{
					strValorNuevo=calificacionempleado.getvalor_obtenido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.VALOROBTENIDO,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getvalor_peso().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getvalor_peso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getvalor_peso()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getvalor_peso().toString();
				}
				if(calificacionempleado.getvalor_peso()!=null)
				{
					strValorNuevo=calificacionempleado.getvalor_peso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.VALORPESO,strValorActual,strValorNuevo);
			}	
			
			if(calificacionempleado.getIsNew()||!calificacionempleado.getverificado().equals(calificacionempleado.getCalificacionEmpleadoOriginal().getverificado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calificacionempleado.getCalificacionEmpleadoOriginal().getverificado()!=null)
				{
					strValorActual=calificacionempleado.getCalificacionEmpleadoOriginal().getverificado().toString();
				}
				if(calificacionempleado.getverificado()!=null)
				{
					strValorNuevo=calificacionempleado.getverificado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalificacionEmpleadoConstantesFunciones.VERIFICADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCalificacionEmpleadoRelacionesWithConnection(CalificacionEmpleado calificacionempleado) throws Exception {

		if(!calificacionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCalificacionEmpleadoRelacionesBase(calificacionempleado,true);
		}
	}

	public void saveCalificacionEmpleadoRelaciones(CalificacionEmpleado calificacionempleado)throws Exception {

		if(!calificacionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCalificacionEmpleadoRelacionesBase(calificacionempleado,false);
		}
	}

	public void saveCalificacionEmpleadoRelacionesBase(CalificacionEmpleado calificacionempleado,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CalificacionEmpleado-saveRelacionesWithConnection");}
	

			this.setCalificacionEmpleado(calificacionempleado);

			if(CalificacionEmpleadoLogicAdditional.validarSaveRelaciones(calificacionempleado,this)) {

				CalificacionEmpleadoLogicAdditional.updateRelacionesToSave(calificacionempleado,this);

				if((calificacionempleado.getIsNew()||calificacionempleado.getIsChanged())&&!calificacionempleado.getIsDeleted()) {
					this.saveCalificacionEmpleado();
					this.saveCalificacionEmpleadoRelacionesDetalles();

				} else if(calificacionempleado.getIsDeleted()) {
					this.saveCalificacionEmpleadoRelacionesDetalles();
					this.saveCalificacionEmpleado();
				}

				CalificacionEmpleadoLogicAdditional.updateRelacionesToSaveAfter(calificacionempleado,this);

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
	
	
	private void saveCalificacionEmpleadoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCalificacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CalificacionEmpleadoConstantesFunciones.getClassesForeignKeysOfCalificacionEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCalificacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CalificacionEmpleadoConstantesFunciones.getClassesRelationshipsOfCalificacionEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

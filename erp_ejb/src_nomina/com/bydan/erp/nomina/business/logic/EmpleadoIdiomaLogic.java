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
import com.bydan.erp.nomina.util.EmpleadoIdiomaConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoIdiomaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoIdiomaParameterGeneral;
import com.bydan.erp.nomina.business.entity.EmpleadoIdioma;
import com.bydan.erp.nomina.business.logic.EmpleadoIdiomaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmpleadoIdiomaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpleadoIdiomaLogic.class);
	
	protected EmpleadoIdiomaDataAccess empleadoidiomaDataAccess; 	
	protected EmpleadoIdioma empleadoidioma;
	protected List<EmpleadoIdioma> empleadoidiomas;
	protected Object empleadoidiomaObject;	
	protected List<Object> empleadoidiomasObject;
	
	public static ClassValidator<EmpleadoIdioma> empleadoidiomaValidator = new ClassValidator<EmpleadoIdioma>(EmpleadoIdioma.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpleadoIdiomaLogicAdditional empleadoidiomaLogicAdditional=null;
	
	public EmpleadoIdiomaLogicAdditional getEmpleadoIdiomaLogicAdditional() {
		return this.empleadoidiomaLogicAdditional;
	}
	
	public void setEmpleadoIdiomaLogicAdditional(EmpleadoIdiomaLogicAdditional empleadoidiomaLogicAdditional) {
		try {
			this.empleadoidiomaLogicAdditional=empleadoidiomaLogicAdditional;
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
	
	
	
	
	public  EmpleadoIdiomaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empleadoidiomaDataAccess = new EmpleadoIdiomaDataAccess();
			
			this.empleadoidiomas= new ArrayList<EmpleadoIdioma>();
			this.empleadoidioma= new EmpleadoIdioma();
			
			this.empleadoidiomaObject=new Object();
			this.empleadoidiomasObject=new ArrayList<Object>();
				
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
			
			this.empleadoidiomaDataAccess.setConnexionType(this.connexionType);
			this.empleadoidiomaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpleadoIdiomaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empleadoidiomaDataAccess = new EmpleadoIdiomaDataAccess();
			this.empleadoidiomas= new ArrayList<EmpleadoIdioma>();
			this.empleadoidioma= new EmpleadoIdioma();
			this.empleadoidiomaObject=new Object();
			this.empleadoidiomasObject=new ArrayList<Object>();
			
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
			
			this.empleadoidiomaDataAccess.setConnexionType(this.connexionType);
			this.empleadoidiomaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EmpleadoIdioma getEmpleadoIdioma() throws Exception {	
		EmpleadoIdiomaLogicAdditional.checkEmpleadoIdiomaToGet(empleadoidioma,this.datosCliente,this.arrDatoGeneral);
		EmpleadoIdiomaLogicAdditional.updateEmpleadoIdiomaToGet(empleadoidioma,this.arrDatoGeneral);
		
		return empleadoidioma;
	}
		
	public void setEmpleadoIdioma(EmpleadoIdioma newEmpleadoIdioma) {
		this.empleadoidioma = newEmpleadoIdioma;
	}
	
	public EmpleadoIdiomaDataAccess getEmpleadoIdiomaDataAccess() {
		return empleadoidiomaDataAccess;
	}
	
	public void setEmpleadoIdiomaDataAccess(EmpleadoIdiomaDataAccess newempleadoidiomaDataAccess) {
		this.empleadoidiomaDataAccess = newempleadoidiomaDataAccess;
	}
	
	public List<EmpleadoIdioma> getEmpleadoIdiomas() throws Exception {		
		this.quitarEmpleadoIdiomasNulos();
		
		EmpleadoIdiomaLogicAdditional.checkEmpleadoIdiomaToGets(empleadoidiomas,this.datosCliente,this.arrDatoGeneral);
		
		for (EmpleadoIdioma empleadoidiomaLocal: empleadoidiomas ) {
			EmpleadoIdiomaLogicAdditional.updateEmpleadoIdiomaToGet(empleadoidiomaLocal,this.arrDatoGeneral);
		}
		
		return empleadoidiomas;
	}
	
	public void setEmpleadoIdiomas(List<EmpleadoIdioma> newEmpleadoIdiomas) {
		this.empleadoidiomas = newEmpleadoIdiomas;
	}
	
	public Object getEmpleadoIdiomaObject() {	
		this.empleadoidiomaObject=this.empleadoidiomaDataAccess.getEntityObject();
		return this.empleadoidiomaObject;
	}
		
	public void setEmpleadoIdiomaObject(Object newEmpleadoIdiomaObject) {
		this.empleadoidiomaObject = newEmpleadoIdiomaObject;
	}
	
	public List<Object> getEmpleadoIdiomasObject() {		
		this.empleadoidiomasObject=this.empleadoidiomaDataAccess.getEntitiesObject();
		return this.empleadoidiomasObject;
	}
		
	public void setEmpleadoIdiomasObject(List<Object> newEmpleadoIdiomasObject) {
		this.empleadoidiomasObject = newEmpleadoIdiomasObject;
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
		
		if(this.empleadoidiomaDataAccess!=null) {
			this.empleadoidiomaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empleadoidiomaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empleadoidiomaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empleadoidioma = new  EmpleadoIdioma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoidioma=empleadoidiomaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoidioma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidioma);
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
		empleadoidioma = new  EmpleadoIdioma();
		  		  
        try {
			
			empleadoidioma=empleadoidiomaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoidioma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidioma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empleadoidioma = new  EmpleadoIdioma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoidioma=empleadoidiomaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoidioma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidioma);
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
		empleadoidioma = new  EmpleadoIdioma();
		  		  
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
		empleadoidioma = new  EmpleadoIdioma();
		  		  
        try {
			
			empleadoidioma=empleadoidiomaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoidioma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidioma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empleadoidioma = new  EmpleadoIdioma();
		  		  
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
		empleadoidioma = new  EmpleadoIdioma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empleadoidiomaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoidioma = new  EmpleadoIdioma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empleadoidiomaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoidioma = new  EmpleadoIdioma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empleadoidiomaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoidioma = new  EmpleadoIdioma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empleadoidiomaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoidioma = new  EmpleadoIdioma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empleadoidiomaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoidioma = new  EmpleadoIdioma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empleadoidiomaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoidiomas = new  ArrayList<EmpleadoIdioma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoIdioma(empleadoidiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
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
		empleadoidiomas = new  ArrayList<EmpleadoIdioma>();
		  		  
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
		empleadoidiomas = new  ArrayList<EmpleadoIdioma>();
		  		  
        try {			
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpleadoIdioma(empleadoidiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empleadoidiomas = new  ArrayList<EmpleadoIdioma>();
		  		  
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
		empleadoidiomas = new  ArrayList<EmpleadoIdioma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoIdioma(empleadoidiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
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
		empleadoidiomas = new  ArrayList<EmpleadoIdioma>();
		  		  
        try {
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoIdioma(empleadoidiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
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
		empleadoidiomas = new  ArrayList<EmpleadoIdioma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoIdioma(empleadoidiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
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
		empleadoidiomas = new  ArrayList<EmpleadoIdioma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoIdioma(empleadoidiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empleadoidioma = new  EmpleadoIdioma();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoidioma=empleadoidiomaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoIdioma(empleadoidioma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidioma);
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
		empleadoidioma = new  EmpleadoIdioma();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoidioma=empleadoidiomaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoIdioma(empleadoidioma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidioma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoidiomas = new  ArrayList<EmpleadoIdioma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoidiomas=empleadoidiomaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoIdioma(empleadoidiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
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
		empleadoidiomas = new  ArrayList<EmpleadoIdioma>();
		  		  
        try {
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoidiomas=empleadoidiomaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoIdioma(empleadoidiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpleadoIdiomasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoidiomas = new  ArrayList<EmpleadoIdioma>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getTodosEmpleadoIdiomasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoIdioma(empleadoidiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
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
	
	public  void  getTodosEmpleadoIdiomas(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoidiomas = new  ArrayList<EmpleadoIdioma>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoIdioma(empleadoidiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpleadoIdioma(EmpleadoIdioma empleadoidioma) throws Exception {
		Boolean estaValidado=false;
		
		if(empleadoidioma.getIsNew() || empleadoidioma.getIsChanged()) { 
			this.invalidValues = empleadoidiomaValidator.getInvalidValues(empleadoidioma);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empleadoidioma);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpleadoIdioma(List<EmpleadoIdioma> EmpleadoIdiomas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EmpleadoIdioma empleadoidiomaLocal:empleadoidiomas) {				
			estaValidadoObjeto=this.validarGuardarEmpleadoIdioma(empleadoidiomaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpleadoIdioma(List<EmpleadoIdioma> EmpleadoIdiomas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoIdioma(empleadoidiomas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpleadoIdioma(EmpleadoIdioma EmpleadoIdioma) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoIdioma(empleadoidioma)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EmpleadoIdioma empleadoidioma) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empleadoidioma.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpleadoIdiomaConstantesFunciones.getEmpleadoIdiomaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empleadoidioma","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpleadoIdiomaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpleadoIdiomaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpleadoIdiomaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-saveEmpleadoIdiomaWithConnection");connexion.begin();			
			
			EmpleadoIdiomaLogicAdditional.checkEmpleadoIdiomaToSave(this.empleadoidioma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoIdiomaLogicAdditional.updateEmpleadoIdiomaToSave(this.empleadoidioma,this.arrDatoGeneral);
			
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoidioma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoIdioma();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoIdioma(this.empleadoidioma)) {
				EmpleadoIdiomaDataAccess.save(this.empleadoidioma, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empleadoidioma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoIdiomaLogicAdditional.checkEmpleadoIdiomaToSaveAfter(this.empleadoidioma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoIdioma();
			
			connexion.commit();			
			
			if(this.empleadoidioma.getIsDeleted()) {
				this.empleadoidioma=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpleadoIdioma()throws Exception {	
		try {	
			
			EmpleadoIdiomaLogicAdditional.checkEmpleadoIdiomaToSave(this.empleadoidioma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoIdiomaLogicAdditional.updateEmpleadoIdiomaToSave(this.empleadoidioma,this.arrDatoGeneral);
			
			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoidioma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoIdioma(this.empleadoidioma)) {			
				EmpleadoIdiomaDataAccess.save(this.empleadoidioma, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empleadoidioma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoIdiomaLogicAdditional.checkEmpleadoIdiomaToSaveAfter(this.empleadoidioma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empleadoidioma.getIsDeleted()) {
				this.empleadoidioma=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpleadoIdiomasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-saveEmpleadoIdiomasWithConnection");connexion.begin();			
			
			EmpleadoIdiomaLogicAdditional.checkEmpleadoIdiomaToSaves(empleadoidiomas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoIdiomas();
			
			Boolean validadoTodosEmpleadoIdioma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoIdioma empleadoidiomaLocal:empleadoidiomas) {		
				if(empleadoidiomaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoIdiomaLogicAdditional.updateEmpleadoIdiomaToSave(empleadoidiomaLocal,this.arrDatoGeneral);
	        	
				EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoidiomaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoIdioma(empleadoidiomaLocal)) {
					EmpleadoIdiomaDataAccess.save(empleadoidiomaLocal, connexion);				
				} else {
					validadoTodosEmpleadoIdioma=false;
				}
			}
			
			if(!validadoTodosEmpleadoIdioma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoIdiomaLogicAdditional.checkEmpleadoIdiomaToSavesAfter(empleadoidiomas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoIdiomas();
			
			connexion.commit();		
			
			this.quitarEmpleadoIdiomasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpleadoIdiomas()throws Exception {				
		 try {	
			EmpleadoIdiomaLogicAdditional.checkEmpleadoIdiomaToSaves(empleadoidiomas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpleadoIdioma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoIdioma empleadoidiomaLocal:empleadoidiomas) {				
				if(empleadoidiomaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoIdiomaLogicAdditional.updateEmpleadoIdiomaToSave(empleadoidiomaLocal,this.arrDatoGeneral);
	        	
				EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoidiomaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoIdioma(empleadoidiomaLocal)) {				
					EmpleadoIdiomaDataAccess.save(empleadoidiomaLocal, connexion);				
				} else {
					validadoTodosEmpleadoIdioma=false;
				}
			}
			
			if(!validadoTodosEmpleadoIdioma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoIdiomaLogicAdditional.checkEmpleadoIdiomaToSavesAfter(empleadoidiomas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpleadoIdiomasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoIdiomaParameterReturnGeneral procesarAccionEmpleadoIdiomas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoIdioma> empleadoidiomas,EmpleadoIdiomaParameterReturnGeneral empleadoidiomaParameterGeneral)throws Exception {
		 try {	
			EmpleadoIdiomaParameterReturnGeneral empleadoidiomaReturnGeneral=new EmpleadoIdiomaParameterReturnGeneral();
	
			EmpleadoIdiomaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoidiomas,empleadoidiomaParameterGeneral,empleadoidiomaReturnGeneral);
			
			return empleadoidiomaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoIdiomaParameterReturnGeneral procesarAccionEmpleadoIdiomasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoIdioma> empleadoidiomas,EmpleadoIdiomaParameterReturnGeneral empleadoidiomaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-procesarAccionEmpleadoIdiomasWithConnection");connexion.begin();			
			
			EmpleadoIdiomaParameterReturnGeneral empleadoidiomaReturnGeneral=new EmpleadoIdiomaParameterReturnGeneral();
	
			EmpleadoIdiomaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoidiomas,empleadoidiomaParameterGeneral,empleadoidiomaReturnGeneral);
			
			this.connexion.commit();
			
			return empleadoidiomaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoIdiomaParameterReturnGeneral procesarEventosEmpleadoIdiomas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoIdioma> empleadoidiomas,EmpleadoIdioma empleadoidioma,EmpleadoIdiomaParameterReturnGeneral empleadoidiomaParameterGeneral,Boolean isEsNuevoEmpleadoIdioma,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpleadoIdiomaParameterReturnGeneral empleadoidiomaReturnGeneral=new EmpleadoIdiomaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoidiomaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoIdiomaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoidiomas,empleadoidioma,empleadoidiomaParameterGeneral,empleadoidiomaReturnGeneral,isEsNuevoEmpleadoIdioma,clases);
			
			return empleadoidiomaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpleadoIdiomaParameterReturnGeneral procesarEventosEmpleadoIdiomasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoIdioma> empleadoidiomas,EmpleadoIdioma empleadoidioma,EmpleadoIdiomaParameterReturnGeneral empleadoidiomaParameterGeneral,Boolean isEsNuevoEmpleadoIdioma,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-procesarEventosEmpleadoIdiomasWithConnection");connexion.begin();			
			
			EmpleadoIdiomaParameterReturnGeneral empleadoidiomaReturnGeneral=new EmpleadoIdiomaParameterReturnGeneral();
	
			empleadoidiomaReturnGeneral.setEmpleadoIdioma(empleadoidioma);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoidiomaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoIdiomaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoidiomas,empleadoidioma,empleadoidiomaParameterGeneral,empleadoidiomaReturnGeneral,isEsNuevoEmpleadoIdioma,clases);
			
			this.connexion.commit();
			
			return empleadoidiomaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoIdiomaParameterReturnGeneral procesarImportacionEmpleadoIdiomasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpleadoIdiomaParameterReturnGeneral empleadoidiomaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-procesarImportacionEmpleadoIdiomasWithConnection");connexion.begin();			
			
			EmpleadoIdiomaParameterReturnGeneral empleadoidiomaReturnGeneral=new EmpleadoIdiomaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empleadoidiomas=new ArrayList<EmpleadoIdioma>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empleadoidioma=new EmpleadoIdioma();
				
				
				if(conColumnasBase) {this.empleadoidioma.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empleadoidioma.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empleadoidioma.setes_materna(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.empleadoidioma.setes_tecnico(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.empleadoidioma.setporcen_tecnico(Integer.parseInt(arrColumnas[iColumn++]));
				this.empleadoidioma.setes_lectura(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.empleadoidioma.setporcen_lectura(Integer.parseInt(arrColumnas[iColumn++]));
				this.empleadoidioma.setes_escrito(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.empleadoidioma.setporcen_escrito(Integer.parseInt(arrColumnas[iColumn++]));
				this.empleadoidioma.setes_hablado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.empleadoidioma.setporcen_hablado(Integer.parseInt(arrColumnas[iColumn++]));
				this.empleadoidioma.setdescripcion(arrColumnas[iColumn++]);
				
				this.empleadoidiomas.add(this.empleadoidioma);
			}
			
			this.saveEmpleadoIdiomas();
			
			this.connexion.commit();
			
			empleadoidiomaReturnGeneral.setConRetornoEstaProcesado(true);
			empleadoidiomaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empleadoidiomaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpleadoIdiomasEliminados() throws Exception {				
		
		List<EmpleadoIdioma> empleadoidiomasAux= new ArrayList<EmpleadoIdioma>();
		
		for(EmpleadoIdioma empleadoidioma:empleadoidiomas) {
			if(!empleadoidioma.getIsDeleted()) {
				empleadoidiomasAux.add(empleadoidioma);
			}
		}
		
		empleadoidiomas=empleadoidiomasAux;
	}
	
	public void quitarEmpleadoIdiomasNulos() throws Exception {				
		
		List<EmpleadoIdioma> empleadoidiomasAux= new ArrayList<EmpleadoIdioma>();
		
		for(EmpleadoIdioma empleadoidioma : this.empleadoidiomas) {
			if(empleadoidioma==null) {
				empleadoidiomasAux.add(empleadoidioma);
			}
		}
		
		//this.empleadoidiomas=empleadoidiomasAux;
		
		this.empleadoidiomas.removeAll(empleadoidiomasAux);
	}
	
	public void getSetVersionRowEmpleadoIdiomaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empleadoidioma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empleadoidioma.getIsDeleted() || (empleadoidioma.getIsChanged()&&!empleadoidioma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empleadoidiomaDataAccess.getSetVersionRowEmpleadoIdioma(connexion,empleadoidioma.getId());
				
				if(!empleadoidioma.getVersionRow().equals(timestamp)) {	
					empleadoidioma.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empleadoidioma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpleadoIdioma()throws Exception {	
		
		if(empleadoidioma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empleadoidioma.getIsDeleted() || (empleadoidioma.getIsChanged()&&!empleadoidioma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empleadoidiomaDataAccess.getSetVersionRowEmpleadoIdioma(connexion,empleadoidioma.getId());
			
			try {							
				if(!empleadoidioma.getVersionRow().equals(timestamp)) {	
					empleadoidioma.setVersionRow(timestamp);
				}
				
				empleadoidioma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpleadoIdiomasWithConnection()throws Exception {	
		if(empleadoidiomas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EmpleadoIdioma empleadoidiomaAux:empleadoidiomas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empleadoidiomaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoidiomaAux.getIsDeleted() || (empleadoidiomaAux.getIsChanged()&&!empleadoidiomaAux.getIsNew())) {
						
						timestamp=empleadoidiomaDataAccess.getSetVersionRowEmpleadoIdioma(connexion,empleadoidiomaAux.getId());
						
						if(!empleadoidioma.getVersionRow().equals(timestamp)) {	
							empleadoidiomaAux.setVersionRow(timestamp);
						}
								
						empleadoidiomaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpleadoIdiomas()throws Exception {	
		if(empleadoidiomas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EmpleadoIdioma empleadoidiomaAux:empleadoidiomas) {
					if(empleadoidiomaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoidiomaAux.getIsDeleted() || (empleadoidiomaAux.getIsChanged()&&!empleadoidiomaAux.getIsNew())) {
						
						timestamp=empleadoidiomaDataAccess.getSetVersionRowEmpleadoIdioma(connexion,empleadoidiomaAux.getId());
						
						if(!empleadoidiomaAux.getVersionRow().equals(timestamp)) {	
							empleadoidiomaAux.setVersionRow(timestamp);
						}
						
													
						empleadoidiomaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpleadoIdiomaParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoIdiomaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalIdioma) throws Exception {
		EmpleadoIdiomaParameterReturnGeneral  empleadoidiomaReturnGeneral =new EmpleadoIdiomaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpleadoIdiomaWithConnection");connexion.begin();
			
			empleadoidiomaReturnGeneral =new EmpleadoIdiomaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoidiomaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoidiomaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Idioma> idiomasForeignKey=new ArrayList<Idioma>();
			IdiomaLogic idiomaLogic=new IdiomaLogic();
			idiomaLogic.setConnexion(this.connexion);
			idiomaLogic.getIdiomaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalIdioma.equals("NONE")) {
				idiomaLogic.getTodosIdiomas(finalQueryGlobalIdioma,new Pagination());
				idiomasForeignKey=idiomaLogic.getIdiomas();
			}

			empleadoidiomaReturnGeneral.setidiomasForeignKey(idiomasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empleadoidiomaReturnGeneral;
	}
	
	public EmpleadoIdiomaParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoIdioma(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalIdioma) throws Exception {
		EmpleadoIdiomaParameterReturnGeneral  empleadoidiomaReturnGeneral =new EmpleadoIdiomaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empleadoidiomaReturnGeneral =new EmpleadoIdiomaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoidiomaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoidiomaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Idioma> idiomasForeignKey=new ArrayList<Idioma>();
			IdiomaLogic idiomaLogic=new IdiomaLogic();
			idiomaLogic.setConnexion(this.connexion);
			idiomaLogic.getIdiomaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalIdioma.equals("NONE")) {
				idiomaLogic.getTodosIdiomas(finalQueryGlobalIdioma,new Pagination());
				idiomasForeignKey=idiomaLogic.getIdiomas();
			}

			empleadoidiomaReturnGeneral.setidiomasForeignKey(idiomasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empleadoidiomaReturnGeneral;
	}
	
	
	public void deepLoad(EmpleadoIdioma empleadoidioma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpleadoIdiomaLogicAdditional.updateEmpleadoIdiomaToGet(empleadoidioma,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoidioma.setEmpresa(empleadoidiomaDataAccess.getEmpresa(connexion,empleadoidioma));
		empleadoidioma.setEmpleado(empleadoidiomaDataAccess.getEmpleado(connexion,empleadoidioma));
		empleadoidioma.setIdioma(empleadoidiomaDataAccess.getIdioma(connexion,empleadoidioma));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoidioma.setEmpresa(empleadoidiomaDataAccess.getEmpresa(connexion,empleadoidioma));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoidioma.setEmpleado(empleadoidiomaDataAccess.getEmpleado(connexion,empleadoidioma));
				continue;
			}

			if(clas.clas.equals(Idioma.class)) {
				empleadoidioma.setIdioma(empleadoidiomaDataAccess.getIdioma(connexion,empleadoidioma));
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
			empleadoidioma.setEmpresa(empleadoidiomaDataAccess.getEmpresa(connexion,empleadoidioma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoidioma.setEmpleado(empleadoidiomaDataAccess.getEmpleado(connexion,empleadoidioma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Idioma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoidioma.setIdioma(empleadoidiomaDataAccess.getIdioma(connexion,empleadoidioma));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoidioma.setEmpresa(empleadoidiomaDataAccess.getEmpresa(connexion,empleadoidioma));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoidioma.getEmpresa(),isDeep,deepLoadType,clases);
				
		empleadoidioma.setEmpleado(empleadoidiomaDataAccess.getEmpleado(connexion,empleadoidioma));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoidioma.getEmpleado(),isDeep,deepLoadType,clases);
				
		empleadoidioma.setIdioma(empleadoidiomaDataAccess.getIdioma(connexion,empleadoidioma));
		IdiomaLogic idiomaLogic= new IdiomaLogic(connexion);
		idiomaLogic.deepLoad(empleadoidioma.getIdioma(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoidioma.setEmpresa(empleadoidiomaDataAccess.getEmpresa(connexion,empleadoidioma));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(empleadoidioma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoidioma.setEmpleado(empleadoidiomaDataAccess.getEmpleado(connexion,empleadoidioma));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleadoidioma.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Idioma.class)) {
				empleadoidioma.setIdioma(empleadoidiomaDataAccess.getIdioma(connexion,empleadoidioma));
				IdiomaLogic idiomaLogic= new IdiomaLogic(connexion);
				idiomaLogic.deepLoad(empleadoidioma.getIdioma(),isDeep,deepLoadType,clases);				
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
			empleadoidioma.setEmpresa(empleadoidiomaDataAccess.getEmpresa(connexion,empleadoidioma));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(empleadoidioma.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoidioma.setEmpleado(empleadoidiomaDataAccess.getEmpleado(connexion,empleadoidioma));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleadoidioma.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Idioma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoidioma.setIdioma(empleadoidiomaDataAccess.getIdioma(connexion,empleadoidioma));
			IdiomaLogic idiomaLogic= new IdiomaLogic(connexion);
			idiomaLogic.deepLoad(empleadoidioma.getIdioma(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EmpleadoIdioma empleadoidioma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpleadoIdiomaLogicAdditional.updateEmpleadoIdiomaToSave(empleadoidioma,this.arrDatoGeneral);
			
EmpleadoIdiomaDataAccess.save(empleadoidioma, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoidioma.getEmpresa(),connexion);

		EmpleadoDataAccess.save(empleadoidioma.getEmpleado(),connexion);

		IdiomaDataAccess.save(empleadoidioma.getIdioma(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoidioma.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoidioma.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Idioma.class)) {
				IdiomaDataAccess.save(empleadoidioma.getIdioma(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoidioma.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoidioma.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(empleadoidioma.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoidioma.getEmpleado(),isDeep,deepLoadType,clases);
				

		IdiomaDataAccess.save(empleadoidioma.getIdioma(),connexion);
		IdiomaLogic idiomaLogic= new IdiomaLogic(connexion);
		idiomaLogic.deepLoad(empleadoidioma.getIdioma(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoidioma.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(empleadoidioma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoidioma.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(empleadoidioma.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Idioma.class)) {
				IdiomaDataAccess.save(empleadoidioma.getIdioma(),connexion);
				IdiomaLogic idiomaLogic= new IdiomaLogic(connexion);
				idiomaLogic.deepSave(empleadoidioma.getIdioma(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(EmpleadoIdioma.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empleadoidioma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(empleadoidioma);
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
			this.deepLoad(this.empleadoidioma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidioma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EmpleadoIdioma.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empleadoidiomas!=null) {
				for(EmpleadoIdioma empleadoidioma:empleadoidiomas) {
					this.deepLoad(empleadoidioma,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(empleadoidiomas);
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
			if(empleadoidiomas!=null) {
				for(EmpleadoIdioma empleadoidioma:empleadoidiomas) {
					this.deepLoad(empleadoidioma,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(empleadoidiomas);
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
			this.getNewConnexionToDeep(EmpleadoIdioma.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empleadoidioma,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EmpleadoIdioma.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empleadoidiomas!=null) {
				for(EmpleadoIdioma empleadoidioma:empleadoidiomas) {
					this.deepSave(empleadoidioma,isDeep,deepLoadType,clases);
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
			if(empleadoidiomas!=null) {
				for(EmpleadoIdioma empleadoidioma:empleadoidiomas) {
					this.deepSave(empleadoidioma,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpleadoIdiomasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoIdiomaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoIdiomasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoIdiomaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoIdiomasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoIdiomaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoIdiomasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoIdiomaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoIdiomasFK_IdIdiomaWithConnection(String sFinalQuery,Pagination pagination,Long id_idioma)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoIdioma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidIdioma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidIdioma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_idioma,EmpleadoIdiomaConstantesFunciones.IDIDIOMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidIdioma);

			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdIdioma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoIdiomasFK_IdIdioma(String sFinalQuery,Pagination pagination,Long id_idioma)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidIdioma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidIdioma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_idioma,EmpleadoIdiomaConstantesFunciones.IDIDIOMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidIdioma);

			EmpleadoIdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdIdioma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(this.empleadoidiomas);
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
			if(EmpleadoIdiomaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoIdiomaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EmpleadoIdioma empleadoidioma,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpleadoIdiomaConstantesFunciones.ISCONAUDITORIA) {
				if(empleadoidioma.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoIdiomaDataAccess.TABLENAME, empleadoidioma.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoIdiomaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoIdiomaLogic.registrarAuditoriaDetallesEmpleadoIdioma(connexion,empleadoidioma,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empleadoidioma.getIsDeleted()) {
					/*if(!empleadoidioma.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpleadoIdiomaDataAccess.TABLENAME, empleadoidioma.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpleadoIdiomaLogic.registrarAuditoriaDetallesEmpleadoIdioma(connexion,empleadoidioma,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoIdiomaDataAccess.TABLENAME, empleadoidioma.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empleadoidioma.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoIdiomaDataAccess.TABLENAME, empleadoidioma.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoIdiomaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoIdiomaLogic.registrarAuditoriaDetallesEmpleadoIdioma(connexion,empleadoidioma,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpleadoIdioma(Connexion connexion,EmpleadoIdioma empleadoidioma)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getid_empresa().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getid_empresa()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getid_empresa().toString();
				}
				if(empleadoidioma.getid_empresa()!=null)
				{
					strValorNuevo=empleadoidioma.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getid_empleado().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getid_empleado()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getid_empleado().toString();
				}
				if(empleadoidioma.getid_empleado()!=null)
				{
					strValorNuevo=empleadoidioma.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getid_idioma().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getid_idioma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getid_idioma()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getid_idioma().toString();
				}
				if(empleadoidioma.getid_idioma()!=null)
				{
					strValorNuevo=empleadoidioma.getid_idioma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.IDIDIOMA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getes_materna().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getes_materna()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getes_materna()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getes_materna().toString();
				}
				if(empleadoidioma.getes_materna()!=null)
				{
					strValorNuevo=empleadoidioma.getes_materna().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.ESMATERNA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getes_tecnico().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getes_tecnico()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getes_tecnico()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getes_tecnico().toString();
				}
				if(empleadoidioma.getes_tecnico()!=null)
				{
					strValorNuevo=empleadoidioma.getes_tecnico().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.ESTECNICO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getporcen_tecnico().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getporcen_tecnico()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getporcen_tecnico()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getporcen_tecnico().toString();
				}
				if(empleadoidioma.getporcen_tecnico()!=null)
				{
					strValorNuevo=empleadoidioma.getporcen_tecnico().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.PORCENTECNICO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getes_lectura().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getes_lectura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getes_lectura()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getes_lectura().toString();
				}
				if(empleadoidioma.getes_lectura()!=null)
				{
					strValorNuevo=empleadoidioma.getes_lectura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.ESLECTURA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getporcen_lectura().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getporcen_lectura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getporcen_lectura()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getporcen_lectura().toString();
				}
				if(empleadoidioma.getporcen_lectura()!=null)
				{
					strValorNuevo=empleadoidioma.getporcen_lectura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.PORCENLECTURA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getes_escrito().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getes_escrito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getes_escrito()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getes_escrito().toString();
				}
				if(empleadoidioma.getes_escrito()!=null)
				{
					strValorNuevo=empleadoidioma.getes_escrito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.ESESCRITO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getporcen_escrito().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getporcen_escrito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getporcen_escrito()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getporcen_escrito().toString();
				}
				if(empleadoidioma.getporcen_escrito()!=null)
				{
					strValorNuevo=empleadoidioma.getporcen_escrito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.PORCENESCRITO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getes_hablado().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getes_hablado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getes_hablado()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getes_hablado().toString();
				}
				if(empleadoidioma.getes_hablado()!=null)
				{
					strValorNuevo=empleadoidioma.getes_hablado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.ESHABLADO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getporcen_hablado().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getporcen_hablado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getporcen_hablado()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getporcen_hablado().toString();
				}
				if(empleadoidioma.getporcen_hablado()!=null)
				{
					strValorNuevo=empleadoidioma.getporcen_hablado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.PORCENHABLADO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoidioma.getIsNew()||!empleadoidioma.getdescripcion().equals(empleadoidioma.getEmpleadoIdiomaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoidioma.getEmpleadoIdiomaOriginal().getdescripcion()!=null)
				{
					strValorActual=empleadoidioma.getEmpleadoIdiomaOriginal().getdescripcion();
				}
				if(empleadoidioma.getdescripcion()!=null)
				{
					strValorNuevo=empleadoidioma.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoIdiomaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpleadoIdiomaRelacionesWithConnection(EmpleadoIdioma empleadoidioma) throws Exception {

		if(!empleadoidioma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoIdiomaRelacionesBase(empleadoidioma,true);
		}
	}

	public void saveEmpleadoIdiomaRelaciones(EmpleadoIdioma empleadoidioma)throws Exception {

		if(!empleadoidioma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoIdiomaRelacionesBase(empleadoidioma,false);
		}
	}

	public void saveEmpleadoIdiomaRelacionesBase(EmpleadoIdioma empleadoidioma,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EmpleadoIdioma-saveRelacionesWithConnection");}
	

			this.setEmpleadoIdioma(empleadoidioma);

			if(EmpleadoIdiomaLogicAdditional.validarSaveRelaciones(empleadoidioma,this)) {

				EmpleadoIdiomaLogicAdditional.updateRelacionesToSave(empleadoidioma,this);

				if((empleadoidioma.getIsNew()||empleadoidioma.getIsChanged())&&!empleadoidioma.getIsDeleted()) {
					this.saveEmpleadoIdioma();
					this.saveEmpleadoIdiomaRelacionesDetalles();

				} else if(empleadoidioma.getIsDeleted()) {
					this.saveEmpleadoIdiomaRelacionesDetalles();
					this.saveEmpleadoIdioma();
				}

				EmpleadoIdiomaLogicAdditional.updateRelacionesToSaveAfter(empleadoidioma,this);

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
	
	
	private void saveEmpleadoIdiomaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoIdioma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoIdiomaConstantesFunciones.getClassesForeignKeysOfEmpleadoIdioma(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoIdioma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoIdiomaConstantesFunciones.getClassesRelationshipsOfEmpleadoIdioma(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

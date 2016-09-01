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
import com.bydan.erp.nomina.util.EmpleadoHobbyConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoHobbyParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoHobbyParameterGeneral;
import com.bydan.erp.nomina.business.entity.EmpleadoHobby;
import com.bydan.erp.nomina.business.logic.EmpleadoHobbyLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmpleadoHobbyLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpleadoHobbyLogic.class);
	
	protected EmpleadoHobbyDataAccess empleadohobbyDataAccess; 	
	protected EmpleadoHobby empleadohobby;
	protected List<EmpleadoHobby> empleadohobbys;
	protected Object empleadohobbyObject;	
	protected List<Object> empleadohobbysObject;
	
	public static ClassValidator<EmpleadoHobby> empleadohobbyValidator = new ClassValidator<EmpleadoHobby>(EmpleadoHobby.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpleadoHobbyLogicAdditional empleadohobbyLogicAdditional=null;
	
	public EmpleadoHobbyLogicAdditional getEmpleadoHobbyLogicAdditional() {
		return this.empleadohobbyLogicAdditional;
	}
	
	public void setEmpleadoHobbyLogicAdditional(EmpleadoHobbyLogicAdditional empleadohobbyLogicAdditional) {
		try {
			this.empleadohobbyLogicAdditional=empleadohobbyLogicAdditional;
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
	
	
	
	
	public  EmpleadoHobbyLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empleadohobbyDataAccess = new EmpleadoHobbyDataAccess();
			
			this.empleadohobbys= new ArrayList<EmpleadoHobby>();
			this.empleadohobby= new EmpleadoHobby();
			
			this.empleadohobbyObject=new Object();
			this.empleadohobbysObject=new ArrayList<Object>();
				
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
			
			this.empleadohobbyDataAccess.setConnexionType(this.connexionType);
			this.empleadohobbyDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpleadoHobbyLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empleadohobbyDataAccess = new EmpleadoHobbyDataAccess();
			this.empleadohobbys= new ArrayList<EmpleadoHobby>();
			this.empleadohobby= new EmpleadoHobby();
			this.empleadohobbyObject=new Object();
			this.empleadohobbysObject=new ArrayList<Object>();
			
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
			
			this.empleadohobbyDataAccess.setConnexionType(this.connexionType);
			this.empleadohobbyDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EmpleadoHobby getEmpleadoHobby() throws Exception {	
		EmpleadoHobbyLogicAdditional.checkEmpleadoHobbyToGet(empleadohobby,this.datosCliente,this.arrDatoGeneral);
		EmpleadoHobbyLogicAdditional.updateEmpleadoHobbyToGet(empleadohobby,this.arrDatoGeneral);
		
		return empleadohobby;
	}
		
	public void setEmpleadoHobby(EmpleadoHobby newEmpleadoHobby) {
		this.empleadohobby = newEmpleadoHobby;
	}
	
	public EmpleadoHobbyDataAccess getEmpleadoHobbyDataAccess() {
		return empleadohobbyDataAccess;
	}
	
	public void setEmpleadoHobbyDataAccess(EmpleadoHobbyDataAccess newempleadohobbyDataAccess) {
		this.empleadohobbyDataAccess = newempleadohobbyDataAccess;
	}
	
	public List<EmpleadoHobby> getEmpleadoHobbys() throws Exception {		
		this.quitarEmpleadoHobbysNulos();
		
		EmpleadoHobbyLogicAdditional.checkEmpleadoHobbyToGets(empleadohobbys,this.datosCliente,this.arrDatoGeneral);
		
		for (EmpleadoHobby empleadohobbyLocal: empleadohobbys ) {
			EmpleadoHobbyLogicAdditional.updateEmpleadoHobbyToGet(empleadohobbyLocal,this.arrDatoGeneral);
		}
		
		return empleadohobbys;
	}
	
	public void setEmpleadoHobbys(List<EmpleadoHobby> newEmpleadoHobbys) {
		this.empleadohobbys = newEmpleadoHobbys;
	}
	
	public Object getEmpleadoHobbyObject() {	
		this.empleadohobbyObject=this.empleadohobbyDataAccess.getEntityObject();
		return this.empleadohobbyObject;
	}
		
	public void setEmpleadoHobbyObject(Object newEmpleadoHobbyObject) {
		this.empleadohobbyObject = newEmpleadoHobbyObject;
	}
	
	public List<Object> getEmpleadoHobbysObject() {		
		this.empleadohobbysObject=this.empleadohobbyDataAccess.getEntitiesObject();
		return this.empleadohobbysObject;
	}
		
	public void setEmpleadoHobbysObject(List<Object> newEmpleadoHobbysObject) {
		this.empleadohobbysObject = newEmpleadoHobbysObject;
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
		
		if(this.empleadohobbyDataAccess!=null) {
			this.empleadohobbyDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empleadohobbyDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empleadohobbyDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empleadohobby = new  EmpleadoHobby();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadohobby=empleadohobbyDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadohobby,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobby);
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
		empleadohobby = new  EmpleadoHobby();
		  		  
        try {
			
			empleadohobby=empleadohobbyDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadohobby,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobby);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empleadohobby = new  EmpleadoHobby();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadohobby=empleadohobbyDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadohobby,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobby);
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
		empleadohobby = new  EmpleadoHobby();
		  		  
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
		empleadohobby = new  EmpleadoHobby();
		  		  
        try {
			
			empleadohobby=empleadohobbyDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadohobby,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobby);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empleadohobby = new  EmpleadoHobby();
		  		  
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
		empleadohobby = new  EmpleadoHobby();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empleadohobbyDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadohobby = new  EmpleadoHobby();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empleadohobbyDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadohobby = new  EmpleadoHobby();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empleadohobbyDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadohobby = new  EmpleadoHobby();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empleadohobbyDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadohobby = new  EmpleadoHobby();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empleadohobbyDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadohobby = new  EmpleadoHobby();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empleadohobbyDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadohobbys = new  ArrayList<EmpleadoHobby>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoHobby(empleadohobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
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
		empleadohobbys = new  ArrayList<EmpleadoHobby>();
		  		  
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
		empleadohobbys = new  ArrayList<EmpleadoHobby>();
		  		  
        try {			
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpleadoHobby(empleadohobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empleadohobbys = new  ArrayList<EmpleadoHobby>();
		  		  
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
		empleadohobbys = new  ArrayList<EmpleadoHobby>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoHobby(empleadohobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
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
		empleadohobbys = new  ArrayList<EmpleadoHobby>();
		  		  
        try {
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoHobby(empleadohobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
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
		empleadohobbys = new  ArrayList<EmpleadoHobby>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoHobby(empleadohobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
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
		empleadohobbys = new  ArrayList<EmpleadoHobby>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoHobby(empleadohobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empleadohobby = new  EmpleadoHobby();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadohobby=empleadohobbyDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoHobby(empleadohobby);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobby);
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
		empleadohobby = new  EmpleadoHobby();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadohobby=empleadohobbyDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoHobby(empleadohobby);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobby);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadohobbys = new  ArrayList<EmpleadoHobby>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadohobbys=empleadohobbyDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoHobby(empleadohobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
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
		empleadohobbys = new  ArrayList<EmpleadoHobby>();
		  		  
        try {
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadohobbys=empleadohobbyDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoHobby(empleadohobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpleadoHobbysWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empleadohobbys = new  ArrayList<EmpleadoHobby>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getTodosEmpleadoHobbysWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoHobby(empleadohobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
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
	
	public  void  getTodosEmpleadoHobbys(String sFinalQuery,Pagination pagination)throws Exception {
		empleadohobbys = new  ArrayList<EmpleadoHobby>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoHobby(empleadohobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpleadoHobby(EmpleadoHobby empleadohobby) throws Exception {
		Boolean estaValidado=false;
		
		if(empleadohobby.getIsNew() || empleadohobby.getIsChanged()) { 
			this.invalidValues = empleadohobbyValidator.getInvalidValues(empleadohobby);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empleadohobby);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpleadoHobby(List<EmpleadoHobby> EmpleadoHobbys) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EmpleadoHobby empleadohobbyLocal:empleadohobbys) {				
			estaValidadoObjeto=this.validarGuardarEmpleadoHobby(empleadohobbyLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpleadoHobby(List<EmpleadoHobby> EmpleadoHobbys) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoHobby(empleadohobbys)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpleadoHobby(EmpleadoHobby EmpleadoHobby) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoHobby(empleadohobby)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EmpleadoHobby empleadohobby) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empleadohobby.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpleadoHobbyConstantesFunciones.getEmpleadoHobbyLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empleadohobby","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpleadoHobbyConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpleadoHobbyConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpleadoHobbyWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-saveEmpleadoHobbyWithConnection");connexion.begin();			
			
			EmpleadoHobbyLogicAdditional.checkEmpleadoHobbyToSave(this.empleadohobby,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoHobbyLogicAdditional.updateEmpleadoHobbyToSave(this.empleadohobby,this.arrDatoGeneral);
			
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadohobby,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoHobby();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoHobby(this.empleadohobby)) {
				EmpleadoHobbyDataAccess.save(this.empleadohobby, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empleadohobby,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoHobbyLogicAdditional.checkEmpleadoHobbyToSaveAfter(this.empleadohobby,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoHobby();
			
			connexion.commit();			
			
			if(this.empleadohobby.getIsDeleted()) {
				this.empleadohobby=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpleadoHobby()throws Exception {	
		try {	
			
			EmpleadoHobbyLogicAdditional.checkEmpleadoHobbyToSave(this.empleadohobby,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoHobbyLogicAdditional.updateEmpleadoHobbyToSave(this.empleadohobby,this.arrDatoGeneral);
			
			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadohobby,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoHobby(this.empleadohobby)) {			
				EmpleadoHobbyDataAccess.save(this.empleadohobby, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empleadohobby,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoHobbyLogicAdditional.checkEmpleadoHobbyToSaveAfter(this.empleadohobby,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empleadohobby.getIsDeleted()) {
				this.empleadohobby=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpleadoHobbysWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-saveEmpleadoHobbysWithConnection");connexion.begin();			
			
			EmpleadoHobbyLogicAdditional.checkEmpleadoHobbyToSaves(empleadohobbys,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoHobbys();
			
			Boolean validadoTodosEmpleadoHobby=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoHobby empleadohobbyLocal:empleadohobbys) {		
				if(empleadohobbyLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoHobbyLogicAdditional.updateEmpleadoHobbyToSave(empleadohobbyLocal,this.arrDatoGeneral);
	        	
				EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadohobbyLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoHobby(empleadohobbyLocal)) {
					EmpleadoHobbyDataAccess.save(empleadohobbyLocal, connexion);				
				} else {
					validadoTodosEmpleadoHobby=false;
				}
			}
			
			if(!validadoTodosEmpleadoHobby) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoHobbyLogicAdditional.checkEmpleadoHobbyToSavesAfter(empleadohobbys,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoHobbys();
			
			connexion.commit();		
			
			this.quitarEmpleadoHobbysEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpleadoHobbys()throws Exception {				
		 try {	
			EmpleadoHobbyLogicAdditional.checkEmpleadoHobbyToSaves(empleadohobbys,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpleadoHobby=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoHobby empleadohobbyLocal:empleadohobbys) {				
				if(empleadohobbyLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoHobbyLogicAdditional.updateEmpleadoHobbyToSave(empleadohobbyLocal,this.arrDatoGeneral);
	        	
				EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadohobbyLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoHobby(empleadohobbyLocal)) {				
					EmpleadoHobbyDataAccess.save(empleadohobbyLocal, connexion);				
				} else {
					validadoTodosEmpleadoHobby=false;
				}
			}
			
			if(!validadoTodosEmpleadoHobby) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoHobbyLogicAdditional.checkEmpleadoHobbyToSavesAfter(empleadohobbys,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpleadoHobbysEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoHobbyParameterReturnGeneral procesarAccionEmpleadoHobbys(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoHobby> empleadohobbys,EmpleadoHobbyParameterReturnGeneral empleadohobbyParameterGeneral)throws Exception {
		 try {	
			EmpleadoHobbyParameterReturnGeneral empleadohobbyReturnGeneral=new EmpleadoHobbyParameterReturnGeneral();
	
			EmpleadoHobbyLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadohobbys,empleadohobbyParameterGeneral,empleadohobbyReturnGeneral);
			
			return empleadohobbyReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoHobbyParameterReturnGeneral procesarAccionEmpleadoHobbysWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoHobby> empleadohobbys,EmpleadoHobbyParameterReturnGeneral empleadohobbyParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-procesarAccionEmpleadoHobbysWithConnection");connexion.begin();			
			
			EmpleadoHobbyParameterReturnGeneral empleadohobbyReturnGeneral=new EmpleadoHobbyParameterReturnGeneral();
	
			EmpleadoHobbyLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadohobbys,empleadohobbyParameterGeneral,empleadohobbyReturnGeneral);
			
			this.connexion.commit();
			
			return empleadohobbyReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoHobbyParameterReturnGeneral procesarEventosEmpleadoHobbys(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoHobby> empleadohobbys,EmpleadoHobby empleadohobby,EmpleadoHobbyParameterReturnGeneral empleadohobbyParameterGeneral,Boolean isEsNuevoEmpleadoHobby,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpleadoHobbyParameterReturnGeneral empleadohobbyReturnGeneral=new EmpleadoHobbyParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadohobbyReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoHobbyLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadohobbys,empleadohobby,empleadohobbyParameterGeneral,empleadohobbyReturnGeneral,isEsNuevoEmpleadoHobby,clases);
			
			return empleadohobbyReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpleadoHobbyParameterReturnGeneral procesarEventosEmpleadoHobbysWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoHobby> empleadohobbys,EmpleadoHobby empleadohobby,EmpleadoHobbyParameterReturnGeneral empleadohobbyParameterGeneral,Boolean isEsNuevoEmpleadoHobby,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-procesarEventosEmpleadoHobbysWithConnection");connexion.begin();			
			
			EmpleadoHobbyParameterReturnGeneral empleadohobbyReturnGeneral=new EmpleadoHobbyParameterReturnGeneral();
	
			empleadohobbyReturnGeneral.setEmpleadoHobby(empleadohobby);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadohobbyReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoHobbyLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadohobbys,empleadohobby,empleadohobbyParameterGeneral,empleadohobbyReturnGeneral,isEsNuevoEmpleadoHobby,clases);
			
			this.connexion.commit();
			
			return empleadohobbyReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoHobbyParameterReturnGeneral procesarImportacionEmpleadoHobbysWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpleadoHobbyParameterReturnGeneral empleadohobbyParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-procesarImportacionEmpleadoHobbysWithConnection");connexion.begin();			
			
			EmpleadoHobbyParameterReturnGeneral empleadohobbyReturnGeneral=new EmpleadoHobbyParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empleadohobbys=new ArrayList<EmpleadoHobby>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empleadohobby=new EmpleadoHobby();
				
				
				if(conColumnasBase) {this.empleadohobby.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empleadohobby.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.empleadohobbys.add(this.empleadohobby);
			}
			
			this.saveEmpleadoHobbys();
			
			this.connexion.commit();
			
			empleadohobbyReturnGeneral.setConRetornoEstaProcesado(true);
			empleadohobbyReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empleadohobbyReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpleadoHobbysEliminados() throws Exception {				
		
		List<EmpleadoHobby> empleadohobbysAux= new ArrayList<EmpleadoHobby>();
		
		for(EmpleadoHobby empleadohobby:empleadohobbys) {
			if(!empleadohobby.getIsDeleted()) {
				empleadohobbysAux.add(empleadohobby);
			}
		}
		
		empleadohobbys=empleadohobbysAux;
	}
	
	public void quitarEmpleadoHobbysNulos() throws Exception {				
		
		List<EmpleadoHobby> empleadohobbysAux= new ArrayList<EmpleadoHobby>();
		
		for(EmpleadoHobby empleadohobby : this.empleadohobbys) {
			if(empleadohobby==null) {
				empleadohobbysAux.add(empleadohobby);
			}
		}
		
		//this.empleadohobbys=empleadohobbysAux;
		
		this.empleadohobbys.removeAll(empleadohobbysAux);
	}
	
	public void getSetVersionRowEmpleadoHobbyWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empleadohobby.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empleadohobby.getIsDeleted() || (empleadohobby.getIsChanged()&&!empleadohobby.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empleadohobbyDataAccess.getSetVersionRowEmpleadoHobby(connexion,empleadohobby.getId());
				
				if(!empleadohobby.getVersionRow().equals(timestamp)) {	
					empleadohobby.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empleadohobby.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpleadoHobby()throws Exception {	
		
		if(empleadohobby.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empleadohobby.getIsDeleted() || (empleadohobby.getIsChanged()&&!empleadohobby.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empleadohobbyDataAccess.getSetVersionRowEmpleadoHobby(connexion,empleadohobby.getId());
			
			try {							
				if(!empleadohobby.getVersionRow().equals(timestamp)) {	
					empleadohobby.setVersionRow(timestamp);
				}
				
				empleadohobby.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpleadoHobbysWithConnection()throws Exception {	
		if(empleadohobbys!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EmpleadoHobby empleadohobbyAux:empleadohobbys) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empleadohobbyAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadohobbyAux.getIsDeleted() || (empleadohobbyAux.getIsChanged()&&!empleadohobbyAux.getIsNew())) {
						
						timestamp=empleadohobbyDataAccess.getSetVersionRowEmpleadoHobby(connexion,empleadohobbyAux.getId());
						
						if(!empleadohobby.getVersionRow().equals(timestamp)) {	
							empleadohobbyAux.setVersionRow(timestamp);
						}
								
						empleadohobbyAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpleadoHobbys()throws Exception {	
		if(empleadohobbys!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EmpleadoHobby empleadohobbyAux:empleadohobbys) {
					if(empleadohobbyAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadohobbyAux.getIsDeleted() || (empleadohobbyAux.getIsChanged()&&!empleadohobbyAux.getIsNew())) {
						
						timestamp=empleadohobbyDataAccess.getSetVersionRowEmpleadoHobby(connexion,empleadohobbyAux.getId());
						
						if(!empleadohobbyAux.getVersionRow().equals(timestamp)) {	
							empleadohobbyAux.setVersionRow(timestamp);
						}
						
													
						empleadohobbyAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpleadoHobbyParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoHobbyWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalHobby) throws Exception {
		EmpleadoHobbyParameterReturnGeneral  empleadohobbyReturnGeneral =new EmpleadoHobbyParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpleadoHobbyWithConnection");connexion.begin();
			
			empleadohobbyReturnGeneral =new EmpleadoHobbyParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadohobbyReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadohobbyReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Hobby> hobbysForeignKey=new ArrayList<Hobby>();
			HobbyLogic hobbyLogic=new HobbyLogic();
			hobbyLogic.setConnexion(this.connexion);
			hobbyLogic.getHobbyDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalHobby.equals("NONE")) {
				hobbyLogic.getTodosHobbys(finalQueryGlobalHobby,new Pagination());
				hobbysForeignKey=hobbyLogic.getHobbys();
			}

			empleadohobbyReturnGeneral.sethobbysForeignKey(hobbysForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empleadohobbyReturnGeneral;
	}
	
	public EmpleadoHobbyParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoHobby(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalHobby) throws Exception {
		EmpleadoHobbyParameterReturnGeneral  empleadohobbyReturnGeneral =new EmpleadoHobbyParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empleadohobbyReturnGeneral =new EmpleadoHobbyParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadohobbyReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadohobbyReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Hobby> hobbysForeignKey=new ArrayList<Hobby>();
			HobbyLogic hobbyLogic=new HobbyLogic();
			hobbyLogic.setConnexion(this.connexion);
			hobbyLogic.getHobbyDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalHobby.equals("NONE")) {
				hobbyLogic.getTodosHobbys(finalQueryGlobalHobby,new Pagination());
				hobbysForeignKey=hobbyLogic.getHobbys();
			}

			empleadohobbyReturnGeneral.sethobbysForeignKey(hobbysForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empleadohobbyReturnGeneral;
	}
	
	
	public void deepLoad(EmpleadoHobby empleadohobby,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpleadoHobbyLogicAdditional.updateEmpleadoHobbyToGet(empleadohobby,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadohobby.setEmpresa(empleadohobbyDataAccess.getEmpresa(connexion,empleadohobby));
		empleadohobby.setEmpleado(empleadohobbyDataAccess.getEmpleado(connexion,empleadohobby));
		empleadohobby.setHobby(empleadohobbyDataAccess.getHobby(connexion,empleadohobby));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadohobby.setEmpresa(empleadohobbyDataAccess.getEmpresa(connexion,empleadohobby));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadohobby.setEmpleado(empleadohobbyDataAccess.getEmpleado(connexion,empleadohobby));
				continue;
			}

			if(clas.clas.equals(Hobby.class)) {
				empleadohobby.setHobby(empleadohobbyDataAccess.getHobby(connexion,empleadohobby));
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
			empleadohobby.setEmpresa(empleadohobbyDataAccess.getEmpresa(connexion,empleadohobby));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadohobby.setEmpleado(empleadohobbyDataAccess.getEmpleado(connexion,empleadohobby));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Hobby.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadohobby.setHobby(empleadohobbyDataAccess.getHobby(connexion,empleadohobby));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadohobby.setEmpresa(empleadohobbyDataAccess.getEmpresa(connexion,empleadohobby));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadohobby.getEmpresa(),isDeep,deepLoadType,clases);
				
		empleadohobby.setEmpleado(empleadohobbyDataAccess.getEmpleado(connexion,empleadohobby));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadohobby.getEmpleado(),isDeep,deepLoadType,clases);
				
		empleadohobby.setHobby(empleadohobbyDataAccess.getHobby(connexion,empleadohobby));
		HobbyLogic hobbyLogic= new HobbyLogic(connexion);
		hobbyLogic.deepLoad(empleadohobby.getHobby(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadohobby.setEmpresa(empleadohobbyDataAccess.getEmpresa(connexion,empleadohobby));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(empleadohobby.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadohobby.setEmpleado(empleadohobbyDataAccess.getEmpleado(connexion,empleadohobby));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleadohobby.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Hobby.class)) {
				empleadohobby.setHobby(empleadohobbyDataAccess.getHobby(connexion,empleadohobby));
				HobbyLogic hobbyLogic= new HobbyLogic(connexion);
				hobbyLogic.deepLoad(empleadohobby.getHobby(),isDeep,deepLoadType,clases);				
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
			empleadohobby.setEmpresa(empleadohobbyDataAccess.getEmpresa(connexion,empleadohobby));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(empleadohobby.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadohobby.setEmpleado(empleadohobbyDataAccess.getEmpleado(connexion,empleadohobby));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleadohobby.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Hobby.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadohobby.setHobby(empleadohobbyDataAccess.getHobby(connexion,empleadohobby));
			HobbyLogic hobbyLogic= new HobbyLogic(connexion);
			hobbyLogic.deepLoad(empleadohobby.getHobby(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EmpleadoHobby empleadohobby,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpleadoHobbyLogicAdditional.updateEmpleadoHobbyToSave(empleadohobby,this.arrDatoGeneral);
			
EmpleadoHobbyDataAccess.save(empleadohobby, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadohobby.getEmpresa(),connexion);

		EmpleadoDataAccess.save(empleadohobby.getEmpleado(),connexion);

		HobbyDataAccess.save(empleadohobby.getHobby(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadohobby.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadohobby.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Hobby.class)) {
				HobbyDataAccess.save(empleadohobby.getHobby(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadohobby.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadohobby.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(empleadohobby.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadohobby.getEmpleado(),isDeep,deepLoadType,clases);
				

		HobbyDataAccess.save(empleadohobby.getHobby(),connexion);
		HobbyLogic hobbyLogic= new HobbyLogic(connexion);
		hobbyLogic.deepLoad(empleadohobby.getHobby(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadohobby.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(empleadohobby.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadohobby.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(empleadohobby.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Hobby.class)) {
				HobbyDataAccess.save(empleadohobby.getHobby(),connexion);
				HobbyLogic hobbyLogic= new HobbyLogic(connexion);
				hobbyLogic.deepSave(empleadohobby.getHobby(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(EmpleadoHobby.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empleadohobby,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(empleadohobby);
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
			this.deepLoad(this.empleadohobby,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobby);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EmpleadoHobby.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empleadohobbys!=null) {
				for(EmpleadoHobby empleadohobby:empleadohobbys) {
					this.deepLoad(empleadohobby,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(empleadohobbys);
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
			if(empleadohobbys!=null) {
				for(EmpleadoHobby empleadohobby:empleadohobbys) {
					this.deepLoad(empleadohobby,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(empleadohobbys);
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
			this.getNewConnexionToDeep(EmpleadoHobby.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empleadohobby,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EmpleadoHobby.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empleadohobbys!=null) {
				for(EmpleadoHobby empleadohobby:empleadohobbys) {
					this.deepSave(empleadohobby,isDeep,deepLoadType,clases);
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
			if(empleadohobbys!=null) {
				for(EmpleadoHobby empleadohobby:empleadohobbys) {
					this.deepSave(empleadohobby,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpleadoHobbysFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoHobbyConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoHobbysFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoHobbyConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoHobbysFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoHobbyConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoHobbysFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoHobbyConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoHobbysFK_IdHobbyWithConnection(String sFinalQuery,Pagination pagination,Long id_hobby)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHobby.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidHobby= new ParameterSelectionGeneral();
			parameterSelectionGeneralidHobby.setParameterSelectionGeneralEqual(ParameterType.LONG,id_hobby,EmpleadoHobbyConstantesFunciones.IDHOBBY,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidHobby);

			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdHobby","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoHobbysFK_IdHobby(String sFinalQuery,Pagination pagination,Long id_hobby)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidHobby= new ParameterSelectionGeneral();
			parameterSelectionGeneralidHobby.setParameterSelectionGeneralEqual(ParameterType.LONG,id_hobby,EmpleadoHobbyConstantesFunciones.IDHOBBY,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidHobby);

			EmpleadoHobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdHobby","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(this.empleadohobbys);
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
			if(EmpleadoHobbyConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoHobbyDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EmpleadoHobby empleadohobby,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpleadoHobbyConstantesFunciones.ISCONAUDITORIA) {
				if(empleadohobby.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoHobbyDataAccess.TABLENAME, empleadohobby.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoHobbyConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoHobbyLogic.registrarAuditoriaDetallesEmpleadoHobby(connexion,empleadohobby,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empleadohobby.getIsDeleted()) {
					/*if(!empleadohobby.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpleadoHobbyDataAccess.TABLENAME, empleadohobby.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpleadoHobbyLogic.registrarAuditoriaDetallesEmpleadoHobby(connexion,empleadohobby,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoHobbyDataAccess.TABLENAME, empleadohobby.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empleadohobby.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoHobbyDataAccess.TABLENAME, empleadohobby.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoHobbyConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoHobbyLogic.registrarAuditoriaDetallesEmpleadoHobby(connexion,empleadohobby,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpleadoHobby(Connexion connexion,EmpleadoHobby empleadohobby)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empleadohobby.getIsNew()||!empleadohobby.getid_empresa().equals(empleadohobby.getEmpleadoHobbyOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadohobby.getEmpleadoHobbyOriginal().getid_empresa()!=null)
				{
					strValorActual=empleadohobby.getEmpleadoHobbyOriginal().getid_empresa().toString();
				}
				if(empleadohobby.getid_empresa()!=null)
				{
					strValorNuevo=empleadohobby.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoHobbyConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empleadohobby.getIsNew()||!empleadohobby.getid_empleado().equals(empleadohobby.getEmpleadoHobbyOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadohobby.getEmpleadoHobbyOriginal().getid_empleado()!=null)
				{
					strValorActual=empleadohobby.getEmpleadoHobbyOriginal().getid_empleado().toString();
				}
				if(empleadohobby.getid_empleado()!=null)
				{
					strValorNuevo=empleadohobby.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoHobbyConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(empleadohobby.getIsNew()||!empleadohobby.getid_hobby().equals(empleadohobby.getEmpleadoHobbyOriginal().getid_hobby()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadohobby.getEmpleadoHobbyOriginal().getid_hobby()!=null)
				{
					strValorActual=empleadohobby.getEmpleadoHobbyOriginal().getid_hobby().toString();
				}
				if(empleadohobby.getid_hobby()!=null)
				{
					strValorNuevo=empleadohobby.getid_hobby().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoHobbyConstantesFunciones.IDHOBBY,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpleadoHobbyRelacionesWithConnection(EmpleadoHobby empleadohobby) throws Exception {

		if(!empleadohobby.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoHobbyRelacionesBase(empleadohobby,true);
		}
	}

	public void saveEmpleadoHobbyRelaciones(EmpleadoHobby empleadohobby)throws Exception {

		if(!empleadohobby.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoHobbyRelacionesBase(empleadohobby,false);
		}
	}

	public void saveEmpleadoHobbyRelacionesBase(EmpleadoHobby empleadohobby,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EmpleadoHobby-saveRelacionesWithConnection");}
	

			this.setEmpleadoHobby(empleadohobby);

			if(EmpleadoHobbyLogicAdditional.validarSaveRelaciones(empleadohobby,this)) {

				EmpleadoHobbyLogicAdditional.updateRelacionesToSave(empleadohobby,this);

				if((empleadohobby.getIsNew()||empleadohobby.getIsChanged())&&!empleadohobby.getIsDeleted()) {
					this.saveEmpleadoHobby();
					this.saveEmpleadoHobbyRelacionesDetalles();

				} else if(empleadohobby.getIsDeleted()) {
					this.saveEmpleadoHobbyRelacionesDetalles();
					this.saveEmpleadoHobby();
				}

				EmpleadoHobbyLogicAdditional.updateRelacionesToSaveAfter(empleadohobby,this);

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
	
	
	private void saveEmpleadoHobbyRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoHobby(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoHobbyConstantesFunciones.getClassesForeignKeysOfEmpleadoHobby(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoHobby(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoHobbyConstantesFunciones.getClassesRelationshipsOfEmpleadoHobby(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

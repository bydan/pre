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
import com.bydan.erp.nomina.util.EmpleadoConstanteConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoConstanteParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoConstanteParameterGeneral;
import com.bydan.erp.nomina.business.entity.EmpleadoConstante;
import com.bydan.erp.nomina.business.logic.EmpleadoConstanteLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmpleadoConstanteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpleadoConstanteLogic.class);
	
	protected EmpleadoConstanteDataAccess empleadoconstanteDataAccess; 	
	protected EmpleadoConstante empleadoconstante;
	protected List<EmpleadoConstante> empleadoconstantes;
	protected Object empleadoconstanteObject;	
	protected List<Object> empleadoconstantesObject;
	
	public static ClassValidator<EmpleadoConstante> empleadoconstanteValidator = new ClassValidator<EmpleadoConstante>(EmpleadoConstante.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpleadoConstanteLogicAdditional empleadoconstanteLogicAdditional=null;
	
	public EmpleadoConstanteLogicAdditional getEmpleadoConstanteLogicAdditional() {
		return this.empleadoconstanteLogicAdditional;
	}
	
	public void setEmpleadoConstanteLogicAdditional(EmpleadoConstanteLogicAdditional empleadoconstanteLogicAdditional) {
		try {
			this.empleadoconstanteLogicAdditional=empleadoconstanteLogicAdditional;
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
	
	
	
	
	public  EmpleadoConstanteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empleadoconstanteDataAccess = new EmpleadoConstanteDataAccess();
			
			this.empleadoconstantes= new ArrayList<EmpleadoConstante>();
			this.empleadoconstante= new EmpleadoConstante();
			
			this.empleadoconstanteObject=new Object();
			this.empleadoconstantesObject=new ArrayList<Object>();
				
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
			
			this.empleadoconstanteDataAccess.setConnexionType(this.connexionType);
			this.empleadoconstanteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpleadoConstanteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empleadoconstanteDataAccess = new EmpleadoConstanteDataAccess();
			this.empleadoconstantes= new ArrayList<EmpleadoConstante>();
			this.empleadoconstante= new EmpleadoConstante();
			this.empleadoconstanteObject=new Object();
			this.empleadoconstantesObject=new ArrayList<Object>();
			
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
			
			this.empleadoconstanteDataAccess.setConnexionType(this.connexionType);
			this.empleadoconstanteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EmpleadoConstante getEmpleadoConstante() throws Exception {	
		EmpleadoConstanteLogicAdditional.checkEmpleadoConstanteToGet(empleadoconstante,this.datosCliente,this.arrDatoGeneral);
		EmpleadoConstanteLogicAdditional.updateEmpleadoConstanteToGet(empleadoconstante,this.arrDatoGeneral);
		
		return empleadoconstante;
	}
		
	public void setEmpleadoConstante(EmpleadoConstante newEmpleadoConstante) {
		this.empleadoconstante = newEmpleadoConstante;
	}
	
	public EmpleadoConstanteDataAccess getEmpleadoConstanteDataAccess() {
		return empleadoconstanteDataAccess;
	}
	
	public void setEmpleadoConstanteDataAccess(EmpleadoConstanteDataAccess newempleadoconstanteDataAccess) {
		this.empleadoconstanteDataAccess = newempleadoconstanteDataAccess;
	}
	
	public List<EmpleadoConstante> getEmpleadoConstantes() throws Exception {		
		this.quitarEmpleadoConstantesNulos();
		
		EmpleadoConstanteLogicAdditional.checkEmpleadoConstanteToGets(empleadoconstantes,this.datosCliente,this.arrDatoGeneral);
		
		for (EmpleadoConstante empleadoconstanteLocal: empleadoconstantes ) {
			EmpleadoConstanteLogicAdditional.updateEmpleadoConstanteToGet(empleadoconstanteLocal,this.arrDatoGeneral);
		}
		
		return empleadoconstantes;
	}
	
	public void setEmpleadoConstantes(List<EmpleadoConstante> newEmpleadoConstantes) {
		this.empleadoconstantes = newEmpleadoConstantes;
	}
	
	public Object getEmpleadoConstanteObject() {	
		this.empleadoconstanteObject=this.empleadoconstanteDataAccess.getEntityObject();
		return this.empleadoconstanteObject;
	}
		
	public void setEmpleadoConstanteObject(Object newEmpleadoConstanteObject) {
		this.empleadoconstanteObject = newEmpleadoConstanteObject;
	}
	
	public List<Object> getEmpleadoConstantesObject() {		
		this.empleadoconstantesObject=this.empleadoconstanteDataAccess.getEntitiesObject();
		return this.empleadoconstantesObject;
	}
		
	public void setEmpleadoConstantesObject(List<Object> newEmpleadoConstantesObject) {
		this.empleadoconstantesObject = newEmpleadoConstantesObject;
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
		
		if(this.empleadoconstanteDataAccess!=null) {
			this.empleadoconstanteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empleadoconstanteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empleadoconstanteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empleadoconstante = new  EmpleadoConstante();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoconstante=empleadoconstanteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoconstante,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstante);
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
		empleadoconstante = new  EmpleadoConstante();
		  		  
        try {
			
			empleadoconstante=empleadoconstanteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoconstante,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstante);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empleadoconstante = new  EmpleadoConstante();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoconstante=empleadoconstanteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoconstante,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstante);
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
		empleadoconstante = new  EmpleadoConstante();
		  		  
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
		empleadoconstante = new  EmpleadoConstante();
		  		  
        try {
			
			empleadoconstante=empleadoconstanteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoconstante,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstante);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empleadoconstante = new  EmpleadoConstante();
		  		  
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
		empleadoconstante = new  EmpleadoConstante();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empleadoconstanteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoconstante = new  EmpleadoConstante();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empleadoconstanteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoconstante = new  EmpleadoConstante();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empleadoconstanteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoconstante = new  EmpleadoConstante();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empleadoconstanteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoconstante = new  EmpleadoConstante();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empleadoconstanteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoconstante = new  EmpleadoConstante();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empleadoconstanteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoconstantes = new  ArrayList<EmpleadoConstante>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoConstante(empleadoconstantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
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
		empleadoconstantes = new  ArrayList<EmpleadoConstante>();
		  		  
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
		empleadoconstantes = new  ArrayList<EmpleadoConstante>();
		  		  
        try {			
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpleadoConstante(empleadoconstantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empleadoconstantes = new  ArrayList<EmpleadoConstante>();
		  		  
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
		empleadoconstantes = new  ArrayList<EmpleadoConstante>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoConstante(empleadoconstantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
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
		empleadoconstantes = new  ArrayList<EmpleadoConstante>();
		  		  
        try {
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoConstante(empleadoconstantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
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
		empleadoconstantes = new  ArrayList<EmpleadoConstante>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoConstante(empleadoconstantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
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
		empleadoconstantes = new  ArrayList<EmpleadoConstante>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoConstante(empleadoconstantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empleadoconstante = new  EmpleadoConstante();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoconstante=empleadoconstanteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoConstante(empleadoconstante);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstante);
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
		empleadoconstante = new  EmpleadoConstante();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoconstante=empleadoconstanteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoConstante(empleadoconstante);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstante);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoconstantes = new  ArrayList<EmpleadoConstante>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoconstantes=empleadoconstanteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoConstante(empleadoconstantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
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
		empleadoconstantes = new  ArrayList<EmpleadoConstante>();
		  		  
        try {
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoconstantes=empleadoconstanteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoConstante(empleadoconstantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpleadoConstantesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoconstantes = new  ArrayList<EmpleadoConstante>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getTodosEmpleadoConstantesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoConstante(empleadoconstantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
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
	
	public  void  getTodosEmpleadoConstantes(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoconstantes = new  ArrayList<EmpleadoConstante>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoConstante(empleadoconstantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpleadoConstante(EmpleadoConstante empleadoconstante) throws Exception {
		Boolean estaValidado=false;
		
		if(empleadoconstante.getIsNew() || empleadoconstante.getIsChanged()) { 
			this.invalidValues = empleadoconstanteValidator.getInvalidValues(empleadoconstante);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empleadoconstante);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpleadoConstante(List<EmpleadoConstante> EmpleadoConstantes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EmpleadoConstante empleadoconstanteLocal:empleadoconstantes) {				
			estaValidadoObjeto=this.validarGuardarEmpleadoConstante(empleadoconstanteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpleadoConstante(List<EmpleadoConstante> EmpleadoConstantes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoConstante(empleadoconstantes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpleadoConstante(EmpleadoConstante EmpleadoConstante) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoConstante(empleadoconstante)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EmpleadoConstante empleadoconstante) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empleadoconstante.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpleadoConstanteConstantesFunciones.getEmpleadoConstanteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empleadoconstante","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpleadoConstanteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpleadoConstanteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpleadoConstanteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-saveEmpleadoConstanteWithConnection");connexion.begin();			
			
			EmpleadoConstanteLogicAdditional.checkEmpleadoConstanteToSave(this.empleadoconstante,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoConstanteLogicAdditional.updateEmpleadoConstanteToSave(this.empleadoconstante,this.arrDatoGeneral);
			
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoconstante,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoConstante();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoConstante(this.empleadoconstante)) {
				EmpleadoConstanteDataAccess.save(this.empleadoconstante, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empleadoconstante,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoConstanteLogicAdditional.checkEmpleadoConstanteToSaveAfter(this.empleadoconstante,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoConstante();
			
			connexion.commit();			
			
			if(this.empleadoconstante.getIsDeleted()) {
				this.empleadoconstante=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpleadoConstante()throws Exception {	
		try {	
			
			EmpleadoConstanteLogicAdditional.checkEmpleadoConstanteToSave(this.empleadoconstante,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoConstanteLogicAdditional.updateEmpleadoConstanteToSave(this.empleadoconstante,this.arrDatoGeneral);
			
			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoconstante,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoConstante(this.empleadoconstante)) {			
				EmpleadoConstanteDataAccess.save(this.empleadoconstante, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empleadoconstante,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoConstanteLogicAdditional.checkEmpleadoConstanteToSaveAfter(this.empleadoconstante,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empleadoconstante.getIsDeleted()) {
				this.empleadoconstante=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpleadoConstantesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-saveEmpleadoConstantesWithConnection");connexion.begin();			
			
			EmpleadoConstanteLogicAdditional.checkEmpleadoConstanteToSaves(empleadoconstantes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoConstantes();
			
			Boolean validadoTodosEmpleadoConstante=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoConstante empleadoconstanteLocal:empleadoconstantes) {		
				if(empleadoconstanteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoConstanteLogicAdditional.updateEmpleadoConstanteToSave(empleadoconstanteLocal,this.arrDatoGeneral);
	        	
				EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoconstanteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoConstante(empleadoconstanteLocal)) {
					EmpleadoConstanteDataAccess.save(empleadoconstanteLocal, connexion);				
				} else {
					validadoTodosEmpleadoConstante=false;
				}
			}
			
			if(!validadoTodosEmpleadoConstante) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoConstanteLogicAdditional.checkEmpleadoConstanteToSavesAfter(empleadoconstantes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoConstantes();
			
			connexion.commit();		
			
			this.quitarEmpleadoConstantesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpleadoConstantes()throws Exception {				
		 try {	
			EmpleadoConstanteLogicAdditional.checkEmpleadoConstanteToSaves(empleadoconstantes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpleadoConstante=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoConstante empleadoconstanteLocal:empleadoconstantes) {				
				if(empleadoconstanteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoConstanteLogicAdditional.updateEmpleadoConstanteToSave(empleadoconstanteLocal,this.arrDatoGeneral);
	        	
				EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoconstanteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoConstante(empleadoconstanteLocal)) {				
					EmpleadoConstanteDataAccess.save(empleadoconstanteLocal, connexion);				
				} else {
					validadoTodosEmpleadoConstante=false;
				}
			}
			
			if(!validadoTodosEmpleadoConstante) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoConstanteLogicAdditional.checkEmpleadoConstanteToSavesAfter(empleadoconstantes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpleadoConstantesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoConstanteParameterReturnGeneral procesarAccionEmpleadoConstantes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoConstante> empleadoconstantes,EmpleadoConstanteParameterReturnGeneral empleadoconstanteParameterGeneral)throws Exception {
		 try {	
			EmpleadoConstanteParameterReturnGeneral empleadoconstanteReturnGeneral=new EmpleadoConstanteParameterReturnGeneral();
	
			EmpleadoConstanteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoconstantes,empleadoconstanteParameterGeneral,empleadoconstanteReturnGeneral);
			
			return empleadoconstanteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoConstanteParameterReturnGeneral procesarAccionEmpleadoConstantesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoConstante> empleadoconstantes,EmpleadoConstanteParameterReturnGeneral empleadoconstanteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-procesarAccionEmpleadoConstantesWithConnection");connexion.begin();			
			
			EmpleadoConstanteParameterReturnGeneral empleadoconstanteReturnGeneral=new EmpleadoConstanteParameterReturnGeneral();
	
			EmpleadoConstanteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoconstantes,empleadoconstanteParameterGeneral,empleadoconstanteReturnGeneral);
			
			this.connexion.commit();
			
			return empleadoconstanteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoConstanteParameterReturnGeneral procesarEventosEmpleadoConstantes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoConstante> empleadoconstantes,EmpleadoConstante empleadoconstante,EmpleadoConstanteParameterReturnGeneral empleadoconstanteParameterGeneral,Boolean isEsNuevoEmpleadoConstante,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpleadoConstanteParameterReturnGeneral empleadoconstanteReturnGeneral=new EmpleadoConstanteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoconstanteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoConstanteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoconstantes,empleadoconstante,empleadoconstanteParameterGeneral,empleadoconstanteReturnGeneral,isEsNuevoEmpleadoConstante,clases);
			
			return empleadoconstanteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpleadoConstanteParameterReturnGeneral procesarEventosEmpleadoConstantesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoConstante> empleadoconstantes,EmpleadoConstante empleadoconstante,EmpleadoConstanteParameterReturnGeneral empleadoconstanteParameterGeneral,Boolean isEsNuevoEmpleadoConstante,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-procesarEventosEmpleadoConstantesWithConnection");connexion.begin();			
			
			EmpleadoConstanteParameterReturnGeneral empleadoconstanteReturnGeneral=new EmpleadoConstanteParameterReturnGeneral();
	
			empleadoconstanteReturnGeneral.setEmpleadoConstante(empleadoconstante);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoconstanteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoConstanteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoconstantes,empleadoconstante,empleadoconstanteParameterGeneral,empleadoconstanteReturnGeneral,isEsNuevoEmpleadoConstante,clases);
			
			this.connexion.commit();
			
			return empleadoconstanteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoConstanteParameterReturnGeneral procesarImportacionEmpleadoConstantesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpleadoConstanteParameterReturnGeneral empleadoconstanteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-procesarImportacionEmpleadoConstantesWithConnection");connexion.begin();			
			
			EmpleadoConstanteParameterReturnGeneral empleadoconstanteReturnGeneral=new EmpleadoConstanteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empleadoconstantes=new ArrayList<EmpleadoConstante>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empleadoconstante=new EmpleadoConstante();
				
				
				if(conColumnasBase) {this.empleadoconstante.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empleadoconstante.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empleadoconstante.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.empleadoconstante.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.empleadoconstantes.add(this.empleadoconstante);
			}
			
			this.saveEmpleadoConstantes();
			
			this.connexion.commit();
			
			empleadoconstanteReturnGeneral.setConRetornoEstaProcesado(true);
			empleadoconstanteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empleadoconstanteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpleadoConstantesEliminados() throws Exception {				
		
		List<EmpleadoConstante> empleadoconstantesAux= new ArrayList<EmpleadoConstante>();
		
		for(EmpleadoConstante empleadoconstante:empleadoconstantes) {
			if(!empleadoconstante.getIsDeleted()) {
				empleadoconstantesAux.add(empleadoconstante);
			}
		}
		
		empleadoconstantes=empleadoconstantesAux;
	}
	
	public void quitarEmpleadoConstantesNulos() throws Exception {				
		
		List<EmpleadoConstante> empleadoconstantesAux= new ArrayList<EmpleadoConstante>();
		
		for(EmpleadoConstante empleadoconstante : this.empleadoconstantes) {
			if(empleadoconstante==null) {
				empleadoconstantesAux.add(empleadoconstante);
			}
		}
		
		//this.empleadoconstantes=empleadoconstantesAux;
		
		this.empleadoconstantes.removeAll(empleadoconstantesAux);
	}
	
	public void getSetVersionRowEmpleadoConstanteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empleadoconstante.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empleadoconstante.getIsDeleted() || (empleadoconstante.getIsChanged()&&!empleadoconstante.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empleadoconstanteDataAccess.getSetVersionRowEmpleadoConstante(connexion,empleadoconstante.getId());
				
				if(!empleadoconstante.getVersionRow().equals(timestamp)) {	
					empleadoconstante.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empleadoconstante.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpleadoConstante()throws Exception {	
		
		if(empleadoconstante.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empleadoconstante.getIsDeleted() || (empleadoconstante.getIsChanged()&&!empleadoconstante.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empleadoconstanteDataAccess.getSetVersionRowEmpleadoConstante(connexion,empleadoconstante.getId());
			
			try {							
				if(!empleadoconstante.getVersionRow().equals(timestamp)) {	
					empleadoconstante.setVersionRow(timestamp);
				}
				
				empleadoconstante.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpleadoConstantesWithConnection()throws Exception {	
		if(empleadoconstantes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EmpleadoConstante empleadoconstanteAux:empleadoconstantes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empleadoconstanteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoconstanteAux.getIsDeleted() || (empleadoconstanteAux.getIsChanged()&&!empleadoconstanteAux.getIsNew())) {
						
						timestamp=empleadoconstanteDataAccess.getSetVersionRowEmpleadoConstante(connexion,empleadoconstanteAux.getId());
						
						if(!empleadoconstante.getVersionRow().equals(timestamp)) {	
							empleadoconstanteAux.setVersionRow(timestamp);
						}
								
						empleadoconstanteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpleadoConstantes()throws Exception {	
		if(empleadoconstantes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EmpleadoConstante empleadoconstanteAux:empleadoconstantes) {
					if(empleadoconstanteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoconstanteAux.getIsDeleted() || (empleadoconstanteAux.getIsChanged()&&!empleadoconstanteAux.getIsNew())) {
						
						timestamp=empleadoconstanteDataAccess.getSetVersionRowEmpleadoConstante(connexion,empleadoconstanteAux.getId());
						
						if(!empleadoconstanteAux.getVersionRow().equals(timestamp)) {	
							empleadoconstanteAux.setVersionRow(timestamp);
						}
						
													
						empleadoconstanteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpleadoConstanteParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoConstanteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalConstanteNomi) throws Exception {
		EmpleadoConstanteParameterReturnGeneral  empleadoconstanteReturnGeneral =new EmpleadoConstanteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpleadoConstanteWithConnection");connexion.begin();
			
			empleadoconstanteReturnGeneral =new EmpleadoConstanteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoconstanteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoconstanteReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<ConstanteNomi> constantenomisForeignKey=new ArrayList<ConstanteNomi>();
			ConstanteNomiLogic constantenomiLogic=new ConstanteNomiLogic();
			constantenomiLogic.setConnexion(this.connexion);
			constantenomiLogic.getConstanteNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConstanteNomi.equals("NONE")) {
				constantenomiLogic.getTodosConstanteNomis(finalQueryGlobalConstanteNomi,new Pagination());
				constantenomisForeignKey=constantenomiLogic.getConstanteNomis();
			}

			empleadoconstanteReturnGeneral.setconstantenomisForeignKey(constantenomisForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empleadoconstanteReturnGeneral;
	}
	
	public EmpleadoConstanteParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoConstante(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalConstanteNomi) throws Exception {
		EmpleadoConstanteParameterReturnGeneral  empleadoconstanteReturnGeneral =new EmpleadoConstanteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empleadoconstanteReturnGeneral =new EmpleadoConstanteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoconstanteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoconstanteReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<ConstanteNomi> constantenomisForeignKey=new ArrayList<ConstanteNomi>();
			ConstanteNomiLogic constantenomiLogic=new ConstanteNomiLogic();
			constantenomiLogic.setConnexion(this.connexion);
			constantenomiLogic.getConstanteNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConstanteNomi.equals("NONE")) {
				constantenomiLogic.getTodosConstanteNomis(finalQueryGlobalConstanteNomi,new Pagination());
				constantenomisForeignKey=constantenomiLogic.getConstanteNomis();
			}

			empleadoconstanteReturnGeneral.setconstantenomisForeignKey(constantenomisForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empleadoconstanteReturnGeneral;
	}
	
	
	public void deepLoad(EmpleadoConstante empleadoconstante,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpleadoConstanteLogicAdditional.updateEmpleadoConstanteToGet(empleadoconstante,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoconstante.setEmpresa(empleadoconstanteDataAccess.getEmpresa(connexion,empleadoconstante));
		empleadoconstante.setEmpleado(empleadoconstanteDataAccess.getEmpleado(connexion,empleadoconstante));
		empleadoconstante.setConstanteNomi(empleadoconstanteDataAccess.getConstanteNomi(connexion,empleadoconstante));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoconstante.setEmpresa(empleadoconstanteDataAccess.getEmpresa(connexion,empleadoconstante));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoconstante.setEmpleado(empleadoconstanteDataAccess.getEmpleado(connexion,empleadoconstante));
				continue;
			}

			if(clas.clas.equals(ConstanteNomi.class)) {
				empleadoconstante.setConstanteNomi(empleadoconstanteDataAccess.getConstanteNomi(connexion,empleadoconstante));
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
			empleadoconstante.setEmpresa(empleadoconstanteDataAccess.getEmpresa(connexion,empleadoconstante));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoconstante.setEmpleado(empleadoconstanteDataAccess.getEmpleado(connexion,empleadoconstante));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ConstanteNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoconstante.setConstanteNomi(empleadoconstanteDataAccess.getConstanteNomi(connexion,empleadoconstante));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoconstante.setEmpresa(empleadoconstanteDataAccess.getEmpresa(connexion,empleadoconstante));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoconstante.getEmpresa(),isDeep,deepLoadType,clases);
				
		empleadoconstante.setEmpleado(empleadoconstanteDataAccess.getEmpleado(connexion,empleadoconstante));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoconstante.getEmpleado(),isDeep,deepLoadType,clases);
				
		empleadoconstante.setConstanteNomi(empleadoconstanteDataAccess.getConstanteNomi(connexion,empleadoconstante));
		ConstanteNomiLogic constantenomiLogic= new ConstanteNomiLogic(connexion);
		constantenomiLogic.deepLoad(empleadoconstante.getConstanteNomi(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoconstante.setEmpresa(empleadoconstanteDataAccess.getEmpresa(connexion,empleadoconstante));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(empleadoconstante.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoconstante.setEmpleado(empleadoconstanteDataAccess.getEmpleado(connexion,empleadoconstante));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleadoconstante.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ConstanteNomi.class)) {
				empleadoconstante.setConstanteNomi(empleadoconstanteDataAccess.getConstanteNomi(connexion,empleadoconstante));
				ConstanteNomiLogic constantenomiLogic= new ConstanteNomiLogic(connexion);
				constantenomiLogic.deepLoad(empleadoconstante.getConstanteNomi(),isDeep,deepLoadType,clases);				
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
			empleadoconstante.setEmpresa(empleadoconstanteDataAccess.getEmpresa(connexion,empleadoconstante));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(empleadoconstante.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoconstante.setEmpleado(empleadoconstanteDataAccess.getEmpleado(connexion,empleadoconstante));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleadoconstante.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ConstanteNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoconstante.setConstanteNomi(empleadoconstanteDataAccess.getConstanteNomi(connexion,empleadoconstante));
			ConstanteNomiLogic constantenomiLogic= new ConstanteNomiLogic(connexion);
			constantenomiLogic.deepLoad(empleadoconstante.getConstanteNomi(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EmpleadoConstante empleadoconstante,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpleadoConstanteLogicAdditional.updateEmpleadoConstanteToSave(empleadoconstante,this.arrDatoGeneral);
			
EmpleadoConstanteDataAccess.save(empleadoconstante, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoconstante.getEmpresa(),connexion);

		EmpleadoDataAccess.save(empleadoconstante.getEmpleado(),connexion);

		ConstanteNomiDataAccess.save(empleadoconstante.getConstanteNomi(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoconstante.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoconstante.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(ConstanteNomi.class)) {
				ConstanteNomiDataAccess.save(empleadoconstante.getConstanteNomi(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoconstante.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoconstante.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(empleadoconstante.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoconstante.getEmpleado(),isDeep,deepLoadType,clases);
				

		ConstanteNomiDataAccess.save(empleadoconstante.getConstanteNomi(),connexion);
		ConstanteNomiLogic constantenomiLogic= new ConstanteNomiLogic(connexion);
		constantenomiLogic.deepLoad(empleadoconstante.getConstanteNomi(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoconstante.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(empleadoconstante.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoconstante.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(empleadoconstante.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ConstanteNomi.class)) {
				ConstanteNomiDataAccess.save(empleadoconstante.getConstanteNomi(),connexion);
				ConstanteNomiLogic constantenomiLogic= new ConstanteNomiLogic(connexion);
				constantenomiLogic.deepSave(empleadoconstante.getConstanteNomi(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(EmpleadoConstante.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empleadoconstante,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(empleadoconstante);
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
			this.deepLoad(this.empleadoconstante,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstante);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EmpleadoConstante.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empleadoconstantes!=null) {
				for(EmpleadoConstante empleadoconstante:empleadoconstantes) {
					this.deepLoad(empleadoconstante,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(empleadoconstantes);
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
			if(empleadoconstantes!=null) {
				for(EmpleadoConstante empleadoconstante:empleadoconstantes) {
					this.deepLoad(empleadoconstante,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(empleadoconstantes);
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
			this.getNewConnexionToDeep(EmpleadoConstante.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empleadoconstante,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EmpleadoConstante.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empleadoconstantes!=null) {
				for(EmpleadoConstante empleadoconstante:empleadoconstantes) {
					this.deepSave(empleadoconstante,isDeep,deepLoadType,clases);
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
			if(empleadoconstantes!=null) {
				for(EmpleadoConstante empleadoconstante:empleadoconstantes) {
					this.deepSave(empleadoconstante,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpleadoConstantesFK_IdConstanteNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_constante_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConstanteNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConstanteNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_constante_nomi,EmpleadoConstanteConstantesFunciones.IDCONSTANTENOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConstanteNomi);

			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConstanteNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoConstantesFK_IdConstanteNomi(String sFinalQuery,Pagination pagination,Long id_constante_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConstanteNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConstanteNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_constante_nomi,EmpleadoConstanteConstantesFunciones.IDCONSTANTENOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConstanteNomi);

			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConstanteNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoConstantesFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoConstanteConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoConstantesFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoConstanteConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoConstantesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoConstante.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoConstanteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoConstantesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoConstanteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoConstanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoConstanteConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoConstante(this.empleadoconstantes);
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
			if(EmpleadoConstanteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoConstanteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EmpleadoConstante empleadoconstante,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpleadoConstanteConstantesFunciones.ISCONAUDITORIA) {
				if(empleadoconstante.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoConstanteDataAccess.TABLENAME, empleadoconstante.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoConstanteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoConstanteLogic.registrarAuditoriaDetallesEmpleadoConstante(connexion,empleadoconstante,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empleadoconstante.getIsDeleted()) {
					/*if(!empleadoconstante.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpleadoConstanteDataAccess.TABLENAME, empleadoconstante.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpleadoConstanteLogic.registrarAuditoriaDetallesEmpleadoConstante(connexion,empleadoconstante,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoConstanteDataAccess.TABLENAME, empleadoconstante.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empleadoconstante.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoConstanteDataAccess.TABLENAME, empleadoconstante.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoConstanteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoConstanteLogic.registrarAuditoriaDetallesEmpleadoConstante(connexion,empleadoconstante,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpleadoConstante(Connexion connexion,EmpleadoConstante empleadoconstante)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empleadoconstante.getIsNew()||!empleadoconstante.getid_empresa().equals(empleadoconstante.getEmpleadoConstanteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoconstante.getEmpleadoConstanteOriginal().getid_empresa()!=null)
				{
					strValorActual=empleadoconstante.getEmpleadoConstanteOriginal().getid_empresa().toString();
				}
				if(empleadoconstante.getid_empresa()!=null)
				{
					strValorNuevo=empleadoconstante.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstanteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoconstante.getIsNew()||!empleadoconstante.getid_empleado().equals(empleadoconstante.getEmpleadoConstanteOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoconstante.getEmpleadoConstanteOriginal().getid_empleado()!=null)
				{
					strValorActual=empleadoconstante.getEmpleadoConstanteOriginal().getid_empleado().toString();
				}
				if(empleadoconstante.getid_empleado()!=null)
				{
					strValorNuevo=empleadoconstante.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstanteConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoconstante.getIsNew()||!empleadoconstante.getid_constante_nomi().equals(empleadoconstante.getEmpleadoConstanteOriginal().getid_constante_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoconstante.getEmpleadoConstanteOriginal().getid_constante_nomi()!=null)
				{
					strValorActual=empleadoconstante.getEmpleadoConstanteOriginal().getid_constante_nomi().toString();
				}
				if(empleadoconstante.getid_constante_nomi()!=null)
				{
					strValorNuevo=empleadoconstante.getid_constante_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstanteConstantesFunciones.IDCONSTANTENOMI,strValorActual,strValorNuevo);
			}	
			
			if(empleadoconstante.getIsNew()||!empleadoconstante.getvalor().equals(empleadoconstante.getEmpleadoConstanteOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoconstante.getEmpleadoConstanteOriginal().getvalor()!=null)
				{
					strValorActual=empleadoconstante.getEmpleadoConstanteOriginal().getvalor().toString();
				}
				if(empleadoconstante.getvalor()!=null)
				{
					strValorNuevo=empleadoconstante.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstanteConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(empleadoconstante.getIsNew()||!empleadoconstante.getesta_activo().equals(empleadoconstante.getEmpleadoConstanteOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoconstante.getEmpleadoConstanteOriginal().getesta_activo()!=null)
				{
					strValorActual=empleadoconstante.getEmpleadoConstanteOriginal().getesta_activo().toString();
				}
				if(empleadoconstante.getesta_activo()!=null)
				{
					strValorNuevo=empleadoconstante.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoConstanteConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpleadoConstanteRelacionesWithConnection(EmpleadoConstante empleadoconstante) throws Exception {

		if(!empleadoconstante.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoConstanteRelacionesBase(empleadoconstante,true);
		}
	}

	public void saveEmpleadoConstanteRelaciones(EmpleadoConstante empleadoconstante)throws Exception {

		if(!empleadoconstante.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoConstanteRelacionesBase(empleadoconstante,false);
		}
	}

	public void saveEmpleadoConstanteRelacionesBase(EmpleadoConstante empleadoconstante,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EmpleadoConstante-saveRelacionesWithConnection");}
	

			this.setEmpleadoConstante(empleadoconstante);

			if(EmpleadoConstanteLogicAdditional.validarSaveRelaciones(empleadoconstante,this)) {

				EmpleadoConstanteLogicAdditional.updateRelacionesToSave(empleadoconstante,this);

				if((empleadoconstante.getIsNew()||empleadoconstante.getIsChanged())&&!empleadoconstante.getIsDeleted()) {
					this.saveEmpleadoConstante();
					this.saveEmpleadoConstanteRelacionesDetalles();

				} else if(empleadoconstante.getIsDeleted()) {
					this.saveEmpleadoConstanteRelacionesDetalles();
					this.saveEmpleadoConstante();
				}

				EmpleadoConstanteLogicAdditional.updateRelacionesToSaveAfter(empleadoconstante,this);

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
	
	
	private void saveEmpleadoConstanteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoConstante(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoConstanteConstantesFunciones.getClassesForeignKeysOfEmpleadoConstante(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoConstante(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoConstanteConstantesFunciones.getClassesRelationshipsOfEmpleadoConstante(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

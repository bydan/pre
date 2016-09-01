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
import com.bydan.erp.nomina.util.EmpleadoHerraConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoHerraParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoHerraParameterGeneral;
import com.bydan.erp.nomina.business.entity.EmpleadoHerra;
import com.bydan.erp.nomina.business.logic.EmpleadoHerraLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmpleadoHerraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpleadoHerraLogic.class);
	
	protected EmpleadoHerraDataAccess empleadoherraDataAccess; 	
	protected EmpleadoHerra empleadoherra;
	protected List<EmpleadoHerra> empleadoherras;
	protected Object empleadoherraObject;	
	protected List<Object> empleadoherrasObject;
	
	public static ClassValidator<EmpleadoHerra> empleadoherraValidator = new ClassValidator<EmpleadoHerra>(EmpleadoHerra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpleadoHerraLogicAdditional empleadoherraLogicAdditional=null;
	
	public EmpleadoHerraLogicAdditional getEmpleadoHerraLogicAdditional() {
		return this.empleadoherraLogicAdditional;
	}
	
	public void setEmpleadoHerraLogicAdditional(EmpleadoHerraLogicAdditional empleadoherraLogicAdditional) {
		try {
			this.empleadoherraLogicAdditional=empleadoherraLogicAdditional;
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
	
	
	
	
	public  EmpleadoHerraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empleadoherraDataAccess = new EmpleadoHerraDataAccess();
			
			this.empleadoherras= new ArrayList<EmpleadoHerra>();
			this.empleadoherra= new EmpleadoHerra();
			
			this.empleadoherraObject=new Object();
			this.empleadoherrasObject=new ArrayList<Object>();
				
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
			
			this.empleadoherraDataAccess.setConnexionType(this.connexionType);
			this.empleadoherraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpleadoHerraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empleadoherraDataAccess = new EmpleadoHerraDataAccess();
			this.empleadoherras= new ArrayList<EmpleadoHerra>();
			this.empleadoherra= new EmpleadoHerra();
			this.empleadoherraObject=new Object();
			this.empleadoherrasObject=new ArrayList<Object>();
			
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
			
			this.empleadoherraDataAccess.setConnexionType(this.connexionType);
			this.empleadoherraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EmpleadoHerra getEmpleadoHerra() throws Exception {	
		EmpleadoHerraLogicAdditional.checkEmpleadoHerraToGet(empleadoherra,this.datosCliente,this.arrDatoGeneral);
		EmpleadoHerraLogicAdditional.updateEmpleadoHerraToGet(empleadoherra,this.arrDatoGeneral);
		
		return empleadoherra;
	}
		
	public void setEmpleadoHerra(EmpleadoHerra newEmpleadoHerra) {
		this.empleadoherra = newEmpleadoHerra;
	}
	
	public EmpleadoHerraDataAccess getEmpleadoHerraDataAccess() {
		return empleadoherraDataAccess;
	}
	
	public void setEmpleadoHerraDataAccess(EmpleadoHerraDataAccess newempleadoherraDataAccess) {
		this.empleadoherraDataAccess = newempleadoherraDataAccess;
	}
	
	public List<EmpleadoHerra> getEmpleadoHerras() throws Exception {		
		this.quitarEmpleadoHerrasNulos();
		
		EmpleadoHerraLogicAdditional.checkEmpleadoHerraToGets(empleadoherras,this.datosCliente,this.arrDatoGeneral);
		
		for (EmpleadoHerra empleadoherraLocal: empleadoherras ) {
			EmpleadoHerraLogicAdditional.updateEmpleadoHerraToGet(empleadoherraLocal,this.arrDatoGeneral);
		}
		
		return empleadoherras;
	}
	
	public void setEmpleadoHerras(List<EmpleadoHerra> newEmpleadoHerras) {
		this.empleadoherras = newEmpleadoHerras;
	}
	
	public Object getEmpleadoHerraObject() {	
		this.empleadoherraObject=this.empleadoherraDataAccess.getEntityObject();
		return this.empleadoherraObject;
	}
		
	public void setEmpleadoHerraObject(Object newEmpleadoHerraObject) {
		this.empleadoherraObject = newEmpleadoHerraObject;
	}
	
	public List<Object> getEmpleadoHerrasObject() {		
		this.empleadoherrasObject=this.empleadoherraDataAccess.getEntitiesObject();
		return this.empleadoherrasObject;
	}
		
	public void setEmpleadoHerrasObject(List<Object> newEmpleadoHerrasObject) {
		this.empleadoherrasObject = newEmpleadoHerrasObject;
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
		
		if(this.empleadoherraDataAccess!=null) {
			this.empleadoherraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empleadoherraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empleadoherraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empleadoherra = new  EmpleadoHerra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoherra=empleadoherraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoherra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherra);
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
		empleadoherra = new  EmpleadoHerra();
		  		  
        try {
			
			empleadoherra=empleadoherraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoherra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empleadoherra = new  EmpleadoHerra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoherra=empleadoherraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoherra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherra);
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
		empleadoherra = new  EmpleadoHerra();
		  		  
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
		empleadoherra = new  EmpleadoHerra();
		  		  
        try {
			
			empleadoherra=empleadoherraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoherra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empleadoherra = new  EmpleadoHerra();
		  		  
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
		empleadoherra = new  EmpleadoHerra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empleadoherraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoherra = new  EmpleadoHerra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empleadoherraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoherra = new  EmpleadoHerra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empleadoherraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoherra = new  EmpleadoHerra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empleadoherraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoherra = new  EmpleadoHerra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empleadoherraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoherra = new  EmpleadoHerra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empleadoherraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoherras = new  ArrayList<EmpleadoHerra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoherras=empleadoherraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoHerra(empleadoherras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
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
		empleadoherras = new  ArrayList<EmpleadoHerra>();
		  		  
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
		empleadoherras = new  ArrayList<EmpleadoHerra>();
		  		  
        try {			
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoherras=empleadoherraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpleadoHerra(empleadoherras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empleadoherras = new  ArrayList<EmpleadoHerra>();
		  		  
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
		empleadoherras = new  ArrayList<EmpleadoHerra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoherras=empleadoherraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoHerra(empleadoherras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
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
		empleadoherras = new  ArrayList<EmpleadoHerra>();
		  		  
        try {
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoherras=empleadoherraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoHerra(empleadoherras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
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
		empleadoherras = new  ArrayList<EmpleadoHerra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoherras=empleadoherraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoHerra(empleadoherras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
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
		empleadoherras = new  ArrayList<EmpleadoHerra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoherras=empleadoherraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoHerra(empleadoherras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empleadoherra = new  EmpleadoHerra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoherra=empleadoherraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoHerra(empleadoherra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherra);
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
		empleadoherra = new  EmpleadoHerra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoherra=empleadoherraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoHerra(empleadoherra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoherras = new  ArrayList<EmpleadoHerra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoherras=empleadoherraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoHerra(empleadoherras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
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
		empleadoherras = new  ArrayList<EmpleadoHerra>();
		  		  
        try {
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoherras=empleadoherraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoHerra(empleadoherras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpleadoHerrasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoherras = new  ArrayList<EmpleadoHerra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getTodosEmpleadoHerrasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoherras=empleadoherraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoHerra(empleadoherras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
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
	
	public  void  getTodosEmpleadoHerras(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoherras = new  ArrayList<EmpleadoHerra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoherras=empleadoherraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoHerra(empleadoherras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpleadoHerra(EmpleadoHerra empleadoherra) throws Exception {
		Boolean estaValidado=false;
		
		if(empleadoherra.getIsNew() || empleadoherra.getIsChanged()) { 
			this.invalidValues = empleadoherraValidator.getInvalidValues(empleadoherra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empleadoherra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpleadoHerra(List<EmpleadoHerra> EmpleadoHerras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EmpleadoHerra empleadoherraLocal:empleadoherras) {				
			estaValidadoObjeto=this.validarGuardarEmpleadoHerra(empleadoherraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpleadoHerra(List<EmpleadoHerra> EmpleadoHerras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoHerra(empleadoherras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpleadoHerra(EmpleadoHerra EmpleadoHerra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoHerra(empleadoherra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EmpleadoHerra empleadoherra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empleadoherra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpleadoHerraConstantesFunciones.getEmpleadoHerraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empleadoherra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpleadoHerraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpleadoHerraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpleadoHerraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-saveEmpleadoHerraWithConnection");connexion.begin();			
			
			EmpleadoHerraLogicAdditional.checkEmpleadoHerraToSave(this.empleadoherra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoHerraLogicAdditional.updateEmpleadoHerraToSave(this.empleadoherra,this.arrDatoGeneral);
			
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoherra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoHerra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoHerra(this.empleadoherra)) {
				EmpleadoHerraDataAccess.save(this.empleadoherra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empleadoherra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoHerraLogicAdditional.checkEmpleadoHerraToSaveAfter(this.empleadoherra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoHerra();
			
			connexion.commit();			
			
			if(this.empleadoherra.getIsDeleted()) {
				this.empleadoherra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpleadoHerra()throws Exception {	
		try {	
			
			EmpleadoHerraLogicAdditional.checkEmpleadoHerraToSave(this.empleadoherra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoHerraLogicAdditional.updateEmpleadoHerraToSave(this.empleadoherra,this.arrDatoGeneral);
			
			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoherra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoHerra(this.empleadoherra)) {			
				EmpleadoHerraDataAccess.save(this.empleadoherra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empleadoherra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoHerraLogicAdditional.checkEmpleadoHerraToSaveAfter(this.empleadoherra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empleadoherra.getIsDeleted()) {
				this.empleadoherra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpleadoHerrasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-saveEmpleadoHerrasWithConnection");connexion.begin();			
			
			EmpleadoHerraLogicAdditional.checkEmpleadoHerraToSaves(empleadoherras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoHerras();
			
			Boolean validadoTodosEmpleadoHerra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoHerra empleadoherraLocal:empleadoherras) {		
				if(empleadoherraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoHerraLogicAdditional.updateEmpleadoHerraToSave(empleadoherraLocal,this.arrDatoGeneral);
	        	
				EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoherraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoHerra(empleadoherraLocal)) {
					EmpleadoHerraDataAccess.save(empleadoherraLocal, connexion);				
				} else {
					validadoTodosEmpleadoHerra=false;
				}
			}
			
			if(!validadoTodosEmpleadoHerra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoHerraLogicAdditional.checkEmpleadoHerraToSavesAfter(empleadoherras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoHerras();
			
			connexion.commit();		
			
			this.quitarEmpleadoHerrasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpleadoHerras()throws Exception {				
		 try {	
			EmpleadoHerraLogicAdditional.checkEmpleadoHerraToSaves(empleadoherras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpleadoHerra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoHerra empleadoherraLocal:empleadoherras) {				
				if(empleadoherraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoHerraLogicAdditional.updateEmpleadoHerraToSave(empleadoherraLocal,this.arrDatoGeneral);
	        	
				EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoherraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoHerra(empleadoherraLocal)) {				
					EmpleadoHerraDataAccess.save(empleadoherraLocal, connexion);				
				} else {
					validadoTodosEmpleadoHerra=false;
				}
			}
			
			if(!validadoTodosEmpleadoHerra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoHerraLogicAdditional.checkEmpleadoHerraToSavesAfter(empleadoherras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpleadoHerrasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoHerraParameterReturnGeneral procesarAccionEmpleadoHerras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoHerra> empleadoherras,EmpleadoHerraParameterReturnGeneral empleadoherraParameterGeneral)throws Exception {
		 try {	
			EmpleadoHerraParameterReturnGeneral empleadoherraReturnGeneral=new EmpleadoHerraParameterReturnGeneral();
	
			EmpleadoHerraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoherras,empleadoherraParameterGeneral,empleadoherraReturnGeneral);
			
			return empleadoherraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoHerraParameterReturnGeneral procesarAccionEmpleadoHerrasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoHerra> empleadoherras,EmpleadoHerraParameterReturnGeneral empleadoherraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-procesarAccionEmpleadoHerrasWithConnection");connexion.begin();			
			
			EmpleadoHerraParameterReturnGeneral empleadoherraReturnGeneral=new EmpleadoHerraParameterReturnGeneral();
	
			EmpleadoHerraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoherras,empleadoherraParameterGeneral,empleadoherraReturnGeneral);
			
			this.connexion.commit();
			
			return empleadoherraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoHerraParameterReturnGeneral procesarEventosEmpleadoHerras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoHerra> empleadoherras,EmpleadoHerra empleadoherra,EmpleadoHerraParameterReturnGeneral empleadoherraParameterGeneral,Boolean isEsNuevoEmpleadoHerra,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpleadoHerraParameterReturnGeneral empleadoherraReturnGeneral=new EmpleadoHerraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoherraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoHerraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoherras,empleadoherra,empleadoherraParameterGeneral,empleadoherraReturnGeneral,isEsNuevoEmpleadoHerra,clases);
			
			return empleadoherraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpleadoHerraParameterReturnGeneral procesarEventosEmpleadoHerrasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoHerra> empleadoherras,EmpleadoHerra empleadoherra,EmpleadoHerraParameterReturnGeneral empleadoherraParameterGeneral,Boolean isEsNuevoEmpleadoHerra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-procesarEventosEmpleadoHerrasWithConnection");connexion.begin();			
			
			EmpleadoHerraParameterReturnGeneral empleadoherraReturnGeneral=new EmpleadoHerraParameterReturnGeneral();
	
			empleadoherraReturnGeneral.setEmpleadoHerra(empleadoherra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoherraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoHerraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoherras,empleadoherra,empleadoherraParameterGeneral,empleadoherraReturnGeneral,isEsNuevoEmpleadoHerra,clases);
			
			this.connexion.commit();
			
			return empleadoherraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoHerraParameterReturnGeneral procesarImportacionEmpleadoHerrasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpleadoHerraParameterReturnGeneral empleadoherraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-procesarImportacionEmpleadoHerrasWithConnection");connexion.begin();			
			
			EmpleadoHerraParameterReturnGeneral empleadoherraReturnGeneral=new EmpleadoHerraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empleadoherras=new ArrayList<EmpleadoHerra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empleadoherra=new EmpleadoHerra();
				
				
				if(conColumnasBase) {this.empleadoherra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empleadoherra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empleadoherra.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.empleadoherra.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.empleadoherras.add(this.empleadoherra);
			}
			
			this.saveEmpleadoHerras();
			
			this.connexion.commit();
			
			empleadoherraReturnGeneral.setConRetornoEstaProcesado(true);
			empleadoherraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empleadoherraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpleadoHerrasEliminados() throws Exception {				
		
		List<EmpleadoHerra> empleadoherrasAux= new ArrayList<EmpleadoHerra>();
		
		for(EmpleadoHerra empleadoherra:empleadoherras) {
			if(!empleadoherra.getIsDeleted()) {
				empleadoherrasAux.add(empleadoherra);
			}
		}
		
		empleadoherras=empleadoherrasAux;
	}
	
	public void quitarEmpleadoHerrasNulos() throws Exception {				
		
		List<EmpleadoHerra> empleadoherrasAux= new ArrayList<EmpleadoHerra>();
		
		for(EmpleadoHerra empleadoherra : this.empleadoherras) {
			if(empleadoherra==null) {
				empleadoherrasAux.add(empleadoherra);
			}
		}
		
		//this.empleadoherras=empleadoherrasAux;
		
		this.empleadoherras.removeAll(empleadoherrasAux);
	}
	
	public void getSetVersionRowEmpleadoHerraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empleadoherra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empleadoherra.getIsDeleted() || (empleadoherra.getIsChanged()&&!empleadoherra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empleadoherraDataAccess.getSetVersionRowEmpleadoHerra(connexion,empleadoherra.getId());
				
				if(!empleadoherra.getVersionRow().equals(timestamp)) {	
					empleadoherra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empleadoherra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpleadoHerra()throws Exception {	
		
		if(empleadoherra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empleadoherra.getIsDeleted() || (empleadoherra.getIsChanged()&&!empleadoherra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empleadoherraDataAccess.getSetVersionRowEmpleadoHerra(connexion,empleadoherra.getId());
			
			try {							
				if(!empleadoherra.getVersionRow().equals(timestamp)) {	
					empleadoherra.setVersionRow(timestamp);
				}
				
				empleadoherra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpleadoHerrasWithConnection()throws Exception {	
		if(empleadoherras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EmpleadoHerra empleadoherraAux:empleadoherras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empleadoherraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoherraAux.getIsDeleted() || (empleadoherraAux.getIsChanged()&&!empleadoherraAux.getIsNew())) {
						
						timestamp=empleadoherraDataAccess.getSetVersionRowEmpleadoHerra(connexion,empleadoherraAux.getId());
						
						if(!empleadoherra.getVersionRow().equals(timestamp)) {	
							empleadoherraAux.setVersionRow(timestamp);
						}
								
						empleadoherraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpleadoHerras()throws Exception {	
		if(empleadoherras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EmpleadoHerra empleadoherraAux:empleadoherras) {
					if(empleadoherraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoherraAux.getIsDeleted() || (empleadoherraAux.getIsChanged()&&!empleadoherraAux.getIsNew())) {
						
						timestamp=empleadoherraDataAccess.getSetVersionRowEmpleadoHerra(connexion,empleadoherraAux.getId());
						
						if(!empleadoherraAux.getVersionRow().equals(timestamp)) {	
							empleadoherraAux.setVersionRow(timestamp);
						}
						
													
						empleadoherraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpleadoHerraParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoHerraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalHerramienta) throws Exception {
		EmpleadoHerraParameterReturnGeneral  empleadoherraReturnGeneral =new EmpleadoHerraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpleadoHerraWithConnection");connexion.begin();
			
			empleadoherraReturnGeneral =new EmpleadoHerraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoherraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoherraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Herramienta> herramientasForeignKey=new ArrayList<Herramienta>();
			HerramientaLogic herramientaLogic=new HerramientaLogic();
			herramientaLogic.setConnexion(this.connexion);
			herramientaLogic.getHerramientaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalHerramienta.equals("NONE")) {
				herramientaLogic.getTodosHerramientas(finalQueryGlobalHerramienta,new Pagination());
				herramientasForeignKey=herramientaLogic.getHerramientas();
			}

			empleadoherraReturnGeneral.setherramientasForeignKey(herramientasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empleadoherraReturnGeneral;
	}
	
	public EmpleadoHerraParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoHerra(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalHerramienta) throws Exception {
		EmpleadoHerraParameterReturnGeneral  empleadoherraReturnGeneral =new EmpleadoHerraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empleadoherraReturnGeneral =new EmpleadoHerraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoherraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoherraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Herramienta> herramientasForeignKey=new ArrayList<Herramienta>();
			HerramientaLogic herramientaLogic=new HerramientaLogic();
			herramientaLogic.setConnexion(this.connexion);
			herramientaLogic.getHerramientaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalHerramienta.equals("NONE")) {
				herramientaLogic.getTodosHerramientas(finalQueryGlobalHerramienta,new Pagination());
				herramientasForeignKey=herramientaLogic.getHerramientas();
			}

			empleadoherraReturnGeneral.setherramientasForeignKey(herramientasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empleadoherraReturnGeneral;
	}
	
	
	public void deepLoad(EmpleadoHerra empleadoherra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpleadoHerraLogicAdditional.updateEmpleadoHerraToGet(empleadoherra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoherra.setEmpresa(empleadoherraDataAccess.getEmpresa(connexion,empleadoherra));
		empleadoherra.setEmpleado(empleadoherraDataAccess.getEmpleado(connexion,empleadoherra));
		empleadoherra.setHerramienta(empleadoherraDataAccess.getHerramienta(connexion,empleadoherra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoherra.setEmpresa(empleadoherraDataAccess.getEmpresa(connexion,empleadoherra));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoherra.setEmpleado(empleadoherraDataAccess.getEmpleado(connexion,empleadoherra));
				continue;
			}

			if(clas.clas.equals(Herramienta.class)) {
				empleadoherra.setHerramienta(empleadoherraDataAccess.getHerramienta(connexion,empleadoherra));
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
			empleadoherra.setEmpresa(empleadoherraDataAccess.getEmpresa(connexion,empleadoherra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoherra.setEmpleado(empleadoherraDataAccess.getEmpleado(connexion,empleadoherra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Herramienta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoherra.setHerramienta(empleadoherraDataAccess.getHerramienta(connexion,empleadoherra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoherra.setEmpresa(empleadoherraDataAccess.getEmpresa(connexion,empleadoherra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoherra.getEmpresa(),isDeep,deepLoadType,clases);
				
		empleadoherra.setEmpleado(empleadoherraDataAccess.getEmpleado(connexion,empleadoherra));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoherra.getEmpleado(),isDeep,deepLoadType,clases);
				
		empleadoherra.setHerramienta(empleadoherraDataAccess.getHerramienta(connexion,empleadoherra));
		HerramientaLogic herramientaLogic= new HerramientaLogic(connexion);
		herramientaLogic.deepLoad(empleadoherra.getHerramienta(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoherra.setEmpresa(empleadoherraDataAccess.getEmpresa(connexion,empleadoherra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(empleadoherra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoherra.setEmpleado(empleadoherraDataAccess.getEmpleado(connexion,empleadoherra));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleadoherra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Herramienta.class)) {
				empleadoherra.setHerramienta(empleadoherraDataAccess.getHerramienta(connexion,empleadoherra));
				HerramientaLogic herramientaLogic= new HerramientaLogic(connexion);
				herramientaLogic.deepLoad(empleadoherra.getHerramienta(),isDeep,deepLoadType,clases);				
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
			empleadoherra.setEmpresa(empleadoherraDataAccess.getEmpresa(connexion,empleadoherra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(empleadoherra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoherra.setEmpleado(empleadoherraDataAccess.getEmpleado(connexion,empleadoherra));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleadoherra.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Herramienta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoherra.setHerramienta(empleadoherraDataAccess.getHerramienta(connexion,empleadoherra));
			HerramientaLogic herramientaLogic= new HerramientaLogic(connexion);
			herramientaLogic.deepLoad(empleadoherra.getHerramienta(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EmpleadoHerra empleadoherra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpleadoHerraLogicAdditional.updateEmpleadoHerraToSave(empleadoherra,this.arrDatoGeneral);
			
EmpleadoHerraDataAccess.save(empleadoherra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoherra.getEmpresa(),connexion);

		EmpleadoDataAccess.save(empleadoherra.getEmpleado(),connexion);

		HerramientaDataAccess.save(empleadoherra.getHerramienta(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoherra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoherra.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Herramienta.class)) {
				HerramientaDataAccess.save(empleadoherra.getHerramienta(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoherra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoherra.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(empleadoherra.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoherra.getEmpleado(),isDeep,deepLoadType,clases);
				

		HerramientaDataAccess.save(empleadoherra.getHerramienta(),connexion);
		HerramientaLogic herramientaLogic= new HerramientaLogic(connexion);
		herramientaLogic.deepLoad(empleadoherra.getHerramienta(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoherra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(empleadoherra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoherra.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(empleadoherra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Herramienta.class)) {
				HerramientaDataAccess.save(empleadoherra.getHerramienta(),connexion);
				HerramientaLogic herramientaLogic= new HerramientaLogic(connexion);
				herramientaLogic.deepSave(empleadoherra.getHerramienta(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(EmpleadoHerra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empleadoherra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(empleadoherra);
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
			this.deepLoad(this.empleadoherra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EmpleadoHerra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empleadoherras!=null) {
				for(EmpleadoHerra empleadoherra:empleadoherras) {
					this.deepLoad(empleadoherra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(empleadoherras);
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
			if(empleadoherras!=null) {
				for(EmpleadoHerra empleadoherra:empleadoherras) {
					this.deepLoad(empleadoherra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(empleadoherras);
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
			this.getNewConnexionToDeep(EmpleadoHerra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empleadoherra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EmpleadoHerra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empleadoherras!=null) {
				for(EmpleadoHerra empleadoherra:empleadoherras) {
					this.deepSave(empleadoherra,isDeep,deepLoadType,clases);
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
			if(empleadoherras!=null) {
				for(EmpleadoHerra empleadoherra:empleadoherras) {
					this.deepSave(empleadoherra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpleadoHerrasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoHerraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoherras=empleadoherraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoHerrasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoHerraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoherras=empleadoherraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoHerrasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoHerraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoherras=empleadoherraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoHerrasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoHerraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoherras=empleadoherraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoHerrasFK_IdHerramientaWithConnection(String sFinalQuery,Pagination pagination,Long id_herramienta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoHerra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidHerramienta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidHerramienta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_herramienta,EmpleadoHerraConstantesFunciones.IDHERRAMIENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidHerramienta);

			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdHerramienta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoherras=empleadoherraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoHerrasFK_IdHerramienta(String sFinalQuery,Pagination pagination,Long id_herramienta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidHerramienta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidHerramienta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_herramienta,EmpleadoHerraConstantesFunciones.IDHERRAMIENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidHerramienta);

			EmpleadoHerraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdHerramienta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoherras=empleadoherraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(this.empleadoherras);
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
			if(EmpleadoHerraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoHerraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EmpleadoHerra empleadoherra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpleadoHerraConstantesFunciones.ISCONAUDITORIA) {
				if(empleadoherra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoHerraDataAccess.TABLENAME, empleadoherra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoHerraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoHerraLogic.registrarAuditoriaDetallesEmpleadoHerra(connexion,empleadoherra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empleadoherra.getIsDeleted()) {
					/*if(!empleadoherra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpleadoHerraDataAccess.TABLENAME, empleadoherra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpleadoHerraLogic.registrarAuditoriaDetallesEmpleadoHerra(connexion,empleadoherra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoHerraDataAccess.TABLENAME, empleadoherra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empleadoherra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoHerraDataAccess.TABLENAME, empleadoherra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoHerraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoHerraLogic.registrarAuditoriaDetallesEmpleadoHerra(connexion,empleadoherra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpleadoHerra(Connexion connexion,EmpleadoHerra empleadoherra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empleadoherra.getIsNew()||!empleadoherra.getid_empresa().equals(empleadoherra.getEmpleadoHerraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoherra.getEmpleadoHerraOriginal().getid_empresa()!=null)
				{
					strValorActual=empleadoherra.getEmpleadoHerraOriginal().getid_empresa().toString();
				}
				if(empleadoherra.getid_empresa()!=null)
				{
					strValorNuevo=empleadoherra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoHerraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoherra.getIsNew()||!empleadoherra.getid_empleado().equals(empleadoherra.getEmpleadoHerraOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoherra.getEmpleadoHerraOriginal().getid_empleado()!=null)
				{
					strValorActual=empleadoherra.getEmpleadoHerraOriginal().getid_empleado().toString();
				}
				if(empleadoherra.getid_empleado()!=null)
				{
					strValorNuevo=empleadoherra.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoHerraConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoherra.getIsNew()||!empleadoherra.getid_herramienta().equals(empleadoherra.getEmpleadoHerraOriginal().getid_herramienta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoherra.getEmpleadoHerraOriginal().getid_herramienta()!=null)
				{
					strValorActual=empleadoherra.getEmpleadoHerraOriginal().getid_herramienta().toString();
				}
				if(empleadoherra.getid_herramienta()!=null)
				{
					strValorNuevo=empleadoherra.getid_herramienta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoHerraConstantesFunciones.IDHERRAMIENTA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoherra.getIsNew()||!empleadoherra.getcantidad().equals(empleadoherra.getEmpleadoHerraOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoherra.getEmpleadoHerraOriginal().getcantidad()!=null)
				{
					strValorActual=empleadoherra.getEmpleadoHerraOriginal().getcantidad().toString();
				}
				if(empleadoherra.getcantidad()!=null)
				{
					strValorNuevo=empleadoherra.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoHerraConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(empleadoherra.getIsNew()||!empleadoherra.getesta_activo().equals(empleadoherra.getEmpleadoHerraOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoherra.getEmpleadoHerraOriginal().getesta_activo()!=null)
				{
					strValorActual=empleadoherra.getEmpleadoHerraOriginal().getesta_activo().toString();
				}
				if(empleadoherra.getesta_activo()!=null)
				{
					strValorNuevo=empleadoherra.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoHerraConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpleadoHerraRelacionesWithConnection(EmpleadoHerra empleadoherra) throws Exception {

		if(!empleadoherra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoHerraRelacionesBase(empleadoherra,true);
		}
	}

	public void saveEmpleadoHerraRelaciones(EmpleadoHerra empleadoherra)throws Exception {

		if(!empleadoherra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoHerraRelacionesBase(empleadoherra,false);
		}
	}

	public void saveEmpleadoHerraRelacionesBase(EmpleadoHerra empleadoherra,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EmpleadoHerra-saveRelacionesWithConnection");}
	

			this.setEmpleadoHerra(empleadoherra);

			if(EmpleadoHerraLogicAdditional.validarSaveRelaciones(empleadoherra,this)) {

				EmpleadoHerraLogicAdditional.updateRelacionesToSave(empleadoherra,this);

				if((empleadoherra.getIsNew()||empleadoherra.getIsChanged())&&!empleadoherra.getIsDeleted()) {
					this.saveEmpleadoHerra();
					this.saveEmpleadoHerraRelacionesDetalles();

				} else if(empleadoherra.getIsDeleted()) {
					this.saveEmpleadoHerraRelacionesDetalles();
					this.saveEmpleadoHerra();
				}

				EmpleadoHerraLogicAdditional.updateRelacionesToSaveAfter(empleadoherra,this);

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
	
	
	private void saveEmpleadoHerraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoHerra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoHerraConstantesFunciones.getClassesForeignKeysOfEmpleadoHerra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoHerra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoHerraConstantesFunciones.getClassesRelationshipsOfEmpleadoHerra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.nomina.util.EmpleadoDiscaConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoDiscaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoDiscaParameterGeneral;
import com.bydan.erp.nomina.business.entity.EmpleadoDisca;
import com.bydan.erp.nomina.business.logic.EmpleadoDiscaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmpleadoDiscaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpleadoDiscaLogic.class);
	
	protected EmpleadoDiscaDataAccess empleadodiscaDataAccess; 	
	protected EmpleadoDisca empleadodisca;
	protected List<EmpleadoDisca> empleadodiscas;
	protected Object empleadodiscaObject;	
	protected List<Object> empleadodiscasObject;
	
	public static ClassValidator<EmpleadoDisca> empleadodiscaValidator = new ClassValidator<EmpleadoDisca>(EmpleadoDisca.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpleadoDiscaLogicAdditional empleadodiscaLogicAdditional=null;
	
	public EmpleadoDiscaLogicAdditional getEmpleadoDiscaLogicAdditional() {
		return this.empleadodiscaLogicAdditional;
	}
	
	public void setEmpleadoDiscaLogicAdditional(EmpleadoDiscaLogicAdditional empleadodiscaLogicAdditional) {
		try {
			this.empleadodiscaLogicAdditional=empleadodiscaLogicAdditional;
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
	
	
	
	
	public  EmpleadoDiscaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empleadodiscaDataAccess = new EmpleadoDiscaDataAccess();
			
			this.empleadodiscas= new ArrayList<EmpleadoDisca>();
			this.empleadodisca= new EmpleadoDisca();
			
			this.empleadodiscaObject=new Object();
			this.empleadodiscasObject=new ArrayList<Object>();
				
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
			
			this.empleadodiscaDataAccess.setConnexionType(this.connexionType);
			this.empleadodiscaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpleadoDiscaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empleadodiscaDataAccess = new EmpleadoDiscaDataAccess();
			this.empleadodiscas= new ArrayList<EmpleadoDisca>();
			this.empleadodisca= new EmpleadoDisca();
			this.empleadodiscaObject=new Object();
			this.empleadodiscasObject=new ArrayList<Object>();
			
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
			
			this.empleadodiscaDataAccess.setConnexionType(this.connexionType);
			this.empleadodiscaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EmpleadoDisca getEmpleadoDisca() throws Exception {	
		EmpleadoDiscaLogicAdditional.checkEmpleadoDiscaToGet(empleadodisca,this.datosCliente,this.arrDatoGeneral);
		EmpleadoDiscaLogicAdditional.updateEmpleadoDiscaToGet(empleadodisca,this.arrDatoGeneral);
		
		return empleadodisca;
	}
		
	public void setEmpleadoDisca(EmpleadoDisca newEmpleadoDisca) {
		this.empleadodisca = newEmpleadoDisca;
	}
	
	public EmpleadoDiscaDataAccess getEmpleadoDiscaDataAccess() {
		return empleadodiscaDataAccess;
	}
	
	public void setEmpleadoDiscaDataAccess(EmpleadoDiscaDataAccess newempleadodiscaDataAccess) {
		this.empleadodiscaDataAccess = newempleadodiscaDataAccess;
	}
	
	public List<EmpleadoDisca> getEmpleadoDiscas() throws Exception {		
		this.quitarEmpleadoDiscasNulos();
		
		EmpleadoDiscaLogicAdditional.checkEmpleadoDiscaToGets(empleadodiscas,this.datosCliente,this.arrDatoGeneral);
		
		for (EmpleadoDisca empleadodiscaLocal: empleadodiscas ) {
			EmpleadoDiscaLogicAdditional.updateEmpleadoDiscaToGet(empleadodiscaLocal,this.arrDatoGeneral);
		}
		
		return empleadodiscas;
	}
	
	public void setEmpleadoDiscas(List<EmpleadoDisca> newEmpleadoDiscas) {
		this.empleadodiscas = newEmpleadoDiscas;
	}
	
	public Object getEmpleadoDiscaObject() {	
		this.empleadodiscaObject=this.empleadodiscaDataAccess.getEntityObject();
		return this.empleadodiscaObject;
	}
		
	public void setEmpleadoDiscaObject(Object newEmpleadoDiscaObject) {
		this.empleadodiscaObject = newEmpleadoDiscaObject;
	}
	
	public List<Object> getEmpleadoDiscasObject() {		
		this.empleadodiscasObject=this.empleadodiscaDataAccess.getEntitiesObject();
		return this.empleadodiscasObject;
	}
		
	public void setEmpleadoDiscasObject(List<Object> newEmpleadoDiscasObject) {
		this.empleadodiscasObject = newEmpleadoDiscasObject;
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
		
		if(this.empleadodiscaDataAccess!=null) {
			this.empleadodiscaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empleadodiscaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empleadodiscaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empleadodisca = new  EmpleadoDisca();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadodisca=empleadodiscaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadodisca,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodisca);
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
		empleadodisca = new  EmpleadoDisca();
		  		  
        try {
			
			empleadodisca=empleadodiscaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadodisca,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodisca);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empleadodisca = new  EmpleadoDisca();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadodisca=empleadodiscaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadodisca,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodisca);
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
		empleadodisca = new  EmpleadoDisca();
		  		  
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
		empleadodisca = new  EmpleadoDisca();
		  		  
        try {
			
			empleadodisca=empleadodiscaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadodisca,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodisca);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empleadodisca = new  EmpleadoDisca();
		  		  
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
		empleadodisca = new  EmpleadoDisca();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empleadodiscaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadodisca = new  EmpleadoDisca();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empleadodiscaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadodisca = new  EmpleadoDisca();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empleadodiscaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadodisca = new  EmpleadoDisca();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empleadodiscaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadodisca = new  EmpleadoDisca();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empleadodiscaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadodisca = new  EmpleadoDisca();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empleadodiscaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadodiscas = new  ArrayList<EmpleadoDisca>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoDisca(empleadodiscas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
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
		empleadodiscas = new  ArrayList<EmpleadoDisca>();
		  		  
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
		empleadodiscas = new  ArrayList<EmpleadoDisca>();
		  		  
        try {			
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpleadoDisca(empleadodiscas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empleadodiscas = new  ArrayList<EmpleadoDisca>();
		  		  
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
		empleadodiscas = new  ArrayList<EmpleadoDisca>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoDisca(empleadodiscas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
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
		empleadodiscas = new  ArrayList<EmpleadoDisca>();
		  		  
        try {
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoDisca(empleadodiscas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
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
		empleadodiscas = new  ArrayList<EmpleadoDisca>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoDisca(empleadodiscas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
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
		empleadodiscas = new  ArrayList<EmpleadoDisca>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoDisca(empleadodiscas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empleadodisca = new  EmpleadoDisca();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadodisca=empleadodiscaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoDisca(empleadodisca);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodisca);
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
		empleadodisca = new  EmpleadoDisca();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadodisca=empleadodiscaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoDisca(empleadodisca);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodisca);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadodiscas = new  ArrayList<EmpleadoDisca>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadodiscas=empleadodiscaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoDisca(empleadodiscas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
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
		empleadodiscas = new  ArrayList<EmpleadoDisca>();
		  		  
        try {
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadodiscas=empleadodiscaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoDisca(empleadodiscas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpleadoDiscasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empleadodiscas = new  ArrayList<EmpleadoDisca>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getTodosEmpleadoDiscasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoDisca(empleadodiscas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
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
	
	public  void  getTodosEmpleadoDiscas(String sFinalQuery,Pagination pagination)throws Exception {
		empleadodiscas = new  ArrayList<EmpleadoDisca>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoDisca(empleadodiscas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpleadoDisca(EmpleadoDisca empleadodisca) throws Exception {
		Boolean estaValidado=false;
		
		if(empleadodisca.getIsNew() || empleadodisca.getIsChanged()) { 
			this.invalidValues = empleadodiscaValidator.getInvalidValues(empleadodisca);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empleadodisca);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpleadoDisca(List<EmpleadoDisca> EmpleadoDiscas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EmpleadoDisca empleadodiscaLocal:empleadodiscas) {				
			estaValidadoObjeto=this.validarGuardarEmpleadoDisca(empleadodiscaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpleadoDisca(List<EmpleadoDisca> EmpleadoDiscas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoDisca(empleadodiscas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpleadoDisca(EmpleadoDisca EmpleadoDisca) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoDisca(empleadodisca)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EmpleadoDisca empleadodisca) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empleadodisca.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpleadoDiscaConstantesFunciones.getEmpleadoDiscaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empleadodisca","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpleadoDiscaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpleadoDiscaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpleadoDiscaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-saveEmpleadoDiscaWithConnection");connexion.begin();			
			
			EmpleadoDiscaLogicAdditional.checkEmpleadoDiscaToSave(this.empleadodisca,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoDiscaLogicAdditional.updateEmpleadoDiscaToSave(this.empleadodisca,this.arrDatoGeneral);
			
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadodisca,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoDisca();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoDisca(this.empleadodisca)) {
				EmpleadoDiscaDataAccess.save(this.empleadodisca, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empleadodisca,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoDiscaLogicAdditional.checkEmpleadoDiscaToSaveAfter(this.empleadodisca,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoDisca();
			
			connexion.commit();			
			
			if(this.empleadodisca.getIsDeleted()) {
				this.empleadodisca=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpleadoDisca()throws Exception {	
		try {	
			
			EmpleadoDiscaLogicAdditional.checkEmpleadoDiscaToSave(this.empleadodisca,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoDiscaLogicAdditional.updateEmpleadoDiscaToSave(this.empleadodisca,this.arrDatoGeneral);
			
			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadodisca,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoDisca(this.empleadodisca)) {			
				EmpleadoDiscaDataAccess.save(this.empleadodisca, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empleadodisca,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoDiscaLogicAdditional.checkEmpleadoDiscaToSaveAfter(this.empleadodisca,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empleadodisca.getIsDeleted()) {
				this.empleadodisca=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpleadoDiscasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-saveEmpleadoDiscasWithConnection");connexion.begin();			
			
			EmpleadoDiscaLogicAdditional.checkEmpleadoDiscaToSaves(empleadodiscas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoDiscas();
			
			Boolean validadoTodosEmpleadoDisca=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoDisca empleadodiscaLocal:empleadodiscas) {		
				if(empleadodiscaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoDiscaLogicAdditional.updateEmpleadoDiscaToSave(empleadodiscaLocal,this.arrDatoGeneral);
	        	
				EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadodiscaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoDisca(empleadodiscaLocal)) {
					EmpleadoDiscaDataAccess.save(empleadodiscaLocal, connexion);				
				} else {
					validadoTodosEmpleadoDisca=false;
				}
			}
			
			if(!validadoTodosEmpleadoDisca) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoDiscaLogicAdditional.checkEmpleadoDiscaToSavesAfter(empleadodiscas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoDiscas();
			
			connexion.commit();		
			
			this.quitarEmpleadoDiscasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpleadoDiscas()throws Exception {				
		 try {	
			EmpleadoDiscaLogicAdditional.checkEmpleadoDiscaToSaves(empleadodiscas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpleadoDisca=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoDisca empleadodiscaLocal:empleadodiscas) {				
				if(empleadodiscaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoDiscaLogicAdditional.updateEmpleadoDiscaToSave(empleadodiscaLocal,this.arrDatoGeneral);
	        	
				EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadodiscaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoDisca(empleadodiscaLocal)) {				
					EmpleadoDiscaDataAccess.save(empleadodiscaLocal, connexion);				
				} else {
					validadoTodosEmpleadoDisca=false;
				}
			}
			
			if(!validadoTodosEmpleadoDisca) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoDiscaLogicAdditional.checkEmpleadoDiscaToSavesAfter(empleadodiscas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpleadoDiscasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoDiscaParameterReturnGeneral procesarAccionEmpleadoDiscas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoDisca> empleadodiscas,EmpleadoDiscaParameterReturnGeneral empleadodiscaParameterGeneral)throws Exception {
		 try {	
			EmpleadoDiscaParameterReturnGeneral empleadodiscaReturnGeneral=new EmpleadoDiscaParameterReturnGeneral();
	
			EmpleadoDiscaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadodiscas,empleadodiscaParameterGeneral,empleadodiscaReturnGeneral);
			
			return empleadodiscaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoDiscaParameterReturnGeneral procesarAccionEmpleadoDiscasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoDisca> empleadodiscas,EmpleadoDiscaParameterReturnGeneral empleadodiscaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-procesarAccionEmpleadoDiscasWithConnection");connexion.begin();			
			
			EmpleadoDiscaParameterReturnGeneral empleadodiscaReturnGeneral=new EmpleadoDiscaParameterReturnGeneral();
	
			EmpleadoDiscaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadodiscas,empleadodiscaParameterGeneral,empleadodiscaReturnGeneral);
			
			this.connexion.commit();
			
			return empleadodiscaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoDiscaParameterReturnGeneral procesarEventosEmpleadoDiscas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoDisca> empleadodiscas,EmpleadoDisca empleadodisca,EmpleadoDiscaParameterReturnGeneral empleadodiscaParameterGeneral,Boolean isEsNuevoEmpleadoDisca,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpleadoDiscaParameterReturnGeneral empleadodiscaReturnGeneral=new EmpleadoDiscaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadodiscaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoDiscaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadodiscas,empleadodisca,empleadodiscaParameterGeneral,empleadodiscaReturnGeneral,isEsNuevoEmpleadoDisca,clases);
			
			return empleadodiscaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpleadoDiscaParameterReturnGeneral procesarEventosEmpleadoDiscasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoDisca> empleadodiscas,EmpleadoDisca empleadodisca,EmpleadoDiscaParameterReturnGeneral empleadodiscaParameterGeneral,Boolean isEsNuevoEmpleadoDisca,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-procesarEventosEmpleadoDiscasWithConnection");connexion.begin();			
			
			EmpleadoDiscaParameterReturnGeneral empleadodiscaReturnGeneral=new EmpleadoDiscaParameterReturnGeneral();
	
			empleadodiscaReturnGeneral.setEmpleadoDisca(empleadodisca);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadodiscaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoDiscaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadodiscas,empleadodisca,empleadodiscaParameterGeneral,empleadodiscaReturnGeneral,isEsNuevoEmpleadoDisca,clases);
			
			this.connexion.commit();
			
			return empleadodiscaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoDiscaParameterReturnGeneral procesarImportacionEmpleadoDiscasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpleadoDiscaParameterReturnGeneral empleadodiscaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-procesarImportacionEmpleadoDiscasWithConnection");connexion.begin();			
			
			EmpleadoDiscaParameterReturnGeneral empleadodiscaReturnGeneral=new EmpleadoDiscaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empleadodiscas=new ArrayList<EmpleadoDisca>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empleadodisca=new EmpleadoDisca();
				
				
				if(conColumnasBase) {this.empleadodisca.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empleadodisca.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empleadodisca.setporcentaje_inicial(Double.parseDouble(arrColumnas[iColumn++]));
				this.empleadodisca.setporcentaje_final(Double.parseDouble(arrColumnas[iColumn++]));
			this.empleadodisca.setdescripcion(arrColumnas[iColumn++]);
				
				this.empleadodiscas.add(this.empleadodisca);
			}
			
			this.saveEmpleadoDiscas();
			
			this.connexion.commit();
			
			empleadodiscaReturnGeneral.setConRetornoEstaProcesado(true);
			empleadodiscaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empleadodiscaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpleadoDiscasEliminados() throws Exception {				
		
		List<EmpleadoDisca> empleadodiscasAux= new ArrayList<EmpleadoDisca>();
		
		for(EmpleadoDisca empleadodisca:empleadodiscas) {
			if(!empleadodisca.getIsDeleted()) {
				empleadodiscasAux.add(empleadodisca);
			}
		}
		
		empleadodiscas=empleadodiscasAux;
	}
	
	public void quitarEmpleadoDiscasNulos() throws Exception {				
		
		List<EmpleadoDisca> empleadodiscasAux= new ArrayList<EmpleadoDisca>();
		
		for(EmpleadoDisca empleadodisca : this.empleadodiscas) {
			if(empleadodisca==null) {
				empleadodiscasAux.add(empleadodisca);
			}
		}
		
		//this.empleadodiscas=empleadodiscasAux;
		
		this.empleadodiscas.removeAll(empleadodiscasAux);
	}
	
	public void getSetVersionRowEmpleadoDiscaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empleadodisca.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empleadodisca.getIsDeleted() || (empleadodisca.getIsChanged()&&!empleadodisca.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empleadodiscaDataAccess.getSetVersionRowEmpleadoDisca(connexion,empleadodisca.getId());
				
				if(!empleadodisca.getVersionRow().equals(timestamp)) {	
					empleadodisca.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empleadodisca.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpleadoDisca()throws Exception {	
		
		if(empleadodisca.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empleadodisca.getIsDeleted() || (empleadodisca.getIsChanged()&&!empleadodisca.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empleadodiscaDataAccess.getSetVersionRowEmpleadoDisca(connexion,empleadodisca.getId());
			
			try {							
				if(!empleadodisca.getVersionRow().equals(timestamp)) {	
					empleadodisca.setVersionRow(timestamp);
				}
				
				empleadodisca.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpleadoDiscasWithConnection()throws Exception {	
		if(empleadodiscas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EmpleadoDisca empleadodiscaAux:empleadodiscas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empleadodiscaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadodiscaAux.getIsDeleted() || (empleadodiscaAux.getIsChanged()&&!empleadodiscaAux.getIsNew())) {
						
						timestamp=empleadodiscaDataAccess.getSetVersionRowEmpleadoDisca(connexion,empleadodiscaAux.getId());
						
						if(!empleadodisca.getVersionRow().equals(timestamp)) {	
							empleadodiscaAux.setVersionRow(timestamp);
						}
								
						empleadodiscaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpleadoDiscas()throws Exception {	
		if(empleadodiscas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EmpleadoDisca empleadodiscaAux:empleadodiscas) {
					if(empleadodiscaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadodiscaAux.getIsDeleted() || (empleadodiscaAux.getIsChanged()&&!empleadodiscaAux.getIsNew())) {
						
						timestamp=empleadodiscaDataAccess.getSetVersionRowEmpleadoDisca(connexion,empleadodiscaAux.getId());
						
						if(!empleadodiscaAux.getVersionRow().equals(timestamp)) {	
							empleadodiscaAux.setVersionRow(timestamp);
						}
						
													
						empleadodiscaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpleadoDiscaParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoDiscaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoDiscapacidad) throws Exception {
		EmpleadoDiscaParameterReturnGeneral  empleadodiscaReturnGeneral =new EmpleadoDiscaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpleadoDiscaWithConnection");connexion.begin();
			
			empleadodiscaReturnGeneral =new EmpleadoDiscaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadodiscaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadodiscaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoDiscapacidad> tipodiscapacidadsForeignKey=new ArrayList<TipoDiscapacidad>();
			TipoDiscapacidadLogic tipodiscapacidadLogic=new TipoDiscapacidadLogic();
			tipodiscapacidadLogic.setConnexion(this.connexion);
			tipodiscapacidadLogic.getTipoDiscapacidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDiscapacidad.equals("NONE")) {
				tipodiscapacidadLogic.getTodosTipoDiscapacidads(finalQueryGlobalTipoDiscapacidad,new Pagination());
				tipodiscapacidadsForeignKey=tipodiscapacidadLogic.getTipoDiscapacidads();
			}

			empleadodiscaReturnGeneral.settipodiscapacidadsForeignKey(tipodiscapacidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empleadodiscaReturnGeneral;
	}
	
	public EmpleadoDiscaParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoDisca(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoDiscapacidad) throws Exception {
		EmpleadoDiscaParameterReturnGeneral  empleadodiscaReturnGeneral =new EmpleadoDiscaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empleadodiscaReturnGeneral =new EmpleadoDiscaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadodiscaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadodiscaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoDiscapacidad> tipodiscapacidadsForeignKey=new ArrayList<TipoDiscapacidad>();
			TipoDiscapacidadLogic tipodiscapacidadLogic=new TipoDiscapacidadLogic();
			tipodiscapacidadLogic.setConnexion(this.connexion);
			tipodiscapacidadLogic.getTipoDiscapacidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDiscapacidad.equals("NONE")) {
				tipodiscapacidadLogic.getTodosTipoDiscapacidads(finalQueryGlobalTipoDiscapacidad,new Pagination());
				tipodiscapacidadsForeignKey=tipodiscapacidadLogic.getTipoDiscapacidads();
			}

			empleadodiscaReturnGeneral.settipodiscapacidadsForeignKey(tipodiscapacidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empleadodiscaReturnGeneral;
	}
	
	
	public void deepLoad(EmpleadoDisca empleadodisca,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpleadoDiscaLogicAdditional.updateEmpleadoDiscaToGet(empleadodisca,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadodisca.setEmpresa(empleadodiscaDataAccess.getEmpresa(connexion,empleadodisca));
		empleadodisca.setEmpleado(empleadodiscaDataAccess.getEmpleado(connexion,empleadodisca));
		empleadodisca.setTipoDiscapacidad(empleadodiscaDataAccess.getTipoDiscapacidad(connexion,empleadodisca));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadodisca.setEmpresa(empleadodiscaDataAccess.getEmpresa(connexion,empleadodisca));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadodisca.setEmpleado(empleadodiscaDataAccess.getEmpleado(connexion,empleadodisca));
				continue;
			}

			if(clas.clas.equals(TipoDiscapacidad.class)) {
				empleadodisca.setTipoDiscapacidad(empleadodiscaDataAccess.getTipoDiscapacidad(connexion,empleadodisca));
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
			empleadodisca.setEmpresa(empleadodiscaDataAccess.getEmpresa(connexion,empleadodisca));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadodisca.setEmpleado(empleadodiscaDataAccess.getEmpleado(connexion,empleadodisca));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDiscapacidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadodisca.setTipoDiscapacidad(empleadodiscaDataAccess.getTipoDiscapacidad(connexion,empleadodisca));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadodisca.setEmpresa(empleadodiscaDataAccess.getEmpresa(connexion,empleadodisca));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadodisca.getEmpresa(),isDeep,deepLoadType,clases);
				
		empleadodisca.setEmpleado(empleadodiscaDataAccess.getEmpleado(connexion,empleadodisca));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadodisca.getEmpleado(),isDeep,deepLoadType,clases);
				
		empleadodisca.setTipoDiscapacidad(empleadodiscaDataAccess.getTipoDiscapacidad(connexion,empleadodisca));
		TipoDiscapacidadLogic tipodiscapacidadLogic= new TipoDiscapacidadLogic(connexion);
		tipodiscapacidadLogic.deepLoad(empleadodisca.getTipoDiscapacidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadodisca.setEmpresa(empleadodiscaDataAccess.getEmpresa(connexion,empleadodisca));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(empleadodisca.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadodisca.setEmpleado(empleadodiscaDataAccess.getEmpleado(connexion,empleadodisca));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleadodisca.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDiscapacidad.class)) {
				empleadodisca.setTipoDiscapacidad(empleadodiscaDataAccess.getTipoDiscapacidad(connexion,empleadodisca));
				TipoDiscapacidadLogic tipodiscapacidadLogic= new TipoDiscapacidadLogic(connexion);
				tipodiscapacidadLogic.deepLoad(empleadodisca.getTipoDiscapacidad(),isDeep,deepLoadType,clases);				
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
			empleadodisca.setEmpresa(empleadodiscaDataAccess.getEmpresa(connexion,empleadodisca));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(empleadodisca.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadodisca.setEmpleado(empleadodiscaDataAccess.getEmpleado(connexion,empleadodisca));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleadodisca.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDiscapacidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadodisca.setTipoDiscapacidad(empleadodiscaDataAccess.getTipoDiscapacidad(connexion,empleadodisca));
			TipoDiscapacidadLogic tipodiscapacidadLogic= new TipoDiscapacidadLogic(connexion);
			tipodiscapacidadLogic.deepLoad(empleadodisca.getTipoDiscapacidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EmpleadoDisca empleadodisca,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpleadoDiscaLogicAdditional.updateEmpleadoDiscaToSave(empleadodisca,this.arrDatoGeneral);
			
EmpleadoDiscaDataAccess.save(empleadodisca, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadodisca.getEmpresa(),connexion);

		EmpleadoDataAccess.save(empleadodisca.getEmpleado(),connexion);

		TipoDiscapacidadDataAccess.save(empleadodisca.getTipoDiscapacidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadodisca.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadodisca.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDiscapacidad.class)) {
				TipoDiscapacidadDataAccess.save(empleadodisca.getTipoDiscapacidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadodisca.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadodisca.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(empleadodisca.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadodisca.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoDiscapacidadDataAccess.save(empleadodisca.getTipoDiscapacidad(),connexion);
		TipoDiscapacidadLogic tipodiscapacidadLogic= new TipoDiscapacidadLogic(connexion);
		tipodiscapacidadLogic.deepLoad(empleadodisca.getTipoDiscapacidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadodisca.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(empleadodisca.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadodisca.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(empleadodisca.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDiscapacidad.class)) {
				TipoDiscapacidadDataAccess.save(empleadodisca.getTipoDiscapacidad(),connexion);
				TipoDiscapacidadLogic tipodiscapacidadLogic= new TipoDiscapacidadLogic(connexion);
				tipodiscapacidadLogic.deepSave(empleadodisca.getTipoDiscapacidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(EmpleadoDisca.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empleadodisca,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(empleadodisca);
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
			this.deepLoad(this.empleadodisca,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodisca);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EmpleadoDisca.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empleadodiscas!=null) {
				for(EmpleadoDisca empleadodisca:empleadodiscas) {
					this.deepLoad(empleadodisca,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(empleadodiscas);
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
			if(empleadodiscas!=null) {
				for(EmpleadoDisca empleadodisca:empleadodiscas) {
					this.deepLoad(empleadodisca,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(empleadodiscas);
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
			this.getNewConnexionToDeep(EmpleadoDisca.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empleadodisca,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EmpleadoDisca.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empleadodiscas!=null) {
				for(EmpleadoDisca empleadodisca:empleadodiscas) {
					this.deepSave(empleadodisca,isDeep,deepLoadType,clases);
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
			if(empleadodiscas!=null) {
				for(EmpleadoDisca empleadodisca:empleadodiscas) {
					this.deepSave(empleadodisca,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpleadoDiscasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoDiscaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoDiscasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoDiscaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoDiscasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoDiscaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoDiscasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoDiscaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoDiscasFK_IdTipoDiscapacidadWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_discapacidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoDisca.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDiscapacidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDiscapacidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_discapacidad,EmpleadoDiscaConstantesFunciones.IDTIPODISCAPACIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDiscapacidad);

			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDiscapacidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoDiscasFK_IdTipoDiscapacidad(String sFinalQuery,Pagination pagination,Long id_tipo_discapacidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDiscapacidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDiscapacidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_discapacidad,EmpleadoDiscaConstantesFunciones.IDTIPODISCAPACIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDiscapacidad);

			EmpleadoDiscaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDiscapacidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(this.empleadodiscas);
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
			if(EmpleadoDiscaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoDiscaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EmpleadoDisca empleadodisca,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpleadoDiscaConstantesFunciones.ISCONAUDITORIA) {
				if(empleadodisca.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoDiscaDataAccess.TABLENAME, empleadodisca.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoDiscaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoDiscaLogic.registrarAuditoriaDetallesEmpleadoDisca(connexion,empleadodisca,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empleadodisca.getIsDeleted()) {
					/*if(!empleadodisca.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpleadoDiscaDataAccess.TABLENAME, empleadodisca.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpleadoDiscaLogic.registrarAuditoriaDetallesEmpleadoDisca(connexion,empleadodisca,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoDiscaDataAccess.TABLENAME, empleadodisca.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empleadodisca.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoDiscaDataAccess.TABLENAME, empleadodisca.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoDiscaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoDiscaLogic.registrarAuditoriaDetallesEmpleadoDisca(connexion,empleadodisca,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpleadoDisca(Connexion connexion,EmpleadoDisca empleadodisca)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empleadodisca.getIsNew()||!empleadodisca.getid_empresa().equals(empleadodisca.getEmpleadoDiscaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadodisca.getEmpleadoDiscaOriginal().getid_empresa()!=null)
				{
					strValorActual=empleadodisca.getEmpleadoDiscaOriginal().getid_empresa().toString();
				}
				if(empleadodisca.getid_empresa()!=null)
				{
					strValorNuevo=empleadodisca.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoDiscaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empleadodisca.getIsNew()||!empleadodisca.getid_empleado().equals(empleadodisca.getEmpleadoDiscaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadodisca.getEmpleadoDiscaOriginal().getid_empleado()!=null)
				{
					strValorActual=empleadodisca.getEmpleadoDiscaOriginal().getid_empleado().toString();
				}
				if(empleadodisca.getid_empleado()!=null)
				{
					strValorNuevo=empleadodisca.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoDiscaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(empleadodisca.getIsNew()||!empleadodisca.getid_tipo_discapacidad().equals(empleadodisca.getEmpleadoDiscaOriginal().getid_tipo_discapacidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadodisca.getEmpleadoDiscaOriginal().getid_tipo_discapacidad()!=null)
				{
					strValorActual=empleadodisca.getEmpleadoDiscaOriginal().getid_tipo_discapacidad().toString();
				}
				if(empleadodisca.getid_tipo_discapacidad()!=null)
				{
					strValorNuevo=empleadodisca.getid_tipo_discapacidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoDiscaConstantesFunciones.IDTIPODISCAPACIDAD,strValorActual,strValorNuevo);
			}	
			
			if(empleadodisca.getIsNew()||!empleadodisca.getporcentaje_inicial().equals(empleadodisca.getEmpleadoDiscaOriginal().getporcentaje_inicial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadodisca.getEmpleadoDiscaOriginal().getporcentaje_inicial()!=null)
				{
					strValorActual=empleadodisca.getEmpleadoDiscaOriginal().getporcentaje_inicial().toString();
				}
				if(empleadodisca.getporcentaje_inicial()!=null)
				{
					strValorNuevo=empleadodisca.getporcentaje_inicial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoDiscaConstantesFunciones.PORCENTAJEINICIAL,strValorActual,strValorNuevo);
			}	
			
			if(empleadodisca.getIsNew()||!empleadodisca.getporcentaje_final().equals(empleadodisca.getEmpleadoDiscaOriginal().getporcentaje_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadodisca.getEmpleadoDiscaOriginal().getporcentaje_final()!=null)
				{
					strValorActual=empleadodisca.getEmpleadoDiscaOriginal().getporcentaje_final().toString();
				}
				if(empleadodisca.getporcentaje_final()!=null)
				{
					strValorNuevo=empleadodisca.getporcentaje_final().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoDiscaConstantesFunciones.PORCENTAJEFINAL,strValorActual,strValorNuevo);
			}	
			
			if(empleadodisca.getIsNew()||!empleadodisca.getdescripcion().equals(empleadodisca.getEmpleadoDiscaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadodisca.getEmpleadoDiscaOriginal().getdescripcion()!=null)
				{
					strValorActual=empleadodisca.getEmpleadoDiscaOriginal().getdescripcion();
				}
				if(empleadodisca.getdescripcion()!=null)
				{
					strValorNuevo=empleadodisca.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoDiscaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpleadoDiscaRelacionesWithConnection(EmpleadoDisca empleadodisca) throws Exception {

		if(!empleadodisca.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoDiscaRelacionesBase(empleadodisca,true);
		}
	}

	public void saveEmpleadoDiscaRelaciones(EmpleadoDisca empleadodisca)throws Exception {

		if(!empleadodisca.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoDiscaRelacionesBase(empleadodisca,false);
		}
	}

	public void saveEmpleadoDiscaRelacionesBase(EmpleadoDisca empleadodisca,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EmpleadoDisca-saveRelacionesWithConnection");}
	

			this.setEmpleadoDisca(empleadodisca);

			if(EmpleadoDiscaLogicAdditional.validarSaveRelaciones(empleadodisca,this)) {

				EmpleadoDiscaLogicAdditional.updateRelacionesToSave(empleadodisca,this);

				if((empleadodisca.getIsNew()||empleadodisca.getIsChanged())&&!empleadodisca.getIsDeleted()) {
					this.saveEmpleadoDisca();
					this.saveEmpleadoDiscaRelacionesDetalles();

				} else if(empleadodisca.getIsDeleted()) {
					this.saveEmpleadoDiscaRelacionesDetalles();
					this.saveEmpleadoDisca();
				}

				EmpleadoDiscaLogicAdditional.updateRelacionesToSaveAfter(empleadodisca,this);

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
	
	
	private void saveEmpleadoDiscaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoDisca(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoDiscaConstantesFunciones.getClassesForeignKeysOfEmpleadoDisca(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoDisca(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoDiscaConstantesFunciones.getClassesRelationshipsOfEmpleadoDisca(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.nomina.util.EmpleadoEstructuraConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoEstructuraParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoEstructuraParameterGeneral;
import com.bydan.erp.nomina.business.entity.EmpleadoEstructura;
import com.bydan.erp.nomina.business.logic.EmpleadoEstructuraLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmpleadoEstructuraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpleadoEstructuraLogic.class);
	
	protected EmpleadoEstructuraDataAccess empleadoestructuraDataAccess; 	
	protected EmpleadoEstructura empleadoestructura;
	protected List<EmpleadoEstructura> empleadoestructuras;
	protected Object empleadoestructuraObject;	
	protected List<Object> empleadoestructurasObject;
	
	public static ClassValidator<EmpleadoEstructura> empleadoestructuraValidator = new ClassValidator<EmpleadoEstructura>(EmpleadoEstructura.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpleadoEstructuraLogicAdditional empleadoestructuraLogicAdditional=null;
	
	public EmpleadoEstructuraLogicAdditional getEmpleadoEstructuraLogicAdditional() {
		return this.empleadoestructuraLogicAdditional;
	}
	
	public void setEmpleadoEstructuraLogicAdditional(EmpleadoEstructuraLogicAdditional empleadoestructuraLogicAdditional) {
		try {
			this.empleadoestructuraLogicAdditional=empleadoestructuraLogicAdditional;
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
	
	
	
	
	public  EmpleadoEstructuraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empleadoestructuraDataAccess = new EmpleadoEstructuraDataAccess();
			
			this.empleadoestructuras= new ArrayList<EmpleadoEstructura>();
			this.empleadoestructura= new EmpleadoEstructura();
			
			this.empleadoestructuraObject=new Object();
			this.empleadoestructurasObject=new ArrayList<Object>();
				
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
			
			this.empleadoestructuraDataAccess.setConnexionType(this.connexionType);
			this.empleadoestructuraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpleadoEstructuraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empleadoestructuraDataAccess = new EmpleadoEstructuraDataAccess();
			this.empleadoestructuras= new ArrayList<EmpleadoEstructura>();
			this.empleadoestructura= new EmpleadoEstructura();
			this.empleadoestructuraObject=new Object();
			this.empleadoestructurasObject=new ArrayList<Object>();
			
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
			
			this.empleadoestructuraDataAccess.setConnexionType(this.connexionType);
			this.empleadoestructuraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EmpleadoEstructura getEmpleadoEstructura() throws Exception {	
		EmpleadoEstructuraLogicAdditional.checkEmpleadoEstructuraToGet(empleadoestructura,this.datosCliente,this.arrDatoGeneral);
		EmpleadoEstructuraLogicAdditional.updateEmpleadoEstructuraToGet(empleadoestructura,this.arrDatoGeneral);
		
		return empleadoestructura;
	}
		
	public void setEmpleadoEstructura(EmpleadoEstructura newEmpleadoEstructura) {
		this.empleadoestructura = newEmpleadoEstructura;
	}
	
	public EmpleadoEstructuraDataAccess getEmpleadoEstructuraDataAccess() {
		return empleadoestructuraDataAccess;
	}
	
	public void setEmpleadoEstructuraDataAccess(EmpleadoEstructuraDataAccess newempleadoestructuraDataAccess) {
		this.empleadoestructuraDataAccess = newempleadoestructuraDataAccess;
	}
	
	public List<EmpleadoEstructura> getEmpleadoEstructuras() throws Exception {		
		this.quitarEmpleadoEstructurasNulos();
		
		EmpleadoEstructuraLogicAdditional.checkEmpleadoEstructuraToGets(empleadoestructuras,this.datosCliente,this.arrDatoGeneral);
		
		for (EmpleadoEstructura empleadoestructuraLocal: empleadoestructuras ) {
			EmpleadoEstructuraLogicAdditional.updateEmpleadoEstructuraToGet(empleadoestructuraLocal,this.arrDatoGeneral);
		}
		
		return empleadoestructuras;
	}
	
	public void setEmpleadoEstructuras(List<EmpleadoEstructura> newEmpleadoEstructuras) {
		this.empleadoestructuras = newEmpleadoEstructuras;
	}
	
	public Object getEmpleadoEstructuraObject() {	
		this.empleadoestructuraObject=this.empleadoestructuraDataAccess.getEntityObject();
		return this.empleadoestructuraObject;
	}
		
	public void setEmpleadoEstructuraObject(Object newEmpleadoEstructuraObject) {
		this.empleadoestructuraObject = newEmpleadoEstructuraObject;
	}
	
	public List<Object> getEmpleadoEstructurasObject() {		
		this.empleadoestructurasObject=this.empleadoestructuraDataAccess.getEntitiesObject();
		return this.empleadoestructurasObject;
	}
		
	public void setEmpleadoEstructurasObject(List<Object> newEmpleadoEstructurasObject) {
		this.empleadoestructurasObject = newEmpleadoEstructurasObject;
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
		
		if(this.empleadoestructuraDataAccess!=null) {
			this.empleadoestructuraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empleadoestructuraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empleadoestructuraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empleadoestructura = new  EmpleadoEstructura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoestructura=empleadoestructuraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoestructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructura);
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
		empleadoestructura = new  EmpleadoEstructura();
		  		  
        try {
			
			empleadoestructura=empleadoestructuraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoestructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empleadoestructura = new  EmpleadoEstructura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoestructura=empleadoestructuraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoestructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructura);
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
		empleadoestructura = new  EmpleadoEstructura();
		  		  
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
		empleadoestructura = new  EmpleadoEstructura();
		  		  
        try {
			
			empleadoestructura=empleadoestructuraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoestructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empleadoestructura = new  EmpleadoEstructura();
		  		  
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
		empleadoestructura = new  EmpleadoEstructura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empleadoestructuraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoestructura = new  EmpleadoEstructura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empleadoestructuraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoestructura = new  EmpleadoEstructura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empleadoestructuraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoestructura = new  EmpleadoEstructura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empleadoestructuraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoestructura = new  EmpleadoEstructura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empleadoestructuraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoestructura = new  EmpleadoEstructura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empleadoestructuraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoestructuras = new  ArrayList<EmpleadoEstructura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoEstructura(empleadoestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
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
		empleadoestructuras = new  ArrayList<EmpleadoEstructura>();
		  		  
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
		empleadoestructuras = new  ArrayList<EmpleadoEstructura>();
		  		  
        try {			
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpleadoEstructura(empleadoestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empleadoestructuras = new  ArrayList<EmpleadoEstructura>();
		  		  
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
		empleadoestructuras = new  ArrayList<EmpleadoEstructura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoEstructura(empleadoestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
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
		empleadoestructuras = new  ArrayList<EmpleadoEstructura>();
		  		  
        try {
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoEstructura(empleadoestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
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
		empleadoestructuras = new  ArrayList<EmpleadoEstructura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoEstructura(empleadoestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
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
		empleadoestructuras = new  ArrayList<EmpleadoEstructura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoEstructura(empleadoestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empleadoestructura = new  EmpleadoEstructura();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoestructura=empleadoestructuraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoEstructura(empleadoestructura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructura);
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
		empleadoestructura = new  EmpleadoEstructura();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoestructura=empleadoestructuraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoEstructura(empleadoestructura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoestructuras = new  ArrayList<EmpleadoEstructura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoestructuras=empleadoestructuraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoEstructura(empleadoestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
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
		empleadoestructuras = new  ArrayList<EmpleadoEstructura>();
		  		  
        try {
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoestructuras=empleadoestructuraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoEstructura(empleadoestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpleadoEstructurasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoestructuras = new  ArrayList<EmpleadoEstructura>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getTodosEmpleadoEstructurasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoEstructura(empleadoestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
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
	
	public  void  getTodosEmpleadoEstructuras(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoestructuras = new  ArrayList<EmpleadoEstructura>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoEstructura(empleadoestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpleadoEstructura(EmpleadoEstructura empleadoestructura) throws Exception {
		Boolean estaValidado=false;
		
		if(empleadoestructura.getIsNew() || empleadoestructura.getIsChanged()) { 
			this.invalidValues = empleadoestructuraValidator.getInvalidValues(empleadoestructura);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empleadoestructura);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpleadoEstructura(List<EmpleadoEstructura> EmpleadoEstructuras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EmpleadoEstructura empleadoestructuraLocal:empleadoestructuras) {				
			estaValidadoObjeto=this.validarGuardarEmpleadoEstructura(empleadoestructuraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpleadoEstructura(List<EmpleadoEstructura> EmpleadoEstructuras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoEstructura(empleadoestructuras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpleadoEstructura(EmpleadoEstructura EmpleadoEstructura) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoEstructura(empleadoestructura)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EmpleadoEstructura empleadoestructura) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empleadoestructura.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpleadoEstructuraConstantesFunciones.getEmpleadoEstructuraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empleadoestructura","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpleadoEstructuraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpleadoEstructuraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpleadoEstructuraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-saveEmpleadoEstructuraWithConnection");connexion.begin();			
			
			EmpleadoEstructuraLogicAdditional.checkEmpleadoEstructuraToSave(this.empleadoestructura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoEstructuraLogicAdditional.updateEmpleadoEstructuraToSave(this.empleadoestructura,this.arrDatoGeneral);
			
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoestructura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoEstructura();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoEstructura(this.empleadoestructura)) {
				EmpleadoEstructuraDataAccess.save(this.empleadoestructura, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empleadoestructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoEstructuraLogicAdditional.checkEmpleadoEstructuraToSaveAfter(this.empleadoestructura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoEstructura();
			
			connexion.commit();			
			
			if(this.empleadoestructura.getIsDeleted()) {
				this.empleadoestructura=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpleadoEstructura()throws Exception {	
		try {	
			
			EmpleadoEstructuraLogicAdditional.checkEmpleadoEstructuraToSave(this.empleadoestructura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoEstructuraLogicAdditional.updateEmpleadoEstructuraToSave(this.empleadoestructura,this.arrDatoGeneral);
			
			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoestructura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoEstructura(this.empleadoestructura)) {			
				EmpleadoEstructuraDataAccess.save(this.empleadoestructura, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empleadoestructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoEstructuraLogicAdditional.checkEmpleadoEstructuraToSaveAfter(this.empleadoestructura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empleadoestructura.getIsDeleted()) {
				this.empleadoestructura=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpleadoEstructurasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-saveEmpleadoEstructurasWithConnection");connexion.begin();			
			
			EmpleadoEstructuraLogicAdditional.checkEmpleadoEstructuraToSaves(empleadoestructuras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoEstructuras();
			
			Boolean validadoTodosEmpleadoEstructura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoEstructura empleadoestructuraLocal:empleadoestructuras) {		
				if(empleadoestructuraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoEstructuraLogicAdditional.updateEmpleadoEstructuraToSave(empleadoestructuraLocal,this.arrDatoGeneral);
	        	
				EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoestructuraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoEstructura(empleadoestructuraLocal)) {
					EmpleadoEstructuraDataAccess.save(empleadoestructuraLocal, connexion);				
				} else {
					validadoTodosEmpleadoEstructura=false;
				}
			}
			
			if(!validadoTodosEmpleadoEstructura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoEstructuraLogicAdditional.checkEmpleadoEstructuraToSavesAfter(empleadoestructuras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoEstructuras();
			
			connexion.commit();		
			
			this.quitarEmpleadoEstructurasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpleadoEstructuras()throws Exception {				
		 try {	
			EmpleadoEstructuraLogicAdditional.checkEmpleadoEstructuraToSaves(empleadoestructuras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpleadoEstructura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoEstructura empleadoestructuraLocal:empleadoestructuras) {				
				if(empleadoestructuraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoEstructuraLogicAdditional.updateEmpleadoEstructuraToSave(empleadoestructuraLocal,this.arrDatoGeneral);
	        	
				EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoestructuraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoEstructura(empleadoestructuraLocal)) {				
					EmpleadoEstructuraDataAccess.save(empleadoestructuraLocal, connexion);				
				} else {
					validadoTodosEmpleadoEstructura=false;
				}
			}
			
			if(!validadoTodosEmpleadoEstructura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoEstructuraLogicAdditional.checkEmpleadoEstructuraToSavesAfter(empleadoestructuras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpleadoEstructurasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoEstructuraParameterReturnGeneral procesarAccionEmpleadoEstructuras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoEstructura> empleadoestructuras,EmpleadoEstructuraParameterReturnGeneral empleadoestructuraParameterGeneral)throws Exception {
		 try {	
			EmpleadoEstructuraParameterReturnGeneral empleadoestructuraReturnGeneral=new EmpleadoEstructuraParameterReturnGeneral();
	
			EmpleadoEstructuraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoestructuras,empleadoestructuraParameterGeneral,empleadoestructuraReturnGeneral);
			
			return empleadoestructuraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoEstructuraParameterReturnGeneral procesarAccionEmpleadoEstructurasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoEstructura> empleadoestructuras,EmpleadoEstructuraParameterReturnGeneral empleadoestructuraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-procesarAccionEmpleadoEstructurasWithConnection");connexion.begin();			
			
			EmpleadoEstructuraParameterReturnGeneral empleadoestructuraReturnGeneral=new EmpleadoEstructuraParameterReturnGeneral();
	
			EmpleadoEstructuraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoestructuras,empleadoestructuraParameterGeneral,empleadoestructuraReturnGeneral);
			
			this.connexion.commit();
			
			return empleadoestructuraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoEstructuraParameterReturnGeneral procesarEventosEmpleadoEstructuras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoEstructura> empleadoestructuras,EmpleadoEstructura empleadoestructura,EmpleadoEstructuraParameterReturnGeneral empleadoestructuraParameterGeneral,Boolean isEsNuevoEmpleadoEstructura,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpleadoEstructuraParameterReturnGeneral empleadoestructuraReturnGeneral=new EmpleadoEstructuraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoestructuraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoEstructuraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoestructuras,empleadoestructura,empleadoestructuraParameterGeneral,empleadoestructuraReturnGeneral,isEsNuevoEmpleadoEstructura,clases);
			
			return empleadoestructuraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpleadoEstructuraParameterReturnGeneral procesarEventosEmpleadoEstructurasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoEstructura> empleadoestructuras,EmpleadoEstructura empleadoestructura,EmpleadoEstructuraParameterReturnGeneral empleadoestructuraParameterGeneral,Boolean isEsNuevoEmpleadoEstructura,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-procesarEventosEmpleadoEstructurasWithConnection");connexion.begin();			
			
			EmpleadoEstructuraParameterReturnGeneral empleadoestructuraReturnGeneral=new EmpleadoEstructuraParameterReturnGeneral();
	
			empleadoestructuraReturnGeneral.setEmpleadoEstructura(empleadoestructura);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoestructuraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoEstructuraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoestructuras,empleadoestructura,empleadoestructuraParameterGeneral,empleadoestructuraReturnGeneral,isEsNuevoEmpleadoEstructura,clases);
			
			this.connexion.commit();
			
			return empleadoestructuraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoEstructuraParameterReturnGeneral procesarImportacionEmpleadoEstructurasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpleadoEstructuraParameterReturnGeneral empleadoestructuraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-procesarImportacionEmpleadoEstructurasWithConnection");connexion.begin();			
			
			EmpleadoEstructuraParameterReturnGeneral empleadoestructuraReturnGeneral=new EmpleadoEstructuraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empleadoestructuras=new ArrayList<EmpleadoEstructura>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empleadoestructura=new EmpleadoEstructura();
				
				
				if(conColumnasBase) {this.empleadoestructura.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empleadoestructura.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empleadoestructura.setfecha_ingreso(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.empleadoestructura.setfecha_salida(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.empleadoestructura.setnumero_reingreso(Integer.parseInt(arrColumnas[iColumn++]));
				this.empleadoestructura.setdescripcion(arrColumnas[iColumn++]);
				
				this.empleadoestructuras.add(this.empleadoestructura);
			}
			
			this.saveEmpleadoEstructuras();
			
			this.connexion.commit();
			
			empleadoestructuraReturnGeneral.setConRetornoEstaProcesado(true);
			empleadoestructuraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empleadoestructuraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpleadoEstructurasEliminados() throws Exception {				
		
		List<EmpleadoEstructura> empleadoestructurasAux= new ArrayList<EmpleadoEstructura>();
		
		for(EmpleadoEstructura empleadoestructura:empleadoestructuras) {
			if(!empleadoestructura.getIsDeleted()) {
				empleadoestructurasAux.add(empleadoestructura);
			}
		}
		
		empleadoestructuras=empleadoestructurasAux;
	}
	
	public void quitarEmpleadoEstructurasNulos() throws Exception {				
		
		List<EmpleadoEstructura> empleadoestructurasAux= new ArrayList<EmpleadoEstructura>();
		
		for(EmpleadoEstructura empleadoestructura : this.empleadoestructuras) {
			if(empleadoestructura==null) {
				empleadoestructurasAux.add(empleadoestructura);
			}
		}
		
		//this.empleadoestructuras=empleadoestructurasAux;
		
		this.empleadoestructuras.removeAll(empleadoestructurasAux);
	}
	
	public void getSetVersionRowEmpleadoEstructuraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empleadoestructura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empleadoestructura.getIsDeleted() || (empleadoestructura.getIsChanged()&&!empleadoestructura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empleadoestructuraDataAccess.getSetVersionRowEmpleadoEstructura(connexion,empleadoestructura.getId());
				
				if(!empleadoestructura.getVersionRow().equals(timestamp)) {	
					empleadoestructura.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empleadoestructura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpleadoEstructura()throws Exception {	
		
		if(empleadoestructura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empleadoestructura.getIsDeleted() || (empleadoestructura.getIsChanged()&&!empleadoestructura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empleadoestructuraDataAccess.getSetVersionRowEmpleadoEstructura(connexion,empleadoestructura.getId());
			
			try {							
				if(!empleadoestructura.getVersionRow().equals(timestamp)) {	
					empleadoestructura.setVersionRow(timestamp);
				}
				
				empleadoestructura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpleadoEstructurasWithConnection()throws Exception {	
		if(empleadoestructuras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EmpleadoEstructura empleadoestructuraAux:empleadoestructuras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empleadoestructuraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoestructuraAux.getIsDeleted() || (empleadoestructuraAux.getIsChanged()&&!empleadoestructuraAux.getIsNew())) {
						
						timestamp=empleadoestructuraDataAccess.getSetVersionRowEmpleadoEstructura(connexion,empleadoestructuraAux.getId());
						
						if(!empleadoestructura.getVersionRow().equals(timestamp)) {	
							empleadoestructuraAux.setVersionRow(timestamp);
						}
								
						empleadoestructuraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpleadoEstructuras()throws Exception {	
		if(empleadoestructuras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EmpleadoEstructura empleadoestructuraAux:empleadoestructuras) {
					if(empleadoestructuraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoestructuraAux.getIsDeleted() || (empleadoestructuraAux.getIsChanged()&&!empleadoestructuraAux.getIsNew())) {
						
						timestamp=empleadoestructuraDataAccess.getSetVersionRowEmpleadoEstructura(connexion,empleadoestructuraAux.getId());
						
						if(!empleadoestructuraAux.getVersionRow().equals(timestamp)) {	
							empleadoestructuraAux.setVersionRow(timestamp);
						}
						
													
						empleadoestructuraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpleadoEstructuraParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoEstructuraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalCargo) throws Exception {
		EmpleadoEstructuraParameterReturnGeneral  empleadoestructuraReturnGeneral =new EmpleadoEstructuraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpleadoEstructuraWithConnection");connexion.begin();
			
			empleadoestructuraReturnGeneral =new EmpleadoEstructuraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoestructuraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			empleadoestructuraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoestructuraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			empleadoestructuraReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Cargo> cargosForeignKey=new ArrayList<Cargo>();
			CargoLogic cargoLogic=new CargoLogic();
			cargoLogic.setConnexion(this.connexion);
			cargoLogic.getCargoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCargo.equals("NONE")) {
				cargoLogic.getTodosCargos(finalQueryGlobalCargo,new Pagination());
				cargosForeignKey=cargoLogic.getCargos();
			}

			empleadoestructuraReturnGeneral.setcargosForeignKey(cargosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empleadoestructuraReturnGeneral;
	}
	
	public EmpleadoEstructuraParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoEstructura(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalCargo) throws Exception {
		EmpleadoEstructuraParameterReturnGeneral  empleadoestructuraReturnGeneral =new EmpleadoEstructuraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empleadoestructuraReturnGeneral =new EmpleadoEstructuraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoestructuraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			empleadoestructuraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoestructuraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			empleadoestructuraReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Cargo> cargosForeignKey=new ArrayList<Cargo>();
			CargoLogic cargoLogic=new CargoLogic();
			cargoLogic.setConnexion(this.connexion);
			cargoLogic.getCargoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCargo.equals("NONE")) {
				cargoLogic.getTodosCargos(finalQueryGlobalCargo,new Pagination());
				cargosForeignKey=cargoLogic.getCargos();
			}

			empleadoestructuraReturnGeneral.setcargosForeignKey(cargosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empleadoestructuraReturnGeneral;
	}
	
	
	public void deepLoad(EmpleadoEstructura empleadoestructura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpleadoEstructuraLogicAdditional.updateEmpleadoEstructuraToGet(empleadoestructura,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoestructura.setEmpresa(empleadoestructuraDataAccess.getEmpresa(connexion,empleadoestructura));
		empleadoestructura.setSucursal(empleadoestructuraDataAccess.getSucursal(connexion,empleadoestructura));
		empleadoestructura.setEmpleado(empleadoestructuraDataAccess.getEmpleado(connexion,empleadoestructura));
		empleadoestructura.setEstructura(empleadoestructuraDataAccess.getEstructura(connexion,empleadoestructura));
		empleadoestructura.setCargo(empleadoestructuraDataAccess.getCargo(connexion,empleadoestructura));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoestructura.setEmpresa(empleadoestructuraDataAccess.getEmpresa(connexion,empleadoestructura));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				empleadoestructura.setSucursal(empleadoestructuraDataAccess.getSucursal(connexion,empleadoestructura));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoestructura.setEmpleado(empleadoestructuraDataAccess.getEmpleado(connexion,empleadoestructura));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				empleadoestructura.setEstructura(empleadoestructuraDataAccess.getEstructura(connexion,empleadoestructura));
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				empleadoestructura.setCargo(empleadoestructuraDataAccess.getCargo(connexion,empleadoestructura));
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
			empleadoestructura.setEmpresa(empleadoestructuraDataAccess.getEmpresa(connexion,empleadoestructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoestructura.setSucursal(empleadoestructuraDataAccess.getSucursal(connexion,empleadoestructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoestructura.setEmpleado(empleadoestructuraDataAccess.getEmpleado(connexion,empleadoestructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoestructura.setEstructura(empleadoestructuraDataAccess.getEstructura(connexion,empleadoestructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoestructura.setCargo(empleadoestructuraDataAccess.getCargo(connexion,empleadoestructura));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoestructura.setEmpresa(empleadoestructuraDataAccess.getEmpresa(connexion,empleadoestructura));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoestructura.getEmpresa(),isDeep,deepLoadType,clases);
				
		empleadoestructura.setSucursal(empleadoestructuraDataAccess.getSucursal(connexion,empleadoestructura));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(empleadoestructura.getSucursal(),isDeep,deepLoadType,clases);
				
		empleadoestructura.setEmpleado(empleadoestructuraDataAccess.getEmpleado(connexion,empleadoestructura));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoestructura.getEmpleado(),isDeep,deepLoadType,clases);
				
		empleadoestructura.setEstructura(empleadoestructuraDataAccess.getEstructura(connexion,empleadoestructura));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(empleadoestructura.getEstructura(),isDeep,deepLoadType,clases);
				
		empleadoestructura.setCargo(empleadoestructuraDataAccess.getCargo(connexion,empleadoestructura));
		CargoLogic cargoLogic= new CargoLogic(connexion);
		cargoLogic.deepLoad(empleadoestructura.getCargo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoestructura.setEmpresa(empleadoestructuraDataAccess.getEmpresa(connexion,empleadoestructura));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(empleadoestructura.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				empleadoestructura.setSucursal(empleadoestructuraDataAccess.getSucursal(connexion,empleadoestructura));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(empleadoestructura.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoestructura.setEmpleado(empleadoestructuraDataAccess.getEmpleado(connexion,empleadoestructura));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleadoestructura.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				empleadoestructura.setEstructura(empleadoestructuraDataAccess.getEstructura(connexion,empleadoestructura));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(empleadoestructura.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				empleadoestructura.setCargo(empleadoestructuraDataAccess.getCargo(connexion,empleadoestructura));
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepLoad(empleadoestructura.getCargo(),isDeep,deepLoadType,clases);				
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
			empleadoestructura.setEmpresa(empleadoestructuraDataAccess.getEmpresa(connexion,empleadoestructura));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(empleadoestructura.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoestructura.setSucursal(empleadoestructuraDataAccess.getSucursal(connexion,empleadoestructura));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(empleadoestructura.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoestructura.setEmpleado(empleadoestructuraDataAccess.getEmpleado(connexion,empleadoestructura));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleadoestructura.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoestructura.setEstructura(empleadoestructuraDataAccess.getEstructura(connexion,empleadoestructura));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(empleadoestructura.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoestructura.setCargo(empleadoestructuraDataAccess.getCargo(connexion,empleadoestructura));
			CargoLogic cargoLogic= new CargoLogic(connexion);
			cargoLogic.deepLoad(empleadoestructura.getCargo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EmpleadoEstructura empleadoestructura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpleadoEstructuraLogicAdditional.updateEmpleadoEstructuraToSave(empleadoestructura,this.arrDatoGeneral);
			
EmpleadoEstructuraDataAccess.save(empleadoestructura, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoestructura.getEmpresa(),connexion);

		SucursalDataAccess.save(empleadoestructura.getSucursal(),connexion);

		EmpleadoDataAccess.save(empleadoestructura.getEmpleado(),connexion);

		EstructuraDataAccess.save(empleadoestructura.getEstructura(),connexion);

		CargoDataAccess.save(empleadoestructura.getCargo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoestructura.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(empleadoestructura.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoestructura.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(empleadoestructura.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				CargoDataAccess.save(empleadoestructura.getCargo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoestructura.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoestructura.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(empleadoestructura.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(empleadoestructura.getSucursal(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(empleadoestructura.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoestructura.getEmpleado(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(empleadoestructura.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(empleadoestructura.getEstructura(),isDeep,deepLoadType,clases);
				

		CargoDataAccess.save(empleadoestructura.getCargo(),connexion);
		CargoLogic cargoLogic= new CargoLogic(connexion);
		cargoLogic.deepLoad(empleadoestructura.getCargo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoestructura.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(empleadoestructura.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(empleadoestructura.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(empleadoestructura.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoestructura.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(empleadoestructura.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(empleadoestructura.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(empleadoestructura.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				CargoDataAccess.save(empleadoestructura.getCargo(),connexion);
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepSave(empleadoestructura.getCargo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(EmpleadoEstructura.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empleadoestructura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(empleadoestructura);
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
			this.deepLoad(this.empleadoestructura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EmpleadoEstructura.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empleadoestructuras!=null) {
				for(EmpleadoEstructura empleadoestructura:empleadoestructuras) {
					this.deepLoad(empleadoestructura,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(empleadoestructuras);
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
			if(empleadoestructuras!=null) {
				for(EmpleadoEstructura empleadoestructura:empleadoestructuras) {
					this.deepLoad(empleadoestructura,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(empleadoestructuras);
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
			this.getNewConnexionToDeep(EmpleadoEstructura.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empleadoestructura,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EmpleadoEstructura.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empleadoestructuras!=null) {
				for(EmpleadoEstructura empleadoestructura:empleadoestructuras) {
					this.deepSave(empleadoestructura,isDeep,deepLoadType,clases);
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
			if(empleadoestructuras!=null) {
				for(EmpleadoEstructura empleadoestructura:empleadoestructuras) {
					this.deepSave(empleadoestructura,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpleadoEstructurasFK_IdCargoWithConnection(String sFinalQuery,Pagination pagination,Long id_cargo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCargo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCargo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cargo,EmpleadoEstructuraConstantesFunciones.IDCARGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCargo);

			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCargo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoEstructurasFK_IdCargo(String sFinalQuery,Pagination pagination,Long id_cargo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCargo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCargo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cargo,EmpleadoEstructuraConstantesFunciones.IDCARGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCargo);

			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCargo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoEstructurasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoEstructuraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoEstructurasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoEstructuraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoEstructurasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoEstructuraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoEstructurasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoEstructuraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoEstructurasFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EmpleadoEstructuraConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoEstructurasFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EmpleadoEstructuraConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoEstructurasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEstructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EmpleadoEstructuraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoEstructurasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EmpleadoEstructuraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EmpleadoEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(this.empleadoestructuras);
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
			if(EmpleadoEstructuraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoEstructuraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EmpleadoEstructura empleadoestructura,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpleadoEstructuraConstantesFunciones.ISCONAUDITORIA) {
				if(empleadoestructura.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoEstructuraDataAccess.TABLENAME, empleadoestructura.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoEstructuraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoEstructuraLogic.registrarAuditoriaDetallesEmpleadoEstructura(connexion,empleadoestructura,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empleadoestructura.getIsDeleted()) {
					/*if(!empleadoestructura.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpleadoEstructuraDataAccess.TABLENAME, empleadoestructura.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpleadoEstructuraLogic.registrarAuditoriaDetallesEmpleadoEstructura(connexion,empleadoestructura,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoEstructuraDataAccess.TABLENAME, empleadoestructura.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empleadoestructura.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoEstructuraDataAccess.TABLENAME, empleadoestructura.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoEstructuraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoEstructuraLogic.registrarAuditoriaDetallesEmpleadoEstructura(connexion,empleadoestructura,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpleadoEstructura(Connexion connexion,EmpleadoEstructura empleadoestructura)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empleadoestructura.getIsNew()||!empleadoestructura.getid_empresa().equals(empleadoestructura.getEmpleadoEstructuraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoestructura.getEmpleadoEstructuraOriginal().getid_empresa()!=null)
				{
					strValorActual=empleadoestructura.getEmpleadoEstructuraOriginal().getid_empresa().toString();
				}
				if(empleadoestructura.getid_empresa()!=null)
				{
					strValorNuevo=empleadoestructura.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEstructuraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoestructura.getIsNew()||!empleadoestructura.getid_sucursal().equals(empleadoestructura.getEmpleadoEstructuraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoestructura.getEmpleadoEstructuraOriginal().getid_sucursal()!=null)
				{
					strValorActual=empleadoestructura.getEmpleadoEstructuraOriginal().getid_sucursal().toString();
				}
				if(empleadoestructura.getid_sucursal()!=null)
				{
					strValorNuevo=empleadoestructura.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEstructuraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(empleadoestructura.getIsNew()||!empleadoestructura.getid_empleado().equals(empleadoestructura.getEmpleadoEstructuraOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoestructura.getEmpleadoEstructuraOriginal().getid_empleado()!=null)
				{
					strValorActual=empleadoestructura.getEmpleadoEstructuraOriginal().getid_empleado().toString();
				}
				if(empleadoestructura.getid_empleado()!=null)
				{
					strValorNuevo=empleadoestructura.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEstructuraConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoestructura.getIsNew()||!empleadoestructura.getid_estructura().equals(empleadoestructura.getEmpleadoEstructuraOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoestructura.getEmpleadoEstructuraOriginal().getid_estructura()!=null)
				{
					strValorActual=empleadoestructura.getEmpleadoEstructuraOriginal().getid_estructura().toString();
				}
				if(empleadoestructura.getid_estructura()!=null)
				{
					strValorNuevo=empleadoestructura.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEstructuraConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoestructura.getIsNew()||!empleadoestructura.getid_cargo().equals(empleadoestructura.getEmpleadoEstructuraOriginal().getid_cargo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoestructura.getEmpleadoEstructuraOriginal().getid_cargo()!=null)
				{
					strValorActual=empleadoestructura.getEmpleadoEstructuraOriginal().getid_cargo().toString();
				}
				if(empleadoestructura.getid_cargo()!=null)
				{
					strValorNuevo=empleadoestructura.getid_cargo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEstructuraConstantesFunciones.IDCARGO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoestructura.getIsNew()||!empleadoestructura.getfecha_ingreso().equals(empleadoestructura.getEmpleadoEstructuraOriginal().getfecha_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoestructura.getEmpleadoEstructuraOriginal().getfecha_ingreso()!=null)
				{
					strValorActual=empleadoestructura.getEmpleadoEstructuraOriginal().getfecha_ingreso().toString();
				}
				if(empleadoestructura.getfecha_ingreso()!=null)
				{
					strValorNuevo=empleadoestructura.getfecha_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEstructuraConstantesFunciones.FECHAINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoestructura.getIsNew()||!empleadoestructura.getfecha_salida().equals(empleadoestructura.getEmpleadoEstructuraOriginal().getfecha_salida()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoestructura.getEmpleadoEstructuraOriginal().getfecha_salida()!=null)
				{
					strValorActual=empleadoestructura.getEmpleadoEstructuraOriginal().getfecha_salida().toString();
				}
				if(empleadoestructura.getfecha_salida()!=null)
				{
					strValorNuevo=empleadoestructura.getfecha_salida().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEstructuraConstantesFunciones.FECHASALIDA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoestructura.getIsNew()||!empleadoestructura.getnumero_reingreso().equals(empleadoestructura.getEmpleadoEstructuraOriginal().getnumero_reingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoestructura.getEmpleadoEstructuraOriginal().getnumero_reingreso()!=null)
				{
					strValorActual=empleadoestructura.getEmpleadoEstructuraOriginal().getnumero_reingreso().toString();
				}
				if(empleadoestructura.getnumero_reingreso()!=null)
				{
					strValorNuevo=empleadoestructura.getnumero_reingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEstructuraConstantesFunciones.NUMEROREINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoestructura.getIsNew()||!empleadoestructura.getdescripcion().equals(empleadoestructura.getEmpleadoEstructuraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoestructura.getEmpleadoEstructuraOriginal().getdescripcion()!=null)
				{
					strValorActual=empleadoestructura.getEmpleadoEstructuraOriginal().getdescripcion();
				}
				if(empleadoestructura.getdescripcion()!=null)
				{
					strValorNuevo=empleadoestructura.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEstructuraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpleadoEstructuraRelacionesWithConnection(EmpleadoEstructura empleadoestructura) throws Exception {

		if(!empleadoestructura.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoEstructuraRelacionesBase(empleadoestructura,true);
		}
	}

	public void saveEmpleadoEstructuraRelaciones(EmpleadoEstructura empleadoestructura)throws Exception {

		if(!empleadoestructura.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoEstructuraRelacionesBase(empleadoestructura,false);
		}
	}

	public void saveEmpleadoEstructuraRelacionesBase(EmpleadoEstructura empleadoestructura,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EmpleadoEstructura-saveRelacionesWithConnection");}
	

			this.setEmpleadoEstructura(empleadoestructura);

			if(EmpleadoEstructuraLogicAdditional.validarSaveRelaciones(empleadoestructura,this)) {

				EmpleadoEstructuraLogicAdditional.updateRelacionesToSave(empleadoestructura,this);

				if((empleadoestructura.getIsNew()||empleadoestructura.getIsChanged())&&!empleadoestructura.getIsDeleted()) {
					this.saveEmpleadoEstructura();
					this.saveEmpleadoEstructuraRelacionesDetalles();

				} else if(empleadoestructura.getIsDeleted()) {
					this.saveEmpleadoEstructuraRelacionesDetalles();
					this.saveEmpleadoEstructura();
				}

				EmpleadoEstructuraLogicAdditional.updateRelacionesToSaveAfter(empleadoestructura,this);

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
	
	
	private void saveEmpleadoEstructuraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoEstructuraConstantesFunciones.getClassesForeignKeysOfEmpleadoEstructura(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoEstructuraConstantesFunciones.getClassesRelationshipsOfEmpleadoEstructura(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

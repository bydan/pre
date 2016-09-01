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
import com.bydan.erp.nomina.util.EmpleadoPagoRubroConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoPagoRubroParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoPagoRubroParameterGeneral;
import com.bydan.erp.nomina.business.entity.EmpleadoPagoRubro;
import com.bydan.erp.nomina.business.logic.EmpleadoPagoRubroLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmpleadoPagoRubroLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpleadoPagoRubroLogic.class);
	
	protected EmpleadoPagoRubroDataAccess empleadopagorubroDataAccess; 	
	protected EmpleadoPagoRubro empleadopagorubro;
	protected List<EmpleadoPagoRubro> empleadopagorubros;
	protected Object empleadopagorubroObject;	
	protected List<Object> empleadopagorubrosObject;
	
	public static ClassValidator<EmpleadoPagoRubro> empleadopagorubroValidator = new ClassValidator<EmpleadoPagoRubro>(EmpleadoPagoRubro.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpleadoPagoRubroLogicAdditional empleadopagorubroLogicAdditional=null;
	
	public EmpleadoPagoRubroLogicAdditional getEmpleadoPagoRubroLogicAdditional() {
		return this.empleadopagorubroLogicAdditional;
	}
	
	public void setEmpleadoPagoRubroLogicAdditional(EmpleadoPagoRubroLogicAdditional empleadopagorubroLogicAdditional) {
		try {
			this.empleadopagorubroLogicAdditional=empleadopagorubroLogicAdditional;
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
	
	
	
	
	public  EmpleadoPagoRubroLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empleadopagorubroDataAccess = new EmpleadoPagoRubroDataAccess();
			
			this.empleadopagorubros= new ArrayList<EmpleadoPagoRubro>();
			this.empleadopagorubro= new EmpleadoPagoRubro();
			
			this.empleadopagorubroObject=new Object();
			this.empleadopagorubrosObject=new ArrayList<Object>();
				
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
			
			this.empleadopagorubroDataAccess.setConnexionType(this.connexionType);
			this.empleadopagorubroDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpleadoPagoRubroLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empleadopagorubroDataAccess = new EmpleadoPagoRubroDataAccess();
			this.empleadopagorubros= new ArrayList<EmpleadoPagoRubro>();
			this.empleadopagorubro= new EmpleadoPagoRubro();
			this.empleadopagorubroObject=new Object();
			this.empleadopagorubrosObject=new ArrayList<Object>();
			
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
			
			this.empleadopagorubroDataAccess.setConnexionType(this.connexionType);
			this.empleadopagorubroDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EmpleadoPagoRubro getEmpleadoPagoRubro() throws Exception {	
		EmpleadoPagoRubroLogicAdditional.checkEmpleadoPagoRubroToGet(empleadopagorubro,this.datosCliente,this.arrDatoGeneral);
		EmpleadoPagoRubroLogicAdditional.updateEmpleadoPagoRubroToGet(empleadopagorubro,this.arrDatoGeneral);
		
		return empleadopagorubro;
	}
		
	public void setEmpleadoPagoRubro(EmpleadoPagoRubro newEmpleadoPagoRubro) {
		this.empleadopagorubro = newEmpleadoPagoRubro;
	}
	
	public EmpleadoPagoRubroDataAccess getEmpleadoPagoRubroDataAccess() {
		return empleadopagorubroDataAccess;
	}
	
	public void setEmpleadoPagoRubroDataAccess(EmpleadoPagoRubroDataAccess newempleadopagorubroDataAccess) {
		this.empleadopagorubroDataAccess = newempleadopagorubroDataAccess;
	}
	
	public List<EmpleadoPagoRubro> getEmpleadoPagoRubros() throws Exception {		
		this.quitarEmpleadoPagoRubrosNulos();
		
		EmpleadoPagoRubroLogicAdditional.checkEmpleadoPagoRubroToGets(empleadopagorubros,this.datosCliente,this.arrDatoGeneral);
		
		for (EmpleadoPagoRubro empleadopagorubroLocal: empleadopagorubros ) {
			EmpleadoPagoRubroLogicAdditional.updateEmpleadoPagoRubroToGet(empleadopagorubroLocal,this.arrDatoGeneral);
		}
		
		return empleadopagorubros;
	}
	
	public void setEmpleadoPagoRubros(List<EmpleadoPagoRubro> newEmpleadoPagoRubros) {
		this.empleadopagorubros = newEmpleadoPagoRubros;
	}
	
	public Object getEmpleadoPagoRubroObject() {	
		this.empleadopagorubroObject=this.empleadopagorubroDataAccess.getEntityObject();
		return this.empleadopagorubroObject;
	}
		
	public void setEmpleadoPagoRubroObject(Object newEmpleadoPagoRubroObject) {
		this.empleadopagorubroObject = newEmpleadoPagoRubroObject;
	}
	
	public List<Object> getEmpleadoPagoRubrosObject() {		
		this.empleadopagorubrosObject=this.empleadopagorubroDataAccess.getEntitiesObject();
		return this.empleadopagorubrosObject;
	}
		
	public void setEmpleadoPagoRubrosObject(List<Object> newEmpleadoPagoRubrosObject) {
		this.empleadopagorubrosObject = newEmpleadoPagoRubrosObject;
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
		
		if(this.empleadopagorubroDataAccess!=null) {
			this.empleadopagorubroDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empleadopagorubroDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empleadopagorubroDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empleadopagorubro = new  EmpleadoPagoRubro();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadopagorubro=empleadopagorubroDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadopagorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubro);
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
		empleadopagorubro = new  EmpleadoPagoRubro();
		  		  
        try {
			
			empleadopagorubro=empleadopagorubroDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadopagorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empleadopagorubro = new  EmpleadoPagoRubro();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadopagorubro=empleadopagorubroDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadopagorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubro);
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
		empleadopagorubro = new  EmpleadoPagoRubro();
		  		  
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
		empleadopagorubro = new  EmpleadoPagoRubro();
		  		  
        try {
			
			empleadopagorubro=empleadopagorubroDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadopagorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empleadopagorubro = new  EmpleadoPagoRubro();
		  		  
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
		empleadopagorubro = new  EmpleadoPagoRubro();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empleadopagorubroDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadopagorubro = new  EmpleadoPagoRubro();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empleadopagorubroDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadopagorubro = new  EmpleadoPagoRubro();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empleadopagorubroDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadopagorubro = new  EmpleadoPagoRubro();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empleadopagorubroDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadopagorubro = new  EmpleadoPagoRubro();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empleadopagorubroDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadopagorubro = new  EmpleadoPagoRubro();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empleadopagorubroDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadopagorubros = new  ArrayList<EmpleadoPagoRubro>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoPagoRubro(empleadopagorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
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
		empleadopagorubros = new  ArrayList<EmpleadoPagoRubro>();
		  		  
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
		empleadopagorubros = new  ArrayList<EmpleadoPagoRubro>();
		  		  
        try {			
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpleadoPagoRubro(empleadopagorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empleadopagorubros = new  ArrayList<EmpleadoPagoRubro>();
		  		  
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
		empleadopagorubros = new  ArrayList<EmpleadoPagoRubro>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoPagoRubro(empleadopagorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
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
		empleadopagorubros = new  ArrayList<EmpleadoPagoRubro>();
		  		  
        try {
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoPagoRubro(empleadopagorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
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
		empleadopagorubros = new  ArrayList<EmpleadoPagoRubro>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoPagoRubro(empleadopagorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
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
		empleadopagorubros = new  ArrayList<EmpleadoPagoRubro>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoPagoRubro(empleadopagorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empleadopagorubro = new  EmpleadoPagoRubro();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadopagorubro=empleadopagorubroDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoPagoRubro(empleadopagorubro);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubro);
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
		empleadopagorubro = new  EmpleadoPagoRubro();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadopagorubro=empleadopagorubroDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoPagoRubro(empleadopagorubro);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadopagorubros = new  ArrayList<EmpleadoPagoRubro>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadopagorubros=empleadopagorubroDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoPagoRubro(empleadopagorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
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
		empleadopagorubros = new  ArrayList<EmpleadoPagoRubro>();
		  		  
        try {
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadopagorubros=empleadopagorubroDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoPagoRubro(empleadopagorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpleadoPagoRubrosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empleadopagorubros = new  ArrayList<EmpleadoPagoRubro>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getTodosEmpleadoPagoRubrosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoPagoRubro(empleadopagorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
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
	
	public  void  getTodosEmpleadoPagoRubros(String sFinalQuery,Pagination pagination)throws Exception {
		empleadopagorubros = new  ArrayList<EmpleadoPagoRubro>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoPagoRubro(empleadopagorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpleadoPagoRubro(EmpleadoPagoRubro empleadopagorubro) throws Exception {
		Boolean estaValidado=false;
		
		if(empleadopagorubro.getIsNew() || empleadopagorubro.getIsChanged()) { 
			this.invalidValues = empleadopagorubroValidator.getInvalidValues(empleadopagorubro);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empleadopagorubro);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpleadoPagoRubro(List<EmpleadoPagoRubro> EmpleadoPagoRubros) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EmpleadoPagoRubro empleadopagorubroLocal:empleadopagorubros) {				
			estaValidadoObjeto=this.validarGuardarEmpleadoPagoRubro(empleadopagorubroLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpleadoPagoRubro(List<EmpleadoPagoRubro> EmpleadoPagoRubros) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoPagoRubro(empleadopagorubros)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpleadoPagoRubro(EmpleadoPagoRubro EmpleadoPagoRubro) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoPagoRubro(empleadopagorubro)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EmpleadoPagoRubro empleadopagorubro) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empleadopagorubro.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpleadoPagoRubroConstantesFunciones.getEmpleadoPagoRubroLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empleadopagorubro","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpleadoPagoRubroConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpleadoPagoRubroConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpleadoPagoRubroWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-saveEmpleadoPagoRubroWithConnection");connexion.begin();			
			
			EmpleadoPagoRubroLogicAdditional.checkEmpleadoPagoRubroToSave(this.empleadopagorubro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoPagoRubroLogicAdditional.updateEmpleadoPagoRubroToSave(this.empleadopagorubro,this.arrDatoGeneral);
			
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadopagorubro,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoPagoRubro();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoPagoRubro(this.empleadopagorubro)) {
				EmpleadoPagoRubroDataAccess.save(this.empleadopagorubro, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empleadopagorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoPagoRubroLogicAdditional.checkEmpleadoPagoRubroToSaveAfter(this.empleadopagorubro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoPagoRubro();
			
			connexion.commit();			
			
			if(this.empleadopagorubro.getIsDeleted()) {
				this.empleadopagorubro=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpleadoPagoRubro()throws Exception {	
		try {	
			
			EmpleadoPagoRubroLogicAdditional.checkEmpleadoPagoRubroToSave(this.empleadopagorubro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoPagoRubroLogicAdditional.updateEmpleadoPagoRubroToSave(this.empleadopagorubro,this.arrDatoGeneral);
			
			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadopagorubro,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoPagoRubro(this.empleadopagorubro)) {			
				EmpleadoPagoRubroDataAccess.save(this.empleadopagorubro, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empleadopagorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoPagoRubroLogicAdditional.checkEmpleadoPagoRubroToSaveAfter(this.empleadopagorubro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empleadopagorubro.getIsDeleted()) {
				this.empleadopagorubro=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpleadoPagoRubrosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-saveEmpleadoPagoRubrosWithConnection");connexion.begin();			
			
			EmpleadoPagoRubroLogicAdditional.checkEmpleadoPagoRubroToSaves(empleadopagorubros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoPagoRubros();
			
			Boolean validadoTodosEmpleadoPagoRubro=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoPagoRubro empleadopagorubroLocal:empleadopagorubros) {		
				if(empleadopagorubroLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoPagoRubroLogicAdditional.updateEmpleadoPagoRubroToSave(empleadopagorubroLocal,this.arrDatoGeneral);
	        	
				EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadopagorubroLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoPagoRubro(empleadopagorubroLocal)) {
					EmpleadoPagoRubroDataAccess.save(empleadopagorubroLocal, connexion);				
				} else {
					validadoTodosEmpleadoPagoRubro=false;
				}
			}
			
			if(!validadoTodosEmpleadoPagoRubro) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoPagoRubroLogicAdditional.checkEmpleadoPagoRubroToSavesAfter(empleadopagorubros,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoPagoRubros();
			
			connexion.commit();		
			
			this.quitarEmpleadoPagoRubrosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpleadoPagoRubros()throws Exception {				
		 try {	
			EmpleadoPagoRubroLogicAdditional.checkEmpleadoPagoRubroToSaves(empleadopagorubros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpleadoPagoRubro=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoPagoRubro empleadopagorubroLocal:empleadopagorubros) {				
				if(empleadopagorubroLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoPagoRubroLogicAdditional.updateEmpleadoPagoRubroToSave(empleadopagorubroLocal,this.arrDatoGeneral);
	        	
				EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadopagorubroLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoPagoRubro(empleadopagorubroLocal)) {				
					EmpleadoPagoRubroDataAccess.save(empleadopagorubroLocal, connexion);				
				} else {
					validadoTodosEmpleadoPagoRubro=false;
				}
			}
			
			if(!validadoTodosEmpleadoPagoRubro) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoPagoRubroLogicAdditional.checkEmpleadoPagoRubroToSavesAfter(empleadopagorubros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpleadoPagoRubrosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoPagoRubroParameterReturnGeneral procesarAccionEmpleadoPagoRubros(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoPagoRubro> empleadopagorubros,EmpleadoPagoRubroParameterReturnGeneral empleadopagorubroParameterGeneral)throws Exception {
		 try {	
			EmpleadoPagoRubroParameterReturnGeneral empleadopagorubroReturnGeneral=new EmpleadoPagoRubroParameterReturnGeneral();
	
			EmpleadoPagoRubroLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadopagorubros,empleadopagorubroParameterGeneral,empleadopagorubroReturnGeneral);
			
			return empleadopagorubroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoPagoRubroParameterReturnGeneral procesarAccionEmpleadoPagoRubrosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoPagoRubro> empleadopagorubros,EmpleadoPagoRubroParameterReturnGeneral empleadopagorubroParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-procesarAccionEmpleadoPagoRubrosWithConnection");connexion.begin();			
			
			EmpleadoPagoRubroParameterReturnGeneral empleadopagorubroReturnGeneral=new EmpleadoPagoRubroParameterReturnGeneral();
	
			EmpleadoPagoRubroLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadopagorubros,empleadopagorubroParameterGeneral,empleadopagorubroReturnGeneral);
			
			this.connexion.commit();
			
			return empleadopagorubroReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoPagoRubroParameterReturnGeneral procesarEventosEmpleadoPagoRubros(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoPagoRubro> empleadopagorubros,EmpleadoPagoRubro empleadopagorubro,EmpleadoPagoRubroParameterReturnGeneral empleadopagorubroParameterGeneral,Boolean isEsNuevoEmpleadoPagoRubro,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpleadoPagoRubroParameterReturnGeneral empleadopagorubroReturnGeneral=new EmpleadoPagoRubroParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadopagorubroReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoPagoRubroLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadopagorubros,empleadopagorubro,empleadopagorubroParameterGeneral,empleadopagorubroReturnGeneral,isEsNuevoEmpleadoPagoRubro,clases);
			
			return empleadopagorubroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpleadoPagoRubroParameterReturnGeneral procesarEventosEmpleadoPagoRubrosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoPagoRubro> empleadopagorubros,EmpleadoPagoRubro empleadopagorubro,EmpleadoPagoRubroParameterReturnGeneral empleadopagorubroParameterGeneral,Boolean isEsNuevoEmpleadoPagoRubro,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-procesarEventosEmpleadoPagoRubrosWithConnection");connexion.begin();			
			
			EmpleadoPagoRubroParameterReturnGeneral empleadopagorubroReturnGeneral=new EmpleadoPagoRubroParameterReturnGeneral();
	
			empleadopagorubroReturnGeneral.setEmpleadoPagoRubro(empleadopagorubro);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadopagorubroReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoPagoRubroLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadopagorubros,empleadopagorubro,empleadopagorubroParameterGeneral,empleadopagorubroReturnGeneral,isEsNuevoEmpleadoPagoRubro,clases);
			
			this.connexion.commit();
			
			return empleadopagorubroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoPagoRubroParameterReturnGeneral procesarImportacionEmpleadoPagoRubrosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpleadoPagoRubroParameterReturnGeneral empleadopagorubroParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-procesarImportacionEmpleadoPagoRubrosWithConnection");connexion.begin();			
			
			EmpleadoPagoRubroParameterReturnGeneral empleadopagorubroReturnGeneral=new EmpleadoPagoRubroParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empleadopagorubros=new ArrayList<EmpleadoPagoRubro>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empleadopagorubro=new EmpleadoPagoRubro();
				
				
				if(conColumnasBase) {this.empleadopagorubro.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empleadopagorubro.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empleadopagorubro.setvalor_pago(Double.parseDouble(arrColumnas[iColumn++]));
				this.empleadopagorubro.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.empleadopagorubro.setfecha_liquidacion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.empleadopagorubros.add(this.empleadopagorubro);
			}
			
			this.saveEmpleadoPagoRubros();
			
			this.connexion.commit();
			
			empleadopagorubroReturnGeneral.setConRetornoEstaProcesado(true);
			empleadopagorubroReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empleadopagorubroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpleadoPagoRubrosEliminados() throws Exception {				
		
		List<EmpleadoPagoRubro> empleadopagorubrosAux= new ArrayList<EmpleadoPagoRubro>();
		
		for(EmpleadoPagoRubro empleadopagorubro:empleadopagorubros) {
			if(!empleadopagorubro.getIsDeleted()) {
				empleadopagorubrosAux.add(empleadopagorubro);
			}
		}
		
		empleadopagorubros=empleadopagorubrosAux;
	}
	
	public void quitarEmpleadoPagoRubrosNulos() throws Exception {				
		
		List<EmpleadoPagoRubro> empleadopagorubrosAux= new ArrayList<EmpleadoPagoRubro>();
		
		for(EmpleadoPagoRubro empleadopagorubro : this.empleadopagorubros) {
			if(empleadopagorubro==null) {
				empleadopagorubrosAux.add(empleadopagorubro);
			}
		}
		
		//this.empleadopagorubros=empleadopagorubrosAux;
		
		this.empleadopagorubros.removeAll(empleadopagorubrosAux);
	}
	
	public void getSetVersionRowEmpleadoPagoRubroWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empleadopagorubro.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empleadopagorubro.getIsDeleted() || (empleadopagorubro.getIsChanged()&&!empleadopagorubro.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empleadopagorubroDataAccess.getSetVersionRowEmpleadoPagoRubro(connexion,empleadopagorubro.getId());
				
				if(!empleadopagorubro.getVersionRow().equals(timestamp)) {	
					empleadopagorubro.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empleadopagorubro.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpleadoPagoRubro()throws Exception {	
		
		if(empleadopagorubro.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empleadopagorubro.getIsDeleted() || (empleadopagorubro.getIsChanged()&&!empleadopagorubro.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empleadopagorubroDataAccess.getSetVersionRowEmpleadoPagoRubro(connexion,empleadopagorubro.getId());
			
			try {							
				if(!empleadopagorubro.getVersionRow().equals(timestamp)) {	
					empleadopagorubro.setVersionRow(timestamp);
				}
				
				empleadopagorubro.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpleadoPagoRubrosWithConnection()throws Exception {	
		if(empleadopagorubros!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EmpleadoPagoRubro empleadopagorubroAux:empleadopagorubros) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empleadopagorubroAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadopagorubroAux.getIsDeleted() || (empleadopagorubroAux.getIsChanged()&&!empleadopagorubroAux.getIsNew())) {
						
						timestamp=empleadopagorubroDataAccess.getSetVersionRowEmpleadoPagoRubro(connexion,empleadopagorubroAux.getId());
						
						if(!empleadopagorubro.getVersionRow().equals(timestamp)) {	
							empleadopagorubroAux.setVersionRow(timestamp);
						}
								
						empleadopagorubroAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpleadoPagoRubros()throws Exception {	
		if(empleadopagorubros!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EmpleadoPagoRubro empleadopagorubroAux:empleadopagorubros) {
					if(empleadopagorubroAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadopagorubroAux.getIsDeleted() || (empleadopagorubroAux.getIsChanged()&&!empleadopagorubroAux.getIsNew())) {
						
						timestamp=empleadopagorubroDataAccess.getSetVersionRowEmpleadoPagoRubro(connexion,empleadopagorubroAux.getId());
						
						if(!empleadopagorubroAux.getVersionRow().equals(timestamp)) {	
							empleadopagorubroAux.setVersionRow(timestamp);
						}
						
													
						empleadopagorubroAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpleadoPagoRubroParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoPagoRubroWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalRubroEmplea,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		EmpleadoPagoRubroParameterReturnGeneral  empleadopagorubroReturnGeneral =new EmpleadoPagoRubroParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpleadoPagoRubroWithConnection");connexion.begin();
			
			empleadopagorubroReturnGeneral =new EmpleadoPagoRubroParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadopagorubroReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadopagorubroReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			empleadopagorubroReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			empleadopagorubroReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			empleadopagorubroReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			empleadopagorubroReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empleadopagorubroReturnGeneral;
	}
	
	public EmpleadoPagoRubroParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoPagoRubro(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalRubroEmplea,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		EmpleadoPagoRubroParameterReturnGeneral  empleadopagorubroReturnGeneral =new EmpleadoPagoRubroParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empleadopagorubroReturnGeneral =new EmpleadoPagoRubroParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadopagorubroReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadopagorubroReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			empleadopagorubroReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			empleadopagorubroReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			empleadopagorubroReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			empleadopagorubroReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empleadopagorubroReturnGeneral;
	}
	
	
	public void deepLoad(EmpleadoPagoRubro empleadopagorubro,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpleadoPagoRubroLogicAdditional.updateEmpleadoPagoRubroToGet(empleadopagorubro,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadopagorubro.setEmpresa(empleadopagorubroDataAccess.getEmpresa(connexion,empleadopagorubro));
		empleadopagorubro.setEmpleado(empleadopagorubroDataAccess.getEmpleado(connexion,empleadopagorubro));
		empleadopagorubro.setEstructura(empleadopagorubroDataAccess.getEstructura(connexion,empleadopagorubro));
		empleadopagorubro.setRubroEmplea(empleadopagorubroDataAccess.getRubroEmplea(connexion,empleadopagorubro));
		empleadopagorubro.setAnio(empleadopagorubroDataAccess.getAnio(connexion,empleadopagorubro));
		empleadopagorubro.setMes(empleadopagorubroDataAccess.getMes(connexion,empleadopagorubro));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadopagorubro.setEmpresa(empleadopagorubroDataAccess.getEmpresa(connexion,empleadopagorubro));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadopagorubro.setEmpleado(empleadopagorubroDataAccess.getEmpleado(connexion,empleadopagorubro));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				empleadopagorubro.setEstructura(empleadopagorubroDataAccess.getEstructura(connexion,empleadopagorubro));
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				empleadopagorubro.setRubroEmplea(empleadopagorubroDataAccess.getRubroEmplea(connexion,empleadopagorubro));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				empleadopagorubro.setAnio(empleadopagorubroDataAccess.getAnio(connexion,empleadopagorubro));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				empleadopagorubro.setMes(empleadopagorubroDataAccess.getMes(connexion,empleadopagorubro));
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
			empleadopagorubro.setEmpresa(empleadopagorubroDataAccess.getEmpresa(connexion,empleadopagorubro));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadopagorubro.setEmpleado(empleadopagorubroDataAccess.getEmpleado(connexion,empleadopagorubro));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadopagorubro.setEstructura(empleadopagorubroDataAccess.getEstructura(connexion,empleadopagorubro));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadopagorubro.setRubroEmplea(empleadopagorubroDataAccess.getRubroEmplea(connexion,empleadopagorubro));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadopagorubro.setAnio(empleadopagorubroDataAccess.getAnio(connexion,empleadopagorubro));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadopagorubro.setMes(empleadopagorubroDataAccess.getMes(connexion,empleadopagorubro));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadopagorubro.setEmpresa(empleadopagorubroDataAccess.getEmpresa(connexion,empleadopagorubro));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadopagorubro.getEmpresa(),isDeep,deepLoadType,clases);
				
		empleadopagorubro.setEmpleado(empleadopagorubroDataAccess.getEmpleado(connexion,empleadopagorubro));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadopagorubro.getEmpleado(),isDeep,deepLoadType,clases);
				
		empleadopagorubro.setEstructura(empleadopagorubroDataAccess.getEstructura(connexion,empleadopagorubro));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(empleadopagorubro.getEstructura(),isDeep,deepLoadType,clases);
				
		empleadopagorubro.setRubroEmplea(empleadopagorubroDataAccess.getRubroEmplea(connexion,empleadopagorubro));
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(empleadopagorubro.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		empleadopagorubro.setAnio(empleadopagorubroDataAccess.getAnio(connexion,empleadopagorubro));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(empleadopagorubro.getAnio(),isDeep,deepLoadType,clases);
				
		empleadopagorubro.setMes(empleadopagorubroDataAccess.getMes(connexion,empleadopagorubro));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(empleadopagorubro.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadopagorubro.setEmpresa(empleadopagorubroDataAccess.getEmpresa(connexion,empleadopagorubro));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(empleadopagorubro.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadopagorubro.setEmpleado(empleadopagorubroDataAccess.getEmpleado(connexion,empleadopagorubro));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleadopagorubro.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				empleadopagorubro.setEstructura(empleadopagorubroDataAccess.getEstructura(connexion,empleadopagorubro));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(empleadopagorubro.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				empleadopagorubro.setRubroEmplea(empleadopagorubroDataAccess.getRubroEmplea(connexion,empleadopagorubro));
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepLoad(empleadopagorubro.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				empleadopagorubro.setAnio(empleadopagorubroDataAccess.getAnio(connexion,empleadopagorubro));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(empleadopagorubro.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				empleadopagorubro.setMes(empleadopagorubroDataAccess.getMes(connexion,empleadopagorubro));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(empleadopagorubro.getMes(),isDeep,deepLoadType,clases);				
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
			empleadopagorubro.setEmpresa(empleadopagorubroDataAccess.getEmpresa(connexion,empleadopagorubro));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(empleadopagorubro.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadopagorubro.setEmpleado(empleadopagorubroDataAccess.getEmpleado(connexion,empleadopagorubro));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleadopagorubro.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadopagorubro.setEstructura(empleadopagorubroDataAccess.getEstructura(connexion,empleadopagorubro));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(empleadopagorubro.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadopagorubro.setRubroEmplea(empleadopagorubroDataAccess.getRubroEmplea(connexion,empleadopagorubro));
			RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
			rubroempleaLogic.deepLoad(empleadopagorubro.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadopagorubro.setAnio(empleadopagorubroDataAccess.getAnio(connexion,empleadopagorubro));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(empleadopagorubro.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadopagorubro.setMes(empleadopagorubroDataAccess.getMes(connexion,empleadopagorubro));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(empleadopagorubro.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EmpleadoPagoRubro empleadopagorubro,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpleadoPagoRubroLogicAdditional.updateEmpleadoPagoRubroToSave(empleadopagorubro,this.arrDatoGeneral);
			
EmpleadoPagoRubroDataAccess.save(empleadopagorubro, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadopagorubro.getEmpresa(),connexion);

		EmpleadoDataAccess.save(empleadopagorubro.getEmpleado(),connexion);

		EstructuraDataAccess.save(empleadopagorubro.getEstructura(),connexion);

		RubroEmpleaDataAccess.save(empleadopagorubro.getRubroEmplea(),connexion);

		AnioDataAccess.save(empleadopagorubro.getAnio(),connexion);

		MesDataAccess.save(empleadopagorubro.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadopagorubro.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadopagorubro.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(empleadopagorubro.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(empleadopagorubro.getRubroEmplea(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(empleadopagorubro.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(empleadopagorubro.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadopagorubro.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadopagorubro.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(empleadopagorubro.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadopagorubro.getEmpleado(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(empleadopagorubro.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(empleadopagorubro.getEstructura(),isDeep,deepLoadType,clases);
				

		RubroEmpleaDataAccess.save(empleadopagorubro.getRubroEmplea(),connexion);
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(empleadopagorubro.getRubroEmplea(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(empleadopagorubro.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(empleadopagorubro.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(empleadopagorubro.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(empleadopagorubro.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadopagorubro.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(empleadopagorubro.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadopagorubro.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(empleadopagorubro.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(empleadopagorubro.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(empleadopagorubro.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(empleadopagorubro.getRubroEmplea(),connexion);
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepSave(empleadopagorubro.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(empleadopagorubro.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(empleadopagorubro.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(empleadopagorubro.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(empleadopagorubro.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(EmpleadoPagoRubro.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empleadopagorubro,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(empleadopagorubro);
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
			this.deepLoad(this.empleadopagorubro,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EmpleadoPagoRubro.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empleadopagorubros!=null) {
				for(EmpleadoPagoRubro empleadopagorubro:empleadopagorubros) {
					this.deepLoad(empleadopagorubro,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(empleadopagorubros);
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
			if(empleadopagorubros!=null) {
				for(EmpleadoPagoRubro empleadopagorubro:empleadopagorubros) {
					this.deepLoad(empleadopagorubro,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(empleadopagorubros);
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
			this.getNewConnexionToDeep(EmpleadoPagoRubro.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empleadopagorubro,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EmpleadoPagoRubro.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empleadopagorubros!=null) {
				for(EmpleadoPagoRubro empleadopagorubro:empleadopagorubros) {
					this.deepSave(empleadopagorubro,isDeep,deepLoadType,clases);
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
			if(empleadopagorubros!=null) {
				for(EmpleadoPagoRubro empleadopagorubro:empleadopagorubros) {
					this.deepSave(empleadopagorubro,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpleadoPagoRubrosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,EmpleadoPagoRubroConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoPagoRubrosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,EmpleadoPagoRubroConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoPagoRubrosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoPagoRubroConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoPagoRubrosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoPagoRubroConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoPagoRubrosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoPagoRubroConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoPagoRubrosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoPagoRubroConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoPagoRubrosFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EmpleadoPagoRubroConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoPagoRubrosFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EmpleadoPagoRubroConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoPagoRubrosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,EmpleadoPagoRubroConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoPagoRubrosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,EmpleadoPagoRubroConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoPagoRubrosFK_IdRubroEmpleaWithConnection(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoPagoRubro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,EmpleadoPagoRubroConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoPagoRubrosFK_IdRubroEmplea(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,EmpleadoPagoRubroConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			EmpleadoPagoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(this.empleadopagorubros);
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
			if(EmpleadoPagoRubroConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoPagoRubroDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EmpleadoPagoRubro empleadopagorubro,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpleadoPagoRubroConstantesFunciones.ISCONAUDITORIA) {
				if(empleadopagorubro.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoPagoRubroDataAccess.TABLENAME, empleadopagorubro.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoPagoRubroConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoPagoRubroLogic.registrarAuditoriaDetallesEmpleadoPagoRubro(connexion,empleadopagorubro,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empleadopagorubro.getIsDeleted()) {
					/*if(!empleadopagorubro.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpleadoPagoRubroDataAccess.TABLENAME, empleadopagorubro.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpleadoPagoRubroLogic.registrarAuditoriaDetallesEmpleadoPagoRubro(connexion,empleadopagorubro,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoPagoRubroDataAccess.TABLENAME, empleadopagorubro.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empleadopagorubro.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoPagoRubroDataAccess.TABLENAME, empleadopagorubro.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoPagoRubroConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoPagoRubroLogic.registrarAuditoriaDetallesEmpleadoPagoRubro(connexion,empleadopagorubro,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpleadoPagoRubro(Connexion connexion,EmpleadoPagoRubro empleadopagorubro)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empleadopagorubro.getIsNew()||!empleadopagorubro.getid_empresa().equals(empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_empresa()!=null)
				{
					strValorActual=empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_empresa().toString();
				}
				if(empleadopagorubro.getid_empresa()!=null)
				{
					strValorNuevo=empleadopagorubro.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoPagoRubroConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empleadopagorubro.getIsNew()||!empleadopagorubro.getid_empleado().equals(empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_empleado()!=null)
				{
					strValorActual=empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_empleado().toString();
				}
				if(empleadopagorubro.getid_empleado()!=null)
				{
					strValorNuevo=empleadopagorubro.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoPagoRubroConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(empleadopagorubro.getIsNew()||!empleadopagorubro.getid_estructura().equals(empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_estructura()!=null)
				{
					strValorActual=empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_estructura().toString();
				}
				if(empleadopagorubro.getid_estructura()!=null)
				{
					strValorNuevo=empleadopagorubro.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoPagoRubroConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(empleadopagorubro.getIsNew()||!empleadopagorubro.getid_rubro_emplea().equals(empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_rubro_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_rubro_emplea()!=null)
				{
					strValorActual=empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_rubro_emplea().toString();
				}
				if(empleadopagorubro.getid_rubro_emplea()!=null)
				{
					strValorNuevo=empleadopagorubro.getid_rubro_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoPagoRubroConstantesFunciones.IDRUBROEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(empleadopagorubro.getIsNew()||!empleadopagorubro.getid_anio().equals(empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_anio()!=null)
				{
					strValorActual=empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_anio().toString();
				}
				if(empleadopagorubro.getid_anio()!=null)
				{
					strValorNuevo=empleadopagorubro.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoPagoRubroConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(empleadopagorubro.getIsNew()||!empleadopagorubro.getid_mes().equals(empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_mes()!=null)
				{
					strValorActual=empleadopagorubro.getEmpleadoPagoRubroOriginal().getid_mes().toString();
				}
				if(empleadopagorubro.getid_mes()!=null)
				{
					strValorNuevo=empleadopagorubro.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoPagoRubroConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(empleadopagorubro.getIsNew()||!empleadopagorubro.getvalor_pago().equals(empleadopagorubro.getEmpleadoPagoRubroOriginal().getvalor_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadopagorubro.getEmpleadoPagoRubroOriginal().getvalor_pago()!=null)
				{
					strValorActual=empleadopagorubro.getEmpleadoPagoRubroOriginal().getvalor_pago().toString();
				}
				if(empleadopagorubro.getvalor_pago()!=null)
				{
					strValorNuevo=empleadopagorubro.getvalor_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoPagoRubroConstantesFunciones.VALORPAGO,strValorActual,strValorNuevo);
			}	
			
			if(empleadopagorubro.getIsNew()||!empleadopagorubro.getfecha().equals(empleadopagorubro.getEmpleadoPagoRubroOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadopagorubro.getEmpleadoPagoRubroOriginal().getfecha()!=null)
				{
					strValorActual=empleadopagorubro.getEmpleadoPagoRubroOriginal().getfecha().toString();
				}
				if(empleadopagorubro.getfecha()!=null)
				{
					strValorNuevo=empleadopagorubro.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoPagoRubroConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(empleadopagorubro.getIsNew()||!empleadopagorubro.getfecha_liquidacion().equals(empleadopagorubro.getEmpleadoPagoRubroOriginal().getfecha_liquidacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadopagorubro.getEmpleadoPagoRubroOriginal().getfecha_liquidacion()!=null)
				{
					strValorActual=empleadopagorubro.getEmpleadoPagoRubroOriginal().getfecha_liquidacion().toString();
				}
				if(empleadopagorubro.getfecha_liquidacion()!=null)
				{
					strValorNuevo=empleadopagorubro.getfecha_liquidacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoPagoRubroConstantesFunciones.FECHALIQUIDACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpleadoPagoRubroRelacionesWithConnection(EmpleadoPagoRubro empleadopagorubro) throws Exception {

		if(!empleadopagorubro.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoPagoRubroRelacionesBase(empleadopagorubro,true);
		}
	}

	public void saveEmpleadoPagoRubroRelaciones(EmpleadoPagoRubro empleadopagorubro)throws Exception {

		if(!empleadopagorubro.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoPagoRubroRelacionesBase(empleadopagorubro,false);
		}
	}

	public void saveEmpleadoPagoRubroRelacionesBase(EmpleadoPagoRubro empleadopagorubro,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EmpleadoPagoRubro-saveRelacionesWithConnection");}
	

			this.setEmpleadoPagoRubro(empleadopagorubro);

			if(EmpleadoPagoRubroLogicAdditional.validarSaveRelaciones(empleadopagorubro,this)) {

				EmpleadoPagoRubroLogicAdditional.updateRelacionesToSave(empleadopagorubro,this);

				if((empleadopagorubro.getIsNew()||empleadopagorubro.getIsChanged())&&!empleadopagorubro.getIsDeleted()) {
					this.saveEmpleadoPagoRubro();
					this.saveEmpleadoPagoRubroRelacionesDetalles();

				} else if(empleadopagorubro.getIsDeleted()) {
					this.saveEmpleadoPagoRubroRelacionesDetalles();
					this.saveEmpleadoPagoRubro();
				}

				EmpleadoPagoRubroLogicAdditional.updateRelacionesToSaveAfter(empleadopagorubro,this);

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
	
	
	private void saveEmpleadoPagoRubroRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoPagoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoPagoRubroConstantesFunciones.getClassesForeignKeysOfEmpleadoPagoRubro(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoPagoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoPagoRubroConstantesFunciones.getClassesRelationshipsOfEmpleadoPagoRubro(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

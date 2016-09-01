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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.EmpleadoProcesoRubroConstantesFunciones;
import com.bydan.erp.inventario.util.EmpleadoProcesoRubroParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EmpleadoProcesoRubroParameterGeneral;
import com.bydan.erp.inventario.business.entity.EmpleadoProcesoRubro;
import com.bydan.erp.inventario.business.logic.EmpleadoProcesoRubroLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmpleadoProcesoRubroLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpleadoProcesoRubroLogic.class);
	
	protected EmpleadoProcesoRubroDataAccess empleadoprocesorubroDataAccess; 	
	protected EmpleadoProcesoRubro empleadoprocesorubro;
	protected List<EmpleadoProcesoRubro> empleadoprocesorubros;
	protected Object empleadoprocesorubroObject;	
	protected List<Object> empleadoprocesorubrosObject;
	
	public static ClassValidator<EmpleadoProcesoRubro> empleadoprocesorubroValidator = new ClassValidator<EmpleadoProcesoRubro>(EmpleadoProcesoRubro.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpleadoProcesoRubroLogicAdditional empleadoprocesorubroLogicAdditional=null;
	
	public EmpleadoProcesoRubroLogicAdditional getEmpleadoProcesoRubroLogicAdditional() {
		return this.empleadoprocesorubroLogicAdditional;
	}
	
	public void setEmpleadoProcesoRubroLogicAdditional(EmpleadoProcesoRubroLogicAdditional empleadoprocesorubroLogicAdditional) {
		try {
			this.empleadoprocesorubroLogicAdditional=empleadoprocesorubroLogicAdditional;
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
	
	
	
	
	public  EmpleadoProcesoRubroLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empleadoprocesorubroDataAccess = new EmpleadoProcesoRubroDataAccess();
			
			this.empleadoprocesorubros= new ArrayList<EmpleadoProcesoRubro>();
			this.empleadoprocesorubro= new EmpleadoProcesoRubro();
			
			this.empleadoprocesorubroObject=new Object();
			this.empleadoprocesorubrosObject=new ArrayList<Object>();
				
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
			
			this.empleadoprocesorubroDataAccess.setConnexionType(this.connexionType);
			this.empleadoprocesorubroDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpleadoProcesoRubroLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empleadoprocesorubroDataAccess = new EmpleadoProcesoRubroDataAccess();
			this.empleadoprocesorubros= new ArrayList<EmpleadoProcesoRubro>();
			this.empleadoprocesorubro= new EmpleadoProcesoRubro();
			this.empleadoprocesorubroObject=new Object();
			this.empleadoprocesorubrosObject=new ArrayList<Object>();
			
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
			
			this.empleadoprocesorubroDataAccess.setConnexionType(this.connexionType);
			this.empleadoprocesorubroDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EmpleadoProcesoRubro getEmpleadoProcesoRubro() throws Exception {	
		EmpleadoProcesoRubroLogicAdditional.checkEmpleadoProcesoRubroToGet(empleadoprocesorubro,this.datosCliente,this.arrDatoGeneral);
		EmpleadoProcesoRubroLogicAdditional.updateEmpleadoProcesoRubroToGet(empleadoprocesorubro,this.arrDatoGeneral);
		
		return empleadoprocesorubro;
	}
		
	public void setEmpleadoProcesoRubro(EmpleadoProcesoRubro newEmpleadoProcesoRubro) {
		this.empleadoprocesorubro = newEmpleadoProcesoRubro;
	}
	
	public EmpleadoProcesoRubroDataAccess getEmpleadoProcesoRubroDataAccess() {
		return empleadoprocesorubroDataAccess;
	}
	
	public void setEmpleadoProcesoRubroDataAccess(EmpleadoProcesoRubroDataAccess newempleadoprocesorubroDataAccess) {
		this.empleadoprocesorubroDataAccess = newempleadoprocesorubroDataAccess;
	}
	
	public List<EmpleadoProcesoRubro> getEmpleadoProcesoRubros() throws Exception {		
		this.quitarEmpleadoProcesoRubrosNulos();
		
		EmpleadoProcesoRubroLogicAdditional.checkEmpleadoProcesoRubroToGets(empleadoprocesorubros,this.datosCliente,this.arrDatoGeneral);
		
		for (EmpleadoProcesoRubro empleadoprocesorubroLocal: empleadoprocesorubros ) {
			EmpleadoProcesoRubroLogicAdditional.updateEmpleadoProcesoRubroToGet(empleadoprocesorubroLocal,this.arrDatoGeneral);
		}
		
		return empleadoprocesorubros;
	}
	
	public void setEmpleadoProcesoRubros(List<EmpleadoProcesoRubro> newEmpleadoProcesoRubros) {
		this.empleadoprocesorubros = newEmpleadoProcesoRubros;
	}
	
	public Object getEmpleadoProcesoRubroObject() {	
		this.empleadoprocesorubroObject=this.empleadoprocesorubroDataAccess.getEntityObject();
		return this.empleadoprocesorubroObject;
	}
		
	public void setEmpleadoProcesoRubroObject(Object newEmpleadoProcesoRubroObject) {
		this.empleadoprocesorubroObject = newEmpleadoProcesoRubroObject;
	}
	
	public List<Object> getEmpleadoProcesoRubrosObject() {		
		this.empleadoprocesorubrosObject=this.empleadoprocesorubroDataAccess.getEntitiesObject();
		return this.empleadoprocesorubrosObject;
	}
		
	public void setEmpleadoProcesoRubrosObject(List<Object> newEmpleadoProcesoRubrosObject) {
		this.empleadoprocesorubrosObject = newEmpleadoProcesoRubrosObject;
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
		
		if(this.empleadoprocesorubroDataAccess!=null) {
			this.empleadoprocesorubroDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empleadoprocesorubroDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empleadoprocesorubroDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoprocesorubro=empleadoprocesorubroDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoprocesorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubro);
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
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		  		  
        try {
			
			empleadoprocesorubro=empleadoprocesorubroDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoprocesorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoprocesorubro=empleadoprocesorubroDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoprocesorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubro);
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
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		  		  
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
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		  		  
        try {
			
			empleadoprocesorubro=empleadoprocesorubroDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoprocesorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		  		  
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
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empleadoprocesorubroDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empleadoprocesorubroDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empleadoprocesorubroDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empleadoprocesorubroDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empleadoprocesorubroDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empleadoprocesorubroDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoprocesorubros = new  ArrayList<EmpleadoProcesoRubro>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoProcesoRubro(empleadoprocesorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
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
		empleadoprocesorubros = new  ArrayList<EmpleadoProcesoRubro>();
		  		  
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
		empleadoprocesorubros = new  ArrayList<EmpleadoProcesoRubro>();
		  		  
        try {			
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpleadoProcesoRubro(empleadoprocesorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empleadoprocesorubros = new  ArrayList<EmpleadoProcesoRubro>();
		  		  
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
		empleadoprocesorubros = new  ArrayList<EmpleadoProcesoRubro>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoProcesoRubro(empleadoprocesorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
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
		empleadoprocesorubros = new  ArrayList<EmpleadoProcesoRubro>();
		  		  
        try {
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoProcesoRubro(empleadoprocesorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
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
		empleadoprocesorubros = new  ArrayList<EmpleadoProcesoRubro>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoProcesoRubro(empleadoprocesorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
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
		empleadoprocesorubros = new  ArrayList<EmpleadoProcesoRubro>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoProcesoRubro(empleadoprocesorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoprocesorubro=empleadoprocesorubroDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoProcesoRubro(empleadoprocesorubro);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubro);
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
		empleadoprocesorubro = new  EmpleadoProcesoRubro();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoprocesorubro=empleadoprocesorubroDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoProcesoRubro(empleadoprocesorubro);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoprocesorubros = new  ArrayList<EmpleadoProcesoRubro>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoProcesoRubro(empleadoprocesorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
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
		empleadoprocesorubros = new  ArrayList<EmpleadoProcesoRubro>();
		  		  
        try {
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoProcesoRubro(empleadoprocesorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpleadoProcesoRubrosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoprocesorubros = new  ArrayList<EmpleadoProcesoRubro>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getTodosEmpleadoProcesoRubrosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoProcesoRubro(empleadoprocesorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
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
	
	public  void  getTodosEmpleadoProcesoRubros(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoprocesorubros = new  ArrayList<EmpleadoProcesoRubro>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoProcesoRubro(empleadoprocesorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpleadoProcesoRubro(EmpleadoProcesoRubro empleadoprocesorubro) throws Exception {
		Boolean estaValidado=false;
		
		if(empleadoprocesorubro.getIsNew() || empleadoprocesorubro.getIsChanged()) { 
			this.invalidValues = empleadoprocesorubroValidator.getInvalidValues(empleadoprocesorubro);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empleadoprocesorubro);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpleadoProcesoRubro(List<EmpleadoProcesoRubro> EmpleadoProcesoRubros) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EmpleadoProcesoRubro empleadoprocesorubroLocal:empleadoprocesorubros) {				
			estaValidadoObjeto=this.validarGuardarEmpleadoProcesoRubro(empleadoprocesorubroLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpleadoProcesoRubro(List<EmpleadoProcesoRubro> EmpleadoProcesoRubros) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoProcesoRubro(empleadoprocesorubros)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpleadoProcesoRubro(EmpleadoProcesoRubro EmpleadoProcesoRubro) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoProcesoRubro(empleadoprocesorubro)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EmpleadoProcesoRubro empleadoprocesorubro) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empleadoprocesorubro.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpleadoProcesoRubroConstantesFunciones.getEmpleadoProcesoRubroLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empleadoprocesorubro","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpleadoProcesoRubroConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpleadoProcesoRubroConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpleadoProcesoRubroWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-saveEmpleadoProcesoRubroWithConnection");connexion.begin();			
			
			EmpleadoProcesoRubroLogicAdditional.checkEmpleadoProcesoRubroToSave(this.empleadoprocesorubro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoProcesoRubroLogicAdditional.updateEmpleadoProcesoRubroToSave(this.empleadoprocesorubro,this.arrDatoGeneral);
			
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoprocesorubro,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoProcesoRubro();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoProcesoRubro(this.empleadoprocesorubro)) {
				EmpleadoProcesoRubroDataAccess.save(this.empleadoprocesorubro, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empleadoprocesorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoProcesoRubroLogicAdditional.checkEmpleadoProcesoRubroToSaveAfter(this.empleadoprocesorubro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoProcesoRubro();
			
			connexion.commit();			
			
			if(this.empleadoprocesorubro.getIsDeleted()) {
				this.empleadoprocesorubro=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpleadoProcesoRubro()throws Exception {	
		try {	
			
			EmpleadoProcesoRubroLogicAdditional.checkEmpleadoProcesoRubroToSave(this.empleadoprocesorubro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoProcesoRubroLogicAdditional.updateEmpleadoProcesoRubroToSave(this.empleadoprocesorubro,this.arrDatoGeneral);
			
			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoprocesorubro,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoProcesoRubro(this.empleadoprocesorubro)) {			
				EmpleadoProcesoRubroDataAccess.save(this.empleadoprocesorubro, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empleadoprocesorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoProcesoRubroLogicAdditional.checkEmpleadoProcesoRubroToSaveAfter(this.empleadoprocesorubro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empleadoprocesorubro.getIsDeleted()) {
				this.empleadoprocesorubro=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpleadoProcesoRubrosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-saveEmpleadoProcesoRubrosWithConnection");connexion.begin();			
			
			EmpleadoProcesoRubroLogicAdditional.checkEmpleadoProcesoRubroToSaves(empleadoprocesorubros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoProcesoRubros();
			
			Boolean validadoTodosEmpleadoProcesoRubro=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoProcesoRubro empleadoprocesorubroLocal:empleadoprocesorubros) {		
				if(empleadoprocesorubroLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoProcesoRubroLogicAdditional.updateEmpleadoProcesoRubroToSave(empleadoprocesorubroLocal,this.arrDatoGeneral);
	        	
				EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoprocesorubroLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoProcesoRubro(empleadoprocesorubroLocal)) {
					EmpleadoProcesoRubroDataAccess.save(empleadoprocesorubroLocal, connexion);				
				} else {
					validadoTodosEmpleadoProcesoRubro=false;
				}
			}
			
			if(!validadoTodosEmpleadoProcesoRubro) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoProcesoRubroLogicAdditional.checkEmpleadoProcesoRubroToSavesAfter(empleadoprocesorubros,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoProcesoRubros();
			
			connexion.commit();		
			
			this.quitarEmpleadoProcesoRubrosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpleadoProcesoRubros()throws Exception {				
		 try {	
			EmpleadoProcesoRubroLogicAdditional.checkEmpleadoProcesoRubroToSaves(empleadoprocesorubros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpleadoProcesoRubro=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoProcesoRubro empleadoprocesorubroLocal:empleadoprocesorubros) {				
				if(empleadoprocesorubroLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoProcesoRubroLogicAdditional.updateEmpleadoProcesoRubroToSave(empleadoprocesorubroLocal,this.arrDatoGeneral);
	        	
				EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoprocesorubroLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoProcesoRubro(empleadoprocesorubroLocal)) {				
					EmpleadoProcesoRubroDataAccess.save(empleadoprocesorubroLocal, connexion);				
				} else {
					validadoTodosEmpleadoProcesoRubro=false;
				}
			}
			
			if(!validadoTodosEmpleadoProcesoRubro) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoProcesoRubroLogicAdditional.checkEmpleadoProcesoRubroToSavesAfter(empleadoprocesorubros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpleadoProcesoRubrosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoProcesoRubroParameterReturnGeneral procesarAccionEmpleadoProcesoRubros(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoProcesoRubro> empleadoprocesorubros,EmpleadoProcesoRubroParameterReturnGeneral empleadoprocesorubroParameterGeneral)throws Exception {
		 try {	
			EmpleadoProcesoRubroParameterReturnGeneral empleadoprocesorubroReturnGeneral=new EmpleadoProcesoRubroParameterReturnGeneral();
	
			EmpleadoProcesoRubroLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoprocesorubros,empleadoprocesorubroParameterGeneral,empleadoprocesorubroReturnGeneral);
			
			return empleadoprocesorubroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoProcesoRubroParameterReturnGeneral procesarAccionEmpleadoProcesoRubrosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoProcesoRubro> empleadoprocesorubros,EmpleadoProcesoRubroParameterReturnGeneral empleadoprocesorubroParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-procesarAccionEmpleadoProcesoRubrosWithConnection");connexion.begin();			
			
			EmpleadoProcesoRubroParameterReturnGeneral empleadoprocesorubroReturnGeneral=new EmpleadoProcesoRubroParameterReturnGeneral();
	
			EmpleadoProcesoRubroLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoprocesorubros,empleadoprocesorubroParameterGeneral,empleadoprocesorubroReturnGeneral);
			
			this.connexion.commit();
			
			return empleadoprocesorubroReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoProcesoRubroParameterReturnGeneral procesarEventosEmpleadoProcesoRubros(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoProcesoRubro> empleadoprocesorubros,EmpleadoProcesoRubro empleadoprocesorubro,EmpleadoProcesoRubroParameterReturnGeneral empleadoprocesorubroParameterGeneral,Boolean isEsNuevoEmpleadoProcesoRubro,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpleadoProcesoRubroParameterReturnGeneral empleadoprocesorubroReturnGeneral=new EmpleadoProcesoRubroParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoprocesorubroReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoProcesoRubroLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoprocesorubros,empleadoprocesorubro,empleadoprocesorubroParameterGeneral,empleadoprocesorubroReturnGeneral,isEsNuevoEmpleadoProcesoRubro,clases);
			
			return empleadoprocesorubroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpleadoProcesoRubroParameterReturnGeneral procesarEventosEmpleadoProcesoRubrosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoProcesoRubro> empleadoprocesorubros,EmpleadoProcesoRubro empleadoprocesorubro,EmpleadoProcesoRubroParameterReturnGeneral empleadoprocesorubroParameterGeneral,Boolean isEsNuevoEmpleadoProcesoRubro,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-procesarEventosEmpleadoProcesoRubrosWithConnection");connexion.begin();			
			
			EmpleadoProcesoRubroParameterReturnGeneral empleadoprocesorubroReturnGeneral=new EmpleadoProcesoRubroParameterReturnGeneral();
	
			empleadoprocesorubroReturnGeneral.setEmpleadoProcesoRubro(empleadoprocesorubro);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoprocesorubroReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoProcesoRubroLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoprocesorubros,empleadoprocesorubro,empleadoprocesorubroParameterGeneral,empleadoprocesorubroReturnGeneral,isEsNuevoEmpleadoProcesoRubro,clases);
			
			this.connexion.commit();
			
			return empleadoprocesorubroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoProcesoRubroParameterReturnGeneral procesarImportacionEmpleadoProcesoRubrosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpleadoProcesoRubroParameterReturnGeneral empleadoprocesorubroParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-procesarImportacionEmpleadoProcesoRubrosWithConnection");connexion.begin();			
			
			EmpleadoProcesoRubroParameterReturnGeneral empleadoprocesorubroReturnGeneral=new EmpleadoProcesoRubroParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empleadoprocesorubros=new ArrayList<EmpleadoProcesoRubro>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empleadoprocesorubro=new EmpleadoProcesoRubro();
				
				
				if(conColumnasBase) {this.empleadoprocesorubro.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empleadoprocesorubro.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empleadoprocesorubro.setfecha_ingreso(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.empleadoprocesorubro.setfecha_salida(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.empleadoprocesorubro.setobservaciones(arrColumnas[iColumn++]);
				this.empleadoprocesorubro.setnumeros_reingreso(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.empleadoprocesorubros.add(this.empleadoprocesorubro);
			}
			
			this.saveEmpleadoProcesoRubros();
			
			this.connexion.commit();
			
			empleadoprocesorubroReturnGeneral.setConRetornoEstaProcesado(true);
			empleadoprocesorubroReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empleadoprocesorubroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpleadoProcesoRubrosEliminados() throws Exception {				
		
		List<EmpleadoProcesoRubro> empleadoprocesorubrosAux= new ArrayList<EmpleadoProcesoRubro>();
		
		for(EmpleadoProcesoRubro empleadoprocesorubro:empleadoprocesorubros) {
			if(!empleadoprocesorubro.getIsDeleted()) {
				empleadoprocesorubrosAux.add(empleadoprocesorubro);
			}
		}
		
		empleadoprocesorubros=empleadoprocesorubrosAux;
	}
	
	public void quitarEmpleadoProcesoRubrosNulos() throws Exception {				
		
		List<EmpleadoProcesoRubro> empleadoprocesorubrosAux= new ArrayList<EmpleadoProcesoRubro>();
		
		for(EmpleadoProcesoRubro empleadoprocesorubro : this.empleadoprocesorubros) {
			if(empleadoprocesorubro==null) {
				empleadoprocesorubrosAux.add(empleadoprocesorubro);
			}
		}
		
		//this.empleadoprocesorubros=empleadoprocesorubrosAux;
		
		this.empleadoprocesorubros.removeAll(empleadoprocesorubrosAux);
	}
	
	public void getSetVersionRowEmpleadoProcesoRubroWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empleadoprocesorubro.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empleadoprocesorubro.getIsDeleted() || (empleadoprocesorubro.getIsChanged()&&!empleadoprocesorubro.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empleadoprocesorubroDataAccess.getSetVersionRowEmpleadoProcesoRubro(connexion,empleadoprocesorubro.getId());
				
				if(!empleadoprocesorubro.getVersionRow().equals(timestamp)) {	
					empleadoprocesorubro.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empleadoprocesorubro.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpleadoProcesoRubro()throws Exception {	
		
		if(empleadoprocesorubro.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empleadoprocesorubro.getIsDeleted() || (empleadoprocesorubro.getIsChanged()&&!empleadoprocesorubro.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empleadoprocesorubroDataAccess.getSetVersionRowEmpleadoProcesoRubro(connexion,empleadoprocesorubro.getId());
			
			try {							
				if(!empleadoprocesorubro.getVersionRow().equals(timestamp)) {	
					empleadoprocesorubro.setVersionRow(timestamp);
				}
				
				empleadoprocesorubro.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpleadoProcesoRubrosWithConnection()throws Exception {	
		if(empleadoprocesorubros!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EmpleadoProcesoRubro empleadoprocesorubroAux:empleadoprocesorubros) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empleadoprocesorubroAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoprocesorubroAux.getIsDeleted() || (empleadoprocesorubroAux.getIsChanged()&&!empleadoprocesorubroAux.getIsNew())) {
						
						timestamp=empleadoprocesorubroDataAccess.getSetVersionRowEmpleadoProcesoRubro(connexion,empleadoprocesorubroAux.getId());
						
						if(!empleadoprocesorubro.getVersionRow().equals(timestamp)) {	
							empleadoprocesorubroAux.setVersionRow(timestamp);
						}
								
						empleadoprocesorubroAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpleadoProcesoRubros()throws Exception {	
		if(empleadoprocesorubros!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EmpleadoProcesoRubro empleadoprocesorubroAux:empleadoprocesorubros) {
					if(empleadoprocesorubroAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoprocesorubroAux.getIsDeleted() || (empleadoprocesorubroAux.getIsChanged()&&!empleadoprocesorubroAux.getIsNew())) {
						
						timestamp=empleadoprocesorubroDataAccess.getSetVersionRowEmpleadoProcesoRubro(connexion,empleadoprocesorubroAux.getId());
						
						if(!empleadoprocesorubroAux.getVersionRow().equals(timestamp)) {	
							empleadoprocesorubroAux.setVersionRow(timestamp);
						}
						
													
						empleadoprocesorubroAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpleadoProcesoRubroParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoProcesoRubroWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstructura,String finalQueryGlobalEmpleado) throws Exception {
		EmpleadoProcesoRubroParameterReturnGeneral  empleadoprocesorubroReturnGeneral =new EmpleadoProcesoRubroParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpleadoProcesoRubroWithConnection");connexion.begin();
			
			empleadoprocesorubroReturnGeneral =new EmpleadoProcesoRubroParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoprocesorubroReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			empleadoprocesorubroReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			empleadoprocesorubroReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoprocesorubroReturnGeneral.setempleadosForeignKey(empleadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empleadoprocesorubroReturnGeneral;
	}
	
	public EmpleadoProcesoRubroParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoProcesoRubro(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstructura,String finalQueryGlobalEmpleado) throws Exception {
		EmpleadoProcesoRubroParameterReturnGeneral  empleadoprocesorubroReturnGeneral =new EmpleadoProcesoRubroParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empleadoprocesorubroReturnGeneral =new EmpleadoProcesoRubroParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoprocesorubroReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			empleadoprocesorubroReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			empleadoprocesorubroReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoprocesorubroReturnGeneral.setempleadosForeignKey(empleadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empleadoprocesorubroReturnGeneral;
	}
	
	
	public void deepLoad(EmpleadoProcesoRubro empleadoprocesorubro,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpleadoProcesoRubroLogicAdditional.updateEmpleadoProcesoRubroToGet(empleadoprocesorubro,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoprocesorubro.setEmpresa(empleadoprocesorubroDataAccess.getEmpresa(connexion,empleadoprocesorubro));
		empleadoprocesorubro.setSucursal(empleadoprocesorubroDataAccess.getSucursal(connexion,empleadoprocesorubro));
		empleadoprocesorubro.setEstructura(empleadoprocesorubroDataAccess.getEstructura(connexion,empleadoprocesorubro));
		empleadoprocesorubro.setEmpleado(empleadoprocesorubroDataAccess.getEmpleado(connexion,empleadoprocesorubro));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoprocesorubro.setEmpresa(empleadoprocesorubroDataAccess.getEmpresa(connexion,empleadoprocesorubro));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				empleadoprocesorubro.setSucursal(empleadoprocesorubroDataAccess.getSucursal(connexion,empleadoprocesorubro));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				empleadoprocesorubro.setEstructura(empleadoprocesorubroDataAccess.getEstructura(connexion,empleadoprocesorubro));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoprocesorubro.setEmpleado(empleadoprocesorubroDataAccess.getEmpleado(connexion,empleadoprocesorubro));
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
			empleadoprocesorubro.setEmpresa(empleadoprocesorubroDataAccess.getEmpresa(connexion,empleadoprocesorubro));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoprocesorubro.setSucursal(empleadoprocesorubroDataAccess.getSucursal(connexion,empleadoprocesorubro));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoprocesorubro.setEstructura(empleadoprocesorubroDataAccess.getEstructura(connexion,empleadoprocesorubro));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoprocesorubro.setEmpleado(empleadoprocesorubroDataAccess.getEmpleado(connexion,empleadoprocesorubro));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoprocesorubro.setEmpresa(empleadoprocesorubroDataAccess.getEmpresa(connexion,empleadoprocesorubro));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoprocesorubro.getEmpresa(),isDeep,deepLoadType,clases);
				
		empleadoprocesorubro.setSucursal(empleadoprocesorubroDataAccess.getSucursal(connexion,empleadoprocesorubro));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(empleadoprocesorubro.getSucursal(),isDeep,deepLoadType,clases);
				
		empleadoprocesorubro.setEstructura(empleadoprocesorubroDataAccess.getEstructura(connexion,empleadoprocesorubro));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(empleadoprocesorubro.getEstructura(),isDeep,deepLoadType,clases);
				
		empleadoprocesorubro.setEmpleado(empleadoprocesorubroDataAccess.getEmpleado(connexion,empleadoprocesorubro));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoprocesorubro.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoprocesorubro.setEmpresa(empleadoprocesorubroDataAccess.getEmpresa(connexion,empleadoprocesorubro));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(empleadoprocesorubro.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				empleadoprocesorubro.setSucursal(empleadoprocesorubroDataAccess.getSucursal(connexion,empleadoprocesorubro));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(empleadoprocesorubro.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				empleadoprocesorubro.setEstructura(empleadoprocesorubroDataAccess.getEstructura(connexion,empleadoprocesorubro));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(empleadoprocesorubro.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoprocesorubro.setEmpleado(empleadoprocesorubroDataAccess.getEmpleado(connexion,empleadoprocesorubro));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleadoprocesorubro.getEmpleado(),isDeep,deepLoadType,clases);				
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
			empleadoprocesorubro.setEmpresa(empleadoprocesorubroDataAccess.getEmpresa(connexion,empleadoprocesorubro));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(empleadoprocesorubro.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoprocesorubro.setSucursal(empleadoprocesorubroDataAccess.getSucursal(connexion,empleadoprocesorubro));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(empleadoprocesorubro.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoprocesorubro.setEstructura(empleadoprocesorubroDataAccess.getEstructura(connexion,empleadoprocesorubro));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(empleadoprocesorubro.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoprocesorubro.setEmpleado(empleadoprocesorubroDataAccess.getEmpleado(connexion,empleadoprocesorubro));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleadoprocesorubro.getEmpleado(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EmpleadoProcesoRubro empleadoprocesorubro,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpleadoProcesoRubroLogicAdditional.updateEmpleadoProcesoRubroToSave(empleadoprocesorubro,this.arrDatoGeneral);
			
EmpleadoProcesoRubroDataAccess.save(empleadoprocesorubro, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoprocesorubro.getEmpresa(),connexion);

		SucursalDataAccess.save(empleadoprocesorubro.getSucursal(),connexion);

		EstructuraDataAccess.save(empleadoprocesorubro.getEstructura(),connexion);

		EmpleadoDataAccess.save(empleadoprocesorubro.getEmpleado(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoprocesorubro.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(empleadoprocesorubro.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(empleadoprocesorubro.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoprocesorubro.getEmpleado(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoprocesorubro.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoprocesorubro.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(empleadoprocesorubro.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(empleadoprocesorubro.getSucursal(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(empleadoprocesorubro.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(empleadoprocesorubro.getEstructura(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(empleadoprocesorubro.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoprocesorubro.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoprocesorubro.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(empleadoprocesorubro.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(empleadoprocesorubro.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(empleadoprocesorubro.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(empleadoprocesorubro.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(empleadoprocesorubro.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoprocesorubro.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(empleadoprocesorubro.getEmpleado(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(EmpleadoProcesoRubro.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empleadoprocesorubro,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(empleadoprocesorubro);
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
			this.deepLoad(this.empleadoprocesorubro,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EmpleadoProcesoRubro.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empleadoprocesorubros!=null) {
				for(EmpleadoProcesoRubro empleadoprocesorubro:empleadoprocesorubros) {
					this.deepLoad(empleadoprocesorubro,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(empleadoprocesorubros);
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
			if(empleadoprocesorubros!=null) {
				for(EmpleadoProcesoRubro empleadoprocesorubro:empleadoprocesorubros) {
					this.deepLoad(empleadoprocesorubro,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(empleadoprocesorubros);
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
			this.getNewConnexionToDeep(EmpleadoProcesoRubro.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empleadoprocesorubro,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EmpleadoProcesoRubro.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empleadoprocesorubros!=null) {
				for(EmpleadoProcesoRubro empleadoprocesorubro:empleadoprocesorubros) {
					this.deepSave(empleadoprocesorubro,isDeep,deepLoadType,clases);
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
			if(empleadoprocesorubros!=null) {
				for(EmpleadoProcesoRubro empleadoprocesorubro:empleadoprocesorubros) {
					this.deepSave(empleadoprocesorubro,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpleadoProcesoRubrosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoProcesoRubroConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoProcesoRubrosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoProcesoRubroConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoProcesoRubrosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoProcesoRubrosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoProcesoRubrosFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EmpleadoProcesoRubroConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoProcesoRubrosFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EmpleadoProcesoRubroConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoProcesoRubrosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoProcesoRubro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoProcesoRubrosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EmpleadoProcesoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(this.empleadoprocesorubros);
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
			if(EmpleadoProcesoRubroConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoProcesoRubroDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EmpleadoProcesoRubro empleadoprocesorubro,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpleadoProcesoRubroConstantesFunciones.ISCONAUDITORIA) {
				if(empleadoprocesorubro.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoProcesoRubroDataAccess.TABLENAME, empleadoprocesorubro.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoProcesoRubroConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoProcesoRubroLogic.registrarAuditoriaDetallesEmpleadoProcesoRubro(connexion,empleadoprocesorubro,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empleadoprocesorubro.getIsDeleted()) {
					/*if(!empleadoprocesorubro.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpleadoProcesoRubroDataAccess.TABLENAME, empleadoprocesorubro.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpleadoProcesoRubroLogic.registrarAuditoriaDetallesEmpleadoProcesoRubro(connexion,empleadoprocesorubro,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoProcesoRubroDataAccess.TABLENAME, empleadoprocesorubro.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empleadoprocesorubro.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoProcesoRubroDataAccess.TABLENAME, empleadoprocesorubro.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoProcesoRubroConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoProcesoRubroLogic.registrarAuditoriaDetallesEmpleadoProcesoRubro(connexion,empleadoprocesorubro,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpleadoProcesoRubro(Connexion connexion,EmpleadoProcesoRubro empleadoprocesorubro)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empleadoprocesorubro.getIsNew()||!empleadoprocesorubro.getid_empresa().equals(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getid_empresa()!=null)
				{
					strValorActual=empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getid_empresa().toString();
				}
				if(empleadoprocesorubro.getid_empresa()!=null)
				{
					strValorNuevo=empleadoprocesorubro.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoprocesorubro.getIsNew()||!empleadoprocesorubro.getid_sucursal().equals(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getid_sucursal()!=null)
				{
					strValorActual=empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getid_sucursal().toString();
				}
				if(empleadoprocesorubro.getid_sucursal()!=null)
				{
					strValorNuevo=empleadoprocesorubro.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(empleadoprocesorubro.getIsNew()||!empleadoprocesorubro.getid_estructura().equals(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getid_estructura()!=null)
				{
					strValorActual=empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getid_estructura().toString();
				}
				if(empleadoprocesorubro.getid_estructura()!=null)
				{
					strValorNuevo=empleadoprocesorubro.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoProcesoRubroConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoprocesorubro.getIsNew()||!empleadoprocesorubro.getid_empleado().equals(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getid_empleado()!=null)
				{
					strValorActual=empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getid_empleado().toString();
				}
				if(empleadoprocesorubro.getid_empleado()!=null)
				{
					strValorNuevo=empleadoprocesorubro.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoProcesoRubroConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoprocesorubro.getIsNew()||!empleadoprocesorubro.getfecha_ingreso().equals(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getfecha_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getfecha_ingreso()!=null)
				{
					strValorActual=empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getfecha_ingreso().toString();
				}
				if(empleadoprocesorubro.getfecha_ingreso()!=null)
				{
					strValorNuevo=empleadoprocesorubro.getfecha_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoProcesoRubroConstantesFunciones.FECHAINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoprocesorubro.getIsNew()||!empleadoprocesorubro.getfecha_salida().equals(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getfecha_salida()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getfecha_salida()!=null)
				{
					strValorActual=empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getfecha_salida().toString();
				}
				if(empleadoprocesorubro.getfecha_salida()!=null)
				{
					strValorNuevo=empleadoprocesorubro.getfecha_salida().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoProcesoRubroConstantesFunciones.FECHASALIDA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoprocesorubro.getIsNew()||!empleadoprocesorubro.getobservaciones().equals(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getobservaciones()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getobservaciones()!=null)
				{
					strValorActual=empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getobservaciones();
				}
				if(empleadoprocesorubro.getobservaciones()!=null)
				{
					strValorNuevo=empleadoprocesorubro.getobservaciones() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoProcesoRubroConstantesFunciones.OBSERVACIONES,strValorActual,strValorNuevo);
			}	
			
			if(empleadoprocesorubro.getIsNew()||!empleadoprocesorubro.getnumeros_reingreso().equals(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getnumeros_reingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getnumeros_reingreso()!=null)
				{
					strValorActual=empleadoprocesorubro.getEmpleadoProcesoRubroOriginal().getnumeros_reingreso().toString();
				}
				if(empleadoprocesorubro.getnumeros_reingreso()!=null)
				{
					strValorNuevo=empleadoprocesorubro.getnumeros_reingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoProcesoRubroConstantesFunciones.NUMEROSREINGRESO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpleadoProcesoRubroRelacionesWithConnection(EmpleadoProcesoRubro empleadoprocesorubro) throws Exception {

		if(!empleadoprocesorubro.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoProcesoRubroRelacionesBase(empleadoprocesorubro,true);
		}
	}

	public void saveEmpleadoProcesoRubroRelaciones(EmpleadoProcesoRubro empleadoprocesorubro)throws Exception {

		if(!empleadoprocesorubro.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoProcesoRubroRelacionesBase(empleadoprocesorubro,false);
		}
	}

	public void saveEmpleadoProcesoRubroRelacionesBase(EmpleadoProcesoRubro empleadoprocesorubro,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EmpleadoProcesoRubro-saveRelacionesWithConnection");}
	

			this.setEmpleadoProcesoRubro(empleadoprocesorubro);

			if(EmpleadoProcesoRubroLogicAdditional.validarSaveRelaciones(empleadoprocesorubro,this)) {

				EmpleadoProcesoRubroLogicAdditional.updateRelacionesToSave(empleadoprocesorubro,this);

				if((empleadoprocesorubro.getIsNew()||empleadoprocesorubro.getIsChanged())&&!empleadoprocesorubro.getIsDeleted()) {
					this.saveEmpleadoProcesoRubro();
					this.saveEmpleadoProcesoRubroRelacionesDetalles();

				} else if(empleadoprocesorubro.getIsDeleted()) {
					this.saveEmpleadoProcesoRubroRelacionesDetalles();
					this.saveEmpleadoProcesoRubro();
				}

				EmpleadoProcesoRubroLogicAdditional.updateRelacionesToSaveAfter(empleadoprocesorubro,this);

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
	
	
	private void saveEmpleadoProcesoRubroRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoProcesoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoProcesoRubroConstantesFunciones.getClassesForeignKeysOfEmpleadoProcesoRubro(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoProcesoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoProcesoRubroConstantesFunciones.getClassesRelationshipsOfEmpleadoProcesoRubro(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

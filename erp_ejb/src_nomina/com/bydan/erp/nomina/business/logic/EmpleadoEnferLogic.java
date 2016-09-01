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
import com.bydan.erp.nomina.util.EmpleadoEnferConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoEnferParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoEnferParameterGeneral;
import com.bydan.erp.nomina.business.entity.EmpleadoEnfer;
import com.bydan.erp.nomina.business.logic.EmpleadoEnferLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmpleadoEnferLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpleadoEnferLogic.class);
	
	protected EmpleadoEnferDataAccess empleadoenferDataAccess; 	
	protected EmpleadoEnfer empleadoenfer;
	protected List<EmpleadoEnfer> empleadoenfers;
	protected Object empleadoenferObject;	
	protected List<Object> empleadoenfersObject;
	
	public static ClassValidator<EmpleadoEnfer> empleadoenferValidator = new ClassValidator<EmpleadoEnfer>(EmpleadoEnfer.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpleadoEnferLogicAdditional empleadoenferLogicAdditional=null;
	
	public EmpleadoEnferLogicAdditional getEmpleadoEnferLogicAdditional() {
		return this.empleadoenferLogicAdditional;
	}
	
	public void setEmpleadoEnferLogicAdditional(EmpleadoEnferLogicAdditional empleadoenferLogicAdditional) {
		try {
			this.empleadoenferLogicAdditional=empleadoenferLogicAdditional;
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
	
	
	
	
	public  EmpleadoEnferLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empleadoenferDataAccess = new EmpleadoEnferDataAccess();
			
			this.empleadoenfers= new ArrayList<EmpleadoEnfer>();
			this.empleadoenfer= new EmpleadoEnfer();
			
			this.empleadoenferObject=new Object();
			this.empleadoenfersObject=new ArrayList<Object>();
				
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
			
			this.empleadoenferDataAccess.setConnexionType(this.connexionType);
			this.empleadoenferDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpleadoEnferLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empleadoenferDataAccess = new EmpleadoEnferDataAccess();
			this.empleadoenfers= new ArrayList<EmpleadoEnfer>();
			this.empleadoenfer= new EmpleadoEnfer();
			this.empleadoenferObject=new Object();
			this.empleadoenfersObject=new ArrayList<Object>();
			
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
			
			this.empleadoenferDataAccess.setConnexionType(this.connexionType);
			this.empleadoenferDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EmpleadoEnfer getEmpleadoEnfer() throws Exception {	
		EmpleadoEnferLogicAdditional.checkEmpleadoEnferToGet(empleadoenfer,this.datosCliente,this.arrDatoGeneral);
		EmpleadoEnferLogicAdditional.updateEmpleadoEnferToGet(empleadoenfer,this.arrDatoGeneral);
		
		return empleadoenfer;
	}
		
	public void setEmpleadoEnfer(EmpleadoEnfer newEmpleadoEnfer) {
		this.empleadoenfer = newEmpleadoEnfer;
	}
	
	public EmpleadoEnferDataAccess getEmpleadoEnferDataAccess() {
		return empleadoenferDataAccess;
	}
	
	public void setEmpleadoEnferDataAccess(EmpleadoEnferDataAccess newempleadoenferDataAccess) {
		this.empleadoenferDataAccess = newempleadoenferDataAccess;
	}
	
	public List<EmpleadoEnfer> getEmpleadoEnfers() throws Exception {		
		this.quitarEmpleadoEnfersNulos();
		
		EmpleadoEnferLogicAdditional.checkEmpleadoEnferToGets(empleadoenfers,this.datosCliente,this.arrDatoGeneral);
		
		for (EmpleadoEnfer empleadoenferLocal: empleadoenfers ) {
			EmpleadoEnferLogicAdditional.updateEmpleadoEnferToGet(empleadoenferLocal,this.arrDatoGeneral);
		}
		
		return empleadoenfers;
	}
	
	public void setEmpleadoEnfers(List<EmpleadoEnfer> newEmpleadoEnfers) {
		this.empleadoenfers = newEmpleadoEnfers;
	}
	
	public Object getEmpleadoEnferObject() {	
		this.empleadoenferObject=this.empleadoenferDataAccess.getEntityObject();
		return this.empleadoenferObject;
	}
		
	public void setEmpleadoEnferObject(Object newEmpleadoEnferObject) {
		this.empleadoenferObject = newEmpleadoEnferObject;
	}
	
	public List<Object> getEmpleadoEnfersObject() {		
		this.empleadoenfersObject=this.empleadoenferDataAccess.getEntitiesObject();
		return this.empleadoenfersObject;
	}
		
	public void setEmpleadoEnfersObject(List<Object> newEmpleadoEnfersObject) {
		this.empleadoenfersObject = newEmpleadoEnfersObject;
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
		
		if(this.empleadoenferDataAccess!=null) {
			this.empleadoenferDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empleadoenferDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empleadoenferDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empleadoenfer = new  EmpleadoEnfer();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoenfer=empleadoenferDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoenfer,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfer);
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
		empleadoenfer = new  EmpleadoEnfer();
		  		  
        try {
			
			empleadoenfer=empleadoenferDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoenfer,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfer);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empleadoenfer = new  EmpleadoEnfer();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoenfer=empleadoenferDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoenfer,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfer);
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
		empleadoenfer = new  EmpleadoEnfer();
		  		  
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
		empleadoenfer = new  EmpleadoEnfer();
		  		  
        try {
			
			empleadoenfer=empleadoenferDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoenfer,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfer);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empleadoenfer = new  EmpleadoEnfer();
		  		  
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
		empleadoenfer = new  EmpleadoEnfer();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empleadoenferDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoenfer = new  EmpleadoEnfer();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empleadoenferDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoenfer = new  EmpleadoEnfer();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empleadoenferDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoenfer = new  EmpleadoEnfer();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empleadoenferDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoenfer = new  EmpleadoEnfer();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empleadoenferDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoenfer = new  EmpleadoEnfer();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empleadoenferDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoenfers = new  ArrayList<EmpleadoEnfer>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoenfers=empleadoenferDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoEnfer(empleadoenfers);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
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
		empleadoenfers = new  ArrayList<EmpleadoEnfer>();
		  		  
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
		empleadoenfers = new  ArrayList<EmpleadoEnfer>();
		  		  
        try {			
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoenfers=empleadoenferDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpleadoEnfer(empleadoenfers);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empleadoenfers = new  ArrayList<EmpleadoEnfer>();
		  		  
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
		empleadoenfers = new  ArrayList<EmpleadoEnfer>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoEnfer(empleadoenfers);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
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
		empleadoenfers = new  ArrayList<EmpleadoEnfer>();
		  		  
        try {
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoEnfer(empleadoenfers);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
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
		empleadoenfers = new  ArrayList<EmpleadoEnfer>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoEnfer(empleadoenfers);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
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
		empleadoenfers = new  ArrayList<EmpleadoEnfer>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoEnfer(empleadoenfers);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empleadoenfer = new  EmpleadoEnfer();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoenfer=empleadoenferDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoEnfer(empleadoenfer);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfer);
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
		empleadoenfer = new  EmpleadoEnfer();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoenfer=empleadoenferDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoEnfer(empleadoenfer);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfer);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoenfers = new  ArrayList<EmpleadoEnfer>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoenfers=empleadoenferDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoEnfer(empleadoenfers);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
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
		empleadoenfers = new  ArrayList<EmpleadoEnfer>();
		  		  
        try {
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoenfers=empleadoenferDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoEnfer(empleadoenfers);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpleadoEnfersWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoenfers = new  ArrayList<EmpleadoEnfer>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getTodosEmpleadoEnfersWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoEnfer(empleadoenfers);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
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
	
	public  void  getTodosEmpleadoEnfers(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoenfers = new  ArrayList<EmpleadoEnfer>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoEnfer(empleadoenfers);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpleadoEnfer(EmpleadoEnfer empleadoenfer) throws Exception {
		Boolean estaValidado=false;
		
		if(empleadoenfer.getIsNew() || empleadoenfer.getIsChanged()) { 
			this.invalidValues = empleadoenferValidator.getInvalidValues(empleadoenfer);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empleadoenfer);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpleadoEnfer(List<EmpleadoEnfer> EmpleadoEnfers) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EmpleadoEnfer empleadoenferLocal:empleadoenfers) {				
			estaValidadoObjeto=this.validarGuardarEmpleadoEnfer(empleadoenferLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpleadoEnfer(List<EmpleadoEnfer> EmpleadoEnfers) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoEnfer(empleadoenfers)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpleadoEnfer(EmpleadoEnfer EmpleadoEnfer) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoEnfer(empleadoenfer)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EmpleadoEnfer empleadoenfer) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empleadoenfer.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpleadoEnferConstantesFunciones.getEmpleadoEnferLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empleadoenfer","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpleadoEnferConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpleadoEnferConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpleadoEnferWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-saveEmpleadoEnferWithConnection");connexion.begin();			
			
			EmpleadoEnferLogicAdditional.checkEmpleadoEnferToSave(this.empleadoenfer,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoEnferLogicAdditional.updateEmpleadoEnferToSave(this.empleadoenfer,this.arrDatoGeneral);
			
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoenfer,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoEnfer();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoEnfer(this.empleadoenfer)) {
				EmpleadoEnferDataAccess.save(this.empleadoenfer, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empleadoenfer,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoEnferLogicAdditional.checkEmpleadoEnferToSaveAfter(this.empleadoenfer,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoEnfer();
			
			connexion.commit();			
			
			if(this.empleadoenfer.getIsDeleted()) {
				this.empleadoenfer=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpleadoEnfer()throws Exception {	
		try {	
			
			EmpleadoEnferLogicAdditional.checkEmpleadoEnferToSave(this.empleadoenfer,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoEnferLogicAdditional.updateEmpleadoEnferToSave(this.empleadoenfer,this.arrDatoGeneral);
			
			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoenfer,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoEnfer(this.empleadoenfer)) {			
				EmpleadoEnferDataAccess.save(this.empleadoenfer, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empleadoenfer,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoEnferLogicAdditional.checkEmpleadoEnferToSaveAfter(this.empleadoenfer,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empleadoenfer.getIsDeleted()) {
				this.empleadoenfer=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpleadoEnfersWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-saveEmpleadoEnfersWithConnection");connexion.begin();			
			
			EmpleadoEnferLogicAdditional.checkEmpleadoEnferToSaves(empleadoenfers,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoEnfers();
			
			Boolean validadoTodosEmpleadoEnfer=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoEnfer empleadoenferLocal:empleadoenfers) {		
				if(empleadoenferLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoEnferLogicAdditional.updateEmpleadoEnferToSave(empleadoenferLocal,this.arrDatoGeneral);
	        	
				EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoenferLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoEnfer(empleadoenferLocal)) {
					EmpleadoEnferDataAccess.save(empleadoenferLocal, connexion);				
				} else {
					validadoTodosEmpleadoEnfer=false;
				}
			}
			
			if(!validadoTodosEmpleadoEnfer) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoEnferLogicAdditional.checkEmpleadoEnferToSavesAfter(empleadoenfers,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoEnfers();
			
			connexion.commit();		
			
			this.quitarEmpleadoEnfersEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpleadoEnfers()throws Exception {				
		 try {	
			EmpleadoEnferLogicAdditional.checkEmpleadoEnferToSaves(empleadoenfers,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpleadoEnfer=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoEnfer empleadoenferLocal:empleadoenfers) {				
				if(empleadoenferLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoEnferLogicAdditional.updateEmpleadoEnferToSave(empleadoenferLocal,this.arrDatoGeneral);
	        	
				EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoenferLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoEnfer(empleadoenferLocal)) {				
					EmpleadoEnferDataAccess.save(empleadoenferLocal, connexion);				
				} else {
					validadoTodosEmpleadoEnfer=false;
				}
			}
			
			if(!validadoTodosEmpleadoEnfer) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoEnferLogicAdditional.checkEmpleadoEnferToSavesAfter(empleadoenfers,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpleadoEnfersEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoEnferParameterReturnGeneral procesarAccionEmpleadoEnfers(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoEnfer> empleadoenfers,EmpleadoEnferParameterReturnGeneral empleadoenferParameterGeneral)throws Exception {
		 try {	
			EmpleadoEnferParameterReturnGeneral empleadoenferReturnGeneral=new EmpleadoEnferParameterReturnGeneral();
	
			EmpleadoEnferLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoenfers,empleadoenferParameterGeneral,empleadoenferReturnGeneral);
			
			return empleadoenferReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoEnferParameterReturnGeneral procesarAccionEmpleadoEnfersWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoEnfer> empleadoenfers,EmpleadoEnferParameterReturnGeneral empleadoenferParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-procesarAccionEmpleadoEnfersWithConnection");connexion.begin();			
			
			EmpleadoEnferParameterReturnGeneral empleadoenferReturnGeneral=new EmpleadoEnferParameterReturnGeneral();
	
			EmpleadoEnferLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoenfers,empleadoenferParameterGeneral,empleadoenferReturnGeneral);
			
			this.connexion.commit();
			
			return empleadoenferReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoEnferParameterReturnGeneral procesarEventosEmpleadoEnfers(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoEnfer> empleadoenfers,EmpleadoEnfer empleadoenfer,EmpleadoEnferParameterReturnGeneral empleadoenferParameterGeneral,Boolean isEsNuevoEmpleadoEnfer,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpleadoEnferParameterReturnGeneral empleadoenferReturnGeneral=new EmpleadoEnferParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoenferReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoEnferLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoenfers,empleadoenfer,empleadoenferParameterGeneral,empleadoenferReturnGeneral,isEsNuevoEmpleadoEnfer,clases);
			
			return empleadoenferReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpleadoEnferParameterReturnGeneral procesarEventosEmpleadoEnfersWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoEnfer> empleadoenfers,EmpleadoEnfer empleadoenfer,EmpleadoEnferParameterReturnGeneral empleadoenferParameterGeneral,Boolean isEsNuevoEmpleadoEnfer,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-procesarEventosEmpleadoEnfersWithConnection");connexion.begin();			
			
			EmpleadoEnferParameterReturnGeneral empleadoenferReturnGeneral=new EmpleadoEnferParameterReturnGeneral();
	
			empleadoenferReturnGeneral.setEmpleadoEnfer(empleadoenfer);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoenferReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoEnferLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoenfers,empleadoenfer,empleadoenferParameterGeneral,empleadoenferReturnGeneral,isEsNuevoEmpleadoEnfer,clases);
			
			this.connexion.commit();
			
			return empleadoenferReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoEnferParameterReturnGeneral procesarImportacionEmpleadoEnfersWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpleadoEnferParameterReturnGeneral empleadoenferParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-procesarImportacionEmpleadoEnfersWithConnection");connexion.begin();			
			
			EmpleadoEnferParameterReturnGeneral empleadoenferReturnGeneral=new EmpleadoEnferParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empleadoenfers=new ArrayList<EmpleadoEnfer>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empleadoenfer=new EmpleadoEnfer();
				
				
				if(conColumnasBase) {this.empleadoenfer.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empleadoenfer.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empleadoenfer.setdescripcion(arrColumnas[iColumn++]);
				
				this.empleadoenfers.add(this.empleadoenfer);
			}
			
			this.saveEmpleadoEnfers();
			
			this.connexion.commit();
			
			empleadoenferReturnGeneral.setConRetornoEstaProcesado(true);
			empleadoenferReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empleadoenferReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpleadoEnfersEliminados() throws Exception {				
		
		List<EmpleadoEnfer> empleadoenfersAux= new ArrayList<EmpleadoEnfer>();
		
		for(EmpleadoEnfer empleadoenfer:empleadoenfers) {
			if(!empleadoenfer.getIsDeleted()) {
				empleadoenfersAux.add(empleadoenfer);
			}
		}
		
		empleadoenfers=empleadoenfersAux;
	}
	
	public void quitarEmpleadoEnfersNulos() throws Exception {				
		
		List<EmpleadoEnfer> empleadoenfersAux= new ArrayList<EmpleadoEnfer>();
		
		for(EmpleadoEnfer empleadoenfer : this.empleadoenfers) {
			if(empleadoenfer==null) {
				empleadoenfersAux.add(empleadoenfer);
			}
		}
		
		//this.empleadoenfers=empleadoenfersAux;
		
		this.empleadoenfers.removeAll(empleadoenfersAux);
	}
	
	public void getSetVersionRowEmpleadoEnferWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empleadoenfer.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empleadoenfer.getIsDeleted() || (empleadoenfer.getIsChanged()&&!empleadoenfer.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empleadoenferDataAccess.getSetVersionRowEmpleadoEnfer(connexion,empleadoenfer.getId());
				
				if(!empleadoenfer.getVersionRow().equals(timestamp)) {	
					empleadoenfer.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empleadoenfer.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpleadoEnfer()throws Exception {	
		
		if(empleadoenfer.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empleadoenfer.getIsDeleted() || (empleadoenfer.getIsChanged()&&!empleadoenfer.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empleadoenferDataAccess.getSetVersionRowEmpleadoEnfer(connexion,empleadoenfer.getId());
			
			try {							
				if(!empleadoenfer.getVersionRow().equals(timestamp)) {	
					empleadoenfer.setVersionRow(timestamp);
				}
				
				empleadoenfer.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpleadoEnfersWithConnection()throws Exception {	
		if(empleadoenfers!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EmpleadoEnfer empleadoenferAux:empleadoenfers) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empleadoenferAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoenferAux.getIsDeleted() || (empleadoenferAux.getIsChanged()&&!empleadoenferAux.getIsNew())) {
						
						timestamp=empleadoenferDataAccess.getSetVersionRowEmpleadoEnfer(connexion,empleadoenferAux.getId());
						
						if(!empleadoenfer.getVersionRow().equals(timestamp)) {	
							empleadoenferAux.setVersionRow(timestamp);
						}
								
						empleadoenferAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpleadoEnfers()throws Exception {	
		if(empleadoenfers!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EmpleadoEnfer empleadoenferAux:empleadoenfers) {
					if(empleadoenferAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoenferAux.getIsDeleted() || (empleadoenferAux.getIsChanged()&&!empleadoenferAux.getIsNew())) {
						
						timestamp=empleadoenferDataAccess.getSetVersionRowEmpleadoEnfer(connexion,empleadoenferAux.getId());
						
						if(!empleadoenferAux.getVersionRow().equals(timestamp)) {	
							empleadoenferAux.setVersionRow(timestamp);
						}
						
													
						empleadoenferAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpleadoEnferParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoEnferWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEnfermedad) throws Exception {
		EmpleadoEnferParameterReturnGeneral  empleadoenferReturnGeneral =new EmpleadoEnferParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpleadoEnferWithConnection");connexion.begin();
			
			empleadoenferReturnGeneral =new EmpleadoEnferParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoenferReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoenferReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Enfermedad> enfermedadsForeignKey=new ArrayList<Enfermedad>();
			EnfermedadLogic enfermedadLogic=new EnfermedadLogic();
			enfermedadLogic.setConnexion(this.connexion);
			enfermedadLogic.getEnfermedadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEnfermedad.equals("NONE")) {
				enfermedadLogic.getTodosEnfermedads(finalQueryGlobalEnfermedad,new Pagination());
				enfermedadsForeignKey=enfermedadLogic.getEnfermedads();
			}

			empleadoenferReturnGeneral.setenfermedadsForeignKey(enfermedadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empleadoenferReturnGeneral;
	}
	
	public EmpleadoEnferParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoEnfer(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEnfermedad) throws Exception {
		EmpleadoEnferParameterReturnGeneral  empleadoenferReturnGeneral =new EmpleadoEnferParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empleadoenferReturnGeneral =new EmpleadoEnferParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoenferReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoenferReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Enfermedad> enfermedadsForeignKey=new ArrayList<Enfermedad>();
			EnfermedadLogic enfermedadLogic=new EnfermedadLogic();
			enfermedadLogic.setConnexion(this.connexion);
			enfermedadLogic.getEnfermedadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEnfermedad.equals("NONE")) {
				enfermedadLogic.getTodosEnfermedads(finalQueryGlobalEnfermedad,new Pagination());
				enfermedadsForeignKey=enfermedadLogic.getEnfermedads();
			}

			empleadoenferReturnGeneral.setenfermedadsForeignKey(enfermedadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empleadoenferReturnGeneral;
	}
	
	
	public void deepLoad(EmpleadoEnfer empleadoenfer,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpleadoEnferLogicAdditional.updateEmpleadoEnferToGet(empleadoenfer,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoenfer.setEmpresa(empleadoenferDataAccess.getEmpresa(connexion,empleadoenfer));
		empleadoenfer.setEmpleado(empleadoenferDataAccess.getEmpleado(connexion,empleadoenfer));
		empleadoenfer.setEnfermedad(empleadoenferDataAccess.getEnfermedad(connexion,empleadoenfer));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoenfer.setEmpresa(empleadoenferDataAccess.getEmpresa(connexion,empleadoenfer));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoenfer.setEmpleado(empleadoenferDataAccess.getEmpleado(connexion,empleadoenfer));
				continue;
			}

			if(clas.clas.equals(Enfermedad.class)) {
				empleadoenfer.setEnfermedad(empleadoenferDataAccess.getEnfermedad(connexion,empleadoenfer));
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
			empleadoenfer.setEmpresa(empleadoenferDataAccess.getEmpresa(connexion,empleadoenfer));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoenfer.setEmpleado(empleadoenferDataAccess.getEmpleado(connexion,empleadoenfer));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Enfermedad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoenfer.setEnfermedad(empleadoenferDataAccess.getEnfermedad(connexion,empleadoenfer));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoenfer.setEmpresa(empleadoenferDataAccess.getEmpresa(connexion,empleadoenfer));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoenfer.getEmpresa(),isDeep,deepLoadType,clases);
				
		empleadoenfer.setEmpleado(empleadoenferDataAccess.getEmpleado(connexion,empleadoenfer));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoenfer.getEmpleado(),isDeep,deepLoadType,clases);
				
		empleadoenfer.setEnfermedad(empleadoenferDataAccess.getEnfermedad(connexion,empleadoenfer));
		EnfermedadLogic enfermedadLogic= new EnfermedadLogic(connexion);
		enfermedadLogic.deepLoad(empleadoenfer.getEnfermedad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoenfer.setEmpresa(empleadoenferDataAccess.getEmpresa(connexion,empleadoenfer));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(empleadoenfer.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoenfer.setEmpleado(empleadoenferDataAccess.getEmpleado(connexion,empleadoenfer));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleadoenfer.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Enfermedad.class)) {
				empleadoenfer.setEnfermedad(empleadoenferDataAccess.getEnfermedad(connexion,empleadoenfer));
				EnfermedadLogic enfermedadLogic= new EnfermedadLogic(connexion);
				enfermedadLogic.deepLoad(empleadoenfer.getEnfermedad(),isDeep,deepLoadType,clases);				
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
			empleadoenfer.setEmpresa(empleadoenferDataAccess.getEmpresa(connexion,empleadoenfer));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(empleadoenfer.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoenfer.setEmpleado(empleadoenferDataAccess.getEmpleado(connexion,empleadoenfer));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleadoenfer.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Enfermedad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoenfer.setEnfermedad(empleadoenferDataAccess.getEnfermedad(connexion,empleadoenfer));
			EnfermedadLogic enfermedadLogic= new EnfermedadLogic(connexion);
			enfermedadLogic.deepLoad(empleadoenfer.getEnfermedad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EmpleadoEnfer empleadoenfer,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpleadoEnferLogicAdditional.updateEmpleadoEnferToSave(empleadoenfer,this.arrDatoGeneral);
			
EmpleadoEnferDataAccess.save(empleadoenfer, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoenfer.getEmpresa(),connexion);

		EmpleadoDataAccess.save(empleadoenfer.getEmpleado(),connexion);

		EnfermedadDataAccess.save(empleadoenfer.getEnfermedad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoenfer.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoenfer.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Enfermedad.class)) {
				EnfermedadDataAccess.save(empleadoenfer.getEnfermedad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoenfer.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoenfer.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(empleadoenfer.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoenfer.getEmpleado(),isDeep,deepLoadType,clases);
				

		EnfermedadDataAccess.save(empleadoenfer.getEnfermedad(),connexion);
		EnfermedadLogic enfermedadLogic= new EnfermedadLogic(connexion);
		enfermedadLogic.deepLoad(empleadoenfer.getEnfermedad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoenfer.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(empleadoenfer.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoenfer.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(empleadoenfer.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Enfermedad.class)) {
				EnfermedadDataAccess.save(empleadoenfer.getEnfermedad(),connexion);
				EnfermedadLogic enfermedadLogic= new EnfermedadLogic(connexion);
				enfermedadLogic.deepSave(empleadoenfer.getEnfermedad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(EmpleadoEnfer.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empleadoenfer,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(empleadoenfer);
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
			this.deepLoad(this.empleadoenfer,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfer);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EmpleadoEnfer.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empleadoenfers!=null) {
				for(EmpleadoEnfer empleadoenfer:empleadoenfers) {
					this.deepLoad(empleadoenfer,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(empleadoenfers);
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
			if(empleadoenfers!=null) {
				for(EmpleadoEnfer empleadoenfer:empleadoenfers) {
					this.deepLoad(empleadoenfer,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(empleadoenfers);
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
			this.getNewConnexionToDeep(EmpleadoEnfer.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empleadoenfer,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EmpleadoEnfer.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empleadoenfers!=null) {
				for(EmpleadoEnfer empleadoenfer:empleadoenfers) {
					this.deepSave(empleadoenfer,isDeep,deepLoadType,clases);
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
			if(empleadoenfers!=null) {
				for(EmpleadoEnfer empleadoenfer:empleadoenfers) {
					this.deepSave(empleadoenfer,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpleadoEnfersFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoEnferConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoEnfersFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoEnferConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoEnfersFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoEnferConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoEnfersFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoEnferConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoEnfersFK_IdEnfermedadWithConnection(String sFinalQuery,Pagination pagination,Long id_enfermedad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoEnfer.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEnfermedad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEnfermedad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_enfermedad,EmpleadoEnferConstantesFunciones.IDENFERMEDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEnfermedad);

			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEnfermedad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoEnfersFK_IdEnfermedad(String sFinalQuery,Pagination pagination,Long id_enfermedad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEnfermedad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEnfermedad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_enfermedad,EmpleadoEnferConstantesFunciones.IDENFERMEDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEnfermedad);

			EmpleadoEnferLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEnfermedad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(this.empleadoenfers);
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
			if(EmpleadoEnferConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoEnferDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EmpleadoEnfer empleadoenfer,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpleadoEnferConstantesFunciones.ISCONAUDITORIA) {
				if(empleadoenfer.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoEnferDataAccess.TABLENAME, empleadoenfer.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoEnferConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoEnferLogic.registrarAuditoriaDetallesEmpleadoEnfer(connexion,empleadoenfer,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empleadoenfer.getIsDeleted()) {
					/*if(!empleadoenfer.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpleadoEnferDataAccess.TABLENAME, empleadoenfer.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpleadoEnferLogic.registrarAuditoriaDetallesEmpleadoEnfer(connexion,empleadoenfer,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoEnferDataAccess.TABLENAME, empleadoenfer.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empleadoenfer.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoEnferDataAccess.TABLENAME, empleadoenfer.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoEnferConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoEnferLogic.registrarAuditoriaDetallesEmpleadoEnfer(connexion,empleadoenfer,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpleadoEnfer(Connexion connexion,EmpleadoEnfer empleadoenfer)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empleadoenfer.getIsNew()||!empleadoenfer.getid_empresa().equals(empleadoenfer.getEmpleadoEnferOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoenfer.getEmpleadoEnferOriginal().getid_empresa()!=null)
				{
					strValorActual=empleadoenfer.getEmpleadoEnferOriginal().getid_empresa().toString();
				}
				if(empleadoenfer.getid_empresa()!=null)
				{
					strValorNuevo=empleadoenfer.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEnferConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoenfer.getIsNew()||!empleadoenfer.getid_empleado().equals(empleadoenfer.getEmpleadoEnferOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoenfer.getEmpleadoEnferOriginal().getid_empleado()!=null)
				{
					strValorActual=empleadoenfer.getEmpleadoEnferOriginal().getid_empleado().toString();
				}
				if(empleadoenfer.getid_empleado()!=null)
				{
					strValorNuevo=empleadoenfer.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEnferConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoenfer.getIsNew()||!empleadoenfer.getid_enfermedad().equals(empleadoenfer.getEmpleadoEnferOriginal().getid_enfermedad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoenfer.getEmpleadoEnferOriginal().getid_enfermedad()!=null)
				{
					strValorActual=empleadoenfer.getEmpleadoEnferOriginal().getid_enfermedad().toString();
				}
				if(empleadoenfer.getid_enfermedad()!=null)
				{
					strValorNuevo=empleadoenfer.getid_enfermedad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEnferConstantesFunciones.IDENFERMEDAD,strValorActual,strValorNuevo);
			}	
			
			if(empleadoenfer.getIsNew()||!empleadoenfer.getdescripcion().equals(empleadoenfer.getEmpleadoEnferOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoenfer.getEmpleadoEnferOriginal().getdescripcion()!=null)
				{
					strValorActual=empleadoenfer.getEmpleadoEnferOriginal().getdescripcion();
				}
				if(empleadoenfer.getdescripcion()!=null)
				{
					strValorNuevo=empleadoenfer.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoEnferConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpleadoEnferRelacionesWithConnection(EmpleadoEnfer empleadoenfer) throws Exception {

		if(!empleadoenfer.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoEnferRelacionesBase(empleadoenfer,true);
		}
	}

	public void saveEmpleadoEnferRelaciones(EmpleadoEnfer empleadoenfer)throws Exception {

		if(!empleadoenfer.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoEnferRelacionesBase(empleadoenfer,false);
		}
	}

	public void saveEmpleadoEnferRelacionesBase(EmpleadoEnfer empleadoenfer,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EmpleadoEnfer-saveRelacionesWithConnection");}
	

			this.setEmpleadoEnfer(empleadoenfer);

			if(EmpleadoEnferLogicAdditional.validarSaveRelaciones(empleadoenfer,this)) {

				EmpleadoEnferLogicAdditional.updateRelacionesToSave(empleadoenfer,this);

				if((empleadoenfer.getIsNew()||empleadoenfer.getIsChanged())&&!empleadoenfer.getIsDeleted()) {
					this.saveEmpleadoEnfer();
					this.saveEmpleadoEnferRelacionesDetalles();

				} else if(empleadoenfer.getIsDeleted()) {
					this.saveEmpleadoEnferRelacionesDetalles();
					this.saveEmpleadoEnfer();
				}

				EmpleadoEnferLogicAdditional.updateRelacionesToSaveAfter(empleadoenfer,this);

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
	
	
	private void saveEmpleadoEnferRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoEnfer(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoEnferConstantesFunciones.getClassesForeignKeysOfEmpleadoEnfer(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoEnfer(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoEnferConstantesFunciones.getClassesRelationshipsOfEmpleadoEnfer(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

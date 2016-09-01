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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.PresuAsignacionConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuAsignacionParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuAsignacionParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.PresuAsignacion;
import com.bydan.erp.contabilidad.business.logic.PresuAsignacionLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.nomina.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class PresuAsignacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PresuAsignacionLogic.class);
	
	protected PresuAsignacionDataAccess presuasignacionDataAccess; 	
	protected PresuAsignacion presuasignacion;
	protected List<PresuAsignacion> presuasignacions;
	protected Object presuasignacionObject;	
	protected List<Object> presuasignacionsObject;
	
	public static ClassValidator<PresuAsignacion> presuasignacionValidator = new ClassValidator<PresuAsignacion>(PresuAsignacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PresuAsignacionLogicAdditional presuasignacionLogicAdditional=null;
	
	public PresuAsignacionLogicAdditional getPresuAsignacionLogicAdditional() {
		return this.presuasignacionLogicAdditional;
	}
	
	public void setPresuAsignacionLogicAdditional(PresuAsignacionLogicAdditional presuasignacionLogicAdditional) {
		try {
			this.presuasignacionLogicAdditional=presuasignacionLogicAdditional;
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
	
	
	
	
	public  PresuAsignacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.presuasignacionDataAccess = new PresuAsignacionDataAccess();
			
			this.presuasignacions= new ArrayList<PresuAsignacion>();
			this.presuasignacion= new PresuAsignacion();
			
			this.presuasignacionObject=new Object();
			this.presuasignacionsObject=new ArrayList<Object>();
				
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
			
			this.presuasignacionDataAccess.setConnexionType(this.connexionType);
			this.presuasignacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PresuAsignacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.presuasignacionDataAccess = new PresuAsignacionDataAccess();
			this.presuasignacions= new ArrayList<PresuAsignacion>();
			this.presuasignacion= new PresuAsignacion();
			this.presuasignacionObject=new Object();
			this.presuasignacionsObject=new ArrayList<Object>();
			
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
			
			this.presuasignacionDataAccess.setConnexionType(this.connexionType);
			this.presuasignacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PresuAsignacion getPresuAsignacion() throws Exception {	
		PresuAsignacionLogicAdditional.checkPresuAsignacionToGet(presuasignacion,this.datosCliente,this.arrDatoGeneral);
		PresuAsignacionLogicAdditional.updatePresuAsignacionToGet(presuasignacion,this.arrDatoGeneral);
		
		return presuasignacion;
	}
		
	public void setPresuAsignacion(PresuAsignacion newPresuAsignacion) {
		this.presuasignacion = newPresuAsignacion;
	}
	
	public PresuAsignacionDataAccess getPresuAsignacionDataAccess() {
		return presuasignacionDataAccess;
	}
	
	public void setPresuAsignacionDataAccess(PresuAsignacionDataAccess newpresuasignacionDataAccess) {
		this.presuasignacionDataAccess = newpresuasignacionDataAccess;
	}
	
	public List<PresuAsignacion> getPresuAsignacions() throws Exception {		
		this.quitarPresuAsignacionsNulos();
		
		PresuAsignacionLogicAdditional.checkPresuAsignacionToGets(presuasignacions,this.datosCliente,this.arrDatoGeneral);
		
		for (PresuAsignacion presuasignacionLocal: presuasignacions ) {
			PresuAsignacionLogicAdditional.updatePresuAsignacionToGet(presuasignacionLocal,this.arrDatoGeneral);
		}
		
		return presuasignacions;
	}
	
	public void setPresuAsignacions(List<PresuAsignacion> newPresuAsignacions) {
		this.presuasignacions = newPresuAsignacions;
	}
	
	public Object getPresuAsignacionObject() {	
		this.presuasignacionObject=this.presuasignacionDataAccess.getEntityObject();
		return this.presuasignacionObject;
	}
		
	public void setPresuAsignacionObject(Object newPresuAsignacionObject) {
		this.presuasignacionObject = newPresuAsignacionObject;
	}
	
	public List<Object> getPresuAsignacionsObject() {		
		this.presuasignacionsObject=this.presuasignacionDataAccess.getEntitiesObject();
		return this.presuasignacionsObject;
	}
		
	public void setPresuAsignacionsObject(List<Object> newPresuAsignacionsObject) {
		this.presuasignacionsObject = newPresuAsignacionsObject;
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
		
		if(this.presuasignacionDataAccess!=null) {
			this.presuasignacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			presuasignacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			presuasignacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		presuasignacion = new  PresuAsignacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presuasignacion=presuasignacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presuasignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacion);
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
		presuasignacion = new  PresuAsignacion();
		  		  
        try {
			
			presuasignacion=presuasignacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presuasignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		presuasignacion = new  PresuAsignacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presuasignacion=presuasignacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presuasignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacion);
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
		presuasignacion = new  PresuAsignacion();
		  		  
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
		presuasignacion = new  PresuAsignacion();
		  		  
        try {
			
			presuasignacion=presuasignacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presuasignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		presuasignacion = new  PresuAsignacion();
		  		  
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
		presuasignacion = new  PresuAsignacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =presuasignacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presuasignacion = new  PresuAsignacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=presuasignacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presuasignacion = new  PresuAsignacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =presuasignacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presuasignacion = new  PresuAsignacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=presuasignacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presuasignacion = new  PresuAsignacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =presuasignacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presuasignacion = new  PresuAsignacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=presuasignacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presuasignacions = new  ArrayList<PresuAsignacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuasignacions=presuasignacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuAsignacion(presuasignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
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
		presuasignacions = new  ArrayList<PresuAsignacion>();
		  		  
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
		presuasignacions = new  ArrayList<PresuAsignacion>();
		  		  
        try {			
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuasignacions=presuasignacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPresuAsignacion(presuasignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		presuasignacions = new  ArrayList<PresuAsignacion>();
		  		  
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
		presuasignacions = new  ArrayList<PresuAsignacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuasignacions=presuasignacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuAsignacion(presuasignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
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
		presuasignacions = new  ArrayList<PresuAsignacion>();
		  		  
        try {
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuasignacions=presuasignacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuAsignacion(presuasignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
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
		presuasignacions = new  ArrayList<PresuAsignacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuasignacions=presuasignacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuAsignacion(presuasignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
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
		presuasignacions = new  ArrayList<PresuAsignacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuasignacions=presuasignacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuAsignacion(presuasignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		presuasignacion = new  PresuAsignacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuasignacion=presuasignacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuAsignacion(presuasignacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacion);
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
		presuasignacion = new  PresuAsignacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuasignacion=presuasignacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuAsignacion(presuasignacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presuasignacions = new  ArrayList<PresuAsignacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuasignacions=presuasignacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuAsignacion(presuasignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
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
		presuasignacions = new  ArrayList<PresuAsignacion>();
		  		  
        try {
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuasignacions=presuasignacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuAsignacion(presuasignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPresuAsignacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		presuasignacions = new  ArrayList<PresuAsignacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getTodosPresuAsignacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuasignacions=presuasignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresuAsignacion(presuasignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
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
	
	public  void  getTodosPresuAsignacions(String sFinalQuery,Pagination pagination)throws Exception {
		presuasignacions = new  ArrayList<PresuAsignacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuasignacions=presuasignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresuAsignacion(presuasignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPresuAsignacion(PresuAsignacion presuasignacion) throws Exception {
		Boolean estaValidado=false;
		
		if(presuasignacion.getIsNew() || presuasignacion.getIsChanged()) { 
			this.invalidValues = presuasignacionValidator.getInvalidValues(presuasignacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(presuasignacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPresuAsignacion(List<PresuAsignacion> PresuAsignacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PresuAsignacion presuasignacionLocal:presuasignacions) {				
			estaValidadoObjeto=this.validarGuardarPresuAsignacion(presuasignacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPresuAsignacion(List<PresuAsignacion> PresuAsignacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresuAsignacion(presuasignacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPresuAsignacion(PresuAsignacion PresuAsignacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresuAsignacion(presuasignacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PresuAsignacion presuasignacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+presuasignacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PresuAsignacionConstantesFunciones.getPresuAsignacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"presuasignacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PresuAsignacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PresuAsignacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePresuAsignacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-savePresuAsignacionWithConnection");connexion.begin();			
			
			PresuAsignacionLogicAdditional.checkPresuAsignacionToSave(this.presuasignacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresuAsignacionLogicAdditional.updatePresuAsignacionToSave(this.presuasignacion,this.arrDatoGeneral);
			
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presuasignacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPresuAsignacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresuAsignacion(this.presuasignacion)) {
				PresuAsignacionDataAccess.save(this.presuasignacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.presuasignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresuAsignacionLogicAdditional.checkPresuAsignacionToSaveAfter(this.presuasignacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresuAsignacion();
			
			connexion.commit();			
			
			if(this.presuasignacion.getIsDeleted()) {
				this.presuasignacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePresuAsignacion()throws Exception {	
		try {	
			
			PresuAsignacionLogicAdditional.checkPresuAsignacionToSave(this.presuasignacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresuAsignacionLogicAdditional.updatePresuAsignacionToSave(this.presuasignacion,this.arrDatoGeneral);
			
			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presuasignacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresuAsignacion(this.presuasignacion)) {			
				PresuAsignacionDataAccess.save(this.presuasignacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.presuasignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresuAsignacionLogicAdditional.checkPresuAsignacionToSaveAfter(this.presuasignacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.presuasignacion.getIsDeleted()) {
				this.presuasignacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePresuAsignacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-savePresuAsignacionsWithConnection");connexion.begin();			
			
			PresuAsignacionLogicAdditional.checkPresuAsignacionToSaves(presuasignacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPresuAsignacions();
			
			Boolean validadoTodosPresuAsignacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresuAsignacion presuasignacionLocal:presuasignacions) {		
				if(presuasignacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresuAsignacionLogicAdditional.updatePresuAsignacionToSave(presuasignacionLocal,this.arrDatoGeneral);
	        	
				PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presuasignacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresuAsignacion(presuasignacionLocal)) {
					PresuAsignacionDataAccess.save(presuasignacionLocal, connexion);				
				} else {
					validadoTodosPresuAsignacion=false;
				}
			}
			
			if(!validadoTodosPresuAsignacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresuAsignacionLogicAdditional.checkPresuAsignacionToSavesAfter(presuasignacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresuAsignacions();
			
			connexion.commit();		
			
			this.quitarPresuAsignacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePresuAsignacions()throws Exception {				
		 try {	
			PresuAsignacionLogicAdditional.checkPresuAsignacionToSaves(presuasignacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPresuAsignacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresuAsignacion presuasignacionLocal:presuasignacions) {				
				if(presuasignacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresuAsignacionLogicAdditional.updatePresuAsignacionToSave(presuasignacionLocal,this.arrDatoGeneral);
	        	
				PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presuasignacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresuAsignacion(presuasignacionLocal)) {				
					PresuAsignacionDataAccess.save(presuasignacionLocal, connexion);				
				} else {
					validadoTodosPresuAsignacion=false;
				}
			}
			
			if(!validadoTodosPresuAsignacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresuAsignacionLogicAdditional.checkPresuAsignacionToSavesAfter(presuasignacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPresuAsignacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresuAsignacionParameterReturnGeneral procesarAccionPresuAsignacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresuAsignacion> presuasignacions,PresuAsignacionParameterReturnGeneral presuasignacionParameterGeneral)throws Exception {
		 try {	
			PresuAsignacionParameterReturnGeneral presuasignacionReturnGeneral=new PresuAsignacionParameterReturnGeneral();
	
			PresuAsignacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presuasignacions,presuasignacionParameterGeneral,presuasignacionReturnGeneral);
			
			return presuasignacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresuAsignacionParameterReturnGeneral procesarAccionPresuAsignacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresuAsignacion> presuasignacions,PresuAsignacionParameterReturnGeneral presuasignacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-procesarAccionPresuAsignacionsWithConnection");connexion.begin();			
			
			PresuAsignacionParameterReturnGeneral presuasignacionReturnGeneral=new PresuAsignacionParameterReturnGeneral();
	
			PresuAsignacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presuasignacions,presuasignacionParameterGeneral,presuasignacionReturnGeneral);
			
			this.connexion.commit();
			
			return presuasignacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresuAsignacionParameterReturnGeneral procesarEventosPresuAsignacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresuAsignacion> presuasignacions,PresuAsignacion presuasignacion,PresuAsignacionParameterReturnGeneral presuasignacionParameterGeneral,Boolean isEsNuevoPresuAsignacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			PresuAsignacionParameterReturnGeneral presuasignacionReturnGeneral=new PresuAsignacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presuasignacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresuAsignacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presuasignacions,presuasignacion,presuasignacionParameterGeneral,presuasignacionReturnGeneral,isEsNuevoPresuAsignacion,clases);
			
			return presuasignacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PresuAsignacionParameterReturnGeneral procesarEventosPresuAsignacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresuAsignacion> presuasignacions,PresuAsignacion presuasignacion,PresuAsignacionParameterReturnGeneral presuasignacionParameterGeneral,Boolean isEsNuevoPresuAsignacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-procesarEventosPresuAsignacionsWithConnection");connexion.begin();			
			
			PresuAsignacionParameterReturnGeneral presuasignacionReturnGeneral=new PresuAsignacionParameterReturnGeneral();
	
			presuasignacionReturnGeneral.setPresuAsignacion(presuasignacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presuasignacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresuAsignacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presuasignacions,presuasignacion,presuasignacionParameterGeneral,presuasignacionReturnGeneral,isEsNuevoPresuAsignacion,clases);
			
			this.connexion.commit();
			
			return presuasignacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresuAsignacionParameterReturnGeneral procesarImportacionPresuAsignacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PresuAsignacionParameterReturnGeneral presuasignacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-procesarImportacionPresuAsignacionsWithConnection");connexion.begin();			
			
			PresuAsignacionParameterReturnGeneral presuasignacionReturnGeneral=new PresuAsignacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.presuasignacions=new ArrayList<PresuAsignacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.presuasignacion=new PresuAsignacion();
				
				
				if(conColumnasBase) {this.presuasignacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.presuasignacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.presuasignacion.setcodigo_secuencial(Long.parseLong(arrColumnas[iColumn++]));
				this.presuasignacion.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.presuasignacion.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.presuasignacion.setdescripcion(arrColumnas[iColumn++]);
				
				this.presuasignacions.add(this.presuasignacion);
			}
			
			this.savePresuAsignacions();
			
			this.connexion.commit();
			
			presuasignacionReturnGeneral.setConRetornoEstaProcesado(true);
			presuasignacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return presuasignacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPresuAsignacionsEliminados() throws Exception {				
		
		List<PresuAsignacion> presuasignacionsAux= new ArrayList<PresuAsignacion>();
		
		for(PresuAsignacion presuasignacion:presuasignacions) {
			if(!presuasignacion.getIsDeleted()) {
				presuasignacionsAux.add(presuasignacion);
			}
		}
		
		presuasignacions=presuasignacionsAux;
	}
	
	public void quitarPresuAsignacionsNulos() throws Exception {				
		
		List<PresuAsignacion> presuasignacionsAux= new ArrayList<PresuAsignacion>();
		
		for(PresuAsignacion presuasignacion : this.presuasignacions) {
			if(presuasignacion==null) {
				presuasignacionsAux.add(presuasignacion);
			}
		}
		
		//this.presuasignacions=presuasignacionsAux;
		
		this.presuasignacions.removeAll(presuasignacionsAux);
	}
	
	public void getSetVersionRowPresuAsignacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(presuasignacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((presuasignacion.getIsDeleted() || (presuasignacion.getIsChanged()&&!presuasignacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=presuasignacionDataAccess.getSetVersionRowPresuAsignacion(connexion,presuasignacion.getId());
				
				if(!presuasignacion.getVersionRow().equals(timestamp)) {	
					presuasignacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				presuasignacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPresuAsignacion()throws Exception {	
		
		if(presuasignacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((presuasignacion.getIsDeleted() || (presuasignacion.getIsChanged()&&!presuasignacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=presuasignacionDataAccess.getSetVersionRowPresuAsignacion(connexion,presuasignacion.getId());
			
			try {							
				if(!presuasignacion.getVersionRow().equals(timestamp)) {	
					presuasignacion.setVersionRow(timestamp);
				}
				
				presuasignacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPresuAsignacionsWithConnection()throws Exception {	
		if(presuasignacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PresuAsignacion presuasignacionAux:presuasignacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(presuasignacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presuasignacionAux.getIsDeleted() || (presuasignacionAux.getIsChanged()&&!presuasignacionAux.getIsNew())) {
						
						timestamp=presuasignacionDataAccess.getSetVersionRowPresuAsignacion(connexion,presuasignacionAux.getId());
						
						if(!presuasignacion.getVersionRow().equals(timestamp)) {	
							presuasignacionAux.setVersionRow(timestamp);
						}
								
						presuasignacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPresuAsignacions()throws Exception {	
		if(presuasignacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PresuAsignacion presuasignacionAux:presuasignacions) {
					if(presuasignacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presuasignacionAux.getIsDeleted() || (presuasignacionAux.getIsChanged()&&!presuasignacionAux.getIsNew())) {
						
						timestamp=presuasignacionDataAccess.getSetVersionRowPresuAsignacion(connexion,presuasignacionAux.getId());
						
						if(!presuasignacionAux.getVersionRow().equals(timestamp)) {	
							presuasignacionAux.setVersionRow(timestamp);
						}
						
													
						presuasignacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PresuAsignacionParameterReturnGeneral cargarCombosLoteForeignKeyPresuAsignacionWithConnection(String finalQueryGlobalPresuProyectoCuenta,String finalQueryGlobalEmpleado,String finalQueryGlobalPresuEstado) throws Exception {
		PresuAsignacionParameterReturnGeneral  presuasignacionReturnGeneral =new PresuAsignacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-cargarCombosLoteForeignKeyPresuAsignacionWithConnection");connexion.begin();
			
			presuasignacionReturnGeneral =new PresuAsignacionParameterReturnGeneral();
			
			

			List<PresuProyectoCuenta> presuproyectocuentasForeignKey=new ArrayList<PresuProyectoCuenta>();
			PresuProyectoCuentaLogic presuproyectocuentaLogic=new PresuProyectoCuentaLogic();
			presuproyectocuentaLogic.setConnexion(this.connexion);
			presuproyectocuentaLogic.getPresuProyectoCuentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuProyectoCuenta.equals("NONE")) {
				presuproyectocuentaLogic.getTodosPresuProyectoCuentas(finalQueryGlobalPresuProyectoCuenta,new Pagination());
				presuproyectocuentasForeignKey=presuproyectocuentaLogic.getPresuProyectoCuentas();
			}

			presuasignacionReturnGeneral.setpresuproyectocuentasForeignKey(presuproyectocuentasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			presuasignacionReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<PresuEstado> presuestadosForeignKey=new ArrayList<PresuEstado>();
			PresuEstadoLogic presuestadoLogic=new PresuEstadoLogic();
			presuestadoLogic.setConnexion(this.connexion);
			presuestadoLogic.getPresuEstadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuEstado.equals("NONE")) {
				presuestadoLogic.getTodosPresuEstados(finalQueryGlobalPresuEstado,new Pagination());
				presuestadosForeignKey=presuestadoLogic.getPresuEstados();
			}

			presuasignacionReturnGeneral.setpresuestadosForeignKey(presuestadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return presuasignacionReturnGeneral;
	}
	
	public PresuAsignacionParameterReturnGeneral cargarCombosLoteForeignKeyPresuAsignacion(String finalQueryGlobalPresuProyectoCuenta,String finalQueryGlobalEmpleado,String finalQueryGlobalPresuEstado) throws Exception {
		PresuAsignacionParameterReturnGeneral  presuasignacionReturnGeneral =new PresuAsignacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			presuasignacionReturnGeneral =new PresuAsignacionParameterReturnGeneral();
			
			

			List<PresuProyectoCuenta> presuproyectocuentasForeignKey=new ArrayList<PresuProyectoCuenta>();
			PresuProyectoCuentaLogic presuproyectocuentaLogic=new PresuProyectoCuentaLogic();
			presuproyectocuentaLogic.setConnexion(this.connexion);
			presuproyectocuentaLogic.getPresuProyectoCuentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuProyectoCuenta.equals("NONE")) {
				presuproyectocuentaLogic.getTodosPresuProyectoCuentas(finalQueryGlobalPresuProyectoCuenta,new Pagination());
				presuproyectocuentasForeignKey=presuproyectocuentaLogic.getPresuProyectoCuentas();
			}

			presuasignacionReturnGeneral.setpresuproyectocuentasForeignKey(presuproyectocuentasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			presuasignacionReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<PresuEstado> presuestadosForeignKey=new ArrayList<PresuEstado>();
			PresuEstadoLogic presuestadoLogic=new PresuEstadoLogic();
			presuestadoLogic.setConnexion(this.connexion);
			presuestadoLogic.getPresuEstadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuEstado.equals("NONE")) {
				presuestadoLogic.getTodosPresuEstados(finalQueryGlobalPresuEstado,new Pagination());
				presuestadosForeignKey=presuestadoLogic.getPresuEstados();
			}

			presuasignacionReturnGeneral.setpresuestadosForeignKey(presuestadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return presuasignacionReturnGeneral;
	}
	
	
	public void deepLoad(PresuAsignacion presuasignacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PresuAsignacionLogicAdditional.updatePresuAsignacionToGet(presuasignacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presuasignacion.setPresuProyectoCuenta(presuasignacionDataAccess.getPresuProyectoCuenta(connexion,presuasignacion));
		presuasignacion.setEmpleado(presuasignacionDataAccess.getEmpleado(connexion,presuasignacion));
		presuasignacion.setPresuEstado(presuasignacionDataAccess.getPresuEstado(connexion,presuasignacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyectoCuenta.class)) {
				presuasignacion.setPresuProyectoCuenta(presuasignacionDataAccess.getPresuProyectoCuenta(connexion,presuasignacion));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				presuasignacion.setEmpleado(presuasignacionDataAccess.getEmpleado(connexion,presuasignacion));
				continue;
			}

			if(clas.clas.equals(PresuEstado.class)) {
				presuasignacion.setPresuEstado(presuasignacionDataAccess.getPresuEstado(connexion,presuasignacion));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyectoCuenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuasignacion.setPresuProyectoCuenta(presuasignacionDataAccess.getPresuProyectoCuenta(connexion,presuasignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuasignacion.setEmpleado(presuasignacionDataAccess.getEmpleado(connexion,presuasignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuEstado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuasignacion.setPresuEstado(presuasignacionDataAccess.getPresuEstado(connexion,presuasignacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presuasignacion.setPresuProyectoCuenta(presuasignacionDataAccess.getPresuProyectoCuenta(connexion,presuasignacion));
		PresuProyectoCuentaLogic presuproyectocuentaLogic= new PresuProyectoCuentaLogic(connexion);
		presuproyectocuentaLogic.deepLoad(presuasignacion.getPresuProyectoCuenta(),isDeep,deepLoadType,clases);
				
		presuasignacion.setEmpleado(presuasignacionDataAccess.getEmpleado(connexion,presuasignacion));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(presuasignacion.getEmpleado(),isDeep,deepLoadType,clases);
				
		presuasignacion.setPresuEstado(presuasignacionDataAccess.getPresuEstado(connexion,presuasignacion));
		PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
		presuestadoLogic.deepLoad(presuasignacion.getPresuEstado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyectoCuenta.class)) {
				presuasignacion.setPresuProyectoCuenta(presuasignacionDataAccess.getPresuProyectoCuenta(connexion,presuasignacion));
				PresuProyectoCuentaLogic presuproyectocuentaLogic= new PresuProyectoCuentaLogic(connexion);
				presuproyectocuentaLogic.deepLoad(presuasignacion.getPresuProyectoCuenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				presuasignacion.setEmpleado(presuasignacionDataAccess.getEmpleado(connexion,presuasignacion));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(presuasignacion.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresuEstado.class)) {
				presuasignacion.setPresuEstado(presuasignacionDataAccess.getPresuEstado(connexion,presuasignacion));
				PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
				presuestadoLogic.deepLoad(presuasignacion.getPresuEstado(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyectoCuenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuasignacion.setPresuProyectoCuenta(presuasignacionDataAccess.getPresuProyectoCuenta(connexion,presuasignacion));
			PresuProyectoCuentaLogic presuproyectocuentaLogic= new PresuProyectoCuentaLogic(connexion);
			presuproyectocuentaLogic.deepLoad(presuasignacion.getPresuProyectoCuenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuasignacion.setEmpleado(presuasignacionDataAccess.getEmpleado(connexion,presuasignacion));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(presuasignacion.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PresuEstado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuasignacion.setPresuEstado(presuasignacionDataAccess.getPresuEstado(connexion,presuasignacion));
			PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
			presuestadoLogic.deepLoad(presuasignacion.getPresuEstado(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PresuAsignacion presuasignacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PresuAsignacionLogicAdditional.updatePresuAsignacionToSave(presuasignacion,this.arrDatoGeneral);
			
PresuAsignacionDataAccess.save(presuasignacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PresuProyectoCuentaDataAccess.save(presuasignacion.getPresuProyectoCuenta(),connexion);

		EmpleadoDataAccess.save(presuasignacion.getEmpleado(),connexion);

		PresuEstadoDataAccess.save(presuasignacion.getPresuEstado(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyectoCuenta.class)) {
				PresuProyectoCuentaDataAccess.save(presuasignacion.getPresuProyectoCuenta(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(presuasignacion.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(PresuEstado.class)) {
				PresuEstadoDataAccess.save(presuasignacion.getPresuEstado(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PresuProyectoCuentaDataAccess.save(presuasignacion.getPresuProyectoCuenta(),connexion);
		PresuProyectoCuentaLogic presuproyectocuentaLogic= new PresuProyectoCuentaLogic(connexion);
		presuproyectocuentaLogic.deepLoad(presuasignacion.getPresuProyectoCuenta(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(presuasignacion.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(presuasignacion.getEmpleado(),isDeep,deepLoadType,clases);
				

		PresuEstadoDataAccess.save(presuasignacion.getPresuEstado(),connexion);
		PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
		presuestadoLogic.deepLoad(presuasignacion.getPresuEstado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyectoCuenta.class)) {
				PresuProyectoCuentaDataAccess.save(presuasignacion.getPresuProyectoCuenta(),connexion);
				PresuProyectoCuentaLogic presuproyectocuentaLogic= new PresuProyectoCuentaLogic(connexion);
				presuproyectocuentaLogic.deepSave(presuasignacion.getPresuProyectoCuenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(presuasignacion.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(presuasignacion.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresuEstado.class)) {
				PresuEstadoDataAccess.save(presuasignacion.getPresuEstado(),connexion);
				PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
				presuestadoLogic.deepSave(presuasignacion.getPresuEstado(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PresuAsignacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(presuasignacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(presuasignacion);
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
			this.deepLoad(this.presuasignacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PresuAsignacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(presuasignacions!=null) {
				for(PresuAsignacion presuasignacion:presuasignacions) {
					this.deepLoad(presuasignacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(presuasignacions);
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
			if(presuasignacions!=null) {
				for(PresuAsignacion presuasignacion:presuasignacions) {
					this.deepLoad(presuasignacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(presuasignacions);
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
			this.getNewConnexionToDeep(PresuAsignacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(presuasignacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PresuAsignacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(presuasignacions!=null) {
				for(PresuAsignacion presuasignacion:presuasignacions) {
					this.deepSave(presuasignacion,isDeep,deepLoadType,clases);
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
			if(presuasignacions!=null) {
				for(PresuAsignacion presuasignacion:presuasignacions) {
					this.deepSave(presuasignacion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPresuAsignacionsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PresuAsignacionConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuasignacions=presuasignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuAsignacionsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PresuAsignacionConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuasignacions=presuasignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuAsignacionsFK_IdPresuEstadoWithConnection(String sFinalQuery,Pagination pagination,Long id_presu_estado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuEstado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuEstado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_estado,PresuAsignacionConstantesFunciones.IDPRESUESTADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuEstado);

			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuEstado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuasignacions=presuasignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuAsignacionsFK_IdPresuEstado(String sFinalQuery,Pagination pagination,Long id_presu_estado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuEstado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuEstado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_estado,PresuAsignacionConstantesFunciones.IDPRESUESTADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuEstado);

			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuEstado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuasignacions=presuasignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuAsignacionsFK_IdPresuProyectoCuentaWithConnection(String sFinalQuery,Pagination pagination,Long id_presu_proyecto_cuenta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuAsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuProyectoCuenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuProyectoCuenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_proyecto_cuenta,PresuAsignacionConstantesFunciones.IDPRESUPROYECTOCUENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuProyectoCuenta);

			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuProyectoCuenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuasignacions=presuasignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuAsignacionsFK_IdPresuProyectoCuenta(String sFinalQuery,Pagination pagination,Long id_presu_proyecto_cuenta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuProyectoCuenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuProyectoCuenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_proyecto_cuenta,PresuAsignacionConstantesFunciones.IDPRESUPROYECTOCUENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuProyectoCuenta);

			PresuAsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuProyectoCuenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuasignacions=presuasignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(this.presuasignacions);
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
			if(PresuAsignacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuAsignacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PresuAsignacion presuasignacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PresuAsignacionConstantesFunciones.ISCONAUDITORIA) {
				if(presuasignacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuAsignacionDataAccess.TABLENAME, presuasignacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresuAsignacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresuAsignacionLogic.registrarAuditoriaDetallesPresuAsignacion(connexion,presuasignacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(presuasignacion.getIsDeleted()) {
					/*if(!presuasignacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PresuAsignacionDataAccess.TABLENAME, presuasignacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PresuAsignacionLogic.registrarAuditoriaDetallesPresuAsignacion(connexion,presuasignacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuAsignacionDataAccess.TABLENAME, presuasignacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(presuasignacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuAsignacionDataAccess.TABLENAME, presuasignacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresuAsignacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresuAsignacionLogic.registrarAuditoriaDetallesPresuAsignacion(connexion,presuasignacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPresuAsignacion(Connexion connexion,PresuAsignacion presuasignacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(presuasignacion.getIsNew()||!presuasignacion.getid_presu_proyecto_cuenta().equals(presuasignacion.getPresuAsignacionOriginal().getid_presu_proyecto_cuenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuasignacion.getPresuAsignacionOriginal().getid_presu_proyecto_cuenta()!=null)
				{
					strValorActual=presuasignacion.getPresuAsignacionOriginal().getid_presu_proyecto_cuenta().toString();
				}
				if(presuasignacion.getid_presu_proyecto_cuenta()!=null)
				{
					strValorNuevo=presuasignacion.getid_presu_proyecto_cuenta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuAsignacionConstantesFunciones.IDPRESUPROYECTOCUENTA,strValorActual,strValorNuevo);
			}	
			
			if(presuasignacion.getIsNew()||!presuasignacion.getid_empleado().equals(presuasignacion.getPresuAsignacionOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuasignacion.getPresuAsignacionOriginal().getid_empleado()!=null)
				{
					strValorActual=presuasignacion.getPresuAsignacionOriginal().getid_empleado().toString();
				}
				if(presuasignacion.getid_empleado()!=null)
				{
					strValorNuevo=presuasignacion.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuAsignacionConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(presuasignacion.getIsNew()||!presuasignacion.getcodigo_secuencial().equals(presuasignacion.getPresuAsignacionOriginal().getcodigo_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuasignacion.getPresuAsignacionOriginal().getcodigo_secuencial()!=null)
				{
					strValorActual=presuasignacion.getPresuAsignacionOriginal().getcodigo_secuencial().toString();
				}
				if(presuasignacion.getcodigo_secuencial()!=null)
				{
					strValorNuevo=presuasignacion.getcodigo_secuencial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuAsignacionConstantesFunciones.CODIGOSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(presuasignacion.getIsNew()||!presuasignacion.getvalor().equals(presuasignacion.getPresuAsignacionOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuasignacion.getPresuAsignacionOriginal().getvalor()!=null)
				{
					strValorActual=presuasignacion.getPresuAsignacionOriginal().getvalor().toString();
				}
				if(presuasignacion.getvalor()!=null)
				{
					strValorNuevo=presuasignacion.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuAsignacionConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(presuasignacion.getIsNew()||!presuasignacion.getfecha().equals(presuasignacion.getPresuAsignacionOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuasignacion.getPresuAsignacionOriginal().getfecha()!=null)
				{
					strValorActual=presuasignacion.getPresuAsignacionOriginal().getfecha().toString();
				}
				if(presuasignacion.getfecha()!=null)
				{
					strValorNuevo=presuasignacion.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuAsignacionConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(presuasignacion.getIsNew()||!presuasignacion.getid_presu_estado().equals(presuasignacion.getPresuAsignacionOriginal().getid_presu_estado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuasignacion.getPresuAsignacionOriginal().getid_presu_estado()!=null)
				{
					strValorActual=presuasignacion.getPresuAsignacionOriginal().getid_presu_estado().toString();
				}
				if(presuasignacion.getid_presu_estado()!=null)
				{
					strValorNuevo=presuasignacion.getid_presu_estado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuAsignacionConstantesFunciones.IDPRESUESTADO,strValorActual,strValorNuevo);
			}	
			
			if(presuasignacion.getIsNew()||!presuasignacion.getdescripcion().equals(presuasignacion.getPresuAsignacionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuasignacion.getPresuAsignacionOriginal().getdescripcion()!=null)
				{
					strValorActual=presuasignacion.getPresuAsignacionOriginal().getdescripcion();
				}
				if(presuasignacion.getdescripcion()!=null)
				{
					strValorNuevo=presuasignacion.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuAsignacionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePresuAsignacionRelacionesWithConnection(PresuAsignacion presuasignacion) throws Exception {

		if(!presuasignacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresuAsignacionRelacionesBase(presuasignacion,true);
		}
	}

	public void savePresuAsignacionRelaciones(PresuAsignacion presuasignacion)throws Exception {

		if(!presuasignacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresuAsignacionRelacionesBase(presuasignacion,false);
		}
	}

	public void savePresuAsignacionRelacionesBase(PresuAsignacion presuasignacion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PresuAsignacion-saveRelacionesWithConnection");}
	

			this.setPresuAsignacion(presuasignacion);

			if(PresuAsignacionLogicAdditional.validarSaveRelaciones(presuasignacion,this)) {

				PresuAsignacionLogicAdditional.updateRelacionesToSave(presuasignacion,this);

				if((presuasignacion.getIsNew()||presuasignacion.getIsChanged())&&!presuasignacion.getIsDeleted()) {
					this.savePresuAsignacion();
					this.savePresuAsignacionRelacionesDetalles();

				} else if(presuasignacion.getIsDeleted()) {
					this.savePresuAsignacionRelacionesDetalles();
					this.savePresuAsignacion();
				}

				PresuAsignacionLogicAdditional.updateRelacionesToSaveAfter(presuasignacion,this);

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
	
	
	private void savePresuAsignacionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPresuAsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresuAsignacionConstantesFunciones.getClassesForeignKeysOfPresuAsignacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuAsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresuAsignacionConstantesFunciones.getClassesRelationshipsOfPresuAsignacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

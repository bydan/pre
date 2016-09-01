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
import com.bydan.erp.nomina.util.PlaniVacacionConstantesFunciones;
import com.bydan.erp.nomina.util.PlaniVacacionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.PlaniVacacionParameterGeneral;
import com.bydan.erp.nomina.business.entity.PlaniVacacion;
import com.bydan.erp.nomina.business.logic.PlaniVacacionLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class PlaniVacacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PlaniVacacionLogic.class);
	
	protected PlaniVacacionDataAccess planivacacionDataAccess; 	
	protected PlaniVacacion planivacacion;
	protected List<PlaniVacacion> planivacacions;
	protected Object planivacacionObject;	
	protected List<Object> planivacacionsObject;
	
	public static ClassValidator<PlaniVacacion> planivacacionValidator = new ClassValidator<PlaniVacacion>(PlaniVacacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PlaniVacacionLogicAdditional planivacacionLogicAdditional=null;
	
	public PlaniVacacionLogicAdditional getPlaniVacacionLogicAdditional() {
		return this.planivacacionLogicAdditional;
	}
	
	public void setPlaniVacacionLogicAdditional(PlaniVacacionLogicAdditional planivacacionLogicAdditional) {
		try {
			this.planivacacionLogicAdditional=planivacacionLogicAdditional;
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
	
	
	
	
	public  PlaniVacacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.planivacacionDataAccess = new PlaniVacacionDataAccess();
			
			this.planivacacions= new ArrayList<PlaniVacacion>();
			this.planivacacion= new PlaniVacacion();
			
			this.planivacacionObject=new Object();
			this.planivacacionsObject=new ArrayList<Object>();
				
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
			
			this.planivacacionDataAccess.setConnexionType(this.connexionType);
			this.planivacacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PlaniVacacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.planivacacionDataAccess = new PlaniVacacionDataAccess();
			this.planivacacions= new ArrayList<PlaniVacacion>();
			this.planivacacion= new PlaniVacacion();
			this.planivacacionObject=new Object();
			this.planivacacionsObject=new ArrayList<Object>();
			
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
			
			this.planivacacionDataAccess.setConnexionType(this.connexionType);
			this.planivacacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PlaniVacacion getPlaniVacacion() throws Exception {	
		PlaniVacacionLogicAdditional.checkPlaniVacacionToGet(planivacacion,this.datosCliente,this.arrDatoGeneral);
		PlaniVacacionLogicAdditional.updatePlaniVacacionToGet(planivacacion,this.arrDatoGeneral);
		
		return planivacacion;
	}
		
	public void setPlaniVacacion(PlaniVacacion newPlaniVacacion) {
		this.planivacacion = newPlaniVacacion;
	}
	
	public PlaniVacacionDataAccess getPlaniVacacionDataAccess() {
		return planivacacionDataAccess;
	}
	
	public void setPlaniVacacionDataAccess(PlaniVacacionDataAccess newplanivacacionDataAccess) {
		this.planivacacionDataAccess = newplanivacacionDataAccess;
	}
	
	public List<PlaniVacacion> getPlaniVacacions() throws Exception {		
		this.quitarPlaniVacacionsNulos();
		
		PlaniVacacionLogicAdditional.checkPlaniVacacionToGets(planivacacions,this.datosCliente,this.arrDatoGeneral);
		
		for (PlaniVacacion planivacacionLocal: planivacacions ) {
			PlaniVacacionLogicAdditional.updatePlaniVacacionToGet(planivacacionLocal,this.arrDatoGeneral);
		}
		
		return planivacacions;
	}
	
	public void setPlaniVacacions(List<PlaniVacacion> newPlaniVacacions) {
		this.planivacacions = newPlaniVacacions;
	}
	
	public Object getPlaniVacacionObject() {	
		this.planivacacionObject=this.planivacacionDataAccess.getEntityObject();
		return this.planivacacionObject;
	}
		
	public void setPlaniVacacionObject(Object newPlaniVacacionObject) {
		this.planivacacionObject = newPlaniVacacionObject;
	}
	
	public List<Object> getPlaniVacacionsObject() {		
		this.planivacacionsObject=this.planivacacionDataAccess.getEntitiesObject();
		return this.planivacacionsObject;
	}
		
	public void setPlaniVacacionsObject(List<Object> newPlaniVacacionsObject) {
		this.planivacacionsObject = newPlaniVacacionsObject;
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
		
		if(this.planivacacionDataAccess!=null) {
			this.planivacacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			planivacacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			planivacacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		planivacacion = new  PlaniVacacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			planivacacion=planivacacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.planivacacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacion);
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
		planivacacion = new  PlaniVacacion();
		  		  
        try {
			
			planivacacion=planivacacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.planivacacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		planivacacion = new  PlaniVacacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			planivacacion=planivacacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.planivacacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacion);
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
		planivacacion = new  PlaniVacacion();
		  		  
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
		planivacacion = new  PlaniVacacion();
		  		  
        try {
			
			planivacacion=planivacacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.planivacacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		planivacacion = new  PlaniVacacion();
		  		  
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
		planivacacion = new  PlaniVacacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =planivacacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		planivacacion = new  PlaniVacacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=planivacacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		planivacacion = new  PlaniVacacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =planivacacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		planivacacion = new  PlaniVacacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=planivacacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		planivacacion = new  PlaniVacacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =planivacacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		planivacacion = new  PlaniVacacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=planivacacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		planivacacions = new  ArrayList<PlaniVacacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planivacacions=planivacacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlaniVacacion(planivacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
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
		planivacacions = new  ArrayList<PlaniVacacion>();
		  		  
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
		planivacacions = new  ArrayList<PlaniVacacion>();
		  		  
        try {			
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planivacacions=planivacacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPlaniVacacion(planivacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		planivacacions = new  ArrayList<PlaniVacacion>();
		  		  
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
		planivacacions = new  ArrayList<PlaniVacacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planivacacions=planivacacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlaniVacacion(planivacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
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
		planivacacions = new  ArrayList<PlaniVacacion>();
		  		  
        try {
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planivacacions=planivacacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlaniVacacion(planivacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
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
		planivacacions = new  ArrayList<PlaniVacacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planivacacions=planivacacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPlaniVacacion(planivacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
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
		planivacacions = new  ArrayList<PlaniVacacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planivacacions=planivacacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPlaniVacacion(planivacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		planivacacion = new  PlaniVacacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planivacacion=planivacacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPlaniVacacion(planivacacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacion);
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
		planivacacion = new  PlaniVacacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planivacacion=planivacacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPlaniVacacion(planivacacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		planivacacions = new  ArrayList<PlaniVacacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planivacacions=planivacacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlaniVacacion(planivacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
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
		planivacacions = new  ArrayList<PlaniVacacion>();
		  		  
        try {
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planivacacions=planivacacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPlaniVacacion(planivacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPlaniVacacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		planivacacions = new  ArrayList<PlaniVacacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getTodosPlaniVacacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPlaniVacacion(planivacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
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
	
	public  void  getTodosPlaniVacacions(String sFinalQuery,Pagination pagination)throws Exception {
		planivacacions = new  ArrayList<PlaniVacacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPlaniVacacion(planivacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPlaniVacacion(PlaniVacacion planivacacion) throws Exception {
		Boolean estaValidado=false;
		
		if(planivacacion.getIsNew() || planivacacion.getIsChanged()) { 
			this.invalidValues = planivacacionValidator.getInvalidValues(planivacacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(planivacacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPlaniVacacion(List<PlaniVacacion> PlaniVacacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PlaniVacacion planivacacionLocal:planivacacions) {				
			estaValidadoObjeto=this.validarGuardarPlaniVacacion(planivacacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPlaniVacacion(List<PlaniVacacion> PlaniVacacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPlaniVacacion(planivacacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPlaniVacacion(PlaniVacacion PlaniVacacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPlaniVacacion(planivacacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PlaniVacacion planivacacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+planivacacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PlaniVacacionConstantesFunciones.getPlaniVacacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"planivacacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PlaniVacacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PlaniVacacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePlaniVacacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-savePlaniVacacionWithConnection");connexion.begin();			
			
			PlaniVacacionLogicAdditional.checkPlaniVacacionToSave(this.planivacacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PlaniVacacionLogicAdditional.updatePlaniVacacionToSave(this.planivacacion,this.arrDatoGeneral);
			
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.planivacacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPlaniVacacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPlaniVacacion(this.planivacacion)) {
				PlaniVacacionDataAccess.save(this.planivacacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.planivacacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PlaniVacacionLogicAdditional.checkPlaniVacacionToSaveAfter(this.planivacacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPlaniVacacion();
			
			connexion.commit();			
			
			if(this.planivacacion.getIsDeleted()) {
				this.planivacacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePlaniVacacion()throws Exception {	
		try {	
			
			PlaniVacacionLogicAdditional.checkPlaniVacacionToSave(this.planivacacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PlaniVacacionLogicAdditional.updatePlaniVacacionToSave(this.planivacacion,this.arrDatoGeneral);
			
			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.planivacacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPlaniVacacion(this.planivacacion)) {			
				PlaniVacacionDataAccess.save(this.planivacacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.planivacacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PlaniVacacionLogicAdditional.checkPlaniVacacionToSaveAfter(this.planivacacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.planivacacion.getIsDeleted()) {
				this.planivacacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePlaniVacacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-savePlaniVacacionsWithConnection");connexion.begin();			
			
			PlaniVacacionLogicAdditional.checkPlaniVacacionToSaves(planivacacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPlaniVacacions();
			
			Boolean validadoTodosPlaniVacacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PlaniVacacion planivacacionLocal:planivacacions) {		
				if(planivacacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PlaniVacacionLogicAdditional.updatePlaniVacacionToSave(planivacacionLocal,this.arrDatoGeneral);
	        	
				PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),planivacacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPlaniVacacion(planivacacionLocal)) {
					PlaniVacacionDataAccess.save(planivacacionLocal, connexion);				
				} else {
					validadoTodosPlaniVacacion=false;
				}
			}
			
			if(!validadoTodosPlaniVacacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PlaniVacacionLogicAdditional.checkPlaniVacacionToSavesAfter(planivacacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPlaniVacacions();
			
			connexion.commit();		
			
			this.quitarPlaniVacacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePlaniVacacions()throws Exception {				
		 try {	
			PlaniVacacionLogicAdditional.checkPlaniVacacionToSaves(planivacacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPlaniVacacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PlaniVacacion planivacacionLocal:planivacacions) {				
				if(planivacacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PlaniVacacionLogicAdditional.updatePlaniVacacionToSave(planivacacionLocal,this.arrDatoGeneral);
	        	
				PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),planivacacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPlaniVacacion(planivacacionLocal)) {				
					PlaniVacacionDataAccess.save(planivacacionLocal, connexion);				
				} else {
					validadoTodosPlaniVacacion=false;
				}
			}
			
			if(!validadoTodosPlaniVacacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PlaniVacacionLogicAdditional.checkPlaniVacacionToSavesAfter(planivacacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPlaniVacacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PlaniVacacionParameterReturnGeneral procesarAccionPlaniVacacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PlaniVacacion> planivacacions,PlaniVacacionParameterReturnGeneral planivacacionParameterGeneral)throws Exception {
		 try {	
			PlaniVacacionParameterReturnGeneral planivacacionReturnGeneral=new PlaniVacacionParameterReturnGeneral();
	
			PlaniVacacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,planivacacions,planivacacionParameterGeneral,planivacacionReturnGeneral);
			
			return planivacacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PlaniVacacionParameterReturnGeneral procesarAccionPlaniVacacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PlaniVacacion> planivacacions,PlaniVacacionParameterReturnGeneral planivacacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-procesarAccionPlaniVacacionsWithConnection");connexion.begin();			
			
			PlaniVacacionParameterReturnGeneral planivacacionReturnGeneral=new PlaniVacacionParameterReturnGeneral();
	
			PlaniVacacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,planivacacions,planivacacionParameterGeneral,planivacacionReturnGeneral);
			
			this.connexion.commit();
			
			return planivacacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PlaniVacacionParameterReturnGeneral procesarEventosPlaniVacacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PlaniVacacion> planivacacions,PlaniVacacion planivacacion,PlaniVacacionParameterReturnGeneral planivacacionParameterGeneral,Boolean isEsNuevoPlaniVacacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			PlaniVacacionParameterReturnGeneral planivacacionReturnGeneral=new PlaniVacacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				planivacacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PlaniVacacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,planivacacions,planivacacion,planivacacionParameterGeneral,planivacacionReturnGeneral,isEsNuevoPlaniVacacion,clases);
			
			return planivacacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PlaniVacacionParameterReturnGeneral procesarEventosPlaniVacacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PlaniVacacion> planivacacions,PlaniVacacion planivacacion,PlaniVacacionParameterReturnGeneral planivacacionParameterGeneral,Boolean isEsNuevoPlaniVacacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-procesarEventosPlaniVacacionsWithConnection");connexion.begin();			
			
			PlaniVacacionParameterReturnGeneral planivacacionReturnGeneral=new PlaniVacacionParameterReturnGeneral();
	
			planivacacionReturnGeneral.setPlaniVacacion(planivacacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				planivacacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PlaniVacacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,planivacacions,planivacacion,planivacacionParameterGeneral,planivacacionReturnGeneral,isEsNuevoPlaniVacacion,clases);
			
			this.connexion.commit();
			
			return planivacacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PlaniVacacionParameterReturnGeneral procesarImportacionPlaniVacacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PlaniVacacionParameterReturnGeneral planivacacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-procesarImportacionPlaniVacacionsWithConnection");connexion.begin();			
			
			PlaniVacacionParameterReturnGeneral planivacacionReturnGeneral=new PlaniVacacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.planivacacions=new ArrayList<PlaniVacacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.planivacacion=new PlaniVacacion();
				
				
				if(conColumnasBase) {this.planivacacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.planivacacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.planivacacion.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.planivacacion.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.planivacacion.setdias_anio(Double.parseDouble(arrColumnas[iColumn++]));
				this.planivacacion.setdias_realizadas(Double.parseDouble(arrColumnas[iColumn++]));
				this.planivacacion.setdias_pendiente(Double.parseDouble(arrColumnas[iColumn++]));
				this.planivacacion.setdias_tomados(Double.parseDouble(arrColumnas[iColumn++]));
				this.planivacacion.setdias_anticipadas(Double.parseDouble(arrColumnas[iColumn++]));
			this.planivacacion.setdescripcion(arrColumnas[iColumn++]);
				
				this.planivacacions.add(this.planivacacion);
			}
			
			this.savePlaniVacacions();
			
			this.connexion.commit();
			
			planivacacionReturnGeneral.setConRetornoEstaProcesado(true);
			planivacacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return planivacacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPlaniVacacionsEliminados() throws Exception {				
		
		List<PlaniVacacion> planivacacionsAux= new ArrayList<PlaniVacacion>();
		
		for(PlaniVacacion planivacacion:planivacacions) {
			if(!planivacacion.getIsDeleted()) {
				planivacacionsAux.add(planivacacion);
			}
		}
		
		planivacacions=planivacacionsAux;
	}
	
	public void quitarPlaniVacacionsNulos() throws Exception {				
		
		List<PlaniVacacion> planivacacionsAux= new ArrayList<PlaniVacacion>();
		
		for(PlaniVacacion planivacacion : this.planivacacions) {
			if(planivacacion==null) {
				planivacacionsAux.add(planivacacion);
			}
		}
		
		//this.planivacacions=planivacacionsAux;
		
		this.planivacacions.removeAll(planivacacionsAux);
	}
	
	public void getSetVersionRowPlaniVacacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(planivacacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((planivacacion.getIsDeleted() || (planivacacion.getIsChanged()&&!planivacacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=planivacacionDataAccess.getSetVersionRowPlaniVacacion(connexion,planivacacion.getId());
				
				if(!planivacacion.getVersionRow().equals(timestamp)) {	
					planivacacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				planivacacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPlaniVacacion()throws Exception {	
		
		if(planivacacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((planivacacion.getIsDeleted() || (planivacacion.getIsChanged()&&!planivacacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=planivacacionDataAccess.getSetVersionRowPlaniVacacion(connexion,planivacacion.getId());
			
			try {							
				if(!planivacacion.getVersionRow().equals(timestamp)) {	
					planivacacion.setVersionRow(timestamp);
				}
				
				planivacacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPlaniVacacionsWithConnection()throws Exception {	
		if(planivacacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PlaniVacacion planivacacionAux:planivacacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(planivacacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(planivacacionAux.getIsDeleted() || (planivacacionAux.getIsChanged()&&!planivacacionAux.getIsNew())) {
						
						timestamp=planivacacionDataAccess.getSetVersionRowPlaniVacacion(connexion,planivacacionAux.getId());
						
						if(!planivacacion.getVersionRow().equals(timestamp)) {	
							planivacacionAux.setVersionRow(timestamp);
						}
								
						planivacacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPlaniVacacions()throws Exception {	
		if(planivacacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PlaniVacacion planivacacionAux:planivacacions) {
					if(planivacacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(planivacacionAux.getIsDeleted() || (planivacacionAux.getIsChanged()&&!planivacacionAux.getIsNew())) {
						
						timestamp=planivacacionDataAccess.getSetVersionRowPlaniVacacion(connexion,planivacacionAux.getId());
						
						if(!planivacacionAux.getVersionRow().equals(timestamp)) {	
							planivacacionAux.setVersionRow(timestamp);
						}
						
													
						planivacacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PlaniVacacionParameterReturnGeneral cargarCombosLoteForeignKeyPlaniVacacionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstructura,String finalQueryGlobalEstructuraSeccion,String finalQueryGlobalEstructuraCargo,String finalQueryGlobalEmpleado,String finalQueryGlobalMes) throws Exception {
		PlaniVacacionParameterReturnGeneral  planivacacionReturnGeneral =new PlaniVacacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-cargarCombosLoteForeignKeyPlaniVacacionWithConnection");connexion.begin();
			
			planivacacionReturnGeneral =new PlaniVacacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			planivacacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			planivacacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			planivacacionReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Estructura> estructuraseccionsForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraseccionLogic=new EstructuraLogic();
			estructuraseccionLogic.setConnexion(this.connexion);
			estructuraseccionLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructuraSeccion.equals("NONE")) {
				estructuraseccionLogic.getTodosEstructuras(finalQueryGlobalEstructuraSeccion,new Pagination());
				estructuraseccionsForeignKey=estructuraseccionLogic.getEstructuras();
			}

			planivacacionReturnGeneral.setestructuraseccionsForeignKey(estructuraseccionsForeignKey);


			List<Estructura> estructuracargosForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuracargoLogic=new EstructuraLogic();
			estructuracargoLogic.setConnexion(this.connexion);
			estructuracargoLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructuraCargo.equals("NONE")) {
				estructuracargoLogic.getTodosEstructuras(finalQueryGlobalEstructuraCargo,new Pagination());
				estructuracargosForeignKey=estructuracargoLogic.getEstructuras();
			}

			planivacacionReturnGeneral.setestructuracargosForeignKey(estructuracargosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			planivacacionReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			planivacacionReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return planivacacionReturnGeneral;
	}
	
	public PlaniVacacionParameterReturnGeneral cargarCombosLoteForeignKeyPlaniVacacion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstructura,String finalQueryGlobalEstructuraSeccion,String finalQueryGlobalEstructuraCargo,String finalQueryGlobalEmpleado,String finalQueryGlobalMes) throws Exception {
		PlaniVacacionParameterReturnGeneral  planivacacionReturnGeneral =new PlaniVacacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			planivacacionReturnGeneral =new PlaniVacacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			planivacacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			planivacacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			planivacacionReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Estructura> estructuraseccionsForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraseccionLogic=new EstructuraLogic();
			estructuraseccionLogic.setConnexion(this.connexion);
			estructuraseccionLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructuraSeccion.equals("NONE")) {
				estructuraseccionLogic.getTodosEstructuras(finalQueryGlobalEstructuraSeccion,new Pagination());
				estructuraseccionsForeignKey=estructuraseccionLogic.getEstructuras();
			}

			planivacacionReturnGeneral.setestructuraseccionsForeignKey(estructuraseccionsForeignKey);


			List<Estructura> estructuracargosForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuracargoLogic=new EstructuraLogic();
			estructuracargoLogic.setConnexion(this.connexion);
			estructuracargoLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructuraCargo.equals("NONE")) {
				estructuracargoLogic.getTodosEstructuras(finalQueryGlobalEstructuraCargo,new Pagination());
				estructuracargosForeignKey=estructuracargoLogic.getEstructuras();
			}

			planivacacionReturnGeneral.setestructuracargosForeignKey(estructuracargosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			planivacacionReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			planivacacionReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return planivacacionReturnGeneral;
	}
	
	
	public void deepLoad(PlaniVacacion planivacacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PlaniVacacionLogicAdditional.updatePlaniVacacionToGet(planivacacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		planivacacion.setEmpresa(planivacacionDataAccess.getEmpresa(connexion,planivacacion));
		planivacacion.setSucursal(planivacacionDataAccess.getSucursal(connexion,planivacacion));
		planivacacion.setEstructura(planivacacionDataAccess.getEstructura(connexion,planivacacion));
		planivacacion.setEstructuraSeccion(planivacacionDataAccess.getEstructuraSeccion(connexion,planivacacion));
		planivacacion.setEstructuraCargo(planivacacionDataAccess.getEstructuraCargo(connexion,planivacacion));
		planivacacion.setEmpleado(planivacacionDataAccess.getEmpleado(connexion,planivacacion));
		planivacacion.setMes(planivacacionDataAccess.getMes(connexion,planivacacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				planivacacion.setEmpresa(planivacacionDataAccess.getEmpresa(connexion,planivacacion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				planivacacion.setSucursal(planivacacionDataAccess.getSucursal(connexion,planivacacion));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				planivacacion.setEstructura(planivacacionDataAccess.getEstructura(connexion,planivacacion));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				planivacacion.setEstructuraSeccion(planivacacionDataAccess.getEstructuraSeccion(connexion,planivacacion));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				planivacacion.setEstructuraCargo(planivacacionDataAccess.getEstructuraCargo(connexion,planivacacion));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				planivacacion.setEmpleado(planivacacionDataAccess.getEmpleado(connexion,planivacacion));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				planivacacion.setMes(planivacacionDataAccess.getMes(connexion,planivacacion));
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
			planivacacion.setEmpresa(planivacacionDataAccess.getEmpresa(connexion,planivacacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planivacacion.setSucursal(planivacacionDataAccess.getSucursal(connexion,planivacacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planivacacion.setEstructura(planivacacionDataAccess.getEstructura(connexion,planivacacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planivacacion.setEstructuraSeccion(planivacacionDataAccess.getEstructuraSeccion(connexion,planivacacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planivacacion.setEstructuraCargo(planivacacionDataAccess.getEstructuraCargo(connexion,planivacacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planivacacion.setEmpleado(planivacacionDataAccess.getEmpleado(connexion,planivacacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planivacacion.setMes(planivacacionDataAccess.getMes(connexion,planivacacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		planivacacion.setEmpresa(planivacacionDataAccess.getEmpresa(connexion,planivacacion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(planivacacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		planivacacion.setSucursal(planivacacionDataAccess.getSucursal(connexion,planivacacion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(planivacacion.getSucursal(),isDeep,deepLoadType,clases);
				
		planivacacion.setEstructura(planivacacionDataAccess.getEstructura(connexion,planivacacion));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(planivacacion.getEstructura(),isDeep,deepLoadType,clases);
				
		planivacacion.setEstructuraSeccion(planivacacionDataAccess.getEstructuraSeccion(connexion,planivacacion));
		EstructuraLogic estructuraseccionLogic= new EstructuraLogic(connexion);
		estructuraseccionLogic.deepLoad(planivacacion.getEstructuraSeccion(),isDeep,deepLoadType,clases);
				
		planivacacion.setEstructuraCargo(planivacacionDataAccess.getEstructuraCargo(connexion,planivacacion));
		EstructuraLogic estructuracargoLogic= new EstructuraLogic(connexion);
		estructuracargoLogic.deepLoad(planivacacion.getEstructuraCargo(),isDeep,deepLoadType,clases);
				
		planivacacion.setEmpleado(planivacacionDataAccess.getEmpleado(connexion,planivacacion));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(planivacacion.getEmpleado(),isDeep,deepLoadType,clases);
				
		planivacacion.setMes(planivacacionDataAccess.getMes(connexion,planivacacion));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(planivacacion.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				planivacacion.setEmpresa(planivacacionDataAccess.getEmpresa(connexion,planivacacion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(planivacacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				planivacacion.setSucursal(planivacacionDataAccess.getSucursal(connexion,planivacacion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(planivacacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				planivacacion.setEstructura(planivacacionDataAccess.getEstructura(connexion,planivacacion));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(planivacacion.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				planivacacion.setEstructuraSeccion(planivacacionDataAccess.getEstructuraSeccion(connexion,planivacacion));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(planivacacion.getEstructuraSeccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				planivacacion.setEstructuraCargo(planivacacionDataAccess.getEstructuraCargo(connexion,planivacacion));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(planivacacion.getEstructuraCargo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				planivacacion.setEmpleado(planivacacionDataAccess.getEmpleado(connexion,planivacacion));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(planivacacion.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				planivacacion.setMes(planivacacionDataAccess.getMes(connexion,planivacacion));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(planivacacion.getMes(),isDeep,deepLoadType,clases);				
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
			planivacacion.setEmpresa(planivacacionDataAccess.getEmpresa(connexion,planivacacion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(planivacacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planivacacion.setSucursal(planivacacionDataAccess.getSucursal(connexion,planivacacion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(planivacacion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planivacacion.setEstructura(planivacacionDataAccess.getEstructura(connexion,planivacacion));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(planivacacion.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planivacacion.setEstructuraSeccion(planivacacionDataAccess.getEstructuraSeccion(connexion,planivacacion));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(planivacacion.getEstructuraSeccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planivacacion.setEstructuraCargo(planivacacionDataAccess.getEstructuraCargo(connexion,planivacacion));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(planivacacion.getEstructuraCargo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planivacacion.setEmpleado(planivacacionDataAccess.getEmpleado(connexion,planivacacion));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(planivacacion.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			planivacacion.setMes(planivacacionDataAccess.getMes(connexion,planivacacion));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(planivacacion.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PlaniVacacion planivacacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PlaniVacacionLogicAdditional.updatePlaniVacacionToSave(planivacacion,this.arrDatoGeneral);
			
PlaniVacacionDataAccess.save(planivacacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(planivacacion.getEmpresa(),connexion);

		SucursalDataAccess.save(planivacacion.getSucursal(),connexion);

		EstructuraDataAccess.save(planivacacion.getEstructura(),connexion);

		EstructuraDataAccess.save(planivacacion.getEstructuraSeccion(),connexion);

		EstructuraDataAccess.save(planivacacion.getEstructuraCargo(),connexion);

		EmpleadoDataAccess.save(planivacacion.getEmpleado(),connexion);

		MesDataAccess.save(planivacacion.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(planivacacion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(planivacacion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(planivacacion.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(planivacacion.getEstructuraSeccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(planivacacion.getEstructuraCargo(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(planivacacion.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(planivacacion.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(planivacacion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(planivacacion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(planivacacion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(planivacacion.getSucursal(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(planivacacion.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(planivacacion.getEstructura(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(planivacacion.getEstructuraSeccion(),connexion);
		EstructuraLogic estructuraseccionLogic= new EstructuraLogic(connexion);
		estructuraseccionLogic.deepLoad(planivacacion.getEstructuraSeccion(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(planivacacion.getEstructuraCargo(),connexion);
		EstructuraLogic estructuracargoLogic= new EstructuraLogic(connexion);
		estructuracargoLogic.deepLoad(planivacacion.getEstructuraCargo(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(planivacacion.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(planivacacion.getEmpleado(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(planivacacion.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(planivacacion.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(planivacacion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(planivacacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(planivacacion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(planivacacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(planivacacion.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(planivacacion.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(planivacacion.getEstructuraSeccion(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(planivacacion.getEstructuraSeccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(planivacacion.getEstructuraCargo(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(planivacacion.getEstructuraCargo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(planivacacion.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(planivacacion.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(planivacacion.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(planivacacion.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PlaniVacacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(planivacacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(planivacacion);
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
			this.deepLoad(this.planivacacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PlaniVacacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(planivacacions!=null) {
				for(PlaniVacacion planivacacion:planivacacions) {
					this.deepLoad(planivacacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(planivacacions);
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
			if(planivacacions!=null) {
				for(PlaniVacacion planivacacion:planivacacions) {
					this.deepLoad(planivacacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(planivacacions);
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
			this.getNewConnexionToDeep(PlaniVacacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(planivacacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PlaniVacacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(planivacacions!=null) {
				for(PlaniVacacion planivacacion:planivacacions) {
					this.deepSave(planivacacion,isDeep,deepLoadType,clases);
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
			if(planivacacions!=null) {
				for(PlaniVacacion planivacacion:planivacacions) {
					this.deepSave(planivacacion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPlaniVacacionsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PlaniVacacionConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaniVacacionsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PlaniVacacionConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaniVacacionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PlaniVacacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaniVacacionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PlaniVacacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaniVacacionsFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,PlaniVacacionConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaniVacacionsFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,PlaniVacacionConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaniVacacionsFK_IdEstructuraCargoWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura_cargo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructuraCargo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructuraCargo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura_cargo,PlaniVacacionConstantesFunciones.IDESTRUCTURACARGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructuraCargo);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructuraCargo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaniVacacionsFK_IdEstructuraCargo(String sFinalQuery,Pagination pagination,Long id_estructura_cargo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructuraCargo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructuraCargo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura_cargo,PlaniVacacionConstantesFunciones.IDESTRUCTURACARGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructuraCargo);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructuraCargo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaniVacacionsFK_IdEstructuraSeccionWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura_seccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructuraSeccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructuraSeccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura_seccion,PlaniVacacionConstantesFunciones.IDESTRUCTURASECCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructuraSeccion);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructuraSeccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaniVacacionsFK_IdEstructuraSeccion(String sFinalQuery,Pagination pagination,Long id_estructura_seccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructuraSeccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructuraSeccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura_seccion,PlaniVacacionConstantesFunciones.IDESTRUCTURASECCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructuraSeccion);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructuraSeccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaniVacacionsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PlaniVacacionConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaniVacacionsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PlaniVacacionConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPlaniVacacionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PlaniVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PlaniVacacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPlaniVacacionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PlaniVacacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PlaniVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			planivacacions=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(this.planivacacions);
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
			if(PlaniVacacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PlaniVacacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PlaniVacacion planivacacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PlaniVacacionConstantesFunciones.ISCONAUDITORIA) {
				if(planivacacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PlaniVacacionDataAccess.TABLENAME, planivacacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PlaniVacacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PlaniVacacionLogic.registrarAuditoriaDetallesPlaniVacacion(connexion,planivacacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(planivacacion.getIsDeleted()) {
					/*if(!planivacacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PlaniVacacionDataAccess.TABLENAME, planivacacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PlaniVacacionLogic.registrarAuditoriaDetallesPlaniVacacion(connexion,planivacacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PlaniVacacionDataAccess.TABLENAME, planivacacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(planivacacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PlaniVacacionDataAccess.TABLENAME, planivacacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PlaniVacacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PlaniVacacionLogic.registrarAuditoriaDetallesPlaniVacacion(connexion,planivacacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPlaniVacacion(Connexion connexion,PlaniVacacion planivacacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(planivacacion.getIsNew()||!planivacacion.getid_empresa().equals(planivacacion.getPlaniVacacionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getid_empresa()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getid_empresa().toString();
				}
				if(planivacacion.getid_empresa()!=null)
				{
					strValorNuevo=planivacacion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getid_sucursal().equals(planivacacion.getPlaniVacacionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getid_sucursal()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getid_sucursal().toString();
				}
				if(planivacacion.getid_sucursal()!=null)
				{
					strValorNuevo=planivacacion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getid_estructura().equals(planivacacion.getPlaniVacacionOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getid_estructura()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getid_estructura().toString();
				}
				if(planivacacion.getid_estructura()!=null)
				{
					strValorNuevo=planivacacion.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getid_estructura_seccion().equals(planivacacion.getPlaniVacacionOriginal().getid_estructura_seccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getid_estructura_seccion()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getid_estructura_seccion().toString();
				}
				if(planivacacion.getid_estructura_seccion()!=null)
				{
					strValorNuevo=planivacacion.getid_estructura_seccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.IDESTRUCTURASECCION,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getid_estructura_cargo().equals(planivacacion.getPlaniVacacionOriginal().getid_estructura_cargo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getid_estructura_cargo()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getid_estructura_cargo().toString();
				}
				if(planivacacion.getid_estructura_cargo()!=null)
				{
					strValorNuevo=planivacacion.getid_estructura_cargo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.IDESTRUCTURACARGO,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getid_empleado().equals(planivacacion.getPlaniVacacionOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getid_empleado()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getid_empleado().toString();
				}
				if(planivacacion.getid_empleado()!=null)
				{
					strValorNuevo=planivacacion.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getfecha_inicio().equals(planivacacion.getPlaniVacacionOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getfecha_inicio()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getfecha_inicio().toString();
				}
				if(planivacacion.getfecha_inicio()!=null)
				{
					strValorNuevo=planivacacion.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getfecha_fin().equals(planivacacion.getPlaniVacacionOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getfecha_fin()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getfecha_fin().toString();
				}
				if(planivacacion.getfecha_fin()!=null)
				{
					strValorNuevo=planivacacion.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getid_mes().equals(planivacacion.getPlaniVacacionOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getid_mes()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getid_mes().toString();
				}
				if(planivacacion.getid_mes()!=null)
				{
					strValorNuevo=planivacacion.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getdias_anio().equals(planivacacion.getPlaniVacacionOriginal().getdias_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getdias_anio()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getdias_anio().toString();
				}
				if(planivacacion.getdias_anio()!=null)
				{
					strValorNuevo=planivacacion.getdias_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.DIASANIO,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getdias_realizadas().equals(planivacacion.getPlaniVacacionOriginal().getdias_realizadas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getdias_realizadas()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getdias_realizadas().toString();
				}
				if(planivacacion.getdias_realizadas()!=null)
				{
					strValorNuevo=planivacacion.getdias_realizadas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.DIASREALIZADAS,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getdias_pendiente().equals(planivacacion.getPlaniVacacionOriginal().getdias_pendiente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getdias_pendiente()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getdias_pendiente().toString();
				}
				if(planivacacion.getdias_pendiente()!=null)
				{
					strValorNuevo=planivacacion.getdias_pendiente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.DIASPENDIENTE,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getdias_tomados().equals(planivacacion.getPlaniVacacionOriginal().getdias_tomados()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getdias_tomados()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getdias_tomados().toString();
				}
				if(planivacacion.getdias_tomados()!=null)
				{
					strValorNuevo=planivacacion.getdias_tomados().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.DIASTOMADOS,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getdias_anticipadas().equals(planivacacion.getPlaniVacacionOriginal().getdias_anticipadas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getdias_anticipadas()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getdias_anticipadas().toString();
				}
				if(planivacacion.getdias_anticipadas()!=null)
				{
					strValorNuevo=planivacacion.getdias_anticipadas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.DIASANTICIPADAS,strValorActual,strValorNuevo);
			}	
			
			if(planivacacion.getIsNew()||!planivacacion.getdescripcion().equals(planivacacion.getPlaniVacacionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(planivacacion.getPlaniVacacionOriginal().getdescripcion()!=null)
				{
					strValorActual=planivacacion.getPlaniVacacionOriginal().getdescripcion();
				}
				if(planivacacion.getdescripcion()!=null)
				{
					strValorNuevo=planivacacion.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PlaniVacacionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePlaniVacacionRelacionesWithConnection(PlaniVacacion planivacacion) throws Exception {

		if(!planivacacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePlaniVacacionRelacionesBase(planivacacion,true);
		}
	}

	public void savePlaniVacacionRelaciones(PlaniVacacion planivacacion)throws Exception {

		if(!planivacacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePlaniVacacionRelacionesBase(planivacacion,false);
		}
	}

	public void savePlaniVacacionRelacionesBase(PlaniVacacion planivacacion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PlaniVacacion-saveRelacionesWithConnection");}
	

			this.setPlaniVacacion(planivacacion);

			if(PlaniVacacionLogicAdditional.validarSaveRelaciones(planivacacion,this)) {

				PlaniVacacionLogicAdditional.updateRelacionesToSave(planivacacion,this);

				if((planivacacion.getIsNew()||planivacacion.getIsChanged())&&!planivacacion.getIsDeleted()) {
					this.savePlaniVacacion();
					this.savePlaniVacacionRelacionesDetalles();

				} else if(planivacacion.getIsDeleted()) {
					this.savePlaniVacacionRelacionesDetalles();
					this.savePlaniVacacion();
				}

				PlaniVacacionLogicAdditional.updateRelacionesToSaveAfter(planivacacion,this);

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
	
	
	private void savePlaniVacacionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPlaniVacacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PlaniVacacionConstantesFunciones.getClassesForeignKeysOfPlaniVacacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlaniVacacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PlaniVacacionConstantesFunciones.getClassesRelationshipsOfPlaniVacacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

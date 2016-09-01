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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.TipoRefePersoConstantesFunciones;
import com.bydan.erp.cartera.util.TipoRefePersoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoRefePersoParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoRefePerso;
import com.bydan.erp.cartera.business.logic.TipoRefePersoLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoRefePersoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoRefePersoLogic.class);
	
	protected TipoRefePersoDataAccess tiporefepersoDataAccess; 	
	protected TipoRefePerso tiporefeperso;
	protected List<TipoRefePerso> tiporefepersos;
	protected Object tiporefepersoObject;	
	protected List<Object> tiporefepersosObject;
	
	public static ClassValidator<TipoRefePerso> tiporefepersoValidator = new ClassValidator<TipoRefePerso>(TipoRefePerso.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoRefePersoLogicAdditional tiporefepersoLogicAdditional=null;
	
	public TipoRefePersoLogicAdditional getTipoRefePersoLogicAdditional() {
		return this.tiporefepersoLogicAdditional;
	}
	
	public void setTipoRefePersoLogicAdditional(TipoRefePersoLogicAdditional tiporefepersoLogicAdditional) {
		try {
			this.tiporefepersoLogicAdditional=tiporefepersoLogicAdditional;
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
	
	
	
	
	public  TipoRefePersoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiporefepersoDataAccess = new TipoRefePersoDataAccess();
			
			this.tiporefepersos= new ArrayList<TipoRefePerso>();
			this.tiporefeperso= new TipoRefePerso();
			
			this.tiporefepersoObject=new Object();
			this.tiporefepersosObject=new ArrayList<Object>();
				
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
			
			this.tiporefepersoDataAccess.setConnexionType(this.connexionType);
			this.tiporefepersoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoRefePersoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiporefepersoDataAccess = new TipoRefePersoDataAccess();
			this.tiporefepersos= new ArrayList<TipoRefePerso>();
			this.tiporefeperso= new TipoRefePerso();
			this.tiporefepersoObject=new Object();
			this.tiporefepersosObject=new ArrayList<Object>();
			
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
			
			this.tiporefepersoDataAccess.setConnexionType(this.connexionType);
			this.tiporefepersoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoRefePerso getTipoRefePerso() throws Exception {	
		TipoRefePersoLogicAdditional.checkTipoRefePersoToGet(tiporefeperso,this.datosCliente,this.arrDatoGeneral);
		TipoRefePersoLogicAdditional.updateTipoRefePersoToGet(tiporefeperso,this.arrDatoGeneral);
		
		return tiporefeperso;
	}
		
	public void setTipoRefePerso(TipoRefePerso newTipoRefePerso) {
		this.tiporefeperso = newTipoRefePerso;
	}
	
	public TipoRefePersoDataAccess getTipoRefePersoDataAccess() {
		return tiporefepersoDataAccess;
	}
	
	public void setTipoRefePersoDataAccess(TipoRefePersoDataAccess newtiporefepersoDataAccess) {
		this.tiporefepersoDataAccess = newtiporefepersoDataAccess;
	}
	
	public List<TipoRefePerso> getTipoRefePersos() throws Exception {		
		this.quitarTipoRefePersosNulos();
		
		TipoRefePersoLogicAdditional.checkTipoRefePersoToGets(tiporefepersos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoRefePerso tiporefepersoLocal: tiporefepersos ) {
			TipoRefePersoLogicAdditional.updateTipoRefePersoToGet(tiporefepersoLocal,this.arrDatoGeneral);
		}
		
		return tiporefepersos;
	}
	
	public void setTipoRefePersos(List<TipoRefePerso> newTipoRefePersos) {
		this.tiporefepersos = newTipoRefePersos;
	}
	
	public Object getTipoRefePersoObject() {	
		this.tiporefepersoObject=this.tiporefepersoDataAccess.getEntityObject();
		return this.tiporefepersoObject;
	}
		
	public void setTipoRefePersoObject(Object newTipoRefePersoObject) {
		this.tiporefepersoObject = newTipoRefePersoObject;
	}
	
	public List<Object> getTipoRefePersosObject() {		
		this.tiporefepersosObject=this.tiporefepersoDataAccess.getEntitiesObject();
		return this.tiporefepersosObject;
	}
		
	public void setTipoRefePersosObject(List<Object> newTipoRefePersosObject) {
		this.tiporefepersosObject = newTipoRefePersosObject;
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
		
		if(this.tiporefepersoDataAccess!=null) {
			this.tiporefepersoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiporefepersoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiporefepersoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiporefeperso = new  TipoRefePerso();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporefeperso=tiporefepersoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporefeperso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefeperso);
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
		tiporefeperso = new  TipoRefePerso();
		  		  
        try {
			
			tiporefeperso=tiporefepersoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporefeperso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefeperso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiporefeperso = new  TipoRefePerso();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporefeperso=tiporefepersoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporefeperso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefeperso);
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
		tiporefeperso = new  TipoRefePerso();
		  		  
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
		tiporefeperso = new  TipoRefePerso();
		  		  
        try {
			
			tiporefeperso=tiporefepersoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporefeperso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefeperso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiporefeperso = new  TipoRefePerso();
		  		  
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
		tiporefeperso = new  TipoRefePerso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiporefepersoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporefeperso = new  TipoRefePerso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiporefepersoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporefeperso = new  TipoRefePerso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiporefepersoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporefeperso = new  TipoRefePerso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiporefepersoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporefeperso = new  TipoRefePerso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiporefepersoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporefeperso = new  TipoRefePerso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiporefepersoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporefepersos = new  ArrayList<TipoRefePerso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporefepersos=tiporefepersoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRefePerso(tiporefepersos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
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
		tiporefepersos = new  ArrayList<TipoRefePerso>();
		  		  
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
		tiporefepersos = new  ArrayList<TipoRefePerso>();
		  		  
        try {			
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporefepersos=tiporefepersoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoRefePerso(tiporefepersos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiporefepersos = new  ArrayList<TipoRefePerso>();
		  		  
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
		tiporefepersos = new  ArrayList<TipoRefePerso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporefepersos=tiporefepersoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRefePerso(tiporefepersos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
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
		tiporefepersos = new  ArrayList<TipoRefePerso>();
		  		  
        try {
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporefepersos=tiporefepersoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRefePerso(tiporefepersos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
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
		tiporefepersos = new  ArrayList<TipoRefePerso>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporefepersos=tiporefepersoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRefePerso(tiporefepersos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
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
		tiporefepersos = new  ArrayList<TipoRefePerso>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporefepersos=tiporefepersoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRefePerso(tiporefepersos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiporefeperso = new  TipoRefePerso();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporefeperso=tiporefepersoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRefePerso(tiporefeperso);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefeperso);
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
		tiporefeperso = new  TipoRefePerso();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporefeperso=tiporefepersoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRefePerso(tiporefeperso);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefeperso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporefepersos = new  ArrayList<TipoRefePerso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporefepersos=tiporefepersoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRefePerso(tiporefepersos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
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
		tiporefepersos = new  ArrayList<TipoRefePerso>();
		  		  
        try {
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporefepersos=tiporefepersoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRefePerso(tiporefepersos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoRefePersosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiporefepersos = new  ArrayList<TipoRefePerso>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getTodosTipoRefePersosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporefepersos=tiporefepersoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRefePerso(tiporefepersos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
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
	
	public  void  getTodosTipoRefePersos(String sFinalQuery,Pagination pagination)throws Exception {
		tiporefepersos = new  ArrayList<TipoRefePerso>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporefepersos=tiporefepersoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRefePerso(tiporefepersos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoRefePerso(TipoRefePerso tiporefeperso) throws Exception {
		Boolean estaValidado=false;
		
		if(tiporefeperso.getIsNew() || tiporefeperso.getIsChanged()) { 
			this.invalidValues = tiporefepersoValidator.getInvalidValues(tiporefeperso);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiporefeperso);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoRefePerso(List<TipoRefePerso> TipoRefePersos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoRefePerso tiporefepersoLocal:tiporefepersos) {				
			estaValidadoObjeto=this.validarGuardarTipoRefePerso(tiporefepersoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoRefePerso(List<TipoRefePerso> TipoRefePersos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRefePerso(tiporefepersos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoRefePerso(TipoRefePerso TipoRefePerso) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRefePerso(tiporefeperso)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoRefePerso tiporefeperso) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiporefeperso.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoRefePersoConstantesFunciones.getTipoRefePersoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiporefeperso","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoRefePersoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoRefePersoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoRefePersoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-saveTipoRefePersoWithConnection");connexion.begin();			
			
			TipoRefePersoLogicAdditional.checkTipoRefePersoToSave(this.tiporefeperso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRefePersoLogicAdditional.updateTipoRefePersoToSave(this.tiporefeperso,this.arrDatoGeneral);
			
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporefeperso,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoRefePerso();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRefePerso(this.tiporefeperso)) {
				TipoRefePersoDataAccess.save(this.tiporefeperso, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiporefeperso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRefePersoLogicAdditional.checkTipoRefePersoToSaveAfter(this.tiporefeperso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRefePerso();
			
			connexion.commit();			
			
			if(this.tiporefeperso.getIsDeleted()) {
				this.tiporefeperso=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoRefePerso()throws Exception {	
		try {	
			
			TipoRefePersoLogicAdditional.checkTipoRefePersoToSave(this.tiporefeperso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRefePersoLogicAdditional.updateTipoRefePersoToSave(this.tiporefeperso,this.arrDatoGeneral);
			
			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporefeperso,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRefePerso(this.tiporefeperso)) {			
				TipoRefePersoDataAccess.save(this.tiporefeperso, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiporefeperso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRefePersoLogicAdditional.checkTipoRefePersoToSaveAfter(this.tiporefeperso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiporefeperso.getIsDeleted()) {
				this.tiporefeperso=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoRefePersosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-saveTipoRefePersosWithConnection");connexion.begin();			
			
			TipoRefePersoLogicAdditional.checkTipoRefePersoToSaves(tiporefepersos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoRefePersos();
			
			Boolean validadoTodosTipoRefePerso=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRefePerso tiporefepersoLocal:tiporefepersos) {		
				if(tiporefepersoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRefePersoLogicAdditional.updateTipoRefePersoToSave(tiporefepersoLocal,this.arrDatoGeneral);
	        	
				TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporefepersoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRefePerso(tiporefepersoLocal)) {
					TipoRefePersoDataAccess.save(tiporefepersoLocal, connexion);				
				} else {
					validadoTodosTipoRefePerso=false;
				}
			}
			
			if(!validadoTodosTipoRefePerso) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRefePersoLogicAdditional.checkTipoRefePersoToSavesAfter(tiporefepersos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRefePersos();
			
			connexion.commit();		
			
			this.quitarTipoRefePersosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoRefePersos()throws Exception {				
		 try {	
			TipoRefePersoLogicAdditional.checkTipoRefePersoToSaves(tiporefepersos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoRefePerso=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRefePerso tiporefepersoLocal:tiporefepersos) {				
				if(tiporefepersoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRefePersoLogicAdditional.updateTipoRefePersoToSave(tiporefepersoLocal,this.arrDatoGeneral);
	        	
				TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporefepersoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRefePerso(tiporefepersoLocal)) {				
					TipoRefePersoDataAccess.save(tiporefepersoLocal, connexion);				
				} else {
					validadoTodosTipoRefePerso=false;
				}
			}
			
			if(!validadoTodosTipoRefePerso) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRefePersoLogicAdditional.checkTipoRefePersoToSavesAfter(tiporefepersos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoRefePersosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRefePersoParameterReturnGeneral procesarAccionTipoRefePersos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRefePerso> tiporefepersos,TipoRefePersoParameterReturnGeneral tiporefepersoParameterGeneral)throws Exception {
		 try {	
			TipoRefePersoParameterReturnGeneral tiporefepersoReturnGeneral=new TipoRefePersoParameterReturnGeneral();
	
			TipoRefePersoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporefepersos,tiporefepersoParameterGeneral,tiporefepersoReturnGeneral);
			
			return tiporefepersoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRefePersoParameterReturnGeneral procesarAccionTipoRefePersosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRefePerso> tiporefepersos,TipoRefePersoParameterReturnGeneral tiporefepersoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-procesarAccionTipoRefePersosWithConnection");connexion.begin();			
			
			TipoRefePersoParameterReturnGeneral tiporefepersoReturnGeneral=new TipoRefePersoParameterReturnGeneral();
	
			TipoRefePersoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporefepersos,tiporefepersoParameterGeneral,tiporefepersoReturnGeneral);
			
			this.connexion.commit();
			
			return tiporefepersoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRefePersoParameterReturnGeneral procesarEventosTipoRefePersos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRefePerso> tiporefepersos,TipoRefePerso tiporefeperso,TipoRefePersoParameterReturnGeneral tiporefepersoParameterGeneral,Boolean isEsNuevoTipoRefePerso,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoRefePersoParameterReturnGeneral tiporefepersoReturnGeneral=new TipoRefePersoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporefepersoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRefePersoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporefepersos,tiporefeperso,tiporefepersoParameterGeneral,tiporefepersoReturnGeneral,isEsNuevoTipoRefePerso,clases);
			
			return tiporefepersoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoRefePersoParameterReturnGeneral procesarEventosTipoRefePersosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRefePerso> tiporefepersos,TipoRefePerso tiporefeperso,TipoRefePersoParameterReturnGeneral tiporefepersoParameterGeneral,Boolean isEsNuevoTipoRefePerso,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-procesarEventosTipoRefePersosWithConnection");connexion.begin();			
			
			TipoRefePersoParameterReturnGeneral tiporefepersoReturnGeneral=new TipoRefePersoParameterReturnGeneral();
	
			tiporefepersoReturnGeneral.setTipoRefePerso(tiporefeperso);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporefepersoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRefePersoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporefepersos,tiporefeperso,tiporefepersoParameterGeneral,tiporefepersoReturnGeneral,isEsNuevoTipoRefePerso,clases);
			
			this.connexion.commit();
			
			return tiporefepersoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRefePersoParameterReturnGeneral procesarImportacionTipoRefePersosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoRefePersoParameterReturnGeneral tiporefepersoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-procesarImportacionTipoRefePersosWithConnection");connexion.begin();			
			
			TipoRefePersoParameterReturnGeneral tiporefepersoReturnGeneral=new TipoRefePersoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiporefepersos=new ArrayList<TipoRefePerso>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiporefeperso=new TipoRefePerso();
				
				
				if(conColumnasBase) {this.tiporefeperso.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiporefeperso.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiporefeperso.setcodigo(arrColumnas[iColumn++]);
				this.tiporefeperso.setnombre(arrColumnas[iColumn++]);
				
				this.tiporefepersos.add(this.tiporefeperso);
			}
			
			this.saveTipoRefePersos();
			
			this.connexion.commit();
			
			tiporefepersoReturnGeneral.setConRetornoEstaProcesado(true);
			tiporefepersoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiporefepersoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoRefePersosEliminados() throws Exception {				
		
		List<TipoRefePerso> tiporefepersosAux= new ArrayList<TipoRefePerso>();
		
		for(TipoRefePerso tiporefeperso:tiporefepersos) {
			if(!tiporefeperso.getIsDeleted()) {
				tiporefepersosAux.add(tiporefeperso);
			}
		}
		
		tiporefepersos=tiporefepersosAux;
	}
	
	public void quitarTipoRefePersosNulos() throws Exception {				
		
		List<TipoRefePerso> tiporefepersosAux= new ArrayList<TipoRefePerso>();
		
		for(TipoRefePerso tiporefeperso : this.tiporefepersos) {
			if(tiporefeperso==null) {
				tiporefepersosAux.add(tiporefeperso);
			}
		}
		
		//this.tiporefepersos=tiporefepersosAux;
		
		this.tiporefepersos.removeAll(tiporefepersosAux);
	}
	
	public void getSetVersionRowTipoRefePersoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiporefeperso.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiporefeperso.getIsDeleted() || (tiporefeperso.getIsChanged()&&!tiporefeperso.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiporefepersoDataAccess.getSetVersionRowTipoRefePerso(connexion,tiporefeperso.getId());
				
				if(!tiporefeperso.getVersionRow().equals(timestamp)) {	
					tiporefeperso.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiporefeperso.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoRefePerso()throws Exception {	
		
		if(tiporefeperso.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiporefeperso.getIsDeleted() || (tiporefeperso.getIsChanged()&&!tiporefeperso.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiporefepersoDataAccess.getSetVersionRowTipoRefePerso(connexion,tiporefeperso.getId());
			
			try {							
				if(!tiporefeperso.getVersionRow().equals(timestamp)) {	
					tiporefeperso.setVersionRow(timestamp);
				}
				
				tiporefeperso.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoRefePersosWithConnection()throws Exception {	
		if(tiporefepersos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoRefePerso tiporefepersoAux:tiporefepersos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiporefepersoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporefepersoAux.getIsDeleted() || (tiporefepersoAux.getIsChanged()&&!tiporefepersoAux.getIsNew())) {
						
						timestamp=tiporefepersoDataAccess.getSetVersionRowTipoRefePerso(connexion,tiporefepersoAux.getId());
						
						if(!tiporefeperso.getVersionRow().equals(timestamp)) {	
							tiporefepersoAux.setVersionRow(timestamp);
						}
								
						tiporefepersoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoRefePersos()throws Exception {	
		if(tiporefepersos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoRefePerso tiporefepersoAux:tiporefepersos) {
					if(tiporefepersoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporefepersoAux.getIsDeleted() || (tiporefepersoAux.getIsChanged()&&!tiporefepersoAux.getIsNew())) {
						
						timestamp=tiporefepersoDataAccess.getSetVersionRowTipoRefePerso(connexion,tiporefepersoAux.getId());
						
						if(!tiporefepersoAux.getVersionRow().equals(timestamp)) {	
							tiporefepersoAux.setVersionRow(timestamp);
						}
						
													
						tiporefepersoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoRefePersoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ReferenciaPersonalLogic referenciapersonalLogic=new ReferenciaPersonalLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoRefePersoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ReferenciaPersonal.class));
											
			

			referenciapersonalLogic.setConnexion(this.getConnexion());
			referenciapersonalLogic.setDatosCliente(this.datosCliente);
			referenciapersonalLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoRefePerso tiporefeperso:this.tiporefepersos) {
				

				classes=new ArrayList<Classe>();
				classes=ReferenciaPersonalConstantesFunciones.getClassesForeignKeysOfReferenciaPersonal(new ArrayList<Classe>(),DeepLoadType.NONE);

				referenciapersonalLogic.setReferenciaPersonals(tiporefeperso.referenciapersonals);
				referenciapersonalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(TipoRefePerso tiporefeperso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoRefePersoLogicAdditional.updateTipoRefePersoToGet(tiporefeperso,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporefeperso.setReferenciaPersonals(tiporefepersoDataAccess.getReferenciaPersonals(connexion,tiporefeperso));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporefeperso.setReferenciaPersonals(tiporefepersoDataAccess.getReferenciaPersonals(connexion,tiporefeperso));

				if(this.isConDeep) {
					ReferenciaPersonalLogic referenciapersonalLogic= new ReferenciaPersonalLogic(this.connexion);
					referenciapersonalLogic.setReferenciaPersonals(tiporefeperso.getReferenciaPersonals());
					ArrayList<Classe> classesLocal=ReferenciaPersonalConstantesFunciones.getClassesForeignKeysOfReferenciaPersonal(new ArrayList<Classe>(),DeepLoadType.NONE);
					referenciapersonalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(referenciapersonalLogic.getReferenciaPersonals());
					tiporefeperso.setReferenciaPersonals(referenciapersonalLogic.getReferenciaPersonals());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaPersonal.class));
			tiporefeperso.setReferenciaPersonals(tiporefepersoDataAccess.getReferenciaPersonals(connexion,tiporefeperso));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tiporefeperso.setReferenciaPersonals(tiporefepersoDataAccess.getReferenciaPersonals(connexion,tiporefeperso));

		for(ReferenciaPersonal referenciapersonal:tiporefeperso.getReferenciaPersonals()) {
			ReferenciaPersonalLogic referenciapersonalLogic= new ReferenciaPersonalLogic(connexion);
			referenciapersonalLogic.deepLoad(referenciapersonal,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporefeperso.setReferenciaPersonals(tiporefepersoDataAccess.getReferenciaPersonals(connexion,tiporefeperso));

				for(ReferenciaPersonal referenciapersonal:tiporefeperso.getReferenciaPersonals()) {
					ReferenciaPersonalLogic referenciapersonalLogic= new ReferenciaPersonalLogic(connexion);
					referenciapersonalLogic.deepLoad(referenciapersonal,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaPersonal.class));
			tiporefeperso.setReferenciaPersonals(tiporefepersoDataAccess.getReferenciaPersonals(connexion,tiporefeperso));

			for(ReferenciaPersonal referenciapersonal:tiporefeperso.getReferenciaPersonals()) {
				ReferenciaPersonalLogic referenciapersonalLogic= new ReferenciaPersonalLogic(connexion);
				referenciapersonalLogic.deepLoad(referenciapersonal,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoRefePerso tiporefeperso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoRefePersoLogicAdditional.updateTipoRefePersoToSave(tiporefeperso,this.arrDatoGeneral);
			
TipoRefePersoDataAccess.save(tiporefeperso, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(ReferenciaPersonal referenciapersonal:tiporefeperso.getReferenciaPersonals()) {
			referenciapersonal.setidvalorclientereferenciapersonal(tiporefeperso.getId());
			ReferenciaPersonalDataAccess.save(referenciapersonal,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(ReferenciaPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaPersonal referenciapersonal:tiporefeperso.getReferenciaPersonals()) {
					referenciapersonal.setidvalorclientereferenciapersonal(tiporefeperso.getId());
					ReferenciaPersonalDataAccess.save(referenciapersonal,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(ReferenciaPersonal referenciapersonal:tiporefeperso.getReferenciaPersonals()) {
			ReferenciaPersonalLogic referenciapersonalLogic= new ReferenciaPersonalLogic(connexion);
			referenciapersonal.setidvalorclientereferenciapersonal(tiporefeperso.getId());
			ReferenciaPersonalDataAccess.save(referenciapersonal,connexion);
			referenciapersonalLogic.deepSave(referenciapersonal,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(ReferenciaPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaPersonal referenciapersonal:tiporefeperso.getReferenciaPersonals()) {
					ReferenciaPersonalLogic referenciapersonalLogic= new ReferenciaPersonalLogic(connexion);
					referenciapersonal.setidvalorclientereferenciapersonal(tiporefeperso.getId());
					ReferenciaPersonalDataAccess.save(referenciapersonal,connexion);
					referenciapersonalLogic.deepSave(referenciapersonal,isDeep,deepLoadType,clases);
				}
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
			this.getNewConnexionToDeep(TipoRefePerso.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiporefeperso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(tiporefeperso);
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
			this.deepLoad(this.tiporefeperso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefeperso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoRefePerso.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiporefepersos!=null) {
				for(TipoRefePerso tiporefeperso:tiporefepersos) {
					this.deepLoad(tiporefeperso,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(tiporefepersos);
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
			if(tiporefepersos!=null) {
				for(TipoRefePerso tiporefeperso:tiporefepersos) {
					this.deepLoad(tiporefeperso,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(tiporefepersos);
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
			this.getNewConnexionToDeep(TipoRefePerso.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiporefeperso,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoRefePerso.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiporefepersos!=null) {
				for(TipoRefePerso tiporefeperso:tiporefepersos) {
					this.deepSave(tiporefeperso,isDeep,deepLoadType,clases);
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
			if(tiporefepersos!=null) {
				for(TipoRefePerso tiporefeperso:tiporefepersos) {
					this.deepSave(tiporefeperso,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoRefePersosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoRefePersoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporefepersos=tiporefepersoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRefePersosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoRefePersoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporefepersos=tiporefepersoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoRefePersosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRefePerso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoRefePersoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporefepersos=tiporefepersoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRefePersosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoRefePersoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoRefePersoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporefepersos=tiporefepersoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRefePersoConstantesFunciones.refrescarForeignKeysDescripcionesTipoRefePerso(this.tiporefepersos);
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
			if(TipoRefePersoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRefePersoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoRefePerso tiporefeperso,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoRefePersoConstantesFunciones.ISCONAUDITORIA) {
				if(tiporefeperso.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRefePersoDataAccess.TABLENAME, tiporefeperso.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRefePersoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRefePersoLogic.registrarAuditoriaDetallesTipoRefePerso(connexion,tiporefeperso,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiporefeperso.getIsDeleted()) {
					/*if(!tiporefeperso.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoRefePersoDataAccess.TABLENAME, tiporefeperso.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoRefePersoLogic.registrarAuditoriaDetallesTipoRefePerso(connexion,tiporefeperso,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRefePersoDataAccess.TABLENAME, tiporefeperso.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiporefeperso.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRefePersoDataAccess.TABLENAME, tiporefeperso.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRefePersoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRefePersoLogic.registrarAuditoriaDetallesTipoRefePerso(connexion,tiporefeperso,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoRefePerso(Connexion connexion,TipoRefePerso tiporefeperso)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiporefeperso.getIsNew()||!tiporefeperso.getcodigo().equals(tiporefeperso.getTipoRefePersoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporefeperso.getTipoRefePersoOriginal().getcodigo()!=null)
				{
					strValorActual=tiporefeperso.getTipoRefePersoOriginal().getcodigo();
				}
				if(tiporefeperso.getcodigo()!=null)
				{
					strValorNuevo=tiporefeperso.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRefePersoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiporefeperso.getIsNew()||!tiporefeperso.getnombre().equals(tiporefeperso.getTipoRefePersoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporefeperso.getTipoRefePersoOriginal().getnombre()!=null)
				{
					strValorActual=tiporefeperso.getTipoRefePersoOriginal().getnombre();
				}
				if(tiporefeperso.getnombre()!=null)
				{
					strValorNuevo=tiporefeperso.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRefePersoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoRefePersoRelacionesWithConnection(TipoRefePerso tiporefeperso,List<ReferenciaPersonal> referenciapersonals) throws Exception {

		if(!tiporefeperso.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRefePersoRelacionesBase(tiporefeperso,referenciapersonals,true);
		}
	}

	public void saveTipoRefePersoRelaciones(TipoRefePerso tiporefeperso,List<ReferenciaPersonal> referenciapersonals)throws Exception {

		if(!tiporefeperso.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRefePersoRelacionesBase(tiporefeperso,referenciapersonals,false);
		}
	}

	public void saveTipoRefePersoRelacionesBase(TipoRefePerso tiporefeperso,List<ReferenciaPersonal> referenciapersonals,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoRefePerso-saveRelacionesWithConnection");}
	
			tiporefeperso.setReferenciaPersonals(referenciapersonals);

			this.setTipoRefePerso(tiporefeperso);

				if((tiporefeperso.getIsNew()||tiporefeperso.getIsChanged())&&!tiporefeperso.getIsDeleted()) {
					this.saveTipoRefePerso();
					this.saveTipoRefePersoRelacionesDetalles(referenciapersonals);

				} else if(tiporefeperso.getIsDeleted()) {
					this.saveTipoRefePersoRelacionesDetalles(referenciapersonals);
					this.saveTipoRefePerso();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ReferenciaPersonalConstantesFunciones.InicializarGeneralEntityAuxiliaresReferenciaPersonals(referenciapersonals,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoRefePersoRelacionesDetalles(List<ReferenciaPersonal> referenciapersonals)throws Exception {
		try {
	

			Long idTipoRefePersoActual=this.getTipoRefePerso().getId();

			ReferenciaPersonalLogic referenciapersonalLogic_Desde_TipoRefePerso=new ReferenciaPersonalLogic();
			referenciapersonalLogic_Desde_TipoRefePerso.setReferenciaPersonals(referenciapersonals);

			referenciapersonalLogic_Desde_TipoRefePerso.setConnexion(this.getConnexion());
			referenciapersonalLogic_Desde_TipoRefePerso.setDatosCliente(this.datosCliente);

			for(ReferenciaPersonal referenciapersonal_Desde_TipoRefePerso:referenciapersonalLogic_Desde_TipoRefePerso.getReferenciaPersonals()) {
				referenciapersonal_Desde_TipoRefePerso.setidvalorclientereferenciapersonal(idTipoRefePersoActual);
			}

			referenciapersonalLogic_Desde_TipoRefePerso.saveReferenciaPersonals();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRefePerso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRefePersoConstantesFunciones.getClassesForeignKeysOfTipoRefePerso(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRefePerso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRefePersoConstantesFunciones.getClassesRelationshipsOfTipoRefePerso(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

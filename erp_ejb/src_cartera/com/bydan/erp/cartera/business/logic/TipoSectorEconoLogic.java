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
import com.bydan.erp.cartera.util.TipoSectorEconoConstantesFunciones;
import com.bydan.erp.cartera.util.TipoSectorEconoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoSectorEconoParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoSectorEcono;
import com.bydan.erp.cartera.business.logic.TipoSectorEconoLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoSectorEconoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoSectorEconoLogic.class);
	
	protected TipoSectorEconoDataAccess tiposectoreconoDataAccess; 	
	protected TipoSectorEcono tiposectorecono;
	protected List<TipoSectorEcono> tiposectoreconos;
	protected Object tiposectoreconoObject;	
	protected List<Object> tiposectoreconosObject;
	
	public static ClassValidator<TipoSectorEcono> tiposectoreconoValidator = new ClassValidator<TipoSectorEcono>(TipoSectorEcono.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoSectorEconoLogicAdditional tiposectoreconoLogicAdditional=null;
	
	public TipoSectorEconoLogicAdditional getTipoSectorEconoLogicAdditional() {
		return this.tiposectoreconoLogicAdditional;
	}
	
	public void setTipoSectorEconoLogicAdditional(TipoSectorEconoLogicAdditional tiposectoreconoLogicAdditional) {
		try {
			this.tiposectoreconoLogicAdditional=tiposectoreconoLogicAdditional;
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
	
	
	
	
	public  TipoSectorEconoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiposectoreconoDataAccess = new TipoSectorEconoDataAccess();
			
			this.tiposectoreconos= new ArrayList<TipoSectorEcono>();
			this.tiposectorecono= new TipoSectorEcono();
			
			this.tiposectoreconoObject=new Object();
			this.tiposectoreconosObject=new ArrayList<Object>();
				
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
			
			this.tiposectoreconoDataAccess.setConnexionType(this.connexionType);
			this.tiposectoreconoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoSectorEconoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiposectoreconoDataAccess = new TipoSectorEconoDataAccess();
			this.tiposectoreconos= new ArrayList<TipoSectorEcono>();
			this.tiposectorecono= new TipoSectorEcono();
			this.tiposectoreconoObject=new Object();
			this.tiposectoreconosObject=new ArrayList<Object>();
			
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
			
			this.tiposectoreconoDataAccess.setConnexionType(this.connexionType);
			this.tiposectoreconoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoSectorEcono getTipoSectorEcono() throws Exception {	
		TipoSectorEconoLogicAdditional.checkTipoSectorEconoToGet(tiposectorecono,this.datosCliente,this.arrDatoGeneral);
		TipoSectorEconoLogicAdditional.updateTipoSectorEconoToGet(tiposectorecono,this.arrDatoGeneral);
		
		return tiposectorecono;
	}
		
	public void setTipoSectorEcono(TipoSectorEcono newTipoSectorEcono) {
		this.tiposectorecono = newTipoSectorEcono;
	}
	
	public TipoSectorEconoDataAccess getTipoSectorEconoDataAccess() {
		return tiposectoreconoDataAccess;
	}
	
	public void setTipoSectorEconoDataAccess(TipoSectorEconoDataAccess newtiposectoreconoDataAccess) {
		this.tiposectoreconoDataAccess = newtiposectoreconoDataAccess;
	}
	
	public List<TipoSectorEcono> getTipoSectorEconos() throws Exception {		
		this.quitarTipoSectorEconosNulos();
		
		TipoSectorEconoLogicAdditional.checkTipoSectorEconoToGets(tiposectoreconos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoSectorEcono tiposectoreconoLocal: tiposectoreconos ) {
			TipoSectorEconoLogicAdditional.updateTipoSectorEconoToGet(tiposectoreconoLocal,this.arrDatoGeneral);
		}
		
		return tiposectoreconos;
	}
	
	public void setTipoSectorEconos(List<TipoSectorEcono> newTipoSectorEconos) {
		this.tiposectoreconos = newTipoSectorEconos;
	}
	
	public Object getTipoSectorEconoObject() {	
		this.tiposectoreconoObject=this.tiposectoreconoDataAccess.getEntityObject();
		return this.tiposectoreconoObject;
	}
		
	public void setTipoSectorEconoObject(Object newTipoSectorEconoObject) {
		this.tiposectoreconoObject = newTipoSectorEconoObject;
	}
	
	public List<Object> getTipoSectorEconosObject() {		
		this.tiposectoreconosObject=this.tiposectoreconoDataAccess.getEntitiesObject();
		return this.tiposectoreconosObject;
	}
		
	public void setTipoSectorEconosObject(List<Object> newTipoSectorEconosObject) {
		this.tiposectoreconosObject = newTipoSectorEconosObject;
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
		
		if(this.tiposectoreconoDataAccess!=null) {
			this.tiposectoreconoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiposectoreconoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiposectoreconoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiposectorecono = new  TipoSectorEcono();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiposectorecono=tiposectoreconoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiposectorecono,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectorecono);
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
		tiposectorecono = new  TipoSectorEcono();
		  		  
        try {
			
			tiposectorecono=tiposectoreconoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiposectorecono,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectorecono);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiposectorecono = new  TipoSectorEcono();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiposectorecono=tiposectoreconoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiposectorecono,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectorecono);
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
		tiposectorecono = new  TipoSectorEcono();
		  		  
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
		tiposectorecono = new  TipoSectorEcono();
		  		  
        try {
			
			tiposectorecono=tiposectoreconoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiposectorecono,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectorecono);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiposectorecono = new  TipoSectorEcono();
		  		  
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
		tiposectorecono = new  TipoSectorEcono();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiposectoreconoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiposectorecono = new  TipoSectorEcono();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiposectoreconoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiposectorecono = new  TipoSectorEcono();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiposectoreconoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiposectorecono = new  TipoSectorEcono();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiposectoreconoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiposectorecono = new  TipoSectorEcono();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiposectoreconoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiposectorecono = new  TipoSectorEcono();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiposectoreconoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiposectoreconos = new  ArrayList<TipoSectorEcono>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSectorEcono(tiposectoreconos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
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
		tiposectoreconos = new  ArrayList<TipoSectorEcono>();
		  		  
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
		tiposectoreconos = new  ArrayList<TipoSectorEcono>();
		  		  
        try {			
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoSectorEcono(tiposectoreconos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiposectoreconos = new  ArrayList<TipoSectorEcono>();
		  		  
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
		tiposectoreconos = new  ArrayList<TipoSectorEcono>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSectorEcono(tiposectoreconos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
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
		tiposectoreconos = new  ArrayList<TipoSectorEcono>();
		  		  
        try {
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSectorEcono(tiposectoreconos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
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
		tiposectoreconos = new  ArrayList<TipoSectorEcono>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoSectorEcono(tiposectoreconos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
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
		tiposectoreconos = new  ArrayList<TipoSectorEcono>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoSectorEcono(tiposectoreconos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiposectorecono = new  TipoSectorEcono();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposectorecono=tiposectoreconoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoSectorEcono(tiposectorecono);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectorecono);
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
		tiposectorecono = new  TipoSectorEcono();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposectorecono=tiposectoreconoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoSectorEcono(tiposectorecono);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectorecono);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiposectoreconos = new  ArrayList<TipoSectorEcono>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposectoreconos=tiposectoreconoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSectorEcono(tiposectoreconos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
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
		tiposectoreconos = new  ArrayList<TipoSectorEcono>();
		  		  
        try {
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposectoreconos=tiposectoreconoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSectorEcono(tiposectoreconos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoSectorEconosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiposectoreconos = new  ArrayList<TipoSectorEcono>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getTodosTipoSectorEconosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoSectorEcono(tiposectoreconos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
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
	
	public  void  getTodosTipoSectorEconos(String sFinalQuery,Pagination pagination)throws Exception {
		tiposectoreconos = new  ArrayList<TipoSectorEcono>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoSectorEcono(tiposectoreconos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoSectorEcono(TipoSectorEcono tiposectorecono) throws Exception {
		Boolean estaValidado=false;
		
		if(tiposectorecono.getIsNew() || tiposectorecono.getIsChanged()) { 
			this.invalidValues = tiposectoreconoValidator.getInvalidValues(tiposectorecono);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiposectorecono);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoSectorEcono(List<TipoSectorEcono> TipoSectorEconos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoSectorEcono tiposectoreconoLocal:tiposectoreconos) {				
			estaValidadoObjeto=this.validarGuardarTipoSectorEcono(tiposectoreconoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoSectorEcono(List<TipoSectorEcono> TipoSectorEconos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoSectorEcono(tiposectoreconos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoSectorEcono(TipoSectorEcono TipoSectorEcono) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoSectorEcono(tiposectorecono)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoSectorEcono tiposectorecono) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiposectorecono.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoSectorEconoConstantesFunciones.getTipoSectorEconoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiposectorecono","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoSectorEconoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoSectorEconoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoSectorEconoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-saveTipoSectorEconoWithConnection");connexion.begin();			
			
			TipoSectorEconoLogicAdditional.checkTipoSectorEconoToSave(this.tiposectorecono,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoSectorEconoLogicAdditional.updateTipoSectorEconoToSave(this.tiposectorecono,this.arrDatoGeneral);
			
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiposectorecono,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoSectorEcono();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoSectorEcono(this.tiposectorecono)) {
				TipoSectorEconoDataAccess.save(this.tiposectorecono, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiposectorecono,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoSectorEconoLogicAdditional.checkTipoSectorEconoToSaveAfter(this.tiposectorecono,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoSectorEcono();
			
			connexion.commit();			
			
			if(this.tiposectorecono.getIsDeleted()) {
				this.tiposectorecono=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoSectorEcono()throws Exception {	
		try {	
			
			TipoSectorEconoLogicAdditional.checkTipoSectorEconoToSave(this.tiposectorecono,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoSectorEconoLogicAdditional.updateTipoSectorEconoToSave(this.tiposectorecono,this.arrDatoGeneral);
			
			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiposectorecono,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoSectorEcono(this.tiposectorecono)) {			
				TipoSectorEconoDataAccess.save(this.tiposectorecono, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiposectorecono,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoSectorEconoLogicAdditional.checkTipoSectorEconoToSaveAfter(this.tiposectorecono,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiposectorecono.getIsDeleted()) {
				this.tiposectorecono=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoSectorEconosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-saveTipoSectorEconosWithConnection");connexion.begin();			
			
			TipoSectorEconoLogicAdditional.checkTipoSectorEconoToSaves(tiposectoreconos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoSectorEconos();
			
			Boolean validadoTodosTipoSectorEcono=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoSectorEcono tiposectoreconoLocal:tiposectoreconos) {		
				if(tiposectoreconoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoSectorEconoLogicAdditional.updateTipoSectorEconoToSave(tiposectoreconoLocal,this.arrDatoGeneral);
	        	
				TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiposectoreconoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoSectorEcono(tiposectoreconoLocal)) {
					TipoSectorEconoDataAccess.save(tiposectoreconoLocal, connexion);				
				} else {
					validadoTodosTipoSectorEcono=false;
				}
			}
			
			if(!validadoTodosTipoSectorEcono) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoSectorEconoLogicAdditional.checkTipoSectorEconoToSavesAfter(tiposectoreconos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoSectorEconos();
			
			connexion.commit();		
			
			this.quitarTipoSectorEconosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoSectorEconos()throws Exception {				
		 try {	
			TipoSectorEconoLogicAdditional.checkTipoSectorEconoToSaves(tiposectoreconos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoSectorEcono=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoSectorEcono tiposectoreconoLocal:tiposectoreconos) {				
				if(tiposectoreconoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoSectorEconoLogicAdditional.updateTipoSectorEconoToSave(tiposectoreconoLocal,this.arrDatoGeneral);
	        	
				TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiposectoreconoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoSectorEcono(tiposectoreconoLocal)) {				
					TipoSectorEconoDataAccess.save(tiposectoreconoLocal, connexion);				
				} else {
					validadoTodosTipoSectorEcono=false;
				}
			}
			
			if(!validadoTodosTipoSectorEcono) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoSectorEconoLogicAdditional.checkTipoSectorEconoToSavesAfter(tiposectoreconos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoSectorEconosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoSectorEconoParameterReturnGeneral procesarAccionTipoSectorEconos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoSectorEcono> tiposectoreconos,TipoSectorEconoParameterReturnGeneral tiposectoreconoParameterGeneral)throws Exception {
		 try {	
			TipoSectorEconoParameterReturnGeneral tiposectoreconoReturnGeneral=new TipoSectorEconoParameterReturnGeneral();
	
			TipoSectorEconoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiposectoreconos,tiposectoreconoParameterGeneral,tiposectoreconoReturnGeneral);
			
			return tiposectoreconoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoSectorEconoParameterReturnGeneral procesarAccionTipoSectorEconosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoSectorEcono> tiposectoreconos,TipoSectorEconoParameterReturnGeneral tiposectoreconoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-procesarAccionTipoSectorEconosWithConnection");connexion.begin();			
			
			TipoSectorEconoParameterReturnGeneral tiposectoreconoReturnGeneral=new TipoSectorEconoParameterReturnGeneral();
	
			TipoSectorEconoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiposectoreconos,tiposectoreconoParameterGeneral,tiposectoreconoReturnGeneral);
			
			this.connexion.commit();
			
			return tiposectoreconoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoSectorEconoParameterReturnGeneral procesarEventosTipoSectorEconos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoSectorEcono> tiposectoreconos,TipoSectorEcono tiposectorecono,TipoSectorEconoParameterReturnGeneral tiposectoreconoParameterGeneral,Boolean isEsNuevoTipoSectorEcono,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoSectorEconoParameterReturnGeneral tiposectoreconoReturnGeneral=new TipoSectorEconoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiposectoreconoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoSectorEconoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiposectoreconos,tiposectorecono,tiposectoreconoParameterGeneral,tiposectoreconoReturnGeneral,isEsNuevoTipoSectorEcono,clases);
			
			return tiposectoreconoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoSectorEconoParameterReturnGeneral procesarEventosTipoSectorEconosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoSectorEcono> tiposectoreconos,TipoSectorEcono tiposectorecono,TipoSectorEconoParameterReturnGeneral tiposectoreconoParameterGeneral,Boolean isEsNuevoTipoSectorEcono,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-procesarEventosTipoSectorEconosWithConnection");connexion.begin();			
			
			TipoSectorEconoParameterReturnGeneral tiposectoreconoReturnGeneral=new TipoSectorEconoParameterReturnGeneral();
	
			tiposectoreconoReturnGeneral.setTipoSectorEcono(tiposectorecono);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiposectoreconoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoSectorEconoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiposectoreconos,tiposectorecono,tiposectoreconoParameterGeneral,tiposectoreconoReturnGeneral,isEsNuevoTipoSectorEcono,clases);
			
			this.connexion.commit();
			
			return tiposectoreconoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoSectorEconoParameterReturnGeneral procesarImportacionTipoSectorEconosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoSectorEconoParameterReturnGeneral tiposectoreconoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-procesarImportacionTipoSectorEconosWithConnection");connexion.begin();			
			
			TipoSectorEconoParameterReturnGeneral tiposectoreconoReturnGeneral=new TipoSectorEconoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiposectoreconos=new ArrayList<TipoSectorEcono>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiposectorecono=new TipoSectorEcono();
				
				
				if(conColumnasBase) {this.tiposectorecono.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiposectorecono.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiposectorecono.setcodigo(arrColumnas[iColumn++]);
				this.tiposectorecono.setnombre(arrColumnas[iColumn++]);
				
				this.tiposectoreconos.add(this.tiposectorecono);
			}
			
			this.saveTipoSectorEconos();
			
			this.connexion.commit();
			
			tiposectoreconoReturnGeneral.setConRetornoEstaProcesado(true);
			tiposectoreconoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiposectoreconoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoSectorEconosEliminados() throws Exception {				
		
		List<TipoSectorEcono> tiposectoreconosAux= new ArrayList<TipoSectorEcono>();
		
		for(TipoSectorEcono tiposectorecono:tiposectoreconos) {
			if(!tiposectorecono.getIsDeleted()) {
				tiposectoreconosAux.add(tiposectorecono);
			}
		}
		
		tiposectoreconos=tiposectoreconosAux;
	}
	
	public void quitarTipoSectorEconosNulos() throws Exception {				
		
		List<TipoSectorEcono> tiposectoreconosAux= new ArrayList<TipoSectorEcono>();
		
		for(TipoSectorEcono tiposectorecono : this.tiposectoreconos) {
			if(tiposectorecono==null) {
				tiposectoreconosAux.add(tiposectorecono);
			}
		}
		
		//this.tiposectoreconos=tiposectoreconosAux;
		
		this.tiposectoreconos.removeAll(tiposectoreconosAux);
	}
	
	public void getSetVersionRowTipoSectorEconoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiposectorecono.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiposectorecono.getIsDeleted() || (tiposectorecono.getIsChanged()&&!tiposectorecono.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiposectoreconoDataAccess.getSetVersionRowTipoSectorEcono(connexion,tiposectorecono.getId());
				
				if(!tiposectorecono.getVersionRow().equals(timestamp)) {	
					tiposectorecono.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiposectorecono.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoSectorEcono()throws Exception {	
		
		if(tiposectorecono.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiposectorecono.getIsDeleted() || (tiposectorecono.getIsChanged()&&!tiposectorecono.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiposectoreconoDataAccess.getSetVersionRowTipoSectorEcono(connexion,tiposectorecono.getId());
			
			try {							
				if(!tiposectorecono.getVersionRow().equals(timestamp)) {	
					tiposectorecono.setVersionRow(timestamp);
				}
				
				tiposectorecono.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoSectorEconosWithConnection()throws Exception {	
		if(tiposectoreconos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoSectorEcono tiposectoreconoAux:tiposectoreconos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiposectoreconoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiposectoreconoAux.getIsDeleted() || (tiposectoreconoAux.getIsChanged()&&!tiposectoreconoAux.getIsNew())) {
						
						timestamp=tiposectoreconoDataAccess.getSetVersionRowTipoSectorEcono(connexion,tiposectoreconoAux.getId());
						
						if(!tiposectorecono.getVersionRow().equals(timestamp)) {	
							tiposectoreconoAux.setVersionRow(timestamp);
						}
								
						tiposectoreconoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoSectorEconos()throws Exception {	
		if(tiposectoreconos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoSectorEcono tiposectoreconoAux:tiposectoreconos) {
					if(tiposectoreconoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiposectoreconoAux.getIsDeleted() || (tiposectoreconoAux.getIsChanged()&&!tiposectoreconoAux.getIsNew())) {
						
						timestamp=tiposectoreconoDataAccess.getSetVersionRowTipoSectorEcono(connexion,tiposectoreconoAux.getId());
						
						if(!tiposectoreconoAux.getVersionRow().equals(timestamp)) {	
							tiposectoreconoAux.setVersionRow(timestamp);
						}
						
													
						tiposectoreconoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoSectorEconoParameterReturnGeneral cargarCombosLoteForeignKeyTipoSectorEconoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoSectorEconoParameterReturnGeneral  tiposectoreconoReturnGeneral =new TipoSectorEconoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoSectorEconoWithConnection");connexion.begin();
			
			tiposectoreconoReturnGeneral =new TipoSectorEconoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiposectoreconoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tiposectoreconoReturnGeneral;
	}
	
	public TipoSectorEconoParameterReturnGeneral cargarCombosLoteForeignKeyTipoSectorEcono(String finalQueryGlobalEmpresa) throws Exception {
		TipoSectorEconoParameterReturnGeneral  tiposectoreconoReturnGeneral =new TipoSectorEconoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tiposectoreconoReturnGeneral =new TipoSectorEconoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiposectoreconoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tiposectoreconoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoSectorEconoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ReferenciaComercialLogic referenciacomercialLogic=new ReferenciaComercialLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoSectorEconoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ReferenciaComercial.class));
											
			

			referenciacomercialLogic.setConnexion(this.getConnexion());
			referenciacomercialLogic.setDatosCliente(this.datosCliente);
			referenciacomercialLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoSectorEcono tiposectorecono:this.tiposectoreconos) {
				

				classes=new ArrayList<Classe>();
				classes=ReferenciaComercialConstantesFunciones.getClassesForeignKeysOfReferenciaComercial(new ArrayList<Classe>(),DeepLoadType.NONE);

				referenciacomercialLogic.setReferenciaComercials(tiposectorecono.referenciacomercials);
				referenciacomercialLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoSectorEcono tiposectorecono,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoSectorEconoLogicAdditional.updateTipoSectorEconoToGet(tiposectorecono,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiposectorecono.setEmpresa(tiposectoreconoDataAccess.getEmpresa(connexion,tiposectorecono));
		tiposectorecono.setReferenciaComercials(tiposectoreconoDataAccess.getReferenciaComercials(connexion,tiposectorecono));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiposectorecono.setEmpresa(tiposectoreconoDataAccess.getEmpresa(connexion,tiposectorecono));
				continue;
			}

			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiposectorecono.setReferenciaComercials(tiposectoreconoDataAccess.getReferenciaComercials(connexion,tiposectorecono));

				if(this.isConDeep) {
					ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(this.connexion);
					referenciacomercialLogic.setReferenciaComercials(tiposectorecono.getReferenciaComercials());
					ArrayList<Classe> classesLocal=ReferenciaComercialConstantesFunciones.getClassesForeignKeysOfReferenciaComercial(new ArrayList<Classe>(),DeepLoadType.NONE);
					referenciacomercialLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(referenciacomercialLogic.getReferenciaComercials());
					tiposectorecono.setReferenciaComercials(referenciacomercialLogic.getReferenciaComercials());
				}

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
			tiposectorecono.setEmpresa(tiposectoreconoDataAccess.getEmpresa(connexion,tiposectorecono));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaComercial.class));
			tiposectorecono.setReferenciaComercials(tiposectoreconoDataAccess.getReferenciaComercials(connexion,tiposectorecono));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiposectorecono.setEmpresa(tiposectoreconoDataAccess.getEmpresa(connexion,tiposectorecono));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiposectorecono.getEmpresa(),isDeep,deepLoadType,clases);
				

		tiposectorecono.setReferenciaComercials(tiposectoreconoDataAccess.getReferenciaComercials(connexion,tiposectorecono));

		for(ReferenciaComercial referenciacomercial:tiposectorecono.getReferenciaComercials()) {
			ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
			referenciacomercialLogic.deepLoad(referenciacomercial,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiposectorecono.setEmpresa(tiposectoreconoDataAccess.getEmpresa(connexion,tiposectorecono));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tiposectorecono.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiposectorecono.setReferenciaComercials(tiposectoreconoDataAccess.getReferenciaComercials(connexion,tiposectorecono));

				for(ReferenciaComercial referenciacomercial:tiposectorecono.getReferenciaComercials()) {
					ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
					referenciacomercialLogic.deepLoad(referenciacomercial,isDeep,deepLoadType,clases);
				}
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
			tiposectorecono.setEmpresa(tiposectoreconoDataAccess.getEmpresa(connexion,tiposectorecono));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tiposectorecono.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaComercial.class));
			tiposectorecono.setReferenciaComercials(tiposectoreconoDataAccess.getReferenciaComercials(connexion,tiposectorecono));

			for(ReferenciaComercial referenciacomercial:tiposectorecono.getReferenciaComercials()) {
				ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
				referenciacomercialLogic.deepLoad(referenciacomercial,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoSectorEcono tiposectorecono,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoSectorEconoLogicAdditional.updateTipoSectorEconoToSave(tiposectorecono,this.arrDatoGeneral);
			
TipoSectorEconoDataAccess.save(tiposectorecono, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiposectorecono.getEmpresa(),connexion);

		for(ReferenciaComercial referenciacomercial:tiposectorecono.getReferenciaComercials()) {
			referenciacomercial.setidvalorclientesectoreconomico(tiposectorecono.getId());
			ReferenciaComercialDataAccess.save(referenciacomercial,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiposectorecono.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaComercial referenciacomercial:tiposectorecono.getReferenciaComercials()) {
					referenciacomercial.setidvalorclientesectoreconomico(tiposectorecono.getId());
					ReferenciaComercialDataAccess.save(referenciacomercial,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiposectorecono.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiposectorecono.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(ReferenciaComercial referenciacomercial:tiposectorecono.getReferenciaComercials()) {
			ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
			referenciacomercial.setidvalorclientesectoreconomico(tiposectorecono.getId());
			ReferenciaComercialDataAccess.save(referenciacomercial,connexion);
			referenciacomercialLogic.deepSave(referenciacomercial,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiposectorecono.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tiposectorecono.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaComercial referenciacomercial:tiposectorecono.getReferenciaComercials()) {
					ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
					referenciacomercial.setidvalorclientesectoreconomico(tiposectorecono.getId());
					ReferenciaComercialDataAccess.save(referenciacomercial,connexion);
					referenciacomercialLogic.deepSave(referenciacomercial,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoSectorEcono.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiposectorecono,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(tiposectorecono);
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
			this.deepLoad(this.tiposectorecono,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectorecono);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoSectorEcono.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiposectoreconos!=null) {
				for(TipoSectorEcono tiposectorecono:tiposectoreconos) {
					this.deepLoad(tiposectorecono,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(tiposectoreconos);
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
			if(tiposectoreconos!=null) {
				for(TipoSectorEcono tiposectorecono:tiposectoreconos) {
					this.deepLoad(tiposectorecono,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(tiposectoreconos);
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
			this.getNewConnexionToDeep(TipoSectorEcono.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiposectorecono,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoSectorEcono.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiposectoreconos!=null) {
				for(TipoSectorEcono tiposectorecono:tiposectoreconos) {
					this.deepSave(tiposectorecono,isDeep,deepLoadType,clases);
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
			if(tiposectoreconos!=null) {
				for(TipoSectorEcono tiposectorecono:tiposectoreconos) {
					this.deepSave(tiposectorecono,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoSectorEconosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoSectorEconoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoSectorEconosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoSectorEconoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoSectorEconosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoSectorEconoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoSectorEconosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoSectorEconoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoSectorEconosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSectorEcono.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoSectorEconoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoSectorEconosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoSectorEconoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoSectorEconoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiposectoreconos=tiposectoreconoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoSectorEconoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSectorEcono(this.tiposectoreconos);
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
			if(TipoSectorEconoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoSectorEconoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoSectorEcono tiposectorecono,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoSectorEconoConstantesFunciones.ISCONAUDITORIA) {
				if(tiposectorecono.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoSectorEconoDataAccess.TABLENAME, tiposectorecono.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoSectorEconoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoSectorEconoLogic.registrarAuditoriaDetallesTipoSectorEcono(connexion,tiposectorecono,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiposectorecono.getIsDeleted()) {
					/*if(!tiposectorecono.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoSectorEconoDataAccess.TABLENAME, tiposectorecono.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoSectorEconoLogic.registrarAuditoriaDetallesTipoSectorEcono(connexion,tiposectorecono,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoSectorEconoDataAccess.TABLENAME, tiposectorecono.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiposectorecono.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoSectorEconoDataAccess.TABLENAME, tiposectorecono.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoSectorEconoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoSectorEconoLogic.registrarAuditoriaDetallesTipoSectorEcono(connexion,tiposectorecono,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoSectorEcono(Connexion connexion,TipoSectorEcono tiposectorecono)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiposectorecono.getIsNew()||!tiposectorecono.getid_empresa().equals(tiposectorecono.getTipoSectorEconoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiposectorecono.getTipoSectorEconoOriginal().getid_empresa()!=null)
				{
					strValorActual=tiposectorecono.getTipoSectorEconoOriginal().getid_empresa().toString();
				}
				if(tiposectorecono.getid_empresa()!=null)
				{
					strValorNuevo=tiposectorecono.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoSectorEconoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tiposectorecono.getIsNew()||!tiposectorecono.getcodigo().equals(tiposectorecono.getTipoSectorEconoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiposectorecono.getTipoSectorEconoOriginal().getcodigo()!=null)
				{
					strValorActual=tiposectorecono.getTipoSectorEconoOriginal().getcodigo();
				}
				if(tiposectorecono.getcodigo()!=null)
				{
					strValorNuevo=tiposectorecono.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoSectorEconoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiposectorecono.getIsNew()||!tiposectorecono.getnombre().equals(tiposectorecono.getTipoSectorEconoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiposectorecono.getTipoSectorEconoOriginal().getnombre()!=null)
				{
					strValorActual=tiposectorecono.getTipoSectorEconoOriginal().getnombre();
				}
				if(tiposectorecono.getnombre()!=null)
				{
					strValorNuevo=tiposectorecono.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoSectorEconoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoSectorEconoRelacionesWithConnection(TipoSectorEcono tiposectorecono,List<ReferenciaComercial> referenciacomercials) throws Exception {

		if(!tiposectorecono.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoSectorEconoRelacionesBase(tiposectorecono,referenciacomercials,true);
		}
	}

	public void saveTipoSectorEconoRelaciones(TipoSectorEcono tiposectorecono,List<ReferenciaComercial> referenciacomercials)throws Exception {

		if(!tiposectorecono.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoSectorEconoRelacionesBase(tiposectorecono,referenciacomercials,false);
		}
	}

	public void saveTipoSectorEconoRelacionesBase(TipoSectorEcono tiposectorecono,List<ReferenciaComercial> referenciacomercials,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoSectorEcono-saveRelacionesWithConnection");}
	
			tiposectorecono.setReferenciaComercials(referenciacomercials);

			this.setTipoSectorEcono(tiposectorecono);

			if(TipoSectorEconoLogicAdditional.validarSaveRelaciones(tiposectorecono,this)) {

				TipoSectorEconoLogicAdditional.updateRelacionesToSave(tiposectorecono,this);

				if((tiposectorecono.getIsNew()||tiposectorecono.getIsChanged())&&!tiposectorecono.getIsDeleted()) {
					this.saveTipoSectorEcono();
					this.saveTipoSectorEconoRelacionesDetalles(referenciacomercials);

				} else if(tiposectorecono.getIsDeleted()) {
					this.saveTipoSectorEconoRelacionesDetalles(referenciacomercials);
					this.saveTipoSectorEcono();
				}

				TipoSectorEconoLogicAdditional.updateRelacionesToSaveAfter(tiposectorecono,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ReferenciaComercialConstantesFunciones.InicializarGeneralEntityAuxiliaresReferenciaComercials(referenciacomercials,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoSectorEconoRelacionesDetalles(List<ReferenciaComercial> referenciacomercials)throws Exception {
		try {
	

			Long idTipoSectorEconoActual=this.getTipoSectorEcono().getId();

			ReferenciaComercialLogic referenciacomercialLogic_Desde_TipoSectorEcono=new ReferenciaComercialLogic();
			referenciacomercialLogic_Desde_TipoSectorEcono.setReferenciaComercials(referenciacomercials);

			referenciacomercialLogic_Desde_TipoSectorEcono.setConnexion(this.getConnexion());
			referenciacomercialLogic_Desde_TipoSectorEcono.setDatosCliente(this.datosCliente);

			for(ReferenciaComercial referenciacomercial_Desde_TipoSectorEcono:referenciacomercialLogic_Desde_TipoSectorEcono.getReferenciaComercials()) {
				referenciacomercial_Desde_TipoSectorEcono.setidvalorclientesectoreconomico(idTipoSectorEconoActual);
			}

			referenciacomercialLogic_Desde_TipoSectorEcono.saveReferenciaComercials();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoSectorEcono(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoSectorEconoConstantesFunciones.getClassesForeignKeysOfTipoSectorEcono(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSectorEcono(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoSectorEconoConstantesFunciones.getClassesRelationshipsOfTipoSectorEcono(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

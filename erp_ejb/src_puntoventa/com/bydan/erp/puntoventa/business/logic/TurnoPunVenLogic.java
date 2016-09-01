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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.TurnoPunVenConstantesFunciones;
import com.bydan.erp.puntoventa.util.TurnoPunVenParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TurnoPunVenParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.TurnoPunVen;
import com.bydan.erp.puntoventa.business.logic.TurnoPunVenLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TurnoPunVenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TurnoPunVenLogic.class);
	
	protected TurnoPunVenDataAccess turnopunvenDataAccess; 	
	protected TurnoPunVen turnopunven;
	protected List<TurnoPunVen> turnopunvens;
	protected Object turnopunvenObject;	
	protected List<Object> turnopunvensObject;
	
	public static ClassValidator<TurnoPunVen> turnopunvenValidator = new ClassValidator<TurnoPunVen>(TurnoPunVen.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TurnoPunVenLogicAdditional turnopunvenLogicAdditional=null;
	
	public TurnoPunVenLogicAdditional getTurnoPunVenLogicAdditional() {
		return this.turnopunvenLogicAdditional;
	}
	
	public void setTurnoPunVenLogicAdditional(TurnoPunVenLogicAdditional turnopunvenLogicAdditional) {
		try {
			this.turnopunvenLogicAdditional=turnopunvenLogicAdditional;
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
	
	
	
	
	public  TurnoPunVenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.turnopunvenDataAccess = new TurnoPunVenDataAccess();
			
			this.turnopunvens= new ArrayList<TurnoPunVen>();
			this.turnopunven= new TurnoPunVen();
			
			this.turnopunvenObject=new Object();
			this.turnopunvensObject=new ArrayList<Object>();
				
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
			
			this.turnopunvenDataAccess.setConnexionType(this.connexionType);
			this.turnopunvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TurnoPunVenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.turnopunvenDataAccess = new TurnoPunVenDataAccess();
			this.turnopunvens= new ArrayList<TurnoPunVen>();
			this.turnopunven= new TurnoPunVen();
			this.turnopunvenObject=new Object();
			this.turnopunvensObject=new ArrayList<Object>();
			
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
			
			this.turnopunvenDataAccess.setConnexionType(this.connexionType);
			this.turnopunvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TurnoPunVen getTurnoPunVen() throws Exception {	
		TurnoPunVenLogicAdditional.checkTurnoPunVenToGet(turnopunven,this.datosCliente,this.arrDatoGeneral);
		TurnoPunVenLogicAdditional.updateTurnoPunVenToGet(turnopunven,this.arrDatoGeneral);
		
		return turnopunven;
	}
		
	public void setTurnoPunVen(TurnoPunVen newTurnoPunVen) {
		this.turnopunven = newTurnoPunVen;
	}
	
	public TurnoPunVenDataAccess getTurnoPunVenDataAccess() {
		return turnopunvenDataAccess;
	}
	
	public void setTurnoPunVenDataAccess(TurnoPunVenDataAccess newturnopunvenDataAccess) {
		this.turnopunvenDataAccess = newturnopunvenDataAccess;
	}
	
	public List<TurnoPunVen> getTurnoPunVens() throws Exception {		
		this.quitarTurnoPunVensNulos();
		
		TurnoPunVenLogicAdditional.checkTurnoPunVenToGets(turnopunvens,this.datosCliente,this.arrDatoGeneral);
		
		for (TurnoPunVen turnopunvenLocal: turnopunvens ) {
			TurnoPunVenLogicAdditional.updateTurnoPunVenToGet(turnopunvenLocal,this.arrDatoGeneral);
		}
		
		return turnopunvens;
	}
	
	public void setTurnoPunVens(List<TurnoPunVen> newTurnoPunVens) {
		this.turnopunvens = newTurnoPunVens;
	}
	
	public Object getTurnoPunVenObject() {	
		this.turnopunvenObject=this.turnopunvenDataAccess.getEntityObject();
		return this.turnopunvenObject;
	}
		
	public void setTurnoPunVenObject(Object newTurnoPunVenObject) {
		this.turnopunvenObject = newTurnoPunVenObject;
	}
	
	public List<Object> getTurnoPunVensObject() {		
		this.turnopunvensObject=this.turnopunvenDataAccess.getEntitiesObject();
		return this.turnopunvensObject;
	}
		
	public void setTurnoPunVensObject(List<Object> newTurnoPunVensObject) {
		this.turnopunvensObject = newTurnoPunVensObject;
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
		
		if(this.turnopunvenDataAccess!=null) {
			this.turnopunvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			turnopunvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			turnopunvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		turnopunven = new  TurnoPunVen();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			turnopunven=turnopunvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.turnopunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunven);
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
		turnopunven = new  TurnoPunVen();
		  		  
        try {
			
			turnopunven=turnopunvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.turnopunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		turnopunven = new  TurnoPunVen();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			turnopunven=turnopunvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.turnopunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunven);
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
		turnopunven = new  TurnoPunVen();
		  		  
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
		turnopunven = new  TurnoPunVen();
		  		  
        try {
			
			turnopunven=turnopunvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.turnopunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		turnopunven = new  TurnoPunVen();
		  		  
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
		turnopunven = new  TurnoPunVen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =turnopunvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		turnopunven = new  TurnoPunVen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=turnopunvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		turnopunven = new  TurnoPunVen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =turnopunvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		turnopunven = new  TurnoPunVen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=turnopunvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		turnopunven = new  TurnoPunVen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =turnopunvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		turnopunven = new  TurnoPunVen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=turnopunvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		turnopunvens = new  ArrayList<TurnoPunVen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnopunvens=turnopunvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTurnoPunVen(turnopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
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
		turnopunvens = new  ArrayList<TurnoPunVen>();
		  		  
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
		turnopunvens = new  ArrayList<TurnoPunVen>();
		  		  
        try {			
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnopunvens=turnopunvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTurnoPunVen(turnopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		turnopunvens = new  ArrayList<TurnoPunVen>();
		  		  
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
		turnopunvens = new  ArrayList<TurnoPunVen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnopunvens=turnopunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTurnoPunVen(turnopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
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
		turnopunvens = new  ArrayList<TurnoPunVen>();
		  		  
        try {
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnopunvens=turnopunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTurnoPunVen(turnopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
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
		turnopunvens = new  ArrayList<TurnoPunVen>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnopunvens=turnopunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTurnoPunVen(turnopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
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
		turnopunvens = new  ArrayList<TurnoPunVen>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnopunvens=turnopunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTurnoPunVen(turnopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		turnopunven = new  TurnoPunVen();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnopunven=turnopunvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTurnoPunVen(turnopunven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunven);
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
		turnopunven = new  TurnoPunVen();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnopunven=turnopunvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTurnoPunVen(turnopunven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		turnopunvens = new  ArrayList<TurnoPunVen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnopunvens=turnopunvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTurnoPunVen(turnopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
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
		turnopunvens = new  ArrayList<TurnoPunVen>();
		  		  
        try {
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnopunvens=turnopunvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTurnoPunVen(turnopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTurnoPunVensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		turnopunvens = new  ArrayList<TurnoPunVen>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getTodosTurnoPunVensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnopunvens=turnopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTurnoPunVen(turnopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
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
	
	public  void  getTodosTurnoPunVens(String sFinalQuery,Pagination pagination)throws Exception {
		turnopunvens = new  ArrayList<TurnoPunVen>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnopunvens=turnopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTurnoPunVen(turnopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTurnoPunVen(TurnoPunVen turnopunven) throws Exception {
		Boolean estaValidado=false;
		
		if(turnopunven.getIsNew() || turnopunven.getIsChanged()) { 
			this.invalidValues = turnopunvenValidator.getInvalidValues(turnopunven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(turnopunven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTurnoPunVen(List<TurnoPunVen> TurnoPunVens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TurnoPunVen turnopunvenLocal:turnopunvens) {				
			estaValidadoObjeto=this.validarGuardarTurnoPunVen(turnopunvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTurnoPunVen(List<TurnoPunVen> TurnoPunVens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTurnoPunVen(turnopunvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTurnoPunVen(TurnoPunVen TurnoPunVen) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTurnoPunVen(turnopunven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TurnoPunVen turnopunven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+turnopunven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TurnoPunVenConstantesFunciones.getTurnoPunVenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"turnopunven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TurnoPunVenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TurnoPunVenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTurnoPunVenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-saveTurnoPunVenWithConnection");connexion.begin();			
			
			TurnoPunVenLogicAdditional.checkTurnoPunVenToSave(this.turnopunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TurnoPunVenLogicAdditional.updateTurnoPunVenToSave(this.turnopunven,this.arrDatoGeneral);
			
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.turnopunven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTurnoPunVen();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTurnoPunVen(this.turnopunven)) {
				TurnoPunVenDataAccess.save(this.turnopunven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.turnopunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TurnoPunVenLogicAdditional.checkTurnoPunVenToSaveAfter(this.turnopunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTurnoPunVen();
			
			connexion.commit();			
			
			if(this.turnopunven.getIsDeleted()) {
				this.turnopunven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTurnoPunVen()throws Exception {	
		try {	
			
			TurnoPunVenLogicAdditional.checkTurnoPunVenToSave(this.turnopunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TurnoPunVenLogicAdditional.updateTurnoPunVenToSave(this.turnopunven,this.arrDatoGeneral);
			
			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.turnopunven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTurnoPunVen(this.turnopunven)) {			
				TurnoPunVenDataAccess.save(this.turnopunven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.turnopunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TurnoPunVenLogicAdditional.checkTurnoPunVenToSaveAfter(this.turnopunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.turnopunven.getIsDeleted()) {
				this.turnopunven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTurnoPunVensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-saveTurnoPunVensWithConnection");connexion.begin();			
			
			TurnoPunVenLogicAdditional.checkTurnoPunVenToSaves(turnopunvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTurnoPunVens();
			
			Boolean validadoTodosTurnoPunVen=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TurnoPunVen turnopunvenLocal:turnopunvens) {		
				if(turnopunvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TurnoPunVenLogicAdditional.updateTurnoPunVenToSave(turnopunvenLocal,this.arrDatoGeneral);
	        	
				TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),turnopunvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTurnoPunVen(turnopunvenLocal)) {
					TurnoPunVenDataAccess.save(turnopunvenLocal, connexion);				
				} else {
					validadoTodosTurnoPunVen=false;
				}
			}
			
			if(!validadoTodosTurnoPunVen) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TurnoPunVenLogicAdditional.checkTurnoPunVenToSavesAfter(turnopunvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTurnoPunVens();
			
			connexion.commit();		
			
			this.quitarTurnoPunVensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTurnoPunVens()throws Exception {				
		 try {	
			TurnoPunVenLogicAdditional.checkTurnoPunVenToSaves(turnopunvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTurnoPunVen=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TurnoPunVen turnopunvenLocal:turnopunvens) {				
				if(turnopunvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TurnoPunVenLogicAdditional.updateTurnoPunVenToSave(turnopunvenLocal,this.arrDatoGeneral);
	        	
				TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),turnopunvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTurnoPunVen(turnopunvenLocal)) {				
					TurnoPunVenDataAccess.save(turnopunvenLocal, connexion);				
				} else {
					validadoTodosTurnoPunVen=false;
				}
			}
			
			if(!validadoTodosTurnoPunVen) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TurnoPunVenLogicAdditional.checkTurnoPunVenToSavesAfter(turnopunvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTurnoPunVensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TurnoPunVenParameterReturnGeneral procesarAccionTurnoPunVens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TurnoPunVen> turnopunvens,TurnoPunVenParameterReturnGeneral turnopunvenParameterGeneral)throws Exception {
		 try {	
			TurnoPunVenParameterReturnGeneral turnopunvenReturnGeneral=new TurnoPunVenParameterReturnGeneral();
	
			TurnoPunVenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,turnopunvens,turnopunvenParameterGeneral,turnopunvenReturnGeneral);
			
			return turnopunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TurnoPunVenParameterReturnGeneral procesarAccionTurnoPunVensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TurnoPunVen> turnopunvens,TurnoPunVenParameterReturnGeneral turnopunvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-procesarAccionTurnoPunVensWithConnection");connexion.begin();			
			
			TurnoPunVenParameterReturnGeneral turnopunvenReturnGeneral=new TurnoPunVenParameterReturnGeneral();
	
			TurnoPunVenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,turnopunvens,turnopunvenParameterGeneral,turnopunvenReturnGeneral);
			
			this.connexion.commit();
			
			return turnopunvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TurnoPunVenParameterReturnGeneral procesarEventosTurnoPunVens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TurnoPunVen> turnopunvens,TurnoPunVen turnopunven,TurnoPunVenParameterReturnGeneral turnopunvenParameterGeneral,Boolean isEsNuevoTurnoPunVen,ArrayList<Classe> clases)throws Exception {
		 try {	
			TurnoPunVenParameterReturnGeneral turnopunvenReturnGeneral=new TurnoPunVenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				turnopunvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TurnoPunVenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,turnopunvens,turnopunven,turnopunvenParameterGeneral,turnopunvenReturnGeneral,isEsNuevoTurnoPunVen,clases);
			
			return turnopunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TurnoPunVenParameterReturnGeneral procesarEventosTurnoPunVensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TurnoPunVen> turnopunvens,TurnoPunVen turnopunven,TurnoPunVenParameterReturnGeneral turnopunvenParameterGeneral,Boolean isEsNuevoTurnoPunVen,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-procesarEventosTurnoPunVensWithConnection");connexion.begin();			
			
			TurnoPunVenParameterReturnGeneral turnopunvenReturnGeneral=new TurnoPunVenParameterReturnGeneral();
	
			turnopunvenReturnGeneral.setTurnoPunVen(turnopunven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				turnopunvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TurnoPunVenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,turnopunvens,turnopunven,turnopunvenParameterGeneral,turnopunvenReturnGeneral,isEsNuevoTurnoPunVen,clases);
			
			this.connexion.commit();
			
			return turnopunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TurnoPunVenParameterReturnGeneral procesarImportacionTurnoPunVensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TurnoPunVenParameterReturnGeneral turnopunvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-procesarImportacionTurnoPunVensWithConnection");connexion.begin();			
			
			TurnoPunVenParameterReturnGeneral turnopunvenReturnGeneral=new TurnoPunVenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.turnopunvens=new ArrayList<TurnoPunVen>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.turnopunven=new TurnoPunVen();
				
				
				if(conColumnasBase) {this.turnopunven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.turnopunven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.turnopunven.setnombre(arrColumnas[iColumn++]);
				//this.turnopunven.sethora_inicio(arrColumnas[iColumn++]);
				//this.turnopunven.sethora_fin(arrColumnas[iColumn++]);
				
				this.turnopunvens.add(this.turnopunven);
			}
			
			this.saveTurnoPunVens();
			
			this.connexion.commit();
			
			turnopunvenReturnGeneral.setConRetornoEstaProcesado(true);
			turnopunvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return turnopunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTurnoPunVensEliminados() throws Exception {				
		
		List<TurnoPunVen> turnopunvensAux= new ArrayList<TurnoPunVen>();
		
		for(TurnoPunVen turnopunven:turnopunvens) {
			if(!turnopunven.getIsDeleted()) {
				turnopunvensAux.add(turnopunven);
			}
		}
		
		turnopunvens=turnopunvensAux;
	}
	
	public void quitarTurnoPunVensNulos() throws Exception {				
		
		List<TurnoPunVen> turnopunvensAux= new ArrayList<TurnoPunVen>();
		
		for(TurnoPunVen turnopunven : this.turnopunvens) {
			if(turnopunven==null) {
				turnopunvensAux.add(turnopunven);
			}
		}
		
		//this.turnopunvens=turnopunvensAux;
		
		this.turnopunvens.removeAll(turnopunvensAux);
	}
	
	public void getSetVersionRowTurnoPunVenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(turnopunven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((turnopunven.getIsDeleted() || (turnopunven.getIsChanged()&&!turnopunven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=turnopunvenDataAccess.getSetVersionRowTurnoPunVen(connexion,turnopunven.getId());
				
				if(!turnopunven.getVersionRow().equals(timestamp)) {	
					turnopunven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				turnopunven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTurnoPunVen()throws Exception {	
		
		if(turnopunven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((turnopunven.getIsDeleted() || (turnopunven.getIsChanged()&&!turnopunven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=turnopunvenDataAccess.getSetVersionRowTurnoPunVen(connexion,turnopunven.getId());
			
			try {							
				if(!turnopunven.getVersionRow().equals(timestamp)) {	
					turnopunven.setVersionRow(timestamp);
				}
				
				turnopunven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTurnoPunVensWithConnection()throws Exception {	
		if(turnopunvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TurnoPunVen turnopunvenAux:turnopunvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(turnopunvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(turnopunvenAux.getIsDeleted() || (turnopunvenAux.getIsChanged()&&!turnopunvenAux.getIsNew())) {
						
						timestamp=turnopunvenDataAccess.getSetVersionRowTurnoPunVen(connexion,turnopunvenAux.getId());
						
						if(!turnopunven.getVersionRow().equals(timestamp)) {	
							turnopunvenAux.setVersionRow(timestamp);
						}
								
						turnopunvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTurnoPunVens()throws Exception {	
		if(turnopunvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TurnoPunVen turnopunvenAux:turnopunvens) {
					if(turnopunvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(turnopunvenAux.getIsDeleted() || (turnopunvenAux.getIsChanged()&&!turnopunvenAux.getIsNew())) {
						
						timestamp=turnopunvenDataAccess.getSetVersionRowTurnoPunVen(connexion,turnopunvenAux.getId());
						
						if(!turnopunvenAux.getVersionRow().equals(timestamp)) {	
							turnopunvenAux.setVersionRow(timestamp);
						}
						
													
						turnopunvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TurnoPunVenParameterReturnGeneral cargarCombosLoteForeignKeyTurnoPunVenWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario) throws Exception {
		TurnoPunVenParameterReturnGeneral  turnopunvenReturnGeneral =new TurnoPunVenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-cargarCombosLoteForeignKeyTurnoPunVenWithConnection");connexion.begin();
			
			turnopunvenReturnGeneral =new TurnoPunVenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			turnopunvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			turnopunvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			turnopunvenReturnGeneral.setusuariosForeignKey(usuariosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return turnopunvenReturnGeneral;
	}
	
	public TurnoPunVenParameterReturnGeneral cargarCombosLoteForeignKeyTurnoPunVen(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario) throws Exception {
		TurnoPunVenParameterReturnGeneral  turnopunvenReturnGeneral =new TurnoPunVenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			turnopunvenReturnGeneral =new TurnoPunVenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			turnopunvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			turnopunvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			turnopunvenReturnGeneral.setusuariosForeignKey(usuariosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return turnopunvenReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTurnoPunVenWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CajaIngresoLogic cajaingresoLogic=new CajaIngresoLogic();
			CajeroTurnoLogic cajeroturnoLogic=new CajeroTurnoLogic();
			CajaEgresoLogic cajaegresoLogic=new CajaEgresoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTurnoPunVenWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CajaIngreso.class));
			classes.add(new Classe(CajeroTurno.class));
			classes.add(new Classe(CajaEgreso.class));
											
			

			cajaingresoLogic.setConnexion(this.getConnexion());
			cajaingresoLogic.setDatosCliente(this.datosCliente);
			cajaingresoLogic.setIsConRefrescarForeignKeys(true);

			cajeroturnoLogic.setConnexion(this.getConnexion());
			cajeroturnoLogic.setDatosCliente(this.datosCliente);
			cajeroturnoLogic.setIsConRefrescarForeignKeys(true);

			cajaegresoLogic.setConnexion(this.getConnexion());
			cajaegresoLogic.setDatosCliente(this.datosCliente);
			cajaegresoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TurnoPunVen turnopunven:this.turnopunvens) {
				

				classes=new ArrayList<Classe>();
				classes=CajaIngresoConstantesFunciones.getClassesForeignKeysOfCajaIngreso(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajaingresoLogic.setCajaIngresos(turnopunven.cajaingresos);
				cajaingresoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CajeroTurnoConstantesFunciones.getClassesForeignKeysOfCajeroTurno(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajeroturnoLogic.setCajeroTurnos(turnopunven.cajeroturnos);
				cajeroturnoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CajaEgresoConstantesFunciones.getClassesForeignKeysOfCajaEgreso(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajaegresoLogic.setCajaEgresos(turnopunven.cajaegresos);
				cajaegresoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TurnoPunVen turnopunven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TurnoPunVenLogicAdditional.updateTurnoPunVenToGet(turnopunven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		turnopunven.setEmpresa(turnopunvenDataAccess.getEmpresa(connexion,turnopunven));
		turnopunven.setSucursal(turnopunvenDataAccess.getSucursal(connexion,turnopunven));
		turnopunven.setUsuario(turnopunvenDataAccess.getUsuario(connexion,turnopunven));
		turnopunven.setCajaIngresos(turnopunvenDataAccess.getCajaIngresos(connexion,turnopunven));
		turnopunven.setCajeroTurnos(turnopunvenDataAccess.getCajeroTurnos(connexion,turnopunven));
		turnopunven.setCajaEgresos(turnopunvenDataAccess.getCajaEgresos(connexion,turnopunven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				turnopunven.setEmpresa(turnopunvenDataAccess.getEmpresa(connexion,turnopunven));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				turnopunven.setSucursal(turnopunvenDataAccess.getSucursal(connexion,turnopunven));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				turnopunven.setUsuario(turnopunvenDataAccess.getUsuario(connexion,turnopunven));
				continue;
			}

			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				turnopunven.setCajaIngresos(turnopunvenDataAccess.getCajaIngresos(connexion,turnopunven));

				if(this.isConDeep) {
					CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(this.connexion);
					cajaingresoLogic.setCajaIngresos(turnopunven.getCajaIngresos());
					ArrayList<Classe> classesLocal=CajaIngresoConstantesFunciones.getClassesForeignKeysOfCajaIngreso(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajaingresoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(cajaingresoLogic.getCajaIngresos());
					turnopunven.setCajaIngresos(cajaingresoLogic.getCajaIngresos());
				}

				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				turnopunven.setCajeroTurnos(turnopunvenDataAccess.getCajeroTurnos(connexion,turnopunven));

				if(this.isConDeep) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(this.connexion);
					cajeroturnoLogic.setCajeroTurnos(turnopunven.getCajeroTurnos());
					ArrayList<Classe> classesLocal=CajeroTurnoConstantesFunciones.getClassesForeignKeysOfCajeroTurno(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajeroturnoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(cajeroturnoLogic.getCajeroTurnos());
					turnopunven.setCajeroTurnos(cajeroturnoLogic.getCajeroTurnos());
				}

				continue;
			}

			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				turnopunven.setCajaEgresos(turnopunvenDataAccess.getCajaEgresos(connexion,turnopunven));

				if(this.isConDeep) {
					CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(this.connexion);
					cajaegresoLogic.setCajaEgresos(turnopunven.getCajaEgresos());
					ArrayList<Classe> classesLocal=CajaEgresoConstantesFunciones.getClassesForeignKeysOfCajaEgreso(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajaegresoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(cajaegresoLogic.getCajaEgresos());
					turnopunven.setCajaEgresos(cajaegresoLogic.getCajaEgresos());
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
			turnopunven.setEmpresa(turnopunvenDataAccess.getEmpresa(connexion,turnopunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			turnopunven.setSucursal(turnopunvenDataAccess.getSucursal(connexion,turnopunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			turnopunven.setUsuario(turnopunvenDataAccess.getUsuario(connexion,turnopunven));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaIngreso.class));
			turnopunven.setCajaIngresos(turnopunvenDataAccess.getCajaIngresos(connexion,turnopunven));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajeroTurno.class));
			turnopunven.setCajeroTurnos(turnopunvenDataAccess.getCajeroTurnos(connexion,turnopunven));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaEgreso.class));
			turnopunven.setCajaEgresos(turnopunvenDataAccess.getCajaEgresos(connexion,turnopunven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		turnopunven.setEmpresa(turnopunvenDataAccess.getEmpresa(connexion,turnopunven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(turnopunven.getEmpresa(),isDeep,deepLoadType,clases);
				
		turnopunven.setSucursal(turnopunvenDataAccess.getSucursal(connexion,turnopunven));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(turnopunven.getSucursal(),isDeep,deepLoadType,clases);
				
		turnopunven.setUsuario(turnopunvenDataAccess.getUsuario(connexion,turnopunven));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(turnopunven.getUsuario(),isDeep,deepLoadType,clases);
				

		turnopunven.setCajaIngresos(turnopunvenDataAccess.getCajaIngresos(connexion,turnopunven));

		for(CajaIngreso cajaingreso:turnopunven.getCajaIngresos()) {
			CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
			cajaingresoLogic.deepLoad(cajaingreso,isDeep,deepLoadType,clases);
		}

		turnopunven.setCajeroTurnos(turnopunvenDataAccess.getCajeroTurnos(connexion,turnopunven));

		for(CajeroTurno cajeroturno:turnopunven.getCajeroTurnos()) {
			CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
			cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
		}

		turnopunven.setCajaEgresos(turnopunvenDataAccess.getCajaEgresos(connexion,turnopunven));

		for(CajaEgreso cajaegreso:turnopunven.getCajaEgresos()) {
			CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
			cajaegresoLogic.deepLoad(cajaegreso,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				turnopunven.setEmpresa(turnopunvenDataAccess.getEmpresa(connexion,turnopunven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(turnopunven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				turnopunven.setSucursal(turnopunvenDataAccess.getSucursal(connexion,turnopunven));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(turnopunven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				turnopunven.setUsuario(turnopunvenDataAccess.getUsuario(connexion,turnopunven));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(turnopunven.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				turnopunven.setCajaIngresos(turnopunvenDataAccess.getCajaIngresos(connexion,turnopunven));

				for(CajaIngreso cajaingreso:turnopunven.getCajaIngresos()) {
					CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
					cajaingresoLogic.deepLoad(cajaingreso,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				turnopunven.setCajeroTurnos(turnopunvenDataAccess.getCajeroTurnos(connexion,turnopunven));

				for(CajeroTurno cajeroturno:turnopunven.getCajeroTurnos()) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
					cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				turnopunven.setCajaEgresos(turnopunvenDataAccess.getCajaEgresos(connexion,turnopunven));

				for(CajaEgreso cajaegreso:turnopunven.getCajaEgresos()) {
					CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
					cajaegresoLogic.deepLoad(cajaegreso,isDeep,deepLoadType,clases);
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
			turnopunven.setEmpresa(turnopunvenDataAccess.getEmpresa(connexion,turnopunven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(turnopunven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			turnopunven.setSucursal(turnopunvenDataAccess.getSucursal(connexion,turnopunven));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(turnopunven.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			turnopunven.setUsuario(turnopunvenDataAccess.getUsuario(connexion,turnopunven));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(turnopunven.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaIngreso.class));
			turnopunven.setCajaIngresos(turnopunvenDataAccess.getCajaIngresos(connexion,turnopunven));

			for(CajaIngreso cajaingreso:turnopunven.getCajaIngresos()) {
				CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
				cajaingresoLogic.deepLoad(cajaingreso,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajeroTurno.class));
			turnopunven.setCajeroTurnos(turnopunvenDataAccess.getCajeroTurnos(connexion,turnopunven));

			for(CajeroTurno cajeroturno:turnopunven.getCajeroTurnos()) {
				CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
				cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaEgreso.class));
			turnopunven.setCajaEgresos(turnopunvenDataAccess.getCajaEgresos(connexion,turnopunven));

			for(CajaEgreso cajaegreso:turnopunven.getCajaEgresos()) {
				CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
				cajaegresoLogic.deepLoad(cajaegreso,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TurnoPunVen turnopunven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TurnoPunVenLogicAdditional.updateTurnoPunVenToSave(turnopunven,this.arrDatoGeneral);
			
TurnoPunVenDataAccess.save(turnopunven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(turnopunven.getEmpresa(),connexion);

		SucursalDataAccess.save(turnopunven.getSucursal(),connexion);

		UsuarioDataAccess.save(turnopunven.getUsuario(),connexion);

		for(CajaIngreso cajaingreso:turnopunven.getCajaIngresos()) {
			cajaingreso.setid_turno_pun_ven(turnopunven.getId());
			CajaIngresoDataAccess.save(cajaingreso,connexion);
		}

		for(CajeroTurno cajeroturno:turnopunven.getCajeroTurnos()) {
			cajeroturno.setid_turno_pun_ven(turnopunven.getId());
			CajeroTurnoDataAccess.save(cajeroturno,connexion);
		}

		for(CajaEgreso cajaegreso:turnopunven.getCajaEgresos()) {
			cajaegreso.setid_turno_pun_ven(turnopunven.getId());
			CajaEgresoDataAccess.save(cajaegreso,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(turnopunven.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(turnopunven.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(turnopunven.getUsuario(),connexion);
				continue;
			}


			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajaIngreso cajaingreso:turnopunven.getCajaIngresos()) {
					cajaingreso.setid_turno_pun_ven(turnopunven.getId());
					CajaIngresoDataAccess.save(cajaingreso,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajeroTurno cajeroturno:turnopunven.getCajeroTurnos()) {
					cajeroturno.setid_turno_pun_ven(turnopunven.getId());
					CajeroTurnoDataAccess.save(cajeroturno,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajaEgreso cajaegreso:turnopunven.getCajaEgresos()) {
					cajaegreso.setid_turno_pun_ven(turnopunven.getId());
					CajaEgresoDataAccess.save(cajaegreso,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(turnopunven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(turnopunven.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(turnopunven.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(turnopunven.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(turnopunven.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(turnopunven.getUsuario(),isDeep,deepLoadType,clases);
				

		for(CajaIngreso cajaingreso:turnopunven.getCajaIngresos()) {
			CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
			cajaingreso.setid_turno_pun_ven(turnopunven.getId());
			CajaIngresoDataAccess.save(cajaingreso,connexion);
			cajaingresoLogic.deepSave(cajaingreso,isDeep,deepLoadType,clases);
		}

		for(CajeroTurno cajeroturno:turnopunven.getCajeroTurnos()) {
			CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
			cajeroturno.setid_turno_pun_ven(turnopunven.getId());
			CajeroTurnoDataAccess.save(cajeroturno,connexion);
			cajeroturnoLogic.deepSave(cajeroturno,isDeep,deepLoadType,clases);
		}

		for(CajaEgreso cajaegreso:turnopunven.getCajaEgresos()) {
			CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
			cajaegreso.setid_turno_pun_ven(turnopunven.getId());
			CajaEgresoDataAccess.save(cajaegreso,connexion);
			cajaegresoLogic.deepSave(cajaegreso,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(turnopunven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(turnopunven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(turnopunven.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(turnopunven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(turnopunven.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(turnopunven.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajaIngreso cajaingreso:turnopunven.getCajaIngresos()) {
					CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
					cajaingreso.setid_turno_pun_ven(turnopunven.getId());
					CajaIngresoDataAccess.save(cajaingreso,connexion);
					cajaingresoLogic.deepSave(cajaingreso,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajeroTurno cajeroturno:turnopunven.getCajeroTurnos()) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
					cajeroturno.setid_turno_pun_ven(turnopunven.getId());
					CajeroTurnoDataAccess.save(cajeroturno,connexion);
					cajeroturnoLogic.deepSave(cajeroturno,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajaEgreso cajaegreso:turnopunven.getCajaEgresos()) {
					CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
					cajaegreso.setid_turno_pun_ven(turnopunven.getId());
					CajaEgresoDataAccess.save(cajaegreso,connexion);
					cajaegresoLogic.deepSave(cajaegreso,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TurnoPunVen.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(turnopunven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(turnopunven);
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
			this.deepLoad(this.turnopunven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TurnoPunVen.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(turnopunvens!=null) {
				for(TurnoPunVen turnopunven:turnopunvens) {
					this.deepLoad(turnopunven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(turnopunvens);
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
			if(turnopunvens!=null) {
				for(TurnoPunVen turnopunven:turnopunvens) {
					this.deepLoad(turnopunven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(turnopunvens);
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
			this.getNewConnexionToDeep(TurnoPunVen.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(turnopunven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TurnoPunVen.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(turnopunvens!=null) {
				for(TurnoPunVen turnopunven:turnopunvens) {
					this.deepSave(turnopunven,isDeep,deepLoadType,clases);
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
			if(turnopunvens!=null) {
				for(TurnoPunVen turnopunven:turnopunvens) {
					this.deepSave(turnopunven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTurnoPunVensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TurnoPunVenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			turnopunvens=turnopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTurnoPunVensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TurnoPunVenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			turnopunvens=turnopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTurnoPunVensFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TurnoPunVenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			turnopunvens=turnopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTurnoPunVensFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TurnoPunVenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			turnopunvens=turnopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTurnoPunVensFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TurnoPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,TurnoPunVenConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			turnopunvens=turnopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTurnoPunVensFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,TurnoPunVenConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			TurnoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			turnopunvens=turnopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(this.turnopunvens);
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
			if(TurnoPunVenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TurnoPunVenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TurnoPunVen turnopunven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TurnoPunVenConstantesFunciones.ISCONAUDITORIA) {
				if(turnopunven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TurnoPunVenDataAccess.TABLENAME, turnopunven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TurnoPunVenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TurnoPunVenLogic.registrarAuditoriaDetallesTurnoPunVen(connexion,turnopunven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(turnopunven.getIsDeleted()) {
					/*if(!turnopunven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TurnoPunVenDataAccess.TABLENAME, turnopunven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TurnoPunVenLogic.registrarAuditoriaDetallesTurnoPunVen(connexion,turnopunven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TurnoPunVenDataAccess.TABLENAME, turnopunven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(turnopunven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TurnoPunVenDataAccess.TABLENAME, turnopunven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TurnoPunVenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TurnoPunVenLogic.registrarAuditoriaDetallesTurnoPunVen(connexion,turnopunven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTurnoPunVen(Connexion connexion,TurnoPunVen turnopunven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(turnopunven.getIsNew()||!turnopunven.getid_empresa().equals(turnopunven.getTurnoPunVenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turnopunven.getTurnoPunVenOriginal().getid_empresa()!=null)
				{
					strValorActual=turnopunven.getTurnoPunVenOriginal().getid_empresa().toString();
				}
				if(turnopunven.getid_empresa()!=null)
				{
					strValorNuevo=turnopunven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoPunVenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(turnopunven.getIsNew()||!turnopunven.getid_sucursal().equals(turnopunven.getTurnoPunVenOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turnopunven.getTurnoPunVenOriginal().getid_sucursal()!=null)
				{
					strValorActual=turnopunven.getTurnoPunVenOriginal().getid_sucursal().toString();
				}
				if(turnopunven.getid_sucursal()!=null)
				{
					strValorNuevo=turnopunven.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoPunVenConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(turnopunven.getIsNew()||!turnopunven.getid_usuario().equals(turnopunven.getTurnoPunVenOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turnopunven.getTurnoPunVenOriginal().getid_usuario()!=null)
				{
					strValorActual=turnopunven.getTurnoPunVenOriginal().getid_usuario().toString();
				}
				if(turnopunven.getid_usuario()!=null)
				{
					strValorNuevo=turnopunven.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoPunVenConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(turnopunven.getIsNew()||!turnopunven.getnombre().equals(turnopunven.getTurnoPunVenOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turnopunven.getTurnoPunVenOriginal().getnombre()!=null)
				{
					strValorActual=turnopunven.getTurnoPunVenOriginal().getnombre();
				}
				if(turnopunven.getnombre()!=null)
				{
					strValorNuevo=turnopunven.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoPunVenConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(turnopunven.getIsNew()||!turnopunven.gethora_inicio().equals(turnopunven.getTurnoPunVenOriginal().gethora_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turnopunven.getTurnoPunVenOriginal().gethora_inicio()!=null)
				{
					strValorActual=turnopunven.getTurnoPunVenOriginal().gethora_inicio().toString();
				}
				if(turnopunven.gethora_inicio()!=null)
				{
					strValorNuevo=turnopunven.gethora_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoPunVenConstantesFunciones.HORAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(turnopunven.getIsNew()||!turnopunven.gethora_fin().equals(turnopunven.getTurnoPunVenOriginal().gethora_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turnopunven.getTurnoPunVenOriginal().gethora_fin()!=null)
				{
					strValorActual=turnopunven.getTurnoPunVenOriginal().gethora_fin().toString();
				}
				if(turnopunven.gethora_fin()!=null)
				{
					strValorNuevo=turnopunven.gethora_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoPunVenConstantesFunciones.HORAFIN,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTurnoPunVenRelacionesWithConnection(TurnoPunVen turnopunven,List<CajaIngreso> cajaingresos,List<CajeroTurno> cajeroturnos,List<CajaEgreso> cajaegresos) throws Exception {

		if(!turnopunven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTurnoPunVenRelacionesBase(turnopunven,cajaingresos,cajeroturnos,cajaegresos,true);
		}
	}

	public void saveTurnoPunVenRelaciones(TurnoPunVen turnopunven,List<CajaIngreso> cajaingresos,List<CajeroTurno> cajeroturnos,List<CajaEgreso> cajaegresos)throws Exception {

		if(!turnopunven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTurnoPunVenRelacionesBase(turnopunven,cajaingresos,cajeroturnos,cajaegresos,false);
		}
	}

	public void saveTurnoPunVenRelacionesBase(TurnoPunVen turnopunven,List<CajaIngreso> cajaingresos,List<CajeroTurno> cajeroturnos,List<CajaEgreso> cajaegresos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TurnoPunVen-saveRelacionesWithConnection");}
	
			turnopunven.setCajaIngresos(cajaingresos);
			turnopunven.setCajeroTurnos(cajeroturnos);
			turnopunven.setCajaEgresos(cajaegresos);

			this.setTurnoPunVen(turnopunven);

			if(TurnoPunVenLogicAdditional.validarSaveRelaciones(turnopunven,this)) {

				TurnoPunVenLogicAdditional.updateRelacionesToSave(turnopunven,this);

				if((turnopunven.getIsNew()||turnopunven.getIsChanged())&&!turnopunven.getIsDeleted()) {
					this.saveTurnoPunVen();
					this.saveTurnoPunVenRelacionesDetalles(cajaingresos,cajeroturnos,cajaegresos);

				} else if(turnopunven.getIsDeleted()) {
					this.saveTurnoPunVenRelacionesDetalles(cajaingresos,cajeroturnos,cajaegresos);
					this.saveTurnoPunVen();
				}

				TurnoPunVenLogicAdditional.updateRelacionesToSaveAfter(turnopunven,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CajaIngresoConstantesFunciones.InicializarGeneralEntityAuxiliaresCajaIngresos(cajaingresos,true,true);
			CajeroTurnoConstantesFunciones.InicializarGeneralEntityAuxiliaresCajeroTurnos(cajeroturnos,true,true);
			CajaEgresoConstantesFunciones.InicializarGeneralEntityAuxiliaresCajaEgresos(cajaegresos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTurnoPunVenRelacionesDetalles(List<CajaIngreso> cajaingresos,List<CajeroTurno> cajeroturnos,List<CajaEgreso> cajaegresos)throws Exception {
		try {
	

			Long idTurnoPunVenActual=this.getTurnoPunVen().getId();

			CajaIngresoLogic cajaingresoLogic_Desde_TurnoPunVen=new CajaIngresoLogic();
			cajaingresoLogic_Desde_TurnoPunVen.setCajaIngresos(cajaingresos);

			cajaingresoLogic_Desde_TurnoPunVen.setConnexion(this.getConnexion());
			cajaingresoLogic_Desde_TurnoPunVen.setDatosCliente(this.datosCliente);

			for(CajaIngreso cajaingreso_Desde_TurnoPunVen:cajaingresoLogic_Desde_TurnoPunVen.getCajaIngresos()) {
				cajaingreso_Desde_TurnoPunVen.setid_turno_pun_ven(idTurnoPunVenActual);

				cajaingresoLogic_Desde_TurnoPunVen.setCajaIngreso(cajaingreso_Desde_TurnoPunVen);
				cajaingresoLogic_Desde_TurnoPunVen.saveCajaIngreso();

				Long idCajaIngresoActual=cajaingreso_Desde_TurnoPunVen.getId();

				CajaIngresoDetalleLogic cajaingresodetalleLogic_Desde_CajaIngreso=new CajaIngresoDetalleLogic();

				if(cajaingreso_Desde_TurnoPunVen.getCajaIngresoDetalles()==null){
					cajaingreso_Desde_TurnoPunVen.setCajaIngresoDetalles(new ArrayList<CajaIngresoDetalle>());
				}

				cajaingresodetalleLogic_Desde_CajaIngreso.setCajaIngresoDetalles(cajaingreso_Desde_TurnoPunVen.getCajaIngresoDetalles());

				cajaingresodetalleLogic_Desde_CajaIngreso.setConnexion(this.getConnexion());
				cajaingresodetalleLogic_Desde_CajaIngreso.setDatosCliente(this.datosCliente);

				for(CajaIngresoDetalle cajaingresodetalle_Desde_CajaIngreso:cajaingresodetalleLogic_Desde_CajaIngreso.getCajaIngresoDetalles()) {
					cajaingresodetalle_Desde_CajaIngreso.setid_caja_ingreso(idCajaIngresoActual);
				}

				cajaingresodetalleLogic_Desde_CajaIngreso.saveCajaIngresoDetalles();
			}


			CajeroTurnoLogic cajeroturnoLogic_Desde_TurnoPunVen=new CajeroTurnoLogic();
			cajeroturnoLogic_Desde_TurnoPunVen.setCajeroTurnos(cajeroturnos);

			cajeroturnoLogic_Desde_TurnoPunVen.setConnexion(this.getConnexion());
			cajeroturnoLogic_Desde_TurnoPunVen.setDatosCliente(this.datosCliente);

			for(CajeroTurno cajeroturno_Desde_TurnoPunVen:cajeroturnoLogic_Desde_TurnoPunVen.getCajeroTurnos()) {
				cajeroturno_Desde_TurnoPunVen.setid_turno_pun_ven(idTurnoPunVenActual);
			}

			cajeroturnoLogic_Desde_TurnoPunVen.saveCajeroTurnos();

			CajaEgresoLogic cajaegresoLogic_Desde_TurnoPunVen=new CajaEgresoLogic();
			cajaegresoLogic_Desde_TurnoPunVen.setCajaEgresos(cajaegresos);

			cajaegresoLogic_Desde_TurnoPunVen.setConnexion(this.getConnexion());
			cajaegresoLogic_Desde_TurnoPunVen.setDatosCliente(this.datosCliente);

			for(CajaEgreso cajaegreso_Desde_TurnoPunVen:cajaegresoLogic_Desde_TurnoPunVen.getCajaEgresos()) {
				cajaegreso_Desde_TurnoPunVen.setid_turno_pun_ven(idTurnoPunVenActual);

				cajaegresoLogic_Desde_TurnoPunVen.setCajaEgreso(cajaegreso_Desde_TurnoPunVen);
				cajaegresoLogic_Desde_TurnoPunVen.saveCajaEgreso();

				Long idCajaEgresoActual=cajaegreso_Desde_TurnoPunVen.getId();

				CajaEgresoDetalleLogic cajaegresodetalleLogic_Desde_CajaEgreso=new CajaEgresoDetalleLogic();

				if(cajaegreso_Desde_TurnoPunVen.getCajaEgresoDetalles()==null){
					cajaegreso_Desde_TurnoPunVen.setCajaEgresoDetalles(new ArrayList<CajaEgresoDetalle>());
				}

				cajaegresodetalleLogic_Desde_CajaEgreso.setCajaEgresoDetalles(cajaegreso_Desde_TurnoPunVen.getCajaEgresoDetalles());

				cajaegresodetalleLogic_Desde_CajaEgreso.setConnexion(this.getConnexion());
				cajaegresodetalleLogic_Desde_CajaEgreso.setDatosCliente(this.datosCliente);

				for(CajaEgresoDetalle cajaegresodetalle_Desde_CajaEgreso:cajaegresodetalleLogic_Desde_CajaEgreso.getCajaEgresoDetalles()) {
					cajaegresodetalle_Desde_CajaEgreso.setid_caja_egreso(idCajaEgresoActual);
				}

				cajaegresodetalleLogic_Desde_CajaEgreso.saveCajaEgresoDetalles();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTurnoPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TurnoPunVenConstantesFunciones.getClassesForeignKeysOfTurnoPunVen(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTurnoPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TurnoPunVenConstantesFunciones.getClassesRelationshipsOfTurnoPunVen(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

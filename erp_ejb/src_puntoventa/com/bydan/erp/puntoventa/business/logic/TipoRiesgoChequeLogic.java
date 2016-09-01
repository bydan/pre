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
import com.bydan.erp.puntoventa.util.TipoRiesgoChequeConstantesFunciones;
import com.bydan.erp.puntoventa.util.TipoRiesgoChequeParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TipoRiesgoChequeParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.TipoRiesgoCheque;
//import com.bydan.erp.puntoventa.business.logic.TipoRiesgoChequeLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoRiesgoChequeLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoRiesgoChequeLogic.class);
	
	protected TipoRiesgoChequeDataAccess tiporiesgochequeDataAccess; 	
	protected TipoRiesgoCheque tiporiesgocheque;
	protected List<TipoRiesgoCheque> tiporiesgocheques;
	protected Object tiporiesgochequeObject;	
	protected List<Object> tiporiesgochequesObject;
	
	public static ClassValidator<TipoRiesgoCheque> tiporiesgochequeValidator = new ClassValidator<TipoRiesgoCheque>(TipoRiesgoCheque.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  TipoRiesgoChequeLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiporiesgochequeDataAccess = new TipoRiesgoChequeDataAccess();
			
			this.tiporiesgocheques= new ArrayList<TipoRiesgoCheque>();
			this.tiporiesgocheque= new TipoRiesgoCheque();
			
			this.tiporiesgochequeObject=new Object();
			this.tiporiesgochequesObject=new ArrayList<Object>();
				
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
			
			this.tiporiesgochequeDataAccess.setConnexionType(this.connexionType);
			this.tiporiesgochequeDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoRiesgoChequeLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiporiesgochequeDataAccess = new TipoRiesgoChequeDataAccess();
			this.tiporiesgocheques= new ArrayList<TipoRiesgoCheque>();
			this.tiporiesgocheque= new TipoRiesgoCheque();
			this.tiporiesgochequeObject=new Object();
			this.tiporiesgochequesObject=new ArrayList<Object>();
			
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
			
			this.tiporiesgochequeDataAccess.setConnexionType(this.connexionType);
			this.tiporiesgochequeDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoRiesgoCheque getTipoRiesgoCheque() throws Exception {	
		//TipoRiesgoChequeLogicAdditional.checkTipoRiesgoChequeToGet(tiporiesgocheque,this.datosCliente,this.arrDatoGeneral);
		//TipoRiesgoChequeLogicAdditional.updateTipoRiesgoChequeToGet(tiporiesgocheque,this.arrDatoGeneral);
		
		return tiporiesgocheque;
	}
		
	public void setTipoRiesgoCheque(TipoRiesgoCheque newTipoRiesgoCheque) {
		this.tiporiesgocheque = newTipoRiesgoCheque;
	}
	
	public TipoRiesgoChequeDataAccess getTipoRiesgoChequeDataAccess() {
		return tiporiesgochequeDataAccess;
	}
	
	public void setTipoRiesgoChequeDataAccess(TipoRiesgoChequeDataAccess newtiporiesgochequeDataAccess) {
		this.tiporiesgochequeDataAccess = newtiporiesgochequeDataAccess;
	}
	
	public List<TipoRiesgoCheque> getTipoRiesgoCheques() throws Exception {		
		this.quitarTipoRiesgoChequesNulos();
		
		//TipoRiesgoChequeLogicAdditional.checkTipoRiesgoChequeToGets(tiporiesgocheques,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoRiesgoCheque tiporiesgochequeLocal: tiporiesgocheques ) {
			//TipoRiesgoChequeLogicAdditional.updateTipoRiesgoChequeToGet(tiporiesgochequeLocal,this.arrDatoGeneral);
		}
		
		return tiporiesgocheques;
	}
	
	public void setTipoRiesgoCheques(List<TipoRiesgoCheque> newTipoRiesgoCheques) {
		this.tiporiesgocheques = newTipoRiesgoCheques;
	}
	
	public Object getTipoRiesgoChequeObject() {	
		this.tiporiesgochequeObject=this.tiporiesgochequeDataAccess.getEntityObject();
		return this.tiporiesgochequeObject;
	}
		
	public void setTipoRiesgoChequeObject(Object newTipoRiesgoChequeObject) {
		this.tiporiesgochequeObject = newTipoRiesgoChequeObject;
	}
	
	public List<Object> getTipoRiesgoChequesObject() {		
		this.tiporiesgochequesObject=this.tiporiesgochequeDataAccess.getEntitiesObject();
		return this.tiporiesgochequesObject;
	}
		
	public void setTipoRiesgoChequesObject(List<Object> newTipoRiesgoChequesObject) {
		this.tiporiesgochequesObject = newTipoRiesgoChequesObject;
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
		
		if(this.tiporiesgochequeDataAccess!=null) {
			this.tiporiesgochequeDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiporiesgochequeDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiporiesgochequeDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiporiesgocheque = new  TipoRiesgoCheque();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporiesgocheque=tiporiesgochequeDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporiesgocheque,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheque);
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
		tiporiesgocheque = new  TipoRiesgoCheque();
		  		  
        try {
			
			tiporiesgocheque=tiporiesgochequeDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporiesgocheque,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheque);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiporiesgocheque = new  TipoRiesgoCheque();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporiesgocheque=tiporiesgochequeDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporiesgocheque,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheque);
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
		tiporiesgocheque = new  TipoRiesgoCheque();
		  		  
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
		tiporiesgocheque = new  TipoRiesgoCheque();
		  		  
        try {
			
			tiporiesgocheque=tiporiesgochequeDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporiesgocheque,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheque);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiporiesgocheque = new  TipoRiesgoCheque();
		  		  
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
		tiporiesgocheque = new  TipoRiesgoCheque();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiporiesgochequeDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporiesgocheque = new  TipoRiesgoCheque();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiporiesgochequeDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporiesgocheque = new  TipoRiesgoCheque();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiporiesgochequeDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporiesgocheque = new  TipoRiesgoCheque();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiporiesgochequeDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporiesgocheque = new  TipoRiesgoCheque();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiporiesgochequeDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporiesgocheque = new  TipoRiesgoCheque();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiporiesgochequeDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporiesgocheques = new  ArrayList<TipoRiesgoCheque>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgocheques=tiporiesgochequeDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCheque(tiporiesgocheques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheques);
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
		tiporiesgocheques = new  ArrayList<TipoRiesgoCheque>();
		  		  
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
		tiporiesgocheques = new  ArrayList<TipoRiesgoCheque>();
		  		  
        try {			
			TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgocheques=tiporiesgochequeDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoRiesgoCheque(tiporiesgocheques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheques);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiporiesgocheques = new  ArrayList<TipoRiesgoCheque>();
		  		  
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
		tiporiesgocheques = new  ArrayList<TipoRiesgoCheque>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgocheques=tiporiesgochequeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCheque(tiporiesgocheques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheques);
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
		tiporiesgocheques = new  ArrayList<TipoRiesgoCheque>();
		  		  
        try {
			TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgocheques=tiporiesgochequeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCheque(tiporiesgocheques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheques);
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
		tiporiesgocheques = new  ArrayList<TipoRiesgoCheque>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgocheques=tiporiesgochequeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCheque(tiporiesgocheques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheques);
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
		tiporiesgocheques = new  ArrayList<TipoRiesgoCheque>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgocheques=tiporiesgochequeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCheque(tiporiesgocheques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheques);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiporiesgocheque = new  TipoRiesgoCheque();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgocheque=tiporiesgochequeDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCheque(tiporiesgocheque);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheque);
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
		tiporiesgocheque = new  TipoRiesgoCheque();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgocheque=tiporiesgochequeDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCheque(tiporiesgocheque);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheque);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoRiesgoChequesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiporiesgocheques = new  ArrayList<TipoRiesgoCheque>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-getTodosTipoRiesgoChequesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgocheques=tiporiesgochequeDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRiesgoCheque(tiporiesgocheques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheques);
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
	
	public  void  getTodosTipoRiesgoCheques(String sFinalQuery,Pagination pagination)throws Exception {
		tiporiesgocheques = new  ArrayList<TipoRiesgoCheque>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgocheques=tiporiesgochequeDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRiesgoCheque(tiporiesgocheques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheques);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoRiesgoCheque(TipoRiesgoCheque tiporiesgocheque) throws Exception {
		Boolean estaValidado=false;
		
		if(tiporiesgocheque.getIsNew() || tiporiesgocheque.getIsChanged()) { 
			this.invalidValues = tiporiesgochequeValidator.getInvalidValues(tiporiesgocheque);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiporiesgocheque);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoRiesgoCheque(List<TipoRiesgoCheque> TipoRiesgoCheques) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoRiesgoCheque tiporiesgochequeLocal:tiporiesgocheques) {				
			estaValidadoObjeto=this.validarGuardarTipoRiesgoCheque(tiporiesgochequeLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoRiesgoCheque(List<TipoRiesgoCheque> TipoRiesgoCheques) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRiesgoCheque(tiporiesgocheques)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoRiesgoCheque(TipoRiesgoCheque TipoRiesgoCheque) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRiesgoCheque(tiporiesgocheque)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoRiesgoCheque tiporiesgocheque) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiporiesgocheque.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoRiesgoChequeConstantesFunciones.getTipoRiesgoChequeLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiporiesgocheque","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoRiesgoChequeConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoRiesgoChequeConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoRiesgoChequeWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-saveTipoRiesgoChequeWithConnection");connexion.begin();			
			
			//TipoRiesgoChequeLogicAdditional.checkTipoRiesgoChequeToSave(this.tiporiesgocheque,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoRiesgoChequeLogicAdditional.updateTipoRiesgoChequeToSave(this.tiporiesgocheque,this.arrDatoGeneral);
			
			TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporiesgocheque,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoRiesgoCheque();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRiesgoCheque(this.tiporiesgocheque)) {
				TipoRiesgoChequeDataAccess.save(this.tiporiesgocheque, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiporiesgocheque,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoRiesgoChequeLogicAdditional.checkTipoRiesgoChequeToSaveAfter(this.tiporiesgocheque,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRiesgoCheque();
			
			connexion.commit();			
			
			if(this.tiporiesgocheque.getIsDeleted()) {
				this.tiporiesgocheque=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoRiesgoCheque()throws Exception {	
		try {	
			
			//TipoRiesgoChequeLogicAdditional.checkTipoRiesgoChequeToSave(this.tiporiesgocheque,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoRiesgoChequeLogicAdditional.updateTipoRiesgoChequeToSave(this.tiporiesgocheque,this.arrDatoGeneral);
			
			TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporiesgocheque,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRiesgoCheque(this.tiporiesgocheque)) {			
				TipoRiesgoChequeDataAccess.save(this.tiporiesgocheque, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiporiesgocheque,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoRiesgoChequeLogicAdditional.checkTipoRiesgoChequeToSaveAfter(this.tiporiesgocheque,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiporiesgocheque.getIsDeleted()) {
				this.tiporiesgocheque=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoRiesgoChequesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-saveTipoRiesgoChequesWithConnection");connexion.begin();			
			
			//TipoRiesgoChequeLogicAdditional.checkTipoRiesgoChequeToSaves(tiporiesgocheques,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoRiesgoCheques();
			
			Boolean validadoTodosTipoRiesgoCheque=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRiesgoCheque tiporiesgochequeLocal:tiporiesgocheques) {		
				if(tiporiesgochequeLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoRiesgoChequeLogicAdditional.updateTipoRiesgoChequeToSave(tiporiesgochequeLocal,this.arrDatoGeneral);
	        	
				TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporiesgochequeLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRiesgoCheque(tiporiesgochequeLocal)) {
					TipoRiesgoChequeDataAccess.save(tiporiesgochequeLocal, connexion);				
				} else {
					validadoTodosTipoRiesgoCheque=false;
				}
			}
			
			if(!validadoTodosTipoRiesgoCheque) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoRiesgoChequeLogicAdditional.checkTipoRiesgoChequeToSavesAfter(tiporiesgocheques,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRiesgoCheques();
			
			connexion.commit();		
			
			this.quitarTipoRiesgoChequesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoRiesgoCheques()throws Exception {				
		 try {	
			//TipoRiesgoChequeLogicAdditional.checkTipoRiesgoChequeToSaves(tiporiesgocheques,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoRiesgoCheque=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRiesgoCheque tiporiesgochequeLocal:tiporiesgocheques) {				
				if(tiporiesgochequeLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoRiesgoChequeLogicAdditional.updateTipoRiesgoChequeToSave(tiporiesgochequeLocal,this.arrDatoGeneral);
	        	
				TipoRiesgoChequeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporiesgochequeLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRiesgoCheque(tiporiesgochequeLocal)) {				
					TipoRiesgoChequeDataAccess.save(tiporiesgochequeLocal, connexion);				
				} else {
					validadoTodosTipoRiesgoCheque=false;
				}
			}
			
			if(!validadoTodosTipoRiesgoCheque) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoRiesgoChequeLogicAdditional.checkTipoRiesgoChequeToSavesAfter(tiporiesgocheques,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoRiesgoChequesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRiesgoChequeParameterReturnGeneral procesarAccionTipoRiesgoCheques(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRiesgoCheque> tiporiesgocheques,TipoRiesgoChequeParameterReturnGeneral tiporiesgochequeParameterGeneral)throws Exception {
		 try {	
			TipoRiesgoChequeParameterReturnGeneral tiporiesgochequeReturnGeneral=new TipoRiesgoChequeParameterReturnGeneral();
	
			
			return tiporiesgochequeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRiesgoChequeParameterReturnGeneral procesarAccionTipoRiesgoChequesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRiesgoCheque> tiporiesgocheques,TipoRiesgoChequeParameterReturnGeneral tiporiesgochequeParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-procesarAccionTipoRiesgoChequesWithConnection");connexion.begin();			
			
			TipoRiesgoChequeParameterReturnGeneral tiporiesgochequeReturnGeneral=new TipoRiesgoChequeParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tiporiesgochequeReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRiesgoChequeParameterReturnGeneral procesarEventosTipoRiesgoCheques(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRiesgoCheque> tiporiesgocheques,TipoRiesgoCheque tiporiesgocheque,TipoRiesgoChequeParameterReturnGeneral tiporiesgochequeParameterGeneral,Boolean isEsNuevoTipoRiesgoCheque,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoRiesgoChequeParameterReturnGeneral tiporiesgochequeReturnGeneral=new TipoRiesgoChequeParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporiesgochequeReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tiporiesgochequeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoRiesgoChequeParameterReturnGeneral procesarEventosTipoRiesgoChequesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRiesgoCheque> tiporiesgocheques,TipoRiesgoCheque tiporiesgocheque,TipoRiesgoChequeParameterReturnGeneral tiporiesgochequeParameterGeneral,Boolean isEsNuevoTipoRiesgoCheque,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-procesarEventosTipoRiesgoChequesWithConnection");connexion.begin();			
			
			TipoRiesgoChequeParameterReturnGeneral tiporiesgochequeReturnGeneral=new TipoRiesgoChequeParameterReturnGeneral();
	
			tiporiesgochequeReturnGeneral.setTipoRiesgoCheque(tiporiesgocheque);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporiesgochequeReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tiporiesgochequeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRiesgoChequeParameterReturnGeneral procesarImportacionTipoRiesgoChequesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoRiesgoChequeParameterReturnGeneral tiporiesgochequeParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-procesarImportacionTipoRiesgoChequesWithConnection");connexion.begin();			
			
			TipoRiesgoChequeParameterReturnGeneral tiporiesgochequeReturnGeneral=new TipoRiesgoChequeParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiporiesgocheques=new ArrayList<TipoRiesgoCheque>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiporiesgocheque=new TipoRiesgoCheque();
				
				
				if(conColumnasBase) {this.tiporiesgocheque.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiporiesgocheque.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiporiesgocheque.setnombre(arrColumnas[iColumn++]);
				this.tiporiesgocheque.setdescripcion(arrColumnas[iColumn++]);
				
				this.tiporiesgocheques.add(this.tiporiesgocheque);
			}
			
			this.saveTipoRiesgoCheques();
			
			this.connexion.commit();
			
			tiporiesgochequeReturnGeneral.setConRetornoEstaProcesado(true);
			tiporiesgochequeReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiporiesgochequeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoRiesgoChequesEliminados() throws Exception {				
		
		List<TipoRiesgoCheque> tiporiesgochequesAux= new ArrayList<TipoRiesgoCheque>();
		
		for(TipoRiesgoCheque tiporiesgocheque:tiporiesgocheques) {
			if(!tiporiesgocheque.getIsDeleted()) {
				tiporiesgochequesAux.add(tiporiesgocheque);
			}
		}
		
		tiporiesgocheques=tiporiesgochequesAux;
	}
	
	public void quitarTipoRiesgoChequesNulos() throws Exception {				
		
		List<TipoRiesgoCheque> tiporiesgochequesAux= new ArrayList<TipoRiesgoCheque>();
		
		for(TipoRiesgoCheque tiporiesgocheque : this.tiporiesgocheques) {
			if(tiporiesgocheque==null) {
				tiporiesgochequesAux.add(tiporiesgocheque);
			}
		}
		
		//this.tiporiesgocheques=tiporiesgochequesAux;
		
		this.tiporiesgocheques.removeAll(tiporiesgochequesAux);
	}
	
	public void getSetVersionRowTipoRiesgoChequeWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiporiesgocheque.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiporiesgocheque.getIsDeleted() || (tiporiesgocheque.getIsChanged()&&!tiporiesgocheque.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiporiesgochequeDataAccess.getSetVersionRowTipoRiesgoCheque(connexion,tiporiesgocheque.getId());
				
				if(!tiporiesgocheque.getVersionRow().equals(timestamp)) {	
					tiporiesgocheque.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiporiesgocheque.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoRiesgoCheque()throws Exception {	
		
		if(tiporiesgocheque.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiporiesgocheque.getIsDeleted() || (tiporiesgocheque.getIsChanged()&&!tiporiesgocheque.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiporiesgochequeDataAccess.getSetVersionRowTipoRiesgoCheque(connexion,tiporiesgocheque.getId());
			
			try {							
				if(!tiporiesgocheque.getVersionRow().equals(timestamp)) {	
					tiporiesgocheque.setVersionRow(timestamp);
				}
				
				tiporiesgocheque.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoRiesgoChequesWithConnection()throws Exception {	
		if(tiporiesgocheques!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoRiesgoCheque tiporiesgochequeAux:tiporiesgocheques) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiporiesgochequeAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporiesgochequeAux.getIsDeleted() || (tiporiesgochequeAux.getIsChanged()&&!tiporiesgochequeAux.getIsNew())) {
						
						timestamp=tiporiesgochequeDataAccess.getSetVersionRowTipoRiesgoCheque(connexion,tiporiesgochequeAux.getId());
						
						if(!tiporiesgocheque.getVersionRow().equals(timestamp)) {	
							tiporiesgochequeAux.setVersionRow(timestamp);
						}
								
						tiporiesgochequeAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoRiesgoCheques()throws Exception {	
		if(tiporiesgocheques!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoRiesgoCheque tiporiesgochequeAux:tiporiesgocheques) {
					if(tiporiesgochequeAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporiesgochequeAux.getIsDeleted() || (tiporiesgochequeAux.getIsChanged()&&!tiporiesgochequeAux.getIsNew())) {
						
						timestamp=tiporiesgochequeDataAccess.getSetVersionRowTipoRiesgoCheque(connexion,tiporiesgochequeAux.getId());
						
						if(!tiporiesgochequeAux.getVersionRow().equals(timestamp)) {	
							tiporiesgochequeAux.setVersionRow(timestamp);
						}
						
													
						tiporiesgochequeAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoRiesgoChequeWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic=new FormaPagoPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCheque.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoRiesgoChequeWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormaPagoPuntoVenta.class));
											
			

			formapagopuntoventaLogic.setConnexion(this.getConnexion());
			formapagopuntoventaLogic.setDatosCliente(this.datosCliente);
			formapagopuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoRiesgoCheque tiporiesgocheque:this.tiporiesgocheques) {
				

				classes=new ArrayList<Classe>();
				classes=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				formapagopuntoventaLogic.setFormaPagoPuntoVentas(tiporiesgocheque.formapagopuntoventas);
				formapagopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoRiesgoCheque tiporiesgocheque,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoRiesgoChequeLogicAdditional.updateTipoRiesgoChequeToGet(tiporiesgocheque,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporiesgocheque.setFormaPagoPuntoVentas(tiporiesgochequeDataAccess.getFormaPagoPuntoVentas(connexion,tiporiesgocheque));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporiesgocheque.setFormaPagoPuntoVentas(tiporiesgochequeDataAccess.getFormaPagoPuntoVentas(connexion,tiporiesgocheque));

				if(this.isConDeep) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(this.connexion);
					formapagopuntoventaLogic.setFormaPagoPuntoVentas(tiporiesgocheque.getFormaPagoPuntoVentas());
					ArrayList<Classe> classesLocal=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					formapagopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
					tiporiesgocheque.setFormaPagoPuntoVentas(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			tiporiesgocheque.setFormaPagoPuntoVentas(tiporiesgochequeDataAccess.getFormaPagoPuntoVentas(connexion,tiporiesgocheque));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tiporiesgocheque.setFormaPagoPuntoVentas(tiporiesgochequeDataAccess.getFormaPagoPuntoVentas(connexion,tiporiesgocheque));

		for(FormaPagoPuntoVenta formapagopuntoventa:tiporiesgocheque.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporiesgocheque.setFormaPagoPuntoVentas(tiporiesgochequeDataAccess.getFormaPagoPuntoVentas(connexion,tiporiesgocheque));

				for(FormaPagoPuntoVenta formapagopuntoventa:tiporiesgocheque.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			tiporiesgocheque.setFormaPagoPuntoVentas(tiporiesgochequeDataAccess.getFormaPagoPuntoVentas(connexion,tiporiesgocheque));

			for(FormaPagoPuntoVenta formapagopuntoventa:tiporiesgocheque.getFormaPagoPuntoVentas()) {
				FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
				formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoRiesgoCheque tiporiesgocheque,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoRiesgoCheque.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiporiesgocheque,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(tiporiesgocheque);
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
			this.deepLoad(this.tiporiesgocheque,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(this.tiporiesgocheque);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoRiesgoCheque.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiporiesgocheques!=null) {
				for(TipoRiesgoCheque tiporiesgocheque:tiporiesgocheques) {
					this.deepLoad(tiporiesgocheque,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(tiporiesgocheques);
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
			if(tiporiesgocheques!=null) {
				for(TipoRiesgoCheque tiporiesgocheque:tiporiesgocheques) {
					this.deepLoad(tiporiesgocheque,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoRiesgoChequeConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCheque(tiporiesgocheques);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoRiesgoChequeConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRiesgoChequeDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoRiesgoCheque tiporiesgocheque,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoRiesgoChequeConstantesFunciones.ISCONAUDITORIA) {
				if(tiporiesgocheque.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRiesgoChequeDataAccess.TABLENAME, tiporiesgocheque.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRiesgoChequeConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRiesgoChequeLogic.registrarAuditoriaDetallesTipoRiesgoCheque(connexion,tiporiesgocheque,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiporiesgocheque.getIsDeleted()) {
					/*if(!tiporiesgocheque.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoRiesgoChequeDataAccess.TABLENAME, tiporiesgocheque.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoRiesgoChequeLogic.registrarAuditoriaDetallesTipoRiesgoCheque(connexion,tiporiesgocheque,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRiesgoChequeDataAccess.TABLENAME, tiporiesgocheque.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiporiesgocheque.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRiesgoChequeDataAccess.TABLENAME, tiporiesgocheque.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRiesgoChequeConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRiesgoChequeLogic.registrarAuditoriaDetallesTipoRiesgoCheque(connexion,tiporiesgocheque,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoRiesgoCheque(Connexion connexion,TipoRiesgoCheque tiporiesgocheque)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiporiesgocheque.getIsNew()||!tiporiesgocheque.getnombre().equals(tiporiesgocheque.getTipoRiesgoChequeOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporiesgocheque.getTipoRiesgoChequeOriginal().getnombre()!=null)
				{
					strValorActual=tiporiesgocheque.getTipoRiesgoChequeOriginal().getnombre();
				}
				if(tiporiesgocheque.getnombre()!=null)
				{
					strValorNuevo=tiporiesgocheque.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRiesgoChequeConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tiporiesgocheque.getIsNew()||!tiporiesgocheque.getdescripcion().equals(tiporiesgocheque.getTipoRiesgoChequeOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporiesgocheque.getTipoRiesgoChequeOriginal().getdescripcion()!=null)
				{
					strValorActual=tiporiesgocheque.getTipoRiesgoChequeOriginal().getdescripcion();
				}
				if(tiporiesgocheque.getdescripcion()!=null)
				{
					strValorNuevo=tiporiesgocheque.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRiesgoChequeConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRiesgoCheque(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRiesgoChequeConstantesFunciones.getClassesForeignKeysOfTipoRiesgoCheque(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRiesgoCheque(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRiesgoChequeConstantesFunciones.getClassesRelationshipsOfTipoRiesgoCheque(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

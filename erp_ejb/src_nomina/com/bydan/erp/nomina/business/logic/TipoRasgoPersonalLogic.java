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
import com.bydan.erp.nomina.util.TipoRasgoPersonalConstantesFunciones;
import com.bydan.erp.nomina.util.TipoRasgoPersonalParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoRasgoPersonalParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoRasgoPersonal;
import com.bydan.erp.nomina.business.logic.TipoRasgoPersonalLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoRasgoPersonalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoRasgoPersonalLogic.class);
	
	protected TipoRasgoPersonalDataAccess tiporasgopersonalDataAccess; 	
	protected TipoRasgoPersonal tiporasgopersonal;
	protected List<TipoRasgoPersonal> tiporasgopersonals;
	protected Object tiporasgopersonalObject;	
	protected List<Object> tiporasgopersonalsObject;
	
	public static ClassValidator<TipoRasgoPersonal> tiporasgopersonalValidator = new ClassValidator<TipoRasgoPersonal>(TipoRasgoPersonal.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoRasgoPersonalLogicAdditional tiporasgopersonalLogicAdditional=null;
	
	public TipoRasgoPersonalLogicAdditional getTipoRasgoPersonalLogicAdditional() {
		return this.tiporasgopersonalLogicAdditional;
	}
	
	public void setTipoRasgoPersonalLogicAdditional(TipoRasgoPersonalLogicAdditional tiporasgopersonalLogicAdditional) {
		try {
			this.tiporasgopersonalLogicAdditional=tiporasgopersonalLogicAdditional;
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
	
	
	
	
	public  TipoRasgoPersonalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiporasgopersonalDataAccess = new TipoRasgoPersonalDataAccess();
			
			this.tiporasgopersonals= new ArrayList<TipoRasgoPersonal>();
			this.tiporasgopersonal= new TipoRasgoPersonal();
			
			this.tiporasgopersonalObject=new Object();
			this.tiporasgopersonalsObject=new ArrayList<Object>();
				
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
			
			this.tiporasgopersonalDataAccess.setConnexionType(this.connexionType);
			this.tiporasgopersonalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoRasgoPersonalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiporasgopersonalDataAccess = new TipoRasgoPersonalDataAccess();
			this.tiporasgopersonals= new ArrayList<TipoRasgoPersonal>();
			this.tiporasgopersonal= new TipoRasgoPersonal();
			this.tiporasgopersonalObject=new Object();
			this.tiporasgopersonalsObject=new ArrayList<Object>();
			
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
			
			this.tiporasgopersonalDataAccess.setConnexionType(this.connexionType);
			this.tiporasgopersonalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoRasgoPersonal getTipoRasgoPersonal() throws Exception {	
		TipoRasgoPersonalLogicAdditional.checkTipoRasgoPersonalToGet(tiporasgopersonal,this.datosCliente,this.arrDatoGeneral);
		TipoRasgoPersonalLogicAdditional.updateTipoRasgoPersonalToGet(tiporasgopersonal,this.arrDatoGeneral);
		
		return tiporasgopersonal;
	}
		
	public void setTipoRasgoPersonal(TipoRasgoPersonal newTipoRasgoPersonal) {
		this.tiporasgopersonal = newTipoRasgoPersonal;
	}
	
	public TipoRasgoPersonalDataAccess getTipoRasgoPersonalDataAccess() {
		return tiporasgopersonalDataAccess;
	}
	
	public void setTipoRasgoPersonalDataAccess(TipoRasgoPersonalDataAccess newtiporasgopersonalDataAccess) {
		this.tiporasgopersonalDataAccess = newtiporasgopersonalDataAccess;
	}
	
	public List<TipoRasgoPersonal> getTipoRasgoPersonals() throws Exception {		
		this.quitarTipoRasgoPersonalsNulos();
		
		TipoRasgoPersonalLogicAdditional.checkTipoRasgoPersonalToGets(tiporasgopersonals,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoRasgoPersonal tiporasgopersonalLocal: tiporasgopersonals ) {
			TipoRasgoPersonalLogicAdditional.updateTipoRasgoPersonalToGet(tiporasgopersonalLocal,this.arrDatoGeneral);
		}
		
		return tiporasgopersonals;
	}
	
	public void setTipoRasgoPersonals(List<TipoRasgoPersonal> newTipoRasgoPersonals) {
		this.tiporasgopersonals = newTipoRasgoPersonals;
	}
	
	public Object getTipoRasgoPersonalObject() {	
		this.tiporasgopersonalObject=this.tiporasgopersonalDataAccess.getEntityObject();
		return this.tiporasgopersonalObject;
	}
		
	public void setTipoRasgoPersonalObject(Object newTipoRasgoPersonalObject) {
		this.tiporasgopersonalObject = newTipoRasgoPersonalObject;
	}
	
	public List<Object> getTipoRasgoPersonalsObject() {		
		this.tiporasgopersonalsObject=this.tiporasgopersonalDataAccess.getEntitiesObject();
		return this.tiporasgopersonalsObject;
	}
		
	public void setTipoRasgoPersonalsObject(List<Object> newTipoRasgoPersonalsObject) {
		this.tiporasgopersonalsObject = newTipoRasgoPersonalsObject;
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
		
		if(this.tiporasgopersonalDataAccess!=null) {
			this.tiporasgopersonalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiporasgopersonalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiporasgopersonalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiporasgopersonal = new  TipoRasgoPersonal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporasgopersonal=tiporasgopersonalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporasgopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonal);
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
		tiporasgopersonal = new  TipoRasgoPersonal();
		  		  
        try {
			
			tiporasgopersonal=tiporasgopersonalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporasgopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiporasgopersonal = new  TipoRasgoPersonal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporasgopersonal=tiporasgopersonalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporasgopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonal);
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
		tiporasgopersonal = new  TipoRasgoPersonal();
		  		  
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
		tiporasgopersonal = new  TipoRasgoPersonal();
		  		  
        try {
			
			tiporasgopersonal=tiporasgopersonalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporasgopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiporasgopersonal = new  TipoRasgoPersonal();
		  		  
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
		tiporasgopersonal = new  TipoRasgoPersonal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiporasgopersonalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporasgopersonal = new  TipoRasgoPersonal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiporasgopersonalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporasgopersonal = new  TipoRasgoPersonal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiporasgopersonalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporasgopersonal = new  TipoRasgoPersonal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiporasgopersonalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporasgopersonal = new  TipoRasgoPersonal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiporasgopersonalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporasgopersonal = new  TipoRasgoPersonal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiporasgopersonalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporasgopersonals = new  ArrayList<TipoRasgoPersonal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporasgopersonals=tiporasgopersonalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRasgoPersonal(tiporasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonals);
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
		tiporasgopersonals = new  ArrayList<TipoRasgoPersonal>();
		  		  
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
		tiporasgopersonals = new  ArrayList<TipoRasgoPersonal>();
		  		  
        try {			
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporasgopersonals=tiporasgopersonalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoRasgoPersonal(tiporasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiporasgopersonals = new  ArrayList<TipoRasgoPersonal>();
		  		  
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
		tiporasgopersonals = new  ArrayList<TipoRasgoPersonal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporasgopersonals=tiporasgopersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRasgoPersonal(tiporasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonals);
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
		tiporasgopersonals = new  ArrayList<TipoRasgoPersonal>();
		  		  
        try {
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporasgopersonals=tiporasgopersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRasgoPersonal(tiporasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonals);
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
		tiporasgopersonals = new  ArrayList<TipoRasgoPersonal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporasgopersonals=tiporasgopersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRasgoPersonal(tiporasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonals);
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
		tiporasgopersonals = new  ArrayList<TipoRasgoPersonal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporasgopersonals=tiporasgopersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRasgoPersonal(tiporasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiporasgopersonal = new  TipoRasgoPersonal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporasgopersonal=tiporasgopersonalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRasgoPersonal(tiporasgopersonal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonal);
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
		tiporasgopersonal = new  TipoRasgoPersonal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporasgopersonal=tiporasgopersonalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRasgoPersonal(tiporasgopersonal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporasgopersonals = new  ArrayList<TipoRasgoPersonal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporasgopersonals=tiporasgopersonalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRasgoPersonal(tiporasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonals);
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
		tiporasgopersonals = new  ArrayList<TipoRasgoPersonal>();
		  		  
        try {
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporasgopersonals=tiporasgopersonalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRasgoPersonal(tiporasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoRasgoPersonalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiporasgopersonals = new  ArrayList<TipoRasgoPersonal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-getTodosTipoRasgoPersonalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporasgopersonals=tiporasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRasgoPersonal(tiporasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonals);
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
	
	public  void  getTodosTipoRasgoPersonals(String sFinalQuery,Pagination pagination)throws Exception {
		tiporasgopersonals = new  ArrayList<TipoRasgoPersonal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporasgopersonals=tiporasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRasgoPersonal(tiporasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoRasgoPersonal(TipoRasgoPersonal tiporasgopersonal) throws Exception {
		Boolean estaValidado=false;
		
		if(tiporasgopersonal.getIsNew() || tiporasgopersonal.getIsChanged()) { 
			this.invalidValues = tiporasgopersonalValidator.getInvalidValues(tiporasgopersonal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiporasgopersonal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoRasgoPersonal(List<TipoRasgoPersonal> TipoRasgoPersonals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoRasgoPersonal tiporasgopersonalLocal:tiporasgopersonals) {				
			estaValidadoObjeto=this.validarGuardarTipoRasgoPersonal(tiporasgopersonalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoRasgoPersonal(List<TipoRasgoPersonal> TipoRasgoPersonals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRasgoPersonal(tiporasgopersonals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoRasgoPersonal(TipoRasgoPersonal TipoRasgoPersonal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRasgoPersonal(tiporasgopersonal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoRasgoPersonal tiporasgopersonal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiporasgopersonal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoRasgoPersonalConstantesFunciones.getTipoRasgoPersonalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiporasgopersonal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoRasgoPersonalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoRasgoPersonalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoRasgoPersonalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-saveTipoRasgoPersonalWithConnection");connexion.begin();			
			
			TipoRasgoPersonalLogicAdditional.checkTipoRasgoPersonalToSave(this.tiporasgopersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRasgoPersonalLogicAdditional.updateTipoRasgoPersonalToSave(this.tiporasgopersonal,this.arrDatoGeneral);
			
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporasgopersonal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoRasgoPersonal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRasgoPersonal(this.tiporasgopersonal)) {
				TipoRasgoPersonalDataAccess.save(this.tiporasgopersonal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiporasgopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRasgoPersonalLogicAdditional.checkTipoRasgoPersonalToSaveAfter(this.tiporasgopersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRasgoPersonal();
			
			connexion.commit();			
			
			if(this.tiporasgopersonal.getIsDeleted()) {
				this.tiporasgopersonal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoRasgoPersonal()throws Exception {	
		try {	
			
			TipoRasgoPersonalLogicAdditional.checkTipoRasgoPersonalToSave(this.tiporasgopersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRasgoPersonalLogicAdditional.updateTipoRasgoPersonalToSave(this.tiporasgopersonal,this.arrDatoGeneral);
			
			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporasgopersonal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRasgoPersonal(this.tiporasgopersonal)) {			
				TipoRasgoPersonalDataAccess.save(this.tiporasgopersonal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiporasgopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRasgoPersonalLogicAdditional.checkTipoRasgoPersonalToSaveAfter(this.tiporasgopersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiporasgopersonal.getIsDeleted()) {
				this.tiporasgopersonal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoRasgoPersonalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-saveTipoRasgoPersonalsWithConnection");connexion.begin();			
			
			TipoRasgoPersonalLogicAdditional.checkTipoRasgoPersonalToSaves(tiporasgopersonals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoRasgoPersonals();
			
			Boolean validadoTodosTipoRasgoPersonal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRasgoPersonal tiporasgopersonalLocal:tiporasgopersonals) {		
				if(tiporasgopersonalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRasgoPersonalLogicAdditional.updateTipoRasgoPersonalToSave(tiporasgopersonalLocal,this.arrDatoGeneral);
	        	
				TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporasgopersonalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRasgoPersonal(tiporasgopersonalLocal)) {
					TipoRasgoPersonalDataAccess.save(tiporasgopersonalLocal, connexion);				
				} else {
					validadoTodosTipoRasgoPersonal=false;
				}
			}
			
			if(!validadoTodosTipoRasgoPersonal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRasgoPersonalLogicAdditional.checkTipoRasgoPersonalToSavesAfter(tiporasgopersonals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRasgoPersonals();
			
			connexion.commit();		
			
			this.quitarTipoRasgoPersonalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoRasgoPersonals()throws Exception {				
		 try {	
			TipoRasgoPersonalLogicAdditional.checkTipoRasgoPersonalToSaves(tiporasgopersonals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoRasgoPersonal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRasgoPersonal tiporasgopersonalLocal:tiporasgopersonals) {				
				if(tiporasgopersonalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRasgoPersonalLogicAdditional.updateTipoRasgoPersonalToSave(tiporasgopersonalLocal,this.arrDatoGeneral);
	        	
				TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporasgopersonalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRasgoPersonal(tiporasgopersonalLocal)) {				
					TipoRasgoPersonalDataAccess.save(tiporasgopersonalLocal, connexion);				
				} else {
					validadoTodosTipoRasgoPersonal=false;
				}
			}
			
			if(!validadoTodosTipoRasgoPersonal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRasgoPersonalLogicAdditional.checkTipoRasgoPersonalToSavesAfter(tiporasgopersonals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoRasgoPersonalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRasgoPersonalParameterReturnGeneral procesarAccionTipoRasgoPersonals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRasgoPersonal> tiporasgopersonals,TipoRasgoPersonalParameterReturnGeneral tiporasgopersonalParameterGeneral)throws Exception {
		 try {	
			TipoRasgoPersonalParameterReturnGeneral tiporasgopersonalReturnGeneral=new TipoRasgoPersonalParameterReturnGeneral();
	
			TipoRasgoPersonalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporasgopersonals,tiporasgopersonalParameterGeneral,tiporasgopersonalReturnGeneral);
			
			return tiporasgopersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRasgoPersonalParameterReturnGeneral procesarAccionTipoRasgoPersonalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRasgoPersonal> tiporasgopersonals,TipoRasgoPersonalParameterReturnGeneral tiporasgopersonalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-procesarAccionTipoRasgoPersonalsWithConnection");connexion.begin();			
			
			TipoRasgoPersonalParameterReturnGeneral tiporasgopersonalReturnGeneral=new TipoRasgoPersonalParameterReturnGeneral();
	
			TipoRasgoPersonalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporasgopersonals,tiporasgopersonalParameterGeneral,tiporasgopersonalReturnGeneral);
			
			this.connexion.commit();
			
			return tiporasgopersonalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRasgoPersonalParameterReturnGeneral procesarEventosTipoRasgoPersonals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRasgoPersonal> tiporasgopersonals,TipoRasgoPersonal tiporasgopersonal,TipoRasgoPersonalParameterReturnGeneral tiporasgopersonalParameterGeneral,Boolean isEsNuevoTipoRasgoPersonal,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoRasgoPersonalParameterReturnGeneral tiporasgopersonalReturnGeneral=new TipoRasgoPersonalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporasgopersonalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRasgoPersonalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporasgopersonals,tiporasgopersonal,tiporasgopersonalParameterGeneral,tiporasgopersonalReturnGeneral,isEsNuevoTipoRasgoPersonal,clases);
			
			return tiporasgopersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoRasgoPersonalParameterReturnGeneral procesarEventosTipoRasgoPersonalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRasgoPersonal> tiporasgopersonals,TipoRasgoPersonal tiporasgopersonal,TipoRasgoPersonalParameterReturnGeneral tiporasgopersonalParameterGeneral,Boolean isEsNuevoTipoRasgoPersonal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-procesarEventosTipoRasgoPersonalsWithConnection");connexion.begin();			
			
			TipoRasgoPersonalParameterReturnGeneral tiporasgopersonalReturnGeneral=new TipoRasgoPersonalParameterReturnGeneral();
	
			tiporasgopersonalReturnGeneral.setTipoRasgoPersonal(tiporasgopersonal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporasgopersonalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRasgoPersonalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporasgopersonals,tiporasgopersonal,tiporasgopersonalParameterGeneral,tiporasgopersonalReturnGeneral,isEsNuevoTipoRasgoPersonal,clases);
			
			this.connexion.commit();
			
			return tiporasgopersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRasgoPersonalParameterReturnGeneral procesarImportacionTipoRasgoPersonalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoRasgoPersonalParameterReturnGeneral tiporasgopersonalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-procesarImportacionTipoRasgoPersonalsWithConnection");connexion.begin();			
			
			TipoRasgoPersonalParameterReturnGeneral tiporasgopersonalReturnGeneral=new TipoRasgoPersonalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiporasgopersonals=new ArrayList<TipoRasgoPersonal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiporasgopersonal=new TipoRasgoPersonal();
				
				
				if(conColumnasBase) {this.tiporasgopersonal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiporasgopersonal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiporasgopersonal.setcodigo(arrColumnas[iColumn++]);
				this.tiporasgopersonal.setnombre(arrColumnas[iColumn++]);
				
				this.tiporasgopersonals.add(this.tiporasgopersonal);
			}
			
			this.saveTipoRasgoPersonals();
			
			this.connexion.commit();
			
			tiporasgopersonalReturnGeneral.setConRetornoEstaProcesado(true);
			tiporasgopersonalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiporasgopersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoRasgoPersonalsEliminados() throws Exception {				
		
		List<TipoRasgoPersonal> tiporasgopersonalsAux= new ArrayList<TipoRasgoPersonal>();
		
		for(TipoRasgoPersonal tiporasgopersonal:tiporasgopersonals) {
			if(!tiporasgopersonal.getIsDeleted()) {
				tiporasgopersonalsAux.add(tiporasgopersonal);
			}
		}
		
		tiporasgopersonals=tiporasgopersonalsAux;
	}
	
	public void quitarTipoRasgoPersonalsNulos() throws Exception {				
		
		List<TipoRasgoPersonal> tiporasgopersonalsAux= new ArrayList<TipoRasgoPersonal>();
		
		for(TipoRasgoPersonal tiporasgopersonal : this.tiporasgopersonals) {
			if(tiporasgopersonal==null) {
				tiporasgopersonalsAux.add(tiporasgopersonal);
			}
		}
		
		//this.tiporasgopersonals=tiporasgopersonalsAux;
		
		this.tiporasgopersonals.removeAll(tiporasgopersonalsAux);
	}
	
	public void getSetVersionRowTipoRasgoPersonalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiporasgopersonal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiporasgopersonal.getIsDeleted() || (tiporasgopersonal.getIsChanged()&&!tiporasgopersonal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiporasgopersonalDataAccess.getSetVersionRowTipoRasgoPersonal(connexion,tiporasgopersonal.getId());
				
				if(!tiporasgopersonal.getVersionRow().equals(timestamp)) {	
					tiporasgopersonal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiporasgopersonal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoRasgoPersonal()throws Exception {	
		
		if(tiporasgopersonal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiporasgopersonal.getIsDeleted() || (tiporasgopersonal.getIsChanged()&&!tiporasgopersonal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiporasgopersonalDataAccess.getSetVersionRowTipoRasgoPersonal(connexion,tiporasgopersonal.getId());
			
			try {							
				if(!tiporasgopersonal.getVersionRow().equals(timestamp)) {	
					tiporasgopersonal.setVersionRow(timestamp);
				}
				
				tiporasgopersonal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoRasgoPersonalsWithConnection()throws Exception {	
		if(tiporasgopersonals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoRasgoPersonal tiporasgopersonalAux:tiporasgopersonals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiporasgopersonalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporasgopersonalAux.getIsDeleted() || (tiporasgopersonalAux.getIsChanged()&&!tiporasgopersonalAux.getIsNew())) {
						
						timestamp=tiporasgopersonalDataAccess.getSetVersionRowTipoRasgoPersonal(connexion,tiporasgopersonalAux.getId());
						
						if(!tiporasgopersonal.getVersionRow().equals(timestamp)) {	
							tiporasgopersonalAux.setVersionRow(timestamp);
						}
								
						tiporasgopersonalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoRasgoPersonals()throws Exception {	
		if(tiporasgopersonals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoRasgoPersonal tiporasgopersonalAux:tiporasgopersonals) {
					if(tiporasgopersonalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporasgopersonalAux.getIsDeleted() || (tiporasgopersonalAux.getIsChanged()&&!tiporasgopersonalAux.getIsNew())) {
						
						timestamp=tiporasgopersonalDataAccess.getSetVersionRowTipoRasgoPersonal(connexion,tiporasgopersonalAux.getId());
						
						if(!tiporasgopersonalAux.getVersionRow().equals(timestamp)) {	
							tiporasgopersonalAux.setVersionRow(timestamp);
						}
						
													
						tiporasgopersonalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoRasgoPersonalParameterReturnGeneral cargarCombosLoteForeignKeyTipoRasgoPersonalWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoRasgoPersonalParameterReturnGeneral  tiporasgopersonalReturnGeneral =new TipoRasgoPersonalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoRasgoPersonalWithConnection");connexion.begin();
			
			tiporasgopersonalReturnGeneral =new TipoRasgoPersonalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiporasgopersonalReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tiporasgopersonalReturnGeneral;
	}
	
	public TipoRasgoPersonalParameterReturnGeneral cargarCombosLoteForeignKeyTipoRasgoPersonal(String finalQueryGlobalEmpresa) throws Exception {
		TipoRasgoPersonalParameterReturnGeneral  tiporasgopersonalReturnGeneral =new TipoRasgoPersonalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tiporasgopersonalReturnGeneral =new TipoRasgoPersonalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiporasgopersonalReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tiporasgopersonalReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoRasgoPersonalWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			RasgoPersonalLogic rasgopersonalLogic=new RasgoPersonalLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoRasgoPersonalWithConnection");connexion.begin();
			
			
			classes.add(new Classe(RasgoPersonal.class));
											
			

			rasgopersonalLogic.setConnexion(this.getConnexion());
			rasgopersonalLogic.setDatosCliente(this.datosCliente);
			rasgopersonalLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoRasgoPersonal tiporasgopersonal:this.tiporasgopersonals) {
				

				classes=new ArrayList<Classe>();
				classes=RasgoPersonalConstantesFunciones.getClassesForeignKeysOfRasgoPersonal(new ArrayList<Classe>(),DeepLoadType.NONE);

				rasgopersonalLogic.setRasgoPersonals(tiporasgopersonal.rasgopersonals);
				rasgopersonalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoRasgoPersonal tiporasgopersonal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoRasgoPersonalLogicAdditional.updateTipoRasgoPersonalToGet(tiporasgopersonal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporasgopersonal.setEmpresa(tiporasgopersonalDataAccess.getEmpresa(connexion,tiporasgopersonal));
		tiporasgopersonal.setRasgoPersonals(tiporasgopersonalDataAccess.getRasgoPersonals(connexion,tiporasgopersonal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiporasgopersonal.setEmpresa(tiporasgopersonalDataAccess.getEmpresa(connexion,tiporasgopersonal));
				continue;
			}

			if(clas.clas.equals(RasgoPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporasgopersonal.setRasgoPersonals(tiporasgopersonalDataAccess.getRasgoPersonals(connexion,tiporasgopersonal));

				if(this.isConDeep) {
					RasgoPersonalLogic rasgopersonalLogic= new RasgoPersonalLogic(this.connexion);
					rasgopersonalLogic.setRasgoPersonals(tiporasgopersonal.getRasgoPersonals());
					ArrayList<Classe> classesLocal=RasgoPersonalConstantesFunciones.getClassesForeignKeysOfRasgoPersonal(new ArrayList<Classe>(),DeepLoadType.NONE);
					rasgopersonalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(rasgopersonalLogic.getRasgoPersonals());
					tiporasgopersonal.setRasgoPersonals(rasgopersonalLogic.getRasgoPersonals());
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
			tiporasgopersonal.setEmpresa(tiporasgopersonalDataAccess.getEmpresa(connexion,tiporasgopersonal));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RasgoPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RasgoPersonal.class));
			tiporasgopersonal.setRasgoPersonals(tiporasgopersonalDataAccess.getRasgoPersonals(connexion,tiporasgopersonal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporasgopersonal.setEmpresa(tiporasgopersonalDataAccess.getEmpresa(connexion,tiporasgopersonal));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiporasgopersonal.getEmpresa(),isDeep,deepLoadType,clases);
				

		tiporasgopersonal.setRasgoPersonals(tiporasgopersonalDataAccess.getRasgoPersonals(connexion,tiporasgopersonal));

		for(RasgoPersonal rasgopersonal:tiporasgopersonal.getRasgoPersonals()) {
			RasgoPersonalLogic rasgopersonalLogic= new RasgoPersonalLogic(connexion);
			rasgopersonalLogic.deepLoad(rasgopersonal,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiporasgopersonal.setEmpresa(tiporasgopersonalDataAccess.getEmpresa(connexion,tiporasgopersonal));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tiporasgopersonal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RasgoPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporasgopersonal.setRasgoPersonals(tiporasgopersonalDataAccess.getRasgoPersonals(connexion,tiporasgopersonal));

				for(RasgoPersonal rasgopersonal:tiporasgopersonal.getRasgoPersonals()) {
					RasgoPersonalLogic rasgopersonalLogic= new RasgoPersonalLogic(connexion);
					rasgopersonalLogic.deepLoad(rasgopersonal,isDeep,deepLoadType,clases);
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
			tiporasgopersonal.setEmpresa(tiporasgopersonalDataAccess.getEmpresa(connexion,tiporasgopersonal));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tiporasgopersonal.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RasgoPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RasgoPersonal.class));
			tiporasgopersonal.setRasgoPersonals(tiporasgopersonalDataAccess.getRasgoPersonals(connexion,tiporasgopersonal));

			for(RasgoPersonal rasgopersonal:tiporasgopersonal.getRasgoPersonals()) {
				RasgoPersonalLogic rasgopersonalLogic= new RasgoPersonalLogic(connexion);
				rasgopersonalLogic.deepLoad(rasgopersonal,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoRasgoPersonal tiporasgopersonal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoRasgoPersonalLogicAdditional.updateTipoRasgoPersonalToSave(tiporasgopersonal,this.arrDatoGeneral);
			
TipoRasgoPersonalDataAccess.save(tiporasgopersonal, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiporasgopersonal.getEmpresa(),connexion);

		for(RasgoPersonal rasgopersonal:tiporasgopersonal.getRasgoPersonals()) {
			rasgopersonal.setid_tipo_rasgo_personal(tiporasgopersonal.getId());
			RasgoPersonalDataAccess.save(rasgopersonal,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiporasgopersonal.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(RasgoPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RasgoPersonal rasgopersonal:tiporasgopersonal.getRasgoPersonals()) {
					rasgopersonal.setid_tipo_rasgo_personal(tiporasgopersonal.getId());
					RasgoPersonalDataAccess.save(rasgopersonal,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiporasgopersonal.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiporasgopersonal.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(RasgoPersonal rasgopersonal:tiporasgopersonal.getRasgoPersonals()) {
			RasgoPersonalLogic rasgopersonalLogic= new RasgoPersonalLogic(connexion);
			rasgopersonal.setid_tipo_rasgo_personal(tiporasgopersonal.getId());
			RasgoPersonalDataAccess.save(rasgopersonal,connexion);
			rasgopersonalLogic.deepSave(rasgopersonal,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiporasgopersonal.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tiporasgopersonal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(RasgoPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RasgoPersonal rasgopersonal:tiporasgopersonal.getRasgoPersonals()) {
					RasgoPersonalLogic rasgopersonalLogic= new RasgoPersonalLogic(connexion);
					rasgopersonal.setid_tipo_rasgo_personal(tiporasgopersonal.getId());
					RasgoPersonalDataAccess.save(rasgopersonal,connexion);
					rasgopersonalLogic.deepSave(rasgopersonal,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoRasgoPersonal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiporasgopersonal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(tiporasgopersonal);
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
			this.deepLoad(this.tiporasgopersonal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoRasgoPersonal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiporasgopersonals!=null) {
				for(TipoRasgoPersonal tiporasgopersonal:tiporasgopersonals) {
					this.deepLoad(tiporasgopersonal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(tiporasgopersonals);
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
			if(tiporasgopersonals!=null) {
				for(TipoRasgoPersonal tiporasgopersonal:tiporasgopersonals) {
					this.deepLoad(tiporasgopersonal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(tiporasgopersonals);
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
			this.getNewConnexionToDeep(TipoRasgoPersonal.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiporasgopersonal,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoRasgoPersonal.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiporasgopersonals!=null) {
				for(TipoRasgoPersonal tiporasgopersonal:tiporasgopersonals) {
					this.deepSave(tiporasgopersonal,isDeep,deepLoadType,clases);
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
			if(tiporasgopersonals!=null) {
				for(TipoRasgoPersonal tiporasgopersonal:tiporasgopersonals) {
					this.deepSave(tiporasgopersonal,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoRasgoPersonalsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRasgoPersonal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoRasgoPersonalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporasgopersonals=tiporasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRasgoPersonalsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoRasgoPersonalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoRasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporasgopersonals=tiporasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoRasgoPersonal(this.tiporasgopersonals);
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
			if(TipoRasgoPersonalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRasgoPersonalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoRasgoPersonal tiporasgopersonal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoRasgoPersonalConstantesFunciones.ISCONAUDITORIA) {
				if(tiporasgopersonal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRasgoPersonalDataAccess.TABLENAME, tiporasgopersonal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRasgoPersonalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRasgoPersonalLogic.registrarAuditoriaDetallesTipoRasgoPersonal(connexion,tiporasgopersonal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiporasgopersonal.getIsDeleted()) {
					/*if(!tiporasgopersonal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoRasgoPersonalDataAccess.TABLENAME, tiporasgopersonal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoRasgoPersonalLogic.registrarAuditoriaDetallesTipoRasgoPersonal(connexion,tiporasgopersonal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRasgoPersonalDataAccess.TABLENAME, tiporasgopersonal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiporasgopersonal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRasgoPersonalDataAccess.TABLENAME, tiporasgopersonal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRasgoPersonalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRasgoPersonalLogic.registrarAuditoriaDetallesTipoRasgoPersonal(connexion,tiporasgopersonal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoRasgoPersonal(Connexion connexion,TipoRasgoPersonal tiporasgopersonal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiporasgopersonal.getIsNew()||!tiporasgopersonal.getid_empresa().equals(tiporasgopersonal.getTipoRasgoPersonalOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporasgopersonal.getTipoRasgoPersonalOriginal().getid_empresa()!=null)
				{
					strValorActual=tiporasgopersonal.getTipoRasgoPersonalOriginal().getid_empresa().toString();
				}
				if(tiporasgopersonal.getid_empresa()!=null)
				{
					strValorNuevo=tiporasgopersonal.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRasgoPersonalConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tiporasgopersonal.getIsNew()||!tiporasgopersonal.getcodigo().equals(tiporasgopersonal.getTipoRasgoPersonalOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporasgopersonal.getTipoRasgoPersonalOriginal().getcodigo()!=null)
				{
					strValorActual=tiporasgopersonal.getTipoRasgoPersonalOriginal().getcodigo();
				}
				if(tiporasgopersonal.getcodigo()!=null)
				{
					strValorNuevo=tiporasgopersonal.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRasgoPersonalConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiporasgopersonal.getIsNew()||!tiporasgopersonal.getnombre().equals(tiporasgopersonal.getTipoRasgoPersonalOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporasgopersonal.getTipoRasgoPersonalOriginal().getnombre()!=null)
				{
					strValorActual=tiporasgopersonal.getTipoRasgoPersonalOriginal().getnombre();
				}
				if(tiporasgopersonal.getnombre()!=null)
				{
					strValorNuevo=tiporasgopersonal.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRasgoPersonalConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoRasgoPersonalRelacionesWithConnection(TipoRasgoPersonal tiporasgopersonal,List<RasgoPersonal> rasgopersonals) throws Exception {

		if(!tiporasgopersonal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRasgoPersonalRelacionesBase(tiporasgopersonal,rasgopersonals,true);
		}
	}

	public void saveTipoRasgoPersonalRelaciones(TipoRasgoPersonal tiporasgopersonal,List<RasgoPersonal> rasgopersonals)throws Exception {

		if(!tiporasgopersonal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRasgoPersonalRelacionesBase(tiporasgopersonal,rasgopersonals,false);
		}
	}

	public void saveTipoRasgoPersonalRelacionesBase(TipoRasgoPersonal tiporasgopersonal,List<RasgoPersonal> rasgopersonals,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoRasgoPersonal-saveRelacionesWithConnection");}
	
			tiporasgopersonal.setRasgoPersonals(rasgopersonals);

			this.setTipoRasgoPersonal(tiporasgopersonal);

			if(TipoRasgoPersonalLogicAdditional.validarSaveRelaciones(tiporasgopersonal,this)) {

				TipoRasgoPersonalLogicAdditional.updateRelacionesToSave(tiporasgopersonal,this);

				if((tiporasgopersonal.getIsNew()||tiporasgopersonal.getIsChanged())&&!tiporasgopersonal.getIsDeleted()) {
					this.saveTipoRasgoPersonal();
					this.saveTipoRasgoPersonalRelacionesDetalles(rasgopersonals);

				} else if(tiporasgopersonal.getIsDeleted()) {
					this.saveTipoRasgoPersonalRelacionesDetalles(rasgopersonals);
					this.saveTipoRasgoPersonal();
				}

				TipoRasgoPersonalLogicAdditional.updateRelacionesToSaveAfter(tiporasgopersonal,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			RasgoPersonalConstantesFunciones.InicializarGeneralEntityAuxiliaresRasgoPersonals(rasgopersonals,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoRasgoPersonalRelacionesDetalles(List<RasgoPersonal> rasgopersonals)throws Exception {
		try {
	

			Long idTipoRasgoPersonalActual=this.getTipoRasgoPersonal().getId();

			RasgoPersonalLogic rasgopersonalLogic_Desde_TipoRasgoPersonal=new RasgoPersonalLogic();
			rasgopersonalLogic_Desde_TipoRasgoPersonal.setRasgoPersonals(rasgopersonals);

			rasgopersonalLogic_Desde_TipoRasgoPersonal.setConnexion(this.getConnexion());
			rasgopersonalLogic_Desde_TipoRasgoPersonal.setDatosCliente(this.datosCliente);

			for(RasgoPersonal rasgopersonal_Desde_TipoRasgoPersonal:rasgopersonalLogic_Desde_TipoRasgoPersonal.getRasgoPersonals()) {
				rasgopersonal_Desde_TipoRasgoPersonal.setid_tipo_rasgo_personal(idTipoRasgoPersonalActual);
			}

			rasgopersonalLogic_Desde_TipoRasgoPersonal.saveRasgoPersonals();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRasgoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRasgoPersonalConstantesFunciones.getClassesForeignKeysOfTipoRasgoPersonal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRasgoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRasgoPersonalConstantesFunciones.getClassesRelationshipsOfTipoRasgoPersonal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

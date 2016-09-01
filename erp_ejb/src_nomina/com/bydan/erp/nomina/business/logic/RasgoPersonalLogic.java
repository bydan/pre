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
import com.bydan.erp.nomina.util.RasgoPersonalConstantesFunciones;
import com.bydan.erp.nomina.util.RasgoPersonalParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RasgoPersonalParameterGeneral;
import com.bydan.erp.nomina.business.entity.RasgoPersonal;
import com.bydan.erp.nomina.business.logic.RasgoPersonalLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class RasgoPersonalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RasgoPersonalLogic.class);
	
	protected RasgoPersonalDataAccess rasgopersonalDataAccess; 	
	protected RasgoPersonal rasgopersonal;
	protected List<RasgoPersonal> rasgopersonals;
	protected Object rasgopersonalObject;	
	protected List<Object> rasgopersonalsObject;
	
	public static ClassValidator<RasgoPersonal> rasgopersonalValidator = new ClassValidator<RasgoPersonal>(RasgoPersonal.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RasgoPersonalLogicAdditional rasgopersonalLogicAdditional=null;
	
	public RasgoPersonalLogicAdditional getRasgoPersonalLogicAdditional() {
		return this.rasgopersonalLogicAdditional;
	}
	
	public void setRasgoPersonalLogicAdditional(RasgoPersonalLogicAdditional rasgopersonalLogicAdditional) {
		try {
			this.rasgopersonalLogicAdditional=rasgopersonalLogicAdditional;
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
	
	
	
	
	public  RasgoPersonalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.rasgopersonalDataAccess = new RasgoPersonalDataAccess();
			
			this.rasgopersonals= new ArrayList<RasgoPersonal>();
			this.rasgopersonal= new RasgoPersonal();
			
			this.rasgopersonalObject=new Object();
			this.rasgopersonalsObject=new ArrayList<Object>();
				
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
			
			this.rasgopersonalDataAccess.setConnexionType(this.connexionType);
			this.rasgopersonalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RasgoPersonalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.rasgopersonalDataAccess = new RasgoPersonalDataAccess();
			this.rasgopersonals= new ArrayList<RasgoPersonal>();
			this.rasgopersonal= new RasgoPersonal();
			this.rasgopersonalObject=new Object();
			this.rasgopersonalsObject=new ArrayList<Object>();
			
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
			
			this.rasgopersonalDataAccess.setConnexionType(this.connexionType);
			this.rasgopersonalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RasgoPersonal getRasgoPersonal() throws Exception {	
		RasgoPersonalLogicAdditional.checkRasgoPersonalToGet(rasgopersonal,this.datosCliente,this.arrDatoGeneral);
		RasgoPersonalLogicAdditional.updateRasgoPersonalToGet(rasgopersonal,this.arrDatoGeneral);
		
		return rasgopersonal;
	}
		
	public void setRasgoPersonal(RasgoPersonal newRasgoPersonal) {
		this.rasgopersonal = newRasgoPersonal;
	}
	
	public RasgoPersonalDataAccess getRasgoPersonalDataAccess() {
		return rasgopersonalDataAccess;
	}
	
	public void setRasgoPersonalDataAccess(RasgoPersonalDataAccess newrasgopersonalDataAccess) {
		this.rasgopersonalDataAccess = newrasgopersonalDataAccess;
	}
	
	public List<RasgoPersonal> getRasgoPersonals() throws Exception {		
		this.quitarRasgoPersonalsNulos();
		
		RasgoPersonalLogicAdditional.checkRasgoPersonalToGets(rasgopersonals,this.datosCliente,this.arrDatoGeneral);
		
		for (RasgoPersonal rasgopersonalLocal: rasgopersonals ) {
			RasgoPersonalLogicAdditional.updateRasgoPersonalToGet(rasgopersonalLocal,this.arrDatoGeneral);
		}
		
		return rasgopersonals;
	}
	
	public void setRasgoPersonals(List<RasgoPersonal> newRasgoPersonals) {
		this.rasgopersonals = newRasgoPersonals;
	}
	
	public Object getRasgoPersonalObject() {	
		this.rasgopersonalObject=this.rasgopersonalDataAccess.getEntityObject();
		return this.rasgopersonalObject;
	}
		
	public void setRasgoPersonalObject(Object newRasgoPersonalObject) {
		this.rasgopersonalObject = newRasgoPersonalObject;
	}
	
	public List<Object> getRasgoPersonalsObject() {		
		this.rasgopersonalsObject=this.rasgopersonalDataAccess.getEntitiesObject();
		return this.rasgopersonalsObject;
	}
		
	public void setRasgoPersonalsObject(List<Object> newRasgoPersonalsObject) {
		this.rasgopersonalsObject = newRasgoPersonalsObject;
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
		
		if(this.rasgopersonalDataAccess!=null) {
			this.rasgopersonalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			rasgopersonalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			rasgopersonalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		rasgopersonal = new  RasgoPersonal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rasgopersonal=rasgopersonalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rasgopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonal);
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
		rasgopersonal = new  RasgoPersonal();
		  		  
        try {
			
			rasgopersonal=rasgopersonalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rasgopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		rasgopersonal = new  RasgoPersonal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rasgopersonal=rasgopersonalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rasgopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonal);
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
		rasgopersonal = new  RasgoPersonal();
		  		  
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
		rasgopersonal = new  RasgoPersonal();
		  		  
        try {
			
			rasgopersonal=rasgopersonalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rasgopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		rasgopersonal = new  RasgoPersonal();
		  		  
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
		rasgopersonal = new  RasgoPersonal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =rasgopersonalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rasgopersonal = new  RasgoPersonal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=rasgopersonalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rasgopersonal = new  RasgoPersonal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =rasgopersonalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rasgopersonal = new  RasgoPersonal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=rasgopersonalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rasgopersonal = new  RasgoPersonal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =rasgopersonalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rasgopersonal = new  RasgoPersonal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=rasgopersonalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rasgopersonals = new  ArrayList<RasgoPersonal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRasgoPersonal(rasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
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
		rasgopersonals = new  ArrayList<RasgoPersonal>();
		  		  
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
		rasgopersonals = new  ArrayList<RasgoPersonal>();
		  		  
        try {			
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRasgoPersonal(rasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		rasgopersonals = new  ArrayList<RasgoPersonal>();
		  		  
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
		rasgopersonals = new  ArrayList<RasgoPersonal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRasgoPersonal(rasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
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
		rasgopersonals = new  ArrayList<RasgoPersonal>();
		  		  
        try {
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRasgoPersonal(rasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
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
		rasgopersonals = new  ArrayList<RasgoPersonal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRasgoPersonal(rasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
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
		rasgopersonals = new  ArrayList<RasgoPersonal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRasgoPersonal(rasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		rasgopersonal = new  RasgoPersonal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rasgopersonal=rasgopersonalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRasgoPersonal(rasgopersonal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonal);
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
		rasgopersonal = new  RasgoPersonal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rasgopersonal=rasgopersonalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRasgoPersonal(rasgopersonal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rasgopersonals = new  ArrayList<RasgoPersonal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rasgopersonals=rasgopersonalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRasgoPersonal(rasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
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
		rasgopersonals = new  ArrayList<RasgoPersonal>();
		  		  
        try {
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rasgopersonals=rasgopersonalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRasgoPersonal(rasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRasgoPersonalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		rasgopersonals = new  ArrayList<RasgoPersonal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getTodosRasgoPersonalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRasgoPersonal(rasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
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
	
	public  void  getTodosRasgoPersonals(String sFinalQuery,Pagination pagination)throws Exception {
		rasgopersonals = new  ArrayList<RasgoPersonal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRasgoPersonal(rasgopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRasgoPersonal(RasgoPersonal rasgopersonal) throws Exception {
		Boolean estaValidado=false;
		
		if(rasgopersonal.getIsNew() || rasgopersonal.getIsChanged()) { 
			this.invalidValues = rasgopersonalValidator.getInvalidValues(rasgopersonal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(rasgopersonal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRasgoPersonal(List<RasgoPersonal> RasgoPersonals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RasgoPersonal rasgopersonalLocal:rasgopersonals) {				
			estaValidadoObjeto=this.validarGuardarRasgoPersonal(rasgopersonalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRasgoPersonal(List<RasgoPersonal> RasgoPersonals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRasgoPersonal(rasgopersonals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRasgoPersonal(RasgoPersonal RasgoPersonal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRasgoPersonal(rasgopersonal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RasgoPersonal rasgopersonal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+rasgopersonal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RasgoPersonalConstantesFunciones.getRasgoPersonalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"rasgopersonal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RasgoPersonalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RasgoPersonalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRasgoPersonalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-saveRasgoPersonalWithConnection");connexion.begin();			
			
			RasgoPersonalLogicAdditional.checkRasgoPersonalToSave(this.rasgopersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RasgoPersonalLogicAdditional.updateRasgoPersonalToSave(this.rasgopersonal,this.arrDatoGeneral);
			
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rasgopersonal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRasgoPersonal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRasgoPersonal(this.rasgopersonal)) {
				RasgoPersonalDataAccess.save(this.rasgopersonal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.rasgopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RasgoPersonalLogicAdditional.checkRasgoPersonalToSaveAfter(this.rasgopersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRasgoPersonal();
			
			connexion.commit();			
			
			if(this.rasgopersonal.getIsDeleted()) {
				this.rasgopersonal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRasgoPersonal()throws Exception {	
		try {	
			
			RasgoPersonalLogicAdditional.checkRasgoPersonalToSave(this.rasgopersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RasgoPersonalLogicAdditional.updateRasgoPersonalToSave(this.rasgopersonal,this.arrDatoGeneral);
			
			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rasgopersonal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRasgoPersonal(this.rasgopersonal)) {			
				RasgoPersonalDataAccess.save(this.rasgopersonal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.rasgopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RasgoPersonalLogicAdditional.checkRasgoPersonalToSaveAfter(this.rasgopersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.rasgopersonal.getIsDeleted()) {
				this.rasgopersonal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRasgoPersonalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-saveRasgoPersonalsWithConnection");connexion.begin();			
			
			RasgoPersonalLogicAdditional.checkRasgoPersonalToSaves(rasgopersonals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRasgoPersonals();
			
			Boolean validadoTodosRasgoPersonal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RasgoPersonal rasgopersonalLocal:rasgopersonals) {		
				if(rasgopersonalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RasgoPersonalLogicAdditional.updateRasgoPersonalToSave(rasgopersonalLocal,this.arrDatoGeneral);
	        	
				RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rasgopersonalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRasgoPersonal(rasgopersonalLocal)) {
					RasgoPersonalDataAccess.save(rasgopersonalLocal, connexion);				
				} else {
					validadoTodosRasgoPersonal=false;
				}
			}
			
			if(!validadoTodosRasgoPersonal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RasgoPersonalLogicAdditional.checkRasgoPersonalToSavesAfter(rasgopersonals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRasgoPersonals();
			
			connexion.commit();		
			
			this.quitarRasgoPersonalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRasgoPersonals()throws Exception {				
		 try {	
			RasgoPersonalLogicAdditional.checkRasgoPersonalToSaves(rasgopersonals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRasgoPersonal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RasgoPersonal rasgopersonalLocal:rasgopersonals) {				
				if(rasgopersonalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RasgoPersonalLogicAdditional.updateRasgoPersonalToSave(rasgopersonalLocal,this.arrDatoGeneral);
	        	
				RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rasgopersonalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRasgoPersonal(rasgopersonalLocal)) {				
					RasgoPersonalDataAccess.save(rasgopersonalLocal, connexion);				
				} else {
					validadoTodosRasgoPersonal=false;
				}
			}
			
			if(!validadoTodosRasgoPersonal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RasgoPersonalLogicAdditional.checkRasgoPersonalToSavesAfter(rasgopersonals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRasgoPersonalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RasgoPersonalParameterReturnGeneral procesarAccionRasgoPersonals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RasgoPersonal> rasgopersonals,RasgoPersonalParameterReturnGeneral rasgopersonalParameterGeneral)throws Exception {
		 try {	
			RasgoPersonalParameterReturnGeneral rasgopersonalReturnGeneral=new RasgoPersonalParameterReturnGeneral();
	
			RasgoPersonalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rasgopersonals,rasgopersonalParameterGeneral,rasgopersonalReturnGeneral);
			
			return rasgopersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RasgoPersonalParameterReturnGeneral procesarAccionRasgoPersonalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RasgoPersonal> rasgopersonals,RasgoPersonalParameterReturnGeneral rasgopersonalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-procesarAccionRasgoPersonalsWithConnection");connexion.begin();			
			
			RasgoPersonalParameterReturnGeneral rasgopersonalReturnGeneral=new RasgoPersonalParameterReturnGeneral();
	
			RasgoPersonalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rasgopersonals,rasgopersonalParameterGeneral,rasgopersonalReturnGeneral);
			
			this.connexion.commit();
			
			return rasgopersonalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RasgoPersonalParameterReturnGeneral procesarEventosRasgoPersonals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RasgoPersonal> rasgopersonals,RasgoPersonal rasgopersonal,RasgoPersonalParameterReturnGeneral rasgopersonalParameterGeneral,Boolean isEsNuevoRasgoPersonal,ArrayList<Classe> clases)throws Exception {
		 try {	
			RasgoPersonalParameterReturnGeneral rasgopersonalReturnGeneral=new RasgoPersonalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rasgopersonalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RasgoPersonalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rasgopersonals,rasgopersonal,rasgopersonalParameterGeneral,rasgopersonalReturnGeneral,isEsNuevoRasgoPersonal,clases);
			
			return rasgopersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RasgoPersonalParameterReturnGeneral procesarEventosRasgoPersonalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RasgoPersonal> rasgopersonals,RasgoPersonal rasgopersonal,RasgoPersonalParameterReturnGeneral rasgopersonalParameterGeneral,Boolean isEsNuevoRasgoPersonal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-procesarEventosRasgoPersonalsWithConnection");connexion.begin();			
			
			RasgoPersonalParameterReturnGeneral rasgopersonalReturnGeneral=new RasgoPersonalParameterReturnGeneral();
	
			rasgopersonalReturnGeneral.setRasgoPersonal(rasgopersonal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rasgopersonalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RasgoPersonalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rasgopersonals,rasgopersonal,rasgopersonalParameterGeneral,rasgopersonalReturnGeneral,isEsNuevoRasgoPersonal,clases);
			
			this.connexion.commit();
			
			return rasgopersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RasgoPersonalParameterReturnGeneral procesarImportacionRasgoPersonalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RasgoPersonalParameterReturnGeneral rasgopersonalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-procesarImportacionRasgoPersonalsWithConnection");connexion.begin();			
			
			RasgoPersonalParameterReturnGeneral rasgopersonalReturnGeneral=new RasgoPersonalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.rasgopersonals=new ArrayList<RasgoPersonal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.rasgopersonal=new RasgoPersonal();
				
				
				if(conColumnasBase) {this.rasgopersonal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.rasgopersonal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.rasgopersonal.setdescripcion(arrColumnas[iColumn++]);
				
				this.rasgopersonals.add(this.rasgopersonal);
			}
			
			this.saveRasgoPersonals();
			
			this.connexion.commit();
			
			rasgopersonalReturnGeneral.setConRetornoEstaProcesado(true);
			rasgopersonalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return rasgopersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRasgoPersonalsEliminados() throws Exception {				
		
		List<RasgoPersonal> rasgopersonalsAux= new ArrayList<RasgoPersonal>();
		
		for(RasgoPersonal rasgopersonal:rasgopersonals) {
			if(!rasgopersonal.getIsDeleted()) {
				rasgopersonalsAux.add(rasgopersonal);
			}
		}
		
		rasgopersonals=rasgopersonalsAux;
	}
	
	public void quitarRasgoPersonalsNulos() throws Exception {				
		
		List<RasgoPersonal> rasgopersonalsAux= new ArrayList<RasgoPersonal>();
		
		for(RasgoPersonal rasgopersonal : this.rasgopersonals) {
			if(rasgopersonal==null) {
				rasgopersonalsAux.add(rasgopersonal);
			}
		}
		
		//this.rasgopersonals=rasgopersonalsAux;
		
		this.rasgopersonals.removeAll(rasgopersonalsAux);
	}
	
	public void getSetVersionRowRasgoPersonalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(rasgopersonal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((rasgopersonal.getIsDeleted() || (rasgopersonal.getIsChanged()&&!rasgopersonal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=rasgopersonalDataAccess.getSetVersionRowRasgoPersonal(connexion,rasgopersonal.getId());
				
				if(!rasgopersonal.getVersionRow().equals(timestamp)) {	
					rasgopersonal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				rasgopersonal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRasgoPersonal()throws Exception {	
		
		if(rasgopersonal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((rasgopersonal.getIsDeleted() || (rasgopersonal.getIsChanged()&&!rasgopersonal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=rasgopersonalDataAccess.getSetVersionRowRasgoPersonal(connexion,rasgopersonal.getId());
			
			try {							
				if(!rasgopersonal.getVersionRow().equals(timestamp)) {	
					rasgopersonal.setVersionRow(timestamp);
				}
				
				rasgopersonal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRasgoPersonalsWithConnection()throws Exception {	
		if(rasgopersonals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RasgoPersonal rasgopersonalAux:rasgopersonals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(rasgopersonalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rasgopersonalAux.getIsDeleted() || (rasgopersonalAux.getIsChanged()&&!rasgopersonalAux.getIsNew())) {
						
						timestamp=rasgopersonalDataAccess.getSetVersionRowRasgoPersonal(connexion,rasgopersonalAux.getId());
						
						if(!rasgopersonal.getVersionRow().equals(timestamp)) {	
							rasgopersonalAux.setVersionRow(timestamp);
						}
								
						rasgopersonalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRasgoPersonals()throws Exception {	
		if(rasgopersonals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RasgoPersonal rasgopersonalAux:rasgopersonals) {
					if(rasgopersonalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rasgopersonalAux.getIsDeleted() || (rasgopersonalAux.getIsChanged()&&!rasgopersonalAux.getIsNew())) {
						
						timestamp=rasgopersonalDataAccess.getSetVersionRowRasgoPersonal(connexion,rasgopersonalAux.getId());
						
						if(!rasgopersonalAux.getVersionRow().equals(timestamp)) {	
							rasgopersonalAux.setVersionRow(timestamp);
						}
						
													
						rasgopersonalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RasgoPersonalParameterReturnGeneral cargarCombosLoteForeignKeyRasgoPersonalWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoRasgoPersonal) throws Exception {
		RasgoPersonalParameterReturnGeneral  rasgopersonalReturnGeneral =new RasgoPersonalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-cargarCombosLoteForeignKeyRasgoPersonalWithConnection");connexion.begin();
			
			rasgopersonalReturnGeneral =new RasgoPersonalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rasgopersonalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			rasgopersonalReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoRasgoPersonal> tiporasgopersonalsForeignKey=new ArrayList<TipoRasgoPersonal>();
			TipoRasgoPersonalLogic tiporasgopersonalLogic=new TipoRasgoPersonalLogic();
			tiporasgopersonalLogic.setConnexion(this.connexion);
			tiporasgopersonalLogic.getTipoRasgoPersonalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRasgoPersonal.equals("NONE")) {
				tiporasgopersonalLogic.getTodosTipoRasgoPersonals(finalQueryGlobalTipoRasgoPersonal,new Pagination());
				tiporasgopersonalsForeignKey=tiporasgopersonalLogic.getTipoRasgoPersonals();
			}

			rasgopersonalReturnGeneral.settiporasgopersonalsForeignKey(tiporasgopersonalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return rasgopersonalReturnGeneral;
	}
	
	public RasgoPersonalParameterReturnGeneral cargarCombosLoteForeignKeyRasgoPersonal(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoRasgoPersonal) throws Exception {
		RasgoPersonalParameterReturnGeneral  rasgopersonalReturnGeneral =new RasgoPersonalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			rasgopersonalReturnGeneral =new RasgoPersonalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rasgopersonalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			rasgopersonalReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoRasgoPersonal> tiporasgopersonalsForeignKey=new ArrayList<TipoRasgoPersonal>();
			TipoRasgoPersonalLogic tiporasgopersonalLogic=new TipoRasgoPersonalLogic();
			tiporasgopersonalLogic.setConnexion(this.connexion);
			tiporasgopersonalLogic.getTipoRasgoPersonalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRasgoPersonal.equals("NONE")) {
				tiporasgopersonalLogic.getTodosTipoRasgoPersonals(finalQueryGlobalTipoRasgoPersonal,new Pagination());
				tiporasgopersonalsForeignKey=tiporasgopersonalLogic.getTipoRasgoPersonals();
			}

			rasgopersonalReturnGeneral.settiporasgopersonalsForeignKey(tiporasgopersonalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return rasgopersonalReturnGeneral;
	}
	
	
	public void deepLoad(RasgoPersonal rasgopersonal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RasgoPersonalLogicAdditional.updateRasgoPersonalToGet(rasgopersonal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rasgopersonal.setEmpresa(rasgopersonalDataAccess.getEmpresa(connexion,rasgopersonal));
		rasgopersonal.setEmpleado(rasgopersonalDataAccess.getEmpleado(connexion,rasgopersonal));
		rasgopersonal.setTipoRasgoPersonal(rasgopersonalDataAccess.getTipoRasgoPersonal(connexion,rasgopersonal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rasgopersonal.setEmpresa(rasgopersonalDataAccess.getEmpresa(connexion,rasgopersonal));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				rasgopersonal.setEmpleado(rasgopersonalDataAccess.getEmpleado(connexion,rasgopersonal));
				continue;
			}

			if(clas.clas.equals(TipoRasgoPersonal.class)) {
				rasgopersonal.setTipoRasgoPersonal(rasgopersonalDataAccess.getTipoRasgoPersonal(connexion,rasgopersonal));
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
			rasgopersonal.setEmpresa(rasgopersonalDataAccess.getEmpresa(connexion,rasgopersonal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rasgopersonal.setEmpleado(rasgopersonalDataAccess.getEmpleado(connexion,rasgopersonal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRasgoPersonal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rasgopersonal.setTipoRasgoPersonal(rasgopersonalDataAccess.getTipoRasgoPersonal(connexion,rasgopersonal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rasgopersonal.setEmpresa(rasgopersonalDataAccess.getEmpresa(connexion,rasgopersonal));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rasgopersonal.getEmpresa(),isDeep,deepLoadType,clases);
				
		rasgopersonal.setEmpleado(rasgopersonalDataAccess.getEmpleado(connexion,rasgopersonal));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(rasgopersonal.getEmpleado(),isDeep,deepLoadType,clases);
				
		rasgopersonal.setTipoRasgoPersonal(rasgopersonalDataAccess.getTipoRasgoPersonal(connexion,rasgopersonal));
		TipoRasgoPersonalLogic tiporasgopersonalLogic= new TipoRasgoPersonalLogic(connexion);
		tiporasgopersonalLogic.deepLoad(rasgopersonal.getTipoRasgoPersonal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rasgopersonal.setEmpresa(rasgopersonalDataAccess.getEmpresa(connexion,rasgopersonal));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(rasgopersonal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				rasgopersonal.setEmpleado(rasgopersonalDataAccess.getEmpleado(connexion,rasgopersonal));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(rasgopersonal.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRasgoPersonal.class)) {
				rasgopersonal.setTipoRasgoPersonal(rasgopersonalDataAccess.getTipoRasgoPersonal(connexion,rasgopersonal));
				TipoRasgoPersonalLogic tiporasgopersonalLogic= new TipoRasgoPersonalLogic(connexion);
				tiporasgopersonalLogic.deepLoad(rasgopersonal.getTipoRasgoPersonal(),isDeep,deepLoadType,clases);				
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
			rasgopersonal.setEmpresa(rasgopersonalDataAccess.getEmpresa(connexion,rasgopersonal));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(rasgopersonal.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rasgopersonal.setEmpleado(rasgopersonalDataAccess.getEmpleado(connexion,rasgopersonal));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(rasgopersonal.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRasgoPersonal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rasgopersonal.setTipoRasgoPersonal(rasgopersonalDataAccess.getTipoRasgoPersonal(connexion,rasgopersonal));
			TipoRasgoPersonalLogic tiporasgopersonalLogic= new TipoRasgoPersonalLogic(connexion);
			tiporasgopersonalLogic.deepLoad(rasgopersonal.getTipoRasgoPersonal(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RasgoPersonal rasgopersonal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RasgoPersonalLogicAdditional.updateRasgoPersonalToSave(rasgopersonal,this.arrDatoGeneral);
			
RasgoPersonalDataAccess.save(rasgopersonal, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rasgopersonal.getEmpresa(),connexion);

		EmpleadoDataAccess.save(rasgopersonal.getEmpleado(),connexion);

		TipoRasgoPersonalDataAccess.save(rasgopersonal.getTipoRasgoPersonal(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rasgopersonal.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(rasgopersonal.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRasgoPersonal.class)) {
				TipoRasgoPersonalDataAccess.save(rasgopersonal.getTipoRasgoPersonal(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rasgopersonal.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rasgopersonal.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(rasgopersonal.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(rasgopersonal.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoRasgoPersonalDataAccess.save(rasgopersonal.getTipoRasgoPersonal(),connexion);
		TipoRasgoPersonalLogic tiporasgopersonalLogic= new TipoRasgoPersonalLogic(connexion);
		tiporasgopersonalLogic.deepLoad(rasgopersonal.getTipoRasgoPersonal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rasgopersonal.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(rasgopersonal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(rasgopersonal.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(rasgopersonal.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRasgoPersonal.class)) {
				TipoRasgoPersonalDataAccess.save(rasgopersonal.getTipoRasgoPersonal(),connexion);
				TipoRasgoPersonalLogic tiporasgopersonalLogic= new TipoRasgoPersonalLogic(connexion);
				tiporasgopersonalLogic.deepSave(rasgopersonal.getTipoRasgoPersonal(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(RasgoPersonal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(rasgopersonal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(rasgopersonal);
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
			this.deepLoad(this.rasgopersonal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RasgoPersonal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(rasgopersonals!=null) {
				for(RasgoPersonal rasgopersonal:rasgopersonals) {
					this.deepLoad(rasgopersonal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(rasgopersonals);
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
			if(rasgopersonals!=null) {
				for(RasgoPersonal rasgopersonal:rasgopersonals) {
					this.deepLoad(rasgopersonal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(rasgopersonals);
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
			this.getNewConnexionToDeep(RasgoPersonal.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(rasgopersonal,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RasgoPersonal.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(rasgopersonals!=null) {
				for(RasgoPersonal rasgopersonal:rasgopersonals) {
					this.deepSave(rasgopersonal,isDeep,deepLoadType,clases);
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
			if(rasgopersonals!=null) {
				for(RasgoPersonal rasgopersonal:rasgopersonals) {
					this.deepSave(rasgopersonal,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRasgoPersonalsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,RasgoPersonalConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRasgoPersonalsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,RasgoPersonalConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRasgoPersonalsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RasgoPersonalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRasgoPersonalsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RasgoPersonalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRasgoPersonalsFK_IdTipoRasgoPersonalWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_rasgo_personal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RasgoPersonal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRasgoPersonal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRasgoPersonal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_rasgo_personal,RasgoPersonalConstantesFunciones.IDTIPORASGOPERSONAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRasgoPersonal);

			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRasgoPersonal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRasgoPersonalsFK_IdTipoRasgoPersonal(String sFinalQuery,Pagination pagination,Long id_tipo_rasgo_personal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRasgoPersonal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRasgoPersonal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_rasgo_personal,RasgoPersonalConstantesFunciones.IDTIPORASGOPERSONAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRasgoPersonal);

			RasgoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRasgoPersonal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RasgoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesRasgoPersonal(this.rasgopersonals);
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
			if(RasgoPersonalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RasgoPersonalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RasgoPersonal rasgopersonal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RasgoPersonalConstantesFunciones.ISCONAUDITORIA) {
				if(rasgopersonal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RasgoPersonalDataAccess.TABLENAME, rasgopersonal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RasgoPersonalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RasgoPersonalLogic.registrarAuditoriaDetallesRasgoPersonal(connexion,rasgopersonal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(rasgopersonal.getIsDeleted()) {
					/*if(!rasgopersonal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RasgoPersonalDataAccess.TABLENAME, rasgopersonal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RasgoPersonalLogic.registrarAuditoriaDetallesRasgoPersonal(connexion,rasgopersonal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RasgoPersonalDataAccess.TABLENAME, rasgopersonal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(rasgopersonal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RasgoPersonalDataAccess.TABLENAME, rasgopersonal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RasgoPersonalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RasgoPersonalLogic.registrarAuditoriaDetallesRasgoPersonal(connexion,rasgopersonal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRasgoPersonal(Connexion connexion,RasgoPersonal rasgopersonal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(rasgopersonal.getIsNew()||!rasgopersonal.getid_empresa().equals(rasgopersonal.getRasgoPersonalOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rasgopersonal.getRasgoPersonalOriginal().getid_empresa()!=null)
				{
					strValorActual=rasgopersonal.getRasgoPersonalOriginal().getid_empresa().toString();
				}
				if(rasgopersonal.getid_empresa()!=null)
				{
					strValorNuevo=rasgopersonal.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RasgoPersonalConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(rasgopersonal.getIsNew()||!rasgopersonal.getid_empleado().equals(rasgopersonal.getRasgoPersonalOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rasgopersonal.getRasgoPersonalOriginal().getid_empleado()!=null)
				{
					strValorActual=rasgopersonal.getRasgoPersonalOriginal().getid_empleado().toString();
				}
				if(rasgopersonal.getid_empleado()!=null)
				{
					strValorNuevo=rasgopersonal.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RasgoPersonalConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(rasgopersonal.getIsNew()||!rasgopersonal.getid_tipo_rasgo_personal().equals(rasgopersonal.getRasgoPersonalOriginal().getid_tipo_rasgo_personal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rasgopersonal.getRasgoPersonalOriginal().getid_tipo_rasgo_personal()!=null)
				{
					strValorActual=rasgopersonal.getRasgoPersonalOriginal().getid_tipo_rasgo_personal().toString();
				}
				if(rasgopersonal.getid_tipo_rasgo_personal()!=null)
				{
					strValorNuevo=rasgopersonal.getid_tipo_rasgo_personal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RasgoPersonalConstantesFunciones.IDTIPORASGOPERSONAL,strValorActual,strValorNuevo);
			}	
			
			if(rasgopersonal.getIsNew()||!rasgopersonal.getdescripcion().equals(rasgopersonal.getRasgoPersonalOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rasgopersonal.getRasgoPersonalOriginal().getdescripcion()!=null)
				{
					strValorActual=rasgopersonal.getRasgoPersonalOriginal().getdescripcion();
				}
				if(rasgopersonal.getdescripcion()!=null)
				{
					strValorNuevo=rasgopersonal.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RasgoPersonalConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRasgoPersonalRelacionesWithConnection(RasgoPersonal rasgopersonal) throws Exception {

		if(!rasgopersonal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRasgoPersonalRelacionesBase(rasgopersonal,true);
		}
	}

	public void saveRasgoPersonalRelaciones(RasgoPersonal rasgopersonal)throws Exception {

		if(!rasgopersonal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRasgoPersonalRelacionesBase(rasgopersonal,false);
		}
	}

	public void saveRasgoPersonalRelacionesBase(RasgoPersonal rasgopersonal,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RasgoPersonal-saveRelacionesWithConnection");}
	

			this.setRasgoPersonal(rasgopersonal);

			if(RasgoPersonalLogicAdditional.validarSaveRelaciones(rasgopersonal,this)) {

				RasgoPersonalLogicAdditional.updateRelacionesToSave(rasgopersonal,this);

				if((rasgopersonal.getIsNew()||rasgopersonal.getIsChanged())&&!rasgopersonal.getIsDeleted()) {
					this.saveRasgoPersonal();
					this.saveRasgoPersonalRelacionesDetalles();

				} else if(rasgopersonal.getIsDeleted()) {
					this.saveRasgoPersonalRelacionesDetalles();
					this.saveRasgoPersonal();
				}

				RasgoPersonalLogicAdditional.updateRelacionesToSaveAfter(rasgopersonal,this);

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
	
	
	private void saveRasgoPersonalRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRasgoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RasgoPersonalConstantesFunciones.getClassesForeignKeysOfRasgoPersonal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRasgoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RasgoPersonalConstantesFunciones.getClassesRelationshipsOfRasgoPersonal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

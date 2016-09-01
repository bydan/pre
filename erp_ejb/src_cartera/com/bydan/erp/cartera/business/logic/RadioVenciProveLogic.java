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
import com.bydan.erp.cartera.util.RadioVenciProveConstantesFunciones;
import com.bydan.erp.cartera.util.RadioVenciProveParameterReturnGeneral;
//import com.bydan.erp.cartera.util.RadioVenciProveParameterGeneral;
import com.bydan.erp.cartera.business.entity.RadioVenciProve;
import com.bydan.erp.cartera.business.logic.RadioVenciProveLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class RadioVenciProveLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RadioVenciProveLogic.class);
	
	protected RadioVenciProveDataAccess radiovenciproveDataAccess; 	
	protected RadioVenciProve radiovenciprove;
	protected List<RadioVenciProve> radiovenciproves;
	protected Object radiovenciproveObject;	
	protected List<Object> radiovenciprovesObject;
	
	public static ClassValidator<RadioVenciProve> radiovenciproveValidator = new ClassValidator<RadioVenciProve>(RadioVenciProve.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RadioVenciProveLogicAdditional radiovenciproveLogicAdditional=null;
	
	public RadioVenciProveLogicAdditional getRadioVenciProveLogicAdditional() {
		return this.radiovenciproveLogicAdditional;
	}
	
	public void setRadioVenciProveLogicAdditional(RadioVenciProveLogicAdditional radiovenciproveLogicAdditional) {
		try {
			this.radiovenciproveLogicAdditional=radiovenciproveLogicAdditional;
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
	
	
	
	
	public  RadioVenciProveLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.radiovenciproveDataAccess = new RadioVenciProveDataAccess();
			
			this.radiovenciproves= new ArrayList<RadioVenciProve>();
			this.radiovenciprove= new RadioVenciProve();
			
			this.radiovenciproveObject=new Object();
			this.radiovenciprovesObject=new ArrayList<Object>();
				
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
			
			this.radiovenciproveDataAccess.setConnexionType(this.connexionType);
			this.radiovenciproveDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RadioVenciProveLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.radiovenciproveDataAccess = new RadioVenciProveDataAccess();
			this.radiovenciproves= new ArrayList<RadioVenciProve>();
			this.radiovenciprove= new RadioVenciProve();
			this.radiovenciproveObject=new Object();
			this.radiovenciprovesObject=new ArrayList<Object>();
			
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
			
			this.radiovenciproveDataAccess.setConnexionType(this.connexionType);
			this.radiovenciproveDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RadioVenciProve getRadioVenciProve() throws Exception {	
		RadioVenciProveLogicAdditional.checkRadioVenciProveToGet(radiovenciprove,this.datosCliente,this.arrDatoGeneral);
		RadioVenciProveLogicAdditional.updateRadioVenciProveToGet(radiovenciprove,this.arrDatoGeneral);
		
		return radiovenciprove;
	}
		
	public void setRadioVenciProve(RadioVenciProve newRadioVenciProve) {
		this.radiovenciprove = newRadioVenciProve;
	}
	
	public RadioVenciProveDataAccess getRadioVenciProveDataAccess() {
		return radiovenciproveDataAccess;
	}
	
	public void setRadioVenciProveDataAccess(RadioVenciProveDataAccess newradiovenciproveDataAccess) {
		this.radiovenciproveDataAccess = newradiovenciproveDataAccess;
	}
	
	public List<RadioVenciProve> getRadioVenciProves() throws Exception {		
		this.quitarRadioVenciProvesNulos();
		
		RadioVenciProveLogicAdditional.checkRadioVenciProveToGets(radiovenciproves,this.datosCliente,this.arrDatoGeneral);
		
		for (RadioVenciProve radiovenciproveLocal: radiovenciproves ) {
			RadioVenciProveLogicAdditional.updateRadioVenciProveToGet(radiovenciproveLocal,this.arrDatoGeneral);
		}
		
		return radiovenciproves;
	}
	
	public void setRadioVenciProves(List<RadioVenciProve> newRadioVenciProves) {
		this.radiovenciproves = newRadioVenciProves;
	}
	
	public Object getRadioVenciProveObject() {	
		this.radiovenciproveObject=this.radiovenciproveDataAccess.getEntityObject();
		return this.radiovenciproveObject;
	}
		
	public void setRadioVenciProveObject(Object newRadioVenciProveObject) {
		this.radiovenciproveObject = newRadioVenciProveObject;
	}
	
	public List<Object> getRadioVenciProvesObject() {		
		this.radiovenciprovesObject=this.radiovenciproveDataAccess.getEntitiesObject();
		return this.radiovenciprovesObject;
	}
		
	public void setRadioVenciProvesObject(List<Object> newRadioVenciProvesObject) {
		this.radiovenciprovesObject = newRadioVenciProvesObject;
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
		
		if(this.radiovenciproveDataAccess!=null) {
			this.radiovenciproveDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			radiovenciproveDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			radiovenciproveDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		radiovenciprove = new  RadioVenciProve();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			radiovenciprove=radiovenciproveDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.radiovenciprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciprove);
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
		radiovenciprove = new  RadioVenciProve();
		  		  
        try {
			
			radiovenciprove=radiovenciproveDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.radiovenciprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		radiovenciprove = new  RadioVenciProve();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			radiovenciprove=radiovenciproveDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.radiovenciprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciprove);
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
		radiovenciprove = new  RadioVenciProve();
		  		  
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
		radiovenciprove = new  RadioVenciProve();
		  		  
        try {
			
			radiovenciprove=radiovenciproveDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.radiovenciprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		radiovenciprove = new  RadioVenciProve();
		  		  
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
		radiovenciprove = new  RadioVenciProve();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =radiovenciproveDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		radiovenciprove = new  RadioVenciProve();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=radiovenciproveDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		radiovenciprove = new  RadioVenciProve();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =radiovenciproveDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		radiovenciprove = new  RadioVenciProve();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=radiovenciproveDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		radiovenciprove = new  RadioVenciProve();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =radiovenciproveDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		radiovenciprove = new  RadioVenciProve();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=radiovenciproveDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		radiovenciproves = new  ArrayList<RadioVenciProve>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRadioVenciProve(radiovenciproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
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
		radiovenciproves = new  ArrayList<RadioVenciProve>();
		  		  
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
		radiovenciproves = new  ArrayList<RadioVenciProve>();
		  		  
        try {			
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRadioVenciProve(radiovenciproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		radiovenciproves = new  ArrayList<RadioVenciProve>();
		  		  
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
		radiovenciproves = new  ArrayList<RadioVenciProve>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRadioVenciProve(radiovenciproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
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
		radiovenciproves = new  ArrayList<RadioVenciProve>();
		  		  
        try {
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRadioVenciProve(radiovenciproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
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
		radiovenciproves = new  ArrayList<RadioVenciProve>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRadioVenciProve(radiovenciproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
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
		radiovenciproves = new  ArrayList<RadioVenciProve>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRadioVenciProve(radiovenciproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		radiovenciprove = new  RadioVenciProve();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciprove=radiovenciproveDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRadioVenciProve(radiovenciprove);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciprove);
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
		radiovenciprove = new  RadioVenciProve();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciprove=radiovenciproveDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRadioVenciProve(radiovenciprove);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		radiovenciproves = new  ArrayList<RadioVenciProve>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciproves=radiovenciproveDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRadioVenciProve(radiovenciproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
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
		radiovenciproves = new  ArrayList<RadioVenciProve>();
		  		  
        try {
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciproves=radiovenciproveDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRadioVenciProve(radiovenciproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRadioVenciProvesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		radiovenciproves = new  ArrayList<RadioVenciProve>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getTodosRadioVenciProvesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRadioVenciProve(radiovenciproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
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
	
	public  void  getTodosRadioVenciProves(String sFinalQuery,Pagination pagination)throws Exception {
		radiovenciproves = new  ArrayList<RadioVenciProve>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRadioVenciProve(radiovenciproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRadioVenciProve(RadioVenciProve radiovenciprove) throws Exception {
		Boolean estaValidado=false;
		
		if(radiovenciprove.getIsNew() || radiovenciprove.getIsChanged()) { 
			this.invalidValues = radiovenciproveValidator.getInvalidValues(radiovenciprove);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(radiovenciprove);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRadioVenciProve(List<RadioVenciProve> RadioVenciProves) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RadioVenciProve radiovenciproveLocal:radiovenciproves) {				
			estaValidadoObjeto=this.validarGuardarRadioVenciProve(radiovenciproveLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRadioVenciProve(List<RadioVenciProve> RadioVenciProves) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRadioVenciProve(radiovenciproves)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRadioVenciProve(RadioVenciProve RadioVenciProve) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRadioVenciProve(radiovenciprove)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RadioVenciProve radiovenciprove) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+radiovenciprove.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RadioVenciProveConstantesFunciones.getRadioVenciProveLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"radiovenciprove","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RadioVenciProveConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RadioVenciProveConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRadioVenciProveWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-saveRadioVenciProveWithConnection");connexion.begin();			
			
			RadioVenciProveLogicAdditional.checkRadioVenciProveToSave(this.radiovenciprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RadioVenciProveLogicAdditional.updateRadioVenciProveToSave(this.radiovenciprove,this.arrDatoGeneral);
			
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.radiovenciprove,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRadioVenciProve();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRadioVenciProve(this.radiovenciprove)) {
				RadioVenciProveDataAccess.save(this.radiovenciprove, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.radiovenciprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RadioVenciProveLogicAdditional.checkRadioVenciProveToSaveAfter(this.radiovenciprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRadioVenciProve();
			
			connexion.commit();			
			
			if(this.radiovenciprove.getIsDeleted()) {
				this.radiovenciprove=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRadioVenciProve()throws Exception {	
		try {	
			
			RadioVenciProveLogicAdditional.checkRadioVenciProveToSave(this.radiovenciprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RadioVenciProveLogicAdditional.updateRadioVenciProveToSave(this.radiovenciprove,this.arrDatoGeneral);
			
			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.radiovenciprove,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRadioVenciProve(this.radiovenciprove)) {			
				RadioVenciProveDataAccess.save(this.radiovenciprove, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.radiovenciprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RadioVenciProveLogicAdditional.checkRadioVenciProveToSaveAfter(this.radiovenciprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.radiovenciprove.getIsDeleted()) {
				this.radiovenciprove=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRadioVenciProvesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-saveRadioVenciProvesWithConnection");connexion.begin();			
			
			RadioVenciProveLogicAdditional.checkRadioVenciProveToSaves(radiovenciproves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRadioVenciProves();
			
			Boolean validadoTodosRadioVenciProve=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RadioVenciProve radiovenciproveLocal:radiovenciproves) {		
				if(radiovenciproveLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RadioVenciProveLogicAdditional.updateRadioVenciProveToSave(radiovenciproveLocal,this.arrDatoGeneral);
	        	
				RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),radiovenciproveLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRadioVenciProve(radiovenciproveLocal)) {
					RadioVenciProveDataAccess.save(radiovenciproveLocal, connexion);				
				} else {
					validadoTodosRadioVenciProve=false;
				}
			}
			
			if(!validadoTodosRadioVenciProve) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RadioVenciProveLogicAdditional.checkRadioVenciProveToSavesAfter(radiovenciproves,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRadioVenciProves();
			
			connexion.commit();		
			
			this.quitarRadioVenciProvesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRadioVenciProves()throws Exception {				
		 try {	
			RadioVenciProveLogicAdditional.checkRadioVenciProveToSaves(radiovenciproves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRadioVenciProve=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RadioVenciProve radiovenciproveLocal:radiovenciproves) {				
				if(radiovenciproveLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RadioVenciProveLogicAdditional.updateRadioVenciProveToSave(radiovenciproveLocal,this.arrDatoGeneral);
	        	
				RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),radiovenciproveLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRadioVenciProve(radiovenciproveLocal)) {				
					RadioVenciProveDataAccess.save(radiovenciproveLocal, connexion);				
				} else {
					validadoTodosRadioVenciProve=false;
				}
			}
			
			if(!validadoTodosRadioVenciProve) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RadioVenciProveLogicAdditional.checkRadioVenciProveToSavesAfter(radiovenciproves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRadioVenciProvesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RadioVenciProveParameterReturnGeneral procesarAccionRadioVenciProves(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RadioVenciProve> radiovenciproves,RadioVenciProveParameterReturnGeneral radiovenciproveParameterGeneral)throws Exception {
		 try {	
			RadioVenciProveParameterReturnGeneral radiovenciproveReturnGeneral=new RadioVenciProveParameterReturnGeneral();
	
			RadioVenciProveLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,radiovenciproves,radiovenciproveParameterGeneral,radiovenciproveReturnGeneral);
			
			return radiovenciproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RadioVenciProveParameterReturnGeneral procesarAccionRadioVenciProvesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RadioVenciProve> radiovenciproves,RadioVenciProveParameterReturnGeneral radiovenciproveParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-procesarAccionRadioVenciProvesWithConnection");connexion.begin();			
			
			RadioVenciProveParameterReturnGeneral radiovenciproveReturnGeneral=new RadioVenciProveParameterReturnGeneral();
	
			RadioVenciProveLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,radiovenciproves,radiovenciproveParameterGeneral,radiovenciproveReturnGeneral);
			
			this.connexion.commit();
			
			return radiovenciproveReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RadioVenciProveParameterReturnGeneral procesarEventosRadioVenciProves(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RadioVenciProve> radiovenciproves,RadioVenciProve radiovenciprove,RadioVenciProveParameterReturnGeneral radiovenciproveParameterGeneral,Boolean isEsNuevoRadioVenciProve,ArrayList<Classe> clases)throws Exception {
		 try {	
			RadioVenciProveParameterReturnGeneral radiovenciproveReturnGeneral=new RadioVenciProveParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				radiovenciproveReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RadioVenciProveLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,radiovenciproves,radiovenciprove,radiovenciproveParameterGeneral,radiovenciproveReturnGeneral,isEsNuevoRadioVenciProve,clases);
			
			return radiovenciproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RadioVenciProveParameterReturnGeneral procesarEventosRadioVenciProvesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RadioVenciProve> radiovenciproves,RadioVenciProve radiovenciprove,RadioVenciProveParameterReturnGeneral radiovenciproveParameterGeneral,Boolean isEsNuevoRadioVenciProve,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-procesarEventosRadioVenciProvesWithConnection");connexion.begin();			
			
			RadioVenciProveParameterReturnGeneral radiovenciproveReturnGeneral=new RadioVenciProveParameterReturnGeneral();
	
			radiovenciproveReturnGeneral.setRadioVenciProve(radiovenciprove);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				radiovenciproveReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RadioVenciProveLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,radiovenciproves,radiovenciprove,radiovenciproveParameterGeneral,radiovenciproveReturnGeneral,isEsNuevoRadioVenciProve,clases);
			
			this.connexion.commit();
			
			return radiovenciproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RadioVenciProveParameterReturnGeneral procesarImportacionRadioVenciProvesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RadioVenciProveParameterReturnGeneral radiovenciproveParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-procesarImportacionRadioVenciProvesWithConnection");connexion.begin();			
			
			RadioVenciProveParameterReturnGeneral radiovenciproveReturnGeneral=new RadioVenciProveParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.radiovenciproves=new ArrayList<RadioVenciProve>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.radiovenciprove=new RadioVenciProve();
				
				
				if(conColumnasBase) {this.radiovenciprove.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.radiovenciprove.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.radiovenciprove.setdia_desde(Integer.parseInt(arrColumnas[iColumn++]));
				this.radiovenciprove.setdia_hasta(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.radiovenciproves.add(this.radiovenciprove);
			}
			
			this.saveRadioVenciProves();
			
			this.connexion.commit();
			
			radiovenciproveReturnGeneral.setConRetornoEstaProcesado(true);
			radiovenciproveReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return radiovenciproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRadioVenciProvesEliminados() throws Exception {				
		
		List<RadioVenciProve> radiovenciprovesAux= new ArrayList<RadioVenciProve>();
		
		for(RadioVenciProve radiovenciprove:radiovenciproves) {
			if(!radiovenciprove.getIsDeleted()) {
				radiovenciprovesAux.add(radiovenciprove);
			}
		}
		
		radiovenciproves=radiovenciprovesAux;
	}
	
	public void quitarRadioVenciProvesNulos() throws Exception {				
		
		List<RadioVenciProve> radiovenciprovesAux= new ArrayList<RadioVenciProve>();
		
		for(RadioVenciProve radiovenciprove : this.radiovenciproves) {
			if(radiovenciprove==null) {
				radiovenciprovesAux.add(radiovenciprove);
			}
		}
		
		//this.radiovenciproves=radiovenciprovesAux;
		
		this.radiovenciproves.removeAll(radiovenciprovesAux);
	}
	
	public void getSetVersionRowRadioVenciProveWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(radiovenciprove.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((radiovenciprove.getIsDeleted() || (radiovenciprove.getIsChanged()&&!radiovenciprove.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=radiovenciproveDataAccess.getSetVersionRowRadioVenciProve(connexion,radiovenciprove.getId());
				
				if(!radiovenciprove.getVersionRow().equals(timestamp)) {	
					radiovenciprove.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				radiovenciprove.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRadioVenciProve()throws Exception {	
		
		if(radiovenciprove.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((radiovenciprove.getIsDeleted() || (radiovenciprove.getIsChanged()&&!radiovenciprove.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=radiovenciproveDataAccess.getSetVersionRowRadioVenciProve(connexion,radiovenciprove.getId());
			
			try {							
				if(!radiovenciprove.getVersionRow().equals(timestamp)) {	
					radiovenciprove.setVersionRow(timestamp);
				}
				
				radiovenciprove.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRadioVenciProvesWithConnection()throws Exception {	
		if(radiovenciproves!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RadioVenciProve radiovenciproveAux:radiovenciproves) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(radiovenciproveAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(radiovenciproveAux.getIsDeleted() || (radiovenciproveAux.getIsChanged()&&!radiovenciproveAux.getIsNew())) {
						
						timestamp=radiovenciproveDataAccess.getSetVersionRowRadioVenciProve(connexion,radiovenciproveAux.getId());
						
						if(!radiovenciprove.getVersionRow().equals(timestamp)) {	
							radiovenciproveAux.setVersionRow(timestamp);
						}
								
						radiovenciproveAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRadioVenciProves()throws Exception {	
		if(radiovenciproves!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RadioVenciProve radiovenciproveAux:radiovenciproves) {
					if(radiovenciproveAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(radiovenciproveAux.getIsDeleted() || (radiovenciproveAux.getIsChanged()&&!radiovenciproveAux.getIsNew())) {
						
						timestamp=radiovenciproveDataAccess.getSetVersionRowRadioVenciProve(connexion,radiovenciproveAux.getId());
						
						if(!radiovenciproveAux.getVersionRow().equals(timestamp)) {	
							radiovenciproveAux.setVersionRow(timestamp);
						}
						
													
						radiovenciproveAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RadioVenciProveParameterReturnGeneral cargarCombosLoteForeignKeyRadioVenciProveWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoRadioVenci) throws Exception {
		RadioVenciProveParameterReturnGeneral  radiovenciproveReturnGeneral =new RadioVenciProveParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-cargarCombosLoteForeignKeyRadioVenciProveWithConnection");connexion.begin();
			
			radiovenciproveReturnGeneral =new RadioVenciProveParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			radiovenciproveReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoRadioVenci> tiporadiovencisForeignKey=new ArrayList<TipoRadioVenci>();
			TipoRadioVenciLogic tiporadiovenciLogic=new TipoRadioVenciLogic();
			tiporadiovenciLogic.setConnexion(this.connexion);
			tiporadiovenciLogic.getTipoRadioVenciDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRadioVenci.equals("NONE")) {
				tiporadiovenciLogic.getTodosTipoRadioVencis(finalQueryGlobalTipoRadioVenci,new Pagination());
				tiporadiovencisForeignKey=tiporadiovenciLogic.getTipoRadioVencis();
			}

			radiovenciproveReturnGeneral.settiporadiovencisForeignKey(tiporadiovencisForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return radiovenciproveReturnGeneral;
	}
	
	public RadioVenciProveParameterReturnGeneral cargarCombosLoteForeignKeyRadioVenciProve(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoRadioVenci) throws Exception {
		RadioVenciProveParameterReturnGeneral  radiovenciproveReturnGeneral =new RadioVenciProveParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			radiovenciproveReturnGeneral =new RadioVenciProveParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			radiovenciproveReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoRadioVenci> tiporadiovencisForeignKey=new ArrayList<TipoRadioVenci>();
			TipoRadioVenciLogic tiporadiovenciLogic=new TipoRadioVenciLogic();
			tiporadiovenciLogic.setConnexion(this.connexion);
			tiporadiovenciLogic.getTipoRadioVenciDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRadioVenci.equals("NONE")) {
				tiporadiovenciLogic.getTodosTipoRadioVencis(finalQueryGlobalTipoRadioVenci,new Pagination());
				tiporadiovencisForeignKey=tiporadiovenciLogic.getTipoRadioVencis();
			}

			radiovenciproveReturnGeneral.settiporadiovencisForeignKey(tiporadiovencisForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return radiovenciproveReturnGeneral;
	}
	
	
	public void deepLoad(RadioVenciProve radiovenciprove,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RadioVenciProveLogicAdditional.updateRadioVenciProveToGet(radiovenciprove,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		radiovenciprove.setEmpresa(radiovenciproveDataAccess.getEmpresa(connexion,radiovenciprove));
		radiovenciprove.setTipoRadioVenci(radiovenciproveDataAccess.getTipoRadioVenci(connexion,radiovenciprove));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				radiovenciprove.setEmpresa(radiovenciproveDataAccess.getEmpresa(connexion,radiovenciprove));
				continue;
			}

			if(clas.clas.equals(TipoRadioVenci.class)) {
				radiovenciprove.setTipoRadioVenci(radiovenciproveDataAccess.getTipoRadioVenci(connexion,radiovenciprove));
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
			radiovenciprove.setEmpresa(radiovenciproveDataAccess.getEmpresa(connexion,radiovenciprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRadioVenci.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			radiovenciprove.setTipoRadioVenci(radiovenciproveDataAccess.getTipoRadioVenci(connexion,radiovenciprove));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		radiovenciprove.setEmpresa(radiovenciproveDataAccess.getEmpresa(connexion,radiovenciprove));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(radiovenciprove.getEmpresa(),isDeep,deepLoadType,clases);
				
		radiovenciprove.setTipoRadioVenci(radiovenciproveDataAccess.getTipoRadioVenci(connexion,radiovenciprove));
		TipoRadioVenciLogic tiporadiovenciLogic= new TipoRadioVenciLogic(connexion);
		tiporadiovenciLogic.deepLoad(radiovenciprove.getTipoRadioVenci(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				radiovenciprove.setEmpresa(radiovenciproveDataAccess.getEmpresa(connexion,radiovenciprove));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(radiovenciprove.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRadioVenci.class)) {
				radiovenciprove.setTipoRadioVenci(radiovenciproveDataAccess.getTipoRadioVenci(connexion,radiovenciprove));
				TipoRadioVenciLogic tiporadiovenciLogic= new TipoRadioVenciLogic(connexion);
				tiporadiovenciLogic.deepLoad(radiovenciprove.getTipoRadioVenci(),isDeep,deepLoadType,clases);				
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
			radiovenciprove.setEmpresa(radiovenciproveDataAccess.getEmpresa(connexion,radiovenciprove));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(radiovenciprove.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRadioVenci.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			radiovenciprove.setTipoRadioVenci(radiovenciproveDataAccess.getTipoRadioVenci(connexion,radiovenciprove));
			TipoRadioVenciLogic tiporadiovenciLogic= new TipoRadioVenciLogic(connexion);
			tiporadiovenciLogic.deepLoad(radiovenciprove.getTipoRadioVenci(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RadioVenciProve radiovenciprove,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RadioVenciProveLogicAdditional.updateRadioVenciProveToSave(radiovenciprove,this.arrDatoGeneral);
			
RadioVenciProveDataAccess.save(radiovenciprove, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(radiovenciprove.getEmpresa(),connexion);

		TipoRadioVenciDataAccess.save(radiovenciprove.getTipoRadioVenci(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(radiovenciprove.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRadioVenci.class)) {
				TipoRadioVenciDataAccess.save(radiovenciprove.getTipoRadioVenci(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(radiovenciprove.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(radiovenciprove.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoRadioVenciDataAccess.save(radiovenciprove.getTipoRadioVenci(),connexion);
		TipoRadioVenciLogic tiporadiovenciLogic= new TipoRadioVenciLogic(connexion);
		tiporadiovenciLogic.deepLoad(radiovenciprove.getTipoRadioVenci(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(radiovenciprove.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(radiovenciprove.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRadioVenci.class)) {
				TipoRadioVenciDataAccess.save(radiovenciprove.getTipoRadioVenci(),connexion);
				TipoRadioVenciLogic tiporadiovenciLogic= new TipoRadioVenciLogic(connexion);
				tiporadiovenciLogic.deepSave(radiovenciprove.getTipoRadioVenci(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(RadioVenciProve.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(radiovenciprove,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(radiovenciprove);
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
			this.deepLoad(this.radiovenciprove,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RadioVenciProve.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(radiovenciproves!=null) {
				for(RadioVenciProve radiovenciprove:radiovenciproves) {
					this.deepLoad(radiovenciprove,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(radiovenciproves);
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
			if(radiovenciproves!=null) {
				for(RadioVenciProve radiovenciprove:radiovenciproves) {
					this.deepLoad(radiovenciprove,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(radiovenciproves);
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
			this.getNewConnexionToDeep(RadioVenciProve.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(radiovenciprove,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RadioVenciProve.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(radiovenciproves!=null) {
				for(RadioVenciProve radiovenciprove:radiovenciproves) {
					this.deepSave(radiovenciprove,isDeep,deepLoadType,clases);
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
			if(radiovenciproves!=null) {
				for(RadioVenciProve radiovenciprove:radiovenciproves) {
					this.deepSave(radiovenciprove,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRadioVenciProvesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RadioVenciProveConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRadioVenciProvesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RadioVenciProveConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRadioVenciProvesFK_IdTipoRadioVenciWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_radio_venci)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRadioVenci= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRadioVenci.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_radio_venci,RadioVenciProveConstantesFunciones.IDTIPORADIOVENCI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRadioVenci);

			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRadioVenci","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRadioVenciProvesFK_IdTipoRadioVenci(String sFinalQuery,Pagination pagination,Long id_tipo_radio_venci)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRadioVenci= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRadioVenci.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_radio_venci,RadioVenciProveConstantesFunciones.IDTIPORADIOVENCI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRadioVenci);

			RadioVenciProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRadioVenci","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(this.radiovenciproves);
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
			if(RadioVenciProveConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RadioVenciProveDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RadioVenciProve radiovenciprove,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RadioVenciProveConstantesFunciones.ISCONAUDITORIA) {
				if(radiovenciprove.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RadioVenciProveDataAccess.TABLENAME, radiovenciprove.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RadioVenciProveConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RadioVenciProveLogic.registrarAuditoriaDetallesRadioVenciProve(connexion,radiovenciprove,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(radiovenciprove.getIsDeleted()) {
					/*if(!radiovenciprove.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RadioVenciProveDataAccess.TABLENAME, radiovenciprove.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RadioVenciProveLogic.registrarAuditoriaDetallesRadioVenciProve(connexion,radiovenciprove,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RadioVenciProveDataAccess.TABLENAME, radiovenciprove.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(radiovenciprove.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RadioVenciProveDataAccess.TABLENAME, radiovenciprove.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RadioVenciProveConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RadioVenciProveLogic.registrarAuditoriaDetallesRadioVenciProve(connexion,radiovenciprove,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRadioVenciProve(Connexion connexion,RadioVenciProve radiovenciprove)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(radiovenciprove.getIsNew()||!radiovenciprove.getid_empresa().equals(radiovenciprove.getRadioVenciProveOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(radiovenciprove.getRadioVenciProveOriginal().getid_empresa()!=null)
				{
					strValorActual=radiovenciprove.getRadioVenciProveOriginal().getid_empresa().toString();
				}
				if(radiovenciprove.getid_empresa()!=null)
				{
					strValorNuevo=radiovenciprove.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RadioVenciProveConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(radiovenciprove.getIsNew()||!radiovenciprove.getid_tipo_radio_venci().equals(radiovenciprove.getRadioVenciProveOriginal().getid_tipo_radio_venci()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(radiovenciprove.getRadioVenciProveOriginal().getid_tipo_radio_venci()!=null)
				{
					strValorActual=radiovenciprove.getRadioVenciProveOriginal().getid_tipo_radio_venci().toString();
				}
				if(radiovenciprove.getid_tipo_radio_venci()!=null)
				{
					strValorNuevo=radiovenciprove.getid_tipo_radio_venci().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RadioVenciProveConstantesFunciones.IDTIPORADIOVENCI,strValorActual,strValorNuevo);
			}	
			
			if(radiovenciprove.getIsNew()||!radiovenciprove.getdia_desde().equals(radiovenciprove.getRadioVenciProveOriginal().getdia_desde()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(radiovenciprove.getRadioVenciProveOriginal().getdia_desde()!=null)
				{
					strValorActual=radiovenciprove.getRadioVenciProveOriginal().getdia_desde().toString();
				}
				if(radiovenciprove.getdia_desde()!=null)
				{
					strValorNuevo=radiovenciprove.getdia_desde().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RadioVenciProveConstantesFunciones.DIADESDE,strValorActual,strValorNuevo);
			}	
			
			if(radiovenciprove.getIsNew()||!radiovenciprove.getdia_hasta().equals(radiovenciprove.getRadioVenciProveOriginal().getdia_hasta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(radiovenciprove.getRadioVenciProveOriginal().getdia_hasta()!=null)
				{
					strValorActual=radiovenciprove.getRadioVenciProveOriginal().getdia_hasta().toString();
				}
				if(radiovenciprove.getdia_hasta()!=null)
				{
					strValorNuevo=radiovenciprove.getdia_hasta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RadioVenciProveConstantesFunciones.DIAHASTA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRadioVenciProveRelacionesWithConnection(RadioVenciProve radiovenciprove) throws Exception {

		if(!radiovenciprove.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRadioVenciProveRelacionesBase(radiovenciprove,true);
		}
	}

	public void saveRadioVenciProveRelaciones(RadioVenciProve radiovenciprove)throws Exception {

		if(!radiovenciprove.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRadioVenciProveRelacionesBase(radiovenciprove,false);
		}
	}

	public void saveRadioVenciProveRelacionesBase(RadioVenciProve radiovenciprove,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RadioVenciProve-saveRelacionesWithConnection");}
	

			this.setRadioVenciProve(radiovenciprove);

			if(RadioVenciProveLogicAdditional.validarSaveRelaciones(radiovenciprove,this)) {

				RadioVenciProveLogicAdditional.updateRelacionesToSave(radiovenciprove,this);

				if((radiovenciprove.getIsNew()||radiovenciprove.getIsChanged())&&!radiovenciprove.getIsDeleted()) {
					this.saveRadioVenciProve();
					this.saveRadioVenciProveRelacionesDetalles();

				} else if(radiovenciprove.getIsDeleted()) {
					this.saveRadioVenciProveRelacionesDetalles();
					this.saveRadioVenciProve();
				}

				RadioVenciProveLogicAdditional.updateRelacionesToSaveAfter(radiovenciprove,this);

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
	
	
	private void saveRadioVenciProveRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRadioVenciProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RadioVenciProveConstantesFunciones.getClassesForeignKeysOfRadioVenciProve(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRadioVenciProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RadioVenciProveConstantesFunciones.getClassesRelationshipsOfRadioVenciProve(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

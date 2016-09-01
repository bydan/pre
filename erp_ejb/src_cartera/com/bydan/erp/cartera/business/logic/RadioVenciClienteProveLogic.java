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
import com.bydan.erp.cartera.util.RadioVenciClienteProveConstantesFunciones;
import com.bydan.erp.cartera.util.RadioVenciClienteProveParameterReturnGeneral;
//import com.bydan.erp.cartera.util.RadioVenciClienteProveParameterGeneral;
import com.bydan.erp.cartera.business.entity.RadioVenciClienteProve;
import com.bydan.erp.cartera.business.logic.RadioVenciClienteProveLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class RadioVenciClienteProveLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RadioVenciClienteProveLogic.class);
	
	protected RadioVenciClienteProveDataAccess radiovenciclienteproveDataAccess; 	
	protected RadioVenciClienteProve radiovenciclienteprove;
	protected List<RadioVenciClienteProve> radiovenciclienteproves;
	protected Object radiovenciclienteproveObject;	
	protected List<Object> radiovenciclienteprovesObject;
	
	public static ClassValidator<RadioVenciClienteProve> radiovenciclienteproveValidator = new ClassValidator<RadioVenciClienteProve>(RadioVenciClienteProve.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RadioVenciClienteProveLogicAdditional radiovenciclienteproveLogicAdditional=null;
	
	public RadioVenciClienteProveLogicAdditional getRadioVenciClienteProveLogicAdditional() {
		return this.radiovenciclienteproveLogicAdditional;
	}
	
	public void setRadioVenciClienteProveLogicAdditional(RadioVenciClienteProveLogicAdditional radiovenciclienteproveLogicAdditional) {
		try {
			this.radiovenciclienteproveLogicAdditional=radiovenciclienteproveLogicAdditional;
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
	
	
	
	
	public  RadioVenciClienteProveLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.radiovenciclienteproveDataAccess = new RadioVenciClienteProveDataAccess();
			
			this.radiovenciclienteproves= new ArrayList<RadioVenciClienteProve>();
			this.radiovenciclienteprove= new RadioVenciClienteProve();
			
			this.radiovenciclienteproveObject=new Object();
			this.radiovenciclienteprovesObject=new ArrayList<Object>();
				
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
			
			this.radiovenciclienteproveDataAccess.setConnexionType(this.connexionType);
			this.radiovenciclienteproveDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RadioVenciClienteProveLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.radiovenciclienteproveDataAccess = new RadioVenciClienteProveDataAccess();
			this.radiovenciclienteproves= new ArrayList<RadioVenciClienteProve>();
			this.radiovenciclienteprove= new RadioVenciClienteProve();
			this.radiovenciclienteproveObject=new Object();
			this.radiovenciclienteprovesObject=new ArrayList<Object>();
			
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
			
			this.radiovenciclienteproveDataAccess.setConnexionType(this.connexionType);
			this.radiovenciclienteproveDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RadioVenciClienteProve getRadioVenciClienteProve() throws Exception {	
		RadioVenciClienteProveLogicAdditional.checkRadioVenciClienteProveToGet(radiovenciclienteprove,this.datosCliente,this.arrDatoGeneral);
		RadioVenciClienteProveLogicAdditional.updateRadioVenciClienteProveToGet(radiovenciclienteprove,this.arrDatoGeneral);
		
		return radiovenciclienteprove;
	}
		
	public void setRadioVenciClienteProve(RadioVenciClienteProve newRadioVenciClienteProve) {
		this.radiovenciclienteprove = newRadioVenciClienteProve;
	}
	
	public RadioVenciClienteProveDataAccess getRadioVenciClienteProveDataAccess() {
		return radiovenciclienteproveDataAccess;
	}
	
	public void setRadioVenciClienteProveDataAccess(RadioVenciClienteProveDataAccess newradiovenciclienteproveDataAccess) {
		this.radiovenciclienteproveDataAccess = newradiovenciclienteproveDataAccess;
	}
	
	public List<RadioVenciClienteProve> getRadioVenciClienteProves() throws Exception {		
		this.quitarRadioVenciClienteProvesNulos();
		
		RadioVenciClienteProveLogicAdditional.checkRadioVenciClienteProveToGets(radiovenciclienteproves,this.datosCliente,this.arrDatoGeneral);
		
		for (RadioVenciClienteProve radiovenciclienteproveLocal: radiovenciclienteproves ) {
			RadioVenciClienteProveLogicAdditional.updateRadioVenciClienteProveToGet(radiovenciclienteproveLocal,this.arrDatoGeneral);
		}
		
		return radiovenciclienteproves;
	}
	
	public void setRadioVenciClienteProves(List<RadioVenciClienteProve> newRadioVenciClienteProves) {
		this.radiovenciclienteproves = newRadioVenciClienteProves;
	}
	
	public Object getRadioVenciClienteProveObject() {	
		this.radiovenciclienteproveObject=this.radiovenciclienteproveDataAccess.getEntityObject();
		return this.radiovenciclienteproveObject;
	}
		
	public void setRadioVenciClienteProveObject(Object newRadioVenciClienteProveObject) {
		this.radiovenciclienteproveObject = newRadioVenciClienteProveObject;
	}
	
	public List<Object> getRadioVenciClienteProvesObject() {		
		this.radiovenciclienteprovesObject=this.radiovenciclienteproveDataAccess.getEntitiesObject();
		return this.radiovenciclienteprovesObject;
	}
		
	public void setRadioVenciClienteProvesObject(List<Object> newRadioVenciClienteProvesObject) {
		this.radiovenciclienteprovesObject = newRadioVenciClienteProvesObject;
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
		
		if(this.radiovenciclienteproveDataAccess!=null) {
			this.radiovenciclienteproveDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			radiovenciclienteproveDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			radiovenciclienteproveDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		radiovenciclienteprove = new  RadioVenciClienteProve();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			radiovenciclienteprove=radiovenciclienteproveDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.radiovenciclienteprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteprove);
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
		radiovenciclienteprove = new  RadioVenciClienteProve();
		  		  
        try {
			
			radiovenciclienteprove=radiovenciclienteproveDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.radiovenciclienteprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		radiovenciclienteprove = new  RadioVenciClienteProve();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			radiovenciclienteprove=radiovenciclienteproveDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.radiovenciclienteprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteprove);
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
		radiovenciclienteprove = new  RadioVenciClienteProve();
		  		  
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
		radiovenciclienteprove = new  RadioVenciClienteProve();
		  		  
        try {
			
			radiovenciclienteprove=radiovenciclienteproveDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.radiovenciclienteprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		radiovenciclienteprove = new  RadioVenciClienteProve();
		  		  
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
		radiovenciclienteprove = new  RadioVenciClienteProve();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =radiovenciclienteproveDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		radiovenciclienteprove = new  RadioVenciClienteProve();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=radiovenciclienteproveDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		radiovenciclienteprove = new  RadioVenciClienteProve();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =radiovenciclienteproveDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		radiovenciclienteprove = new  RadioVenciClienteProve();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=radiovenciclienteproveDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		radiovenciclienteprove = new  RadioVenciClienteProve();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =radiovenciclienteproveDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		radiovenciclienteprove = new  RadioVenciClienteProve();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=radiovenciclienteproveDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		radiovenciclienteproves = new  ArrayList<RadioVenciClienteProve>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRadioVenciClienteProve(radiovenciclienteproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
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
		radiovenciclienteproves = new  ArrayList<RadioVenciClienteProve>();
		  		  
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
		radiovenciclienteproves = new  ArrayList<RadioVenciClienteProve>();
		  		  
        try {			
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRadioVenciClienteProve(radiovenciclienteproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		radiovenciclienteproves = new  ArrayList<RadioVenciClienteProve>();
		  		  
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
		radiovenciclienteproves = new  ArrayList<RadioVenciClienteProve>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRadioVenciClienteProve(radiovenciclienteproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
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
		radiovenciclienteproves = new  ArrayList<RadioVenciClienteProve>();
		  		  
        try {
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRadioVenciClienteProve(radiovenciclienteproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
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
		radiovenciclienteproves = new  ArrayList<RadioVenciClienteProve>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRadioVenciClienteProve(radiovenciclienteproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
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
		radiovenciclienteproves = new  ArrayList<RadioVenciClienteProve>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRadioVenciClienteProve(radiovenciclienteproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		radiovenciclienteprove = new  RadioVenciClienteProve();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciclienteprove=radiovenciclienteproveDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRadioVenciClienteProve(radiovenciclienteprove);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteprove);
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
		radiovenciclienteprove = new  RadioVenciClienteProve();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciclienteprove=radiovenciclienteproveDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRadioVenciClienteProve(radiovenciclienteprove);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		radiovenciclienteproves = new  ArrayList<RadioVenciClienteProve>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRadioVenciClienteProve(radiovenciclienteproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
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
		radiovenciclienteproves = new  ArrayList<RadioVenciClienteProve>();
		  		  
        try {
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRadioVenciClienteProve(radiovenciclienteproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRadioVenciClienteProvesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		radiovenciclienteproves = new  ArrayList<RadioVenciClienteProve>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getTodosRadioVenciClienteProvesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRadioVenciClienteProve(radiovenciclienteproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
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
	
	public  void  getTodosRadioVenciClienteProves(String sFinalQuery,Pagination pagination)throws Exception {
		radiovenciclienteproves = new  ArrayList<RadioVenciClienteProve>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRadioVenciClienteProve(radiovenciclienteproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRadioVenciClienteProve(RadioVenciClienteProve radiovenciclienteprove) throws Exception {
		Boolean estaValidado=false;
		
		if(radiovenciclienteprove.getIsNew() || radiovenciclienteprove.getIsChanged()) { 
			this.invalidValues = radiovenciclienteproveValidator.getInvalidValues(radiovenciclienteprove);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(radiovenciclienteprove);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRadioVenciClienteProve(List<RadioVenciClienteProve> RadioVenciClienteProves) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RadioVenciClienteProve radiovenciclienteproveLocal:radiovenciclienteproves) {				
			estaValidadoObjeto=this.validarGuardarRadioVenciClienteProve(radiovenciclienteproveLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRadioVenciClienteProve(List<RadioVenciClienteProve> RadioVenciClienteProves) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRadioVenciClienteProve(radiovenciclienteproves)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRadioVenciClienteProve(RadioVenciClienteProve RadioVenciClienteProve) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRadioVenciClienteProve(radiovenciclienteprove)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RadioVenciClienteProve radiovenciclienteprove) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+radiovenciclienteprove.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RadioVenciClienteProveConstantesFunciones.getRadioVenciClienteProveLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"radiovenciclienteprove","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RadioVenciClienteProveConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RadioVenciClienteProveConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRadioVenciClienteProveWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-saveRadioVenciClienteProveWithConnection");connexion.begin();			
			
			RadioVenciClienteProveLogicAdditional.checkRadioVenciClienteProveToSave(this.radiovenciclienteprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RadioVenciClienteProveLogicAdditional.updateRadioVenciClienteProveToSave(this.radiovenciclienteprove,this.arrDatoGeneral);
			
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.radiovenciclienteprove,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRadioVenciClienteProve();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRadioVenciClienteProve(this.radiovenciclienteprove)) {
				RadioVenciClienteProveDataAccess.save(this.radiovenciclienteprove, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.radiovenciclienteprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RadioVenciClienteProveLogicAdditional.checkRadioVenciClienteProveToSaveAfter(this.radiovenciclienteprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRadioVenciClienteProve();
			
			connexion.commit();			
			
			if(this.radiovenciclienteprove.getIsDeleted()) {
				this.radiovenciclienteprove=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRadioVenciClienteProve()throws Exception {	
		try {	
			
			RadioVenciClienteProveLogicAdditional.checkRadioVenciClienteProveToSave(this.radiovenciclienteprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RadioVenciClienteProveLogicAdditional.updateRadioVenciClienteProveToSave(this.radiovenciclienteprove,this.arrDatoGeneral);
			
			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.radiovenciclienteprove,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRadioVenciClienteProve(this.radiovenciclienteprove)) {			
				RadioVenciClienteProveDataAccess.save(this.radiovenciclienteprove, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.radiovenciclienteprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RadioVenciClienteProveLogicAdditional.checkRadioVenciClienteProveToSaveAfter(this.radiovenciclienteprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.radiovenciclienteprove.getIsDeleted()) {
				this.radiovenciclienteprove=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRadioVenciClienteProvesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-saveRadioVenciClienteProvesWithConnection");connexion.begin();			
			
			RadioVenciClienteProveLogicAdditional.checkRadioVenciClienteProveToSaves(radiovenciclienteproves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRadioVenciClienteProves();
			
			Boolean validadoTodosRadioVenciClienteProve=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RadioVenciClienteProve radiovenciclienteproveLocal:radiovenciclienteproves) {		
				if(radiovenciclienteproveLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RadioVenciClienteProveLogicAdditional.updateRadioVenciClienteProveToSave(radiovenciclienteproveLocal,this.arrDatoGeneral);
	        	
				RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),radiovenciclienteproveLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRadioVenciClienteProve(radiovenciclienteproveLocal)) {
					RadioVenciClienteProveDataAccess.save(radiovenciclienteproveLocal, connexion);				
				} else {
					validadoTodosRadioVenciClienteProve=false;
				}
			}
			
			if(!validadoTodosRadioVenciClienteProve) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RadioVenciClienteProveLogicAdditional.checkRadioVenciClienteProveToSavesAfter(radiovenciclienteproves,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRadioVenciClienteProves();
			
			connexion.commit();		
			
			this.quitarRadioVenciClienteProvesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRadioVenciClienteProves()throws Exception {				
		 try {	
			RadioVenciClienteProveLogicAdditional.checkRadioVenciClienteProveToSaves(radiovenciclienteproves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRadioVenciClienteProve=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RadioVenciClienteProve radiovenciclienteproveLocal:radiovenciclienteproves) {				
				if(radiovenciclienteproveLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RadioVenciClienteProveLogicAdditional.updateRadioVenciClienteProveToSave(radiovenciclienteproveLocal,this.arrDatoGeneral);
	        	
				RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),radiovenciclienteproveLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRadioVenciClienteProve(radiovenciclienteproveLocal)) {				
					RadioVenciClienteProveDataAccess.save(radiovenciclienteproveLocal, connexion);				
				} else {
					validadoTodosRadioVenciClienteProve=false;
				}
			}
			
			if(!validadoTodosRadioVenciClienteProve) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RadioVenciClienteProveLogicAdditional.checkRadioVenciClienteProveToSavesAfter(radiovenciclienteproves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRadioVenciClienteProvesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RadioVenciClienteProveParameterReturnGeneral procesarAccionRadioVenciClienteProves(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RadioVenciClienteProve> radiovenciclienteproves,RadioVenciClienteProveParameterReturnGeneral radiovenciclienteproveParameterGeneral)throws Exception {
		 try {	
			RadioVenciClienteProveParameterReturnGeneral radiovenciclienteproveReturnGeneral=new RadioVenciClienteProveParameterReturnGeneral();
	
			RadioVenciClienteProveLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,radiovenciclienteproves,radiovenciclienteproveParameterGeneral,radiovenciclienteproveReturnGeneral);
			
			return radiovenciclienteproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RadioVenciClienteProveParameterReturnGeneral procesarAccionRadioVenciClienteProvesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RadioVenciClienteProve> radiovenciclienteproves,RadioVenciClienteProveParameterReturnGeneral radiovenciclienteproveParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-procesarAccionRadioVenciClienteProvesWithConnection");connexion.begin();			
			
			RadioVenciClienteProveParameterReturnGeneral radiovenciclienteproveReturnGeneral=new RadioVenciClienteProveParameterReturnGeneral();
	
			RadioVenciClienteProveLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,radiovenciclienteproves,radiovenciclienteproveParameterGeneral,radiovenciclienteproveReturnGeneral);
			
			this.connexion.commit();
			
			return radiovenciclienteproveReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RadioVenciClienteProveParameterReturnGeneral procesarEventosRadioVenciClienteProves(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RadioVenciClienteProve> radiovenciclienteproves,RadioVenciClienteProve radiovenciclienteprove,RadioVenciClienteProveParameterReturnGeneral radiovenciclienteproveParameterGeneral,Boolean isEsNuevoRadioVenciClienteProve,ArrayList<Classe> clases)throws Exception {
		 try {	
			RadioVenciClienteProveParameterReturnGeneral radiovenciclienteproveReturnGeneral=new RadioVenciClienteProveParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				radiovenciclienteproveReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RadioVenciClienteProveLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,radiovenciclienteproves,radiovenciclienteprove,radiovenciclienteproveParameterGeneral,radiovenciclienteproveReturnGeneral,isEsNuevoRadioVenciClienteProve,clases);
			
			return radiovenciclienteproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RadioVenciClienteProveParameterReturnGeneral procesarEventosRadioVenciClienteProvesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RadioVenciClienteProve> radiovenciclienteproves,RadioVenciClienteProve radiovenciclienteprove,RadioVenciClienteProveParameterReturnGeneral radiovenciclienteproveParameterGeneral,Boolean isEsNuevoRadioVenciClienteProve,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-procesarEventosRadioVenciClienteProvesWithConnection");connexion.begin();			
			
			RadioVenciClienteProveParameterReturnGeneral radiovenciclienteproveReturnGeneral=new RadioVenciClienteProveParameterReturnGeneral();
	
			radiovenciclienteproveReturnGeneral.setRadioVenciClienteProve(radiovenciclienteprove);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				radiovenciclienteproveReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RadioVenciClienteProveLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,radiovenciclienteproves,radiovenciclienteprove,radiovenciclienteproveParameterGeneral,radiovenciclienteproveReturnGeneral,isEsNuevoRadioVenciClienteProve,clases);
			
			this.connexion.commit();
			
			return radiovenciclienteproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RadioVenciClienteProveParameterReturnGeneral procesarImportacionRadioVenciClienteProvesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RadioVenciClienteProveParameterReturnGeneral radiovenciclienteproveParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-procesarImportacionRadioVenciClienteProvesWithConnection");connexion.begin();			
			
			RadioVenciClienteProveParameterReturnGeneral radiovenciclienteproveReturnGeneral=new RadioVenciClienteProveParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.radiovenciclienteproves=new ArrayList<RadioVenciClienteProve>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.radiovenciclienteprove=new RadioVenciClienteProve();
				
				
				if(conColumnasBase) {this.radiovenciclienteprove.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.radiovenciclienteprove.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.radiovenciclienteprove.setdia_desde(Integer.parseInt(arrColumnas[iColumn++]));
				this.radiovenciclienteprove.setdia_hasta(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.radiovenciclienteproves.add(this.radiovenciclienteprove);
			}
			
			this.saveRadioVenciClienteProves();
			
			this.connexion.commit();
			
			radiovenciclienteproveReturnGeneral.setConRetornoEstaProcesado(true);
			radiovenciclienteproveReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return radiovenciclienteproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRadioVenciClienteProvesEliminados() throws Exception {				
		
		List<RadioVenciClienteProve> radiovenciclienteprovesAux= new ArrayList<RadioVenciClienteProve>();
		
		for(RadioVenciClienteProve radiovenciclienteprove:radiovenciclienteproves) {
			if(!radiovenciclienteprove.getIsDeleted()) {
				radiovenciclienteprovesAux.add(radiovenciclienteprove);
			}
		}
		
		radiovenciclienteproves=radiovenciclienteprovesAux;
	}
	
	public void quitarRadioVenciClienteProvesNulos() throws Exception {				
		
		List<RadioVenciClienteProve> radiovenciclienteprovesAux= new ArrayList<RadioVenciClienteProve>();
		
		for(RadioVenciClienteProve radiovenciclienteprove : this.radiovenciclienteproves) {
			if(radiovenciclienteprove==null) {
				radiovenciclienteprovesAux.add(radiovenciclienteprove);
			}
		}
		
		//this.radiovenciclienteproves=radiovenciclienteprovesAux;
		
		this.radiovenciclienteproves.removeAll(radiovenciclienteprovesAux);
	}
	
	public void getSetVersionRowRadioVenciClienteProveWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(radiovenciclienteprove.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((radiovenciclienteprove.getIsDeleted() || (radiovenciclienteprove.getIsChanged()&&!radiovenciclienteprove.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=radiovenciclienteproveDataAccess.getSetVersionRowRadioVenciClienteProve(connexion,radiovenciclienteprove.getId());
				
				if(!radiovenciclienteprove.getVersionRow().equals(timestamp)) {	
					radiovenciclienteprove.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				radiovenciclienteprove.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRadioVenciClienteProve()throws Exception {	
		
		if(radiovenciclienteprove.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((radiovenciclienteprove.getIsDeleted() || (radiovenciclienteprove.getIsChanged()&&!radiovenciclienteprove.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=radiovenciclienteproveDataAccess.getSetVersionRowRadioVenciClienteProve(connexion,radiovenciclienteprove.getId());
			
			try {							
				if(!radiovenciclienteprove.getVersionRow().equals(timestamp)) {	
					radiovenciclienteprove.setVersionRow(timestamp);
				}
				
				radiovenciclienteprove.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRadioVenciClienteProvesWithConnection()throws Exception {	
		if(radiovenciclienteproves!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RadioVenciClienteProve radiovenciclienteproveAux:radiovenciclienteproves) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(radiovenciclienteproveAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(radiovenciclienteproveAux.getIsDeleted() || (radiovenciclienteproveAux.getIsChanged()&&!radiovenciclienteproveAux.getIsNew())) {
						
						timestamp=radiovenciclienteproveDataAccess.getSetVersionRowRadioVenciClienteProve(connexion,radiovenciclienteproveAux.getId());
						
						if(!radiovenciclienteprove.getVersionRow().equals(timestamp)) {	
							radiovenciclienteproveAux.setVersionRow(timestamp);
						}
								
						radiovenciclienteproveAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRadioVenciClienteProves()throws Exception {	
		if(radiovenciclienteproves!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RadioVenciClienteProve radiovenciclienteproveAux:radiovenciclienteproves) {
					if(radiovenciclienteproveAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(radiovenciclienteproveAux.getIsDeleted() || (radiovenciclienteproveAux.getIsChanged()&&!radiovenciclienteproveAux.getIsNew())) {
						
						timestamp=radiovenciclienteproveDataAccess.getSetVersionRowRadioVenciClienteProve(connexion,radiovenciclienteproveAux.getId());
						
						if(!radiovenciclienteproveAux.getVersionRow().equals(timestamp)) {	
							radiovenciclienteproveAux.setVersionRow(timestamp);
						}
						
													
						radiovenciclienteproveAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RadioVenciClienteProveParameterReturnGeneral cargarCombosLoteForeignKeyRadioVenciClienteProveWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoRadioVenci) throws Exception {
		RadioVenciClienteProveParameterReturnGeneral  radiovenciclienteproveReturnGeneral =new RadioVenciClienteProveParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-cargarCombosLoteForeignKeyRadioVenciClienteProveWithConnection");connexion.begin();
			
			radiovenciclienteproveReturnGeneral =new RadioVenciClienteProveParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			radiovenciclienteproveReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoRadioVenci> tiporadiovencisForeignKey=new ArrayList<TipoRadioVenci>();
			TipoRadioVenciLogic tiporadiovenciLogic=new TipoRadioVenciLogic();
			tiporadiovenciLogic.setConnexion(this.connexion);
			tiporadiovenciLogic.getTipoRadioVenciDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRadioVenci.equals("NONE")) {
				tiporadiovenciLogic.getTodosTipoRadioVencis(finalQueryGlobalTipoRadioVenci,new Pagination());
				tiporadiovencisForeignKey=tiporadiovenciLogic.getTipoRadioVencis();
			}

			radiovenciclienteproveReturnGeneral.settiporadiovencisForeignKey(tiporadiovencisForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return radiovenciclienteproveReturnGeneral;
	}
	
	public RadioVenciClienteProveParameterReturnGeneral cargarCombosLoteForeignKeyRadioVenciClienteProve(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoRadioVenci) throws Exception {
		RadioVenciClienteProveParameterReturnGeneral  radiovenciclienteproveReturnGeneral =new RadioVenciClienteProveParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			radiovenciclienteproveReturnGeneral =new RadioVenciClienteProveParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			radiovenciclienteproveReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoRadioVenci> tiporadiovencisForeignKey=new ArrayList<TipoRadioVenci>();
			TipoRadioVenciLogic tiporadiovenciLogic=new TipoRadioVenciLogic();
			tiporadiovenciLogic.setConnexion(this.connexion);
			tiporadiovenciLogic.getTipoRadioVenciDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRadioVenci.equals("NONE")) {
				tiporadiovenciLogic.getTodosTipoRadioVencis(finalQueryGlobalTipoRadioVenci,new Pagination());
				tiporadiovencisForeignKey=tiporadiovenciLogic.getTipoRadioVencis();
			}

			radiovenciclienteproveReturnGeneral.settiporadiovencisForeignKey(tiporadiovencisForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return radiovenciclienteproveReturnGeneral;
	}
	
	
	public void deepLoad(RadioVenciClienteProve radiovenciclienteprove,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RadioVenciClienteProveLogicAdditional.updateRadioVenciClienteProveToGet(radiovenciclienteprove,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		radiovenciclienteprove.setEmpresa(radiovenciclienteproveDataAccess.getEmpresa(connexion,radiovenciclienteprove));
		radiovenciclienteprove.setTipoRadioVenci(radiovenciclienteproveDataAccess.getTipoRadioVenci(connexion,radiovenciclienteprove));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				radiovenciclienteprove.setEmpresa(radiovenciclienteproveDataAccess.getEmpresa(connexion,radiovenciclienteprove));
				continue;
			}

			if(clas.clas.equals(TipoRadioVenci.class)) {
				radiovenciclienteprove.setTipoRadioVenci(radiovenciclienteproveDataAccess.getTipoRadioVenci(connexion,radiovenciclienteprove));
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
			radiovenciclienteprove.setEmpresa(radiovenciclienteproveDataAccess.getEmpresa(connexion,radiovenciclienteprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRadioVenci.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			radiovenciclienteprove.setTipoRadioVenci(radiovenciclienteproveDataAccess.getTipoRadioVenci(connexion,radiovenciclienteprove));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		radiovenciclienteprove.setEmpresa(radiovenciclienteproveDataAccess.getEmpresa(connexion,radiovenciclienteprove));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(radiovenciclienteprove.getEmpresa(),isDeep,deepLoadType,clases);
				
		radiovenciclienteprove.setTipoRadioVenci(radiovenciclienteproveDataAccess.getTipoRadioVenci(connexion,radiovenciclienteprove));
		TipoRadioVenciLogic tiporadiovenciLogic= new TipoRadioVenciLogic(connexion);
		tiporadiovenciLogic.deepLoad(radiovenciclienteprove.getTipoRadioVenci(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				radiovenciclienteprove.setEmpresa(radiovenciclienteproveDataAccess.getEmpresa(connexion,radiovenciclienteprove));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(radiovenciclienteprove.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRadioVenci.class)) {
				radiovenciclienteprove.setTipoRadioVenci(radiovenciclienteproveDataAccess.getTipoRadioVenci(connexion,radiovenciclienteprove));
				TipoRadioVenciLogic tiporadiovenciLogic= new TipoRadioVenciLogic(connexion);
				tiporadiovenciLogic.deepLoad(radiovenciclienteprove.getTipoRadioVenci(),isDeep,deepLoadType,clases);				
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
			radiovenciclienteprove.setEmpresa(radiovenciclienteproveDataAccess.getEmpresa(connexion,radiovenciclienteprove));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(radiovenciclienteprove.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRadioVenci.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			radiovenciclienteprove.setTipoRadioVenci(radiovenciclienteproveDataAccess.getTipoRadioVenci(connexion,radiovenciclienteprove));
			TipoRadioVenciLogic tiporadiovenciLogic= new TipoRadioVenciLogic(connexion);
			tiporadiovenciLogic.deepLoad(radiovenciclienteprove.getTipoRadioVenci(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RadioVenciClienteProve radiovenciclienteprove,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RadioVenciClienteProveLogicAdditional.updateRadioVenciClienteProveToSave(radiovenciclienteprove,this.arrDatoGeneral);
			
RadioVenciClienteProveDataAccess.save(radiovenciclienteprove, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(radiovenciclienteprove.getEmpresa(),connexion);

		TipoRadioVenciDataAccess.save(radiovenciclienteprove.getTipoRadioVenci(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(radiovenciclienteprove.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRadioVenci.class)) {
				TipoRadioVenciDataAccess.save(radiovenciclienteprove.getTipoRadioVenci(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(radiovenciclienteprove.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(radiovenciclienteprove.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoRadioVenciDataAccess.save(radiovenciclienteprove.getTipoRadioVenci(),connexion);
		TipoRadioVenciLogic tiporadiovenciLogic= new TipoRadioVenciLogic(connexion);
		tiporadiovenciLogic.deepLoad(radiovenciclienteprove.getTipoRadioVenci(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(radiovenciclienteprove.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(radiovenciclienteprove.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRadioVenci.class)) {
				TipoRadioVenciDataAccess.save(radiovenciclienteprove.getTipoRadioVenci(),connexion);
				TipoRadioVenciLogic tiporadiovenciLogic= new TipoRadioVenciLogic(connexion);
				tiporadiovenciLogic.deepSave(radiovenciclienteprove.getTipoRadioVenci(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(RadioVenciClienteProve.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(radiovenciclienteprove,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(radiovenciclienteprove);
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
			this.deepLoad(this.radiovenciclienteprove,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RadioVenciClienteProve.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(radiovenciclienteproves!=null) {
				for(RadioVenciClienteProve radiovenciclienteprove:radiovenciclienteproves) {
					this.deepLoad(radiovenciclienteprove,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(radiovenciclienteproves);
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
			if(radiovenciclienteproves!=null) {
				for(RadioVenciClienteProve radiovenciclienteprove:radiovenciclienteproves) {
					this.deepLoad(radiovenciclienteprove,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(radiovenciclienteproves);
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
			this.getNewConnexionToDeep(RadioVenciClienteProve.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(radiovenciclienteprove,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RadioVenciClienteProve.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(radiovenciclienteproves!=null) {
				for(RadioVenciClienteProve radiovenciclienteprove:radiovenciclienteproves) {
					this.deepSave(radiovenciclienteprove,isDeep,deepLoadType,clases);
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
			if(radiovenciclienteproves!=null) {
				for(RadioVenciClienteProve radiovenciclienteprove:radiovenciclienteproves) {
					this.deepSave(radiovenciclienteprove,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRadioVenciClienteProvesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RadioVenciClienteProveConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRadioVenciClienteProvesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RadioVenciClienteProveConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRadioVenciClienteProvesFK_IdTipoRadioVenciWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_radio_venci)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RadioVenciClienteProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRadioVenci= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRadioVenci.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_radio_venci,RadioVenciClienteProveConstantesFunciones.IDTIPORADIOVENCI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRadioVenci);

			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRadioVenci","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRadioVenciClienteProvesFK_IdTipoRadioVenci(String sFinalQuery,Pagination pagination,Long id_tipo_radio_venci)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRadioVenci= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRadioVenci.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_radio_venci,RadioVenciClienteProveConstantesFunciones.IDTIPORADIOVENCI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRadioVenci);

			RadioVenciClienteProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRadioVenci","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(this.radiovenciclienteproves);
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
			if(RadioVenciClienteProveConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RadioVenciClienteProveDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RadioVenciClienteProve radiovenciclienteprove,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RadioVenciClienteProveConstantesFunciones.ISCONAUDITORIA) {
				if(radiovenciclienteprove.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RadioVenciClienteProveDataAccess.TABLENAME, radiovenciclienteprove.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RadioVenciClienteProveConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RadioVenciClienteProveLogic.registrarAuditoriaDetallesRadioVenciClienteProve(connexion,radiovenciclienteprove,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(radiovenciclienteprove.getIsDeleted()) {
					/*if(!radiovenciclienteprove.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RadioVenciClienteProveDataAccess.TABLENAME, radiovenciclienteprove.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RadioVenciClienteProveLogic.registrarAuditoriaDetallesRadioVenciClienteProve(connexion,radiovenciclienteprove,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RadioVenciClienteProveDataAccess.TABLENAME, radiovenciclienteprove.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(radiovenciclienteprove.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RadioVenciClienteProveDataAccess.TABLENAME, radiovenciclienteprove.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RadioVenciClienteProveConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RadioVenciClienteProveLogic.registrarAuditoriaDetallesRadioVenciClienteProve(connexion,radiovenciclienteprove,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRadioVenciClienteProve(Connexion connexion,RadioVenciClienteProve radiovenciclienteprove)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(radiovenciclienteprove.getIsNew()||!radiovenciclienteprove.getid_empresa().equals(radiovenciclienteprove.getRadioVenciClienteProveOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(radiovenciclienteprove.getRadioVenciClienteProveOriginal().getid_empresa()!=null)
				{
					strValorActual=radiovenciclienteprove.getRadioVenciClienteProveOriginal().getid_empresa().toString();
				}
				if(radiovenciclienteprove.getid_empresa()!=null)
				{
					strValorNuevo=radiovenciclienteprove.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RadioVenciClienteProveConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(radiovenciclienteprove.getIsNew()||!radiovenciclienteprove.getid_tipo_radio_venci().equals(radiovenciclienteprove.getRadioVenciClienteProveOriginal().getid_tipo_radio_venci()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(radiovenciclienteprove.getRadioVenciClienteProveOriginal().getid_tipo_radio_venci()!=null)
				{
					strValorActual=radiovenciclienteprove.getRadioVenciClienteProveOriginal().getid_tipo_radio_venci().toString();
				}
				if(radiovenciclienteprove.getid_tipo_radio_venci()!=null)
				{
					strValorNuevo=radiovenciclienteprove.getid_tipo_radio_venci().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RadioVenciClienteProveConstantesFunciones.IDTIPORADIOVENCI,strValorActual,strValorNuevo);
			}	
			
			if(radiovenciclienteprove.getIsNew()||!radiovenciclienteprove.getdia_desde().equals(radiovenciclienteprove.getRadioVenciClienteProveOriginal().getdia_desde()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(radiovenciclienteprove.getRadioVenciClienteProveOriginal().getdia_desde()!=null)
				{
					strValorActual=radiovenciclienteprove.getRadioVenciClienteProveOriginal().getdia_desde().toString();
				}
				if(radiovenciclienteprove.getdia_desde()!=null)
				{
					strValorNuevo=radiovenciclienteprove.getdia_desde().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RadioVenciClienteProveConstantesFunciones.DIADESDE,strValorActual,strValorNuevo);
			}	
			
			if(radiovenciclienteprove.getIsNew()||!radiovenciclienteprove.getdia_hasta().equals(radiovenciclienteprove.getRadioVenciClienteProveOriginal().getdia_hasta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(radiovenciclienteprove.getRadioVenciClienteProveOriginal().getdia_hasta()!=null)
				{
					strValorActual=radiovenciclienteprove.getRadioVenciClienteProveOriginal().getdia_hasta().toString();
				}
				if(radiovenciclienteprove.getdia_hasta()!=null)
				{
					strValorNuevo=radiovenciclienteprove.getdia_hasta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RadioVenciClienteProveConstantesFunciones.DIAHASTA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRadioVenciClienteProveRelacionesWithConnection(RadioVenciClienteProve radiovenciclienteprove) throws Exception {

		if(!radiovenciclienteprove.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRadioVenciClienteProveRelacionesBase(radiovenciclienteprove,true);
		}
	}

	public void saveRadioVenciClienteProveRelaciones(RadioVenciClienteProve radiovenciclienteprove)throws Exception {

		if(!radiovenciclienteprove.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRadioVenciClienteProveRelacionesBase(radiovenciclienteprove,false);
		}
	}

	public void saveRadioVenciClienteProveRelacionesBase(RadioVenciClienteProve radiovenciclienteprove,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RadioVenciClienteProve-saveRelacionesWithConnection");}
	

			this.setRadioVenciClienteProve(radiovenciclienteprove);

			if(RadioVenciClienteProveLogicAdditional.validarSaveRelaciones(radiovenciclienteprove,this)) {

				RadioVenciClienteProveLogicAdditional.updateRelacionesToSave(radiovenciclienteprove,this);

				if((radiovenciclienteprove.getIsNew()||radiovenciclienteprove.getIsChanged())&&!radiovenciclienteprove.getIsDeleted()) {
					this.saveRadioVenciClienteProve();
					this.saveRadioVenciClienteProveRelacionesDetalles();

				} else if(radiovenciclienteprove.getIsDeleted()) {
					this.saveRadioVenciClienteProveRelacionesDetalles();
					this.saveRadioVenciClienteProve();
				}

				RadioVenciClienteProveLogicAdditional.updateRelacionesToSaveAfter(radiovenciclienteprove,this);

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
	
	
	private void saveRadioVenciClienteProveRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRadioVenciClienteProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RadioVenciClienteProveConstantesFunciones.getClassesForeignKeysOfRadioVenciClienteProve(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRadioVenciClienteProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RadioVenciClienteProveConstantesFunciones.getClassesRelationshipsOfRadioVenciClienteProve(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

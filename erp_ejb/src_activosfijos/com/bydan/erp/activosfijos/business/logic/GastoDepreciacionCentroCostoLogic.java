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
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.util.GastoDepreciacionCentroCostoConstantesFunciones;
import com.bydan.erp.activosfijos.util.GastoDepreciacionCentroCostoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.GastoDepreciacionCentroCostoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.GastoDepreciacionCentroCosto;
import com.bydan.erp.activosfijos.business.logic.GastoDepreciacionCentroCostoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class GastoDepreciacionCentroCostoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(GastoDepreciacionCentroCostoLogic.class);
	
	protected GastoDepreciacionCentroCostoDataAccess gastodepreciacioncentrocostoDataAccess; 	
	protected GastoDepreciacionCentroCosto gastodepreciacioncentrocosto;
	protected List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos;
	protected Object gastodepreciacioncentrocostoObject;	
	protected List<Object> gastodepreciacioncentrocostosObject;
	
	public static ClassValidator<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostoValidator = new ClassValidator<GastoDepreciacionCentroCosto>(GastoDepreciacionCentroCosto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected GastoDepreciacionCentroCostoLogicAdditional gastodepreciacioncentrocostoLogicAdditional=null;
	
	public GastoDepreciacionCentroCostoLogicAdditional getGastoDepreciacionCentroCostoLogicAdditional() {
		return this.gastodepreciacioncentrocostoLogicAdditional;
	}
	
	public void setGastoDepreciacionCentroCostoLogicAdditional(GastoDepreciacionCentroCostoLogicAdditional gastodepreciacioncentrocostoLogicAdditional) {
		try {
			this.gastodepreciacioncentrocostoLogicAdditional=gastodepreciacioncentrocostoLogicAdditional;
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
	
	
	
	
	public  GastoDepreciacionCentroCostoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.gastodepreciacioncentrocostoDataAccess = new GastoDepreciacionCentroCostoDataAccess();
			
			this.gastodepreciacioncentrocostos= new ArrayList<GastoDepreciacionCentroCosto>();
			this.gastodepreciacioncentrocosto= new GastoDepreciacionCentroCosto();
			
			this.gastodepreciacioncentrocostoObject=new Object();
			this.gastodepreciacioncentrocostosObject=new ArrayList<Object>();
				
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
			
			this.gastodepreciacioncentrocostoDataAccess.setConnexionType(this.connexionType);
			this.gastodepreciacioncentrocostoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  GastoDepreciacionCentroCostoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.gastodepreciacioncentrocostoDataAccess = new GastoDepreciacionCentroCostoDataAccess();
			this.gastodepreciacioncentrocostos= new ArrayList<GastoDepreciacionCentroCosto>();
			this.gastodepreciacioncentrocosto= new GastoDepreciacionCentroCosto();
			this.gastodepreciacioncentrocostoObject=new Object();
			this.gastodepreciacioncentrocostosObject=new ArrayList<Object>();
			
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
			
			this.gastodepreciacioncentrocostoDataAccess.setConnexionType(this.connexionType);
			this.gastodepreciacioncentrocostoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public GastoDepreciacionCentroCosto getGastoDepreciacionCentroCosto() throws Exception {	
		GastoDepreciacionCentroCostoLogicAdditional.checkGastoDepreciacionCentroCostoToGet(gastodepreciacioncentrocosto,this.datosCliente,this.arrDatoGeneral);
		GastoDepreciacionCentroCostoLogicAdditional.updateGastoDepreciacionCentroCostoToGet(gastodepreciacioncentrocosto,this.arrDatoGeneral);
		
		return gastodepreciacioncentrocosto;
	}
		
	public void setGastoDepreciacionCentroCosto(GastoDepreciacionCentroCosto newGastoDepreciacionCentroCosto) {
		this.gastodepreciacioncentrocosto = newGastoDepreciacionCentroCosto;
	}
	
	public GastoDepreciacionCentroCostoDataAccess getGastoDepreciacionCentroCostoDataAccess() {
		return gastodepreciacioncentrocostoDataAccess;
	}
	
	public void setGastoDepreciacionCentroCostoDataAccess(GastoDepreciacionCentroCostoDataAccess newgastodepreciacioncentrocostoDataAccess) {
		this.gastodepreciacioncentrocostoDataAccess = newgastodepreciacioncentrocostoDataAccess;
	}
	
	public List<GastoDepreciacionCentroCosto> getGastoDepreciacionCentroCostos() throws Exception {		
		this.quitarGastoDepreciacionCentroCostosNulos();
		
		GastoDepreciacionCentroCostoLogicAdditional.checkGastoDepreciacionCentroCostoToGets(gastodepreciacioncentrocostos,this.datosCliente,this.arrDatoGeneral);
		
		for (GastoDepreciacionCentroCosto gastodepreciacioncentrocostoLocal: gastodepreciacioncentrocostos ) {
			GastoDepreciacionCentroCostoLogicAdditional.updateGastoDepreciacionCentroCostoToGet(gastodepreciacioncentrocostoLocal,this.arrDatoGeneral);
		}
		
		return gastodepreciacioncentrocostos;
	}
	
	public void setGastoDepreciacionCentroCostos(List<GastoDepreciacionCentroCosto> newGastoDepreciacionCentroCostos) {
		this.gastodepreciacioncentrocostos = newGastoDepreciacionCentroCostos;
	}
	
	public Object getGastoDepreciacionCentroCostoObject() {	
		this.gastodepreciacioncentrocostoObject=this.gastodepreciacioncentrocostoDataAccess.getEntityObject();
		return this.gastodepreciacioncentrocostoObject;
	}
		
	public void setGastoDepreciacionCentroCostoObject(Object newGastoDepreciacionCentroCostoObject) {
		this.gastodepreciacioncentrocostoObject = newGastoDepreciacionCentroCostoObject;
	}
	
	public List<Object> getGastoDepreciacionCentroCostosObject() {		
		this.gastodepreciacioncentrocostosObject=this.gastodepreciacioncentrocostoDataAccess.getEntitiesObject();
		return this.gastodepreciacioncentrocostosObject;
	}
		
	public void setGastoDepreciacionCentroCostosObject(List<Object> newGastoDepreciacionCentroCostosObject) {
		this.gastodepreciacioncentrocostosObject = newGastoDepreciacionCentroCostosObject;
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
		
		if(this.gastodepreciacioncentrocostoDataAccess!=null) {
			this.gastodepreciacioncentrocostoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			gastodepreciacioncentrocostoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			gastodepreciacioncentrocostoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			gastodepreciacioncentrocosto=gastodepreciacioncentrocostoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.gastodepreciacioncentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocosto);
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
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		  		  
        try {
			
			gastodepreciacioncentrocosto=gastodepreciacioncentrocostoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.gastodepreciacioncentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocosto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			gastodepreciacioncentrocosto=gastodepreciacioncentrocostoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.gastodepreciacioncentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocosto);
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
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		  		  
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
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		  		  
        try {
			
			gastodepreciacioncentrocosto=gastodepreciacioncentrocostoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.gastodepreciacioncentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocosto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		  		  
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
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =gastodepreciacioncentrocostoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=gastodepreciacioncentrocostoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =gastodepreciacioncentrocostoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=gastodepreciacioncentrocostoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =gastodepreciacioncentrocostoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=gastodepreciacioncentrocostoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		gastodepreciacioncentrocostos = new  ArrayList<GastoDepreciacionCentroCosto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
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
		gastodepreciacioncentrocostos = new  ArrayList<GastoDepreciacionCentroCosto>();
		  		  
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
		gastodepreciacioncentrocostos = new  ArrayList<GastoDepreciacionCentroCosto>();
		  		  
        try {			
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		gastodepreciacioncentrocostos = new  ArrayList<GastoDepreciacionCentroCosto>();
		  		  
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
		gastodepreciacioncentrocostos = new  ArrayList<GastoDepreciacionCentroCosto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
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
		gastodepreciacioncentrocostos = new  ArrayList<GastoDepreciacionCentroCosto>();
		  		  
        try {
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
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
		gastodepreciacioncentrocostos = new  ArrayList<GastoDepreciacionCentroCosto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
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
		gastodepreciacioncentrocostos = new  ArrayList<GastoDepreciacionCentroCosto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacioncentrocosto=gastodepreciacioncentrocostoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGastoDepreciacionCentroCosto(gastodepreciacioncentrocosto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocosto);
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
		gastodepreciacioncentrocosto = new  GastoDepreciacionCentroCosto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacioncentrocosto=gastodepreciacioncentrocostoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGastoDepreciacionCentroCosto(gastodepreciacioncentrocosto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocosto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		gastodepreciacioncentrocostos = new  ArrayList<GastoDepreciacionCentroCosto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
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
		gastodepreciacioncentrocostos = new  ArrayList<GastoDepreciacionCentroCosto>();
		  		  
        try {
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosGastoDepreciacionCentroCostosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		gastodepreciacioncentrocostos = new  ArrayList<GastoDepreciacionCentroCosto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getTodosGastoDepreciacionCentroCostosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
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
	
	public  void  getTodosGastoDepreciacionCentroCostos(String sFinalQuery,Pagination pagination)throws Exception {
		gastodepreciacioncentrocostos = new  ArrayList<GastoDepreciacionCentroCosto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarGastoDepreciacionCentroCosto(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto) throws Exception {
		Boolean estaValidado=false;
		
		if(gastodepreciacioncentrocosto.getIsNew() || gastodepreciacioncentrocosto.getIsChanged()) { 
			this.invalidValues = gastodepreciacioncentrocostoValidator.getInvalidValues(gastodepreciacioncentrocosto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(gastodepreciacioncentrocosto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarGastoDepreciacionCentroCosto(List<GastoDepreciacionCentroCosto> GastoDepreciacionCentroCostos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoLocal:gastodepreciacioncentrocostos) {				
			estaValidadoObjeto=this.validarGuardarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarGastoDepreciacionCentroCosto(List<GastoDepreciacionCentroCosto> GastoDepreciacionCentroCostos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarGastoDepreciacionCentroCosto(GastoDepreciacionCentroCosto GastoDepreciacionCentroCosto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGastoDepreciacionCentroCosto(gastodepreciacioncentrocosto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+gastodepreciacioncentrocosto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=GastoDepreciacionCentroCostoConstantesFunciones.getGastoDepreciacionCentroCostoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"gastodepreciacioncentrocosto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(GastoDepreciacionCentroCostoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(GastoDepreciacionCentroCostoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveGastoDepreciacionCentroCostoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-saveGastoDepreciacionCentroCostoWithConnection");connexion.begin();			
			
			GastoDepreciacionCentroCostoLogicAdditional.checkGastoDepreciacionCentroCostoToSave(this.gastodepreciacioncentrocosto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GastoDepreciacionCentroCostoLogicAdditional.updateGastoDepreciacionCentroCostoToSave(this.gastodepreciacioncentrocosto,this.arrDatoGeneral);
			
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.gastodepreciacioncentrocosto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowGastoDepreciacionCentroCosto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocosto)) {
				GastoDepreciacionCentroCostoDataAccess.save(this.gastodepreciacioncentrocosto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.gastodepreciacioncentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GastoDepreciacionCentroCostoLogicAdditional.checkGastoDepreciacionCentroCostoToSaveAfter(this.gastodepreciacioncentrocosto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGastoDepreciacionCentroCosto();
			
			connexion.commit();			
			
			if(this.gastodepreciacioncentrocosto.getIsDeleted()) {
				this.gastodepreciacioncentrocosto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveGastoDepreciacionCentroCosto()throws Exception {	
		try {	
			
			GastoDepreciacionCentroCostoLogicAdditional.checkGastoDepreciacionCentroCostoToSave(this.gastodepreciacioncentrocosto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GastoDepreciacionCentroCostoLogicAdditional.updateGastoDepreciacionCentroCostoToSave(this.gastodepreciacioncentrocosto,this.arrDatoGeneral);
			
			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.gastodepreciacioncentrocosto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocosto)) {			
				GastoDepreciacionCentroCostoDataAccess.save(this.gastodepreciacioncentrocosto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.gastodepreciacioncentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GastoDepreciacionCentroCostoLogicAdditional.checkGastoDepreciacionCentroCostoToSaveAfter(this.gastodepreciacioncentrocosto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.gastodepreciacioncentrocosto.getIsDeleted()) {
				this.gastodepreciacioncentrocosto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveGastoDepreciacionCentroCostosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-saveGastoDepreciacionCentroCostosWithConnection");connexion.begin();			
			
			GastoDepreciacionCentroCostoLogicAdditional.checkGastoDepreciacionCentroCostoToSaves(gastodepreciacioncentrocostos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowGastoDepreciacionCentroCostos();
			
			Boolean validadoTodosGastoDepreciacionCentroCosto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoLocal:gastodepreciacioncentrocostos) {		
				if(gastodepreciacioncentrocostoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GastoDepreciacionCentroCostoLogicAdditional.updateGastoDepreciacionCentroCostoToSave(gastodepreciacioncentrocostoLocal,this.arrDatoGeneral);
	        	
				GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),gastodepreciacioncentrocostoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostoLocal)) {
					GastoDepreciacionCentroCostoDataAccess.save(gastodepreciacioncentrocostoLocal, connexion);				
				} else {
					validadoTodosGastoDepreciacionCentroCosto=false;
				}
			}
			
			if(!validadoTodosGastoDepreciacionCentroCosto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GastoDepreciacionCentroCostoLogicAdditional.checkGastoDepreciacionCentroCostoToSavesAfter(gastodepreciacioncentrocostos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGastoDepreciacionCentroCostos();
			
			connexion.commit();		
			
			this.quitarGastoDepreciacionCentroCostosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveGastoDepreciacionCentroCostos()throws Exception {				
		 try {	
			GastoDepreciacionCentroCostoLogicAdditional.checkGastoDepreciacionCentroCostoToSaves(gastodepreciacioncentrocostos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosGastoDepreciacionCentroCosto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoLocal:gastodepreciacioncentrocostos) {				
				if(gastodepreciacioncentrocostoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GastoDepreciacionCentroCostoLogicAdditional.updateGastoDepreciacionCentroCostoToSave(gastodepreciacioncentrocostoLocal,this.arrDatoGeneral);
	        	
				GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),gastodepreciacioncentrocostoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGastoDepreciacionCentroCosto(gastodepreciacioncentrocostoLocal)) {				
					GastoDepreciacionCentroCostoDataAccess.save(gastodepreciacioncentrocostoLocal, connexion);				
				} else {
					validadoTodosGastoDepreciacionCentroCosto=false;
				}
			}
			
			if(!validadoTodosGastoDepreciacionCentroCosto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GastoDepreciacionCentroCostoLogicAdditional.checkGastoDepreciacionCentroCostoToSavesAfter(gastodepreciacioncentrocostos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarGastoDepreciacionCentroCostosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GastoDepreciacionCentroCostoParameterReturnGeneral procesarAccionGastoDepreciacionCentroCostos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,GastoDepreciacionCentroCostoParameterReturnGeneral gastodepreciacioncentrocostoParameterGeneral)throws Exception {
		 try {	
			GastoDepreciacionCentroCostoParameterReturnGeneral gastodepreciacioncentrocostoReturnGeneral=new GastoDepreciacionCentroCostoParameterReturnGeneral();
	
			GastoDepreciacionCentroCostoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,gastodepreciacioncentrocostos,gastodepreciacioncentrocostoParameterGeneral,gastodepreciacioncentrocostoReturnGeneral);
			
			return gastodepreciacioncentrocostoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GastoDepreciacionCentroCostoParameterReturnGeneral procesarAccionGastoDepreciacionCentroCostosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,GastoDepreciacionCentroCostoParameterReturnGeneral gastodepreciacioncentrocostoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-procesarAccionGastoDepreciacionCentroCostosWithConnection");connexion.begin();			
			
			GastoDepreciacionCentroCostoParameterReturnGeneral gastodepreciacioncentrocostoReturnGeneral=new GastoDepreciacionCentroCostoParameterReturnGeneral();
	
			GastoDepreciacionCentroCostoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,gastodepreciacioncentrocostos,gastodepreciacioncentrocostoParameterGeneral,gastodepreciacioncentrocostoReturnGeneral);
			
			this.connexion.commit();
			
			return gastodepreciacioncentrocostoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GastoDepreciacionCentroCostoParameterReturnGeneral procesarEventosGastoDepreciacionCentroCostos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,GastoDepreciacionCentroCostoParameterReturnGeneral gastodepreciacioncentrocostoParameterGeneral,Boolean isEsNuevoGastoDepreciacionCentroCosto,ArrayList<Classe> clases)throws Exception {
		 try {	
			GastoDepreciacionCentroCostoParameterReturnGeneral gastodepreciacioncentrocostoReturnGeneral=new GastoDepreciacionCentroCostoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				gastodepreciacioncentrocostoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GastoDepreciacionCentroCostoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,gastodepreciacioncentrocostos,gastodepreciacioncentrocosto,gastodepreciacioncentrocostoParameterGeneral,gastodepreciacioncentrocostoReturnGeneral,isEsNuevoGastoDepreciacionCentroCosto,clases);
			
			return gastodepreciacioncentrocostoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public GastoDepreciacionCentroCostoParameterReturnGeneral procesarEventosGastoDepreciacionCentroCostosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,GastoDepreciacionCentroCostoParameterReturnGeneral gastodepreciacioncentrocostoParameterGeneral,Boolean isEsNuevoGastoDepreciacionCentroCosto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-procesarEventosGastoDepreciacionCentroCostosWithConnection");connexion.begin();			
			
			GastoDepreciacionCentroCostoParameterReturnGeneral gastodepreciacioncentrocostoReturnGeneral=new GastoDepreciacionCentroCostoParameterReturnGeneral();
	
			gastodepreciacioncentrocostoReturnGeneral.setGastoDepreciacionCentroCosto(gastodepreciacioncentrocosto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				gastodepreciacioncentrocostoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GastoDepreciacionCentroCostoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,gastodepreciacioncentrocostos,gastodepreciacioncentrocosto,gastodepreciacioncentrocostoParameterGeneral,gastodepreciacioncentrocostoReturnGeneral,isEsNuevoGastoDepreciacionCentroCosto,clases);
			
			this.connexion.commit();
			
			return gastodepreciacioncentrocostoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GastoDepreciacionCentroCostoParameterReturnGeneral procesarImportacionGastoDepreciacionCentroCostosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,GastoDepreciacionCentroCostoParameterReturnGeneral gastodepreciacioncentrocostoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-procesarImportacionGastoDepreciacionCentroCostosWithConnection");connexion.begin();			
			
			GastoDepreciacionCentroCostoParameterReturnGeneral gastodepreciacioncentrocostoReturnGeneral=new GastoDepreciacionCentroCostoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.gastodepreciacioncentrocostos=new ArrayList<GastoDepreciacionCentroCosto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.gastodepreciacioncentrocosto=new GastoDepreciacionCentroCosto();
				
				
				if(conColumnasBase) {this.gastodepreciacioncentrocosto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.gastodepreciacioncentrocosto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.gastodepreciacioncentrocosto.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.gastodepreciacioncentrocostos.add(this.gastodepreciacioncentrocosto);
			}
			
			this.saveGastoDepreciacionCentroCostos();
			
			this.connexion.commit();
			
			gastodepreciacioncentrocostoReturnGeneral.setConRetornoEstaProcesado(true);
			gastodepreciacioncentrocostoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return gastodepreciacioncentrocostoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarGastoDepreciacionCentroCostosEliminados() throws Exception {				
		
		List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostosAux= new ArrayList<GastoDepreciacionCentroCosto>();
		
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:gastodepreciacioncentrocostos) {
			if(!gastodepreciacioncentrocosto.getIsDeleted()) {
				gastodepreciacioncentrocostosAux.add(gastodepreciacioncentrocosto);
			}
		}
		
		gastodepreciacioncentrocostos=gastodepreciacioncentrocostosAux;
	}
	
	public void quitarGastoDepreciacionCentroCostosNulos() throws Exception {				
		
		List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostosAux= new ArrayList<GastoDepreciacionCentroCosto>();
		
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto : this.gastodepreciacioncentrocostos) {
			if(gastodepreciacioncentrocosto==null) {
				gastodepreciacioncentrocostosAux.add(gastodepreciacioncentrocosto);
			}
		}
		
		//this.gastodepreciacioncentrocostos=gastodepreciacioncentrocostosAux;
		
		this.gastodepreciacioncentrocostos.removeAll(gastodepreciacioncentrocostosAux);
	}
	
	public void getSetVersionRowGastoDepreciacionCentroCostoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(gastodepreciacioncentrocosto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((gastodepreciacioncentrocosto.getIsDeleted() || (gastodepreciacioncentrocosto.getIsChanged()&&!gastodepreciacioncentrocosto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=gastodepreciacioncentrocostoDataAccess.getSetVersionRowGastoDepreciacionCentroCosto(connexion,gastodepreciacioncentrocosto.getId());
				
				if(!gastodepreciacioncentrocosto.getVersionRow().equals(timestamp)) {	
					gastodepreciacioncentrocosto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				gastodepreciacioncentrocosto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowGastoDepreciacionCentroCosto()throws Exception {	
		
		if(gastodepreciacioncentrocosto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((gastodepreciacioncentrocosto.getIsDeleted() || (gastodepreciacioncentrocosto.getIsChanged()&&!gastodepreciacioncentrocosto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=gastodepreciacioncentrocostoDataAccess.getSetVersionRowGastoDepreciacionCentroCosto(connexion,gastodepreciacioncentrocosto.getId());
			
			try {							
				if(!gastodepreciacioncentrocosto.getVersionRow().equals(timestamp)) {	
					gastodepreciacioncentrocosto.setVersionRow(timestamp);
				}
				
				gastodepreciacioncentrocosto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowGastoDepreciacionCentroCostosWithConnection()throws Exception {	
		if(gastodepreciacioncentrocostos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoAux:gastodepreciacioncentrocostos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(gastodepreciacioncentrocostoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(gastodepreciacioncentrocostoAux.getIsDeleted() || (gastodepreciacioncentrocostoAux.getIsChanged()&&!gastodepreciacioncentrocostoAux.getIsNew())) {
						
						timestamp=gastodepreciacioncentrocostoDataAccess.getSetVersionRowGastoDepreciacionCentroCosto(connexion,gastodepreciacioncentrocostoAux.getId());
						
						if(!gastodepreciacioncentrocosto.getVersionRow().equals(timestamp)) {	
							gastodepreciacioncentrocostoAux.setVersionRow(timestamp);
						}
								
						gastodepreciacioncentrocostoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowGastoDepreciacionCentroCostos()throws Exception {	
		if(gastodepreciacioncentrocostos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoAux:gastodepreciacioncentrocostos) {
					if(gastodepreciacioncentrocostoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(gastodepreciacioncentrocostoAux.getIsDeleted() || (gastodepreciacioncentrocostoAux.getIsChanged()&&!gastodepreciacioncentrocostoAux.getIsNew())) {
						
						timestamp=gastodepreciacioncentrocostoDataAccess.getSetVersionRowGastoDepreciacionCentroCosto(connexion,gastodepreciacioncentrocostoAux.getId());
						
						if(!gastodepreciacioncentrocostoAux.getVersionRow().equals(timestamp)) {	
							gastodepreciacioncentrocostoAux.setVersionRow(timestamp);
						}
						
													
						gastodepreciacioncentrocostoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public GastoDepreciacionCentroCostoParameterReturnGeneral cargarCombosLoteForeignKeyGastoDepreciacionCentroCostoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCentroCosto,String finalQueryGlobalDetalleActivoFijo,String finalQueryGlobalCuentaContable) throws Exception {
		GastoDepreciacionCentroCostoParameterReturnGeneral  gastodepreciacioncentrocostoReturnGeneral =new GastoDepreciacionCentroCostoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-cargarCombosLoteForeignKeyGastoDepreciacionCentroCostoWithConnection");connexion.begin();
			
			gastodepreciacioncentrocostoReturnGeneral =new GastoDepreciacionCentroCostoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			gastodepreciacioncentrocostoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			gastodepreciacioncentrocostoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			gastodepreciacioncentrocostoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			gastodepreciacioncentrocostoReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			gastodepreciacioncentrocostoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return gastodepreciacioncentrocostoReturnGeneral;
	}
	
	public GastoDepreciacionCentroCostoParameterReturnGeneral cargarCombosLoteForeignKeyGastoDepreciacionCentroCosto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCentroCosto,String finalQueryGlobalDetalleActivoFijo,String finalQueryGlobalCuentaContable) throws Exception {
		GastoDepreciacionCentroCostoParameterReturnGeneral  gastodepreciacioncentrocostoReturnGeneral =new GastoDepreciacionCentroCostoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			gastodepreciacioncentrocostoReturnGeneral =new GastoDepreciacionCentroCostoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			gastodepreciacioncentrocostoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			gastodepreciacioncentrocostoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			gastodepreciacioncentrocostoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			gastodepreciacioncentrocostoReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			gastodepreciacioncentrocostoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return gastodepreciacioncentrocostoReturnGeneral;
	}
	
	
	public void deepLoad(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			GastoDepreciacionCentroCostoLogicAdditional.updateGastoDepreciacionCentroCostoToGet(gastodepreciacioncentrocosto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		gastodepreciacioncentrocosto.setEmpresa(gastodepreciacioncentrocostoDataAccess.getEmpresa(connexion,gastodepreciacioncentrocosto));
		gastodepreciacioncentrocosto.setSucursal(gastodepreciacioncentrocostoDataAccess.getSucursal(connexion,gastodepreciacioncentrocosto));
		gastodepreciacioncentrocosto.setCentroCosto(gastodepreciacioncentrocostoDataAccess.getCentroCosto(connexion,gastodepreciacioncentrocosto));
		gastodepreciacioncentrocosto.setDetalleActivoFijo(gastodepreciacioncentrocostoDataAccess.getDetalleActivoFijo(connexion,gastodepreciacioncentrocosto));
		gastodepreciacioncentrocosto.setCuentaContable(gastodepreciacioncentrocostoDataAccess.getCuentaContable(connexion,gastodepreciacioncentrocosto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				gastodepreciacioncentrocosto.setEmpresa(gastodepreciacioncentrocostoDataAccess.getEmpresa(connexion,gastodepreciacioncentrocosto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				gastodepreciacioncentrocosto.setSucursal(gastodepreciacioncentrocostoDataAccess.getSucursal(connexion,gastodepreciacioncentrocosto));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				gastodepreciacioncentrocosto.setCentroCosto(gastodepreciacioncentrocostoDataAccess.getCentroCosto(connexion,gastodepreciacioncentrocosto));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				gastodepreciacioncentrocosto.setDetalleActivoFijo(gastodepreciacioncentrocostoDataAccess.getDetalleActivoFijo(connexion,gastodepreciacioncentrocosto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				gastodepreciacioncentrocosto.setCuentaContable(gastodepreciacioncentrocostoDataAccess.getCuentaContable(connexion,gastodepreciacioncentrocosto));
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
			gastodepreciacioncentrocosto.setEmpresa(gastodepreciacioncentrocostoDataAccess.getEmpresa(connexion,gastodepreciacioncentrocosto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastodepreciacioncentrocosto.setSucursal(gastodepreciacioncentrocostoDataAccess.getSucursal(connexion,gastodepreciacioncentrocosto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastodepreciacioncentrocosto.setCentroCosto(gastodepreciacioncentrocostoDataAccess.getCentroCosto(connexion,gastodepreciacioncentrocosto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastodepreciacioncentrocosto.setDetalleActivoFijo(gastodepreciacioncentrocostoDataAccess.getDetalleActivoFijo(connexion,gastodepreciacioncentrocosto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastodepreciacioncentrocosto.setCuentaContable(gastodepreciacioncentrocostoDataAccess.getCuentaContable(connexion,gastodepreciacioncentrocosto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		gastodepreciacioncentrocosto.setEmpresa(gastodepreciacioncentrocostoDataAccess.getEmpresa(connexion,gastodepreciacioncentrocosto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(gastodepreciacioncentrocosto.getEmpresa(),isDeep,deepLoadType,clases);
				
		gastodepreciacioncentrocosto.setSucursal(gastodepreciacioncentrocostoDataAccess.getSucursal(connexion,gastodepreciacioncentrocosto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(gastodepreciacioncentrocosto.getSucursal(),isDeep,deepLoadType,clases);
				
		gastodepreciacioncentrocosto.setCentroCosto(gastodepreciacioncentrocostoDataAccess.getCentroCosto(connexion,gastodepreciacioncentrocosto));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(gastodepreciacioncentrocosto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		gastodepreciacioncentrocosto.setDetalleActivoFijo(gastodepreciacioncentrocostoDataAccess.getDetalleActivoFijo(connexion,gastodepreciacioncentrocosto));
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(gastodepreciacioncentrocosto.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		gastodepreciacioncentrocosto.setCuentaContable(gastodepreciacioncentrocostoDataAccess.getCuentaContable(connexion,gastodepreciacioncentrocosto));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(gastodepreciacioncentrocosto.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				gastodepreciacioncentrocosto.setEmpresa(gastodepreciacioncentrocostoDataAccess.getEmpresa(connexion,gastodepreciacioncentrocosto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(gastodepreciacioncentrocosto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				gastodepreciacioncentrocosto.setSucursal(gastodepreciacioncentrocostoDataAccess.getSucursal(connexion,gastodepreciacioncentrocosto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(gastodepreciacioncentrocosto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				gastodepreciacioncentrocosto.setCentroCosto(gastodepreciacioncentrocostoDataAccess.getCentroCosto(connexion,gastodepreciacioncentrocosto));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(gastodepreciacioncentrocosto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				gastodepreciacioncentrocosto.setDetalleActivoFijo(gastodepreciacioncentrocostoDataAccess.getDetalleActivoFijo(connexion,gastodepreciacioncentrocosto));
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(gastodepreciacioncentrocosto.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				gastodepreciacioncentrocosto.setCuentaContable(gastodepreciacioncentrocostoDataAccess.getCuentaContable(connexion,gastodepreciacioncentrocosto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(gastodepreciacioncentrocosto.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			gastodepreciacioncentrocosto.setEmpresa(gastodepreciacioncentrocostoDataAccess.getEmpresa(connexion,gastodepreciacioncentrocosto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(gastodepreciacioncentrocosto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastodepreciacioncentrocosto.setSucursal(gastodepreciacioncentrocostoDataAccess.getSucursal(connexion,gastodepreciacioncentrocosto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(gastodepreciacioncentrocosto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastodepreciacioncentrocosto.setCentroCosto(gastodepreciacioncentrocostoDataAccess.getCentroCosto(connexion,gastodepreciacioncentrocosto));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(gastodepreciacioncentrocosto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastodepreciacioncentrocosto.setDetalleActivoFijo(gastodepreciacioncentrocostoDataAccess.getDetalleActivoFijo(connexion,gastodepreciacioncentrocosto));
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(gastodepreciacioncentrocosto.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastodepreciacioncentrocosto.setCuentaContable(gastodepreciacioncentrocostoDataAccess.getCuentaContable(connexion,gastodepreciacioncentrocosto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(gastodepreciacioncentrocosto.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			GastoDepreciacionCentroCostoLogicAdditional.updateGastoDepreciacionCentroCostoToSave(gastodepreciacioncentrocosto,this.arrDatoGeneral);
			
GastoDepreciacionCentroCostoDataAccess.save(gastodepreciacioncentrocosto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(gastodepreciacioncentrocosto.getEmpresa(),connexion);

		SucursalDataAccess.save(gastodepreciacioncentrocosto.getSucursal(),connexion);

		CentroCostoDataAccess.save(gastodepreciacioncentrocosto.getCentroCosto(),connexion);

		DetalleActivoFijoDataAccess.save(gastodepreciacioncentrocosto.getDetalleActivoFijo(),connexion);

		CuentaContableDataAccess.save(gastodepreciacioncentrocosto.getCuentaContable(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(gastodepreciacioncentrocosto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(gastodepreciacioncentrocosto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(gastodepreciacioncentrocosto.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(gastodepreciacioncentrocosto.getDetalleActivoFijo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(gastodepreciacioncentrocosto.getCuentaContable(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(gastodepreciacioncentrocosto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(gastodepreciacioncentrocosto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(gastodepreciacioncentrocosto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(gastodepreciacioncentrocosto.getSucursal(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(gastodepreciacioncentrocosto.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(gastodepreciacioncentrocosto.getCentroCosto(),isDeep,deepLoadType,clases);
				

		DetalleActivoFijoDataAccess.save(gastodepreciacioncentrocosto.getDetalleActivoFijo(),connexion);
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(gastodepreciacioncentrocosto.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(gastodepreciacioncentrocosto.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(gastodepreciacioncentrocosto.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(gastodepreciacioncentrocosto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(gastodepreciacioncentrocosto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(gastodepreciacioncentrocosto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(gastodepreciacioncentrocosto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(gastodepreciacioncentrocosto.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(gastodepreciacioncentrocosto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(gastodepreciacioncentrocosto.getDetalleActivoFijo(),connexion);
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepSave(gastodepreciacioncentrocosto.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(gastodepreciacioncentrocosto.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(gastodepreciacioncentrocosto.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(GastoDepreciacionCentroCosto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(gastodepreciacioncentrocosto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(gastodepreciacioncentrocosto);
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
			this.deepLoad(this.gastodepreciacioncentrocosto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocosto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(GastoDepreciacionCentroCosto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(gastodepreciacioncentrocostos!=null) {
				for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:gastodepreciacioncentrocostos) {
					this.deepLoad(gastodepreciacioncentrocosto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos);
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
			if(gastodepreciacioncentrocostos!=null) {
				for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:gastodepreciacioncentrocostos) {
					this.deepLoad(gastodepreciacioncentrocosto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(gastodepreciacioncentrocostos);
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
			this.getNewConnexionToDeep(GastoDepreciacionCentroCosto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(gastodepreciacioncentrocosto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(GastoDepreciacionCentroCosto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(gastodepreciacioncentrocostos!=null) {
				for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:gastodepreciacioncentrocostos) {
					this.deepSave(gastodepreciacioncentrocosto,isDeep,deepLoadType,clases);
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
			if(gastodepreciacioncentrocostos!=null) {
				for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:gastodepreciacioncentrocostos) {
					this.deepSave(gastodepreciacioncentrocosto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getGastoDepreciacionCentroCostosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,GastoDepreciacionCentroCostoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoDepreciacionCentroCostosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,GastoDepreciacionCentroCostoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoDepreciacionCentroCostosFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,GastoDepreciacionCentroCostoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoDepreciacionCentroCostosFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,GastoDepreciacionCentroCostoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoDepreciacionCentroCostosFK_IdDetalleActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,GastoDepreciacionCentroCostoConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoDepreciacionCentroCostosFK_IdDetalleActivoFijo(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,GastoDepreciacionCentroCostoConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoDepreciacionCentroCostosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoDepreciacionCentroCostosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoDepreciacionCentroCostosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacionCentroCosto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoDepreciacionCentroCostosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			GastoDepreciacionCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(this.gastodepreciacioncentrocostos);
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
			if(GastoDepreciacionCentroCostoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,GastoDepreciacionCentroCostoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(GastoDepreciacionCentroCostoConstantesFunciones.ISCONAUDITORIA) {
				if(gastodepreciacioncentrocosto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GastoDepreciacionCentroCostoDataAccess.TABLENAME, gastodepreciacioncentrocosto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GastoDepreciacionCentroCostoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GastoDepreciacionCentroCostoLogic.registrarAuditoriaDetallesGastoDepreciacionCentroCosto(connexion,gastodepreciacioncentrocosto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(gastodepreciacioncentrocosto.getIsDeleted()) {
					/*if(!gastodepreciacioncentrocosto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,GastoDepreciacionCentroCostoDataAccess.TABLENAME, gastodepreciacioncentrocosto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////GastoDepreciacionCentroCostoLogic.registrarAuditoriaDetallesGastoDepreciacionCentroCosto(connexion,gastodepreciacioncentrocosto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GastoDepreciacionCentroCostoDataAccess.TABLENAME, gastodepreciacioncentrocosto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(gastodepreciacioncentrocosto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GastoDepreciacionCentroCostoDataAccess.TABLENAME, gastodepreciacioncentrocosto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GastoDepreciacionCentroCostoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GastoDepreciacionCentroCostoLogic.registrarAuditoriaDetallesGastoDepreciacionCentroCosto(connexion,gastodepreciacioncentrocosto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesGastoDepreciacionCentroCosto(Connexion connexion,GastoDepreciacionCentroCosto gastodepreciacioncentrocosto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(gastodepreciacioncentrocosto.getIsNew()||!gastodepreciacioncentrocosto.getid_empresa().equals(gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_empresa()!=null)
				{
					strValorActual=gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_empresa().toString();
				}
				if(gastodepreciacioncentrocosto.getid_empresa()!=null)
				{
					strValorNuevo=gastodepreciacioncentrocosto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(gastodepreciacioncentrocosto.getIsNew()||!gastodepreciacioncentrocosto.getid_sucursal().equals(gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_sucursal()!=null)
				{
					strValorActual=gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_sucursal().toString();
				}
				if(gastodepreciacioncentrocosto.getid_sucursal()!=null)
				{
					strValorNuevo=gastodepreciacioncentrocosto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(gastodepreciacioncentrocosto.getIsNew()||!gastodepreciacioncentrocosto.getid_centro_costo().equals(gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_centro_costo()!=null)
				{
					strValorActual=gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_centro_costo().toString();
				}
				if(gastodepreciacioncentrocosto.getid_centro_costo()!=null)
				{
					strValorNuevo=gastodepreciacioncentrocosto.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoDepreciacionCentroCostoConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(gastodepreciacioncentrocosto.getIsNew()||!gastodepreciacioncentrocosto.getid_detalle_activo_fijo().equals(gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_detalle_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_detalle_activo_fijo()!=null)
				{
					strValorActual=gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_detalle_activo_fijo().toString();
				}
				if(gastodepreciacioncentrocosto.getid_detalle_activo_fijo()!=null)
				{
					strValorNuevo=gastodepreciacioncentrocosto.getid_detalle_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoDepreciacionCentroCostoConstantesFunciones.IDDETALLEACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(gastodepreciacioncentrocosto.getIsNew()||!gastodepreciacioncentrocosto.getid_cuenta_contable().equals(gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getid_cuenta_contable().toString();
				}
				if(gastodepreciacioncentrocosto.getid_cuenta_contable()!=null)
				{
					strValorNuevo=gastodepreciacioncentrocosto.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoDepreciacionCentroCostoConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(gastodepreciacioncentrocosto.getIsNew()||!gastodepreciacioncentrocosto.getporcentaje().equals(gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getporcentaje()!=null)
				{
					strValorActual=gastodepreciacioncentrocosto.getGastoDepreciacionCentroCostoOriginal().getporcentaje().toString();
				}
				if(gastodepreciacioncentrocosto.getporcentaje()!=null)
				{
					strValorNuevo=gastodepreciacioncentrocosto.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoDepreciacionCentroCostoConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveGastoDepreciacionCentroCostoRelacionesWithConnection(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto) throws Exception {

		if(!gastodepreciacioncentrocosto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGastoDepreciacionCentroCostoRelacionesBase(gastodepreciacioncentrocosto,true);
		}
	}

	public void saveGastoDepreciacionCentroCostoRelaciones(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto)throws Exception {

		if(!gastodepreciacioncentrocosto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGastoDepreciacionCentroCostoRelacionesBase(gastodepreciacioncentrocosto,false);
		}
	}

	public void saveGastoDepreciacionCentroCostoRelacionesBase(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("GastoDepreciacionCentroCosto-saveRelacionesWithConnection");}
	

			this.setGastoDepreciacionCentroCosto(gastodepreciacioncentrocosto);

			if(GastoDepreciacionCentroCostoLogicAdditional.validarSaveRelaciones(gastodepreciacioncentrocosto,this)) {

				GastoDepreciacionCentroCostoLogicAdditional.updateRelacionesToSave(gastodepreciacioncentrocosto,this);

				if((gastodepreciacioncentrocosto.getIsNew()||gastodepreciacioncentrocosto.getIsChanged())&&!gastodepreciacioncentrocosto.getIsDeleted()) {
					this.saveGastoDepreciacionCentroCosto();
					this.saveGastoDepreciacionCentroCostoRelacionesDetalles();

				} else if(gastodepreciacioncentrocosto.getIsDeleted()) {
					this.saveGastoDepreciacionCentroCostoRelacionesDetalles();
					this.saveGastoDepreciacionCentroCosto();
				}

				GastoDepreciacionCentroCostoLogicAdditional.updateRelacionesToSaveAfter(gastodepreciacioncentrocosto,this);

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
	
	
	private void saveGastoDepreciacionCentroCostoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfGastoDepreciacionCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GastoDepreciacionCentroCostoConstantesFunciones.getClassesForeignKeysOfGastoDepreciacionCentroCosto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGastoDepreciacionCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GastoDepreciacionCentroCostoConstantesFunciones.getClassesRelationshipsOfGastoDepreciacionCentroCosto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

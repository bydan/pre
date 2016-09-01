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
import com.bydan.erp.nomina.util.AsistenciaPorCentroCostoConstantesFunciones;
import com.bydan.erp.nomina.util.AsistenciaPorCentroCostoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.AsistenciaPorCentroCostoParameterGeneral;
import com.bydan.erp.nomina.business.entity.AsistenciaPorCentroCosto;
import com.bydan.erp.nomina.business.logic.AsistenciaPorCentroCostoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

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
public class AsistenciaPorCentroCostoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AsistenciaPorCentroCostoLogic.class);
	
	protected AsistenciaPorCentroCostoDataAccess asistenciaporcentrocostoDataAccess; 	
	protected AsistenciaPorCentroCosto asistenciaporcentrocosto;
	protected List<AsistenciaPorCentroCosto> asistenciaporcentrocostos;
	protected Object asistenciaporcentrocostoObject;	
	protected List<Object> asistenciaporcentrocostosObject;
	
	public static ClassValidator<AsistenciaPorCentroCosto> asistenciaporcentrocostoValidator = new ClassValidator<AsistenciaPorCentroCosto>(AsistenciaPorCentroCosto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AsistenciaPorCentroCostoLogicAdditional asistenciaporcentrocostoLogicAdditional=null;
	
	public AsistenciaPorCentroCostoLogicAdditional getAsistenciaPorCentroCostoLogicAdditional() {
		return this.asistenciaporcentrocostoLogicAdditional;
	}
	
	public void setAsistenciaPorCentroCostoLogicAdditional(AsistenciaPorCentroCostoLogicAdditional asistenciaporcentrocostoLogicAdditional) {
		try {
			this.asistenciaporcentrocostoLogicAdditional=asistenciaporcentrocostoLogicAdditional;
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
	
	
	
	
	public  AsistenciaPorCentroCostoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.asistenciaporcentrocostoDataAccess = new AsistenciaPorCentroCostoDataAccess();
			
			this.asistenciaporcentrocostos= new ArrayList<AsistenciaPorCentroCosto>();
			this.asistenciaporcentrocosto= new AsistenciaPorCentroCosto();
			
			this.asistenciaporcentrocostoObject=new Object();
			this.asistenciaporcentrocostosObject=new ArrayList<Object>();
				
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
			
			this.asistenciaporcentrocostoDataAccess.setConnexionType(this.connexionType);
			this.asistenciaporcentrocostoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AsistenciaPorCentroCostoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.asistenciaporcentrocostoDataAccess = new AsistenciaPorCentroCostoDataAccess();
			this.asistenciaporcentrocostos= new ArrayList<AsistenciaPorCentroCosto>();
			this.asistenciaporcentrocosto= new AsistenciaPorCentroCosto();
			this.asistenciaporcentrocostoObject=new Object();
			this.asistenciaporcentrocostosObject=new ArrayList<Object>();
			
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
			
			this.asistenciaporcentrocostoDataAccess.setConnexionType(this.connexionType);
			this.asistenciaporcentrocostoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AsistenciaPorCentroCosto getAsistenciaPorCentroCosto() throws Exception {	
		AsistenciaPorCentroCostoLogicAdditional.checkAsistenciaPorCentroCostoToGet(asistenciaporcentrocosto,this.datosCliente,this.arrDatoGeneral);
		AsistenciaPorCentroCostoLogicAdditional.updateAsistenciaPorCentroCostoToGet(asistenciaporcentrocosto,this.arrDatoGeneral);
		
		return asistenciaporcentrocosto;
	}
		
	public void setAsistenciaPorCentroCosto(AsistenciaPorCentroCosto newAsistenciaPorCentroCosto) {
		this.asistenciaporcentrocosto = newAsistenciaPorCentroCosto;
	}
	
	public AsistenciaPorCentroCostoDataAccess getAsistenciaPorCentroCostoDataAccess() {
		return asistenciaporcentrocostoDataAccess;
	}
	
	public void setAsistenciaPorCentroCostoDataAccess(AsistenciaPorCentroCostoDataAccess newasistenciaporcentrocostoDataAccess) {
		this.asistenciaporcentrocostoDataAccess = newasistenciaporcentrocostoDataAccess;
	}
	
	public List<AsistenciaPorCentroCosto> getAsistenciaPorCentroCostos() throws Exception {		
		this.quitarAsistenciaPorCentroCostosNulos();
		
		AsistenciaPorCentroCostoLogicAdditional.checkAsistenciaPorCentroCostoToGets(asistenciaporcentrocostos,this.datosCliente,this.arrDatoGeneral);
		
		for (AsistenciaPorCentroCosto asistenciaporcentrocostoLocal: asistenciaporcentrocostos ) {
			AsistenciaPorCentroCostoLogicAdditional.updateAsistenciaPorCentroCostoToGet(asistenciaporcentrocostoLocal,this.arrDatoGeneral);
		}
		
		return asistenciaporcentrocostos;
	}
	
	public void setAsistenciaPorCentroCostos(List<AsistenciaPorCentroCosto> newAsistenciaPorCentroCostos) {
		this.asistenciaporcentrocostos = newAsistenciaPorCentroCostos;
	}
	
	public Object getAsistenciaPorCentroCostoObject() {	
		this.asistenciaporcentrocostoObject=this.asistenciaporcentrocostoDataAccess.getEntityObject();
		return this.asistenciaporcentrocostoObject;
	}
		
	public void setAsistenciaPorCentroCostoObject(Object newAsistenciaPorCentroCostoObject) {
		this.asistenciaporcentrocostoObject = newAsistenciaPorCentroCostoObject;
	}
	
	public List<Object> getAsistenciaPorCentroCostosObject() {		
		this.asistenciaporcentrocostosObject=this.asistenciaporcentrocostoDataAccess.getEntitiesObject();
		return this.asistenciaporcentrocostosObject;
	}
		
	public void setAsistenciaPorCentroCostosObject(List<Object> newAsistenciaPorCentroCostosObject) {
		this.asistenciaporcentrocostosObject = newAsistenciaPorCentroCostosObject;
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
		
		if(this.asistenciaporcentrocostoDataAccess!=null) {
			this.asistenciaporcentrocostoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			asistenciaporcentrocostoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			asistenciaporcentrocostoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			asistenciaporcentrocosto=asistenciaporcentrocostoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asistenciaporcentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocosto);
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
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		  		  
        try {
			
			asistenciaporcentrocosto=asistenciaporcentrocostoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asistenciaporcentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocosto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			asistenciaporcentrocosto=asistenciaporcentrocostoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asistenciaporcentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocosto);
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
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		  		  
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
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		  		  
        try {
			
			asistenciaporcentrocosto=asistenciaporcentrocostoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asistenciaporcentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocosto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		  		  
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
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =asistenciaporcentrocostoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=asistenciaporcentrocostoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =asistenciaporcentrocostoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=asistenciaporcentrocostoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =asistenciaporcentrocostoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=asistenciaporcentrocostoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		asistenciaporcentrocostos = new  ArrayList<AsistenciaPorCentroCosto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaPorCentroCosto(asistenciaporcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
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
		asistenciaporcentrocostos = new  ArrayList<AsistenciaPorCentroCosto>();
		  		  
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
		asistenciaporcentrocostos = new  ArrayList<AsistenciaPorCentroCosto>();
		  		  
        try {			
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAsistenciaPorCentroCosto(asistenciaporcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		asistenciaporcentrocostos = new  ArrayList<AsistenciaPorCentroCosto>();
		  		  
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
		asistenciaporcentrocostos = new  ArrayList<AsistenciaPorCentroCosto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaPorCentroCosto(asistenciaporcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
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
		asistenciaporcentrocostos = new  ArrayList<AsistenciaPorCentroCosto>();
		  		  
        try {
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaPorCentroCosto(asistenciaporcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
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
		asistenciaporcentrocostos = new  ArrayList<AsistenciaPorCentroCosto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsistenciaPorCentroCosto(asistenciaporcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
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
		asistenciaporcentrocostos = new  ArrayList<AsistenciaPorCentroCosto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsistenciaPorCentroCosto(asistenciaporcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciaporcentrocosto=asistenciaporcentrocostoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsistenciaPorCentroCosto(asistenciaporcentrocosto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocosto);
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
		asistenciaporcentrocosto = new  AsistenciaPorCentroCosto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciaporcentrocosto=asistenciaporcentrocostoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsistenciaPorCentroCosto(asistenciaporcentrocosto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocosto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		asistenciaporcentrocostos = new  ArrayList<AsistenciaPorCentroCosto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaPorCentroCosto(asistenciaporcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
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
		asistenciaporcentrocostos = new  ArrayList<AsistenciaPorCentroCosto>();
		  		  
        try {
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaPorCentroCosto(asistenciaporcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAsistenciaPorCentroCostosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		asistenciaporcentrocostos = new  ArrayList<AsistenciaPorCentroCosto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getTodosAsistenciaPorCentroCostosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAsistenciaPorCentroCosto(asistenciaporcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
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
	
	public  void  getTodosAsistenciaPorCentroCostos(String sFinalQuery,Pagination pagination)throws Exception {
		asistenciaporcentrocostos = new  ArrayList<AsistenciaPorCentroCosto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAsistenciaPorCentroCosto(asistenciaporcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAsistenciaPorCentroCosto(AsistenciaPorCentroCosto asistenciaporcentrocosto) throws Exception {
		Boolean estaValidado=false;
		
		if(asistenciaporcentrocosto.getIsNew() || asistenciaporcentrocosto.getIsChanged()) { 
			this.invalidValues = asistenciaporcentrocostoValidator.getInvalidValues(asistenciaporcentrocosto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(asistenciaporcentrocosto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAsistenciaPorCentroCosto(List<AsistenciaPorCentroCosto> AsistenciaPorCentroCostos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AsistenciaPorCentroCosto asistenciaporcentrocostoLocal:asistenciaporcentrocostos) {				
			estaValidadoObjeto=this.validarGuardarAsistenciaPorCentroCosto(asistenciaporcentrocostoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAsistenciaPorCentroCosto(List<AsistenciaPorCentroCosto> AsistenciaPorCentroCostos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAsistenciaPorCentroCosto(asistenciaporcentrocostos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAsistenciaPorCentroCosto(AsistenciaPorCentroCosto AsistenciaPorCentroCosto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAsistenciaPorCentroCosto(asistenciaporcentrocosto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AsistenciaPorCentroCosto asistenciaporcentrocosto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+asistenciaporcentrocosto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AsistenciaPorCentroCostoConstantesFunciones.getAsistenciaPorCentroCostoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"asistenciaporcentrocosto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AsistenciaPorCentroCostoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AsistenciaPorCentroCostoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAsistenciaPorCentroCostoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-saveAsistenciaPorCentroCostoWithConnection");connexion.begin();			
			
			AsistenciaPorCentroCostoLogicAdditional.checkAsistenciaPorCentroCostoToSave(this.asistenciaporcentrocosto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AsistenciaPorCentroCostoLogicAdditional.updateAsistenciaPorCentroCostoToSave(this.asistenciaporcentrocosto,this.arrDatoGeneral);
			
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.asistenciaporcentrocosto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAsistenciaPorCentroCosto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAsistenciaPorCentroCosto(this.asistenciaporcentrocosto)) {
				AsistenciaPorCentroCostoDataAccess.save(this.asistenciaporcentrocosto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.asistenciaporcentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AsistenciaPorCentroCostoLogicAdditional.checkAsistenciaPorCentroCostoToSaveAfter(this.asistenciaporcentrocosto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAsistenciaPorCentroCosto();
			
			connexion.commit();			
			
			if(this.asistenciaporcentrocosto.getIsDeleted()) {
				this.asistenciaporcentrocosto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAsistenciaPorCentroCosto()throws Exception {	
		try {	
			
			AsistenciaPorCentroCostoLogicAdditional.checkAsistenciaPorCentroCostoToSave(this.asistenciaporcentrocosto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AsistenciaPorCentroCostoLogicAdditional.updateAsistenciaPorCentroCostoToSave(this.asistenciaporcentrocosto,this.arrDatoGeneral);
			
			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.asistenciaporcentrocosto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAsistenciaPorCentroCosto(this.asistenciaporcentrocosto)) {			
				AsistenciaPorCentroCostoDataAccess.save(this.asistenciaporcentrocosto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.asistenciaporcentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AsistenciaPorCentroCostoLogicAdditional.checkAsistenciaPorCentroCostoToSaveAfter(this.asistenciaporcentrocosto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.asistenciaporcentrocosto.getIsDeleted()) {
				this.asistenciaporcentrocosto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAsistenciaPorCentroCostosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-saveAsistenciaPorCentroCostosWithConnection");connexion.begin();			
			
			AsistenciaPorCentroCostoLogicAdditional.checkAsistenciaPorCentroCostoToSaves(asistenciaporcentrocostos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAsistenciaPorCentroCostos();
			
			Boolean validadoTodosAsistenciaPorCentroCosto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AsistenciaPorCentroCosto asistenciaporcentrocostoLocal:asistenciaporcentrocostos) {		
				if(asistenciaporcentrocostoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AsistenciaPorCentroCostoLogicAdditional.updateAsistenciaPorCentroCostoToSave(asistenciaporcentrocostoLocal,this.arrDatoGeneral);
	        	
				AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),asistenciaporcentrocostoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAsistenciaPorCentroCosto(asistenciaporcentrocostoLocal)) {
					AsistenciaPorCentroCostoDataAccess.save(asistenciaporcentrocostoLocal, connexion);				
				} else {
					validadoTodosAsistenciaPorCentroCosto=false;
				}
			}
			
			if(!validadoTodosAsistenciaPorCentroCosto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AsistenciaPorCentroCostoLogicAdditional.checkAsistenciaPorCentroCostoToSavesAfter(asistenciaporcentrocostos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAsistenciaPorCentroCostos();
			
			connexion.commit();		
			
			this.quitarAsistenciaPorCentroCostosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAsistenciaPorCentroCostos()throws Exception {				
		 try {	
			AsistenciaPorCentroCostoLogicAdditional.checkAsistenciaPorCentroCostoToSaves(asistenciaporcentrocostos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAsistenciaPorCentroCosto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AsistenciaPorCentroCosto asistenciaporcentrocostoLocal:asistenciaporcentrocostos) {				
				if(asistenciaporcentrocostoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AsistenciaPorCentroCostoLogicAdditional.updateAsistenciaPorCentroCostoToSave(asistenciaporcentrocostoLocal,this.arrDatoGeneral);
	        	
				AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),asistenciaporcentrocostoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAsistenciaPorCentroCosto(asistenciaporcentrocostoLocal)) {				
					AsistenciaPorCentroCostoDataAccess.save(asistenciaporcentrocostoLocal, connexion);				
				} else {
					validadoTodosAsistenciaPorCentroCosto=false;
				}
			}
			
			if(!validadoTodosAsistenciaPorCentroCosto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AsistenciaPorCentroCostoLogicAdditional.checkAsistenciaPorCentroCostoToSavesAfter(asistenciaporcentrocostos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAsistenciaPorCentroCostosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AsistenciaPorCentroCostoParameterReturnGeneral procesarAccionAsistenciaPorCentroCostos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AsistenciaPorCentroCosto> asistenciaporcentrocostos,AsistenciaPorCentroCostoParameterReturnGeneral asistenciaporcentrocostoParameterGeneral)throws Exception {
		 try {	
			AsistenciaPorCentroCostoParameterReturnGeneral asistenciaporcentrocostoReturnGeneral=new AsistenciaPorCentroCostoParameterReturnGeneral();
	
			AsistenciaPorCentroCostoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,asistenciaporcentrocostos,asistenciaporcentrocostoParameterGeneral,asistenciaporcentrocostoReturnGeneral);
			
			return asistenciaporcentrocostoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AsistenciaPorCentroCostoParameterReturnGeneral procesarAccionAsistenciaPorCentroCostosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AsistenciaPorCentroCosto> asistenciaporcentrocostos,AsistenciaPorCentroCostoParameterReturnGeneral asistenciaporcentrocostoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-procesarAccionAsistenciaPorCentroCostosWithConnection");connexion.begin();			
			
			AsistenciaPorCentroCostoParameterReturnGeneral asistenciaporcentrocostoReturnGeneral=new AsistenciaPorCentroCostoParameterReturnGeneral();
	
			AsistenciaPorCentroCostoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,asistenciaporcentrocostos,asistenciaporcentrocostoParameterGeneral,asistenciaporcentrocostoReturnGeneral);
			
			this.connexion.commit();
			
			return asistenciaporcentrocostoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AsistenciaPorCentroCostoParameterReturnGeneral procesarEventosAsistenciaPorCentroCostos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AsistenciaPorCentroCosto> asistenciaporcentrocostos,AsistenciaPorCentroCosto asistenciaporcentrocosto,AsistenciaPorCentroCostoParameterReturnGeneral asistenciaporcentrocostoParameterGeneral,Boolean isEsNuevoAsistenciaPorCentroCosto,ArrayList<Classe> clases)throws Exception {
		 try {	
			AsistenciaPorCentroCostoParameterReturnGeneral asistenciaporcentrocostoReturnGeneral=new AsistenciaPorCentroCostoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				asistenciaporcentrocostoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AsistenciaPorCentroCostoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,asistenciaporcentrocostos,asistenciaporcentrocosto,asistenciaporcentrocostoParameterGeneral,asistenciaporcentrocostoReturnGeneral,isEsNuevoAsistenciaPorCentroCosto,clases);
			
			return asistenciaporcentrocostoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AsistenciaPorCentroCostoParameterReturnGeneral procesarEventosAsistenciaPorCentroCostosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AsistenciaPorCentroCosto> asistenciaporcentrocostos,AsistenciaPorCentroCosto asistenciaporcentrocosto,AsistenciaPorCentroCostoParameterReturnGeneral asistenciaporcentrocostoParameterGeneral,Boolean isEsNuevoAsistenciaPorCentroCosto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-procesarEventosAsistenciaPorCentroCostosWithConnection");connexion.begin();			
			
			AsistenciaPorCentroCostoParameterReturnGeneral asistenciaporcentrocostoReturnGeneral=new AsistenciaPorCentroCostoParameterReturnGeneral();
	
			asistenciaporcentrocostoReturnGeneral.setAsistenciaPorCentroCosto(asistenciaporcentrocosto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				asistenciaporcentrocostoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AsistenciaPorCentroCostoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,asistenciaporcentrocostos,asistenciaporcentrocosto,asistenciaporcentrocostoParameterGeneral,asistenciaporcentrocostoReturnGeneral,isEsNuevoAsistenciaPorCentroCosto,clases);
			
			this.connexion.commit();
			
			return asistenciaporcentrocostoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AsistenciaPorCentroCostoParameterReturnGeneral procesarImportacionAsistenciaPorCentroCostosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AsistenciaPorCentroCostoParameterReturnGeneral asistenciaporcentrocostoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-procesarImportacionAsistenciaPorCentroCostosWithConnection");connexion.begin();			
			
			AsistenciaPorCentroCostoParameterReturnGeneral asistenciaporcentrocostoReturnGeneral=new AsistenciaPorCentroCostoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.asistenciaporcentrocostos=new ArrayList<AsistenciaPorCentroCosto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.asistenciaporcentrocosto=new AsistenciaPorCentroCosto();
				
				
				if(conColumnasBase) {this.asistenciaporcentrocosto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.asistenciaporcentrocosto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.asistenciaporcentrocosto.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.asistenciaporcentrocosto.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciaporcentrocosto.setvalor_hora(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciaporcentrocosto.setpermiso(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.asistenciaporcentrocostos.add(this.asistenciaporcentrocosto);
			}
			
			this.saveAsistenciaPorCentroCostos();
			
			this.connexion.commit();
			
			asistenciaporcentrocostoReturnGeneral.setConRetornoEstaProcesado(true);
			asistenciaporcentrocostoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return asistenciaporcentrocostoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAsistenciaPorCentroCostosEliminados() throws Exception {				
		
		List<AsistenciaPorCentroCosto> asistenciaporcentrocostosAux= new ArrayList<AsistenciaPorCentroCosto>();
		
		for(AsistenciaPorCentroCosto asistenciaporcentrocosto:asistenciaporcentrocostos) {
			if(!asistenciaporcentrocosto.getIsDeleted()) {
				asistenciaporcentrocostosAux.add(asistenciaporcentrocosto);
			}
		}
		
		asistenciaporcentrocostos=asistenciaporcentrocostosAux;
	}
	
	public void quitarAsistenciaPorCentroCostosNulos() throws Exception {				
		
		List<AsistenciaPorCentroCosto> asistenciaporcentrocostosAux= new ArrayList<AsistenciaPorCentroCosto>();
		
		for(AsistenciaPorCentroCosto asistenciaporcentrocosto : this.asistenciaporcentrocostos) {
			if(asistenciaporcentrocosto==null) {
				asistenciaporcentrocostosAux.add(asistenciaporcentrocosto);
			}
		}
		
		//this.asistenciaporcentrocostos=asistenciaporcentrocostosAux;
		
		this.asistenciaporcentrocostos.removeAll(asistenciaporcentrocostosAux);
	}
	
	public void getSetVersionRowAsistenciaPorCentroCostoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(asistenciaporcentrocosto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((asistenciaporcentrocosto.getIsDeleted() || (asistenciaporcentrocosto.getIsChanged()&&!asistenciaporcentrocosto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=asistenciaporcentrocostoDataAccess.getSetVersionRowAsistenciaPorCentroCosto(connexion,asistenciaporcentrocosto.getId());
				
				if(!asistenciaporcentrocosto.getVersionRow().equals(timestamp)) {	
					asistenciaporcentrocosto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				asistenciaporcentrocosto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAsistenciaPorCentroCosto()throws Exception {	
		
		if(asistenciaporcentrocosto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((asistenciaporcentrocosto.getIsDeleted() || (asistenciaporcentrocosto.getIsChanged()&&!asistenciaporcentrocosto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=asistenciaporcentrocostoDataAccess.getSetVersionRowAsistenciaPorCentroCosto(connexion,asistenciaporcentrocosto.getId());
			
			try {							
				if(!asistenciaporcentrocosto.getVersionRow().equals(timestamp)) {	
					asistenciaporcentrocosto.setVersionRow(timestamp);
				}
				
				asistenciaporcentrocosto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAsistenciaPorCentroCostosWithConnection()throws Exception {	
		if(asistenciaporcentrocostos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AsistenciaPorCentroCosto asistenciaporcentrocostoAux:asistenciaporcentrocostos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(asistenciaporcentrocostoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(asistenciaporcentrocostoAux.getIsDeleted() || (asistenciaporcentrocostoAux.getIsChanged()&&!asistenciaporcentrocostoAux.getIsNew())) {
						
						timestamp=asistenciaporcentrocostoDataAccess.getSetVersionRowAsistenciaPorCentroCosto(connexion,asistenciaporcentrocostoAux.getId());
						
						if(!asistenciaporcentrocosto.getVersionRow().equals(timestamp)) {	
							asistenciaporcentrocostoAux.setVersionRow(timestamp);
						}
								
						asistenciaporcentrocostoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAsistenciaPorCentroCostos()throws Exception {	
		if(asistenciaporcentrocostos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AsistenciaPorCentroCosto asistenciaporcentrocostoAux:asistenciaporcentrocostos) {
					if(asistenciaporcentrocostoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(asistenciaporcentrocostoAux.getIsDeleted() || (asistenciaporcentrocostoAux.getIsChanged()&&!asistenciaporcentrocostoAux.getIsNew())) {
						
						timestamp=asistenciaporcentrocostoDataAccess.getSetVersionRowAsistenciaPorCentroCosto(connexion,asistenciaporcentrocostoAux.getId());
						
						if(!asistenciaporcentrocostoAux.getVersionRow().equals(timestamp)) {	
							asistenciaporcentrocostoAux.setVersionRow(timestamp);
						}
						
													
						asistenciaporcentrocostoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AsistenciaPorCentroCostoParameterReturnGeneral cargarCombosLoteForeignKeyAsistenciaPorCentroCostoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCentroCosto,String finalQueryGlobalEmpleado) throws Exception {
		AsistenciaPorCentroCostoParameterReturnGeneral  asistenciaporcentrocostoReturnGeneral =new AsistenciaPorCentroCostoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-cargarCombosLoteForeignKeyAsistenciaPorCentroCostoWithConnection");connexion.begin();
			
			asistenciaporcentrocostoReturnGeneral =new AsistenciaPorCentroCostoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			asistenciaporcentrocostoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			asistenciaporcentrocostoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			asistenciaporcentrocostoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return asistenciaporcentrocostoReturnGeneral;
	}
	
	public AsistenciaPorCentroCostoParameterReturnGeneral cargarCombosLoteForeignKeyAsistenciaPorCentroCosto(String finalQueryGlobalEmpresa,String finalQueryGlobalCentroCosto,String finalQueryGlobalEmpleado) throws Exception {
		AsistenciaPorCentroCostoParameterReturnGeneral  asistenciaporcentrocostoReturnGeneral =new AsistenciaPorCentroCostoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			asistenciaporcentrocostoReturnGeneral =new AsistenciaPorCentroCostoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			asistenciaporcentrocostoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			asistenciaporcentrocostoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			asistenciaporcentrocostoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return asistenciaporcentrocostoReturnGeneral;
	}
	
	
	public void deepLoad(AsistenciaPorCentroCosto asistenciaporcentrocosto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AsistenciaPorCentroCostoLogicAdditional.updateAsistenciaPorCentroCostoToGet(asistenciaporcentrocosto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		asistenciaporcentrocosto.setEmpresa(asistenciaporcentrocostoDataAccess.getEmpresa(connexion,asistenciaporcentrocosto));
		asistenciaporcentrocosto.setCentroCosto(asistenciaporcentrocostoDataAccess.getCentroCosto(connexion,asistenciaporcentrocosto));
		asistenciaporcentrocosto.setEmpleado(asistenciaporcentrocostoDataAccess.getEmpleado(connexion,asistenciaporcentrocosto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				asistenciaporcentrocosto.setEmpresa(asistenciaporcentrocostoDataAccess.getEmpresa(connexion,asistenciaporcentrocosto));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				asistenciaporcentrocosto.setCentroCosto(asistenciaporcentrocostoDataAccess.getCentroCosto(connexion,asistenciaporcentrocosto));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				asistenciaporcentrocosto.setEmpleado(asistenciaporcentrocostoDataAccess.getEmpleado(connexion,asistenciaporcentrocosto));
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
			asistenciaporcentrocosto.setEmpresa(asistenciaporcentrocostoDataAccess.getEmpresa(connexion,asistenciaporcentrocosto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciaporcentrocosto.setCentroCosto(asistenciaporcentrocostoDataAccess.getCentroCosto(connexion,asistenciaporcentrocosto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciaporcentrocosto.setEmpleado(asistenciaporcentrocostoDataAccess.getEmpleado(connexion,asistenciaporcentrocosto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		asistenciaporcentrocosto.setEmpresa(asistenciaporcentrocostoDataAccess.getEmpresa(connexion,asistenciaporcentrocosto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(asistenciaporcentrocosto.getEmpresa(),isDeep,deepLoadType,clases);
				
		asistenciaporcentrocosto.setCentroCosto(asistenciaporcentrocostoDataAccess.getCentroCosto(connexion,asistenciaporcentrocosto));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(asistenciaporcentrocosto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		asistenciaporcentrocosto.setEmpleado(asistenciaporcentrocostoDataAccess.getEmpleado(connexion,asistenciaporcentrocosto));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(asistenciaporcentrocosto.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				asistenciaporcentrocosto.setEmpresa(asistenciaporcentrocostoDataAccess.getEmpresa(connexion,asistenciaporcentrocosto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(asistenciaporcentrocosto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				asistenciaporcentrocosto.setCentroCosto(asistenciaporcentrocostoDataAccess.getCentroCosto(connexion,asistenciaporcentrocosto));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(asistenciaporcentrocosto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				asistenciaporcentrocosto.setEmpleado(asistenciaporcentrocostoDataAccess.getEmpleado(connexion,asistenciaporcentrocosto));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(asistenciaporcentrocosto.getEmpleado(),isDeep,deepLoadType,clases);				
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
			asistenciaporcentrocosto.setEmpresa(asistenciaporcentrocostoDataAccess.getEmpresa(connexion,asistenciaporcentrocosto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(asistenciaporcentrocosto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciaporcentrocosto.setCentroCosto(asistenciaporcentrocostoDataAccess.getCentroCosto(connexion,asistenciaporcentrocosto));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(asistenciaporcentrocosto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciaporcentrocosto.setEmpleado(asistenciaporcentrocostoDataAccess.getEmpleado(connexion,asistenciaporcentrocosto));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(asistenciaporcentrocosto.getEmpleado(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AsistenciaPorCentroCosto asistenciaporcentrocosto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AsistenciaPorCentroCostoLogicAdditional.updateAsistenciaPorCentroCostoToSave(asistenciaporcentrocosto,this.arrDatoGeneral);
			
AsistenciaPorCentroCostoDataAccess.save(asistenciaporcentrocosto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(asistenciaporcentrocosto.getEmpresa(),connexion);

		CentroCostoDataAccess.save(asistenciaporcentrocosto.getCentroCosto(),connexion);

		EmpleadoDataAccess.save(asistenciaporcentrocosto.getEmpleado(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(asistenciaporcentrocosto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(asistenciaporcentrocosto.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(asistenciaporcentrocosto.getEmpleado(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(asistenciaporcentrocosto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(asistenciaporcentrocosto.getEmpresa(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(asistenciaporcentrocosto.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(asistenciaporcentrocosto.getCentroCosto(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(asistenciaporcentrocosto.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(asistenciaporcentrocosto.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(asistenciaporcentrocosto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(asistenciaporcentrocosto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(asistenciaporcentrocosto.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(asistenciaporcentrocosto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(asistenciaporcentrocosto.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(asistenciaporcentrocosto.getEmpleado(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(AsistenciaPorCentroCosto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(asistenciaporcentrocosto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(asistenciaporcentrocosto);
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
			this.deepLoad(this.asistenciaporcentrocosto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocosto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AsistenciaPorCentroCosto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(asistenciaporcentrocostos!=null) {
				for(AsistenciaPorCentroCosto asistenciaporcentrocosto:asistenciaporcentrocostos) {
					this.deepLoad(asistenciaporcentrocosto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(asistenciaporcentrocostos);
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
			if(asistenciaporcentrocostos!=null) {
				for(AsistenciaPorCentroCosto asistenciaporcentrocosto:asistenciaporcentrocostos) {
					this.deepLoad(asistenciaporcentrocosto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(asistenciaporcentrocostos);
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
			this.getNewConnexionToDeep(AsistenciaPorCentroCosto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(asistenciaporcentrocosto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AsistenciaPorCentroCosto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(asistenciaporcentrocostos!=null) {
				for(AsistenciaPorCentroCosto asistenciaporcentrocosto:asistenciaporcentrocostos) {
					this.deepSave(asistenciaporcentrocosto,isDeep,deepLoadType,clases);
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
			if(asistenciaporcentrocostos!=null) {
				for(AsistenciaPorCentroCosto asistenciaporcentrocosto:asistenciaporcentrocostos) {
					this.deepSave(asistenciaporcentrocosto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAsistenciaPorCentroCostosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,AsistenciaPorCentroCostoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaPorCentroCostosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,AsistenciaPorCentroCostoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsistenciaPorCentroCostosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,AsistenciaPorCentroCostoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaPorCentroCostosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,AsistenciaPorCentroCostoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsistenciaPorCentroCostosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaPorCentroCosto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaPorCentroCostosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AsistenciaPorCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaPorCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(this.asistenciaporcentrocostos);
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
			if(AsistenciaPorCentroCostoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AsistenciaPorCentroCostoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AsistenciaPorCentroCosto asistenciaporcentrocosto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AsistenciaPorCentroCostoConstantesFunciones.ISCONAUDITORIA) {
				if(asistenciaporcentrocosto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsistenciaPorCentroCostoDataAccess.TABLENAME, asistenciaporcentrocosto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AsistenciaPorCentroCostoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AsistenciaPorCentroCostoLogic.registrarAuditoriaDetallesAsistenciaPorCentroCosto(connexion,asistenciaporcentrocosto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(asistenciaporcentrocosto.getIsDeleted()) {
					/*if(!asistenciaporcentrocosto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AsistenciaPorCentroCostoDataAccess.TABLENAME, asistenciaporcentrocosto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AsistenciaPorCentroCostoLogic.registrarAuditoriaDetallesAsistenciaPorCentroCosto(connexion,asistenciaporcentrocosto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsistenciaPorCentroCostoDataAccess.TABLENAME, asistenciaporcentrocosto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(asistenciaporcentrocosto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsistenciaPorCentroCostoDataAccess.TABLENAME, asistenciaporcentrocosto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AsistenciaPorCentroCostoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AsistenciaPorCentroCostoLogic.registrarAuditoriaDetallesAsistenciaPorCentroCosto(connexion,asistenciaporcentrocosto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAsistenciaPorCentroCosto(Connexion connexion,AsistenciaPorCentroCosto asistenciaporcentrocosto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(asistenciaporcentrocosto.getIsNew()||!asistenciaporcentrocosto.getid_empresa().equals(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getid_empresa()!=null)
				{
					strValorActual=asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getid_empresa().toString();
				}
				if(asistenciaporcentrocosto.getid_empresa()!=null)
				{
					strValorNuevo=asistenciaporcentrocosto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(asistenciaporcentrocosto.getIsNew()||!asistenciaporcentrocosto.getid_centro_costo().equals(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getid_centro_costo()!=null)
				{
					strValorActual=asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getid_centro_costo().toString();
				}
				if(asistenciaporcentrocosto.getid_centro_costo()!=null)
				{
					strValorNuevo=asistenciaporcentrocosto.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaPorCentroCostoConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(asistenciaporcentrocosto.getIsNew()||!asistenciaporcentrocosto.getid_empleado().equals(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getid_empleado()!=null)
				{
					strValorActual=asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getid_empleado().toString();
				}
				if(asistenciaporcentrocosto.getid_empleado()!=null)
				{
					strValorNuevo=asistenciaporcentrocosto.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaPorCentroCostoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(asistenciaporcentrocosto.getIsNew()||!asistenciaporcentrocosto.getfecha().equals(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getfecha()!=null)
				{
					strValorActual=asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getfecha().toString();
				}
				if(asistenciaporcentrocosto.getfecha()!=null)
				{
					strValorNuevo=asistenciaporcentrocosto.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaPorCentroCostoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(asistenciaporcentrocosto.getIsNew()||!asistenciaporcentrocosto.getporcentaje().equals(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getporcentaje()!=null)
				{
					strValorActual=asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getporcentaje().toString();
				}
				if(asistenciaporcentrocosto.getporcentaje()!=null)
				{
					strValorNuevo=asistenciaporcentrocosto.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaPorCentroCostoConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(asistenciaporcentrocosto.getIsNew()||!asistenciaporcentrocosto.getvalor_hora().equals(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getvalor_hora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getvalor_hora()!=null)
				{
					strValorActual=asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getvalor_hora().toString();
				}
				if(asistenciaporcentrocosto.getvalor_hora()!=null)
				{
					strValorNuevo=asistenciaporcentrocosto.getvalor_hora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaPorCentroCostoConstantesFunciones.VALORHORA,strValorActual,strValorNuevo);
			}	
			
			if(asistenciaporcentrocosto.getIsNew()||!asistenciaporcentrocosto.getpermiso().equals(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getpermiso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getpermiso()!=null)
				{
					strValorActual=asistenciaporcentrocosto.getAsistenciaPorCentroCostoOriginal().getpermiso().toString();
				}
				if(asistenciaporcentrocosto.getpermiso()!=null)
				{
					strValorNuevo=asistenciaporcentrocosto.getpermiso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaPorCentroCostoConstantesFunciones.PERMISO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAsistenciaPorCentroCostoRelacionesWithConnection(AsistenciaPorCentroCosto asistenciaporcentrocosto) throws Exception {

		if(!asistenciaporcentrocosto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAsistenciaPorCentroCostoRelacionesBase(asistenciaporcentrocosto,true);
		}
	}

	public void saveAsistenciaPorCentroCostoRelaciones(AsistenciaPorCentroCosto asistenciaporcentrocosto)throws Exception {

		if(!asistenciaporcentrocosto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAsistenciaPorCentroCostoRelacionesBase(asistenciaporcentrocosto,false);
		}
	}

	public void saveAsistenciaPorCentroCostoRelacionesBase(AsistenciaPorCentroCosto asistenciaporcentrocosto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AsistenciaPorCentroCosto-saveRelacionesWithConnection");}
	

			this.setAsistenciaPorCentroCosto(asistenciaporcentrocosto);

			if(AsistenciaPorCentroCostoLogicAdditional.validarSaveRelaciones(asistenciaporcentrocosto,this)) {

				AsistenciaPorCentroCostoLogicAdditional.updateRelacionesToSave(asistenciaporcentrocosto,this);

				if((asistenciaporcentrocosto.getIsNew()||asistenciaporcentrocosto.getIsChanged())&&!asistenciaporcentrocosto.getIsDeleted()) {
					this.saveAsistenciaPorCentroCosto();
					this.saveAsistenciaPorCentroCostoRelacionesDetalles();

				} else if(asistenciaporcentrocosto.getIsDeleted()) {
					this.saveAsistenciaPorCentroCostoRelacionesDetalles();
					this.saveAsistenciaPorCentroCosto();
				}

				AsistenciaPorCentroCostoLogicAdditional.updateRelacionesToSaveAfter(asistenciaporcentrocosto,this);

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
	
	
	private void saveAsistenciaPorCentroCostoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAsistenciaPorCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AsistenciaPorCentroCostoConstantesFunciones.getClassesForeignKeysOfAsistenciaPorCentroCosto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsistenciaPorCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AsistenciaPorCentroCostoConstantesFunciones.getClassesRelationshipsOfAsistenciaPorCentroCosto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

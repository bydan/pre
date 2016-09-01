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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.NivelCentroCostoConstantesFunciones;
import com.bydan.erp.contabilidad.util.NivelCentroCostoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.NivelCentroCostoParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.NivelCentroCosto;
import com.bydan.erp.contabilidad.business.logic.NivelCentroCostoLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class NivelCentroCostoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NivelCentroCostoLogic.class);
	
	protected NivelCentroCostoDataAccess nivelcentrocostoDataAccess; 	
	protected NivelCentroCosto nivelcentrocosto;
	protected List<NivelCentroCosto> nivelcentrocostos;
	protected Object nivelcentrocostoObject;	
	protected List<Object> nivelcentrocostosObject;
	
	public static ClassValidator<NivelCentroCosto> nivelcentrocostoValidator = new ClassValidator<NivelCentroCosto>(NivelCentroCosto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NivelCentroCostoLogicAdditional nivelcentrocostoLogicAdditional=null;
	
	public NivelCentroCostoLogicAdditional getNivelCentroCostoLogicAdditional() {
		return this.nivelcentrocostoLogicAdditional;
	}
	
	public void setNivelCentroCostoLogicAdditional(NivelCentroCostoLogicAdditional nivelcentrocostoLogicAdditional) {
		try {
			this.nivelcentrocostoLogicAdditional=nivelcentrocostoLogicAdditional;
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
	
	
	
	
	public  NivelCentroCostoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.nivelcentrocostoDataAccess = new NivelCentroCostoDataAccess();
			
			this.nivelcentrocostos= new ArrayList<NivelCentroCosto>();
			this.nivelcentrocosto= new NivelCentroCosto();
			
			this.nivelcentrocostoObject=new Object();
			this.nivelcentrocostosObject=new ArrayList<Object>();
				
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
			
			this.nivelcentrocostoDataAccess.setConnexionType(this.connexionType);
			this.nivelcentrocostoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NivelCentroCostoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.nivelcentrocostoDataAccess = new NivelCentroCostoDataAccess();
			this.nivelcentrocostos= new ArrayList<NivelCentroCosto>();
			this.nivelcentrocosto= new NivelCentroCosto();
			this.nivelcentrocostoObject=new Object();
			this.nivelcentrocostosObject=new ArrayList<Object>();
			
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
			
			this.nivelcentrocostoDataAccess.setConnexionType(this.connexionType);
			this.nivelcentrocostoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NivelCentroCosto getNivelCentroCosto() throws Exception {	
		NivelCentroCostoLogicAdditional.checkNivelCentroCostoToGet(nivelcentrocosto,this.datosCliente,this.arrDatoGeneral);
		NivelCentroCostoLogicAdditional.updateNivelCentroCostoToGet(nivelcentrocosto,this.arrDatoGeneral);
		
		return nivelcentrocosto;
	}
		
	public void setNivelCentroCosto(NivelCentroCosto newNivelCentroCosto) {
		this.nivelcentrocosto = newNivelCentroCosto;
	}
	
	public NivelCentroCostoDataAccess getNivelCentroCostoDataAccess() {
		return nivelcentrocostoDataAccess;
	}
	
	public void setNivelCentroCostoDataAccess(NivelCentroCostoDataAccess newnivelcentrocostoDataAccess) {
		this.nivelcentrocostoDataAccess = newnivelcentrocostoDataAccess;
	}
	
	public List<NivelCentroCosto> getNivelCentroCostos() throws Exception {		
		this.quitarNivelCentroCostosNulos();
		
		NivelCentroCostoLogicAdditional.checkNivelCentroCostoToGets(nivelcentrocostos,this.datosCliente,this.arrDatoGeneral);
		
		for (NivelCentroCosto nivelcentrocostoLocal: nivelcentrocostos ) {
			NivelCentroCostoLogicAdditional.updateNivelCentroCostoToGet(nivelcentrocostoLocal,this.arrDatoGeneral);
		}
		
		return nivelcentrocostos;
	}
	
	public void setNivelCentroCostos(List<NivelCentroCosto> newNivelCentroCostos) {
		this.nivelcentrocostos = newNivelCentroCostos;
	}
	
	public Object getNivelCentroCostoObject() {	
		this.nivelcentrocostoObject=this.nivelcentrocostoDataAccess.getEntityObject();
		return this.nivelcentrocostoObject;
	}
		
	public void setNivelCentroCostoObject(Object newNivelCentroCostoObject) {
		this.nivelcentrocostoObject = newNivelCentroCostoObject;
	}
	
	public List<Object> getNivelCentroCostosObject() {		
		this.nivelcentrocostosObject=this.nivelcentrocostoDataAccess.getEntitiesObject();
		return this.nivelcentrocostosObject;
	}
		
	public void setNivelCentroCostosObject(List<Object> newNivelCentroCostosObject) {
		this.nivelcentrocostosObject = newNivelCentroCostosObject;
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
		
		if(this.nivelcentrocostoDataAccess!=null) {
			this.nivelcentrocostoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			nivelcentrocostoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			nivelcentrocostoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		nivelcentrocosto = new  NivelCentroCosto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			nivelcentrocosto=nivelcentrocostoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivelcentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocosto);
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
		nivelcentrocosto = new  NivelCentroCosto();
		  		  
        try {
			
			nivelcentrocosto=nivelcentrocostoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivelcentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocosto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		nivelcentrocosto = new  NivelCentroCosto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			nivelcentrocosto=nivelcentrocostoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivelcentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocosto);
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
		nivelcentrocosto = new  NivelCentroCosto();
		  		  
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
		nivelcentrocosto = new  NivelCentroCosto();
		  		  
        try {
			
			nivelcentrocosto=nivelcentrocostoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivelcentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocosto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		nivelcentrocosto = new  NivelCentroCosto();
		  		  
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
		nivelcentrocosto = new  NivelCentroCosto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =nivelcentrocostoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		nivelcentrocosto = new  NivelCentroCosto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=nivelcentrocostoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		nivelcentrocosto = new  NivelCentroCosto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =nivelcentrocostoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		nivelcentrocosto = new  NivelCentroCosto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=nivelcentrocostoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		nivelcentrocosto = new  NivelCentroCosto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =nivelcentrocostoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		nivelcentrocosto = new  NivelCentroCosto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=nivelcentrocostoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		nivelcentrocostos = new  ArrayList<NivelCentroCosto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcentrocostos=nivelcentrocostoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCentroCosto(nivelcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocostos);
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
		nivelcentrocostos = new  ArrayList<NivelCentroCosto>();
		  		  
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
		nivelcentrocostos = new  ArrayList<NivelCentroCosto>();
		  		  
        try {			
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcentrocostos=nivelcentrocostoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNivelCentroCosto(nivelcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocostos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		nivelcentrocostos = new  ArrayList<NivelCentroCosto>();
		  		  
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
		nivelcentrocostos = new  ArrayList<NivelCentroCosto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcentrocostos=nivelcentrocostoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCentroCosto(nivelcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocostos);
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
		nivelcentrocostos = new  ArrayList<NivelCentroCosto>();
		  		  
        try {
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcentrocostos=nivelcentrocostoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCentroCosto(nivelcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocostos);
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
		nivelcentrocostos = new  ArrayList<NivelCentroCosto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcentrocostos=nivelcentrocostoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelCentroCosto(nivelcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocostos);
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
		nivelcentrocostos = new  ArrayList<NivelCentroCosto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcentrocostos=nivelcentrocostoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelCentroCosto(nivelcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocostos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		nivelcentrocosto = new  NivelCentroCosto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcentrocosto=nivelcentrocostoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelCentroCosto(nivelcentrocosto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocosto);
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
		nivelcentrocosto = new  NivelCentroCosto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcentrocosto=nivelcentrocostoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelCentroCosto(nivelcentrocosto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocosto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		nivelcentrocostos = new  ArrayList<NivelCentroCosto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcentrocostos=nivelcentrocostoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCentroCosto(nivelcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocostos);
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
		nivelcentrocostos = new  ArrayList<NivelCentroCosto>();
		  		  
        try {
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcentrocostos=nivelcentrocostoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCentroCosto(nivelcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocostos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNivelCentroCostosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		nivelcentrocostos = new  ArrayList<NivelCentroCosto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-getTodosNivelCentroCostosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcentrocostos=nivelcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNivelCentroCosto(nivelcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocostos);
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
	
	public  void  getTodosNivelCentroCostos(String sFinalQuery,Pagination pagination)throws Exception {
		nivelcentrocostos = new  ArrayList<NivelCentroCosto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcentrocostos=nivelcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNivelCentroCosto(nivelcentrocostos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocostos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNivelCentroCosto(NivelCentroCosto nivelcentrocosto) throws Exception {
		Boolean estaValidado=false;
		
		if(nivelcentrocosto.getIsNew() || nivelcentrocosto.getIsChanged()) { 
			this.invalidValues = nivelcentrocostoValidator.getInvalidValues(nivelcentrocosto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(nivelcentrocosto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNivelCentroCosto(List<NivelCentroCosto> NivelCentroCostos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NivelCentroCosto nivelcentrocostoLocal:nivelcentrocostos) {				
			estaValidadoObjeto=this.validarGuardarNivelCentroCosto(nivelcentrocostoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNivelCentroCosto(List<NivelCentroCosto> NivelCentroCostos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNivelCentroCosto(nivelcentrocostos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNivelCentroCosto(NivelCentroCosto NivelCentroCosto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNivelCentroCosto(nivelcentrocosto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NivelCentroCosto nivelcentrocosto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+nivelcentrocosto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NivelCentroCostoConstantesFunciones.getNivelCentroCostoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"nivelcentrocosto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NivelCentroCostoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NivelCentroCostoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNivelCentroCostoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-saveNivelCentroCostoWithConnection");connexion.begin();			
			
			NivelCentroCostoLogicAdditional.checkNivelCentroCostoToSave(this.nivelcentrocosto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NivelCentroCostoLogicAdditional.updateNivelCentroCostoToSave(this.nivelcentrocosto,this.arrDatoGeneral);
			
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.nivelcentrocosto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNivelCentroCosto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNivelCentroCosto(this.nivelcentrocosto)) {
				NivelCentroCostoDataAccess.save(this.nivelcentrocosto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.nivelcentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NivelCentroCostoLogicAdditional.checkNivelCentroCostoToSaveAfter(this.nivelcentrocosto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNivelCentroCosto();
			
			connexion.commit();			
			
			if(this.nivelcentrocosto.getIsDeleted()) {
				this.nivelcentrocosto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNivelCentroCosto()throws Exception {	
		try {	
			
			NivelCentroCostoLogicAdditional.checkNivelCentroCostoToSave(this.nivelcentrocosto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NivelCentroCostoLogicAdditional.updateNivelCentroCostoToSave(this.nivelcentrocosto,this.arrDatoGeneral);
			
			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.nivelcentrocosto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNivelCentroCosto(this.nivelcentrocosto)) {			
				NivelCentroCostoDataAccess.save(this.nivelcentrocosto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.nivelcentrocosto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NivelCentroCostoLogicAdditional.checkNivelCentroCostoToSaveAfter(this.nivelcentrocosto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.nivelcentrocosto.getIsDeleted()) {
				this.nivelcentrocosto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNivelCentroCostosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-saveNivelCentroCostosWithConnection");connexion.begin();			
			
			NivelCentroCostoLogicAdditional.checkNivelCentroCostoToSaves(nivelcentrocostos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNivelCentroCostos();
			
			Boolean validadoTodosNivelCentroCosto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NivelCentroCosto nivelcentrocostoLocal:nivelcentrocostos) {		
				if(nivelcentrocostoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NivelCentroCostoLogicAdditional.updateNivelCentroCostoToSave(nivelcentrocostoLocal,this.arrDatoGeneral);
	        	
				NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),nivelcentrocostoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNivelCentroCosto(nivelcentrocostoLocal)) {
					NivelCentroCostoDataAccess.save(nivelcentrocostoLocal, connexion);				
				} else {
					validadoTodosNivelCentroCosto=false;
				}
			}
			
			if(!validadoTodosNivelCentroCosto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NivelCentroCostoLogicAdditional.checkNivelCentroCostoToSavesAfter(nivelcentrocostos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNivelCentroCostos();
			
			connexion.commit();		
			
			this.quitarNivelCentroCostosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNivelCentroCostos()throws Exception {				
		 try {	
			NivelCentroCostoLogicAdditional.checkNivelCentroCostoToSaves(nivelcentrocostos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNivelCentroCosto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NivelCentroCosto nivelcentrocostoLocal:nivelcentrocostos) {				
				if(nivelcentrocostoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NivelCentroCostoLogicAdditional.updateNivelCentroCostoToSave(nivelcentrocostoLocal,this.arrDatoGeneral);
	        	
				NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),nivelcentrocostoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNivelCentroCosto(nivelcentrocostoLocal)) {				
					NivelCentroCostoDataAccess.save(nivelcentrocostoLocal, connexion);				
				} else {
					validadoTodosNivelCentroCosto=false;
				}
			}
			
			if(!validadoTodosNivelCentroCosto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NivelCentroCostoLogicAdditional.checkNivelCentroCostoToSavesAfter(nivelcentrocostos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNivelCentroCostosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NivelCentroCostoParameterReturnGeneral procesarAccionNivelCentroCostos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NivelCentroCosto> nivelcentrocostos,NivelCentroCostoParameterReturnGeneral nivelcentrocostoParameterGeneral)throws Exception {
		 try {	
			NivelCentroCostoParameterReturnGeneral nivelcentrocostoReturnGeneral=new NivelCentroCostoParameterReturnGeneral();
	
			NivelCentroCostoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,nivelcentrocostos,nivelcentrocostoParameterGeneral,nivelcentrocostoReturnGeneral);
			
			return nivelcentrocostoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NivelCentroCostoParameterReturnGeneral procesarAccionNivelCentroCostosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NivelCentroCosto> nivelcentrocostos,NivelCentroCostoParameterReturnGeneral nivelcentrocostoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-procesarAccionNivelCentroCostosWithConnection");connexion.begin();			
			
			NivelCentroCostoParameterReturnGeneral nivelcentrocostoReturnGeneral=new NivelCentroCostoParameterReturnGeneral();
	
			NivelCentroCostoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,nivelcentrocostos,nivelcentrocostoParameterGeneral,nivelcentrocostoReturnGeneral);
			
			this.connexion.commit();
			
			return nivelcentrocostoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NivelCentroCostoParameterReturnGeneral procesarEventosNivelCentroCostos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NivelCentroCosto> nivelcentrocostos,NivelCentroCosto nivelcentrocosto,NivelCentroCostoParameterReturnGeneral nivelcentrocostoParameterGeneral,Boolean isEsNuevoNivelCentroCosto,ArrayList<Classe> clases)throws Exception {
		 try {	
			NivelCentroCostoParameterReturnGeneral nivelcentrocostoReturnGeneral=new NivelCentroCostoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				nivelcentrocostoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NivelCentroCostoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,nivelcentrocostos,nivelcentrocosto,nivelcentrocostoParameterGeneral,nivelcentrocostoReturnGeneral,isEsNuevoNivelCentroCosto,clases);
			
			return nivelcentrocostoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NivelCentroCostoParameterReturnGeneral procesarEventosNivelCentroCostosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NivelCentroCosto> nivelcentrocostos,NivelCentroCosto nivelcentrocosto,NivelCentroCostoParameterReturnGeneral nivelcentrocostoParameterGeneral,Boolean isEsNuevoNivelCentroCosto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-procesarEventosNivelCentroCostosWithConnection");connexion.begin();			
			
			NivelCentroCostoParameterReturnGeneral nivelcentrocostoReturnGeneral=new NivelCentroCostoParameterReturnGeneral();
	
			nivelcentrocostoReturnGeneral.setNivelCentroCosto(nivelcentrocosto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				nivelcentrocostoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NivelCentroCostoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,nivelcentrocostos,nivelcentrocosto,nivelcentrocostoParameterGeneral,nivelcentrocostoReturnGeneral,isEsNuevoNivelCentroCosto,clases);
			
			this.connexion.commit();
			
			return nivelcentrocostoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NivelCentroCostoParameterReturnGeneral procesarImportacionNivelCentroCostosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NivelCentroCostoParameterReturnGeneral nivelcentrocostoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-procesarImportacionNivelCentroCostosWithConnection");connexion.begin();			
			
			NivelCentroCostoParameterReturnGeneral nivelcentrocostoReturnGeneral=new NivelCentroCostoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.nivelcentrocostos=new ArrayList<NivelCentroCosto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.nivelcentrocosto=new NivelCentroCosto();
				
				
				if(conColumnasBase) {this.nivelcentrocosto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.nivelcentrocosto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.nivelcentrocosto.setnivel(Integer.parseInt(arrColumnas[iColumn++]));
				this.nivelcentrocosto.setnumero_digitos(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.nivelcentrocostos.add(this.nivelcentrocosto);
			}
			
			this.saveNivelCentroCostos();
			
			this.connexion.commit();
			
			nivelcentrocostoReturnGeneral.setConRetornoEstaProcesado(true);
			nivelcentrocostoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return nivelcentrocostoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNivelCentroCostosEliminados() throws Exception {				
		
		List<NivelCentroCosto> nivelcentrocostosAux= new ArrayList<NivelCentroCosto>();
		
		for(NivelCentroCosto nivelcentrocosto:nivelcentrocostos) {
			if(!nivelcentrocosto.getIsDeleted()) {
				nivelcentrocostosAux.add(nivelcentrocosto);
			}
		}
		
		nivelcentrocostos=nivelcentrocostosAux;
	}
	
	public void quitarNivelCentroCostosNulos() throws Exception {				
		
		List<NivelCentroCosto> nivelcentrocostosAux= new ArrayList<NivelCentroCosto>();
		
		for(NivelCentroCosto nivelcentrocosto : this.nivelcentrocostos) {
			if(nivelcentrocosto==null) {
				nivelcentrocostosAux.add(nivelcentrocosto);
			}
		}
		
		//this.nivelcentrocostos=nivelcentrocostosAux;
		
		this.nivelcentrocostos.removeAll(nivelcentrocostosAux);
	}
	
	public void getSetVersionRowNivelCentroCostoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(nivelcentrocosto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((nivelcentrocosto.getIsDeleted() || (nivelcentrocosto.getIsChanged()&&!nivelcentrocosto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=nivelcentrocostoDataAccess.getSetVersionRowNivelCentroCosto(connexion,nivelcentrocosto.getId());
				
				if(!nivelcentrocosto.getVersionRow().equals(timestamp)) {	
					nivelcentrocosto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				nivelcentrocosto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNivelCentroCosto()throws Exception {	
		
		if(nivelcentrocosto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((nivelcentrocosto.getIsDeleted() || (nivelcentrocosto.getIsChanged()&&!nivelcentrocosto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=nivelcentrocostoDataAccess.getSetVersionRowNivelCentroCosto(connexion,nivelcentrocosto.getId());
			
			try {							
				if(!nivelcentrocosto.getVersionRow().equals(timestamp)) {	
					nivelcentrocosto.setVersionRow(timestamp);
				}
				
				nivelcentrocosto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNivelCentroCostosWithConnection()throws Exception {	
		if(nivelcentrocostos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NivelCentroCosto nivelcentrocostoAux:nivelcentrocostos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(nivelcentrocostoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(nivelcentrocostoAux.getIsDeleted() || (nivelcentrocostoAux.getIsChanged()&&!nivelcentrocostoAux.getIsNew())) {
						
						timestamp=nivelcentrocostoDataAccess.getSetVersionRowNivelCentroCosto(connexion,nivelcentrocostoAux.getId());
						
						if(!nivelcentrocosto.getVersionRow().equals(timestamp)) {	
							nivelcentrocostoAux.setVersionRow(timestamp);
						}
								
						nivelcentrocostoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNivelCentroCostos()throws Exception {	
		if(nivelcentrocostos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NivelCentroCosto nivelcentrocostoAux:nivelcentrocostos) {
					if(nivelcentrocostoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(nivelcentrocostoAux.getIsDeleted() || (nivelcentrocostoAux.getIsChanged()&&!nivelcentrocostoAux.getIsNew())) {
						
						timestamp=nivelcentrocostoDataAccess.getSetVersionRowNivelCentroCosto(connexion,nivelcentrocostoAux.getId());
						
						if(!nivelcentrocostoAux.getVersionRow().equals(timestamp)) {	
							nivelcentrocostoAux.setVersionRow(timestamp);
						}
						
													
						nivelcentrocostoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public NivelCentroCostoParameterReturnGeneral cargarCombosLoteForeignKeyNivelCentroCostoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		NivelCentroCostoParameterReturnGeneral  nivelcentrocostoReturnGeneral =new NivelCentroCostoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-cargarCombosLoteForeignKeyNivelCentroCostoWithConnection");connexion.begin();
			
			nivelcentrocostoReturnGeneral =new NivelCentroCostoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			nivelcentrocostoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return nivelcentrocostoReturnGeneral;
	}
	
	public NivelCentroCostoParameterReturnGeneral cargarCombosLoteForeignKeyNivelCentroCosto(String finalQueryGlobalEmpresa) throws Exception {
		NivelCentroCostoParameterReturnGeneral  nivelcentrocostoReturnGeneral =new NivelCentroCostoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			nivelcentrocostoReturnGeneral =new NivelCentroCostoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			nivelcentrocostoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return nivelcentrocostoReturnGeneral;
	}
	
	
	public void deepLoad(NivelCentroCosto nivelcentrocosto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NivelCentroCostoLogicAdditional.updateNivelCentroCostoToGet(nivelcentrocosto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		nivelcentrocosto.setEmpresa(nivelcentrocostoDataAccess.getEmpresa(connexion,nivelcentrocosto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				nivelcentrocosto.setEmpresa(nivelcentrocostoDataAccess.getEmpresa(connexion,nivelcentrocosto));
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
			nivelcentrocosto.setEmpresa(nivelcentrocostoDataAccess.getEmpresa(connexion,nivelcentrocosto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		nivelcentrocosto.setEmpresa(nivelcentrocostoDataAccess.getEmpresa(connexion,nivelcentrocosto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(nivelcentrocosto.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				nivelcentrocosto.setEmpresa(nivelcentrocostoDataAccess.getEmpresa(connexion,nivelcentrocosto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(nivelcentrocosto.getEmpresa(),isDeep,deepLoadType,clases);				
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
			nivelcentrocosto.setEmpresa(nivelcentrocostoDataAccess.getEmpresa(connexion,nivelcentrocosto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(nivelcentrocosto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NivelCentroCosto nivelcentrocosto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NivelCentroCostoLogicAdditional.updateNivelCentroCostoToSave(nivelcentrocosto,this.arrDatoGeneral);
			
NivelCentroCostoDataAccess.save(nivelcentrocosto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(nivelcentrocosto.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(nivelcentrocosto.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(nivelcentrocosto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(nivelcentrocosto.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(nivelcentrocosto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(nivelcentrocosto.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(NivelCentroCosto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(nivelcentrocosto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(nivelcentrocosto);
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
			this.deepLoad(this.nivelcentrocosto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocosto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NivelCentroCosto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(nivelcentrocostos!=null) {
				for(NivelCentroCosto nivelcentrocosto:nivelcentrocostos) {
					this.deepLoad(nivelcentrocosto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(nivelcentrocostos);
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
			if(nivelcentrocostos!=null) {
				for(NivelCentroCosto nivelcentrocosto:nivelcentrocostos) {
					this.deepLoad(nivelcentrocosto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(nivelcentrocostos);
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
			this.getNewConnexionToDeep(NivelCentroCosto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(nivelcentrocosto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NivelCentroCosto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(nivelcentrocostos!=null) {
				for(NivelCentroCosto nivelcentrocosto:nivelcentrocostos) {
					this.deepSave(nivelcentrocosto,isDeep,deepLoadType,clases);
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
			if(nivelcentrocostos!=null) {
				for(NivelCentroCosto nivelcentrocosto:nivelcentrocostos) {
					this.deepSave(nivelcentrocosto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNivelCentroCostosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCentroCosto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NivelCentroCostoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			nivelcentrocostos=nivelcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocostos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNivelCentroCostosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NivelCentroCostoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NivelCentroCostoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			nivelcentrocostos=nivelcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NivelCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesNivelCentroCosto(this.nivelcentrocostos);
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
			if(NivelCentroCostoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelCentroCostoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NivelCentroCosto nivelcentrocosto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NivelCentroCostoConstantesFunciones.ISCONAUDITORIA) {
				if(nivelcentrocosto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelCentroCostoDataAccess.TABLENAME, nivelcentrocosto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NivelCentroCostoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NivelCentroCostoLogic.registrarAuditoriaDetallesNivelCentroCosto(connexion,nivelcentrocosto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(nivelcentrocosto.getIsDeleted()) {
					/*if(!nivelcentrocosto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NivelCentroCostoDataAccess.TABLENAME, nivelcentrocosto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NivelCentroCostoLogic.registrarAuditoriaDetallesNivelCentroCosto(connexion,nivelcentrocosto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelCentroCostoDataAccess.TABLENAME, nivelcentrocosto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(nivelcentrocosto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelCentroCostoDataAccess.TABLENAME, nivelcentrocosto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NivelCentroCostoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NivelCentroCostoLogic.registrarAuditoriaDetallesNivelCentroCosto(connexion,nivelcentrocosto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNivelCentroCosto(Connexion connexion,NivelCentroCosto nivelcentrocosto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(nivelcentrocosto.getIsNew()||!nivelcentrocosto.getid_empresa().equals(nivelcentrocosto.getNivelCentroCostoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(nivelcentrocosto.getNivelCentroCostoOriginal().getid_empresa()!=null)
				{
					strValorActual=nivelcentrocosto.getNivelCentroCostoOriginal().getid_empresa().toString();
				}
				if(nivelcentrocosto.getid_empresa()!=null)
				{
					strValorNuevo=nivelcentrocosto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NivelCentroCostoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(nivelcentrocosto.getIsNew()||!nivelcentrocosto.getnivel().equals(nivelcentrocosto.getNivelCentroCostoOriginal().getnivel()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(nivelcentrocosto.getNivelCentroCostoOriginal().getnivel()!=null)
				{
					strValorActual=nivelcentrocosto.getNivelCentroCostoOriginal().getnivel().toString();
				}
				if(nivelcentrocosto.getnivel()!=null)
				{
					strValorNuevo=nivelcentrocosto.getnivel().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NivelCentroCostoConstantesFunciones.NIVEL,strValorActual,strValorNuevo);
			}	
			
			if(nivelcentrocosto.getIsNew()||!nivelcentrocosto.getnumero_digitos().equals(nivelcentrocosto.getNivelCentroCostoOriginal().getnumero_digitos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(nivelcentrocosto.getNivelCentroCostoOriginal().getnumero_digitos()!=null)
				{
					strValorActual=nivelcentrocosto.getNivelCentroCostoOriginal().getnumero_digitos().toString();
				}
				if(nivelcentrocosto.getnumero_digitos()!=null)
				{
					strValorNuevo=nivelcentrocosto.getnumero_digitos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NivelCentroCostoConstantesFunciones.NUMERODIGITOS,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNivelCentroCostoRelacionesWithConnection(NivelCentroCosto nivelcentrocosto) throws Exception {

		if(!nivelcentrocosto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNivelCentroCostoRelacionesBase(nivelcentrocosto,true);
		}
	}

	public void saveNivelCentroCostoRelaciones(NivelCentroCosto nivelcentrocosto)throws Exception {

		if(!nivelcentrocosto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNivelCentroCostoRelacionesBase(nivelcentrocosto,false);
		}
	}

	public void saveNivelCentroCostoRelacionesBase(NivelCentroCosto nivelcentrocosto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NivelCentroCosto-saveRelacionesWithConnection");}
	

			this.setNivelCentroCosto(nivelcentrocosto);

			if(NivelCentroCostoLogicAdditional.validarSaveRelaciones(nivelcentrocosto,this)) {

				NivelCentroCostoLogicAdditional.updateRelacionesToSave(nivelcentrocosto,this);

				if((nivelcentrocosto.getIsNew()||nivelcentrocosto.getIsChanged())&&!nivelcentrocosto.getIsDeleted()) {
					this.saveNivelCentroCosto();
					this.saveNivelCentroCostoRelacionesDetalles();

				} else if(nivelcentrocosto.getIsDeleted()) {
					this.saveNivelCentroCostoRelacionesDetalles();
					this.saveNivelCentroCosto();
				}

				NivelCentroCostoLogicAdditional.updateRelacionesToSaveAfter(nivelcentrocosto,this);

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
	
	
	private void saveNivelCentroCostoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNivelCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NivelCentroCostoConstantesFunciones.getClassesForeignKeysOfNivelCentroCosto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNivelCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NivelCentroCostoConstantesFunciones.getClassesRelationshipsOfNivelCentroCosto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

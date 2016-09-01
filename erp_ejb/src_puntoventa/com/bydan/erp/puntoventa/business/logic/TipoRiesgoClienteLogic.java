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
import com.bydan.erp.puntoventa.util.TipoRiesgoClienteConstantesFunciones;
import com.bydan.erp.puntoventa.util.TipoRiesgoClienteParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TipoRiesgoClienteParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.TipoRiesgoCliente;
import com.bydan.erp.puntoventa.business.logic.TipoRiesgoClienteLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoRiesgoClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoRiesgoClienteLogic.class);
	
	protected TipoRiesgoClienteDataAccess tiporiesgoclienteDataAccess; 	
	protected TipoRiesgoCliente tiporiesgocliente;
	protected List<TipoRiesgoCliente> tiporiesgoclientes;
	protected Object tiporiesgoclienteObject;	
	protected List<Object> tiporiesgoclientesObject;
	
	public static ClassValidator<TipoRiesgoCliente> tiporiesgoclienteValidator = new ClassValidator<TipoRiesgoCliente>(TipoRiesgoCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoRiesgoClienteLogicAdditional tiporiesgoclienteLogicAdditional=null;
	
	public TipoRiesgoClienteLogicAdditional getTipoRiesgoClienteLogicAdditional() {
		return this.tiporiesgoclienteLogicAdditional;
	}
	
	public void setTipoRiesgoClienteLogicAdditional(TipoRiesgoClienteLogicAdditional tiporiesgoclienteLogicAdditional) {
		try {
			this.tiporiesgoclienteLogicAdditional=tiporiesgoclienteLogicAdditional;
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
	
	
	
	
	public  TipoRiesgoClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiporiesgoclienteDataAccess = new TipoRiesgoClienteDataAccess();
			
			this.tiporiesgoclientes= new ArrayList<TipoRiesgoCliente>();
			this.tiporiesgocliente= new TipoRiesgoCliente();
			
			this.tiporiesgoclienteObject=new Object();
			this.tiporiesgoclientesObject=new ArrayList<Object>();
				
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
			
			this.tiporiesgoclienteDataAccess.setConnexionType(this.connexionType);
			this.tiporiesgoclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoRiesgoClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiporiesgoclienteDataAccess = new TipoRiesgoClienteDataAccess();
			this.tiporiesgoclientes= new ArrayList<TipoRiesgoCliente>();
			this.tiporiesgocliente= new TipoRiesgoCliente();
			this.tiporiesgoclienteObject=new Object();
			this.tiporiesgoclientesObject=new ArrayList<Object>();
			
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
			
			this.tiporiesgoclienteDataAccess.setConnexionType(this.connexionType);
			this.tiporiesgoclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoRiesgoCliente getTipoRiesgoCliente() throws Exception {	
		TipoRiesgoClienteLogicAdditional.checkTipoRiesgoClienteToGet(tiporiesgocliente,this.datosCliente,this.arrDatoGeneral);
		TipoRiesgoClienteLogicAdditional.updateTipoRiesgoClienteToGet(tiporiesgocliente,this.arrDatoGeneral);
		
		return tiporiesgocliente;
	}
		
	public void setTipoRiesgoCliente(TipoRiesgoCliente newTipoRiesgoCliente) {
		this.tiporiesgocliente = newTipoRiesgoCliente;
	}
	
	public TipoRiesgoClienteDataAccess getTipoRiesgoClienteDataAccess() {
		return tiporiesgoclienteDataAccess;
	}
	
	public void setTipoRiesgoClienteDataAccess(TipoRiesgoClienteDataAccess newtiporiesgoclienteDataAccess) {
		this.tiporiesgoclienteDataAccess = newtiporiesgoclienteDataAccess;
	}
	
	public List<TipoRiesgoCliente> getTipoRiesgoClientes() throws Exception {		
		this.quitarTipoRiesgoClientesNulos();
		
		TipoRiesgoClienteLogicAdditional.checkTipoRiesgoClienteToGets(tiporiesgoclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoRiesgoCliente tiporiesgoclienteLocal: tiporiesgoclientes ) {
			TipoRiesgoClienteLogicAdditional.updateTipoRiesgoClienteToGet(tiporiesgoclienteLocal,this.arrDatoGeneral);
		}
		
		return tiporiesgoclientes;
	}
	
	public void setTipoRiesgoClientes(List<TipoRiesgoCliente> newTipoRiesgoClientes) {
		this.tiporiesgoclientes = newTipoRiesgoClientes;
	}
	
	public Object getTipoRiesgoClienteObject() {	
		this.tiporiesgoclienteObject=this.tiporiesgoclienteDataAccess.getEntityObject();
		return this.tiporiesgoclienteObject;
	}
		
	public void setTipoRiesgoClienteObject(Object newTipoRiesgoClienteObject) {
		this.tiporiesgoclienteObject = newTipoRiesgoClienteObject;
	}
	
	public List<Object> getTipoRiesgoClientesObject() {		
		this.tiporiesgoclientesObject=this.tiporiesgoclienteDataAccess.getEntitiesObject();
		return this.tiporiesgoclientesObject;
	}
		
	public void setTipoRiesgoClientesObject(List<Object> newTipoRiesgoClientesObject) {
		this.tiporiesgoclientesObject = newTipoRiesgoClientesObject;
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
		
		if(this.tiporiesgoclienteDataAccess!=null) {
			this.tiporiesgoclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiporiesgoclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiporiesgoclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiporiesgocliente = new  TipoRiesgoCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporiesgocliente=tiporiesgoclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporiesgocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgocliente);
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
		tiporiesgocliente = new  TipoRiesgoCliente();
		  		  
        try {
			
			tiporiesgocliente=tiporiesgoclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporiesgocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiporiesgocliente = new  TipoRiesgoCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporiesgocliente=tiporiesgoclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporiesgocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgocliente);
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
		tiporiesgocliente = new  TipoRiesgoCliente();
		  		  
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
		tiporiesgocliente = new  TipoRiesgoCliente();
		  		  
        try {
			
			tiporiesgocliente=tiporiesgoclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporiesgocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiporiesgocliente = new  TipoRiesgoCliente();
		  		  
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
		tiporiesgocliente = new  TipoRiesgoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiporiesgoclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporiesgocliente = new  TipoRiesgoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiporiesgoclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporiesgocliente = new  TipoRiesgoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiporiesgoclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporiesgocliente = new  TipoRiesgoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiporiesgoclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporiesgocliente = new  TipoRiesgoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiporiesgoclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporiesgocliente = new  TipoRiesgoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiporiesgoclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporiesgoclientes = new  ArrayList<TipoRiesgoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgoclientes=tiporiesgoclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCliente(tiporiesgoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgoclientes);
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
		tiporiesgoclientes = new  ArrayList<TipoRiesgoCliente>();
		  		  
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
		tiporiesgoclientes = new  ArrayList<TipoRiesgoCliente>();
		  		  
        try {			
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgoclientes=tiporiesgoclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoRiesgoCliente(tiporiesgoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgoclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiporiesgoclientes = new  ArrayList<TipoRiesgoCliente>();
		  		  
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
		tiporiesgoclientes = new  ArrayList<TipoRiesgoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgoclientes=tiporiesgoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCliente(tiporiesgoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgoclientes);
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
		tiporiesgoclientes = new  ArrayList<TipoRiesgoCliente>();
		  		  
        try {
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgoclientes=tiporiesgoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCliente(tiporiesgoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgoclientes);
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
		tiporiesgoclientes = new  ArrayList<TipoRiesgoCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgoclientes=tiporiesgoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCliente(tiporiesgoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgoclientes);
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
		tiporiesgoclientes = new  ArrayList<TipoRiesgoCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgoclientes=tiporiesgoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCliente(tiporiesgoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgoclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiporiesgocliente = new  TipoRiesgoCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgocliente=tiporiesgoclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCliente(tiporiesgocliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgocliente);
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
		tiporiesgocliente = new  TipoRiesgoCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgocliente=tiporiesgoclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCliente(tiporiesgocliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporiesgoclientes = new  ArrayList<TipoRiesgoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgoclientes=tiporiesgoclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCliente(tiporiesgoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgoclientes);
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
		tiporiesgoclientes = new  ArrayList<TipoRiesgoCliente>();
		  		  
        try {
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgoclientes=tiporiesgoclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRiesgoCliente(tiporiesgoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgoclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoRiesgoClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiporiesgoclientes = new  ArrayList<TipoRiesgoCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-getTodosTipoRiesgoClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgoclientes=tiporiesgoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRiesgoCliente(tiporiesgoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgoclientes);
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
	
	public  void  getTodosTipoRiesgoClientes(String sFinalQuery,Pagination pagination)throws Exception {
		tiporiesgoclientes = new  ArrayList<TipoRiesgoCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporiesgoclientes=tiporiesgoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRiesgoCliente(tiporiesgoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgoclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoRiesgoCliente(TipoRiesgoCliente tiporiesgocliente) throws Exception {
		Boolean estaValidado=false;
		
		if(tiporiesgocliente.getIsNew() || tiporiesgocliente.getIsChanged()) { 
			this.invalidValues = tiporiesgoclienteValidator.getInvalidValues(tiporiesgocliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiporiesgocliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoRiesgoCliente(List<TipoRiesgoCliente> TipoRiesgoClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoRiesgoCliente tiporiesgoclienteLocal:tiporiesgoclientes) {				
			estaValidadoObjeto=this.validarGuardarTipoRiesgoCliente(tiporiesgoclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoRiesgoCliente(List<TipoRiesgoCliente> TipoRiesgoClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRiesgoCliente(tiporiesgoclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoRiesgoCliente(TipoRiesgoCliente TipoRiesgoCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRiesgoCliente(tiporiesgocliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoRiesgoCliente tiporiesgocliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiporiesgocliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoRiesgoClienteConstantesFunciones.getTipoRiesgoClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiporiesgocliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoRiesgoClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoRiesgoClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoRiesgoClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-saveTipoRiesgoClienteWithConnection");connexion.begin();			
			
			TipoRiesgoClienteLogicAdditional.checkTipoRiesgoClienteToSave(this.tiporiesgocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRiesgoClienteLogicAdditional.updateTipoRiesgoClienteToSave(this.tiporiesgocliente,this.arrDatoGeneral);
			
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporiesgocliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoRiesgoCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRiesgoCliente(this.tiporiesgocliente)) {
				TipoRiesgoClienteDataAccess.save(this.tiporiesgocliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiporiesgocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRiesgoClienteLogicAdditional.checkTipoRiesgoClienteToSaveAfter(this.tiporiesgocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRiesgoCliente();
			
			connexion.commit();			
			
			if(this.tiporiesgocliente.getIsDeleted()) {
				this.tiporiesgocliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoRiesgoCliente()throws Exception {	
		try {	
			
			TipoRiesgoClienteLogicAdditional.checkTipoRiesgoClienteToSave(this.tiporiesgocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRiesgoClienteLogicAdditional.updateTipoRiesgoClienteToSave(this.tiporiesgocliente,this.arrDatoGeneral);
			
			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporiesgocliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRiesgoCliente(this.tiporiesgocliente)) {			
				TipoRiesgoClienteDataAccess.save(this.tiporiesgocliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiporiesgocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRiesgoClienteLogicAdditional.checkTipoRiesgoClienteToSaveAfter(this.tiporiesgocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiporiesgocliente.getIsDeleted()) {
				this.tiporiesgocliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoRiesgoClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-saveTipoRiesgoClientesWithConnection");connexion.begin();			
			
			TipoRiesgoClienteLogicAdditional.checkTipoRiesgoClienteToSaves(tiporiesgoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoRiesgoClientes();
			
			Boolean validadoTodosTipoRiesgoCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRiesgoCliente tiporiesgoclienteLocal:tiporiesgoclientes) {		
				if(tiporiesgoclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRiesgoClienteLogicAdditional.updateTipoRiesgoClienteToSave(tiporiesgoclienteLocal,this.arrDatoGeneral);
	        	
				TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporiesgoclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRiesgoCliente(tiporiesgoclienteLocal)) {
					TipoRiesgoClienteDataAccess.save(tiporiesgoclienteLocal, connexion);				
				} else {
					validadoTodosTipoRiesgoCliente=false;
				}
			}
			
			if(!validadoTodosTipoRiesgoCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRiesgoClienteLogicAdditional.checkTipoRiesgoClienteToSavesAfter(tiporiesgoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRiesgoClientes();
			
			connexion.commit();		
			
			this.quitarTipoRiesgoClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoRiesgoClientes()throws Exception {				
		 try {	
			TipoRiesgoClienteLogicAdditional.checkTipoRiesgoClienteToSaves(tiporiesgoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoRiesgoCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRiesgoCliente tiporiesgoclienteLocal:tiporiesgoclientes) {				
				if(tiporiesgoclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRiesgoClienteLogicAdditional.updateTipoRiesgoClienteToSave(tiporiesgoclienteLocal,this.arrDatoGeneral);
	        	
				TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporiesgoclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRiesgoCliente(tiporiesgoclienteLocal)) {				
					TipoRiesgoClienteDataAccess.save(tiporiesgoclienteLocal, connexion);				
				} else {
					validadoTodosTipoRiesgoCliente=false;
				}
			}
			
			if(!validadoTodosTipoRiesgoCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRiesgoClienteLogicAdditional.checkTipoRiesgoClienteToSavesAfter(tiporiesgoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoRiesgoClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRiesgoClienteParameterReturnGeneral procesarAccionTipoRiesgoClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRiesgoCliente> tiporiesgoclientes,TipoRiesgoClienteParameterReturnGeneral tiporiesgoclienteParameterGeneral)throws Exception {
		 try {	
			TipoRiesgoClienteParameterReturnGeneral tiporiesgoclienteReturnGeneral=new TipoRiesgoClienteParameterReturnGeneral();
	
			TipoRiesgoClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporiesgoclientes,tiporiesgoclienteParameterGeneral,tiporiesgoclienteReturnGeneral);
			
			return tiporiesgoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRiesgoClienteParameterReturnGeneral procesarAccionTipoRiesgoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRiesgoCliente> tiporiesgoclientes,TipoRiesgoClienteParameterReturnGeneral tiporiesgoclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-procesarAccionTipoRiesgoClientesWithConnection");connexion.begin();			
			
			TipoRiesgoClienteParameterReturnGeneral tiporiesgoclienteReturnGeneral=new TipoRiesgoClienteParameterReturnGeneral();
	
			TipoRiesgoClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporiesgoclientes,tiporiesgoclienteParameterGeneral,tiporiesgoclienteReturnGeneral);
			
			this.connexion.commit();
			
			return tiporiesgoclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRiesgoClienteParameterReturnGeneral procesarEventosTipoRiesgoClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRiesgoCliente> tiporiesgoclientes,TipoRiesgoCliente tiporiesgocliente,TipoRiesgoClienteParameterReturnGeneral tiporiesgoclienteParameterGeneral,Boolean isEsNuevoTipoRiesgoCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoRiesgoClienteParameterReturnGeneral tiporiesgoclienteReturnGeneral=new TipoRiesgoClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporiesgoclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRiesgoClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporiesgoclientes,tiporiesgocliente,tiporiesgoclienteParameterGeneral,tiporiesgoclienteReturnGeneral,isEsNuevoTipoRiesgoCliente,clases);
			
			return tiporiesgoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoRiesgoClienteParameterReturnGeneral procesarEventosTipoRiesgoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRiesgoCliente> tiporiesgoclientes,TipoRiesgoCliente tiporiesgocliente,TipoRiesgoClienteParameterReturnGeneral tiporiesgoclienteParameterGeneral,Boolean isEsNuevoTipoRiesgoCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-procesarEventosTipoRiesgoClientesWithConnection");connexion.begin();			
			
			TipoRiesgoClienteParameterReturnGeneral tiporiesgoclienteReturnGeneral=new TipoRiesgoClienteParameterReturnGeneral();
	
			tiporiesgoclienteReturnGeneral.setTipoRiesgoCliente(tiporiesgocliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporiesgoclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRiesgoClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporiesgoclientes,tiporiesgocliente,tiporiesgoclienteParameterGeneral,tiporiesgoclienteReturnGeneral,isEsNuevoTipoRiesgoCliente,clases);
			
			this.connexion.commit();
			
			return tiporiesgoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRiesgoClienteParameterReturnGeneral procesarImportacionTipoRiesgoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoRiesgoClienteParameterReturnGeneral tiporiesgoclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-procesarImportacionTipoRiesgoClientesWithConnection");connexion.begin();			
			
			TipoRiesgoClienteParameterReturnGeneral tiporiesgoclienteReturnGeneral=new TipoRiesgoClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiporiesgoclientes=new ArrayList<TipoRiesgoCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiporiesgocliente=new TipoRiesgoCliente();
				
				
				if(conColumnasBase) {this.tiporiesgocliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiporiesgocliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiporiesgocliente.setnombre(arrColumnas[iColumn++]);
				
				this.tiporiesgoclientes.add(this.tiporiesgocliente);
			}
			
			this.saveTipoRiesgoClientes();
			
			this.connexion.commit();
			
			tiporiesgoclienteReturnGeneral.setConRetornoEstaProcesado(true);
			tiporiesgoclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiporiesgoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoRiesgoClientesEliminados() throws Exception {				
		
		List<TipoRiesgoCliente> tiporiesgoclientesAux= new ArrayList<TipoRiesgoCliente>();
		
		for(TipoRiesgoCliente tiporiesgocliente:tiporiesgoclientes) {
			if(!tiporiesgocliente.getIsDeleted()) {
				tiporiesgoclientesAux.add(tiporiesgocliente);
			}
		}
		
		tiporiesgoclientes=tiporiesgoclientesAux;
	}
	
	public void quitarTipoRiesgoClientesNulos() throws Exception {				
		
		List<TipoRiesgoCliente> tiporiesgoclientesAux= new ArrayList<TipoRiesgoCliente>();
		
		for(TipoRiesgoCliente tiporiesgocliente : this.tiporiesgoclientes) {
			if(tiporiesgocliente==null) {
				tiporiesgoclientesAux.add(tiporiesgocliente);
			}
		}
		
		//this.tiporiesgoclientes=tiporiesgoclientesAux;
		
		this.tiporiesgoclientes.removeAll(tiporiesgoclientesAux);
	}
	
	public void getSetVersionRowTipoRiesgoClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiporiesgocliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiporiesgocliente.getIsDeleted() || (tiporiesgocliente.getIsChanged()&&!tiporiesgocliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiporiesgoclienteDataAccess.getSetVersionRowTipoRiesgoCliente(connexion,tiporiesgocliente.getId());
				
				if(!tiporiesgocliente.getVersionRow().equals(timestamp)) {	
					tiporiesgocliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiporiesgocliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoRiesgoCliente()throws Exception {	
		
		if(tiporiesgocliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiporiesgocliente.getIsDeleted() || (tiporiesgocliente.getIsChanged()&&!tiporiesgocliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiporiesgoclienteDataAccess.getSetVersionRowTipoRiesgoCliente(connexion,tiporiesgocliente.getId());
			
			try {							
				if(!tiporiesgocliente.getVersionRow().equals(timestamp)) {	
					tiporiesgocliente.setVersionRow(timestamp);
				}
				
				tiporiesgocliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoRiesgoClientesWithConnection()throws Exception {	
		if(tiporiesgoclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoRiesgoCliente tiporiesgoclienteAux:tiporiesgoclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiporiesgoclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporiesgoclienteAux.getIsDeleted() || (tiporiesgoclienteAux.getIsChanged()&&!tiporiesgoclienteAux.getIsNew())) {
						
						timestamp=tiporiesgoclienteDataAccess.getSetVersionRowTipoRiesgoCliente(connexion,tiporiesgoclienteAux.getId());
						
						if(!tiporiesgocliente.getVersionRow().equals(timestamp)) {	
							tiporiesgoclienteAux.setVersionRow(timestamp);
						}
								
						tiporiesgoclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoRiesgoClientes()throws Exception {	
		if(tiporiesgoclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoRiesgoCliente tiporiesgoclienteAux:tiporiesgoclientes) {
					if(tiporiesgoclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporiesgoclienteAux.getIsDeleted() || (tiporiesgoclienteAux.getIsChanged()&&!tiporiesgoclienteAux.getIsNew())) {
						
						timestamp=tiporiesgoclienteDataAccess.getSetVersionRowTipoRiesgoCliente(connexion,tiporiesgoclienteAux.getId());
						
						if(!tiporiesgoclienteAux.getVersionRow().equals(timestamp)) {	
							tiporiesgoclienteAux.setVersionRow(timestamp);
						}
						
													
						tiporiesgoclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoRiesgoClienteParameterReturnGeneral cargarCombosLoteForeignKeyTipoRiesgoClienteWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoRiesgoClienteParameterReturnGeneral  tiporiesgoclienteReturnGeneral =new TipoRiesgoClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoRiesgoClienteWithConnection");connexion.begin();
			
			tiporiesgoclienteReturnGeneral =new TipoRiesgoClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiporiesgoclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tiporiesgoclienteReturnGeneral;
	}
	
	public TipoRiesgoClienteParameterReturnGeneral cargarCombosLoteForeignKeyTipoRiesgoCliente(String finalQueryGlobalEmpresa) throws Exception {
		TipoRiesgoClienteParameterReturnGeneral  tiporiesgoclienteReturnGeneral =new TipoRiesgoClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tiporiesgoclienteReturnGeneral =new TipoRiesgoClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiporiesgoclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tiporiesgoclienteReturnGeneral;
	}
	
	
	public void deepLoad(TipoRiesgoCliente tiporiesgocliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoRiesgoClienteLogicAdditional.updateTipoRiesgoClienteToGet(tiporiesgocliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporiesgocliente.setEmpresa(tiporiesgoclienteDataAccess.getEmpresa(connexion,tiporiesgocliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiporiesgocliente.setEmpresa(tiporiesgoclienteDataAccess.getEmpresa(connexion,tiporiesgocliente));
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
			tiporiesgocliente.setEmpresa(tiporiesgoclienteDataAccess.getEmpresa(connexion,tiporiesgocliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporiesgocliente.setEmpresa(tiporiesgoclienteDataAccess.getEmpresa(connexion,tiporiesgocliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiporiesgocliente.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiporiesgocliente.setEmpresa(tiporiesgoclienteDataAccess.getEmpresa(connexion,tiporiesgocliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tiporiesgocliente.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tiporiesgocliente.setEmpresa(tiporiesgoclienteDataAccess.getEmpresa(connexion,tiporiesgocliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tiporiesgocliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoRiesgoCliente tiporiesgocliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoRiesgoClienteLogicAdditional.updateTipoRiesgoClienteToSave(tiporiesgocliente,this.arrDatoGeneral);
			
TipoRiesgoClienteDataAccess.save(tiporiesgocliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiporiesgocliente.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiporiesgocliente.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiporiesgocliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiporiesgocliente.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiporiesgocliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tiporiesgocliente.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoRiesgoCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiporiesgocliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(tiporiesgocliente);
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
			this.deepLoad(this.tiporiesgocliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoRiesgoCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiporiesgoclientes!=null) {
				for(TipoRiesgoCliente tiporiesgocliente:tiporiesgoclientes) {
					this.deepLoad(tiporiesgocliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(tiporiesgoclientes);
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
			if(tiporiesgoclientes!=null) {
				for(TipoRiesgoCliente tiporiesgocliente:tiporiesgoclientes) {
					this.deepLoad(tiporiesgocliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(tiporiesgoclientes);
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
			this.getNewConnexionToDeep(TipoRiesgoCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiporiesgocliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoRiesgoCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiporiesgoclientes!=null) {
				for(TipoRiesgoCliente tiporiesgocliente:tiporiesgoclientes) {
					this.deepSave(tiporiesgocliente,isDeep,deepLoadType,clases);
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
			if(tiporiesgoclientes!=null) {
				for(TipoRiesgoCliente tiporiesgocliente:tiporiesgoclientes) {
					this.deepSave(tiporiesgocliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoRiesgoClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRiesgoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoRiesgoClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporiesgoclientes=tiporiesgoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRiesgoClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoRiesgoClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoRiesgoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporiesgoclientes=tiporiesgoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRiesgoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoRiesgoCliente(this.tiporiesgoclientes);
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
			if(TipoRiesgoClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRiesgoClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoRiesgoCliente tiporiesgocliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoRiesgoClienteConstantesFunciones.ISCONAUDITORIA) {
				if(tiporiesgocliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRiesgoClienteDataAccess.TABLENAME, tiporiesgocliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRiesgoClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRiesgoClienteLogic.registrarAuditoriaDetallesTipoRiesgoCliente(connexion,tiporiesgocliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiporiesgocliente.getIsDeleted()) {
					/*if(!tiporiesgocliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoRiesgoClienteDataAccess.TABLENAME, tiporiesgocliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoRiesgoClienteLogic.registrarAuditoriaDetallesTipoRiesgoCliente(connexion,tiporiesgocliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRiesgoClienteDataAccess.TABLENAME, tiporiesgocliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiporiesgocliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRiesgoClienteDataAccess.TABLENAME, tiporiesgocliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRiesgoClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRiesgoClienteLogic.registrarAuditoriaDetallesTipoRiesgoCliente(connexion,tiporiesgocliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoRiesgoCliente(Connexion connexion,TipoRiesgoCliente tiporiesgocliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiporiesgocliente.getIsNew()||!tiporiesgocliente.getid_empresa().equals(tiporiesgocliente.getTipoRiesgoClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporiesgocliente.getTipoRiesgoClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=tiporiesgocliente.getTipoRiesgoClienteOriginal().getid_empresa().toString();
				}
				if(tiporiesgocliente.getid_empresa()!=null)
				{
					strValorNuevo=tiporiesgocliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRiesgoClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tiporiesgocliente.getIsNew()||!tiporiesgocliente.getnombre().equals(tiporiesgocliente.getTipoRiesgoClienteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporiesgocliente.getTipoRiesgoClienteOriginal().getnombre()!=null)
				{
					strValorActual=tiporiesgocliente.getTipoRiesgoClienteOriginal().getnombre();
				}
				if(tiporiesgocliente.getnombre()!=null)
				{
					strValorNuevo=tiporiesgocliente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRiesgoClienteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoRiesgoClienteRelacionesWithConnection(TipoRiesgoCliente tiporiesgocliente) throws Exception {

		if(!tiporiesgocliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRiesgoClienteRelacionesBase(tiporiesgocliente,true);
		}
	}

	public void saveTipoRiesgoClienteRelaciones(TipoRiesgoCliente tiporiesgocliente)throws Exception {

		if(!tiporiesgocliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRiesgoClienteRelacionesBase(tiporiesgocliente,false);
		}
	}

	public void saveTipoRiesgoClienteRelacionesBase(TipoRiesgoCliente tiporiesgocliente,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoRiesgoCliente-saveRelacionesWithConnection");}
	

			this.setTipoRiesgoCliente(tiporiesgocliente);

			if(TipoRiesgoClienteLogicAdditional.validarSaveRelaciones(tiporiesgocliente,this)) {

				TipoRiesgoClienteLogicAdditional.updateRelacionesToSave(tiporiesgocliente,this);

				if((tiporiesgocliente.getIsNew()||tiporiesgocliente.getIsChanged())&&!tiporiesgocliente.getIsDeleted()) {
					this.saveTipoRiesgoCliente();
					this.saveTipoRiesgoClienteRelacionesDetalles();

				} else if(tiporiesgocliente.getIsDeleted()) {
					this.saveTipoRiesgoClienteRelacionesDetalles();
					this.saveTipoRiesgoCliente();
				}

				TipoRiesgoClienteLogicAdditional.updateRelacionesToSaveAfter(tiporiesgocliente,this);

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
	
	
	private void saveTipoRiesgoClienteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRiesgoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRiesgoClienteConstantesFunciones.getClassesForeignKeysOfTipoRiesgoCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRiesgoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRiesgoClienteConstantesFunciones.getClassesRelationshipsOfTipoRiesgoCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

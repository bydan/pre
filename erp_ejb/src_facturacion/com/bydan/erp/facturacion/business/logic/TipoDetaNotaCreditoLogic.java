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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.TipoDetaNotaCreditoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoDetaNotaCreditoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoDetaNotaCreditoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoDetaNotaCredito;
import com.bydan.erp.facturacion.business.logic.TipoDetaNotaCreditoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoDetaNotaCreditoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoDetaNotaCreditoLogic.class);
	
	protected TipoDetaNotaCreditoDataAccess tipodetanotacreditoDataAccess; 	
	protected TipoDetaNotaCredito tipodetanotacredito;
	protected List<TipoDetaNotaCredito> tipodetanotacreditos;
	protected Object tipodetanotacreditoObject;	
	protected List<Object> tipodetanotacreditosObject;
	
	public static ClassValidator<TipoDetaNotaCredito> tipodetanotacreditoValidator = new ClassValidator<TipoDetaNotaCredito>(TipoDetaNotaCredito.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoDetaNotaCreditoLogicAdditional tipodetanotacreditoLogicAdditional=null;
	
	public TipoDetaNotaCreditoLogicAdditional getTipoDetaNotaCreditoLogicAdditional() {
		return this.tipodetanotacreditoLogicAdditional;
	}
	
	public void setTipoDetaNotaCreditoLogicAdditional(TipoDetaNotaCreditoLogicAdditional tipodetanotacreditoLogicAdditional) {
		try {
			this.tipodetanotacreditoLogicAdditional=tipodetanotacreditoLogicAdditional;
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
	
	
	
	
	public  TipoDetaNotaCreditoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipodetanotacreditoDataAccess = new TipoDetaNotaCreditoDataAccess();
			
			this.tipodetanotacreditos= new ArrayList<TipoDetaNotaCredito>();
			this.tipodetanotacredito= new TipoDetaNotaCredito();
			
			this.tipodetanotacreditoObject=new Object();
			this.tipodetanotacreditosObject=new ArrayList<Object>();
				
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
			
			this.tipodetanotacreditoDataAccess.setConnexionType(this.connexionType);
			this.tipodetanotacreditoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoDetaNotaCreditoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipodetanotacreditoDataAccess = new TipoDetaNotaCreditoDataAccess();
			this.tipodetanotacreditos= new ArrayList<TipoDetaNotaCredito>();
			this.tipodetanotacredito= new TipoDetaNotaCredito();
			this.tipodetanotacreditoObject=new Object();
			this.tipodetanotacreditosObject=new ArrayList<Object>();
			
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
			
			this.tipodetanotacreditoDataAccess.setConnexionType(this.connexionType);
			this.tipodetanotacreditoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoDetaNotaCredito getTipoDetaNotaCredito() throws Exception {	
		TipoDetaNotaCreditoLogicAdditional.checkTipoDetaNotaCreditoToGet(tipodetanotacredito,this.datosCliente,this.arrDatoGeneral);
		TipoDetaNotaCreditoLogicAdditional.updateTipoDetaNotaCreditoToGet(tipodetanotacredito,this.arrDatoGeneral);
		
		return tipodetanotacredito;
	}
		
	public void setTipoDetaNotaCredito(TipoDetaNotaCredito newTipoDetaNotaCredito) {
		this.tipodetanotacredito = newTipoDetaNotaCredito;
	}
	
	public TipoDetaNotaCreditoDataAccess getTipoDetaNotaCreditoDataAccess() {
		return tipodetanotacreditoDataAccess;
	}
	
	public void setTipoDetaNotaCreditoDataAccess(TipoDetaNotaCreditoDataAccess newtipodetanotacreditoDataAccess) {
		this.tipodetanotacreditoDataAccess = newtipodetanotacreditoDataAccess;
	}
	
	public List<TipoDetaNotaCredito> getTipoDetaNotaCreditos() throws Exception {		
		this.quitarTipoDetaNotaCreditosNulos();
		
		TipoDetaNotaCreditoLogicAdditional.checkTipoDetaNotaCreditoToGets(tipodetanotacreditos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoDetaNotaCredito tipodetanotacreditoLocal: tipodetanotacreditos ) {
			TipoDetaNotaCreditoLogicAdditional.updateTipoDetaNotaCreditoToGet(tipodetanotacreditoLocal,this.arrDatoGeneral);
		}
		
		return tipodetanotacreditos;
	}
	
	public void setTipoDetaNotaCreditos(List<TipoDetaNotaCredito> newTipoDetaNotaCreditos) {
		this.tipodetanotacreditos = newTipoDetaNotaCreditos;
	}
	
	public Object getTipoDetaNotaCreditoObject() {	
		this.tipodetanotacreditoObject=this.tipodetanotacreditoDataAccess.getEntityObject();
		return this.tipodetanotacreditoObject;
	}
		
	public void setTipoDetaNotaCreditoObject(Object newTipoDetaNotaCreditoObject) {
		this.tipodetanotacreditoObject = newTipoDetaNotaCreditoObject;
	}
	
	public List<Object> getTipoDetaNotaCreditosObject() {		
		this.tipodetanotacreditosObject=this.tipodetanotacreditoDataAccess.getEntitiesObject();
		return this.tipodetanotacreditosObject;
	}
		
	public void setTipoDetaNotaCreditosObject(List<Object> newTipoDetaNotaCreditosObject) {
		this.tipodetanotacreditosObject = newTipoDetaNotaCreditosObject;
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
		
		if(this.tipodetanotacreditoDataAccess!=null) {
			this.tipodetanotacreditoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipodetanotacreditoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipodetanotacreditoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipodetanotacredito = new  TipoDetaNotaCredito();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodetanotacredito=tipodetanotacreditoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodetanotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacredito);
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
		tipodetanotacredito = new  TipoDetaNotaCredito();
		  		  
        try {
			
			tipodetanotacredito=tipodetanotacreditoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodetanotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipodetanotacredito = new  TipoDetaNotaCredito();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodetanotacredito=tipodetanotacreditoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodetanotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacredito);
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
		tipodetanotacredito = new  TipoDetaNotaCredito();
		  		  
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
		tipodetanotacredito = new  TipoDetaNotaCredito();
		  		  
        try {
			
			tipodetanotacredito=tipodetanotacreditoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodetanotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipodetanotacredito = new  TipoDetaNotaCredito();
		  		  
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
		tipodetanotacredito = new  TipoDetaNotaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipodetanotacreditoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodetanotacredito = new  TipoDetaNotaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipodetanotacreditoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodetanotacredito = new  TipoDetaNotaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipodetanotacreditoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodetanotacredito = new  TipoDetaNotaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipodetanotacreditoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodetanotacredito = new  TipoDetaNotaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipodetanotacreditoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodetanotacredito = new  TipoDetaNotaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipodetanotacreditoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodetanotacreditos = new  ArrayList<TipoDetaNotaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetaNotaCredito(tipodetanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
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
		tipodetanotacreditos = new  ArrayList<TipoDetaNotaCredito>();
		  		  
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
		tipodetanotacreditos = new  ArrayList<TipoDetaNotaCredito>();
		  		  
        try {			
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoDetaNotaCredito(tipodetanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipodetanotacreditos = new  ArrayList<TipoDetaNotaCredito>();
		  		  
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
		tipodetanotacreditos = new  ArrayList<TipoDetaNotaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetaNotaCredito(tipodetanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
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
		tipodetanotacreditos = new  ArrayList<TipoDetaNotaCredito>();
		  		  
        try {
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetaNotaCredito(tipodetanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
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
		tipodetanotacreditos = new  ArrayList<TipoDetaNotaCredito>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDetaNotaCredito(tipodetanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
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
		tipodetanotacreditos = new  ArrayList<TipoDetaNotaCredito>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDetaNotaCredito(tipodetanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipodetanotacredito = new  TipoDetaNotaCredito();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetanotacredito=tipodetanotacreditoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDetaNotaCredito(tipodetanotacredito);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacredito);
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
		tipodetanotacredito = new  TipoDetaNotaCredito();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetanotacredito=tipodetanotacreditoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDetaNotaCredito(tipodetanotacredito);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodetanotacreditos = new  ArrayList<TipoDetaNotaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetaNotaCredito(tipodetanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
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
		tipodetanotacreditos = new  ArrayList<TipoDetaNotaCredito>();
		  		  
        try {
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetaNotaCredito(tipodetanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoDetaNotaCreditosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipodetanotacreditos = new  ArrayList<TipoDetaNotaCredito>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getTodosTipoDetaNotaCreditosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDetaNotaCredito(tipodetanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
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
	
	public  void  getTodosTipoDetaNotaCreditos(String sFinalQuery,Pagination pagination)throws Exception {
		tipodetanotacreditos = new  ArrayList<TipoDetaNotaCredito>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDetaNotaCredito(tipodetanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoDetaNotaCredito(TipoDetaNotaCredito tipodetanotacredito) throws Exception {
		Boolean estaValidado=false;
		
		if(tipodetanotacredito.getIsNew() || tipodetanotacredito.getIsChanged()) { 
			this.invalidValues = tipodetanotacreditoValidator.getInvalidValues(tipodetanotacredito);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipodetanotacredito);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoDetaNotaCredito(List<TipoDetaNotaCredito> TipoDetaNotaCreditos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoDetaNotaCredito tipodetanotacreditoLocal:tipodetanotacreditos) {				
			estaValidadoObjeto=this.validarGuardarTipoDetaNotaCredito(tipodetanotacreditoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoDetaNotaCredito(List<TipoDetaNotaCredito> TipoDetaNotaCreditos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDetaNotaCredito(tipodetanotacreditos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoDetaNotaCredito(TipoDetaNotaCredito TipoDetaNotaCredito) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDetaNotaCredito(tipodetanotacredito)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoDetaNotaCredito tipodetanotacredito) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipodetanotacredito.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoDetaNotaCreditoConstantesFunciones.getTipoDetaNotaCreditoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipodetanotacredito","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoDetaNotaCreditoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoDetaNotaCreditoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoDetaNotaCreditoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-saveTipoDetaNotaCreditoWithConnection");connexion.begin();			
			
			TipoDetaNotaCreditoLogicAdditional.checkTipoDetaNotaCreditoToSave(this.tipodetanotacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDetaNotaCreditoLogicAdditional.updateTipoDetaNotaCreditoToSave(this.tipodetanotacredito,this.arrDatoGeneral);
			
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodetanotacredito,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoDetaNotaCredito();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDetaNotaCredito(this.tipodetanotacredito)) {
				TipoDetaNotaCreditoDataAccess.save(this.tipodetanotacredito, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipodetanotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDetaNotaCreditoLogicAdditional.checkTipoDetaNotaCreditoToSaveAfter(this.tipodetanotacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDetaNotaCredito();
			
			connexion.commit();			
			
			if(this.tipodetanotacredito.getIsDeleted()) {
				this.tipodetanotacredito=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoDetaNotaCredito()throws Exception {	
		try {	
			
			TipoDetaNotaCreditoLogicAdditional.checkTipoDetaNotaCreditoToSave(this.tipodetanotacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDetaNotaCreditoLogicAdditional.updateTipoDetaNotaCreditoToSave(this.tipodetanotacredito,this.arrDatoGeneral);
			
			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodetanotacredito,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDetaNotaCredito(this.tipodetanotacredito)) {			
				TipoDetaNotaCreditoDataAccess.save(this.tipodetanotacredito, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipodetanotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDetaNotaCreditoLogicAdditional.checkTipoDetaNotaCreditoToSaveAfter(this.tipodetanotacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipodetanotacredito.getIsDeleted()) {
				this.tipodetanotacredito=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoDetaNotaCreditosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-saveTipoDetaNotaCreditosWithConnection");connexion.begin();			
			
			TipoDetaNotaCreditoLogicAdditional.checkTipoDetaNotaCreditoToSaves(tipodetanotacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoDetaNotaCreditos();
			
			Boolean validadoTodosTipoDetaNotaCredito=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDetaNotaCredito tipodetanotacreditoLocal:tipodetanotacreditos) {		
				if(tipodetanotacreditoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDetaNotaCreditoLogicAdditional.updateTipoDetaNotaCreditoToSave(tipodetanotacreditoLocal,this.arrDatoGeneral);
	        	
				TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodetanotacreditoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDetaNotaCredito(tipodetanotacreditoLocal)) {
					TipoDetaNotaCreditoDataAccess.save(tipodetanotacreditoLocal, connexion);				
				} else {
					validadoTodosTipoDetaNotaCredito=false;
				}
			}
			
			if(!validadoTodosTipoDetaNotaCredito) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDetaNotaCreditoLogicAdditional.checkTipoDetaNotaCreditoToSavesAfter(tipodetanotacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDetaNotaCreditos();
			
			connexion.commit();		
			
			this.quitarTipoDetaNotaCreditosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoDetaNotaCreditos()throws Exception {				
		 try {	
			TipoDetaNotaCreditoLogicAdditional.checkTipoDetaNotaCreditoToSaves(tipodetanotacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoDetaNotaCredito=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDetaNotaCredito tipodetanotacreditoLocal:tipodetanotacreditos) {				
				if(tipodetanotacreditoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDetaNotaCreditoLogicAdditional.updateTipoDetaNotaCreditoToSave(tipodetanotacreditoLocal,this.arrDatoGeneral);
	        	
				TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodetanotacreditoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDetaNotaCredito(tipodetanotacreditoLocal)) {				
					TipoDetaNotaCreditoDataAccess.save(tipodetanotacreditoLocal, connexion);				
				} else {
					validadoTodosTipoDetaNotaCredito=false;
				}
			}
			
			if(!validadoTodosTipoDetaNotaCredito) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDetaNotaCreditoLogicAdditional.checkTipoDetaNotaCreditoToSavesAfter(tipodetanotacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoDetaNotaCreditosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDetaNotaCreditoParameterReturnGeneral procesarAccionTipoDetaNotaCreditos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDetaNotaCredito> tipodetanotacreditos,TipoDetaNotaCreditoParameterReturnGeneral tipodetanotacreditoParameterGeneral)throws Exception {
		 try {	
			TipoDetaNotaCreditoParameterReturnGeneral tipodetanotacreditoReturnGeneral=new TipoDetaNotaCreditoParameterReturnGeneral();
	
			TipoDetaNotaCreditoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodetanotacreditos,tipodetanotacreditoParameterGeneral,tipodetanotacreditoReturnGeneral);
			
			return tipodetanotacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDetaNotaCreditoParameterReturnGeneral procesarAccionTipoDetaNotaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDetaNotaCredito> tipodetanotacreditos,TipoDetaNotaCreditoParameterReturnGeneral tipodetanotacreditoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-procesarAccionTipoDetaNotaCreditosWithConnection");connexion.begin();			
			
			TipoDetaNotaCreditoParameterReturnGeneral tipodetanotacreditoReturnGeneral=new TipoDetaNotaCreditoParameterReturnGeneral();
	
			TipoDetaNotaCreditoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodetanotacreditos,tipodetanotacreditoParameterGeneral,tipodetanotacreditoReturnGeneral);
			
			this.connexion.commit();
			
			return tipodetanotacreditoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDetaNotaCreditoParameterReturnGeneral procesarEventosTipoDetaNotaCreditos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDetaNotaCredito> tipodetanotacreditos,TipoDetaNotaCredito tipodetanotacredito,TipoDetaNotaCreditoParameterReturnGeneral tipodetanotacreditoParameterGeneral,Boolean isEsNuevoTipoDetaNotaCredito,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoDetaNotaCreditoParameterReturnGeneral tipodetanotacreditoReturnGeneral=new TipoDetaNotaCreditoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodetanotacreditoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDetaNotaCreditoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodetanotacreditos,tipodetanotacredito,tipodetanotacreditoParameterGeneral,tipodetanotacreditoReturnGeneral,isEsNuevoTipoDetaNotaCredito,clases);
			
			return tipodetanotacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoDetaNotaCreditoParameterReturnGeneral procesarEventosTipoDetaNotaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDetaNotaCredito> tipodetanotacreditos,TipoDetaNotaCredito tipodetanotacredito,TipoDetaNotaCreditoParameterReturnGeneral tipodetanotacreditoParameterGeneral,Boolean isEsNuevoTipoDetaNotaCredito,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-procesarEventosTipoDetaNotaCreditosWithConnection");connexion.begin();			
			
			TipoDetaNotaCreditoParameterReturnGeneral tipodetanotacreditoReturnGeneral=new TipoDetaNotaCreditoParameterReturnGeneral();
	
			tipodetanotacreditoReturnGeneral.setTipoDetaNotaCredito(tipodetanotacredito);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodetanotacreditoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDetaNotaCreditoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodetanotacreditos,tipodetanotacredito,tipodetanotacreditoParameterGeneral,tipodetanotacreditoReturnGeneral,isEsNuevoTipoDetaNotaCredito,clases);
			
			this.connexion.commit();
			
			return tipodetanotacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDetaNotaCreditoParameterReturnGeneral procesarImportacionTipoDetaNotaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoDetaNotaCreditoParameterReturnGeneral tipodetanotacreditoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-procesarImportacionTipoDetaNotaCreditosWithConnection");connexion.begin();			
			
			TipoDetaNotaCreditoParameterReturnGeneral tipodetanotacreditoReturnGeneral=new TipoDetaNotaCreditoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipodetanotacreditos=new ArrayList<TipoDetaNotaCredito>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipodetanotacredito=new TipoDetaNotaCredito();
				
				
				if(conColumnasBase) {this.tipodetanotacredito.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipodetanotacredito.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipodetanotacredito.setcodigo(arrColumnas[iColumn++]);
				this.tipodetanotacredito.setnombre(arrColumnas[iColumn++]);
				
				this.tipodetanotacreditos.add(this.tipodetanotacredito);
			}
			
			this.saveTipoDetaNotaCreditos();
			
			this.connexion.commit();
			
			tipodetanotacreditoReturnGeneral.setConRetornoEstaProcesado(true);
			tipodetanotacreditoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipodetanotacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoDetaNotaCreditosEliminados() throws Exception {				
		
		List<TipoDetaNotaCredito> tipodetanotacreditosAux= new ArrayList<TipoDetaNotaCredito>();
		
		for(TipoDetaNotaCredito tipodetanotacredito:tipodetanotacreditos) {
			if(!tipodetanotacredito.getIsDeleted()) {
				tipodetanotacreditosAux.add(tipodetanotacredito);
			}
		}
		
		tipodetanotacreditos=tipodetanotacreditosAux;
	}
	
	public void quitarTipoDetaNotaCreditosNulos() throws Exception {				
		
		List<TipoDetaNotaCredito> tipodetanotacreditosAux= new ArrayList<TipoDetaNotaCredito>();
		
		for(TipoDetaNotaCredito tipodetanotacredito : this.tipodetanotacreditos) {
			if(tipodetanotacredito==null) {
				tipodetanotacreditosAux.add(tipodetanotacredito);
			}
		}
		
		//this.tipodetanotacreditos=tipodetanotacreditosAux;
		
		this.tipodetanotacreditos.removeAll(tipodetanotacreditosAux);
	}
	
	public void getSetVersionRowTipoDetaNotaCreditoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipodetanotacredito.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipodetanotacredito.getIsDeleted() || (tipodetanotacredito.getIsChanged()&&!tipodetanotacredito.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipodetanotacreditoDataAccess.getSetVersionRowTipoDetaNotaCredito(connexion,tipodetanotacredito.getId());
				
				if(!tipodetanotacredito.getVersionRow().equals(timestamp)) {	
					tipodetanotacredito.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipodetanotacredito.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoDetaNotaCredito()throws Exception {	
		
		if(tipodetanotacredito.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipodetanotacredito.getIsDeleted() || (tipodetanotacredito.getIsChanged()&&!tipodetanotacredito.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipodetanotacreditoDataAccess.getSetVersionRowTipoDetaNotaCredito(connexion,tipodetanotacredito.getId());
			
			try {							
				if(!tipodetanotacredito.getVersionRow().equals(timestamp)) {	
					tipodetanotacredito.setVersionRow(timestamp);
				}
				
				tipodetanotacredito.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoDetaNotaCreditosWithConnection()throws Exception {	
		if(tipodetanotacreditos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoDetaNotaCredito tipodetanotacreditoAux:tipodetanotacreditos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipodetanotacreditoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodetanotacreditoAux.getIsDeleted() || (tipodetanotacreditoAux.getIsChanged()&&!tipodetanotacreditoAux.getIsNew())) {
						
						timestamp=tipodetanotacreditoDataAccess.getSetVersionRowTipoDetaNotaCredito(connexion,tipodetanotacreditoAux.getId());
						
						if(!tipodetanotacredito.getVersionRow().equals(timestamp)) {	
							tipodetanotacreditoAux.setVersionRow(timestamp);
						}
								
						tipodetanotacreditoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoDetaNotaCreditos()throws Exception {	
		if(tipodetanotacreditos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoDetaNotaCredito tipodetanotacreditoAux:tipodetanotacreditos) {
					if(tipodetanotacreditoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodetanotacreditoAux.getIsDeleted() || (tipodetanotacreditoAux.getIsChanged()&&!tipodetanotacreditoAux.getIsNew())) {
						
						timestamp=tipodetanotacreditoDataAccess.getSetVersionRowTipoDetaNotaCredito(connexion,tipodetanotacreditoAux.getId());
						
						if(!tipodetanotacreditoAux.getVersionRow().equals(timestamp)) {	
							tipodetanotacreditoAux.setVersionRow(timestamp);
						}
						
													
						tipodetanotacreditoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoDetaNotaCreditoParameterReturnGeneral cargarCombosLoteForeignKeyTipoDetaNotaCreditoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoDetaNotaCreditoParameterReturnGeneral  tipodetanotacreditoReturnGeneral =new TipoDetaNotaCreditoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoDetaNotaCreditoWithConnection");connexion.begin();
			
			tipodetanotacreditoReturnGeneral =new TipoDetaNotaCreditoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodetanotacreditoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipodetanotacreditoReturnGeneral;
	}
	
	public TipoDetaNotaCreditoParameterReturnGeneral cargarCombosLoteForeignKeyTipoDetaNotaCredito(String finalQueryGlobalEmpresa) throws Exception {
		TipoDetaNotaCreditoParameterReturnGeneral  tipodetanotacreditoReturnGeneral =new TipoDetaNotaCreditoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipodetanotacreditoReturnGeneral =new TipoDetaNotaCreditoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodetanotacreditoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipodetanotacreditoReturnGeneral;
	}
	
	
	public void deepLoad(TipoDetaNotaCredito tipodetanotacredito,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoDetaNotaCreditoLogicAdditional.updateTipoDetaNotaCreditoToGet(tipodetanotacredito,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodetanotacredito.setEmpresa(tipodetanotacreditoDataAccess.getEmpresa(connexion,tipodetanotacredito));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodetanotacredito.setEmpresa(tipodetanotacreditoDataAccess.getEmpresa(connexion,tipodetanotacredito));
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
			tipodetanotacredito.setEmpresa(tipodetanotacreditoDataAccess.getEmpresa(connexion,tipodetanotacredito));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodetanotacredito.setEmpresa(tipodetanotacreditoDataAccess.getEmpresa(connexion,tipodetanotacredito));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodetanotacredito.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodetanotacredito.setEmpresa(tipodetanotacreditoDataAccess.getEmpresa(connexion,tipodetanotacredito));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipodetanotacredito.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tipodetanotacredito.setEmpresa(tipodetanotacreditoDataAccess.getEmpresa(connexion,tipodetanotacredito));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipodetanotacredito.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoDetaNotaCredito tipodetanotacredito,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoDetaNotaCreditoLogicAdditional.updateTipoDetaNotaCreditoToSave(tipodetanotacredito,this.arrDatoGeneral);
			
TipoDetaNotaCreditoDataAccess.save(tipodetanotacredito, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipodetanotacredito.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipodetanotacredito.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipodetanotacredito.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodetanotacredito.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipodetanotacredito.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipodetanotacredito.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoDetaNotaCredito.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipodetanotacredito,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(tipodetanotacredito);
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
			this.deepLoad(this.tipodetanotacredito,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDetaNotaCredito.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipodetanotacreditos!=null) {
				for(TipoDetaNotaCredito tipodetanotacredito:tipodetanotacreditos) {
					this.deepLoad(tipodetanotacredito,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(tipodetanotacreditos);
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
			if(tipodetanotacreditos!=null) {
				for(TipoDetaNotaCredito tipodetanotacredito:tipodetanotacreditos) {
					this.deepLoad(tipodetanotacredito,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(tipodetanotacreditos);
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
			this.getNewConnexionToDeep(TipoDetaNotaCredito.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipodetanotacredito,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoDetaNotaCredito.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipodetanotacreditos!=null) {
				for(TipoDetaNotaCredito tipodetanotacredito:tipodetanotacreditos) {
					this.deepSave(tipodetanotacredito,isDeep,deepLoadType,clases);
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
			if(tipodetanotacreditos!=null) {
				for(TipoDetaNotaCredito tipodetanotacredito:tipodetanotacreditos) {
					this.deepSave(tipodetanotacredito,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoDetaNotaCreditosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoDetaNotaCreditoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDetaNotaCreditosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoDetaNotaCreditoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDetaNotaCreditosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoDetaNotaCreditoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDetaNotaCreditosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoDetaNotaCreditoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDetaNotaCreditosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDetaNotaCreditosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodetanotacreditos=tipodetanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetaNotaCredito(this.tipodetanotacreditos);
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
			if(TipoDetaNotaCreditoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDetaNotaCreditoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoDetaNotaCredito tipodetanotacredito,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoDetaNotaCreditoConstantesFunciones.ISCONAUDITORIA) {
				if(tipodetanotacredito.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDetaNotaCreditoDataAccess.TABLENAME, tipodetanotacredito.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDetaNotaCreditoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDetaNotaCreditoLogic.registrarAuditoriaDetallesTipoDetaNotaCredito(connexion,tipodetanotacredito,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipodetanotacredito.getIsDeleted()) {
					/*if(!tipodetanotacredito.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoDetaNotaCreditoDataAccess.TABLENAME, tipodetanotacredito.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoDetaNotaCreditoLogic.registrarAuditoriaDetallesTipoDetaNotaCredito(connexion,tipodetanotacredito,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDetaNotaCreditoDataAccess.TABLENAME, tipodetanotacredito.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipodetanotacredito.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDetaNotaCreditoDataAccess.TABLENAME, tipodetanotacredito.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDetaNotaCreditoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDetaNotaCreditoLogic.registrarAuditoriaDetallesTipoDetaNotaCredito(connexion,tipodetanotacredito,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoDetaNotaCredito(Connexion connexion,TipoDetaNotaCredito tipodetanotacredito)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipodetanotacredito.getIsNew()||!tipodetanotacredito.getid_empresa().equals(tipodetanotacredito.getTipoDetaNotaCreditoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodetanotacredito.getTipoDetaNotaCreditoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipodetanotacredito.getTipoDetaNotaCreditoOriginal().getid_empresa().toString();
				}
				if(tipodetanotacredito.getid_empresa()!=null)
				{
					strValorNuevo=tipodetanotacredito.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipodetanotacredito.getIsNew()||!tipodetanotacredito.getcodigo().equals(tipodetanotacredito.getTipoDetaNotaCreditoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodetanotacredito.getTipoDetaNotaCreditoOriginal().getcodigo()!=null)
				{
					strValorActual=tipodetanotacredito.getTipoDetaNotaCreditoOriginal().getcodigo();
				}
				if(tipodetanotacredito.getcodigo()!=null)
				{
					strValorNuevo=tipodetanotacredito.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDetaNotaCreditoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipodetanotacredito.getIsNew()||!tipodetanotacredito.getnombre().equals(tipodetanotacredito.getTipoDetaNotaCreditoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodetanotacredito.getTipoDetaNotaCreditoOriginal().getnombre()!=null)
				{
					strValorActual=tipodetanotacredito.getTipoDetaNotaCreditoOriginal().getnombre();
				}
				if(tipodetanotacredito.getnombre()!=null)
				{
					strValorNuevo=tipodetanotacredito.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDetaNotaCreditoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoDetaNotaCreditoRelacionesWithConnection(TipoDetaNotaCredito tipodetanotacredito) throws Exception {

		if(!tipodetanotacredito.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDetaNotaCreditoRelacionesBase(tipodetanotacredito,true);
		}
	}

	public void saveTipoDetaNotaCreditoRelaciones(TipoDetaNotaCredito tipodetanotacredito)throws Exception {

		if(!tipodetanotacredito.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDetaNotaCreditoRelacionesBase(tipodetanotacredito,false);
		}
	}

	public void saveTipoDetaNotaCreditoRelacionesBase(TipoDetaNotaCredito tipodetanotacredito,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoDetaNotaCredito-saveRelacionesWithConnection");}
	

			this.setTipoDetaNotaCredito(tipodetanotacredito);

			if(TipoDetaNotaCreditoLogicAdditional.validarSaveRelaciones(tipodetanotacredito,this)) {

				TipoDetaNotaCreditoLogicAdditional.updateRelacionesToSave(tipodetanotacredito,this);

				if((tipodetanotacredito.getIsNew()||tipodetanotacredito.getIsChanged())&&!tipodetanotacredito.getIsDeleted()) {
					this.saveTipoDetaNotaCredito();
					this.saveTipoDetaNotaCreditoRelacionesDetalles();

				} else if(tipodetanotacredito.getIsDeleted()) {
					this.saveTipoDetaNotaCreditoRelacionesDetalles();
					this.saveTipoDetaNotaCredito();
				}

				TipoDetaNotaCreditoLogicAdditional.updateRelacionesToSaveAfter(tipodetanotacredito,this);

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
	
	
	private void saveTipoDetaNotaCreditoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDetaNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDetaNotaCreditoConstantesFunciones.getClassesForeignKeysOfTipoDetaNotaCredito(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDetaNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDetaNotaCreditoConstantesFunciones.getClassesRelationshipsOfTipoDetaNotaCredito(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

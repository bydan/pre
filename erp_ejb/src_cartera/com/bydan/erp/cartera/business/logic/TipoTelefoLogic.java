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
import com.bydan.erp.cartera.util.TipoTelefoConstantesFunciones;
import com.bydan.erp.cartera.util.TipoTelefoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoTelefoParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoTelefo;
import com.bydan.erp.cartera.business.logic.TipoTelefoLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoTelefoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoTelefoLogic.class);
	
	protected TipoTelefoDataAccess tipotelefoDataAccess; 	
	protected TipoTelefo tipotelefo;
	protected List<TipoTelefo> tipotelefos;
	protected Object tipotelefoObject;	
	protected List<Object> tipotelefosObject;
	
	public static ClassValidator<TipoTelefo> tipotelefoValidator = new ClassValidator<TipoTelefo>(TipoTelefo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoTelefoLogicAdditional tipotelefoLogicAdditional=null;
	
	public TipoTelefoLogicAdditional getTipoTelefoLogicAdditional() {
		return this.tipotelefoLogicAdditional;
	}
	
	public void setTipoTelefoLogicAdditional(TipoTelefoLogicAdditional tipotelefoLogicAdditional) {
		try {
			this.tipotelefoLogicAdditional=tipotelefoLogicAdditional;
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
	
	
	
	
	public  TipoTelefoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipotelefoDataAccess = new TipoTelefoDataAccess();
			
			this.tipotelefos= new ArrayList<TipoTelefo>();
			this.tipotelefo= new TipoTelefo();
			
			this.tipotelefoObject=new Object();
			this.tipotelefosObject=new ArrayList<Object>();
				
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
			
			this.tipotelefoDataAccess.setConnexionType(this.connexionType);
			this.tipotelefoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoTelefoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipotelefoDataAccess = new TipoTelefoDataAccess();
			this.tipotelefos= new ArrayList<TipoTelefo>();
			this.tipotelefo= new TipoTelefo();
			this.tipotelefoObject=new Object();
			this.tipotelefosObject=new ArrayList<Object>();
			
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
			
			this.tipotelefoDataAccess.setConnexionType(this.connexionType);
			this.tipotelefoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoTelefo getTipoTelefo() throws Exception {	
		TipoTelefoLogicAdditional.checkTipoTelefoToGet(tipotelefo,this.datosCliente,this.arrDatoGeneral);
		TipoTelefoLogicAdditional.updateTipoTelefoToGet(tipotelefo,this.arrDatoGeneral);
		
		return tipotelefo;
	}
		
	public void setTipoTelefo(TipoTelefo newTipoTelefo) {
		this.tipotelefo = newTipoTelefo;
	}
	
	public TipoTelefoDataAccess getTipoTelefoDataAccess() {
		return tipotelefoDataAccess;
	}
	
	public void setTipoTelefoDataAccess(TipoTelefoDataAccess newtipotelefoDataAccess) {
		this.tipotelefoDataAccess = newtipotelefoDataAccess;
	}
	
	public List<TipoTelefo> getTipoTelefos() throws Exception {		
		this.quitarTipoTelefosNulos();
		
		TipoTelefoLogicAdditional.checkTipoTelefoToGets(tipotelefos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoTelefo tipotelefoLocal: tipotelefos ) {
			TipoTelefoLogicAdditional.updateTipoTelefoToGet(tipotelefoLocal,this.arrDatoGeneral);
		}
		
		return tipotelefos;
	}
	
	public void setTipoTelefos(List<TipoTelefo> newTipoTelefos) {
		this.tipotelefos = newTipoTelefos;
	}
	
	public Object getTipoTelefoObject() {	
		this.tipotelefoObject=this.tipotelefoDataAccess.getEntityObject();
		return this.tipotelefoObject;
	}
		
	public void setTipoTelefoObject(Object newTipoTelefoObject) {
		this.tipotelefoObject = newTipoTelefoObject;
	}
	
	public List<Object> getTipoTelefosObject() {		
		this.tipotelefosObject=this.tipotelefoDataAccess.getEntitiesObject();
		return this.tipotelefosObject;
	}
		
	public void setTipoTelefosObject(List<Object> newTipoTelefosObject) {
		this.tipotelefosObject = newTipoTelefosObject;
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
		
		if(this.tipotelefoDataAccess!=null) {
			this.tipotelefoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipotelefoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipotelefoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipotelefo = new  TipoTelefo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipotelefo=tipotelefoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotelefo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefo);
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
		tipotelefo = new  TipoTelefo();
		  		  
        try {
			
			tipotelefo=tipotelefoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotelefo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipotelefo = new  TipoTelefo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipotelefo=tipotelefoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotelefo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefo);
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
		tipotelefo = new  TipoTelefo();
		  		  
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
		tipotelefo = new  TipoTelefo();
		  		  
        try {
			
			tipotelefo=tipotelefoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotelefo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipotelefo = new  TipoTelefo();
		  		  
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
		tipotelefo = new  TipoTelefo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipotelefoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipotelefo = new  TipoTelefo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipotelefoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipotelefo = new  TipoTelefo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipotelefoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipotelefo = new  TipoTelefo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipotelefoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipotelefo = new  TipoTelefo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipotelefoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipotelefo = new  TipoTelefo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipotelefoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipotelefos = new  ArrayList<TipoTelefo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotelefos=tipotelefoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTelefo(tipotelefos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefos);
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
		tipotelefos = new  ArrayList<TipoTelefo>();
		  		  
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
		tipotelefos = new  ArrayList<TipoTelefo>();
		  		  
        try {			
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotelefos=tipotelefoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoTelefo(tipotelefos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipotelefos = new  ArrayList<TipoTelefo>();
		  		  
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
		tipotelefos = new  ArrayList<TipoTelefo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotelefos=tipotelefoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTelefo(tipotelefos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefos);
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
		tipotelefos = new  ArrayList<TipoTelefo>();
		  		  
        try {
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotelefos=tipotelefoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTelefo(tipotelefos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefos);
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
		tipotelefos = new  ArrayList<TipoTelefo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotelefos=tipotelefoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTelefo(tipotelefos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefos);
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
		tipotelefos = new  ArrayList<TipoTelefo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotelefos=tipotelefoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTelefo(tipotelefos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipotelefo = new  TipoTelefo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotelefo=tipotelefoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTelefo(tipotelefo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefo);
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
		tipotelefo = new  TipoTelefo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotelefo=tipotelefoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTelefo(tipotelefo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipotelefos = new  ArrayList<TipoTelefo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotelefos=tipotelefoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTelefo(tipotelefos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefos);
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
		tipotelefos = new  ArrayList<TipoTelefo>();
		  		  
        try {
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotelefos=tipotelefoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTelefo(tipotelefos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoTelefosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipotelefos = new  ArrayList<TipoTelefo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-getTodosTipoTelefosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotelefos=tipotelefoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoTelefo(tipotelefos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefos);
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
	
	public  void  getTodosTipoTelefos(String sFinalQuery,Pagination pagination)throws Exception {
		tipotelefos = new  ArrayList<TipoTelefo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotelefos=tipotelefoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoTelefo(tipotelefos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoTelefo(TipoTelefo tipotelefo) throws Exception {
		Boolean estaValidado=false;
		
		if(tipotelefo.getIsNew() || tipotelefo.getIsChanged()) { 
			this.invalidValues = tipotelefoValidator.getInvalidValues(tipotelefo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipotelefo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoTelefo(List<TipoTelefo> TipoTelefos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoTelefo tipotelefoLocal:tipotelefos) {				
			estaValidadoObjeto=this.validarGuardarTipoTelefo(tipotelefoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoTelefo(List<TipoTelefo> TipoTelefos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoTelefo(tipotelefos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoTelefo(TipoTelefo TipoTelefo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoTelefo(tipotelefo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoTelefo tipotelefo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipotelefo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoTelefoConstantesFunciones.getTipoTelefoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipotelefo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoTelefoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoTelefoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoTelefoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-saveTipoTelefoWithConnection");connexion.begin();			
			
			TipoTelefoLogicAdditional.checkTipoTelefoToSave(this.tipotelefo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoTelefoLogicAdditional.updateTipoTelefoToSave(this.tipotelefo,this.arrDatoGeneral);
			
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipotelefo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoTelefo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoTelefo(this.tipotelefo)) {
				TipoTelefoDataAccess.save(this.tipotelefo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipotelefo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoTelefoLogicAdditional.checkTipoTelefoToSaveAfter(this.tipotelefo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoTelefo();
			
			connexion.commit();			
			
			if(this.tipotelefo.getIsDeleted()) {
				this.tipotelefo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoTelefo()throws Exception {	
		try {	
			
			TipoTelefoLogicAdditional.checkTipoTelefoToSave(this.tipotelefo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoTelefoLogicAdditional.updateTipoTelefoToSave(this.tipotelefo,this.arrDatoGeneral);
			
			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipotelefo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoTelefo(this.tipotelefo)) {			
				TipoTelefoDataAccess.save(this.tipotelefo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipotelefo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoTelefoLogicAdditional.checkTipoTelefoToSaveAfter(this.tipotelefo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipotelefo.getIsDeleted()) {
				this.tipotelefo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoTelefosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-saveTipoTelefosWithConnection");connexion.begin();			
			
			TipoTelefoLogicAdditional.checkTipoTelefoToSaves(tipotelefos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoTelefos();
			
			Boolean validadoTodosTipoTelefo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoTelefo tipotelefoLocal:tipotelefos) {		
				if(tipotelefoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoTelefoLogicAdditional.updateTipoTelefoToSave(tipotelefoLocal,this.arrDatoGeneral);
	        	
				TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipotelefoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoTelefo(tipotelefoLocal)) {
					TipoTelefoDataAccess.save(tipotelefoLocal, connexion);				
				} else {
					validadoTodosTipoTelefo=false;
				}
			}
			
			if(!validadoTodosTipoTelefo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoTelefoLogicAdditional.checkTipoTelefoToSavesAfter(tipotelefos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoTelefos();
			
			connexion.commit();		
			
			this.quitarTipoTelefosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoTelefos()throws Exception {				
		 try {	
			TipoTelefoLogicAdditional.checkTipoTelefoToSaves(tipotelefos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoTelefo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoTelefo tipotelefoLocal:tipotelefos) {				
				if(tipotelefoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoTelefoLogicAdditional.updateTipoTelefoToSave(tipotelefoLocal,this.arrDatoGeneral);
	        	
				TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipotelefoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoTelefo(tipotelefoLocal)) {				
					TipoTelefoDataAccess.save(tipotelefoLocal, connexion);				
				} else {
					validadoTodosTipoTelefo=false;
				}
			}
			
			if(!validadoTodosTipoTelefo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoTelefoLogicAdditional.checkTipoTelefoToSavesAfter(tipotelefos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoTelefosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoTelefoParameterReturnGeneral procesarAccionTipoTelefos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoTelefo> tipotelefos,TipoTelefoParameterReturnGeneral tipotelefoParameterGeneral)throws Exception {
		 try {	
			TipoTelefoParameterReturnGeneral tipotelefoReturnGeneral=new TipoTelefoParameterReturnGeneral();
	
			TipoTelefoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipotelefos,tipotelefoParameterGeneral,tipotelefoReturnGeneral);
			
			return tipotelefoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoTelefoParameterReturnGeneral procesarAccionTipoTelefosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoTelefo> tipotelefos,TipoTelefoParameterReturnGeneral tipotelefoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-procesarAccionTipoTelefosWithConnection");connexion.begin();			
			
			TipoTelefoParameterReturnGeneral tipotelefoReturnGeneral=new TipoTelefoParameterReturnGeneral();
	
			TipoTelefoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipotelefos,tipotelefoParameterGeneral,tipotelefoReturnGeneral);
			
			this.connexion.commit();
			
			return tipotelefoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoTelefoParameterReturnGeneral procesarEventosTipoTelefos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoTelefo> tipotelefos,TipoTelefo tipotelefo,TipoTelefoParameterReturnGeneral tipotelefoParameterGeneral,Boolean isEsNuevoTipoTelefo,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoTelefoParameterReturnGeneral tipotelefoReturnGeneral=new TipoTelefoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipotelefoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoTelefoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipotelefos,tipotelefo,tipotelefoParameterGeneral,tipotelefoReturnGeneral,isEsNuevoTipoTelefo,clases);
			
			return tipotelefoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoTelefoParameterReturnGeneral procesarEventosTipoTelefosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoTelefo> tipotelefos,TipoTelefo tipotelefo,TipoTelefoParameterReturnGeneral tipotelefoParameterGeneral,Boolean isEsNuevoTipoTelefo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-procesarEventosTipoTelefosWithConnection");connexion.begin();			
			
			TipoTelefoParameterReturnGeneral tipotelefoReturnGeneral=new TipoTelefoParameterReturnGeneral();
	
			tipotelefoReturnGeneral.setTipoTelefo(tipotelefo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipotelefoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoTelefoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipotelefos,tipotelefo,tipotelefoParameterGeneral,tipotelefoReturnGeneral,isEsNuevoTipoTelefo,clases);
			
			this.connexion.commit();
			
			return tipotelefoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoTelefoParameterReturnGeneral procesarImportacionTipoTelefosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoTelefoParameterReturnGeneral tipotelefoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-procesarImportacionTipoTelefosWithConnection");connexion.begin();			
			
			TipoTelefoParameterReturnGeneral tipotelefoReturnGeneral=new TipoTelefoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipotelefos=new ArrayList<TipoTelefo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipotelefo=new TipoTelefo();
				
				
				if(conColumnasBase) {this.tipotelefo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipotelefo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipotelefo.setcodigo(arrColumnas[iColumn++]);
				this.tipotelefo.setnombre(arrColumnas[iColumn++]);
				
				this.tipotelefos.add(this.tipotelefo);
			}
			
			this.saveTipoTelefos();
			
			this.connexion.commit();
			
			tipotelefoReturnGeneral.setConRetornoEstaProcesado(true);
			tipotelefoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipotelefoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoTelefosEliminados() throws Exception {				
		
		List<TipoTelefo> tipotelefosAux= new ArrayList<TipoTelefo>();
		
		for(TipoTelefo tipotelefo:tipotelefos) {
			if(!tipotelefo.getIsDeleted()) {
				tipotelefosAux.add(tipotelefo);
			}
		}
		
		tipotelefos=tipotelefosAux;
	}
	
	public void quitarTipoTelefosNulos() throws Exception {				
		
		List<TipoTelefo> tipotelefosAux= new ArrayList<TipoTelefo>();
		
		for(TipoTelefo tipotelefo : this.tipotelefos) {
			if(tipotelefo==null) {
				tipotelefosAux.add(tipotelefo);
			}
		}
		
		//this.tipotelefos=tipotelefosAux;
		
		this.tipotelefos.removeAll(tipotelefosAux);
	}
	
	public void getSetVersionRowTipoTelefoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipotelefo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipotelefo.getIsDeleted() || (tipotelefo.getIsChanged()&&!tipotelefo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipotelefoDataAccess.getSetVersionRowTipoTelefo(connexion,tipotelefo.getId());
				
				if(!tipotelefo.getVersionRow().equals(timestamp)) {	
					tipotelefo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipotelefo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoTelefo()throws Exception {	
		
		if(tipotelefo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipotelefo.getIsDeleted() || (tipotelefo.getIsChanged()&&!tipotelefo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipotelefoDataAccess.getSetVersionRowTipoTelefo(connexion,tipotelefo.getId());
			
			try {							
				if(!tipotelefo.getVersionRow().equals(timestamp)) {	
					tipotelefo.setVersionRow(timestamp);
				}
				
				tipotelefo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoTelefosWithConnection()throws Exception {	
		if(tipotelefos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoTelefo tipotelefoAux:tipotelefos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipotelefoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipotelefoAux.getIsDeleted() || (tipotelefoAux.getIsChanged()&&!tipotelefoAux.getIsNew())) {
						
						timestamp=tipotelefoDataAccess.getSetVersionRowTipoTelefo(connexion,tipotelefoAux.getId());
						
						if(!tipotelefo.getVersionRow().equals(timestamp)) {	
							tipotelefoAux.setVersionRow(timestamp);
						}
								
						tipotelefoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoTelefos()throws Exception {	
		if(tipotelefos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoTelefo tipotelefoAux:tipotelefos) {
					if(tipotelefoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipotelefoAux.getIsDeleted() || (tipotelefoAux.getIsChanged()&&!tipotelefoAux.getIsNew())) {
						
						timestamp=tipotelefoDataAccess.getSetVersionRowTipoTelefo(connexion,tipotelefoAux.getId());
						
						if(!tipotelefoAux.getVersionRow().equals(timestamp)) {	
							tipotelefoAux.setVersionRow(timestamp);
						}
						
													
						tipotelefoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoTelefoParameterReturnGeneral cargarCombosLoteForeignKeyTipoTelefoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoTelefoParameterReturnGeneral  tipotelefoReturnGeneral =new TipoTelefoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoTelefoWithConnection");connexion.begin();
			
			tipotelefoReturnGeneral =new TipoTelefoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipotelefoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipotelefoReturnGeneral;
	}
	
	public TipoTelefoParameterReturnGeneral cargarCombosLoteForeignKeyTipoTelefo(String finalQueryGlobalEmpresa) throws Exception {
		TipoTelefoParameterReturnGeneral  tipotelefoReturnGeneral =new TipoTelefoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipotelefoReturnGeneral =new TipoTelefoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipotelefoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipotelefoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoTelefoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TelefonoLogic telefonoLogic=new TelefonoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoTelefoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Telefono.class));
											
			

			telefonoLogic.setConnexion(this.getConnexion());
			telefonoLogic.setDatosCliente(this.datosCliente);
			telefonoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoTelefo tipotelefo:this.tipotelefos) {
				

				classes=new ArrayList<Classe>();
				classes=TelefonoConstantesFunciones.getClassesForeignKeysOfTelefono(new ArrayList<Classe>(),DeepLoadType.NONE);

				telefonoLogic.setTelefonos(tipotelefo.telefonos);
				telefonoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoTelefo tipotelefo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoTelefoLogicAdditional.updateTipoTelefoToGet(tipotelefo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipotelefo.setEmpresa(tipotelefoDataAccess.getEmpresa(connexion,tipotelefo));
		tipotelefo.setTelefonos(tipotelefoDataAccess.getTelefonos(connexion,tipotelefo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipotelefo.setEmpresa(tipotelefoDataAccess.getEmpresa(connexion,tipotelefo));
				continue;
			}

			if(clas.clas.equals(Telefono.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipotelefo.setTelefonos(tipotelefoDataAccess.getTelefonos(connexion,tipotelefo));

				if(this.isConDeep) {
					TelefonoLogic telefonoLogic= new TelefonoLogic(this.connexion);
					telefonoLogic.setTelefonos(tipotelefo.getTelefonos());
					ArrayList<Classe> classesLocal=TelefonoConstantesFunciones.getClassesForeignKeysOfTelefono(new ArrayList<Classe>(),DeepLoadType.NONE);
					telefonoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TelefonoConstantesFunciones.refrescarForeignKeysDescripcionesTelefono(telefonoLogic.getTelefonos());
					tipotelefo.setTelefonos(telefonoLogic.getTelefonos());
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
			tipotelefo.setEmpresa(tipotelefoDataAccess.getEmpresa(connexion,tipotelefo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Telefono.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Telefono.class));
			tipotelefo.setTelefonos(tipotelefoDataAccess.getTelefonos(connexion,tipotelefo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipotelefo.setEmpresa(tipotelefoDataAccess.getEmpresa(connexion,tipotelefo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipotelefo.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipotelefo.setTelefonos(tipotelefoDataAccess.getTelefonos(connexion,tipotelefo));

		for(Telefono telefono:tipotelefo.getTelefonos()) {
			TelefonoLogic telefonoLogic= new TelefonoLogic(connexion);
			telefonoLogic.deepLoad(telefono,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipotelefo.setEmpresa(tipotelefoDataAccess.getEmpresa(connexion,tipotelefo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipotelefo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Telefono.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipotelefo.setTelefonos(tipotelefoDataAccess.getTelefonos(connexion,tipotelefo));

				for(Telefono telefono:tipotelefo.getTelefonos()) {
					TelefonoLogic telefonoLogic= new TelefonoLogic(connexion);
					telefonoLogic.deepLoad(telefono,isDeep,deepLoadType,clases);
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
			tipotelefo.setEmpresa(tipotelefoDataAccess.getEmpresa(connexion,tipotelefo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipotelefo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Telefono.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Telefono.class));
			tipotelefo.setTelefonos(tipotelefoDataAccess.getTelefonos(connexion,tipotelefo));

			for(Telefono telefono:tipotelefo.getTelefonos()) {
				TelefonoLogic telefonoLogic= new TelefonoLogic(connexion);
				telefonoLogic.deepLoad(telefono,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoTelefo tipotelefo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoTelefoLogicAdditional.updateTipoTelefoToSave(tipotelefo,this.arrDatoGeneral);
			
TipoTelefoDataAccess.save(tipotelefo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipotelefo.getEmpresa(),connexion);

		for(Telefono telefono:tipotelefo.getTelefonos()) {
			telefono.setid_tipo_telefono(tipotelefo.getId());
			TelefonoDataAccess.save(telefono,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipotelefo.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Telefono.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Telefono telefono:tipotelefo.getTelefonos()) {
					telefono.setid_tipo_telefono(tipotelefo.getId());
					TelefonoDataAccess.save(telefono,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipotelefo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipotelefo.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Telefono telefono:tipotelefo.getTelefonos()) {
			TelefonoLogic telefonoLogic= new TelefonoLogic(connexion);
			telefono.setid_tipo_telefono(tipotelefo.getId());
			TelefonoDataAccess.save(telefono,connexion);
			telefonoLogic.deepSave(telefono,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipotelefo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipotelefo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Telefono.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Telefono telefono:tipotelefo.getTelefonos()) {
					TelefonoLogic telefonoLogic= new TelefonoLogic(connexion);
					telefono.setid_tipo_telefono(tipotelefo.getId());
					TelefonoDataAccess.save(telefono,connexion);
					telefonoLogic.deepSave(telefono,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoTelefo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipotelefo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(tipotelefo);
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
			this.deepLoad(this.tipotelefo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoTelefo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipotelefos!=null) {
				for(TipoTelefo tipotelefo:tipotelefos) {
					this.deepLoad(tipotelefo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(tipotelefos);
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
			if(tipotelefos!=null) {
				for(TipoTelefo tipotelefo:tipotelefos) {
					this.deepLoad(tipotelefo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(tipotelefos);
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
			this.getNewConnexionToDeep(TipoTelefo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipotelefo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoTelefo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipotelefos!=null) {
				for(TipoTelefo tipotelefo:tipotelefos) {
					this.deepSave(tipotelefo,isDeep,deepLoadType,clases);
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
			if(tipotelefos!=null) {
				for(TipoTelefo tipotelefo:tipotelefos) {
					this.deepSave(tipotelefo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoTelefosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTelefo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoTelefoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotelefos=tipotelefoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoTelefosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoTelefoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoTelefoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotelefos=tipotelefoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTelefoConstantesFunciones.refrescarForeignKeysDescripcionesTipoTelefo(this.tipotelefos);
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
			if(TipoTelefoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTelefoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoTelefo tipotelefo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoTelefoConstantesFunciones.ISCONAUDITORIA) {
				if(tipotelefo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTelefoDataAccess.TABLENAME, tipotelefo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoTelefoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoTelefoLogic.registrarAuditoriaDetallesTipoTelefo(connexion,tipotelefo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipotelefo.getIsDeleted()) {
					/*if(!tipotelefo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoTelefoDataAccess.TABLENAME, tipotelefo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoTelefoLogic.registrarAuditoriaDetallesTipoTelefo(connexion,tipotelefo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTelefoDataAccess.TABLENAME, tipotelefo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipotelefo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTelefoDataAccess.TABLENAME, tipotelefo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoTelefoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoTelefoLogic.registrarAuditoriaDetallesTipoTelefo(connexion,tipotelefo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoTelefo(Connexion connexion,TipoTelefo tipotelefo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipotelefo.getIsNew()||!tipotelefo.getid_empresa().equals(tipotelefo.getTipoTelefoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipotelefo.getTipoTelefoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipotelefo.getTipoTelefoOriginal().getid_empresa().toString();
				}
				if(tipotelefo.getid_empresa()!=null)
				{
					strValorNuevo=tipotelefo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTelefoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipotelefo.getIsNew()||!tipotelefo.getcodigo().equals(tipotelefo.getTipoTelefoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipotelefo.getTipoTelefoOriginal().getcodigo()!=null)
				{
					strValorActual=tipotelefo.getTipoTelefoOriginal().getcodigo();
				}
				if(tipotelefo.getcodigo()!=null)
				{
					strValorNuevo=tipotelefo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTelefoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipotelefo.getIsNew()||!tipotelefo.getnombre().equals(tipotelefo.getTipoTelefoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipotelefo.getTipoTelefoOriginal().getnombre()!=null)
				{
					strValorActual=tipotelefo.getTipoTelefoOriginal().getnombre();
				}
				if(tipotelefo.getnombre()!=null)
				{
					strValorNuevo=tipotelefo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTelefoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoTelefoRelacionesWithConnection(TipoTelefo tipotelefo,List<Telefono> telefonos) throws Exception {

		if(!tipotelefo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoTelefoRelacionesBase(tipotelefo,telefonos,true);
		}
	}

	public void saveTipoTelefoRelaciones(TipoTelefo tipotelefo,List<Telefono> telefonos)throws Exception {

		if(!tipotelefo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoTelefoRelacionesBase(tipotelefo,telefonos,false);
		}
	}

	public void saveTipoTelefoRelacionesBase(TipoTelefo tipotelefo,List<Telefono> telefonos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoTelefo-saveRelacionesWithConnection");}
	
			tipotelefo.setTelefonos(telefonos);

			this.setTipoTelefo(tipotelefo);

			if(TipoTelefoLogicAdditional.validarSaveRelaciones(tipotelefo,this)) {

				TipoTelefoLogicAdditional.updateRelacionesToSave(tipotelefo,this);

				if((tipotelefo.getIsNew()||tipotelefo.getIsChanged())&&!tipotelefo.getIsDeleted()) {
					this.saveTipoTelefo();
					this.saveTipoTelefoRelacionesDetalles(telefonos);

				} else if(tipotelefo.getIsDeleted()) {
					this.saveTipoTelefoRelacionesDetalles(telefonos);
					this.saveTipoTelefo();
				}

				TipoTelefoLogicAdditional.updateRelacionesToSaveAfter(tipotelefo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TelefonoConstantesFunciones.InicializarGeneralEntityAuxiliaresTelefonos(telefonos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoTelefoRelacionesDetalles(List<Telefono> telefonos)throws Exception {
		try {
	

			Long idTipoTelefoActual=this.getTipoTelefo().getId();

			TelefonoLogic telefonoLogic_Desde_TipoTelefo=new TelefonoLogic();
			telefonoLogic_Desde_TipoTelefo.setTelefonos(telefonos);

			telefonoLogic_Desde_TipoTelefo.setConnexion(this.getConnexion());
			telefonoLogic_Desde_TipoTelefo.setDatosCliente(this.datosCliente);

			for(Telefono telefono_Desde_TipoTelefo:telefonoLogic_Desde_TipoTelefo.getTelefonos()) {
				telefono_Desde_TipoTelefo.setid_tipo_telefono(idTipoTelefoActual);
			}

			telefonoLogic_Desde_TipoTelefo.saveTelefonos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTelefo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoTelefoConstantesFunciones.getClassesForeignKeysOfTipoTelefo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTelefo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoTelefoConstantesFunciones.getClassesRelationshipsOfTipoTelefo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

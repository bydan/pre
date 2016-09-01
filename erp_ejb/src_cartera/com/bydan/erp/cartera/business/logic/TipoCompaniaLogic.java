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
import com.bydan.erp.cartera.util.TipoCompaniaConstantesFunciones;
import com.bydan.erp.cartera.util.TipoCompaniaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoCompaniaParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoCompania;
import com.bydan.erp.cartera.business.logic.TipoCompaniaLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoCompaniaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCompaniaLogic.class);
	
	protected TipoCompaniaDataAccess tipocompaniaDataAccess; 	
	protected TipoCompania tipocompania;
	protected List<TipoCompania> tipocompanias;
	protected Object tipocompaniaObject;	
	protected List<Object> tipocompaniasObject;
	
	public static ClassValidator<TipoCompania> tipocompaniaValidator = new ClassValidator<TipoCompania>(TipoCompania.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoCompaniaLogicAdditional tipocompaniaLogicAdditional=null;
	
	public TipoCompaniaLogicAdditional getTipoCompaniaLogicAdditional() {
		return this.tipocompaniaLogicAdditional;
	}
	
	public void setTipoCompaniaLogicAdditional(TipoCompaniaLogicAdditional tipocompaniaLogicAdditional) {
		try {
			this.tipocompaniaLogicAdditional=tipocompaniaLogicAdditional;
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
	
	
	
	
	public  TipoCompaniaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocompaniaDataAccess = new TipoCompaniaDataAccess();
			
			this.tipocompanias= new ArrayList<TipoCompania>();
			this.tipocompania= new TipoCompania();
			
			this.tipocompaniaObject=new Object();
			this.tipocompaniasObject=new ArrayList<Object>();
				
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
			
			this.tipocompaniaDataAccess.setConnexionType(this.connexionType);
			this.tipocompaniaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCompaniaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocompaniaDataAccess = new TipoCompaniaDataAccess();
			this.tipocompanias= new ArrayList<TipoCompania>();
			this.tipocompania= new TipoCompania();
			this.tipocompaniaObject=new Object();
			this.tipocompaniasObject=new ArrayList<Object>();
			
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
			
			this.tipocompaniaDataAccess.setConnexionType(this.connexionType);
			this.tipocompaniaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCompania getTipoCompania() throws Exception {	
		TipoCompaniaLogicAdditional.checkTipoCompaniaToGet(tipocompania,this.datosCliente,this.arrDatoGeneral);
		TipoCompaniaLogicAdditional.updateTipoCompaniaToGet(tipocompania,this.arrDatoGeneral);
		
		return tipocompania;
	}
		
	public void setTipoCompania(TipoCompania newTipoCompania) {
		this.tipocompania = newTipoCompania;
	}
	
	public TipoCompaniaDataAccess getTipoCompaniaDataAccess() {
		return tipocompaniaDataAccess;
	}
	
	public void setTipoCompaniaDataAccess(TipoCompaniaDataAccess newtipocompaniaDataAccess) {
		this.tipocompaniaDataAccess = newtipocompaniaDataAccess;
	}
	
	public List<TipoCompania> getTipoCompanias() throws Exception {		
		this.quitarTipoCompaniasNulos();
		
		TipoCompaniaLogicAdditional.checkTipoCompaniaToGets(tipocompanias,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCompania tipocompaniaLocal: tipocompanias ) {
			TipoCompaniaLogicAdditional.updateTipoCompaniaToGet(tipocompaniaLocal,this.arrDatoGeneral);
		}
		
		return tipocompanias;
	}
	
	public void setTipoCompanias(List<TipoCompania> newTipoCompanias) {
		this.tipocompanias = newTipoCompanias;
	}
	
	public Object getTipoCompaniaObject() {	
		this.tipocompaniaObject=this.tipocompaniaDataAccess.getEntityObject();
		return this.tipocompaniaObject;
	}
		
	public void setTipoCompaniaObject(Object newTipoCompaniaObject) {
		this.tipocompaniaObject = newTipoCompaniaObject;
	}
	
	public List<Object> getTipoCompaniasObject() {		
		this.tipocompaniasObject=this.tipocompaniaDataAccess.getEntitiesObject();
		return this.tipocompaniasObject;
	}
		
	public void setTipoCompaniasObject(List<Object> newTipoCompaniasObject) {
		this.tipocompaniasObject = newTipoCompaniasObject;
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
		
		if(this.tipocompaniaDataAccess!=null) {
			this.tipocompaniaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocompaniaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocompaniaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocompania = new  TipoCompania();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocompania=tipocompaniaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocompania,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompania);
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
		tipocompania = new  TipoCompania();
		  		  
        try {
			
			tipocompania=tipocompaniaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocompania,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompania);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocompania = new  TipoCompania();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocompania=tipocompaniaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocompania,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompania);
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
		tipocompania = new  TipoCompania();
		  		  
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
		tipocompania = new  TipoCompania();
		  		  
        try {
			
			tipocompania=tipocompaniaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocompania,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompania);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocompania = new  TipoCompania();
		  		  
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
		tipocompania = new  TipoCompania();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocompaniaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocompania = new  TipoCompania();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocompaniaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocompania = new  TipoCompania();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocompaniaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocompania = new  TipoCompania();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocompaniaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocompania = new  TipoCompania();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocompaniaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocompania = new  TipoCompania();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocompaniaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocompanias = new  ArrayList<TipoCompania>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocompanias=tipocompaniaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCompania(tipocompanias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompanias);
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
		tipocompanias = new  ArrayList<TipoCompania>();
		  		  
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
		tipocompanias = new  ArrayList<TipoCompania>();
		  		  
        try {			
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocompanias=tipocompaniaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCompania(tipocompanias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompanias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocompanias = new  ArrayList<TipoCompania>();
		  		  
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
		tipocompanias = new  ArrayList<TipoCompania>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocompanias=tipocompaniaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCompania(tipocompanias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompanias);
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
		tipocompanias = new  ArrayList<TipoCompania>();
		  		  
        try {
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocompanias=tipocompaniaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCompania(tipocompanias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompanias);
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
		tipocompanias = new  ArrayList<TipoCompania>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocompanias=tipocompaniaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCompania(tipocompanias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompanias);
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
		tipocompanias = new  ArrayList<TipoCompania>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocompanias=tipocompaniaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCompania(tipocompanias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompanias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocompania = new  TipoCompania();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocompania=tipocompaniaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCompania(tipocompania);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompania);
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
		tipocompania = new  TipoCompania();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocompania=tipocompaniaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCompania(tipocompania);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompania);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocompanias = new  ArrayList<TipoCompania>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocompanias=tipocompaniaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCompania(tipocompanias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompanias);
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
		tipocompanias = new  ArrayList<TipoCompania>();
		  		  
        try {
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocompanias=tipocompaniaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCompania(tipocompanias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompanias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoCompaniasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocompanias = new  ArrayList<TipoCompania>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-getTodosTipoCompaniasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocompanias=tipocompaniaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCompania(tipocompanias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompanias);
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
	
	public  void  getTodosTipoCompanias(String sFinalQuery,Pagination pagination)throws Exception {
		tipocompanias = new  ArrayList<TipoCompania>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocompanias=tipocompaniaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCompania(tipocompanias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompanias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCompania(TipoCompania tipocompania) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocompania.getIsNew() || tipocompania.getIsChanged()) { 
			this.invalidValues = tipocompaniaValidator.getInvalidValues(tipocompania);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocompania);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCompania(List<TipoCompania> TipoCompanias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCompania tipocompaniaLocal:tipocompanias) {				
			estaValidadoObjeto=this.validarGuardarTipoCompania(tipocompaniaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCompania(List<TipoCompania> TipoCompanias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCompania(tipocompanias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCompania(TipoCompania TipoCompania) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCompania(tipocompania)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCompania tipocompania) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocompania.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCompaniaConstantesFunciones.getTipoCompaniaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocompania","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCompaniaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCompaniaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCompaniaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-saveTipoCompaniaWithConnection");connexion.begin();			
			
			TipoCompaniaLogicAdditional.checkTipoCompaniaToSave(this.tipocompania,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCompaniaLogicAdditional.updateTipoCompaniaToSave(this.tipocompania,this.arrDatoGeneral);
			
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocompania,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCompania();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCompania(this.tipocompania)) {
				TipoCompaniaDataAccess.save(this.tipocompania, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocompania,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCompaniaLogicAdditional.checkTipoCompaniaToSaveAfter(this.tipocompania,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCompania();
			
			connexion.commit();			
			
			if(this.tipocompania.getIsDeleted()) {
				this.tipocompania=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCompania()throws Exception {	
		try {	
			
			TipoCompaniaLogicAdditional.checkTipoCompaniaToSave(this.tipocompania,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCompaniaLogicAdditional.updateTipoCompaniaToSave(this.tipocompania,this.arrDatoGeneral);
			
			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocompania,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCompania(this.tipocompania)) {			
				TipoCompaniaDataAccess.save(this.tipocompania, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocompania,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCompaniaLogicAdditional.checkTipoCompaniaToSaveAfter(this.tipocompania,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocompania.getIsDeleted()) {
				this.tipocompania=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCompaniasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-saveTipoCompaniasWithConnection");connexion.begin();			
			
			TipoCompaniaLogicAdditional.checkTipoCompaniaToSaves(tipocompanias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCompanias();
			
			Boolean validadoTodosTipoCompania=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCompania tipocompaniaLocal:tipocompanias) {		
				if(tipocompaniaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCompaniaLogicAdditional.updateTipoCompaniaToSave(tipocompaniaLocal,this.arrDatoGeneral);
	        	
				TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocompaniaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCompania(tipocompaniaLocal)) {
					TipoCompaniaDataAccess.save(tipocompaniaLocal, connexion);				
				} else {
					validadoTodosTipoCompania=false;
				}
			}
			
			if(!validadoTodosTipoCompania) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCompaniaLogicAdditional.checkTipoCompaniaToSavesAfter(tipocompanias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCompanias();
			
			connexion.commit();		
			
			this.quitarTipoCompaniasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCompanias()throws Exception {				
		 try {	
			TipoCompaniaLogicAdditional.checkTipoCompaniaToSaves(tipocompanias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCompania=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCompania tipocompaniaLocal:tipocompanias) {				
				if(tipocompaniaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCompaniaLogicAdditional.updateTipoCompaniaToSave(tipocompaniaLocal,this.arrDatoGeneral);
	        	
				TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocompaniaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCompania(tipocompaniaLocal)) {				
					TipoCompaniaDataAccess.save(tipocompaniaLocal, connexion);				
				} else {
					validadoTodosTipoCompania=false;
				}
			}
			
			if(!validadoTodosTipoCompania) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCompaniaLogicAdditional.checkTipoCompaniaToSavesAfter(tipocompanias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCompaniasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCompaniaParameterReturnGeneral procesarAccionTipoCompanias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCompania> tipocompanias,TipoCompaniaParameterReturnGeneral tipocompaniaParameterGeneral)throws Exception {
		 try {	
			TipoCompaniaParameterReturnGeneral tipocompaniaReturnGeneral=new TipoCompaniaParameterReturnGeneral();
	
			TipoCompaniaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocompanias,tipocompaniaParameterGeneral,tipocompaniaReturnGeneral);
			
			return tipocompaniaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCompaniaParameterReturnGeneral procesarAccionTipoCompaniasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCompania> tipocompanias,TipoCompaniaParameterReturnGeneral tipocompaniaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-procesarAccionTipoCompaniasWithConnection");connexion.begin();			
			
			TipoCompaniaParameterReturnGeneral tipocompaniaReturnGeneral=new TipoCompaniaParameterReturnGeneral();
	
			TipoCompaniaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocompanias,tipocompaniaParameterGeneral,tipocompaniaReturnGeneral);
			
			this.connexion.commit();
			
			return tipocompaniaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCompaniaParameterReturnGeneral procesarEventosTipoCompanias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCompania> tipocompanias,TipoCompania tipocompania,TipoCompaniaParameterReturnGeneral tipocompaniaParameterGeneral,Boolean isEsNuevoTipoCompania,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCompaniaParameterReturnGeneral tipocompaniaReturnGeneral=new TipoCompaniaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocompaniaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCompaniaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocompanias,tipocompania,tipocompaniaParameterGeneral,tipocompaniaReturnGeneral,isEsNuevoTipoCompania,clases);
			
			return tipocompaniaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCompaniaParameterReturnGeneral procesarEventosTipoCompaniasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCompania> tipocompanias,TipoCompania tipocompania,TipoCompaniaParameterReturnGeneral tipocompaniaParameterGeneral,Boolean isEsNuevoTipoCompania,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-procesarEventosTipoCompaniasWithConnection");connexion.begin();			
			
			TipoCompaniaParameterReturnGeneral tipocompaniaReturnGeneral=new TipoCompaniaParameterReturnGeneral();
	
			tipocompaniaReturnGeneral.setTipoCompania(tipocompania);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocompaniaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCompaniaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocompanias,tipocompania,tipocompaniaParameterGeneral,tipocompaniaReturnGeneral,isEsNuevoTipoCompania,clases);
			
			this.connexion.commit();
			
			return tipocompaniaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCompaniaParameterReturnGeneral procesarImportacionTipoCompaniasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCompaniaParameterReturnGeneral tipocompaniaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-procesarImportacionTipoCompaniasWithConnection");connexion.begin();			
			
			TipoCompaniaParameterReturnGeneral tipocompaniaReturnGeneral=new TipoCompaniaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocompanias=new ArrayList<TipoCompania>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocompania=new TipoCompania();
				
				
				if(conColumnasBase) {this.tipocompania.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocompania.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocompania.setcodigo(arrColumnas[iColumn++]);
				this.tipocompania.setnombre(arrColumnas[iColumn++]);
				
				this.tipocompanias.add(this.tipocompania);
			}
			
			this.saveTipoCompanias();
			
			this.connexion.commit();
			
			tipocompaniaReturnGeneral.setConRetornoEstaProcesado(true);
			tipocompaniaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocompaniaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCompaniasEliminados() throws Exception {				
		
		List<TipoCompania> tipocompaniasAux= new ArrayList<TipoCompania>();
		
		for(TipoCompania tipocompania:tipocompanias) {
			if(!tipocompania.getIsDeleted()) {
				tipocompaniasAux.add(tipocompania);
			}
		}
		
		tipocompanias=tipocompaniasAux;
	}
	
	public void quitarTipoCompaniasNulos() throws Exception {				
		
		List<TipoCompania> tipocompaniasAux= new ArrayList<TipoCompania>();
		
		for(TipoCompania tipocompania : this.tipocompanias) {
			if(tipocompania==null) {
				tipocompaniasAux.add(tipocompania);
			}
		}
		
		//this.tipocompanias=tipocompaniasAux;
		
		this.tipocompanias.removeAll(tipocompaniasAux);
	}
	
	public void getSetVersionRowTipoCompaniaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocompania.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocompania.getIsDeleted() || (tipocompania.getIsChanged()&&!tipocompania.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocompaniaDataAccess.getSetVersionRowTipoCompania(connexion,tipocompania.getId());
				
				if(!tipocompania.getVersionRow().equals(timestamp)) {	
					tipocompania.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocompania.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCompania()throws Exception {	
		
		if(tipocompania.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocompania.getIsDeleted() || (tipocompania.getIsChanged()&&!tipocompania.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocompaniaDataAccess.getSetVersionRowTipoCompania(connexion,tipocompania.getId());
			
			try {							
				if(!tipocompania.getVersionRow().equals(timestamp)) {	
					tipocompania.setVersionRow(timestamp);
				}
				
				tipocompania.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCompaniasWithConnection()throws Exception {	
		if(tipocompanias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCompania tipocompaniaAux:tipocompanias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocompaniaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocompaniaAux.getIsDeleted() || (tipocompaniaAux.getIsChanged()&&!tipocompaniaAux.getIsNew())) {
						
						timestamp=tipocompaniaDataAccess.getSetVersionRowTipoCompania(connexion,tipocompaniaAux.getId());
						
						if(!tipocompania.getVersionRow().equals(timestamp)) {	
							tipocompaniaAux.setVersionRow(timestamp);
						}
								
						tipocompaniaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCompanias()throws Exception {	
		if(tipocompanias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCompania tipocompaniaAux:tipocompanias) {
					if(tipocompaniaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocompaniaAux.getIsDeleted() || (tipocompaniaAux.getIsChanged()&&!tipocompaniaAux.getIsNew())) {
						
						timestamp=tipocompaniaDataAccess.getSetVersionRowTipoCompania(connexion,tipocompaniaAux.getId());
						
						if(!tipocompaniaAux.getVersionRow().equals(timestamp)) {	
							tipocompaniaAux.setVersionRow(timestamp);
						}
						
													
						tipocompaniaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoCompaniaParameterReturnGeneral cargarCombosLoteForeignKeyTipoCompaniaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoCompaniaParameterReturnGeneral  tipocompaniaReturnGeneral =new TipoCompaniaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoCompaniaWithConnection");connexion.begin();
			
			tipocompaniaReturnGeneral =new TipoCompaniaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocompaniaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipocompaniaReturnGeneral;
	}
	
	public TipoCompaniaParameterReturnGeneral cargarCombosLoteForeignKeyTipoCompania(String finalQueryGlobalEmpresa) throws Exception {
		TipoCompaniaParameterReturnGeneral  tipocompaniaReturnGeneral =new TipoCompaniaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipocompaniaReturnGeneral =new TipoCompaniaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocompaniaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipocompaniaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoCompaniaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DatoConstitucionLogic datoconstitucionLogic=new DatoConstitucionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoCompaniaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DatoConstitucion.class));
											
			

			datoconstitucionLogic.setConnexion(this.getConnexion());
			datoconstitucionLogic.setDatosCliente(this.datosCliente);
			datoconstitucionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoCompania tipocompania:this.tipocompanias) {
				

				classes=new ArrayList<Classe>();
				classes=DatoConstitucionConstantesFunciones.getClassesForeignKeysOfDatoConstitucion(new ArrayList<Classe>(),DeepLoadType.NONE);

				datoconstitucionLogic.setDatoConstitucions(tipocompania.datoconstitucions);
				datoconstitucionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoCompania tipocompania,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoCompaniaLogicAdditional.updateTipoCompaniaToGet(tipocompania,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocompania.setEmpresa(tipocompaniaDataAccess.getEmpresa(connexion,tipocompania));
		tipocompania.setDatoConstitucions(tipocompaniaDataAccess.getDatoConstitucions(connexion,tipocompania));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocompania.setEmpresa(tipocompaniaDataAccess.getEmpresa(connexion,tipocompania));
				continue;
			}

			if(clas.clas.equals(DatoConstitucion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocompania.setDatoConstitucions(tipocompaniaDataAccess.getDatoConstitucions(connexion,tipocompania));

				if(this.isConDeep) {
					DatoConstitucionLogic datoconstitucionLogic= new DatoConstitucionLogic(this.connexion);
					datoconstitucionLogic.setDatoConstitucions(tipocompania.getDatoConstitucions());
					ArrayList<Classe> classesLocal=DatoConstitucionConstantesFunciones.getClassesForeignKeysOfDatoConstitucion(new ArrayList<Classe>(),DeepLoadType.NONE);
					datoconstitucionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(datoconstitucionLogic.getDatoConstitucions());
					tipocompania.setDatoConstitucions(datoconstitucionLogic.getDatoConstitucions());
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
			tipocompania.setEmpresa(tipocompaniaDataAccess.getEmpresa(connexion,tipocompania));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoConstitucion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoConstitucion.class));
			tipocompania.setDatoConstitucions(tipocompaniaDataAccess.getDatoConstitucions(connexion,tipocompania));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocompania.setEmpresa(tipocompaniaDataAccess.getEmpresa(connexion,tipocompania));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocompania.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipocompania.setDatoConstitucions(tipocompaniaDataAccess.getDatoConstitucions(connexion,tipocompania));

		for(DatoConstitucion datoconstitucion:tipocompania.getDatoConstitucions()) {
			DatoConstitucionLogic datoconstitucionLogic= new DatoConstitucionLogic(connexion);
			datoconstitucionLogic.deepLoad(datoconstitucion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocompania.setEmpresa(tipocompaniaDataAccess.getEmpresa(connexion,tipocompania));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipocompania.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DatoConstitucion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocompania.setDatoConstitucions(tipocompaniaDataAccess.getDatoConstitucions(connexion,tipocompania));

				for(DatoConstitucion datoconstitucion:tipocompania.getDatoConstitucions()) {
					DatoConstitucionLogic datoconstitucionLogic= new DatoConstitucionLogic(connexion);
					datoconstitucionLogic.deepLoad(datoconstitucion,isDeep,deepLoadType,clases);
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
			tipocompania.setEmpresa(tipocompaniaDataAccess.getEmpresa(connexion,tipocompania));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipocompania.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoConstitucion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoConstitucion.class));
			tipocompania.setDatoConstitucions(tipocompaniaDataAccess.getDatoConstitucions(connexion,tipocompania));

			for(DatoConstitucion datoconstitucion:tipocompania.getDatoConstitucions()) {
				DatoConstitucionLogic datoconstitucionLogic= new DatoConstitucionLogic(connexion);
				datoconstitucionLogic.deepLoad(datoconstitucion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCompania tipocompania,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoCompaniaLogicAdditional.updateTipoCompaniaToSave(tipocompania,this.arrDatoGeneral);
			
TipoCompaniaDataAccess.save(tipocompania, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocompania.getEmpresa(),connexion);

		for(DatoConstitucion datoconstitucion:tipocompania.getDatoConstitucions()) {
			datoconstitucion.setidvalorclientecompania(tipocompania.getId());
			DatoConstitucionDataAccess.save(datoconstitucion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocompania.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(DatoConstitucion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoConstitucion datoconstitucion:tipocompania.getDatoConstitucions()) {
					datoconstitucion.setidvalorclientecompania(tipocompania.getId());
					DatoConstitucionDataAccess.save(datoconstitucion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocompania.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocompania.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(DatoConstitucion datoconstitucion:tipocompania.getDatoConstitucions()) {
			DatoConstitucionLogic datoconstitucionLogic= new DatoConstitucionLogic(connexion);
			datoconstitucion.setidvalorclientecompania(tipocompania.getId());
			DatoConstitucionDataAccess.save(datoconstitucion,connexion);
			datoconstitucionLogic.deepSave(datoconstitucion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocompania.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipocompania.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DatoConstitucion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoConstitucion datoconstitucion:tipocompania.getDatoConstitucions()) {
					DatoConstitucionLogic datoconstitucionLogic= new DatoConstitucionLogic(connexion);
					datoconstitucion.setidvalorclientecompania(tipocompania.getId());
					DatoConstitucionDataAccess.save(datoconstitucion,connexion);
					datoconstitucionLogic.deepSave(datoconstitucion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoCompania.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocompania,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(tipocompania);
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
			this.deepLoad(this.tipocompania,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompania);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCompania.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocompanias!=null) {
				for(TipoCompania tipocompania:tipocompanias) {
					this.deepLoad(tipocompania,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(tipocompanias);
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
			if(tipocompanias!=null) {
				for(TipoCompania tipocompania:tipocompanias) {
					this.deepLoad(tipocompania,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(tipocompanias);
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
			this.getNewConnexionToDeep(TipoCompania.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipocompania,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoCompania.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipocompanias!=null) {
				for(TipoCompania tipocompania:tipocompanias) {
					this.deepSave(tipocompania,isDeep,deepLoadType,clases);
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
			if(tipocompanias!=null) {
				for(TipoCompania tipocompania:tipocompanias) {
					this.deepSave(tipocompania,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoCompaniasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCompania.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoCompaniaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocompanias=tipocompaniaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompanias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCompaniasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoCompaniaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoCompaniaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocompanias=tipocompaniaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCompaniaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCompania(this.tipocompanias);
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
			if(TipoCompaniaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCompaniaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCompania tipocompania,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCompaniaConstantesFunciones.ISCONAUDITORIA) {
				if(tipocompania.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCompaniaDataAccess.TABLENAME, tipocompania.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCompaniaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCompaniaLogic.registrarAuditoriaDetallesTipoCompania(connexion,tipocompania,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocompania.getIsDeleted()) {
					/*if(!tipocompania.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCompaniaDataAccess.TABLENAME, tipocompania.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCompaniaLogic.registrarAuditoriaDetallesTipoCompania(connexion,tipocompania,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCompaniaDataAccess.TABLENAME, tipocompania.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocompania.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCompaniaDataAccess.TABLENAME, tipocompania.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCompaniaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCompaniaLogic.registrarAuditoriaDetallesTipoCompania(connexion,tipocompania,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCompania(Connexion connexion,TipoCompania tipocompania)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocompania.getIsNew()||!tipocompania.getid_empresa().equals(tipocompania.getTipoCompaniaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocompania.getTipoCompaniaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipocompania.getTipoCompaniaOriginal().getid_empresa().toString();
				}
				if(tipocompania.getid_empresa()!=null)
				{
					strValorNuevo=tipocompania.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCompaniaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipocompania.getIsNew()||!tipocompania.getcodigo().equals(tipocompania.getTipoCompaniaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocompania.getTipoCompaniaOriginal().getcodigo()!=null)
				{
					strValorActual=tipocompania.getTipoCompaniaOriginal().getcodigo();
				}
				if(tipocompania.getcodigo()!=null)
				{
					strValorNuevo=tipocompania.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCompaniaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocompania.getIsNew()||!tipocompania.getnombre().equals(tipocompania.getTipoCompaniaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocompania.getTipoCompaniaOriginal().getnombre()!=null)
				{
					strValorActual=tipocompania.getTipoCompaniaOriginal().getnombre();
				}
				if(tipocompania.getnombre()!=null)
				{
					strValorNuevo=tipocompania.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCompaniaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoCompaniaRelacionesWithConnection(TipoCompania tipocompania,List<DatoConstitucion> datoconstitucions) throws Exception {

		if(!tipocompania.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCompaniaRelacionesBase(tipocompania,datoconstitucions,true);
		}
	}

	public void saveTipoCompaniaRelaciones(TipoCompania tipocompania,List<DatoConstitucion> datoconstitucions)throws Exception {

		if(!tipocompania.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCompaniaRelacionesBase(tipocompania,datoconstitucions,false);
		}
	}

	public void saveTipoCompaniaRelacionesBase(TipoCompania tipocompania,List<DatoConstitucion> datoconstitucions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoCompania-saveRelacionesWithConnection");}
	
			tipocompania.setDatoConstitucions(datoconstitucions);

			this.setTipoCompania(tipocompania);

			if(TipoCompaniaLogicAdditional.validarSaveRelaciones(tipocompania,this)) {

				TipoCompaniaLogicAdditional.updateRelacionesToSave(tipocompania,this);

				if((tipocompania.getIsNew()||tipocompania.getIsChanged())&&!tipocompania.getIsDeleted()) {
					this.saveTipoCompania();
					this.saveTipoCompaniaRelacionesDetalles(datoconstitucions);

				} else if(tipocompania.getIsDeleted()) {
					this.saveTipoCompaniaRelacionesDetalles(datoconstitucions);
					this.saveTipoCompania();
				}

				TipoCompaniaLogicAdditional.updateRelacionesToSaveAfter(tipocompania,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DatoConstitucionConstantesFunciones.InicializarGeneralEntityAuxiliaresDatoConstitucions(datoconstitucions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoCompaniaRelacionesDetalles(List<DatoConstitucion> datoconstitucions)throws Exception {
		try {
	

			Long idTipoCompaniaActual=this.getTipoCompania().getId();

			DatoConstitucionLogic datoconstitucionLogic_Desde_TipoCompania=new DatoConstitucionLogic();
			datoconstitucionLogic_Desde_TipoCompania.setDatoConstitucions(datoconstitucions);

			datoconstitucionLogic_Desde_TipoCompania.setConnexion(this.getConnexion());
			datoconstitucionLogic_Desde_TipoCompania.setDatosCliente(this.datosCliente);

			for(DatoConstitucion datoconstitucion_Desde_TipoCompania:datoconstitucionLogic_Desde_TipoCompania.getDatoConstitucions()) {
				datoconstitucion_Desde_TipoCompania.setidvalorclientecompania(idTipoCompaniaActual);
			}

			datoconstitucionLogic_Desde_TipoCompania.saveDatoConstitucions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCompania(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCompaniaConstantesFunciones.getClassesForeignKeysOfTipoCompania(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCompania(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCompaniaConstantesFunciones.getClassesRelationshipsOfTipoCompania(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

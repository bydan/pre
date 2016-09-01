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
import com.bydan.erp.cartera.util.TipoRadioVenciConstantesFunciones;
import com.bydan.erp.cartera.util.TipoRadioVenciParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoRadioVenciParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoRadioVenci;
//import com.bydan.erp.cartera.business.logic.TipoRadioVenciLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoRadioVenciLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoRadioVenciLogic.class);
	
	protected TipoRadioVenciDataAccess tiporadiovenciDataAccess; 	
	protected TipoRadioVenci tiporadiovenci;
	protected List<TipoRadioVenci> tiporadiovencis;
	protected Object tiporadiovenciObject;	
	protected List<Object> tiporadiovencisObject;
	
	public static ClassValidator<TipoRadioVenci> tiporadiovenciValidator = new ClassValidator<TipoRadioVenci>(TipoRadioVenci.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  TipoRadioVenciLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiporadiovenciDataAccess = new TipoRadioVenciDataAccess();
			
			this.tiporadiovencis= new ArrayList<TipoRadioVenci>();
			this.tiporadiovenci= new TipoRadioVenci();
			
			this.tiporadiovenciObject=new Object();
			this.tiporadiovencisObject=new ArrayList<Object>();
				
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
			
			this.tiporadiovenciDataAccess.setConnexionType(this.connexionType);
			this.tiporadiovenciDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoRadioVenciLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiporadiovenciDataAccess = new TipoRadioVenciDataAccess();
			this.tiporadiovencis= new ArrayList<TipoRadioVenci>();
			this.tiporadiovenci= new TipoRadioVenci();
			this.tiporadiovenciObject=new Object();
			this.tiporadiovencisObject=new ArrayList<Object>();
			
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
			
			this.tiporadiovenciDataAccess.setConnexionType(this.connexionType);
			this.tiporadiovenciDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoRadioVenci getTipoRadioVenci() throws Exception {	
		//TipoRadioVenciLogicAdditional.checkTipoRadioVenciToGet(tiporadiovenci,this.datosCliente,this.arrDatoGeneral);
		//TipoRadioVenciLogicAdditional.updateTipoRadioVenciToGet(tiporadiovenci,this.arrDatoGeneral);
		
		return tiporadiovenci;
	}
		
	public void setTipoRadioVenci(TipoRadioVenci newTipoRadioVenci) {
		this.tiporadiovenci = newTipoRadioVenci;
	}
	
	public TipoRadioVenciDataAccess getTipoRadioVenciDataAccess() {
		return tiporadiovenciDataAccess;
	}
	
	public void setTipoRadioVenciDataAccess(TipoRadioVenciDataAccess newtiporadiovenciDataAccess) {
		this.tiporadiovenciDataAccess = newtiporadiovenciDataAccess;
	}
	
	public List<TipoRadioVenci> getTipoRadioVencis() throws Exception {		
		this.quitarTipoRadioVencisNulos();
		
		//TipoRadioVenciLogicAdditional.checkTipoRadioVenciToGets(tiporadiovencis,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoRadioVenci tiporadiovenciLocal: tiporadiovencis ) {
			//TipoRadioVenciLogicAdditional.updateTipoRadioVenciToGet(tiporadiovenciLocal,this.arrDatoGeneral);
		}
		
		return tiporadiovencis;
	}
	
	public void setTipoRadioVencis(List<TipoRadioVenci> newTipoRadioVencis) {
		this.tiporadiovencis = newTipoRadioVencis;
	}
	
	public Object getTipoRadioVenciObject() {	
		this.tiporadiovenciObject=this.tiporadiovenciDataAccess.getEntityObject();
		return this.tiporadiovenciObject;
	}
		
	public void setTipoRadioVenciObject(Object newTipoRadioVenciObject) {
		this.tiporadiovenciObject = newTipoRadioVenciObject;
	}
	
	public List<Object> getTipoRadioVencisObject() {		
		this.tiporadiovencisObject=this.tiporadiovenciDataAccess.getEntitiesObject();
		return this.tiporadiovencisObject;
	}
		
	public void setTipoRadioVencisObject(List<Object> newTipoRadioVencisObject) {
		this.tiporadiovencisObject = newTipoRadioVencisObject;
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
		
		if(this.tiporadiovenciDataAccess!=null) {
			this.tiporadiovenciDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiporadiovenciDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiporadiovenciDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiporadiovenci = new  TipoRadioVenci();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporadiovenci=tiporadiovenciDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporadiovenci,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovenci);
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
		tiporadiovenci = new  TipoRadioVenci();
		  		  
        try {
			
			tiporadiovenci=tiporadiovenciDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporadiovenci,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovenci);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiporadiovenci = new  TipoRadioVenci();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporadiovenci=tiporadiovenciDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporadiovenci,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovenci);
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
		tiporadiovenci = new  TipoRadioVenci();
		  		  
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
		tiporadiovenci = new  TipoRadioVenci();
		  		  
        try {
			
			tiporadiovenci=tiporadiovenciDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporadiovenci,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovenci);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiporadiovenci = new  TipoRadioVenci();
		  		  
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
		tiporadiovenci = new  TipoRadioVenci();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiporadiovenciDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporadiovenci = new  TipoRadioVenci();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiporadiovenciDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporadiovenci = new  TipoRadioVenci();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiporadiovenciDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporadiovenci = new  TipoRadioVenci();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiporadiovenciDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporadiovenci = new  TipoRadioVenci();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiporadiovenciDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporadiovenci = new  TipoRadioVenci();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiporadiovenciDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporadiovencis = new  ArrayList<TipoRadioVenci>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporadiovencis=tiporadiovenciDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRadioVenci(tiporadiovencis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovencis);
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
		tiporadiovencis = new  ArrayList<TipoRadioVenci>();
		  		  
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
		tiporadiovencis = new  ArrayList<TipoRadioVenci>();
		  		  
        try {			
			TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporadiovencis=tiporadiovenciDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoRadioVenci(tiporadiovencis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovencis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiporadiovencis = new  ArrayList<TipoRadioVenci>();
		  		  
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
		tiporadiovencis = new  ArrayList<TipoRadioVenci>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporadiovencis=tiporadiovenciDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRadioVenci(tiporadiovencis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovencis);
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
		tiporadiovencis = new  ArrayList<TipoRadioVenci>();
		  		  
        try {
			TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporadiovencis=tiporadiovenciDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRadioVenci(tiporadiovencis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovencis);
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
		tiporadiovencis = new  ArrayList<TipoRadioVenci>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporadiovencis=tiporadiovenciDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRadioVenci(tiporadiovencis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovencis);
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
		tiporadiovencis = new  ArrayList<TipoRadioVenci>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporadiovencis=tiporadiovenciDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRadioVenci(tiporadiovencis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovencis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiporadiovenci = new  TipoRadioVenci();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporadiovenci=tiporadiovenciDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRadioVenci(tiporadiovenci);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovenci);
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
		tiporadiovenci = new  TipoRadioVenci();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporadiovenci=tiporadiovenciDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRadioVenci(tiporadiovenci);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovenci);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoRadioVencisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiporadiovencis = new  ArrayList<TipoRadioVenci>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-getTodosTipoRadioVencisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporadiovencis=tiporadiovenciDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRadioVenci(tiporadiovencis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovencis);
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
	
	public  void  getTodosTipoRadioVencis(String sFinalQuery,Pagination pagination)throws Exception {
		tiporadiovencis = new  ArrayList<TipoRadioVenci>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporadiovencis=tiporadiovenciDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRadioVenci(tiporadiovencis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovencis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoRadioVenci(TipoRadioVenci tiporadiovenci) throws Exception {
		Boolean estaValidado=false;
		
		if(tiporadiovenci.getIsNew() || tiporadiovenci.getIsChanged()) { 
			this.invalidValues = tiporadiovenciValidator.getInvalidValues(tiporadiovenci);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiporadiovenci);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoRadioVenci(List<TipoRadioVenci> TipoRadioVencis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoRadioVenci tiporadiovenciLocal:tiporadiovencis) {				
			estaValidadoObjeto=this.validarGuardarTipoRadioVenci(tiporadiovenciLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoRadioVenci(List<TipoRadioVenci> TipoRadioVencis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRadioVenci(tiporadiovencis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoRadioVenci(TipoRadioVenci TipoRadioVenci) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRadioVenci(tiporadiovenci)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoRadioVenci tiporadiovenci) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiporadiovenci.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoRadioVenciConstantesFunciones.getTipoRadioVenciLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiporadiovenci","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoRadioVenciConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoRadioVenciConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoRadioVenciWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-saveTipoRadioVenciWithConnection");connexion.begin();			
			
			//TipoRadioVenciLogicAdditional.checkTipoRadioVenciToSave(this.tiporadiovenci,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoRadioVenciLogicAdditional.updateTipoRadioVenciToSave(this.tiporadiovenci,this.arrDatoGeneral);
			
			TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporadiovenci,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoRadioVenci();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRadioVenci(this.tiporadiovenci)) {
				TipoRadioVenciDataAccess.save(this.tiporadiovenci, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiporadiovenci,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoRadioVenciLogicAdditional.checkTipoRadioVenciToSaveAfter(this.tiporadiovenci,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRadioVenci();
			
			connexion.commit();			
			
			if(this.tiporadiovenci.getIsDeleted()) {
				this.tiporadiovenci=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoRadioVenci()throws Exception {	
		try {	
			
			//TipoRadioVenciLogicAdditional.checkTipoRadioVenciToSave(this.tiporadiovenci,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoRadioVenciLogicAdditional.updateTipoRadioVenciToSave(this.tiporadiovenci,this.arrDatoGeneral);
			
			TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporadiovenci,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRadioVenci(this.tiporadiovenci)) {			
				TipoRadioVenciDataAccess.save(this.tiporadiovenci, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiporadiovenci,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoRadioVenciLogicAdditional.checkTipoRadioVenciToSaveAfter(this.tiporadiovenci,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiporadiovenci.getIsDeleted()) {
				this.tiporadiovenci=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoRadioVencisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-saveTipoRadioVencisWithConnection");connexion.begin();			
			
			//TipoRadioVenciLogicAdditional.checkTipoRadioVenciToSaves(tiporadiovencis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoRadioVencis();
			
			Boolean validadoTodosTipoRadioVenci=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRadioVenci tiporadiovenciLocal:tiporadiovencis) {		
				if(tiporadiovenciLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoRadioVenciLogicAdditional.updateTipoRadioVenciToSave(tiporadiovenciLocal,this.arrDatoGeneral);
	        	
				TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporadiovenciLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRadioVenci(tiporadiovenciLocal)) {
					TipoRadioVenciDataAccess.save(tiporadiovenciLocal, connexion);				
				} else {
					validadoTodosTipoRadioVenci=false;
				}
			}
			
			if(!validadoTodosTipoRadioVenci) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoRadioVenciLogicAdditional.checkTipoRadioVenciToSavesAfter(tiporadiovencis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRadioVencis();
			
			connexion.commit();		
			
			this.quitarTipoRadioVencisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoRadioVencis()throws Exception {				
		 try {	
			//TipoRadioVenciLogicAdditional.checkTipoRadioVenciToSaves(tiporadiovencis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoRadioVenci=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRadioVenci tiporadiovenciLocal:tiporadiovencis) {				
				if(tiporadiovenciLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoRadioVenciLogicAdditional.updateTipoRadioVenciToSave(tiporadiovenciLocal,this.arrDatoGeneral);
	        	
				TipoRadioVenciLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporadiovenciLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRadioVenci(tiporadiovenciLocal)) {				
					TipoRadioVenciDataAccess.save(tiporadiovenciLocal, connexion);				
				} else {
					validadoTodosTipoRadioVenci=false;
				}
			}
			
			if(!validadoTodosTipoRadioVenci) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoRadioVenciLogicAdditional.checkTipoRadioVenciToSavesAfter(tiporadiovencis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoRadioVencisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRadioVenciParameterReturnGeneral procesarAccionTipoRadioVencis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRadioVenci> tiporadiovencis,TipoRadioVenciParameterReturnGeneral tiporadiovenciParameterGeneral)throws Exception {
		 try {	
			TipoRadioVenciParameterReturnGeneral tiporadiovenciReturnGeneral=new TipoRadioVenciParameterReturnGeneral();
	
			
			return tiporadiovenciReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRadioVenciParameterReturnGeneral procesarAccionTipoRadioVencisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRadioVenci> tiporadiovencis,TipoRadioVenciParameterReturnGeneral tiporadiovenciParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-procesarAccionTipoRadioVencisWithConnection");connexion.begin();			
			
			TipoRadioVenciParameterReturnGeneral tiporadiovenciReturnGeneral=new TipoRadioVenciParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tiporadiovenciReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRadioVenciParameterReturnGeneral procesarEventosTipoRadioVencis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRadioVenci> tiporadiovencis,TipoRadioVenci tiporadiovenci,TipoRadioVenciParameterReturnGeneral tiporadiovenciParameterGeneral,Boolean isEsNuevoTipoRadioVenci,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoRadioVenciParameterReturnGeneral tiporadiovenciReturnGeneral=new TipoRadioVenciParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporadiovenciReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tiporadiovenciReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoRadioVenciParameterReturnGeneral procesarEventosTipoRadioVencisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRadioVenci> tiporadiovencis,TipoRadioVenci tiporadiovenci,TipoRadioVenciParameterReturnGeneral tiporadiovenciParameterGeneral,Boolean isEsNuevoTipoRadioVenci,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-procesarEventosTipoRadioVencisWithConnection");connexion.begin();			
			
			TipoRadioVenciParameterReturnGeneral tiporadiovenciReturnGeneral=new TipoRadioVenciParameterReturnGeneral();
	
			tiporadiovenciReturnGeneral.setTipoRadioVenci(tiporadiovenci);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporadiovenciReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tiporadiovenciReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRadioVenciParameterReturnGeneral procesarImportacionTipoRadioVencisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoRadioVenciParameterReturnGeneral tiporadiovenciParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-procesarImportacionTipoRadioVencisWithConnection");connexion.begin();			
			
			TipoRadioVenciParameterReturnGeneral tiporadiovenciReturnGeneral=new TipoRadioVenciParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiporadiovencis=new ArrayList<TipoRadioVenci>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiporadiovenci=new TipoRadioVenci();
				
				
				if(conColumnasBase) {this.tiporadiovenci.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiporadiovenci.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiporadiovenci.setnombre(arrColumnas[iColumn++]);
				
				this.tiporadiovencis.add(this.tiporadiovenci);
			}
			
			this.saveTipoRadioVencis();
			
			this.connexion.commit();
			
			tiporadiovenciReturnGeneral.setConRetornoEstaProcesado(true);
			tiporadiovenciReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiporadiovenciReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoRadioVencisEliminados() throws Exception {				
		
		List<TipoRadioVenci> tiporadiovencisAux= new ArrayList<TipoRadioVenci>();
		
		for(TipoRadioVenci tiporadiovenci:tiporadiovencis) {
			if(!tiporadiovenci.getIsDeleted()) {
				tiporadiovencisAux.add(tiporadiovenci);
			}
		}
		
		tiporadiovencis=tiporadiovencisAux;
	}
	
	public void quitarTipoRadioVencisNulos() throws Exception {				
		
		List<TipoRadioVenci> tiporadiovencisAux= new ArrayList<TipoRadioVenci>();
		
		for(TipoRadioVenci tiporadiovenci : this.tiporadiovencis) {
			if(tiporadiovenci==null) {
				tiporadiovencisAux.add(tiporadiovenci);
			}
		}
		
		//this.tiporadiovencis=tiporadiovencisAux;
		
		this.tiporadiovencis.removeAll(tiporadiovencisAux);
	}
	
	public void getSetVersionRowTipoRadioVenciWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiporadiovenci.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiporadiovenci.getIsDeleted() || (tiporadiovenci.getIsChanged()&&!tiporadiovenci.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiporadiovenciDataAccess.getSetVersionRowTipoRadioVenci(connexion,tiporadiovenci.getId());
				
				if(!tiporadiovenci.getVersionRow().equals(timestamp)) {	
					tiporadiovenci.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiporadiovenci.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoRadioVenci()throws Exception {	
		
		if(tiporadiovenci.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiporadiovenci.getIsDeleted() || (tiporadiovenci.getIsChanged()&&!tiporadiovenci.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiporadiovenciDataAccess.getSetVersionRowTipoRadioVenci(connexion,tiporadiovenci.getId());
			
			try {							
				if(!tiporadiovenci.getVersionRow().equals(timestamp)) {	
					tiporadiovenci.setVersionRow(timestamp);
				}
				
				tiporadiovenci.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoRadioVencisWithConnection()throws Exception {	
		if(tiporadiovencis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoRadioVenci tiporadiovenciAux:tiporadiovencis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiporadiovenciAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporadiovenciAux.getIsDeleted() || (tiporadiovenciAux.getIsChanged()&&!tiporadiovenciAux.getIsNew())) {
						
						timestamp=tiporadiovenciDataAccess.getSetVersionRowTipoRadioVenci(connexion,tiporadiovenciAux.getId());
						
						if(!tiporadiovenci.getVersionRow().equals(timestamp)) {	
							tiporadiovenciAux.setVersionRow(timestamp);
						}
								
						tiporadiovenciAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoRadioVencis()throws Exception {	
		if(tiporadiovencis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoRadioVenci tiporadiovenciAux:tiporadiovencis) {
					if(tiporadiovenciAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporadiovenciAux.getIsDeleted() || (tiporadiovenciAux.getIsChanged()&&!tiporadiovenciAux.getIsNew())) {
						
						timestamp=tiporadiovenciDataAccess.getSetVersionRowTipoRadioVenci(connexion,tiporadiovenciAux.getId());
						
						if(!tiporadiovenciAux.getVersionRow().equals(timestamp)) {	
							tiporadiovenciAux.setVersionRow(timestamp);
						}
						
													
						tiporadiovenciAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoRadioVenciWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			RadioVenciProveLogic radiovenciproveLogic=new RadioVenciProveLogic();
			RadioVenciClienteProveLogic radiovenciclienteproveLogic=new RadioVenciClienteProveLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoRadioVenciWithConnection");connexion.begin();
			
			
			classes.add(new Classe(RadioVenciProve.class));
			classes.add(new Classe(RadioVenciClienteProve.class));
											
			

			radiovenciproveLogic.setConnexion(this.getConnexion());
			radiovenciproveLogic.setDatosCliente(this.datosCliente);
			radiovenciproveLogic.setIsConRefrescarForeignKeys(true);

			radiovenciclienteproveLogic.setConnexion(this.getConnexion());
			radiovenciclienteproveLogic.setDatosCliente(this.datosCliente);
			radiovenciclienteproveLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoRadioVenci tiporadiovenci:this.tiporadiovencis) {
				

				classes=new ArrayList<Classe>();
				classes=RadioVenciProveConstantesFunciones.getClassesForeignKeysOfRadioVenciProve(new ArrayList<Classe>(),DeepLoadType.NONE);

				radiovenciproveLogic.setRadioVenciProves(tiporadiovenci.radiovenciproves);
				radiovenciproveLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RadioVenciClienteProveConstantesFunciones.getClassesForeignKeysOfRadioVenciClienteProve(new ArrayList<Classe>(),DeepLoadType.NONE);

				radiovenciclienteproveLogic.setRadioVenciClienteProves(tiporadiovenci.radiovenciclienteproves);
				radiovenciclienteproveLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoRadioVenci tiporadiovenci,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoRadioVenciLogicAdditional.updateTipoRadioVenciToGet(tiporadiovenci,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporadiovenci.setRadioVenciProves(tiporadiovenciDataAccess.getRadioVenciProves(connexion,tiporadiovenci));
		tiporadiovenci.setRadioVenciClienteProves(tiporadiovenciDataAccess.getRadioVenciClienteProves(connexion,tiporadiovenci));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RadioVenciProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporadiovenci.setRadioVenciProves(tiporadiovenciDataAccess.getRadioVenciProves(connexion,tiporadiovenci));

				if(this.isConDeep) {
					RadioVenciProveLogic radiovenciproveLogic= new RadioVenciProveLogic(this.connexion);
					radiovenciproveLogic.setRadioVenciProves(tiporadiovenci.getRadioVenciProves());
					ArrayList<Classe> classesLocal=RadioVenciProveConstantesFunciones.getClassesForeignKeysOfRadioVenciProve(new ArrayList<Classe>(),DeepLoadType.NONE);
					radiovenciproveLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RadioVenciProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciProve(radiovenciproveLogic.getRadioVenciProves());
					tiporadiovenci.setRadioVenciProves(radiovenciproveLogic.getRadioVenciProves());
				}

				continue;
			}

			if(clas.clas.equals(RadioVenciClienteProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporadiovenci.setRadioVenciClienteProves(tiporadiovenciDataAccess.getRadioVenciClienteProves(connexion,tiporadiovenci));

				if(this.isConDeep) {
					RadioVenciClienteProveLogic radiovenciclienteproveLogic= new RadioVenciClienteProveLogic(this.connexion);
					radiovenciclienteproveLogic.setRadioVenciClienteProves(tiporadiovenci.getRadioVenciClienteProves());
					ArrayList<Classe> classesLocal=RadioVenciClienteProveConstantesFunciones.getClassesForeignKeysOfRadioVenciClienteProve(new ArrayList<Classe>(),DeepLoadType.NONE);
					radiovenciclienteproveLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RadioVenciClienteProveConstantesFunciones.refrescarForeignKeysDescripcionesRadioVenciClienteProve(radiovenciclienteproveLogic.getRadioVenciClienteProves());
					tiporadiovenci.setRadioVenciClienteProves(radiovenciclienteproveLogic.getRadioVenciClienteProves());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RadioVenciProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RadioVenciProve.class));
			tiporadiovenci.setRadioVenciProves(tiporadiovenciDataAccess.getRadioVenciProves(connexion,tiporadiovenci));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RadioVenciClienteProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RadioVenciClienteProve.class));
			tiporadiovenci.setRadioVenciClienteProves(tiporadiovenciDataAccess.getRadioVenciClienteProves(connexion,tiporadiovenci));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tiporadiovenci.setRadioVenciProves(tiporadiovenciDataAccess.getRadioVenciProves(connexion,tiporadiovenci));

		for(RadioVenciProve radiovenciprove:tiporadiovenci.getRadioVenciProves()) {
			RadioVenciProveLogic radiovenciproveLogic= new RadioVenciProveLogic(connexion);
			radiovenciproveLogic.deepLoad(radiovenciprove,isDeep,deepLoadType,clases);
		}

		tiporadiovenci.setRadioVenciClienteProves(tiporadiovenciDataAccess.getRadioVenciClienteProves(connexion,tiporadiovenci));

		for(RadioVenciClienteProve radiovenciclienteprove:tiporadiovenci.getRadioVenciClienteProves()) {
			RadioVenciClienteProveLogic radiovenciclienteproveLogic= new RadioVenciClienteProveLogic(connexion);
			radiovenciclienteproveLogic.deepLoad(radiovenciclienteprove,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RadioVenciProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporadiovenci.setRadioVenciProves(tiporadiovenciDataAccess.getRadioVenciProves(connexion,tiporadiovenci));

				for(RadioVenciProve radiovenciprove:tiporadiovenci.getRadioVenciProves()) {
					RadioVenciProveLogic radiovenciproveLogic= new RadioVenciProveLogic(connexion);
					radiovenciproveLogic.deepLoad(radiovenciprove,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RadioVenciClienteProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporadiovenci.setRadioVenciClienteProves(tiporadiovenciDataAccess.getRadioVenciClienteProves(connexion,tiporadiovenci));

				for(RadioVenciClienteProve radiovenciclienteprove:tiporadiovenci.getRadioVenciClienteProves()) {
					RadioVenciClienteProveLogic radiovenciclienteproveLogic= new RadioVenciClienteProveLogic(connexion);
					radiovenciclienteproveLogic.deepLoad(radiovenciclienteprove,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RadioVenciProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RadioVenciProve.class));
			tiporadiovenci.setRadioVenciProves(tiporadiovenciDataAccess.getRadioVenciProves(connexion,tiporadiovenci));

			for(RadioVenciProve radiovenciprove:tiporadiovenci.getRadioVenciProves()) {
				RadioVenciProveLogic radiovenciproveLogic= new RadioVenciProveLogic(connexion);
				radiovenciproveLogic.deepLoad(radiovenciprove,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RadioVenciClienteProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RadioVenciClienteProve.class));
			tiporadiovenci.setRadioVenciClienteProves(tiporadiovenciDataAccess.getRadioVenciClienteProves(connexion,tiporadiovenci));

			for(RadioVenciClienteProve radiovenciclienteprove:tiporadiovenci.getRadioVenciClienteProves()) {
				RadioVenciClienteProveLogic radiovenciclienteproveLogic= new RadioVenciClienteProveLogic(connexion);
				radiovenciclienteproveLogic.deepLoad(radiovenciclienteprove,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoRadioVenci tiporadiovenci,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoRadioVenci.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiporadiovenci,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(tiporadiovenci);
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
			this.deepLoad(this.tiporadiovenci,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovenci);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoRadioVenci.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiporadiovencis!=null) {
				for(TipoRadioVenci tiporadiovenci:tiporadiovencis) {
					this.deepLoad(tiporadiovenci,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(tiporadiovencis);
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
			if(tiporadiovencis!=null) {
				for(TipoRadioVenci tiporadiovenci:tiporadiovencis) {
					this.deepLoad(tiporadiovenci,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(tiporadiovencis);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoRadioVenciPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRadioVenci.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoRadioVenciConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tiporadiovenci=tiporadiovenciDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tiporadiovenci,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovenci);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRadioVenciPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoRadioVenciConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tiporadiovenci=tiporadiovenciDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tiporadiovenci,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoRadioVenciConstantesFunciones.refrescarForeignKeysDescripcionesTipoRadioVenci(this.tiporadiovenci);
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
			if(TipoRadioVenciConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRadioVenciDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoRadioVenci tiporadiovenci,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoRadioVenciConstantesFunciones.ISCONAUDITORIA) {
				if(tiporadiovenci.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRadioVenciDataAccess.TABLENAME, tiporadiovenci.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRadioVenciConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRadioVenciLogic.registrarAuditoriaDetallesTipoRadioVenci(connexion,tiporadiovenci,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiporadiovenci.getIsDeleted()) {
					/*if(!tiporadiovenci.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoRadioVenciDataAccess.TABLENAME, tiporadiovenci.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoRadioVenciLogic.registrarAuditoriaDetallesTipoRadioVenci(connexion,tiporadiovenci,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRadioVenciDataAccess.TABLENAME, tiporadiovenci.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiporadiovenci.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRadioVenciDataAccess.TABLENAME, tiporadiovenci.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRadioVenciConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRadioVenciLogic.registrarAuditoriaDetallesTipoRadioVenci(connexion,tiporadiovenci,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoRadioVenci(Connexion connexion,TipoRadioVenci tiporadiovenci)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiporadiovenci.getIsNew()||!tiporadiovenci.getnombre().equals(tiporadiovenci.getTipoRadioVenciOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporadiovenci.getTipoRadioVenciOriginal().getnombre()!=null)
				{
					strValorActual=tiporadiovenci.getTipoRadioVenciOriginal().getnombre();
				}
				if(tiporadiovenci.getnombre()!=null)
				{
					strValorNuevo=tiporadiovenci.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRadioVenciConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRadioVenci(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRadioVenciConstantesFunciones.getClassesForeignKeysOfTipoRadioVenci(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRadioVenci(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRadioVenciConstantesFunciones.getClassesRelationshipsOfTipoRadioVenci(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

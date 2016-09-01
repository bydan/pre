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
import com.bydan.erp.contabilidad.util.TipoMonedaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoMonedaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoMonedaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoMoneda;
import com.bydan.erp.contabilidad.business.logic.TipoMonedaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoMonedaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoMonedaLogic.class);
	
	protected TipoMonedaDataAccess tipomonedaDataAccess; 	
	protected TipoMoneda tipomoneda;
	protected List<TipoMoneda> tipomonedas;
	protected Object tipomonedaObject;	
	protected List<Object> tipomonedasObject;
	
	public static ClassValidator<TipoMoneda> tipomonedaValidator = new ClassValidator<TipoMoneda>(TipoMoneda.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoMonedaLogicAdditional tipomonedaLogicAdditional=null;
	
	public TipoMonedaLogicAdditional getTipoMonedaLogicAdditional() {
		return this.tipomonedaLogicAdditional;
	}
	
	public void setTipoMonedaLogicAdditional(TipoMonedaLogicAdditional tipomonedaLogicAdditional) {
		try {
			this.tipomonedaLogicAdditional=tipomonedaLogicAdditional;
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
	
	
	
	
	public  TipoMonedaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipomonedaDataAccess = new TipoMonedaDataAccess();
			
			this.tipomonedas= new ArrayList<TipoMoneda>();
			this.tipomoneda= new TipoMoneda();
			
			this.tipomonedaObject=new Object();
			this.tipomonedasObject=new ArrayList<Object>();
				
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
			
			this.tipomonedaDataAccess.setConnexionType(this.connexionType);
			this.tipomonedaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoMonedaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipomonedaDataAccess = new TipoMonedaDataAccess();
			this.tipomonedas= new ArrayList<TipoMoneda>();
			this.tipomoneda= new TipoMoneda();
			this.tipomonedaObject=new Object();
			this.tipomonedasObject=new ArrayList<Object>();
			
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
			
			this.tipomonedaDataAccess.setConnexionType(this.connexionType);
			this.tipomonedaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoMoneda getTipoMoneda() throws Exception {	
		TipoMonedaLogicAdditional.checkTipoMonedaToGet(tipomoneda,this.datosCliente,this.arrDatoGeneral);
		TipoMonedaLogicAdditional.updateTipoMonedaToGet(tipomoneda,this.arrDatoGeneral);
		
		return tipomoneda;
	}
		
	public void setTipoMoneda(TipoMoneda newTipoMoneda) {
		this.tipomoneda = newTipoMoneda;
	}
	
	public TipoMonedaDataAccess getTipoMonedaDataAccess() {
		return tipomonedaDataAccess;
	}
	
	public void setTipoMonedaDataAccess(TipoMonedaDataAccess newtipomonedaDataAccess) {
		this.tipomonedaDataAccess = newtipomonedaDataAccess;
	}
	
	public List<TipoMoneda> getTipoMonedas() throws Exception {		
		this.quitarTipoMonedasNulos();
		
		TipoMonedaLogicAdditional.checkTipoMonedaToGets(tipomonedas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoMoneda tipomonedaLocal: tipomonedas ) {
			TipoMonedaLogicAdditional.updateTipoMonedaToGet(tipomonedaLocal,this.arrDatoGeneral);
		}
		
		return tipomonedas;
	}
	
	public void setTipoMonedas(List<TipoMoneda> newTipoMonedas) {
		this.tipomonedas = newTipoMonedas;
	}
	
	public Object getTipoMonedaObject() {	
		this.tipomonedaObject=this.tipomonedaDataAccess.getEntityObject();
		return this.tipomonedaObject;
	}
		
	public void setTipoMonedaObject(Object newTipoMonedaObject) {
		this.tipomonedaObject = newTipoMonedaObject;
	}
	
	public List<Object> getTipoMonedasObject() {		
		this.tipomonedasObject=this.tipomonedaDataAccess.getEntitiesObject();
		return this.tipomonedasObject;
	}
		
	public void setTipoMonedasObject(List<Object> newTipoMonedasObject) {
		this.tipomonedasObject = newTipoMonedasObject;
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
		
		if(this.tipomonedaDataAccess!=null) {
			this.tipomonedaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipomonedaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipomonedaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipomoneda = new  TipoMoneda();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomoneda=tipomonedaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomoneda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomoneda);
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
		tipomoneda = new  TipoMoneda();
		  		  
        try {
			
			tipomoneda=tipomonedaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomoneda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomoneda);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipomoneda = new  TipoMoneda();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomoneda=tipomonedaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomoneda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomoneda);
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
		tipomoneda = new  TipoMoneda();
		  		  
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
		tipomoneda = new  TipoMoneda();
		  		  
        try {
			
			tipomoneda=tipomonedaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomoneda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomoneda);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipomoneda = new  TipoMoneda();
		  		  
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
		tipomoneda = new  TipoMoneda();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipomonedaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomoneda = new  TipoMoneda();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipomonedaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomoneda = new  TipoMoneda();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipomonedaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomoneda = new  TipoMoneda();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipomonedaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomoneda = new  TipoMoneda();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipomonedaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomoneda = new  TipoMoneda();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipomonedaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomonedas = new  ArrayList<TipoMoneda>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomonedas=tipomonedaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMoneda(tipomonedas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
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
		tipomonedas = new  ArrayList<TipoMoneda>();
		  		  
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
		tipomonedas = new  ArrayList<TipoMoneda>();
		  		  
        try {			
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomonedas=tipomonedaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoMoneda(tipomonedas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipomonedas = new  ArrayList<TipoMoneda>();
		  		  
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
		tipomonedas = new  ArrayList<TipoMoneda>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomonedas=tipomonedaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMoneda(tipomonedas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
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
		tipomonedas = new  ArrayList<TipoMoneda>();
		  		  
        try {
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomonedas=tipomonedaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMoneda(tipomonedas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
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
		tipomonedas = new  ArrayList<TipoMoneda>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomonedas=tipomonedaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMoneda(tipomonedas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
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
		tipomonedas = new  ArrayList<TipoMoneda>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomonedas=tipomonedaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMoneda(tipomonedas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipomoneda = new  TipoMoneda();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomoneda=tipomonedaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMoneda(tipomoneda);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomoneda);
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
		tipomoneda = new  TipoMoneda();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomoneda=tipomonedaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMoneda(tipomoneda);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomoneda);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomonedas = new  ArrayList<TipoMoneda>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomonedas=tipomonedaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMoneda(tipomonedas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
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
		tipomonedas = new  ArrayList<TipoMoneda>();
		  		  
        try {
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomonedas=tipomonedaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMoneda(tipomonedas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoMonedasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipomonedas = new  ArrayList<TipoMoneda>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getTodosTipoMonedasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomonedas=tipomonedaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoMoneda(tipomonedas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
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
	
	public  void  getTodosTipoMonedas(String sFinalQuery,Pagination pagination)throws Exception {
		tipomonedas = new  ArrayList<TipoMoneda>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomonedas=tipomonedaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoMoneda(tipomonedas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoMoneda(TipoMoneda tipomoneda) throws Exception {
		Boolean estaValidado=false;
		
		if(tipomoneda.getIsNew() || tipomoneda.getIsChanged()) { 
			this.invalidValues = tipomonedaValidator.getInvalidValues(tipomoneda);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipomoneda);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoMoneda(List<TipoMoneda> TipoMonedas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoMoneda tipomonedaLocal:tipomonedas) {				
			estaValidadoObjeto=this.validarGuardarTipoMoneda(tipomonedaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoMoneda(List<TipoMoneda> TipoMonedas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoMoneda(tipomonedas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoMoneda(TipoMoneda TipoMoneda) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoMoneda(tipomoneda)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoMoneda tipomoneda) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipomoneda.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoMonedaConstantesFunciones.getTipoMonedaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipomoneda","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoMonedaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoMonedaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoMonedaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-saveTipoMonedaWithConnection");connexion.begin();			
			
			TipoMonedaLogicAdditional.checkTipoMonedaToSave(this.tipomoneda,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoMonedaLogicAdditional.updateTipoMonedaToSave(this.tipomoneda,this.arrDatoGeneral);
			
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomoneda,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoMoneda();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoMoneda(this.tipomoneda)) {
				TipoMonedaDataAccess.save(this.tipomoneda, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipomoneda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoMonedaLogicAdditional.checkTipoMonedaToSaveAfter(this.tipomoneda,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoMoneda();
			
			connexion.commit();			
			
			if(this.tipomoneda.getIsDeleted()) {
				this.tipomoneda=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoMoneda()throws Exception {	
		try {	
			
			TipoMonedaLogicAdditional.checkTipoMonedaToSave(this.tipomoneda,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoMonedaLogicAdditional.updateTipoMonedaToSave(this.tipomoneda,this.arrDatoGeneral);
			
			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomoneda,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoMoneda(this.tipomoneda)) {			
				TipoMonedaDataAccess.save(this.tipomoneda, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipomoneda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoMonedaLogicAdditional.checkTipoMonedaToSaveAfter(this.tipomoneda,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipomoneda.getIsDeleted()) {
				this.tipomoneda=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoMonedasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-saveTipoMonedasWithConnection");connexion.begin();			
			
			TipoMonedaLogicAdditional.checkTipoMonedaToSaves(tipomonedas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoMonedas();
			
			Boolean validadoTodosTipoMoneda=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoMoneda tipomonedaLocal:tipomonedas) {		
				if(tipomonedaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoMonedaLogicAdditional.updateTipoMonedaToSave(tipomonedaLocal,this.arrDatoGeneral);
	        	
				TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomonedaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoMoneda(tipomonedaLocal)) {
					TipoMonedaDataAccess.save(tipomonedaLocal, connexion);				
				} else {
					validadoTodosTipoMoneda=false;
				}
			}
			
			if(!validadoTodosTipoMoneda) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoMonedaLogicAdditional.checkTipoMonedaToSavesAfter(tipomonedas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoMonedas();
			
			connexion.commit();		
			
			this.quitarTipoMonedasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoMonedas()throws Exception {				
		 try {	
			TipoMonedaLogicAdditional.checkTipoMonedaToSaves(tipomonedas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoMoneda=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoMoneda tipomonedaLocal:tipomonedas) {				
				if(tipomonedaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoMonedaLogicAdditional.updateTipoMonedaToSave(tipomonedaLocal,this.arrDatoGeneral);
	        	
				TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomonedaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoMoneda(tipomonedaLocal)) {				
					TipoMonedaDataAccess.save(tipomonedaLocal, connexion);				
				} else {
					validadoTodosTipoMoneda=false;
				}
			}
			
			if(!validadoTodosTipoMoneda) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoMonedaLogicAdditional.checkTipoMonedaToSavesAfter(tipomonedas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoMonedasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoMonedaParameterReturnGeneral procesarAccionTipoMonedas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoMoneda> tipomonedas,TipoMonedaParameterReturnGeneral tipomonedaParameterGeneral)throws Exception {
		 try {	
			TipoMonedaParameterReturnGeneral tipomonedaReturnGeneral=new TipoMonedaParameterReturnGeneral();
	
			TipoMonedaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipomonedas,tipomonedaParameterGeneral,tipomonedaReturnGeneral);
			
			return tipomonedaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoMonedaParameterReturnGeneral procesarAccionTipoMonedasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoMoneda> tipomonedas,TipoMonedaParameterReturnGeneral tipomonedaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-procesarAccionTipoMonedasWithConnection");connexion.begin();			
			
			TipoMonedaParameterReturnGeneral tipomonedaReturnGeneral=new TipoMonedaParameterReturnGeneral();
	
			TipoMonedaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipomonedas,tipomonedaParameterGeneral,tipomonedaReturnGeneral);
			
			this.connexion.commit();
			
			return tipomonedaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoMonedaParameterReturnGeneral procesarEventosTipoMonedas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoMoneda> tipomonedas,TipoMoneda tipomoneda,TipoMonedaParameterReturnGeneral tipomonedaParameterGeneral,Boolean isEsNuevoTipoMoneda,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoMonedaParameterReturnGeneral tipomonedaReturnGeneral=new TipoMonedaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomonedaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoMonedaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipomonedas,tipomoneda,tipomonedaParameterGeneral,tipomonedaReturnGeneral,isEsNuevoTipoMoneda,clases);
			
			return tipomonedaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoMonedaParameterReturnGeneral procesarEventosTipoMonedasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoMoneda> tipomonedas,TipoMoneda tipomoneda,TipoMonedaParameterReturnGeneral tipomonedaParameterGeneral,Boolean isEsNuevoTipoMoneda,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-procesarEventosTipoMonedasWithConnection");connexion.begin();			
			
			TipoMonedaParameterReturnGeneral tipomonedaReturnGeneral=new TipoMonedaParameterReturnGeneral();
	
			tipomonedaReturnGeneral.setTipoMoneda(tipomoneda);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomonedaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoMonedaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipomonedas,tipomoneda,tipomonedaParameterGeneral,tipomonedaReturnGeneral,isEsNuevoTipoMoneda,clases);
			
			this.connexion.commit();
			
			return tipomonedaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoMonedaParameterReturnGeneral procesarImportacionTipoMonedasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoMonedaParameterReturnGeneral tipomonedaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-procesarImportacionTipoMonedasWithConnection");connexion.begin();			
			
			TipoMonedaParameterReturnGeneral tipomonedaReturnGeneral=new TipoMonedaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipomonedas=new ArrayList<TipoMoneda>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipomoneda=new TipoMoneda();
				
				
				if(conColumnasBase) {this.tipomoneda.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipomoneda.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipomoneda.setnombre(arrColumnas[iColumn++]);
				this.tipomoneda.setsigla(arrColumnas[iColumn++]);
				this.tipomoneda.setsimbolo(arrColumnas[iColumn++]);
				this.tipomoneda.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tipomonedas.add(this.tipomoneda);
			}
			
			this.saveTipoMonedas();
			
			this.connexion.commit();
			
			tipomonedaReturnGeneral.setConRetornoEstaProcesado(true);
			tipomonedaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipomonedaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoMonedasEliminados() throws Exception {				
		
		List<TipoMoneda> tipomonedasAux= new ArrayList<TipoMoneda>();
		
		for(TipoMoneda tipomoneda:tipomonedas) {
			if(!tipomoneda.getIsDeleted()) {
				tipomonedasAux.add(tipomoneda);
			}
		}
		
		tipomonedas=tipomonedasAux;
	}
	
	public void quitarTipoMonedasNulos() throws Exception {				
		
		List<TipoMoneda> tipomonedasAux= new ArrayList<TipoMoneda>();
		
		for(TipoMoneda tipomoneda : this.tipomonedas) {
			if(tipomoneda==null) {
				tipomonedasAux.add(tipomoneda);
			}
		}
		
		//this.tipomonedas=tipomonedasAux;
		
		this.tipomonedas.removeAll(tipomonedasAux);
	}
	
	public void getSetVersionRowTipoMonedaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipomoneda.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipomoneda.getIsDeleted() || (tipomoneda.getIsChanged()&&!tipomoneda.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipomonedaDataAccess.getSetVersionRowTipoMoneda(connexion,tipomoneda.getId());
				
				if(!tipomoneda.getVersionRow().equals(timestamp)) {	
					tipomoneda.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipomoneda.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoMoneda()throws Exception {	
		
		if(tipomoneda.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipomoneda.getIsDeleted() || (tipomoneda.getIsChanged()&&!tipomoneda.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipomonedaDataAccess.getSetVersionRowTipoMoneda(connexion,tipomoneda.getId());
			
			try {							
				if(!tipomoneda.getVersionRow().equals(timestamp)) {	
					tipomoneda.setVersionRow(timestamp);
				}
				
				tipomoneda.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoMonedasWithConnection()throws Exception {	
		if(tipomonedas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoMoneda tipomonedaAux:tipomonedas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipomonedaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomonedaAux.getIsDeleted() || (tipomonedaAux.getIsChanged()&&!tipomonedaAux.getIsNew())) {
						
						timestamp=tipomonedaDataAccess.getSetVersionRowTipoMoneda(connexion,tipomonedaAux.getId());
						
						if(!tipomoneda.getVersionRow().equals(timestamp)) {	
							tipomonedaAux.setVersionRow(timestamp);
						}
								
						tipomonedaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoMonedas()throws Exception {	
		if(tipomonedas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoMoneda tipomonedaAux:tipomonedas) {
					if(tipomonedaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomonedaAux.getIsDeleted() || (tipomonedaAux.getIsChanged()&&!tipomonedaAux.getIsNew())) {
						
						timestamp=tipomonedaDataAccess.getSetVersionRowTipoMoneda(connexion,tipomonedaAux.getId());
						
						if(!tipomonedaAux.getVersionRow().equals(timestamp)) {	
							tipomonedaAux.setVersionRow(timestamp);
						}
						
													
						tipomonedaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoMonedaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic=new ParametroContabilidadDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoMonedaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ParametroContabilidadDefecto.class));
											
			

			parametrocontabilidaddefectoLogic.setConnexion(this.getConnexion());
			parametrocontabilidaddefectoLogic.setDatosCliente(this.datosCliente);
			parametrocontabilidaddefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoMoneda tipomoneda:this.tipomonedas) {
				

				classes=new ArrayList<Classe>();
				classes=ParametroContabilidadDefectoConstantesFunciones.getClassesForeignKeysOfParametroContabilidadDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocontabilidaddefectoLogic.setParametroContabilidadDefectos(tipomoneda.parametrocontabilidaddefectos);
				parametrocontabilidaddefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoMoneda tipomoneda,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoMonedaLogicAdditional.updateTipoMonedaToGet(tipomoneda,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomoneda.setParametroContabilidadDefectos(tipomonedaDataAccess.getParametroContabilidadDefectos(connexion,tipomoneda));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomoneda.setParametroContabilidadDefectos(tipomonedaDataAccess.getParametroContabilidadDefectos(connexion,tipomoneda));

				if(this.isConDeep) {
					ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(this.connexion);
					parametrocontabilidaddefectoLogic.setParametroContabilidadDefectos(tipomoneda.getParametroContabilidadDefectos());
					ArrayList<Classe> classesLocal=ParametroContabilidadDefectoConstantesFunciones.getClassesForeignKeysOfParametroContabilidadDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocontabilidaddefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(parametrocontabilidaddefectoLogic.getParametroContabilidadDefectos());
					tipomoneda.setParametroContabilidadDefectos(parametrocontabilidaddefectoLogic.getParametroContabilidadDefectos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroContabilidadDefecto.class));
			tipomoneda.setParametroContabilidadDefectos(tipomonedaDataAccess.getParametroContabilidadDefectos(connexion,tipomoneda));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipomoneda.setParametroContabilidadDefectos(tipomonedaDataAccess.getParametroContabilidadDefectos(connexion,tipomoneda));

		for(ParametroContabilidadDefecto parametrocontabilidaddefecto:tipomoneda.getParametroContabilidadDefectos()) {
			ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(connexion);
			parametrocontabilidaddefectoLogic.deepLoad(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomoneda.setParametroContabilidadDefectos(tipomonedaDataAccess.getParametroContabilidadDefectos(connexion,tipomoneda));

				for(ParametroContabilidadDefecto parametrocontabilidaddefecto:tipomoneda.getParametroContabilidadDefectos()) {
					ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(connexion);
					parametrocontabilidaddefectoLogic.deepLoad(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroContabilidadDefecto.class));
			tipomoneda.setParametroContabilidadDefectos(tipomonedaDataAccess.getParametroContabilidadDefectos(connexion,tipomoneda));

			for(ParametroContabilidadDefecto parametrocontabilidaddefecto:tipomoneda.getParametroContabilidadDefectos()) {
				ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(connexion);
				parametrocontabilidaddefectoLogic.deepLoad(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoMoneda tipomoneda,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoMonedaLogicAdditional.updateTipoMonedaToSave(tipomoneda,this.arrDatoGeneral);
			
TipoMonedaDataAccess.save(tipomoneda, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(ParametroContabilidadDefecto parametrocontabilidaddefecto:tipomoneda.getParametroContabilidadDefectos()) {
			parametrocontabilidaddefecto.setid_tipo_moneda(tipomoneda.getId());
			ParametroContabilidadDefectoDataAccess.save(parametrocontabilidaddefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroContabilidadDefecto parametrocontabilidaddefecto:tipomoneda.getParametroContabilidadDefectos()) {
					parametrocontabilidaddefecto.setid_tipo_moneda(tipomoneda.getId());
					ParametroContabilidadDefectoDataAccess.save(parametrocontabilidaddefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(ParametroContabilidadDefecto parametrocontabilidaddefecto:tipomoneda.getParametroContabilidadDefectos()) {
			ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(connexion);
			parametrocontabilidaddefecto.setid_tipo_moneda(tipomoneda.getId());
			ParametroContabilidadDefectoDataAccess.save(parametrocontabilidaddefecto,connexion);
			parametrocontabilidaddefectoLogic.deepSave(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroContabilidadDefecto parametrocontabilidaddefecto:tipomoneda.getParametroContabilidadDefectos()) {
					ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(connexion);
					parametrocontabilidaddefecto.setid_tipo_moneda(tipomoneda.getId());
					ParametroContabilidadDefectoDataAccess.save(parametrocontabilidaddefecto,connexion);
					parametrocontabilidaddefectoLogic.deepSave(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoMoneda.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipomoneda,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(tipomoneda);
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
			this.deepLoad(this.tipomoneda,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomoneda);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoMoneda.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipomonedas!=null) {
				for(TipoMoneda tipomoneda:tipomonedas) {
					this.deepLoad(tipomoneda,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(tipomonedas);
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
			if(tipomonedas!=null) {
				for(TipoMoneda tipomoneda:tipomonedas) {
					this.deepLoad(tipomoneda,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(tipomonedas);
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
			this.getNewConnexionToDeep(TipoMoneda.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipomoneda,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoMoneda.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipomonedas!=null) {
				for(TipoMoneda tipomoneda:tipomonedas) {
					this.deepSave(tipomoneda,isDeep,deepLoadType,clases);
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
			if(tipomonedas!=null) {
				for(TipoMoneda tipomoneda:tipomonedas) {
					this.deepSave(tipomoneda,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoMonedasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoMonedaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomonedas=tipomonedaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMonedasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoMonedaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomonedas=tipomonedaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoMonedasBusquedaPorSiglaWithConnection(String sFinalQuery,Pagination pagination,String sigla)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSigla= new ParameterSelectionGeneral();
			parameterSelectionGeneralSigla.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+sigla+"%",TipoMonedaConstantesFunciones.SIGLA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSigla);

			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSigla","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomonedas=tipomonedaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMonedasBusquedaPorSigla(String sFinalQuery,Pagination pagination,String sigla)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSigla= new ParameterSelectionGeneral();
			parameterSelectionGeneralSigla.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+sigla+"%",TipoMonedaConstantesFunciones.SIGLA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSigla);

			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSigla","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomonedas=tipomonedaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoMonedasBusquedaPorSimboloWithConnection(String sFinalQuery,Pagination pagination,String simbolo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSimbolo= new ParameterSelectionGeneral();
			parameterSelectionGeneralSimbolo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+simbolo+"%",TipoMonedaConstantesFunciones.SIMBOLO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSimbolo);

			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSimbolo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomonedas=tipomonedaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMonedasBusquedaPorSimbolo(String sFinalQuery,Pagination pagination,String simbolo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSimbolo= new ParameterSelectionGeneral();
			parameterSelectionGeneralSimbolo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+simbolo+"%",TipoMonedaConstantesFunciones.SIMBOLO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSimbolo);

			TipoMonedaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSimbolo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomonedas=tipomonedaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomonedas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoMonedaPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoneda.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoMonedaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipomoneda=tipomonedaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipomoneda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomoneda);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMonedaPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoMonedaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipomoneda=tipomonedaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipomoneda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoMonedaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoneda(this.tipomoneda);
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
			if(TipoMonedaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMonedaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoMoneda tipomoneda,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoMonedaConstantesFunciones.ISCONAUDITORIA) {
				if(tipomoneda.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMonedaDataAccess.TABLENAME, tipomoneda.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoMonedaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoMonedaLogic.registrarAuditoriaDetallesTipoMoneda(connexion,tipomoneda,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipomoneda.getIsDeleted()) {
					/*if(!tipomoneda.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoMonedaDataAccess.TABLENAME, tipomoneda.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoMonedaLogic.registrarAuditoriaDetallesTipoMoneda(connexion,tipomoneda,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMonedaDataAccess.TABLENAME, tipomoneda.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipomoneda.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMonedaDataAccess.TABLENAME, tipomoneda.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoMonedaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoMonedaLogic.registrarAuditoriaDetallesTipoMoneda(connexion,tipomoneda,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoMoneda(Connexion connexion,TipoMoneda tipomoneda)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipomoneda.getIsNew()||!tipomoneda.getnombre().equals(tipomoneda.getTipoMonedaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomoneda.getTipoMonedaOriginal().getnombre()!=null)
				{
					strValorActual=tipomoneda.getTipoMonedaOriginal().getnombre();
				}
				if(tipomoneda.getnombre()!=null)
				{
					strValorNuevo=tipomoneda.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMonedaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipomoneda.getIsNew()||!tipomoneda.getsigla().equals(tipomoneda.getTipoMonedaOriginal().getsigla()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomoneda.getTipoMonedaOriginal().getsigla()!=null)
				{
					strValorActual=tipomoneda.getTipoMonedaOriginal().getsigla();
				}
				if(tipomoneda.getsigla()!=null)
				{
					strValorNuevo=tipomoneda.getsigla() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMonedaConstantesFunciones.SIGLA,strValorActual,strValorNuevo);
			}	
			
			if(tipomoneda.getIsNew()||!tipomoneda.getsimbolo().equals(tipomoneda.getTipoMonedaOriginal().getsimbolo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomoneda.getTipoMonedaOriginal().getsimbolo()!=null)
				{
					strValorActual=tipomoneda.getTipoMonedaOriginal().getsimbolo();
				}
				if(tipomoneda.getsimbolo()!=null)
				{
					strValorNuevo=tipomoneda.getsimbolo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMonedaConstantesFunciones.SIMBOLO,strValorActual,strValorNuevo);
			}	
			
			if(tipomoneda.getIsNew()||!tipomoneda.getesta_activo().equals(tipomoneda.getTipoMonedaOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomoneda.getTipoMonedaOriginal().getesta_activo()!=null)
				{
					strValorActual=tipomoneda.getTipoMonedaOriginal().getesta_activo().toString();
				}
				if(tipomoneda.getesta_activo()!=null)
				{
					strValorNuevo=tipomoneda.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMonedaConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoMonedaRelacionesWithConnection(TipoMoneda tipomoneda,List<ParametroContabilidadDefecto> parametrocontabilidaddefectos) throws Exception {

		if(!tipomoneda.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoMonedaRelacionesBase(tipomoneda,parametrocontabilidaddefectos,true);
		}
	}

	public void saveTipoMonedaRelaciones(TipoMoneda tipomoneda,List<ParametroContabilidadDefecto> parametrocontabilidaddefectos)throws Exception {

		if(!tipomoneda.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoMonedaRelacionesBase(tipomoneda,parametrocontabilidaddefectos,false);
		}
	}

	public void saveTipoMonedaRelacionesBase(TipoMoneda tipomoneda,List<ParametroContabilidadDefecto> parametrocontabilidaddefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoMoneda-saveRelacionesWithConnection");}
	
			tipomoneda.setParametroContabilidadDefectos(parametrocontabilidaddefectos);

			this.setTipoMoneda(tipomoneda);

				if((tipomoneda.getIsNew()||tipomoneda.getIsChanged())&&!tipomoneda.getIsDeleted()) {
					this.saveTipoMoneda();
					this.saveTipoMonedaRelacionesDetalles(parametrocontabilidaddefectos);

				} else if(tipomoneda.getIsDeleted()) {
					this.saveTipoMonedaRelacionesDetalles(parametrocontabilidaddefectos);
					this.saveTipoMoneda();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ParametroContabilidadDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroContabilidadDefectos(parametrocontabilidaddefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoMonedaRelacionesDetalles(List<ParametroContabilidadDefecto> parametrocontabilidaddefectos)throws Exception {
		try {
	

			Long idTipoMonedaActual=this.getTipoMoneda().getId();

			ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic_Desde_TipoMoneda=new ParametroContabilidadDefectoLogic();
			parametrocontabilidaddefectoLogic_Desde_TipoMoneda.setParametroContabilidadDefectos(parametrocontabilidaddefectos);

			parametrocontabilidaddefectoLogic_Desde_TipoMoneda.setConnexion(this.getConnexion());
			parametrocontabilidaddefectoLogic_Desde_TipoMoneda.setDatosCliente(this.datosCliente);

			for(ParametroContabilidadDefecto parametrocontabilidaddefecto_Desde_TipoMoneda:parametrocontabilidaddefectoLogic_Desde_TipoMoneda.getParametroContabilidadDefectos()) {
				parametrocontabilidaddefecto_Desde_TipoMoneda.setid_tipo_moneda(idTipoMonedaActual);
			}

			parametrocontabilidaddefectoLogic_Desde_TipoMoneda.saveParametroContabilidadDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMoneda(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoMonedaConstantesFunciones.getClassesForeignKeysOfTipoMoneda(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMoneda(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoMonedaConstantesFunciones.getClassesRelationshipsOfTipoMoneda(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.facturacion.util.TipoParamFactuPlazoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoParamFactuPlazoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoParamFactuPlazoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoParamFactuPlazo;
import com.bydan.erp.facturacion.business.logic.TipoParamFactuPlazoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoParamFactuPlazoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoParamFactuPlazoLogic.class);
	
	protected TipoParamFactuPlazoDataAccess tipoparamfactuplazoDataAccess; 	
	protected TipoParamFactuPlazo tipoparamfactuplazo;
	protected List<TipoParamFactuPlazo> tipoparamfactuplazos;
	protected Object tipoparamfactuplazoObject;	
	protected List<Object> tipoparamfactuplazosObject;
	
	public static ClassValidator<TipoParamFactuPlazo> tipoparamfactuplazoValidator = new ClassValidator<TipoParamFactuPlazo>(TipoParamFactuPlazo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoParamFactuPlazoLogicAdditional tipoparamfactuplazoLogicAdditional=null;
	
	public TipoParamFactuPlazoLogicAdditional getTipoParamFactuPlazoLogicAdditional() {
		return this.tipoparamfactuplazoLogicAdditional;
	}
	
	public void setTipoParamFactuPlazoLogicAdditional(TipoParamFactuPlazoLogicAdditional tipoparamfactuplazoLogicAdditional) {
		try {
			this.tipoparamfactuplazoLogicAdditional=tipoparamfactuplazoLogicAdditional;
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
	
	
	
	
	public  TipoParamFactuPlazoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoparamfactuplazoDataAccess = new TipoParamFactuPlazoDataAccess();
			
			this.tipoparamfactuplazos= new ArrayList<TipoParamFactuPlazo>();
			this.tipoparamfactuplazo= new TipoParamFactuPlazo();
			
			this.tipoparamfactuplazoObject=new Object();
			this.tipoparamfactuplazosObject=new ArrayList<Object>();
				
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
			
			this.tipoparamfactuplazoDataAccess.setConnexionType(this.connexionType);
			this.tipoparamfactuplazoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoParamFactuPlazoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoparamfactuplazoDataAccess = new TipoParamFactuPlazoDataAccess();
			this.tipoparamfactuplazos= new ArrayList<TipoParamFactuPlazo>();
			this.tipoparamfactuplazo= new TipoParamFactuPlazo();
			this.tipoparamfactuplazoObject=new Object();
			this.tipoparamfactuplazosObject=new ArrayList<Object>();
			
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
			
			this.tipoparamfactuplazoDataAccess.setConnexionType(this.connexionType);
			this.tipoparamfactuplazoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoParamFactuPlazo getTipoParamFactuPlazo() throws Exception {	
		TipoParamFactuPlazoLogicAdditional.checkTipoParamFactuPlazoToGet(tipoparamfactuplazo,this.datosCliente,this.arrDatoGeneral);
		TipoParamFactuPlazoLogicAdditional.updateTipoParamFactuPlazoToGet(tipoparamfactuplazo,this.arrDatoGeneral);
		
		return tipoparamfactuplazo;
	}
		
	public void setTipoParamFactuPlazo(TipoParamFactuPlazo newTipoParamFactuPlazo) {
		this.tipoparamfactuplazo = newTipoParamFactuPlazo;
	}
	
	public TipoParamFactuPlazoDataAccess getTipoParamFactuPlazoDataAccess() {
		return tipoparamfactuplazoDataAccess;
	}
	
	public void setTipoParamFactuPlazoDataAccess(TipoParamFactuPlazoDataAccess newtipoparamfactuplazoDataAccess) {
		this.tipoparamfactuplazoDataAccess = newtipoparamfactuplazoDataAccess;
	}
	
	public List<TipoParamFactuPlazo> getTipoParamFactuPlazos() throws Exception {		
		this.quitarTipoParamFactuPlazosNulos();
		
		TipoParamFactuPlazoLogicAdditional.checkTipoParamFactuPlazoToGets(tipoparamfactuplazos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoParamFactuPlazo tipoparamfactuplazoLocal: tipoparamfactuplazos ) {
			TipoParamFactuPlazoLogicAdditional.updateTipoParamFactuPlazoToGet(tipoparamfactuplazoLocal,this.arrDatoGeneral);
		}
		
		return tipoparamfactuplazos;
	}
	
	public void setTipoParamFactuPlazos(List<TipoParamFactuPlazo> newTipoParamFactuPlazos) {
		this.tipoparamfactuplazos = newTipoParamFactuPlazos;
	}
	
	public Object getTipoParamFactuPlazoObject() {	
		this.tipoparamfactuplazoObject=this.tipoparamfactuplazoDataAccess.getEntityObject();
		return this.tipoparamfactuplazoObject;
	}
		
	public void setTipoParamFactuPlazoObject(Object newTipoParamFactuPlazoObject) {
		this.tipoparamfactuplazoObject = newTipoParamFactuPlazoObject;
	}
	
	public List<Object> getTipoParamFactuPlazosObject() {		
		this.tipoparamfactuplazosObject=this.tipoparamfactuplazoDataAccess.getEntitiesObject();
		return this.tipoparamfactuplazosObject;
	}
		
	public void setTipoParamFactuPlazosObject(List<Object> newTipoParamFactuPlazosObject) {
		this.tipoparamfactuplazosObject = newTipoParamFactuPlazosObject;
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
		
		if(this.tipoparamfactuplazoDataAccess!=null) {
			this.tipoparamfactuplazoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoparamfactuplazoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoparamfactuplazoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoparamfactuplazo=tipoparamfactuplazoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactuplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazo);
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
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		  		  
        try {
			
			tipoparamfactuplazo=tipoparamfactuplazoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactuplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoparamfactuplazo=tipoparamfactuplazoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactuplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazo);
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
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		  		  
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
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		  		  
        try {
			
			tipoparamfactuplazo=tipoparamfactuplazoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactuplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		  		  
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
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoparamfactuplazoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoparamfactuplazoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoparamfactuplazoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoparamfactuplazoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoparamfactuplazoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoparamfactuplazoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoparamfactuplazos = new  ArrayList<TipoParamFactuPlazo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactuplazos=tipoparamfactuplazoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuPlazo(tipoparamfactuplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazos);
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
		tipoparamfactuplazos = new  ArrayList<TipoParamFactuPlazo>();
		  		  
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
		tipoparamfactuplazos = new  ArrayList<TipoParamFactuPlazo>();
		  		  
        try {			
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactuplazos=tipoparamfactuplazoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoParamFactuPlazo(tipoparamfactuplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoparamfactuplazos = new  ArrayList<TipoParamFactuPlazo>();
		  		  
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
		tipoparamfactuplazos = new  ArrayList<TipoParamFactuPlazo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactuplazos=tipoparamfactuplazoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuPlazo(tipoparamfactuplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazos);
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
		tipoparamfactuplazos = new  ArrayList<TipoParamFactuPlazo>();
		  		  
        try {
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactuplazos=tipoparamfactuplazoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuPlazo(tipoparamfactuplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazos);
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
		tipoparamfactuplazos = new  ArrayList<TipoParamFactuPlazo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactuplazos=tipoparamfactuplazoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuPlazo(tipoparamfactuplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazos);
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
		tipoparamfactuplazos = new  ArrayList<TipoParamFactuPlazo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactuplazos=tipoparamfactuplazoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuPlazo(tipoparamfactuplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactuplazo=tipoparamfactuplazoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuPlazo(tipoparamfactuplazo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazo);
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
		tipoparamfactuplazo = new  TipoParamFactuPlazo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactuplazo=tipoparamfactuplazoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuPlazo(tipoparamfactuplazo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoparamfactuplazos = new  ArrayList<TipoParamFactuPlazo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactuplazos=tipoparamfactuplazoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuPlazo(tipoparamfactuplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazos);
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
		tipoparamfactuplazos = new  ArrayList<TipoParamFactuPlazo>();
		  		  
        try {
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactuplazos=tipoparamfactuplazoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuPlazo(tipoparamfactuplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoParamFactuPlazosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoparamfactuplazos = new  ArrayList<TipoParamFactuPlazo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getTodosTipoParamFactuPlazosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactuplazos=tipoparamfactuplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoParamFactuPlazo(tipoparamfactuplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazos);
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
	
	public  void  getTodosTipoParamFactuPlazos(String sFinalQuery,Pagination pagination)throws Exception {
		tipoparamfactuplazos = new  ArrayList<TipoParamFactuPlazo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactuplazos=tipoparamfactuplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoParamFactuPlazo(tipoparamfactuplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoParamFactuPlazo(TipoParamFactuPlazo tipoparamfactuplazo) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoparamfactuplazo.getIsNew() || tipoparamfactuplazo.getIsChanged()) { 
			this.invalidValues = tipoparamfactuplazoValidator.getInvalidValues(tipoparamfactuplazo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoparamfactuplazo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoParamFactuPlazo(List<TipoParamFactuPlazo> TipoParamFactuPlazos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoParamFactuPlazo tipoparamfactuplazoLocal:tipoparamfactuplazos) {				
			estaValidadoObjeto=this.validarGuardarTipoParamFactuPlazo(tipoparamfactuplazoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoParamFactuPlazo(List<TipoParamFactuPlazo> TipoParamFactuPlazos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoParamFactuPlazo(tipoparamfactuplazos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoParamFactuPlazo(TipoParamFactuPlazo TipoParamFactuPlazo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoParamFactuPlazo(tipoparamfactuplazo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoParamFactuPlazo tipoparamfactuplazo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoparamfactuplazo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoParamFactuPlazoConstantesFunciones.getTipoParamFactuPlazoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoparamfactuplazo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoParamFactuPlazoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoParamFactuPlazoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoParamFactuPlazoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-saveTipoParamFactuPlazoWithConnection");connexion.begin();			
			
			TipoParamFactuPlazoLogicAdditional.checkTipoParamFactuPlazoToSave(this.tipoparamfactuplazo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoParamFactuPlazoLogicAdditional.updateTipoParamFactuPlazoToSave(this.tipoparamfactuplazo,this.arrDatoGeneral);
			
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoparamfactuplazo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoParamFactuPlazo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoParamFactuPlazo(this.tipoparamfactuplazo)) {
				TipoParamFactuPlazoDataAccess.save(this.tipoparamfactuplazo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoparamfactuplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoParamFactuPlazoLogicAdditional.checkTipoParamFactuPlazoToSaveAfter(this.tipoparamfactuplazo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoParamFactuPlazo();
			
			connexion.commit();			
			
			if(this.tipoparamfactuplazo.getIsDeleted()) {
				this.tipoparamfactuplazo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoParamFactuPlazo()throws Exception {	
		try {	
			
			TipoParamFactuPlazoLogicAdditional.checkTipoParamFactuPlazoToSave(this.tipoparamfactuplazo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoParamFactuPlazoLogicAdditional.updateTipoParamFactuPlazoToSave(this.tipoparamfactuplazo,this.arrDatoGeneral);
			
			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoparamfactuplazo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoParamFactuPlazo(this.tipoparamfactuplazo)) {			
				TipoParamFactuPlazoDataAccess.save(this.tipoparamfactuplazo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoparamfactuplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoParamFactuPlazoLogicAdditional.checkTipoParamFactuPlazoToSaveAfter(this.tipoparamfactuplazo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoparamfactuplazo.getIsDeleted()) {
				this.tipoparamfactuplazo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoParamFactuPlazosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-saveTipoParamFactuPlazosWithConnection");connexion.begin();			
			
			TipoParamFactuPlazoLogicAdditional.checkTipoParamFactuPlazoToSaves(tipoparamfactuplazos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoParamFactuPlazos();
			
			Boolean validadoTodosTipoParamFactuPlazo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoParamFactuPlazo tipoparamfactuplazoLocal:tipoparamfactuplazos) {		
				if(tipoparamfactuplazoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoParamFactuPlazoLogicAdditional.updateTipoParamFactuPlazoToSave(tipoparamfactuplazoLocal,this.arrDatoGeneral);
	        	
				TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoparamfactuplazoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoParamFactuPlazo(tipoparamfactuplazoLocal)) {
					TipoParamFactuPlazoDataAccess.save(tipoparamfactuplazoLocal, connexion);				
				} else {
					validadoTodosTipoParamFactuPlazo=false;
				}
			}
			
			if(!validadoTodosTipoParamFactuPlazo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoParamFactuPlazoLogicAdditional.checkTipoParamFactuPlazoToSavesAfter(tipoparamfactuplazos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoParamFactuPlazos();
			
			connexion.commit();		
			
			this.quitarTipoParamFactuPlazosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoParamFactuPlazos()throws Exception {				
		 try {	
			TipoParamFactuPlazoLogicAdditional.checkTipoParamFactuPlazoToSaves(tipoparamfactuplazos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoParamFactuPlazo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoParamFactuPlazo tipoparamfactuplazoLocal:tipoparamfactuplazos) {				
				if(tipoparamfactuplazoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoParamFactuPlazoLogicAdditional.updateTipoParamFactuPlazoToSave(tipoparamfactuplazoLocal,this.arrDatoGeneral);
	        	
				TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoparamfactuplazoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoParamFactuPlazo(tipoparamfactuplazoLocal)) {				
					TipoParamFactuPlazoDataAccess.save(tipoparamfactuplazoLocal, connexion);				
				} else {
					validadoTodosTipoParamFactuPlazo=false;
				}
			}
			
			if(!validadoTodosTipoParamFactuPlazo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoParamFactuPlazoLogicAdditional.checkTipoParamFactuPlazoToSavesAfter(tipoparamfactuplazos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoParamFactuPlazosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoParamFactuPlazoParameterReturnGeneral procesarAccionTipoParamFactuPlazos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoParamFactuPlazo> tipoparamfactuplazos,TipoParamFactuPlazoParameterReturnGeneral tipoparamfactuplazoParameterGeneral)throws Exception {
		 try {	
			TipoParamFactuPlazoParameterReturnGeneral tipoparamfactuplazoReturnGeneral=new TipoParamFactuPlazoParameterReturnGeneral();
	
			TipoParamFactuPlazoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoparamfactuplazos,tipoparamfactuplazoParameterGeneral,tipoparamfactuplazoReturnGeneral);
			
			return tipoparamfactuplazoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoParamFactuPlazoParameterReturnGeneral procesarAccionTipoParamFactuPlazosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoParamFactuPlazo> tipoparamfactuplazos,TipoParamFactuPlazoParameterReturnGeneral tipoparamfactuplazoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-procesarAccionTipoParamFactuPlazosWithConnection");connexion.begin();			
			
			TipoParamFactuPlazoParameterReturnGeneral tipoparamfactuplazoReturnGeneral=new TipoParamFactuPlazoParameterReturnGeneral();
	
			TipoParamFactuPlazoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoparamfactuplazos,tipoparamfactuplazoParameterGeneral,tipoparamfactuplazoReturnGeneral);
			
			this.connexion.commit();
			
			return tipoparamfactuplazoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoParamFactuPlazoParameterReturnGeneral procesarEventosTipoParamFactuPlazos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoParamFactuPlazo> tipoparamfactuplazos,TipoParamFactuPlazo tipoparamfactuplazo,TipoParamFactuPlazoParameterReturnGeneral tipoparamfactuplazoParameterGeneral,Boolean isEsNuevoTipoParamFactuPlazo,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoParamFactuPlazoParameterReturnGeneral tipoparamfactuplazoReturnGeneral=new TipoParamFactuPlazoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoparamfactuplazoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoParamFactuPlazoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoparamfactuplazos,tipoparamfactuplazo,tipoparamfactuplazoParameterGeneral,tipoparamfactuplazoReturnGeneral,isEsNuevoTipoParamFactuPlazo,clases);
			
			return tipoparamfactuplazoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoParamFactuPlazoParameterReturnGeneral procesarEventosTipoParamFactuPlazosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoParamFactuPlazo> tipoparamfactuplazos,TipoParamFactuPlazo tipoparamfactuplazo,TipoParamFactuPlazoParameterReturnGeneral tipoparamfactuplazoParameterGeneral,Boolean isEsNuevoTipoParamFactuPlazo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-procesarEventosTipoParamFactuPlazosWithConnection");connexion.begin();			
			
			TipoParamFactuPlazoParameterReturnGeneral tipoparamfactuplazoReturnGeneral=new TipoParamFactuPlazoParameterReturnGeneral();
	
			tipoparamfactuplazoReturnGeneral.setTipoParamFactuPlazo(tipoparamfactuplazo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoparamfactuplazoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoParamFactuPlazoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoparamfactuplazos,tipoparamfactuplazo,tipoparamfactuplazoParameterGeneral,tipoparamfactuplazoReturnGeneral,isEsNuevoTipoParamFactuPlazo,clases);
			
			this.connexion.commit();
			
			return tipoparamfactuplazoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoParamFactuPlazoParameterReturnGeneral procesarImportacionTipoParamFactuPlazosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoParamFactuPlazoParameterReturnGeneral tipoparamfactuplazoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-procesarImportacionTipoParamFactuPlazosWithConnection");connexion.begin();			
			
			TipoParamFactuPlazoParameterReturnGeneral tipoparamfactuplazoReturnGeneral=new TipoParamFactuPlazoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoparamfactuplazos=new ArrayList<TipoParamFactuPlazo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoparamfactuplazo=new TipoParamFactuPlazo();
				
				
				if(conColumnasBase) {this.tipoparamfactuplazo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoparamfactuplazo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoparamfactuplazo.setnombre(arrColumnas[iColumn++]);
				
				this.tipoparamfactuplazos.add(this.tipoparamfactuplazo);
			}
			
			this.saveTipoParamFactuPlazos();
			
			this.connexion.commit();
			
			tipoparamfactuplazoReturnGeneral.setConRetornoEstaProcesado(true);
			tipoparamfactuplazoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoparamfactuplazoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoParamFactuPlazosEliminados() throws Exception {				
		
		List<TipoParamFactuPlazo> tipoparamfactuplazosAux= new ArrayList<TipoParamFactuPlazo>();
		
		for(TipoParamFactuPlazo tipoparamfactuplazo:tipoparamfactuplazos) {
			if(!tipoparamfactuplazo.getIsDeleted()) {
				tipoparamfactuplazosAux.add(tipoparamfactuplazo);
			}
		}
		
		tipoparamfactuplazos=tipoparamfactuplazosAux;
	}
	
	public void quitarTipoParamFactuPlazosNulos() throws Exception {				
		
		List<TipoParamFactuPlazo> tipoparamfactuplazosAux= new ArrayList<TipoParamFactuPlazo>();
		
		for(TipoParamFactuPlazo tipoparamfactuplazo : this.tipoparamfactuplazos) {
			if(tipoparamfactuplazo==null) {
				tipoparamfactuplazosAux.add(tipoparamfactuplazo);
			}
		}
		
		//this.tipoparamfactuplazos=tipoparamfactuplazosAux;
		
		this.tipoparamfactuplazos.removeAll(tipoparamfactuplazosAux);
	}
	
	public void getSetVersionRowTipoParamFactuPlazoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoparamfactuplazo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoparamfactuplazo.getIsDeleted() || (tipoparamfactuplazo.getIsChanged()&&!tipoparamfactuplazo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoparamfactuplazoDataAccess.getSetVersionRowTipoParamFactuPlazo(connexion,tipoparamfactuplazo.getId());
				
				if(!tipoparamfactuplazo.getVersionRow().equals(timestamp)) {	
					tipoparamfactuplazo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoparamfactuplazo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoParamFactuPlazo()throws Exception {	
		
		if(tipoparamfactuplazo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoparamfactuplazo.getIsDeleted() || (tipoparamfactuplazo.getIsChanged()&&!tipoparamfactuplazo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoparamfactuplazoDataAccess.getSetVersionRowTipoParamFactuPlazo(connexion,tipoparamfactuplazo.getId());
			
			try {							
				if(!tipoparamfactuplazo.getVersionRow().equals(timestamp)) {	
					tipoparamfactuplazo.setVersionRow(timestamp);
				}
				
				tipoparamfactuplazo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoParamFactuPlazosWithConnection()throws Exception {	
		if(tipoparamfactuplazos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoParamFactuPlazo tipoparamfactuplazoAux:tipoparamfactuplazos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoparamfactuplazoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoparamfactuplazoAux.getIsDeleted() || (tipoparamfactuplazoAux.getIsChanged()&&!tipoparamfactuplazoAux.getIsNew())) {
						
						timestamp=tipoparamfactuplazoDataAccess.getSetVersionRowTipoParamFactuPlazo(connexion,tipoparamfactuplazoAux.getId());
						
						if(!tipoparamfactuplazo.getVersionRow().equals(timestamp)) {	
							tipoparamfactuplazoAux.setVersionRow(timestamp);
						}
								
						tipoparamfactuplazoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoParamFactuPlazos()throws Exception {	
		if(tipoparamfactuplazos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoParamFactuPlazo tipoparamfactuplazoAux:tipoparamfactuplazos) {
					if(tipoparamfactuplazoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoparamfactuplazoAux.getIsDeleted() || (tipoparamfactuplazoAux.getIsChanged()&&!tipoparamfactuplazoAux.getIsNew())) {
						
						timestamp=tipoparamfactuplazoDataAccess.getSetVersionRowTipoParamFactuPlazo(connexion,tipoparamfactuplazoAux.getId());
						
						if(!tipoparamfactuplazoAux.getVersionRow().equals(timestamp)) {	
							tipoparamfactuplazoAux.setVersionRow(timestamp);
						}
						
													
						tipoparamfactuplazoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoParamFactuPlazo tipoparamfactuplazo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoParamFactuPlazoLogicAdditional.updateTipoParamFactuPlazoToGet(tipoparamfactuplazo,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoParamFactuPlazo tipoparamfactuplazo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoParamFactuPlazoLogicAdditional.updateTipoParamFactuPlazoToSave(tipoparamfactuplazo,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoParamFactuPlazo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoparamfactuplazo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(tipoparamfactuplazo);
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
			this.deepLoad(this.tipoparamfactuplazo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoParamFactuPlazo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoparamfactuplazos!=null) {
				for(TipoParamFactuPlazo tipoparamfactuplazo:tipoparamfactuplazos) {
					this.deepLoad(tipoparamfactuplazo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(tipoparamfactuplazos);
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
			if(tipoparamfactuplazos!=null) {
				for(TipoParamFactuPlazo tipoparamfactuplazo:tipoparamfactuplazos) {
					this.deepLoad(tipoparamfactuplazo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(tipoparamfactuplazos);
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
			this.getNewConnexionToDeep(TipoParamFactuPlazo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoparamfactuplazo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoParamFactuPlazo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoparamfactuplazos!=null) {
				for(TipoParamFactuPlazo tipoparamfactuplazo:tipoparamfactuplazos) {
					this.deepSave(tipoparamfactuplazo,isDeep,deepLoadType,clases);
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
			if(tipoparamfactuplazos!=null) {
				for(TipoParamFactuPlazo tipoparamfactuplazo:tipoparamfactuplazos) {
					this.deepSave(tipoparamfactuplazo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoParamFactuPlazosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoParamFactuPlazoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoparamfactuplazos=tipoparamfactuplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoParamFactuPlazosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoParamFactuPlazoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoParamFactuPlazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoparamfactuplazos=tipoparamfactuplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoParamFactuPlazoPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuPlazo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoParamFactuPlazoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoparamfactuplazo=tipoparamfactuplazoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactuplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazo);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoParamFactuPlazoPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoParamFactuPlazoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoparamfactuplazo=tipoparamfactuplazoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactuplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoParamFactuPlazoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuPlazo(this.tipoparamfactuplazo);
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
			if(TipoParamFactuPlazoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuPlazoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoParamFactuPlazo tipoparamfactuplazo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoParamFactuPlazoConstantesFunciones.ISCONAUDITORIA) {
				if(tipoparamfactuplazo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuPlazoDataAccess.TABLENAME, tipoparamfactuplazo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoParamFactuPlazoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoParamFactuPlazoLogic.registrarAuditoriaDetallesTipoParamFactuPlazo(connexion,tipoparamfactuplazo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoparamfactuplazo.getIsDeleted()) {
					/*if(!tipoparamfactuplazo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoParamFactuPlazoDataAccess.TABLENAME, tipoparamfactuplazo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoParamFactuPlazoLogic.registrarAuditoriaDetallesTipoParamFactuPlazo(connexion,tipoparamfactuplazo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuPlazoDataAccess.TABLENAME, tipoparamfactuplazo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoparamfactuplazo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuPlazoDataAccess.TABLENAME, tipoparamfactuplazo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoParamFactuPlazoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoParamFactuPlazoLogic.registrarAuditoriaDetallesTipoParamFactuPlazo(connexion,tipoparamfactuplazo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoParamFactuPlazo(Connexion connexion,TipoParamFactuPlazo tipoparamfactuplazo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoparamfactuplazo.getIsNew()||!tipoparamfactuplazo.getnombre().equals(tipoparamfactuplazo.getTipoParamFactuPlazoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoparamfactuplazo.getTipoParamFactuPlazoOriginal().getnombre()!=null)
				{
					strValorActual=tipoparamfactuplazo.getTipoParamFactuPlazoOriginal().getnombre();
				}
				if(tipoparamfactuplazo.getnombre()!=null)
				{
					strValorNuevo=tipoparamfactuplazo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoParamFactuPlazoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoParamFactuPlazoRelacionesWithConnection(TipoParamFactuPlazo tipoparamfactuplazo) throws Exception {

		if(!tipoparamfactuplazo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoParamFactuPlazoRelacionesBase(tipoparamfactuplazo,true);
		}
	}

	public void saveTipoParamFactuPlazoRelaciones(TipoParamFactuPlazo tipoparamfactuplazo)throws Exception {

		if(!tipoparamfactuplazo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoParamFactuPlazoRelacionesBase(tipoparamfactuplazo,false);
		}
	}

	public void saveTipoParamFactuPlazoRelacionesBase(TipoParamFactuPlazo tipoparamfactuplazo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoParamFactuPlazo-saveRelacionesWithConnection");}
	

			this.setTipoParamFactuPlazo(tipoparamfactuplazo);

				if((tipoparamfactuplazo.getIsNew()||tipoparamfactuplazo.getIsChanged())&&!tipoparamfactuplazo.getIsDeleted()) {
					this.saveTipoParamFactuPlazo();
					this.saveTipoParamFactuPlazoRelacionesDetalles();

				} else if(tipoparamfactuplazo.getIsDeleted()) {
					this.saveTipoParamFactuPlazoRelacionesDetalles();
					this.saveTipoParamFactuPlazo();
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
	
	
	private void saveTipoParamFactuPlazoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoParamFactuPlazo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoParamFactuPlazoConstantesFunciones.getClassesForeignKeysOfTipoParamFactuPlazo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParamFactuPlazo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoParamFactuPlazoConstantesFunciones.getClassesRelationshipsOfTipoParamFactuPlazo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

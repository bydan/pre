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
import com.bydan.erp.cartera.util.TipoVinculacionConstantesFunciones;
import com.bydan.erp.cartera.util.TipoVinculacionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoVinculacionParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoVinculacion;
import com.bydan.erp.cartera.business.logic.TipoVinculacionLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoVinculacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoVinculacionLogic.class);
	
	protected TipoVinculacionDataAccess tipovinculacionDataAccess; 	
	protected TipoVinculacion tipovinculacion;
	protected List<TipoVinculacion> tipovinculacions;
	protected Object tipovinculacionObject;	
	protected List<Object> tipovinculacionsObject;
	
	public static ClassValidator<TipoVinculacion> tipovinculacionValidator = new ClassValidator<TipoVinculacion>(TipoVinculacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoVinculacionLogicAdditional tipovinculacionLogicAdditional=null;
	
	public TipoVinculacionLogicAdditional getTipoVinculacionLogicAdditional() {
		return this.tipovinculacionLogicAdditional;
	}
	
	public void setTipoVinculacionLogicAdditional(TipoVinculacionLogicAdditional tipovinculacionLogicAdditional) {
		try {
			this.tipovinculacionLogicAdditional=tipovinculacionLogicAdditional;
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
	
	
	
	
	public  TipoVinculacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipovinculacionDataAccess = new TipoVinculacionDataAccess();
			
			this.tipovinculacions= new ArrayList<TipoVinculacion>();
			this.tipovinculacion= new TipoVinculacion();
			
			this.tipovinculacionObject=new Object();
			this.tipovinculacionsObject=new ArrayList<Object>();
				
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
			
			this.tipovinculacionDataAccess.setConnexionType(this.connexionType);
			this.tipovinculacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoVinculacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipovinculacionDataAccess = new TipoVinculacionDataAccess();
			this.tipovinculacions= new ArrayList<TipoVinculacion>();
			this.tipovinculacion= new TipoVinculacion();
			this.tipovinculacionObject=new Object();
			this.tipovinculacionsObject=new ArrayList<Object>();
			
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
			
			this.tipovinculacionDataAccess.setConnexionType(this.connexionType);
			this.tipovinculacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoVinculacion getTipoVinculacion() throws Exception {	
		TipoVinculacionLogicAdditional.checkTipoVinculacionToGet(tipovinculacion,this.datosCliente,this.arrDatoGeneral);
		TipoVinculacionLogicAdditional.updateTipoVinculacionToGet(tipovinculacion,this.arrDatoGeneral);
		
		return tipovinculacion;
	}
		
	public void setTipoVinculacion(TipoVinculacion newTipoVinculacion) {
		this.tipovinculacion = newTipoVinculacion;
	}
	
	public TipoVinculacionDataAccess getTipoVinculacionDataAccess() {
		return tipovinculacionDataAccess;
	}
	
	public void setTipoVinculacionDataAccess(TipoVinculacionDataAccess newtipovinculacionDataAccess) {
		this.tipovinculacionDataAccess = newtipovinculacionDataAccess;
	}
	
	public List<TipoVinculacion> getTipoVinculacions() throws Exception {		
		this.quitarTipoVinculacionsNulos();
		
		TipoVinculacionLogicAdditional.checkTipoVinculacionToGets(tipovinculacions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoVinculacion tipovinculacionLocal: tipovinculacions ) {
			TipoVinculacionLogicAdditional.updateTipoVinculacionToGet(tipovinculacionLocal,this.arrDatoGeneral);
		}
		
		return tipovinculacions;
	}
	
	public void setTipoVinculacions(List<TipoVinculacion> newTipoVinculacions) {
		this.tipovinculacions = newTipoVinculacions;
	}
	
	public Object getTipoVinculacionObject() {	
		this.tipovinculacionObject=this.tipovinculacionDataAccess.getEntityObject();
		return this.tipovinculacionObject;
	}
		
	public void setTipoVinculacionObject(Object newTipoVinculacionObject) {
		this.tipovinculacionObject = newTipoVinculacionObject;
	}
	
	public List<Object> getTipoVinculacionsObject() {		
		this.tipovinculacionsObject=this.tipovinculacionDataAccess.getEntitiesObject();
		return this.tipovinculacionsObject;
	}
		
	public void setTipoVinculacionsObject(List<Object> newTipoVinculacionsObject) {
		this.tipovinculacionsObject = newTipoVinculacionsObject;
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
		
		if(this.tipovinculacionDataAccess!=null) {
			this.tipovinculacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipovinculacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipovinculacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipovinculacion = new  TipoVinculacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipovinculacion=tipovinculacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovinculacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacion);
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
		tipovinculacion = new  TipoVinculacion();
		  		  
        try {
			
			tipovinculacion=tipovinculacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovinculacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipovinculacion = new  TipoVinculacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipovinculacion=tipovinculacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovinculacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacion);
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
		tipovinculacion = new  TipoVinculacion();
		  		  
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
		tipovinculacion = new  TipoVinculacion();
		  		  
        try {
			
			tipovinculacion=tipovinculacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovinculacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipovinculacion = new  TipoVinculacion();
		  		  
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
		tipovinculacion = new  TipoVinculacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipovinculacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovinculacion = new  TipoVinculacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipovinculacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipovinculacion = new  TipoVinculacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipovinculacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovinculacion = new  TipoVinculacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipovinculacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipovinculacion = new  TipoVinculacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipovinculacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovinculacion = new  TipoVinculacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipovinculacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipovinculacions = new  ArrayList<TipoVinculacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovinculacions=tipovinculacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVinculacion(tipovinculacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacions);
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
		tipovinculacions = new  ArrayList<TipoVinculacion>();
		  		  
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
		tipovinculacions = new  ArrayList<TipoVinculacion>();
		  		  
        try {			
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovinculacions=tipovinculacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoVinculacion(tipovinculacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipovinculacions = new  ArrayList<TipoVinculacion>();
		  		  
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
		tipovinculacions = new  ArrayList<TipoVinculacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovinculacions=tipovinculacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVinculacion(tipovinculacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacions);
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
		tipovinculacions = new  ArrayList<TipoVinculacion>();
		  		  
        try {
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovinculacions=tipovinculacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVinculacion(tipovinculacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacions);
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
		tipovinculacions = new  ArrayList<TipoVinculacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovinculacions=tipovinculacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoVinculacion(tipovinculacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacions);
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
		tipovinculacions = new  ArrayList<TipoVinculacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovinculacions=tipovinculacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoVinculacion(tipovinculacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipovinculacion = new  TipoVinculacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovinculacion=tipovinculacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoVinculacion(tipovinculacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacion);
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
		tipovinculacion = new  TipoVinculacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovinculacion=tipovinculacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoVinculacion(tipovinculacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipovinculacions = new  ArrayList<TipoVinculacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovinculacions=tipovinculacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVinculacion(tipovinculacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacions);
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
		tipovinculacions = new  ArrayList<TipoVinculacion>();
		  		  
        try {
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovinculacions=tipovinculacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVinculacion(tipovinculacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoVinculacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipovinculacions = new  ArrayList<TipoVinculacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-getTodosTipoVinculacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovinculacions=tipovinculacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoVinculacion(tipovinculacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacions);
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
	
	public  void  getTodosTipoVinculacions(String sFinalQuery,Pagination pagination)throws Exception {
		tipovinculacions = new  ArrayList<TipoVinculacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovinculacions=tipovinculacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoVinculacion(tipovinculacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoVinculacion(TipoVinculacion tipovinculacion) throws Exception {
		Boolean estaValidado=false;
		
		if(tipovinculacion.getIsNew() || tipovinculacion.getIsChanged()) { 
			this.invalidValues = tipovinculacionValidator.getInvalidValues(tipovinculacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipovinculacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoVinculacion(List<TipoVinculacion> TipoVinculacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoVinculacion tipovinculacionLocal:tipovinculacions) {				
			estaValidadoObjeto=this.validarGuardarTipoVinculacion(tipovinculacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoVinculacion(List<TipoVinculacion> TipoVinculacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoVinculacion(tipovinculacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoVinculacion(TipoVinculacion TipoVinculacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoVinculacion(tipovinculacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoVinculacion tipovinculacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipovinculacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoVinculacionConstantesFunciones.getTipoVinculacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipovinculacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoVinculacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoVinculacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoVinculacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-saveTipoVinculacionWithConnection");connexion.begin();			
			
			TipoVinculacionLogicAdditional.checkTipoVinculacionToSave(this.tipovinculacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoVinculacionLogicAdditional.updateTipoVinculacionToSave(this.tipovinculacion,this.arrDatoGeneral);
			
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipovinculacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoVinculacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoVinculacion(this.tipovinculacion)) {
				TipoVinculacionDataAccess.save(this.tipovinculacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipovinculacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoVinculacionLogicAdditional.checkTipoVinculacionToSaveAfter(this.tipovinculacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoVinculacion();
			
			connexion.commit();			
			
			if(this.tipovinculacion.getIsDeleted()) {
				this.tipovinculacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoVinculacion()throws Exception {	
		try {	
			
			TipoVinculacionLogicAdditional.checkTipoVinculacionToSave(this.tipovinculacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoVinculacionLogicAdditional.updateTipoVinculacionToSave(this.tipovinculacion,this.arrDatoGeneral);
			
			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipovinculacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoVinculacion(this.tipovinculacion)) {			
				TipoVinculacionDataAccess.save(this.tipovinculacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipovinculacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoVinculacionLogicAdditional.checkTipoVinculacionToSaveAfter(this.tipovinculacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipovinculacion.getIsDeleted()) {
				this.tipovinculacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoVinculacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-saveTipoVinculacionsWithConnection");connexion.begin();			
			
			TipoVinculacionLogicAdditional.checkTipoVinculacionToSaves(tipovinculacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoVinculacions();
			
			Boolean validadoTodosTipoVinculacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoVinculacion tipovinculacionLocal:tipovinculacions) {		
				if(tipovinculacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoVinculacionLogicAdditional.updateTipoVinculacionToSave(tipovinculacionLocal,this.arrDatoGeneral);
	        	
				TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipovinculacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoVinculacion(tipovinculacionLocal)) {
					TipoVinculacionDataAccess.save(tipovinculacionLocal, connexion);				
				} else {
					validadoTodosTipoVinculacion=false;
				}
			}
			
			if(!validadoTodosTipoVinculacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoVinculacionLogicAdditional.checkTipoVinculacionToSavesAfter(tipovinculacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoVinculacions();
			
			connexion.commit();		
			
			this.quitarTipoVinculacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoVinculacions()throws Exception {				
		 try {	
			TipoVinculacionLogicAdditional.checkTipoVinculacionToSaves(tipovinculacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoVinculacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoVinculacion tipovinculacionLocal:tipovinculacions) {				
				if(tipovinculacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoVinculacionLogicAdditional.updateTipoVinculacionToSave(tipovinculacionLocal,this.arrDatoGeneral);
	        	
				TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipovinculacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoVinculacion(tipovinculacionLocal)) {				
					TipoVinculacionDataAccess.save(tipovinculacionLocal, connexion);				
				} else {
					validadoTodosTipoVinculacion=false;
				}
			}
			
			if(!validadoTodosTipoVinculacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoVinculacionLogicAdditional.checkTipoVinculacionToSavesAfter(tipovinculacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoVinculacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoVinculacionParameterReturnGeneral procesarAccionTipoVinculacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoVinculacion> tipovinculacions,TipoVinculacionParameterReturnGeneral tipovinculacionParameterGeneral)throws Exception {
		 try {	
			TipoVinculacionParameterReturnGeneral tipovinculacionReturnGeneral=new TipoVinculacionParameterReturnGeneral();
	
			TipoVinculacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipovinculacions,tipovinculacionParameterGeneral,tipovinculacionReturnGeneral);
			
			return tipovinculacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoVinculacionParameterReturnGeneral procesarAccionTipoVinculacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoVinculacion> tipovinculacions,TipoVinculacionParameterReturnGeneral tipovinculacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-procesarAccionTipoVinculacionsWithConnection");connexion.begin();			
			
			TipoVinculacionParameterReturnGeneral tipovinculacionReturnGeneral=new TipoVinculacionParameterReturnGeneral();
	
			TipoVinculacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipovinculacions,tipovinculacionParameterGeneral,tipovinculacionReturnGeneral);
			
			this.connexion.commit();
			
			return tipovinculacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoVinculacionParameterReturnGeneral procesarEventosTipoVinculacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoVinculacion> tipovinculacions,TipoVinculacion tipovinculacion,TipoVinculacionParameterReturnGeneral tipovinculacionParameterGeneral,Boolean isEsNuevoTipoVinculacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoVinculacionParameterReturnGeneral tipovinculacionReturnGeneral=new TipoVinculacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipovinculacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoVinculacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipovinculacions,tipovinculacion,tipovinculacionParameterGeneral,tipovinculacionReturnGeneral,isEsNuevoTipoVinculacion,clases);
			
			return tipovinculacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoVinculacionParameterReturnGeneral procesarEventosTipoVinculacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoVinculacion> tipovinculacions,TipoVinculacion tipovinculacion,TipoVinculacionParameterReturnGeneral tipovinculacionParameterGeneral,Boolean isEsNuevoTipoVinculacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-procesarEventosTipoVinculacionsWithConnection");connexion.begin();			
			
			TipoVinculacionParameterReturnGeneral tipovinculacionReturnGeneral=new TipoVinculacionParameterReturnGeneral();
	
			tipovinculacionReturnGeneral.setTipoVinculacion(tipovinculacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipovinculacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoVinculacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipovinculacions,tipovinculacion,tipovinculacionParameterGeneral,tipovinculacionReturnGeneral,isEsNuevoTipoVinculacion,clases);
			
			this.connexion.commit();
			
			return tipovinculacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoVinculacionParameterReturnGeneral procesarImportacionTipoVinculacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoVinculacionParameterReturnGeneral tipovinculacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-procesarImportacionTipoVinculacionsWithConnection");connexion.begin();			
			
			TipoVinculacionParameterReturnGeneral tipovinculacionReturnGeneral=new TipoVinculacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipovinculacions=new ArrayList<TipoVinculacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipovinculacion=new TipoVinculacion();
				
				
				if(conColumnasBase) {this.tipovinculacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipovinculacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipovinculacion.setcodigo(arrColumnas[iColumn++]);
				this.tipovinculacion.setnombre(arrColumnas[iColumn++]);
				
				this.tipovinculacions.add(this.tipovinculacion);
			}
			
			this.saveTipoVinculacions();
			
			this.connexion.commit();
			
			tipovinculacionReturnGeneral.setConRetornoEstaProcesado(true);
			tipovinculacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipovinculacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoVinculacionsEliminados() throws Exception {				
		
		List<TipoVinculacion> tipovinculacionsAux= new ArrayList<TipoVinculacion>();
		
		for(TipoVinculacion tipovinculacion:tipovinculacions) {
			if(!tipovinculacion.getIsDeleted()) {
				tipovinculacionsAux.add(tipovinculacion);
			}
		}
		
		tipovinculacions=tipovinculacionsAux;
	}
	
	public void quitarTipoVinculacionsNulos() throws Exception {				
		
		List<TipoVinculacion> tipovinculacionsAux= new ArrayList<TipoVinculacion>();
		
		for(TipoVinculacion tipovinculacion : this.tipovinculacions) {
			if(tipovinculacion==null) {
				tipovinculacionsAux.add(tipovinculacion);
			}
		}
		
		//this.tipovinculacions=tipovinculacionsAux;
		
		this.tipovinculacions.removeAll(tipovinculacionsAux);
	}
	
	public void getSetVersionRowTipoVinculacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipovinculacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipovinculacion.getIsDeleted() || (tipovinculacion.getIsChanged()&&!tipovinculacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipovinculacionDataAccess.getSetVersionRowTipoVinculacion(connexion,tipovinculacion.getId());
				
				if(!tipovinculacion.getVersionRow().equals(timestamp)) {	
					tipovinculacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipovinculacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoVinculacion()throws Exception {	
		
		if(tipovinculacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipovinculacion.getIsDeleted() || (tipovinculacion.getIsChanged()&&!tipovinculacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipovinculacionDataAccess.getSetVersionRowTipoVinculacion(connexion,tipovinculacion.getId());
			
			try {							
				if(!tipovinculacion.getVersionRow().equals(timestamp)) {	
					tipovinculacion.setVersionRow(timestamp);
				}
				
				tipovinculacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoVinculacionsWithConnection()throws Exception {	
		if(tipovinculacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoVinculacion tipovinculacionAux:tipovinculacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipovinculacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipovinculacionAux.getIsDeleted() || (tipovinculacionAux.getIsChanged()&&!tipovinculacionAux.getIsNew())) {
						
						timestamp=tipovinculacionDataAccess.getSetVersionRowTipoVinculacion(connexion,tipovinculacionAux.getId());
						
						if(!tipovinculacion.getVersionRow().equals(timestamp)) {	
							tipovinculacionAux.setVersionRow(timestamp);
						}
								
						tipovinculacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoVinculacions()throws Exception {	
		if(tipovinculacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoVinculacion tipovinculacionAux:tipovinculacions) {
					if(tipovinculacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipovinculacionAux.getIsDeleted() || (tipovinculacionAux.getIsChanged()&&!tipovinculacionAux.getIsNew())) {
						
						timestamp=tipovinculacionDataAccess.getSetVersionRowTipoVinculacion(connexion,tipovinculacionAux.getId());
						
						if(!tipovinculacionAux.getVersionRow().equals(timestamp)) {	
							tipovinculacionAux.setVersionRow(timestamp);
						}
						
													
						tipovinculacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoVinculacionParameterReturnGeneral cargarCombosLoteForeignKeyTipoVinculacionWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoVinculacionParameterReturnGeneral  tipovinculacionReturnGeneral =new TipoVinculacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoVinculacionWithConnection");connexion.begin();
			
			tipovinculacionReturnGeneral =new TipoVinculacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipovinculacionReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipovinculacionReturnGeneral;
	}
	
	public TipoVinculacionParameterReturnGeneral cargarCombosLoteForeignKeyTipoVinculacion(String finalQueryGlobalEmpresa) throws Exception {
		TipoVinculacionParameterReturnGeneral  tipovinculacionReturnGeneral =new TipoVinculacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipovinculacionReturnGeneral =new TipoVinculacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipovinculacionReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipovinculacionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoVinculacionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			InformacionEconomicaLogic informacioneconomicaLogic=new InformacionEconomicaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoVinculacionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(InformacionEconomica.class));
											
			

			informacioneconomicaLogic.setConnexion(this.getConnexion());
			informacioneconomicaLogic.setDatosCliente(this.datosCliente);
			informacioneconomicaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoVinculacion tipovinculacion:this.tipovinculacions) {
				

				classes=new ArrayList<Classe>();
				classes=InformacionEconomicaConstantesFunciones.getClassesForeignKeysOfInformacionEconomica(new ArrayList<Classe>(),DeepLoadType.NONE);

				informacioneconomicaLogic.setInformacionEconomicas(tipovinculacion.informacioneconomicas);
				informacioneconomicaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoVinculacion tipovinculacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoVinculacionLogicAdditional.updateTipoVinculacionToGet(tipovinculacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipovinculacion.setEmpresa(tipovinculacionDataAccess.getEmpresa(connexion,tipovinculacion));
		tipovinculacion.setInformacionEconomicas(tipovinculacionDataAccess.getInformacionEconomicas(connexion,tipovinculacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipovinculacion.setEmpresa(tipovinculacionDataAccess.getEmpresa(connexion,tipovinculacion));
				continue;
			}

			if(clas.clas.equals(InformacionEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovinculacion.setInformacionEconomicas(tipovinculacionDataAccess.getInformacionEconomicas(connexion,tipovinculacion));

				if(this.isConDeep) {
					InformacionEconomicaLogic informacioneconomicaLogic= new InformacionEconomicaLogic(this.connexion);
					informacioneconomicaLogic.setInformacionEconomicas(tipovinculacion.getInformacionEconomicas());
					ArrayList<Classe> classesLocal=InformacionEconomicaConstantesFunciones.getClassesForeignKeysOfInformacionEconomica(new ArrayList<Classe>(),DeepLoadType.NONE);
					informacioneconomicaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(informacioneconomicaLogic.getInformacionEconomicas());
					tipovinculacion.setInformacionEconomicas(informacioneconomicaLogic.getInformacionEconomicas());
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
			tipovinculacion.setEmpresa(tipovinculacionDataAccess.getEmpresa(connexion,tipovinculacion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionEconomica.class));
			tipovinculacion.setInformacionEconomicas(tipovinculacionDataAccess.getInformacionEconomicas(connexion,tipovinculacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipovinculacion.setEmpresa(tipovinculacionDataAccess.getEmpresa(connexion,tipovinculacion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipovinculacion.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipovinculacion.setInformacionEconomicas(tipovinculacionDataAccess.getInformacionEconomicas(connexion,tipovinculacion));

		for(InformacionEconomica informacioneconomica:tipovinculacion.getInformacionEconomicas()) {
			InformacionEconomicaLogic informacioneconomicaLogic= new InformacionEconomicaLogic(connexion);
			informacioneconomicaLogic.deepLoad(informacioneconomica,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipovinculacion.setEmpresa(tipovinculacionDataAccess.getEmpresa(connexion,tipovinculacion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipovinculacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(InformacionEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovinculacion.setInformacionEconomicas(tipovinculacionDataAccess.getInformacionEconomicas(connexion,tipovinculacion));

				for(InformacionEconomica informacioneconomica:tipovinculacion.getInformacionEconomicas()) {
					InformacionEconomicaLogic informacioneconomicaLogic= new InformacionEconomicaLogic(connexion);
					informacioneconomicaLogic.deepLoad(informacioneconomica,isDeep,deepLoadType,clases);
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
			tipovinculacion.setEmpresa(tipovinculacionDataAccess.getEmpresa(connexion,tipovinculacion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipovinculacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionEconomica.class));
			tipovinculacion.setInformacionEconomicas(tipovinculacionDataAccess.getInformacionEconomicas(connexion,tipovinculacion));

			for(InformacionEconomica informacioneconomica:tipovinculacion.getInformacionEconomicas()) {
				InformacionEconomicaLogic informacioneconomicaLogic= new InformacionEconomicaLogic(connexion);
				informacioneconomicaLogic.deepLoad(informacioneconomica,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoVinculacion tipovinculacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoVinculacionLogicAdditional.updateTipoVinculacionToSave(tipovinculacion,this.arrDatoGeneral);
			
TipoVinculacionDataAccess.save(tipovinculacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipovinculacion.getEmpresa(),connexion);

		for(InformacionEconomica informacioneconomica:tipovinculacion.getInformacionEconomicas()) {
			informacioneconomica.setidvalorclientevinculacion(tipovinculacion.getId());
			InformacionEconomicaDataAccess.save(informacioneconomica,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipovinculacion.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(InformacionEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionEconomica informacioneconomica:tipovinculacion.getInformacionEconomicas()) {
					informacioneconomica.setidvalorclientevinculacion(tipovinculacion.getId());
					InformacionEconomicaDataAccess.save(informacioneconomica,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipovinculacion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipovinculacion.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(InformacionEconomica informacioneconomica:tipovinculacion.getInformacionEconomicas()) {
			InformacionEconomicaLogic informacioneconomicaLogic= new InformacionEconomicaLogic(connexion);
			informacioneconomica.setidvalorclientevinculacion(tipovinculacion.getId());
			InformacionEconomicaDataAccess.save(informacioneconomica,connexion);
			informacioneconomicaLogic.deepSave(informacioneconomica,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipovinculacion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipovinculacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(InformacionEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionEconomica informacioneconomica:tipovinculacion.getInformacionEconomicas()) {
					InformacionEconomicaLogic informacioneconomicaLogic= new InformacionEconomicaLogic(connexion);
					informacioneconomica.setidvalorclientevinculacion(tipovinculacion.getId());
					InformacionEconomicaDataAccess.save(informacioneconomica,connexion);
					informacioneconomicaLogic.deepSave(informacioneconomica,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoVinculacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipovinculacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(tipovinculacion);
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
			this.deepLoad(this.tipovinculacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoVinculacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipovinculacions!=null) {
				for(TipoVinculacion tipovinculacion:tipovinculacions) {
					this.deepLoad(tipovinculacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(tipovinculacions);
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
			if(tipovinculacions!=null) {
				for(TipoVinculacion tipovinculacion:tipovinculacions) {
					this.deepLoad(tipovinculacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(tipovinculacions);
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
			this.getNewConnexionToDeep(TipoVinculacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipovinculacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoVinculacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipovinculacions!=null) {
				for(TipoVinculacion tipovinculacion:tipovinculacions) {
					this.deepSave(tipovinculacion,isDeep,deepLoadType,clases);
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
			if(tipovinculacions!=null) {
				for(TipoVinculacion tipovinculacion:tipovinculacions) {
					this.deepSave(tipovinculacion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoVinculacionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVinculacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoVinculacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipovinculacions=tipovinculacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoVinculacionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoVinculacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoVinculacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipovinculacions=tipovinculacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoVinculacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoVinculacion(this.tipovinculacions);
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
			if(TipoVinculacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoVinculacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoVinculacion tipovinculacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoVinculacionConstantesFunciones.ISCONAUDITORIA) {
				if(tipovinculacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoVinculacionDataAccess.TABLENAME, tipovinculacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoVinculacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoVinculacionLogic.registrarAuditoriaDetallesTipoVinculacion(connexion,tipovinculacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipovinculacion.getIsDeleted()) {
					/*if(!tipovinculacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoVinculacionDataAccess.TABLENAME, tipovinculacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoVinculacionLogic.registrarAuditoriaDetallesTipoVinculacion(connexion,tipovinculacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoVinculacionDataAccess.TABLENAME, tipovinculacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipovinculacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoVinculacionDataAccess.TABLENAME, tipovinculacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoVinculacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoVinculacionLogic.registrarAuditoriaDetallesTipoVinculacion(connexion,tipovinculacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoVinculacion(Connexion connexion,TipoVinculacion tipovinculacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipovinculacion.getIsNew()||!tipovinculacion.getid_empresa().equals(tipovinculacion.getTipoVinculacionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipovinculacion.getTipoVinculacionOriginal().getid_empresa()!=null)
				{
					strValorActual=tipovinculacion.getTipoVinculacionOriginal().getid_empresa().toString();
				}
				if(tipovinculacion.getid_empresa()!=null)
				{
					strValorNuevo=tipovinculacion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoVinculacionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipovinculacion.getIsNew()||!tipovinculacion.getcodigo().equals(tipovinculacion.getTipoVinculacionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipovinculacion.getTipoVinculacionOriginal().getcodigo()!=null)
				{
					strValorActual=tipovinculacion.getTipoVinculacionOriginal().getcodigo();
				}
				if(tipovinculacion.getcodigo()!=null)
				{
					strValorNuevo=tipovinculacion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoVinculacionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipovinculacion.getIsNew()||!tipovinculacion.getnombre().equals(tipovinculacion.getTipoVinculacionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipovinculacion.getTipoVinculacionOriginal().getnombre()!=null)
				{
					strValorActual=tipovinculacion.getTipoVinculacionOriginal().getnombre();
				}
				if(tipovinculacion.getnombre()!=null)
				{
					strValorNuevo=tipovinculacion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoVinculacionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoVinculacionRelacionesWithConnection(TipoVinculacion tipovinculacion,List<InformacionEconomica> informacioneconomicas) throws Exception {

		if(!tipovinculacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoVinculacionRelacionesBase(tipovinculacion,informacioneconomicas,true);
		}
	}

	public void saveTipoVinculacionRelaciones(TipoVinculacion tipovinculacion,List<InformacionEconomica> informacioneconomicas)throws Exception {

		if(!tipovinculacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoVinculacionRelacionesBase(tipovinculacion,informacioneconomicas,false);
		}
	}

	public void saveTipoVinculacionRelacionesBase(TipoVinculacion tipovinculacion,List<InformacionEconomica> informacioneconomicas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoVinculacion-saveRelacionesWithConnection");}
	
			tipovinculacion.setInformacionEconomicas(informacioneconomicas);

			this.setTipoVinculacion(tipovinculacion);

			if(TipoVinculacionLogicAdditional.validarSaveRelaciones(tipovinculacion,this)) {

				TipoVinculacionLogicAdditional.updateRelacionesToSave(tipovinculacion,this);

				if((tipovinculacion.getIsNew()||tipovinculacion.getIsChanged())&&!tipovinculacion.getIsDeleted()) {
					this.saveTipoVinculacion();
					this.saveTipoVinculacionRelacionesDetalles(informacioneconomicas);

				} else if(tipovinculacion.getIsDeleted()) {
					this.saveTipoVinculacionRelacionesDetalles(informacioneconomicas);
					this.saveTipoVinculacion();
				}

				TipoVinculacionLogicAdditional.updateRelacionesToSaveAfter(tipovinculacion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			InformacionEconomicaConstantesFunciones.InicializarGeneralEntityAuxiliaresInformacionEconomicas(informacioneconomicas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoVinculacionRelacionesDetalles(List<InformacionEconomica> informacioneconomicas)throws Exception {
		try {
	

			Long idTipoVinculacionActual=this.getTipoVinculacion().getId();

			InformacionEconomicaLogic informacioneconomicaLogic_Desde_TipoVinculacion=new InformacionEconomicaLogic();
			informacioneconomicaLogic_Desde_TipoVinculacion.setInformacionEconomicas(informacioneconomicas);

			informacioneconomicaLogic_Desde_TipoVinculacion.setConnexion(this.getConnexion());
			informacioneconomicaLogic_Desde_TipoVinculacion.setDatosCliente(this.datosCliente);

			for(InformacionEconomica informacioneconomica_Desde_TipoVinculacion:informacioneconomicaLogic_Desde_TipoVinculacion.getInformacionEconomicas()) {
				informacioneconomica_Desde_TipoVinculacion.setidvalorclientevinculacion(idTipoVinculacionActual);
			}

			informacioneconomicaLogic_Desde_TipoVinculacion.saveInformacionEconomicas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoVinculacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoVinculacionConstantesFunciones.getClassesForeignKeysOfTipoVinculacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVinculacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoVinculacionConstantesFunciones.getClassesRelationshipsOfTipoVinculacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

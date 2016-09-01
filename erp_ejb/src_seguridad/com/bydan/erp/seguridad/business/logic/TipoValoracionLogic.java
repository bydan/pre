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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.TipoValoracionConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoValoracionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoValoracionParameterGeneral;
import com.bydan.erp.seguridad.business.entity.TipoValoracion;
//import com.bydan.erp.seguridad.business.logic.TipoValoracionLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.cartera.util.*;


import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoValoracionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoValoracionLogic.class);
	
	protected TipoValoracionDataAccess tipovaloracionDataAccess; 	
	protected TipoValoracion tipovaloracion;
	protected List<TipoValoracion> tipovaloracions;
	protected Object tipovaloracionObject;	
	protected List<Object> tipovaloracionsObject;
	
	public static ClassValidator<TipoValoracion> tipovaloracionValidator = new ClassValidator<TipoValoracion>(TipoValoracion.class);	
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
	
	
	
	
	public  TipoValoracionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipovaloracionDataAccess = new TipoValoracionDataAccess();
			
			this.tipovaloracions= new ArrayList<TipoValoracion>();
			this.tipovaloracion= new TipoValoracion();
			
			this.tipovaloracionObject=new Object();
			this.tipovaloracionsObject=new ArrayList<Object>();
				
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
			
			this.tipovaloracionDataAccess.setConnexionType(this.connexionType);
			this.tipovaloracionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoValoracionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipovaloracionDataAccess = new TipoValoracionDataAccess();
			this.tipovaloracions= new ArrayList<TipoValoracion>();
			this.tipovaloracion= new TipoValoracion();
			this.tipovaloracionObject=new Object();
			this.tipovaloracionsObject=new ArrayList<Object>();
			
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
			
			this.tipovaloracionDataAccess.setConnexionType(this.connexionType);
			this.tipovaloracionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoValoracion getTipoValoracion() throws Exception {	
		//TipoValoracionLogicAdditional.checkTipoValoracionToGet(tipovaloracion,this.datosCliente,this.arrDatoGeneral);
		//TipoValoracionLogicAdditional.updateTipoValoracionToGet(tipovaloracion,this.arrDatoGeneral);
		
		return tipovaloracion;
	}
		
	public void setTipoValoracion(TipoValoracion newTipoValoracion) {
		this.tipovaloracion = newTipoValoracion;
	}
	
	public TipoValoracionDataAccess getTipoValoracionDataAccess() {
		return tipovaloracionDataAccess;
	}
	
	public void setTipoValoracionDataAccess(TipoValoracionDataAccess newtipovaloracionDataAccess) {
		this.tipovaloracionDataAccess = newtipovaloracionDataAccess;
	}
	
	public List<TipoValoracion> getTipoValoracions() throws Exception {		
		this.quitarTipoValoracionsNulos();
		
		//TipoValoracionLogicAdditional.checkTipoValoracionToGets(tipovaloracions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoValoracion tipovaloracionLocal: tipovaloracions ) {
			//TipoValoracionLogicAdditional.updateTipoValoracionToGet(tipovaloracionLocal,this.arrDatoGeneral);
		}
		
		return tipovaloracions;
	}
	
	public void setTipoValoracions(List<TipoValoracion> newTipoValoracions) {
		this.tipovaloracions = newTipoValoracions;
	}
	
	public Object getTipoValoracionObject() {	
		this.tipovaloracionObject=this.tipovaloracionDataAccess.getEntityObject();
		return this.tipovaloracionObject;
	}
		
	public void setTipoValoracionObject(Object newTipoValoracionObject) {
		this.tipovaloracionObject = newTipoValoracionObject;
	}
	
	public List<Object> getTipoValoracionsObject() {		
		this.tipovaloracionsObject=this.tipovaloracionDataAccess.getEntitiesObject();
		return this.tipovaloracionsObject;
	}
		
	public void setTipoValoracionsObject(List<Object> newTipoValoracionsObject) {
		this.tipovaloracionsObject = newTipoValoracionsObject;
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
		
		if(this.tipovaloracionDataAccess!=null) {
			this.tipovaloracionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipovaloracionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipovaloracionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipovaloracion = new  TipoValoracion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipovaloracion=tipovaloracionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovaloracion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracion);
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
		tipovaloracion = new  TipoValoracion();
		  		  
        try {
			
			tipovaloracion=tipovaloracionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovaloracion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipovaloracion = new  TipoValoracion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipovaloracion=tipovaloracionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovaloracion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracion);
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
		tipovaloracion = new  TipoValoracion();
		  		  
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
		tipovaloracion = new  TipoValoracion();
		  		  
        try {
			
			tipovaloracion=tipovaloracionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovaloracion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipovaloracion = new  TipoValoracion();
		  		  
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
		tipovaloracion = new  TipoValoracion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipovaloracionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovaloracion = new  TipoValoracion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipovaloracionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipovaloracion = new  TipoValoracion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipovaloracionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovaloracion = new  TipoValoracion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipovaloracionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipovaloracion = new  TipoValoracion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipovaloracionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovaloracion = new  TipoValoracion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipovaloracionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipovaloracions = new  ArrayList<TipoValoracion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovaloracions=tipovaloracionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoValoracion(tipovaloracions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracions);
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
		tipovaloracions = new  ArrayList<TipoValoracion>();
		  		  
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
		tipovaloracions = new  ArrayList<TipoValoracion>();
		  		  
        try {			
			TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovaloracions=tipovaloracionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoValoracion(tipovaloracions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipovaloracions = new  ArrayList<TipoValoracion>();
		  		  
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
		tipovaloracions = new  ArrayList<TipoValoracion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovaloracions=tipovaloracionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoValoracion(tipovaloracions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracions);
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
		tipovaloracions = new  ArrayList<TipoValoracion>();
		  		  
        try {
			TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovaloracions=tipovaloracionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoValoracion(tipovaloracions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracions);
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
		tipovaloracions = new  ArrayList<TipoValoracion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovaloracions=tipovaloracionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoValoracion(tipovaloracions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracions);
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
		tipovaloracions = new  ArrayList<TipoValoracion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovaloracions=tipovaloracionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoValoracion(tipovaloracions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipovaloracion = new  TipoValoracion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovaloracion=tipovaloracionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoValoracion(tipovaloracion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracion);
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
		tipovaloracion = new  TipoValoracion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovaloracion=tipovaloracionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoValoracion(tipovaloracion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoValoracionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipovaloracions = new  ArrayList<TipoValoracion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-getTodosTipoValoracionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovaloracions=tipovaloracionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoValoracion(tipovaloracions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracions);
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
	
	public  void  getTodosTipoValoracions(String sFinalQuery,Pagination pagination)throws Exception {
		tipovaloracions = new  ArrayList<TipoValoracion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovaloracions=tipovaloracionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoValoracion(tipovaloracions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoValoracion(TipoValoracion tipovaloracion) throws Exception {
		Boolean estaValidado=false;
		
		if(tipovaloracion.getIsNew() || tipovaloracion.getIsChanged()) { 
			this.invalidValues = tipovaloracionValidator.getInvalidValues(tipovaloracion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipovaloracion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoValoracion(List<TipoValoracion> TipoValoracions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoValoracion tipovaloracionLocal:tipovaloracions) {				
			estaValidadoObjeto=this.validarGuardarTipoValoracion(tipovaloracionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoValoracion(List<TipoValoracion> TipoValoracions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoValoracion(tipovaloracions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoValoracion(TipoValoracion TipoValoracion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoValoracion(tipovaloracion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoValoracion tipovaloracion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipovaloracion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoValoracionConstantesFunciones.getTipoValoracionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipovaloracion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoValoracionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoValoracionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoValoracionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-saveTipoValoracionWithConnection");connexion.begin();			
			
			//TipoValoracionLogicAdditional.checkTipoValoracionToSave(this.tipovaloracion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoValoracionLogicAdditional.updateTipoValoracionToSave(this.tipovaloracion,this.arrDatoGeneral);
			
			TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipovaloracion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoValoracion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoValoracion(this.tipovaloracion)) {
				TipoValoracionDataAccess.save(this.tipovaloracion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipovaloracion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoValoracionLogicAdditional.checkTipoValoracionToSaveAfter(this.tipovaloracion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoValoracion();
			
			connexion.commit();			
			
			if(this.tipovaloracion.getIsDeleted()) {
				this.tipovaloracion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoValoracion()throws Exception {	
		try {	
			
			//TipoValoracionLogicAdditional.checkTipoValoracionToSave(this.tipovaloracion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoValoracionLogicAdditional.updateTipoValoracionToSave(this.tipovaloracion,this.arrDatoGeneral);
			
			TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipovaloracion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoValoracion(this.tipovaloracion)) {			
				TipoValoracionDataAccess.save(this.tipovaloracion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipovaloracion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoValoracionLogicAdditional.checkTipoValoracionToSaveAfter(this.tipovaloracion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipovaloracion.getIsDeleted()) {
				this.tipovaloracion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoValoracionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-saveTipoValoracionsWithConnection");connexion.begin();			
			
			//TipoValoracionLogicAdditional.checkTipoValoracionToSaves(tipovaloracions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoValoracions();
			
			Boolean validadoTodosTipoValoracion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoValoracion tipovaloracionLocal:tipovaloracions) {		
				if(tipovaloracionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoValoracionLogicAdditional.updateTipoValoracionToSave(tipovaloracionLocal,this.arrDatoGeneral);
	        	
				TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipovaloracionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoValoracion(tipovaloracionLocal)) {
					TipoValoracionDataAccess.save(tipovaloracionLocal, connexion);				
				} else {
					validadoTodosTipoValoracion=false;
				}
			}
			
			if(!validadoTodosTipoValoracion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoValoracionLogicAdditional.checkTipoValoracionToSavesAfter(tipovaloracions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoValoracions();
			
			connexion.commit();		
			
			this.quitarTipoValoracionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoValoracions()throws Exception {				
		 try {	
			//TipoValoracionLogicAdditional.checkTipoValoracionToSaves(tipovaloracions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoValoracion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoValoracion tipovaloracionLocal:tipovaloracions) {				
				if(tipovaloracionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoValoracionLogicAdditional.updateTipoValoracionToSave(tipovaloracionLocal,this.arrDatoGeneral);
	        	
				TipoValoracionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipovaloracionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoValoracion(tipovaloracionLocal)) {				
					TipoValoracionDataAccess.save(tipovaloracionLocal, connexion);				
				} else {
					validadoTodosTipoValoracion=false;
				}
			}
			
			if(!validadoTodosTipoValoracion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoValoracionLogicAdditional.checkTipoValoracionToSavesAfter(tipovaloracions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoValoracionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoValoracionParameterReturnGeneral procesarAccionTipoValoracions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoValoracion> tipovaloracions,TipoValoracionParameterReturnGeneral tipovaloracionParameterGeneral)throws Exception {
		 try {	
			TipoValoracionParameterReturnGeneral tipovaloracionReturnGeneral=new TipoValoracionParameterReturnGeneral();
	
			
			return tipovaloracionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoValoracionParameterReturnGeneral procesarAccionTipoValoracionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoValoracion> tipovaloracions,TipoValoracionParameterReturnGeneral tipovaloracionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-procesarAccionTipoValoracionsWithConnection");connexion.begin();			
			
			TipoValoracionParameterReturnGeneral tipovaloracionReturnGeneral=new TipoValoracionParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipovaloracionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoValoracionParameterReturnGeneral procesarEventosTipoValoracions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoValoracion> tipovaloracions,TipoValoracion tipovaloracion,TipoValoracionParameterReturnGeneral tipovaloracionParameterGeneral,Boolean isEsNuevoTipoValoracion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoValoracionParameterReturnGeneral tipovaloracionReturnGeneral=new TipoValoracionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipovaloracionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipovaloracionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoValoracionParameterReturnGeneral procesarEventosTipoValoracionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoValoracion> tipovaloracions,TipoValoracion tipovaloracion,TipoValoracionParameterReturnGeneral tipovaloracionParameterGeneral,Boolean isEsNuevoTipoValoracion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-procesarEventosTipoValoracionsWithConnection");connexion.begin();			
			
			TipoValoracionParameterReturnGeneral tipovaloracionReturnGeneral=new TipoValoracionParameterReturnGeneral();
	
			tipovaloracionReturnGeneral.setTipoValoracion(tipovaloracion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipovaloracionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipovaloracionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoValoracionParameterReturnGeneral procesarImportacionTipoValoracionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoValoracionParameterReturnGeneral tipovaloracionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-procesarImportacionTipoValoracionsWithConnection");connexion.begin();			
			
			TipoValoracionParameterReturnGeneral tipovaloracionReturnGeneral=new TipoValoracionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipovaloracions=new ArrayList<TipoValoracion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipovaloracion=new TipoValoracion();
				
				
				if(conColumnasBase) {this.tipovaloracion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipovaloracion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipovaloracion.setcodigo(arrColumnas[iColumn++]);
				this.tipovaloracion.setnombre(arrColumnas[iColumn++]);
				
				this.tipovaloracions.add(this.tipovaloracion);
			}
			
			this.saveTipoValoracions();
			
			this.connexion.commit();
			
			tipovaloracionReturnGeneral.setConRetornoEstaProcesado(true);
			tipovaloracionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipovaloracionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoValoracionsEliminados() throws Exception {				
		
		List<TipoValoracion> tipovaloracionsAux= new ArrayList<TipoValoracion>();
		
		for(TipoValoracion tipovaloracion:tipovaloracions) {
			if(!tipovaloracion.getIsDeleted()) {
				tipovaloracionsAux.add(tipovaloracion);
			}
		}
		
		tipovaloracions=tipovaloracionsAux;
	}
	
	public void quitarTipoValoracionsNulos() throws Exception {				
		
		List<TipoValoracion> tipovaloracionsAux= new ArrayList<TipoValoracion>();
		
		for(TipoValoracion tipovaloracion : this.tipovaloracions) {
			if(tipovaloracion==null) {
				tipovaloracionsAux.add(tipovaloracion);
			}
		}
		
		//this.tipovaloracions=tipovaloracionsAux;
		
		this.tipovaloracions.removeAll(tipovaloracionsAux);
	}
	
	public void getSetVersionRowTipoValoracionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipovaloracion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipovaloracion.getIsDeleted() || (tipovaloracion.getIsChanged()&&!tipovaloracion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipovaloracionDataAccess.getSetVersionRowTipoValoracion(connexion,tipovaloracion.getId());
				
				if(!tipovaloracion.getVersionRow().equals(timestamp)) {	
					tipovaloracion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipovaloracion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoValoracion()throws Exception {	
		
		if(tipovaloracion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipovaloracion.getIsDeleted() || (tipovaloracion.getIsChanged()&&!tipovaloracion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipovaloracionDataAccess.getSetVersionRowTipoValoracion(connexion,tipovaloracion.getId());
			
			try {							
				if(!tipovaloracion.getVersionRow().equals(timestamp)) {	
					tipovaloracion.setVersionRow(timestamp);
				}
				
				tipovaloracion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoValoracionsWithConnection()throws Exception {	
		if(tipovaloracions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoValoracion tipovaloracionAux:tipovaloracions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipovaloracionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipovaloracionAux.getIsDeleted() || (tipovaloracionAux.getIsChanged()&&!tipovaloracionAux.getIsNew())) {
						
						timestamp=tipovaloracionDataAccess.getSetVersionRowTipoValoracion(connexion,tipovaloracionAux.getId());
						
						if(!tipovaloracion.getVersionRow().equals(timestamp)) {	
							tipovaloracionAux.setVersionRow(timestamp);
						}
								
						tipovaloracionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoValoracions()throws Exception {	
		if(tipovaloracions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoValoracion tipovaloracionAux:tipovaloracions) {
					if(tipovaloracionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipovaloracionAux.getIsDeleted() || (tipovaloracionAux.getIsChanged()&&!tipovaloracionAux.getIsNew())) {
						
						timestamp=tipovaloracionDataAccess.getSetVersionRowTipoValoracion(connexion,tipovaloracionAux.getId());
						
						if(!tipovaloracionAux.getVersionRow().equals(timestamp)) {	
							tipovaloracionAux.setVersionRow(timestamp);
						}
						
													
						tipovaloracionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoValoracionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ReferenciaBancariaLogic referenciabancariaLogic=new ReferenciaBancariaLogic();
			LunaSistemaSolarLogic lunasistemasolarLogic=new LunaSistemaSolarLogic();
			PlanetaSistemaSolarLogic planetasistemasolarLogic=new PlanetaSistemaSolarLogic();
			ReferenciaComercialLogic referenciacomercialLogic=new ReferenciaComercialLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValoracion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoValoracionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ReferenciaBancaria.class));
			classes.add(new Classe(LunaSistemaSolar.class));
			classes.add(new Classe(PlanetaSistemaSolar.class));
			classes.add(new Classe(ReferenciaComercial.class));
											
			

			referenciabancariaLogic.setConnexion(this.getConnexion());
			referenciabancariaLogic.setDatosCliente(this.datosCliente);
			referenciabancariaLogic.setIsConRefrescarForeignKeys(true);

			lunasistemasolarLogic.setConnexion(this.getConnexion());
			lunasistemasolarLogic.setDatosCliente(this.datosCliente);
			lunasistemasolarLogic.setIsConRefrescarForeignKeys(true);

			planetasistemasolarLogic.setConnexion(this.getConnexion());
			planetasistemasolarLogic.setDatosCliente(this.datosCliente);
			planetasistemasolarLogic.setIsConRefrescarForeignKeys(true);

			referenciacomercialLogic.setConnexion(this.getConnexion());
			referenciacomercialLogic.setDatosCliente(this.datosCliente);
			referenciacomercialLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoValoracion tipovaloracion:this.tipovaloracions) {
				

				classes=new ArrayList<Classe>();
				classes=ReferenciaBancariaConstantesFunciones.getClassesForeignKeysOfReferenciaBancaria(new ArrayList<Classe>(),DeepLoadType.NONE);

				referenciabancariaLogic.setReferenciaBancarias(tipovaloracion.referenciabancarias);
				referenciabancariaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=LunaSistemaSolarConstantesFunciones.getClassesForeignKeysOfLunaSistemaSolar(new ArrayList<Classe>(),DeepLoadType.NONE);

				lunasistemasolarLogic.setLunaSistemaSolars(tipovaloracion.lunasistemasolars);
				lunasistemasolarLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PlanetaSistemaSolarConstantesFunciones.getClassesForeignKeysOfPlanetaSistemaSolar(new ArrayList<Classe>(),DeepLoadType.NONE);

				planetasistemasolarLogic.setPlanetaSistemaSolars(tipovaloracion.planetasistemasolars);
				planetasistemasolarLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ReferenciaComercialConstantesFunciones.getClassesForeignKeysOfReferenciaComercial(new ArrayList<Classe>(),DeepLoadType.NONE);

				referenciacomercialLogic.setReferenciaComercials(tipovaloracion.referenciacomercials);
				referenciacomercialLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoValoracion tipovaloracion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoValoracionLogicAdditional.updateTipoValoracionToGet(tipovaloracion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipovaloracion.setReferenciaBancarias(tipovaloracionDataAccess.getReferenciaBancarias(connexion,tipovaloracion));
		tipovaloracion.setLunaSistemaSolars(tipovaloracionDataAccess.getLunaSistemaSolars(connexion,tipovaloracion));
		tipovaloracion.setPlanetaSistemaSolars(tipovaloracionDataAccess.getPlanetaSistemaSolars(connexion,tipovaloracion));
		tipovaloracion.setReferenciaComercials(tipovaloracionDataAccess.getReferenciaComercials(connexion,tipovaloracion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovaloracion.setReferenciaBancarias(tipovaloracionDataAccess.getReferenciaBancarias(connexion,tipovaloracion));

				if(this.isConDeep) {
					ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(this.connexion);
					referenciabancariaLogic.setReferenciaBancarias(tipovaloracion.getReferenciaBancarias());
					ArrayList<Classe> classesLocal=ReferenciaBancariaConstantesFunciones.getClassesForeignKeysOfReferenciaBancaria(new ArrayList<Classe>(),DeepLoadType.NONE);
					referenciabancariaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(referenciabancariaLogic.getReferenciaBancarias());
					tipovaloracion.setReferenciaBancarias(referenciabancariaLogic.getReferenciaBancarias());
				}

				continue;
			}

			if(clas.clas.equals(LunaSistemaSolar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovaloracion.setLunaSistemaSolars(tipovaloracionDataAccess.getLunaSistemaSolars(connexion,tipovaloracion));

				if(this.isConDeep) {
					LunaSistemaSolarLogic lunasistemasolarLogic= new LunaSistemaSolarLogic(this.connexion);
					lunasistemasolarLogic.setLunaSistemaSolars(tipovaloracion.getLunaSistemaSolars());
					ArrayList<Classe> classesLocal=LunaSistemaSolarConstantesFunciones.getClassesForeignKeysOfLunaSistemaSolar(new ArrayList<Classe>(),DeepLoadType.NONE);
					lunasistemasolarLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					LunaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesLunaSistemaSolar(lunasistemasolarLogic.getLunaSistemaSolars());
					tipovaloracion.setLunaSistemaSolars(lunasistemasolarLogic.getLunaSistemaSolars());
				}

				continue;
			}

			if(clas.clas.equals(PlanetaSistemaSolar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovaloracion.setPlanetaSistemaSolars(tipovaloracionDataAccess.getPlanetaSistemaSolars(connexion,tipovaloracion));

				if(this.isConDeep) {
					PlanetaSistemaSolarLogic planetasistemasolarLogic= new PlanetaSistemaSolarLogic(this.connexion);
					planetasistemasolarLogic.setPlanetaSistemaSolars(tipovaloracion.getPlanetaSistemaSolars());
					ArrayList<Classe> classesLocal=PlanetaSistemaSolarConstantesFunciones.getClassesForeignKeysOfPlanetaSistemaSolar(new ArrayList<Classe>(),DeepLoadType.NONE);
					planetasistemasolarLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PlanetaSistemaSolarConstantesFunciones.refrescarForeignKeysDescripcionesPlanetaSistemaSolar(planetasistemasolarLogic.getPlanetaSistemaSolars());
					tipovaloracion.setPlanetaSistemaSolars(planetasistemasolarLogic.getPlanetaSistemaSolars());
				}

				continue;
			}

			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovaloracion.setReferenciaComercials(tipovaloracionDataAccess.getReferenciaComercials(connexion,tipovaloracion));

				if(this.isConDeep) {
					ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(this.connexion);
					referenciacomercialLogic.setReferenciaComercials(tipovaloracion.getReferenciaComercials());
					ArrayList<Classe> classesLocal=ReferenciaComercialConstantesFunciones.getClassesForeignKeysOfReferenciaComercial(new ArrayList<Classe>(),DeepLoadType.NONE);
					referenciacomercialLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(referenciacomercialLogic.getReferenciaComercials());
					tipovaloracion.setReferenciaComercials(referenciacomercialLogic.getReferenciaComercials());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaBancaria.class));
			tipovaloracion.setReferenciaBancarias(tipovaloracionDataAccess.getReferenciaBancarias(connexion,tipovaloracion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LunaSistemaSolar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(LunaSistemaSolar.class));
			tipovaloracion.setLunaSistemaSolars(tipovaloracionDataAccess.getLunaSistemaSolars(connexion,tipovaloracion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PlanetaSistemaSolar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PlanetaSistemaSolar.class));
			tipovaloracion.setPlanetaSistemaSolars(tipovaloracionDataAccess.getPlanetaSistemaSolars(connexion,tipovaloracion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaComercial.class));
			tipovaloracion.setReferenciaComercials(tipovaloracionDataAccess.getReferenciaComercials(connexion,tipovaloracion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipovaloracion.setReferenciaBancarias(tipovaloracionDataAccess.getReferenciaBancarias(connexion,tipovaloracion));

		for(ReferenciaBancaria referenciabancaria:tipovaloracion.getReferenciaBancarias()) {
			ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
			referenciabancariaLogic.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
		}

		tipovaloracion.setLunaSistemaSolars(tipovaloracionDataAccess.getLunaSistemaSolars(connexion,tipovaloracion));

		for(LunaSistemaSolar lunasistemasolar:tipovaloracion.getLunaSistemaSolars()) {
			LunaSistemaSolarLogic lunasistemasolarLogic= new LunaSistemaSolarLogic(connexion);
			lunasistemasolarLogic.deepLoad(lunasistemasolar,isDeep,deepLoadType,clases);
		}

		tipovaloracion.setPlanetaSistemaSolars(tipovaloracionDataAccess.getPlanetaSistemaSolars(connexion,tipovaloracion));

		for(PlanetaSistemaSolar planetasistemasolar:tipovaloracion.getPlanetaSistemaSolars()) {
			PlanetaSistemaSolarLogic planetasistemasolarLogic= new PlanetaSistemaSolarLogic(connexion);
			planetasistemasolarLogic.deepLoad(planetasistemasolar,isDeep,deepLoadType,clases);
		}

		tipovaloracion.setReferenciaComercials(tipovaloracionDataAccess.getReferenciaComercials(connexion,tipovaloracion));

		for(ReferenciaComercial referenciacomercial:tipovaloracion.getReferenciaComercials()) {
			ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
			referenciacomercialLogic.deepLoad(referenciacomercial,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovaloracion.setReferenciaBancarias(tipovaloracionDataAccess.getReferenciaBancarias(connexion,tipovaloracion));

				for(ReferenciaBancaria referenciabancaria:tipovaloracion.getReferenciaBancarias()) {
					ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
					referenciabancariaLogic.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(LunaSistemaSolar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovaloracion.setLunaSistemaSolars(tipovaloracionDataAccess.getLunaSistemaSolars(connexion,tipovaloracion));

				for(LunaSistemaSolar lunasistemasolar:tipovaloracion.getLunaSistemaSolars()) {
					LunaSistemaSolarLogic lunasistemasolarLogic= new LunaSistemaSolarLogic(connexion);
					lunasistemasolarLogic.deepLoad(lunasistemasolar,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PlanetaSistemaSolar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovaloracion.setPlanetaSistemaSolars(tipovaloracionDataAccess.getPlanetaSistemaSolars(connexion,tipovaloracion));

				for(PlanetaSistemaSolar planetasistemasolar:tipovaloracion.getPlanetaSistemaSolars()) {
					PlanetaSistemaSolarLogic planetasistemasolarLogic= new PlanetaSistemaSolarLogic(connexion);
					planetasistemasolarLogic.deepLoad(planetasistemasolar,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovaloracion.setReferenciaComercials(tipovaloracionDataAccess.getReferenciaComercials(connexion,tipovaloracion));

				for(ReferenciaComercial referenciacomercial:tipovaloracion.getReferenciaComercials()) {
					ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
					referenciacomercialLogic.deepLoad(referenciacomercial,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaBancaria.class));
			tipovaloracion.setReferenciaBancarias(tipovaloracionDataAccess.getReferenciaBancarias(connexion,tipovaloracion));

			for(ReferenciaBancaria referenciabancaria:tipovaloracion.getReferenciaBancarias()) {
				ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
				referenciabancariaLogic.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LunaSistemaSolar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(LunaSistemaSolar.class));
			tipovaloracion.setLunaSistemaSolars(tipovaloracionDataAccess.getLunaSistemaSolars(connexion,tipovaloracion));

			for(LunaSistemaSolar lunasistemasolar:tipovaloracion.getLunaSistemaSolars()) {
				LunaSistemaSolarLogic lunasistemasolarLogic= new LunaSistemaSolarLogic(connexion);
				lunasistemasolarLogic.deepLoad(lunasistemasolar,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PlanetaSistemaSolar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PlanetaSistemaSolar.class));
			tipovaloracion.setPlanetaSistemaSolars(tipovaloracionDataAccess.getPlanetaSistemaSolars(connexion,tipovaloracion));

			for(PlanetaSistemaSolar planetasistemasolar:tipovaloracion.getPlanetaSistemaSolars()) {
				PlanetaSistemaSolarLogic planetasistemasolarLogic= new PlanetaSistemaSolarLogic(connexion);
				planetasistemasolarLogic.deepLoad(planetasistemasolar,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaComercial.class));
			tipovaloracion.setReferenciaComercials(tipovaloracionDataAccess.getReferenciaComercials(connexion,tipovaloracion));

			for(ReferenciaComercial referenciacomercial:tipovaloracion.getReferenciaComercials()) {
				ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
				referenciacomercialLogic.deepLoad(referenciacomercial,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoValoracion tipovaloracion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoValoracion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipovaloracion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(tipovaloracion);
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
			this.deepLoad(this.tipovaloracion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(this.tipovaloracion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoValoracion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipovaloracions!=null) {
				for(TipoValoracion tipovaloracion:tipovaloracions) {
					this.deepLoad(tipovaloracion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(tipovaloracions);
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
			if(tipovaloracions!=null) {
				for(TipoValoracion tipovaloracion:tipovaloracions) {
					this.deepLoad(tipovaloracion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoValoracionConstantesFunciones.refrescarForeignKeysDescripcionesTipoValoracion(tipovaloracions);
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
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoValoracionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoValoracionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoValoracion tipovaloracion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoValoracionConstantesFunciones.ISCONAUDITORIA) {
				if(tipovaloracion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoValoracionDataAccess.TABLENAME, tipovaloracion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoValoracionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoValoracionLogic.registrarAuditoriaDetallesTipoValoracion(connexion,tipovaloracion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipovaloracion.getIsDeleted()) {
					/*if(!tipovaloracion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoValoracionDataAccess.TABLENAME, tipovaloracion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoValoracionLogic.registrarAuditoriaDetallesTipoValoracion(connexion,tipovaloracion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoValoracionDataAccess.TABLENAME, tipovaloracion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipovaloracion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoValoracionDataAccess.TABLENAME, tipovaloracion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoValoracionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoValoracionLogic.registrarAuditoriaDetallesTipoValoracion(connexion,tipovaloracion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoValoracion(Connexion connexion,TipoValoracion tipovaloracion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipovaloracion.getIsNew()||!tipovaloracion.getcodigo().equals(tipovaloracion.getTipoValoracionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipovaloracion.getTipoValoracionOriginal().getcodigo()!=null)
				{
					strValorActual=tipovaloracion.getTipoValoracionOriginal().getcodigo();
				}
				if(tipovaloracion.getcodigo()!=null)
				{
					strValorNuevo=tipovaloracion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoValoracionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipovaloracion.getIsNew()||!tipovaloracion.getnombre().equals(tipovaloracion.getTipoValoracionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipovaloracion.getTipoValoracionOriginal().getnombre()!=null)
				{
					strValorActual=tipovaloracion.getTipoValoracionOriginal().getnombre();
				}
				if(tipovaloracion.getnombre()!=null)
				{
					strValorNuevo=tipovaloracion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoValoracionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoValoracion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoValoracionConstantesFunciones.getClassesForeignKeysOfTipoValoracion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoValoracion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoValoracionConstantesFunciones.getClassesRelationshipsOfTipoValoracion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

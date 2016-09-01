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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.TipoAfiliacionConstantesFunciones;
import com.bydan.erp.nomina.util.TipoAfiliacionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoAfiliacionParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoAfiliacion;
import com.bydan.erp.nomina.business.logic.TipoAfiliacionLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoAfiliacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoAfiliacionLogic.class);
	
	protected TipoAfiliacionDataAccess tipoafiliacionDataAccess; 	
	protected TipoAfiliacion tipoafiliacion;
	protected List<TipoAfiliacion> tipoafiliacions;
	protected Object tipoafiliacionObject;	
	protected List<Object> tipoafiliacionsObject;
	
	public static ClassValidator<TipoAfiliacion> tipoafiliacionValidator = new ClassValidator<TipoAfiliacion>(TipoAfiliacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoAfiliacionLogicAdditional tipoafiliacionLogicAdditional=null;
	
	public TipoAfiliacionLogicAdditional getTipoAfiliacionLogicAdditional() {
		return this.tipoafiliacionLogicAdditional;
	}
	
	public void setTipoAfiliacionLogicAdditional(TipoAfiliacionLogicAdditional tipoafiliacionLogicAdditional) {
		try {
			this.tipoafiliacionLogicAdditional=tipoafiliacionLogicAdditional;
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
	
	
	
	
	public  TipoAfiliacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoafiliacionDataAccess = new TipoAfiliacionDataAccess();
			
			this.tipoafiliacions= new ArrayList<TipoAfiliacion>();
			this.tipoafiliacion= new TipoAfiliacion();
			
			this.tipoafiliacionObject=new Object();
			this.tipoafiliacionsObject=new ArrayList<Object>();
				
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
			
			this.tipoafiliacionDataAccess.setConnexionType(this.connexionType);
			this.tipoafiliacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoAfiliacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoafiliacionDataAccess = new TipoAfiliacionDataAccess();
			this.tipoafiliacions= new ArrayList<TipoAfiliacion>();
			this.tipoafiliacion= new TipoAfiliacion();
			this.tipoafiliacionObject=new Object();
			this.tipoafiliacionsObject=new ArrayList<Object>();
			
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
			
			this.tipoafiliacionDataAccess.setConnexionType(this.connexionType);
			this.tipoafiliacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoAfiliacion getTipoAfiliacion() throws Exception {	
		TipoAfiliacionLogicAdditional.checkTipoAfiliacionToGet(tipoafiliacion,this.datosCliente,this.arrDatoGeneral);
		TipoAfiliacionLogicAdditional.updateTipoAfiliacionToGet(tipoafiliacion,this.arrDatoGeneral);
		
		return tipoafiliacion;
	}
		
	public void setTipoAfiliacion(TipoAfiliacion newTipoAfiliacion) {
		this.tipoafiliacion = newTipoAfiliacion;
	}
	
	public TipoAfiliacionDataAccess getTipoAfiliacionDataAccess() {
		return tipoafiliacionDataAccess;
	}
	
	public void setTipoAfiliacionDataAccess(TipoAfiliacionDataAccess newtipoafiliacionDataAccess) {
		this.tipoafiliacionDataAccess = newtipoafiliacionDataAccess;
	}
	
	public List<TipoAfiliacion> getTipoAfiliacions() throws Exception {		
		this.quitarTipoAfiliacionsNulos();
		
		TipoAfiliacionLogicAdditional.checkTipoAfiliacionToGets(tipoafiliacions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoAfiliacion tipoafiliacionLocal: tipoafiliacions ) {
			TipoAfiliacionLogicAdditional.updateTipoAfiliacionToGet(tipoafiliacionLocal,this.arrDatoGeneral);
		}
		
		return tipoafiliacions;
	}
	
	public void setTipoAfiliacions(List<TipoAfiliacion> newTipoAfiliacions) {
		this.tipoafiliacions = newTipoAfiliacions;
	}
	
	public Object getTipoAfiliacionObject() {	
		this.tipoafiliacionObject=this.tipoafiliacionDataAccess.getEntityObject();
		return this.tipoafiliacionObject;
	}
		
	public void setTipoAfiliacionObject(Object newTipoAfiliacionObject) {
		this.tipoafiliacionObject = newTipoAfiliacionObject;
	}
	
	public List<Object> getTipoAfiliacionsObject() {		
		this.tipoafiliacionsObject=this.tipoafiliacionDataAccess.getEntitiesObject();
		return this.tipoafiliacionsObject;
	}
		
	public void setTipoAfiliacionsObject(List<Object> newTipoAfiliacionsObject) {
		this.tipoafiliacionsObject = newTipoAfiliacionsObject;
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
		
		if(this.tipoafiliacionDataAccess!=null) {
			this.tipoafiliacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoafiliacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoafiliacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoafiliacion = new  TipoAfiliacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoafiliacion=tipoafiliacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoafiliacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacion);
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
		tipoafiliacion = new  TipoAfiliacion();
		  		  
        try {
			
			tipoafiliacion=tipoafiliacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoafiliacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoafiliacion = new  TipoAfiliacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoafiliacion=tipoafiliacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoafiliacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacion);
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
		tipoafiliacion = new  TipoAfiliacion();
		  		  
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
		tipoafiliacion = new  TipoAfiliacion();
		  		  
        try {
			
			tipoafiliacion=tipoafiliacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoafiliacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoafiliacion = new  TipoAfiliacion();
		  		  
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
		tipoafiliacion = new  TipoAfiliacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoafiliacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoafiliacion = new  TipoAfiliacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoafiliacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoafiliacion = new  TipoAfiliacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoafiliacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoafiliacion = new  TipoAfiliacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoafiliacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoafiliacion = new  TipoAfiliacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoafiliacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoafiliacion = new  TipoAfiliacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoafiliacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoafiliacions = new  ArrayList<TipoAfiliacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAfiliacion(tipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
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
		tipoafiliacions = new  ArrayList<TipoAfiliacion>();
		  		  
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
		tipoafiliacions = new  ArrayList<TipoAfiliacion>();
		  		  
        try {			
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoAfiliacion(tipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoafiliacions = new  ArrayList<TipoAfiliacion>();
		  		  
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
		tipoafiliacions = new  ArrayList<TipoAfiliacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAfiliacion(tipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
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
		tipoafiliacions = new  ArrayList<TipoAfiliacion>();
		  		  
        try {
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAfiliacion(tipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
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
		tipoafiliacions = new  ArrayList<TipoAfiliacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAfiliacion(tipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
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
		tipoafiliacions = new  ArrayList<TipoAfiliacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAfiliacion(tipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoafiliacion = new  TipoAfiliacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoafiliacion=tipoafiliacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAfiliacion(tipoafiliacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacion);
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
		tipoafiliacion = new  TipoAfiliacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoafiliacion=tipoafiliacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAfiliacion(tipoafiliacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoafiliacions = new  ArrayList<TipoAfiliacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoafiliacions=tipoafiliacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAfiliacion(tipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
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
		tipoafiliacions = new  ArrayList<TipoAfiliacion>();
		  		  
        try {
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoafiliacions=tipoafiliacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAfiliacion(tipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoAfiliacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoafiliacions = new  ArrayList<TipoAfiliacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getTodosTipoAfiliacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoAfiliacion(tipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
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
	
	public  void  getTodosTipoAfiliacions(String sFinalQuery,Pagination pagination)throws Exception {
		tipoafiliacions = new  ArrayList<TipoAfiliacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoAfiliacion(tipoafiliacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoAfiliacion(TipoAfiliacion tipoafiliacion) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoafiliacion.getIsNew() || tipoafiliacion.getIsChanged()) { 
			this.invalidValues = tipoafiliacionValidator.getInvalidValues(tipoafiliacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoafiliacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoAfiliacion(List<TipoAfiliacion> TipoAfiliacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoAfiliacion tipoafiliacionLocal:tipoafiliacions) {				
			estaValidadoObjeto=this.validarGuardarTipoAfiliacion(tipoafiliacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoAfiliacion(List<TipoAfiliacion> TipoAfiliacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoAfiliacion(tipoafiliacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoAfiliacion(TipoAfiliacion TipoAfiliacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoAfiliacion(tipoafiliacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoAfiliacion tipoafiliacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoafiliacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoAfiliacionConstantesFunciones.getTipoAfiliacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoafiliacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoAfiliacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoAfiliacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoAfiliacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-saveTipoAfiliacionWithConnection");connexion.begin();			
			
			TipoAfiliacionLogicAdditional.checkTipoAfiliacionToSave(this.tipoafiliacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoAfiliacionLogicAdditional.updateTipoAfiliacionToSave(this.tipoafiliacion,this.arrDatoGeneral);
			
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoafiliacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoAfiliacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoAfiliacion(this.tipoafiliacion)) {
				TipoAfiliacionDataAccess.save(this.tipoafiliacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoafiliacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoAfiliacionLogicAdditional.checkTipoAfiliacionToSaveAfter(this.tipoafiliacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoAfiliacion();
			
			connexion.commit();			
			
			if(this.tipoafiliacion.getIsDeleted()) {
				this.tipoafiliacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoAfiliacion()throws Exception {	
		try {	
			
			TipoAfiliacionLogicAdditional.checkTipoAfiliacionToSave(this.tipoafiliacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoAfiliacionLogicAdditional.updateTipoAfiliacionToSave(this.tipoafiliacion,this.arrDatoGeneral);
			
			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoafiliacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoAfiliacion(this.tipoafiliacion)) {			
				TipoAfiliacionDataAccess.save(this.tipoafiliacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoafiliacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoAfiliacionLogicAdditional.checkTipoAfiliacionToSaveAfter(this.tipoafiliacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoafiliacion.getIsDeleted()) {
				this.tipoafiliacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoAfiliacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-saveTipoAfiliacionsWithConnection");connexion.begin();			
			
			TipoAfiliacionLogicAdditional.checkTipoAfiliacionToSaves(tipoafiliacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoAfiliacions();
			
			Boolean validadoTodosTipoAfiliacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoAfiliacion tipoafiliacionLocal:tipoafiliacions) {		
				if(tipoafiliacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoAfiliacionLogicAdditional.updateTipoAfiliacionToSave(tipoafiliacionLocal,this.arrDatoGeneral);
	        	
				TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoafiliacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoAfiliacion(tipoafiliacionLocal)) {
					TipoAfiliacionDataAccess.save(tipoafiliacionLocal, connexion);				
				} else {
					validadoTodosTipoAfiliacion=false;
				}
			}
			
			if(!validadoTodosTipoAfiliacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoAfiliacionLogicAdditional.checkTipoAfiliacionToSavesAfter(tipoafiliacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoAfiliacions();
			
			connexion.commit();		
			
			this.quitarTipoAfiliacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoAfiliacions()throws Exception {				
		 try {	
			TipoAfiliacionLogicAdditional.checkTipoAfiliacionToSaves(tipoafiliacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoAfiliacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoAfiliacion tipoafiliacionLocal:tipoafiliacions) {				
				if(tipoafiliacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoAfiliacionLogicAdditional.updateTipoAfiliacionToSave(tipoafiliacionLocal,this.arrDatoGeneral);
	        	
				TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoafiliacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoAfiliacion(tipoafiliacionLocal)) {				
					TipoAfiliacionDataAccess.save(tipoafiliacionLocal, connexion);				
				} else {
					validadoTodosTipoAfiliacion=false;
				}
			}
			
			if(!validadoTodosTipoAfiliacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoAfiliacionLogicAdditional.checkTipoAfiliacionToSavesAfter(tipoafiliacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoAfiliacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoAfiliacionParameterReturnGeneral procesarAccionTipoAfiliacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoAfiliacion> tipoafiliacions,TipoAfiliacionParameterReturnGeneral tipoafiliacionParameterGeneral)throws Exception {
		 try {	
			TipoAfiliacionParameterReturnGeneral tipoafiliacionReturnGeneral=new TipoAfiliacionParameterReturnGeneral();
	
			TipoAfiliacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoafiliacions,tipoafiliacionParameterGeneral,tipoafiliacionReturnGeneral);
			
			return tipoafiliacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoAfiliacionParameterReturnGeneral procesarAccionTipoAfiliacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoAfiliacion> tipoafiliacions,TipoAfiliacionParameterReturnGeneral tipoafiliacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-procesarAccionTipoAfiliacionsWithConnection");connexion.begin();			
			
			TipoAfiliacionParameterReturnGeneral tipoafiliacionReturnGeneral=new TipoAfiliacionParameterReturnGeneral();
	
			TipoAfiliacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoafiliacions,tipoafiliacionParameterGeneral,tipoafiliacionReturnGeneral);
			
			this.connexion.commit();
			
			return tipoafiliacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoAfiliacionParameterReturnGeneral procesarEventosTipoAfiliacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoAfiliacion> tipoafiliacions,TipoAfiliacion tipoafiliacion,TipoAfiliacionParameterReturnGeneral tipoafiliacionParameterGeneral,Boolean isEsNuevoTipoAfiliacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoAfiliacionParameterReturnGeneral tipoafiliacionReturnGeneral=new TipoAfiliacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoafiliacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoAfiliacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoafiliacions,tipoafiliacion,tipoafiliacionParameterGeneral,tipoafiliacionReturnGeneral,isEsNuevoTipoAfiliacion,clases);
			
			return tipoafiliacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoAfiliacionParameterReturnGeneral procesarEventosTipoAfiliacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoAfiliacion> tipoafiliacions,TipoAfiliacion tipoafiliacion,TipoAfiliacionParameterReturnGeneral tipoafiliacionParameterGeneral,Boolean isEsNuevoTipoAfiliacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-procesarEventosTipoAfiliacionsWithConnection");connexion.begin();			
			
			TipoAfiliacionParameterReturnGeneral tipoafiliacionReturnGeneral=new TipoAfiliacionParameterReturnGeneral();
	
			tipoafiliacionReturnGeneral.setTipoAfiliacion(tipoafiliacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoafiliacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoAfiliacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoafiliacions,tipoafiliacion,tipoafiliacionParameterGeneral,tipoafiliacionReturnGeneral,isEsNuevoTipoAfiliacion,clases);
			
			this.connexion.commit();
			
			return tipoafiliacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoAfiliacionParameterReturnGeneral procesarImportacionTipoAfiliacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoAfiliacionParameterReturnGeneral tipoafiliacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-procesarImportacionTipoAfiliacionsWithConnection");connexion.begin();			
			
			TipoAfiliacionParameterReturnGeneral tipoafiliacionReturnGeneral=new TipoAfiliacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoafiliacions=new ArrayList<TipoAfiliacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoafiliacion=new TipoAfiliacion();
				
				
				if(conColumnasBase) {this.tipoafiliacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoafiliacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoafiliacion.setcodigo(arrColumnas[iColumn++]);
				this.tipoafiliacion.setnombre(arrColumnas[iColumn++]);
				this.tipoafiliacion.setporcen_emplea(Double.parseDouble(arrColumnas[iColumn++]));
				this.tipoafiliacion.setporcen_patro(Double.parseDouble(arrColumnas[iColumn++]));
				this.tipoafiliacion.setporcen_gene_emplea(Double.parseDouble(arrColumnas[iColumn++]));
				this.tipoafiliacion.setporcen_gene_patro(Double.parseDouble(arrColumnas[iColumn++]));
				this.tipoafiliacion.setporcen_secu(Double.parseDouble(arrColumnas[iColumn++]));
				this.tipoafiliacion.setporcen_iece(Double.parseDouble(arrColumnas[iColumn++]));
			this.tipoafiliacion.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipoafiliacions.add(this.tipoafiliacion);
			}
			
			this.saveTipoAfiliacions();
			
			this.connexion.commit();
			
			tipoafiliacionReturnGeneral.setConRetornoEstaProcesado(true);
			tipoafiliacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoafiliacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoAfiliacionsEliminados() throws Exception {				
		
		List<TipoAfiliacion> tipoafiliacionsAux= new ArrayList<TipoAfiliacion>();
		
		for(TipoAfiliacion tipoafiliacion:tipoafiliacions) {
			if(!tipoafiliacion.getIsDeleted()) {
				tipoafiliacionsAux.add(tipoafiliacion);
			}
		}
		
		tipoafiliacions=tipoafiliacionsAux;
	}
	
	public void quitarTipoAfiliacionsNulos() throws Exception {				
		
		List<TipoAfiliacion> tipoafiliacionsAux= new ArrayList<TipoAfiliacion>();
		
		for(TipoAfiliacion tipoafiliacion : this.tipoafiliacions) {
			if(tipoafiliacion==null) {
				tipoafiliacionsAux.add(tipoafiliacion);
			}
		}
		
		//this.tipoafiliacions=tipoafiliacionsAux;
		
		this.tipoafiliacions.removeAll(tipoafiliacionsAux);
	}
	
	public void getSetVersionRowTipoAfiliacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoafiliacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoafiliacion.getIsDeleted() || (tipoafiliacion.getIsChanged()&&!tipoafiliacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoafiliacionDataAccess.getSetVersionRowTipoAfiliacion(connexion,tipoafiliacion.getId());
				
				if(!tipoafiliacion.getVersionRow().equals(timestamp)) {	
					tipoafiliacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoafiliacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoAfiliacion()throws Exception {	
		
		if(tipoafiliacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoafiliacion.getIsDeleted() || (tipoafiliacion.getIsChanged()&&!tipoafiliacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoafiliacionDataAccess.getSetVersionRowTipoAfiliacion(connexion,tipoafiliacion.getId());
			
			try {							
				if(!tipoafiliacion.getVersionRow().equals(timestamp)) {	
					tipoafiliacion.setVersionRow(timestamp);
				}
				
				tipoafiliacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoAfiliacionsWithConnection()throws Exception {	
		if(tipoafiliacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoAfiliacion tipoafiliacionAux:tipoafiliacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoafiliacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoafiliacionAux.getIsDeleted() || (tipoafiliacionAux.getIsChanged()&&!tipoafiliacionAux.getIsNew())) {
						
						timestamp=tipoafiliacionDataAccess.getSetVersionRowTipoAfiliacion(connexion,tipoafiliacionAux.getId());
						
						if(!tipoafiliacion.getVersionRow().equals(timestamp)) {	
							tipoafiliacionAux.setVersionRow(timestamp);
						}
								
						tipoafiliacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoAfiliacions()throws Exception {	
		if(tipoafiliacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoAfiliacion tipoafiliacionAux:tipoafiliacions) {
					if(tipoafiliacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoafiliacionAux.getIsDeleted() || (tipoafiliacionAux.getIsChanged()&&!tipoafiliacionAux.getIsNew())) {
						
						timestamp=tipoafiliacionDataAccess.getSetVersionRowTipoAfiliacion(connexion,tipoafiliacionAux.getId());
						
						if(!tipoafiliacionAux.getVersionRow().equals(timestamp)) {	
							tipoafiliacionAux.setVersionRow(timestamp);
						}
						
													
						tipoafiliacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoAfiliacionParameterReturnGeneral cargarCombosLoteForeignKeyTipoAfiliacionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCateTipoAfiliacion) throws Exception {
		TipoAfiliacionParameterReturnGeneral  tipoafiliacionReturnGeneral =new TipoAfiliacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoAfiliacionWithConnection");connexion.begin();
			
			tipoafiliacionReturnGeneral =new TipoAfiliacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoafiliacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CateTipoAfiliacion> catetipoafiliacionsForeignKey=new ArrayList<CateTipoAfiliacion>();
			CateTipoAfiliacionLogic catetipoafiliacionLogic=new CateTipoAfiliacionLogic();
			catetipoafiliacionLogic.setConnexion(this.connexion);
			//catetipoafiliacionLogic.getCateTipoAfiliacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCateTipoAfiliacion.equals("NONE")) {
				catetipoafiliacionLogic.getTodosCateTipoAfiliacions(finalQueryGlobalCateTipoAfiliacion,new Pagination());
				catetipoafiliacionsForeignKey=catetipoafiliacionLogic.getCateTipoAfiliacions();
			}

			tipoafiliacionReturnGeneral.setcatetipoafiliacionsForeignKey(catetipoafiliacionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoafiliacionReturnGeneral;
	}
	
	public TipoAfiliacionParameterReturnGeneral cargarCombosLoteForeignKeyTipoAfiliacion(String finalQueryGlobalEmpresa,String finalQueryGlobalCateTipoAfiliacion) throws Exception {
		TipoAfiliacionParameterReturnGeneral  tipoafiliacionReturnGeneral =new TipoAfiliacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoafiliacionReturnGeneral =new TipoAfiliacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoafiliacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CateTipoAfiliacion> catetipoafiliacionsForeignKey=new ArrayList<CateTipoAfiliacion>();
			CateTipoAfiliacionLogic catetipoafiliacionLogic=new CateTipoAfiliacionLogic();
			catetipoafiliacionLogic.setConnexion(this.connexion);
			//catetipoafiliacionLogic.getCateTipoAfiliacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCateTipoAfiliacion.equals("NONE")) {
				catetipoafiliacionLogic.getTodosCateTipoAfiliacions(finalQueryGlobalCateTipoAfiliacion,new Pagination());
				catetipoafiliacionsForeignKey=catetipoafiliacionLogic.getCateTipoAfiliacions();
			}

			tipoafiliacionReturnGeneral.setcatetipoafiliacionsForeignKey(catetipoafiliacionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoafiliacionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoAfiliacionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic=new DatoGeneralEmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoAfiliacionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DatoGeneralEmpleado.class));
											
			

			datogeneralempleadoLogic.setConnexion(this.getConnexion());
			datogeneralempleadoLogic.setDatosCliente(this.datosCliente);
			datogeneralempleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoAfiliacion tipoafiliacion:this.tipoafiliacions) {
				

				classes=new ArrayList<Classe>();
				classes=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				datogeneralempleadoLogic.setDatoGeneralEmpleados(tipoafiliacion.datogeneralempleados);
				datogeneralempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoAfiliacion tipoafiliacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoAfiliacionLogicAdditional.updateTipoAfiliacionToGet(tipoafiliacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoafiliacion.setEmpresa(tipoafiliacionDataAccess.getEmpresa(connexion,tipoafiliacion));
		tipoafiliacion.setCateTipoAfiliacion(tipoafiliacionDataAccess.getCateTipoAfiliacion(connexion,tipoafiliacion));
		tipoafiliacion.setDatoGeneralEmpleados(tipoafiliacionDataAccess.getDatoGeneralEmpleados(connexion,tipoafiliacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoafiliacion.setEmpresa(tipoafiliacionDataAccess.getEmpresa(connexion,tipoafiliacion));
				continue;
			}

			if(clas.clas.equals(CateTipoAfiliacion.class)) {
				tipoafiliacion.setCateTipoAfiliacion(tipoafiliacionDataAccess.getCateTipoAfiliacion(connexion,tipoafiliacion));
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoafiliacion.setDatoGeneralEmpleados(tipoafiliacionDataAccess.getDatoGeneralEmpleados(connexion,tipoafiliacion));

				if(this.isConDeep) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(this.connexion);
					datogeneralempleadoLogic.setDatoGeneralEmpleados(tipoafiliacion.getDatoGeneralEmpleados());
					ArrayList<Classe> classesLocal=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					datogeneralempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(datogeneralempleadoLogic.getDatoGeneralEmpleados());
					tipoafiliacion.setDatoGeneralEmpleados(datogeneralempleadoLogic.getDatoGeneralEmpleados());
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
			tipoafiliacion.setEmpresa(tipoafiliacionDataAccess.getEmpresa(connexion,tipoafiliacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CateTipoAfiliacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoafiliacion.setCateTipoAfiliacion(tipoafiliacionDataAccess.getCateTipoAfiliacion(connexion,tipoafiliacion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			tipoafiliacion.setDatoGeneralEmpleados(tipoafiliacionDataAccess.getDatoGeneralEmpleados(connexion,tipoafiliacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoafiliacion.setEmpresa(tipoafiliacionDataAccess.getEmpresa(connexion,tipoafiliacion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoafiliacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		tipoafiliacion.setCateTipoAfiliacion(tipoafiliacionDataAccess.getCateTipoAfiliacion(connexion,tipoafiliacion));
		CateTipoAfiliacionLogic catetipoafiliacionLogic= new CateTipoAfiliacionLogic(connexion);
		catetipoafiliacionLogic.deepLoad(tipoafiliacion.getCateTipoAfiliacion(),isDeep,deepLoadType,clases);
				

		tipoafiliacion.setDatoGeneralEmpleados(tipoafiliacionDataAccess.getDatoGeneralEmpleados(connexion,tipoafiliacion));

		for(DatoGeneralEmpleado datogeneralempleado:tipoafiliacion.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoafiliacion.setEmpresa(tipoafiliacionDataAccess.getEmpresa(connexion,tipoafiliacion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoafiliacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CateTipoAfiliacion.class)) {
				tipoafiliacion.setCateTipoAfiliacion(tipoafiliacionDataAccess.getCateTipoAfiliacion(connexion,tipoafiliacion));
				CateTipoAfiliacionLogic catetipoafiliacionLogic= new CateTipoAfiliacionLogic(connexion);
				catetipoafiliacionLogic.deepLoad(tipoafiliacion.getCateTipoAfiliacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoafiliacion.setDatoGeneralEmpleados(tipoafiliacionDataAccess.getDatoGeneralEmpleados(connexion,tipoafiliacion));

				for(DatoGeneralEmpleado datogeneralempleado:tipoafiliacion.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
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
			tipoafiliacion.setEmpresa(tipoafiliacionDataAccess.getEmpresa(connexion,tipoafiliacion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoafiliacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CateTipoAfiliacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoafiliacion.setCateTipoAfiliacion(tipoafiliacionDataAccess.getCateTipoAfiliacion(connexion,tipoafiliacion));
			CateTipoAfiliacionLogic catetipoafiliacionLogic= new CateTipoAfiliacionLogic(connexion);
			catetipoafiliacionLogic.deepLoad(tipoafiliacion.getCateTipoAfiliacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			tipoafiliacion.setDatoGeneralEmpleados(tipoafiliacionDataAccess.getDatoGeneralEmpleados(connexion,tipoafiliacion));

			for(DatoGeneralEmpleado datogeneralempleado:tipoafiliacion.getDatoGeneralEmpleados()) {
				DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
				datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoAfiliacion tipoafiliacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoAfiliacionLogicAdditional.updateTipoAfiliacionToSave(tipoafiliacion,this.arrDatoGeneral);
			
TipoAfiliacionDataAccess.save(tipoafiliacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoafiliacion.getEmpresa(),connexion);

		CateTipoAfiliacionDataAccess.save(tipoafiliacion.getCateTipoAfiliacion(),connexion);

		for(DatoGeneralEmpleado datogeneralempleado:tipoafiliacion.getDatoGeneralEmpleados()) {
			datogeneralempleado.setid_tipo_afiliacion(tipoafiliacion.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoafiliacion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CateTipoAfiliacion.class)) {
				CateTipoAfiliacionDataAccess.save(tipoafiliacion.getCateTipoAfiliacion(),connexion);
				continue;
			}


			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:tipoafiliacion.getDatoGeneralEmpleados()) {
					datogeneralempleado.setid_tipo_afiliacion(tipoafiliacion.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoafiliacion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoafiliacion.getEmpresa(),isDeep,deepLoadType,clases);
				

		CateTipoAfiliacionDataAccess.save(tipoafiliacion.getCateTipoAfiliacion(),connexion);
		CateTipoAfiliacionLogic catetipoafiliacionLogic= new CateTipoAfiliacionLogic(connexion);
		catetipoafiliacionLogic.deepLoad(tipoafiliacion.getCateTipoAfiliacion(),isDeep,deepLoadType,clases);
				

		for(DatoGeneralEmpleado datogeneralempleado:tipoafiliacion.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleado.setid_tipo_afiliacion(tipoafiliacion.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
			datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoafiliacion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoafiliacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CateTipoAfiliacion.class)) {
				CateTipoAfiliacionDataAccess.save(tipoafiliacion.getCateTipoAfiliacion(),connexion);
				CateTipoAfiliacionLogic catetipoafiliacionLogic= new CateTipoAfiliacionLogic(connexion);
				catetipoafiliacionLogic.deepSave(tipoafiliacion.getCateTipoAfiliacion(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:tipoafiliacion.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleado.setid_tipo_afiliacion(tipoafiliacion.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
					datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoAfiliacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoafiliacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(tipoafiliacion);
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
			this.deepLoad(this.tipoafiliacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoAfiliacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoafiliacions!=null) {
				for(TipoAfiliacion tipoafiliacion:tipoafiliacions) {
					this.deepLoad(tipoafiliacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(tipoafiliacions);
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
			if(tipoafiliacions!=null) {
				for(TipoAfiliacion tipoafiliacion:tipoafiliacions) {
					this.deepLoad(tipoafiliacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(tipoafiliacions);
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
			this.getNewConnexionToDeep(TipoAfiliacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoafiliacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoAfiliacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoafiliacions!=null) {
				for(TipoAfiliacion tipoafiliacion:tipoafiliacions) {
					this.deepSave(tipoafiliacion,isDeep,deepLoadType,clases);
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
			if(tipoafiliacions!=null) {
				for(TipoAfiliacion tipoafiliacion:tipoafiliacions) {
					this.deepSave(tipoafiliacion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoAfiliacionsFK_IdCateTipoAfiliacionWithConnection(String sFinalQuery,Pagination pagination,Long id_cate_tipo_afiliacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCateTipoAfiliacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCateTipoAfiliacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cate_tipo_afiliacion,TipoAfiliacionConstantesFunciones.IDCATETIPOAFILIACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCateTipoAfiliacion);

			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCateTipoAfiliacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoAfiliacionsFK_IdCateTipoAfiliacion(String sFinalQuery,Pagination pagination,Long id_cate_tipo_afiliacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCateTipoAfiliacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCateTipoAfiliacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cate_tipo_afiliacion,TipoAfiliacionConstantesFunciones.IDCATETIPOAFILIACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCateTipoAfiliacion);

			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCateTipoAfiliacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoAfiliacionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAfiliacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoAfiliacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoAfiliacionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoAfiliacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoAfiliacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAfiliacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoAfiliacion(this.tipoafiliacions);
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
			if(TipoAfiliacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAfiliacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoAfiliacion tipoafiliacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoAfiliacionConstantesFunciones.ISCONAUDITORIA) {
				if(tipoafiliacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAfiliacionDataAccess.TABLENAME, tipoafiliacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoAfiliacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoAfiliacionLogic.registrarAuditoriaDetallesTipoAfiliacion(connexion,tipoafiliacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoafiliacion.getIsDeleted()) {
					/*if(!tipoafiliacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoAfiliacionDataAccess.TABLENAME, tipoafiliacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoAfiliacionLogic.registrarAuditoriaDetallesTipoAfiliacion(connexion,tipoafiliacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAfiliacionDataAccess.TABLENAME, tipoafiliacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoafiliacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAfiliacionDataAccess.TABLENAME, tipoafiliacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoAfiliacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoAfiliacionLogic.registrarAuditoriaDetallesTipoAfiliacion(connexion,tipoafiliacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoAfiliacion(Connexion connexion,TipoAfiliacion tipoafiliacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoafiliacion.getIsNew()||!tipoafiliacion.getid_empresa().equals(tipoafiliacion.getTipoAfiliacionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoafiliacion.getTipoAfiliacionOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoafiliacion.getTipoAfiliacionOriginal().getid_empresa().toString();
				}
				if(tipoafiliacion.getid_empresa()!=null)
				{
					strValorNuevo=tipoafiliacion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAfiliacionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoafiliacion.getIsNew()||!tipoafiliacion.getid_cate_tipo_afiliacion().equals(tipoafiliacion.getTipoAfiliacionOriginal().getid_cate_tipo_afiliacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoafiliacion.getTipoAfiliacionOriginal().getid_cate_tipo_afiliacion()!=null)
				{
					strValorActual=tipoafiliacion.getTipoAfiliacionOriginal().getid_cate_tipo_afiliacion().toString();
				}
				if(tipoafiliacion.getid_cate_tipo_afiliacion()!=null)
				{
					strValorNuevo=tipoafiliacion.getid_cate_tipo_afiliacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAfiliacionConstantesFunciones.IDCATETIPOAFILIACION,strValorActual,strValorNuevo);
			}	
			
			if(tipoafiliacion.getIsNew()||!tipoafiliacion.getcodigo().equals(tipoafiliacion.getTipoAfiliacionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoafiliacion.getTipoAfiliacionOriginal().getcodigo()!=null)
				{
					strValorActual=tipoafiliacion.getTipoAfiliacionOriginal().getcodigo();
				}
				if(tipoafiliacion.getcodigo()!=null)
				{
					strValorNuevo=tipoafiliacion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAfiliacionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoafiliacion.getIsNew()||!tipoafiliacion.getnombre().equals(tipoafiliacion.getTipoAfiliacionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoafiliacion.getTipoAfiliacionOriginal().getnombre()!=null)
				{
					strValorActual=tipoafiliacion.getTipoAfiliacionOriginal().getnombre();
				}
				if(tipoafiliacion.getnombre()!=null)
				{
					strValorNuevo=tipoafiliacion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAfiliacionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipoafiliacion.getIsNew()||!tipoafiliacion.getporcen_emplea().equals(tipoafiliacion.getTipoAfiliacionOriginal().getporcen_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoafiliacion.getTipoAfiliacionOriginal().getporcen_emplea()!=null)
				{
					strValorActual=tipoafiliacion.getTipoAfiliacionOriginal().getporcen_emplea().toString();
				}
				if(tipoafiliacion.getporcen_emplea()!=null)
				{
					strValorNuevo=tipoafiliacion.getporcen_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAfiliacionConstantesFunciones.PORCENEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(tipoafiliacion.getIsNew()||!tipoafiliacion.getporcen_patro().equals(tipoafiliacion.getTipoAfiliacionOriginal().getporcen_patro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoafiliacion.getTipoAfiliacionOriginal().getporcen_patro()!=null)
				{
					strValorActual=tipoafiliacion.getTipoAfiliacionOriginal().getporcen_patro().toString();
				}
				if(tipoafiliacion.getporcen_patro()!=null)
				{
					strValorNuevo=tipoafiliacion.getporcen_patro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAfiliacionConstantesFunciones.PORCENPATRO,strValorActual,strValorNuevo);
			}	
			
			if(tipoafiliacion.getIsNew()||!tipoafiliacion.getporcen_gene_emplea().equals(tipoafiliacion.getTipoAfiliacionOriginal().getporcen_gene_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoafiliacion.getTipoAfiliacionOriginal().getporcen_gene_emplea()!=null)
				{
					strValorActual=tipoafiliacion.getTipoAfiliacionOriginal().getporcen_gene_emplea().toString();
				}
				if(tipoafiliacion.getporcen_gene_emplea()!=null)
				{
					strValorNuevo=tipoafiliacion.getporcen_gene_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAfiliacionConstantesFunciones.PORCENGENEEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(tipoafiliacion.getIsNew()||!tipoafiliacion.getporcen_gene_patro().equals(tipoafiliacion.getTipoAfiliacionOriginal().getporcen_gene_patro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoafiliacion.getTipoAfiliacionOriginal().getporcen_gene_patro()!=null)
				{
					strValorActual=tipoafiliacion.getTipoAfiliacionOriginal().getporcen_gene_patro().toString();
				}
				if(tipoafiliacion.getporcen_gene_patro()!=null)
				{
					strValorNuevo=tipoafiliacion.getporcen_gene_patro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAfiliacionConstantesFunciones.PORCENGENEPATRO,strValorActual,strValorNuevo);
			}	
			
			if(tipoafiliacion.getIsNew()||!tipoafiliacion.getporcen_secu().equals(tipoafiliacion.getTipoAfiliacionOriginal().getporcen_secu()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoafiliacion.getTipoAfiliacionOriginal().getporcen_secu()!=null)
				{
					strValorActual=tipoafiliacion.getTipoAfiliacionOriginal().getporcen_secu().toString();
				}
				if(tipoafiliacion.getporcen_secu()!=null)
				{
					strValorNuevo=tipoafiliacion.getporcen_secu().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAfiliacionConstantesFunciones.PORCENSECU,strValorActual,strValorNuevo);
			}	
			
			if(tipoafiliacion.getIsNew()||!tipoafiliacion.getporcen_iece().equals(tipoafiliacion.getTipoAfiliacionOriginal().getporcen_iece()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoafiliacion.getTipoAfiliacionOriginal().getporcen_iece()!=null)
				{
					strValorActual=tipoafiliacion.getTipoAfiliacionOriginal().getporcen_iece().toString();
				}
				if(tipoafiliacion.getporcen_iece()!=null)
				{
					strValorNuevo=tipoafiliacion.getporcen_iece().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAfiliacionConstantesFunciones.PORCENIECE,strValorActual,strValorNuevo);
			}	
			
			if(tipoafiliacion.getIsNew()||!tipoafiliacion.getdescripcion().equals(tipoafiliacion.getTipoAfiliacionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoafiliacion.getTipoAfiliacionOriginal().getdescripcion()!=null)
				{
					strValorActual=tipoafiliacion.getTipoAfiliacionOriginal().getdescripcion();
				}
				if(tipoafiliacion.getdescripcion()!=null)
				{
					strValorNuevo=tipoafiliacion.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAfiliacionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoAfiliacionRelacionesWithConnection(TipoAfiliacion tipoafiliacion,List<DatoGeneralEmpleado> datogeneralempleados) throws Exception {

		if(!tipoafiliacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoAfiliacionRelacionesBase(tipoafiliacion,datogeneralempleados,true);
		}
	}

	public void saveTipoAfiliacionRelaciones(TipoAfiliacion tipoafiliacion,List<DatoGeneralEmpleado> datogeneralempleados)throws Exception {

		if(!tipoafiliacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoAfiliacionRelacionesBase(tipoafiliacion,datogeneralempleados,false);
		}
	}

	public void saveTipoAfiliacionRelacionesBase(TipoAfiliacion tipoafiliacion,List<DatoGeneralEmpleado> datogeneralempleados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoAfiliacion-saveRelacionesWithConnection");}
	
			tipoafiliacion.setDatoGeneralEmpleados(datogeneralempleados);

			this.setTipoAfiliacion(tipoafiliacion);

			if(TipoAfiliacionLogicAdditional.validarSaveRelaciones(tipoafiliacion,this)) {

				TipoAfiliacionLogicAdditional.updateRelacionesToSave(tipoafiliacion,this);

				if((tipoafiliacion.getIsNew()||tipoafiliacion.getIsChanged())&&!tipoafiliacion.getIsDeleted()) {
					this.saveTipoAfiliacion();
					this.saveTipoAfiliacionRelacionesDetalles(datogeneralempleados);

				} else if(tipoafiliacion.getIsDeleted()) {
					this.saveTipoAfiliacionRelacionesDetalles(datogeneralempleados);
					this.saveTipoAfiliacion();
				}

				TipoAfiliacionLogicAdditional.updateRelacionesToSaveAfter(tipoafiliacion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DatoGeneralEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresDatoGeneralEmpleados(datogeneralempleados,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoAfiliacionRelacionesDetalles(List<DatoGeneralEmpleado> datogeneralempleados)throws Exception {
		try {
	

			Long idTipoAfiliacionActual=this.getTipoAfiliacion().getId();

			DatoGeneralEmpleadoLogic datogeneralempleadoLogic_Desde_TipoAfiliacion=new DatoGeneralEmpleadoLogic();
			datogeneralempleadoLogic_Desde_TipoAfiliacion.setDatoGeneralEmpleados(datogeneralempleados);

			datogeneralempleadoLogic_Desde_TipoAfiliacion.setConnexion(this.getConnexion());
			datogeneralempleadoLogic_Desde_TipoAfiliacion.setDatosCliente(this.datosCliente);

			for(DatoGeneralEmpleado datogeneralempleado_Desde_TipoAfiliacion:datogeneralempleadoLogic_Desde_TipoAfiliacion.getDatoGeneralEmpleados()) {
				datogeneralempleado_Desde_TipoAfiliacion.setid_tipo_afiliacion(idTipoAfiliacionActual);
			}

			datogeneralempleadoLogic_Desde_TipoAfiliacion.saveDatoGeneralEmpleados();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoAfiliacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoAfiliacionConstantesFunciones.getClassesForeignKeysOfTipoAfiliacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAfiliacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoAfiliacionConstantesFunciones.getClassesRelationshipsOfTipoAfiliacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

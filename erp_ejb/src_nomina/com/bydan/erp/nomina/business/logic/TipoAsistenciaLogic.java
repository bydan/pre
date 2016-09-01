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
import com.bydan.erp.nomina.util.TipoAsistenciaConstantesFunciones;
import com.bydan.erp.nomina.util.TipoAsistenciaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoAsistenciaParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoAsistencia;
import com.bydan.erp.nomina.business.logic.TipoAsistenciaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoAsistenciaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoAsistenciaLogic.class);
	
	protected TipoAsistenciaDataAccess tipoasistenciaDataAccess; 	
	protected TipoAsistencia tipoasistencia;
	protected List<TipoAsistencia> tipoasistencias;
	protected Object tipoasistenciaObject;	
	protected List<Object> tipoasistenciasObject;
	
	public static ClassValidator<TipoAsistencia> tipoasistenciaValidator = new ClassValidator<TipoAsistencia>(TipoAsistencia.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoAsistenciaLogicAdditional tipoasistenciaLogicAdditional=null;
	
	public TipoAsistenciaLogicAdditional getTipoAsistenciaLogicAdditional() {
		return this.tipoasistenciaLogicAdditional;
	}
	
	public void setTipoAsistenciaLogicAdditional(TipoAsistenciaLogicAdditional tipoasistenciaLogicAdditional) {
		try {
			this.tipoasistenciaLogicAdditional=tipoasistenciaLogicAdditional;
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
	
	
	
	
	public  TipoAsistenciaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoasistenciaDataAccess = new TipoAsistenciaDataAccess();
			
			this.tipoasistencias= new ArrayList<TipoAsistencia>();
			this.tipoasistencia= new TipoAsistencia();
			
			this.tipoasistenciaObject=new Object();
			this.tipoasistenciasObject=new ArrayList<Object>();
				
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
			
			this.tipoasistenciaDataAccess.setConnexionType(this.connexionType);
			this.tipoasistenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoAsistenciaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoasistenciaDataAccess = new TipoAsistenciaDataAccess();
			this.tipoasistencias= new ArrayList<TipoAsistencia>();
			this.tipoasistencia= new TipoAsistencia();
			this.tipoasistenciaObject=new Object();
			this.tipoasistenciasObject=new ArrayList<Object>();
			
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
			
			this.tipoasistenciaDataAccess.setConnexionType(this.connexionType);
			this.tipoasistenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoAsistencia getTipoAsistencia() throws Exception {	
		TipoAsistenciaLogicAdditional.checkTipoAsistenciaToGet(tipoasistencia,this.datosCliente,this.arrDatoGeneral);
		TipoAsistenciaLogicAdditional.updateTipoAsistenciaToGet(tipoasistencia,this.arrDatoGeneral);
		
		return tipoasistencia;
	}
		
	public void setTipoAsistencia(TipoAsistencia newTipoAsistencia) {
		this.tipoasistencia = newTipoAsistencia;
	}
	
	public TipoAsistenciaDataAccess getTipoAsistenciaDataAccess() {
		return tipoasistenciaDataAccess;
	}
	
	public void setTipoAsistenciaDataAccess(TipoAsistenciaDataAccess newtipoasistenciaDataAccess) {
		this.tipoasistenciaDataAccess = newtipoasistenciaDataAccess;
	}
	
	public List<TipoAsistencia> getTipoAsistencias() throws Exception {		
		this.quitarTipoAsistenciasNulos();
		
		TipoAsistenciaLogicAdditional.checkTipoAsistenciaToGets(tipoasistencias,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoAsistencia tipoasistenciaLocal: tipoasistencias ) {
			TipoAsistenciaLogicAdditional.updateTipoAsistenciaToGet(tipoasistenciaLocal,this.arrDatoGeneral);
		}
		
		return tipoasistencias;
	}
	
	public void setTipoAsistencias(List<TipoAsistencia> newTipoAsistencias) {
		this.tipoasistencias = newTipoAsistencias;
	}
	
	public Object getTipoAsistenciaObject() {	
		this.tipoasistenciaObject=this.tipoasistenciaDataAccess.getEntityObject();
		return this.tipoasistenciaObject;
	}
		
	public void setTipoAsistenciaObject(Object newTipoAsistenciaObject) {
		this.tipoasistenciaObject = newTipoAsistenciaObject;
	}
	
	public List<Object> getTipoAsistenciasObject() {		
		this.tipoasistenciasObject=this.tipoasistenciaDataAccess.getEntitiesObject();
		return this.tipoasistenciasObject;
	}
		
	public void setTipoAsistenciasObject(List<Object> newTipoAsistenciasObject) {
		this.tipoasistenciasObject = newTipoAsistenciasObject;
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
		
		if(this.tipoasistenciaDataAccess!=null) {
			this.tipoasistenciaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoasistenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoasistenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoasistencia = new  TipoAsistencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoasistencia=tipoasistenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoasistencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencia);
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
		tipoasistencia = new  TipoAsistencia();
		  		  
        try {
			
			tipoasistencia=tipoasistenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoasistencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoasistencia = new  TipoAsistencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoasistencia=tipoasistenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoasistencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencia);
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
		tipoasistencia = new  TipoAsistencia();
		  		  
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
		tipoasistencia = new  TipoAsistencia();
		  		  
        try {
			
			tipoasistencia=tipoasistenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoasistencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoasistencia = new  TipoAsistencia();
		  		  
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
		tipoasistencia = new  TipoAsistencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoasistenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoasistencia = new  TipoAsistencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoasistenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoasistencia = new  TipoAsistencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoasistenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoasistencia = new  TipoAsistencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoasistenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoasistencia = new  TipoAsistencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoasistenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoasistencia = new  TipoAsistencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoasistenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoasistencias = new  ArrayList<TipoAsistencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoasistencias=tipoasistenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAsistencia(tipoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencias);
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
		tipoasistencias = new  ArrayList<TipoAsistencia>();
		  		  
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
		tipoasistencias = new  ArrayList<TipoAsistencia>();
		  		  
        try {			
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoasistencias=tipoasistenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoAsistencia(tipoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoasistencias = new  ArrayList<TipoAsistencia>();
		  		  
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
		tipoasistencias = new  ArrayList<TipoAsistencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoasistencias=tipoasistenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAsistencia(tipoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencias);
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
		tipoasistencias = new  ArrayList<TipoAsistencia>();
		  		  
        try {
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoasistencias=tipoasistenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAsistencia(tipoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencias);
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
		tipoasistencias = new  ArrayList<TipoAsistencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoasistencias=tipoasistenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAsistencia(tipoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencias);
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
		tipoasistencias = new  ArrayList<TipoAsistencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoasistencias=tipoasistenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAsistencia(tipoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoasistencia = new  TipoAsistencia();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoasistencia=tipoasistenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAsistencia(tipoasistencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencia);
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
		tipoasistencia = new  TipoAsistencia();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoasistencia=tipoasistenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAsistencia(tipoasistencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoasistencias = new  ArrayList<TipoAsistencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoasistencias=tipoasistenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAsistencia(tipoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencias);
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
		tipoasistencias = new  ArrayList<TipoAsistencia>();
		  		  
        try {
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoasistencias=tipoasistenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAsistencia(tipoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoAsistenciasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoasistencias = new  ArrayList<TipoAsistencia>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-getTodosTipoAsistenciasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoasistencias=tipoasistenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoAsistencia(tipoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencias);
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
	
	public  void  getTodosTipoAsistencias(String sFinalQuery,Pagination pagination)throws Exception {
		tipoasistencias = new  ArrayList<TipoAsistencia>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoasistencias=tipoasistenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoAsistencia(tipoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoAsistencia(TipoAsistencia tipoasistencia) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoasistencia.getIsNew() || tipoasistencia.getIsChanged()) { 
			this.invalidValues = tipoasistenciaValidator.getInvalidValues(tipoasistencia);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoasistencia);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoAsistencia(List<TipoAsistencia> TipoAsistencias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoAsistencia tipoasistenciaLocal:tipoasistencias) {				
			estaValidadoObjeto=this.validarGuardarTipoAsistencia(tipoasistenciaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoAsistencia(List<TipoAsistencia> TipoAsistencias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoAsistencia(tipoasistencias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoAsistencia(TipoAsistencia TipoAsistencia) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoAsistencia(tipoasistencia)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoAsistencia tipoasistencia) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoasistencia.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoAsistenciaConstantesFunciones.getTipoAsistenciaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoasistencia","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoAsistenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoAsistenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoAsistenciaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-saveTipoAsistenciaWithConnection");connexion.begin();			
			
			TipoAsistenciaLogicAdditional.checkTipoAsistenciaToSave(this.tipoasistencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoAsistenciaLogicAdditional.updateTipoAsistenciaToSave(this.tipoasistencia,this.arrDatoGeneral);
			
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoasistencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoAsistencia();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoAsistencia(this.tipoasistencia)) {
				TipoAsistenciaDataAccess.save(this.tipoasistencia, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoasistencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoAsistenciaLogicAdditional.checkTipoAsistenciaToSaveAfter(this.tipoasistencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoAsistencia();
			
			connexion.commit();			
			
			if(this.tipoasistencia.getIsDeleted()) {
				this.tipoasistencia=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoAsistencia()throws Exception {	
		try {	
			
			TipoAsistenciaLogicAdditional.checkTipoAsistenciaToSave(this.tipoasistencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoAsistenciaLogicAdditional.updateTipoAsistenciaToSave(this.tipoasistencia,this.arrDatoGeneral);
			
			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoasistencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoAsistencia(this.tipoasistencia)) {			
				TipoAsistenciaDataAccess.save(this.tipoasistencia, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoasistencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoAsistenciaLogicAdditional.checkTipoAsistenciaToSaveAfter(this.tipoasistencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoasistencia.getIsDeleted()) {
				this.tipoasistencia=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoAsistenciasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-saveTipoAsistenciasWithConnection");connexion.begin();			
			
			TipoAsistenciaLogicAdditional.checkTipoAsistenciaToSaves(tipoasistencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoAsistencias();
			
			Boolean validadoTodosTipoAsistencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoAsistencia tipoasistenciaLocal:tipoasistencias) {		
				if(tipoasistenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoAsistenciaLogicAdditional.updateTipoAsistenciaToSave(tipoasistenciaLocal,this.arrDatoGeneral);
	        	
				TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoasistenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoAsistencia(tipoasistenciaLocal)) {
					TipoAsistenciaDataAccess.save(tipoasistenciaLocal, connexion);				
				} else {
					validadoTodosTipoAsistencia=false;
				}
			}
			
			if(!validadoTodosTipoAsistencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoAsistenciaLogicAdditional.checkTipoAsistenciaToSavesAfter(tipoasistencias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoAsistencias();
			
			connexion.commit();		
			
			this.quitarTipoAsistenciasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoAsistencias()throws Exception {				
		 try {	
			TipoAsistenciaLogicAdditional.checkTipoAsistenciaToSaves(tipoasistencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoAsistencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoAsistencia tipoasistenciaLocal:tipoasistencias) {				
				if(tipoasistenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoAsistenciaLogicAdditional.updateTipoAsistenciaToSave(tipoasistenciaLocal,this.arrDatoGeneral);
	        	
				TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoasistenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoAsistencia(tipoasistenciaLocal)) {				
					TipoAsistenciaDataAccess.save(tipoasistenciaLocal, connexion);				
				} else {
					validadoTodosTipoAsistencia=false;
				}
			}
			
			if(!validadoTodosTipoAsistencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoAsistenciaLogicAdditional.checkTipoAsistenciaToSavesAfter(tipoasistencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoAsistenciasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoAsistenciaParameterReturnGeneral procesarAccionTipoAsistencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoAsistencia> tipoasistencias,TipoAsistenciaParameterReturnGeneral tipoasistenciaParameterGeneral)throws Exception {
		 try {	
			TipoAsistenciaParameterReturnGeneral tipoasistenciaReturnGeneral=new TipoAsistenciaParameterReturnGeneral();
	
			TipoAsistenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoasistencias,tipoasistenciaParameterGeneral,tipoasistenciaReturnGeneral);
			
			return tipoasistenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoAsistenciaParameterReturnGeneral procesarAccionTipoAsistenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoAsistencia> tipoasistencias,TipoAsistenciaParameterReturnGeneral tipoasistenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-procesarAccionTipoAsistenciasWithConnection");connexion.begin();			
			
			TipoAsistenciaParameterReturnGeneral tipoasistenciaReturnGeneral=new TipoAsistenciaParameterReturnGeneral();
	
			TipoAsistenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoasistencias,tipoasistenciaParameterGeneral,tipoasistenciaReturnGeneral);
			
			this.connexion.commit();
			
			return tipoasistenciaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoAsistenciaParameterReturnGeneral procesarEventosTipoAsistencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoAsistencia> tipoasistencias,TipoAsistencia tipoasistencia,TipoAsistenciaParameterReturnGeneral tipoasistenciaParameterGeneral,Boolean isEsNuevoTipoAsistencia,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoAsistenciaParameterReturnGeneral tipoasistenciaReturnGeneral=new TipoAsistenciaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoasistenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoAsistenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoasistencias,tipoasistencia,tipoasistenciaParameterGeneral,tipoasistenciaReturnGeneral,isEsNuevoTipoAsistencia,clases);
			
			return tipoasistenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoAsistenciaParameterReturnGeneral procesarEventosTipoAsistenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoAsistencia> tipoasistencias,TipoAsistencia tipoasistencia,TipoAsistenciaParameterReturnGeneral tipoasistenciaParameterGeneral,Boolean isEsNuevoTipoAsistencia,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-procesarEventosTipoAsistenciasWithConnection");connexion.begin();			
			
			TipoAsistenciaParameterReturnGeneral tipoasistenciaReturnGeneral=new TipoAsistenciaParameterReturnGeneral();
	
			tipoasistenciaReturnGeneral.setTipoAsistencia(tipoasistencia);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoasistenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoAsistenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoasistencias,tipoasistencia,tipoasistenciaParameterGeneral,tipoasistenciaReturnGeneral,isEsNuevoTipoAsistencia,clases);
			
			this.connexion.commit();
			
			return tipoasistenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoAsistenciaParameterReturnGeneral procesarImportacionTipoAsistenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoAsistenciaParameterReturnGeneral tipoasistenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-procesarImportacionTipoAsistenciasWithConnection");connexion.begin();			
			
			TipoAsistenciaParameterReturnGeneral tipoasistenciaReturnGeneral=new TipoAsistenciaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoasistencias=new ArrayList<TipoAsistencia>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoasistencia=new TipoAsistencia();
				
				
				if(conColumnasBase) {this.tipoasistencia.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoasistencia.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoasistencia.setnombre(arrColumnas[iColumn++]);
				
				this.tipoasistencias.add(this.tipoasistencia);
			}
			
			this.saveTipoAsistencias();
			
			this.connexion.commit();
			
			tipoasistenciaReturnGeneral.setConRetornoEstaProcesado(true);
			tipoasistenciaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoasistenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoAsistenciasEliminados() throws Exception {				
		
		List<TipoAsistencia> tipoasistenciasAux= new ArrayList<TipoAsistencia>();
		
		for(TipoAsistencia tipoasistencia:tipoasistencias) {
			if(!tipoasistencia.getIsDeleted()) {
				tipoasistenciasAux.add(tipoasistencia);
			}
		}
		
		tipoasistencias=tipoasistenciasAux;
	}
	
	public void quitarTipoAsistenciasNulos() throws Exception {				
		
		List<TipoAsistencia> tipoasistenciasAux= new ArrayList<TipoAsistencia>();
		
		for(TipoAsistencia tipoasistencia : this.tipoasistencias) {
			if(tipoasistencia==null) {
				tipoasistenciasAux.add(tipoasistencia);
			}
		}
		
		//this.tipoasistencias=tipoasistenciasAux;
		
		this.tipoasistencias.removeAll(tipoasistenciasAux);
	}
	
	public void getSetVersionRowTipoAsistenciaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoasistencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoasistencia.getIsDeleted() || (tipoasistencia.getIsChanged()&&!tipoasistencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoasistenciaDataAccess.getSetVersionRowTipoAsistencia(connexion,tipoasistencia.getId());
				
				if(!tipoasistencia.getVersionRow().equals(timestamp)) {	
					tipoasistencia.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoasistencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoAsistencia()throws Exception {	
		
		if(tipoasistencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoasistencia.getIsDeleted() || (tipoasistencia.getIsChanged()&&!tipoasistencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoasistenciaDataAccess.getSetVersionRowTipoAsistencia(connexion,tipoasistencia.getId());
			
			try {							
				if(!tipoasistencia.getVersionRow().equals(timestamp)) {	
					tipoasistencia.setVersionRow(timestamp);
				}
				
				tipoasistencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoAsistenciasWithConnection()throws Exception {	
		if(tipoasistencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoAsistencia tipoasistenciaAux:tipoasistencias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoasistenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoasistenciaAux.getIsDeleted() || (tipoasistenciaAux.getIsChanged()&&!tipoasistenciaAux.getIsNew())) {
						
						timestamp=tipoasistenciaDataAccess.getSetVersionRowTipoAsistencia(connexion,tipoasistenciaAux.getId());
						
						if(!tipoasistencia.getVersionRow().equals(timestamp)) {	
							tipoasistenciaAux.setVersionRow(timestamp);
						}
								
						tipoasistenciaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoAsistencias()throws Exception {	
		if(tipoasistencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoAsistencia tipoasistenciaAux:tipoasistencias) {
					if(tipoasistenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoasistenciaAux.getIsDeleted() || (tipoasistenciaAux.getIsChanged()&&!tipoasistenciaAux.getIsNew())) {
						
						timestamp=tipoasistenciaDataAccess.getSetVersionRowTipoAsistencia(connexion,tipoasistenciaAux.getId());
						
						if(!tipoasistenciaAux.getVersionRow().equals(timestamp)) {	
							tipoasistenciaAux.setVersionRow(timestamp);
						}
						
													
						tipoasistenciaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoAsistenciaParameterReturnGeneral cargarCombosLoteForeignKeyTipoAsistenciaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoAsistenciaParameterReturnGeneral  tipoasistenciaReturnGeneral =new TipoAsistenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoAsistenciaWithConnection");connexion.begin();
			
			tipoasistenciaReturnGeneral =new TipoAsistenciaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoasistenciaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoasistenciaReturnGeneral;
	}
	
	public TipoAsistenciaParameterReturnGeneral cargarCombosLoteForeignKeyTipoAsistencia(String finalQueryGlobalEmpresa) throws Exception {
		TipoAsistenciaParameterReturnGeneral  tipoasistenciaReturnGeneral =new TipoAsistenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoasistenciaReturnGeneral =new TipoAsistenciaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoasistenciaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoasistenciaReturnGeneral;
	}
	
	
	public void deepLoad(TipoAsistencia tipoasistencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoAsistenciaLogicAdditional.updateTipoAsistenciaToGet(tipoasistencia,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoasistencia.setEmpresa(tipoasistenciaDataAccess.getEmpresa(connexion,tipoasistencia));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoasistencia.setEmpresa(tipoasistenciaDataAccess.getEmpresa(connexion,tipoasistencia));
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
			tipoasistencia.setEmpresa(tipoasistenciaDataAccess.getEmpresa(connexion,tipoasistencia));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoasistencia.setEmpresa(tipoasistenciaDataAccess.getEmpresa(connexion,tipoasistencia));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoasistencia.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoasistencia.setEmpresa(tipoasistenciaDataAccess.getEmpresa(connexion,tipoasistencia));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoasistencia.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tipoasistencia.setEmpresa(tipoasistenciaDataAccess.getEmpresa(connexion,tipoasistencia));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoasistencia.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoAsistencia tipoasistencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoAsistenciaLogicAdditional.updateTipoAsistenciaToSave(tipoasistencia,this.arrDatoGeneral);
			
TipoAsistenciaDataAccess.save(tipoasistencia, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoasistencia.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoasistencia.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoasistencia.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoasistencia.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoasistencia.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoasistencia.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoAsistencia.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoasistencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(tipoasistencia);
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
			this.deepLoad(this.tipoasistencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoAsistencia.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoasistencias!=null) {
				for(TipoAsistencia tipoasistencia:tipoasistencias) {
					this.deepLoad(tipoasistencia,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(tipoasistencias);
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
			if(tipoasistencias!=null) {
				for(TipoAsistencia tipoasistencia:tipoasistencias) {
					this.deepLoad(tipoasistencia,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(tipoasistencias);
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
			this.getNewConnexionToDeep(TipoAsistencia.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoasistencia,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoAsistencia.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoasistencias!=null) {
				for(TipoAsistencia tipoasistencia:tipoasistencias) {
					this.deepSave(tipoasistencia,isDeep,deepLoadType,clases);
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
			if(tipoasistencias!=null) {
				for(TipoAsistencia tipoasistencia:tipoasistencias) {
					this.deepSave(tipoasistencia,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoAsistenciasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAsistencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoAsistenciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoasistencias=tipoasistenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoAsistenciasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoAsistenciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoasistencias=tipoasistenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesTipoAsistencia(this.tipoasistencias);
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
			if(TipoAsistenciaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAsistenciaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoAsistencia tipoasistencia,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoAsistenciaConstantesFunciones.ISCONAUDITORIA) {
				if(tipoasistencia.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAsistenciaDataAccess.TABLENAME, tipoasistencia.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoAsistenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoAsistenciaLogic.registrarAuditoriaDetallesTipoAsistencia(connexion,tipoasistencia,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoasistencia.getIsDeleted()) {
					/*if(!tipoasistencia.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoAsistenciaDataAccess.TABLENAME, tipoasistencia.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoAsistenciaLogic.registrarAuditoriaDetallesTipoAsistencia(connexion,tipoasistencia,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAsistenciaDataAccess.TABLENAME, tipoasistencia.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoasistencia.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAsistenciaDataAccess.TABLENAME, tipoasistencia.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoAsistenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoAsistenciaLogic.registrarAuditoriaDetallesTipoAsistencia(connexion,tipoasistencia,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoAsistencia(Connexion connexion,TipoAsistencia tipoasistencia)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoasistencia.getIsNew()||!tipoasistencia.getid_empresa().equals(tipoasistencia.getTipoAsistenciaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoasistencia.getTipoAsistenciaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoasistencia.getTipoAsistenciaOriginal().getid_empresa().toString();
				}
				if(tipoasistencia.getid_empresa()!=null)
				{
					strValorNuevo=tipoasistencia.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAsistenciaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoasistencia.getIsNew()||!tipoasistencia.getnombre().equals(tipoasistencia.getTipoAsistenciaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoasistencia.getTipoAsistenciaOriginal().getnombre()!=null)
				{
					strValorActual=tipoasistencia.getTipoAsistenciaOriginal().getnombre();
				}
				if(tipoasistencia.getnombre()!=null)
				{
					strValorNuevo=tipoasistencia.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAsistenciaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoAsistenciaRelacionesWithConnection(TipoAsistencia tipoasistencia) throws Exception {

		if(!tipoasistencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoAsistenciaRelacionesBase(tipoasistencia,true);
		}
	}

	public void saveTipoAsistenciaRelaciones(TipoAsistencia tipoasistencia)throws Exception {

		if(!tipoasistencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoAsistenciaRelacionesBase(tipoasistencia,false);
		}
	}

	public void saveTipoAsistenciaRelacionesBase(TipoAsistencia tipoasistencia,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoAsistencia-saveRelacionesWithConnection");}
	

			this.setTipoAsistencia(tipoasistencia);

			if(TipoAsistenciaLogicAdditional.validarSaveRelaciones(tipoasistencia,this)) {

				TipoAsistenciaLogicAdditional.updateRelacionesToSave(tipoasistencia,this);

				if((tipoasistencia.getIsNew()||tipoasistencia.getIsChanged())&&!tipoasistencia.getIsDeleted()) {
					this.saveTipoAsistencia();
					this.saveTipoAsistenciaRelacionesDetalles();

				} else if(tipoasistencia.getIsDeleted()) {
					this.saveTipoAsistenciaRelacionesDetalles();
					this.saveTipoAsistencia();
				}

				TipoAsistenciaLogicAdditional.updateRelacionesToSaveAfter(tipoasistencia,this);

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
	
	
	private void saveTipoAsistenciaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoAsistencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoAsistenciaConstantesFunciones.getClassesForeignKeysOfTipoAsistencia(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAsistencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoAsistenciaConstantesFunciones.getClassesRelationshipsOfTipoAsistencia(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

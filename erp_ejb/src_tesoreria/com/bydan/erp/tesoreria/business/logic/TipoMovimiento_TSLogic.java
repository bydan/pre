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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.TipoMovimiento_TSConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoMovimiento_TSParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoMovimiento_TSParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.TipoMovimiento_TS;
import com.bydan.erp.tesoreria.business.logic.TipoMovimiento_TSLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoMovimiento_TSLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoMovimiento_TSLogic.class);
	
	protected TipoMovimiento_TSDataAccess tipomovimiento_tsDataAccess; 	
	protected TipoMovimiento_TS tipomovimiento_ts;
	protected List<TipoMovimiento_TS> tipomovimiento_tss;
	protected Object tipomovimiento_tsObject;	
	protected List<Object> tipomovimiento_tssObject;
	
	public static ClassValidator<TipoMovimiento_TS> tipomovimiento_tsValidator = new ClassValidator<TipoMovimiento_TS>(TipoMovimiento_TS.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoMovimiento_TSLogicAdditional tipomovimiento_tsLogicAdditional=null;
	
	public TipoMovimiento_TSLogicAdditional getTipoMovimiento_TSLogicAdditional() {
		return this.tipomovimiento_tsLogicAdditional;
	}
	
	public void setTipoMovimiento_TSLogicAdditional(TipoMovimiento_TSLogicAdditional tipomovimiento_tsLogicAdditional) {
		try {
			this.tipomovimiento_tsLogicAdditional=tipomovimiento_tsLogicAdditional;
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
	
	
	
	
	public  TipoMovimiento_TSLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipomovimiento_tsDataAccess = new TipoMovimiento_TSDataAccess();
			
			this.tipomovimiento_tss= new ArrayList<TipoMovimiento_TS>();
			this.tipomovimiento_ts= new TipoMovimiento_TS();
			
			this.tipomovimiento_tsObject=new Object();
			this.tipomovimiento_tssObject=new ArrayList<Object>();
				
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
			
			this.tipomovimiento_tsDataAccess.setConnexionType(this.connexionType);
			this.tipomovimiento_tsDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoMovimiento_TSLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipomovimiento_tsDataAccess = new TipoMovimiento_TSDataAccess();
			this.tipomovimiento_tss= new ArrayList<TipoMovimiento_TS>();
			this.tipomovimiento_ts= new TipoMovimiento_TS();
			this.tipomovimiento_tsObject=new Object();
			this.tipomovimiento_tssObject=new ArrayList<Object>();
			
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
			
			this.tipomovimiento_tsDataAccess.setConnexionType(this.connexionType);
			this.tipomovimiento_tsDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoMovimiento_TS getTipoMovimiento_TS() throws Exception {	
		TipoMovimiento_TSLogicAdditional.checkTipoMovimiento_TSToGet(tipomovimiento_ts,this.datosCliente,this.arrDatoGeneral);
		TipoMovimiento_TSLogicAdditional.updateTipoMovimiento_TSToGet(tipomovimiento_ts,this.arrDatoGeneral);
		
		return tipomovimiento_ts;
	}
		
	public void setTipoMovimiento_TS(TipoMovimiento_TS newTipoMovimiento_TS) {
		this.tipomovimiento_ts = newTipoMovimiento_TS;
	}
	
	public TipoMovimiento_TSDataAccess getTipoMovimiento_TSDataAccess() {
		return tipomovimiento_tsDataAccess;
	}
	
	public void setTipoMovimiento_TSDataAccess(TipoMovimiento_TSDataAccess newtipomovimiento_tsDataAccess) {
		this.tipomovimiento_tsDataAccess = newtipomovimiento_tsDataAccess;
	}
	
	public List<TipoMovimiento_TS> getTipoMovimiento_TSs() throws Exception {		
		this.quitarTipoMovimiento_TSsNulos();
		
		TipoMovimiento_TSLogicAdditional.checkTipoMovimiento_TSToGets(tipomovimiento_tss,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoMovimiento_TS tipomovimiento_tsLocal: tipomovimiento_tss ) {
			TipoMovimiento_TSLogicAdditional.updateTipoMovimiento_TSToGet(tipomovimiento_tsLocal,this.arrDatoGeneral);
		}
		
		return tipomovimiento_tss;
	}
	
	public void setTipoMovimiento_TSs(List<TipoMovimiento_TS> newTipoMovimiento_TSs) {
		this.tipomovimiento_tss = newTipoMovimiento_TSs;
	}
	
	public Object getTipoMovimiento_TSObject() {	
		this.tipomovimiento_tsObject=this.tipomovimiento_tsDataAccess.getEntityObject();
		return this.tipomovimiento_tsObject;
	}
		
	public void setTipoMovimiento_TSObject(Object newTipoMovimiento_TSObject) {
		this.tipomovimiento_tsObject = newTipoMovimiento_TSObject;
	}
	
	public List<Object> getTipoMovimiento_TSsObject() {		
		this.tipomovimiento_tssObject=this.tipomovimiento_tsDataAccess.getEntitiesObject();
		return this.tipomovimiento_tssObject;
	}
		
	public void setTipoMovimiento_TSsObject(List<Object> newTipoMovimiento_TSsObject) {
		this.tipomovimiento_tssObject = newTipoMovimiento_TSsObject;
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
		
		if(this.tipomovimiento_tsDataAccess!=null) {
			this.tipomovimiento_tsDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipomovimiento_tsDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipomovimiento_tsDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipomovimiento_ts = new  TipoMovimiento_TS();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomovimiento_ts=tipomovimiento_tsDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomovimiento_ts,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_ts);
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
		tipomovimiento_ts = new  TipoMovimiento_TS();
		  		  
        try {
			
			tipomovimiento_ts=tipomovimiento_tsDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomovimiento_ts,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_ts);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipomovimiento_ts = new  TipoMovimiento_TS();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomovimiento_ts=tipomovimiento_tsDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomovimiento_ts,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_ts);
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
		tipomovimiento_ts = new  TipoMovimiento_TS();
		  		  
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
		tipomovimiento_ts = new  TipoMovimiento_TS();
		  		  
        try {
			
			tipomovimiento_ts=tipomovimiento_tsDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomovimiento_ts,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_ts);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipomovimiento_ts = new  TipoMovimiento_TS();
		  		  
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
		tipomovimiento_ts = new  TipoMovimiento_TS();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipomovimiento_tsDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomovimiento_ts = new  TipoMovimiento_TS();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipomovimiento_tsDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomovimiento_ts = new  TipoMovimiento_TS();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipomovimiento_tsDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomovimiento_ts = new  TipoMovimiento_TS();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipomovimiento_tsDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomovimiento_ts = new  TipoMovimiento_TS();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipomovimiento_tsDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomovimiento_ts = new  TipoMovimiento_TS();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipomovimiento_tsDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomovimiento_tss = new  ArrayList<TipoMovimiento_TS>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimiento_tss=tipomovimiento_tsDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMovimiento_TS(tipomovimiento_tss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_tss);
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
		tipomovimiento_tss = new  ArrayList<TipoMovimiento_TS>();
		  		  
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
		tipomovimiento_tss = new  ArrayList<TipoMovimiento_TS>();
		  		  
        try {			
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimiento_tss=tipomovimiento_tsDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoMovimiento_TS(tipomovimiento_tss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_tss);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipomovimiento_tss = new  ArrayList<TipoMovimiento_TS>();
		  		  
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
		tipomovimiento_tss = new  ArrayList<TipoMovimiento_TS>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimiento_tss=tipomovimiento_tsDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMovimiento_TS(tipomovimiento_tss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_tss);
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
		tipomovimiento_tss = new  ArrayList<TipoMovimiento_TS>();
		  		  
        try {
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimiento_tss=tipomovimiento_tsDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMovimiento_TS(tipomovimiento_tss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_tss);
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
		tipomovimiento_tss = new  ArrayList<TipoMovimiento_TS>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimiento_tss=tipomovimiento_tsDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMovimiento_TS(tipomovimiento_tss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_tss);
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
		tipomovimiento_tss = new  ArrayList<TipoMovimiento_TS>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimiento_tss=tipomovimiento_tsDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMovimiento_TS(tipomovimiento_tss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_tss);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipomovimiento_ts = new  TipoMovimiento_TS();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimiento_ts=tipomovimiento_tsDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMovimiento_TS(tipomovimiento_ts);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_ts);
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
		tipomovimiento_ts = new  TipoMovimiento_TS();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimiento_ts=tipomovimiento_tsDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMovimiento_TS(tipomovimiento_ts);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_ts);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomovimiento_tss = new  ArrayList<TipoMovimiento_TS>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimiento_tss=tipomovimiento_tsDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMovimiento_TS(tipomovimiento_tss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_tss);
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
		tipomovimiento_tss = new  ArrayList<TipoMovimiento_TS>();
		  		  
        try {
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimiento_tss=tipomovimiento_tsDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMovimiento_TS(tipomovimiento_tss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_tss);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoMovimiento_TSsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipomovimiento_tss = new  ArrayList<TipoMovimiento_TS>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-getTodosTipoMovimiento_TSsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimiento_tss=tipomovimiento_tsDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoMovimiento_TS(tipomovimiento_tss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_tss);
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
	
	public  void  getTodosTipoMovimiento_TSs(String sFinalQuery,Pagination pagination)throws Exception {
		tipomovimiento_tss = new  ArrayList<TipoMovimiento_TS>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovimiento_tss=tipomovimiento_tsDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoMovimiento_TS(tipomovimiento_tss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_tss);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoMovimiento_TS(TipoMovimiento_TS tipomovimiento_ts) throws Exception {
		Boolean estaValidado=false;
		
		if(tipomovimiento_ts.getIsNew() || tipomovimiento_ts.getIsChanged()) { 
			this.invalidValues = tipomovimiento_tsValidator.getInvalidValues(tipomovimiento_ts);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipomovimiento_ts);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoMovimiento_TS(List<TipoMovimiento_TS> TipoMovimiento_TSs) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoMovimiento_TS tipomovimiento_tsLocal:tipomovimiento_tss) {				
			estaValidadoObjeto=this.validarGuardarTipoMovimiento_TS(tipomovimiento_tsLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoMovimiento_TS(List<TipoMovimiento_TS> TipoMovimiento_TSs) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoMovimiento_TS(tipomovimiento_tss)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoMovimiento_TS(TipoMovimiento_TS TipoMovimiento_TS) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoMovimiento_TS(tipomovimiento_ts)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoMovimiento_TS tipomovimiento_ts) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipomovimiento_ts.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoMovimiento_TSConstantesFunciones.getTipoMovimiento_TSLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipomovimiento_ts","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoMovimiento_TSConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoMovimiento_TSConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoMovimiento_TSWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-saveTipoMovimiento_TSWithConnection");connexion.begin();			
			
			TipoMovimiento_TSLogicAdditional.checkTipoMovimiento_TSToSave(this.tipomovimiento_ts,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoMovimiento_TSLogicAdditional.updateTipoMovimiento_TSToSave(this.tipomovimiento_ts,this.arrDatoGeneral);
			
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomovimiento_ts,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoMovimiento_TS();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoMovimiento_TS(this.tipomovimiento_ts)) {
				TipoMovimiento_TSDataAccess.save(this.tipomovimiento_ts, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipomovimiento_ts,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoMovimiento_TSLogicAdditional.checkTipoMovimiento_TSToSaveAfter(this.tipomovimiento_ts,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoMovimiento_TS();
			
			connexion.commit();			
			
			if(this.tipomovimiento_ts.getIsDeleted()) {
				this.tipomovimiento_ts=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoMovimiento_TS()throws Exception {	
		try {	
			
			TipoMovimiento_TSLogicAdditional.checkTipoMovimiento_TSToSave(this.tipomovimiento_ts,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoMovimiento_TSLogicAdditional.updateTipoMovimiento_TSToSave(this.tipomovimiento_ts,this.arrDatoGeneral);
			
			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomovimiento_ts,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoMovimiento_TS(this.tipomovimiento_ts)) {			
				TipoMovimiento_TSDataAccess.save(this.tipomovimiento_ts, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipomovimiento_ts,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoMovimiento_TSLogicAdditional.checkTipoMovimiento_TSToSaveAfter(this.tipomovimiento_ts,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipomovimiento_ts.getIsDeleted()) {
				this.tipomovimiento_ts=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoMovimiento_TSsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-saveTipoMovimiento_TSsWithConnection");connexion.begin();			
			
			TipoMovimiento_TSLogicAdditional.checkTipoMovimiento_TSToSaves(tipomovimiento_tss,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoMovimiento_TSs();
			
			Boolean validadoTodosTipoMovimiento_TS=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoMovimiento_TS tipomovimiento_tsLocal:tipomovimiento_tss) {		
				if(tipomovimiento_tsLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoMovimiento_TSLogicAdditional.updateTipoMovimiento_TSToSave(tipomovimiento_tsLocal,this.arrDatoGeneral);
	        	
				TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomovimiento_tsLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoMovimiento_TS(tipomovimiento_tsLocal)) {
					TipoMovimiento_TSDataAccess.save(tipomovimiento_tsLocal, connexion);				
				} else {
					validadoTodosTipoMovimiento_TS=false;
				}
			}
			
			if(!validadoTodosTipoMovimiento_TS) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoMovimiento_TSLogicAdditional.checkTipoMovimiento_TSToSavesAfter(tipomovimiento_tss,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoMovimiento_TSs();
			
			connexion.commit();		
			
			this.quitarTipoMovimiento_TSsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoMovimiento_TSs()throws Exception {				
		 try {	
			TipoMovimiento_TSLogicAdditional.checkTipoMovimiento_TSToSaves(tipomovimiento_tss,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoMovimiento_TS=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoMovimiento_TS tipomovimiento_tsLocal:tipomovimiento_tss) {				
				if(tipomovimiento_tsLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoMovimiento_TSLogicAdditional.updateTipoMovimiento_TSToSave(tipomovimiento_tsLocal,this.arrDatoGeneral);
	        	
				TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomovimiento_tsLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoMovimiento_TS(tipomovimiento_tsLocal)) {				
					TipoMovimiento_TSDataAccess.save(tipomovimiento_tsLocal, connexion);				
				} else {
					validadoTodosTipoMovimiento_TS=false;
				}
			}
			
			if(!validadoTodosTipoMovimiento_TS) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoMovimiento_TSLogicAdditional.checkTipoMovimiento_TSToSavesAfter(tipomovimiento_tss,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoMovimiento_TSsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoMovimiento_TSParameterReturnGeneral procesarAccionTipoMovimiento_TSs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoMovimiento_TS> tipomovimiento_tss,TipoMovimiento_TSParameterReturnGeneral tipomovimiento_tsParameterGeneral)throws Exception {
		 try {	
			TipoMovimiento_TSParameterReturnGeneral tipomovimiento_tsReturnGeneral=new TipoMovimiento_TSParameterReturnGeneral();
	
			TipoMovimiento_TSLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipomovimiento_tss,tipomovimiento_tsParameterGeneral,tipomovimiento_tsReturnGeneral);
			
			return tipomovimiento_tsReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoMovimiento_TSParameterReturnGeneral procesarAccionTipoMovimiento_TSsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoMovimiento_TS> tipomovimiento_tss,TipoMovimiento_TSParameterReturnGeneral tipomovimiento_tsParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-procesarAccionTipoMovimiento_TSsWithConnection");connexion.begin();			
			
			TipoMovimiento_TSParameterReturnGeneral tipomovimiento_tsReturnGeneral=new TipoMovimiento_TSParameterReturnGeneral();
	
			TipoMovimiento_TSLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipomovimiento_tss,tipomovimiento_tsParameterGeneral,tipomovimiento_tsReturnGeneral);
			
			this.connexion.commit();
			
			return tipomovimiento_tsReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoMovimiento_TSParameterReturnGeneral procesarEventosTipoMovimiento_TSs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoMovimiento_TS> tipomovimiento_tss,TipoMovimiento_TS tipomovimiento_ts,TipoMovimiento_TSParameterReturnGeneral tipomovimiento_tsParameterGeneral,Boolean isEsNuevoTipoMovimiento_TS,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoMovimiento_TSParameterReturnGeneral tipomovimiento_tsReturnGeneral=new TipoMovimiento_TSParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomovimiento_tsReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoMovimiento_TSLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipomovimiento_tss,tipomovimiento_ts,tipomovimiento_tsParameterGeneral,tipomovimiento_tsReturnGeneral,isEsNuevoTipoMovimiento_TS,clases);
			
			return tipomovimiento_tsReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoMovimiento_TSParameterReturnGeneral procesarEventosTipoMovimiento_TSsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoMovimiento_TS> tipomovimiento_tss,TipoMovimiento_TS tipomovimiento_ts,TipoMovimiento_TSParameterReturnGeneral tipomovimiento_tsParameterGeneral,Boolean isEsNuevoTipoMovimiento_TS,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-procesarEventosTipoMovimiento_TSsWithConnection");connexion.begin();			
			
			TipoMovimiento_TSParameterReturnGeneral tipomovimiento_tsReturnGeneral=new TipoMovimiento_TSParameterReturnGeneral();
	
			tipomovimiento_tsReturnGeneral.setTipoMovimiento_TS(tipomovimiento_ts);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomovimiento_tsReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoMovimiento_TSLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipomovimiento_tss,tipomovimiento_ts,tipomovimiento_tsParameterGeneral,tipomovimiento_tsReturnGeneral,isEsNuevoTipoMovimiento_TS,clases);
			
			this.connexion.commit();
			
			return tipomovimiento_tsReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoMovimiento_TSParameterReturnGeneral procesarImportacionTipoMovimiento_TSsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoMovimiento_TSParameterReturnGeneral tipomovimiento_tsParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-procesarImportacionTipoMovimiento_TSsWithConnection");connexion.begin();			
			
			TipoMovimiento_TSParameterReturnGeneral tipomovimiento_tsReturnGeneral=new TipoMovimiento_TSParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipomovimiento_tss=new ArrayList<TipoMovimiento_TS>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipomovimiento_ts=new TipoMovimiento_TS();
				
				
				if(conColumnasBase) {this.tipomovimiento_ts.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipomovimiento_ts.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipomovimiento_ts.setcodigo(arrColumnas[iColumn++]);
				this.tipomovimiento_ts.setnombre(arrColumnas[iColumn++]);
				
				this.tipomovimiento_tss.add(this.tipomovimiento_ts);
			}
			
			this.saveTipoMovimiento_TSs();
			
			this.connexion.commit();
			
			tipomovimiento_tsReturnGeneral.setConRetornoEstaProcesado(true);
			tipomovimiento_tsReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipomovimiento_tsReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoMovimiento_TSsEliminados() throws Exception {				
		
		List<TipoMovimiento_TS> tipomovimiento_tssAux= new ArrayList<TipoMovimiento_TS>();
		
		for(TipoMovimiento_TS tipomovimiento_ts:tipomovimiento_tss) {
			if(!tipomovimiento_ts.getIsDeleted()) {
				tipomovimiento_tssAux.add(tipomovimiento_ts);
			}
		}
		
		tipomovimiento_tss=tipomovimiento_tssAux;
	}
	
	public void quitarTipoMovimiento_TSsNulos() throws Exception {				
		
		List<TipoMovimiento_TS> tipomovimiento_tssAux= new ArrayList<TipoMovimiento_TS>();
		
		for(TipoMovimiento_TS tipomovimiento_ts : this.tipomovimiento_tss) {
			if(tipomovimiento_ts==null) {
				tipomovimiento_tssAux.add(tipomovimiento_ts);
			}
		}
		
		//this.tipomovimiento_tss=tipomovimiento_tssAux;
		
		this.tipomovimiento_tss.removeAll(tipomovimiento_tssAux);
	}
	
	public void getSetVersionRowTipoMovimiento_TSWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipomovimiento_ts.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipomovimiento_ts.getIsDeleted() || (tipomovimiento_ts.getIsChanged()&&!tipomovimiento_ts.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipomovimiento_tsDataAccess.getSetVersionRowTipoMovimiento_TS(connexion,tipomovimiento_ts.getId());
				
				if(!tipomovimiento_ts.getVersionRow().equals(timestamp)) {	
					tipomovimiento_ts.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipomovimiento_ts.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoMovimiento_TS()throws Exception {	
		
		if(tipomovimiento_ts.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipomovimiento_ts.getIsDeleted() || (tipomovimiento_ts.getIsChanged()&&!tipomovimiento_ts.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipomovimiento_tsDataAccess.getSetVersionRowTipoMovimiento_TS(connexion,tipomovimiento_ts.getId());
			
			try {							
				if(!tipomovimiento_ts.getVersionRow().equals(timestamp)) {	
					tipomovimiento_ts.setVersionRow(timestamp);
				}
				
				tipomovimiento_ts.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoMovimiento_TSsWithConnection()throws Exception {	
		if(tipomovimiento_tss!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoMovimiento_TS tipomovimiento_tsAux:tipomovimiento_tss) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipomovimiento_tsAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomovimiento_tsAux.getIsDeleted() || (tipomovimiento_tsAux.getIsChanged()&&!tipomovimiento_tsAux.getIsNew())) {
						
						timestamp=tipomovimiento_tsDataAccess.getSetVersionRowTipoMovimiento_TS(connexion,tipomovimiento_tsAux.getId());
						
						if(!tipomovimiento_ts.getVersionRow().equals(timestamp)) {	
							tipomovimiento_tsAux.setVersionRow(timestamp);
						}
								
						tipomovimiento_tsAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoMovimiento_TSs()throws Exception {	
		if(tipomovimiento_tss!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoMovimiento_TS tipomovimiento_tsAux:tipomovimiento_tss) {
					if(tipomovimiento_tsAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomovimiento_tsAux.getIsDeleted() || (tipomovimiento_tsAux.getIsChanged()&&!tipomovimiento_tsAux.getIsNew())) {
						
						timestamp=tipomovimiento_tsDataAccess.getSetVersionRowTipoMovimiento_TS(connexion,tipomovimiento_tsAux.getId());
						
						if(!tipomovimiento_tsAux.getVersionRow().equals(timestamp)) {	
							tipomovimiento_tsAux.setVersionRow(timestamp);
						}
						
													
						tipomovimiento_tsAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoMovimiento_TSParameterReturnGeneral cargarCombosLoteForeignKeyTipoMovimiento_TSWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoMovimiento_TSParameterReturnGeneral  tipomovimiento_tsReturnGeneral =new TipoMovimiento_TSParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoMovimiento_TSWithConnection");connexion.begin();
			
			tipomovimiento_tsReturnGeneral =new TipoMovimiento_TSParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipomovimiento_tsReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipomovimiento_tsReturnGeneral;
	}
	
	public TipoMovimiento_TSParameterReturnGeneral cargarCombosLoteForeignKeyTipoMovimiento_TS(String finalQueryGlobalEmpresa) throws Exception {
		TipoMovimiento_TSParameterReturnGeneral  tipomovimiento_tsReturnGeneral =new TipoMovimiento_TSParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipomovimiento_tsReturnGeneral =new TipoMovimiento_TSParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipomovimiento_tsReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipomovimiento_tsReturnGeneral;
	}
	
	
	public void deepLoad(TipoMovimiento_TS tipomovimiento_ts,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoMovimiento_TSLogicAdditional.updateTipoMovimiento_TSToGet(tipomovimiento_ts,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomovimiento_ts.setEmpresa(tipomovimiento_tsDataAccess.getEmpresa(connexion,tipomovimiento_ts));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipomovimiento_ts.setEmpresa(tipomovimiento_tsDataAccess.getEmpresa(connexion,tipomovimiento_ts));
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
			tipomovimiento_ts.setEmpresa(tipomovimiento_tsDataAccess.getEmpresa(connexion,tipomovimiento_ts));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomovimiento_ts.setEmpresa(tipomovimiento_tsDataAccess.getEmpresa(connexion,tipomovimiento_ts));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipomovimiento_ts.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipomovimiento_ts.setEmpresa(tipomovimiento_tsDataAccess.getEmpresa(connexion,tipomovimiento_ts));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipomovimiento_ts.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tipomovimiento_ts.setEmpresa(tipomovimiento_tsDataAccess.getEmpresa(connexion,tipomovimiento_ts));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipomovimiento_ts.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoMovimiento_TS tipomovimiento_ts,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoMovimiento_TSLogicAdditional.updateTipoMovimiento_TSToSave(tipomovimiento_ts,this.arrDatoGeneral);
			
TipoMovimiento_TSDataAccess.save(tipomovimiento_ts, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipomovimiento_ts.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipomovimiento_ts.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipomovimiento_ts.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipomovimiento_ts.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipomovimiento_ts.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipomovimiento_ts.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoMovimiento_TS.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipomovimiento_ts,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(tipomovimiento_ts);
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
			this.deepLoad(this.tipomovimiento_ts,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_ts);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoMovimiento_TS.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipomovimiento_tss!=null) {
				for(TipoMovimiento_TS tipomovimiento_ts:tipomovimiento_tss) {
					this.deepLoad(tipomovimiento_ts,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(tipomovimiento_tss);
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
			if(tipomovimiento_tss!=null) {
				for(TipoMovimiento_TS tipomovimiento_ts:tipomovimiento_tss) {
					this.deepLoad(tipomovimiento_ts,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(tipomovimiento_tss);
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
			this.getNewConnexionToDeep(TipoMovimiento_TS.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipomovimiento_ts,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoMovimiento_TS.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipomovimiento_tss!=null) {
				for(TipoMovimiento_TS tipomovimiento_ts:tipomovimiento_tss) {
					this.deepSave(tipomovimiento_ts,isDeep,deepLoadType,clases);
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
			if(tipomovimiento_tss!=null) {
				for(TipoMovimiento_TS tipomovimiento_ts:tipomovimiento_tss) {
					this.deepSave(tipomovimiento_ts,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoMovimiento_TSsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMovimiento_TS.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoMovimiento_TSConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomovimiento_tss=tipomovimiento_tsDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_tss);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMovimiento_TSsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoMovimiento_TSConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoMovimiento_TSLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomovimiento_tss=tipomovimiento_tsDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMovimiento_TSConstantesFunciones.refrescarForeignKeysDescripcionesTipoMovimiento_TS(this.tipomovimiento_tss);
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
			if(TipoMovimiento_TSConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMovimiento_TSDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoMovimiento_TS tipomovimiento_ts,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoMovimiento_TSConstantesFunciones.ISCONAUDITORIA) {
				if(tipomovimiento_ts.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMovimiento_TSDataAccess.TABLENAME, tipomovimiento_ts.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoMovimiento_TSConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoMovimiento_TSLogic.registrarAuditoriaDetallesTipoMovimiento_TS(connexion,tipomovimiento_ts,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipomovimiento_ts.getIsDeleted()) {
					/*if(!tipomovimiento_ts.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoMovimiento_TSDataAccess.TABLENAME, tipomovimiento_ts.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoMovimiento_TSLogic.registrarAuditoriaDetallesTipoMovimiento_TS(connexion,tipomovimiento_ts,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMovimiento_TSDataAccess.TABLENAME, tipomovimiento_ts.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipomovimiento_ts.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMovimiento_TSDataAccess.TABLENAME, tipomovimiento_ts.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoMovimiento_TSConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoMovimiento_TSLogic.registrarAuditoriaDetallesTipoMovimiento_TS(connexion,tipomovimiento_ts,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoMovimiento_TS(Connexion connexion,TipoMovimiento_TS tipomovimiento_ts)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipomovimiento_ts.getIsNew()||!tipomovimiento_ts.getcodigo().equals(tipomovimiento_ts.getTipoMovimiento_TSOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomovimiento_ts.getTipoMovimiento_TSOriginal().getcodigo()!=null)
				{
					strValorActual=tipomovimiento_ts.getTipoMovimiento_TSOriginal().getcodigo();
				}
				if(tipomovimiento_ts.getcodigo()!=null)
				{
					strValorNuevo=tipomovimiento_ts.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMovimiento_TSConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipomovimiento_ts.getIsNew()||!tipomovimiento_ts.getnombre().equals(tipomovimiento_ts.getTipoMovimiento_TSOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomovimiento_ts.getTipoMovimiento_TSOriginal().getnombre()!=null)
				{
					strValorActual=tipomovimiento_ts.getTipoMovimiento_TSOriginal().getnombre();
				}
				if(tipomovimiento_ts.getnombre()!=null)
				{
					strValorNuevo=tipomovimiento_ts.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMovimiento_TSConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipomovimiento_ts.getIsNew()||!tipomovimiento_ts.getid_empresa().equals(tipomovimiento_ts.getTipoMovimiento_TSOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomovimiento_ts.getTipoMovimiento_TSOriginal().getid_empresa()!=null)
				{
					strValorActual=tipomovimiento_ts.getTipoMovimiento_TSOriginal().getid_empresa().toString();
				}
				if(tipomovimiento_ts.getid_empresa()!=null)
				{
					strValorNuevo=tipomovimiento_ts.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMovimiento_TSConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoMovimiento_TSRelacionesWithConnection(TipoMovimiento_TS tipomovimiento_ts) throws Exception {

		if(!tipomovimiento_ts.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoMovimiento_TSRelacionesBase(tipomovimiento_ts,true);
		}
	}

	public void saveTipoMovimiento_TSRelaciones(TipoMovimiento_TS tipomovimiento_ts)throws Exception {

		if(!tipomovimiento_ts.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoMovimiento_TSRelacionesBase(tipomovimiento_ts,false);
		}
	}

	public void saveTipoMovimiento_TSRelacionesBase(TipoMovimiento_TS tipomovimiento_ts,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoMovimiento_TS-saveRelacionesWithConnection");}
	

			this.setTipoMovimiento_TS(tipomovimiento_ts);

			if(TipoMovimiento_TSLogicAdditional.validarSaveRelaciones(tipomovimiento_ts,this)) {

				TipoMovimiento_TSLogicAdditional.updateRelacionesToSave(tipomovimiento_ts,this);

				if((tipomovimiento_ts.getIsNew()||tipomovimiento_ts.getIsChanged())&&!tipomovimiento_ts.getIsDeleted()) {
					this.saveTipoMovimiento_TS();
					this.saveTipoMovimiento_TSRelacionesDetalles();

				} else if(tipomovimiento_ts.getIsDeleted()) {
					this.saveTipoMovimiento_TSRelacionesDetalles();
					this.saveTipoMovimiento_TS();
				}

				TipoMovimiento_TSLogicAdditional.updateRelacionesToSaveAfter(tipomovimiento_ts,this);

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
	
	
	private void saveTipoMovimiento_TSRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMovimiento_TS(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoMovimiento_TSConstantesFunciones.getClassesForeignKeysOfTipoMovimiento_TS(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMovimiento_TS(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoMovimiento_TSConstantesFunciones.getClassesRelationshipsOfTipoMovimiento_TS(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

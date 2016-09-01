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
import com.bydan.erp.cartera.util.TipoInversionConstantesFunciones;
import com.bydan.erp.cartera.util.TipoInversionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoInversionParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoInversion;
import com.bydan.erp.cartera.business.logic.TipoInversionLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoInversionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoInversionLogic.class);
	
	protected TipoInversionDataAccess tipoinversionDataAccess; 	
	protected TipoInversion tipoinversion;
	protected List<TipoInversion> tipoinversions;
	protected Object tipoinversionObject;	
	protected List<Object> tipoinversionsObject;
	
	public static ClassValidator<TipoInversion> tipoinversionValidator = new ClassValidator<TipoInversion>(TipoInversion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoInversionLogicAdditional tipoinversionLogicAdditional=null;
	
	public TipoInversionLogicAdditional getTipoInversionLogicAdditional() {
		return this.tipoinversionLogicAdditional;
	}
	
	public void setTipoInversionLogicAdditional(TipoInversionLogicAdditional tipoinversionLogicAdditional) {
		try {
			this.tipoinversionLogicAdditional=tipoinversionLogicAdditional;
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
	
	
	
	
	public  TipoInversionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoinversionDataAccess = new TipoInversionDataAccess();
			
			this.tipoinversions= new ArrayList<TipoInversion>();
			this.tipoinversion= new TipoInversion();
			
			this.tipoinversionObject=new Object();
			this.tipoinversionsObject=new ArrayList<Object>();
				
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
			
			this.tipoinversionDataAccess.setConnexionType(this.connexionType);
			this.tipoinversionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoInversionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoinversionDataAccess = new TipoInversionDataAccess();
			this.tipoinversions= new ArrayList<TipoInversion>();
			this.tipoinversion= new TipoInversion();
			this.tipoinversionObject=new Object();
			this.tipoinversionsObject=new ArrayList<Object>();
			
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
			
			this.tipoinversionDataAccess.setConnexionType(this.connexionType);
			this.tipoinversionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoInversion getTipoInversion() throws Exception {	
		TipoInversionLogicAdditional.checkTipoInversionToGet(tipoinversion,this.datosCliente,this.arrDatoGeneral);
		TipoInversionLogicAdditional.updateTipoInversionToGet(tipoinversion,this.arrDatoGeneral);
		
		return tipoinversion;
	}
		
	public void setTipoInversion(TipoInversion newTipoInversion) {
		this.tipoinversion = newTipoInversion;
	}
	
	public TipoInversionDataAccess getTipoInversionDataAccess() {
		return tipoinversionDataAccess;
	}
	
	public void setTipoInversionDataAccess(TipoInversionDataAccess newtipoinversionDataAccess) {
		this.tipoinversionDataAccess = newtipoinversionDataAccess;
	}
	
	public List<TipoInversion> getTipoInversions() throws Exception {		
		this.quitarTipoInversionsNulos();
		
		TipoInversionLogicAdditional.checkTipoInversionToGets(tipoinversions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoInversion tipoinversionLocal: tipoinversions ) {
			TipoInversionLogicAdditional.updateTipoInversionToGet(tipoinversionLocal,this.arrDatoGeneral);
		}
		
		return tipoinversions;
	}
	
	public void setTipoInversions(List<TipoInversion> newTipoInversions) {
		this.tipoinversions = newTipoInversions;
	}
	
	public Object getTipoInversionObject() {	
		this.tipoinversionObject=this.tipoinversionDataAccess.getEntityObject();
		return this.tipoinversionObject;
	}
		
	public void setTipoInversionObject(Object newTipoInversionObject) {
		this.tipoinversionObject = newTipoInversionObject;
	}
	
	public List<Object> getTipoInversionsObject() {		
		this.tipoinversionsObject=this.tipoinversionDataAccess.getEntitiesObject();
		return this.tipoinversionsObject;
	}
		
	public void setTipoInversionsObject(List<Object> newTipoInversionsObject) {
		this.tipoinversionsObject = newTipoInversionsObject;
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
		
		if(this.tipoinversionDataAccess!=null) {
			this.tipoinversionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoinversionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoinversionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoinversion = new  TipoInversion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoinversion=tipoinversionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoinversion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversion);
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
		tipoinversion = new  TipoInversion();
		  		  
        try {
			
			tipoinversion=tipoinversionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoinversion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoinversion = new  TipoInversion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoinversion=tipoinversionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoinversion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversion);
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
		tipoinversion = new  TipoInversion();
		  		  
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
		tipoinversion = new  TipoInversion();
		  		  
        try {
			
			tipoinversion=tipoinversionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoinversion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoinversion = new  TipoInversion();
		  		  
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
		tipoinversion = new  TipoInversion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoinversionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoinversion = new  TipoInversion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoinversionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoinversion = new  TipoInversion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoinversionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoinversion = new  TipoInversion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoinversionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoinversion = new  TipoInversion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoinversionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoinversion = new  TipoInversion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoinversionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoinversions = new  ArrayList<TipoInversion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinversions=tipoinversionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInversion(tipoinversions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversions);
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
		tipoinversions = new  ArrayList<TipoInversion>();
		  		  
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
		tipoinversions = new  ArrayList<TipoInversion>();
		  		  
        try {			
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinversions=tipoinversionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoInversion(tipoinversions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoinversions = new  ArrayList<TipoInversion>();
		  		  
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
		tipoinversions = new  ArrayList<TipoInversion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinversions=tipoinversionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInversion(tipoinversions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversions);
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
		tipoinversions = new  ArrayList<TipoInversion>();
		  		  
        try {
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinversions=tipoinversionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInversion(tipoinversions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversions);
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
		tipoinversions = new  ArrayList<TipoInversion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinversions=tipoinversionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInversion(tipoinversions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversions);
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
		tipoinversions = new  ArrayList<TipoInversion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinversions=tipoinversionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInversion(tipoinversions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoinversion = new  TipoInversion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinversion=tipoinversionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInversion(tipoinversion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversion);
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
		tipoinversion = new  TipoInversion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinversion=tipoinversionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInversion(tipoinversion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoinversions = new  ArrayList<TipoInversion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinversions=tipoinversionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInversion(tipoinversions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversions);
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
		tipoinversions = new  ArrayList<TipoInversion>();
		  		  
        try {
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinversions=tipoinversionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInversion(tipoinversions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoInversionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoinversions = new  ArrayList<TipoInversion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-getTodosTipoInversionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinversions=tipoinversionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoInversion(tipoinversions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversions);
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
	
	public  void  getTodosTipoInversions(String sFinalQuery,Pagination pagination)throws Exception {
		tipoinversions = new  ArrayList<TipoInversion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinversions=tipoinversionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoInversion(tipoinversions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoInversion(TipoInversion tipoinversion) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoinversion.getIsNew() || tipoinversion.getIsChanged()) { 
			this.invalidValues = tipoinversionValidator.getInvalidValues(tipoinversion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoinversion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoInversion(List<TipoInversion> TipoInversions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoInversion tipoinversionLocal:tipoinversions) {				
			estaValidadoObjeto=this.validarGuardarTipoInversion(tipoinversionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoInversion(List<TipoInversion> TipoInversions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoInversion(tipoinversions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoInversion(TipoInversion TipoInversion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoInversion(tipoinversion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoInversion tipoinversion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoinversion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoInversionConstantesFunciones.getTipoInversionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoinversion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoInversionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoInversionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoInversionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-saveTipoInversionWithConnection");connexion.begin();			
			
			TipoInversionLogicAdditional.checkTipoInversionToSave(this.tipoinversion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoInversionLogicAdditional.updateTipoInversionToSave(this.tipoinversion,this.arrDatoGeneral);
			
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoinversion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoInversion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoInversion(this.tipoinversion)) {
				TipoInversionDataAccess.save(this.tipoinversion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoinversion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoInversionLogicAdditional.checkTipoInversionToSaveAfter(this.tipoinversion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoInversion();
			
			connexion.commit();			
			
			if(this.tipoinversion.getIsDeleted()) {
				this.tipoinversion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoInversion()throws Exception {	
		try {	
			
			TipoInversionLogicAdditional.checkTipoInversionToSave(this.tipoinversion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoInversionLogicAdditional.updateTipoInversionToSave(this.tipoinversion,this.arrDatoGeneral);
			
			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoinversion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoInversion(this.tipoinversion)) {			
				TipoInversionDataAccess.save(this.tipoinversion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoinversion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoInversionLogicAdditional.checkTipoInversionToSaveAfter(this.tipoinversion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoinversion.getIsDeleted()) {
				this.tipoinversion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoInversionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-saveTipoInversionsWithConnection");connexion.begin();			
			
			TipoInversionLogicAdditional.checkTipoInversionToSaves(tipoinversions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoInversions();
			
			Boolean validadoTodosTipoInversion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoInversion tipoinversionLocal:tipoinversions) {		
				if(tipoinversionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoInversionLogicAdditional.updateTipoInversionToSave(tipoinversionLocal,this.arrDatoGeneral);
	        	
				TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoinversionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoInversion(tipoinversionLocal)) {
					TipoInversionDataAccess.save(tipoinversionLocal, connexion);				
				} else {
					validadoTodosTipoInversion=false;
				}
			}
			
			if(!validadoTodosTipoInversion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoInversionLogicAdditional.checkTipoInversionToSavesAfter(tipoinversions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoInversions();
			
			connexion.commit();		
			
			this.quitarTipoInversionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoInversions()throws Exception {				
		 try {	
			TipoInversionLogicAdditional.checkTipoInversionToSaves(tipoinversions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoInversion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoInversion tipoinversionLocal:tipoinversions) {				
				if(tipoinversionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoInversionLogicAdditional.updateTipoInversionToSave(tipoinversionLocal,this.arrDatoGeneral);
	        	
				TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoinversionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoInversion(tipoinversionLocal)) {				
					TipoInversionDataAccess.save(tipoinversionLocal, connexion);				
				} else {
					validadoTodosTipoInversion=false;
				}
			}
			
			if(!validadoTodosTipoInversion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoInversionLogicAdditional.checkTipoInversionToSavesAfter(tipoinversions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoInversionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoInversionParameterReturnGeneral procesarAccionTipoInversions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoInversion> tipoinversions,TipoInversionParameterReturnGeneral tipoinversionParameterGeneral)throws Exception {
		 try {	
			TipoInversionParameterReturnGeneral tipoinversionReturnGeneral=new TipoInversionParameterReturnGeneral();
	
			TipoInversionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoinversions,tipoinversionParameterGeneral,tipoinversionReturnGeneral);
			
			return tipoinversionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoInversionParameterReturnGeneral procesarAccionTipoInversionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoInversion> tipoinversions,TipoInversionParameterReturnGeneral tipoinversionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-procesarAccionTipoInversionsWithConnection");connexion.begin();			
			
			TipoInversionParameterReturnGeneral tipoinversionReturnGeneral=new TipoInversionParameterReturnGeneral();
	
			TipoInversionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoinversions,tipoinversionParameterGeneral,tipoinversionReturnGeneral);
			
			this.connexion.commit();
			
			return tipoinversionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoInversionParameterReturnGeneral procesarEventosTipoInversions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoInversion> tipoinversions,TipoInversion tipoinversion,TipoInversionParameterReturnGeneral tipoinversionParameterGeneral,Boolean isEsNuevoTipoInversion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoInversionParameterReturnGeneral tipoinversionReturnGeneral=new TipoInversionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoinversionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoInversionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoinversions,tipoinversion,tipoinversionParameterGeneral,tipoinversionReturnGeneral,isEsNuevoTipoInversion,clases);
			
			return tipoinversionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoInversionParameterReturnGeneral procesarEventosTipoInversionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoInversion> tipoinversions,TipoInversion tipoinversion,TipoInversionParameterReturnGeneral tipoinversionParameterGeneral,Boolean isEsNuevoTipoInversion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-procesarEventosTipoInversionsWithConnection");connexion.begin();			
			
			TipoInversionParameterReturnGeneral tipoinversionReturnGeneral=new TipoInversionParameterReturnGeneral();
	
			tipoinversionReturnGeneral.setTipoInversion(tipoinversion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoinversionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoInversionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoinversions,tipoinversion,tipoinversionParameterGeneral,tipoinversionReturnGeneral,isEsNuevoTipoInversion,clases);
			
			this.connexion.commit();
			
			return tipoinversionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoInversionParameterReturnGeneral procesarImportacionTipoInversionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoInversionParameterReturnGeneral tipoinversionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-procesarImportacionTipoInversionsWithConnection");connexion.begin();			
			
			TipoInversionParameterReturnGeneral tipoinversionReturnGeneral=new TipoInversionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoinversions=new ArrayList<TipoInversion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoinversion=new TipoInversion();
				
				
				if(conColumnasBase) {this.tipoinversion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoinversion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoinversion.setcodigo(arrColumnas[iColumn++]);
				this.tipoinversion.setnombre(arrColumnas[iColumn++]);
				
				this.tipoinversions.add(this.tipoinversion);
			}
			
			this.saveTipoInversions();
			
			this.connexion.commit();
			
			tipoinversionReturnGeneral.setConRetornoEstaProcesado(true);
			tipoinversionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoinversionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoInversionsEliminados() throws Exception {				
		
		List<TipoInversion> tipoinversionsAux= new ArrayList<TipoInversion>();
		
		for(TipoInversion tipoinversion:tipoinversions) {
			if(!tipoinversion.getIsDeleted()) {
				tipoinversionsAux.add(tipoinversion);
			}
		}
		
		tipoinversions=tipoinversionsAux;
	}
	
	public void quitarTipoInversionsNulos() throws Exception {				
		
		List<TipoInversion> tipoinversionsAux= new ArrayList<TipoInversion>();
		
		for(TipoInversion tipoinversion : this.tipoinversions) {
			if(tipoinversion==null) {
				tipoinversionsAux.add(tipoinversion);
			}
		}
		
		//this.tipoinversions=tipoinversionsAux;
		
		this.tipoinversions.removeAll(tipoinversionsAux);
	}
	
	public void getSetVersionRowTipoInversionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoinversion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoinversion.getIsDeleted() || (tipoinversion.getIsChanged()&&!tipoinversion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoinversionDataAccess.getSetVersionRowTipoInversion(connexion,tipoinversion.getId());
				
				if(!tipoinversion.getVersionRow().equals(timestamp)) {	
					tipoinversion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoinversion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoInversion()throws Exception {	
		
		if(tipoinversion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoinversion.getIsDeleted() || (tipoinversion.getIsChanged()&&!tipoinversion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoinversionDataAccess.getSetVersionRowTipoInversion(connexion,tipoinversion.getId());
			
			try {							
				if(!tipoinversion.getVersionRow().equals(timestamp)) {	
					tipoinversion.setVersionRow(timestamp);
				}
				
				tipoinversion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoInversionsWithConnection()throws Exception {	
		if(tipoinversions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoInversion tipoinversionAux:tipoinversions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoinversionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoinversionAux.getIsDeleted() || (tipoinversionAux.getIsChanged()&&!tipoinversionAux.getIsNew())) {
						
						timestamp=tipoinversionDataAccess.getSetVersionRowTipoInversion(connexion,tipoinversionAux.getId());
						
						if(!tipoinversion.getVersionRow().equals(timestamp)) {	
							tipoinversionAux.setVersionRow(timestamp);
						}
								
						tipoinversionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoInversions()throws Exception {	
		if(tipoinversions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoInversion tipoinversionAux:tipoinversions) {
					if(tipoinversionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoinversionAux.getIsDeleted() || (tipoinversionAux.getIsChanged()&&!tipoinversionAux.getIsNew())) {
						
						timestamp=tipoinversionDataAccess.getSetVersionRowTipoInversion(connexion,tipoinversionAux.getId());
						
						if(!tipoinversionAux.getVersionRow().equals(timestamp)) {	
							tipoinversionAux.setVersionRow(timestamp);
						}
						
													
						tipoinversionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoInversionParameterReturnGeneral cargarCombosLoteForeignKeyTipoInversionWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoInversionParameterReturnGeneral  tipoinversionReturnGeneral =new TipoInversionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoInversionWithConnection");connexion.begin();
			
			tipoinversionReturnGeneral =new TipoInversionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoinversionReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoinversionReturnGeneral;
	}
	
	public TipoInversionParameterReturnGeneral cargarCombosLoteForeignKeyTipoInversion(String finalQueryGlobalEmpresa) throws Exception {
		TipoInversionParameterReturnGeneral  tipoinversionReturnGeneral =new TipoInversionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoinversionReturnGeneral =new TipoInversionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoinversionReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoinversionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoInversionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			AccionistaLogic accionistaLogic=new AccionistaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoInversionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Accionista.class));
											
			

			accionistaLogic.setConnexion(this.getConnexion());
			accionistaLogic.setDatosCliente(this.datosCliente);
			accionistaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoInversion tipoinversion:this.tipoinversions) {
				

				classes=new ArrayList<Classe>();
				classes=AccionistaConstantesFunciones.getClassesForeignKeysOfAccionista(new ArrayList<Classe>(),DeepLoadType.NONE);

				accionistaLogic.setAccionistas(tipoinversion.accionistas);
				accionistaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoInversion tipoinversion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoInversionLogicAdditional.updateTipoInversionToGet(tipoinversion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoinversion.setEmpresa(tipoinversionDataAccess.getEmpresa(connexion,tipoinversion));
		tipoinversion.setAccionistas(tipoinversionDataAccess.getAccionistas(connexion,tipoinversion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoinversion.setEmpresa(tipoinversionDataAccess.getEmpresa(connexion,tipoinversion));
				continue;
			}

			if(clas.clas.equals(Accionista.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoinversion.setAccionistas(tipoinversionDataAccess.getAccionistas(connexion,tipoinversion));

				if(this.isConDeep) {
					AccionistaLogic accionistaLogic= new AccionistaLogic(this.connexion);
					accionistaLogic.setAccionistas(tipoinversion.getAccionistas());
					ArrayList<Classe> classesLocal=AccionistaConstantesFunciones.getClassesForeignKeysOfAccionista(new ArrayList<Classe>(),DeepLoadType.NONE);
					accionistaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(accionistaLogic.getAccionistas());
					tipoinversion.setAccionistas(accionistaLogic.getAccionistas());
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
			tipoinversion.setEmpresa(tipoinversionDataAccess.getEmpresa(connexion,tipoinversion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Accionista.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Accionista.class));
			tipoinversion.setAccionistas(tipoinversionDataAccess.getAccionistas(connexion,tipoinversion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoinversion.setEmpresa(tipoinversionDataAccess.getEmpresa(connexion,tipoinversion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoinversion.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoinversion.setAccionistas(tipoinversionDataAccess.getAccionistas(connexion,tipoinversion));

		for(Accionista accionista:tipoinversion.getAccionistas()) {
			AccionistaLogic accionistaLogic= new AccionistaLogic(connexion);
			accionistaLogic.deepLoad(accionista,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoinversion.setEmpresa(tipoinversionDataAccess.getEmpresa(connexion,tipoinversion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoinversion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Accionista.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoinversion.setAccionistas(tipoinversionDataAccess.getAccionistas(connexion,tipoinversion));

				for(Accionista accionista:tipoinversion.getAccionistas()) {
					AccionistaLogic accionistaLogic= new AccionistaLogic(connexion);
					accionistaLogic.deepLoad(accionista,isDeep,deepLoadType,clases);
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
			tipoinversion.setEmpresa(tipoinversionDataAccess.getEmpresa(connexion,tipoinversion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoinversion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Accionista.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Accionista.class));
			tipoinversion.setAccionistas(tipoinversionDataAccess.getAccionistas(connexion,tipoinversion));

			for(Accionista accionista:tipoinversion.getAccionistas()) {
				AccionistaLogic accionistaLogic= new AccionistaLogic(connexion);
				accionistaLogic.deepLoad(accionista,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoInversion tipoinversion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoInversionLogicAdditional.updateTipoInversionToSave(tipoinversion,this.arrDatoGeneral);
			
TipoInversionDataAccess.save(tipoinversion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoinversion.getEmpresa(),connexion);

		for(Accionista accionista:tipoinversion.getAccionistas()) {
			accionista.setidvalorclienteinversion(tipoinversion.getId());
			AccionistaDataAccess.save(accionista,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoinversion.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Accionista.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Accionista accionista:tipoinversion.getAccionistas()) {
					accionista.setidvalorclienteinversion(tipoinversion.getId());
					AccionistaDataAccess.save(accionista,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoinversion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoinversion.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Accionista accionista:tipoinversion.getAccionistas()) {
			AccionistaLogic accionistaLogic= new AccionistaLogic(connexion);
			accionista.setidvalorclienteinversion(tipoinversion.getId());
			AccionistaDataAccess.save(accionista,connexion);
			accionistaLogic.deepSave(accionista,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoinversion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoinversion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Accionista.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Accionista accionista:tipoinversion.getAccionistas()) {
					AccionistaLogic accionistaLogic= new AccionistaLogic(connexion);
					accionista.setidvalorclienteinversion(tipoinversion.getId());
					AccionistaDataAccess.save(accionista,connexion);
					accionistaLogic.deepSave(accionista,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoInversion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoinversion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(tipoinversion);
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
			this.deepLoad(this.tipoinversion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoInversion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoinversions!=null) {
				for(TipoInversion tipoinversion:tipoinversions) {
					this.deepLoad(tipoinversion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(tipoinversions);
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
			if(tipoinversions!=null) {
				for(TipoInversion tipoinversion:tipoinversions) {
					this.deepLoad(tipoinversion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(tipoinversions);
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
			this.getNewConnexionToDeep(TipoInversion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoinversion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoInversion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoinversions!=null) {
				for(TipoInversion tipoinversion:tipoinversions) {
					this.deepSave(tipoinversion,isDeep,deepLoadType,clases);
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
			if(tipoinversions!=null) {
				for(TipoInversion tipoinversion:tipoinversions) {
					this.deepSave(tipoinversion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoInversionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInversion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoInversionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoinversions=tipoinversionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoInversionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoInversionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoInversionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoinversions=tipoinversionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoInversionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInversion(this.tipoinversions);
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
			if(TipoInversionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInversionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoInversion tipoinversion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoInversionConstantesFunciones.ISCONAUDITORIA) {
				if(tipoinversion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInversionDataAccess.TABLENAME, tipoinversion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoInversionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoInversionLogic.registrarAuditoriaDetallesTipoInversion(connexion,tipoinversion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoinversion.getIsDeleted()) {
					/*if(!tipoinversion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoInversionDataAccess.TABLENAME, tipoinversion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoInversionLogic.registrarAuditoriaDetallesTipoInversion(connexion,tipoinversion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInversionDataAccess.TABLENAME, tipoinversion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoinversion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInversionDataAccess.TABLENAME, tipoinversion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoInversionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoInversionLogic.registrarAuditoriaDetallesTipoInversion(connexion,tipoinversion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoInversion(Connexion connexion,TipoInversion tipoinversion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoinversion.getIsNew()||!tipoinversion.getid_empresa().equals(tipoinversion.getTipoInversionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoinversion.getTipoInversionOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoinversion.getTipoInversionOriginal().getid_empresa().toString();
				}
				if(tipoinversion.getid_empresa()!=null)
				{
					strValorNuevo=tipoinversion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoInversionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoinversion.getIsNew()||!tipoinversion.getcodigo().equals(tipoinversion.getTipoInversionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoinversion.getTipoInversionOriginal().getcodigo()!=null)
				{
					strValorActual=tipoinversion.getTipoInversionOriginal().getcodigo();
				}
				if(tipoinversion.getcodigo()!=null)
				{
					strValorNuevo=tipoinversion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoInversionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoinversion.getIsNew()||!tipoinversion.getnombre().equals(tipoinversion.getTipoInversionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoinversion.getTipoInversionOriginal().getnombre()!=null)
				{
					strValorActual=tipoinversion.getTipoInversionOriginal().getnombre();
				}
				if(tipoinversion.getnombre()!=null)
				{
					strValorNuevo=tipoinversion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoInversionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoInversionRelacionesWithConnection(TipoInversion tipoinversion,List<Accionista> accionistas) throws Exception {

		if(!tipoinversion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoInversionRelacionesBase(tipoinversion,accionistas,true);
		}
	}

	public void saveTipoInversionRelaciones(TipoInversion tipoinversion,List<Accionista> accionistas)throws Exception {

		if(!tipoinversion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoInversionRelacionesBase(tipoinversion,accionistas,false);
		}
	}

	public void saveTipoInversionRelacionesBase(TipoInversion tipoinversion,List<Accionista> accionistas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoInversion-saveRelacionesWithConnection");}
	
			tipoinversion.setAccionistas(accionistas);

			this.setTipoInversion(tipoinversion);

			if(TipoInversionLogicAdditional.validarSaveRelaciones(tipoinversion,this)) {

				TipoInversionLogicAdditional.updateRelacionesToSave(tipoinversion,this);

				if((tipoinversion.getIsNew()||tipoinversion.getIsChanged())&&!tipoinversion.getIsDeleted()) {
					this.saveTipoInversion();
					this.saveTipoInversionRelacionesDetalles(accionistas);

				} else if(tipoinversion.getIsDeleted()) {
					this.saveTipoInversionRelacionesDetalles(accionistas);
					this.saveTipoInversion();
				}

				TipoInversionLogicAdditional.updateRelacionesToSaveAfter(tipoinversion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			AccionistaConstantesFunciones.InicializarGeneralEntityAuxiliaresAccionistas(accionistas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoInversionRelacionesDetalles(List<Accionista> accionistas)throws Exception {
		try {
	

			Long idTipoInversionActual=this.getTipoInversion().getId();

			AccionistaLogic accionistaLogic_Desde_TipoInversion=new AccionistaLogic();
			accionistaLogic_Desde_TipoInversion.setAccionistas(accionistas);

			accionistaLogic_Desde_TipoInversion.setConnexion(this.getConnexion());
			accionistaLogic_Desde_TipoInversion.setDatosCliente(this.datosCliente);

			for(Accionista accionista_Desde_TipoInversion:accionistaLogic_Desde_TipoInversion.getAccionistas()) {
				accionista_Desde_TipoInversion.setidvalorclienteinversion(idTipoInversionActual);
			}

			accionistaLogic_Desde_TipoInversion.saveAccionistas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoInversion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoInversionConstantesFunciones.getClassesForeignKeysOfTipoInversion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInversion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoInversionConstantesFunciones.getClassesRelationshipsOfTipoInversion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

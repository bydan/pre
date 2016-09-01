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
import com.bydan.erp.tesoreria.util.TipoBancoRetencionConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoBancoRetencionParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoBancoRetencionParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.TipoBancoRetencion;
import com.bydan.erp.tesoreria.business.logic.TipoBancoRetencionLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoBancoRetencionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoBancoRetencionLogic.class);
	
	protected TipoBancoRetencionDataAccess tipobancoretencionDataAccess; 	
	protected TipoBancoRetencion tipobancoretencion;
	protected List<TipoBancoRetencion> tipobancoretencions;
	protected Object tipobancoretencionObject;	
	protected List<Object> tipobancoretencionsObject;
	
	public static ClassValidator<TipoBancoRetencion> tipobancoretencionValidator = new ClassValidator<TipoBancoRetencion>(TipoBancoRetencion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoBancoRetencionLogicAdditional tipobancoretencionLogicAdditional=null;
	
	public TipoBancoRetencionLogicAdditional getTipoBancoRetencionLogicAdditional() {
		return this.tipobancoretencionLogicAdditional;
	}
	
	public void setTipoBancoRetencionLogicAdditional(TipoBancoRetencionLogicAdditional tipobancoretencionLogicAdditional) {
		try {
			this.tipobancoretencionLogicAdditional=tipobancoretencionLogicAdditional;
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
	
	
	
	
	public  TipoBancoRetencionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipobancoretencionDataAccess = new TipoBancoRetencionDataAccess();
			
			this.tipobancoretencions= new ArrayList<TipoBancoRetencion>();
			this.tipobancoretencion= new TipoBancoRetencion();
			
			this.tipobancoretencionObject=new Object();
			this.tipobancoretencionsObject=new ArrayList<Object>();
				
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
			
			this.tipobancoretencionDataAccess.setConnexionType(this.connexionType);
			this.tipobancoretencionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoBancoRetencionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipobancoretencionDataAccess = new TipoBancoRetencionDataAccess();
			this.tipobancoretencions= new ArrayList<TipoBancoRetencion>();
			this.tipobancoretencion= new TipoBancoRetencion();
			this.tipobancoretencionObject=new Object();
			this.tipobancoretencionsObject=new ArrayList<Object>();
			
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
			
			this.tipobancoretencionDataAccess.setConnexionType(this.connexionType);
			this.tipobancoretencionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoBancoRetencion getTipoBancoRetencion() throws Exception {	
		TipoBancoRetencionLogicAdditional.checkTipoBancoRetencionToGet(tipobancoretencion,this.datosCliente,this.arrDatoGeneral);
		TipoBancoRetencionLogicAdditional.updateTipoBancoRetencionToGet(tipobancoretencion,this.arrDatoGeneral);
		
		return tipobancoretencion;
	}
		
	public void setTipoBancoRetencion(TipoBancoRetencion newTipoBancoRetencion) {
		this.tipobancoretencion = newTipoBancoRetencion;
	}
	
	public TipoBancoRetencionDataAccess getTipoBancoRetencionDataAccess() {
		return tipobancoretencionDataAccess;
	}
	
	public void setTipoBancoRetencionDataAccess(TipoBancoRetencionDataAccess newtipobancoretencionDataAccess) {
		this.tipobancoretencionDataAccess = newtipobancoretencionDataAccess;
	}
	
	public List<TipoBancoRetencion> getTipoBancoRetencions() throws Exception {		
		this.quitarTipoBancoRetencionsNulos();
		
		TipoBancoRetencionLogicAdditional.checkTipoBancoRetencionToGets(tipobancoretencions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoBancoRetencion tipobancoretencionLocal: tipobancoretencions ) {
			TipoBancoRetencionLogicAdditional.updateTipoBancoRetencionToGet(tipobancoretencionLocal,this.arrDatoGeneral);
		}
		
		return tipobancoretencions;
	}
	
	public void setTipoBancoRetencions(List<TipoBancoRetencion> newTipoBancoRetencions) {
		this.tipobancoretencions = newTipoBancoRetencions;
	}
	
	public Object getTipoBancoRetencionObject() {	
		this.tipobancoretencionObject=this.tipobancoretencionDataAccess.getEntityObject();
		return this.tipobancoretencionObject;
	}
		
	public void setTipoBancoRetencionObject(Object newTipoBancoRetencionObject) {
		this.tipobancoretencionObject = newTipoBancoRetencionObject;
	}
	
	public List<Object> getTipoBancoRetencionsObject() {		
		this.tipobancoretencionsObject=this.tipobancoretencionDataAccess.getEntitiesObject();
		return this.tipobancoretencionsObject;
	}
		
	public void setTipoBancoRetencionsObject(List<Object> newTipoBancoRetencionsObject) {
		this.tipobancoretencionsObject = newTipoBancoRetencionsObject;
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
		
		if(this.tipobancoretencionDataAccess!=null) {
			this.tipobancoretencionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipobancoretencionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipobancoretencionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipobancoretencion = new  TipoBancoRetencion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipobancoretencion=tipobancoretencionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipobancoretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencion);
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
		tipobancoretencion = new  TipoBancoRetencion();
		  		  
        try {
			
			tipobancoretencion=tipobancoretencionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipobancoretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipobancoretencion = new  TipoBancoRetencion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipobancoretencion=tipobancoretencionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipobancoretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencion);
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
		tipobancoretencion = new  TipoBancoRetencion();
		  		  
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
		tipobancoretencion = new  TipoBancoRetencion();
		  		  
        try {
			
			tipobancoretencion=tipobancoretencionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipobancoretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipobancoretencion = new  TipoBancoRetencion();
		  		  
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
		tipobancoretencion = new  TipoBancoRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipobancoretencionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipobancoretencion = new  TipoBancoRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipobancoretencionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipobancoretencion = new  TipoBancoRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipobancoretencionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipobancoretencion = new  TipoBancoRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipobancoretencionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipobancoretencion = new  TipoBancoRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipobancoretencionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipobancoretencion = new  TipoBancoRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipobancoretencionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipobancoretencions = new  ArrayList<TipoBancoRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoRetencion(tipobancoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
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
		tipobancoretencions = new  ArrayList<TipoBancoRetencion>();
		  		  
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
		tipobancoretencions = new  ArrayList<TipoBancoRetencion>();
		  		  
        try {			
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoBancoRetencion(tipobancoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipobancoretencions = new  ArrayList<TipoBancoRetencion>();
		  		  
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
		tipobancoretencions = new  ArrayList<TipoBancoRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoRetencion(tipobancoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
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
		tipobancoretencions = new  ArrayList<TipoBancoRetencion>();
		  		  
        try {
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoRetencion(tipobancoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
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
		tipobancoretencions = new  ArrayList<TipoBancoRetencion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoBancoRetencion(tipobancoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
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
		tipobancoretencions = new  ArrayList<TipoBancoRetencion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoBancoRetencion(tipobancoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipobancoretencion = new  TipoBancoRetencion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoretencion=tipobancoretencionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoBancoRetencion(tipobancoretencion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencion);
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
		tipobancoretencion = new  TipoBancoRetencion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoretencion=tipobancoretencionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoBancoRetencion(tipobancoretencion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipobancoretencions = new  ArrayList<TipoBancoRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoretencions=tipobancoretencionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoRetencion(tipobancoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
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
		tipobancoretencions = new  ArrayList<TipoBancoRetencion>();
		  		  
        try {
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoretencions=tipobancoretencionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoRetencion(tipobancoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoBancoRetencionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipobancoretencions = new  ArrayList<TipoBancoRetencion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getTodosTipoBancoRetencionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoBancoRetencion(tipobancoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
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
	
	public  void  getTodosTipoBancoRetencions(String sFinalQuery,Pagination pagination)throws Exception {
		tipobancoretencions = new  ArrayList<TipoBancoRetencion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoBancoRetencion(tipobancoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoBancoRetencion(TipoBancoRetencion tipobancoretencion) throws Exception {
		Boolean estaValidado=false;
		
		if(tipobancoretencion.getIsNew() || tipobancoretencion.getIsChanged()) { 
			this.invalidValues = tipobancoretencionValidator.getInvalidValues(tipobancoretencion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipobancoretencion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoBancoRetencion(List<TipoBancoRetencion> TipoBancoRetencions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoBancoRetencion tipobancoretencionLocal:tipobancoretencions) {				
			estaValidadoObjeto=this.validarGuardarTipoBancoRetencion(tipobancoretencionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoBancoRetencion(List<TipoBancoRetencion> TipoBancoRetencions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoBancoRetencion(tipobancoretencions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoBancoRetencion(TipoBancoRetencion TipoBancoRetencion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoBancoRetencion(tipobancoretencion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoBancoRetencion tipobancoretencion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipobancoretencion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoBancoRetencionConstantesFunciones.getTipoBancoRetencionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipobancoretencion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoBancoRetencionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoBancoRetencionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoBancoRetencionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-saveTipoBancoRetencionWithConnection");connexion.begin();			
			
			TipoBancoRetencionLogicAdditional.checkTipoBancoRetencionToSave(this.tipobancoretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoBancoRetencionLogicAdditional.updateTipoBancoRetencionToSave(this.tipobancoretencion,this.arrDatoGeneral);
			
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipobancoretencion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoBancoRetencion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoBancoRetencion(this.tipobancoretencion)) {
				TipoBancoRetencionDataAccess.save(this.tipobancoretencion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipobancoretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoBancoRetencionLogicAdditional.checkTipoBancoRetencionToSaveAfter(this.tipobancoretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoBancoRetencion();
			
			connexion.commit();			
			
			if(this.tipobancoretencion.getIsDeleted()) {
				this.tipobancoretencion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoBancoRetencion()throws Exception {	
		try {	
			
			TipoBancoRetencionLogicAdditional.checkTipoBancoRetencionToSave(this.tipobancoretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoBancoRetencionLogicAdditional.updateTipoBancoRetencionToSave(this.tipobancoretencion,this.arrDatoGeneral);
			
			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipobancoretencion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoBancoRetencion(this.tipobancoretencion)) {			
				TipoBancoRetencionDataAccess.save(this.tipobancoretencion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipobancoretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoBancoRetencionLogicAdditional.checkTipoBancoRetencionToSaveAfter(this.tipobancoretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipobancoretencion.getIsDeleted()) {
				this.tipobancoretencion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoBancoRetencionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-saveTipoBancoRetencionsWithConnection");connexion.begin();			
			
			TipoBancoRetencionLogicAdditional.checkTipoBancoRetencionToSaves(tipobancoretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoBancoRetencions();
			
			Boolean validadoTodosTipoBancoRetencion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoBancoRetencion tipobancoretencionLocal:tipobancoretencions) {		
				if(tipobancoretencionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoBancoRetencionLogicAdditional.updateTipoBancoRetencionToSave(tipobancoretencionLocal,this.arrDatoGeneral);
	        	
				TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipobancoretencionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoBancoRetencion(tipobancoretencionLocal)) {
					TipoBancoRetencionDataAccess.save(tipobancoretencionLocal, connexion);				
				} else {
					validadoTodosTipoBancoRetencion=false;
				}
			}
			
			if(!validadoTodosTipoBancoRetencion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoBancoRetencionLogicAdditional.checkTipoBancoRetencionToSavesAfter(tipobancoretencions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoBancoRetencions();
			
			connexion.commit();		
			
			this.quitarTipoBancoRetencionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoBancoRetencions()throws Exception {				
		 try {	
			TipoBancoRetencionLogicAdditional.checkTipoBancoRetencionToSaves(tipobancoretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoBancoRetencion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoBancoRetencion tipobancoretencionLocal:tipobancoretencions) {				
				if(tipobancoretencionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoBancoRetencionLogicAdditional.updateTipoBancoRetencionToSave(tipobancoretencionLocal,this.arrDatoGeneral);
	        	
				TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipobancoretencionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoBancoRetencion(tipobancoretencionLocal)) {				
					TipoBancoRetencionDataAccess.save(tipobancoretencionLocal, connexion);				
				} else {
					validadoTodosTipoBancoRetencion=false;
				}
			}
			
			if(!validadoTodosTipoBancoRetencion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoBancoRetencionLogicAdditional.checkTipoBancoRetencionToSavesAfter(tipobancoretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoBancoRetencionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoBancoRetencionParameterReturnGeneral procesarAccionTipoBancoRetencions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoBancoRetencion> tipobancoretencions,TipoBancoRetencionParameterReturnGeneral tipobancoretencionParameterGeneral)throws Exception {
		 try {	
			TipoBancoRetencionParameterReturnGeneral tipobancoretencionReturnGeneral=new TipoBancoRetencionParameterReturnGeneral();
	
			TipoBancoRetencionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipobancoretencions,tipobancoretencionParameterGeneral,tipobancoretencionReturnGeneral);
			
			return tipobancoretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoBancoRetencionParameterReturnGeneral procesarAccionTipoBancoRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoBancoRetencion> tipobancoretencions,TipoBancoRetencionParameterReturnGeneral tipobancoretencionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-procesarAccionTipoBancoRetencionsWithConnection");connexion.begin();			
			
			TipoBancoRetencionParameterReturnGeneral tipobancoretencionReturnGeneral=new TipoBancoRetencionParameterReturnGeneral();
	
			TipoBancoRetencionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipobancoretencions,tipobancoretencionParameterGeneral,tipobancoretencionReturnGeneral);
			
			this.connexion.commit();
			
			return tipobancoretencionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoBancoRetencionParameterReturnGeneral procesarEventosTipoBancoRetencions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoBancoRetencion> tipobancoretencions,TipoBancoRetencion tipobancoretencion,TipoBancoRetencionParameterReturnGeneral tipobancoretencionParameterGeneral,Boolean isEsNuevoTipoBancoRetencion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoBancoRetencionParameterReturnGeneral tipobancoretencionReturnGeneral=new TipoBancoRetencionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipobancoretencionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoBancoRetencionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipobancoretencions,tipobancoretencion,tipobancoretencionParameterGeneral,tipobancoretencionReturnGeneral,isEsNuevoTipoBancoRetencion,clases);
			
			return tipobancoretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoBancoRetencionParameterReturnGeneral procesarEventosTipoBancoRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoBancoRetencion> tipobancoretencions,TipoBancoRetencion tipobancoretencion,TipoBancoRetencionParameterReturnGeneral tipobancoretencionParameterGeneral,Boolean isEsNuevoTipoBancoRetencion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-procesarEventosTipoBancoRetencionsWithConnection");connexion.begin();			
			
			TipoBancoRetencionParameterReturnGeneral tipobancoretencionReturnGeneral=new TipoBancoRetencionParameterReturnGeneral();
	
			tipobancoretencionReturnGeneral.setTipoBancoRetencion(tipobancoretencion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipobancoretencionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoBancoRetencionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipobancoretencions,tipobancoretencion,tipobancoretencionParameterGeneral,tipobancoretencionReturnGeneral,isEsNuevoTipoBancoRetencion,clases);
			
			this.connexion.commit();
			
			return tipobancoretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoBancoRetencionParameterReturnGeneral procesarImportacionTipoBancoRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoBancoRetencionParameterReturnGeneral tipobancoretencionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-procesarImportacionTipoBancoRetencionsWithConnection");connexion.begin();			
			
			TipoBancoRetencionParameterReturnGeneral tipobancoretencionReturnGeneral=new TipoBancoRetencionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipobancoretencions=new ArrayList<TipoBancoRetencion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipobancoretencion=new TipoBancoRetencion();
				
				
				if(conColumnasBase) {this.tipobancoretencion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipobancoretencion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipobancoretencion.setcodigo(arrColumnas[iColumn++]);
				this.tipobancoretencion.setnombre(arrColumnas[iColumn++]);
				
				this.tipobancoretencions.add(this.tipobancoretencion);
			}
			
			this.saveTipoBancoRetencions();
			
			this.connexion.commit();
			
			tipobancoretencionReturnGeneral.setConRetornoEstaProcesado(true);
			tipobancoretencionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipobancoretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoBancoRetencionsEliminados() throws Exception {				
		
		List<TipoBancoRetencion> tipobancoretencionsAux= new ArrayList<TipoBancoRetencion>();
		
		for(TipoBancoRetencion tipobancoretencion:tipobancoretencions) {
			if(!tipobancoretencion.getIsDeleted()) {
				tipobancoretencionsAux.add(tipobancoretencion);
			}
		}
		
		tipobancoretencions=tipobancoretencionsAux;
	}
	
	public void quitarTipoBancoRetencionsNulos() throws Exception {				
		
		List<TipoBancoRetencion> tipobancoretencionsAux= new ArrayList<TipoBancoRetencion>();
		
		for(TipoBancoRetencion tipobancoretencion : this.tipobancoretencions) {
			if(tipobancoretencion==null) {
				tipobancoretencionsAux.add(tipobancoretencion);
			}
		}
		
		//this.tipobancoretencions=tipobancoretencionsAux;
		
		this.tipobancoretencions.removeAll(tipobancoretencionsAux);
	}
	
	public void getSetVersionRowTipoBancoRetencionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipobancoretencion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipobancoretencion.getIsDeleted() || (tipobancoretencion.getIsChanged()&&!tipobancoretencion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipobancoretencionDataAccess.getSetVersionRowTipoBancoRetencion(connexion,tipobancoretencion.getId());
				
				if(!tipobancoretencion.getVersionRow().equals(timestamp)) {	
					tipobancoretencion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipobancoretencion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoBancoRetencion()throws Exception {	
		
		if(tipobancoretencion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipobancoretencion.getIsDeleted() || (tipobancoretencion.getIsChanged()&&!tipobancoretencion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipobancoretencionDataAccess.getSetVersionRowTipoBancoRetencion(connexion,tipobancoretencion.getId());
			
			try {							
				if(!tipobancoretencion.getVersionRow().equals(timestamp)) {	
					tipobancoretencion.setVersionRow(timestamp);
				}
				
				tipobancoretencion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoBancoRetencionsWithConnection()throws Exception {	
		if(tipobancoretencions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoBancoRetencion tipobancoretencionAux:tipobancoretencions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipobancoretencionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipobancoretencionAux.getIsDeleted() || (tipobancoretencionAux.getIsChanged()&&!tipobancoretencionAux.getIsNew())) {
						
						timestamp=tipobancoretencionDataAccess.getSetVersionRowTipoBancoRetencion(connexion,tipobancoretencionAux.getId());
						
						if(!tipobancoretencion.getVersionRow().equals(timestamp)) {	
							tipobancoretencionAux.setVersionRow(timestamp);
						}
								
						tipobancoretencionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoBancoRetencions()throws Exception {	
		if(tipobancoretencions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoBancoRetencion tipobancoretencionAux:tipobancoretencions) {
					if(tipobancoretencionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipobancoretencionAux.getIsDeleted() || (tipobancoretencionAux.getIsChanged()&&!tipobancoretencionAux.getIsNew())) {
						
						timestamp=tipobancoretencionDataAccess.getSetVersionRowTipoBancoRetencion(connexion,tipobancoretencionAux.getId());
						
						if(!tipobancoretencionAux.getVersionRow().equals(timestamp)) {	
							tipobancoretencionAux.setVersionRow(timestamp);
						}
						
													
						tipobancoretencionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoBancoRetencionParameterReturnGeneral cargarCombosLoteForeignKeyTipoBancoRetencionWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoBancoRetencionParameterReturnGeneral  tipobancoretencionReturnGeneral =new TipoBancoRetencionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoBancoRetencionWithConnection");connexion.begin();
			
			tipobancoretencionReturnGeneral =new TipoBancoRetencionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipobancoretencionReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipobancoretencionReturnGeneral;
	}
	
	public TipoBancoRetencionParameterReturnGeneral cargarCombosLoteForeignKeyTipoBancoRetencion(String finalQueryGlobalEmpresa) throws Exception {
		TipoBancoRetencionParameterReturnGeneral  tipobancoretencionReturnGeneral =new TipoBancoRetencionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipobancoretencionReturnGeneral =new TipoBancoRetencionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipobancoretencionReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipobancoretencionReturnGeneral;
	}
	
	
	public void deepLoad(TipoBancoRetencion tipobancoretencion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoBancoRetencionLogicAdditional.updateTipoBancoRetencionToGet(tipobancoretencion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipobancoretencion.setEmpresa(tipobancoretencionDataAccess.getEmpresa(connexion,tipobancoretencion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipobancoretencion.setEmpresa(tipobancoretencionDataAccess.getEmpresa(connexion,tipobancoretencion));
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
			tipobancoretencion.setEmpresa(tipobancoretencionDataAccess.getEmpresa(connexion,tipobancoretencion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipobancoretencion.setEmpresa(tipobancoretencionDataAccess.getEmpresa(connexion,tipobancoretencion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipobancoretencion.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipobancoretencion.setEmpresa(tipobancoretencionDataAccess.getEmpresa(connexion,tipobancoretencion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipobancoretencion.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tipobancoretencion.setEmpresa(tipobancoretencionDataAccess.getEmpresa(connexion,tipobancoretencion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipobancoretencion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoBancoRetencion tipobancoretencion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoBancoRetencionLogicAdditional.updateTipoBancoRetencionToSave(tipobancoretencion,this.arrDatoGeneral);
			
TipoBancoRetencionDataAccess.save(tipobancoretencion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipobancoretencion.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipobancoretencion.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipobancoretencion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipobancoretencion.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipobancoretencion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipobancoretencion.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoBancoRetencion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipobancoretencion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(tipobancoretencion);
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
			this.deepLoad(this.tipobancoretencion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoBancoRetencion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipobancoretencions!=null) {
				for(TipoBancoRetencion tipobancoretencion:tipobancoretencions) {
					this.deepLoad(tipobancoretencion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(tipobancoretencions);
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
			if(tipobancoretencions!=null) {
				for(TipoBancoRetencion tipobancoretencion:tipobancoretencions) {
					this.deepLoad(tipobancoretencion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(tipobancoretencions);
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
			this.getNewConnexionToDeep(TipoBancoRetencion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipobancoretencion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoBancoRetencion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipobancoretencions!=null) {
				for(TipoBancoRetencion tipobancoretencion:tipobancoretencions) {
					this.deepSave(tipobancoretencion,isDeep,deepLoadType,clases);
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
			if(tipobancoretencions!=null) {
				for(TipoBancoRetencion tipobancoretencion:tipobancoretencions) {
					this.deepSave(tipobancoretencion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoBancoRetencionsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoBancoRetencionConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoBancoRetencionsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoBancoRetencionConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoBancoRetencionsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoBancoRetencionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoBancoRetencionsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoBancoRetencionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoBancoRetencionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoBancoRetencionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoBancoRetencionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoBancoRetencionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoBancoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipobancoretencions=tipobancoretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoBancoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoRetencion(this.tipobancoretencions);
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
			if(TipoBancoRetencionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoBancoRetencionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoBancoRetencion tipobancoretencion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoBancoRetencionConstantesFunciones.ISCONAUDITORIA) {
				if(tipobancoretencion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoBancoRetencionDataAccess.TABLENAME, tipobancoretencion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoBancoRetencionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoBancoRetencionLogic.registrarAuditoriaDetallesTipoBancoRetencion(connexion,tipobancoretencion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipobancoretencion.getIsDeleted()) {
					/*if(!tipobancoretencion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoBancoRetencionDataAccess.TABLENAME, tipobancoretencion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoBancoRetencionLogic.registrarAuditoriaDetallesTipoBancoRetencion(connexion,tipobancoretencion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoBancoRetencionDataAccess.TABLENAME, tipobancoretencion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipobancoretencion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoBancoRetencionDataAccess.TABLENAME, tipobancoretencion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoBancoRetencionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoBancoRetencionLogic.registrarAuditoriaDetallesTipoBancoRetencion(connexion,tipobancoretencion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoBancoRetencion(Connexion connexion,TipoBancoRetencion tipobancoretencion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipobancoretencion.getIsNew()||!tipobancoretencion.getid_empresa().equals(tipobancoretencion.getTipoBancoRetencionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipobancoretencion.getTipoBancoRetencionOriginal().getid_empresa()!=null)
				{
					strValorActual=tipobancoretencion.getTipoBancoRetencionOriginal().getid_empresa().toString();
				}
				if(tipobancoretencion.getid_empresa()!=null)
				{
					strValorNuevo=tipobancoretencion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoBancoRetencionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipobancoretencion.getIsNew()||!tipobancoretencion.getcodigo().equals(tipobancoretencion.getTipoBancoRetencionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipobancoretencion.getTipoBancoRetencionOriginal().getcodigo()!=null)
				{
					strValorActual=tipobancoretencion.getTipoBancoRetencionOriginal().getcodigo();
				}
				if(tipobancoretencion.getcodigo()!=null)
				{
					strValorNuevo=tipobancoretencion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoBancoRetencionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipobancoretencion.getIsNew()||!tipobancoretencion.getnombre().equals(tipobancoretencion.getTipoBancoRetencionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipobancoretencion.getTipoBancoRetencionOriginal().getnombre()!=null)
				{
					strValorActual=tipobancoretencion.getTipoBancoRetencionOriginal().getnombre();
				}
				if(tipobancoretencion.getnombre()!=null)
				{
					strValorNuevo=tipobancoretencion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoBancoRetencionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoBancoRetencionRelacionesWithConnection(TipoBancoRetencion tipobancoretencion) throws Exception {

		if(!tipobancoretencion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoBancoRetencionRelacionesBase(tipobancoretencion,true);
		}
	}

	public void saveTipoBancoRetencionRelaciones(TipoBancoRetencion tipobancoretencion)throws Exception {

		if(!tipobancoretencion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoBancoRetencionRelacionesBase(tipobancoretencion,false);
		}
	}

	public void saveTipoBancoRetencionRelacionesBase(TipoBancoRetencion tipobancoretencion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoBancoRetencion-saveRelacionesWithConnection");}
	

			this.setTipoBancoRetencion(tipobancoretencion);

			if(TipoBancoRetencionLogicAdditional.validarSaveRelaciones(tipobancoretencion,this)) {

				TipoBancoRetencionLogicAdditional.updateRelacionesToSave(tipobancoretencion,this);

				if((tipobancoretencion.getIsNew()||tipobancoretencion.getIsChanged())&&!tipobancoretencion.getIsDeleted()) {
					this.saveTipoBancoRetencion();
					this.saveTipoBancoRetencionRelacionesDetalles();

				} else if(tipobancoretencion.getIsDeleted()) {
					this.saveTipoBancoRetencionRelacionesDetalles();
					this.saveTipoBancoRetencion();
				}

				TipoBancoRetencionLogicAdditional.updateRelacionesToSaveAfter(tipobancoretencion,this);

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
	
	
	private void saveTipoBancoRetencionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoBancoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoBancoRetencionConstantesFunciones.getClassesForeignKeysOfTipoBancoRetencion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBancoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoBancoRetencionConstantesFunciones.getClassesRelationshipsOfTipoBancoRetencion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

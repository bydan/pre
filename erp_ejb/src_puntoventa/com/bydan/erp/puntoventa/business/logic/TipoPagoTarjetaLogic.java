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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.TipoPagoTarjetaConstantesFunciones;
import com.bydan.erp.puntoventa.util.TipoPagoTarjetaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TipoPagoTarjetaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.TipoPagoTarjeta;
//import com.bydan.erp.puntoventa.business.logic.TipoPagoTarjetaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoPagoTarjetaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoPagoTarjetaLogic.class);
	
	protected TipoPagoTarjetaDataAccess tipopagotarjetaDataAccess; 	
	protected TipoPagoTarjeta tipopagotarjeta;
	protected List<TipoPagoTarjeta> tipopagotarjetas;
	protected Object tipopagotarjetaObject;	
	protected List<Object> tipopagotarjetasObject;
	
	public static ClassValidator<TipoPagoTarjeta> tipopagotarjetaValidator = new ClassValidator<TipoPagoTarjeta>(TipoPagoTarjeta.class);	
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
	
	
	
	
	public  TipoPagoTarjetaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipopagotarjetaDataAccess = new TipoPagoTarjetaDataAccess();
			
			this.tipopagotarjetas= new ArrayList<TipoPagoTarjeta>();
			this.tipopagotarjeta= new TipoPagoTarjeta();
			
			this.tipopagotarjetaObject=new Object();
			this.tipopagotarjetasObject=new ArrayList<Object>();
				
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
			
			this.tipopagotarjetaDataAccess.setConnexionType(this.connexionType);
			this.tipopagotarjetaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoPagoTarjetaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipopagotarjetaDataAccess = new TipoPagoTarjetaDataAccess();
			this.tipopagotarjetas= new ArrayList<TipoPagoTarjeta>();
			this.tipopagotarjeta= new TipoPagoTarjeta();
			this.tipopagotarjetaObject=new Object();
			this.tipopagotarjetasObject=new ArrayList<Object>();
			
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
			
			this.tipopagotarjetaDataAccess.setConnexionType(this.connexionType);
			this.tipopagotarjetaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoPagoTarjeta getTipoPagoTarjeta() throws Exception {	
		//TipoPagoTarjetaLogicAdditional.checkTipoPagoTarjetaToGet(tipopagotarjeta,this.datosCliente,this.arrDatoGeneral);
		//TipoPagoTarjetaLogicAdditional.updateTipoPagoTarjetaToGet(tipopagotarjeta,this.arrDatoGeneral);
		
		return tipopagotarjeta;
	}
		
	public void setTipoPagoTarjeta(TipoPagoTarjeta newTipoPagoTarjeta) {
		this.tipopagotarjeta = newTipoPagoTarjeta;
	}
	
	public TipoPagoTarjetaDataAccess getTipoPagoTarjetaDataAccess() {
		return tipopagotarjetaDataAccess;
	}
	
	public void setTipoPagoTarjetaDataAccess(TipoPagoTarjetaDataAccess newtipopagotarjetaDataAccess) {
		this.tipopagotarjetaDataAccess = newtipopagotarjetaDataAccess;
	}
	
	public List<TipoPagoTarjeta> getTipoPagoTarjetas() throws Exception {		
		this.quitarTipoPagoTarjetasNulos();
		
		//TipoPagoTarjetaLogicAdditional.checkTipoPagoTarjetaToGets(tipopagotarjetas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoPagoTarjeta tipopagotarjetaLocal: tipopagotarjetas ) {
			//TipoPagoTarjetaLogicAdditional.updateTipoPagoTarjetaToGet(tipopagotarjetaLocal,this.arrDatoGeneral);
		}
		
		return tipopagotarjetas;
	}
	
	public void setTipoPagoTarjetas(List<TipoPagoTarjeta> newTipoPagoTarjetas) {
		this.tipopagotarjetas = newTipoPagoTarjetas;
	}
	
	public Object getTipoPagoTarjetaObject() {	
		this.tipopagotarjetaObject=this.tipopagotarjetaDataAccess.getEntityObject();
		return this.tipopagotarjetaObject;
	}
		
	public void setTipoPagoTarjetaObject(Object newTipoPagoTarjetaObject) {
		this.tipopagotarjetaObject = newTipoPagoTarjetaObject;
	}
	
	public List<Object> getTipoPagoTarjetasObject() {		
		this.tipopagotarjetasObject=this.tipopagotarjetaDataAccess.getEntitiesObject();
		return this.tipopagotarjetasObject;
	}
		
	public void setTipoPagoTarjetasObject(List<Object> newTipoPagoTarjetasObject) {
		this.tipopagotarjetasObject = newTipoPagoTarjetasObject;
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
		
		if(this.tipopagotarjetaDataAccess!=null) {
			this.tipopagotarjetaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipopagotarjetaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipopagotarjetaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipopagotarjeta = new  TipoPagoTarjeta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipopagotarjeta=tipopagotarjetaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipopagotarjeta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjeta);
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
		tipopagotarjeta = new  TipoPagoTarjeta();
		  		  
        try {
			
			tipopagotarjeta=tipopagotarjetaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipopagotarjeta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjeta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipopagotarjeta = new  TipoPagoTarjeta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipopagotarjeta=tipopagotarjetaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipopagotarjeta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjeta);
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
		tipopagotarjeta = new  TipoPagoTarjeta();
		  		  
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
		tipopagotarjeta = new  TipoPagoTarjeta();
		  		  
        try {
			
			tipopagotarjeta=tipopagotarjetaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipopagotarjeta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjeta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipopagotarjeta = new  TipoPagoTarjeta();
		  		  
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
		tipopagotarjeta = new  TipoPagoTarjeta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipopagotarjetaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipopagotarjeta = new  TipoPagoTarjeta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipopagotarjetaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipopagotarjeta = new  TipoPagoTarjeta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipopagotarjetaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipopagotarjeta = new  TipoPagoTarjeta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipopagotarjetaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipopagotarjeta = new  TipoPagoTarjeta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipopagotarjetaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipopagotarjeta = new  TipoPagoTarjeta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipopagotarjetaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipopagotarjetas = new  ArrayList<TipoPagoTarjeta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopagotarjetas=tipopagotarjetaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPagoTarjeta(tipopagotarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjetas);
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
		tipopagotarjetas = new  ArrayList<TipoPagoTarjeta>();
		  		  
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
		tipopagotarjetas = new  ArrayList<TipoPagoTarjeta>();
		  		  
        try {			
			TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopagotarjetas=tipopagotarjetaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoPagoTarjeta(tipopagotarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjetas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipopagotarjetas = new  ArrayList<TipoPagoTarjeta>();
		  		  
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
		tipopagotarjetas = new  ArrayList<TipoPagoTarjeta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopagotarjetas=tipopagotarjetaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPagoTarjeta(tipopagotarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjetas);
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
		tipopagotarjetas = new  ArrayList<TipoPagoTarjeta>();
		  		  
        try {
			TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopagotarjetas=tipopagotarjetaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPagoTarjeta(tipopagotarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjetas);
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
		tipopagotarjetas = new  ArrayList<TipoPagoTarjeta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopagotarjetas=tipopagotarjetaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPagoTarjeta(tipopagotarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjetas);
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
		tipopagotarjetas = new  ArrayList<TipoPagoTarjeta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopagotarjetas=tipopagotarjetaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPagoTarjeta(tipopagotarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjetas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipopagotarjeta = new  TipoPagoTarjeta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopagotarjeta=tipopagotarjetaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPagoTarjeta(tipopagotarjeta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjeta);
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
		tipopagotarjeta = new  TipoPagoTarjeta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopagotarjeta=tipopagotarjetaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPagoTarjeta(tipopagotarjeta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjeta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoPagoTarjetasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipopagotarjetas = new  ArrayList<TipoPagoTarjeta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-getTodosTipoPagoTarjetasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopagotarjetas=tipopagotarjetaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPagoTarjeta(tipopagotarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjetas);
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
	
	public  void  getTodosTipoPagoTarjetas(String sFinalQuery,Pagination pagination)throws Exception {
		tipopagotarjetas = new  ArrayList<TipoPagoTarjeta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopagotarjetas=tipopagotarjetaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPagoTarjeta(tipopagotarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjetas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoPagoTarjeta(TipoPagoTarjeta tipopagotarjeta) throws Exception {
		Boolean estaValidado=false;
		
		if(tipopagotarjeta.getIsNew() || tipopagotarjeta.getIsChanged()) { 
			this.invalidValues = tipopagotarjetaValidator.getInvalidValues(tipopagotarjeta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipopagotarjeta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoPagoTarjeta(List<TipoPagoTarjeta> TipoPagoTarjetas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoPagoTarjeta tipopagotarjetaLocal:tipopagotarjetas) {				
			estaValidadoObjeto=this.validarGuardarTipoPagoTarjeta(tipopagotarjetaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoPagoTarjeta(List<TipoPagoTarjeta> TipoPagoTarjetas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPagoTarjeta(tipopagotarjetas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoPagoTarjeta(TipoPagoTarjeta TipoPagoTarjeta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPagoTarjeta(tipopagotarjeta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoPagoTarjeta tipopagotarjeta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipopagotarjeta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoPagoTarjetaConstantesFunciones.getTipoPagoTarjetaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipopagotarjeta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoPagoTarjetaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoPagoTarjetaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoPagoTarjetaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-saveTipoPagoTarjetaWithConnection");connexion.begin();			
			
			//TipoPagoTarjetaLogicAdditional.checkTipoPagoTarjetaToSave(this.tipopagotarjeta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoPagoTarjetaLogicAdditional.updateTipoPagoTarjetaToSave(this.tipopagotarjeta,this.arrDatoGeneral);
			
			TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipopagotarjeta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoPagoTarjeta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPagoTarjeta(this.tipopagotarjeta)) {
				TipoPagoTarjetaDataAccess.save(this.tipopagotarjeta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipopagotarjeta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoPagoTarjetaLogicAdditional.checkTipoPagoTarjetaToSaveAfter(this.tipopagotarjeta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPagoTarjeta();
			
			connexion.commit();			
			
			if(this.tipopagotarjeta.getIsDeleted()) {
				this.tipopagotarjeta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoPagoTarjeta()throws Exception {	
		try {	
			
			//TipoPagoTarjetaLogicAdditional.checkTipoPagoTarjetaToSave(this.tipopagotarjeta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoPagoTarjetaLogicAdditional.updateTipoPagoTarjetaToSave(this.tipopagotarjeta,this.arrDatoGeneral);
			
			TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipopagotarjeta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPagoTarjeta(this.tipopagotarjeta)) {			
				TipoPagoTarjetaDataAccess.save(this.tipopagotarjeta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipopagotarjeta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoPagoTarjetaLogicAdditional.checkTipoPagoTarjetaToSaveAfter(this.tipopagotarjeta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipopagotarjeta.getIsDeleted()) {
				this.tipopagotarjeta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoPagoTarjetasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-saveTipoPagoTarjetasWithConnection");connexion.begin();			
			
			//TipoPagoTarjetaLogicAdditional.checkTipoPagoTarjetaToSaves(tipopagotarjetas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoPagoTarjetas();
			
			Boolean validadoTodosTipoPagoTarjeta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPagoTarjeta tipopagotarjetaLocal:tipopagotarjetas) {		
				if(tipopagotarjetaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoPagoTarjetaLogicAdditional.updateTipoPagoTarjetaToSave(tipopagotarjetaLocal,this.arrDatoGeneral);
	        	
				TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipopagotarjetaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPagoTarjeta(tipopagotarjetaLocal)) {
					TipoPagoTarjetaDataAccess.save(tipopagotarjetaLocal, connexion);				
				} else {
					validadoTodosTipoPagoTarjeta=false;
				}
			}
			
			if(!validadoTodosTipoPagoTarjeta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoPagoTarjetaLogicAdditional.checkTipoPagoTarjetaToSavesAfter(tipopagotarjetas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPagoTarjetas();
			
			connexion.commit();		
			
			this.quitarTipoPagoTarjetasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoPagoTarjetas()throws Exception {				
		 try {	
			//TipoPagoTarjetaLogicAdditional.checkTipoPagoTarjetaToSaves(tipopagotarjetas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoPagoTarjeta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPagoTarjeta tipopagotarjetaLocal:tipopagotarjetas) {				
				if(tipopagotarjetaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoPagoTarjetaLogicAdditional.updateTipoPagoTarjetaToSave(tipopagotarjetaLocal,this.arrDatoGeneral);
	        	
				TipoPagoTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipopagotarjetaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPagoTarjeta(tipopagotarjetaLocal)) {				
					TipoPagoTarjetaDataAccess.save(tipopagotarjetaLocal, connexion);				
				} else {
					validadoTodosTipoPagoTarjeta=false;
				}
			}
			
			if(!validadoTodosTipoPagoTarjeta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoPagoTarjetaLogicAdditional.checkTipoPagoTarjetaToSavesAfter(tipopagotarjetas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoPagoTarjetasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPagoTarjetaParameterReturnGeneral procesarAccionTipoPagoTarjetas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPagoTarjeta> tipopagotarjetas,TipoPagoTarjetaParameterReturnGeneral tipopagotarjetaParameterGeneral)throws Exception {
		 try {	
			TipoPagoTarjetaParameterReturnGeneral tipopagotarjetaReturnGeneral=new TipoPagoTarjetaParameterReturnGeneral();
	
			
			return tipopagotarjetaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPagoTarjetaParameterReturnGeneral procesarAccionTipoPagoTarjetasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPagoTarjeta> tipopagotarjetas,TipoPagoTarjetaParameterReturnGeneral tipopagotarjetaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-procesarAccionTipoPagoTarjetasWithConnection");connexion.begin();			
			
			TipoPagoTarjetaParameterReturnGeneral tipopagotarjetaReturnGeneral=new TipoPagoTarjetaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipopagotarjetaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPagoTarjetaParameterReturnGeneral procesarEventosTipoPagoTarjetas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPagoTarjeta> tipopagotarjetas,TipoPagoTarjeta tipopagotarjeta,TipoPagoTarjetaParameterReturnGeneral tipopagotarjetaParameterGeneral,Boolean isEsNuevoTipoPagoTarjeta,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoPagoTarjetaParameterReturnGeneral tipopagotarjetaReturnGeneral=new TipoPagoTarjetaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipopagotarjetaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipopagotarjetaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoPagoTarjetaParameterReturnGeneral procesarEventosTipoPagoTarjetasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPagoTarjeta> tipopagotarjetas,TipoPagoTarjeta tipopagotarjeta,TipoPagoTarjetaParameterReturnGeneral tipopagotarjetaParameterGeneral,Boolean isEsNuevoTipoPagoTarjeta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-procesarEventosTipoPagoTarjetasWithConnection");connexion.begin();			
			
			TipoPagoTarjetaParameterReturnGeneral tipopagotarjetaReturnGeneral=new TipoPagoTarjetaParameterReturnGeneral();
	
			tipopagotarjetaReturnGeneral.setTipoPagoTarjeta(tipopagotarjeta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipopagotarjetaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipopagotarjetaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPagoTarjetaParameterReturnGeneral procesarImportacionTipoPagoTarjetasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoPagoTarjetaParameterReturnGeneral tipopagotarjetaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-procesarImportacionTipoPagoTarjetasWithConnection");connexion.begin();			
			
			TipoPagoTarjetaParameterReturnGeneral tipopagotarjetaReturnGeneral=new TipoPagoTarjetaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipopagotarjetas=new ArrayList<TipoPagoTarjeta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipopagotarjeta=new TipoPagoTarjeta();
				
				
				if(conColumnasBase) {this.tipopagotarjeta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipopagotarjeta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipopagotarjeta.setnombre(arrColumnas[iColumn++]);
				this.tipopagotarjeta.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipopagotarjetas.add(this.tipopagotarjeta);
			}
			
			this.saveTipoPagoTarjetas();
			
			this.connexion.commit();
			
			tipopagotarjetaReturnGeneral.setConRetornoEstaProcesado(true);
			tipopagotarjetaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipopagotarjetaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoPagoTarjetasEliminados() throws Exception {				
		
		List<TipoPagoTarjeta> tipopagotarjetasAux= new ArrayList<TipoPagoTarjeta>();
		
		for(TipoPagoTarjeta tipopagotarjeta:tipopagotarjetas) {
			if(!tipopagotarjeta.getIsDeleted()) {
				tipopagotarjetasAux.add(tipopagotarjeta);
			}
		}
		
		tipopagotarjetas=tipopagotarjetasAux;
	}
	
	public void quitarTipoPagoTarjetasNulos() throws Exception {				
		
		List<TipoPagoTarjeta> tipopagotarjetasAux= new ArrayList<TipoPagoTarjeta>();
		
		for(TipoPagoTarjeta tipopagotarjeta : this.tipopagotarjetas) {
			if(tipopagotarjeta==null) {
				tipopagotarjetasAux.add(tipopagotarjeta);
			}
		}
		
		//this.tipopagotarjetas=tipopagotarjetasAux;
		
		this.tipopagotarjetas.removeAll(tipopagotarjetasAux);
	}
	
	public void getSetVersionRowTipoPagoTarjetaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipopagotarjeta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipopagotarjeta.getIsDeleted() || (tipopagotarjeta.getIsChanged()&&!tipopagotarjeta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipopagotarjetaDataAccess.getSetVersionRowTipoPagoTarjeta(connexion,tipopagotarjeta.getId());
				
				if(!tipopagotarjeta.getVersionRow().equals(timestamp)) {	
					tipopagotarjeta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipopagotarjeta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoPagoTarjeta()throws Exception {	
		
		if(tipopagotarjeta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipopagotarjeta.getIsDeleted() || (tipopagotarjeta.getIsChanged()&&!tipopagotarjeta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipopagotarjetaDataAccess.getSetVersionRowTipoPagoTarjeta(connexion,tipopagotarjeta.getId());
			
			try {							
				if(!tipopagotarjeta.getVersionRow().equals(timestamp)) {	
					tipopagotarjeta.setVersionRow(timestamp);
				}
				
				tipopagotarjeta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoPagoTarjetasWithConnection()throws Exception {	
		if(tipopagotarjetas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoPagoTarjeta tipopagotarjetaAux:tipopagotarjetas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipopagotarjetaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipopagotarjetaAux.getIsDeleted() || (tipopagotarjetaAux.getIsChanged()&&!tipopagotarjetaAux.getIsNew())) {
						
						timestamp=tipopagotarjetaDataAccess.getSetVersionRowTipoPagoTarjeta(connexion,tipopagotarjetaAux.getId());
						
						if(!tipopagotarjeta.getVersionRow().equals(timestamp)) {	
							tipopagotarjetaAux.setVersionRow(timestamp);
						}
								
						tipopagotarjetaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoPagoTarjetas()throws Exception {	
		if(tipopagotarjetas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoPagoTarjeta tipopagotarjetaAux:tipopagotarjetas) {
					if(tipopagotarjetaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipopagotarjetaAux.getIsDeleted() || (tipopagotarjetaAux.getIsChanged()&&!tipopagotarjetaAux.getIsNew())) {
						
						timestamp=tipopagotarjetaDataAccess.getSetVersionRowTipoPagoTarjeta(connexion,tipopagotarjetaAux.getId());
						
						if(!tipopagotarjetaAux.getVersionRow().equals(timestamp)) {	
							tipopagotarjetaAux.setVersionRow(timestamp);
						}
						
													
						tipopagotarjetaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoPagoTarjetaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic=new FormaPagoPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPagoTarjeta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoPagoTarjetaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormaPagoPuntoVenta.class));
											
			

			formapagopuntoventaLogic.setConnexion(this.getConnexion());
			formapagopuntoventaLogic.setDatosCliente(this.datosCliente);
			formapagopuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoPagoTarjeta tipopagotarjeta:this.tipopagotarjetas) {
				

				classes=new ArrayList<Classe>();
				classes=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				formapagopuntoventaLogic.setFormaPagoPuntoVentas(tipopagotarjeta.formapagopuntoventas);
				formapagopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoPagoTarjeta tipopagotarjeta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoPagoTarjetaLogicAdditional.updateTipoPagoTarjetaToGet(tipopagotarjeta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipopagotarjeta.setFormaPagoPuntoVentas(tipopagotarjetaDataAccess.getFormaPagoPuntoVentas(connexion,tipopagotarjeta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipopagotarjeta.setFormaPagoPuntoVentas(tipopagotarjetaDataAccess.getFormaPagoPuntoVentas(connexion,tipopagotarjeta));

				if(this.isConDeep) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(this.connexion);
					formapagopuntoventaLogic.setFormaPagoPuntoVentas(tipopagotarjeta.getFormaPagoPuntoVentas());
					ArrayList<Classe> classesLocal=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					formapagopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
					tipopagotarjeta.setFormaPagoPuntoVentas(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			tipopagotarjeta.setFormaPagoPuntoVentas(tipopagotarjetaDataAccess.getFormaPagoPuntoVentas(connexion,tipopagotarjeta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipopagotarjeta.setFormaPagoPuntoVentas(tipopagotarjetaDataAccess.getFormaPagoPuntoVentas(connexion,tipopagotarjeta));

		for(FormaPagoPuntoVenta formapagopuntoventa:tipopagotarjeta.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipopagotarjeta.setFormaPagoPuntoVentas(tipopagotarjetaDataAccess.getFormaPagoPuntoVentas(connexion,tipopagotarjeta));

				for(FormaPagoPuntoVenta formapagopuntoventa:tipopagotarjeta.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			tipopagotarjeta.setFormaPagoPuntoVentas(tipopagotarjetaDataAccess.getFormaPagoPuntoVentas(connexion,tipopagotarjeta));

			for(FormaPagoPuntoVenta formapagopuntoventa:tipopagotarjeta.getFormaPagoPuntoVentas()) {
				FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
				formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoPagoTarjeta tipopagotarjeta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoPagoTarjeta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipopagotarjeta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(tipopagotarjeta);
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
			this.deepLoad(this.tipopagotarjeta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(this.tipopagotarjeta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoPagoTarjeta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipopagotarjetas!=null) {
				for(TipoPagoTarjeta tipopagotarjeta:tipopagotarjetas) {
					this.deepLoad(tipopagotarjeta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(tipopagotarjetas);
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
			if(tipopagotarjetas!=null) {
				for(TipoPagoTarjeta tipopagotarjeta:tipopagotarjetas) {
					this.deepLoad(tipopagotarjeta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoPagoTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPagoTarjeta(tipopagotarjetas);
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
			if(TipoPagoTarjetaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPagoTarjetaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoPagoTarjeta tipopagotarjeta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoPagoTarjetaConstantesFunciones.ISCONAUDITORIA) {
				if(tipopagotarjeta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPagoTarjetaDataAccess.TABLENAME, tipopagotarjeta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPagoTarjetaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPagoTarjetaLogic.registrarAuditoriaDetallesTipoPagoTarjeta(connexion,tipopagotarjeta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipopagotarjeta.getIsDeleted()) {
					/*if(!tipopagotarjeta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoPagoTarjetaDataAccess.TABLENAME, tipopagotarjeta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoPagoTarjetaLogic.registrarAuditoriaDetallesTipoPagoTarjeta(connexion,tipopagotarjeta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPagoTarjetaDataAccess.TABLENAME, tipopagotarjeta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipopagotarjeta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPagoTarjetaDataAccess.TABLENAME, tipopagotarjeta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPagoTarjetaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPagoTarjetaLogic.registrarAuditoriaDetallesTipoPagoTarjeta(connexion,tipopagotarjeta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoPagoTarjeta(Connexion connexion,TipoPagoTarjeta tipopagotarjeta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipopagotarjeta.getIsNew()||!tipopagotarjeta.getnombre().equals(tipopagotarjeta.getTipoPagoTarjetaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipopagotarjeta.getTipoPagoTarjetaOriginal().getnombre()!=null)
				{
					strValorActual=tipopagotarjeta.getTipoPagoTarjetaOriginal().getnombre();
				}
				if(tipopagotarjeta.getnombre()!=null)
				{
					strValorNuevo=tipopagotarjeta.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPagoTarjetaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipopagotarjeta.getIsNew()||!tipopagotarjeta.getdescripcion().equals(tipopagotarjeta.getTipoPagoTarjetaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipopagotarjeta.getTipoPagoTarjetaOriginal().getdescripcion()!=null)
				{
					strValorActual=tipopagotarjeta.getTipoPagoTarjetaOriginal().getdescripcion();
				}
				if(tipopagotarjeta.getdescripcion()!=null)
				{
					strValorNuevo=tipopagotarjeta.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPagoTarjetaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPagoTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPagoTarjetaConstantesFunciones.getClassesForeignKeysOfTipoPagoTarjeta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPagoTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPagoTarjetaConstantesFunciones.getClassesRelationshipsOfTipoPagoTarjeta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

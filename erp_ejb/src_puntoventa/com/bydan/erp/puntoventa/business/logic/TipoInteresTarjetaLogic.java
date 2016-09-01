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
import com.bydan.erp.puntoventa.util.TipoInteresTarjetaConstantesFunciones;
import com.bydan.erp.puntoventa.util.TipoInteresTarjetaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TipoInteresTarjetaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.TipoInteresTarjeta;
//import com.bydan.erp.puntoventa.business.logic.TipoInteresTarjetaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoInteresTarjetaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoInteresTarjetaLogic.class);
	
	protected TipoInteresTarjetaDataAccess tipointerestarjetaDataAccess; 	
	protected TipoInteresTarjeta tipointerestarjeta;
	protected List<TipoInteresTarjeta> tipointerestarjetas;
	protected Object tipointerestarjetaObject;	
	protected List<Object> tipointerestarjetasObject;
	
	public static ClassValidator<TipoInteresTarjeta> tipointerestarjetaValidator = new ClassValidator<TipoInteresTarjeta>(TipoInteresTarjeta.class);	
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
	
	
	
	
	public  TipoInteresTarjetaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipointerestarjetaDataAccess = new TipoInteresTarjetaDataAccess();
			
			this.tipointerestarjetas= new ArrayList<TipoInteresTarjeta>();
			this.tipointerestarjeta= new TipoInteresTarjeta();
			
			this.tipointerestarjetaObject=new Object();
			this.tipointerestarjetasObject=new ArrayList<Object>();
				
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
			
			this.tipointerestarjetaDataAccess.setConnexionType(this.connexionType);
			this.tipointerestarjetaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoInteresTarjetaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipointerestarjetaDataAccess = new TipoInteresTarjetaDataAccess();
			this.tipointerestarjetas= new ArrayList<TipoInteresTarjeta>();
			this.tipointerestarjeta= new TipoInteresTarjeta();
			this.tipointerestarjetaObject=new Object();
			this.tipointerestarjetasObject=new ArrayList<Object>();
			
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
			
			this.tipointerestarjetaDataAccess.setConnexionType(this.connexionType);
			this.tipointerestarjetaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoInteresTarjeta getTipoInteresTarjeta() throws Exception {	
		//TipoInteresTarjetaLogicAdditional.checkTipoInteresTarjetaToGet(tipointerestarjeta,this.datosCliente,this.arrDatoGeneral);
		//TipoInteresTarjetaLogicAdditional.updateTipoInteresTarjetaToGet(tipointerestarjeta,this.arrDatoGeneral);
		
		return tipointerestarjeta;
	}
		
	public void setTipoInteresTarjeta(TipoInteresTarjeta newTipoInteresTarjeta) {
		this.tipointerestarjeta = newTipoInteresTarjeta;
	}
	
	public TipoInteresTarjetaDataAccess getTipoInteresTarjetaDataAccess() {
		return tipointerestarjetaDataAccess;
	}
	
	public void setTipoInteresTarjetaDataAccess(TipoInteresTarjetaDataAccess newtipointerestarjetaDataAccess) {
		this.tipointerestarjetaDataAccess = newtipointerestarjetaDataAccess;
	}
	
	public List<TipoInteresTarjeta> getTipoInteresTarjetas() throws Exception {		
		this.quitarTipoInteresTarjetasNulos();
		
		//TipoInteresTarjetaLogicAdditional.checkTipoInteresTarjetaToGets(tipointerestarjetas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoInteresTarjeta tipointerestarjetaLocal: tipointerestarjetas ) {
			//TipoInteresTarjetaLogicAdditional.updateTipoInteresTarjetaToGet(tipointerestarjetaLocal,this.arrDatoGeneral);
		}
		
		return tipointerestarjetas;
	}
	
	public void setTipoInteresTarjetas(List<TipoInteresTarjeta> newTipoInteresTarjetas) {
		this.tipointerestarjetas = newTipoInteresTarjetas;
	}
	
	public Object getTipoInteresTarjetaObject() {	
		this.tipointerestarjetaObject=this.tipointerestarjetaDataAccess.getEntityObject();
		return this.tipointerestarjetaObject;
	}
		
	public void setTipoInteresTarjetaObject(Object newTipoInteresTarjetaObject) {
		this.tipointerestarjetaObject = newTipoInteresTarjetaObject;
	}
	
	public List<Object> getTipoInteresTarjetasObject() {		
		this.tipointerestarjetasObject=this.tipointerestarjetaDataAccess.getEntitiesObject();
		return this.tipointerestarjetasObject;
	}
		
	public void setTipoInteresTarjetasObject(List<Object> newTipoInteresTarjetasObject) {
		this.tipointerestarjetasObject = newTipoInteresTarjetasObject;
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
		
		if(this.tipointerestarjetaDataAccess!=null) {
			this.tipointerestarjetaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipointerestarjetaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipointerestarjetaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipointerestarjeta = new  TipoInteresTarjeta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipointerestarjeta=tipointerestarjetaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipointerestarjeta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjeta);
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
		tipointerestarjeta = new  TipoInteresTarjeta();
		  		  
        try {
			
			tipointerestarjeta=tipointerestarjetaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipointerestarjeta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjeta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipointerestarjeta = new  TipoInteresTarjeta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipointerestarjeta=tipointerestarjetaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipointerestarjeta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjeta);
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
		tipointerestarjeta = new  TipoInteresTarjeta();
		  		  
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
		tipointerestarjeta = new  TipoInteresTarjeta();
		  		  
        try {
			
			tipointerestarjeta=tipointerestarjetaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipointerestarjeta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjeta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipointerestarjeta = new  TipoInteresTarjeta();
		  		  
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
		tipointerestarjeta = new  TipoInteresTarjeta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipointerestarjetaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipointerestarjeta = new  TipoInteresTarjeta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipointerestarjetaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipointerestarjeta = new  TipoInteresTarjeta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipointerestarjetaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipointerestarjeta = new  TipoInteresTarjeta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipointerestarjetaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipointerestarjeta = new  TipoInteresTarjeta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipointerestarjetaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipointerestarjeta = new  TipoInteresTarjeta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipointerestarjetaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipointerestarjetas = new  ArrayList<TipoInteresTarjeta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointerestarjetas=tipointerestarjetaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInteresTarjeta(tipointerestarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjetas);
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
		tipointerestarjetas = new  ArrayList<TipoInteresTarjeta>();
		  		  
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
		tipointerestarjetas = new  ArrayList<TipoInteresTarjeta>();
		  		  
        try {			
			TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointerestarjetas=tipointerestarjetaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoInteresTarjeta(tipointerestarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjetas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipointerestarjetas = new  ArrayList<TipoInteresTarjeta>();
		  		  
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
		tipointerestarjetas = new  ArrayList<TipoInteresTarjeta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointerestarjetas=tipointerestarjetaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInteresTarjeta(tipointerestarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjetas);
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
		tipointerestarjetas = new  ArrayList<TipoInteresTarjeta>();
		  		  
        try {
			TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointerestarjetas=tipointerestarjetaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInteresTarjeta(tipointerestarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjetas);
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
		tipointerestarjetas = new  ArrayList<TipoInteresTarjeta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointerestarjetas=tipointerestarjetaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInteresTarjeta(tipointerestarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjetas);
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
		tipointerestarjetas = new  ArrayList<TipoInteresTarjeta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointerestarjetas=tipointerestarjetaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInteresTarjeta(tipointerestarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjetas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipointerestarjeta = new  TipoInteresTarjeta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointerestarjeta=tipointerestarjetaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInteresTarjeta(tipointerestarjeta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjeta);
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
		tipointerestarjeta = new  TipoInteresTarjeta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointerestarjeta=tipointerestarjetaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInteresTarjeta(tipointerestarjeta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjeta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoInteresTarjetasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipointerestarjetas = new  ArrayList<TipoInteresTarjeta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-getTodosTipoInteresTarjetasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointerestarjetas=tipointerestarjetaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoInteresTarjeta(tipointerestarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjetas);
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
	
	public  void  getTodosTipoInteresTarjetas(String sFinalQuery,Pagination pagination)throws Exception {
		tipointerestarjetas = new  ArrayList<TipoInteresTarjeta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointerestarjetas=tipointerestarjetaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoInteresTarjeta(tipointerestarjetas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjetas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoInteresTarjeta(TipoInteresTarjeta tipointerestarjeta) throws Exception {
		Boolean estaValidado=false;
		
		if(tipointerestarjeta.getIsNew() || tipointerestarjeta.getIsChanged()) { 
			this.invalidValues = tipointerestarjetaValidator.getInvalidValues(tipointerestarjeta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipointerestarjeta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoInteresTarjeta(List<TipoInteresTarjeta> TipoInteresTarjetas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoInteresTarjeta tipointerestarjetaLocal:tipointerestarjetas) {				
			estaValidadoObjeto=this.validarGuardarTipoInteresTarjeta(tipointerestarjetaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoInteresTarjeta(List<TipoInteresTarjeta> TipoInteresTarjetas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoInteresTarjeta(tipointerestarjetas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoInteresTarjeta(TipoInteresTarjeta TipoInteresTarjeta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoInteresTarjeta(tipointerestarjeta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoInteresTarjeta tipointerestarjeta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipointerestarjeta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoInteresTarjetaConstantesFunciones.getTipoInteresTarjetaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipointerestarjeta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoInteresTarjetaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoInteresTarjetaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoInteresTarjetaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-saveTipoInteresTarjetaWithConnection");connexion.begin();			
			
			//TipoInteresTarjetaLogicAdditional.checkTipoInteresTarjetaToSave(this.tipointerestarjeta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoInteresTarjetaLogicAdditional.updateTipoInteresTarjetaToSave(this.tipointerestarjeta,this.arrDatoGeneral);
			
			TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipointerestarjeta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoInteresTarjeta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoInteresTarjeta(this.tipointerestarjeta)) {
				TipoInteresTarjetaDataAccess.save(this.tipointerestarjeta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipointerestarjeta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoInteresTarjetaLogicAdditional.checkTipoInteresTarjetaToSaveAfter(this.tipointerestarjeta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoInteresTarjeta();
			
			connexion.commit();			
			
			if(this.tipointerestarjeta.getIsDeleted()) {
				this.tipointerestarjeta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoInteresTarjeta()throws Exception {	
		try {	
			
			//TipoInteresTarjetaLogicAdditional.checkTipoInteresTarjetaToSave(this.tipointerestarjeta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoInteresTarjetaLogicAdditional.updateTipoInteresTarjetaToSave(this.tipointerestarjeta,this.arrDatoGeneral);
			
			TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipointerestarjeta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoInteresTarjeta(this.tipointerestarjeta)) {			
				TipoInteresTarjetaDataAccess.save(this.tipointerestarjeta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipointerestarjeta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoInteresTarjetaLogicAdditional.checkTipoInteresTarjetaToSaveAfter(this.tipointerestarjeta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipointerestarjeta.getIsDeleted()) {
				this.tipointerestarjeta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoInteresTarjetasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-saveTipoInteresTarjetasWithConnection");connexion.begin();			
			
			//TipoInteresTarjetaLogicAdditional.checkTipoInteresTarjetaToSaves(tipointerestarjetas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoInteresTarjetas();
			
			Boolean validadoTodosTipoInteresTarjeta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoInteresTarjeta tipointerestarjetaLocal:tipointerestarjetas) {		
				if(tipointerestarjetaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoInteresTarjetaLogicAdditional.updateTipoInteresTarjetaToSave(tipointerestarjetaLocal,this.arrDatoGeneral);
	        	
				TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipointerestarjetaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoInteresTarjeta(tipointerestarjetaLocal)) {
					TipoInteresTarjetaDataAccess.save(tipointerestarjetaLocal, connexion);				
				} else {
					validadoTodosTipoInteresTarjeta=false;
				}
			}
			
			if(!validadoTodosTipoInteresTarjeta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoInteresTarjetaLogicAdditional.checkTipoInteresTarjetaToSavesAfter(tipointerestarjetas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoInteresTarjetas();
			
			connexion.commit();		
			
			this.quitarTipoInteresTarjetasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoInteresTarjetas()throws Exception {				
		 try {	
			//TipoInteresTarjetaLogicAdditional.checkTipoInteresTarjetaToSaves(tipointerestarjetas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoInteresTarjeta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoInteresTarjeta tipointerestarjetaLocal:tipointerestarjetas) {				
				if(tipointerestarjetaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoInteresTarjetaLogicAdditional.updateTipoInteresTarjetaToSave(tipointerestarjetaLocal,this.arrDatoGeneral);
	        	
				TipoInteresTarjetaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipointerestarjetaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoInteresTarjeta(tipointerestarjetaLocal)) {				
					TipoInteresTarjetaDataAccess.save(tipointerestarjetaLocal, connexion);				
				} else {
					validadoTodosTipoInteresTarjeta=false;
				}
			}
			
			if(!validadoTodosTipoInteresTarjeta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoInteresTarjetaLogicAdditional.checkTipoInteresTarjetaToSavesAfter(tipointerestarjetas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoInteresTarjetasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoInteresTarjetaParameterReturnGeneral procesarAccionTipoInteresTarjetas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoInteresTarjeta> tipointerestarjetas,TipoInteresTarjetaParameterReturnGeneral tipointerestarjetaParameterGeneral)throws Exception {
		 try {	
			TipoInteresTarjetaParameterReturnGeneral tipointerestarjetaReturnGeneral=new TipoInteresTarjetaParameterReturnGeneral();
	
			
			return tipointerestarjetaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoInteresTarjetaParameterReturnGeneral procesarAccionTipoInteresTarjetasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoInteresTarjeta> tipointerestarjetas,TipoInteresTarjetaParameterReturnGeneral tipointerestarjetaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-procesarAccionTipoInteresTarjetasWithConnection");connexion.begin();			
			
			TipoInteresTarjetaParameterReturnGeneral tipointerestarjetaReturnGeneral=new TipoInteresTarjetaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipointerestarjetaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoInteresTarjetaParameterReturnGeneral procesarEventosTipoInteresTarjetas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoInteresTarjeta> tipointerestarjetas,TipoInteresTarjeta tipointerestarjeta,TipoInteresTarjetaParameterReturnGeneral tipointerestarjetaParameterGeneral,Boolean isEsNuevoTipoInteresTarjeta,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoInteresTarjetaParameterReturnGeneral tipointerestarjetaReturnGeneral=new TipoInteresTarjetaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipointerestarjetaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipointerestarjetaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoInteresTarjetaParameterReturnGeneral procesarEventosTipoInteresTarjetasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoInteresTarjeta> tipointerestarjetas,TipoInteresTarjeta tipointerestarjeta,TipoInteresTarjetaParameterReturnGeneral tipointerestarjetaParameterGeneral,Boolean isEsNuevoTipoInteresTarjeta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-procesarEventosTipoInteresTarjetasWithConnection");connexion.begin();			
			
			TipoInteresTarjetaParameterReturnGeneral tipointerestarjetaReturnGeneral=new TipoInteresTarjetaParameterReturnGeneral();
	
			tipointerestarjetaReturnGeneral.setTipoInteresTarjeta(tipointerestarjeta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipointerestarjetaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipointerestarjetaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoInteresTarjetaParameterReturnGeneral procesarImportacionTipoInteresTarjetasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoInteresTarjetaParameterReturnGeneral tipointerestarjetaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-procesarImportacionTipoInteresTarjetasWithConnection");connexion.begin();			
			
			TipoInteresTarjetaParameterReturnGeneral tipointerestarjetaReturnGeneral=new TipoInteresTarjetaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipointerestarjetas=new ArrayList<TipoInteresTarjeta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipointerestarjeta=new TipoInteresTarjeta();
				
				
				if(conColumnasBase) {this.tipointerestarjeta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipointerestarjeta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipointerestarjeta.setnombre(arrColumnas[iColumn++]);
				this.tipointerestarjeta.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipointerestarjetas.add(this.tipointerestarjeta);
			}
			
			this.saveTipoInteresTarjetas();
			
			this.connexion.commit();
			
			tipointerestarjetaReturnGeneral.setConRetornoEstaProcesado(true);
			tipointerestarjetaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipointerestarjetaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoInteresTarjetasEliminados() throws Exception {				
		
		List<TipoInteresTarjeta> tipointerestarjetasAux= new ArrayList<TipoInteresTarjeta>();
		
		for(TipoInteresTarjeta tipointerestarjeta:tipointerestarjetas) {
			if(!tipointerestarjeta.getIsDeleted()) {
				tipointerestarjetasAux.add(tipointerestarjeta);
			}
		}
		
		tipointerestarjetas=tipointerestarjetasAux;
	}
	
	public void quitarTipoInteresTarjetasNulos() throws Exception {				
		
		List<TipoInteresTarjeta> tipointerestarjetasAux= new ArrayList<TipoInteresTarjeta>();
		
		for(TipoInteresTarjeta tipointerestarjeta : this.tipointerestarjetas) {
			if(tipointerestarjeta==null) {
				tipointerestarjetasAux.add(tipointerestarjeta);
			}
		}
		
		//this.tipointerestarjetas=tipointerestarjetasAux;
		
		this.tipointerestarjetas.removeAll(tipointerestarjetasAux);
	}
	
	public void getSetVersionRowTipoInteresTarjetaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipointerestarjeta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipointerestarjeta.getIsDeleted() || (tipointerestarjeta.getIsChanged()&&!tipointerestarjeta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipointerestarjetaDataAccess.getSetVersionRowTipoInteresTarjeta(connexion,tipointerestarjeta.getId());
				
				if(!tipointerestarjeta.getVersionRow().equals(timestamp)) {	
					tipointerestarjeta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipointerestarjeta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoInteresTarjeta()throws Exception {	
		
		if(tipointerestarjeta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipointerestarjeta.getIsDeleted() || (tipointerestarjeta.getIsChanged()&&!tipointerestarjeta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipointerestarjetaDataAccess.getSetVersionRowTipoInteresTarjeta(connexion,tipointerestarjeta.getId());
			
			try {							
				if(!tipointerestarjeta.getVersionRow().equals(timestamp)) {	
					tipointerestarjeta.setVersionRow(timestamp);
				}
				
				tipointerestarjeta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoInteresTarjetasWithConnection()throws Exception {	
		if(tipointerestarjetas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoInteresTarjeta tipointerestarjetaAux:tipointerestarjetas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipointerestarjetaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipointerestarjetaAux.getIsDeleted() || (tipointerestarjetaAux.getIsChanged()&&!tipointerestarjetaAux.getIsNew())) {
						
						timestamp=tipointerestarjetaDataAccess.getSetVersionRowTipoInteresTarjeta(connexion,tipointerestarjetaAux.getId());
						
						if(!tipointerestarjeta.getVersionRow().equals(timestamp)) {	
							tipointerestarjetaAux.setVersionRow(timestamp);
						}
								
						tipointerestarjetaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoInteresTarjetas()throws Exception {	
		if(tipointerestarjetas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoInteresTarjeta tipointerestarjetaAux:tipointerestarjetas) {
					if(tipointerestarjetaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipointerestarjetaAux.getIsDeleted() || (tipointerestarjetaAux.getIsChanged()&&!tipointerestarjetaAux.getIsNew())) {
						
						timestamp=tipointerestarjetaDataAccess.getSetVersionRowTipoInteresTarjeta(connexion,tipointerestarjetaAux.getId());
						
						if(!tipointerestarjetaAux.getVersionRow().equals(timestamp)) {	
							tipointerestarjetaAux.setVersionRow(timestamp);
						}
						
													
						tipointerestarjetaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoInteresTarjetaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic=new FormaPagoPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInteresTarjeta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoInteresTarjetaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormaPagoPuntoVenta.class));
											
			

			formapagopuntoventaLogic.setConnexion(this.getConnexion());
			formapagopuntoventaLogic.setDatosCliente(this.datosCliente);
			formapagopuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoInteresTarjeta tipointerestarjeta:this.tipointerestarjetas) {
				

				classes=new ArrayList<Classe>();
				classes=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				formapagopuntoventaLogic.setFormaPagoPuntoVentas(tipointerestarjeta.formapagopuntoventas);
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
	
	public void deepLoad(TipoInteresTarjeta tipointerestarjeta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoInteresTarjetaLogicAdditional.updateTipoInteresTarjetaToGet(tipointerestarjeta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipointerestarjeta.setFormaPagoPuntoVentas(tipointerestarjetaDataAccess.getFormaPagoPuntoVentas(connexion,tipointerestarjeta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipointerestarjeta.setFormaPagoPuntoVentas(tipointerestarjetaDataAccess.getFormaPagoPuntoVentas(connexion,tipointerestarjeta));

				if(this.isConDeep) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(this.connexion);
					formapagopuntoventaLogic.setFormaPagoPuntoVentas(tipointerestarjeta.getFormaPagoPuntoVentas());
					ArrayList<Classe> classesLocal=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					formapagopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
					tipointerestarjeta.setFormaPagoPuntoVentas(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
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
			tipointerestarjeta.setFormaPagoPuntoVentas(tipointerestarjetaDataAccess.getFormaPagoPuntoVentas(connexion,tipointerestarjeta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipointerestarjeta.setFormaPagoPuntoVentas(tipointerestarjetaDataAccess.getFormaPagoPuntoVentas(connexion,tipointerestarjeta));

		for(FormaPagoPuntoVenta formapagopuntoventa:tipointerestarjeta.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipointerestarjeta.setFormaPagoPuntoVentas(tipointerestarjetaDataAccess.getFormaPagoPuntoVentas(connexion,tipointerestarjeta));

				for(FormaPagoPuntoVenta formapagopuntoventa:tipointerestarjeta.getFormaPagoPuntoVentas()) {
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
			tipointerestarjeta.setFormaPagoPuntoVentas(tipointerestarjetaDataAccess.getFormaPagoPuntoVentas(connexion,tipointerestarjeta));

			for(FormaPagoPuntoVenta formapagopuntoventa:tipointerestarjeta.getFormaPagoPuntoVentas()) {
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
	
	public void deepSave(TipoInteresTarjeta tipointerestarjeta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoInteresTarjeta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipointerestarjeta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(tipointerestarjeta);
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
			this.deepLoad(this.tipointerestarjeta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(this.tipointerestarjeta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoInteresTarjeta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipointerestarjetas!=null) {
				for(TipoInteresTarjeta tipointerestarjeta:tipointerestarjetas) {
					this.deepLoad(tipointerestarjeta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(tipointerestarjetas);
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
			if(tipointerestarjetas!=null) {
				for(TipoInteresTarjeta tipointerestarjeta:tipointerestarjetas) {
					this.deepLoad(tipointerestarjeta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoInteresTarjetaConstantesFunciones.refrescarForeignKeysDescripcionesTipoInteresTarjeta(tipointerestarjetas);
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
			if(TipoInteresTarjetaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInteresTarjetaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoInteresTarjeta tipointerestarjeta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoInteresTarjetaConstantesFunciones.ISCONAUDITORIA) {
				if(tipointerestarjeta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInteresTarjetaDataAccess.TABLENAME, tipointerestarjeta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoInteresTarjetaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoInteresTarjetaLogic.registrarAuditoriaDetallesTipoInteresTarjeta(connexion,tipointerestarjeta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipointerestarjeta.getIsDeleted()) {
					/*if(!tipointerestarjeta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoInteresTarjetaDataAccess.TABLENAME, tipointerestarjeta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoInteresTarjetaLogic.registrarAuditoriaDetallesTipoInteresTarjeta(connexion,tipointerestarjeta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInteresTarjetaDataAccess.TABLENAME, tipointerestarjeta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipointerestarjeta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInteresTarjetaDataAccess.TABLENAME, tipointerestarjeta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoInteresTarjetaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoInteresTarjetaLogic.registrarAuditoriaDetallesTipoInteresTarjeta(connexion,tipointerestarjeta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoInteresTarjeta(Connexion connexion,TipoInteresTarjeta tipointerestarjeta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipointerestarjeta.getIsNew()||!tipointerestarjeta.getnombre().equals(tipointerestarjeta.getTipoInteresTarjetaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipointerestarjeta.getTipoInteresTarjetaOriginal().getnombre()!=null)
				{
					strValorActual=tipointerestarjeta.getTipoInteresTarjetaOriginal().getnombre();
				}
				if(tipointerestarjeta.getnombre()!=null)
				{
					strValorNuevo=tipointerestarjeta.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoInteresTarjetaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipointerestarjeta.getIsNew()||!tipointerestarjeta.getdescripcion().equals(tipointerestarjeta.getTipoInteresTarjetaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipointerestarjeta.getTipoInteresTarjetaOriginal().getdescripcion()!=null)
				{
					strValorActual=tipointerestarjeta.getTipoInteresTarjetaOriginal().getdescripcion();
				}
				if(tipointerestarjeta.getdescripcion()!=null)
				{
					strValorNuevo=tipointerestarjeta.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoInteresTarjetaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoInteresTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoInteresTarjetaConstantesFunciones.getClassesForeignKeysOfTipoInteresTarjeta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInteresTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoInteresTarjetaConstantesFunciones.getClassesRelationshipsOfTipoInteresTarjeta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

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
import com.bydan.erp.facturacion.util.TipoParamFactuListadoClienteConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoParamFactuListadoClienteParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoParamFactuListadoClienteParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoParamFactuListadoCliente;
import com.bydan.erp.facturacion.business.logic.TipoParamFactuListadoClienteLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoParamFactuListadoClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoParamFactuListadoClienteLogic.class);
	
	protected TipoParamFactuListadoClienteDataAccess tipoparamfactulistadoclienteDataAccess; 	
	protected TipoParamFactuListadoCliente tipoparamfactulistadocliente;
	protected List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes;
	protected Object tipoparamfactulistadoclienteObject;	
	protected List<Object> tipoparamfactulistadoclientesObject;
	
	public static ClassValidator<TipoParamFactuListadoCliente> tipoparamfactulistadoclienteValidator = new ClassValidator<TipoParamFactuListadoCliente>(TipoParamFactuListadoCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoParamFactuListadoClienteLogicAdditional tipoparamfactulistadoclienteLogicAdditional=null;
	
	public TipoParamFactuListadoClienteLogicAdditional getTipoParamFactuListadoClienteLogicAdditional() {
		return this.tipoparamfactulistadoclienteLogicAdditional;
	}
	
	public void setTipoParamFactuListadoClienteLogicAdditional(TipoParamFactuListadoClienteLogicAdditional tipoparamfactulistadoclienteLogicAdditional) {
		try {
			this.tipoparamfactulistadoclienteLogicAdditional=tipoparamfactulistadoclienteLogicAdditional;
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
	
	
	
	
	public  TipoParamFactuListadoClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoparamfactulistadoclienteDataAccess = new TipoParamFactuListadoClienteDataAccess();
			
			this.tipoparamfactulistadoclientes= new ArrayList<TipoParamFactuListadoCliente>();
			this.tipoparamfactulistadocliente= new TipoParamFactuListadoCliente();
			
			this.tipoparamfactulistadoclienteObject=new Object();
			this.tipoparamfactulistadoclientesObject=new ArrayList<Object>();
				
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
			
			this.tipoparamfactulistadoclienteDataAccess.setConnexionType(this.connexionType);
			this.tipoparamfactulistadoclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoParamFactuListadoClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoparamfactulistadoclienteDataAccess = new TipoParamFactuListadoClienteDataAccess();
			this.tipoparamfactulistadoclientes= new ArrayList<TipoParamFactuListadoCliente>();
			this.tipoparamfactulistadocliente= new TipoParamFactuListadoCliente();
			this.tipoparamfactulistadoclienteObject=new Object();
			this.tipoparamfactulistadoclientesObject=new ArrayList<Object>();
			
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
			
			this.tipoparamfactulistadoclienteDataAccess.setConnexionType(this.connexionType);
			this.tipoparamfactulistadoclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoParamFactuListadoCliente getTipoParamFactuListadoCliente() throws Exception {	
		TipoParamFactuListadoClienteLogicAdditional.checkTipoParamFactuListadoClienteToGet(tipoparamfactulistadocliente,this.datosCliente,this.arrDatoGeneral);
		TipoParamFactuListadoClienteLogicAdditional.updateTipoParamFactuListadoClienteToGet(tipoparamfactulistadocliente,this.arrDatoGeneral);
		
		return tipoparamfactulistadocliente;
	}
		
	public void setTipoParamFactuListadoCliente(TipoParamFactuListadoCliente newTipoParamFactuListadoCliente) {
		this.tipoparamfactulistadocliente = newTipoParamFactuListadoCliente;
	}
	
	public TipoParamFactuListadoClienteDataAccess getTipoParamFactuListadoClienteDataAccess() {
		return tipoparamfactulistadoclienteDataAccess;
	}
	
	public void setTipoParamFactuListadoClienteDataAccess(TipoParamFactuListadoClienteDataAccess newtipoparamfactulistadoclienteDataAccess) {
		this.tipoparamfactulistadoclienteDataAccess = newtipoparamfactulistadoclienteDataAccess;
	}
	
	public List<TipoParamFactuListadoCliente> getTipoParamFactuListadoClientes() throws Exception {		
		this.quitarTipoParamFactuListadoClientesNulos();
		
		TipoParamFactuListadoClienteLogicAdditional.checkTipoParamFactuListadoClienteToGets(tipoparamfactulistadoclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoParamFactuListadoCliente tipoparamfactulistadoclienteLocal: tipoparamfactulistadoclientes ) {
			TipoParamFactuListadoClienteLogicAdditional.updateTipoParamFactuListadoClienteToGet(tipoparamfactulistadoclienteLocal,this.arrDatoGeneral);
		}
		
		return tipoparamfactulistadoclientes;
	}
	
	public void setTipoParamFactuListadoClientes(List<TipoParamFactuListadoCliente> newTipoParamFactuListadoClientes) {
		this.tipoparamfactulistadoclientes = newTipoParamFactuListadoClientes;
	}
	
	public Object getTipoParamFactuListadoClienteObject() {	
		this.tipoparamfactulistadoclienteObject=this.tipoparamfactulistadoclienteDataAccess.getEntityObject();
		return this.tipoparamfactulistadoclienteObject;
	}
		
	public void setTipoParamFactuListadoClienteObject(Object newTipoParamFactuListadoClienteObject) {
		this.tipoparamfactulistadoclienteObject = newTipoParamFactuListadoClienteObject;
	}
	
	public List<Object> getTipoParamFactuListadoClientesObject() {		
		this.tipoparamfactulistadoclientesObject=this.tipoparamfactulistadoclienteDataAccess.getEntitiesObject();
		return this.tipoparamfactulistadoclientesObject;
	}
		
	public void setTipoParamFactuListadoClientesObject(List<Object> newTipoParamFactuListadoClientesObject) {
		this.tipoparamfactulistadoclientesObject = newTipoParamFactuListadoClientesObject;
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
		
		if(this.tipoparamfactulistadoclienteDataAccess!=null) {
			this.tipoparamfactulistadoclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoparamfactulistadoclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoparamfactulistadoclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoparamfactulistadocliente=tipoparamfactulistadoclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactulistadocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadocliente);
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
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		  		  
        try {
			
			tipoparamfactulistadocliente=tipoparamfactulistadoclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactulistadocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoparamfactulistadocliente=tipoparamfactulistadoclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactulistadocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadocliente);
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
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		  		  
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
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		  		  
        try {
			
			tipoparamfactulistadocliente=tipoparamfactulistadoclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactulistadocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		  		  
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
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoparamfactulistadoclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoparamfactulistadoclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoparamfactulistadoclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoparamfactulistadoclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoparamfactulistadoclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoparamfactulistadoclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoparamfactulistadoclientes = new  ArrayList<TipoParamFactuListadoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactulistadoclientes=tipoparamfactulistadoclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuListadoCliente(tipoparamfactulistadoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadoclientes);
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
		tipoparamfactulistadoclientes = new  ArrayList<TipoParamFactuListadoCliente>();
		  		  
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
		tipoparamfactulistadoclientes = new  ArrayList<TipoParamFactuListadoCliente>();
		  		  
        try {			
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactulistadoclientes=tipoparamfactulistadoclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoParamFactuListadoCliente(tipoparamfactulistadoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadoclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoparamfactulistadoclientes = new  ArrayList<TipoParamFactuListadoCliente>();
		  		  
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
		tipoparamfactulistadoclientes = new  ArrayList<TipoParamFactuListadoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactulistadoclientes=tipoparamfactulistadoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuListadoCliente(tipoparamfactulistadoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadoclientes);
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
		tipoparamfactulistadoclientes = new  ArrayList<TipoParamFactuListadoCliente>();
		  		  
        try {
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactulistadoclientes=tipoparamfactulistadoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuListadoCliente(tipoparamfactulistadoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadoclientes);
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
		tipoparamfactulistadoclientes = new  ArrayList<TipoParamFactuListadoCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactulistadoclientes=tipoparamfactulistadoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuListadoCliente(tipoparamfactulistadoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadoclientes);
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
		tipoparamfactulistadoclientes = new  ArrayList<TipoParamFactuListadoCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactulistadoclientes=tipoparamfactulistadoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuListadoCliente(tipoparamfactulistadoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadoclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactulistadocliente=tipoparamfactulistadoclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuListadoCliente(tipoparamfactulistadocliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadocliente);
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
		tipoparamfactulistadocliente = new  TipoParamFactuListadoCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactulistadocliente=tipoparamfactulistadoclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuListadoCliente(tipoparamfactulistadocliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoparamfactulistadoclientes = new  ArrayList<TipoParamFactuListadoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactulistadoclientes=tipoparamfactulistadoclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuListadoCliente(tipoparamfactulistadoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadoclientes);
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
		tipoparamfactulistadoclientes = new  ArrayList<TipoParamFactuListadoCliente>();
		  		  
        try {
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactulistadoclientes=tipoparamfactulistadoclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuListadoCliente(tipoparamfactulistadoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadoclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoParamFactuListadoClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoparamfactulistadoclientes = new  ArrayList<TipoParamFactuListadoCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getTodosTipoParamFactuListadoClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactulistadoclientes=tipoparamfactulistadoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoParamFactuListadoCliente(tipoparamfactulistadoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadoclientes);
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
	
	public  void  getTodosTipoParamFactuListadoClientes(String sFinalQuery,Pagination pagination)throws Exception {
		tipoparamfactulistadoclientes = new  ArrayList<TipoParamFactuListadoCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactulistadoclientes=tipoparamfactulistadoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoParamFactuListadoCliente(tipoparamfactulistadoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadoclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoParamFactuListadoCliente(TipoParamFactuListadoCliente tipoparamfactulistadocliente) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoparamfactulistadocliente.getIsNew() || tipoparamfactulistadocliente.getIsChanged()) { 
			this.invalidValues = tipoparamfactulistadoclienteValidator.getInvalidValues(tipoparamfactulistadocliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoparamfactulistadocliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoParamFactuListadoCliente(List<TipoParamFactuListadoCliente> TipoParamFactuListadoClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoParamFactuListadoCliente tipoparamfactulistadoclienteLocal:tipoparamfactulistadoclientes) {				
			estaValidadoObjeto=this.validarGuardarTipoParamFactuListadoCliente(tipoparamfactulistadoclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoParamFactuListadoCliente(List<TipoParamFactuListadoCliente> TipoParamFactuListadoClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoParamFactuListadoCliente(tipoparamfactulistadoclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoParamFactuListadoCliente(TipoParamFactuListadoCliente TipoParamFactuListadoCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoParamFactuListadoCliente(tipoparamfactulistadocliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoParamFactuListadoCliente tipoparamfactulistadocliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoparamfactulistadocliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoParamFactuListadoClienteConstantesFunciones.getTipoParamFactuListadoClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoparamfactulistadocliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoParamFactuListadoClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoParamFactuListadoClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoParamFactuListadoClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-saveTipoParamFactuListadoClienteWithConnection");connexion.begin();			
			
			TipoParamFactuListadoClienteLogicAdditional.checkTipoParamFactuListadoClienteToSave(this.tipoparamfactulistadocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoParamFactuListadoClienteLogicAdditional.updateTipoParamFactuListadoClienteToSave(this.tipoparamfactulistadocliente,this.arrDatoGeneral);
			
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoparamfactulistadocliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoParamFactuListadoCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoParamFactuListadoCliente(this.tipoparamfactulistadocliente)) {
				TipoParamFactuListadoClienteDataAccess.save(this.tipoparamfactulistadocliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoparamfactulistadocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoParamFactuListadoClienteLogicAdditional.checkTipoParamFactuListadoClienteToSaveAfter(this.tipoparamfactulistadocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoParamFactuListadoCliente();
			
			connexion.commit();			
			
			if(this.tipoparamfactulistadocliente.getIsDeleted()) {
				this.tipoparamfactulistadocliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoParamFactuListadoCliente()throws Exception {	
		try {	
			
			TipoParamFactuListadoClienteLogicAdditional.checkTipoParamFactuListadoClienteToSave(this.tipoparamfactulistadocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoParamFactuListadoClienteLogicAdditional.updateTipoParamFactuListadoClienteToSave(this.tipoparamfactulistadocliente,this.arrDatoGeneral);
			
			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoparamfactulistadocliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoParamFactuListadoCliente(this.tipoparamfactulistadocliente)) {			
				TipoParamFactuListadoClienteDataAccess.save(this.tipoparamfactulistadocliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoparamfactulistadocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoParamFactuListadoClienteLogicAdditional.checkTipoParamFactuListadoClienteToSaveAfter(this.tipoparamfactulistadocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoparamfactulistadocliente.getIsDeleted()) {
				this.tipoparamfactulistadocliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoParamFactuListadoClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-saveTipoParamFactuListadoClientesWithConnection");connexion.begin();			
			
			TipoParamFactuListadoClienteLogicAdditional.checkTipoParamFactuListadoClienteToSaves(tipoparamfactulistadoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoParamFactuListadoClientes();
			
			Boolean validadoTodosTipoParamFactuListadoCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoParamFactuListadoCliente tipoparamfactulistadoclienteLocal:tipoparamfactulistadoclientes) {		
				if(tipoparamfactulistadoclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoParamFactuListadoClienteLogicAdditional.updateTipoParamFactuListadoClienteToSave(tipoparamfactulistadoclienteLocal,this.arrDatoGeneral);
	        	
				TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoparamfactulistadoclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoParamFactuListadoCliente(tipoparamfactulistadoclienteLocal)) {
					TipoParamFactuListadoClienteDataAccess.save(tipoparamfactulistadoclienteLocal, connexion);				
				} else {
					validadoTodosTipoParamFactuListadoCliente=false;
				}
			}
			
			if(!validadoTodosTipoParamFactuListadoCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoParamFactuListadoClienteLogicAdditional.checkTipoParamFactuListadoClienteToSavesAfter(tipoparamfactulistadoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoParamFactuListadoClientes();
			
			connexion.commit();		
			
			this.quitarTipoParamFactuListadoClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoParamFactuListadoClientes()throws Exception {				
		 try {	
			TipoParamFactuListadoClienteLogicAdditional.checkTipoParamFactuListadoClienteToSaves(tipoparamfactulistadoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoParamFactuListadoCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoParamFactuListadoCliente tipoparamfactulistadoclienteLocal:tipoparamfactulistadoclientes) {				
				if(tipoparamfactulistadoclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoParamFactuListadoClienteLogicAdditional.updateTipoParamFactuListadoClienteToSave(tipoparamfactulistadoclienteLocal,this.arrDatoGeneral);
	        	
				TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoparamfactulistadoclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoParamFactuListadoCliente(tipoparamfactulistadoclienteLocal)) {				
					TipoParamFactuListadoClienteDataAccess.save(tipoparamfactulistadoclienteLocal, connexion);				
				} else {
					validadoTodosTipoParamFactuListadoCliente=false;
				}
			}
			
			if(!validadoTodosTipoParamFactuListadoCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoParamFactuListadoClienteLogicAdditional.checkTipoParamFactuListadoClienteToSavesAfter(tipoparamfactulistadoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoParamFactuListadoClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoParamFactuListadoClienteParameterReturnGeneral procesarAccionTipoParamFactuListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes,TipoParamFactuListadoClienteParameterReturnGeneral tipoparamfactulistadoclienteParameterGeneral)throws Exception {
		 try {	
			TipoParamFactuListadoClienteParameterReturnGeneral tipoparamfactulistadoclienteReturnGeneral=new TipoParamFactuListadoClienteParameterReturnGeneral();
	
			TipoParamFactuListadoClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoparamfactulistadoclientes,tipoparamfactulistadoclienteParameterGeneral,tipoparamfactulistadoclienteReturnGeneral);
			
			return tipoparamfactulistadoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoParamFactuListadoClienteParameterReturnGeneral procesarAccionTipoParamFactuListadoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes,TipoParamFactuListadoClienteParameterReturnGeneral tipoparamfactulistadoclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-procesarAccionTipoParamFactuListadoClientesWithConnection");connexion.begin();			
			
			TipoParamFactuListadoClienteParameterReturnGeneral tipoparamfactulistadoclienteReturnGeneral=new TipoParamFactuListadoClienteParameterReturnGeneral();
	
			TipoParamFactuListadoClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoparamfactulistadoclientes,tipoparamfactulistadoclienteParameterGeneral,tipoparamfactulistadoclienteReturnGeneral);
			
			this.connexion.commit();
			
			return tipoparamfactulistadoclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoParamFactuListadoClienteParameterReturnGeneral procesarEventosTipoParamFactuListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes,TipoParamFactuListadoCliente tipoparamfactulistadocliente,TipoParamFactuListadoClienteParameterReturnGeneral tipoparamfactulistadoclienteParameterGeneral,Boolean isEsNuevoTipoParamFactuListadoCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoParamFactuListadoClienteParameterReturnGeneral tipoparamfactulistadoclienteReturnGeneral=new TipoParamFactuListadoClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoparamfactulistadoclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoParamFactuListadoClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoparamfactulistadoclientes,tipoparamfactulistadocliente,tipoparamfactulistadoclienteParameterGeneral,tipoparamfactulistadoclienteReturnGeneral,isEsNuevoTipoParamFactuListadoCliente,clases);
			
			return tipoparamfactulistadoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoParamFactuListadoClienteParameterReturnGeneral procesarEventosTipoParamFactuListadoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes,TipoParamFactuListadoCliente tipoparamfactulistadocliente,TipoParamFactuListadoClienteParameterReturnGeneral tipoparamfactulistadoclienteParameterGeneral,Boolean isEsNuevoTipoParamFactuListadoCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-procesarEventosTipoParamFactuListadoClientesWithConnection");connexion.begin();			
			
			TipoParamFactuListadoClienteParameterReturnGeneral tipoparamfactulistadoclienteReturnGeneral=new TipoParamFactuListadoClienteParameterReturnGeneral();
	
			tipoparamfactulistadoclienteReturnGeneral.setTipoParamFactuListadoCliente(tipoparamfactulistadocliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoparamfactulistadoclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoParamFactuListadoClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoparamfactulistadoclientes,tipoparamfactulistadocliente,tipoparamfactulistadoclienteParameterGeneral,tipoparamfactulistadoclienteReturnGeneral,isEsNuevoTipoParamFactuListadoCliente,clases);
			
			this.connexion.commit();
			
			return tipoparamfactulistadoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoParamFactuListadoClienteParameterReturnGeneral procesarImportacionTipoParamFactuListadoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoParamFactuListadoClienteParameterReturnGeneral tipoparamfactulistadoclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-procesarImportacionTipoParamFactuListadoClientesWithConnection");connexion.begin();			
			
			TipoParamFactuListadoClienteParameterReturnGeneral tipoparamfactulistadoclienteReturnGeneral=new TipoParamFactuListadoClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoparamfactulistadoclientes=new ArrayList<TipoParamFactuListadoCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoparamfactulistadocliente=new TipoParamFactuListadoCliente();
				
				
				if(conColumnasBase) {this.tipoparamfactulistadocliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoparamfactulistadocliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoparamfactulistadocliente.setnombre(arrColumnas[iColumn++]);
				
				this.tipoparamfactulistadoclientes.add(this.tipoparamfactulistadocliente);
			}
			
			this.saveTipoParamFactuListadoClientes();
			
			this.connexion.commit();
			
			tipoparamfactulistadoclienteReturnGeneral.setConRetornoEstaProcesado(true);
			tipoparamfactulistadoclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoparamfactulistadoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoParamFactuListadoClientesEliminados() throws Exception {				
		
		List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientesAux= new ArrayList<TipoParamFactuListadoCliente>();
		
		for(TipoParamFactuListadoCliente tipoparamfactulistadocliente:tipoparamfactulistadoclientes) {
			if(!tipoparamfactulistadocliente.getIsDeleted()) {
				tipoparamfactulistadoclientesAux.add(tipoparamfactulistadocliente);
			}
		}
		
		tipoparamfactulistadoclientes=tipoparamfactulistadoclientesAux;
	}
	
	public void quitarTipoParamFactuListadoClientesNulos() throws Exception {				
		
		List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientesAux= new ArrayList<TipoParamFactuListadoCliente>();
		
		for(TipoParamFactuListadoCliente tipoparamfactulistadocliente : this.tipoparamfactulistadoclientes) {
			if(tipoparamfactulistadocliente==null) {
				tipoparamfactulistadoclientesAux.add(tipoparamfactulistadocliente);
			}
		}
		
		//this.tipoparamfactulistadoclientes=tipoparamfactulistadoclientesAux;
		
		this.tipoparamfactulistadoclientes.removeAll(tipoparamfactulistadoclientesAux);
	}
	
	public void getSetVersionRowTipoParamFactuListadoClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoparamfactulistadocliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoparamfactulistadocliente.getIsDeleted() || (tipoparamfactulistadocliente.getIsChanged()&&!tipoparamfactulistadocliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoparamfactulistadoclienteDataAccess.getSetVersionRowTipoParamFactuListadoCliente(connexion,tipoparamfactulistadocliente.getId());
				
				if(!tipoparamfactulistadocliente.getVersionRow().equals(timestamp)) {	
					tipoparamfactulistadocliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoparamfactulistadocliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoParamFactuListadoCliente()throws Exception {	
		
		if(tipoparamfactulistadocliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoparamfactulistadocliente.getIsDeleted() || (tipoparamfactulistadocliente.getIsChanged()&&!tipoparamfactulistadocliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoparamfactulistadoclienteDataAccess.getSetVersionRowTipoParamFactuListadoCliente(connexion,tipoparamfactulistadocliente.getId());
			
			try {							
				if(!tipoparamfactulistadocliente.getVersionRow().equals(timestamp)) {	
					tipoparamfactulistadocliente.setVersionRow(timestamp);
				}
				
				tipoparamfactulistadocliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoParamFactuListadoClientesWithConnection()throws Exception {	
		if(tipoparamfactulistadoclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoParamFactuListadoCliente tipoparamfactulistadoclienteAux:tipoparamfactulistadoclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoparamfactulistadoclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoparamfactulistadoclienteAux.getIsDeleted() || (tipoparamfactulistadoclienteAux.getIsChanged()&&!tipoparamfactulistadoclienteAux.getIsNew())) {
						
						timestamp=tipoparamfactulistadoclienteDataAccess.getSetVersionRowTipoParamFactuListadoCliente(connexion,tipoparamfactulistadoclienteAux.getId());
						
						if(!tipoparamfactulistadocliente.getVersionRow().equals(timestamp)) {	
							tipoparamfactulistadoclienteAux.setVersionRow(timestamp);
						}
								
						tipoparamfactulistadoclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoParamFactuListadoClientes()throws Exception {	
		if(tipoparamfactulistadoclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoParamFactuListadoCliente tipoparamfactulistadoclienteAux:tipoparamfactulistadoclientes) {
					if(tipoparamfactulistadoclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoparamfactulistadoclienteAux.getIsDeleted() || (tipoparamfactulistadoclienteAux.getIsChanged()&&!tipoparamfactulistadoclienteAux.getIsNew())) {
						
						timestamp=tipoparamfactulistadoclienteDataAccess.getSetVersionRowTipoParamFactuListadoCliente(connexion,tipoparamfactulistadoclienteAux.getId());
						
						if(!tipoparamfactulistadoclienteAux.getVersionRow().equals(timestamp)) {	
							tipoparamfactulistadoclienteAux.setVersionRow(timestamp);
						}
						
													
						tipoparamfactulistadoclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoParamFactuListadoCliente tipoparamfactulistadocliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoParamFactuListadoClienteLogicAdditional.updateTipoParamFactuListadoClienteToGet(tipoparamfactulistadocliente,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoParamFactuListadoCliente tipoparamfactulistadocliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoParamFactuListadoClienteLogicAdditional.updateTipoParamFactuListadoClienteToSave(tipoparamfactulistadocliente,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoParamFactuListadoCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoparamfactulistadocliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(tipoparamfactulistadocliente);
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
			this.deepLoad(this.tipoparamfactulistadocliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoParamFactuListadoCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoparamfactulistadoclientes!=null) {
				for(TipoParamFactuListadoCliente tipoparamfactulistadocliente:tipoparamfactulistadoclientes) {
					this.deepLoad(tipoparamfactulistadocliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(tipoparamfactulistadoclientes);
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
			if(tipoparamfactulistadoclientes!=null) {
				for(TipoParamFactuListadoCliente tipoparamfactulistadocliente:tipoparamfactulistadoclientes) {
					this.deepLoad(tipoparamfactulistadocliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(tipoparamfactulistadoclientes);
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
			this.getNewConnexionToDeep(TipoParamFactuListadoCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoparamfactulistadocliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoParamFactuListadoCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoparamfactulistadoclientes!=null) {
				for(TipoParamFactuListadoCliente tipoparamfactulistadocliente:tipoparamfactulistadoclientes) {
					this.deepSave(tipoparamfactulistadocliente,isDeep,deepLoadType,clases);
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
			if(tipoparamfactulistadoclientes!=null) {
				for(TipoParamFactuListadoCliente tipoparamfactulistadocliente:tipoparamfactulistadoclientes) {
					this.deepSave(tipoparamfactulistadocliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoParamFactuListadoClientesBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoParamFactuListadoClienteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoparamfactulistadoclientes=tipoparamfactulistadoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoParamFactuListadoClientesBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoParamFactuListadoClienteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoParamFactuListadoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoparamfactulistadoclientes=tipoparamfactulistadoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadoclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoParamFactuListadoClientePorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuListadoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoParamFactuListadoClienteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoparamfactulistadocliente=tipoparamfactulistadoclienteDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactulistadocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadocliente);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoParamFactuListadoClientePorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoParamFactuListadoClienteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoparamfactulistadocliente=tipoparamfactulistadoclienteDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactulistadocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoParamFactuListadoClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(this.tipoparamfactulistadocliente);
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
			if(TipoParamFactuListadoClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuListadoClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoParamFactuListadoCliente tipoparamfactulistadocliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoParamFactuListadoClienteConstantesFunciones.ISCONAUDITORIA) {
				if(tipoparamfactulistadocliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuListadoClienteDataAccess.TABLENAME, tipoparamfactulistadocliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoParamFactuListadoClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoParamFactuListadoClienteLogic.registrarAuditoriaDetallesTipoParamFactuListadoCliente(connexion,tipoparamfactulistadocliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoparamfactulistadocliente.getIsDeleted()) {
					/*if(!tipoparamfactulistadocliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoParamFactuListadoClienteDataAccess.TABLENAME, tipoparamfactulistadocliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoParamFactuListadoClienteLogic.registrarAuditoriaDetallesTipoParamFactuListadoCliente(connexion,tipoparamfactulistadocliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuListadoClienteDataAccess.TABLENAME, tipoparamfactulistadocliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoparamfactulistadocliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuListadoClienteDataAccess.TABLENAME, tipoparamfactulistadocliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoParamFactuListadoClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoParamFactuListadoClienteLogic.registrarAuditoriaDetallesTipoParamFactuListadoCliente(connexion,tipoparamfactulistadocliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoParamFactuListadoCliente(Connexion connexion,TipoParamFactuListadoCliente tipoparamfactulistadocliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoparamfactulistadocliente.getIsNew()||!tipoparamfactulistadocliente.getnombre().equals(tipoparamfactulistadocliente.getTipoParamFactuListadoClienteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoparamfactulistadocliente.getTipoParamFactuListadoClienteOriginal().getnombre()!=null)
				{
					strValorActual=tipoparamfactulistadocliente.getTipoParamFactuListadoClienteOriginal().getnombre();
				}
				if(tipoparamfactulistadocliente.getnombre()!=null)
				{
					strValorNuevo=tipoparamfactulistadocliente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoParamFactuListadoClienteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoParamFactuListadoClienteRelacionesWithConnection(TipoParamFactuListadoCliente tipoparamfactulistadocliente) throws Exception {

		if(!tipoparamfactulistadocliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoParamFactuListadoClienteRelacionesBase(tipoparamfactulistadocliente,true);
		}
	}

	public void saveTipoParamFactuListadoClienteRelaciones(TipoParamFactuListadoCliente tipoparamfactulistadocliente)throws Exception {

		if(!tipoparamfactulistadocliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoParamFactuListadoClienteRelacionesBase(tipoparamfactulistadocliente,false);
		}
	}

	public void saveTipoParamFactuListadoClienteRelacionesBase(TipoParamFactuListadoCliente tipoparamfactulistadocliente,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoParamFactuListadoCliente-saveRelacionesWithConnection");}
	

			this.setTipoParamFactuListadoCliente(tipoparamfactulistadocliente);

				if((tipoparamfactulistadocliente.getIsNew()||tipoparamfactulistadocliente.getIsChanged())&&!tipoparamfactulistadocliente.getIsDeleted()) {
					this.saveTipoParamFactuListadoCliente();
					this.saveTipoParamFactuListadoClienteRelacionesDetalles();

				} else if(tipoparamfactulistadocliente.getIsDeleted()) {
					this.saveTipoParamFactuListadoClienteRelacionesDetalles();
					this.saveTipoParamFactuListadoCliente();
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
	
	
	private void saveTipoParamFactuListadoClienteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoParamFactuListadoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoParamFactuListadoClienteConstantesFunciones.getClassesForeignKeysOfTipoParamFactuListadoCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParamFactuListadoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoParamFactuListadoClienteConstantesFunciones.getClassesRelationshipsOfTipoParamFactuListadoCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.facturacion.util.TipoParamFactuSecuenciaTrabajoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoParamFactuSecuenciaTrabajoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoParamFactuSecuenciaTrabajoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoParamFactuSecuenciaTrabajo;
import com.bydan.erp.facturacion.business.logic.TipoParamFactuSecuenciaTrabajoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoParamFactuSecuenciaTrabajoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoParamFactuSecuenciaTrabajoLogic.class);
	
	protected TipoParamFactuSecuenciaTrabajoDataAccess tipoparamfactusecuenciatrabajoDataAccess; 	
	protected TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo;
	protected List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos;
	protected Object tipoparamfactusecuenciatrabajoObject;	
	protected List<Object> tipoparamfactusecuenciatrabajosObject;
	
	public static ClassValidator<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajoValidator = new ClassValidator<TipoParamFactuSecuenciaTrabajo>(TipoParamFactuSecuenciaTrabajo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoParamFactuSecuenciaTrabajoLogicAdditional tipoparamfactusecuenciatrabajoLogicAdditional=null;
	
	public TipoParamFactuSecuenciaTrabajoLogicAdditional getTipoParamFactuSecuenciaTrabajoLogicAdditional() {
		return this.tipoparamfactusecuenciatrabajoLogicAdditional;
	}
	
	public void setTipoParamFactuSecuenciaTrabajoLogicAdditional(TipoParamFactuSecuenciaTrabajoLogicAdditional tipoparamfactusecuenciatrabajoLogicAdditional) {
		try {
			this.tipoparamfactusecuenciatrabajoLogicAdditional=tipoparamfactusecuenciatrabajoLogicAdditional;
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
	
	
	
	
	public  TipoParamFactuSecuenciaTrabajoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoparamfactusecuenciatrabajoDataAccess = new TipoParamFactuSecuenciaTrabajoDataAccess();
			
			this.tipoparamfactusecuenciatrabajos= new ArrayList<TipoParamFactuSecuenciaTrabajo>();
			this.tipoparamfactusecuenciatrabajo= new TipoParamFactuSecuenciaTrabajo();
			
			this.tipoparamfactusecuenciatrabajoObject=new Object();
			this.tipoparamfactusecuenciatrabajosObject=new ArrayList<Object>();
				
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
			
			this.tipoparamfactusecuenciatrabajoDataAccess.setConnexionType(this.connexionType);
			this.tipoparamfactusecuenciatrabajoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoParamFactuSecuenciaTrabajoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoparamfactusecuenciatrabajoDataAccess = new TipoParamFactuSecuenciaTrabajoDataAccess();
			this.tipoparamfactusecuenciatrabajos= new ArrayList<TipoParamFactuSecuenciaTrabajo>();
			this.tipoparamfactusecuenciatrabajo= new TipoParamFactuSecuenciaTrabajo();
			this.tipoparamfactusecuenciatrabajoObject=new Object();
			this.tipoparamfactusecuenciatrabajosObject=new ArrayList<Object>();
			
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
			
			this.tipoparamfactusecuenciatrabajoDataAccess.setConnexionType(this.connexionType);
			this.tipoparamfactusecuenciatrabajoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoParamFactuSecuenciaTrabajo getTipoParamFactuSecuenciaTrabajo() throws Exception {	
		TipoParamFactuSecuenciaTrabajoLogicAdditional.checkTipoParamFactuSecuenciaTrabajoToGet(tipoparamfactusecuenciatrabajo,this.datosCliente,this.arrDatoGeneral);
		TipoParamFactuSecuenciaTrabajoLogicAdditional.updateTipoParamFactuSecuenciaTrabajoToGet(tipoparamfactusecuenciatrabajo,this.arrDatoGeneral);
		
		return tipoparamfactusecuenciatrabajo;
	}
		
	public void setTipoParamFactuSecuenciaTrabajo(TipoParamFactuSecuenciaTrabajo newTipoParamFactuSecuenciaTrabajo) {
		this.tipoparamfactusecuenciatrabajo = newTipoParamFactuSecuenciaTrabajo;
	}
	
	public TipoParamFactuSecuenciaTrabajoDataAccess getTipoParamFactuSecuenciaTrabajoDataAccess() {
		return tipoparamfactusecuenciatrabajoDataAccess;
	}
	
	public void setTipoParamFactuSecuenciaTrabajoDataAccess(TipoParamFactuSecuenciaTrabajoDataAccess newtipoparamfactusecuenciatrabajoDataAccess) {
		this.tipoparamfactusecuenciatrabajoDataAccess = newtipoparamfactusecuenciatrabajoDataAccess;
	}
	
	public List<TipoParamFactuSecuenciaTrabajo> getTipoParamFactuSecuenciaTrabajos() throws Exception {		
		this.quitarTipoParamFactuSecuenciaTrabajosNulos();
		
		TipoParamFactuSecuenciaTrabajoLogicAdditional.checkTipoParamFactuSecuenciaTrabajoToGets(tipoparamfactusecuenciatrabajos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoLocal: tipoparamfactusecuenciatrabajos ) {
			TipoParamFactuSecuenciaTrabajoLogicAdditional.updateTipoParamFactuSecuenciaTrabajoToGet(tipoparamfactusecuenciatrabajoLocal,this.arrDatoGeneral);
		}
		
		return tipoparamfactusecuenciatrabajos;
	}
	
	public void setTipoParamFactuSecuenciaTrabajos(List<TipoParamFactuSecuenciaTrabajo> newTipoParamFactuSecuenciaTrabajos) {
		this.tipoparamfactusecuenciatrabajos = newTipoParamFactuSecuenciaTrabajos;
	}
	
	public Object getTipoParamFactuSecuenciaTrabajoObject() {	
		this.tipoparamfactusecuenciatrabajoObject=this.tipoparamfactusecuenciatrabajoDataAccess.getEntityObject();
		return this.tipoparamfactusecuenciatrabajoObject;
	}
		
	public void setTipoParamFactuSecuenciaTrabajoObject(Object newTipoParamFactuSecuenciaTrabajoObject) {
		this.tipoparamfactusecuenciatrabajoObject = newTipoParamFactuSecuenciaTrabajoObject;
	}
	
	public List<Object> getTipoParamFactuSecuenciaTrabajosObject() {		
		this.tipoparamfactusecuenciatrabajosObject=this.tipoparamfactusecuenciatrabajoDataAccess.getEntitiesObject();
		return this.tipoparamfactusecuenciatrabajosObject;
	}
		
	public void setTipoParamFactuSecuenciaTrabajosObject(List<Object> newTipoParamFactuSecuenciaTrabajosObject) {
		this.tipoparamfactusecuenciatrabajosObject = newTipoParamFactuSecuenciaTrabajosObject;
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
		
		if(this.tipoparamfactusecuenciatrabajoDataAccess!=null) {
			this.tipoparamfactusecuenciatrabajoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoparamfactusecuenciatrabajoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoparamfactusecuenciatrabajoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoparamfactusecuenciatrabajo=tipoparamfactusecuenciatrabajoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactusecuenciatrabajo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajo);
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
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		  		  
        try {
			
			tipoparamfactusecuenciatrabajo=tipoparamfactusecuenciatrabajoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactusecuenciatrabajo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoparamfactusecuenciatrabajo=tipoparamfactusecuenciatrabajoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactusecuenciatrabajo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajo);
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
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		  		  
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
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		  		  
        try {
			
			tipoparamfactusecuenciatrabajo=tipoparamfactusecuenciatrabajoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactusecuenciatrabajo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		  		  
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
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoparamfactusecuenciatrabajoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoparamfactusecuenciatrabajoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoparamfactusecuenciatrabajoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoparamfactusecuenciatrabajoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoparamfactusecuenciatrabajoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoparamfactusecuenciatrabajoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoparamfactusecuenciatrabajos = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajos);
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
		tipoparamfactusecuenciatrabajos = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		  		  
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
		tipoparamfactusecuenciatrabajos = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		  		  
        try {			
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoparamfactusecuenciatrabajos = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		  		  
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
		tipoparamfactusecuenciatrabajos = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajos);
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
		tipoparamfactusecuenciatrabajos = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		  		  
        try {
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajos);
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
		tipoparamfactusecuenciatrabajos = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajos);
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
		tipoparamfactusecuenciatrabajos = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactusecuenciatrabajo=tipoparamfactusecuenciatrabajoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajo);
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
		tipoparamfactusecuenciatrabajo = new  TipoParamFactuSecuenciaTrabajo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactusecuenciatrabajo=tipoparamfactusecuenciatrabajoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoparamfactusecuenciatrabajos = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajos);
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
		tipoparamfactusecuenciatrabajos = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		  		  
        try {
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoParamFactuSecuenciaTrabajosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoparamfactusecuenciatrabajos = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getTodosTipoParamFactuSecuenciaTrabajosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajos);
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
	
	public  void  getTodosTipoParamFactuSecuenciaTrabajos(String sFinalQuery,Pagination pagination)throws Exception {
		tipoparamfactusecuenciatrabajos = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoParamFactuSecuenciaTrabajo(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoparamfactusecuenciatrabajo.getIsNew() || tipoparamfactusecuenciatrabajo.getIsChanged()) { 
			this.invalidValues = tipoparamfactusecuenciatrabajoValidator.getInvalidValues(tipoparamfactusecuenciatrabajo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoparamfactusecuenciatrabajo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoParamFactuSecuenciaTrabajo(List<TipoParamFactuSecuenciaTrabajo> TipoParamFactuSecuenciaTrabajos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoLocal:tipoparamfactusecuenciatrabajos) {				
			estaValidadoObjeto=this.validarGuardarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoParamFactuSecuenciaTrabajo(List<TipoParamFactuSecuenciaTrabajo> TipoParamFactuSecuenciaTrabajos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoParamFactuSecuenciaTrabajo(TipoParamFactuSecuenciaTrabajo TipoParamFactuSecuenciaTrabajo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoparamfactusecuenciatrabajo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoParamFactuSecuenciaTrabajoConstantesFunciones.getTipoParamFactuSecuenciaTrabajoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoparamfactusecuenciatrabajo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoParamFactuSecuenciaTrabajoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-saveTipoParamFactuSecuenciaTrabajoWithConnection");connexion.begin();			
			
			TipoParamFactuSecuenciaTrabajoLogicAdditional.checkTipoParamFactuSecuenciaTrabajoToSave(this.tipoparamfactusecuenciatrabajo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoParamFactuSecuenciaTrabajoLogicAdditional.updateTipoParamFactuSecuenciaTrabajoToSave(this.tipoparamfactusecuenciatrabajo,this.arrDatoGeneral);
			
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoparamfactusecuenciatrabajo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoParamFactuSecuenciaTrabajo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajo)) {
				TipoParamFactuSecuenciaTrabajoDataAccess.save(this.tipoparamfactusecuenciatrabajo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoparamfactusecuenciatrabajo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoParamFactuSecuenciaTrabajoLogicAdditional.checkTipoParamFactuSecuenciaTrabajoToSaveAfter(this.tipoparamfactusecuenciatrabajo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoParamFactuSecuenciaTrabajo();
			
			connexion.commit();			
			
			if(this.tipoparamfactusecuenciatrabajo.getIsDeleted()) {
				this.tipoparamfactusecuenciatrabajo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoParamFactuSecuenciaTrabajo()throws Exception {	
		try {	
			
			TipoParamFactuSecuenciaTrabajoLogicAdditional.checkTipoParamFactuSecuenciaTrabajoToSave(this.tipoparamfactusecuenciatrabajo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoParamFactuSecuenciaTrabajoLogicAdditional.updateTipoParamFactuSecuenciaTrabajoToSave(this.tipoparamfactusecuenciatrabajo,this.arrDatoGeneral);
			
			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoparamfactusecuenciatrabajo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajo)) {			
				TipoParamFactuSecuenciaTrabajoDataAccess.save(this.tipoparamfactusecuenciatrabajo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoparamfactusecuenciatrabajo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoParamFactuSecuenciaTrabajoLogicAdditional.checkTipoParamFactuSecuenciaTrabajoToSaveAfter(this.tipoparamfactusecuenciatrabajo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoparamfactusecuenciatrabajo.getIsDeleted()) {
				this.tipoparamfactusecuenciatrabajo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoParamFactuSecuenciaTrabajosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-saveTipoParamFactuSecuenciaTrabajosWithConnection");connexion.begin();			
			
			TipoParamFactuSecuenciaTrabajoLogicAdditional.checkTipoParamFactuSecuenciaTrabajoToSaves(tipoparamfactusecuenciatrabajos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoParamFactuSecuenciaTrabajos();
			
			Boolean validadoTodosTipoParamFactuSecuenciaTrabajo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoLocal:tipoparamfactusecuenciatrabajos) {		
				if(tipoparamfactusecuenciatrabajoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoParamFactuSecuenciaTrabajoLogicAdditional.updateTipoParamFactuSecuenciaTrabajoToSave(tipoparamfactusecuenciatrabajoLocal,this.arrDatoGeneral);
	        	
				TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoparamfactusecuenciatrabajoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajoLocal)) {
					TipoParamFactuSecuenciaTrabajoDataAccess.save(tipoparamfactusecuenciatrabajoLocal, connexion);				
				} else {
					validadoTodosTipoParamFactuSecuenciaTrabajo=false;
				}
			}
			
			if(!validadoTodosTipoParamFactuSecuenciaTrabajo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoParamFactuSecuenciaTrabajoLogicAdditional.checkTipoParamFactuSecuenciaTrabajoToSavesAfter(tipoparamfactusecuenciatrabajos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoParamFactuSecuenciaTrabajos();
			
			connexion.commit();		
			
			this.quitarTipoParamFactuSecuenciaTrabajosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoParamFactuSecuenciaTrabajos()throws Exception {				
		 try {	
			TipoParamFactuSecuenciaTrabajoLogicAdditional.checkTipoParamFactuSecuenciaTrabajoToSaves(tipoparamfactusecuenciatrabajos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoParamFactuSecuenciaTrabajo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoLocal:tipoparamfactusecuenciatrabajos) {				
				if(tipoparamfactusecuenciatrabajoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoParamFactuSecuenciaTrabajoLogicAdditional.updateTipoParamFactuSecuenciaTrabajoToSave(tipoparamfactusecuenciatrabajoLocal,this.arrDatoGeneral);
	        	
				TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoparamfactusecuenciatrabajoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajoLocal)) {				
					TipoParamFactuSecuenciaTrabajoDataAccess.save(tipoparamfactusecuenciatrabajoLocal, connexion);				
				} else {
					validadoTodosTipoParamFactuSecuenciaTrabajo=false;
				}
			}
			
			if(!validadoTodosTipoParamFactuSecuenciaTrabajo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoParamFactuSecuenciaTrabajoLogicAdditional.checkTipoParamFactuSecuenciaTrabajoToSavesAfter(tipoparamfactusecuenciatrabajos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoParamFactuSecuenciaTrabajosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoParamFactuSecuenciaTrabajoParameterReturnGeneral procesarAccionTipoParamFactuSecuenciaTrabajos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos,TipoParamFactuSecuenciaTrabajoParameterReturnGeneral tipoparamfactusecuenciatrabajoParameterGeneral)throws Exception {
		 try {	
			TipoParamFactuSecuenciaTrabajoParameterReturnGeneral tipoparamfactusecuenciatrabajoReturnGeneral=new TipoParamFactuSecuenciaTrabajoParameterReturnGeneral();
	
			TipoParamFactuSecuenciaTrabajoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoparamfactusecuenciatrabajos,tipoparamfactusecuenciatrabajoParameterGeneral,tipoparamfactusecuenciatrabajoReturnGeneral);
			
			return tipoparamfactusecuenciatrabajoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoParamFactuSecuenciaTrabajoParameterReturnGeneral procesarAccionTipoParamFactuSecuenciaTrabajosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos,TipoParamFactuSecuenciaTrabajoParameterReturnGeneral tipoparamfactusecuenciatrabajoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-procesarAccionTipoParamFactuSecuenciaTrabajosWithConnection");connexion.begin();			
			
			TipoParamFactuSecuenciaTrabajoParameterReturnGeneral tipoparamfactusecuenciatrabajoReturnGeneral=new TipoParamFactuSecuenciaTrabajoParameterReturnGeneral();
	
			TipoParamFactuSecuenciaTrabajoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoparamfactusecuenciatrabajos,tipoparamfactusecuenciatrabajoParameterGeneral,tipoparamfactusecuenciatrabajoReturnGeneral);
			
			this.connexion.commit();
			
			return tipoparamfactusecuenciatrabajoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoParamFactuSecuenciaTrabajoParameterReturnGeneral procesarEventosTipoParamFactuSecuenciaTrabajos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos,TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,TipoParamFactuSecuenciaTrabajoParameterReturnGeneral tipoparamfactusecuenciatrabajoParameterGeneral,Boolean isEsNuevoTipoParamFactuSecuenciaTrabajo,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoParamFactuSecuenciaTrabajoParameterReturnGeneral tipoparamfactusecuenciatrabajoReturnGeneral=new TipoParamFactuSecuenciaTrabajoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoparamfactusecuenciatrabajoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoParamFactuSecuenciaTrabajoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoparamfactusecuenciatrabajos,tipoparamfactusecuenciatrabajo,tipoparamfactusecuenciatrabajoParameterGeneral,tipoparamfactusecuenciatrabajoReturnGeneral,isEsNuevoTipoParamFactuSecuenciaTrabajo,clases);
			
			return tipoparamfactusecuenciatrabajoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoParamFactuSecuenciaTrabajoParameterReturnGeneral procesarEventosTipoParamFactuSecuenciaTrabajosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos,TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,TipoParamFactuSecuenciaTrabajoParameterReturnGeneral tipoparamfactusecuenciatrabajoParameterGeneral,Boolean isEsNuevoTipoParamFactuSecuenciaTrabajo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-procesarEventosTipoParamFactuSecuenciaTrabajosWithConnection");connexion.begin();			
			
			TipoParamFactuSecuenciaTrabajoParameterReturnGeneral tipoparamfactusecuenciatrabajoReturnGeneral=new TipoParamFactuSecuenciaTrabajoParameterReturnGeneral();
	
			tipoparamfactusecuenciatrabajoReturnGeneral.setTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoparamfactusecuenciatrabajoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoParamFactuSecuenciaTrabajoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoparamfactusecuenciatrabajos,tipoparamfactusecuenciatrabajo,tipoparamfactusecuenciatrabajoParameterGeneral,tipoparamfactusecuenciatrabajoReturnGeneral,isEsNuevoTipoParamFactuSecuenciaTrabajo,clases);
			
			this.connexion.commit();
			
			return tipoparamfactusecuenciatrabajoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoParamFactuSecuenciaTrabajoParameterReturnGeneral procesarImportacionTipoParamFactuSecuenciaTrabajosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoParamFactuSecuenciaTrabajoParameterReturnGeneral tipoparamfactusecuenciatrabajoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-procesarImportacionTipoParamFactuSecuenciaTrabajosWithConnection");connexion.begin();			
			
			TipoParamFactuSecuenciaTrabajoParameterReturnGeneral tipoparamfactusecuenciatrabajoReturnGeneral=new TipoParamFactuSecuenciaTrabajoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoparamfactusecuenciatrabajos=new ArrayList<TipoParamFactuSecuenciaTrabajo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoparamfactusecuenciatrabajo=new TipoParamFactuSecuenciaTrabajo();
				
				
				if(conColumnasBase) {this.tipoparamfactusecuenciatrabajo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoparamfactusecuenciatrabajo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoparamfactusecuenciatrabajo.setnombre(arrColumnas[iColumn++]);
				
				this.tipoparamfactusecuenciatrabajos.add(this.tipoparamfactusecuenciatrabajo);
			}
			
			this.saveTipoParamFactuSecuenciaTrabajos();
			
			this.connexion.commit();
			
			tipoparamfactusecuenciatrabajoReturnGeneral.setConRetornoEstaProcesado(true);
			tipoparamfactusecuenciatrabajoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoparamfactusecuenciatrabajoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoParamFactuSecuenciaTrabajosEliminados() throws Exception {				
		
		List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajosAux= new ArrayList<TipoParamFactuSecuenciaTrabajo>();
		
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo:tipoparamfactusecuenciatrabajos) {
			if(!tipoparamfactusecuenciatrabajo.getIsDeleted()) {
				tipoparamfactusecuenciatrabajosAux.add(tipoparamfactusecuenciatrabajo);
			}
		}
		
		tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajosAux;
	}
	
	public void quitarTipoParamFactuSecuenciaTrabajosNulos() throws Exception {				
		
		List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajosAux= new ArrayList<TipoParamFactuSecuenciaTrabajo>();
		
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo : this.tipoparamfactusecuenciatrabajos) {
			if(tipoparamfactusecuenciatrabajo==null) {
				tipoparamfactusecuenciatrabajosAux.add(tipoparamfactusecuenciatrabajo);
			}
		}
		
		//this.tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajosAux;
		
		this.tipoparamfactusecuenciatrabajos.removeAll(tipoparamfactusecuenciatrabajosAux);
	}
	
	public void getSetVersionRowTipoParamFactuSecuenciaTrabajoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoparamfactusecuenciatrabajo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoparamfactusecuenciatrabajo.getIsDeleted() || (tipoparamfactusecuenciatrabajo.getIsChanged()&&!tipoparamfactusecuenciatrabajo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoparamfactusecuenciatrabajoDataAccess.getSetVersionRowTipoParamFactuSecuenciaTrabajo(connexion,tipoparamfactusecuenciatrabajo.getId());
				
				if(!tipoparamfactusecuenciatrabajo.getVersionRow().equals(timestamp)) {	
					tipoparamfactusecuenciatrabajo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoparamfactusecuenciatrabajo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoParamFactuSecuenciaTrabajo()throws Exception {	
		
		if(tipoparamfactusecuenciatrabajo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoparamfactusecuenciatrabajo.getIsDeleted() || (tipoparamfactusecuenciatrabajo.getIsChanged()&&!tipoparamfactusecuenciatrabajo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoparamfactusecuenciatrabajoDataAccess.getSetVersionRowTipoParamFactuSecuenciaTrabajo(connexion,tipoparamfactusecuenciatrabajo.getId());
			
			try {							
				if(!tipoparamfactusecuenciatrabajo.getVersionRow().equals(timestamp)) {	
					tipoparamfactusecuenciatrabajo.setVersionRow(timestamp);
				}
				
				tipoparamfactusecuenciatrabajo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoParamFactuSecuenciaTrabajosWithConnection()throws Exception {	
		if(tipoparamfactusecuenciatrabajos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoAux:tipoparamfactusecuenciatrabajos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoparamfactusecuenciatrabajoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoparamfactusecuenciatrabajoAux.getIsDeleted() || (tipoparamfactusecuenciatrabajoAux.getIsChanged()&&!tipoparamfactusecuenciatrabajoAux.getIsNew())) {
						
						timestamp=tipoparamfactusecuenciatrabajoDataAccess.getSetVersionRowTipoParamFactuSecuenciaTrabajo(connexion,tipoparamfactusecuenciatrabajoAux.getId());
						
						if(!tipoparamfactusecuenciatrabajo.getVersionRow().equals(timestamp)) {	
							tipoparamfactusecuenciatrabajoAux.setVersionRow(timestamp);
						}
								
						tipoparamfactusecuenciatrabajoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoParamFactuSecuenciaTrabajos()throws Exception {	
		if(tipoparamfactusecuenciatrabajos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoAux:tipoparamfactusecuenciatrabajos) {
					if(tipoparamfactusecuenciatrabajoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoparamfactusecuenciatrabajoAux.getIsDeleted() || (tipoparamfactusecuenciatrabajoAux.getIsChanged()&&!tipoparamfactusecuenciatrabajoAux.getIsNew())) {
						
						timestamp=tipoparamfactusecuenciatrabajoDataAccess.getSetVersionRowTipoParamFactuSecuenciaTrabajo(connexion,tipoparamfactusecuenciatrabajoAux.getId());
						
						if(!tipoparamfactusecuenciatrabajoAux.getVersionRow().equals(timestamp)) {	
							tipoparamfactusecuenciatrabajoAux.setVersionRow(timestamp);
						}
						
													
						tipoparamfactusecuenciatrabajoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoParamFactuSecuenciaTrabajoLogicAdditional.updateTipoParamFactuSecuenciaTrabajoToGet(tipoparamfactusecuenciatrabajo,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoParamFactuSecuenciaTrabajoLogicAdditional.updateTipoParamFactuSecuenciaTrabajoToSave(tipoparamfactusecuenciatrabajo,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoparamfactusecuenciatrabajo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajo);
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
			this.deepLoad(this.tipoparamfactusecuenciatrabajo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoparamfactusecuenciatrabajos!=null) {
				for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo:tipoparamfactusecuenciatrabajos) {
					this.deepLoad(tipoparamfactusecuenciatrabajo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos);
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
			if(tipoparamfactusecuenciatrabajos!=null) {
				for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo:tipoparamfactusecuenciatrabajos) {
					this.deepLoad(tipoparamfactusecuenciatrabajo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajos);
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
			this.getNewConnexionToDeep(TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoparamfactusecuenciatrabajo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoparamfactusecuenciatrabajos!=null) {
				for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo:tipoparamfactusecuenciatrabajos) {
					this.deepSave(tipoparamfactusecuenciatrabajo,isDeep,deepLoadType,clases);
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
			if(tipoparamfactusecuenciatrabajos!=null) {
				for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo:tipoparamfactusecuenciatrabajos) {
					this.deepSave(tipoparamfactusecuenciatrabajo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoParamFactuSecuenciaTrabajosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoParamFactuSecuenciaTrabajosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoparamfactusecuenciatrabajos=tipoparamfactusecuenciatrabajoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoParamFactuSecuenciaTrabajoPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuSecuenciaTrabajo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoparamfactusecuenciatrabajo=tipoparamfactusecuenciatrabajoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactusecuenciatrabajo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajo);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoParamFactuSecuenciaTrabajoPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoparamfactusecuenciatrabajo=tipoparamfactusecuenciatrabajoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactusecuenciatrabajo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoParamFactuSecuenciaTrabajoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(this.tipoparamfactusecuenciatrabajo);
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
			if(TipoParamFactuSecuenciaTrabajoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuSecuenciaTrabajoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoParamFactuSecuenciaTrabajoConstantesFunciones.ISCONAUDITORIA) {
				if(tipoparamfactusecuenciatrabajo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuSecuenciaTrabajoDataAccess.TABLENAME, tipoparamfactusecuenciatrabajo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoParamFactuSecuenciaTrabajoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoriaDetallesTipoParamFactuSecuenciaTrabajo(connexion,tipoparamfactusecuenciatrabajo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoparamfactusecuenciatrabajo.getIsDeleted()) {
					/*if(!tipoparamfactusecuenciatrabajo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoParamFactuSecuenciaTrabajoDataAccess.TABLENAME, tipoparamfactusecuenciatrabajo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoriaDetallesTipoParamFactuSecuenciaTrabajo(connexion,tipoparamfactusecuenciatrabajo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuSecuenciaTrabajoDataAccess.TABLENAME, tipoparamfactusecuenciatrabajo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoparamfactusecuenciatrabajo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuSecuenciaTrabajoDataAccess.TABLENAME, tipoparamfactusecuenciatrabajo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoParamFactuSecuenciaTrabajoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoParamFactuSecuenciaTrabajoLogic.registrarAuditoriaDetallesTipoParamFactuSecuenciaTrabajo(connexion,tipoparamfactusecuenciatrabajo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoParamFactuSecuenciaTrabajo(Connexion connexion,TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoparamfactusecuenciatrabajo.getIsNew()||!tipoparamfactusecuenciatrabajo.getnombre().equals(tipoparamfactusecuenciatrabajo.getTipoParamFactuSecuenciaTrabajoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoparamfactusecuenciatrabajo.getTipoParamFactuSecuenciaTrabajoOriginal().getnombre()!=null)
				{
					strValorActual=tipoparamfactusecuenciatrabajo.getTipoParamFactuSecuenciaTrabajoOriginal().getnombre();
				}
				if(tipoparamfactusecuenciatrabajo.getnombre()!=null)
				{
					strValorNuevo=tipoparamfactusecuenciatrabajo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoParamFactuSecuenciaTrabajoRelacionesWithConnection(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo) throws Exception {

		if(!tipoparamfactusecuenciatrabajo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoParamFactuSecuenciaTrabajoRelacionesBase(tipoparamfactusecuenciatrabajo,true);
		}
	}

	public void saveTipoParamFactuSecuenciaTrabajoRelaciones(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo)throws Exception {

		if(!tipoparamfactusecuenciatrabajo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoParamFactuSecuenciaTrabajoRelacionesBase(tipoparamfactusecuenciatrabajo,false);
		}
	}

	public void saveTipoParamFactuSecuenciaTrabajoRelacionesBase(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoParamFactuSecuenciaTrabajo-saveRelacionesWithConnection");}
	

			this.setTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajo);

				if((tipoparamfactusecuenciatrabajo.getIsNew()||tipoparamfactusecuenciatrabajo.getIsChanged())&&!tipoparamfactusecuenciatrabajo.getIsDeleted()) {
					this.saveTipoParamFactuSecuenciaTrabajo();
					this.saveTipoParamFactuSecuenciaTrabajoRelacionesDetalles();

				} else if(tipoparamfactusecuenciatrabajo.getIsDeleted()) {
					this.saveTipoParamFactuSecuenciaTrabajoRelacionesDetalles();
					this.saveTipoParamFactuSecuenciaTrabajo();
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
	
	
	private void saveTipoParamFactuSecuenciaTrabajoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoParamFactuSecuenciaTrabajo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoParamFactuSecuenciaTrabajoConstantesFunciones.getClassesForeignKeysOfTipoParamFactuSecuenciaTrabajo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParamFactuSecuenciaTrabajo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoParamFactuSecuenciaTrabajoConstantesFunciones.getClassesRelationshipsOfTipoParamFactuSecuenciaTrabajo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.TipoIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoIvaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoIva;
import com.bydan.erp.contabilidad.business.logic.TipoIvaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.sris.business.logic.*;


import com.bydan.erp.sris.util.*;


import com.bydan.erp.sris.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoIvaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoIvaLogic.class);
	
	protected TipoIvaDataAccess tipoivaDataAccess; 	
	protected TipoIva tipoiva;
	protected List<TipoIva> tipoivas;
	protected Object tipoivaObject;	
	protected List<Object> tipoivasObject;
	
	public static ClassValidator<TipoIva> tipoivaValidator = new ClassValidator<TipoIva>(TipoIva.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoIvaLogicAdditional tipoivaLogicAdditional=null;
	
	public TipoIvaLogicAdditional getTipoIvaLogicAdditional() {
		return this.tipoivaLogicAdditional;
	}
	
	public void setTipoIvaLogicAdditional(TipoIvaLogicAdditional tipoivaLogicAdditional) {
		try {
			this.tipoivaLogicAdditional=tipoivaLogicAdditional;
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
	
	
	
	
	public  TipoIvaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoivaDataAccess = new TipoIvaDataAccess();
			
			this.tipoivas= new ArrayList<TipoIva>();
			this.tipoiva= new TipoIva();
			
			this.tipoivaObject=new Object();
			this.tipoivasObject=new ArrayList<Object>();
				
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
			
			this.tipoivaDataAccess.setConnexionType(this.connexionType);
			this.tipoivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoIvaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoivaDataAccess = new TipoIvaDataAccess();
			this.tipoivas= new ArrayList<TipoIva>();
			this.tipoiva= new TipoIva();
			this.tipoivaObject=new Object();
			this.tipoivasObject=new ArrayList<Object>();
			
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
			
			this.tipoivaDataAccess.setConnexionType(this.connexionType);
			this.tipoivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoIva getTipoIva() throws Exception {	
		TipoIvaLogicAdditional.checkTipoIvaToGet(tipoiva,this.datosCliente,this.arrDatoGeneral);
		TipoIvaLogicAdditional.updateTipoIvaToGet(tipoiva,this.arrDatoGeneral);
		
		return tipoiva;
	}
		
	public void setTipoIva(TipoIva newTipoIva) {
		this.tipoiva = newTipoIva;
	}
	
	public TipoIvaDataAccess getTipoIvaDataAccess() {
		return tipoivaDataAccess;
	}
	
	public void setTipoIvaDataAccess(TipoIvaDataAccess newtipoivaDataAccess) {
		this.tipoivaDataAccess = newtipoivaDataAccess;
	}
	
	public List<TipoIva> getTipoIvas() throws Exception {		
		this.quitarTipoIvasNulos();
		
		TipoIvaLogicAdditional.checkTipoIvaToGets(tipoivas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoIva tipoivaLocal: tipoivas ) {
			TipoIvaLogicAdditional.updateTipoIvaToGet(tipoivaLocal,this.arrDatoGeneral);
		}
		
		return tipoivas;
	}
	
	public void setTipoIvas(List<TipoIva> newTipoIvas) {
		this.tipoivas = newTipoIvas;
	}
	
	public Object getTipoIvaObject() {	
		this.tipoivaObject=this.tipoivaDataAccess.getEntityObject();
		return this.tipoivaObject;
	}
		
	public void setTipoIvaObject(Object newTipoIvaObject) {
		this.tipoivaObject = newTipoIvaObject;
	}
	
	public List<Object> getTipoIvasObject() {		
		this.tipoivasObject=this.tipoivaDataAccess.getEntitiesObject();
		return this.tipoivasObject;
	}
		
	public void setTipoIvasObject(List<Object> newTipoIvasObject) {
		this.tipoivasObject = newTipoIvasObject;
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
		
		if(this.tipoivaDataAccess!=null) {
			this.tipoivaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoiva = new  TipoIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoiva=tipoivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoiva);
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
		tipoiva = new  TipoIva();
		  		  
        try {
			
			tipoiva=tipoivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoiva = new  TipoIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoiva=tipoivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoiva);
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
		tipoiva = new  TipoIva();
		  		  
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
		tipoiva = new  TipoIva();
		  		  
        try {
			
			tipoiva=tipoivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoiva = new  TipoIva();
		  		  
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
		tipoiva = new  TipoIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoiva = new  TipoIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoiva = new  TipoIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoiva = new  TipoIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoiva = new  TipoIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoiva = new  TipoIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoivas = new  ArrayList<TipoIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivas=tipoivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIva(tipoivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoivas);
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
		tipoivas = new  ArrayList<TipoIva>();
		  		  
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
		tipoivas = new  ArrayList<TipoIva>();
		  		  
        try {			
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivas=tipoivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoIva(tipoivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoivas = new  ArrayList<TipoIva>();
		  		  
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
		tipoivas = new  ArrayList<TipoIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivas=tipoivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIva(tipoivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoivas);
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
		tipoivas = new  ArrayList<TipoIva>();
		  		  
        try {
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivas=tipoivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIva(tipoivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoivas);
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
		tipoivas = new  ArrayList<TipoIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivas=tipoivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIva(tipoivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoivas);
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
		tipoivas = new  ArrayList<TipoIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivas=tipoivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIva(tipoivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoiva = new  TipoIva();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoiva=tipoivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIva(tipoiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoiva);
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
		tipoiva = new  TipoIva();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoiva=tipoivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIva(tipoiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoivas = new  ArrayList<TipoIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivas=tipoivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIva(tipoivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoivas);
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
		tipoivas = new  ArrayList<TipoIva>();
		  		  
        try {
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivas=tipoivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIva(tipoivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoIvasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoivas = new  ArrayList<TipoIva>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-getTodosTipoIvasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivas=tipoivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoIva(tipoivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoivas);
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
	
	public  void  getTodosTipoIvas(String sFinalQuery,Pagination pagination)throws Exception {
		tipoivas = new  ArrayList<TipoIva>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivas=tipoivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoIva(tipoivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoIva(TipoIva tipoiva) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoiva.getIsNew() || tipoiva.getIsChanged()) { 
			this.invalidValues = tipoivaValidator.getInvalidValues(tipoiva);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoiva);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoIva(List<TipoIva> TipoIvas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoIva tipoivaLocal:tipoivas) {				
			estaValidadoObjeto=this.validarGuardarTipoIva(tipoivaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoIva(List<TipoIva> TipoIvas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoIva(tipoivas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoIva(TipoIva TipoIva) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoIva(tipoiva)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoIva tipoiva) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoiva.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoIvaConstantesFunciones.getTipoIvaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoiva","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoIvaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-saveTipoIvaWithConnection");connexion.begin();			
			
			TipoIvaLogicAdditional.checkTipoIvaToSave(this.tipoiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoIvaLogicAdditional.updateTipoIvaToSave(this.tipoiva,this.arrDatoGeneral);
			
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoIva();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoIva(this.tipoiva)) {
				TipoIvaDataAccess.save(this.tipoiva, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoIvaLogicAdditional.checkTipoIvaToSaveAfter(this.tipoiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoIva();
			
			connexion.commit();			
			
			if(this.tipoiva.getIsDeleted()) {
				this.tipoiva=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoIva()throws Exception {	
		try {	
			
			TipoIvaLogicAdditional.checkTipoIvaToSave(this.tipoiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoIvaLogicAdditional.updateTipoIvaToSave(this.tipoiva,this.arrDatoGeneral);
			
			TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoIva(this.tipoiva)) {			
				TipoIvaDataAccess.save(this.tipoiva, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoIvaLogicAdditional.checkTipoIvaToSaveAfter(this.tipoiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoiva.getIsDeleted()) {
				this.tipoiva=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoIvasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-saveTipoIvasWithConnection");connexion.begin();			
			
			TipoIvaLogicAdditional.checkTipoIvaToSaves(tipoivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoIvas();
			
			Boolean validadoTodosTipoIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoIva tipoivaLocal:tipoivas) {		
				if(tipoivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoIvaLogicAdditional.updateTipoIvaToSave(tipoivaLocal,this.arrDatoGeneral);
	        	
				TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoIva(tipoivaLocal)) {
					TipoIvaDataAccess.save(tipoivaLocal, connexion);				
				} else {
					validadoTodosTipoIva=false;
				}
			}
			
			if(!validadoTodosTipoIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoIvaLogicAdditional.checkTipoIvaToSavesAfter(tipoivas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoIvas();
			
			connexion.commit();		
			
			this.quitarTipoIvasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoIvas()throws Exception {				
		 try {	
			TipoIvaLogicAdditional.checkTipoIvaToSaves(tipoivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoIva tipoivaLocal:tipoivas) {				
				if(tipoivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoIvaLogicAdditional.updateTipoIvaToSave(tipoivaLocal,this.arrDatoGeneral);
	        	
				TipoIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoIva(tipoivaLocal)) {				
					TipoIvaDataAccess.save(tipoivaLocal, connexion);				
				} else {
					validadoTodosTipoIva=false;
				}
			}
			
			if(!validadoTodosTipoIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoIvaLogicAdditional.checkTipoIvaToSavesAfter(tipoivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoIvasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoIvaParameterReturnGeneral procesarAccionTipoIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoIva> tipoivas,TipoIvaParameterReturnGeneral tipoivaParameterGeneral)throws Exception {
		 try {	
			TipoIvaParameterReturnGeneral tipoivaReturnGeneral=new TipoIvaParameterReturnGeneral();
	
			TipoIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoivas,tipoivaParameterGeneral,tipoivaReturnGeneral);
			
			return tipoivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoIvaParameterReturnGeneral procesarAccionTipoIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoIva> tipoivas,TipoIvaParameterReturnGeneral tipoivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-procesarAccionTipoIvasWithConnection");connexion.begin();			
			
			TipoIvaParameterReturnGeneral tipoivaReturnGeneral=new TipoIvaParameterReturnGeneral();
	
			TipoIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoivas,tipoivaParameterGeneral,tipoivaReturnGeneral);
			
			this.connexion.commit();
			
			return tipoivaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoIvaParameterReturnGeneral procesarEventosTipoIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoIva> tipoivas,TipoIva tipoiva,TipoIvaParameterReturnGeneral tipoivaParameterGeneral,Boolean isEsNuevoTipoIva,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoIvaParameterReturnGeneral tipoivaReturnGeneral=new TipoIvaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoivas,tipoiva,tipoivaParameterGeneral,tipoivaReturnGeneral,isEsNuevoTipoIva,clases);
			
			return tipoivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoIvaParameterReturnGeneral procesarEventosTipoIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoIva> tipoivas,TipoIva tipoiva,TipoIvaParameterReturnGeneral tipoivaParameterGeneral,Boolean isEsNuevoTipoIva,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-procesarEventosTipoIvasWithConnection");connexion.begin();			
			
			TipoIvaParameterReturnGeneral tipoivaReturnGeneral=new TipoIvaParameterReturnGeneral();
	
			tipoivaReturnGeneral.setTipoIva(tipoiva);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoivas,tipoiva,tipoivaParameterGeneral,tipoivaReturnGeneral,isEsNuevoTipoIva,clases);
			
			this.connexion.commit();
			
			return tipoivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoIvaParameterReturnGeneral procesarImportacionTipoIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoIvaParameterReturnGeneral tipoivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-procesarImportacionTipoIvasWithConnection");connexion.begin();			
			
			TipoIvaParameterReturnGeneral tipoivaReturnGeneral=new TipoIvaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoivas=new ArrayList<TipoIva>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoiva=new TipoIva();
				
				
				if(conColumnasBase) {this.tipoiva.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoiva.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoiva.setcodigo(arrColumnas[iColumn++]);
				this.tipoiva.setnombre(arrColumnas[iColumn++]);
				
				this.tipoivas.add(this.tipoiva);
			}
			
			this.saveTipoIvas();
			
			this.connexion.commit();
			
			tipoivaReturnGeneral.setConRetornoEstaProcesado(true);
			tipoivaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoIvasEliminados() throws Exception {				
		
		List<TipoIva> tipoivasAux= new ArrayList<TipoIva>();
		
		for(TipoIva tipoiva:tipoivas) {
			if(!tipoiva.getIsDeleted()) {
				tipoivasAux.add(tipoiva);
			}
		}
		
		tipoivas=tipoivasAux;
	}
	
	public void quitarTipoIvasNulos() throws Exception {				
		
		List<TipoIva> tipoivasAux= new ArrayList<TipoIva>();
		
		for(TipoIva tipoiva : this.tipoivas) {
			if(tipoiva==null) {
				tipoivasAux.add(tipoiva);
			}
		}
		
		//this.tipoivas=tipoivasAux;
		
		this.tipoivas.removeAll(tipoivasAux);
	}
	
	public void getSetVersionRowTipoIvaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoiva.getIsDeleted() || (tipoiva.getIsChanged()&&!tipoiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoivaDataAccess.getSetVersionRowTipoIva(connexion,tipoiva.getId());
				
				if(!tipoiva.getVersionRow().equals(timestamp)) {	
					tipoiva.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoIva()throws Exception {	
		
		if(tipoiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoiva.getIsDeleted() || (tipoiva.getIsChanged()&&!tipoiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoivaDataAccess.getSetVersionRowTipoIva(connexion,tipoiva.getId());
			
			try {							
				if(!tipoiva.getVersionRow().equals(timestamp)) {	
					tipoiva.setVersionRow(timestamp);
				}
				
				tipoiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoIvasWithConnection()throws Exception {	
		if(tipoivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoIva tipoivaAux:tipoivas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoivaAux.getIsDeleted() || (tipoivaAux.getIsChanged()&&!tipoivaAux.getIsNew())) {
						
						timestamp=tipoivaDataAccess.getSetVersionRowTipoIva(connexion,tipoivaAux.getId());
						
						if(!tipoiva.getVersionRow().equals(timestamp)) {	
							tipoivaAux.setVersionRow(timestamp);
						}
								
						tipoivaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoIvas()throws Exception {	
		if(tipoivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoIva tipoivaAux:tipoivas) {
					if(tipoivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoivaAux.getIsDeleted() || (tipoivaAux.getIsChanged()&&!tipoivaAux.getIsNew())) {
						
						timestamp=tipoivaDataAccess.getSetVersionRowTipoIva(connexion,tipoivaAux.getId());
						
						if(!tipoivaAux.getVersionRow().equals(timestamp)) {	
							tipoivaAux.setVersionRow(timestamp);
						}
						
													
						tipoivaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoIvaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TransaccionLocalLogic transaccionlocalLogic=new TransaccionLocalLogic();
			FacturaDiarioLogic facturadiarioLogic=new FacturaDiarioLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoIvaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TransaccionLocal.class));
			classes.add(new Classe(FacturaDiario.class));
											
			

			transaccionlocalLogic.setConnexion(this.getConnexion());
			transaccionlocalLogic.setDatosCliente(this.datosCliente);
			transaccionlocalLogic.setIsConRefrescarForeignKeys(true);

			facturadiarioLogic.setConnexion(this.getConnexion());
			facturadiarioLogic.setDatosCliente(this.datosCliente);
			facturadiarioLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoIva tipoiva:this.tipoivas) {
				

				classes=new ArrayList<Classe>();
				classes=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);

				transaccionlocalLogic.setTransaccionLocals(tipoiva.transaccionlocals);
				transaccionlocalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FacturaDiarioConstantesFunciones.getClassesForeignKeysOfFacturaDiario(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturadiarioLogic.setFacturaDiarios(tipoiva.facturadiarios);
				facturadiarioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoIva tipoiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoIvaLogicAdditional.updateTipoIvaToGet(tipoiva,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoiva.setTransaccionLocals(tipoivaDataAccess.getTransaccionLocals(connexion,tipoiva));
		tipoiva.setFacturaDiarios(tipoivaDataAccess.getFacturaDiarios(connexion,tipoiva));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoiva.setTransaccionLocals(tipoivaDataAccess.getTransaccionLocals(connexion,tipoiva));

				if(this.isConDeep) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(this.connexion);
					transaccionlocalLogic.setTransaccionLocals(tipoiva.getTransaccionLocals());
					ArrayList<Classe> classesLocal=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);
					transaccionlocalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(transaccionlocalLogic.getTransaccionLocals());
					tipoiva.setTransaccionLocals(transaccionlocalLogic.getTransaccionLocals());
				}

				continue;
			}

			if(clas.clas.equals(FacturaDiario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoiva.setFacturaDiarios(tipoivaDataAccess.getFacturaDiarios(connexion,tipoiva));

				if(this.isConDeep) {
					FacturaDiarioLogic facturadiarioLogic= new FacturaDiarioLogic(this.connexion);
					facturadiarioLogic.setFacturaDiarios(tipoiva.getFacturaDiarios());
					ArrayList<Classe> classesLocal=FacturaDiarioConstantesFunciones.getClassesForeignKeysOfFacturaDiario(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturadiarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(facturadiarioLogic.getFacturaDiarios());
					tipoiva.setFacturaDiarios(facturadiarioLogic.getFacturaDiarios());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TransaccionLocal.class));
			tipoiva.setTransaccionLocals(tipoivaDataAccess.getTransaccionLocals(connexion,tipoiva));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaDiario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaDiario.class));
			tipoiva.setFacturaDiarios(tipoivaDataAccess.getFacturaDiarios(connexion,tipoiva));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipoiva.setTransaccionLocals(tipoivaDataAccess.getTransaccionLocals(connexion,tipoiva));

		for(TransaccionLocal transaccionlocal:tipoiva.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
		}

		tipoiva.setFacturaDiarios(tipoivaDataAccess.getFacturaDiarios(connexion,tipoiva));

		for(FacturaDiario facturadiario:tipoiva.getFacturaDiarios()) {
			FacturaDiarioLogic facturadiarioLogic= new FacturaDiarioLogic(connexion);
			facturadiarioLogic.deepLoad(facturadiario,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoiva.setTransaccionLocals(tipoivaDataAccess.getTransaccionLocals(connexion,tipoiva));

				for(TransaccionLocal transaccionlocal:tipoiva.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaDiario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoiva.setFacturaDiarios(tipoivaDataAccess.getFacturaDiarios(connexion,tipoiva));

				for(FacturaDiario facturadiario:tipoiva.getFacturaDiarios()) {
					FacturaDiarioLogic facturadiarioLogic= new FacturaDiarioLogic(connexion);
					facturadiarioLogic.deepLoad(facturadiario,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TransaccionLocal.class));
			tipoiva.setTransaccionLocals(tipoivaDataAccess.getTransaccionLocals(connexion,tipoiva));

			for(TransaccionLocal transaccionlocal:tipoiva.getTransaccionLocals()) {
				TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
				transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaDiario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaDiario.class));
			tipoiva.setFacturaDiarios(tipoivaDataAccess.getFacturaDiarios(connexion,tipoiva));

			for(FacturaDiario facturadiario:tipoiva.getFacturaDiarios()) {
				FacturaDiarioLogic facturadiarioLogic= new FacturaDiarioLogic(connexion);
				facturadiarioLogic.deepLoad(facturadiario,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoIva tipoiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoIvaLogicAdditional.updateTipoIvaToSave(tipoiva,this.arrDatoGeneral);
			
TipoIvaDataAccess.save(tipoiva, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(TransaccionLocal transaccionlocal:tipoiva.getTransaccionLocals()) {
			transaccionlocal.setid_tipo_iva(tipoiva.getId());
			TransaccionLocalDataAccess.save(transaccionlocal,connexion);
		}

		for(FacturaDiario facturadiario:tipoiva.getFacturaDiarios()) {
			facturadiario.setid_tipo_iva(tipoiva.getId());
			FacturaDiarioDataAccess.save(facturadiario,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TransaccionLocal transaccionlocal:tipoiva.getTransaccionLocals()) {
					transaccionlocal.setid_tipo_iva(tipoiva.getId());
					TransaccionLocalDataAccess.save(transaccionlocal,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FacturaDiario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaDiario facturadiario:tipoiva.getFacturaDiarios()) {
					facturadiario.setid_tipo_iva(tipoiva.getId());
					FacturaDiarioDataAccess.save(facturadiario,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(TransaccionLocal transaccionlocal:tipoiva.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocal.setid_tipo_iva(tipoiva.getId());
			TransaccionLocalDataAccess.save(transaccionlocal,connexion);
			transaccionlocalLogic.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
		}

		for(FacturaDiario facturadiario:tipoiva.getFacturaDiarios()) {
			FacturaDiarioLogic facturadiarioLogic= new FacturaDiarioLogic(connexion);
			facturadiario.setid_tipo_iva(tipoiva.getId());
			FacturaDiarioDataAccess.save(facturadiario,connexion);
			facturadiarioLogic.deepSave(facturadiario,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TransaccionLocal transaccionlocal:tipoiva.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocal.setid_tipo_iva(tipoiva.getId());
					TransaccionLocalDataAccess.save(transaccionlocal,connexion);
					transaccionlocalLogic.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaDiario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaDiario facturadiario:tipoiva.getFacturaDiarios()) {
					FacturaDiarioLogic facturadiarioLogic= new FacturaDiarioLogic(connexion);
					facturadiario.setid_tipo_iva(tipoiva.getId());
					FacturaDiarioDataAccess.save(facturadiario,connexion);
					facturadiarioLogic.deepSave(facturadiario,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoIva.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(tipoiva);
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
			this.deepLoad(this.tipoiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoIva.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoivas!=null) {
				for(TipoIva tipoiva:tipoivas) {
					this.deepLoad(tipoiva,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(tipoivas);
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
			if(tipoivas!=null) {
				for(TipoIva tipoiva:tipoivas) {
					this.deepLoad(tipoiva,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(tipoivas);
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
			this.getNewConnexionToDeep(TipoIva.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoiva,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoIva.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoivas!=null) {
				for(TipoIva tipoiva:tipoivas) {
					this.deepSave(tipoiva,isDeep,deepLoadType,clases);
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
			if(tipoivas!=null) {
				for(TipoIva tipoiva:tipoivas) {
					this.deepSave(tipoiva,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoIvaPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,TipoIvaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			tipoiva=tipoivaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoiva);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoIvaPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,TipoIvaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			tipoiva=tipoivaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoIva(this.tipoiva);
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
			if(TipoIvaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIvaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoIva tipoiva,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoIvaConstantesFunciones.ISCONAUDITORIA) {
				if(tipoiva.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIvaDataAccess.TABLENAME, tipoiva.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoIvaLogic.registrarAuditoriaDetallesTipoIva(connexion,tipoiva,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoiva.getIsDeleted()) {
					/*if(!tipoiva.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoIvaDataAccess.TABLENAME, tipoiva.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoIvaLogic.registrarAuditoriaDetallesTipoIva(connexion,tipoiva,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIvaDataAccess.TABLENAME, tipoiva.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoiva.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIvaDataAccess.TABLENAME, tipoiva.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoIvaLogic.registrarAuditoriaDetallesTipoIva(connexion,tipoiva,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoIva(Connexion connexion,TipoIva tipoiva)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoiva.getIsNew()||!tipoiva.getcodigo().equals(tipoiva.getTipoIvaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoiva.getTipoIvaOriginal().getcodigo()!=null)
				{
					strValorActual=tipoiva.getTipoIvaOriginal().getcodigo();
				}
				if(tipoiva.getcodigo()!=null)
				{
					strValorNuevo=tipoiva.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoIvaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoiva.getIsNew()||!tipoiva.getnombre().equals(tipoiva.getTipoIvaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoiva.getTipoIvaOriginal().getnombre()!=null)
				{
					strValorActual=tipoiva.getTipoIvaOriginal().getnombre();
				}
				if(tipoiva.getnombre()!=null)
				{
					strValorNuevo=tipoiva.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoIvaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoIvaRelacionesWithConnection(TipoIva tipoiva,List<TransaccionLocal> transaccionlocals,List<FacturaDiario> facturadiarios) throws Exception {

		if(!tipoiva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoIvaRelacionesBase(tipoiva,transaccionlocals,facturadiarios,true);
		}
	}

	public void saveTipoIvaRelaciones(TipoIva tipoiva,List<TransaccionLocal> transaccionlocals,List<FacturaDiario> facturadiarios)throws Exception {

		if(!tipoiva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoIvaRelacionesBase(tipoiva,transaccionlocals,facturadiarios,false);
		}
	}

	public void saveTipoIvaRelacionesBase(TipoIva tipoiva,List<TransaccionLocal> transaccionlocals,List<FacturaDiario> facturadiarios,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoIva-saveRelacionesWithConnection");}
	
			tipoiva.setTransaccionLocals(transaccionlocals);
			tipoiva.setFacturaDiarios(facturadiarios);

			this.setTipoIva(tipoiva);

				if((tipoiva.getIsNew()||tipoiva.getIsChanged())&&!tipoiva.getIsDeleted()) {
					this.saveTipoIva();
					this.saveTipoIvaRelacionesDetalles(transaccionlocals,facturadiarios);

				} else if(tipoiva.getIsDeleted()) {
					this.saveTipoIvaRelacionesDetalles(transaccionlocals,facturadiarios);
					this.saveTipoIva();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TransaccionLocalConstantesFunciones.InicializarGeneralEntityAuxiliaresTransaccionLocals(transaccionlocals,true,true);
			FacturaDiarioConstantesFunciones.InicializarGeneralEntityAuxiliaresFacturaDiarios(facturadiarios,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoIvaRelacionesDetalles(List<TransaccionLocal> transaccionlocals,List<FacturaDiario> facturadiarios)throws Exception {
		try {
	

			Long idTipoIvaActual=this.getTipoIva().getId();

			TransaccionLocalLogic transaccionlocalLogic_Desde_TipoIva=new TransaccionLocalLogic();
			transaccionlocalLogic_Desde_TipoIva.setTransaccionLocals(transaccionlocals);

			transaccionlocalLogic_Desde_TipoIva.setConnexion(this.getConnexion());
			transaccionlocalLogic_Desde_TipoIva.setDatosCliente(this.datosCliente);

			for(TransaccionLocal transaccionlocal_Desde_TipoIva:transaccionlocalLogic_Desde_TipoIva.getTransaccionLocals()) {
				transaccionlocal_Desde_TipoIva.setid_tipo_iva(idTipoIvaActual);
			}

			transaccionlocalLogic_Desde_TipoIva.saveTransaccionLocals();

			FacturaDiarioLogic facturadiarioLogic_Desde_TipoIva=new FacturaDiarioLogic();
			facturadiarioLogic_Desde_TipoIva.setFacturaDiarios(facturadiarios);

			facturadiarioLogic_Desde_TipoIva.setConnexion(this.getConnexion());
			facturadiarioLogic_Desde_TipoIva.setDatosCliente(this.datosCliente);

			for(FacturaDiario facturadiario_Desde_TipoIva:facturadiarioLogic_Desde_TipoIva.getFacturaDiarios()) {
				facturadiario_Desde_TipoIva.setid_tipo_iva(idTipoIvaActual);
			}

			facturadiarioLogic_Desde_TipoIva.saveFacturaDiarios();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoIvaConstantesFunciones.getClassesForeignKeysOfTipoIva(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoIvaConstantesFunciones.getClassesRelationshipsOfTipoIva(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

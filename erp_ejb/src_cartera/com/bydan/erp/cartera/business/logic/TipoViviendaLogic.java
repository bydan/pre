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
import com.bydan.erp.cartera.util.TipoViviendaConstantesFunciones;
import com.bydan.erp.cartera.util.TipoViviendaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoViviendaParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoVivienda;
import com.bydan.erp.cartera.business.logic.TipoViviendaLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoViviendaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoViviendaLogic.class);
	
	protected TipoViviendaDataAccess tipoviviendaDataAccess; 	
	protected TipoVivienda tipovivienda;
	protected List<TipoVivienda> tipoviviendas;
	protected Object tipoviviendaObject;	
	protected List<Object> tipoviviendasObject;
	
	public static ClassValidator<TipoVivienda> tipoviviendaValidator = new ClassValidator<TipoVivienda>(TipoVivienda.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoViviendaLogicAdditional tipoviviendaLogicAdditional=null;
	
	public TipoViviendaLogicAdditional getTipoViviendaLogicAdditional() {
		return this.tipoviviendaLogicAdditional;
	}
	
	public void setTipoViviendaLogicAdditional(TipoViviendaLogicAdditional tipoviviendaLogicAdditional) {
		try {
			this.tipoviviendaLogicAdditional=tipoviviendaLogicAdditional;
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
	
	
	
	
	public  TipoViviendaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoviviendaDataAccess = new TipoViviendaDataAccess();
			
			this.tipoviviendas= new ArrayList<TipoVivienda>();
			this.tipovivienda= new TipoVivienda();
			
			this.tipoviviendaObject=new Object();
			this.tipoviviendasObject=new ArrayList<Object>();
				
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
			
			this.tipoviviendaDataAccess.setConnexionType(this.connexionType);
			this.tipoviviendaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoViviendaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoviviendaDataAccess = new TipoViviendaDataAccess();
			this.tipoviviendas= new ArrayList<TipoVivienda>();
			this.tipovivienda= new TipoVivienda();
			this.tipoviviendaObject=new Object();
			this.tipoviviendasObject=new ArrayList<Object>();
			
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
			
			this.tipoviviendaDataAccess.setConnexionType(this.connexionType);
			this.tipoviviendaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoVivienda getTipoVivienda() throws Exception {	
		TipoViviendaLogicAdditional.checkTipoViviendaToGet(tipovivienda,this.datosCliente,this.arrDatoGeneral);
		TipoViviendaLogicAdditional.updateTipoViviendaToGet(tipovivienda,this.arrDatoGeneral);
		
		return tipovivienda;
	}
		
	public void setTipoVivienda(TipoVivienda newTipoVivienda) {
		this.tipovivienda = newTipoVivienda;
	}
	
	public TipoViviendaDataAccess getTipoViviendaDataAccess() {
		return tipoviviendaDataAccess;
	}
	
	public void setTipoViviendaDataAccess(TipoViviendaDataAccess newtipoviviendaDataAccess) {
		this.tipoviviendaDataAccess = newtipoviviendaDataAccess;
	}
	
	public List<TipoVivienda> getTipoViviendas() throws Exception {		
		this.quitarTipoViviendasNulos();
		
		TipoViviendaLogicAdditional.checkTipoViviendaToGets(tipoviviendas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoVivienda tipoviviendaLocal: tipoviviendas ) {
			TipoViviendaLogicAdditional.updateTipoViviendaToGet(tipoviviendaLocal,this.arrDatoGeneral);
		}
		
		return tipoviviendas;
	}
	
	public void setTipoViviendas(List<TipoVivienda> newTipoViviendas) {
		this.tipoviviendas = newTipoViviendas;
	}
	
	public Object getTipoViviendaObject() {	
		this.tipoviviendaObject=this.tipoviviendaDataAccess.getEntityObject();
		return this.tipoviviendaObject;
	}
		
	public void setTipoViviendaObject(Object newTipoViviendaObject) {
		this.tipoviviendaObject = newTipoViviendaObject;
	}
	
	public List<Object> getTipoViviendasObject() {		
		this.tipoviviendasObject=this.tipoviviendaDataAccess.getEntitiesObject();
		return this.tipoviviendasObject;
	}
		
	public void setTipoViviendasObject(List<Object> newTipoViviendasObject) {
		this.tipoviviendasObject = newTipoViviendasObject;
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
		
		if(this.tipoviviendaDataAccess!=null) {
			this.tipoviviendaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoviviendaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoviviendaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipovivienda = new  TipoVivienda();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipovivienda=tipoviviendaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovivienda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipovivienda);
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
		tipovivienda = new  TipoVivienda();
		  		  
        try {
			
			tipovivienda=tipoviviendaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovivienda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipovivienda);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipovivienda = new  TipoVivienda();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipovivienda=tipoviviendaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovivienda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipovivienda);
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
		tipovivienda = new  TipoVivienda();
		  		  
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
		tipovivienda = new  TipoVivienda();
		  		  
        try {
			
			tipovivienda=tipoviviendaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovivienda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipovivienda);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipovivienda = new  TipoVivienda();
		  		  
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
		tipovivienda = new  TipoVivienda();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoviviendaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovivienda = new  TipoVivienda();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoviviendaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipovivienda = new  TipoVivienda();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoviviendaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovivienda = new  TipoVivienda();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoviviendaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipovivienda = new  TipoVivienda();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoviviendaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovivienda = new  TipoVivienda();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoviviendaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoviviendas = new  ArrayList<TipoVivienda>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoviviendas=tipoviviendaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVivienda(tipoviviendas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipoviviendas);
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
		tipoviviendas = new  ArrayList<TipoVivienda>();
		  		  
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
		tipoviviendas = new  ArrayList<TipoVivienda>();
		  		  
        try {			
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoviviendas=tipoviviendaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoVivienda(tipoviviendas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipoviviendas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoviviendas = new  ArrayList<TipoVivienda>();
		  		  
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
		tipoviviendas = new  ArrayList<TipoVivienda>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoviviendas=tipoviviendaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVivienda(tipoviviendas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipoviviendas);
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
		tipoviviendas = new  ArrayList<TipoVivienda>();
		  		  
        try {
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoviviendas=tipoviviendaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVivienda(tipoviviendas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipoviviendas);
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
		tipoviviendas = new  ArrayList<TipoVivienda>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoviviendas=tipoviviendaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoVivienda(tipoviviendas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipoviviendas);
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
		tipoviviendas = new  ArrayList<TipoVivienda>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoviviendas=tipoviviendaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoVivienda(tipoviviendas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipoviviendas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipovivienda = new  TipoVivienda();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovivienda=tipoviviendaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoVivienda(tipovivienda);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipovivienda);
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
		tipovivienda = new  TipoVivienda();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovivienda=tipoviviendaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoVivienda(tipovivienda);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipovivienda);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoviviendas = new  ArrayList<TipoVivienda>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoviviendas=tipoviviendaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVivienda(tipoviviendas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipoviviendas);
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
		tipoviviendas = new  ArrayList<TipoVivienda>();
		  		  
        try {
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoviviendas=tipoviviendaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVivienda(tipoviviendas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipoviviendas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoViviendasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoviviendas = new  ArrayList<TipoVivienda>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-getTodosTipoViviendasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoviviendas=tipoviviendaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoVivienda(tipoviviendas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipoviviendas);
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
	
	public  void  getTodosTipoViviendas(String sFinalQuery,Pagination pagination)throws Exception {
		tipoviviendas = new  ArrayList<TipoVivienda>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoviviendas=tipoviviendaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoVivienda(tipoviviendas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipoviviendas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoVivienda(TipoVivienda tipovivienda) throws Exception {
		Boolean estaValidado=false;
		
		if(tipovivienda.getIsNew() || tipovivienda.getIsChanged()) { 
			this.invalidValues = tipoviviendaValidator.getInvalidValues(tipovivienda);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipovivienda);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoVivienda(List<TipoVivienda> TipoViviendas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoVivienda tipoviviendaLocal:tipoviviendas) {				
			estaValidadoObjeto=this.validarGuardarTipoVivienda(tipoviviendaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoVivienda(List<TipoVivienda> TipoViviendas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoVivienda(tipoviviendas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoVivienda(TipoVivienda TipoVivienda) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoVivienda(tipovivienda)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoVivienda tipovivienda) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipovivienda.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoViviendaConstantesFunciones.getTipoViviendaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipovivienda","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoViviendaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoViviendaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoViviendaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-saveTipoViviendaWithConnection");connexion.begin();			
			
			TipoViviendaLogicAdditional.checkTipoViviendaToSave(this.tipovivienda,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoViviendaLogicAdditional.updateTipoViviendaToSave(this.tipovivienda,this.arrDatoGeneral);
			
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipovivienda,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoVivienda();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoVivienda(this.tipovivienda)) {
				TipoViviendaDataAccess.save(this.tipovivienda, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipovivienda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoViviendaLogicAdditional.checkTipoViviendaToSaveAfter(this.tipovivienda,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoVivienda();
			
			connexion.commit();			
			
			if(this.tipovivienda.getIsDeleted()) {
				this.tipovivienda=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoVivienda()throws Exception {	
		try {	
			
			TipoViviendaLogicAdditional.checkTipoViviendaToSave(this.tipovivienda,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoViviendaLogicAdditional.updateTipoViviendaToSave(this.tipovivienda,this.arrDatoGeneral);
			
			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipovivienda,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoVivienda(this.tipovivienda)) {			
				TipoViviendaDataAccess.save(this.tipovivienda, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipovivienda,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoViviendaLogicAdditional.checkTipoViviendaToSaveAfter(this.tipovivienda,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipovivienda.getIsDeleted()) {
				this.tipovivienda=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoViviendasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-saveTipoViviendasWithConnection");connexion.begin();			
			
			TipoViviendaLogicAdditional.checkTipoViviendaToSaves(tipoviviendas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoViviendas();
			
			Boolean validadoTodosTipoVivienda=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoVivienda tipoviviendaLocal:tipoviviendas) {		
				if(tipoviviendaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoViviendaLogicAdditional.updateTipoViviendaToSave(tipoviviendaLocal,this.arrDatoGeneral);
	        	
				TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoviviendaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoVivienda(tipoviviendaLocal)) {
					TipoViviendaDataAccess.save(tipoviviendaLocal, connexion);				
				} else {
					validadoTodosTipoVivienda=false;
				}
			}
			
			if(!validadoTodosTipoVivienda) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoViviendaLogicAdditional.checkTipoViviendaToSavesAfter(tipoviviendas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoViviendas();
			
			connexion.commit();		
			
			this.quitarTipoViviendasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoViviendas()throws Exception {				
		 try {	
			TipoViviendaLogicAdditional.checkTipoViviendaToSaves(tipoviviendas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoVivienda=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoVivienda tipoviviendaLocal:tipoviviendas) {				
				if(tipoviviendaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoViviendaLogicAdditional.updateTipoViviendaToSave(tipoviviendaLocal,this.arrDatoGeneral);
	        	
				TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoviviendaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoVivienda(tipoviviendaLocal)) {				
					TipoViviendaDataAccess.save(tipoviviendaLocal, connexion);				
				} else {
					validadoTodosTipoVivienda=false;
				}
			}
			
			if(!validadoTodosTipoVivienda) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoViviendaLogicAdditional.checkTipoViviendaToSavesAfter(tipoviviendas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoViviendasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoViviendaParameterReturnGeneral procesarAccionTipoViviendas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoVivienda> tipoviviendas,TipoViviendaParameterReturnGeneral tipoviviendaParameterGeneral)throws Exception {
		 try {	
			TipoViviendaParameterReturnGeneral tipoviviendaReturnGeneral=new TipoViviendaParameterReturnGeneral();
	
			TipoViviendaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoviviendas,tipoviviendaParameterGeneral,tipoviviendaReturnGeneral);
			
			return tipoviviendaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoViviendaParameterReturnGeneral procesarAccionTipoViviendasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoVivienda> tipoviviendas,TipoViviendaParameterReturnGeneral tipoviviendaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-procesarAccionTipoViviendasWithConnection");connexion.begin();			
			
			TipoViviendaParameterReturnGeneral tipoviviendaReturnGeneral=new TipoViviendaParameterReturnGeneral();
	
			TipoViviendaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoviviendas,tipoviviendaParameterGeneral,tipoviviendaReturnGeneral);
			
			this.connexion.commit();
			
			return tipoviviendaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoViviendaParameterReturnGeneral procesarEventosTipoViviendas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoVivienda> tipoviviendas,TipoVivienda tipovivienda,TipoViviendaParameterReturnGeneral tipoviviendaParameterGeneral,Boolean isEsNuevoTipoVivienda,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoViviendaParameterReturnGeneral tipoviviendaReturnGeneral=new TipoViviendaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoviviendaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoViviendaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoviviendas,tipovivienda,tipoviviendaParameterGeneral,tipoviviendaReturnGeneral,isEsNuevoTipoVivienda,clases);
			
			return tipoviviendaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoViviendaParameterReturnGeneral procesarEventosTipoViviendasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoVivienda> tipoviviendas,TipoVivienda tipovivienda,TipoViviendaParameterReturnGeneral tipoviviendaParameterGeneral,Boolean isEsNuevoTipoVivienda,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-procesarEventosTipoViviendasWithConnection");connexion.begin();			
			
			TipoViviendaParameterReturnGeneral tipoviviendaReturnGeneral=new TipoViviendaParameterReturnGeneral();
	
			tipoviviendaReturnGeneral.setTipoVivienda(tipovivienda);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoviviendaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoViviendaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoviviendas,tipovivienda,tipoviviendaParameterGeneral,tipoviviendaReturnGeneral,isEsNuevoTipoVivienda,clases);
			
			this.connexion.commit();
			
			return tipoviviendaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoViviendaParameterReturnGeneral procesarImportacionTipoViviendasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoViviendaParameterReturnGeneral tipoviviendaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-procesarImportacionTipoViviendasWithConnection");connexion.begin();			
			
			TipoViviendaParameterReturnGeneral tipoviviendaReturnGeneral=new TipoViviendaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoviviendas=new ArrayList<TipoVivienda>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipovivienda=new TipoVivienda();
				
				
				if(conColumnasBase) {this.tipovivienda.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipovivienda.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipovivienda.setcodigo(arrColumnas[iColumn++]);
				this.tipovivienda.setnombre(arrColumnas[iColumn++]);
				
				this.tipoviviendas.add(this.tipovivienda);
			}
			
			this.saveTipoViviendas();
			
			this.connexion.commit();
			
			tipoviviendaReturnGeneral.setConRetornoEstaProcesado(true);
			tipoviviendaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoviviendaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoViviendasEliminados() throws Exception {				
		
		List<TipoVivienda> tipoviviendasAux= new ArrayList<TipoVivienda>();
		
		for(TipoVivienda tipovivienda:tipoviviendas) {
			if(!tipovivienda.getIsDeleted()) {
				tipoviviendasAux.add(tipovivienda);
			}
		}
		
		tipoviviendas=tipoviviendasAux;
	}
	
	public void quitarTipoViviendasNulos() throws Exception {				
		
		List<TipoVivienda> tipoviviendasAux= new ArrayList<TipoVivienda>();
		
		for(TipoVivienda tipovivienda : this.tipoviviendas) {
			if(tipovivienda==null) {
				tipoviviendasAux.add(tipovivienda);
			}
		}
		
		//this.tipoviviendas=tipoviviendasAux;
		
		this.tipoviviendas.removeAll(tipoviviendasAux);
	}
	
	public void getSetVersionRowTipoViviendaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipovivienda.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipovivienda.getIsDeleted() || (tipovivienda.getIsChanged()&&!tipovivienda.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoviviendaDataAccess.getSetVersionRowTipoVivienda(connexion,tipovivienda.getId());
				
				if(!tipovivienda.getVersionRow().equals(timestamp)) {	
					tipovivienda.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipovivienda.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoVivienda()throws Exception {	
		
		if(tipovivienda.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipovivienda.getIsDeleted() || (tipovivienda.getIsChanged()&&!tipovivienda.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoviviendaDataAccess.getSetVersionRowTipoVivienda(connexion,tipovivienda.getId());
			
			try {							
				if(!tipovivienda.getVersionRow().equals(timestamp)) {	
					tipovivienda.setVersionRow(timestamp);
				}
				
				tipovivienda.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoViviendasWithConnection()throws Exception {	
		if(tipoviviendas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoVivienda tipoviviendaAux:tipoviviendas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoviviendaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoviviendaAux.getIsDeleted() || (tipoviviendaAux.getIsChanged()&&!tipoviviendaAux.getIsNew())) {
						
						timestamp=tipoviviendaDataAccess.getSetVersionRowTipoVivienda(connexion,tipoviviendaAux.getId());
						
						if(!tipovivienda.getVersionRow().equals(timestamp)) {	
							tipoviviendaAux.setVersionRow(timestamp);
						}
								
						tipoviviendaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoViviendas()throws Exception {	
		if(tipoviviendas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoVivienda tipoviviendaAux:tipoviviendas) {
					if(tipoviviendaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoviviendaAux.getIsDeleted() || (tipoviviendaAux.getIsChanged()&&!tipoviviendaAux.getIsNew())) {
						
						timestamp=tipoviviendaDataAccess.getSetVersionRowTipoVivienda(connexion,tipoviviendaAux.getId());
						
						if(!tipoviviendaAux.getVersionRow().equals(timestamp)) {	
							tipoviviendaAux.setVersionRow(timestamp);
						}
						
													
						tipoviviendaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoViviendaParameterReturnGeneral cargarCombosLoteForeignKeyTipoViviendaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoViviendaParameterReturnGeneral  tipoviviendaReturnGeneral =new TipoViviendaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoViviendaWithConnection");connexion.begin();
			
			tipoviviendaReturnGeneral =new TipoViviendaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoviviendaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoviviendaReturnGeneral;
	}
	
	public TipoViviendaParameterReturnGeneral cargarCombosLoteForeignKeyTipoVivienda(String finalQueryGlobalEmpresa) throws Exception {
		TipoViviendaParameterReturnGeneral  tipoviviendaReturnGeneral =new TipoViviendaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoviviendaReturnGeneral =new TipoViviendaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoviviendaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoviviendaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoViviendaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DireccionLogic direccionLogic=new DireccionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoViviendaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Direccion.class));
											
			

			direccionLogic.setConnexion(this.getConnexion());
			direccionLogic.setDatosCliente(this.datosCliente);
			direccionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoVivienda tipovivienda:this.tipoviviendas) {
				

				classes=new ArrayList<Classe>();
				classes=DireccionConstantesFunciones.getClassesForeignKeysOfDireccion(new ArrayList<Classe>(),DeepLoadType.NONE);

				direccionLogic.setDireccions(tipovivienda.direccions);
				direccionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoVivienda tipovivienda,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoViviendaLogicAdditional.updateTipoViviendaToGet(tipovivienda,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipovivienda.setEmpresa(tipoviviendaDataAccess.getEmpresa(connexion,tipovivienda));
		tipovivienda.setDireccions(tipoviviendaDataAccess.getDireccions(connexion,tipovivienda));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipovivienda.setEmpresa(tipoviviendaDataAccess.getEmpresa(connexion,tipovivienda));
				continue;
			}

			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovivienda.setDireccions(tipoviviendaDataAccess.getDireccions(connexion,tipovivienda));

				if(this.isConDeep) {
					DireccionLogic direccionLogic= new DireccionLogic(this.connexion);
					direccionLogic.setDireccions(tipovivienda.getDireccions());
					ArrayList<Classe> classesLocal=DireccionConstantesFunciones.getClassesForeignKeysOfDireccion(new ArrayList<Classe>(),DeepLoadType.NONE);
					direccionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(direccionLogic.getDireccions());
					tipovivienda.setDireccions(direccionLogic.getDireccions());
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
			tipovivienda.setEmpresa(tipoviviendaDataAccess.getEmpresa(connexion,tipovivienda));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Direccion.class));
			tipovivienda.setDireccions(tipoviviendaDataAccess.getDireccions(connexion,tipovivienda));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipovivienda.setEmpresa(tipoviviendaDataAccess.getEmpresa(connexion,tipovivienda));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipovivienda.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipovivienda.setDireccions(tipoviviendaDataAccess.getDireccions(connexion,tipovivienda));

		for(Direccion direccion:tipovivienda.getDireccions()) {
			DireccionLogic direccionLogic= new DireccionLogic(connexion);
			direccionLogic.deepLoad(direccion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipovivienda.setEmpresa(tipoviviendaDataAccess.getEmpresa(connexion,tipovivienda));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipovivienda.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovivienda.setDireccions(tipoviviendaDataAccess.getDireccions(connexion,tipovivienda));

				for(Direccion direccion:tipovivienda.getDireccions()) {
					DireccionLogic direccionLogic= new DireccionLogic(connexion);
					direccionLogic.deepLoad(direccion,isDeep,deepLoadType,clases);
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
			tipovivienda.setEmpresa(tipoviviendaDataAccess.getEmpresa(connexion,tipovivienda));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipovivienda.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Direccion.class));
			tipovivienda.setDireccions(tipoviviendaDataAccess.getDireccions(connexion,tipovivienda));

			for(Direccion direccion:tipovivienda.getDireccions()) {
				DireccionLogic direccionLogic= new DireccionLogic(connexion);
				direccionLogic.deepLoad(direccion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoVivienda tipovivienda,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoViviendaLogicAdditional.updateTipoViviendaToSave(tipovivienda,this.arrDatoGeneral);
			
TipoViviendaDataAccess.save(tipovivienda, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipovivienda.getEmpresa(),connexion);

		for(Direccion direccion:tipovivienda.getDireccions()) {
			direccion.setid_tipo_vivienda(tipovivienda.getId());
			DireccionDataAccess.save(direccion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipovivienda.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Direccion direccion:tipovivienda.getDireccions()) {
					direccion.setid_tipo_vivienda(tipovivienda.getId());
					DireccionDataAccess.save(direccion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipovivienda.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipovivienda.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Direccion direccion:tipovivienda.getDireccions()) {
			DireccionLogic direccionLogic= new DireccionLogic(connexion);
			direccion.setid_tipo_vivienda(tipovivienda.getId());
			DireccionDataAccess.save(direccion,connexion);
			direccionLogic.deepSave(direccion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipovivienda.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipovivienda.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Direccion direccion:tipovivienda.getDireccions()) {
					DireccionLogic direccionLogic= new DireccionLogic(connexion);
					direccion.setid_tipo_vivienda(tipovivienda.getId());
					DireccionDataAccess.save(direccion,connexion);
					direccionLogic.deepSave(direccion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoVivienda.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipovivienda,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(tipovivienda);
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
			this.deepLoad(this.tipovivienda,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipovivienda);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoVivienda.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoviviendas!=null) {
				for(TipoVivienda tipovivienda:tipoviviendas) {
					this.deepLoad(tipovivienda,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(tipoviviendas);
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
			if(tipoviviendas!=null) {
				for(TipoVivienda tipovivienda:tipoviviendas) {
					this.deepLoad(tipovivienda,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(tipoviviendas);
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
			this.getNewConnexionToDeep(TipoVivienda.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipovivienda,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoVivienda.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoviviendas!=null) {
				for(TipoVivienda tipovivienda:tipoviviendas) {
					this.deepSave(tipovivienda,isDeep,deepLoadType,clases);
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
			if(tipoviviendas!=null) {
				for(TipoVivienda tipovivienda:tipoviviendas) {
					this.deepSave(tipovivienda,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoViviendasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVivienda.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoViviendaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoviviendas=tipoviviendaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipoviviendas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoViviendasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoViviendaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoViviendaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoviviendas=tipoviviendaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoViviendaConstantesFunciones.refrescarForeignKeysDescripcionesTipoVivienda(this.tipoviviendas);
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
			if(TipoViviendaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoViviendaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoVivienda tipovivienda,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoViviendaConstantesFunciones.ISCONAUDITORIA) {
				if(tipovivienda.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoViviendaDataAccess.TABLENAME, tipovivienda.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoViviendaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoViviendaLogic.registrarAuditoriaDetallesTipoVivienda(connexion,tipovivienda,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipovivienda.getIsDeleted()) {
					/*if(!tipovivienda.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoViviendaDataAccess.TABLENAME, tipovivienda.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoViviendaLogic.registrarAuditoriaDetallesTipoVivienda(connexion,tipovivienda,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoViviendaDataAccess.TABLENAME, tipovivienda.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipovivienda.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoViviendaDataAccess.TABLENAME, tipovivienda.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoViviendaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoViviendaLogic.registrarAuditoriaDetallesTipoVivienda(connexion,tipovivienda,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoVivienda(Connexion connexion,TipoVivienda tipovivienda)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipovivienda.getIsNew()||!tipovivienda.getid_empresa().equals(tipovivienda.getTipoViviendaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipovivienda.getTipoViviendaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipovivienda.getTipoViviendaOriginal().getid_empresa().toString();
				}
				if(tipovivienda.getid_empresa()!=null)
				{
					strValorNuevo=tipovivienda.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoViviendaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipovivienda.getIsNew()||!tipovivienda.getcodigo().equals(tipovivienda.getTipoViviendaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipovivienda.getTipoViviendaOriginal().getcodigo()!=null)
				{
					strValorActual=tipovivienda.getTipoViviendaOriginal().getcodigo();
				}
				if(tipovivienda.getcodigo()!=null)
				{
					strValorNuevo=tipovivienda.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoViviendaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipovivienda.getIsNew()||!tipovivienda.getnombre().equals(tipovivienda.getTipoViviendaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipovivienda.getTipoViviendaOriginal().getnombre()!=null)
				{
					strValorActual=tipovivienda.getTipoViviendaOriginal().getnombre();
				}
				if(tipovivienda.getnombre()!=null)
				{
					strValorNuevo=tipovivienda.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoViviendaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoViviendaRelacionesWithConnection(TipoVivienda tipovivienda,List<Direccion> direccions) throws Exception {

		if(!tipovivienda.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoViviendaRelacionesBase(tipovivienda,direccions,true);
		}
	}

	public void saveTipoViviendaRelaciones(TipoVivienda tipovivienda,List<Direccion> direccions)throws Exception {

		if(!tipovivienda.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoViviendaRelacionesBase(tipovivienda,direccions,false);
		}
	}

	public void saveTipoViviendaRelacionesBase(TipoVivienda tipovivienda,List<Direccion> direccions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoVivienda-saveRelacionesWithConnection");}
	
			tipovivienda.setDireccions(direccions);

			this.setTipoVivienda(tipovivienda);

			if(TipoViviendaLogicAdditional.validarSaveRelaciones(tipovivienda,this)) {

				TipoViviendaLogicAdditional.updateRelacionesToSave(tipovivienda,this);

				if((tipovivienda.getIsNew()||tipovivienda.getIsChanged())&&!tipovivienda.getIsDeleted()) {
					this.saveTipoVivienda();
					this.saveTipoViviendaRelacionesDetalles(direccions);

				} else if(tipovivienda.getIsDeleted()) {
					this.saveTipoViviendaRelacionesDetalles(direccions);
					this.saveTipoVivienda();
				}

				TipoViviendaLogicAdditional.updateRelacionesToSaveAfter(tipovivienda,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DireccionConstantesFunciones.InicializarGeneralEntityAuxiliaresDireccions(direccions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoViviendaRelacionesDetalles(List<Direccion> direccions)throws Exception {
		try {
	

			Long idTipoViviendaActual=this.getTipoVivienda().getId();

			DireccionLogic direccionLogic_Desde_TipoVivienda=new DireccionLogic();
			direccionLogic_Desde_TipoVivienda.setDireccions(direccions);

			direccionLogic_Desde_TipoVivienda.setConnexion(this.getConnexion());
			direccionLogic_Desde_TipoVivienda.setDatosCliente(this.datosCliente);

			for(Direccion direccion_Desde_TipoVivienda:direccionLogic_Desde_TipoVivienda.getDireccions()) {
				direccion_Desde_TipoVivienda.setid_tipo_vivienda(idTipoViviendaActual);
			}

			direccionLogic_Desde_TipoVivienda.saveDireccions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoVivienda(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoViviendaConstantesFunciones.getClassesForeignKeysOfTipoVivienda(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVivienda(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoViviendaConstantesFunciones.getClassesRelationshipsOfTipoVivienda(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

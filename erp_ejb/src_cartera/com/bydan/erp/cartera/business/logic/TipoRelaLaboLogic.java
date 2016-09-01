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
import com.bydan.erp.cartera.util.TipoRelaLaboConstantesFunciones;
import com.bydan.erp.cartera.util.TipoRelaLaboParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoRelaLaboParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoRelaLabo;
import com.bydan.erp.cartera.business.logic.TipoRelaLaboLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoRelaLaboLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoRelaLaboLogic.class);
	
	protected TipoRelaLaboDataAccess tiporelalaboDataAccess; 	
	protected TipoRelaLabo tiporelalabo;
	protected List<TipoRelaLabo> tiporelalabos;
	protected Object tiporelalaboObject;	
	protected List<Object> tiporelalabosObject;
	
	public static ClassValidator<TipoRelaLabo> tiporelalaboValidator = new ClassValidator<TipoRelaLabo>(TipoRelaLabo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoRelaLaboLogicAdditional tiporelalaboLogicAdditional=null;
	
	public TipoRelaLaboLogicAdditional getTipoRelaLaboLogicAdditional() {
		return this.tiporelalaboLogicAdditional;
	}
	
	public void setTipoRelaLaboLogicAdditional(TipoRelaLaboLogicAdditional tiporelalaboLogicAdditional) {
		try {
			this.tiporelalaboLogicAdditional=tiporelalaboLogicAdditional;
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
	
	
	
	
	public  TipoRelaLaboLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiporelalaboDataAccess = new TipoRelaLaboDataAccess();
			
			this.tiporelalabos= new ArrayList<TipoRelaLabo>();
			this.tiporelalabo= new TipoRelaLabo();
			
			this.tiporelalaboObject=new Object();
			this.tiporelalabosObject=new ArrayList<Object>();
				
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
			
			this.tiporelalaboDataAccess.setConnexionType(this.connexionType);
			this.tiporelalaboDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoRelaLaboLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiporelalaboDataAccess = new TipoRelaLaboDataAccess();
			this.tiporelalabos= new ArrayList<TipoRelaLabo>();
			this.tiporelalabo= new TipoRelaLabo();
			this.tiporelalaboObject=new Object();
			this.tiporelalabosObject=new ArrayList<Object>();
			
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
			
			this.tiporelalaboDataAccess.setConnexionType(this.connexionType);
			this.tiporelalaboDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoRelaLabo getTipoRelaLabo() throws Exception {	
		TipoRelaLaboLogicAdditional.checkTipoRelaLaboToGet(tiporelalabo,this.datosCliente,this.arrDatoGeneral);
		TipoRelaLaboLogicAdditional.updateTipoRelaLaboToGet(tiporelalabo,this.arrDatoGeneral);
		
		return tiporelalabo;
	}
		
	public void setTipoRelaLabo(TipoRelaLabo newTipoRelaLabo) {
		this.tiporelalabo = newTipoRelaLabo;
	}
	
	public TipoRelaLaboDataAccess getTipoRelaLaboDataAccess() {
		return tiporelalaboDataAccess;
	}
	
	public void setTipoRelaLaboDataAccess(TipoRelaLaboDataAccess newtiporelalaboDataAccess) {
		this.tiporelalaboDataAccess = newtiporelalaboDataAccess;
	}
	
	public List<TipoRelaLabo> getTipoRelaLabos() throws Exception {		
		this.quitarTipoRelaLabosNulos();
		
		TipoRelaLaboLogicAdditional.checkTipoRelaLaboToGets(tiporelalabos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoRelaLabo tiporelalaboLocal: tiporelalabos ) {
			TipoRelaLaboLogicAdditional.updateTipoRelaLaboToGet(tiporelalaboLocal,this.arrDatoGeneral);
		}
		
		return tiporelalabos;
	}
	
	public void setTipoRelaLabos(List<TipoRelaLabo> newTipoRelaLabos) {
		this.tiporelalabos = newTipoRelaLabos;
	}
	
	public Object getTipoRelaLaboObject() {	
		this.tiporelalaboObject=this.tiporelalaboDataAccess.getEntityObject();
		return this.tiporelalaboObject;
	}
		
	public void setTipoRelaLaboObject(Object newTipoRelaLaboObject) {
		this.tiporelalaboObject = newTipoRelaLaboObject;
	}
	
	public List<Object> getTipoRelaLabosObject() {		
		this.tiporelalabosObject=this.tiporelalaboDataAccess.getEntitiesObject();
		return this.tiporelalabosObject;
	}
		
	public void setTipoRelaLabosObject(List<Object> newTipoRelaLabosObject) {
		this.tiporelalabosObject = newTipoRelaLabosObject;
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
		
		if(this.tiporelalaboDataAccess!=null) {
			this.tiporelalaboDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiporelalaboDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiporelalaboDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiporelalabo = new  TipoRelaLabo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporelalabo=tiporelalaboDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporelalabo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabo);
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
		tiporelalabo = new  TipoRelaLabo();
		  		  
        try {
			
			tiporelalabo=tiporelalaboDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporelalabo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiporelalabo = new  TipoRelaLabo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporelalabo=tiporelalaboDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporelalabo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabo);
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
		tiporelalabo = new  TipoRelaLabo();
		  		  
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
		tiporelalabo = new  TipoRelaLabo();
		  		  
        try {
			
			tiporelalabo=tiporelalaboDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporelalabo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiporelalabo = new  TipoRelaLabo();
		  		  
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
		tiporelalabo = new  TipoRelaLabo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiporelalaboDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporelalabo = new  TipoRelaLabo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiporelalaboDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporelalabo = new  TipoRelaLabo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiporelalaboDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporelalabo = new  TipoRelaLabo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiporelalaboDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporelalabo = new  TipoRelaLabo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiporelalaboDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporelalabo = new  TipoRelaLabo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiporelalaboDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporelalabos = new  ArrayList<TipoRelaLabo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporelalabos=tiporelalaboDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRelaLabo(tiporelalabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabos);
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
		tiporelalabos = new  ArrayList<TipoRelaLabo>();
		  		  
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
		tiporelalabos = new  ArrayList<TipoRelaLabo>();
		  		  
        try {			
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporelalabos=tiporelalaboDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoRelaLabo(tiporelalabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiporelalabos = new  ArrayList<TipoRelaLabo>();
		  		  
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
		tiporelalabos = new  ArrayList<TipoRelaLabo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporelalabos=tiporelalaboDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRelaLabo(tiporelalabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabos);
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
		tiporelalabos = new  ArrayList<TipoRelaLabo>();
		  		  
        try {
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporelalabos=tiporelalaboDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRelaLabo(tiporelalabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabos);
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
		tiporelalabos = new  ArrayList<TipoRelaLabo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporelalabos=tiporelalaboDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRelaLabo(tiporelalabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabos);
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
		tiporelalabos = new  ArrayList<TipoRelaLabo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporelalabos=tiporelalaboDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRelaLabo(tiporelalabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiporelalabo = new  TipoRelaLabo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporelalabo=tiporelalaboDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRelaLabo(tiporelalabo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabo);
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
		tiporelalabo = new  TipoRelaLabo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporelalabo=tiporelalaboDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRelaLabo(tiporelalabo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporelalabos = new  ArrayList<TipoRelaLabo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporelalabos=tiporelalaboDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRelaLabo(tiporelalabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabos);
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
		tiporelalabos = new  ArrayList<TipoRelaLabo>();
		  		  
        try {
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporelalabos=tiporelalaboDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRelaLabo(tiporelalabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoRelaLabosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiporelalabos = new  ArrayList<TipoRelaLabo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-getTodosTipoRelaLabosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporelalabos=tiporelalaboDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRelaLabo(tiporelalabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabos);
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
	
	public  void  getTodosTipoRelaLabos(String sFinalQuery,Pagination pagination)throws Exception {
		tiporelalabos = new  ArrayList<TipoRelaLabo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporelalabos=tiporelalaboDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRelaLabo(tiporelalabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoRelaLabo(TipoRelaLabo tiporelalabo) throws Exception {
		Boolean estaValidado=false;
		
		if(tiporelalabo.getIsNew() || tiporelalabo.getIsChanged()) { 
			this.invalidValues = tiporelalaboValidator.getInvalidValues(tiporelalabo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiporelalabo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoRelaLabo(List<TipoRelaLabo> TipoRelaLabos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoRelaLabo tiporelalaboLocal:tiporelalabos) {				
			estaValidadoObjeto=this.validarGuardarTipoRelaLabo(tiporelalaboLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoRelaLabo(List<TipoRelaLabo> TipoRelaLabos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRelaLabo(tiporelalabos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoRelaLabo(TipoRelaLabo TipoRelaLabo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRelaLabo(tiporelalabo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoRelaLabo tiporelalabo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiporelalabo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoRelaLaboConstantesFunciones.getTipoRelaLaboLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiporelalabo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoRelaLaboConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoRelaLaboConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoRelaLaboWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-saveTipoRelaLaboWithConnection");connexion.begin();			
			
			TipoRelaLaboLogicAdditional.checkTipoRelaLaboToSave(this.tiporelalabo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRelaLaboLogicAdditional.updateTipoRelaLaboToSave(this.tiporelalabo,this.arrDatoGeneral);
			
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporelalabo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoRelaLabo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRelaLabo(this.tiporelalabo)) {
				TipoRelaLaboDataAccess.save(this.tiporelalabo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiporelalabo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRelaLaboLogicAdditional.checkTipoRelaLaboToSaveAfter(this.tiporelalabo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRelaLabo();
			
			connexion.commit();			
			
			if(this.tiporelalabo.getIsDeleted()) {
				this.tiporelalabo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoRelaLabo()throws Exception {	
		try {	
			
			TipoRelaLaboLogicAdditional.checkTipoRelaLaboToSave(this.tiporelalabo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRelaLaboLogicAdditional.updateTipoRelaLaboToSave(this.tiporelalabo,this.arrDatoGeneral);
			
			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporelalabo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRelaLabo(this.tiporelalabo)) {			
				TipoRelaLaboDataAccess.save(this.tiporelalabo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiporelalabo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRelaLaboLogicAdditional.checkTipoRelaLaboToSaveAfter(this.tiporelalabo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiporelalabo.getIsDeleted()) {
				this.tiporelalabo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoRelaLabosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-saveTipoRelaLabosWithConnection");connexion.begin();			
			
			TipoRelaLaboLogicAdditional.checkTipoRelaLaboToSaves(tiporelalabos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoRelaLabos();
			
			Boolean validadoTodosTipoRelaLabo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRelaLabo tiporelalaboLocal:tiporelalabos) {		
				if(tiporelalaboLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRelaLaboLogicAdditional.updateTipoRelaLaboToSave(tiporelalaboLocal,this.arrDatoGeneral);
	        	
				TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporelalaboLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRelaLabo(tiporelalaboLocal)) {
					TipoRelaLaboDataAccess.save(tiporelalaboLocal, connexion);				
				} else {
					validadoTodosTipoRelaLabo=false;
				}
			}
			
			if(!validadoTodosTipoRelaLabo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRelaLaboLogicAdditional.checkTipoRelaLaboToSavesAfter(tiporelalabos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRelaLabos();
			
			connexion.commit();		
			
			this.quitarTipoRelaLabosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoRelaLabos()throws Exception {				
		 try {	
			TipoRelaLaboLogicAdditional.checkTipoRelaLaboToSaves(tiporelalabos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoRelaLabo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRelaLabo tiporelalaboLocal:tiporelalabos) {				
				if(tiporelalaboLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRelaLaboLogicAdditional.updateTipoRelaLaboToSave(tiporelalaboLocal,this.arrDatoGeneral);
	        	
				TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporelalaboLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRelaLabo(tiporelalaboLocal)) {				
					TipoRelaLaboDataAccess.save(tiporelalaboLocal, connexion);				
				} else {
					validadoTodosTipoRelaLabo=false;
				}
			}
			
			if(!validadoTodosTipoRelaLabo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRelaLaboLogicAdditional.checkTipoRelaLaboToSavesAfter(tiporelalabos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoRelaLabosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRelaLaboParameterReturnGeneral procesarAccionTipoRelaLabos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRelaLabo> tiporelalabos,TipoRelaLaboParameterReturnGeneral tiporelalaboParameterGeneral)throws Exception {
		 try {	
			TipoRelaLaboParameterReturnGeneral tiporelalaboReturnGeneral=new TipoRelaLaboParameterReturnGeneral();
	
			TipoRelaLaboLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporelalabos,tiporelalaboParameterGeneral,tiporelalaboReturnGeneral);
			
			return tiporelalaboReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRelaLaboParameterReturnGeneral procesarAccionTipoRelaLabosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRelaLabo> tiporelalabos,TipoRelaLaboParameterReturnGeneral tiporelalaboParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-procesarAccionTipoRelaLabosWithConnection");connexion.begin();			
			
			TipoRelaLaboParameterReturnGeneral tiporelalaboReturnGeneral=new TipoRelaLaboParameterReturnGeneral();
	
			TipoRelaLaboLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporelalabos,tiporelalaboParameterGeneral,tiporelalaboReturnGeneral);
			
			this.connexion.commit();
			
			return tiporelalaboReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRelaLaboParameterReturnGeneral procesarEventosTipoRelaLabos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRelaLabo> tiporelalabos,TipoRelaLabo tiporelalabo,TipoRelaLaboParameterReturnGeneral tiporelalaboParameterGeneral,Boolean isEsNuevoTipoRelaLabo,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoRelaLaboParameterReturnGeneral tiporelalaboReturnGeneral=new TipoRelaLaboParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporelalaboReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRelaLaboLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporelalabos,tiporelalabo,tiporelalaboParameterGeneral,tiporelalaboReturnGeneral,isEsNuevoTipoRelaLabo,clases);
			
			return tiporelalaboReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoRelaLaboParameterReturnGeneral procesarEventosTipoRelaLabosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRelaLabo> tiporelalabos,TipoRelaLabo tiporelalabo,TipoRelaLaboParameterReturnGeneral tiporelalaboParameterGeneral,Boolean isEsNuevoTipoRelaLabo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-procesarEventosTipoRelaLabosWithConnection");connexion.begin();			
			
			TipoRelaLaboParameterReturnGeneral tiporelalaboReturnGeneral=new TipoRelaLaboParameterReturnGeneral();
	
			tiporelalaboReturnGeneral.setTipoRelaLabo(tiporelalabo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporelalaboReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRelaLaboLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporelalabos,tiporelalabo,tiporelalaboParameterGeneral,tiporelalaboReturnGeneral,isEsNuevoTipoRelaLabo,clases);
			
			this.connexion.commit();
			
			return tiporelalaboReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRelaLaboParameterReturnGeneral procesarImportacionTipoRelaLabosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoRelaLaboParameterReturnGeneral tiporelalaboParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-procesarImportacionTipoRelaLabosWithConnection");connexion.begin();			
			
			TipoRelaLaboParameterReturnGeneral tiporelalaboReturnGeneral=new TipoRelaLaboParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiporelalabos=new ArrayList<TipoRelaLabo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiporelalabo=new TipoRelaLabo();
				
				
				if(conColumnasBase) {this.tiporelalabo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiporelalabo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiporelalabo.setcodigo(arrColumnas[iColumn++]);
				this.tiporelalabo.setnombre(arrColumnas[iColumn++]);
				
				this.tiporelalabos.add(this.tiporelalabo);
			}
			
			this.saveTipoRelaLabos();
			
			this.connexion.commit();
			
			tiporelalaboReturnGeneral.setConRetornoEstaProcesado(true);
			tiporelalaboReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiporelalaboReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoRelaLabosEliminados() throws Exception {				
		
		List<TipoRelaLabo> tiporelalabosAux= new ArrayList<TipoRelaLabo>();
		
		for(TipoRelaLabo tiporelalabo:tiporelalabos) {
			if(!tiporelalabo.getIsDeleted()) {
				tiporelalabosAux.add(tiporelalabo);
			}
		}
		
		tiporelalabos=tiporelalabosAux;
	}
	
	public void quitarTipoRelaLabosNulos() throws Exception {				
		
		List<TipoRelaLabo> tiporelalabosAux= new ArrayList<TipoRelaLabo>();
		
		for(TipoRelaLabo tiporelalabo : this.tiporelalabos) {
			if(tiporelalabo==null) {
				tiporelalabosAux.add(tiporelalabo);
			}
		}
		
		//this.tiporelalabos=tiporelalabosAux;
		
		this.tiporelalabos.removeAll(tiporelalabosAux);
	}
	
	public void getSetVersionRowTipoRelaLaboWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiporelalabo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiporelalabo.getIsDeleted() || (tiporelalabo.getIsChanged()&&!tiporelalabo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiporelalaboDataAccess.getSetVersionRowTipoRelaLabo(connexion,tiporelalabo.getId());
				
				if(!tiporelalabo.getVersionRow().equals(timestamp)) {	
					tiporelalabo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiporelalabo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoRelaLabo()throws Exception {	
		
		if(tiporelalabo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiporelalabo.getIsDeleted() || (tiporelalabo.getIsChanged()&&!tiporelalabo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiporelalaboDataAccess.getSetVersionRowTipoRelaLabo(connexion,tiporelalabo.getId());
			
			try {							
				if(!tiporelalabo.getVersionRow().equals(timestamp)) {	
					tiporelalabo.setVersionRow(timestamp);
				}
				
				tiporelalabo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoRelaLabosWithConnection()throws Exception {	
		if(tiporelalabos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoRelaLabo tiporelalaboAux:tiporelalabos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiporelalaboAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporelalaboAux.getIsDeleted() || (tiporelalaboAux.getIsChanged()&&!tiporelalaboAux.getIsNew())) {
						
						timestamp=tiporelalaboDataAccess.getSetVersionRowTipoRelaLabo(connexion,tiporelalaboAux.getId());
						
						if(!tiporelalabo.getVersionRow().equals(timestamp)) {	
							tiporelalaboAux.setVersionRow(timestamp);
						}
								
						tiporelalaboAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoRelaLabos()throws Exception {	
		if(tiporelalabos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoRelaLabo tiporelalaboAux:tiporelalabos) {
					if(tiporelalaboAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporelalaboAux.getIsDeleted() || (tiporelalaboAux.getIsChanged()&&!tiporelalaboAux.getIsNew())) {
						
						timestamp=tiporelalaboDataAccess.getSetVersionRowTipoRelaLabo(connexion,tiporelalaboAux.getId());
						
						if(!tiporelalaboAux.getVersionRow().equals(timestamp)) {	
							tiporelalaboAux.setVersionRow(timestamp);
						}
						
													
						tiporelalaboAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoRelaLaboParameterReturnGeneral cargarCombosLoteForeignKeyTipoRelaLaboWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoRelaLaboParameterReturnGeneral  tiporelalaboReturnGeneral =new TipoRelaLaboParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoRelaLaboWithConnection");connexion.begin();
			
			tiporelalaboReturnGeneral =new TipoRelaLaboParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiporelalaboReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tiporelalaboReturnGeneral;
	}
	
	public TipoRelaLaboParameterReturnGeneral cargarCombosLoteForeignKeyTipoRelaLabo(String finalQueryGlobalEmpresa) throws Exception {
		TipoRelaLaboParameterReturnGeneral  tiporelalaboReturnGeneral =new TipoRelaLaboParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tiporelalaboReturnGeneral =new TipoRelaLaboParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiporelalaboReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tiporelalaboReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoRelaLaboWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			InformacionLaboralLogic informacionlaboralLogic=new InformacionLaboralLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoRelaLaboWithConnection");connexion.begin();
			
			
			classes.add(new Classe(InformacionLaboral.class));
											
			

			informacionlaboralLogic.setConnexion(this.getConnexion());
			informacionlaboralLogic.setDatosCliente(this.datosCliente);
			informacionlaboralLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoRelaLabo tiporelalabo:this.tiporelalabos) {
				

				classes=new ArrayList<Classe>();
				classes=InformacionLaboralConstantesFunciones.getClassesForeignKeysOfInformacionLaboral(new ArrayList<Classe>(),DeepLoadType.NONE);

				informacionlaboralLogic.setInformacionLaborals(tiporelalabo.informacionlaborals);
				informacionlaboralLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoRelaLabo tiporelalabo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoRelaLaboLogicAdditional.updateTipoRelaLaboToGet(tiporelalabo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporelalabo.setEmpresa(tiporelalaboDataAccess.getEmpresa(connexion,tiporelalabo));
		tiporelalabo.setInformacionLaborals(tiporelalaboDataAccess.getInformacionLaborals(connexion,tiporelalabo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiporelalabo.setEmpresa(tiporelalaboDataAccess.getEmpresa(connexion,tiporelalabo));
				continue;
			}

			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporelalabo.setInformacionLaborals(tiporelalaboDataAccess.getInformacionLaborals(connexion,tiporelalabo));

				if(this.isConDeep) {
					InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(this.connexion);
					informacionlaboralLogic.setInformacionLaborals(tiporelalabo.getInformacionLaborals());
					ArrayList<Classe> classesLocal=InformacionLaboralConstantesFunciones.getClassesForeignKeysOfInformacionLaboral(new ArrayList<Classe>(),DeepLoadType.NONE);
					informacionlaboralLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(informacionlaboralLogic.getInformacionLaborals());
					tiporelalabo.setInformacionLaborals(informacionlaboralLogic.getInformacionLaborals());
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
			tiporelalabo.setEmpresa(tiporelalaboDataAccess.getEmpresa(connexion,tiporelalabo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionLaboral.class));
			tiporelalabo.setInformacionLaborals(tiporelalaboDataAccess.getInformacionLaborals(connexion,tiporelalabo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporelalabo.setEmpresa(tiporelalaboDataAccess.getEmpresa(connexion,tiporelalabo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiporelalabo.getEmpresa(),isDeep,deepLoadType,clases);
				

		tiporelalabo.setInformacionLaborals(tiporelalaboDataAccess.getInformacionLaborals(connexion,tiporelalabo));

		for(InformacionLaboral informacionlaboral:tiporelalabo.getInformacionLaborals()) {
			InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
			informacionlaboralLogic.deepLoad(informacionlaboral,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiporelalabo.setEmpresa(tiporelalaboDataAccess.getEmpresa(connexion,tiporelalabo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tiporelalabo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporelalabo.setInformacionLaborals(tiporelalaboDataAccess.getInformacionLaborals(connexion,tiporelalabo));

				for(InformacionLaboral informacionlaboral:tiporelalabo.getInformacionLaborals()) {
					InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
					informacionlaboralLogic.deepLoad(informacionlaboral,isDeep,deepLoadType,clases);
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
			tiporelalabo.setEmpresa(tiporelalaboDataAccess.getEmpresa(connexion,tiporelalabo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tiporelalabo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionLaboral.class));
			tiporelalabo.setInformacionLaborals(tiporelalaboDataAccess.getInformacionLaborals(connexion,tiporelalabo));

			for(InformacionLaboral informacionlaboral:tiporelalabo.getInformacionLaborals()) {
				InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
				informacionlaboralLogic.deepLoad(informacionlaboral,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoRelaLabo tiporelalabo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoRelaLaboLogicAdditional.updateTipoRelaLaboToSave(tiporelalabo,this.arrDatoGeneral);
			
TipoRelaLaboDataAccess.save(tiporelalabo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiporelalabo.getEmpresa(),connexion);

		for(InformacionLaboral informacionlaboral:tiporelalabo.getInformacionLaborals()) {
			informacionlaboral.setidvalorclienterelacionlaboral(tiporelalabo.getId());
			InformacionLaboralDataAccess.save(informacionlaboral,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiporelalabo.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionLaboral informacionlaboral:tiporelalabo.getInformacionLaborals()) {
					informacionlaboral.setidvalorclienterelacionlaboral(tiporelalabo.getId());
					InformacionLaboralDataAccess.save(informacionlaboral,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiporelalabo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiporelalabo.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(InformacionLaboral informacionlaboral:tiporelalabo.getInformacionLaborals()) {
			InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
			informacionlaboral.setidvalorclienterelacionlaboral(tiporelalabo.getId());
			InformacionLaboralDataAccess.save(informacionlaboral,connexion);
			informacionlaboralLogic.deepSave(informacionlaboral,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiporelalabo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tiporelalabo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionLaboral informacionlaboral:tiporelalabo.getInformacionLaborals()) {
					InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
					informacionlaboral.setidvalorclienterelacionlaboral(tiporelalabo.getId());
					InformacionLaboralDataAccess.save(informacionlaboral,connexion);
					informacionlaboralLogic.deepSave(informacionlaboral,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoRelaLabo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiporelalabo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(tiporelalabo);
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
			this.deepLoad(this.tiporelalabo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoRelaLabo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiporelalabos!=null) {
				for(TipoRelaLabo tiporelalabo:tiporelalabos) {
					this.deepLoad(tiporelalabo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(tiporelalabos);
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
			if(tiporelalabos!=null) {
				for(TipoRelaLabo tiporelalabo:tiporelalabos) {
					this.deepLoad(tiporelalabo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(tiporelalabos);
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
			this.getNewConnexionToDeep(TipoRelaLabo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiporelalabo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoRelaLabo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiporelalabos!=null) {
				for(TipoRelaLabo tiporelalabo:tiporelalabos) {
					this.deepSave(tiporelalabo,isDeep,deepLoadType,clases);
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
			if(tiporelalabos!=null) {
				for(TipoRelaLabo tiporelalabo:tiporelalabos) {
					this.deepSave(tiporelalabo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoRelaLabosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRelaLabo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoRelaLaboConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporelalabos=tiporelalaboDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRelaLabosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoRelaLaboConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoRelaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporelalabos=tiporelalaboDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRelaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoRelaLabo(this.tiporelalabos);
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
			if(TipoRelaLaboConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRelaLaboDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoRelaLabo tiporelalabo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoRelaLaboConstantesFunciones.ISCONAUDITORIA) {
				if(tiporelalabo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRelaLaboDataAccess.TABLENAME, tiporelalabo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRelaLaboConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRelaLaboLogic.registrarAuditoriaDetallesTipoRelaLabo(connexion,tiporelalabo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiporelalabo.getIsDeleted()) {
					/*if(!tiporelalabo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoRelaLaboDataAccess.TABLENAME, tiporelalabo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoRelaLaboLogic.registrarAuditoriaDetallesTipoRelaLabo(connexion,tiporelalabo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRelaLaboDataAccess.TABLENAME, tiporelalabo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiporelalabo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRelaLaboDataAccess.TABLENAME, tiporelalabo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRelaLaboConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRelaLaboLogic.registrarAuditoriaDetallesTipoRelaLabo(connexion,tiporelalabo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoRelaLabo(Connexion connexion,TipoRelaLabo tiporelalabo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiporelalabo.getIsNew()||!tiporelalabo.getid_empresa().equals(tiporelalabo.getTipoRelaLaboOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporelalabo.getTipoRelaLaboOriginal().getid_empresa()!=null)
				{
					strValorActual=tiporelalabo.getTipoRelaLaboOriginal().getid_empresa().toString();
				}
				if(tiporelalabo.getid_empresa()!=null)
				{
					strValorNuevo=tiporelalabo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRelaLaboConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tiporelalabo.getIsNew()||!tiporelalabo.getcodigo().equals(tiporelalabo.getTipoRelaLaboOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporelalabo.getTipoRelaLaboOriginal().getcodigo()!=null)
				{
					strValorActual=tiporelalabo.getTipoRelaLaboOriginal().getcodigo();
				}
				if(tiporelalabo.getcodigo()!=null)
				{
					strValorNuevo=tiporelalabo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRelaLaboConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiporelalabo.getIsNew()||!tiporelalabo.getnombre().equals(tiporelalabo.getTipoRelaLaboOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporelalabo.getTipoRelaLaboOriginal().getnombre()!=null)
				{
					strValorActual=tiporelalabo.getTipoRelaLaboOriginal().getnombre();
				}
				if(tiporelalabo.getnombre()!=null)
				{
					strValorNuevo=tiporelalabo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRelaLaboConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoRelaLaboRelacionesWithConnection(TipoRelaLabo tiporelalabo,List<InformacionLaboral> informacionlaborals) throws Exception {

		if(!tiporelalabo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRelaLaboRelacionesBase(tiporelalabo,informacionlaborals,true);
		}
	}

	public void saveTipoRelaLaboRelaciones(TipoRelaLabo tiporelalabo,List<InformacionLaboral> informacionlaborals)throws Exception {

		if(!tiporelalabo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRelaLaboRelacionesBase(tiporelalabo,informacionlaborals,false);
		}
	}

	public void saveTipoRelaLaboRelacionesBase(TipoRelaLabo tiporelalabo,List<InformacionLaboral> informacionlaborals,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoRelaLabo-saveRelacionesWithConnection");}
	
			tiporelalabo.setInformacionLaborals(informacionlaborals);

			this.setTipoRelaLabo(tiporelalabo);

			if(TipoRelaLaboLogicAdditional.validarSaveRelaciones(tiporelalabo,this)) {

				TipoRelaLaboLogicAdditional.updateRelacionesToSave(tiporelalabo,this);

				if((tiporelalabo.getIsNew()||tiporelalabo.getIsChanged())&&!tiporelalabo.getIsDeleted()) {
					this.saveTipoRelaLabo();
					this.saveTipoRelaLaboRelacionesDetalles(informacionlaborals);

				} else if(tiporelalabo.getIsDeleted()) {
					this.saveTipoRelaLaboRelacionesDetalles(informacionlaborals);
					this.saveTipoRelaLabo();
				}

				TipoRelaLaboLogicAdditional.updateRelacionesToSaveAfter(tiporelalabo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			InformacionLaboralConstantesFunciones.InicializarGeneralEntityAuxiliaresInformacionLaborals(informacionlaborals,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoRelaLaboRelacionesDetalles(List<InformacionLaboral> informacionlaborals)throws Exception {
		try {
	

			Long idTipoRelaLaboActual=this.getTipoRelaLabo().getId();

			InformacionLaboralLogic informacionlaboralLogic_Desde_TipoRelaLabo=new InformacionLaboralLogic();
			informacionlaboralLogic_Desde_TipoRelaLabo.setInformacionLaborals(informacionlaborals);

			informacionlaboralLogic_Desde_TipoRelaLabo.setConnexion(this.getConnexion());
			informacionlaboralLogic_Desde_TipoRelaLabo.setDatosCliente(this.datosCliente);

			for(InformacionLaboral informacionlaboral_Desde_TipoRelaLabo:informacionlaboralLogic_Desde_TipoRelaLabo.getInformacionLaborals()) {
				informacionlaboral_Desde_TipoRelaLabo.setidvalorclienterelacionlaboral(idTipoRelaLaboActual);
			}

			informacionlaboralLogic_Desde_TipoRelaLabo.saveInformacionLaborals();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRelaLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRelaLaboConstantesFunciones.getClassesForeignKeysOfTipoRelaLabo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRelaLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRelaLaboConstantesFunciones.getClassesRelationshipsOfTipoRelaLabo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

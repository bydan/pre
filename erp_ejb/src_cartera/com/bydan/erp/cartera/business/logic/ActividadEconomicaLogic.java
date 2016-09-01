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
import com.bydan.erp.cartera.util.ActividadEconomicaConstantesFunciones;
import com.bydan.erp.cartera.util.ActividadEconomicaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ActividadEconomicaParameterGeneral;
import com.bydan.erp.cartera.business.entity.ActividadEconomica;
import com.bydan.erp.cartera.business.logic.ActividadEconomicaLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ActividadEconomicaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ActividadEconomicaLogic.class);
	
	protected ActividadEconomicaDataAccess actividadeconomicaDataAccess; 	
	protected ActividadEconomica actividadeconomica;
	protected List<ActividadEconomica> actividadeconomicas;
	protected Object actividadeconomicaObject;	
	protected List<Object> actividadeconomicasObject;
	
	public static ClassValidator<ActividadEconomica> actividadeconomicaValidator = new ClassValidator<ActividadEconomica>(ActividadEconomica.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ActividadEconomicaLogicAdditional actividadeconomicaLogicAdditional=null;
	
	public ActividadEconomicaLogicAdditional getActividadEconomicaLogicAdditional() {
		return this.actividadeconomicaLogicAdditional;
	}
	
	public void setActividadEconomicaLogicAdditional(ActividadEconomicaLogicAdditional actividadeconomicaLogicAdditional) {
		try {
			this.actividadeconomicaLogicAdditional=actividadeconomicaLogicAdditional;
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
	
	
	
	
	public  ActividadEconomicaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.actividadeconomicaDataAccess = new ActividadEconomicaDataAccess();
			
			this.actividadeconomicas= new ArrayList<ActividadEconomica>();
			this.actividadeconomica= new ActividadEconomica();
			
			this.actividadeconomicaObject=new Object();
			this.actividadeconomicasObject=new ArrayList<Object>();
				
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
			
			this.actividadeconomicaDataAccess.setConnexionType(this.connexionType);
			this.actividadeconomicaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ActividadEconomicaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.actividadeconomicaDataAccess = new ActividadEconomicaDataAccess();
			this.actividadeconomicas= new ArrayList<ActividadEconomica>();
			this.actividadeconomica= new ActividadEconomica();
			this.actividadeconomicaObject=new Object();
			this.actividadeconomicasObject=new ArrayList<Object>();
			
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
			
			this.actividadeconomicaDataAccess.setConnexionType(this.connexionType);
			this.actividadeconomicaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ActividadEconomica getActividadEconomica() throws Exception {	
		ActividadEconomicaLogicAdditional.checkActividadEconomicaToGet(actividadeconomica,this.datosCliente,this.arrDatoGeneral);
		ActividadEconomicaLogicAdditional.updateActividadEconomicaToGet(actividadeconomica,this.arrDatoGeneral);
		
		return actividadeconomica;
	}
		
	public void setActividadEconomica(ActividadEconomica newActividadEconomica) {
		this.actividadeconomica = newActividadEconomica;
	}
	
	public ActividadEconomicaDataAccess getActividadEconomicaDataAccess() {
		return actividadeconomicaDataAccess;
	}
	
	public void setActividadEconomicaDataAccess(ActividadEconomicaDataAccess newactividadeconomicaDataAccess) {
		this.actividadeconomicaDataAccess = newactividadeconomicaDataAccess;
	}
	
	public List<ActividadEconomica> getActividadEconomicas() throws Exception {		
		this.quitarActividadEconomicasNulos();
		
		ActividadEconomicaLogicAdditional.checkActividadEconomicaToGets(actividadeconomicas,this.datosCliente,this.arrDatoGeneral);
		
		for (ActividadEconomica actividadeconomicaLocal: actividadeconomicas ) {
			ActividadEconomicaLogicAdditional.updateActividadEconomicaToGet(actividadeconomicaLocal,this.arrDatoGeneral);
		}
		
		return actividadeconomicas;
	}
	
	public void setActividadEconomicas(List<ActividadEconomica> newActividadEconomicas) {
		this.actividadeconomicas = newActividadEconomicas;
	}
	
	public Object getActividadEconomicaObject() {	
		this.actividadeconomicaObject=this.actividadeconomicaDataAccess.getEntityObject();
		return this.actividadeconomicaObject;
	}
		
	public void setActividadEconomicaObject(Object newActividadEconomicaObject) {
		this.actividadeconomicaObject = newActividadEconomicaObject;
	}
	
	public List<Object> getActividadEconomicasObject() {		
		this.actividadeconomicasObject=this.actividadeconomicaDataAccess.getEntitiesObject();
		return this.actividadeconomicasObject;
	}
		
	public void setActividadEconomicasObject(List<Object> newActividadEconomicasObject) {
		this.actividadeconomicasObject = newActividadEconomicasObject;
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
		
		if(this.actividadeconomicaDataAccess!=null) {
			this.actividadeconomicaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			actividadeconomicaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			actividadeconomicaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		actividadeconomica = new  ActividadEconomica();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			actividadeconomica=actividadeconomicaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.actividadeconomica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomica);
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
		actividadeconomica = new  ActividadEconomica();
		  		  
        try {
			
			actividadeconomica=actividadeconomicaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.actividadeconomica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		actividadeconomica = new  ActividadEconomica();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			actividadeconomica=actividadeconomicaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.actividadeconomica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomica);
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
		actividadeconomica = new  ActividadEconomica();
		  		  
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
		actividadeconomica = new  ActividadEconomica();
		  		  
        try {
			
			actividadeconomica=actividadeconomicaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.actividadeconomica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		actividadeconomica = new  ActividadEconomica();
		  		  
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
		actividadeconomica = new  ActividadEconomica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =actividadeconomicaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		actividadeconomica = new  ActividadEconomica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=actividadeconomicaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		actividadeconomica = new  ActividadEconomica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =actividadeconomicaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		actividadeconomica = new  ActividadEconomica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=actividadeconomicaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		actividadeconomica = new  ActividadEconomica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =actividadeconomicaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		actividadeconomica = new  ActividadEconomica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=actividadeconomicaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		actividadeconomicas = new  ArrayList<ActividadEconomica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarActividadEconomica(actividadeconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
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
		actividadeconomicas = new  ArrayList<ActividadEconomica>();
		  		  
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
		actividadeconomicas = new  ArrayList<ActividadEconomica>();
		  		  
        try {			
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarActividadEconomica(actividadeconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		actividadeconomicas = new  ArrayList<ActividadEconomica>();
		  		  
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
		actividadeconomicas = new  ArrayList<ActividadEconomica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarActividadEconomica(actividadeconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
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
		actividadeconomicas = new  ArrayList<ActividadEconomica>();
		  		  
        try {
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarActividadEconomica(actividadeconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
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
		actividadeconomicas = new  ArrayList<ActividadEconomica>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarActividadEconomica(actividadeconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
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
		actividadeconomicas = new  ArrayList<ActividadEconomica>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarActividadEconomica(actividadeconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		actividadeconomica = new  ActividadEconomica();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			actividadeconomica=actividadeconomicaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarActividadEconomica(actividadeconomica);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomica);
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
		actividadeconomica = new  ActividadEconomica();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			actividadeconomica=actividadeconomicaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarActividadEconomica(actividadeconomica);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		actividadeconomicas = new  ArrayList<ActividadEconomica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			actividadeconomicas=actividadeconomicaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarActividadEconomica(actividadeconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
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
		actividadeconomicas = new  ArrayList<ActividadEconomica>();
		  		  
        try {
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			actividadeconomicas=actividadeconomicaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarActividadEconomica(actividadeconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosActividadEconomicasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		actividadeconomicas = new  ArrayList<ActividadEconomica>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getTodosActividadEconomicasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarActividadEconomica(actividadeconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
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
	
	public  void  getTodosActividadEconomicas(String sFinalQuery,Pagination pagination)throws Exception {
		actividadeconomicas = new  ArrayList<ActividadEconomica>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarActividadEconomica(actividadeconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarActividadEconomica(ActividadEconomica actividadeconomica) throws Exception {
		Boolean estaValidado=false;
		
		if(actividadeconomica.getIsNew() || actividadeconomica.getIsChanged()) { 
			this.invalidValues = actividadeconomicaValidator.getInvalidValues(actividadeconomica);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(actividadeconomica);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarActividadEconomica(List<ActividadEconomica> ActividadEconomicas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ActividadEconomica actividadeconomicaLocal:actividadeconomicas) {				
			estaValidadoObjeto=this.validarGuardarActividadEconomica(actividadeconomicaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarActividadEconomica(List<ActividadEconomica> ActividadEconomicas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarActividadEconomica(actividadeconomicas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarActividadEconomica(ActividadEconomica ActividadEconomica) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarActividadEconomica(actividadeconomica)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ActividadEconomica actividadeconomica) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+actividadeconomica.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ActividadEconomicaConstantesFunciones.getActividadEconomicaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"actividadeconomica","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ActividadEconomicaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ActividadEconomicaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveActividadEconomicaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-saveActividadEconomicaWithConnection");connexion.begin();			
			
			ActividadEconomicaLogicAdditional.checkActividadEconomicaToSave(this.actividadeconomica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ActividadEconomicaLogicAdditional.updateActividadEconomicaToSave(this.actividadeconomica,this.arrDatoGeneral);
			
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.actividadeconomica,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowActividadEconomica();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarActividadEconomica(this.actividadeconomica)) {
				ActividadEconomicaDataAccess.save(this.actividadeconomica, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.actividadeconomica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ActividadEconomicaLogicAdditional.checkActividadEconomicaToSaveAfter(this.actividadeconomica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowActividadEconomica();
			
			connexion.commit();			
			
			if(this.actividadeconomica.getIsDeleted()) {
				this.actividadeconomica=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveActividadEconomica()throws Exception {	
		try {	
			
			ActividadEconomicaLogicAdditional.checkActividadEconomicaToSave(this.actividadeconomica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ActividadEconomicaLogicAdditional.updateActividadEconomicaToSave(this.actividadeconomica,this.arrDatoGeneral);
			
			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.actividadeconomica,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarActividadEconomica(this.actividadeconomica)) {			
				ActividadEconomicaDataAccess.save(this.actividadeconomica, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.actividadeconomica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ActividadEconomicaLogicAdditional.checkActividadEconomicaToSaveAfter(this.actividadeconomica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.actividadeconomica.getIsDeleted()) {
				this.actividadeconomica=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveActividadEconomicasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-saveActividadEconomicasWithConnection");connexion.begin();			
			
			ActividadEconomicaLogicAdditional.checkActividadEconomicaToSaves(actividadeconomicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowActividadEconomicas();
			
			Boolean validadoTodosActividadEconomica=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ActividadEconomica actividadeconomicaLocal:actividadeconomicas) {		
				if(actividadeconomicaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ActividadEconomicaLogicAdditional.updateActividadEconomicaToSave(actividadeconomicaLocal,this.arrDatoGeneral);
	        	
				ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),actividadeconomicaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarActividadEconomica(actividadeconomicaLocal)) {
					ActividadEconomicaDataAccess.save(actividadeconomicaLocal, connexion);				
				} else {
					validadoTodosActividadEconomica=false;
				}
			}
			
			if(!validadoTodosActividadEconomica) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ActividadEconomicaLogicAdditional.checkActividadEconomicaToSavesAfter(actividadeconomicas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowActividadEconomicas();
			
			connexion.commit();		
			
			this.quitarActividadEconomicasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveActividadEconomicas()throws Exception {				
		 try {	
			ActividadEconomicaLogicAdditional.checkActividadEconomicaToSaves(actividadeconomicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosActividadEconomica=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ActividadEconomica actividadeconomicaLocal:actividadeconomicas) {				
				if(actividadeconomicaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ActividadEconomicaLogicAdditional.updateActividadEconomicaToSave(actividadeconomicaLocal,this.arrDatoGeneral);
	        	
				ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),actividadeconomicaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarActividadEconomica(actividadeconomicaLocal)) {				
					ActividadEconomicaDataAccess.save(actividadeconomicaLocal, connexion);				
				} else {
					validadoTodosActividadEconomica=false;
				}
			}
			
			if(!validadoTodosActividadEconomica) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ActividadEconomicaLogicAdditional.checkActividadEconomicaToSavesAfter(actividadeconomicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarActividadEconomicasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ActividadEconomicaParameterReturnGeneral procesarAccionActividadEconomicas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ActividadEconomica> actividadeconomicas,ActividadEconomicaParameterReturnGeneral actividadeconomicaParameterGeneral)throws Exception {
		 try {	
			ActividadEconomicaParameterReturnGeneral actividadeconomicaReturnGeneral=new ActividadEconomicaParameterReturnGeneral();
	
			ActividadEconomicaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,actividadeconomicas,actividadeconomicaParameterGeneral,actividadeconomicaReturnGeneral);
			
			return actividadeconomicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ActividadEconomicaParameterReturnGeneral procesarAccionActividadEconomicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ActividadEconomica> actividadeconomicas,ActividadEconomicaParameterReturnGeneral actividadeconomicaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-procesarAccionActividadEconomicasWithConnection");connexion.begin();			
			
			ActividadEconomicaParameterReturnGeneral actividadeconomicaReturnGeneral=new ActividadEconomicaParameterReturnGeneral();
	
			ActividadEconomicaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,actividadeconomicas,actividadeconomicaParameterGeneral,actividadeconomicaReturnGeneral);
			
			this.connexion.commit();
			
			return actividadeconomicaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ActividadEconomicaParameterReturnGeneral procesarEventosActividadEconomicas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ActividadEconomica> actividadeconomicas,ActividadEconomica actividadeconomica,ActividadEconomicaParameterReturnGeneral actividadeconomicaParameterGeneral,Boolean isEsNuevoActividadEconomica,ArrayList<Classe> clases)throws Exception {
		 try {	
			ActividadEconomicaParameterReturnGeneral actividadeconomicaReturnGeneral=new ActividadEconomicaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				actividadeconomicaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ActividadEconomicaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,actividadeconomicas,actividadeconomica,actividadeconomicaParameterGeneral,actividadeconomicaReturnGeneral,isEsNuevoActividadEconomica,clases);
			
			return actividadeconomicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ActividadEconomicaParameterReturnGeneral procesarEventosActividadEconomicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ActividadEconomica> actividadeconomicas,ActividadEconomica actividadeconomica,ActividadEconomicaParameterReturnGeneral actividadeconomicaParameterGeneral,Boolean isEsNuevoActividadEconomica,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-procesarEventosActividadEconomicasWithConnection");connexion.begin();			
			
			ActividadEconomicaParameterReturnGeneral actividadeconomicaReturnGeneral=new ActividadEconomicaParameterReturnGeneral();
	
			actividadeconomicaReturnGeneral.setActividadEconomica(actividadeconomica);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				actividadeconomicaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ActividadEconomicaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,actividadeconomicas,actividadeconomica,actividadeconomicaParameterGeneral,actividadeconomicaReturnGeneral,isEsNuevoActividadEconomica,clases);
			
			this.connexion.commit();
			
			return actividadeconomicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ActividadEconomicaParameterReturnGeneral procesarImportacionActividadEconomicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ActividadEconomicaParameterReturnGeneral actividadeconomicaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-procesarImportacionActividadEconomicasWithConnection");connexion.begin();			
			
			ActividadEconomicaParameterReturnGeneral actividadeconomicaReturnGeneral=new ActividadEconomicaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.actividadeconomicas=new ArrayList<ActividadEconomica>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.actividadeconomica=new ActividadEconomica();
				
				
				if(conColumnasBase) {this.actividadeconomica.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.actividadeconomica.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.actividadeconomica.setnombre_negocio(arrColumnas[iColumn++]);
				this.actividadeconomica.setactividad(arrColumnas[iColumn++]);
			this.actividadeconomica.setdireccion(arrColumnas[iColumn++]);
				this.actividadeconomica.settelefono(arrColumnas[iColumn++]);
				this.actividadeconomica.setingreso_neto(Double.parseDouble(arrColumnas[iColumn++]));
				this.actividadeconomica.setingreso_bruto(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.actividadeconomicas.add(this.actividadeconomica);
			}
			
			this.saveActividadEconomicas();
			
			this.connexion.commit();
			
			actividadeconomicaReturnGeneral.setConRetornoEstaProcesado(true);
			actividadeconomicaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return actividadeconomicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarActividadEconomicasEliminados() throws Exception {				
		
		List<ActividadEconomica> actividadeconomicasAux= new ArrayList<ActividadEconomica>();
		
		for(ActividadEconomica actividadeconomica:actividadeconomicas) {
			if(!actividadeconomica.getIsDeleted()) {
				actividadeconomicasAux.add(actividadeconomica);
			}
		}
		
		actividadeconomicas=actividadeconomicasAux;
	}
	
	public void quitarActividadEconomicasNulos() throws Exception {				
		
		List<ActividadEconomica> actividadeconomicasAux= new ArrayList<ActividadEconomica>();
		
		for(ActividadEconomica actividadeconomica : this.actividadeconomicas) {
			if(actividadeconomica==null) {
				actividadeconomicasAux.add(actividadeconomica);
			}
		}
		
		//this.actividadeconomicas=actividadeconomicasAux;
		
		this.actividadeconomicas.removeAll(actividadeconomicasAux);
	}
	
	public void getSetVersionRowActividadEconomicaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(actividadeconomica.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((actividadeconomica.getIsDeleted() || (actividadeconomica.getIsChanged()&&!actividadeconomica.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=actividadeconomicaDataAccess.getSetVersionRowActividadEconomica(connexion,actividadeconomica.getId());
				
				if(!actividadeconomica.getVersionRow().equals(timestamp)) {	
					actividadeconomica.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				actividadeconomica.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowActividadEconomica()throws Exception {	
		
		if(actividadeconomica.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((actividadeconomica.getIsDeleted() || (actividadeconomica.getIsChanged()&&!actividadeconomica.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=actividadeconomicaDataAccess.getSetVersionRowActividadEconomica(connexion,actividadeconomica.getId());
			
			try {							
				if(!actividadeconomica.getVersionRow().equals(timestamp)) {	
					actividadeconomica.setVersionRow(timestamp);
				}
				
				actividadeconomica.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowActividadEconomicasWithConnection()throws Exception {	
		if(actividadeconomicas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ActividadEconomica actividadeconomicaAux:actividadeconomicas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(actividadeconomicaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(actividadeconomicaAux.getIsDeleted() || (actividadeconomicaAux.getIsChanged()&&!actividadeconomicaAux.getIsNew())) {
						
						timestamp=actividadeconomicaDataAccess.getSetVersionRowActividadEconomica(connexion,actividadeconomicaAux.getId());
						
						if(!actividadeconomica.getVersionRow().equals(timestamp)) {	
							actividadeconomicaAux.setVersionRow(timestamp);
						}
								
						actividadeconomicaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowActividadEconomicas()throws Exception {	
		if(actividadeconomicas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ActividadEconomica actividadeconomicaAux:actividadeconomicas) {
					if(actividadeconomicaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(actividadeconomicaAux.getIsDeleted() || (actividadeconomicaAux.getIsChanged()&&!actividadeconomicaAux.getIsNew())) {
						
						timestamp=actividadeconomicaDataAccess.getSetVersionRowActividadEconomica(connexion,actividadeconomicaAux.getId());
						
						if(!actividadeconomicaAux.getVersionRow().equals(timestamp)) {	
							actividadeconomicaAux.setVersionRow(timestamp);
						}
						
													
						actividadeconomicaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ActividadEconomicaParameterReturnGeneral cargarCombosLoteForeignKeyActividadEconomicaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		ActividadEconomicaParameterReturnGeneral  actividadeconomicaReturnGeneral =new ActividadEconomicaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-cargarCombosLoteForeignKeyActividadEconomicaWithConnection");connexion.begin();
			
			actividadeconomicaReturnGeneral =new ActividadEconomicaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			actividadeconomicaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			actividadeconomicaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			actividadeconomicaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			actividadeconomicaReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return actividadeconomicaReturnGeneral;
	}
	
	public ActividadEconomicaParameterReturnGeneral cargarCombosLoteForeignKeyActividadEconomica(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		ActividadEconomicaParameterReturnGeneral  actividadeconomicaReturnGeneral =new ActividadEconomicaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			actividadeconomicaReturnGeneral =new ActividadEconomicaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			actividadeconomicaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			actividadeconomicaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			actividadeconomicaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			actividadeconomicaReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return actividadeconomicaReturnGeneral;
	}
	
	
	public void deepLoad(ActividadEconomica actividadeconomica,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ActividadEconomicaLogicAdditional.updateActividadEconomicaToGet(actividadeconomica,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		actividadeconomica.setEmpresa(actividadeconomicaDataAccess.getEmpresa(connexion,actividadeconomica));
		actividadeconomica.setCliente(actividadeconomicaDataAccess.getCliente(connexion,actividadeconomica));
		actividadeconomica.setPais(actividadeconomicaDataAccess.getPais(connexion,actividadeconomica));
		actividadeconomica.setCiudad(actividadeconomicaDataAccess.getCiudad(connexion,actividadeconomica));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				actividadeconomica.setEmpresa(actividadeconomicaDataAccess.getEmpresa(connexion,actividadeconomica));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				actividadeconomica.setCliente(actividadeconomicaDataAccess.getCliente(connexion,actividadeconomica));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				actividadeconomica.setPais(actividadeconomicaDataAccess.getPais(connexion,actividadeconomica));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				actividadeconomica.setCiudad(actividadeconomicaDataAccess.getCiudad(connexion,actividadeconomica));
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
			actividadeconomica.setEmpresa(actividadeconomicaDataAccess.getEmpresa(connexion,actividadeconomica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			actividadeconomica.setCliente(actividadeconomicaDataAccess.getCliente(connexion,actividadeconomica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			actividadeconomica.setPais(actividadeconomicaDataAccess.getPais(connexion,actividadeconomica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			actividadeconomica.setCiudad(actividadeconomicaDataAccess.getCiudad(connexion,actividadeconomica));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		actividadeconomica.setEmpresa(actividadeconomicaDataAccess.getEmpresa(connexion,actividadeconomica));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(actividadeconomica.getEmpresa(),isDeep,deepLoadType,clases);
				
		actividadeconomica.setCliente(actividadeconomicaDataAccess.getCliente(connexion,actividadeconomica));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(actividadeconomica.getCliente(),isDeep,deepLoadType,clases);
				
		actividadeconomica.setPais(actividadeconomicaDataAccess.getPais(connexion,actividadeconomica));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(actividadeconomica.getPais(),isDeep,deepLoadType,clases);
				
		actividadeconomica.setCiudad(actividadeconomicaDataAccess.getCiudad(connexion,actividadeconomica));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(actividadeconomica.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				actividadeconomica.setEmpresa(actividadeconomicaDataAccess.getEmpresa(connexion,actividadeconomica));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(actividadeconomica.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				actividadeconomica.setCliente(actividadeconomicaDataAccess.getCliente(connexion,actividadeconomica));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(actividadeconomica.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				actividadeconomica.setPais(actividadeconomicaDataAccess.getPais(connexion,actividadeconomica));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(actividadeconomica.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				actividadeconomica.setCiudad(actividadeconomicaDataAccess.getCiudad(connexion,actividadeconomica));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(actividadeconomica.getCiudad(),isDeep,deepLoadType,clases);				
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
			actividadeconomica.setEmpresa(actividadeconomicaDataAccess.getEmpresa(connexion,actividadeconomica));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(actividadeconomica.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			actividadeconomica.setCliente(actividadeconomicaDataAccess.getCliente(connexion,actividadeconomica));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(actividadeconomica.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			actividadeconomica.setPais(actividadeconomicaDataAccess.getPais(connexion,actividadeconomica));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(actividadeconomica.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			actividadeconomica.setCiudad(actividadeconomicaDataAccess.getCiudad(connexion,actividadeconomica));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(actividadeconomica.getCiudad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ActividadEconomica actividadeconomica,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ActividadEconomicaLogicAdditional.updateActividadEconomicaToSave(actividadeconomica,this.arrDatoGeneral);
			
ActividadEconomicaDataAccess.save(actividadeconomica, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(actividadeconomica.getEmpresa(),connexion);

		ClienteDataAccess.save(actividadeconomica.getCliente(),connexion);

		PaisDataAccess.save(actividadeconomica.getPais(),connexion);

		CiudadDataAccess.save(actividadeconomica.getCiudad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(actividadeconomica.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(actividadeconomica.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(actividadeconomica.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(actividadeconomica.getCiudad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(actividadeconomica.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(actividadeconomica.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(actividadeconomica.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(actividadeconomica.getCliente(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(actividadeconomica.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(actividadeconomica.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(actividadeconomica.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(actividadeconomica.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(actividadeconomica.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(actividadeconomica.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(actividadeconomica.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(actividadeconomica.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(actividadeconomica.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(actividadeconomica.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(actividadeconomica.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(actividadeconomica.getCiudad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ActividadEconomica.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(actividadeconomica,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(actividadeconomica);
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
			this.deepLoad(this.actividadeconomica,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ActividadEconomica.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(actividadeconomicas!=null) {
				for(ActividadEconomica actividadeconomica:actividadeconomicas) {
					this.deepLoad(actividadeconomica,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(actividadeconomicas);
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
			if(actividadeconomicas!=null) {
				for(ActividadEconomica actividadeconomica:actividadeconomicas) {
					this.deepLoad(actividadeconomica,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(actividadeconomicas);
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
			this.getNewConnexionToDeep(ActividadEconomica.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(actividadeconomica,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ActividadEconomica.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(actividadeconomicas!=null) {
				for(ActividadEconomica actividadeconomica:actividadeconomicas) {
					this.deepSave(actividadeconomica,isDeep,deepLoadType,clases);
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
			if(actividadeconomicas!=null) {
				for(ActividadEconomica actividadeconomica:actividadeconomicas) {
					this.deepSave(actividadeconomica,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getActividadEconomicasFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,ActividadEconomicaConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getActividadEconomicasFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,ActividadEconomicaConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getActividadEconomicasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ActividadEconomicaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getActividadEconomicasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ActividadEconomicaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getActividadEconomicasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ActividadEconomicaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getActividadEconomicasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ActividadEconomicaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getActividadEconomicasFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ActividadEconomica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ActividadEconomicaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getActividadEconomicasFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ActividadEconomicaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ActividadEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(this.actividadeconomicas);
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
			if(ActividadEconomicaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ActividadEconomicaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ActividadEconomica actividadeconomica,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ActividadEconomicaConstantesFunciones.ISCONAUDITORIA) {
				if(actividadeconomica.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ActividadEconomicaDataAccess.TABLENAME, actividadeconomica.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ActividadEconomicaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ActividadEconomicaLogic.registrarAuditoriaDetallesActividadEconomica(connexion,actividadeconomica,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(actividadeconomica.getIsDeleted()) {
					/*if(!actividadeconomica.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ActividadEconomicaDataAccess.TABLENAME, actividadeconomica.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ActividadEconomicaLogic.registrarAuditoriaDetallesActividadEconomica(connexion,actividadeconomica,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ActividadEconomicaDataAccess.TABLENAME, actividadeconomica.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(actividadeconomica.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ActividadEconomicaDataAccess.TABLENAME, actividadeconomica.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ActividadEconomicaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ActividadEconomicaLogic.registrarAuditoriaDetallesActividadEconomica(connexion,actividadeconomica,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesActividadEconomica(Connexion connexion,ActividadEconomica actividadeconomica)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(actividadeconomica.getIsNew()||!actividadeconomica.getid_empresa().equals(actividadeconomica.getActividadEconomicaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(actividadeconomica.getActividadEconomicaOriginal().getid_empresa()!=null)
				{
					strValorActual=actividadeconomica.getActividadEconomicaOriginal().getid_empresa().toString();
				}
				if(actividadeconomica.getid_empresa()!=null)
				{
					strValorNuevo=actividadeconomica.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ActividadEconomicaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(actividadeconomica.getIsNew()||!actividadeconomica.getid_cliente().equals(actividadeconomica.getActividadEconomicaOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(actividadeconomica.getActividadEconomicaOriginal().getid_cliente()!=null)
				{
					strValorActual=actividadeconomica.getActividadEconomicaOriginal().getid_cliente().toString();
				}
				if(actividadeconomica.getid_cliente()!=null)
				{
					strValorNuevo=actividadeconomica.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ActividadEconomicaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(actividadeconomica.getIsNew()||!actividadeconomica.getnombre_negocio().equals(actividadeconomica.getActividadEconomicaOriginal().getnombre_negocio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(actividadeconomica.getActividadEconomicaOriginal().getnombre_negocio()!=null)
				{
					strValorActual=actividadeconomica.getActividadEconomicaOriginal().getnombre_negocio();
				}
				if(actividadeconomica.getnombre_negocio()!=null)
				{
					strValorNuevo=actividadeconomica.getnombre_negocio() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ActividadEconomicaConstantesFunciones.NOMBRENEGOCIO,strValorActual,strValorNuevo);
			}	
			
			if(actividadeconomica.getIsNew()||!actividadeconomica.getactividad().equals(actividadeconomica.getActividadEconomicaOriginal().getactividad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(actividadeconomica.getActividadEconomicaOriginal().getactividad()!=null)
				{
					strValorActual=actividadeconomica.getActividadEconomicaOriginal().getactividad();
				}
				if(actividadeconomica.getactividad()!=null)
				{
					strValorNuevo=actividadeconomica.getactividad() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ActividadEconomicaConstantesFunciones.ACTIVIDAD,strValorActual,strValorNuevo);
			}	
			
			if(actividadeconomica.getIsNew()||!actividadeconomica.getid_pais().equals(actividadeconomica.getActividadEconomicaOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(actividadeconomica.getActividadEconomicaOriginal().getid_pais()!=null)
				{
					strValorActual=actividadeconomica.getActividadEconomicaOriginal().getid_pais().toString();
				}
				if(actividadeconomica.getid_pais()!=null)
				{
					strValorNuevo=actividadeconomica.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ActividadEconomicaConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(actividadeconomica.getIsNew()||!actividadeconomica.getid_ciudad().equals(actividadeconomica.getActividadEconomicaOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(actividadeconomica.getActividadEconomicaOriginal().getid_ciudad()!=null)
				{
					strValorActual=actividadeconomica.getActividadEconomicaOriginal().getid_ciudad().toString();
				}
				if(actividadeconomica.getid_ciudad()!=null)
				{
					strValorNuevo=actividadeconomica.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ActividadEconomicaConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(actividadeconomica.getIsNew()||!actividadeconomica.getdireccion().equals(actividadeconomica.getActividadEconomicaOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(actividadeconomica.getActividadEconomicaOriginal().getdireccion()!=null)
				{
					strValorActual=actividadeconomica.getActividadEconomicaOriginal().getdireccion();
				}
				if(actividadeconomica.getdireccion()!=null)
				{
					strValorNuevo=actividadeconomica.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ActividadEconomicaConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(actividadeconomica.getIsNew()||!actividadeconomica.gettelefono().equals(actividadeconomica.getActividadEconomicaOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(actividadeconomica.getActividadEconomicaOriginal().gettelefono()!=null)
				{
					strValorActual=actividadeconomica.getActividadEconomicaOriginal().gettelefono();
				}
				if(actividadeconomica.gettelefono()!=null)
				{
					strValorNuevo=actividadeconomica.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ActividadEconomicaConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(actividadeconomica.getIsNew()||!actividadeconomica.getingreso_neto().equals(actividadeconomica.getActividadEconomicaOriginal().getingreso_neto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(actividadeconomica.getActividadEconomicaOriginal().getingreso_neto()!=null)
				{
					strValorActual=actividadeconomica.getActividadEconomicaOriginal().getingreso_neto().toString();
				}
				if(actividadeconomica.getingreso_neto()!=null)
				{
					strValorNuevo=actividadeconomica.getingreso_neto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ActividadEconomicaConstantesFunciones.INGRESONETO,strValorActual,strValorNuevo);
			}	
			
			if(actividadeconomica.getIsNew()||!actividadeconomica.getingreso_bruto().equals(actividadeconomica.getActividadEconomicaOriginal().getingreso_bruto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(actividadeconomica.getActividadEconomicaOriginal().getingreso_bruto()!=null)
				{
					strValorActual=actividadeconomica.getActividadEconomicaOriginal().getingreso_bruto().toString();
				}
				if(actividadeconomica.getingreso_bruto()!=null)
				{
					strValorNuevo=actividadeconomica.getingreso_bruto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ActividadEconomicaConstantesFunciones.INGRESOBRUTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveActividadEconomicaRelacionesWithConnection(ActividadEconomica actividadeconomica) throws Exception {

		if(!actividadeconomica.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveActividadEconomicaRelacionesBase(actividadeconomica,true);
		}
	}

	public void saveActividadEconomicaRelaciones(ActividadEconomica actividadeconomica)throws Exception {

		if(!actividadeconomica.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveActividadEconomicaRelacionesBase(actividadeconomica,false);
		}
	}

	public void saveActividadEconomicaRelacionesBase(ActividadEconomica actividadeconomica,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ActividadEconomica-saveRelacionesWithConnection");}
	

			this.setActividadEconomica(actividadeconomica);

			if(ActividadEconomicaLogicAdditional.validarSaveRelaciones(actividadeconomica,this)) {

				ActividadEconomicaLogicAdditional.updateRelacionesToSave(actividadeconomica,this);

				if((actividadeconomica.getIsNew()||actividadeconomica.getIsChanged())&&!actividadeconomica.getIsDeleted()) {
					this.saveActividadEconomica();
					this.saveActividadEconomicaRelacionesDetalles();

				} else if(actividadeconomica.getIsDeleted()) {
					this.saveActividadEconomicaRelacionesDetalles();
					this.saveActividadEconomica();
				}

				ActividadEconomicaLogicAdditional.updateRelacionesToSaveAfter(actividadeconomica,this);

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
	
	
	private void saveActividadEconomicaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfActividadEconomica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ActividadEconomicaConstantesFunciones.getClassesForeignKeysOfActividadEconomica(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfActividadEconomica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ActividadEconomicaConstantesFunciones.getClassesRelationshipsOfActividadEconomica(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.puntoventa.util.ConfiguracionPunVenConstantesFunciones;
import com.bydan.erp.puntoventa.util.ConfiguracionPunVenParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.ConfiguracionPunVenParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.ConfiguracionPunVen;
import com.bydan.erp.puntoventa.business.logic.ConfiguracionPunVenLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class ConfiguracionPunVenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ConfiguracionPunVenLogic.class);
	
	protected ConfiguracionPunVenDataAccess configuracionpunvenDataAccess; 	
	protected ConfiguracionPunVen configuracionpunven;
	protected List<ConfiguracionPunVen> configuracionpunvens;
	protected Object configuracionpunvenObject;	
	protected List<Object> configuracionpunvensObject;
	
	public static ClassValidator<ConfiguracionPunVen> configuracionpunvenValidator = new ClassValidator<ConfiguracionPunVen>(ConfiguracionPunVen.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ConfiguracionPunVenLogicAdditional configuracionpunvenLogicAdditional=null;
	
	public ConfiguracionPunVenLogicAdditional getConfiguracionPunVenLogicAdditional() {
		return this.configuracionpunvenLogicAdditional;
	}
	
	public void setConfiguracionPunVenLogicAdditional(ConfiguracionPunVenLogicAdditional configuracionpunvenLogicAdditional) {
		try {
			this.configuracionpunvenLogicAdditional=configuracionpunvenLogicAdditional;
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
	
	
	
	
	public  ConfiguracionPunVenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.configuracionpunvenDataAccess = new ConfiguracionPunVenDataAccess();
			
			this.configuracionpunvens= new ArrayList<ConfiguracionPunVen>();
			this.configuracionpunven= new ConfiguracionPunVen();
			
			this.configuracionpunvenObject=new Object();
			this.configuracionpunvensObject=new ArrayList<Object>();
				
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
			
			this.configuracionpunvenDataAccess.setConnexionType(this.connexionType);
			this.configuracionpunvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConfiguracionPunVenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.configuracionpunvenDataAccess = new ConfiguracionPunVenDataAccess();
			this.configuracionpunvens= new ArrayList<ConfiguracionPunVen>();
			this.configuracionpunven= new ConfiguracionPunVen();
			this.configuracionpunvenObject=new Object();
			this.configuracionpunvensObject=new ArrayList<Object>();
			
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
			
			this.configuracionpunvenDataAccess.setConnexionType(this.connexionType);
			this.configuracionpunvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ConfiguracionPunVen getConfiguracionPunVen() throws Exception {	
		ConfiguracionPunVenLogicAdditional.checkConfiguracionPunVenToGet(configuracionpunven,this.datosCliente,this.arrDatoGeneral);
		ConfiguracionPunVenLogicAdditional.updateConfiguracionPunVenToGet(configuracionpunven,this.arrDatoGeneral);
		
		return configuracionpunven;
	}
		
	public void setConfiguracionPunVen(ConfiguracionPunVen newConfiguracionPunVen) {
		this.configuracionpunven = newConfiguracionPunVen;
	}
	
	public ConfiguracionPunVenDataAccess getConfiguracionPunVenDataAccess() {
		return configuracionpunvenDataAccess;
	}
	
	public void setConfiguracionPunVenDataAccess(ConfiguracionPunVenDataAccess newconfiguracionpunvenDataAccess) {
		this.configuracionpunvenDataAccess = newconfiguracionpunvenDataAccess;
	}
	
	public List<ConfiguracionPunVen> getConfiguracionPunVens() throws Exception {		
		this.quitarConfiguracionPunVensNulos();
		
		ConfiguracionPunVenLogicAdditional.checkConfiguracionPunVenToGets(configuracionpunvens,this.datosCliente,this.arrDatoGeneral);
		
		for (ConfiguracionPunVen configuracionpunvenLocal: configuracionpunvens ) {
			ConfiguracionPunVenLogicAdditional.updateConfiguracionPunVenToGet(configuracionpunvenLocal,this.arrDatoGeneral);
		}
		
		return configuracionpunvens;
	}
	
	public void setConfiguracionPunVens(List<ConfiguracionPunVen> newConfiguracionPunVens) {
		this.configuracionpunvens = newConfiguracionPunVens;
	}
	
	public Object getConfiguracionPunVenObject() {	
		this.configuracionpunvenObject=this.configuracionpunvenDataAccess.getEntityObject();
		return this.configuracionpunvenObject;
	}
		
	public void setConfiguracionPunVenObject(Object newConfiguracionPunVenObject) {
		this.configuracionpunvenObject = newConfiguracionPunVenObject;
	}
	
	public List<Object> getConfiguracionPunVensObject() {		
		this.configuracionpunvensObject=this.configuracionpunvenDataAccess.getEntitiesObject();
		return this.configuracionpunvensObject;
	}
		
	public void setConfiguracionPunVensObject(List<Object> newConfiguracionPunVensObject) {
		this.configuracionpunvensObject = newConfiguracionPunVensObject;
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
		
		if(this.configuracionpunvenDataAccess!=null) {
			this.configuracionpunvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			configuracionpunvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			configuracionpunvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		configuracionpunven = new  ConfiguracionPunVen();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			configuracionpunven=configuracionpunvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.configuracionpunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunven);
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
		configuracionpunven = new  ConfiguracionPunVen();
		  		  
        try {
			
			configuracionpunven=configuracionpunvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.configuracionpunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		configuracionpunven = new  ConfiguracionPunVen();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			configuracionpunven=configuracionpunvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.configuracionpunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunven);
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
		configuracionpunven = new  ConfiguracionPunVen();
		  		  
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
		configuracionpunven = new  ConfiguracionPunVen();
		  		  
        try {
			
			configuracionpunven=configuracionpunvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.configuracionpunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		configuracionpunven = new  ConfiguracionPunVen();
		  		  
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
		configuracionpunven = new  ConfiguracionPunVen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =configuracionpunvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		configuracionpunven = new  ConfiguracionPunVen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=configuracionpunvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		configuracionpunven = new  ConfiguracionPunVen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =configuracionpunvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		configuracionpunven = new  ConfiguracionPunVen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=configuracionpunvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		configuracionpunven = new  ConfiguracionPunVen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =configuracionpunvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		configuracionpunven = new  ConfiguracionPunVen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=configuracionpunvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		configuracionpunvens = new  ArrayList<ConfiguracionPunVen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConfiguracionPunVen(configuracionpunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
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
		configuracionpunvens = new  ArrayList<ConfiguracionPunVen>();
		  		  
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
		configuracionpunvens = new  ArrayList<ConfiguracionPunVen>();
		  		  
        try {			
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarConfiguracionPunVen(configuracionpunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		configuracionpunvens = new  ArrayList<ConfiguracionPunVen>();
		  		  
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
		configuracionpunvens = new  ArrayList<ConfiguracionPunVen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConfiguracionPunVen(configuracionpunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
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
		configuracionpunvens = new  ArrayList<ConfiguracionPunVen>();
		  		  
        try {
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConfiguracionPunVen(configuracionpunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
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
		configuracionpunvens = new  ArrayList<ConfiguracionPunVen>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConfiguracionPunVen(configuracionpunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
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
		configuracionpunvens = new  ArrayList<ConfiguracionPunVen>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConfiguracionPunVen(configuracionpunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		configuracionpunven = new  ConfiguracionPunVen();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			configuracionpunven=configuracionpunvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConfiguracionPunVen(configuracionpunven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunven);
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
		configuracionpunven = new  ConfiguracionPunVen();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			configuracionpunven=configuracionpunvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConfiguracionPunVen(configuracionpunven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		configuracionpunvens = new  ArrayList<ConfiguracionPunVen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			configuracionpunvens=configuracionpunvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConfiguracionPunVen(configuracionpunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
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
		configuracionpunvens = new  ArrayList<ConfiguracionPunVen>();
		  		  
        try {
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			configuracionpunvens=configuracionpunvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConfiguracionPunVen(configuracionpunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosConfiguracionPunVensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		configuracionpunvens = new  ArrayList<ConfiguracionPunVen>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getTodosConfiguracionPunVensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConfiguracionPunVen(configuracionpunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
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
	
	public  void  getTodosConfiguracionPunVens(String sFinalQuery,Pagination pagination)throws Exception {
		configuracionpunvens = new  ArrayList<ConfiguracionPunVen>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConfiguracionPunVen(configuracionpunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarConfiguracionPunVen(ConfiguracionPunVen configuracionpunven) throws Exception {
		Boolean estaValidado=false;
		
		if(configuracionpunven.getIsNew() || configuracionpunven.getIsChanged()) { 
			this.invalidValues = configuracionpunvenValidator.getInvalidValues(configuracionpunven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(configuracionpunven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarConfiguracionPunVen(List<ConfiguracionPunVen> ConfiguracionPunVens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ConfiguracionPunVen configuracionpunvenLocal:configuracionpunvens) {				
			estaValidadoObjeto=this.validarGuardarConfiguracionPunVen(configuracionpunvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarConfiguracionPunVen(List<ConfiguracionPunVen> ConfiguracionPunVens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConfiguracionPunVen(configuracionpunvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarConfiguracionPunVen(ConfiguracionPunVen ConfiguracionPunVen) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConfiguracionPunVen(configuracionpunven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ConfiguracionPunVen configuracionpunven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+configuracionpunven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ConfiguracionPunVenConstantesFunciones.getConfiguracionPunVenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"configuracionpunven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ConfiguracionPunVenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ConfiguracionPunVenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveConfiguracionPunVenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-saveConfiguracionPunVenWithConnection");connexion.begin();			
			
			ConfiguracionPunVenLogicAdditional.checkConfiguracionPunVenToSave(this.configuracionpunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConfiguracionPunVenLogicAdditional.updateConfiguracionPunVenToSave(this.configuracionpunven,this.arrDatoGeneral);
			
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.configuracionpunven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowConfiguracionPunVen();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConfiguracionPunVen(this.configuracionpunven)) {
				ConfiguracionPunVenDataAccess.save(this.configuracionpunven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.configuracionpunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConfiguracionPunVenLogicAdditional.checkConfiguracionPunVenToSaveAfter(this.configuracionpunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConfiguracionPunVen();
			
			connexion.commit();			
			
			if(this.configuracionpunven.getIsDeleted()) {
				this.configuracionpunven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveConfiguracionPunVen()throws Exception {	
		try {	
			
			ConfiguracionPunVenLogicAdditional.checkConfiguracionPunVenToSave(this.configuracionpunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConfiguracionPunVenLogicAdditional.updateConfiguracionPunVenToSave(this.configuracionpunven,this.arrDatoGeneral);
			
			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.configuracionpunven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConfiguracionPunVen(this.configuracionpunven)) {			
				ConfiguracionPunVenDataAccess.save(this.configuracionpunven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.configuracionpunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConfiguracionPunVenLogicAdditional.checkConfiguracionPunVenToSaveAfter(this.configuracionpunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.configuracionpunven.getIsDeleted()) {
				this.configuracionpunven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveConfiguracionPunVensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-saveConfiguracionPunVensWithConnection");connexion.begin();			
			
			ConfiguracionPunVenLogicAdditional.checkConfiguracionPunVenToSaves(configuracionpunvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowConfiguracionPunVens();
			
			Boolean validadoTodosConfiguracionPunVen=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ConfiguracionPunVen configuracionpunvenLocal:configuracionpunvens) {		
				if(configuracionpunvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConfiguracionPunVenLogicAdditional.updateConfiguracionPunVenToSave(configuracionpunvenLocal,this.arrDatoGeneral);
	        	
				ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),configuracionpunvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConfiguracionPunVen(configuracionpunvenLocal)) {
					ConfiguracionPunVenDataAccess.save(configuracionpunvenLocal, connexion);				
				} else {
					validadoTodosConfiguracionPunVen=false;
				}
			}
			
			if(!validadoTodosConfiguracionPunVen) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConfiguracionPunVenLogicAdditional.checkConfiguracionPunVenToSavesAfter(configuracionpunvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConfiguracionPunVens();
			
			connexion.commit();		
			
			this.quitarConfiguracionPunVensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveConfiguracionPunVens()throws Exception {				
		 try {	
			ConfiguracionPunVenLogicAdditional.checkConfiguracionPunVenToSaves(configuracionpunvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosConfiguracionPunVen=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ConfiguracionPunVen configuracionpunvenLocal:configuracionpunvens) {				
				if(configuracionpunvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConfiguracionPunVenLogicAdditional.updateConfiguracionPunVenToSave(configuracionpunvenLocal,this.arrDatoGeneral);
	        	
				ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),configuracionpunvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConfiguracionPunVen(configuracionpunvenLocal)) {				
					ConfiguracionPunVenDataAccess.save(configuracionpunvenLocal, connexion);				
				} else {
					validadoTodosConfiguracionPunVen=false;
				}
			}
			
			if(!validadoTodosConfiguracionPunVen) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConfiguracionPunVenLogicAdditional.checkConfiguracionPunVenToSavesAfter(configuracionpunvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarConfiguracionPunVensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConfiguracionPunVenParameterReturnGeneral procesarAccionConfiguracionPunVens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConfiguracionPunVen> configuracionpunvens,ConfiguracionPunVenParameterReturnGeneral configuracionpunvenParameterGeneral)throws Exception {
		 try {	
			ConfiguracionPunVenParameterReturnGeneral configuracionpunvenReturnGeneral=new ConfiguracionPunVenParameterReturnGeneral();
	
			ConfiguracionPunVenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,configuracionpunvens,configuracionpunvenParameterGeneral,configuracionpunvenReturnGeneral);
			
			return configuracionpunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConfiguracionPunVenParameterReturnGeneral procesarAccionConfiguracionPunVensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConfiguracionPunVen> configuracionpunvens,ConfiguracionPunVenParameterReturnGeneral configuracionpunvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-procesarAccionConfiguracionPunVensWithConnection");connexion.begin();			
			
			ConfiguracionPunVenParameterReturnGeneral configuracionpunvenReturnGeneral=new ConfiguracionPunVenParameterReturnGeneral();
	
			ConfiguracionPunVenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,configuracionpunvens,configuracionpunvenParameterGeneral,configuracionpunvenReturnGeneral);
			
			this.connexion.commit();
			
			return configuracionpunvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConfiguracionPunVenParameterReturnGeneral procesarEventosConfiguracionPunVens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ConfiguracionPunVen> configuracionpunvens,ConfiguracionPunVen configuracionpunven,ConfiguracionPunVenParameterReturnGeneral configuracionpunvenParameterGeneral,Boolean isEsNuevoConfiguracionPunVen,ArrayList<Classe> clases)throws Exception {
		 try {	
			ConfiguracionPunVenParameterReturnGeneral configuracionpunvenReturnGeneral=new ConfiguracionPunVenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				configuracionpunvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConfiguracionPunVenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,configuracionpunvens,configuracionpunven,configuracionpunvenParameterGeneral,configuracionpunvenReturnGeneral,isEsNuevoConfiguracionPunVen,clases);
			
			return configuracionpunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ConfiguracionPunVenParameterReturnGeneral procesarEventosConfiguracionPunVensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ConfiguracionPunVen> configuracionpunvens,ConfiguracionPunVen configuracionpunven,ConfiguracionPunVenParameterReturnGeneral configuracionpunvenParameterGeneral,Boolean isEsNuevoConfiguracionPunVen,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-procesarEventosConfiguracionPunVensWithConnection");connexion.begin();			
			
			ConfiguracionPunVenParameterReturnGeneral configuracionpunvenReturnGeneral=new ConfiguracionPunVenParameterReturnGeneral();
	
			configuracionpunvenReturnGeneral.setConfiguracionPunVen(configuracionpunven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				configuracionpunvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConfiguracionPunVenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,configuracionpunvens,configuracionpunven,configuracionpunvenParameterGeneral,configuracionpunvenReturnGeneral,isEsNuevoConfiguracionPunVen,clases);
			
			this.connexion.commit();
			
			return configuracionpunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConfiguracionPunVenParameterReturnGeneral procesarImportacionConfiguracionPunVensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ConfiguracionPunVenParameterReturnGeneral configuracionpunvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-procesarImportacionConfiguracionPunVensWithConnection");connexion.begin();			
			
			ConfiguracionPunVenParameterReturnGeneral configuracionpunvenReturnGeneral=new ConfiguracionPunVenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.configuracionpunvens=new ArrayList<ConfiguracionPunVen>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.configuracionpunven=new ConfiguracionPunVen();
				
				
				if(conColumnasBase) {this.configuracionpunven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.configuracionpunven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.configuracionpunvens.add(this.configuracionpunven);
			}
			
			this.saveConfiguracionPunVens();
			
			this.connexion.commit();
			
			configuracionpunvenReturnGeneral.setConRetornoEstaProcesado(true);
			configuracionpunvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return configuracionpunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarConfiguracionPunVensEliminados() throws Exception {				
		
		List<ConfiguracionPunVen> configuracionpunvensAux= new ArrayList<ConfiguracionPunVen>();
		
		for(ConfiguracionPunVen configuracionpunven:configuracionpunvens) {
			if(!configuracionpunven.getIsDeleted()) {
				configuracionpunvensAux.add(configuracionpunven);
			}
		}
		
		configuracionpunvens=configuracionpunvensAux;
	}
	
	public void quitarConfiguracionPunVensNulos() throws Exception {				
		
		List<ConfiguracionPunVen> configuracionpunvensAux= new ArrayList<ConfiguracionPunVen>();
		
		for(ConfiguracionPunVen configuracionpunven : this.configuracionpunvens) {
			if(configuracionpunven==null) {
				configuracionpunvensAux.add(configuracionpunven);
			}
		}
		
		//this.configuracionpunvens=configuracionpunvensAux;
		
		this.configuracionpunvens.removeAll(configuracionpunvensAux);
	}
	
	public void getSetVersionRowConfiguracionPunVenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(configuracionpunven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((configuracionpunven.getIsDeleted() || (configuracionpunven.getIsChanged()&&!configuracionpunven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=configuracionpunvenDataAccess.getSetVersionRowConfiguracionPunVen(connexion,configuracionpunven.getId());
				
				if(!configuracionpunven.getVersionRow().equals(timestamp)) {	
					configuracionpunven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				configuracionpunven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowConfiguracionPunVen()throws Exception {	
		
		if(configuracionpunven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((configuracionpunven.getIsDeleted() || (configuracionpunven.getIsChanged()&&!configuracionpunven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=configuracionpunvenDataAccess.getSetVersionRowConfiguracionPunVen(connexion,configuracionpunven.getId());
			
			try {							
				if(!configuracionpunven.getVersionRow().equals(timestamp)) {	
					configuracionpunven.setVersionRow(timestamp);
				}
				
				configuracionpunven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowConfiguracionPunVensWithConnection()throws Exception {	
		if(configuracionpunvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ConfiguracionPunVen configuracionpunvenAux:configuracionpunvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(configuracionpunvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(configuracionpunvenAux.getIsDeleted() || (configuracionpunvenAux.getIsChanged()&&!configuracionpunvenAux.getIsNew())) {
						
						timestamp=configuracionpunvenDataAccess.getSetVersionRowConfiguracionPunVen(connexion,configuracionpunvenAux.getId());
						
						if(!configuracionpunven.getVersionRow().equals(timestamp)) {	
							configuracionpunvenAux.setVersionRow(timestamp);
						}
								
						configuracionpunvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowConfiguracionPunVens()throws Exception {	
		if(configuracionpunvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ConfiguracionPunVen configuracionpunvenAux:configuracionpunvens) {
					if(configuracionpunvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(configuracionpunvenAux.getIsDeleted() || (configuracionpunvenAux.getIsChanged()&&!configuracionpunvenAux.getIsNew())) {
						
						timestamp=configuracionpunvenDataAccess.getSetVersionRowConfiguracionPunVen(connexion,configuracionpunvenAux.getId());
						
						if(!configuracionpunvenAux.getVersionRow().equals(timestamp)) {	
							configuracionpunvenAux.setVersionRow(timestamp);
						}
						
													
						configuracionpunvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ConfiguracionPunVenParameterReturnGeneral cargarCombosLoteForeignKeyConfiguracionPunVenWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalCuentaContableEfectivo,String finalQueryGlobalCuentaContableIce,String finalQueryGlobalCuentaContableOtros,String finalQueryGlobalClienteConsumidorFinal,String finalQueryGlobalTipoDocumentoFactura,String finalQueryGlobalTipoDocumentoNotaVenta,String finalQueryGlobalTipoDocumentoNotaCredito,String finalQueryGlobalTipoDocumentoTarjetaCredito,String finalQueryGlobalFormatoFactura,String finalQueryGlobalFormatoNotaVenta,String finalQueryGlobalFormatoNotaCredito,String finalQueryGlobalTransaccionFactura,String finalQueryGlobalTransaccionNotaVenta,String finalQueryGlobalTransaccionNotaCredito,String finalQueryGlobalTransaccionCuentaFactura,String finalQueryGlobalTransaccionCuentaNotaVenta,String finalQueryGlobalTransaccionCuentaNotaCredito) throws Exception {
		ConfiguracionPunVenParameterReturnGeneral  configuracionpunvenReturnGeneral =new ConfiguracionPunVenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-cargarCombosLoteForeignKeyConfiguracionPunVenWithConnection");connexion.begin();
			
			configuracionpunvenReturnGeneral =new ConfiguracionPunVenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			configuracionpunvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			configuracionpunvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			configuracionpunvenReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<CuentaContable> cuentacontableefectivosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableefectivoLogic=new CuentaContableLogic();
			cuentacontableefectivoLogic.setConnexion(this.connexion);
			cuentacontableefectivoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableEfectivo.equals("NONE")) {
				cuentacontableefectivoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableEfectivo,new Pagination());
				cuentacontableefectivosForeignKey=cuentacontableefectivoLogic.getCuentaContables();
			}

			configuracionpunvenReturnGeneral.setcuentacontableefectivosForeignKey(cuentacontableefectivosForeignKey);


			List<CuentaContable> cuentacontableicesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableiceLogic=new CuentaContableLogic();
			cuentacontableiceLogic.setConnexion(this.connexion);
			cuentacontableiceLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIce.equals("NONE")) {
				cuentacontableiceLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIce,new Pagination());
				cuentacontableicesForeignKey=cuentacontableiceLogic.getCuentaContables();
			}

			configuracionpunvenReturnGeneral.setcuentacontableicesForeignKey(cuentacontableicesForeignKey);


			List<CuentaContable> cuentacontableotrossForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableotrosLogic=new CuentaContableLogic();
			cuentacontableotrosLogic.setConnexion(this.connexion);
			cuentacontableotrosLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableOtros.equals("NONE")) {
				cuentacontableotrosLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableOtros,new Pagination());
				cuentacontableotrossForeignKey=cuentacontableotrosLogic.getCuentaContables();
			}

			configuracionpunvenReturnGeneral.setcuentacontableotrossForeignKey(cuentacontableotrossForeignKey);


			List<Cliente> clienteconsumidorfinalsForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteconsumidorfinalLogic=new ClienteLogic();
			clienteconsumidorfinalLogic.setConnexion(this.connexion);
			clienteconsumidorfinalLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteConsumidorFinal.equals("NONE")) {
				clienteconsumidorfinalLogic.getTodosClientes(finalQueryGlobalClienteConsumidorFinal,new Pagination());
				clienteconsumidorfinalsForeignKey=clienteconsumidorfinalLogic.getClientes();
			}

			configuracionpunvenReturnGeneral.setclienteconsumidorfinalsForeignKey(clienteconsumidorfinalsForeignKey);


			List<TipoDocumento> tipodocumentofacturasForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentofacturaLogic=new TipoDocumentoLogic();
			tipodocumentofacturaLogic.setConnexion(this.connexion);
			tipodocumentofacturaLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoFactura.equals("NONE")) {
				tipodocumentofacturaLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoFactura,new Pagination());
				tipodocumentofacturasForeignKey=tipodocumentofacturaLogic.getTipoDocumentos();
			}

			configuracionpunvenReturnGeneral.settipodocumentofacturasForeignKey(tipodocumentofacturasForeignKey);


			List<TipoDocumento> tipodocumentonotaventasForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentonotaventaLogic=new TipoDocumentoLogic();
			tipodocumentonotaventaLogic.setConnexion(this.connexion);
			tipodocumentonotaventaLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoNotaVenta.equals("NONE")) {
				tipodocumentonotaventaLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoNotaVenta,new Pagination());
				tipodocumentonotaventasForeignKey=tipodocumentonotaventaLogic.getTipoDocumentos();
			}

			configuracionpunvenReturnGeneral.settipodocumentonotaventasForeignKey(tipodocumentonotaventasForeignKey);


			List<TipoDocumento> tipodocumentonotacreditosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentonotacreditoLogic=new TipoDocumentoLogic();
			tipodocumentonotacreditoLogic.setConnexion(this.connexion);
			tipodocumentonotacreditoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoNotaCredito.equals("NONE")) {
				tipodocumentonotacreditoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoNotaCredito,new Pagination());
				tipodocumentonotacreditosForeignKey=tipodocumentonotacreditoLogic.getTipoDocumentos();
			}

			configuracionpunvenReturnGeneral.settipodocumentonotacreditosForeignKey(tipodocumentonotacreditosForeignKey);


			List<TipoDocumento> tipodocumentotarjetacreditosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentotarjetacreditoLogic=new TipoDocumentoLogic();
			tipodocumentotarjetacreditoLogic.setConnexion(this.connexion);
			tipodocumentotarjetacreditoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoTarjetaCredito.equals("NONE")) {
				tipodocumentotarjetacreditoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoTarjetaCredito,new Pagination());
				tipodocumentotarjetacreditosForeignKey=tipodocumentotarjetacreditoLogic.getTipoDocumentos();
			}

			configuracionpunvenReturnGeneral.settipodocumentotarjetacreditosForeignKey(tipodocumentotarjetacreditosForeignKey);


			List<Formato> formatofacturasForeignKey=new ArrayList<Formato>();
			FormatoLogic formatofacturaLogic=new FormatoLogic();
			formatofacturaLogic.setConnexion(this.connexion);
			formatofacturaLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoFactura.equals("NONE")) {
				formatofacturaLogic.getTodosFormatos(finalQueryGlobalFormatoFactura,new Pagination());
				formatofacturasForeignKey=formatofacturaLogic.getFormatos();
			}

			configuracionpunvenReturnGeneral.setformatofacturasForeignKey(formatofacturasForeignKey);


			List<Formato> formatonotaventasForeignKey=new ArrayList<Formato>();
			FormatoLogic formatonotaventaLogic=new FormatoLogic();
			formatonotaventaLogic.setConnexion(this.connexion);
			formatonotaventaLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNotaVenta.equals("NONE")) {
				formatonotaventaLogic.getTodosFormatos(finalQueryGlobalFormatoNotaVenta,new Pagination());
				formatonotaventasForeignKey=formatonotaventaLogic.getFormatos();
			}

			configuracionpunvenReturnGeneral.setformatonotaventasForeignKey(formatonotaventasForeignKey);


			List<Formato> formatonotacreditosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatonotacreditoLogic=new FormatoLogic();
			formatonotacreditoLogic.setConnexion(this.connexion);
			formatonotacreditoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNotaCredito.equals("NONE")) {
				formatonotacreditoLogic.getTodosFormatos(finalQueryGlobalFormatoNotaCredito,new Pagination());
				formatonotacreditosForeignKey=formatonotacreditoLogic.getFormatos();
			}

			configuracionpunvenReturnGeneral.setformatonotacreditosForeignKey(formatonotacreditosForeignKey);


			List<Transaccion> transaccionfacturasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionfacturaLogic=new TransaccionLogic();
			transaccionfacturaLogic.setConnexion(this.connexion);
			transaccionfacturaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionFactura.equals("NONE")) {
				transaccionfacturaLogic.getTodosTransaccions(finalQueryGlobalTransaccionFactura,new Pagination());
				transaccionfacturasForeignKey=transaccionfacturaLogic.getTransaccions();
			}

			configuracionpunvenReturnGeneral.settransaccionfacturasForeignKey(transaccionfacturasForeignKey);


			List<Transaccion> transaccionnotaventasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionnotaventaLogic=new TransaccionLogic();
			transaccionnotaventaLogic.setConnexion(this.connexion);
			transaccionnotaventaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionNotaVenta.equals("NONE")) {
				transaccionnotaventaLogic.getTodosTransaccions(finalQueryGlobalTransaccionNotaVenta,new Pagination());
				transaccionnotaventasForeignKey=transaccionnotaventaLogic.getTransaccions();
			}

			configuracionpunvenReturnGeneral.settransaccionnotaventasForeignKey(transaccionnotaventasForeignKey);


			List<Transaccion> transaccionnotacreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionnotacreditoLogic=new TransaccionLogic();
			transaccionnotacreditoLogic.setConnexion(this.connexion);
			transaccionnotacreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionNotaCredito.equals("NONE")) {
				transaccionnotacreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionNotaCredito,new Pagination());
				transaccionnotacreditosForeignKey=transaccionnotacreditoLogic.getTransaccions();
			}

			configuracionpunvenReturnGeneral.settransaccionnotacreditosForeignKey(transaccionnotacreditosForeignKey);


			List<Transaccion> transaccioncuentafacturasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentafacturaLogic=new TransaccionLogic();
			transaccioncuentafacturaLogic.setConnexion(this.connexion);
			transaccioncuentafacturaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaFactura.equals("NONE")) {
				transaccioncuentafacturaLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaFactura,new Pagination());
				transaccioncuentafacturasForeignKey=transaccioncuentafacturaLogic.getTransaccions();
			}

			configuracionpunvenReturnGeneral.settransaccioncuentafacturasForeignKey(transaccioncuentafacturasForeignKey);


			List<Transaccion> transaccioncuentanotaventasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentanotaventaLogic=new TransaccionLogic();
			transaccioncuentanotaventaLogic.setConnexion(this.connexion);
			transaccioncuentanotaventaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaNotaVenta.equals("NONE")) {
				transaccioncuentanotaventaLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaNotaVenta,new Pagination());
				transaccioncuentanotaventasForeignKey=transaccioncuentanotaventaLogic.getTransaccions();
			}

			configuracionpunvenReturnGeneral.settransaccioncuentanotaventasForeignKey(transaccioncuentanotaventasForeignKey);


			List<Transaccion> transaccioncuentanotacreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentanotacreditoLogic=new TransaccionLogic();
			transaccioncuentanotacreditoLogic.setConnexion(this.connexion);
			transaccioncuentanotacreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaNotaCredito.equals("NONE")) {
				transaccioncuentanotacreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaNotaCredito,new Pagination());
				transaccioncuentanotacreditosForeignKey=transaccioncuentanotacreditoLogic.getTransaccions();
			}

			configuracionpunvenReturnGeneral.settransaccioncuentanotacreditosForeignKey(transaccioncuentanotacreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return configuracionpunvenReturnGeneral;
	}
	
	public ConfiguracionPunVenParameterReturnGeneral cargarCombosLoteForeignKeyConfiguracionPunVen(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalCuentaContableEfectivo,String finalQueryGlobalCuentaContableIce,String finalQueryGlobalCuentaContableOtros,String finalQueryGlobalClienteConsumidorFinal,String finalQueryGlobalTipoDocumentoFactura,String finalQueryGlobalTipoDocumentoNotaVenta,String finalQueryGlobalTipoDocumentoNotaCredito,String finalQueryGlobalTipoDocumentoTarjetaCredito,String finalQueryGlobalFormatoFactura,String finalQueryGlobalFormatoNotaVenta,String finalQueryGlobalFormatoNotaCredito,String finalQueryGlobalTransaccionFactura,String finalQueryGlobalTransaccionNotaVenta,String finalQueryGlobalTransaccionNotaCredito,String finalQueryGlobalTransaccionCuentaFactura,String finalQueryGlobalTransaccionCuentaNotaVenta,String finalQueryGlobalTransaccionCuentaNotaCredito) throws Exception {
		ConfiguracionPunVenParameterReturnGeneral  configuracionpunvenReturnGeneral =new ConfiguracionPunVenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			configuracionpunvenReturnGeneral =new ConfiguracionPunVenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			configuracionpunvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			configuracionpunvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			configuracionpunvenReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<CuentaContable> cuentacontableefectivosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableefectivoLogic=new CuentaContableLogic();
			cuentacontableefectivoLogic.setConnexion(this.connexion);
			cuentacontableefectivoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableEfectivo.equals("NONE")) {
				cuentacontableefectivoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableEfectivo,new Pagination());
				cuentacontableefectivosForeignKey=cuentacontableefectivoLogic.getCuentaContables();
			}

			configuracionpunvenReturnGeneral.setcuentacontableefectivosForeignKey(cuentacontableefectivosForeignKey);


			List<CuentaContable> cuentacontableicesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableiceLogic=new CuentaContableLogic();
			cuentacontableiceLogic.setConnexion(this.connexion);
			cuentacontableiceLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIce.equals("NONE")) {
				cuentacontableiceLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIce,new Pagination());
				cuentacontableicesForeignKey=cuentacontableiceLogic.getCuentaContables();
			}

			configuracionpunvenReturnGeneral.setcuentacontableicesForeignKey(cuentacontableicesForeignKey);


			List<CuentaContable> cuentacontableotrossForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableotrosLogic=new CuentaContableLogic();
			cuentacontableotrosLogic.setConnexion(this.connexion);
			cuentacontableotrosLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableOtros.equals("NONE")) {
				cuentacontableotrosLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableOtros,new Pagination());
				cuentacontableotrossForeignKey=cuentacontableotrosLogic.getCuentaContables();
			}

			configuracionpunvenReturnGeneral.setcuentacontableotrossForeignKey(cuentacontableotrossForeignKey);


			List<Cliente> clienteconsumidorfinalsForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteconsumidorfinalLogic=new ClienteLogic();
			clienteconsumidorfinalLogic.setConnexion(this.connexion);
			clienteconsumidorfinalLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteConsumidorFinal.equals("NONE")) {
				clienteconsumidorfinalLogic.getTodosClientes(finalQueryGlobalClienteConsumidorFinal,new Pagination());
				clienteconsumidorfinalsForeignKey=clienteconsumidorfinalLogic.getClientes();
			}

			configuracionpunvenReturnGeneral.setclienteconsumidorfinalsForeignKey(clienteconsumidorfinalsForeignKey);


			List<TipoDocumento> tipodocumentofacturasForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentofacturaLogic=new TipoDocumentoLogic();
			tipodocumentofacturaLogic.setConnexion(this.connexion);
			tipodocumentofacturaLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoFactura.equals("NONE")) {
				tipodocumentofacturaLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoFactura,new Pagination());
				tipodocumentofacturasForeignKey=tipodocumentofacturaLogic.getTipoDocumentos();
			}

			configuracionpunvenReturnGeneral.settipodocumentofacturasForeignKey(tipodocumentofacturasForeignKey);


			List<TipoDocumento> tipodocumentonotaventasForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentonotaventaLogic=new TipoDocumentoLogic();
			tipodocumentonotaventaLogic.setConnexion(this.connexion);
			tipodocumentonotaventaLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoNotaVenta.equals("NONE")) {
				tipodocumentonotaventaLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoNotaVenta,new Pagination());
				tipodocumentonotaventasForeignKey=tipodocumentonotaventaLogic.getTipoDocumentos();
			}

			configuracionpunvenReturnGeneral.settipodocumentonotaventasForeignKey(tipodocumentonotaventasForeignKey);


			List<TipoDocumento> tipodocumentonotacreditosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentonotacreditoLogic=new TipoDocumentoLogic();
			tipodocumentonotacreditoLogic.setConnexion(this.connexion);
			tipodocumentonotacreditoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoNotaCredito.equals("NONE")) {
				tipodocumentonotacreditoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoNotaCredito,new Pagination());
				tipodocumentonotacreditosForeignKey=tipodocumentonotacreditoLogic.getTipoDocumentos();
			}

			configuracionpunvenReturnGeneral.settipodocumentonotacreditosForeignKey(tipodocumentonotacreditosForeignKey);


			List<TipoDocumento> tipodocumentotarjetacreditosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentotarjetacreditoLogic=new TipoDocumentoLogic();
			tipodocumentotarjetacreditoLogic.setConnexion(this.connexion);
			tipodocumentotarjetacreditoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoTarjetaCredito.equals("NONE")) {
				tipodocumentotarjetacreditoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumentoTarjetaCredito,new Pagination());
				tipodocumentotarjetacreditosForeignKey=tipodocumentotarjetacreditoLogic.getTipoDocumentos();
			}

			configuracionpunvenReturnGeneral.settipodocumentotarjetacreditosForeignKey(tipodocumentotarjetacreditosForeignKey);


			List<Formato> formatofacturasForeignKey=new ArrayList<Formato>();
			FormatoLogic formatofacturaLogic=new FormatoLogic();
			formatofacturaLogic.setConnexion(this.connexion);
			formatofacturaLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoFactura.equals("NONE")) {
				formatofacturaLogic.getTodosFormatos(finalQueryGlobalFormatoFactura,new Pagination());
				formatofacturasForeignKey=formatofacturaLogic.getFormatos();
			}

			configuracionpunvenReturnGeneral.setformatofacturasForeignKey(formatofacturasForeignKey);


			List<Formato> formatonotaventasForeignKey=new ArrayList<Formato>();
			FormatoLogic formatonotaventaLogic=new FormatoLogic();
			formatonotaventaLogic.setConnexion(this.connexion);
			formatonotaventaLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNotaVenta.equals("NONE")) {
				formatonotaventaLogic.getTodosFormatos(finalQueryGlobalFormatoNotaVenta,new Pagination());
				formatonotaventasForeignKey=formatonotaventaLogic.getFormatos();
			}

			configuracionpunvenReturnGeneral.setformatonotaventasForeignKey(formatonotaventasForeignKey);


			List<Formato> formatonotacreditosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatonotacreditoLogic=new FormatoLogic();
			formatonotacreditoLogic.setConnexion(this.connexion);
			formatonotacreditoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNotaCredito.equals("NONE")) {
				formatonotacreditoLogic.getTodosFormatos(finalQueryGlobalFormatoNotaCredito,new Pagination());
				formatonotacreditosForeignKey=formatonotacreditoLogic.getFormatos();
			}

			configuracionpunvenReturnGeneral.setformatonotacreditosForeignKey(formatonotacreditosForeignKey);


			List<Transaccion> transaccionfacturasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionfacturaLogic=new TransaccionLogic();
			transaccionfacturaLogic.setConnexion(this.connexion);
			transaccionfacturaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionFactura.equals("NONE")) {
				transaccionfacturaLogic.getTodosTransaccions(finalQueryGlobalTransaccionFactura,new Pagination());
				transaccionfacturasForeignKey=transaccionfacturaLogic.getTransaccions();
			}

			configuracionpunvenReturnGeneral.settransaccionfacturasForeignKey(transaccionfacturasForeignKey);


			List<Transaccion> transaccionnotaventasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionnotaventaLogic=new TransaccionLogic();
			transaccionnotaventaLogic.setConnexion(this.connexion);
			transaccionnotaventaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionNotaVenta.equals("NONE")) {
				transaccionnotaventaLogic.getTodosTransaccions(finalQueryGlobalTransaccionNotaVenta,new Pagination());
				transaccionnotaventasForeignKey=transaccionnotaventaLogic.getTransaccions();
			}

			configuracionpunvenReturnGeneral.settransaccionnotaventasForeignKey(transaccionnotaventasForeignKey);


			List<Transaccion> transaccionnotacreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionnotacreditoLogic=new TransaccionLogic();
			transaccionnotacreditoLogic.setConnexion(this.connexion);
			transaccionnotacreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionNotaCredito.equals("NONE")) {
				transaccionnotacreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionNotaCredito,new Pagination());
				transaccionnotacreditosForeignKey=transaccionnotacreditoLogic.getTransaccions();
			}

			configuracionpunvenReturnGeneral.settransaccionnotacreditosForeignKey(transaccionnotacreditosForeignKey);


			List<Transaccion> transaccioncuentafacturasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentafacturaLogic=new TransaccionLogic();
			transaccioncuentafacturaLogic.setConnexion(this.connexion);
			transaccioncuentafacturaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaFactura.equals("NONE")) {
				transaccioncuentafacturaLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaFactura,new Pagination());
				transaccioncuentafacturasForeignKey=transaccioncuentafacturaLogic.getTransaccions();
			}

			configuracionpunvenReturnGeneral.settransaccioncuentafacturasForeignKey(transaccioncuentafacturasForeignKey);


			List<Transaccion> transaccioncuentanotaventasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentanotaventaLogic=new TransaccionLogic();
			transaccioncuentanotaventaLogic.setConnexion(this.connexion);
			transaccioncuentanotaventaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaNotaVenta.equals("NONE")) {
				transaccioncuentanotaventaLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaNotaVenta,new Pagination());
				transaccioncuentanotaventasForeignKey=transaccioncuentanotaventaLogic.getTransaccions();
			}

			configuracionpunvenReturnGeneral.settransaccioncuentanotaventasForeignKey(transaccioncuentanotaventasForeignKey);


			List<Transaccion> transaccioncuentanotacreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentanotacreditoLogic=new TransaccionLogic();
			transaccioncuentanotacreditoLogic.setConnexion(this.connexion);
			transaccioncuentanotacreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaNotaCredito.equals("NONE")) {
				transaccioncuentanotacreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaNotaCredito,new Pagination());
				transaccioncuentanotacreditosForeignKey=transaccioncuentanotacreditoLogic.getTransaccions();
			}

			configuracionpunvenReturnGeneral.settransaccioncuentanotacreditosForeignKey(transaccioncuentanotacreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return configuracionpunvenReturnGeneral;
	}
	
	
	public void deepLoad(ConfiguracionPunVen configuracionpunven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConfiguracionPunVenLogicAdditional.updateConfiguracionPunVenToGet(configuracionpunven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		configuracionpunven.setEmpresa(configuracionpunvenDataAccess.getEmpresa(connexion,configuracionpunven));
		configuracionpunven.setSucursal(configuracionpunvenDataAccess.getSucursal(connexion,configuracionpunven));
		configuracionpunven.setBodega(configuracionpunvenDataAccess.getBodega(connexion,configuracionpunven));
		configuracionpunven.setCuentaContableEfectivo(configuracionpunvenDataAccess.getCuentaContableEfectivo(connexion,configuracionpunven));
		configuracionpunven.setCuentaContableIce(configuracionpunvenDataAccess.getCuentaContableIce(connexion,configuracionpunven));
		configuracionpunven.setCuentaContableOtros(configuracionpunvenDataAccess.getCuentaContableOtros(connexion,configuracionpunven));
		configuracionpunven.setClienteConsumidorFinal(configuracionpunvenDataAccess.getClienteConsumidorFinal(connexion,configuracionpunven));
		configuracionpunven.setTipoDocumentoFactura(configuracionpunvenDataAccess.getTipoDocumentoFactura(connexion,configuracionpunven));
		configuracionpunven.setTipoDocumentoNotaVenta(configuracionpunvenDataAccess.getTipoDocumentoNotaVenta(connexion,configuracionpunven));
		configuracionpunven.setTipoDocumentoNotaCredito(configuracionpunvenDataAccess.getTipoDocumentoNotaCredito(connexion,configuracionpunven));
		configuracionpunven.setTipoDocumentoTarjetaCredito(configuracionpunvenDataAccess.getTipoDocumentoTarjetaCredito(connexion,configuracionpunven));
		configuracionpunven.setFormatoFactura(configuracionpunvenDataAccess.getFormatoFactura(connexion,configuracionpunven));
		configuracionpunven.setFormatoNotaVenta(configuracionpunvenDataAccess.getFormatoNotaVenta(connexion,configuracionpunven));
		configuracionpunven.setFormatoNotaCredito(configuracionpunvenDataAccess.getFormatoNotaCredito(connexion,configuracionpunven));
		configuracionpunven.setTransaccionFactura(configuracionpunvenDataAccess.getTransaccionFactura(connexion,configuracionpunven));
		configuracionpunven.setTransaccionNotaVenta(configuracionpunvenDataAccess.getTransaccionNotaVenta(connexion,configuracionpunven));
		configuracionpunven.setTransaccionNotaCredito(configuracionpunvenDataAccess.getTransaccionNotaCredito(connexion,configuracionpunven));
		configuracionpunven.setTransaccionCuentaFactura(configuracionpunvenDataAccess.getTransaccionCuentaFactura(connexion,configuracionpunven));
		configuracionpunven.setTransaccionCuentaNotaVenta(configuracionpunvenDataAccess.getTransaccionCuentaNotaVenta(connexion,configuracionpunven));
		configuracionpunven.setTransaccionCuentaNotaCredito(configuracionpunvenDataAccess.getTransaccionCuentaNotaCredito(connexion,configuracionpunven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				configuracionpunven.setEmpresa(configuracionpunvenDataAccess.getEmpresa(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				configuracionpunven.setSucursal(configuracionpunvenDataAccess.getSucursal(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				configuracionpunven.setBodega(configuracionpunvenDataAccess.getBodega(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				configuracionpunven.setCuentaContableEfectivo(configuracionpunvenDataAccess.getCuentaContableEfectivo(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				configuracionpunven.setCuentaContableIce(configuracionpunvenDataAccess.getCuentaContableIce(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				configuracionpunven.setCuentaContableOtros(configuracionpunvenDataAccess.getCuentaContableOtros(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				configuracionpunven.setClienteConsumidorFinal(configuracionpunvenDataAccess.getClienteConsumidorFinal(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				configuracionpunven.setTipoDocumentoFactura(configuracionpunvenDataAccess.getTipoDocumentoFactura(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				configuracionpunven.setTipoDocumentoNotaVenta(configuracionpunvenDataAccess.getTipoDocumentoNotaVenta(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				configuracionpunven.setTipoDocumentoNotaCredito(configuracionpunvenDataAccess.getTipoDocumentoNotaCredito(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				configuracionpunven.setTipoDocumentoTarjetaCredito(configuracionpunvenDataAccess.getTipoDocumentoTarjetaCredito(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				configuracionpunven.setFormatoFactura(configuracionpunvenDataAccess.getFormatoFactura(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				configuracionpunven.setFormatoNotaVenta(configuracionpunvenDataAccess.getFormatoNotaVenta(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				configuracionpunven.setFormatoNotaCredito(configuracionpunvenDataAccess.getFormatoNotaCredito(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				configuracionpunven.setTransaccionFactura(configuracionpunvenDataAccess.getTransaccionFactura(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				configuracionpunven.setTransaccionNotaVenta(configuracionpunvenDataAccess.getTransaccionNotaVenta(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				configuracionpunven.setTransaccionNotaCredito(configuracionpunvenDataAccess.getTransaccionNotaCredito(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				configuracionpunven.setTransaccionCuentaFactura(configuracionpunvenDataAccess.getTransaccionCuentaFactura(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				configuracionpunven.setTransaccionCuentaNotaVenta(configuracionpunvenDataAccess.getTransaccionCuentaNotaVenta(connexion,configuracionpunven));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				configuracionpunven.setTransaccionCuentaNotaCredito(configuracionpunvenDataAccess.getTransaccionCuentaNotaCredito(connexion,configuracionpunven));
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
			configuracionpunven.setEmpresa(configuracionpunvenDataAccess.getEmpresa(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setSucursal(configuracionpunvenDataAccess.getSucursal(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setBodega(configuracionpunvenDataAccess.getBodega(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setCuentaContableEfectivo(configuracionpunvenDataAccess.getCuentaContableEfectivo(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setCuentaContableIce(configuracionpunvenDataAccess.getCuentaContableIce(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setCuentaContableOtros(configuracionpunvenDataAccess.getCuentaContableOtros(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setClienteConsumidorFinal(configuracionpunvenDataAccess.getClienteConsumidorFinal(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTipoDocumentoFactura(configuracionpunvenDataAccess.getTipoDocumentoFactura(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTipoDocumentoNotaVenta(configuracionpunvenDataAccess.getTipoDocumentoNotaVenta(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTipoDocumentoNotaCredito(configuracionpunvenDataAccess.getTipoDocumentoNotaCredito(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTipoDocumentoTarjetaCredito(configuracionpunvenDataAccess.getTipoDocumentoTarjetaCredito(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setFormatoFactura(configuracionpunvenDataAccess.getFormatoFactura(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setFormatoNotaVenta(configuracionpunvenDataAccess.getFormatoNotaVenta(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setFormatoNotaCredito(configuracionpunvenDataAccess.getFormatoNotaCredito(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTransaccionFactura(configuracionpunvenDataAccess.getTransaccionFactura(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTransaccionNotaVenta(configuracionpunvenDataAccess.getTransaccionNotaVenta(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTransaccionNotaCredito(configuracionpunvenDataAccess.getTransaccionNotaCredito(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTransaccionCuentaFactura(configuracionpunvenDataAccess.getTransaccionCuentaFactura(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTransaccionCuentaNotaVenta(configuracionpunvenDataAccess.getTransaccionCuentaNotaVenta(connexion,configuracionpunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTransaccionCuentaNotaCredito(configuracionpunvenDataAccess.getTransaccionCuentaNotaCredito(connexion,configuracionpunven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		configuracionpunven.setEmpresa(configuracionpunvenDataAccess.getEmpresa(connexion,configuracionpunven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(configuracionpunven.getEmpresa(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setSucursal(configuracionpunvenDataAccess.getSucursal(connexion,configuracionpunven));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(configuracionpunven.getSucursal(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setBodega(configuracionpunvenDataAccess.getBodega(connexion,configuracionpunven));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(configuracionpunven.getBodega(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setCuentaContableEfectivo(configuracionpunvenDataAccess.getCuentaContableEfectivo(connexion,configuracionpunven));
		CuentaContableLogic cuentacontableefectivoLogic= new CuentaContableLogic(connexion);
		cuentacontableefectivoLogic.deepLoad(configuracionpunven.getCuentaContableEfectivo(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setCuentaContableIce(configuracionpunvenDataAccess.getCuentaContableIce(connexion,configuracionpunven));
		CuentaContableLogic cuentacontableiceLogic= new CuentaContableLogic(connexion);
		cuentacontableiceLogic.deepLoad(configuracionpunven.getCuentaContableIce(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setCuentaContableOtros(configuracionpunvenDataAccess.getCuentaContableOtros(connexion,configuracionpunven));
		CuentaContableLogic cuentacontableotrosLogic= new CuentaContableLogic(connexion);
		cuentacontableotrosLogic.deepLoad(configuracionpunven.getCuentaContableOtros(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setClienteConsumidorFinal(configuracionpunvenDataAccess.getClienteConsumidorFinal(connexion,configuracionpunven));
		ClienteLogic clienteconsumidorfinalLogic= new ClienteLogic(connexion);
		clienteconsumidorfinalLogic.deepLoad(configuracionpunven.getClienteConsumidorFinal(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setTipoDocumentoFactura(configuracionpunvenDataAccess.getTipoDocumentoFactura(connexion,configuracionpunven));
		TipoDocumentoLogic tipodocumentofacturaLogic= new TipoDocumentoLogic(connexion);
		tipodocumentofacturaLogic.deepLoad(configuracionpunven.getTipoDocumentoFactura(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setTipoDocumentoNotaVenta(configuracionpunvenDataAccess.getTipoDocumentoNotaVenta(connexion,configuracionpunven));
		TipoDocumentoLogic tipodocumentonotaventaLogic= new TipoDocumentoLogic(connexion);
		tipodocumentonotaventaLogic.deepLoad(configuracionpunven.getTipoDocumentoNotaVenta(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setTipoDocumentoNotaCredito(configuracionpunvenDataAccess.getTipoDocumentoNotaCredito(connexion,configuracionpunven));
		TipoDocumentoLogic tipodocumentonotacreditoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentonotacreditoLogic.deepLoad(configuracionpunven.getTipoDocumentoNotaCredito(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setTipoDocumentoTarjetaCredito(configuracionpunvenDataAccess.getTipoDocumentoTarjetaCredito(connexion,configuracionpunven));
		TipoDocumentoLogic tipodocumentotarjetacreditoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentotarjetacreditoLogic.deepLoad(configuracionpunven.getTipoDocumentoTarjetaCredito(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setFormatoFactura(configuracionpunvenDataAccess.getFormatoFactura(connexion,configuracionpunven));
		FormatoLogic formatofacturaLogic= new FormatoLogic(connexion);
		formatofacturaLogic.deepLoad(configuracionpunven.getFormatoFactura(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setFormatoNotaVenta(configuracionpunvenDataAccess.getFormatoNotaVenta(connexion,configuracionpunven));
		FormatoLogic formatonotaventaLogic= new FormatoLogic(connexion);
		formatonotaventaLogic.deepLoad(configuracionpunven.getFormatoNotaVenta(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setFormatoNotaCredito(configuracionpunvenDataAccess.getFormatoNotaCredito(connexion,configuracionpunven));
		FormatoLogic formatonotacreditoLogic= new FormatoLogic(connexion);
		formatonotacreditoLogic.deepLoad(configuracionpunven.getFormatoNotaCredito(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setTransaccionFactura(configuracionpunvenDataAccess.getTransaccionFactura(connexion,configuracionpunven));
		TransaccionLogic transaccionfacturaLogic= new TransaccionLogic(connexion);
		transaccionfacturaLogic.deepLoad(configuracionpunven.getTransaccionFactura(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setTransaccionNotaVenta(configuracionpunvenDataAccess.getTransaccionNotaVenta(connexion,configuracionpunven));
		TransaccionLogic transaccionnotaventaLogic= new TransaccionLogic(connexion);
		transaccionnotaventaLogic.deepLoad(configuracionpunven.getTransaccionNotaVenta(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setTransaccionNotaCredito(configuracionpunvenDataAccess.getTransaccionNotaCredito(connexion,configuracionpunven));
		TransaccionLogic transaccionnotacreditoLogic= new TransaccionLogic(connexion);
		transaccionnotacreditoLogic.deepLoad(configuracionpunven.getTransaccionNotaCredito(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setTransaccionCuentaFactura(configuracionpunvenDataAccess.getTransaccionCuentaFactura(connexion,configuracionpunven));
		TransaccionLogic transaccioncuentafacturaLogic= new TransaccionLogic(connexion);
		transaccioncuentafacturaLogic.deepLoad(configuracionpunven.getTransaccionCuentaFactura(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setTransaccionCuentaNotaVenta(configuracionpunvenDataAccess.getTransaccionCuentaNotaVenta(connexion,configuracionpunven));
		TransaccionLogic transaccioncuentanotaventaLogic= new TransaccionLogic(connexion);
		transaccioncuentanotaventaLogic.deepLoad(configuracionpunven.getTransaccionCuentaNotaVenta(),isDeep,deepLoadType,clases);
				
		configuracionpunven.setTransaccionCuentaNotaCredito(configuracionpunvenDataAccess.getTransaccionCuentaNotaCredito(connexion,configuracionpunven));
		TransaccionLogic transaccioncuentanotacreditoLogic= new TransaccionLogic(connexion);
		transaccioncuentanotacreditoLogic.deepLoad(configuracionpunven.getTransaccionCuentaNotaCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				configuracionpunven.setEmpresa(configuracionpunvenDataAccess.getEmpresa(connexion,configuracionpunven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(configuracionpunven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				configuracionpunven.setSucursal(configuracionpunvenDataAccess.getSucursal(connexion,configuracionpunven));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(configuracionpunven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				configuracionpunven.setBodega(configuracionpunvenDataAccess.getBodega(connexion,configuracionpunven));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(configuracionpunven.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				configuracionpunven.setCuentaContableEfectivo(configuracionpunvenDataAccess.getCuentaContableEfectivo(connexion,configuracionpunven));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(configuracionpunven.getCuentaContableEfectivo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				configuracionpunven.setCuentaContableIce(configuracionpunvenDataAccess.getCuentaContableIce(connexion,configuracionpunven));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(configuracionpunven.getCuentaContableIce(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				configuracionpunven.setCuentaContableOtros(configuracionpunvenDataAccess.getCuentaContableOtros(connexion,configuracionpunven));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(configuracionpunven.getCuentaContableOtros(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				configuracionpunven.setClienteConsumidorFinal(configuracionpunvenDataAccess.getClienteConsumidorFinal(connexion,configuracionpunven));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(configuracionpunven.getClienteConsumidorFinal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				configuracionpunven.setTipoDocumentoFactura(configuracionpunvenDataAccess.getTipoDocumentoFactura(connexion,configuracionpunven));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(configuracionpunven.getTipoDocumentoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				configuracionpunven.setTipoDocumentoNotaVenta(configuracionpunvenDataAccess.getTipoDocumentoNotaVenta(connexion,configuracionpunven));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(configuracionpunven.getTipoDocumentoNotaVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				configuracionpunven.setTipoDocumentoNotaCredito(configuracionpunvenDataAccess.getTipoDocumentoNotaCredito(connexion,configuracionpunven));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(configuracionpunven.getTipoDocumentoNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				configuracionpunven.setTipoDocumentoTarjetaCredito(configuracionpunvenDataAccess.getTipoDocumentoTarjetaCredito(connexion,configuracionpunven));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(configuracionpunven.getTipoDocumentoTarjetaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				configuracionpunven.setFormatoFactura(configuracionpunvenDataAccess.getFormatoFactura(connexion,configuracionpunven));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(configuracionpunven.getFormatoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				configuracionpunven.setFormatoNotaVenta(configuracionpunvenDataAccess.getFormatoNotaVenta(connexion,configuracionpunven));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(configuracionpunven.getFormatoNotaVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				configuracionpunven.setFormatoNotaCredito(configuracionpunvenDataAccess.getFormatoNotaCredito(connexion,configuracionpunven));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(configuracionpunven.getFormatoNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				configuracionpunven.setTransaccionFactura(configuracionpunvenDataAccess.getTransaccionFactura(connexion,configuracionpunven));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(configuracionpunven.getTransaccionFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				configuracionpunven.setTransaccionNotaVenta(configuracionpunvenDataAccess.getTransaccionNotaVenta(connexion,configuracionpunven));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(configuracionpunven.getTransaccionNotaVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				configuracionpunven.setTransaccionNotaCredito(configuracionpunvenDataAccess.getTransaccionNotaCredito(connexion,configuracionpunven));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(configuracionpunven.getTransaccionNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				configuracionpunven.setTransaccionCuentaFactura(configuracionpunvenDataAccess.getTransaccionCuentaFactura(connexion,configuracionpunven));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(configuracionpunven.getTransaccionCuentaFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				configuracionpunven.setTransaccionCuentaNotaVenta(configuracionpunvenDataAccess.getTransaccionCuentaNotaVenta(connexion,configuracionpunven));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(configuracionpunven.getTransaccionCuentaNotaVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				configuracionpunven.setTransaccionCuentaNotaCredito(configuracionpunvenDataAccess.getTransaccionCuentaNotaCredito(connexion,configuracionpunven));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(configuracionpunven.getTransaccionCuentaNotaCredito(),isDeep,deepLoadType,clases);				
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
			configuracionpunven.setEmpresa(configuracionpunvenDataAccess.getEmpresa(connexion,configuracionpunven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(configuracionpunven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setSucursal(configuracionpunvenDataAccess.getSucursal(connexion,configuracionpunven));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(configuracionpunven.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setBodega(configuracionpunvenDataAccess.getBodega(connexion,configuracionpunven));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(configuracionpunven.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setCuentaContableEfectivo(configuracionpunvenDataAccess.getCuentaContableEfectivo(connexion,configuracionpunven));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(configuracionpunven.getCuentaContableEfectivo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setCuentaContableIce(configuracionpunvenDataAccess.getCuentaContableIce(connexion,configuracionpunven));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(configuracionpunven.getCuentaContableIce(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setCuentaContableOtros(configuracionpunvenDataAccess.getCuentaContableOtros(connexion,configuracionpunven));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(configuracionpunven.getCuentaContableOtros(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setClienteConsumidorFinal(configuracionpunvenDataAccess.getClienteConsumidorFinal(connexion,configuracionpunven));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(configuracionpunven.getClienteConsumidorFinal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTipoDocumentoFactura(configuracionpunvenDataAccess.getTipoDocumentoFactura(connexion,configuracionpunven));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(configuracionpunven.getTipoDocumentoFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTipoDocumentoNotaVenta(configuracionpunvenDataAccess.getTipoDocumentoNotaVenta(connexion,configuracionpunven));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(configuracionpunven.getTipoDocumentoNotaVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTipoDocumentoNotaCredito(configuracionpunvenDataAccess.getTipoDocumentoNotaCredito(connexion,configuracionpunven));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(configuracionpunven.getTipoDocumentoNotaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTipoDocumentoTarjetaCredito(configuracionpunvenDataAccess.getTipoDocumentoTarjetaCredito(connexion,configuracionpunven));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(configuracionpunven.getTipoDocumentoTarjetaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setFormatoFactura(configuracionpunvenDataAccess.getFormatoFactura(connexion,configuracionpunven));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(configuracionpunven.getFormatoFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setFormatoNotaVenta(configuracionpunvenDataAccess.getFormatoNotaVenta(connexion,configuracionpunven));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(configuracionpunven.getFormatoNotaVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setFormatoNotaCredito(configuracionpunvenDataAccess.getFormatoNotaCredito(connexion,configuracionpunven));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(configuracionpunven.getFormatoNotaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTransaccionFactura(configuracionpunvenDataAccess.getTransaccionFactura(connexion,configuracionpunven));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(configuracionpunven.getTransaccionFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTransaccionNotaVenta(configuracionpunvenDataAccess.getTransaccionNotaVenta(connexion,configuracionpunven));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(configuracionpunven.getTransaccionNotaVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTransaccionNotaCredito(configuracionpunvenDataAccess.getTransaccionNotaCredito(connexion,configuracionpunven));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(configuracionpunven.getTransaccionNotaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTransaccionCuentaFactura(configuracionpunvenDataAccess.getTransaccionCuentaFactura(connexion,configuracionpunven));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(configuracionpunven.getTransaccionCuentaFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTransaccionCuentaNotaVenta(configuracionpunvenDataAccess.getTransaccionCuentaNotaVenta(connexion,configuracionpunven));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(configuracionpunven.getTransaccionCuentaNotaVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			configuracionpunven.setTransaccionCuentaNotaCredito(configuracionpunvenDataAccess.getTransaccionCuentaNotaCredito(connexion,configuracionpunven));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(configuracionpunven.getTransaccionCuentaNotaCredito(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ConfiguracionPunVen configuracionpunven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ConfiguracionPunVenLogicAdditional.updateConfiguracionPunVenToSave(configuracionpunven,this.arrDatoGeneral);
			
ConfiguracionPunVenDataAccess.save(configuracionpunven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(configuracionpunven.getEmpresa(),connexion);

		SucursalDataAccess.save(configuracionpunven.getSucursal(),connexion);

		BodegaDataAccess.save(configuracionpunven.getBodega(),connexion);

		CuentaContableDataAccess.save(configuracionpunven.getCuentaContableEfectivo(),connexion);

		CuentaContableDataAccess.save(configuracionpunven.getCuentaContableIce(),connexion);

		CuentaContableDataAccess.save(configuracionpunven.getCuentaContableOtros(),connexion);

		ClienteDataAccess.save(configuracionpunven.getClienteConsumidorFinal(),connexion);

		TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoFactura(),connexion);

		TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoNotaVenta(),connexion);

		TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoNotaCredito(),connexion);

		TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoTarjetaCredito(),connexion);

		FormatoDataAccess.save(configuracionpunven.getFormatoFactura(),connexion);

		FormatoDataAccess.save(configuracionpunven.getFormatoNotaVenta(),connexion);

		FormatoDataAccess.save(configuracionpunven.getFormatoNotaCredito(),connexion);

		TransaccionDataAccess.save(configuracionpunven.getTransaccionFactura(),connexion);

		TransaccionDataAccess.save(configuracionpunven.getTransaccionNotaVenta(),connexion);

		TransaccionDataAccess.save(configuracionpunven.getTransaccionNotaCredito(),connexion);

		TransaccionDataAccess.save(configuracionpunven.getTransaccionCuentaFactura(),connexion);

		TransaccionDataAccess.save(configuracionpunven.getTransaccionCuentaNotaVenta(),connexion);

		TransaccionDataAccess.save(configuracionpunven.getTransaccionCuentaNotaCredito(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(configuracionpunven.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(configuracionpunven.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(configuracionpunven.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(configuracionpunven.getCuentaContableEfectivo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(configuracionpunven.getCuentaContableIce(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(configuracionpunven.getCuentaContableOtros(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(configuracionpunven.getClienteConsumidorFinal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoNotaVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoNotaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoTarjetaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(configuracionpunven.getFormatoFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(configuracionpunven.getFormatoNotaVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(configuracionpunven.getFormatoNotaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(configuracionpunven.getTransaccionFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(configuracionpunven.getTransaccionNotaVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(configuracionpunven.getTransaccionNotaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(configuracionpunven.getTransaccionCuentaFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(configuracionpunven.getTransaccionCuentaNotaVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(configuracionpunven.getTransaccionCuentaNotaCredito(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(configuracionpunven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(configuracionpunven.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(configuracionpunven.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(configuracionpunven.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(configuracionpunven.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(configuracionpunven.getBodega(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(configuracionpunven.getCuentaContableEfectivo(),connexion);
		CuentaContableLogic cuentacontableefectivoLogic= new CuentaContableLogic(connexion);
		cuentacontableefectivoLogic.deepLoad(configuracionpunven.getCuentaContableEfectivo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(configuracionpunven.getCuentaContableIce(),connexion);
		CuentaContableLogic cuentacontableiceLogic= new CuentaContableLogic(connexion);
		cuentacontableiceLogic.deepLoad(configuracionpunven.getCuentaContableIce(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(configuracionpunven.getCuentaContableOtros(),connexion);
		CuentaContableLogic cuentacontableotrosLogic= new CuentaContableLogic(connexion);
		cuentacontableotrosLogic.deepLoad(configuracionpunven.getCuentaContableOtros(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(configuracionpunven.getClienteConsumidorFinal(),connexion);
		ClienteLogic clienteconsumidorfinalLogic= new ClienteLogic(connexion);
		clienteconsumidorfinalLogic.deepLoad(configuracionpunven.getClienteConsumidorFinal(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoFactura(),connexion);
		TipoDocumentoLogic tipodocumentofacturaLogic= new TipoDocumentoLogic(connexion);
		tipodocumentofacturaLogic.deepLoad(configuracionpunven.getTipoDocumentoFactura(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoNotaVenta(),connexion);
		TipoDocumentoLogic tipodocumentonotaventaLogic= new TipoDocumentoLogic(connexion);
		tipodocumentonotaventaLogic.deepLoad(configuracionpunven.getTipoDocumentoNotaVenta(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoNotaCredito(),connexion);
		TipoDocumentoLogic tipodocumentonotacreditoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentonotacreditoLogic.deepLoad(configuracionpunven.getTipoDocumentoNotaCredito(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoTarjetaCredito(),connexion);
		TipoDocumentoLogic tipodocumentotarjetacreditoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentotarjetacreditoLogic.deepLoad(configuracionpunven.getTipoDocumentoTarjetaCredito(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(configuracionpunven.getFormatoFactura(),connexion);
		FormatoLogic formatofacturaLogic= new FormatoLogic(connexion);
		formatofacturaLogic.deepLoad(configuracionpunven.getFormatoFactura(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(configuracionpunven.getFormatoNotaVenta(),connexion);
		FormatoLogic formatonotaventaLogic= new FormatoLogic(connexion);
		formatonotaventaLogic.deepLoad(configuracionpunven.getFormatoNotaVenta(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(configuracionpunven.getFormatoNotaCredito(),connexion);
		FormatoLogic formatonotacreditoLogic= new FormatoLogic(connexion);
		formatonotacreditoLogic.deepLoad(configuracionpunven.getFormatoNotaCredito(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(configuracionpunven.getTransaccionFactura(),connexion);
		TransaccionLogic transaccionfacturaLogic= new TransaccionLogic(connexion);
		transaccionfacturaLogic.deepLoad(configuracionpunven.getTransaccionFactura(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(configuracionpunven.getTransaccionNotaVenta(),connexion);
		TransaccionLogic transaccionnotaventaLogic= new TransaccionLogic(connexion);
		transaccionnotaventaLogic.deepLoad(configuracionpunven.getTransaccionNotaVenta(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(configuracionpunven.getTransaccionNotaCredito(),connexion);
		TransaccionLogic transaccionnotacreditoLogic= new TransaccionLogic(connexion);
		transaccionnotacreditoLogic.deepLoad(configuracionpunven.getTransaccionNotaCredito(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(configuracionpunven.getTransaccionCuentaFactura(),connexion);
		TransaccionLogic transaccioncuentafacturaLogic= new TransaccionLogic(connexion);
		transaccioncuentafacturaLogic.deepLoad(configuracionpunven.getTransaccionCuentaFactura(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(configuracionpunven.getTransaccionCuentaNotaVenta(),connexion);
		TransaccionLogic transaccioncuentanotaventaLogic= new TransaccionLogic(connexion);
		transaccioncuentanotaventaLogic.deepLoad(configuracionpunven.getTransaccionCuentaNotaVenta(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(configuracionpunven.getTransaccionCuentaNotaCredito(),connexion);
		TransaccionLogic transaccioncuentanotacreditoLogic= new TransaccionLogic(connexion);
		transaccioncuentanotacreditoLogic.deepLoad(configuracionpunven.getTransaccionCuentaNotaCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(configuracionpunven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(configuracionpunven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(configuracionpunven.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(configuracionpunven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(configuracionpunven.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(configuracionpunven.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(configuracionpunven.getCuentaContableEfectivo(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(configuracionpunven.getCuentaContableEfectivo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(configuracionpunven.getCuentaContableIce(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(configuracionpunven.getCuentaContableIce(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(configuracionpunven.getCuentaContableOtros(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(configuracionpunven.getCuentaContableOtros(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(configuracionpunven.getClienteConsumidorFinal(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(configuracionpunven.getClienteConsumidorFinal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoFactura(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(configuracionpunven.getTipoDocumentoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoNotaVenta(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(configuracionpunven.getTipoDocumentoNotaVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoNotaCredito(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(configuracionpunven.getTipoDocumentoNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(configuracionpunven.getTipoDocumentoTarjetaCredito(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(configuracionpunven.getTipoDocumentoTarjetaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(configuracionpunven.getFormatoFactura(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(configuracionpunven.getFormatoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(configuracionpunven.getFormatoNotaVenta(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(configuracionpunven.getFormatoNotaVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(configuracionpunven.getFormatoNotaCredito(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(configuracionpunven.getFormatoNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(configuracionpunven.getTransaccionFactura(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(configuracionpunven.getTransaccionFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(configuracionpunven.getTransaccionNotaVenta(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(configuracionpunven.getTransaccionNotaVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(configuracionpunven.getTransaccionNotaCredito(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(configuracionpunven.getTransaccionNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(configuracionpunven.getTransaccionCuentaFactura(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(configuracionpunven.getTransaccionCuentaFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(configuracionpunven.getTransaccionCuentaNotaVenta(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(configuracionpunven.getTransaccionCuentaNotaVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(configuracionpunven.getTransaccionCuentaNotaCredito(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(configuracionpunven.getTransaccionCuentaNotaCredito(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ConfiguracionPunVen.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(configuracionpunven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(configuracionpunven);
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
			this.deepLoad(this.configuracionpunven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ConfiguracionPunVen.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(configuracionpunvens!=null) {
				for(ConfiguracionPunVen configuracionpunven:configuracionpunvens) {
					this.deepLoad(configuracionpunven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(configuracionpunvens);
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
			if(configuracionpunvens!=null) {
				for(ConfiguracionPunVen configuracionpunven:configuracionpunvens) {
					this.deepLoad(configuracionpunven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(configuracionpunvens);
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
			this.getNewConnexionToDeep(ConfiguracionPunVen.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(configuracionpunven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ConfiguracionPunVen.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(configuracionpunvens!=null) {
				for(ConfiguracionPunVen configuracionpunven:configuracionpunvens) {
					this.deepSave(configuracionpunven,isDeep,deepLoadType,clases);
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
			if(configuracionpunvens!=null) {
				for(ConfiguracionPunVen configuracionpunven:configuracionpunvens) {
					this.deepSave(configuracionpunven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getConfiguracionPunVensFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ConfiguracionPunVenConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ConfiguracionPunVenConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdClienteConsumidorFinalWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente_consumidor_final)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteConsumidorFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteConsumidorFinal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_consumidor_final,ConfiguracionPunVenConstantesFunciones.IDCLIENTECONSUMIDORFINAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteConsumidorFinal);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteConsumidorFinal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdClienteConsumidorFinal(String sFinalQuery,Pagination pagination,Long id_cliente_consumidor_final)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteConsumidorFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteConsumidorFinal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_consumidor_final,ConfiguracionPunVenConstantesFunciones.IDCLIENTECONSUMIDORFINAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteConsumidorFinal);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteConsumidorFinal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdCuentaContableEfectivoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_efectivo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableEfectivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableEfectivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_efectivo,ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEEFECTIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableEfectivo);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableEfectivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdCuentaContableEfectivo(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_efectivo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableEfectivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableEfectivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_efectivo,ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEEFECTIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableEfectivo);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableEfectivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdCuentaContableIceWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ice)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIce= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIce.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ice,ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEICE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIce);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIce","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdCuentaContableIce(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ice)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIce= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIce.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ice,ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEICE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIce);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIce","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdCuentaContableOtrosWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_otros)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableOtros= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableOtros.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_otros,ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEOTROS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableOtros);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableOtros","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdCuentaContableOtros(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_otros)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableOtros= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableOtros.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_otros,ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEOTROS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableOtros);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableOtros","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConfiguracionPunVenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConfiguracionPunVenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdFormatoFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_factura,ConfiguracionPunVenConstantesFunciones.IDFORMATOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoFactura);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdFormatoFactura(String sFinalQuery,Pagination pagination,Long id_formato_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_factura,ConfiguracionPunVenConstantesFunciones.IDFORMATOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoFactura);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdFormatoNotaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nota_credito,ConfiguracionPunVenConstantesFunciones.IDFORMATONOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNotaCredito);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdFormatoNotaCredito(String sFinalQuery,Pagination pagination,Long id_formato_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nota_credito,ConfiguracionPunVenConstantesFunciones.IDFORMATONOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNotaCredito);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdFormatoNotaVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_nota_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNotaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNotaVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nota_venta,ConfiguracionPunVenConstantesFunciones.IDFORMATONOTAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNotaVenta);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNotaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdFormatoNotaVenta(String sFinalQuery,Pagination pagination,Long id_formato_nota_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNotaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNotaVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nota_venta,ConfiguracionPunVenConstantesFunciones.IDFORMATONOTAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNotaVenta);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNotaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ConfiguracionPunVenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ConfiguracionPunVenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdTipoDocumentoFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_factura,ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoFactura);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdTipoDocumentoFactura(String sFinalQuery,Pagination pagination,Long id_tipo_documento_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_factura,ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoFactura);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdTipoDocumentoNotaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_nota_credito,ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoNotaCredito);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdTipoDocumentoNotaCredito(String sFinalQuery,Pagination pagination,Long id_tipo_documento_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_nota_credito,ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoNotaCredito);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdTipoDocumentoNotaVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento_nota_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoNotaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoNotaVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_nota_venta,ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoNotaVenta);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoNotaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdTipoDocumentoNotaVenta(String sFinalQuery,Pagination pagination,Long id_tipo_documento_nota_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoNotaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoNotaVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_nota_venta,ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoNotaVenta);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoNotaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdTipoDocumentoTarjetaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento_tarjeta_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoTarjetaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoTarjetaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_tarjeta_credito,ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOTARJETACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoTarjetaCredito);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoTarjetaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdTipoDocumentoTarjetaCredito(String sFinalQuery,Pagination pagination,Long id_tipo_documento_tarjeta_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoTarjetaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoTarjetaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_tarjeta_credito,ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOTARJETACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoTarjetaCredito);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoTarjetaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdTransaccionCuentaFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_factura,ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTAFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaFactura);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdTransaccionCuentaFactura(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_factura,ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTAFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaFactura);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdTransaccionCuentaNotaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_nota_credito,ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaNotaCredito);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdTransaccionCuentaNotaCredito(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_nota_credito,ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaNotaCredito);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdTransaccionCuentaNotaVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_nota_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaNotaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaNotaVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_nota_venta,ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaNotaVenta);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaNotaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdTransaccionCuentaNotaVenta(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_nota_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaNotaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaNotaVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_nota_venta,ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaNotaVenta);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaNotaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdTransaccionFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_factura,ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionFactura);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdTransaccionFactura(String sFinalQuery,Pagination pagination,Long id_transaccion_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_factura,ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionFactura);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdTransaccionNotaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_nota_credito,ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionNotaCredito);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdTransaccionNotaCredito(String sFinalQuery,Pagination pagination,Long id_transaccion_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_nota_credito,ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionNotaCredito);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConfiguracionPunVensFK_IdTransaccionNotaVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_nota_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConfiguracionPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionNotaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionNotaVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_nota_venta,ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionNotaVenta);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionNotaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConfiguracionPunVensFK_IdTransaccionNotaVenta(String sFinalQuery,Pagination pagination,Long id_transaccion_nota_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionNotaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionNotaVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_nota_venta,ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionNotaVenta);

			ConfiguracionPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionNotaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			configuracionpunvens=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConfiguracionPunVenConstantesFunciones.refrescarForeignKeysDescripcionesConfiguracionPunVen(this.configuracionpunvens);
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
			if(ConfiguracionPunVenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ConfiguracionPunVenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ConfiguracionPunVen configuracionpunven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ConfiguracionPunVenConstantesFunciones.ISCONAUDITORIA) {
				if(configuracionpunven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConfiguracionPunVenDataAccess.TABLENAME, configuracionpunven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConfiguracionPunVenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConfiguracionPunVenLogic.registrarAuditoriaDetallesConfiguracionPunVen(connexion,configuracionpunven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(configuracionpunven.getIsDeleted()) {
					/*if(!configuracionpunven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ConfiguracionPunVenDataAccess.TABLENAME, configuracionpunven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ConfiguracionPunVenLogic.registrarAuditoriaDetallesConfiguracionPunVen(connexion,configuracionpunven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConfiguracionPunVenDataAccess.TABLENAME, configuracionpunven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(configuracionpunven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConfiguracionPunVenDataAccess.TABLENAME, configuracionpunven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConfiguracionPunVenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConfiguracionPunVenLogic.registrarAuditoriaDetallesConfiguracionPunVen(connexion,configuracionpunven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesConfiguracionPunVen(Connexion connexion,ConfiguracionPunVen configuracionpunven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_empresa().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_empresa()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_empresa().toString();
				}
				if(configuracionpunven.getid_empresa()!=null)
				{
					strValorNuevo=configuracionpunven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_sucursal().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_sucursal()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_sucursal().toString();
				}
				if(configuracionpunven.getid_sucursal()!=null)
				{
					strValorNuevo=configuracionpunven.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_bodega().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_bodega()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_bodega().toString();
				}
				if(configuracionpunven.getid_bodega()!=null)
				{
					strValorNuevo=configuracionpunven.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_cuenta_contable_efectivo().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_cuenta_contable_efectivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_cuenta_contable_efectivo()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_cuenta_contable_efectivo().toString();
				}
				if(configuracionpunven.getid_cuenta_contable_efectivo()!=null)
				{
					strValorNuevo=configuracionpunven.getid_cuenta_contable_efectivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEEFECTIVO,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_cuenta_contable_ice().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_cuenta_contable_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_cuenta_contable_ice()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_cuenta_contable_ice().toString();
				}
				if(configuracionpunven.getid_cuenta_contable_ice()!=null)
				{
					strValorNuevo=configuracionpunven.getid_cuenta_contable_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEICE,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_cuenta_contable_otros().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_cuenta_contable_otros()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_cuenta_contable_otros()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_cuenta_contable_otros().toString();
				}
				if(configuracionpunven.getid_cuenta_contable_otros()!=null)
				{
					strValorNuevo=configuracionpunven.getid_cuenta_contable_otros().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEOTROS,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_cliente_consumidor_final().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_cliente_consumidor_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_cliente_consumidor_final()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_cliente_consumidor_final().toString();
				}
				if(configuracionpunven.getid_cliente_consumidor_final()!=null)
				{
					strValorNuevo=configuracionpunven.getid_cliente_consumidor_final().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDCLIENTECONSUMIDORFINAL,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_tipo_documento_factura().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_tipo_documento_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_tipo_documento_factura()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_tipo_documento_factura().toString();
				}
				if(configuracionpunven.getid_tipo_documento_factura()!=null)
				{
					strValorNuevo=configuracionpunven.getid_tipo_documento_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_tipo_documento_nota_venta().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_tipo_documento_nota_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_tipo_documento_nota_venta()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_tipo_documento_nota_venta().toString();
				}
				if(configuracionpunven.getid_tipo_documento_nota_venta()!=null)
				{
					strValorNuevo=configuracionpunven.getid_tipo_documento_nota_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_tipo_documento_nota_credito().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_tipo_documento_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_tipo_documento_nota_credito()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_tipo_documento_nota_credito().toString();
				}
				if(configuracionpunven.getid_tipo_documento_nota_credito()!=null)
				{
					strValorNuevo=configuracionpunven.getid_tipo_documento_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_tipo_documento_tarjeta_credito().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_tipo_documento_tarjeta_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_tipo_documento_tarjeta_credito()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_tipo_documento_tarjeta_credito().toString();
				}
				if(configuracionpunven.getid_tipo_documento_tarjeta_credito()!=null)
				{
					strValorNuevo=configuracionpunven.getid_tipo_documento_tarjeta_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOTARJETACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_formato_factura().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_formato_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_formato_factura()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_formato_factura().toString();
				}
				if(configuracionpunven.getid_formato_factura()!=null)
				{
					strValorNuevo=configuracionpunven.getid_formato_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDFORMATOFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_formato_nota_venta().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_formato_nota_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_formato_nota_venta()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_formato_nota_venta().toString();
				}
				if(configuracionpunven.getid_formato_nota_venta()!=null)
				{
					strValorNuevo=configuracionpunven.getid_formato_nota_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDFORMATONOTAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_formato_nota_credito().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_formato_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_formato_nota_credito()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_formato_nota_credito().toString();
				}
				if(configuracionpunven.getid_formato_nota_credito()!=null)
				{
					strValorNuevo=configuracionpunven.getid_formato_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDFORMATONOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_transaccion_factura().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_factura()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_factura().toString();
				}
				if(configuracionpunven.getid_transaccion_factura()!=null)
				{
					strValorNuevo=configuracionpunven.getid_transaccion_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_transaccion_nota_venta().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_nota_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_nota_venta()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_nota_venta().toString();
				}
				if(configuracionpunven.getid_transaccion_nota_venta()!=null)
				{
					strValorNuevo=configuracionpunven.getid_transaccion_nota_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_transaccion_nota_credito().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_nota_credito()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_nota_credito().toString();
				}
				if(configuracionpunven.getid_transaccion_nota_credito()!=null)
				{
					strValorNuevo=configuracionpunven.getid_transaccion_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_transaccion_cuenta_factura().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_cuenta_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_cuenta_factura()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_cuenta_factura().toString();
				}
				if(configuracionpunven.getid_transaccion_cuenta_factura()!=null)
				{
					strValorNuevo=configuracionpunven.getid_transaccion_cuenta_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTAFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_transaccion_cuenta_nota_venta().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_cuenta_nota_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_cuenta_nota_venta()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_cuenta_nota_venta().toString();
				}
				if(configuracionpunven.getid_transaccion_cuenta_nota_venta()!=null)
				{
					strValorNuevo=configuracionpunven.getid_transaccion_cuenta_nota_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(configuracionpunven.getIsNew()||!configuracionpunven.getid_transaccion_cuenta_nota_credito().equals(configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_cuenta_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_cuenta_nota_credito()!=null)
				{
					strValorActual=configuracionpunven.getConfiguracionPunVenOriginal().getid_transaccion_cuenta_nota_credito().toString();
				}
				if(configuracionpunven.getid_transaccion_cuenta_nota_credito()!=null)
				{
					strValorNuevo=configuracionpunven.getid_transaccion_cuenta_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTACREDITO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveConfiguracionPunVenRelacionesWithConnection(ConfiguracionPunVen configuracionpunven) throws Exception {

		if(!configuracionpunven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConfiguracionPunVenRelacionesBase(configuracionpunven,true);
		}
	}

	public void saveConfiguracionPunVenRelaciones(ConfiguracionPunVen configuracionpunven)throws Exception {

		if(!configuracionpunven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConfiguracionPunVenRelacionesBase(configuracionpunven,false);
		}
	}

	public void saveConfiguracionPunVenRelacionesBase(ConfiguracionPunVen configuracionpunven,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ConfiguracionPunVen-saveRelacionesWithConnection");}
	

			this.setConfiguracionPunVen(configuracionpunven);

			if(ConfiguracionPunVenLogicAdditional.validarSaveRelaciones(configuracionpunven,this)) {

				ConfiguracionPunVenLogicAdditional.updateRelacionesToSave(configuracionpunven,this);

				if((configuracionpunven.getIsNew()||configuracionpunven.getIsChanged())&&!configuracionpunven.getIsDeleted()) {
					this.saveConfiguracionPunVen();
					this.saveConfiguracionPunVenRelacionesDetalles();

				} else if(configuracionpunven.getIsDeleted()) {
					this.saveConfiguracionPunVenRelacionesDetalles();
					this.saveConfiguracionPunVen();
				}

				ConfiguracionPunVenLogicAdditional.updateRelacionesToSaveAfter(configuracionpunven,this);

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
	
	
	private void saveConfiguracionPunVenRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfConfiguracionPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConfiguracionPunVenConstantesFunciones.getClassesForeignKeysOfConfiguracionPunVen(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConfiguracionPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConfiguracionPunVenConstantesFunciones.getClassesRelationshipsOfConfiguracionPunVen(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

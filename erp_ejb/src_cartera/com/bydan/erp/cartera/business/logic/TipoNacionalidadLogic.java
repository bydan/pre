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
import com.bydan.erp.cartera.util.TipoNacionalidadConstantesFunciones;
import com.bydan.erp.cartera.util.TipoNacionalidadParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoNacionalidadParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoNacionalidad;
import com.bydan.erp.cartera.business.logic.TipoNacionalidadLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoNacionalidadLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoNacionalidadLogic.class);
	
	protected TipoNacionalidadDataAccess tiponacionalidadDataAccess; 	
	protected TipoNacionalidad tiponacionalidad;
	protected List<TipoNacionalidad> tiponacionalidads;
	protected Object tiponacionalidadObject;	
	protected List<Object> tiponacionalidadsObject;
	
	public static ClassValidator<TipoNacionalidad> tiponacionalidadValidator = new ClassValidator<TipoNacionalidad>(TipoNacionalidad.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoNacionalidadLogicAdditional tiponacionalidadLogicAdditional=null;
	
	public TipoNacionalidadLogicAdditional getTipoNacionalidadLogicAdditional() {
		return this.tiponacionalidadLogicAdditional;
	}
	
	public void setTipoNacionalidadLogicAdditional(TipoNacionalidadLogicAdditional tiponacionalidadLogicAdditional) {
		try {
			this.tiponacionalidadLogicAdditional=tiponacionalidadLogicAdditional;
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
	
	
	
	
	public  TipoNacionalidadLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiponacionalidadDataAccess = new TipoNacionalidadDataAccess();
			
			this.tiponacionalidads= new ArrayList<TipoNacionalidad>();
			this.tiponacionalidad= new TipoNacionalidad();
			
			this.tiponacionalidadObject=new Object();
			this.tiponacionalidadsObject=new ArrayList<Object>();
				
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
			
			this.tiponacionalidadDataAccess.setConnexionType(this.connexionType);
			this.tiponacionalidadDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoNacionalidadLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiponacionalidadDataAccess = new TipoNacionalidadDataAccess();
			this.tiponacionalidads= new ArrayList<TipoNacionalidad>();
			this.tiponacionalidad= new TipoNacionalidad();
			this.tiponacionalidadObject=new Object();
			this.tiponacionalidadsObject=new ArrayList<Object>();
			
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
			
			this.tiponacionalidadDataAccess.setConnexionType(this.connexionType);
			this.tiponacionalidadDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoNacionalidad getTipoNacionalidad() throws Exception {	
		TipoNacionalidadLogicAdditional.checkTipoNacionalidadToGet(tiponacionalidad,this.datosCliente,this.arrDatoGeneral);
		TipoNacionalidadLogicAdditional.updateTipoNacionalidadToGet(tiponacionalidad,this.arrDatoGeneral);
		
		return tiponacionalidad;
	}
		
	public void setTipoNacionalidad(TipoNacionalidad newTipoNacionalidad) {
		this.tiponacionalidad = newTipoNacionalidad;
	}
	
	public TipoNacionalidadDataAccess getTipoNacionalidadDataAccess() {
		return tiponacionalidadDataAccess;
	}
	
	public void setTipoNacionalidadDataAccess(TipoNacionalidadDataAccess newtiponacionalidadDataAccess) {
		this.tiponacionalidadDataAccess = newtiponacionalidadDataAccess;
	}
	
	public List<TipoNacionalidad> getTipoNacionalidads() throws Exception {		
		this.quitarTipoNacionalidadsNulos();
		
		TipoNacionalidadLogicAdditional.checkTipoNacionalidadToGets(tiponacionalidads,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoNacionalidad tiponacionalidadLocal: tiponacionalidads ) {
			TipoNacionalidadLogicAdditional.updateTipoNacionalidadToGet(tiponacionalidadLocal,this.arrDatoGeneral);
		}
		
		return tiponacionalidads;
	}
	
	public void setTipoNacionalidads(List<TipoNacionalidad> newTipoNacionalidads) {
		this.tiponacionalidads = newTipoNacionalidads;
	}
	
	public Object getTipoNacionalidadObject() {	
		this.tiponacionalidadObject=this.tiponacionalidadDataAccess.getEntityObject();
		return this.tiponacionalidadObject;
	}
		
	public void setTipoNacionalidadObject(Object newTipoNacionalidadObject) {
		this.tiponacionalidadObject = newTipoNacionalidadObject;
	}
	
	public List<Object> getTipoNacionalidadsObject() {		
		this.tiponacionalidadsObject=this.tiponacionalidadDataAccess.getEntitiesObject();
		return this.tiponacionalidadsObject;
	}
		
	public void setTipoNacionalidadsObject(List<Object> newTipoNacionalidadsObject) {
		this.tiponacionalidadsObject = newTipoNacionalidadsObject;
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
		
		if(this.tiponacionalidadDataAccess!=null) {
			this.tiponacionalidadDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiponacionalidadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiponacionalidadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiponacionalidad = new  TipoNacionalidad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiponacionalidad=tiponacionalidadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponacionalidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidad);
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
		tiponacionalidad = new  TipoNacionalidad();
		  		  
        try {
			
			tiponacionalidad=tiponacionalidadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponacionalidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiponacionalidad = new  TipoNacionalidad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiponacionalidad=tiponacionalidadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponacionalidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidad);
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
		tiponacionalidad = new  TipoNacionalidad();
		  		  
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
		tiponacionalidad = new  TipoNacionalidad();
		  		  
        try {
			
			tiponacionalidad=tiponacionalidadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponacionalidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiponacionalidad = new  TipoNacionalidad();
		  		  
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
		tiponacionalidad = new  TipoNacionalidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiponacionalidadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiponacionalidad = new  TipoNacionalidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiponacionalidadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiponacionalidad = new  TipoNacionalidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiponacionalidadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiponacionalidad = new  TipoNacionalidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiponacionalidadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiponacionalidad = new  TipoNacionalidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiponacionalidadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiponacionalidad = new  TipoNacionalidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiponacionalidadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiponacionalidads = new  ArrayList<TipoNacionalidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponacionalidads=tiponacionalidadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNacionalidad(tiponacionalidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidads);
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
		tiponacionalidads = new  ArrayList<TipoNacionalidad>();
		  		  
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
		tiponacionalidads = new  ArrayList<TipoNacionalidad>();
		  		  
        try {			
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponacionalidads=tiponacionalidadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoNacionalidad(tiponacionalidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiponacionalidads = new  ArrayList<TipoNacionalidad>();
		  		  
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
		tiponacionalidads = new  ArrayList<TipoNacionalidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponacionalidads=tiponacionalidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNacionalidad(tiponacionalidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidads);
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
		tiponacionalidads = new  ArrayList<TipoNacionalidad>();
		  		  
        try {
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponacionalidads=tiponacionalidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNacionalidad(tiponacionalidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidads);
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
		tiponacionalidads = new  ArrayList<TipoNacionalidad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponacionalidads=tiponacionalidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNacionalidad(tiponacionalidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidads);
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
		tiponacionalidads = new  ArrayList<TipoNacionalidad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponacionalidads=tiponacionalidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNacionalidad(tiponacionalidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiponacionalidad = new  TipoNacionalidad();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponacionalidad=tiponacionalidadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNacionalidad(tiponacionalidad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidad);
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
		tiponacionalidad = new  TipoNacionalidad();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponacionalidad=tiponacionalidadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNacionalidad(tiponacionalidad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiponacionalidads = new  ArrayList<TipoNacionalidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponacionalidads=tiponacionalidadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNacionalidad(tiponacionalidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidads);
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
		tiponacionalidads = new  ArrayList<TipoNacionalidad>();
		  		  
        try {
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponacionalidads=tiponacionalidadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNacionalidad(tiponacionalidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoNacionalidadsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiponacionalidads = new  ArrayList<TipoNacionalidad>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-getTodosTipoNacionalidadsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponacionalidads=tiponacionalidadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoNacionalidad(tiponacionalidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidads);
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
	
	public  void  getTodosTipoNacionalidads(String sFinalQuery,Pagination pagination)throws Exception {
		tiponacionalidads = new  ArrayList<TipoNacionalidad>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponacionalidads=tiponacionalidadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoNacionalidad(tiponacionalidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoNacionalidad(TipoNacionalidad tiponacionalidad) throws Exception {
		Boolean estaValidado=false;
		
		if(tiponacionalidad.getIsNew() || tiponacionalidad.getIsChanged()) { 
			this.invalidValues = tiponacionalidadValidator.getInvalidValues(tiponacionalidad);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiponacionalidad);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoNacionalidad(List<TipoNacionalidad> TipoNacionalidads) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoNacionalidad tiponacionalidadLocal:tiponacionalidads) {				
			estaValidadoObjeto=this.validarGuardarTipoNacionalidad(tiponacionalidadLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoNacionalidad(List<TipoNacionalidad> TipoNacionalidads) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoNacionalidad(tiponacionalidads)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoNacionalidad(TipoNacionalidad TipoNacionalidad) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoNacionalidad(tiponacionalidad)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoNacionalidad tiponacionalidad) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiponacionalidad.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoNacionalidadConstantesFunciones.getTipoNacionalidadLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiponacionalidad","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoNacionalidadConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoNacionalidadConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoNacionalidadWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-saveTipoNacionalidadWithConnection");connexion.begin();			
			
			TipoNacionalidadLogicAdditional.checkTipoNacionalidadToSave(this.tiponacionalidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoNacionalidadLogicAdditional.updateTipoNacionalidadToSave(this.tiponacionalidad,this.arrDatoGeneral);
			
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiponacionalidad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoNacionalidad();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoNacionalidad(this.tiponacionalidad)) {
				TipoNacionalidadDataAccess.save(this.tiponacionalidad, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiponacionalidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoNacionalidadLogicAdditional.checkTipoNacionalidadToSaveAfter(this.tiponacionalidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoNacionalidad();
			
			connexion.commit();			
			
			if(this.tiponacionalidad.getIsDeleted()) {
				this.tiponacionalidad=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoNacionalidad()throws Exception {	
		try {	
			
			TipoNacionalidadLogicAdditional.checkTipoNacionalidadToSave(this.tiponacionalidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoNacionalidadLogicAdditional.updateTipoNacionalidadToSave(this.tiponacionalidad,this.arrDatoGeneral);
			
			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiponacionalidad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoNacionalidad(this.tiponacionalidad)) {			
				TipoNacionalidadDataAccess.save(this.tiponacionalidad, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiponacionalidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoNacionalidadLogicAdditional.checkTipoNacionalidadToSaveAfter(this.tiponacionalidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiponacionalidad.getIsDeleted()) {
				this.tiponacionalidad=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoNacionalidadsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-saveTipoNacionalidadsWithConnection");connexion.begin();			
			
			TipoNacionalidadLogicAdditional.checkTipoNacionalidadToSaves(tiponacionalidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoNacionalidads();
			
			Boolean validadoTodosTipoNacionalidad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoNacionalidad tiponacionalidadLocal:tiponacionalidads) {		
				if(tiponacionalidadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoNacionalidadLogicAdditional.updateTipoNacionalidadToSave(tiponacionalidadLocal,this.arrDatoGeneral);
	        	
				TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiponacionalidadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoNacionalidad(tiponacionalidadLocal)) {
					TipoNacionalidadDataAccess.save(tiponacionalidadLocal, connexion);				
				} else {
					validadoTodosTipoNacionalidad=false;
				}
			}
			
			if(!validadoTodosTipoNacionalidad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoNacionalidadLogicAdditional.checkTipoNacionalidadToSavesAfter(tiponacionalidads,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoNacionalidads();
			
			connexion.commit();		
			
			this.quitarTipoNacionalidadsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoNacionalidads()throws Exception {				
		 try {	
			TipoNacionalidadLogicAdditional.checkTipoNacionalidadToSaves(tiponacionalidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoNacionalidad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoNacionalidad tiponacionalidadLocal:tiponacionalidads) {				
				if(tiponacionalidadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoNacionalidadLogicAdditional.updateTipoNacionalidadToSave(tiponacionalidadLocal,this.arrDatoGeneral);
	        	
				TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiponacionalidadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoNacionalidad(tiponacionalidadLocal)) {				
					TipoNacionalidadDataAccess.save(tiponacionalidadLocal, connexion);				
				} else {
					validadoTodosTipoNacionalidad=false;
				}
			}
			
			if(!validadoTodosTipoNacionalidad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoNacionalidadLogicAdditional.checkTipoNacionalidadToSavesAfter(tiponacionalidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoNacionalidadsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoNacionalidadParameterReturnGeneral procesarAccionTipoNacionalidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoNacionalidad> tiponacionalidads,TipoNacionalidadParameterReturnGeneral tiponacionalidadParameterGeneral)throws Exception {
		 try {	
			TipoNacionalidadParameterReturnGeneral tiponacionalidadReturnGeneral=new TipoNacionalidadParameterReturnGeneral();
	
			TipoNacionalidadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiponacionalidads,tiponacionalidadParameterGeneral,tiponacionalidadReturnGeneral);
			
			return tiponacionalidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoNacionalidadParameterReturnGeneral procesarAccionTipoNacionalidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoNacionalidad> tiponacionalidads,TipoNacionalidadParameterReturnGeneral tiponacionalidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-procesarAccionTipoNacionalidadsWithConnection");connexion.begin();			
			
			TipoNacionalidadParameterReturnGeneral tiponacionalidadReturnGeneral=new TipoNacionalidadParameterReturnGeneral();
	
			TipoNacionalidadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiponacionalidads,tiponacionalidadParameterGeneral,tiponacionalidadReturnGeneral);
			
			this.connexion.commit();
			
			return tiponacionalidadReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoNacionalidadParameterReturnGeneral procesarEventosTipoNacionalidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoNacionalidad> tiponacionalidads,TipoNacionalidad tiponacionalidad,TipoNacionalidadParameterReturnGeneral tiponacionalidadParameterGeneral,Boolean isEsNuevoTipoNacionalidad,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoNacionalidadParameterReturnGeneral tiponacionalidadReturnGeneral=new TipoNacionalidadParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiponacionalidadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoNacionalidadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiponacionalidads,tiponacionalidad,tiponacionalidadParameterGeneral,tiponacionalidadReturnGeneral,isEsNuevoTipoNacionalidad,clases);
			
			return tiponacionalidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoNacionalidadParameterReturnGeneral procesarEventosTipoNacionalidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoNacionalidad> tiponacionalidads,TipoNacionalidad tiponacionalidad,TipoNacionalidadParameterReturnGeneral tiponacionalidadParameterGeneral,Boolean isEsNuevoTipoNacionalidad,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-procesarEventosTipoNacionalidadsWithConnection");connexion.begin();			
			
			TipoNacionalidadParameterReturnGeneral tiponacionalidadReturnGeneral=new TipoNacionalidadParameterReturnGeneral();
	
			tiponacionalidadReturnGeneral.setTipoNacionalidad(tiponacionalidad);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiponacionalidadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoNacionalidadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiponacionalidads,tiponacionalidad,tiponacionalidadParameterGeneral,tiponacionalidadReturnGeneral,isEsNuevoTipoNacionalidad,clases);
			
			this.connexion.commit();
			
			return tiponacionalidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoNacionalidadParameterReturnGeneral procesarImportacionTipoNacionalidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoNacionalidadParameterReturnGeneral tiponacionalidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-procesarImportacionTipoNacionalidadsWithConnection");connexion.begin();			
			
			TipoNacionalidadParameterReturnGeneral tiponacionalidadReturnGeneral=new TipoNacionalidadParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiponacionalidads=new ArrayList<TipoNacionalidad>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiponacionalidad=new TipoNacionalidad();
				
				
				if(conColumnasBase) {this.tiponacionalidad.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiponacionalidad.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiponacionalidad.setcodigo(arrColumnas[iColumn++]);
				this.tiponacionalidad.setnombre(arrColumnas[iColumn++]);
				
				this.tiponacionalidads.add(this.tiponacionalidad);
			}
			
			this.saveTipoNacionalidads();
			
			this.connexion.commit();
			
			tiponacionalidadReturnGeneral.setConRetornoEstaProcesado(true);
			tiponacionalidadReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiponacionalidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoNacionalidadsEliminados() throws Exception {				
		
		List<TipoNacionalidad> tiponacionalidadsAux= new ArrayList<TipoNacionalidad>();
		
		for(TipoNacionalidad tiponacionalidad:tiponacionalidads) {
			if(!tiponacionalidad.getIsDeleted()) {
				tiponacionalidadsAux.add(tiponacionalidad);
			}
		}
		
		tiponacionalidads=tiponacionalidadsAux;
	}
	
	public void quitarTipoNacionalidadsNulos() throws Exception {				
		
		List<TipoNacionalidad> tiponacionalidadsAux= new ArrayList<TipoNacionalidad>();
		
		for(TipoNacionalidad tiponacionalidad : this.tiponacionalidads) {
			if(tiponacionalidad==null) {
				tiponacionalidadsAux.add(tiponacionalidad);
			}
		}
		
		//this.tiponacionalidads=tiponacionalidadsAux;
		
		this.tiponacionalidads.removeAll(tiponacionalidadsAux);
	}
	
	public void getSetVersionRowTipoNacionalidadWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiponacionalidad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiponacionalidad.getIsDeleted() || (tiponacionalidad.getIsChanged()&&!tiponacionalidad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiponacionalidadDataAccess.getSetVersionRowTipoNacionalidad(connexion,tiponacionalidad.getId());
				
				if(!tiponacionalidad.getVersionRow().equals(timestamp)) {	
					tiponacionalidad.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiponacionalidad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoNacionalidad()throws Exception {	
		
		if(tiponacionalidad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiponacionalidad.getIsDeleted() || (tiponacionalidad.getIsChanged()&&!tiponacionalidad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiponacionalidadDataAccess.getSetVersionRowTipoNacionalidad(connexion,tiponacionalidad.getId());
			
			try {							
				if(!tiponacionalidad.getVersionRow().equals(timestamp)) {	
					tiponacionalidad.setVersionRow(timestamp);
				}
				
				tiponacionalidad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoNacionalidadsWithConnection()throws Exception {	
		if(tiponacionalidads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoNacionalidad tiponacionalidadAux:tiponacionalidads) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiponacionalidadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiponacionalidadAux.getIsDeleted() || (tiponacionalidadAux.getIsChanged()&&!tiponacionalidadAux.getIsNew())) {
						
						timestamp=tiponacionalidadDataAccess.getSetVersionRowTipoNacionalidad(connexion,tiponacionalidadAux.getId());
						
						if(!tiponacionalidad.getVersionRow().equals(timestamp)) {	
							tiponacionalidadAux.setVersionRow(timestamp);
						}
								
						tiponacionalidadAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoNacionalidads()throws Exception {	
		if(tiponacionalidads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoNacionalidad tiponacionalidadAux:tiponacionalidads) {
					if(tiponacionalidadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiponacionalidadAux.getIsDeleted() || (tiponacionalidadAux.getIsChanged()&&!tiponacionalidadAux.getIsNew())) {
						
						timestamp=tiponacionalidadDataAccess.getSetVersionRowTipoNacionalidad(connexion,tiponacionalidadAux.getId());
						
						if(!tiponacionalidadAux.getVersionRow().equals(timestamp)) {	
							tiponacionalidadAux.setVersionRow(timestamp);
						}
						
													
						tiponacionalidadAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoNacionalidadParameterReturnGeneral cargarCombosLoteForeignKeyTipoNacionalidadWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoNacionalidadParameterReturnGeneral  tiponacionalidadReturnGeneral =new TipoNacionalidadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoNacionalidadWithConnection");connexion.begin();
			
			tiponacionalidadReturnGeneral =new TipoNacionalidadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiponacionalidadReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tiponacionalidadReturnGeneral;
	}
	
	public TipoNacionalidadParameterReturnGeneral cargarCombosLoteForeignKeyTipoNacionalidad(String finalQueryGlobalEmpresa) throws Exception {
		TipoNacionalidadParameterReturnGeneral  tiponacionalidadReturnGeneral =new TipoNacionalidadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tiponacionalidadReturnGeneral =new TipoNacionalidadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiponacionalidadReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tiponacionalidadReturnGeneral;
	}
	
	
	public void deepLoad(TipoNacionalidad tiponacionalidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoNacionalidadLogicAdditional.updateTipoNacionalidadToGet(tiponacionalidad,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiponacionalidad.setEmpresa(tiponacionalidadDataAccess.getEmpresa(connexion,tiponacionalidad));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiponacionalidad.setEmpresa(tiponacionalidadDataAccess.getEmpresa(connexion,tiponacionalidad));
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
			tiponacionalidad.setEmpresa(tiponacionalidadDataAccess.getEmpresa(connexion,tiponacionalidad));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiponacionalidad.setEmpresa(tiponacionalidadDataAccess.getEmpresa(connexion,tiponacionalidad));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiponacionalidad.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiponacionalidad.setEmpresa(tiponacionalidadDataAccess.getEmpresa(connexion,tiponacionalidad));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tiponacionalidad.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tiponacionalidad.setEmpresa(tiponacionalidadDataAccess.getEmpresa(connexion,tiponacionalidad));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tiponacionalidad.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoNacionalidad tiponacionalidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoNacionalidadLogicAdditional.updateTipoNacionalidadToSave(tiponacionalidad,this.arrDatoGeneral);
			
TipoNacionalidadDataAccess.save(tiponacionalidad, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiponacionalidad.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiponacionalidad.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiponacionalidad.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiponacionalidad.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiponacionalidad.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tiponacionalidad.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoNacionalidad.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiponacionalidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(tiponacionalidad);
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
			this.deepLoad(this.tiponacionalidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoNacionalidad.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiponacionalidads!=null) {
				for(TipoNacionalidad tiponacionalidad:tiponacionalidads) {
					this.deepLoad(tiponacionalidad,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(tiponacionalidads);
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
			if(tiponacionalidads!=null) {
				for(TipoNacionalidad tiponacionalidad:tiponacionalidads) {
					this.deepLoad(tiponacionalidad,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(tiponacionalidads);
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
			this.getNewConnexionToDeep(TipoNacionalidad.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiponacionalidad,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoNacionalidad.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiponacionalidads!=null) {
				for(TipoNacionalidad tiponacionalidad:tiponacionalidads) {
					this.deepSave(tiponacionalidad,isDeep,deepLoadType,clases);
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
			if(tiponacionalidads!=null) {
				for(TipoNacionalidad tiponacionalidad:tiponacionalidads) {
					this.deepSave(tiponacionalidad,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoNacionalidadsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNacionalidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoNacionalidadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiponacionalidads=tiponacionalidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoNacionalidadsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoNacionalidadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoNacionalidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiponacionalidads=tiponacionalidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoNacionalidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoNacionalidad(this.tiponacionalidads);
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
			if(TipoNacionalidadConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNacionalidadDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoNacionalidad tiponacionalidad,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoNacionalidadConstantesFunciones.ISCONAUDITORIA) {
				if(tiponacionalidad.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNacionalidadDataAccess.TABLENAME, tiponacionalidad.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoNacionalidadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoNacionalidadLogic.registrarAuditoriaDetallesTipoNacionalidad(connexion,tiponacionalidad,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiponacionalidad.getIsDeleted()) {
					/*if(!tiponacionalidad.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoNacionalidadDataAccess.TABLENAME, tiponacionalidad.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoNacionalidadLogic.registrarAuditoriaDetallesTipoNacionalidad(connexion,tiponacionalidad,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNacionalidadDataAccess.TABLENAME, tiponacionalidad.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiponacionalidad.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNacionalidadDataAccess.TABLENAME, tiponacionalidad.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoNacionalidadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoNacionalidadLogic.registrarAuditoriaDetallesTipoNacionalidad(connexion,tiponacionalidad,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoNacionalidad(Connexion connexion,TipoNacionalidad tiponacionalidad)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiponacionalidad.getIsNew()||!tiponacionalidad.getid_empresa().equals(tiponacionalidad.getTipoNacionalidadOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiponacionalidad.getTipoNacionalidadOriginal().getid_empresa()!=null)
				{
					strValorActual=tiponacionalidad.getTipoNacionalidadOriginal().getid_empresa().toString();
				}
				if(tiponacionalidad.getid_empresa()!=null)
				{
					strValorNuevo=tiponacionalidad.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoNacionalidadConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tiponacionalidad.getIsNew()||!tiponacionalidad.getcodigo().equals(tiponacionalidad.getTipoNacionalidadOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiponacionalidad.getTipoNacionalidadOriginal().getcodigo()!=null)
				{
					strValorActual=tiponacionalidad.getTipoNacionalidadOriginal().getcodigo();
				}
				if(tiponacionalidad.getcodigo()!=null)
				{
					strValorNuevo=tiponacionalidad.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoNacionalidadConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiponacionalidad.getIsNew()||!tiponacionalidad.getnombre().equals(tiponacionalidad.getTipoNacionalidadOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiponacionalidad.getTipoNacionalidadOriginal().getnombre()!=null)
				{
					strValorActual=tiponacionalidad.getTipoNacionalidadOriginal().getnombre();
				}
				if(tiponacionalidad.getnombre()!=null)
				{
					strValorNuevo=tiponacionalidad.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoNacionalidadConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoNacionalidadRelacionesWithConnection(TipoNacionalidad tiponacionalidad) throws Exception {

		if(!tiponacionalidad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoNacionalidadRelacionesBase(tiponacionalidad,true);
		}
	}

	public void saveTipoNacionalidadRelaciones(TipoNacionalidad tiponacionalidad)throws Exception {

		if(!tiponacionalidad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoNacionalidadRelacionesBase(tiponacionalidad,false);
		}
	}

	public void saveTipoNacionalidadRelacionesBase(TipoNacionalidad tiponacionalidad,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoNacionalidad-saveRelacionesWithConnection");}
	

			this.setTipoNacionalidad(tiponacionalidad);

			if(TipoNacionalidadLogicAdditional.validarSaveRelaciones(tiponacionalidad,this)) {

				TipoNacionalidadLogicAdditional.updateRelacionesToSave(tiponacionalidad,this);

				if((tiponacionalidad.getIsNew()||tiponacionalidad.getIsChanged())&&!tiponacionalidad.getIsDeleted()) {
					this.saveTipoNacionalidad();
					this.saveTipoNacionalidadRelacionesDetalles();

				} else if(tiponacionalidad.getIsDeleted()) {
					this.saveTipoNacionalidadRelacionesDetalles();
					this.saveTipoNacionalidad();
				}

				TipoNacionalidadLogicAdditional.updateRelacionesToSaveAfter(tiponacionalidad,this);

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
	
	
	private void saveTipoNacionalidadRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoNacionalidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoNacionalidadConstantesFunciones.getClassesForeignKeysOfTipoNacionalidad(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoNacionalidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoNacionalidadConstantesFunciones.getClassesRelationshipsOfTipoNacionalidad(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

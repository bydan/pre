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
import com.bydan.erp.contabilidad.util.TipoGastoEmpresaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoGastoEmpresaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoGastoEmpresaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoGastoEmpresa;
import com.bydan.erp.contabilidad.business.logic.TipoGastoEmpresaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoGastoEmpresaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoGastoEmpresaLogic.class);
	
	protected TipoGastoEmpresaDataAccess tipogastoempresaDataAccess; 	
	protected TipoGastoEmpresa tipogastoempresa;
	protected List<TipoGastoEmpresa> tipogastoempresas;
	protected Object tipogastoempresaObject;	
	protected List<Object> tipogastoempresasObject;
	
	public static ClassValidator<TipoGastoEmpresa> tipogastoempresaValidator = new ClassValidator<TipoGastoEmpresa>(TipoGastoEmpresa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoGastoEmpresaLogicAdditional tipogastoempresaLogicAdditional=null;
	
	public TipoGastoEmpresaLogicAdditional getTipoGastoEmpresaLogicAdditional() {
		return this.tipogastoempresaLogicAdditional;
	}
	
	public void setTipoGastoEmpresaLogicAdditional(TipoGastoEmpresaLogicAdditional tipogastoempresaLogicAdditional) {
		try {
			this.tipogastoempresaLogicAdditional=tipogastoempresaLogicAdditional;
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
	
	
	
	
	public  TipoGastoEmpresaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipogastoempresaDataAccess = new TipoGastoEmpresaDataAccess();
			
			this.tipogastoempresas= new ArrayList<TipoGastoEmpresa>();
			this.tipogastoempresa= new TipoGastoEmpresa();
			
			this.tipogastoempresaObject=new Object();
			this.tipogastoempresasObject=new ArrayList<Object>();
				
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
			
			this.tipogastoempresaDataAccess.setConnexionType(this.connexionType);
			this.tipogastoempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoGastoEmpresaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipogastoempresaDataAccess = new TipoGastoEmpresaDataAccess();
			this.tipogastoempresas= new ArrayList<TipoGastoEmpresa>();
			this.tipogastoempresa= new TipoGastoEmpresa();
			this.tipogastoempresaObject=new Object();
			this.tipogastoempresasObject=new ArrayList<Object>();
			
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
			
			this.tipogastoempresaDataAccess.setConnexionType(this.connexionType);
			this.tipogastoempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoGastoEmpresa getTipoGastoEmpresa() throws Exception {	
		TipoGastoEmpresaLogicAdditional.checkTipoGastoEmpresaToGet(tipogastoempresa,this.datosCliente,this.arrDatoGeneral);
		TipoGastoEmpresaLogicAdditional.updateTipoGastoEmpresaToGet(tipogastoempresa,this.arrDatoGeneral);
		
		return tipogastoempresa;
	}
		
	public void setTipoGastoEmpresa(TipoGastoEmpresa newTipoGastoEmpresa) {
		this.tipogastoempresa = newTipoGastoEmpresa;
	}
	
	public TipoGastoEmpresaDataAccess getTipoGastoEmpresaDataAccess() {
		return tipogastoempresaDataAccess;
	}
	
	public void setTipoGastoEmpresaDataAccess(TipoGastoEmpresaDataAccess newtipogastoempresaDataAccess) {
		this.tipogastoempresaDataAccess = newtipogastoempresaDataAccess;
	}
	
	public List<TipoGastoEmpresa> getTipoGastoEmpresas() throws Exception {		
		this.quitarTipoGastoEmpresasNulos();
		
		TipoGastoEmpresaLogicAdditional.checkTipoGastoEmpresaToGets(tipogastoempresas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoGastoEmpresa tipogastoempresaLocal: tipogastoempresas ) {
			TipoGastoEmpresaLogicAdditional.updateTipoGastoEmpresaToGet(tipogastoempresaLocal,this.arrDatoGeneral);
		}
		
		return tipogastoempresas;
	}
	
	public void setTipoGastoEmpresas(List<TipoGastoEmpresa> newTipoGastoEmpresas) {
		this.tipogastoempresas = newTipoGastoEmpresas;
	}
	
	public Object getTipoGastoEmpresaObject() {	
		this.tipogastoempresaObject=this.tipogastoempresaDataAccess.getEntityObject();
		return this.tipogastoempresaObject;
	}
		
	public void setTipoGastoEmpresaObject(Object newTipoGastoEmpresaObject) {
		this.tipogastoempresaObject = newTipoGastoEmpresaObject;
	}
	
	public List<Object> getTipoGastoEmpresasObject() {		
		this.tipogastoempresasObject=this.tipogastoempresaDataAccess.getEntitiesObject();
		return this.tipogastoempresasObject;
	}
		
	public void setTipoGastoEmpresasObject(List<Object> newTipoGastoEmpresasObject) {
		this.tipogastoempresasObject = newTipoGastoEmpresasObject;
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
		
		if(this.tipogastoempresaDataAccess!=null) {
			this.tipogastoempresaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipogastoempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipogastoempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipogastoempresa = new  TipoGastoEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogastoempresa=tipogastoempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogastoempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresa);
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
		tipogastoempresa = new  TipoGastoEmpresa();
		  		  
        try {
			
			tipogastoempresa=tipogastoempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogastoempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipogastoempresa = new  TipoGastoEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogastoempresa=tipogastoempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogastoempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresa);
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
		tipogastoempresa = new  TipoGastoEmpresa();
		  		  
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
		tipogastoempresa = new  TipoGastoEmpresa();
		  		  
        try {
			
			tipogastoempresa=tipogastoempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogastoempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipogastoempresa = new  TipoGastoEmpresa();
		  		  
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
		tipogastoempresa = new  TipoGastoEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipogastoempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogastoempresa = new  TipoGastoEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipogastoempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogastoempresa = new  TipoGastoEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipogastoempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogastoempresa = new  TipoGastoEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipogastoempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogastoempresa = new  TipoGastoEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipogastoempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogastoempresa = new  TipoGastoEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipogastoempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogastoempresas = new  ArrayList<TipoGastoEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoEmpresa(tipogastoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
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
		tipogastoempresas = new  ArrayList<TipoGastoEmpresa>();
		  		  
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
		tipogastoempresas = new  ArrayList<TipoGastoEmpresa>();
		  		  
        try {			
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoGastoEmpresa(tipogastoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipogastoempresas = new  ArrayList<TipoGastoEmpresa>();
		  		  
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
		tipogastoempresas = new  ArrayList<TipoGastoEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoEmpresa(tipogastoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
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
		tipogastoempresas = new  ArrayList<TipoGastoEmpresa>();
		  		  
        try {
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoEmpresa(tipogastoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
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
		tipogastoempresas = new  ArrayList<TipoGastoEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGastoEmpresa(tipogastoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
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
		tipogastoempresas = new  ArrayList<TipoGastoEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGastoEmpresa(tipogastoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipogastoempresa = new  TipoGastoEmpresa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoempresa=tipogastoempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGastoEmpresa(tipogastoempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresa);
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
		tipogastoempresa = new  TipoGastoEmpresa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoempresa=tipogastoempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGastoEmpresa(tipogastoempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogastoempresas = new  ArrayList<TipoGastoEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoempresas=tipogastoempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoEmpresa(tipogastoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
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
		tipogastoempresas = new  ArrayList<TipoGastoEmpresa>();
		  		  
        try {
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoempresas=tipogastoempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoEmpresa(tipogastoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoGastoEmpresasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipogastoempresas = new  ArrayList<TipoGastoEmpresa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getTodosTipoGastoEmpresasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGastoEmpresa(tipogastoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
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
	
	public  void  getTodosTipoGastoEmpresas(String sFinalQuery,Pagination pagination)throws Exception {
		tipogastoempresas = new  ArrayList<TipoGastoEmpresa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGastoEmpresa(tipogastoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoGastoEmpresa(TipoGastoEmpresa tipogastoempresa) throws Exception {
		Boolean estaValidado=false;
		
		if(tipogastoempresa.getIsNew() || tipogastoempresa.getIsChanged()) { 
			this.invalidValues = tipogastoempresaValidator.getInvalidValues(tipogastoempresa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipogastoempresa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoGastoEmpresa(List<TipoGastoEmpresa> TipoGastoEmpresas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoGastoEmpresa tipogastoempresaLocal:tipogastoempresas) {				
			estaValidadoObjeto=this.validarGuardarTipoGastoEmpresa(tipogastoempresaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoGastoEmpresa(List<TipoGastoEmpresa> TipoGastoEmpresas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGastoEmpresa(tipogastoempresas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoGastoEmpresa(TipoGastoEmpresa TipoGastoEmpresa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGastoEmpresa(tipogastoempresa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoGastoEmpresa tipogastoempresa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipogastoempresa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoGastoEmpresaConstantesFunciones.getTipoGastoEmpresaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipogastoempresa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoGastoEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoGastoEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoGastoEmpresaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-saveTipoGastoEmpresaWithConnection");connexion.begin();			
			
			TipoGastoEmpresaLogicAdditional.checkTipoGastoEmpresaToSave(this.tipogastoempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoGastoEmpresaLogicAdditional.updateTipoGastoEmpresaToSave(this.tipogastoempresa,this.arrDatoGeneral);
			
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogastoempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoGastoEmpresa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGastoEmpresa(this.tipogastoempresa)) {
				TipoGastoEmpresaDataAccess.save(this.tipogastoempresa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipogastoempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoGastoEmpresaLogicAdditional.checkTipoGastoEmpresaToSaveAfter(this.tipogastoempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGastoEmpresa();
			
			connexion.commit();			
			
			if(this.tipogastoempresa.getIsDeleted()) {
				this.tipogastoempresa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoGastoEmpresa()throws Exception {	
		try {	
			
			TipoGastoEmpresaLogicAdditional.checkTipoGastoEmpresaToSave(this.tipogastoempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoGastoEmpresaLogicAdditional.updateTipoGastoEmpresaToSave(this.tipogastoempresa,this.arrDatoGeneral);
			
			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogastoempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGastoEmpresa(this.tipogastoempresa)) {			
				TipoGastoEmpresaDataAccess.save(this.tipogastoempresa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipogastoempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoGastoEmpresaLogicAdditional.checkTipoGastoEmpresaToSaveAfter(this.tipogastoempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipogastoempresa.getIsDeleted()) {
				this.tipogastoempresa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoGastoEmpresasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-saveTipoGastoEmpresasWithConnection");connexion.begin();			
			
			TipoGastoEmpresaLogicAdditional.checkTipoGastoEmpresaToSaves(tipogastoempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoGastoEmpresas();
			
			Boolean validadoTodosTipoGastoEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGastoEmpresa tipogastoempresaLocal:tipogastoempresas) {		
				if(tipogastoempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoGastoEmpresaLogicAdditional.updateTipoGastoEmpresaToSave(tipogastoempresaLocal,this.arrDatoGeneral);
	        	
				TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogastoempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGastoEmpresa(tipogastoempresaLocal)) {
					TipoGastoEmpresaDataAccess.save(tipogastoempresaLocal, connexion);				
				} else {
					validadoTodosTipoGastoEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoGastoEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoGastoEmpresaLogicAdditional.checkTipoGastoEmpresaToSavesAfter(tipogastoempresas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGastoEmpresas();
			
			connexion.commit();		
			
			this.quitarTipoGastoEmpresasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoGastoEmpresas()throws Exception {				
		 try {	
			TipoGastoEmpresaLogicAdditional.checkTipoGastoEmpresaToSaves(tipogastoempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoGastoEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGastoEmpresa tipogastoempresaLocal:tipogastoempresas) {				
				if(tipogastoempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoGastoEmpresaLogicAdditional.updateTipoGastoEmpresaToSave(tipogastoempresaLocal,this.arrDatoGeneral);
	        	
				TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogastoempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGastoEmpresa(tipogastoempresaLocal)) {				
					TipoGastoEmpresaDataAccess.save(tipogastoempresaLocal, connexion);				
				} else {
					validadoTodosTipoGastoEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoGastoEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoGastoEmpresaLogicAdditional.checkTipoGastoEmpresaToSavesAfter(tipogastoempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoGastoEmpresasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGastoEmpresaParameterReturnGeneral procesarAccionTipoGastoEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGastoEmpresa> tipogastoempresas,TipoGastoEmpresaParameterReturnGeneral tipogastoempresaParameterGeneral)throws Exception {
		 try {	
			TipoGastoEmpresaParameterReturnGeneral tipogastoempresaReturnGeneral=new TipoGastoEmpresaParameterReturnGeneral();
	
			TipoGastoEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipogastoempresas,tipogastoempresaParameterGeneral,tipogastoempresaReturnGeneral);
			
			return tipogastoempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGastoEmpresaParameterReturnGeneral procesarAccionTipoGastoEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGastoEmpresa> tipogastoempresas,TipoGastoEmpresaParameterReturnGeneral tipogastoempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-procesarAccionTipoGastoEmpresasWithConnection");connexion.begin();			
			
			TipoGastoEmpresaParameterReturnGeneral tipogastoempresaReturnGeneral=new TipoGastoEmpresaParameterReturnGeneral();
	
			TipoGastoEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipogastoempresas,tipogastoempresaParameterGeneral,tipogastoempresaReturnGeneral);
			
			this.connexion.commit();
			
			return tipogastoempresaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGastoEmpresaParameterReturnGeneral procesarEventosTipoGastoEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGastoEmpresa> tipogastoempresas,TipoGastoEmpresa tipogastoempresa,TipoGastoEmpresaParameterReturnGeneral tipogastoempresaParameterGeneral,Boolean isEsNuevoTipoGastoEmpresa,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoGastoEmpresaParameterReturnGeneral tipogastoempresaReturnGeneral=new TipoGastoEmpresaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogastoempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoGastoEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipogastoempresas,tipogastoempresa,tipogastoempresaParameterGeneral,tipogastoempresaReturnGeneral,isEsNuevoTipoGastoEmpresa,clases);
			
			return tipogastoempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoGastoEmpresaParameterReturnGeneral procesarEventosTipoGastoEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGastoEmpresa> tipogastoempresas,TipoGastoEmpresa tipogastoempresa,TipoGastoEmpresaParameterReturnGeneral tipogastoempresaParameterGeneral,Boolean isEsNuevoTipoGastoEmpresa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-procesarEventosTipoGastoEmpresasWithConnection");connexion.begin();			
			
			TipoGastoEmpresaParameterReturnGeneral tipogastoempresaReturnGeneral=new TipoGastoEmpresaParameterReturnGeneral();
	
			tipogastoempresaReturnGeneral.setTipoGastoEmpresa(tipogastoempresa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogastoempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoGastoEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipogastoempresas,tipogastoempresa,tipogastoempresaParameterGeneral,tipogastoempresaReturnGeneral,isEsNuevoTipoGastoEmpresa,clases);
			
			this.connexion.commit();
			
			return tipogastoempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGastoEmpresaParameterReturnGeneral procesarImportacionTipoGastoEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoGastoEmpresaParameterReturnGeneral tipogastoempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-procesarImportacionTipoGastoEmpresasWithConnection");connexion.begin();			
			
			TipoGastoEmpresaParameterReturnGeneral tipogastoempresaReturnGeneral=new TipoGastoEmpresaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipogastoempresas=new ArrayList<TipoGastoEmpresa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipogastoempresa=new TipoGastoEmpresa();
				
				
				if(conColumnasBase) {this.tipogastoempresa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipogastoempresa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipogastoempresa.setnombre(arrColumnas[iColumn++]);
				this.tipogastoempresa.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipogastoempresas.add(this.tipogastoempresa);
			}
			
			this.saveTipoGastoEmpresas();
			
			this.connexion.commit();
			
			tipogastoempresaReturnGeneral.setConRetornoEstaProcesado(true);
			tipogastoempresaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipogastoempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoGastoEmpresasEliminados() throws Exception {				
		
		List<TipoGastoEmpresa> tipogastoempresasAux= new ArrayList<TipoGastoEmpresa>();
		
		for(TipoGastoEmpresa tipogastoempresa:tipogastoempresas) {
			if(!tipogastoempresa.getIsDeleted()) {
				tipogastoempresasAux.add(tipogastoempresa);
			}
		}
		
		tipogastoempresas=tipogastoempresasAux;
	}
	
	public void quitarTipoGastoEmpresasNulos() throws Exception {				
		
		List<TipoGastoEmpresa> tipogastoempresasAux= new ArrayList<TipoGastoEmpresa>();
		
		for(TipoGastoEmpresa tipogastoempresa : this.tipogastoempresas) {
			if(tipogastoempresa==null) {
				tipogastoempresasAux.add(tipogastoempresa);
			}
		}
		
		//this.tipogastoempresas=tipogastoempresasAux;
		
		this.tipogastoempresas.removeAll(tipogastoempresasAux);
	}
	
	public void getSetVersionRowTipoGastoEmpresaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipogastoempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipogastoempresa.getIsDeleted() || (tipogastoempresa.getIsChanged()&&!tipogastoempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipogastoempresaDataAccess.getSetVersionRowTipoGastoEmpresa(connexion,tipogastoempresa.getId());
				
				if(!tipogastoempresa.getVersionRow().equals(timestamp)) {	
					tipogastoempresa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipogastoempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoGastoEmpresa()throws Exception {	
		
		if(tipogastoempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipogastoempresa.getIsDeleted() || (tipogastoempresa.getIsChanged()&&!tipogastoempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipogastoempresaDataAccess.getSetVersionRowTipoGastoEmpresa(connexion,tipogastoempresa.getId());
			
			try {							
				if(!tipogastoempresa.getVersionRow().equals(timestamp)) {	
					tipogastoempresa.setVersionRow(timestamp);
				}
				
				tipogastoempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoGastoEmpresasWithConnection()throws Exception {	
		if(tipogastoempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoGastoEmpresa tipogastoempresaAux:tipogastoempresas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipogastoempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogastoempresaAux.getIsDeleted() || (tipogastoempresaAux.getIsChanged()&&!tipogastoempresaAux.getIsNew())) {
						
						timestamp=tipogastoempresaDataAccess.getSetVersionRowTipoGastoEmpresa(connexion,tipogastoempresaAux.getId());
						
						if(!tipogastoempresa.getVersionRow().equals(timestamp)) {	
							tipogastoempresaAux.setVersionRow(timestamp);
						}
								
						tipogastoempresaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoGastoEmpresas()throws Exception {	
		if(tipogastoempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoGastoEmpresa tipogastoempresaAux:tipogastoempresas) {
					if(tipogastoempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogastoempresaAux.getIsDeleted() || (tipogastoempresaAux.getIsChanged()&&!tipogastoempresaAux.getIsNew())) {
						
						timestamp=tipogastoempresaDataAccess.getSetVersionRowTipoGastoEmpresa(connexion,tipogastoempresaAux.getId());
						
						if(!tipogastoempresaAux.getVersionRow().equals(timestamp)) {	
							tipogastoempresaAux.setVersionRow(timestamp);
						}
						
													
						tipogastoempresaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoGastoEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoGastoEmpresaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalFormato,String finalQueryGlobalCuentaContableGasto,String finalQueryGlobalCuentaContableFiscalBien,String finalQueryGlobalCuentaContableFiscalServicio,String finalQueryGlobalCuentaContableRetencionBien,String finalQueryGlobalCuentaContableRetencionServicio,String finalQueryGlobalCuentaContableIvaBien,String finalQueryGlobalCuentaContableIvaServicio) throws Exception {
		TipoGastoEmpresaParameterReturnGeneral  tipogastoempresaReturnGeneral =new TipoGastoEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoGastoEmpresaWithConnection");connexion.begin();
			
			tipogastoempresaReturnGeneral =new TipoGastoEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipogastoempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tipogastoempresaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			tipogastoempresaReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<CuentaContable> cuentacontablegastosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablegastoLogic=new CuentaContableLogic();
			cuentacontablegastoLogic.setConnexion(this.connexion);
			cuentacontablegastoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableGasto.equals("NONE")) {
				cuentacontablegastoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableGasto,new Pagination());
				cuentacontablegastosForeignKey=cuentacontablegastoLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontablegastosForeignKey(cuentacontablegastosForeignKey);


			List<CuentaContable> cuentacontablefiscalbiensForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefiscalbienLogic=new CuentaContableLogic();
			cuentacontablefiscalbienLogic.setConnexion(this.connexion);
			cuentacontablefiscalbienLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFiscalBien.equals("NONE")) {
				cuentacontablefiscalbienLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFiscalBien,new Pagination());
				cuentacontablefiscalbiensForeignKey=cuentacontablefiscalbienLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontablefiscalbiensForeignKey(cuentacontablefiscalbiensForeignKey);


			List<CuentaContable> cuentacontablefiscalserviciosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefiscalservicioLogic=new CuentaContableLogic();
			cuentacontablefiscalservicioLogic.setConnexion(this.connexion);
			cuentacontablefiscalservicioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFiscalServicio.equals("NONE")) {
				cuentacontablefiscalservicioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFiscalServicio,new Pagination());
				cuentacontablefiscalserviciosForeignKey=cuentacontablefiscalservicioLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontablefiscalserviciosForeignKey(cuentacontablefiscalserviciosForeignKey);


			List<CuentaContable> cuentacontableretencionbiensForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableretencionbienLogic=new CuentaContableLogic();
			cuentacontableretencionbienLogic.setConnexion(this.connexion);
			cuentacontableretencionbienLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableRetencionBien.equals("NONE")) {
				cuentacontableretencionbienLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableRetencionBien,new Pagination());
				cuentacontableretencionbiensForeignKey=cuentacontableretencionbienLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontableretencionbiensForeignKey(cuentacontableretencionbiensForeignKey);


			List<CuentaContable> cuentacontableretencionserviciosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableretencionservicioLogic=new CuentaContableLogic();
			cuentacontableretencionservicioLogic.setConnexion(this.connexion);
			cuentacontableretencionservicioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableRetencionServicio.equals("NONE")) {
				cuentacontableretencionservicioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableRetencionServicio,new Pagination());
				cuentacontableretencionserviciosForeignKey=cuentacontableretencionservicioLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontableretencionserviciosForeignKey(cuentacontableretencionserviciosForeignKey);


			List<CuentaContable> cuentacontableivabiensForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableivabienLogic=new CuentaContableLogic();
			cuentacontableivabienLogic.setConnexion(this.connexion);
			cuentacontableivabienLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIvaBien.equals("NONE")) {
				cuentacontableivabienLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIvaBien,new Pagination());
				cuentacontableivabiensForeignKey=cuentacontableivabienLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontableivabiensForeignKey(cuentacontableivabiensForeignKey);


			List<CuentaContable> cuentacontableivaserviciosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableivaservicioLogic=new CuentaContableLogic();
			cuentacontableivaservicioLogic.setConnexion(this.connexion);
			cuentacontableivaservicioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIvaServicio.equals("NONE")) {
				cuentacontableivaservicioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIvaServicio,new Pagination());
				cuentacontableivaserviciosForeignKey=cuentacontableivaservicioLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontableivaserviciosForeignKey(cuentacontableivaserviciosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipogastoempresaReturnGeneral;
	}
	
	public TipoGastoEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoGastoEmpresa(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalFormato,String finalQueryGlobalCuentaContableGasto,String finalQueryGlobalCuentaContableFiscalBien,String finalQueryGlobalCuentaContableFiscalServicio,String finalQueryGlobalCuentaContableRetencionBien,String finalQueryGlobalCuentaContableRetencionServicio,String finalQueryGlobalCuentaContableIvaBien,String finalQueryGlobalCuentaContableIvaServicio) throws Exception {
		TipoGastoEmpresaParameterReturnGeneral  tipogastoempresaReturnGeneral =new TipoGastoEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipogastoempresaReturnGeneral =new TipoGastoEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipogastoempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tipogastoempresaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			tipogastoempresaReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<CuentaContable> cuentacontablegastosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablegastoLogic=new CuentaContableLogic();
			cuentacontablegastoLogic.setConnexion(this.connexion);
			cuentacontablegastoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableGasto.equals("NONE")) {
				cuentacontablegastoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableGasto,new Pagination());
				cuentacontablegastosForeignKey=cuentacontablegastoLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontablegastosForeignKey(cuentacontablegastosForeignKey);


			List<CuentaContable> cuentacontablefiscalbiensForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefiscalbienLogic=new CuentaContableLogic();
			cuentacontablefiscalbienLogic.setConnexion(this.connexion);
			cuentacontablefiscalbienLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFiscalBien.equals("NONE")) {
				cuentacontablefiscalbienLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFiscalBien,new Pagination());
				cuentacontablefiscalbiensForeignKey=cuentacontablefiscalbienLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontablefiscalbiensForeignKey(cuentacontablefiscalbiensForeignKey);


			List<CuentaContable> cuentacontablefiscalserviciosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefiscalservicioLogic=new CuentaContableLogic();
			cuentacontablefiscalservicioLogic.setConnexion(this.connexion);
			cuentacontablefiscalservicioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFiscalServicio.equals("NONE")) {
				cuentacontablefiscalservicioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFiscalServicio,new Pagination());
				cuentacontablefiscalserviciosForeignKey=cuentacontablefiscalservicioLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontablefiscalserviciosForeignKey(cuentacontablefiscalserviciosForeignKey);


			List<CuentaContable> cuentacontableretencionbiensForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableretencionbienLogic=new CuentaContableLogic();
			cuentacontableretencionbienLogic.setConnexion(this.connexion);
			cuentacontableretencionbienLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableRetencionBien.equals("NONE")) {
				cuentacontableretencionbienLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableRetencionBien,new Pagination());
				cuentacontableretencionbiensForeignKey=cuentacontableretencionbienLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontableretencionbiensForeignKey(cuentacontableretencionbiensForeignKey);


			List<CuentaContable> cuentacontableretencionserviciosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableretencionservicioLogic=new CuentaContableLogic();
			cuentacontableretencionservicioLogic.setConnexion(this.connexion);
			cuentacontableretencionservicioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableRetencionServicio.equals("NONE")) {
				cuentacontableretencionservicioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableRetencionServicio,new Pagination());
				cuentacontableretencionserviciosForeignKey=cuentacontableretencionservicioLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontableretencionserviciosForeignKey(cuentacontableretencionserviciosForeignKey);


			List<CuentaContable> cuentacontableivabiensForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableivabienLogic=new CuentaContableLogic();
			cuentacontableivabienLogic.setConnexion(this.connexion);
			cuentacontableivabienLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIvaBien.equals("NONE")) {
				cuentacontableivabienLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIvaBien,new Pagination());
				cuentacontableivabiensForeignKey=cuentacontableivabienLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontableivabiensForeignKey(cuentacontableivabiensForeignKey);


			List<CuentaContable> cuentacontableivaserviciosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableivaservicioLogic=new CuentaContableLogic();
			cuentacontableivaservicioLogic.setConnexion(this.connexion);
			cuentacontableivaservicioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIvaServicio.equals("NONE")) {
				cuentacontableivaservicioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIvaServicio,new Pagination());
				cuentacontableivaserviciosForeignKey=cuentacontableivaservicioLogic.getCuentaContables();
			}

			tipogastoempresaReturnGeneral.setcuentacontableivaserviciosForeignKey(cuentacontableivaserviciosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipogastoempresaReturnGeneral;
	}
	
	
	public void deepLoad(TipoGastoEmpresa tipogastoempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoGastoEmpresaLogicAdditional.updateTipoGastoEmpresaToGet(tipogastoempresa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogastoempresa.setEmpresa(tipogastoempresaDataAccess.getEmpresa(connexion,tipogastoempresa));
		tipogastoempresa.setSucursal(tipogastoempresaDataAccess.getSucursal(connexion,tipogastoempresa));
		tipogastoempresa.setFormato(tipogastoempresaDataAccess.getFormato(connexion,tipogastoempresa));
		tipogastoempresa.setCuentaContableGasto(tipogastoempresaDataAccess.getCuentaContableGasto(connexion,tipogastoempresa));
		tipogastoempresa.setCuentaContableFiscalBien(tipogastoempresaDataAccess.getCuentaContableFiscalBien(connexion,tipogastoempresa));
		tipogastoempresa.setCuentaContableFiscalServicio(tipogastoempresaDataAccess.getCuentaContableFiscalServicio(connexion,tipogastoempresa));
		tipogastoempresa.setCuentaContableRetencionBien(tipogastoempresaDataAccess.getCuentaContableRetencionBien(connexion,tipogastoempresa));
		tipogastoempresa.setCuentaContableRetencionServicio(tipogastoempresaDataAccess.getCuentaContableRetencionServicio(connexion,tipogastoempresa));
		tipogastoempresa.setCuentaContableIvaBien(tipogastoempresaDataAccess.getCuentaContableIvaBien(connexion,tipogastoempresa));
		tipogastoempresa.setCuentaContableIvaServicio(tipogastoempresaDataAccess.getCuentaContableIvaServicio(connexion,tipogastoempresa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipogastoempresa.setEmpresa(tipogastoempresaDataAccess.getEmpresa(connexion,tipogastoempresa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tipogastoempresa.setSucursal(tipogastoempresaDataAccess.getSucursal(connexion,tipogastoempresa));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				tipogastoempresa.setFormato(tipogastoempresaDataAccess.getFormato(connexion,tipogastoempresa));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableGasto(tipogastoempresaDataAccess.getCuentaContableGasto(connexion,tipogastoempresa));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableFiscalBien(tipogastoempresaDataAccess.getCuentaContableFiscalBien(connexion,tipogastoempresa));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableFiscalServicio(tipogastoempresaDataAccess.getCuentaContableFiscalServicio(connexion,tipogastoempresa));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableRetencionBien(tipogastoempresaDataAccess.getCuentaContableRetencionBien(connexion,tipogastoempresa));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableRetencionServicio(tipogastoempresaDataAccess.getCuentaContableRetencionServicio(connexion,tipogastoempresa));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableIvaBien(tipogastoempresaDataAccess.getCuentaContableIvaBien(connexion,tipogastoempresa));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableIvaServicio(tipogastoempresaDataAccess.getCuentaContableIvaServicio(connexion,tipogastoempresa));
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
			tipogastoempresa.setEmpresa(tipogastoempresaDataAccess.getEmpresa(connexion,tipogastoempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setSucursal(tipogastoempresaDataAccess.getSucursal(connexion,tipogastoempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setFormato(tipogastoempresaDataAccess.getFormato(connexion,tipogastoempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableGasto(tipogastoempresaDataAccess.getCuentaContableGasto(connexion,tipogastoempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableFiscalBien(tipogastoempresaDataAccess.getCuentaContableFiscalBien(connexion,tipogastoempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableFiscalServicio(tipogastoempresaDataAccess.getCuentaContableFiscalServicio(connexion,tipogastoempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableRetencionBien(tipogastoempresaDataAccess.getCuentaContableRetencionBien(connexion,tipogastoempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableRetencionServicio(tipogastoempresaDataAccess.getCuentaContableRetencionServicio(connexion,tipogastoempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableIvaBien(tipogastoempresaDataAccess.getCuentaContableIvaBien(connexion,tipogastoempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableIvaServicio(tipogastoempresaDataAccess.getCuentaContableIvaServicio(connexion,tipogastoempresa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogastoempresa.setEmpresa(tipogastoempresaDataAccess.getEmpresa(connexion,tipogastoempresa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipogastoempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		tipogastoempresa.setSucursal(tipogastoempresaDataAccess.getSucursal(connexion,tipogastoempresa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tipogastoempresa.getSucursal(),isDeep,deepLoadType,clases);
				
		tipogastoempresa.setFormato(tipogastoempresaDataAccess.getFormato(connexion,tipogastoempresa));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(tipogastoempresa.getFormato(),isDeep,deepLoadType,clases);
				
		tipogastoempresa.setCuentaContableGasto(tipogastoempresaDataAccess.getCuentaContableGasto(connexion,tipogastoempresa));
		CuentaContableLogic cuentacontablegastoLogic= new CuentaContableLogic(connexion);
		cuentacontablegastoLogic.deepLoad(tipogastoempresa.getCuentaContableGasto(),isDeep,deepLoadType,clases);
				
		tipogastoempresa.setCuentaContableFiscalBien(tipogastoempresaDataAccess.getCuentaContableFiscalBien(connexion,tipogastoempresa));
		CuentaContableLogic cuentacontablefiscalbienLogic= new CuentaContableLogic(connexion);
		cuentacontablefiscalbienLogic.deepLoad(tipogastoempresa.getCuentaContableFiscalBien(),isDeep,deepLoadType,clases);
				
		tipogastoempresa.setCuentaContableFiscalServicio(tipogastoempresaDataAccess.getCuentaContableFiscalServicio(connexion,tipogastoempresa));
		CuentaContableLogic cuentacontablefiscalservicioLogic= new CuentaContableLogic(connexion);
		cuentacontablefiscalservicioLogic.deepLoad(tipogastoempresa.getCuentaContableFiscalServicio(),isDeep,deepLoadType,clases);
				
		tipogastoempresa.setCuentaContableRetencionBien(tipogastoempresaDataAccess.getCuentaContableRetencionBien(connexion,tipogastoempresa));
		CuentaContableLogic cuentacontableretencionbienLogic= new CuentaContableLogic(connexion);
		cuentacontableretencionbienLogic.deepLoad(tipogastoempresa.getCuentaContableRetencionBien(),isDeep,deepLoadType,clases);
				
		tipogastoempresa.setCuentaContableRetencionServicio(tipogastoempresaDataAccess.getCuentaContableRetencionServicio(connexion,tipogastoempresa));
		CuentaContableLogic cuentacontableretencionservicioLogic= new CuentaContableLogic(connexion);
		cuentacontableretencionservicioLogic.deepLoad(tipogastoempresa.getCuentaContableRetencionServicio(),isDeep,deepLoadType,clases);
				
		tipogastoempresa.setCuentaContableIvaBien(tipogastoempresaDataAccess.getCuentaContableIvaBien(connexion,tipogastoempresa));
		CuentaContableLogic cuentacontableivabienLogic= new CuentaContableLogic(connexion);
		cuentacontableivabienLogic.deepLoad(tipogastoempresa.getCuentaContableIvaBien(),isDeep,deepLoadType,clases);
				
		tipogastoempresa.setCuentaContableIvaServicio(tipogastoempresaDataAccess.getCuentaContableIvaServicio(connexion,tipogastoempresa));
		CuentaContableLogic cuentacontableivaservicioLogic= new CuentaContableLogic(connexion);
		cuentacontableivaservicioLogic.deepLoad(tipogastoempresa.getCuentaContableIvaServicio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipogastoempresa.setEmpresa(tipogastoempresaDataAccess.getEmpresa(connexion,tipogastoempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipogastoempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tipogastoempresa.setSucursal(tipogastoempresaDataAccess.getSucursal(connexion,tipogastoempresa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(tipogastoempresa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				tipogastoempresa.setFormato(tipogastoempresaDataAccess.getFormato(connexion,tipogastoempresa));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(tipogastoempresa.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableGasto(tipogastoempresaDataAccess.getCuentaContableGasto(connexion,tipogastoempresa));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableGasto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableFiscalBien(tipogastoempresaDataAccess.getCuentaContableFiscalBien(connexion,tipogastoempresa));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableFiscalBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableFiscalServicio(tipogastoempresaDataAccess.getCuentaContableFiscalServicio(connexion,tipogastoempresa));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableFiscalServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableRetencionBien(tipogastoempresaDataAccess.getCuentaContableRetencionBien(connexion,tipogastoempresa));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableRetencionBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableRetencionServicio(tipogastoempresaDataAccess.getCuentaContableRetencionServicio(connexion,tipogastoempresa));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableRetencionServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableIvaBien(tipogastoempresaDataAccess.getCuentaContableIvaBien(connexion,tipogastoempresa));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableIvaBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipogastoempresa.setCuentaContableIvaServicio(tipogastoempresaDataAccess.getCuentaContableIvaServicio(connexion,tipogastoempresa));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableIvaServicio(),isDeep,deepLoadType,clases);				
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
			tipogastoempresa.setEmpresa(tipogastoempresaDataAccess.getEmpresa(connexion,tipogastoempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipogastoempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setSucursal(tipogastoempresaDataAccess.getSucursal(connexion,tipogastoempresa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(tipogastoempresa.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setFormato(tipogastoempresaDataAccess.getFormato(connexion,tipogastoempresa));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(tipogastoempresa.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableGasto(tipogastoempresaDataAccess.getCuentaContableGasto(connexion,tipogastoempresa));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableGasto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableFiscalBien(tipogastoempresaDataAccess.getCuentaContableFiscalBien(connexion,tipogastoempresa));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableFiscalBien(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableFiscalServicio(tipogastoempresaDataAccess.getCuentaContableFiscalServicio(connexion,tipogastoempresa));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableFiscalServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableRetencionBien(tipogastoempresaDataAccess.getCuentaContableRetencionBien(connexion,tipogastoempresa));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableRetencionBien(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableRetencionServicio(tipogastoempresaDataAccess.getCuentaContableRetencionServicio(connexion,tipogastoempresa));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableRetencionServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableIvaBien(tipogastoempresaDataAccess.getCuentaContableIvaBien(connexion,tipogastoempresa));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableIvaBien(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoempresa.setCuentaContableIvaServicio(tipogastoempresaDataAccess.getCuentaContableIvaServicio(connexion,tipogastoempresa));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tipogastoempresa.getCuentaContableIvaServicio(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoGastoEmpresa tipogastoempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoGastoEmpresaLogicAdditional.updateTipoGastoEmpresaToSave(tipogastoempresa,this.arrDatoGeneral);
			
TipoGastoEmpresaDataAccess.save(tipogastoempresa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipogastoempresa.getEmpresa(),connexion);

		SucursalDataAccess.save(tipogastoempresa.getSucursal(),connexion);

		FormatoDataAccess.save(tipogastoempresa.getFormato(),connexion);

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableGasto(),connexion);

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableFiscalBien(),connexion);

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableFiscalServicio(),connexion);

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableRetencionBien(),connexion);

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableRetencionServicio(),connexion);

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableIvaBien(),connexion);

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableIvaServicio(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipogastoempresa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tipogastoempresa.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(tipogastoempresa.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableGasto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableFiscalBien(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableFiscalServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableRetencionBien(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableRetencionServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableIvaBien(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableIvaServicio(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipogastoempresa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipogastoempresa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(tipogastoempresa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tipogastoempresa.getSucursal(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(tipogastoempresa.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(tipogastoempresa.getFormato(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableGasto(),connexion);
		CuentaContableLogic cuentacontablegastoLogic= new CuentaContableLogic(connexion);
		cuentacontablegastoLogic.deepLoad(tipogastoempresa.getCuentaContableGasto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableFiscalBien(),connexion);
		CuentaContableLogic cuentacontablefiscalbienLogic= new CuentaContableLogic(connexion);
		cuentacontablefiscalbienLogic.deepLoad(tipogastoempresa.getCuentaContableFiscalBien(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableFiscalServicio(),connexion);
		CuentaContableLogic cuentacontablefiscalservicioLogic= new CuentaContableLogic(connexion);
		cuentacontablefiscalservicioLogic.deepLoad(tipogastoempresa.getCuentaContableFiscalServicio(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableRetencionBien(),connexion);
		CuentaContableLogic cuentacontableretencionbienLogic= new CuentaContableLogic(connexion);
		cuentacontableretencionbienLogic.deepLoad(tipogastoempresa.getCuentaContableRetencionBien(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableRetencionServicio(),connexion);
		CuentaContableLogic cuentacontableretencionservicioLogic= new CuentaContableLogic(connexion);
		cuentacontableretencionservicioLogic.deepLoad(tipogastoempresa.getCuentaContableRetencionServicio(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableIvaBien(),connexion);
		CuentaContableLogic cuentacontableivabienLogic= new CuentaContableLogic(connexion);
		cuentacontableivabienLogic.deepLoad(tipogastoempresa.getCuentaContableIvaBien(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableIvaServicio(),connexion);
		CuentaContableLogic cuentacontableivaservicioLogic= new CuentaContableLogic(connexion);
		cuentacontableivaservicioLogic.deepLoad(tipogastoempresa.getCuentaContableIvaServicio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipogastoempresa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipogastoempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tipogastoempresa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(tipogastoempresa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(tipogastoempresa.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(tipogastoempresa.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableGasto(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tipogastoempresa.getCuentaContableGasto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableFiscalBien(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tipogastoempresa.getCuentaContableFiscalBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableFiscalServicio(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tipogastoempresa.getCuentaContableFiscalServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableRetencionBien(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tipogastoempresa.getCuentaContableRetencionBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableRetencionServicio(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tipogastoempresa.getCuentaContableRetencionServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableIvaBien(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tipogastoempresa.getCuentaContableIvaBien(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipogastoempresa.getCuentaContableIvaServicio(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tipogastoempresa.getCuentaContableIvaServicio(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoGastoEmpresa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipogastoempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(tipogastoempresa);
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
			this.deepLoad(this.tipogastoempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGastoEmpresa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipogastoempresas!=null) {
				for(TipoGastoEmpresa tipogastoempresa:tipogastoempresas) {
					this.deepLoad(tipogastoempresa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(tipogastoempresas);
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
			if(tipogastoempresas!=null) {
				for(TipoGastoEmpresa tipogastoempresa:tipogastoempresas) {
					this.deepLoad(tipogastoempresa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(tipogastoempresas);
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
			this.getNewConnexionToDeep(TipoGastoEmpresa.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipogastoempresa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoGastoEmpresa.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipogastoempresas!=null) {
				for(TipoGastoEmpresa tipogastoempresa:tipogastoempresas) {
					this.deepSave(tipogastoempresa,isDeep,deepLoadType,clases);
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
			if(tipogastoempresas!=null) {
				for(TipoGastoEmpresa tipogastoempresa:tipogastoempresas) {
					this.deepSave(tipogastoempresa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoGastoEmpresasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoGastoEmpresaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoEmpresasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoGastoEmpresaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableFiscalBienWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_fiscal_bien)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFiscalBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFiscalBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_fiscal_bien,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALBIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFiscalBien);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFiscalBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableFiscalBien(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_fiscal_bien)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFiscalBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFiscalBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_fiscal_bien,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALBIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFiscalBien);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFiscalBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableFiscalServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_fiscal_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFiscalServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFiscalServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_fiscal_servicio,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFiscalServicio);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFiscalServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableFiscalServicio(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_fiscal_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFiscalServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFiscalServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_fiscal_servicio,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFiscalServicio);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFiscalServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableGastoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_gasto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableGasto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableGasto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_gasto,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEGASTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableGasto);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableGasto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableGasto(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_gasto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableGasto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableGasto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_gasto,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEGASTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableGasto);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableGasto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableIvaBienWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_iva_bien)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIvaBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIvaBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_iva_bien,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVABIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIvaBien);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIvaBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableIvaBien(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_iva_bien)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIvaBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIvaBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_iva_bien,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVABIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIvaBien);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIvaBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableIvaServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_iva_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIvaServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIvaServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_iva_servicio,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVASERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIvaServicio);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIvaServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableIvaServicio(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_iva_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIvaServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIvaServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_iva_servicio,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVASERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIvaServicio);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIvaServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableRetencionBienWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_retencion_bien)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableRetencionBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableRetencionBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_retencion_bien,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONBIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableRetencionBien);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableRetencionBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableRetencionBien(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_retencion_bien)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableRetencionBien= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableRetencionBien.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_retencion_bien,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONBIEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableRetencionBien);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableRetencionBien","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableRetencionServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_retencion_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableRetencionServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableRetencionServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_retencion_servicio,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableRetencionServicio);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableRetencionServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoEmpresasFK_IdCuentaContableRetencionServicio(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_retencion_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableRetencionServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableRetencionServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_retencion_servicio,TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableRetencionServicio);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableRetencionServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGastoEmpresasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoGastoEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoEmpresasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoGastoEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGastoEmpresasFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,TipoGastoEmpresaConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoEmpresasFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,TipoGastoEmpresaConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGastoEmpresasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TipoGastoEmpresaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoEmpresasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TipoGastoEmpresaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TipoGastoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoEmpresa(this.tipogastoempresas);
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
			if(TipoGastoEmpresaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGastoEmpresaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoGastoEmpresa tipogastoempresa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoGastoEmpresaConstantesFunciones.ISCONAUDITORIA) {
				if(tipogastoempresa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGastoEmpresaDataAccess.TABLENAME, tipogastoempresa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGastoEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGastoEmpresaLogic.registrarAuditoriaDetallesTipoGastoEmpresa(connexion,tipogastoempresa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipogastoempresa.getIsDeleted()) {
					/*if(!tipogastoempresa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoGastoEmpresaDataAccess.TABLENAME, tipogastoempresa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoGastoEmpresaLogic.registrarAuditoriaDetallesTipoGastoEmpresa(connexion,tipogastoempresa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGastoEmpresaDataAccess.TABLENAME, tipogastoempresa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipogastoempresa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGastoEmpresaDataAccess.TABLENAME, tipogastoempresa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGastoEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGastoEmpresaLogic.registrarAuditoriaDetallesTipoGastoEmpresa(connexion,tipogastoempresa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoGastoEmpresa(Connexion connexion,TipoGastoEmpresa tipogastoempresa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipogastoempresa.getIsNew()||!tipogastoempresa.getid_empresa().equals(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipogastoempresa.getTipoGastoEmpresaOriginal().getid_empresa().toString();
				}
				if(tipogastoempresa.getid_empresa()!=null)
				{
					strValorNuevo=tipogastoempresa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoEmpresaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoempresa.getIsNew()||!tipogastoempresa.getid_sucursal().equals(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_sucursal()!=null)
				{
					strValorActual=tipogastoempresa.getTipoGastoEmpresaOriginal().getid_sucursal().toString();
				}
				if(tipogastoempresa.getid_sucursal()!=null)
				{
					strValorNuevo=tipogastoempresa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoEmpresaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoempresa.getIsNew()||!tipogastoempresa.getnombre().equals(tipogastoempresa.getTipoGastoEmpresaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoempresa.getTipoGastoEmpresaOriginal().getnombre()!=null)
				{
					strValorActual=tipogastoempresa.getTipoGastoEmpresaOriginal().getnombre();
				}
				if(tipogastoempresa.getnombre()!=null)
				{
					strValorNuevo=tipogastoempresa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoEmpresaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoempresa.getIsNew()||!tipogastoempresa.getid_formato().equals(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_formato()!=null)
				{
					strValorActual=tipogastoempresa.getTipoGastoEmpresaOriginal().getid_formato().toString();
				}
				if(tipogastoempresa.getid_formato()!=null)
				{
					strValorNuevo=tipogastoempresa.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoEmpresaConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoempresa.getIsNew()||!tipogastoempresa.getdescripcion().equals(tipogastoempresa.getTipoGastoEmpresaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoempresa.getTipoGastoEmpresaOriginal().getdescripcion()!=null)
				{
					strValorActual=tipogastoempresa.getTipoGastoEmpresaOriginal().getdescripcion();
				}
				if(tipogastoempresa.getdescripcion()!=null)
				{
					strValorNuevo=tipogastoempresa.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoEmpresaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoempresa.getIsNew()||!tipogastoempresa.getid_cuenta_contable_gasto().equals(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_gasto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_gasto()!=null)
				{
					strValorActual=tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_gasto().toString();
				}
				if(tipogastoempresa.getid_cuenta_contable_gasto()!=null)
				{
					strValorNuevo=tipogastoempresa.getid_cuenta_contable_gasto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEGASTO,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoempresa.getIsNew()||!tipogastoempresa.getid_cuenta_contable_fiscal_bien().equals(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_fiscal_bien()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_fiscal_bien()!=null)
				{
					strValorActual=tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_fiscal_bien().toString();
				}
				if(tipogastoempresa.getid_cuenta_contable_fiscal_bien()!=null)
				{
					strValorNuevo=tipogastoempresa.getid_cuenta_contable_fiscal_bien().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALBIEN,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoempresa.getIsNew()||!tipogastoempresa.getid_cuenta_contable_fiscal_servicio().equals(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_fiscal_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_fiscal_servicio()!=null)
				{
					strValorActual=tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_fiscal_servicio().toString();
				}
				if(tipogastoempresa.getid_cuenta_contable_fiscal_servicio()!=null)
				{
					strValorNuevo=tipogastoempresa.getid_cuenta_contable_fiscal_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALSERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoempresa.getIsNew()||!tipogastoempresa.getid_cuenta_contable_retencion_bien().equals(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_retencion_bien()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_retencion_bien()!=null)
				{
					strValorActual=tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_retencion_bien().toString();
				}
				if(tipogastoempresa.getid_cuenta_contable_retencion_bien()!=null)
				{
					strValorNuevo=tipogastoempresa.getid_cuenta_contable_retencion_bien().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONBIEN,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoempresa.getIsNew()||!tipogastoempresa.getid_cuenta_contable_retencion_servicio().equals(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_retencion_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_retencion_servicio()!=null)
				{
					strValorActual=tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_retencion_servicio().toString();
				}
				if(tipogastoempresa.getid_cuenta_contable_retencion_servicio()!=null)
				{
					strValorNuevo=tipogastoempresa.getid_cuenta_contable_retencion_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONSERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoempresa.getIsNew()||!tipogastoempresa.getid_cuenta_contable_iva_bien().equals(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_iva_bien()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_iva_bien()!=null)
				{
					strValorActual=tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_iva_bien().toString();
				}
				if(tipogastoempresa.getid_cuenta_contable_iva_bien()!=null)
				{
					strValorNuevo=tipogastoempresa.getid_cuenta_contable_iva_bien().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVABIEN,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoempresa.getIsNew()||!tipogastoempresa.getid_cuenta_contable_iva_servicio().equals(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_iva_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_iva_servicio()!=null)
				{
					strValorActual=tipogastoempresa.getTipoGastoEmpresaOriginal().getid_cuenta_contable_iva_servicio().toString();
				}
				if(tipogastoempresa.getid_cuenta_contable_iva_servicio()!=null)
				{
					strValorNuevo=tipogastoempresa.getid_cuenta_contable_iva_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVASERVICIO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoGastoEmpresaRelacionesWithConnection(TipoGastoEmpresa tipogastoempresa) throws Exception {

		if(!tipogastoempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoGastoEmpresaRelacionesBase(tipogastoempresa,true);
		}
	}

	public void saveTipoGastoEmpresaRelaciones(TipoGastoEmpresa tipogastoempresa)throws Exception {

		if(!tipogastoempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoGastoEmpresaRelacionesBase(tipogastoempresa,false);
		}
	}

	public void saveTipoGastoEmpresaRelacionesBase(TipoGastoEmpresa tipogastoempresa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoGastoEmpresa-saveRelacionesWithConnection");}
	

			this.setTipoGastoEmpresa(tipogastoempresa);

			if(TipoGastoEmpresaLogicAdditional.validarSaveRelaciones(tipogastoempresa,this)) {

				TipoGastoEmpresaLogicAdditional.updateRelacionesToSave(tipogastoempresa,this);

				if((tipogastoempresa.getIsNew()||tipogastoempresa.getIsChanged())&&!tipogastoempresa.getIsDeleted()) {
					this.saveTipoGastoEmpresa();
					this.saveTipoGastoEmpresaRelacionesDetalles();

				} else if(tipogastoempresa.getIsDeleted()) {
					this.saveTipoGastoEmpresaRelacionesDetalles();
					this.saveTipoGastoEmpresa();
				}

				TipoGastoEmpresaLogicAdditional.updateRelacionesToSaveAfter(tipogastoempresa,this);

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
	
	
	private void saveTipoGastoEmpresaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGastoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGastoEmpresaConstantesFunciones.getClassesForeignKeysOfTipoGastoEmpresa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGastoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGastoEmpresaConstantesFunciones.getClassesRelationshipsOfTipoGastoEmpresa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

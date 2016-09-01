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
package com.bydan.erp.produccion.business.logic;

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
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.produccion.util.TipoGastoProduEmpresaConstantesFunciones;
import com.bydan.erp.produccion.util.TipoGastoProduEmpresaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoGastoProduEmpresaParameterGeneral;
import com.bydan.erp.produccion.business.entity.TipoGastoProduEmpresa;
import com.bydan.erp.produccion.business.logic.TipoGastoProduEmpresaLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoGastoProduEmpresaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoGastoProduEmpresaLogic.class);
	
	protected TipoGastoProduEmpresaDataAccess tipogastoproduempresaDataAccess; 	
	protected TipoGastoProduEmpresa tipogastoproduempresa;
	protected List<TipoGastoProduEmpresa> tipogastoproduempresas;
	protected Object tipogastoproduempresaObject;	
	protected List<Object> tipogastoproduempresasObject;
	
	public static ClassValidator<TipoGastoProduEmpresa> tipogastoproduempresaValidator = new ClassValidator<TipoGastoProduEmpresa>(TipoGastoProduEmpresa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoGastoProduEmpresaLogicAdditional tipogastoproduempresaLogicAdditional=null;
	
	public TipoGastoProduEmpresaLogicAdditional getTipoGastoProduEmpresaLogicAdditional() {
		return this.tipogastoproduempresaLogicAdditional;
	}
	
	public void setTipoGastoProduEmpresaLogicAdditional(TipoGastoProduEmpresaLogicAdditional tipogastoproduempresaLogicAdditional) {
		try {
			this.tipogastoproduempresaLogicAdditional=tipogastoproduempresaLogicAdditional;
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
	
	
	
	
	public  TipoGastoProduEmpresaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipogastoproduempresaDataAccess = new TipoGastoProduEmpresaDataAccess();
			
			this.tipogastoproduempresas= new ArrayList<TipoGastoProduEmpresa>();
			this.tipogastoproduempresa= new TipoGastoProduEmpresa();
			
			this.tipogastoproduempresaObject=new Object();
			this.tipogastoproduempresasObject=new ArrayList<Object>();
				
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
			
			this.tipogastoproduempresaDataAccess.setConnexionType(this.connexionType);
			this.tipogastoproduempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoGastoProduEmpresaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipogastoproduempresaDataAccess = new TipoGastoProduEmpresaDataAccess();
			this.tipogastoproduempresas= new ArrayList<TipoGastoProduEmpresa>();
			this.tipogastoproduempresa= new TipoGastoProduEmpresa();
			this.tipogastoproduempresaObject=new Object();
			this.tipogastoproduempresasObject=new ArrayList<Object>();
			
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
			
			this.tipogastoproduempresaDataAccess.setConnexionType(this.connexionType);
			this.tipogastoproduempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoGastoProduEmpresa getTipoGastoProduEmpresa() throws Exception {	
		TipoGastoProduEmpresaLogicAdditional.checkTipoGastoProduEmpresaToGet(tipogastoproduempresa,this.datosCliente,this.arrDatoGeneral);
		TipoGastoProduEmpresaLogicAdditional.updateTipoGastoProduEmpresaToGet(tipogastoproduempresa,this.arrDatoGeneral);
		
		return tipogastoproduempresa;
	}
		
	public void setTipoGastoProduEmpresa(TipoGastoProduEmpresa newTipoGastoProduEmpresa) {
		this.tipogastoproduempresa = newTipoGastoProduEmpresa;
	}
	
	public TipoGastoProduEmpresaDataAccess getTipoGastoProduEmpresaDataAccess() {
		return tipogastoproduempresaDataAccess;
	}
	
	public void setTipoGastoProduEmpresaDataAccess(TipoGastoProduEmpresaDataAccess newtipogastoproduempresaDataAccess) {
		this.tipogastoproduempresaDataAccess = newtipogastoproduempresaDataAccess;
	}
	
	public List<TipoGastoProduEmpresa> getTipoGastoProduEmpresas() throws Exception {		
		this.quitarTipoGastoProduEmpresasNulos();
		
		TipoGastoProduEmpresaLogicAdditional.checkTipoGastoProduEmpresaToGets(tipogastoproduempresas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoGastoProduEmpresa tipogastoproduempresaLocal: tipogastoproduempresas ) {
			TipoGastoProduEmpresaLogicAdditional.updateTipoGastoProduEmpresaToGet(tipogastoproduempresaLocal,this.arrDatoGeneral);
		}
		
		return tipogastoproduempresas;
	}
	
	public void setTipoGastoProduEmpresas(List<TipoGastoProduEmpresa> newTipoGastoProduEmpresas) {
		this.tipogastoproduempresas = newTipoGastoProduEmpresas;
	}
	
	public Object getTipoGastoProduEmpresaObject() {	
		this.tipogastoproduempresaObject=this.tipogastoproduempresaDataAccess.getEntityObject();
		return this.tipogastoproduempresaObject;
	}
		
	public void setTipoGastoProduEmpresaObject(Object newTipoGastoProduEmpresaObject) {
		this.tipogastoproduempresaObject = newTipoGastoProduEmpresaObject;
	}
	
	public List<Object> getTipoGastoProduEmpresasObject() {		
		this.tipogastoproduempresasObject=this.tipogastoproduempresaDataAccess.getEntitiesObject();
		return this.tipogastoproduempresasObject;
	}
		
	public void setTipoGastoProduEmpresasObject(List<Object> newTipoGastoProduEmpresasObject) {
		this.tipogastoproduempresasObject = newTipoGastoProduEmpresasObject;
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
		
		if(this.tipogastoproduempresaDataAccess!=null) {
			this.tipogastoproduempresaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipogastoproduempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipogastoproduempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogastoproduempresa=tipogastoproduempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogastoproduempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresa);
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
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		  		  
        try {
			
			tipogastoproduempresa=tipogastoproduempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogastoproduempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogastoproduempresa=tipogastoproduempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogastoproduempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresa);
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
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		  		  
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
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		  		  
        try {
			
			tipogastoproduempresa=tipogastoproduempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogastoproduempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		  		  
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
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipogastoproduempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipogastoproduempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipogastoproduempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipogastoproduempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipogastoproduempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipogastoproduempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogastoproduempresas = new  ArrayList<TipoGastoProduEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoproduempresas=tipogastoproduempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoProduEmpresa(tipogastoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresas);
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
		tipogastoproduempresas = new  ArrayList<TipoGastoProduEmpresa>();
		  		  
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
		tipogastoproduempresas = new  ArrayList<TipoGastoProduEmpresa>();
		  		  
        try {			
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoproduempresas=tipogastoproduempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoGastoProduEmpresa(tipogastoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipogastoproduempresas = new  ArrayList<TipoGastoProduEmpresa>();
		  		  
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
		tipogastoproduempresas = new  ArrayList<TipoGastoProduEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoproduempresas=tipogastoproduempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoProduEmpresa(tipogastoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresas);
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
		tipogastoproduempresas = new  ArrayList<TipoGastoProduEmpresa>();
		  		  
        try {
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoproduempresas=tipogastoproduempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoProduEmpresa(tipogastoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresas);
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
		tipogastoproduempresas = new  ArrayList<TipoGastoProduEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoproduempresas=tipogastoproduempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGastoProduEmpresa(tipogastoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresas);
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
		tipogastoproduempresas = new  ArrayList<TipoGastoProduEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoproduempresas=tipogastoproduempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGastoProduEmpresa(tipogastoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoproduempresa=tipogastoproduempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGastoProduEmpresa(tipogastoproduempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresa);
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
		tipogastoproduempresa = new  TipoGastoProduEmpresa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoproduempresa=tipogastoproduempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGastoProduEmpresa(tipogastoproduempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogastoproduempresas = new  ArrayList<TipoGastoProduEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoproduempresas=tipogastoproduempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoProduEmpresa(tipogastoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresas);
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
		tipogastoproduempresas = new  ArrayList<TipoGastoProduEmpresa>();
		  		  
        try {
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoproduempresas=tipogastoproduempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoProduEmpresa(tipogastoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoGastoProduEmpresasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipogastoproduempresas = new  ArrayList<TipoGastoProduEmpresa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-getTodosTipoGastoProduEmpresasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoproduempresas=tipogastoproduempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGastoProduEmpresa(tipogastoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresas);
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
	
	public  void  getTodosTipoGastoProduEmpresas(String sFinalQuery,Pagination pagination)throws Exception {
		tipogastoproduempresas = new  ArrayList<TipoGastoProduEmpresa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoproduempresas=tipogastoproduempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGastoProduEmpresa(tipogastoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoGastoProduEmpresa(TipoGastoProduEmpresa tipogastoproduempresa) throws Exception {
		Boolean estaValidado=false;
		
		if(tipogastoproduempresa.getIsNew() || tipogastoproduempresa.getIsChanged()) { 
			this.invalidValues = tipogastoproduempresaValidator.getInvalidValues(tipogastoproduempresa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipogastoproduempresa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoGastoProduEmpresa(List<TipoGastoProduEmpresa> TipoGastoProduEmpresas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoGastoProduEmpresa tipogastoproduempresaLocal:tipogastoproduempresas) {				
			estaValidadoObjeto=this.validarGuardarTipoGastoProduEmpresa(tipogastoproduempresaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoGastoProduEmpresa(List<TipoGastoProduEmpresa> TipoGastoProduEmpresas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGastoProduEmpresa(tipogastoproduempresas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoGastoProduEmpresa(TipoGastoProduEmpresa TipoGastoProduEmpresa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGastoProduEmpresa(tipogastoproduempresa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoGastoProduEmpresa tipogastoproduempresa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipogastoproduempresa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoGastoProduEmpresaConstantesFunciones.getTipoGastoProduEmpresaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipogastoproduempresa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoGastoProduEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoGastoProduEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoGastoProduEmpresaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-saveTipoGastoProduEmpresaWithConnection");connexion.begin();			
			
			TipoGastoProduEmpresaLogicAdditional.checkTipoGastoProduEmpresaToSave(this.tipogastoproduempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoGastoProduEmpresaLogicAdditional.updateTipoGastoProduEmpresaToSave(this.tipogastoproduempresa,this.arrDatoGeneral);
			
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogastoproduempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoGastoProduEmpresa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGastoProduEmpresa(this.tipogastoproduempresa)) {
				TipoGastoProduEmpresaDataAccess.save(this.tipogastoproduempresa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipogastoproduempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoGastoProduEmpresaLogicAdditional.checkTipoGastoProduEmpresaToSaveAfter(this.tipogastoproduempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGastoProduEmpresa();
			
			connexion.commit();			
			
			if(this.tipogastoproduempresa.getIsDeleted()) {
				this.tipogastoproduempresa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoGastoProduEmpresa()throws Exception {	
		try {	
			
			TipoGastoProduEmpresaLogicAdditional.checkTipoGastoProduEmpresaToSave(this.tipogastoproduempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoGastoProduEmpresaLogicAdditional.updateTipoGastoProduEmpresaToSave(this.tipogastoproduempresa,this.arrDatoGeneral);
			
			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogastoproduempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGastoProduEmpresa(this.tipogastoproduempresa)) {			
				TipoGastoProduEmpresaDataAccess.save(this.tipogastoproduempresa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipogastoproduempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoGastoProduEmpresaLogicAdditional.checkTipoGastoProduEmpresaToSaveAfter(this.tipogastoproduempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipogastoproduempresa.getIsDeleted()) {
				this.tipogastoproduempresa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoGastoProduEmpresasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-saveTipoGastoProduEmpresasWithConnection");connexion.begin();			
			
			TipoGastoProduEmpresaLogicAdditional.checkTipoGastoProduEmpresaToSaves(tipogastoproduempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoGastoProduEmpresas();
			
			Boolean validadoTodosTipoGastoProduEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGastoProduEmpresa tipogastoproduempresaLocal:tipogastoproduempresas) {		
				if(tipogastoproduempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoGastoProduEmpresaLogicAdditional.updateTipoGastoProduEmpresaToSave(tipogastoproduempresaLocal,this.arrDatoGeneral);
	        	
				TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogastoproduempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGastoProduEmpresa(tipogastoproduempresaLocal)) {
					TipoGastoProduEmpresaDataAccess.save(tipogastoproduempresaLocal, connexion);				
				} else {
					validadoTodosTipoGastoProduEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoGastoProduEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoGastoProduEmpresaLogicAdditional.checkTipoGastoProduEmpresaToSavesAfter(tipogastoproduempresas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGastoProduEmpresas();
			
			connexion.commit();		
			
			this.quitarTipoGastoProduEmpresasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoGastoProduEmpresas()throws Exception {				
		 try {	
			TipoGastoProduEmpresaLogicAdditional.checkTipoGastoProduEmpresaToSaves(tipogastoproduempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoGastoProduEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGastoProduEmpresa tipogastoproduempresaLocal:tipogastoproduempresas) {				
				if(tipogastoproduempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoGastoProduEmpresaLogicAdditional.updateTipoGastoProduEmpresaToSave(tipogastoproduempresaLocal,this.arrDatoGeneral);
	        	
				TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogastoproduempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGastoProduEmpresa(tipogastoproduempresaLocal)) {				
					TipoGastoProduEmpresaDataAccess.save(tipogastoproduempresaLocal, connexion);				
				} else {
					validadoTodosTipoGastoProduEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoGastoProduEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoGastoProduEmpresaLogicAdditional.checkTipoGastoProduEmpresaToSavesAfter(tipogastoproduempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoGastoProduEmpresasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGastoProduEmpresaParameterReturnGeneral procesarAccionTipoGastoProduEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGastoProduEmpresa> tipogastoproduempresas,TipoGastoProduEmpresaParameterReturnGeneral tipogastoproduempresaParameterGeneral)throws Exception {
		 try {	
			TipoGastoProduEmpresaParameterReturnGeneral tipogastoproduempresaReturnGeneral=new TipoGastoProduEmpresaParameterReturnGeneral();
	
			TipoGastoProduEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipogastoproduempresas,tipogastoproduempresaParameterGeneral,tipogastoproduempresaReturnGeneral);
			
			return tipogastoproduempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGastoProduEmpresaParameterReturnGeneral procesarAccionTipoGastoProduEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGastoProduEmpresa> tipogastoproduempresas,TipoGastoProduEmpresaParameterReturnGeneral tipogastoproduempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-procesarAccionTipoGastoProduEmpresasWithConnection");connexion.begin();			
			
			TipoGastoProduEmpresaParameterReturnGeneral tipogastoproduempresaReturnGeneral=new TipoGastoProduEmpresaParameterReturnGeneral();
	
			TipoGastoProduEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipogastoproduempresas,tipogastoproduempresaParameterGeneral,tipogastoproduempresaReturnGeneral);
			
			this.connexion.commit();
			
			return tipogastoproduempresaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGastoProduEmpresaParameterReturnGeneral procesarEventosTipoGastoProduEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGastoProduEmpresa> tipogastoproduempresas,TipoGastoProduEmpresa tipogastoproduempresa,TipoGastoProduEmpresaParameterReturnGeneral tipogastoproduempresaParameterGeneral,Boolean isEsNuevoTipoGastoProduEmpresa,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoGastoProduEmpresaParameterReturnGeneral tipogastoproduempresaReturnGeneral=new TipoGastoProduEmpresaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogastoproduempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoGastoProduEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipogastoproduempresas,tipogastoproduempresa,tipogastoproduempresaParameterGeneral,tipogastoproduempresaReturnGeneral,isEsNuevoTipoGastoProduEmpresa,clases);
			
			return tipogastoproduempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoGastoProduEmpresaParameterReturnGeneral procesarEventosTipoGastoProduEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGastoProduEmpresa> tipogastoproduempresas,TipoGastoProduEmpresa tipogastoproduempresa,TipoGastoProduEmpresaParameterReturnGeneral tipogastoproduempresaParameterGeneral,Boolean isEsNuevoTipoGastoProduEmpresa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-procesarEventosTipoGastoProduEmpresasWithConnection");connexion.begin();			
			
			TipoGastoProduEmpresaParameterReturnGeneral tipogastoproduempresaReturnGeneral=new TipoGastoProduEmpresaParameterReturnGeneral();
	
			tipogastoproduempresaReturnGeneral.setTipoGastoProduEmpresa(tipogastoproduempresa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogastoproduempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoGastoProduEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipogastoproduempresas,tipogastoproduempresa,tipogastoproduempresaParameterGeneral,tipogastoproduempresaReturnGeneral,isEsNuevoTipoGastoProduEmpresa,clases);
			
			this.connexion.commit();
			
			return tipogastoproduempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGastoProduEmpresaParameterReturnGeneral procesarImportacionTipoGastoProduEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoGastoProduEmpresaParameterReturnGeneral tipogastoproduempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-procesarImportacionTipoGastoProduEmpresasWithConnection");connexion.begin();			
			
			TipoGastoProduEmpresaParameterReturnGeneral tipogastoproduempresaReturnGeneral=new TipoGastoProduEmpresaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipogastoproduempresas=new ArrayList<TipoGastoProduEmpresa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipogastoproduempresa=new TipoGastoProduEmpresa();
				
				
				if(conColumnasBase) {this.tipogastoproduempresa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipogastoproduempresa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipogastoproduempresa.setnombre(arrColumnas[iColumn++]);
				this.tipogastoproduempresa.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipogastoproduempresas.add(this.tipogastoproduempresa);
			}
			
			this.saveTipoGastoProduEmpresas();
			
			this.connexion.commit();
			
			tipogastoproduempresaReturnGeneral.setConRetornoEstaProcesado(true);
			tipogastoproduempresaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipogastoproduempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoGastoProduEmpresasEliminados() throws Exception {				
		
		List<TipoGastoProduEmpresa> tipogastoproduempresasAux= new ArrayList<TipoGastoProduEmpresa>();
		
		for(TipoGastoProduEmpresa tipogastoproduempresa:tipogastoproduempresas) {
			if(!tipogastoproduempresa.getIsDeleted()) {
				tipogastoproduempresasAux.add(tipogastoproduempresa);
			}
		}
		
		tipogastoproduempresas=tipogastoproduempresasAux;
	}
	
	public void quitarTipoGastoProduEmpresasNulos() throws Exception {				
		
		List<TipoGastoProduEmpresa> tipogastoproduempresasAux= new ArrayList<TipoGastoProduEmpresa>();
		
		for(TipoGastoProduEmpresa tipogastoproduempresa : this.tipogastoproduempresas) {
			if(tipogastoproduempresa==null) {
				tipogastoproduempresasAux.add(tipogastoproduempresa);
			}
		}
		
		//this.tipogastoproduempresas=tipogastoproduempresasAux;
		
		this.tipogastoproduempresas.removeAll(tipogastoproduempresasAux);
	}
	
	public void getSetVersionRowTipoGastoProduEmpresaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipogastoproduempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipogastoproduempresa.getIsDeleted() || (tipogastoproduempresa.getIsChanged()&&!tipogastoproduempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipogastoproduempresaDataAccess.getSetVersionRowTipoGastoProduEmpresa(connexion,tipogastoproduempresa.getId());
				
				if(!tipogastoproduempresa.getVersionRow().equals(timestamp)) {	
					tipogastoproduempresa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipogastoproduempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoGastoProduEmpresa()throws Exception {	
		
		if(tipogastoproduempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipogastoproduempresa.getIsDeleted() || (tipogastoproduempresa.getIsChanged()&&!tipogastoproduempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipogastoproduempresaDataAccess.getSetVersionRowTipoGastoProduEmpresa(connexion,tipogastoproduempresa.getId());
			
			try {							
				if(!tipogastoproduempresa.getVersionRow().equals(timestamp)) {	
					tipogastoproduempresa.setVersionRow(timestamp);
				}
				
				tipogastoproduempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoGastoProduEmpresasWithConnection()throws Exception {	
		if(tipogastoproduempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoGastoProduEmpresa tipogastoproduempresaAux:tipogastoproduempresas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipogastoproduempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogastoproduempresaAux.getIsDeleted() || (tipogastoproduempresaAux.getIsChanged()&&!tipogastoproduempresaAux.getIsNew())) {
						
						timestamp=tipogastoproduempresaDataAccess.getSetVersionRowTipoGastoProduEmpresa(connexion,tipogastoproduempresaAux.getId());
						
						if(!tipogastoproduempresa.getVersionRow().equals(timestamp)) {	
							tipogastoproduempresaAux.setVersionRow(timestamp);
						}
								
						tipogastoproduempresaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoGastoProduEmpresas()throws Exception {	
		if(tipogastoproduempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoGastoProduEmpresa tipogastoproduempresaAux:tipogastoproduempresas) {
					if(tipogastoproduempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogastoproduempresaAux.getIsDeleted() || (tipogastoproduempresaAux.getIsChanged()&&!tipogastoproduempresaAux.getIsNew())) {
						
						timestamp=tipogastoproduempresaDataAccess.getSetVersionRowTipoGastoProduEmpresa(connexion,tipogastoproduempresaAux.getId());
						
						if(!tipogastoproduempresaAux.getVersionRow().equals(timestamp)) {	
							tipogastoproduempresaAux.setVersionRow(timestamp);
						}
						
													
						tipogastoproduempresaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoGastoProduEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoGastoProduEmpresaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoGastoProduEmpresaParameterReturnGeneral  tipogastoproduempresaReturnGeneral =new TipoGastoProduEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoGastoProduEmpresaWithConnection");connexion.begin();
			
			tipogastoproduempresaReturnGeneral =new TipoGastoProduEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipogastoproduempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipogastoproduempresaReturnGeneral;
	}
	
	public TipoGastoProduEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoGastoProduEmpresa(String finalQueryGlobalEmpresa) throws Exception {
		TipoGastoProduEmpresaParameterReturnGeneral  tipogastoproduempresaReturnGeneral =new TipoGastoProduEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipogastoproduempresaReturnGeneral =new TipoGastoProduEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipogastoproduempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipogastoproduempresaReturnGeneral;
	}
	
	
	public void deepLoad(TipoGastoProduEmpresa tipogastoproduempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoGastoProduEmpresaLogicAdditional.updateTipoGastoProduEmpresaToGet(tipogastoproduempresa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogastoproduempresa.setEmpresa(tipogastoproduempresaDataAccess.getEmpresa(connexion,tipogastoproduempresa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipogastoproduempresa.setEmpresa(tipogastoproduempresaDataAccess.getEmpresa(connexion,tipogastoproduempresa));
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
			tipogastoproduempresa.setEmpresa(tipogastoproduempresaDataAccess.getEmpresa(connexion,tipogastoproduempresa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogastoproduempresa.setEmpresa(tipogastoproduempresaDataAccess.getEmpresa(connexion,tipogastoproduempresa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipogastoproduempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipogastoproduempresa.setEmpresa(tipogastoproduempresaDataAccess.getEmpresa(connexion,tipogastoproduempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipogastoproduempresa.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tipogastoproduempresa.setEmpresa(tipogastoproduempresaDataAccess.getEmpresa(connexion,tipogastoproduempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipogastoproduempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoGastoProduEmpresa tipogastoproduempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoGastoProduEmpresaLogicAdditional.updateTipoGastoProduEmpresaToSave(tipogastoproduempresa,this.arrDatoGeneral);
			
TipoGastoProduEmpresaDataAccess.save(tipogastoproduempresa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipogastoproduempresa.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipogastoproduempresa.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipogastoproduempresa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipogastoproduempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipogastoproduempresa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipogastoproduempresa.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoGastoProduEmpresa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipogastoproduempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(tipogastoproduempresa);
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
			this.deepLoad(this.tipogastoproduempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGastoProduEmpresa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipogastoproduempresas!=null) {
				for(TipoGastoProduEmpresa tipogastoproduempresa:tipogastoproduempresas) {
					this.deepLoad(tipogastoproduempresa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(tipogastoproduempresas);
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
			if(tipogastoproduempresas!=null) {
				for(TipoGastoProduEmpresa tipogastoproduempresa:tipogastoproduempresas) {
					this.deepLoad(tipogastoproduempresa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(tipogastoproduempresas);
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
			this.getNewConnexionToDeep(TipoGastoProduEmpresa.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipogastoproduempresa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoGastoProduEmpresa.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipogastoproduempresas!=null) {
				for(TipoGastoProduEmpresa tipogastoproduempresa:tipogastoproduempresas) {
					this.deepSave(tipogastoproduempresa,isDeep,deepLoadType,clases);
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
			if(tipogastoproduempresas!=null) {
				for(TipoGastoProduEmpresa tipogastoproduempresa:tipogastoproduempresas) {
					this.deepSave(tipogastoproduempresa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoGastoProduEmpresasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProduEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoproduempresas=tipogastoproduempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoProduEmpresasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoGastoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoproduempresas=tipogastoproduempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(this.tipogastoproduempresas);
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
			if(TipoGastoProduEmpresaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGastoProduEmpresaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoGastoProduEmpresa tipogastoproduempresa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoGastoProduEmpresaConstantesFunciones.ISCONAUDITORIA) {
				if(tipogastoproduempresa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGastoProduEmpresaDataAccess.TABLENAME, tipogastoproduempresa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGastoProduEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGastoProduEmpresaLogic.registrarAuditoriaDetallesTipoGastoProduEmpresa(connexion,tipogastoproduempresa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipogastoproduempresa.getIsDeleted()) {
					/*if(!tipogastoproduempresa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoGastoProduEmpresaDataAccess.TABLENAME, tipogastoproduempresa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoGastoProduEmpresaLogic.registrarAuditoriaDetallesTipoGastoProduEmpresa(connexion,tipogastoproduempresa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGastoProduEmpresaDataAccess.TABLENAME, tipogastoproduempresa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipogastoproduempresa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGastoProduEmpresaDataAccess.TABLENAME, tipogastoproduempresa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGastoProduEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGastoProduEmpresaLogic.registrarAuditoriaDetallesTipoGastoProduEmpresa(connexion,tipogastoproduempresa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoGastoProduEmpresa(Connexion connexion,TipoGastoProduEmpresa tipogastoproduempresa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipogastoproduempresa.getIsNew()||!tipogastoproduempresa.getid_empresa().equals(tipogastoproduempresa.getTipoGastoProduEmpresaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoproduempresa.getTipoGastoProduEmpresaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipogastoproduempresa.getTipoGastoProduEmpresaOriginal().getid_empresa().toString();
				}
				if(tipogastoproduempresa.getid_empresa()!=null)
				{
					strValorNuevo=tipogastoproduempresa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoproduempresa.getIsNew()||!tipogastoproduempresa.getnombre().equals(tipogastoproduempresa.getTipoGastoProduEmpresaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoproduempresa.getTipoGastoProduEmpresaOriginal().getnombre()!=null)
				{
					strValorActual=tipogastoproduempresa.getTipoGastoProduEmpresaOriginal().getnombre();
				}
				if(tipogastoproduempresa.getnombre()!=null)
				{
					strValorNuevo=tipogastoproduempresa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoProduEmpresaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoproduempresa.getIsNew()||!tipogastoproduempresa.getdescripcion().equals(tipogastoproduempresa.getTipoGastoProduEmpresaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoproduempresa.getTipoGastoProduEmpresaOriginal().getdescripcion()!=null)
				{
					strValorActual=tipogastoproduempresa.getTipoGastoProduEmpresaOriginal().getdescripcion();
				}
				if(tipogastoproduempresa.getdescripcion()!=null)
				{
					strValorNuevo=tipogastoproduempresa.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoProduEmpresaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoGastoProduEmpresaRelacionesWithConnection(TipoGastoProduEmpresa tipogastoproduempresa) throws Exception {

		if(!tipogastoproduempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoGastoProduEmpresaRelacionesBase(tipogastoproduempresa,true);
		}
	}

	public void saveTipoGastoProduEmpresaRelaciones(TipoGastoProduEmpresa tipogastoproduempresa)throws Exception {

		if(!tipogastoproduempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoGastoProduEmpresaRelacionesBase(tipogastoproduempresa,false);
		}
	}

	public void saveTipoGastoProduEmpresaRelacionesBase(TipoGastoProduEmpresa tipogastoproduempresa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoGastoProduEmpresa-saveRelacionesWithConnection");}
	

			this.setTipoGastoProduEmpresa(tipogastoproduempresa);

			if(TipoGastoProduEmpresaLogicAdditional.validarSaveRelaciones(tipogastoproduempresa,this)) {

				TipoGastoProduEmpresaLogicAdditional.updateRelacionesToSave(tipogastoproduempresa,this);

				if((tipogastoproduempresa.getIsNew()||tipogastoproduempresa.getIsChanged())&&!tipogastoproduempresa.getIsDeleted()) {
					this.saveTipoGastoProduEmpresa();
					this.saveTipoGastoProduEmpresaRelacionesDetalles();

				} else if(tipogastoproduempresa.getIsDeleted()) {
					this.saveTipoGastoProduEmpresaRelacionesDetalles();
					this.saveTipoGastoProduEmpresa();
				}

				TipoGastoProduEmpresaLogicAdditional.updateRelacionesToSaveAfter(tipogastoproduempresa,this);

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
	
	
	private void saveTipoGastoProduEmpresaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGastoProduEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGastoProduEmpresaConstantesFunciones.getClassesForeignKeysOfTipoGastoProduEmpresa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGastoProduEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGastoProduEmpresaConstantesFunciones.getClassesRelationshipsOfTipoGastoProduEmpresa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

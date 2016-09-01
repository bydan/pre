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
import com.bydan.erp.facturacion.util.TipoDevolucionEmpresaConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoDevolucionEmpresaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoDevolucionEmpresaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoDevolucionEmpresa;
import com.bydan.erp.facturacion.business.logic.TipoDevolucionEmpresaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoDevolucionEmpresaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoDevolucionEmpresaLogic.class);
	
	protected TipoDevolucionEmpresaDataAccess tipodevolucionempresaDataAccess; 	
	protected TipoDevolucionEmpresa tipodevolucionempresa;
	protected List<TipoDevolucionEmpresa> tipodevolucionempresas;
	protected Object tipodevolucionempresaObject;	
	protected List<Object> tipodevolucionempresasObject;
	
	public static ClassValidator<TipoDevolucionEmpresa> tipodevolucionempresaValidator = new ClassValidator<TipoDevolucionEmpresa>(TipoDevolucionEmpresa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoDevolucionEmpresaLogicAdditional tipodevolucionempresaLogicAdditional=null;
	
	public TipoDevolucionEmpresaLogicAdditional getTipoDevolucionEmpresaLogicAdditional() {
		return this.tipodevolucionempresaLogicAdditional;
	}
	
	public void setTipoDevolucionEmpresaLogicAdditional(TipoDevolucionEmpresaLogicAdditional tipodevolucionempresaLogicAdditional) {
		try {
			this.tipodevolucionempresaLogicAdditional=tipodevolucionempresaLogicAdditional;
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
	
	
	
	
	public  TipoDevolucionEmpresaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipodevolucionempresaDataAccess = new TipoDevolucionEmpresaDataAccess();
			
			this.tipodevolucionempresas= new ArrayList<TipoDevolucionEmpresa>();
			this.tipodevolucionempresa= new TipoDevolucionEmpresa();
			
			this.tipodevolucionempresaObject=new Object();
			this.tipodevolucionempresasObject=new ArrayList<Object>();
				
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
			
			this.tipodevolucionempresaDataAccess.setConnexionType(this.connexionType);
			this.tipodevolucionempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoDevolucionEmpresaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipodevolucionempresaDataAccess = new TipoDevolucionEmpresaDataAccess();
			this.tipodevolucionempresas= new ArrayList<TipoDevolucionEmpresa>();
			this.tipodevolucionempresa= new TipoDevolucionEmpresa();
			this.tipodevolucionempresaObject=new Object();
			this.tipodevolucionempresasObject=new ArrayList<Object>();
			
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
			
			this.tipodevolucionempresaDataAccess.setConnexionType(this.connexionType);
			this.tipodevolucionempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoDevolucionEmpresa getTipoDevolucionEmpresa() throws Exception {	
		TipoDevolucionEmpresaLogicAdditional.checkTipoDevolucionEmpresaToGet(tipodevolucionempresa,this.datosCliente,this.arrDatoGeneral);
		TipoDevolucionEmpresaLogicAdditional.updateTipoDevolucionEmpresaToGet(tipodevolucionempresa,this.arrDatoGeneral);
		
		return tipodevolucionempresa;
	}
		
	public void setTipoDevolucionEmpresa(TipoDevolucionEmpresa newTipoDevolucionEmpresa) {
		this.tipodevolucionempresa = newTipoDevolucionEmpresa;
	}
	
	public TipoDevolucionEmpresaDataAccess getTipoDevolucionEmpresaDataAccess() {
		return tipodevolucionempresaDataAccess;
	}
	
	public void setTipoDevolucionEmpresaDataAccess(TipoDevolucionEmpresaDataAccess newtipodevolucionempresaDataAccess) {
		this.tipodevolucionempresaDataAccess = newtipodevolucionempresaDataAccess;
	}
	
	public List<TipoDevolucionEmpresa> getTipoDevolucionEmpresas() throws Exception {		
		this.quitarTipoDevolucionEmpresasNulos();
		
		TipoDevolucionEmpresaLogicAdditional.checkTipoDevolucionEmpresaToGets(tipodevolucionempresas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoDevolucionEmpresa tipodevolucionempresaLocal: tipodevolucionempresas ) {
			TipoDevolucionEmpresaLogicAdditional.updateTipoDevolucionEmpresaToGet(tipodevolucionempresaLocal,this.arrDatoGeneral);
		}
		
		return tipodevolucionempresas;
	}
	
	public void setTipoDevolucionEmpresas(List<TipoDevolucionEmpresa> newTipoDevolucionEmpresas) {
		this.tipodevolucionempresas = newTipoDevolucionEmpresas;
	}
	
	public Object getTipoDevolucionEmpresaObject() {	
		this.tipodevolucionempresaObject=this.tipodevolucionempresaDataAccess.getEntityObject();
		return this.tipodevolucionempresaObject;
	}
		
	public void setTipoDevolucionEmpresaObject(Object newTipoDevolucionEmpresaObject) {
		this.tipodevolucionempresaObject = newTipoDevolucionEmpresaObject;
	}
	
	public List<Object> getTipoDevolucionEmpresasObject() {		
		this.tipodevolucionempresasObject=this.tipodevolucionempresaDataAccess.getEntitiesObject();
		return this.tipodevolucionempresasObject;
	}
		
	public void setTipoDevolucionEmpresasObject(List<Object> newTipoDevolucionEmpresasObject) {
		this.tipodevolucionempresasObject = newTipoDevolucionEmpresasObject;
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
		
		if(this.tipodevolucionempresaDataAccess!=null) {
			this.tipodevolucionempresaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipodevolucionempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipodevolucionempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodevolucionempresa=tipodevolucionempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodevolucionempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresa);
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
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		  		  
        try {
			
			tipodevolucionempresa=tipodevolucionempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodevolucionempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodevolucionempresa=tipodevolucionempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodevolucionempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresa);
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
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		  		  
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
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		  		  
        try {
			
			tipodevolucionempresa=tipodevolucionempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodevolucionempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		  		  
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
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipodevolucionempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipodevolucionempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipodevolucionempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipodevolucionempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipodevolucionempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipodevolucionempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodevolucionempresas = new  ArrayList<TipoDevolucionEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDevolucionEmpresa(tipodevolucionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
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
		tipodevolucionempresas = new  ArrayList<TipoDevolucionEmpresa>();
		  		  
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
		tipodevolucionempresas = new  ArrayList<TipoDevolucionEmpresa>();
		  		  
        try {			
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoDevolucionEmpresa(tipodevolucionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipodevolucionempresas = new  ArrayList<TipoDevolucionEmpresa>();
		  		  
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
		tipodevolucionempresas = new  ArrayList<TipoDevolucionEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDevolucionEmpresa(tipodevolucionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
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
		tipodevolucionempresas = new  ArrayList<TipoDevolucionEmpresa>();
		  		  
        try {
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDevolucionEmpresa(tipodevolucionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
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
		tipodevolucionempresas = new  ArrayList<TipoDevolucionEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDevolucionEmpresa(tipodevolucionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
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
		tipodevolucionempresas = new  ArrayList<TipoDevolucionEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDevolucionEmpresa(tipodevolucionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodevolucionempresa=tipodevolucionempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDevolucionEmpresa(tipodevolucionempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresa);
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
		tipodevolucionempresa = new  TipoDevolucionEmpresa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodevolucionempresa=tipodevolucionempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDevolucionEmpresa(tipodevolucionempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodevolucionempresas = new  ArrayList<TipoDevolucionEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDevolucionEmpresa(tipodevolucionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
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
		tipodevolucionempresas = new  ArrayList<TipoDevolucionEmpresa>();
		  		  
        try {
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDevolucionEmpresa(tipodevolucionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoDevolucionEmpresasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipodevolucionempresas = new  ArrayList<TipoDevolucionEmpresa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getTodosTipoDevolucionEmpresasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDevolucionEmpresa(tipodevolucionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
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
	
	public  void  getTodosTipoDevolucionEmpresas(String sFinalQuery,Pagination pagination)throws Exception {
		tipodevolucionempresas = new  ArrayList<TipoDevolucionEmpresa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDevolucionEmpresa(tipodevolucionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoDevolucionEmpresa(TipoDevolucionEmpresa tipodevolucionempresa) throws Exception {
		Boolean estaValidado=false;
		
		if(tipodevolucionempresa.getIsNew() || tipodevolucionempresa.getIsChanged()) { 
			this.invalidValues = tipodevolucionempresaValidator.getInvalidValues(tipodevolucionempresa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipodevolucionempresa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoDevolucionEmpresa(List<TipoDevolucionEmpresa> TipoDevolucionEmpresas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoDevolucionEmpresa tipodevolucionempresaLocal:tipodevolucionempresas) {				
			estaValidadoObjeto=this.validarGuardarTipoDevolucionEmpresa(tipodevolucionempresaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoDevolucionEmpresa(List<TipoDevolucionEmpresa> TipoDevolucionEmpresas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDevolucionEmpresa(tipodevolucionempresas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoDevolucionEmpresa(TipoDevolucionEmpresa TipoDevolucionEmpresa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDevolucionEmpresa(tipodevolucionempresa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoDevolucionEmpresa tipodevolucionempresa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipodevolucionempresa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoDevolucionEmpresaConstantesFunciones.getTipoDevolucionEmpresaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipodevolucionempresa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoDevolucionEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoDevolucionEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoDevolucionEmpresaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-saveTipoDevolucionEmpresaWithConnection");connexion.begin();			
			
			TipoDevolucionEmpresaLogicAdditional.checkTipoDevolucionEmpresaToSave(this.tipodevolucionempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDevolucionEmpresaLogicAdditional.updateTipoDevolucionEmpresaToSave(this.tipodevolucionempresa,this.arrDatoGeneral);
			
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodevolucionempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoDevolucionEmpresa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDevolucionEmpresa(this.tipodevolucionempresa)) {
				TipoDevolucionEmpresaDataAccess.save(this.tipodevolucionempresa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipodevolucionempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDevolucionEmpresaLogicAdditional.checkTipoDevolucionEmpresaToSaveAfter(this.tipodevolucionempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDevolucionEmpresa();
			
			connexion.commit();			
			
			if(this.tipodevolucionempresa.getIsDeleted()) {
				this.tipodevolucionempresa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoDevolucionEmpresa()throws Exception {	
		try {	
			
			TipoDevolucionEmpresaLogicAdditional.checkTipoDevolucionEmpresaToSave(this.tipodevolucionempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDevolucionEmpresaLogicAdditional.updateTipoDevolucionEmpresaToSave(this.tipodevolucionempresa,this.arrDatoGeneral);
			
			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodevolucionempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDevolucionEmpresa(this.tipodevolucionempresa)) {			
				TipoDevolucionEmpresaDataAccess.save(this.tipodevolucionempresa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipodevolucionempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDevolucionEmpresaLogicAdditional.checkTipoDevolucionEmpresaToSaveAfter(this.tipodevolucionempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipodevolucionempresa.getIsDeleted()) {
				this.tipodevolucionempresa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoDevolucionEmpresasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-saveTipoDevolucionEmpresasWithConnection");connexion.begin();			
			
			TipoDevolucionEmpresaLogicAdditional.checkTipoDevolucionEmpresaToSaves(tipodevolucionempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoDevolucionEmpresas();
			
			Boolean validadoTodosTipoDevolucionEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDevolucionEmpresa tipodevolucionempresaLocal:tipodevolucionempresas) {		
				if(tipodevolucionempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDevolucionEmpresaLogicAdditional.updateTipoDevolucionEmpresaToSave(tipodevolucionempresaLocal,this.arrDatoGeneral);
	        	
				TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodevolucionempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDevolucionEmpresa(tipodevolucionempresaLocal)) {
					TipoDevolucionEmpresaDataAccess.save(tipodevolucionempresaLocal, connexion);				
				} else {
					validadoTodosTipoDevolucionEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoDevolucionEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDevolucionEmpresaLogicAdditional.checkTipoDevolucionEmpresaToSavesAfter(tipodevolucionempresas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDevolucionEmpresas();
			
			connexion.commit();		
			
			this.quitarTipoDevolucionEmpresasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoDevolucionEmpresas()throws Exception {				
		 try {	
			TipoDevolucionEmpresaLogicAdditional.checkTipoDevolucionEmpresaToSaves(tipodevolucionempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoDevolucionEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDevolucionEmpresa tipodevolucionempresaLocal:tipodevolucionempresas) {				
				if(tipodevolucionempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDevolucionEmpresaLogicAdditional.updateTipoDevolucionEmpresaToSave(tipodevolucionempresaLocal,this.arrDatoGeneral);
	        	
				TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodevolucionempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDevolucionEmpresa(tipodevolucionempresaLocal)) {				
					TipoDevolucionEmpresaDataAccess.save(tipodevolucionempresaLocal, connexion);				
				} else {
					validadoTodosTipoDevolucionEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoDevolucionEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDevolucionEmpresaLogicAdditional.checkTipoDevolucionEmpresaToSavesAfter(tipodevolucionempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoDevolucionEmpresasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDevolucionEmpresaParameterReturnGeneral procesarAccionTipoDevolucionEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDevolucionEmpresa> tipodevolucionempresas,TipoDevolucionEmpresaParameterReturnGeneral tipodevolucionempresaParameterGeneral)throws Exception {
		 try {	
			TipoDevolucionEmpresaParameterReturnGeneral tipodevolucionempresaReturnGeneral=new TipoDevolucionEmpresaParameterReturnGeneral();
	
			TipoDevolucionEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodevolucionempresas,tipodevolucionempresaParameterGeneral,tipodevolucionempresaReturnGeneral);
			
			return tipodevolucionempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDevolucionEmpresaParameterReturnGeneral procesarAccionTipoDevolucionEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDevolucionEmpresa> tipodevolucionempresas,TipoDevolucionEmpresaParameterReturnGeneral tipodevolucionempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-procesarAccionTipoDevolucionEmpresasWithConnection");connexion.begin();			
			
			TipoDevolucionEmpresaParameterReturnGeneral tipodevolucionempresaReturnGeneral=new TipoDevolucionEmpresaParameterReturnGeneral();
	
			TipoDevolucionEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodevolucionempresas,tipodevolucionempresaParameterGeneral,tipodevolucionempresaReturnGeneral);
			
			this.connexion.commit();
			
			return tipodevolucionempresaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDevolucionEmpresaParameterReturnGeneral procesarEventosTipoDevolucionEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDevolucionEmpresa> tipodevolucionempresas,TipoDevolucionEmpresa tipodevolucionempresa,TipoDevolucionEmpresaParameterReturnGeneral tipodevolucionempresaParameterGeneral,Boolean isEsNuevoTipoDevolucionEmpresa,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoDevolucionEmpresaParameterReturnGeneral tipodevolucionempresaReturnGeneral=new TipoDevolucionEmpresaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodevolucionempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDevolucionEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodevolucionempresas,tipodevolucionempresa,tipodevolucionempresaParameterGeneral,tipodevolucionempresaReturnGeneral,isEsNuevoTipoDevolucionEmpresa,clases);
			
			return tipodevolucionempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoDevolucionEmpresaParameterReturnGeneral procesarEventosTipoDevolucionEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDevolucionEmpresa> tipodevolucionempresas,TipoDevolucionEmpresa tipodevolucionempresa,TipoDevolucionEmpresaParameterReturnGeneral tipodevolucionempresaParameterGeneral,Boolean isEsNuevoTipoDevolucionEmpresa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-procesarEventosTipoDevolucionEmpresasWithConnection");connexion.begin();			
			
			TipoDevolucionEmpresaParameterReturnGeneral tipodevolucionempresaReturnGeneral=new TipoDevolucionEmpresaParameterReturnGeneral();
	
			tipodevolucionempresaReturnGeneral.setTipoDevolucionEmpresa(tipodevolucionempresa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodevolucionempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDevolucionEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodevolucionempresas,tipodevolucionempresa,tipodevolucionempresaParameterGeneral,tipodevolucionempresaReturnGeneral,isEsNuevoTipoDevolucionEmpresa,clases);
			
			this.connexion.commit();
			
			return tipodevolucionempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDevolucionEmpresaParameterReturnGeneral procesarImportacionTipoDevolucionEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoDevolucionEmpresaParameterReturnGeneral tipodevolucionempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-procesarImportacionTipoDevolucionEmpresasWithConnection");connexion.begin();			
			
			TipoDevolucionEmpresaParameterReturnGeneral tipodevolucionempresaReturnGeneral=new TipoDevolucionEmpresaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipodevolucionempresas=new ArrayList<TipoDevolucionEmpresa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipodevolucionempresa=new TipoDevolucionEmpresa();
				
				
				if(conColumnasBase) {this.tipodevolucionempresa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipodevolucionempresa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipodevolucionempresa.setcodigo(arrColumnas[iColumn++]);
				this.tipodevolucionempresa.setnombre(arrColumnas[iColumn++]);
				this.tipodevolucionempresa.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tipodevolucionempresas.add(this.tipodevolucionempresa);
			}
			
			this.saveTipoDevolucionEmpresas();
			
			this.connexion.commit();
			
			tipodevolucionempresaReturnGeneral.setConRetornoEstaProcesado(true);
			tipodevolucionempresaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipodevolucionempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoDevolucionEmpresasEliminados() throws Exception {				
		
		List<TipoDevolucionEmpresa> tipodevolucionempresasAux= new ArrayList<TipoDevolucionEmpresa>();
		
		for(TipoDevolucionEmpresa tipodevolucionempresa:tipodevolucionempresas) {
			if(!tipodevolucionempresa.getIsDeleted()) {
				tipodevolucionempresasAux.add(tipodevolucionempresa);
			}
		}
		
		tipodevolucionempresas=tipodevolucionempresasAux;
	}
	
	public void quitarTipoDevolucionEmpresasNulos() throws Exception {				
		
		List<TipoDevolucionEmpresa> tipodevolucionempresasAux= new ArrayList<TipoDevolucionEmpresa>();
		
		for(TipoDevolucionEmpresa tipodevolucionempresa : this.tipodevolucionempresas) {
			if(tipodevolucionempresa==null) {
				tipodevolucionempresasAux.add(tipodevolucionempresa);
			}
		}
		
		//this.tipodevolucionempresas=tipodevolucionempresasAux;
		
		this.tipodevolucionempresas.removeAll(tipodevolucionempresasAux);
	}
	
	public void getSetVersionRowTipoDevolucionEmpresaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipodevolucionempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipodevolucionempresa.getIsDeleted() || (tipodevolucionempresa.getIsChanged()&&!tipodevolucionempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipodevolucionempresaDataAccess.getSetVersionRowTipoDevolucionEmpresa(connexion,tipodevolucionempresa.getId());
				
				if(!tipodevolucionempresa.getVersionRow().equals(timestamp)) {	
					tipodevolucionempresa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipodevolucionempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoDevolucionEmpresa()throws Exception {	
		
		if(tipodevolucionempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipodevolucionempresa.getIsDeleted() || (tipodevolucionempresa.getIsChanged()&&!tipodevolucionempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipodevolucionempresaDataAccess.getSetVersionRowTipoDevolucionEmpresa(connexion,tipodevolucionempresa.getId());
			
			try {							
				if(!tipodevolucionempresa.getVersionRow().equals(timestamp)) {	
					tipodevolucionempresa.setVersionRow(timestamp);
				}
				
				tipodevolucionempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoDevolucionEmpresasWithConnection()throws Exception {	
		if(tipodevolucionempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoDevolucionEmpresa tipodevolucionempresaAux:tipodevolucionempresas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipodevolucionempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodevolucionempresaAux.getIsDeleted() || (tipodevolucionempresaAux.getIsChanged()&&!tipodevolucionempresaAux.getIsNew())) {
						
						timestamp=tipodevolucionempresaDataAccess.getSetVersionRowTipoDevolucionEmpresa(connexion,tipodevolucionempresaAux.getId());
						
						if(!tipodevolucionempresa.getVersionRow().equals(timestamp)) {	
							tipodevolucionempresaAux.setVersionRow(timestamp);
						}
								
						tipodevolucionempresaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoDevolucionEmpresas()throws Exception {	
		if(tipodevolucionempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoDevolucionEmpresa tipodevolucionempresaAux:tipodevolucionempresas) {
					if(tipodevolucionempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodevolucionempresaAux.getIsDeleted() || (tipodevolucionempresaAux.getIsChanged()&&!tipodevolucionempresaAux.getIsNew())) {
						
						timestamp=tipodevolucionempresaDataAccess.getSetVersionRowTipoDevolucionEmpresa(connexion,tipodevolucionempresaAux.getId());
						
						if(!tipodevolucionempresaAux.getVersionRow().equals(timestamp)) {	
							tipodevolucionempresaAux.setVersionRow(timestamp);
						}
						
													
						tipodevolucionempresaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoDevolucionEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoDevolucionEmpresaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoDevolucionEmpresaParameterReturnGeneral  tipodevolucionempresaReturnGeneral =new TipoDevolucionEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoDevolucionEmpresaWithConnection");connexion.begin();
			
			tipodevolucionempresaReturnGeneral =new TipoDevolucionEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodevolucionempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipodevolucionempresaReturnGeneral;
	}
	
	public TipoDevolucionEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoDevolucionEmpresa(String finalQueryGlobalEmpresa) throws Exception {
		TipoDevolucionEmpresaParameterReturnGeneral  tipodevolucionempresaReturnGeneral =new TipoDevolucionEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipodevolucionempresaReturnGeneral =new TipoDevolucionEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodevolucionempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipodevolucionempresaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoDevolucionEmpresaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetaNotaCreditoSoliLogic detanotacreditosoliLogic=new DetaNotaCreditoSoliLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoDevolucionEmpresaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetaNotaCreditoSoli.class));
											
			

			detanotacreditosoliLogic.setConnexion(this.getConnexion());
			detanotacreditosoliLogic.setDatosCliente(this.datosCliente);
			detanotacreditosoliLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoDevolucionEmpresa tipodevolucionempresa:this.tipodevolucionempresas) {
				

				classes=new ArrayList<Classe>();
				classes=DetaNotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfDetaNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);

				detanotacreditosoliLogic.setDetaNotaCreditoSolis(tipodevolucionempresa.detanotacreditosolis);
				detanotacreditosoliLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoDevolucionEmpresa tipodevolucionempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoDevolucionEmpresaLogicAdditional.updateTipoDevolucionEmpresaToGet(tipodevolucionempresa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodevolucionempresa.setEmpresa(tipodevolucionempresaDataAccess.getEmpresa(connexion,tipodevolucionempresa));
		tipodevolucionempresa.setDetaNotaCreditoSolis(tipodevolucionempresaDataAccess.getDetaNotaCreditoSolis(connexion,tipodevolucionempresa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodevolucionempresa.setEmpresa(tipodevolucionempresaDataAccess.getEmpresa(connexion,tipodevolucionempresa));
				continue;
			}

			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodevolucionempresa.setDetaNotaCreditoSolis(tipodevolucionempresaDataAccess.getDetaNotaCreditoSolis(connexion,tipodevolucionempresa));

				if(this.isConDeep) {
					DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(this.connexion);
					detanotacreditosoliLogic.setDetaNotaCreditoSolis(tipodevolucionempresa.getDetaNotaCreditoSolis());
					ArrayList<Classe> classesLocal=DetaNotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfDetaNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);
					detanotacreditosoliLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(detanotacreditosoliLogic.getDetaNotaCreditoSolis());
					tipodevolucionempresa.setDetaNotaCreditoSolis(detanotacreditosoliLogic.getDetaNotaCreditoSolis());
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
			tipodevolucionempresa.setEmpresa(tipodevolucionempresaDataAccess.getEmpresa(connexion,tipodevolucionempresa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaNotaCreditoSoli.class));
			tipodevolucionempresa.setDetaNotaCreditoSolis(tipodevolucionempresaDataAccess.getDetaNotaCreditoSolis(connexion,tipodevolucionempresa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodevolucionempresa.setEmpresa(tipodevolucionempresaDataAccess.getEmpresa(connexion,tipodevolucionempresa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodevolucionempresa.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipodevolucionempresa.setDetaNotaCreditoSolis(tipodevolucionempresaDataAccess.getDetaNotaCreditoSolis(connexion,tipodevolucionempresa));

		for(DetaNotaCreditoSoli detanotacreditosoli:tipodevolucionempresa.getDetaNotaCreditoSolis()) {
			DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
			detanotacreditosoliLogic.deepLoad(detanotacreditosoli,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodevolucionempresa.setEmpresa(tipodevolucionempresaDataAccess.getEmpresa(connexion,tipodevolucionempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipodevolucionempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodevolucionempresa.setDetaNotaCreditoSolis(tipodevolucionempresaDataAccess.getDetaNotaCreditoSolis(connexion,tipodevolucionempresa));

				for(DetaNotaCreditoSoli detanotacreditosoli:tipodevolucionempresa.getDetaNotaCreditoSolis()) {
					DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
					detanotacreditosoliLogic.deepLoad(detanotacreditosoli,isDeep,deepLoadType,clases);
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
			tipodevolucionempresa.setEmpresa(tipodevolucionempresaDataAccess.getEmpresa(connexion,tipodevolucionempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipodevolucionempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaNotaCreditoSoli.class));
			tipodevolucionempresa.setDetaNotaCreditoSolis(tipodevolucionempresaDataAccess.getDetaNotaCreditoSolis(connexion,tipodevolucionempresa));

			for(DetaNotaCreditoSoli detanotacreditosoli:tipodevolucionempresa.getDetaNotaCreditoSolis()) {
				DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
				detanotacreditosoliLogic.deepLoad(detanotacreditosoli,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoDevolucionEmpresa tipodevolucionempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoDevolucionEmpresaLogicAdditional.updateTipoDevolucionEmpresaToSave(tipodevolucionempresa,this.arrDatoGeneral);
			
TipoDevolucionEmpresaDataAccess.save(tipodevolucionempresa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipodevolucionempresa.getEmpresa(),connexion);

		for(DetaNotaCreditoSoli detanotacreditosoli:tipodevolucionempresa.getDetaNotaCreditoSolis()) {
			detanotacreditosoli.setid_tipo_devolucion_empresa(tipodevolucionempresa.getId());
			DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipodevolucionempresa.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaNotaCreditoSoli detanotacreditosoli:tipodevolucionempresa.getDetaNotaCreditoSolis()) {
					detanotacreditosoli.setid_tipo_devolucion_empresa(tipodevolucionempresa.getId());
					DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipodevolucionempresa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodevolucionempresa.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(DetaNotaCreditoSoli detanotacreditosoli:tipodevolucionempresa.getDetaNotaCreditoSolis()) {
			DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
			detanotacreditosoli.setid_tipo_devolucion_empresa(tipodevolucionempresa.getId());
			DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli,connexion);
			detanotacreditosoliLogic.deepSave(detanotacreditosoli,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipodevolucionempresa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipodevolucionempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaNotaCreditoSoli detanotacreditosoli:tipodevolucionempresa.getDetaNotaCreditoSolis()) {
					DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
					detanotacreditosoli.setid_tipo_devolucion_empresa(tipodevolucionempresa.getId());
					DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli,connexion);
					detanotacreditosoliLogic.deepSave(detanotacreditosoli,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoDevolucionEmpresa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipodevolucionempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(tipodevolucionempresa);
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
			this.deepLoad(this.tipodevolucionempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDevolucionEmpresa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipodevolucionempresas!=null) {
				for(TipoDevolucionEmpresa tipodevolucionempresa:tipodevolucionempresas) {
					this.deepLoad(tipodevolucionempresa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(tipodevolucionempresas);
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
			if(tipodevolucionempresas!=null) {
				for(TipoDevolucionEmpresa tipodevolucionempresa:tipodevolucionempresas) {
					this.deepLoad(tipodevolucionempresa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(tipodevolucionempresas);
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
			this.getNewConnexionToDeep(TipoDevolucionEmpresa.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipodevolucionempresa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoDevolucionEmpresa.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipodevolucionempresas!=null) {
				for(TipoDevolucionEmpresa tipodevolucionempresa:tipodevolucionempresas) {
					this.deepSave(tipodevolucionempresa,isDeep,deepLoadType,clases);
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
			if(tipodevolucionempresas!=null) {
				for(TipoDevolucionEmpresa tipodevolucionempresa:tipodevolucionempresas) {
					this.deepSave(tipodevolucionempresa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoDevolucionEmpresasBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoDevolucionEmpresaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDevolucionEmpresasBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoDevolucionEmpresaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDevolucionEmpresasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoDevolucionEmpresaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDevolucionEmpresasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoDevolucionEmpresaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDevolucionEmpresasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDevolucionEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDevolucionEmpresasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDevolucionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodevolucionempresas=tipodevolucionempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDevolucionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDevolucionEmpresa(this.tipodevolucionempresas);
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
			if(TipoDevolucionEmpresaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDevolucionEmpresaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoDevolucionEmpresa tipodevolucionempresa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoDevolucionEmpresaConstantesFunciones.ISCONAUDITORIA) {
				if(tipodevolucionempresa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDevolucionEmpresaDataAccess.TABLENAME, tipodevolucionempresa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDevolucionEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDevolucionEmpresaLogic.registrarAuditoriaDetallesTipoDevolucionEmpresa(connexion,tipodevolucionempresa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipodevolucionempresa.getIsDeleted()) {
					/*if(!tipodevolucionempresa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoDevolucionEmpresaDataAccess.TABLENAME, tipodevolucionempresa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoDevolucionEmpresaLogic.registrarAuditoriaDetallesTipoDevolucionEmpresa(connexion,tipodevolucionempresa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDevolucionEmpresaDataAccess.TABLENAME, tipodevolucionempresa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipodevolucionempresa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDevolucionEmpresaDataAccess.TABLENAME, tipodevolucionempresa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDevolucionEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDevolucionEmpresaLogic.registrarAuditoriaDetallesTipoDevolucionEmpresa(connexion,tipodevolucionempresa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoDevolucionEmpresa(Connexion connexion,TipoDevolucionEmpresa tipodevolucionempresa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipodevolucionempresa.getIsNew()||!tipodevolucionempresa.getid_empresa().equals(tipodevolucionempresa.getTipoDevolucionEmpresaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodevolucionempresa.getTipoDevolucionEmpresaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipodevolucionempresa.getTipoDevolucionEmpresaOriginal().getid_empresa().toString();
				}
				if(tipodevolucionempresa.getid_empresa()!=null)
				{
					strValorNuevo=tipodevolucionempresa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipodevolucionempresa.getIsNew()||!tipodevolucionempresa.getcodigo().equals(tipodevolucionempresa.getTipoDevolucionEmpresaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodevolucionempresa.getTipoDevolucionEmpresaOriginal().getcodigo()!=null)
				{
					strValorActual=tipodevolucionempresa.getTipoDevolucionEmpresaOriginal().getcodigo();
				}
				if(tipodevolucionempresa.getcodigo()!=null)
				{
					strValorNuevo=tipodevolucionempresa.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDevolucionEmpresaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipodevolucionempresa.getIsNew()||!tipodevolucionempresa.getnombre().equals(tipodevolucionempresa.getTipoDevolucionEmpresaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodevolucionempresa.getTipoDevolucionEmpresaOriginal().getnombre()!=null)
				{
					strValorActual=tipodevolucionempresa.getTipoDevolucionEmpresaOriginal().getnombre();
				}
				if(tipodevolucionempresa.getnombre()!=null)
				{
					strValorNuevo=tipodevolucionempresa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDevolucionEmpresaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipodevolucionempresa.getIsNew()||!tipodevolucionempresa.getesta_activo().equals(tipodevolucionempresa.getTipoDevolucionEmpresaOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodevolucionempresa.getTipoDevolucionEmpresaOriginal().getesta_activo()!=null)
				{
					strValorActual=tipodevolucionempresa.getTipoDevolucionEmpresaOriginal().getesta_activo().toString();
				}
				if(tipodevolucionempresa.getesta_activo()!=null)
				{
					strValorNuevo=tipodevolucionempresa.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDevolucionEmpresaConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoDevolucionEmpresaRelacionesWithConnection(TipoDevolucionEmpresa tipodevolucionempresa,List<DetaNotaCreditoSoli> detanotacreditosolis) throws Exception {

		if(!tipodevolucionempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDevolucionEmpresaRelacionesBase(tipodevolucionempresa,detanotacreditosolis,true);
		}
	}

	public void saveTipoDevolucionEmpresaRelaciones(TipoDevolucionEmpresa tipodevolucionempresa,List<DetaNotaCreditoSoli> detanotacreditosolis)throws Exception {

		if(!tipodevolucionempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDevolucionEmpresaRelacionesBase(tipodevolucionempresa,detanotacreditosolis,false);
		}
	}

	public void saveTipoDevolucionEmpresaRelacionesBase(TipoDevolucionEmpresa tipodevolucionempresa,List<DetaNotaCreditoSoli> detanotacreditosolis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoDevolucionEmpresa-saveRelacionesWithConnection");}
	
			tipodevolucionempresa.setDetaNotaCreditoSolis(detanotacreditosolis);

			this.setTipoDevolucionEmpresa(tipodevolucionempresa);

			if(TipoDevolucionEmpresaLogicAdditional.validarSaveRelaciones(tipodevolucionempresa,this)) {

				TipoDevolucionEmpresaLogicAdditional.updateRelacionesToSave(tipodevolucionempresa,this);

				if((tipodevolucionempresa.getIsNew()||tipodevolucionempresa.getIsChanged())&&!tipodevolucionempresa.getIsDeleted()) {
					this.saveTipoDevolucionEmpresa();
					this.saveTipoDevolucionEmpresaRelacionesDetalles(detanotacreditosolis);

				} else if(tipodevolucionempresa.getIsDeleted()) {
					this.saveTipoDevolucionEmpresaRelacionesDetalles(detanotacreditosolis);
					this.saveTipoDevolucionEmpresa();
				}

				TipoDevolucionEmpresaLogicAdditional.updateRelacionesToSaveAfter(tipodevolucionempresa,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetaNotaCreditoSoliConstantesFunciones.InicializarGeneralEntityAuxiliaresDetaNotaCreditoSolis(detanotacreditosolis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoDevolucionEmpresaRelacionesDetalles(List<DetaNotaCreditoSoli> detanotacreditosolis)throws Exception {
		try {
	

			Long idTipoDevolucionEmpresaActual=this.getTipoDevolucionEmpresa().getId();

			DetaNotaCreditoSoliLogic detanotacreditosoliLogic_Desde_TipoDevolucionEmpresa=new DetaNotaCreditoSoliLogic();
			detanotacreditosoliLogic_Desde_TipoDevolucionEmpresa.setDetaNotaCreditoSolis(detanotacreditosolis);

			detanotacreditosoliLogic_Desde_TipoDevolucionEmpresa.setConnexion(this.getConnexion());
			detanotacreditosoliLogic_Desde_TipoDevolucionEmpresa.setDatosCliente(this.datosCliente);

			for(DetaNotaCreditoSoli detanotacreditosoli_Desde_TipoDevolucionEmpresa:detanotacreditosoliLogic_Desde_TipoDevolucionEmpresa.getDetaNotaCreditoSolis()) {
				detanotacreditosoli_Desde_TipoDevolucionEmpresa.setid_tipo_devolucion_empresa(idTipoDevolucionEmpresaActual);
			}

			detanotacreditosoliLogic_Desde_TipoDevolucionEmpresa.saveDetaNotaCreditoSolis();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDevolucionEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDevolucionEmpresaConstantesFunciones.getClassesForeignKeysOfTipoDevolucionEmpresa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDevolucionEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDevolucionEmpresaConstantesFunciones.getClassesRelationshipsOfTipoDevolucionEmpresa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

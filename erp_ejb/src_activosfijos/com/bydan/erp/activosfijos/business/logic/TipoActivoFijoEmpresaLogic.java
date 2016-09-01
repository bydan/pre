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
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.util.TipoActivoFijoEmpresaConstantesFunciones;
import com.bydan.erp.activosfijos.util.TipoActivoFijoEmpresaParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.TipoActivoFijoEmpresaParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.TipoActivoFijoEmpresa;
import com.bydan.erp.activosfijos.business.logic.TipoActivoFijoEmpresaLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoActivoFijoEmpresaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoActivoFijoEmpresaLogic.class);
	
	protected TipoActivoFijoEmpresaDataAccess tipoactivofijoempresaDataAccess; 	
	protected TipoActivoFijoEmpresa tipoactivofijoempresa;
	protected List<TipoActivoFijoEmpresa> tipoactivofijoempresas;
	protected Object tipoactivofijoempresaObject;	
	protected List<Object> tipoactivofijoempresasObject;
	
	public static ClassValidator<TipoActivoFijoEmpresa> tipoactivofijoempresaValidator = new ClassValidator<TipoActivoFijoEmpresa>(TipoActivoFijoEmpresa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoActivoFijoEmpresaLogicAdditional tipoactivofijoempresaLogicAdditional=null;
	
	public TipoActivoFijoEmpresaLogicAdditional getTipoActivoFijoEmpresaLogicAdditional() {
		return this.tipoactivofijoempresaLogicAdditional;
	}
	
	public void setTipoActivoFijoEmpresaLogicAdditional(TipoActivoFijoEmpresaLogicAdditional tipoactivofijoempresaLogicAdditional) {
		try {
			this.tipoactivofijoempresaLogicAdditional=tipoactivofijoempresaLogicAdditional;
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
	
	
	
	
	public  TipoActivoFijoEmpresaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoactivofijoempresaDataAccess = new TipoActivoFijoEmpresaDataAccess();
			
			this.tipoactivofijoempresas= new ArrayList<TipoActivoFijoEmpresa>();
			this.tipoactivofijoempresa= new TipoActivoFijoEmpresa();
			
			this.tipoactivofijoempresaObject=new Object();
			this.tipoactivofijoempresasObject=new ArrayList<Object>();
				
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
			
			this.tipoactivofijoempresaDataAccess.setConnexionType(this.connexionType);
			this.tipoactivofijoempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoActivoFijoEmpresaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoactivofijoempresaDataAccess = new TipoActivoFijoEmpresaDataAccess();
			this.tipoactivofijoempresas= new ArrayList<TipoActivoFijoEmpresa>();
			this.tipoactivofijoempresa= new TipoActivoFijoEmpresa();
			this.tipoactivofijoempresaObject=new Object();
			this.tipoactivofijoempresasObject=new ArrayList<Object>();
			
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
			
			this.tipoactivofijoempresaDataAccess.setConnexionType(this.connexionType);
			this.tipoactivofijoempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoActivoFijoEmpresa getTipoActivoFijoEmpresa() throws Exception {	
		TipoActivoFijoEmpresaLogicAdditional.checkTipoActivoFijoEmpresaToGet(tipoactivofijoempresa,this.datosCliente,this.arrDatoGeneral);
		TipoActivoFijoEmpresaLogicAdditional.updateTipoActivoFijoEmpresaToGet(tipoactivofijoempresa,this.arrDatoGeneral);
		
		return tipoactivofijoempresa;
	}
		
	public void setTipoActivoFijoEmpresa(TipoActivoFijoEmpresa newTipoActivoFijoEmpresa) {
		this.tipoactivofijoempresa = newTipoActivoFijoEmpresa;
	}
	
	public TipoActivoFijoEmpresaDataAccess getTipoActivoFijoEmpresaDataAccess() {
		return tipoactivofijoempresaDataAccess;
	}
	
	public void setTipoActivoFijoEmpresaDataAccess(TipoActivoFijoEmpresaDataAccess newtipoactivofijoempresaDataAccess) {
		this.tipoactivofijoempresaDataAccess = newtipoactivofijoempresaDataAccess;
	}
	
	public List<TipoActivoFijoEmpresa> getTipoActivoFijoEmpresas() throws Exception {		
		this.quitarTipoActivoFijoEmpresasNulos();
		
		TipoActivoFijoEmpresaLogicAdditional.checkTipoActivoFijoEmpresaToGets(tipoactivofijoempresas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoActivoFijoEmpresa tipoactivofijoempresaLocal: tipoactivofijoempresas ) {
			TipoActivoFijoEmpresaLogicAdditional.updateTipoActivoFijoEmpresaToGet(tipoactivofijoempresaLocal,this.arrDatoGeneral);
		}
		
		return tipoactivofijoempresas;
	}
	
	public void setTipoActivoFijoEmpresas(List<TipoActivoFijoEmpresa> newTipoActivoFijoEmpresas) {
		this.tipoactivofijoempresas = newTipoActivoFijoEmpresas;
	}
	
	public Object getTipoActivoFijoEmpresaObject() {	
		this.tipoactivofijoempresaObject=this.tipoactivofijoempresaDataAccess.getEntityObject();
		return this.tipoactivofijoempresaObject;
	}
		
	public void setTipoActivoFijoEmpresaObject(Object newTipoActivoFijoEmpresaObject) {
		this.tipoactivofijoempresaObject = newTipoActivoFijoEmpresaObject;
	}
	
	public List<Object> getTipoActivoFijoEmpresasObject() {		
		this.tipoactivofijoempresasObject=this.tipoactivofijoempresaDataAccess.getEntitiesObject();
		return this.tipoactivofijoempresasObject;
	}
		
	public void setTipoActivoFijoEmpresasObject(List<Object> newTipoActivoFijoEmpresasObject) {
		this.tipoactivofijoempresasObject = newTipoActivoFijoEmpresasObject;
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
		
		if(this.tipoactivofijoempresaDataAccess!=null) {
			this.tipoactivofijoempresaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoactivofijoempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoactivofijoempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoactivofijoempresa=tipoactivofijoempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoactivofijoempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresa);
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
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		  		  
        try {
			
			tipoactivofijoempresa=tipoactivofijoempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoactivofijoempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoactivofijoempresa=tipoactivofijoempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoactivofijoempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresa);
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
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		  		  
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
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		  		  
        try {
			
			tipoactivofijoempresa=tipoactivofijoempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoactivofijoempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		  		  
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
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoactivofijoempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoactivofijoempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoactivofijoempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoactivofijoempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoactivofijoempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoactivofijoempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoactivofijoempresas = new  ArrayList<TipoActivoFijoEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoactivofijoempresas=tipoactivofijoempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoActivoFijoEmpresa(tipoactivofijoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresas);
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
		tipoactivofijoempresas = new  ArrayList<TipoActivoFijoEmpresa>();
		  		  
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
		tipoactivofijoempresas = new  ArrayList<TipoActivoFijoEmpresa>();
		  		  
        try {			
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoactivofijoempresas=tipoactivofijoempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoActivoFijoEmpresa(tipoactivofijoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoactivofijoempresas = new  ArrayList<TipoActivoFijoEmpresa>();
		  		  
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
		tipoactivofijoempresas = new  ArrayList<TipoActivoFijoEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoactivofijoempresas=tipoactivofijoempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoActivoFijoEmpresa(tipoactivofijoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresas);
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
		tipoactivofijoempresas = new  ArrayList<TipoActivoFijoEmpresa>();
		  		  
        try {
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoactivofijoempresas=tipoactivofijoempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoActivoFijoEmpresa(tipoactivofijoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresas);
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
		tipoactivofijoempresas = new  ArrayList<TipoActivoFijoEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoactivofijoempresas=tipoactivofijoempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoActivoFijoEmpresa(tipoactivofijoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresas);
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
		tipoactivofijoempresas = new  ArrayList<TipoActivoFijoEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoactivofijoempresas=tipoactivofijoempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoActivoFijoEmpresa(tipoactivofijoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoactivofijoempresa=tipoactivofijoempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoActivoFijoEmpresa(tipoactivofijoempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresa);
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
		tipoactivofijoempresa = new  TipoActivoFijoEmpresa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoactivofijoempresa=tipoactivofijoempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoActivoFijoEmpresa(tipoactivofijoempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoactivofijoempresas = new  ArrayList<TipoActivoFijoEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoactivofijoempresas=tipoactivofijoempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoActivoFijoEmpresa(tipoactivofijoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresas);
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
		tipoactivofijoempresas = new  ArrayList<TipoActivoFijoEmpresa>();
		  		  
        try {
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoactivofijoempresas=tipoactivofijoempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoActivoFijoEmpresa(tipoactivofijoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoActivoFijoEmpresasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoactivofijoempresas = new  ArrayList<TipoActivoFijoEmpresa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-getTodosTipoActivoFijoEmpresasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoactivofijoempresas=tipoactivofijoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoActivoFijoEmpresa(tipoactivofijoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresas);
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
	
	public  void  getTodosTipoActivoFijoEmpresas(String sFinalQuery,Pagination pagination)throws Exception {
		tipoactivofijoempresas = new  ArrayList<TipoActivoFijoEmpresa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoactivofijoempresas=tipoactivofijoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoActivoFijoEmpresa(tipoactivofijoempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoActivoFijoEmpresa(TipoActivoFijoEmpresa tipoactivofijoempresa) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoactivofijoempresa.getIsNew() || tipoactivofijoempresa.getIsChanged()) { 
			this.invalidValues = tipoactivofijoempresaValidator.getInvalidValues(tipoactivofijoempresa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoactivofijoempresa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoActivoFijoEmpresa(List<TipoActivoFijoEmpresa> TipoActivoFijoEmpresas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoActivoFijoEmpresa tipoactivofijoempresaLocal:tipoactivofijoempresas) {				
			estaValidadoObjeto=this.validarGuardarTipoActivoFijoEmpresa(tipoactivofijoempresaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoActivoFijoEmpresa(List<TipoActivoFijoEmpresa> TipoActivoFijoEmpresas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoActivoFijoEmpresa(tipoactivofijoempresas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoActivoFijoEmpresa(TipoActivoFijoEmpresa TipoActivoFijoEmpresa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoActivoFijoEmpresa(tipoactivofijoempresa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoActivoFijoEmpresa tipoactivofijoempresa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoactivofijoempresa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoActivoFijoEmpresaConstantesFunciones.getTipoActivoFijoEmpresaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoactivofijoempresa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoActivoFijoEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoActivoFijoEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoActivoFijoEmpresaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-saveTipoActivoFijoEmpresaWithConnection");connexion.begin();			
			
			TipoActivoFijoEmpresaLogicAdditional.checkTipoActivoFijoEmpresaToSave(this.tipoactivofijoempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoActivoFijoEmpresaLogicAdditional.updateTipoActivoFijoEmpresaToSave(this.tipoactivofijoempresa,this.arrDatoGeneral);
			
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoactivofijoempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoActivoFijoEmpresa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoActivoFijoEmpresa(this.tipoactivofijoempresa)) {
				TipoActivoFijoEmpresaDataAccess.save(this.tipoactivofijoempresa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoactivofijoempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoActivoFijoEmpresaLogicAdditional.checkTipoActivoFijoEmpresaToSaveAfter(this.tipoactivofijoempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoActivoFijoEmpresa();
			
			connexion.commit();			
			
			if(this.tipoactivofijoempresa.getIsDeleted()) {
				this.tipoactivofijoempresa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoActivoFijoEmpresa()throws Exception {	
		try {	
			
			TipoActivoFijoEmpresaLogicAdditional.checkTipoActivoFijoEmpresaToSave(this.tipoactivofijoempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoActivoFijoEmpresaLogicAdditional.updateTipoActivoFijoEmpresaToSave(this.tipoactivofijoempresa,this.arrDatoGeneral);
			
			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoactivofijoempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoActivoFijoEmpresa(this.tipoactivofijoempresa)) {			
				TipoActivoFijoEmpresaDataAccess.save(this.tipoactivofijoempresa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoactivofijoempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoActivoFijoEmpresaLogicAdditional.checkTipoActivoFijoEmpresaToSaveAfter(this.tipoactivofijoempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoactivofijoempresa.getIsDeleted()) {
				this.tipoactivofijoempresa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoActivoFijoEmpresasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-saveTipoActivoFijoEmpresasWithConnection");connexion.begin();			
			
			TipoActivoFijoEmpresaLogicAdditional.checkTipoActivoFijoEmpresaToSaves(tipoactivofijoempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoActivoFijoEmpresas();
			
			Boolean validadoTodosTipoActivoFijoEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoActivoFijoEmpresa tipoactivofijoempresaLocal:tipoactivofijoempresas) {		
				if(tipoactivofijoempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoActivoFijoEmpresaLogicAdditional.updateTipoActivoFijoEmpresaToSave(tipoactivofijoempresaLocal,this.arrDatoGeneral);
	        	
				TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoactivofijoempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoActivoFijoEmpresa(tipoactivofijoempresaLocal)) {
					TipoActivoFijoEmpresaDataAccess.save(tipoactivofijoempresaLocal, connexion);				
				} else {
					validadoTodosTipoActivoFijoEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoActivoFijoEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoActivoFijoEmpresaLogicAdditional.checkTipoActivoFijoEmpresaToSavesAfter(tipoactivofijoempresas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoActivoFijoEmpresas();
			
			connexion.commit();		
			
			this.quitarTipoActivoFijoEmpresasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoActivoFijoEmpresas()throws Exception {				
		 try {	
			TipoActivoFijoEmpresaLogicAdditional.checkTipoActivoFijoEmpresaToSaves(tipoactivofijoempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoActivoFijoEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoActivoFijoEmpresa tipoactivofijoempresaLocal:tipoactivofijoempresas) {				
				if(tipoactivofijoempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoActivoFijoEmpresaLogicAdditional.updateTipoActivoFijoEmpresaToSave(tipoactivofijoempresaLocal,this.arrDatoGeneral);
	        	
				TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoactivofijoempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoActivoFijoEmpresa(tipoactivofijoempresaLocal)) {				
					TipoActivoFijoEmpresaDataAccess.save(tipoactivofijoempresaLocal, connexion);				
				} else {
					validadoTodosTipoActivoFijoEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoActivoFijoEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoActivoFijoEmpresaLogicAdditional.checkTipoActivoFijoEmpresaToSavesAfter(tipoactivofijoempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoActivoFijoEmpresasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoActivoFijoEmpresaParameterReturnGeneral procesarAccionTipoActivoFijoEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoActivoFijoEmpresa> tipoactivofijoempresas,TipoActivoFijoEmpresaParameterReturnGeneral tipoactivofijoempresaParameterGeneral)throws Exception {
		 try {	
			TipoActivoFijoEmpresaParameterReturnGeneral tipoactivofijoempresaReturnGeneral=new TipoActivoFijoEmpresaParameterReturnGeneral();
	
			TipoActivoFijoEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoactivofijoempresas,tipoactivofijoempresaParameterGeneral,tipoactivofijoempresaReturnGeneral);
			
			return tipoactivofijoempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoActivoFijoEmpresaParameterReturnGeneral procesarAccionTipoActivoFijoEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoActivoFijoEmpresa> tipoactivofijoempresas,TipoActivoFijoEmpresaParameterReturnGeneral tipoactivofijoempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-procesarAccionTipoActivoFijoEmpresasWithConnection");connexion.begin();			
			
			TipoActivoFijoEmpresaParameterReturnGeneral tipoactivofijoempresaReturnGeneral=new TipoActivoFijoEmpresaParameterReturnGeneral();
	
			TipoActivoFijoEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoactivofijoempresas,tipoactivofijoempresaParameterGeneral,tipoactivofijoempresaReturnGeneral);
			
			this.connexion.commit();
			
			return tipoactivofijoempresaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoActivoFijoEmpresaParameterReturnGeneral procesarEventosTipoActivoFijoEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoActivoFijoEmpresa> tipoactivofijoempresas,TipoActivoFijoEmpresa tipoactivofijoempresa,TipoActivoFijoEmpresaParameterReturnGeneral tipoactivofijoempresaParameterGeneral,Boolean isEsNuevoTipoActivoFijoEmpresa,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoActivoFijoEmpresaParameterReturnGeneral tipoactivofijoempresaReturnGeneral=new TipoActivoFijoEmpresaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoactivofijoempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoActivoFijoEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoactivofijoempresas,tipoactivofijoempresa,tipoactivofijoempresaParameterGeneral,tipoactivofijoempresaReturnGeneral,isEsNuevoTipoActivoFijoEmpresa,clases);
			
			return tipoactivofijoempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoActivoFijoEmpresaParameterReturnGeneral procesarEventosTipoActivoFijoEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoActivoFijoEmpresa> tipoactivofijoempresas,TipoActivoFijoEmpresa tipoactivofijoempresa,TipoActivoFijoEmpresaParameterReturnGeneral tipoactivofijoempresaParameterGeneral,Boolean isEsNuevoTipoActivoFijoEmpresa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-procesarEventosTipoActivoFijoEmpresasWithConnection");connexion.begin();			
			
			TipoActivoFijoEmpresaParameterReturnGeneral tipoactivofijoempresaReturnGeneral=new TipoActivoFijoEmpresaParameterReturnGeneral();
	
			tipoactivofijoempresaReturnGeneral.setTipoActivoFijoEmpresa(tipoactivofijoempresa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoactivofijoempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoActivoFijoEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoactivofijoempresas,tipoactivofijoempresa,tipoactivofijoempresaParameterGeneral,tipoactivofijoempresaReturnGeneral,isEsNuevoTipoActivoFijoEmpresa,clases);
			
			this.connexion.commit();
			
			return tipoactivofijoempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoActivoFijoEmpresaParameterReturnGeneral procesarImportacionTipoActivoFijoEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoActivoFijoEmpresaParameterReturnGeneral tipoactivofijoempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-procesarImportacionTipoActivoFijoEmpresasWithConnection");connexion.begin();			
			
			TipoActivoFijoEmpresaParameterReturnGeneral tipoactivofijoempresaReturnGeneral=new TipoActivoFijoEmpresaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoactivofijoempresas=new ArrayList<TipoActivoFijoEmpresa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoactivofijoempresa=new TipoActivoFijoEmpresa();
				
				
				if(conColumnasBase) {this.tipoactivofijoempresa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoactivofijoempresa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoactivofijoempresa.setcodigo(arrColumnas[iColumn++]);
				this.tipoactivofijoempresa.setnombre(arrColumnas[iColumn++]);
				
				this.tipoactivofijoempresas.add(this.tipoactivofijoempresa);
			}
			
			this.saveTipoActivoFijoEmpresas();
			
			this.connexion.commit();
			
			tipoactivofijoempresaReturnGeneral.setConRetornoEstaProcesado(true);
			tipoactivofijoempresaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoactivofijoempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoActivoFijoEmpresasEliminados() throws Exception {				
		
		List<TipoActivoFijoEmpresa> tipoactivofijoempresasAux= new ArrayList<TipoActivoFijoEmpresa>();
		
		for(TipoActivoFijoEmpresa tipoactivofijoempresa:tipoactivofijoempresas) {
			if(!tipoactivofijoempresa.getIsDeleted()) {
				tipoactivofijoempresasAux.add(tipoactivofijoempresa);
			}
		}
		
		tipoactivofijoempresas=tipoactivofijoempresasAux;
	}
	
	public void quitarTipoActivoFijoEmpresasNulos() throws Exception {				
		
		List<TipoActivoFijoEmpresa> tipoactivofijoempresasAux= new ArrayList<TipoActivoFijoEmpresa>();
		
		for(TipoActivoFijoEmpresa tipoactivofijoempresa : this.tipoactivofijoempresas) {
			if(tipoactivofijoempresa==null) {
				tipoactivofijoempresasAux.add(tipoactivofijoempresa);
			}
		}
		
		//this.tipoactivofijoempresas=tipoactivofijoempresasAux;
		
		this.tipoactivofijoempresas.removeAll(tipoactivofijoempresasAux);
	}
	
	public void getSetVersionRowTipoActivoFijoEmpresaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoactivofijoempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoactivofijoempresa.getIsDeleted() || (tipoactivofijoempresa.getIsChanged()&&!tipoactivofijoempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoactivofijoempresaDataAccess.getSetVersionRowTipoActivoFijoEmpresa(connexion,tipoactivofijoempresa.getId());
				
				if(!tipoactivofijoempresa.getVersionRow().equals(timestamp)) {	
					tipoactivofijoempresa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoactivofijoempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoActivoFijoEmpresa()throws Exception {	
		
		if(tipoactivofijoempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoactivofijoempresa.getIsDeleted() || (tipoactivofijoempresa.getIsChanged()&&!tipoactivofijoempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoactivofijoempresaDataAccess.getSetVersionRowTipoActivoFijoEmpresa(connexion,tipoactivofijoempresa.getId());
			
			try {							
				if(!tipoactivofijoempresa.getVersionRow().equals(timestamp)) {	
					tipoactivofijoempresa.setVersionRow(timestamp);
				}
				
				tipoactivofijoempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoActivoFijoEmpresasWithConnection()throws Exception {	
		if(tipoactivofijoempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoActivoFijoEmpresa tipoactivofijoempresaAux:tipoactivofijoempresas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoactivofijoempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoactivofijoempresaAux.getIsDeleted() || (tipoactivofijoempresaAux.getIsChanged()&&!tipoactivofijoempresaAux.getIsNew())) {
						
						timestamp=tipoactivofijoempresaDataAccess.getSetVersionRowTipoActivoFijoEmpresa(connexion,tipoactivofijoempresaAux.getId());
						
						if(!tipoactivofijoempresa.getVersionRow().equals(timestamp)) {	
							tipoactivofijoempresaAux.setVersionRow(timestamp);
						}
								
						tipoactivofijoempresaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoActivoFijoEmpresas()throws Exception {	
		if(tipoactivofijoempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoActivoFijoEmpresa tipoactivofijoempresaAux:tipoactivofijoempresas) {
					if(tipoactivofijoempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoactivofijoempresaAux.getIsDeleted() || (tipoactivofijoempresaAux.getIsChanged()&&!tipoactivofijoempresaAux.getIsNew())) {
						
						timestamp=tipoactivofijoempresaDataAccess.getSetVersionRowTipoActivoFijoEmpresa(connexion,tipoactivofijoempresaAux.getId());
						
						if(!tipoactivofijoempresaAux.getVersionRow().equals(timestamp)) {	
							tipoactivofijoempresaAux.setVersionRow(timestamp);
						}
						
													
						tipoactivofijoempresaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoActivoFijoEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoActivoFijoEmpresaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoActivoFijoEmpresaParameterReturnGeneral  tipoactivofijoempresaReturnGeneral =new TipoActivoFijoEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoActivoFijoEmpresaWithConnection");connexion.begin();
			
			tipoactivofijoempresaReturnGeneral =new TipoActivoFijoEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoactivofijoempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoactivofijoempresaReturnGeneral;
	}
	
	public TipoActivoFijoEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoActivoFijoEmpresa(String finalQueryGlobalEmpresa) throws Exception {
		TipoActivoFijoEmpresaParameterReturnGeneral  tipoactivofijoempresaReturnGeneral =new TipoActivoFijoEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoactivofijoempresaReturnGeneral =new TipoActivoFijoEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoactivofijoempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoactivofijoempresaReturnGeneral;
	}
	
	
	public void deepLoad(TipoActivoFijoEmpresa tipoactivofijoempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoActivoFijoEmpresaLogicAdditional.updateTipoActivoFijoEmpresaToGet(tipoactivofijoempresa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoactivofijoempresa.setEmpresa(tipoactivofijoempresaDataAccess.getEmpresa(connexion,tipoactivofijoempresa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoactivofijoempresa.setEmpresa(tipoactivofijoempresaDataAccess.getEmpresa(connexion,tipoactivofijoempresa));
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
			tipoactivofijoempresa.setEmpresa(tipoactivofijoempresaDataAccess.getEmpresa(connexion,tipoactivofijoempresa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoactivofijoempresa.setEmpresa(tipoactivofijoempresaDataAccess.getEmpresa(connexion,tipoactivofijoempresa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoactivofijoempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoactivofijoempresa.setEmpresa(tipoactivofijoempresaDataAccess.getEmpresa(connexion,tipoactivofijoempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoactivofijoempresa.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tipoactivofijoempresa.setEmpresa(tipoactivofijoempresaDataAccess.getEmpresa(connexion,tipoactivofijoempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoactivofijoempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoActivoFijoEmpresa tipoactivofijoempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoActivoFijoEmpresaLogicAdditional.updateTipoActivoFijoEmpresaToSave(tipoactivofijoempresa,this.arrDatoGeneral);
			
TipoActivoFijoEmpresaDataAccess.save(tipoactivofijoempresa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoactivofijoempresa.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoactivofijoempresa.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoactivofijoempresa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoactivofijoempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoactivofijoempresa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoactivofijoempresa.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoActivoFijoEmpresa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoactivofijoempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(tipoactivofijoempresa);
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
			this.deepLoad(this.tipoactivofijoempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoActivoFijoEmpresa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoactivofijoempresas!=null) {
				for(TipoActivoFijoEmpresa tipoactivofijoempresa:tipoactivofijoempresas) {
					this.deepLoad(tipoactivofijoempresa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(tipoactivofijoempresas);
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
			if(tipoactivofijoempresas!=null) {
				for(TipoActivoFijoEmpresa tipoactivofijoempresa:tipoactivofijoempresas) {
					this.deepLoad(tipoactivofijoempresa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(tipoactivofijoempresas);
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
			this.getNewConnexionToDeep(TipoActivoFijoEmpresa.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoactivofijoempresa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoActivoFijoEmpresa.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoactivofijoempresas!=null) {
				for(TipoActivoFijoEmpresa tipoactivofijoempresa:tipoactivofijoempresas) {
					this.deepSave(tipoactivofijoempresa,isDeep,deepLoadType,clases);
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
			if(tipoactivofijoempresas!=null) {
				for(TipoActivoFijoEmpresa tipoactivofijoempresa:tipoactivofijoempresas) {
					this.deepSave(tipoactivofijoempresa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoActivoFijoEmpresasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoActivoFijoEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoActivoFijoEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoactivofijoempresas=tipoactivofijoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoActivoFijoEmpresasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoActivoFijoEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoActivoFijoEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoactivofijoempresas=tipoactivofijoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoActivoFijoEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoActivoFijoEmpresa(this.tipoactivofijoempresas);
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
			if(TipoActivoFijoEmpresaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoActivoFijoEmpresaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoActivoFijoEmpresa tipoactivofijoempresa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoActivoFijoEmpresaConstantesFunciones.ISCONAUDITORIA) {
				if(tipoactivofijoempresa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoActivoFijoEmpresaDataAccess.TABLENAME, tipoactivofijoempresa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoActivoFijoEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoActivoFijoEmpresaLogic.registrarAuditoriaDetallesTipoActivoFijoEmpresa(connexion,tipoactivofijoempresa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoactivofijoempresa.getIsDeleted()) {
					/*if(!tipoactivofijoempresa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoActivoFijoEmpresaDataAccess.TABLENAME, tipoactivofijoempresa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoActivoFijoEmpresaLogic.registrarAuditoriaDetallesTipoActivoFijoEmpresa(connexion,tipoactivofijoempresa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoActivoFijoEmpresaDataAccess.TABLENAME, tipoactivofijoempresa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoactivofijoempresa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoActivoFijoEmpresaDataAccess.TABLENAME, tipoactivofijoempresa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoActivoFijoEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoActivoFijoEmpresaLogic.registrarAuditoriaDetallesTipoActivoFijoEmpresa(connexion,tipoactivofijoempresa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoActivoFijoEmpresa(Connexion connexion,TipoActivoFijoEmpresa tipoactivofijoempresa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoactivofijoempresa.getIsNew()||!tipoactivofijoempresa.getid_empresa().equals(tipoactivofijoempresa.getTipoActivoFijoEmpresaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoactivofijoempresa.getTipoActivoFijoEmpresaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoactivofijoempresa.getTipoActivoFijoEmpresaOriginal().getid_empresa().toString();
				}
				if(tipoactivofijoempresa.getid_empresa()!=null)
				{
					strValorNuevo=tipoactivofijoempresa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoActivoFijoEmpresaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoactivofijoempresa.getIsNew()||!tipoactivofijoempresa.getcodigo().equals(tipoactivofijoempresa.getTipoActivoFijoEmpresaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoactivofijoempresa.getTipoActivoFijoEmpresaOriginal().getcodigo()!=null)
				{
					strValorActual=tipoactivofijoempresa.getTipoActivoFijoEmpresaOriginal().getcodigo();
				}
				if(tipoactivofijoempresa.getcodigo()!=null)
				{
					strValorNuevo=tipoactivofijoempresa.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoActivoFijoEmpresaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoactivofijoempresa.getIsNew()||!tipoactivofijoempresa.getnombre().equals(tipoactivofijoempresa.getTipoActivoFijoEmpresaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoactivofijoempresa.getTipoActivoFijoEmpresaOriginal().getnombre()!=null)
				{
					strValorActual=tipoactivofijoempresa.getTipoActivoFijoEmpresaOriginal().getnombre();
				}
				if(tipoactivofijoempresa.getnombre()!=null)
				{
					strValorNuevo=tipoactivofijoempresa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoActivoFijoEmpresaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoActivoFijoEmpresaRelacionesWithConnection(TipoActivoFijoEmpresa tipoactivofijoempresa) throws Exception {

		if(!tipoactivofijoempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoActivoFijoEmpresaRelacionesBase(tipoactivofijoempresa,true);
		}
	}

	public void saveTipoActivoFijoEmpresaRelaciones(TipoActivoFijoEmpresa tipoactivofijoempresa)throws Exception {

		if(!tipoactivofijoempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoActivoFijoEmpresaRelacionesBase(tipoactivofijoempresa,false);
		}
	}

	public void saveTipoActivoFijoEmpresaRelacionesBase(TipoActivoFijoEmpresa tipoactivofijoempresa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoActivoFijoEmpresa-saveRelacionesWithConnection");}
	

			this.setTipoActivoFijoEmpresa(tipoactivofijoempresa);

			if(TipoActivoFijoEmpresaLogicAdditional.validarSaveRelaciones(tipoactivofijoempresa,this)) {

				TipoActivoFijoEmpresaLogicAdditional.updateRelacionesToSave(tipoactivofijoempresa,this);

				if((tipoactivofijoempresa.getIsNew()||tipoactivofijoempresa.getIsChanged())&&!tipoactivofijoempresa.getIsDeleted()) {
					this.saveTipoActivoFijoEmpresa();
					this.saveTipoActivoFijoEmpresaRelacionesDetalles();

				} else if(tipoactivofijoempresa.getIsDeleted()) {
					this.saveTipoActivoFijoEmpresaRelacionesDetalles();
					this.saveTipoActivoFijoEmpresa();
				}

				TipoActivoFijoEmpresaLogicAdditional.updateRelacionesToSaveAfter(tipoactivofijoempresa,this);

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
	
	
	private void saveTipoActivoFijoEmpresaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoActivoFijoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoActivoFijoEmpresaConstantesFunciones.getClassesForeignKeysOfTipoActivoFijoEmpresa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoActivoFijoEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoActivoFijoEmpresaConstantesFunciones.getClassesRelationshipsOfTipoActivoFijoEmpresa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

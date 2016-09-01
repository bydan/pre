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
import com.bydan.erp.cartera.util.TipoGarantiaEmpresaConstantesFunciones;
import com.bydan.erp.cartera.util.TipoGarantiaEmpresaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoGarantiaEmpresaParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoGarantiaEmpresa;
import com.bydan.erp.cartera.business.logic.TipoGarantiaEmpresaLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoGarantiaEmpresaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoGarantiaEmpresaLogic.class);
	
	protected TipoGarantiaEmpresaDataAccess tipogarantiaempresaDataAccess; 	
	protected TipoGarantiaEmpresa tipogarantiaempresa;
	protected List<TipoGarantiaEmpresa> tipogarantiaempresas;
	protected Object tipogarantiaempresaObject;	
	protected List<Object> tipogarantiaempresasObject;
	
	public static ClassValidator<TipoGarantiaEmpresa> tipogarantiaempresaValidator = new ClassValidator<TipoGarantiaEmpresa>(TipoGarantiaEmpresa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoGarantiaEmpresaLogicAdditional tipogarantiaempresaLogicAdditional=null;
	
	public TipoGarantiaEmpresaLogicAdditional getTipoGarantiaEmpresaLogicAdditional() {
		return this.tipogarantiaempresaLogicAdditional;
	}
	
	public void setTipoGarantiaEmpresaLogicAdditional(TipoGarantiaEmpresaLogicAdditional tipogarantiaempresaLogicAdditional) {
		try {
			this.tipogarantiaempresaLogicAdditional=tipogarantiaempresaLogicAdditional;
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
	
	
	
	
	public  TipoGarantiaEmpresaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipogarantiaempresaDataAccess = new TipoGarantiaEmpresaDataAccess();
			
			this.tipogarantiaempresas= new ArrayList<TipoGarantiaEmpresa>();
			this.tipogarantiaempresa= new TipoGarantiaEmpresa();
			
			this.tipogarantiaempresaObject=new Object();
			this.tipogarantiaempresasObject=new ArrayList<Object>();
				
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
			
			this.tipogarantiaempresaDataAccess.setConnexionType(this.connexionType);
			this.tipogarantiaempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoGarantiaEmpresaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipogarantiaempresaDataAccess = new TipoGarantiaEmpresaDataAccess();
			this.tipogarantiaempresas= new ArrayList<TipoGarantiaEmpresa>();
			this.tipogarantiaempresa= new TipoGarantiaEmpresa();
			this.tipogarantiaempresaObject=new Object();
			this.tipogarantiaempresasObject=new ArrayList<Object>();
			
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
			
			this.tipogarantiaempresaDataAccess.setConnexionType(this.connexionType);
			this.tipogarantiaempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoGarantiaEmpresa getTipoGarantiaEmpresa() throws Exception {	
		TipoGarantiaEmpresaLogicAdditional.checkTipoGarantiaEmpresaToGet(tipogarantiaempresa,this.datosCliente,this.arrDatoGeneral);
		TipoGarantiaEmpresaLogicAdditional.updateTipoGarantiaEmpresaToGet(tipogarantiaempresa,this.arrDatoGeneral);
		
		return tipogarantiaempresa;
	}
		
	public void setTipoGarantiaEmpresa(TipoGarantiaEmpresa newTipoGarantiaEmpresa) {
		this.tipogarantiaempresa = newTipoGarantiaEmpresa;
	}
	
	public TipoGarantiaEmpresaDataAccess getTipoGarantiaEmpresaDataAccess() {
		return tipogarantiaempresaDataAccess;
	}
	
	public void setTipoGarantiaEmpresaDataAccess(TipoGarantiaEmpresaDataAccess newtipogarantiaempresaDataAccess) {
		this.tipogarantiaempresaDataAccess = newtipogarantiaempresaDataAccess;
	}
	
	public List<TipoGarantiaEmpresa> getTipoGarantiaEmpresas() throws Exception {		
		this.quitarTipoGarantiaEmpresasNulos();
		
		TipoGarantiaEmpresaLogicAdditional.checkTipoGarantiaEmpresaToGets(tipogarantiaempresas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoGarantiaEmpresa tipogarantiaempresaLocal: tipogarantiaempresas ) {
			TipoGarantiaEmpresaLogicAdditional.updateTipoGarantiaEmpresaToGet(tipogarantiaempresaLocal,this.arrDatoGeneral);
		}
		
		return tipogarantiaempresas;
	}
	
	public void setTipoGarantiaEmpresas(List<TipoGarantiaEmpresa> newTipoGarantiaEmpresas) {
		this.tipogarantiaempresas = newTipoGarantiaEmpresas;
	}
	
	public Object getTipoGarantiaEmpresaObject() {	
		this.tipogarantiaempresaObject=this.tipogarantiaempresaDataAccess.getEntityObject();
		return this.tipogarantiaempresaObject;
	}
		
	public void setTipoGarantiaEmpresaObject(Object newTipoGarantiaEmpresaObject) {
		this.tipogarantiaempresaObject = newTipoGarantiaEmpresaObject;
	}
	
	public List<Object> getTipoGarantiaEmpresasObject() {		
		this.tipogarantiaempresasObject=this.tipogarantiaempresaDataAccess.getEntitiesObject();
		return this.tipogarantiaempresasObject;
	}
		
	public void setTipoGarantiaEmpresasObject(List<Object> newTipoGarantiaEmpresasObject) {
		this.tipogarantiaempresasObject = newTipoGarantiaEmpresasObject;
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
		
		if(this.tipogarantiaempresaDataAccess!=null) {
			this.tipogarantiaempresaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipogarantiaempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipogarantiaempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogarantiaempresa=tipogarantiaempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogarantiaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresa);
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
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		  		  
        try {
			
			tipogarantiaempresa=tipogarantiaempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogarantiaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogarantiaempresa=tipogarantiaempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogarantiaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresa);
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
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		  		  
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
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		  		  
        try {
			
			tipogarantiaempresa=tipogarantiaempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogarantiaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		  		  
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
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipogarantiaempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipogarantiaempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipogarantiaempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipogarantiaempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipogarantiaempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipogarantiaempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogarantiaempresas = new  ArrayList<TipoGarantiaEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGarantiaEmpresa(tipogarantiaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
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
		tipogarantiaempresas = new  ArrayList<TipoGarantiaEmpresa>();
		  		  
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
		tipogarantiaempresas = new  ArrayList<TipoGarantiaEmpresa>();
		  		  
        try {			
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoGarantiaEmpresa(tipogarantiaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipogarantiaempresas = new  ArrayList<TipoGarantiaEmpresa>();
		  		  
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
		tipogarantiaempresas = new  ArrayList<TipoGarantiaEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGarantiaEmpresa(tipogarantiaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
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
		tipogarantiaempresas = new  ArrayList<TipoGarantiaEmpresa>();
		  		  
        try {
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGarantiaEmpresa(tipogarantiaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
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
		tipogarantiaempresas = new  ArrayList<TipoGarantiaEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGarantiaEmpresa(tipogarantiaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
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
		tipogarantiaempresas = new  ArrayList<TipoGarantiaEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGarantiaEmpresa(tipogarantiaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogarantiaempresa=tipogarantiaempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGarantiaEmpresa(tipogarantiaempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresa);
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
		tipogarantiaempresa = new  TipoGarantiaEmpresa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogarantiaempresa=tipogarantiaempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGarantiaEmpresa(tipogarantiaempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogarantiaempresas = new  ArrayList<TipoGarantiaEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGarantiaEmpresa(tipogarantiaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
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
		tipogarantiaempresas = new  ArrayList<TipoGarantiaEmpresa>();
		  		  
        try {
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGarantiaEmpresa(tipogarantiaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoGarantiaEmpresasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipogarantiaempresas = new  ArrayList<TipoGarantiaEmpresa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getTodosTipoGarantiaEmpresasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGarantiaEmpresa(tipogarantiaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
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
	
	public  void  getTodosTipoGarantiaEmpresas(String sFinalQuery,Pagination pagination)throws Exception {
		tipogarantiaempresas = new  ArrayList<TipoGarantiaEmpresa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGarantiaEmpresa(tipogarantiaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoGarantiaEmpresa(TipoGarantiaEmpresa tipogarantiaempresa) throws Exception {
		Boolean estaValidado=false;
		
		if(tipogarantiaempresa.getIsNew() || tipogarantiaempresa.getIsChanged()) { 
			this.invalidValues = tipogarantiaempresaValidator.getInvalidValues(tipogarantiaempresa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipogarantiaempresa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoGarantiaEmpresa(List<TipoGarantiaEmpresa> TipoGarantiaEmpresas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoGarantiaEmpresa tipogarantiaempresaLocal:tipogarantiaempresas) {				
			estaValidadoObjeto=this.validarGuardarTipoGarantiaEmpresa(tipogarantiaempresaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoGarantiaEmpresa(List<TipoGarantiaEmpresa> TipoGarantiaEmpresas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGarantiaEmpresa(tipogarantiaempresas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoGarantiaEmpresa(TipoGarantiaEmpresa TipoGarantiaEmpresa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGarantiaEmpresa(tipogarantiaempresa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoGarantiaEmpresa tipogarantiaempresa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipogarantiaempresa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoGarantiaEmpresaConstantesFunciones.getTipoGarantiaEmpresaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipogarantiaempresa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoGarantiaEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoGarantiaEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoGarantiaEmpresaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-saveTipoGarantiaEmpresaWithConnection");connexion.begin();			
			
			TipoGarantiaEmpresaLogicAdditional.checkTipoGarantiaEmpresaToSave(this.tipogarantiaempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoGarantiaEmpresaLogicAdditional.updateTipoGarantiaEmpresaToSave(this.tipogarantiaempresa,this.arrDatoGeneral);
			
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogarantiaempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoGarantiaEmpresa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGarantiaEmpresa(this.tipogarantiaempresa)) {
				TipoGarantiaEmpresaDataAccess.save(this.tipogarantiaempresa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipogarantiaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoGarantiaEmpresaLogicAdditional.checkTipoGarantiaEmpresaToSaveAfter(this.tipogarantiaempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGarantiaEmpresa();
			
			connexion.commit();			
			
			if(this.tipogarantiaempresa.getIsDeleted()) {
				this.tipogarantiaempresa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoGarantiaEmpresa()throws Exception {	
		try {	
			
			TipoGarantiaEmpresaLogicAdditional.checkTipoGarantiaEmpresaToSave(this.tipogarantiaempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoGarantiaEmpresaLogicAdditional.updateTipoGarantiaEmpresaToSave(this.tipogarantiaempresa,this.arrDatoGeneral);
			
			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogarantiaempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGarantiaEmpresa(this.tipogarantiaempresa)) {			
				TipoGarantiaEmpresaDataAccess.save(this.tipogarantiaempresa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipogarantiaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoGarantiaEmpresaLogicAdditional.checkTipoGarantiaEmpresaToSaveAfter(this.tipogarantiaempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipogarantiaempresa.getIsDeleted()) {
				this.tipogarantiaempresa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoGarantiaEmpresasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-saveTipoGarantiaEmpresasWithConnection");connexion.begin();			
			
			TipoGarantiaEmpresaLogicAdditional.checkTipoGarantiaEmpresaToSaves(tipogarantiaempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoGarantiaEmpresas();
			
			Boolean validadoTodosTipoGarantiaEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGarantiaEmpresa tipogarantiaempresaLocal:tipogarantiaempresas) {		
				if(tipogarantiaempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoGarantiaEmpresaLogicAdditional.updateTipoGarantiaEmpresaToSave(tipogarantiaempresaLocal,this.arrDatoGeneral);
	        	
				TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogarantiaempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGarantiaEmpresa(tipogarantiaempresaLocal)) {
					TipoGarantiaEmpresaDataAccess.save(tipogarantiaempresaLocal, connexion);				
				} else {
					validadoTodosTipoGarantiaEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoGarantiaEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoGarantiaEmpresaLogicAdditional.checkTipoGarantiaEmpresaToSavesAfter(tipogarantiaempresas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGarantiaEmpresas();
			
			connexion.commit();		
			
			this.quitarTipoGarantiaEmpresasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoGarantiaEmpresas()throws Exception {				
		 try {	
			TipoGarantiaEmpresaLogicAdditional.checkTipoGarantiaEmpresaToSaves(tipogarantiaempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoGarantiaEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGarantiaEmpresa tipogarantiaempresaLocal:tipogarantiaempresas) {				
				if(tipogarantiaempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoGarantiaEmpresaLogicAdditional.updateTipoGarantiaEmpresaToSave(tipogarantiaempresaLocal,this.arrDatoGeneral);
	        	
				TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogarantiaempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGarantiaEmpresa(tipogarantiaempresaLocal)) {				
					TipoGarantiaEmpresaDataAccess.save(tipogarantiaempresaLocal, connexion);				
				} else {
					validadoTodosTipoGarantiaEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoGarantiaEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoGarantiaEmpresaLogicAdditional.checkTipoGarantiaEmpresaToSavesAfter(tipogarantiaempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoGarantiaEmpresasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGarantiaEmpresaParameterReturnGeneral procesarAccionTipoGarantiaEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGarantiaEmpresa> tipogarantiaempresas,TipoGarantiaEmpresaParameterReturnGeneral tipogarantiaempresaParameterGeneral)throws Exception {
		 try {	
			TipoGarantiaEmpresaParameterReturnGeneral tipogarantiaempresaReturnGeneral=new TipoGarantiaEmpresaParameterReturnGeneral();
	
			TipoGarantiaEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipogarantiaempresas,tipogarantiaempresaParameterGeneral,tipogarantiaempresaReturnGeneral);
			
			return tipogarantiaempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGarantiaEmpresaParameterReturnGeneral procesarAccionTipoGarantiaEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGarantiaEmpresa> tipogarantiaempresas,TipoGarantiaEmpresaParameterReturnGeneral tipogarantiaempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-procesarAccionTipoGarantiaEmpresasWithConnection");connexion.begin();			
			
			TipoGarantiaEmpresaParameterReturnGeneral tipogarantiaempresaReturnGeneral=new TipoGarantiaEmpresaParameterReturnGeneral();
	
			TipoGarantiaEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipogarantiaempresas,tipogarantiaempresaParameterGeneral,tipogarantiaempresaReturnGeneral);
			
			this.connexion.commit();
			
			return tipogarantiaempresaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGarantiaEmpresaParameterReturnGeneral procesarEventosTipoGarantiaEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGarantiaEmpresa> tipogarantiaempresas,TipoGarantiaEmpresa tipogarantiaempresa,TipoGarantiaEmpresaParameterReturnGeneral tipogarantiaempresaParameterGeneral,Boolean isEsNuevoTipoGarantiaEmpresa,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoGarantiaEmpresaParameterReturnGeneral tipogarantiaempresaReturnGeneral=new TipoGarantiaEmpresaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogarantiaempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoGarantiaEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipogarantiaempresas,tipogarantiaempresa,tipogarantiaempresaParameterGeneral,tipogarantiaempresaReturnGeneral,isEsNuevoTipoGarantiaEmpresa,clases);
			
			return tipogarantiaempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoGarantiaEmpresaParameterReturnGeneral procesarEventosTipoGarantiaEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGarantiaEmpresa> tipogarantiaempresas,TipoGarantiaEmpresa tipogarantiaempresa,TipoGarantiaEmpresaParameterReturnGeneral tipogarantiaempresaParameterGeneral,Boolean isEsNuevoTipoGarantiaEmpresa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-procesarEventosTipoGarantiaEmpresasWithConnection");connexion.begin();			
			
			TipoGarantiaEmpresaParameterReturnGeneral tipogarantiaempresaReturnGeneral=new TipoGarantiaEmpresaParameterReturnGeneral();
	
			tipogarantiaempresaReturnGeneral.setTipoGarantiaEmpresa(tipogarantiaempresa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogarantiaempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoGarantiaEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipogarantiaempresas,tipogarantiaempresa,tipogarantiaempresaParameterGeneral,tipogarantiaempresaReturnGeneral,isEsNuevoTipoGarantiaEmpresa,clases);
			
			this.connexion.commit();
			
			return tipogarantiaempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGarantiaEmpresaParameterReturnGeneral procesarImportacionTipoGarantiaEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoGarantiaEmpresaParameterReturnGeneral tipogarantiaempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-procesarImportacionTipoGarantiaEmpresasWithConnection");connexion.begin();			
			
			TipoGarantiaEmpresaParameterReturnGeneral tipogarantiaempresaReturnGeneral=new TipoGarantiaEmpresaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipogarantiaempresas=new ArrayList<TipoGarantiaEmpresa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipogarantiaempresa=new TipoGarantiaEmpresa();
				
				
				if(conColumnasBase) {this.tipogarantiaempresa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipogarantiaempresa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipogarantiaempresa.setcodigo(arrColumnas[iColumn++]);
				this.tipogarantiaempresa.setnombre(arrColumnas[iColumn++]);
				this.tipogarantiaempresa.setes_defecto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tipogarantiaempresas.add(this.tipogarantiaempresa);
			}
			
			this.saveTipoGarantiaEmpresas();
			
			this.connexion.commit();
			
			tipogarantiaempresaReturnGeneral.setConRetornoEstaProcesado(true);
			tipogarantiaempresaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipogarantiaempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoGarantiaEmpresasEliminados() throws Exception {				
		
		List<TipoGarantiaEmpresa> tipogarantiaempresasAux= new ArrayList<TipoGarantiaEmpresa>();
		
		for(TipoGarantiaEmpresa tipogarantiaempresa:tipogarantiaempresas) {
			if(!tipogarantiaempresa.getIsDeleted()) {
				tipogarantiaempresasAux.add(tipogarantiaempresa);
			}
		}
		
		tipogarantiaempresas=tipogarantiaempresasAux;
	}
	
	public void quitarTipoGarantiaEmpresasNulos() throws Exception {				
		
		List<TipoGarantiaEmpresa> tipogarantiaempresasAux= new ArrayList<TipoGarantiaEmpresa>();
		
		for(TipoGarantiaEmpresa tipogarantiaempresa : this.tipogarantiaempresas) {
			if(tipogarantiaempresa==null) {
				tipogarantiaempresasAux.add(tipogarantiaempresa);
			}
		}
		
		//this.tipogarantiaempresas=tipogarantiaempresasAux;
		
		this.tipogarantiaempresas.removeAll(tipogarantiaempresasAux);
	}
	
	public void getSetVersionRowTipoGarantiaEmpresaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipogarantiaempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipogarantiaempresa.getIsDeleted() || (tipogarantiaempresa.getIsChanged()&&!tipogarantiaempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipogarantiaempresaDataAccess.getSetVersionRowTipoGarantiaEmpresa(connexion,tipogarantiaempresa.getId());
				
				if(!tipogarantiaempresa.getVersionRow().equals(timestamp)) {	
					tipogarantiaempresa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipogarantiaempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoGarantiaEmpresa()throws Exception {	
		
		if(tipogarantiaempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipogarantiaempresa.getIsDeleted() || (tipogarantiaempresa.getIsChanged()&&!tipogarantiaempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipogarantiaempresaDataAccess.getSetVersionRowTipoGarantiaEmpresa(connexion,tipogarantiaempresa.getId());
			
			try {							
				if(!tipogarantiaempresa.getVersionRow().equals(timestamp)) {	
					tipogarantiaempresa.setVersionRow(timestamp);
				}
				
				tipogarantiaempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoGarantiaEmpresasWithConnection()throws Exception {	
		if(tipogarantiaempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoGarantiaEmpresa tipogarantiaempresaAux:tipogarantiaempresas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipogarantiaempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogarantiaempresaAux.getIsDeleted() || (tipogarantiaempresaAux.getIsChanged()&&!tipogarantiaempresaAux.getIsNew())) {
						
						timestamp=tipogarantiaempresaDataAccess.getSetVersionRowTipoGarantiaEmpresa(connexion,tipogarantiaempresaAux.getId());
						
						if(!tipogarantiaempresa.getVersionRow().equals(timestamp)) {	
							tipogarantiaempresaAux.setVersionRow(timestamp);
						}
								
						tipogarantiaempresaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoGarantiaEmpresas()throws Exception {	
		if(tipogarantiaempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoGarantiaEmpresa tipogarantiaempresaAux:tipogarantiaempresas) {
					if(tipogarantiaempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogarantiaempresaAux.getIsDeleted() || (tipogarantiaempresaAux.getIsChanged()&&!tipogarantiaempresaAux.getIsNew())) {
						
						timestamp=tipogarantiaempresaDataAccess.getSetVersionRowTipoGarantiaEmpresa(connexion,tipogarantiaempresaAux.getId());
						
						if(!tipogarantiaempresaAux.getVersionRow().equals(timestamp)) {	
							tipogarantiaempresaAux.setVersionRow(timestamp);
						}
						
													
						tipogarantiaempresaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoGarantiaEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoGarantiaEmpresaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoGarantiaEmpresaParameterReturnGeneral  tipogarantiaempresaReturnGeneral =new TipoGarantiaEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoGarantiaEmpresaWithConnection");connexion.begin();
			
			tipogarantiaempresaReturnGeneral =new TipoGarantiaEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipogarantiaempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipogarantiaempresaReturnGeneral;
	}
	
	public TipoGarantiaEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoGarantiaEmpresa(String finalQueryGlobalEmpresa) throws Exception {
		TipoGarantiaEmpresaParameterReturnGeneral  tipogarantiaempresaReturnGeneral =new TipoGarantiaEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipogarantiaempresaReturnGeneral =new TipoGarantiaEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipogarantiaempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipogarantiaempresaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoGarantiaEmpresaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ClienteLogic clienteLogic=new ClienteLogic();
			GarantiaClienteLogic garantiaclienteLogic=new GarantiaClienteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoGarantiaEmpresaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(GarantiaCliente.class));
											
			

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			garantiaclienteLogic.setConnexion(this.getConnexion());
			garantiaclienteLogic.setDatosCliente(this.datosCliente);
			garantiaclienteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoGarantiaEmpresa tipogarantiaempresa:this.tipogarantiaempresas) {
				

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(tipogarantiaempresa.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=GarantiaClienteConstantesFunciones.getClassesForeignKeysOfGarantiaCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				garantiaclienteLogic.setGarantiaClientes(tipogarantiaempresa.garantiaclientes);
				garantiaclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoGarantiaEmpresa tipogarantiaempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoGarantiaEmpresaLogicAdditional.updateTipoGarantiaEmpresaToGet(tipogarantiaempresa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogarantiaempresa.setEmpresa(tipogarantiaempresaDataAccess.getEmpresa(connexion,tipogarantiaempresa));
		tipogarantiaempresa.setClientes(tipogarantiaempresaDataAccess.getClientes(connexion,tipogarantiaempresa));
		tipogarantiaempresa.setGarantiaClientes(tipogarantiaempresaDataAccess.getGarantiaClientes(connexion,tipogarantiaempresa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipogarantiaempresa.setEmpresa(tipogarantiaempresaDataAccess.getEmpresa(connexion,tipogarantiaempresa));
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogarantiaempresa.setClientes(tipogarantiaempresaDataAccess.getClientes(connexion,tipogarantiaempresa));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(tipogarantiaempresa.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					tipogarantiaempresa.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogarantiaempresa.setGarantiaClientes(tipogarantiaempresaDataAccess.getGarantiaClientes(connexion,tipogarantiaempresa));

				if(this.isConDeep) {
					GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(this.connexion);
					garantiaclienteLogic.setGarantiaClientes(tipogarantiaempresa.getGarantiaClientes());
					ArrayList<Classe> classesLocal=GarantiaClienteConstantesFunciones.getClassesForeignKeysOfGarantiaCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					garantiaclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(garantiaclienteLogic.getGarantiaClientes());
					tipogarantiaempresa.setGarantiaClientes(garantiaclienteLogic.getGarantiaClientes());
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
			tipogarantiaempresa.setEmpresa(tipogarantiaempresaDataAccess.getEmpresa(connexion,tipogarantiaempresa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cliente.class));
			tipogarantiaempresa.setClientes(tipogarantiaempresaDataAccess.getClientes(connexion,tipogarantiaempresa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GarantiaCliente.class));
			tipogarantiaempresa.setGarantiaClientes(tipogarantiaempresaDataAccess.getGarantiaClientes(connexion,tipogarantiaempresa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogarantiaempresa.setEmpresa(tipogarantiaempresaDataAccess.getEmpresa(connexion,tipogarantiaempresa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipogarantiaempresa.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipogarantiaempresa.setClientes(tipogarantiaempresaDataAccess.getClientes(connexion,tipogarantiaempresa));

		for(Cliente cliente:tipogarantiaempresa.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		tipogarantiaempresa.setGarantiaClientes(tipogarantiaempresaDataAccess.getGarantiaClientes(connexion,tipogarantiaempresa));

		for(GarantiaCliente garantiacliente:tipogarantiaempresa.getGarantiaClientes()) {
			GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
			garantiaclienteLogic.deepLoad(garantiacliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipogarantiaempresa.setEmpresa(tipogarantiaempresaDataAccess.getEmpresa(connexion,tipogarantiaempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipogarantiaempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogarantiaempresa.setClientes(tipogarantiaempresaDataAccess.getClientes(connexion,tipogarantiaempresa));

				for(Cliente cliente:tipogarantiaempresa.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogarantiaempresa.setGarantiaClientes(tipogarantiaempresaDataAccess.getGarantiaClientes(connexion,tipogarantiaempresa));

				for(GarantiaCliente garantiacliente:tipogarantiaempresa.getGarantiaClientes()) {
					GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
					garantiaclienteLogic.deepLoad(garantiacliente,isDeep,deepLoadType,clases);
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
			tipogarantiaempresa.setEmpresa(tipogarantiaempresaDataAccess.getEmpresa(connexion,tipogarantiaempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipogarantiaempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cliente.class));
			tipogarantiaempresa.setClientes(tipogarantiaempresaDataAccess.getClientes(connexion,tipogarantiaempresa));

			for(Cliente cliente:tipogarantiaempresa.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GarantiaCliente.class));
			tipogarantiaempresa.setGarantiaClientes(tipogarantiaempresaDataAccess.getGarantiaClientes(connexion,tipogarantiaempresa));

			for(GarantiaCliente garantiacliente:tipogarantiaempresa.getGarantiaClientes()) {
				GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
				garantiaclienteLogic.deepLoad(garantiacliente,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoGarantiaEmpresa tipogarantiaempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoGarantiaEmpresaLogicAdditional.updateTipoGarantiaEmpresaToSave(tipogarantiaempresa,this.arrDatoGeneral);
			
TipoGarantiaEmpresaDataAccess.save(tipogarantiaempresa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipogarantiaempresa.getEmpresa(),connexion);

		for(Cliente cliente:tipogarantiaempresa.getClientes()) {
			cliente.setid_tipo_garantia_empresa(tipogarantiaempresa.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(GarantiaCliente garantiacliente:tipogarantiaempresa.getGarantiaClientes()) {
			garantiacliente.setid_tipo_garantia_empresa(tipogarantiaempresa.getId());
			GarantiaClienteDataAccess.save(garantiacliente,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipogarantiaempresa.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:tipogarantiaempresa.getClientes()) {
					cliente.setid_tipo_garantia_empresa(tipogarantiaempresa.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GarantiaCliente garantiacliente:tipogarantiaempresa.getGarantiaClientes()) {
					garantiacliente.setid_tipo_garantia_empresa(tipogarantiaempresa.getId());
					GarantiaClienteDataAccess.save(garantiacliente,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipogarantiaempresa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipogarantiaempresa.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Cliente cliente:tipogarantiaempresa.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_tipo_garantia_empresa(tipogarantiaempresa.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(GarantiaCliente garantiacliente:tipogarantiaempresa.getGarantiaClientes()) {
			GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
			garantiacliente.setid_tipo_garantia_empresa(tipogarantiaempresa.getId());
			GarantiaClienteDataAccess.save(garantiacliente,connexion);
			garantiaclienteLogic.deepSave(garantiacliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipogarantiaempresa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipogarantiaempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:tipogarantiaempresa.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_tipo_garantia_empresa(tipogarantiaempresa.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GarantiaCliente garantiacliente:tipogarantiaempresa.getGarantiaClientes()) {
					GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
					garantiacliente.setid_tipo_garantia_empresa(tipogarantiaempresa.getId());
					GarantiaClienteDataAccess.save(garantiacliente,connexion);
					garantiaclienteLogic.deepSave(garantiacliente,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoGarantiaEmpresa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipogarantiaempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(tipogarantiaempresa);
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
			this.deepLoad(this.tipogarantiaempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGarantiaEmpresa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipogarantiaempresas!=null) {
				for(TipoGarantiaEmpresa tipogarantiaempresa:tipogarantiaempresas) {
					this.deepLoad(tipogarantiaempresa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(tipogarantiaempresas);
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
			if(tipogarantiaempresas!=null) {
				for(TipoGarantiaEmpresa tipogarantiaempresa:tipogarantiaempresas) {
					this.deepLoad(tipogarantiaempresa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(tipogarantiaempresas);
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
			this.getNewConnexionToDeep(TipoGarantiaEmpresa.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipogarantiaempresa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoGarantiaEmpresa.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipogarantiaempresas!=null) {
				for(TipoGarantiaEmpresa tipogarantiaempresa:tipogarantiaempresas) {
					this.deepSave(tipogarantiaempresa,isDeep,deepLoadType,clases);
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
			if(tipogarantiaempresas!=null) {
				for(TipoGarantiaEmpresa tipogarantiaempresa:tipogarantiaempresas) {
					this.deepSave(tipogarantiaempresa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoGarantiaEmpresasBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoGarantiaEmpresaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGarantiaEmpresasBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoGarantiaEmpresaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGarantiaEmpresasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoGarantiaEmpresaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGarantiaEmpresasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoGarantiaEmpresaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGarantiaEmpresasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGarantiaEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGarantiaEmpresasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoGarantiaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogarantiaempresas=tipogarantiaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGarantiaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGarantiaEmpresa(this.tipogarantiaempresas);
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
			if(TipoGarantiaEmpresaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGarantiaEmpresaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoGarantiaEmpresa tipogarantiaempresa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoGarantiaEmpresaConstantesFunciones.ISCONAUDITORIA) {
				if(tipogarantiaempresa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGarantiaEmpresaDataAccess.TABLENAME, tipogarantiaempresa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGarantiaEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGarantiaEmpresaLogic.registrarAuditoriaDetallesTipoGarantiaEmpresa(connexion,tipogarantiaempresa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipogarantiaempresa.getIsDeleted()) {
					/*if(!tipogarantiaempresa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoGarantiaEmpresaDataAccess.TABLENAME, tipogarantiaempresa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoGarantiaEmpresaLogic.registrarAuditoriaDetallesTipoGarantiaEmpresa(connexion,tipogarantiaempresa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGarantiaEmpresaDataAccess.TABLENAME, tipogarantiaempresa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipogarantiaempresa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGarantiaEmpresaDataAccess.TABLENAME, tipogarantiaempresa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGarantiaEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGarantiaEmpresaLogic.registrarAuditoriaDetallesTipoGarantiaEmpresa(connexion,tipogarantiaempresa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoGarantiaEmpresa(Connexion connexion,TipoGarantiaEmpresa tipogarantiaempresa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipogarantiaempresa.getIsNew()||!tipogarantiaempresa.getid_empresa().equals(tipogarantiaempresa.getTipoGarantiaEmpresaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogarantiaempresa.getTipoGarantiaEmpresaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipogarantiaempresa.getTipoGarantiaEmpresaOriginal().getid_empresa().toString();
				}
				if(tipogarantiaempresa.getid_empresa()!=null)
				{
					strValorNuevo=tipogarantiaempresa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipogarantiaempresa.getIsNew()||!tipogarantiaempresa.getcodigo().equals(tipogarantiaempresa.getTipoGarantiaEmpresaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogarantiaempresa.getTipoGarantiaEmpresaOriginal().getcodigo()!=null)
				{
					strValorActual=tipogarantiaempresa.getTipoGarantiaEmpresaOriginal().getcodigo();
				}
				if(tipogarantiaempresa.getcodigo()!=null)
				{
					strValorNuevo=tipogarantiaempresa.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGarantiaEmpresaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipogarantiaempresa.getIsNew()||!tipogarantiaempresa.getnombre().equals(tipogarantiaempresa.getTipoGarantiaEmpresaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogarantiaempresa.getTipoGarantiaEmpresaOriginal().getnombre()!=null)
				{
					strValorActual=tipogarantiaempresa.getTipoGarantiaEmpresaOriginal().getnombre();
				}
				if(tipogarantiaempresa.getnombre()!=null)
				{
					strValorNuevo=tipogarantiaempresa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGarantiaEmpresaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipogarantiaempresa.getIsNew()||!tipogarantiaempresa.getes_defecto().equals(tipogarantiaempresa.getTipoGarantiaEmpresaOriginal().getes_defecto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogarantiaempresa.getTipoGarantiaEmpresaOriginal().getes_defecto()!=null)
				{
					strValorActual=tipogarantiaempresa.getTipoGarantiaEmpresaOriginal().getes_defecto().toString();
				}
				if(tipogarantiaempresa.getes_defecto()!=null)
				{
					strValorNuevo=tipogarantiaempresa.getes_defecto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGarantiaEmpresaConstantesFunciones.ESDEFECTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoGarantiaEmpresaRelacionesWithConnection(TipoGarantiaEmpresa tipogarantiaempresa,List<Cliente> clientes,List<GarantiaCliente> garantiaclientes) throws Exception {

		if(!tipogarantiaempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoGarantiaEmpresaRelacionesBase(tipogarantiaempresa,clientes,garantiaclientes,true);
		}
	}

	public void saveTipoGarantiaEmpresaRelaciones(TipoGarantiaEmpresa tipogarantiaempresa,List<Cliente> clientes,List<GarantiaCliente> garantiaclientes)throws Exception {

		if(!tipogarantiaempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoGarantiaEmpresaRelacionesBase(tipogarantiaempresa,clientes,garantiaclientes,false);
		}
	}

	public void saveTipoGarantiaEmpresaRelacionesBase(TipoGarantiaEmpresa tipogarantiaempresa,List<Cliente> clientes,List<GarantiaCliente> garantiaclientes,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoGarantiaEmpresa-saveRelacionesWithConnection");}
	
			tipogarantiaempresa.setClientes(clientes);
			tipogarantiaempresa.setGarantiaClientes(garantiaclientes);

			this.setTipoGarantiaEmpresa(tipogarantiaempresa);

			if(TipoGarantiaEmpresaLogicAdditional.validarSaveRelaciones(tipogarantiaempresa,this)) {

				TipoGarantiaEmpresaLogicAdditional.updateRelacionesToSave(tipogarantiaempresa,this);

				if((tipogarantiaempresa.getIsNew()||tipogarantiaempresa.getIsChanged())&&!tipogarantiaempresa.getIsDeleted()) {
					this.saveTipoGarantiaEmpresa();
					this.saveTipoGarantiaEmpresaRelacionesDetalles(clientes,garantiaclientes);

				} else if(tipogarantiaempresa.getIsDeleted()) {
					this.saveTipoGarantiaEmpresaRelacionesDetalles(clientes,garantiaclientes);
					this.saveTipoGarantiaEmpresa();
				}

				TipoGarantiaEmpresaLogicAdditional.updateRelacionesToSaveAfter(tipogarantiaempresa,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			GarantiaClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresGarantiaClientes(garantiaclientes,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoGarantiaEmpresaRelacionesDetalles(List<Cliente> clientes,List<GarantiaCliente> garantiaclientes)throws Exception {
		try {
	

			Long idTipoGarantiaEmpresaActual=this.getTipoGarantiaEmpresa().getId();

			ClienteLogic clienteLogic_Desde_TipoGarantiaEmpresa=new ClienteLogic();
			clienteLogic_Desde_TipoGarantiaEmpresa.setClientes(clientes);

			clienteLogic_Desde_TipoGarantiaEmpresa.setConnexion(this.getConnexion());
			clienteLogic_Desde_TipoGarantiaEmpresa.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_TipoGarantiaEmpresa:clienteLogic_Desde_TipoGarantiaEmpresa.getClientes()) {
				cliente_Desde_TipoGarantiaEmpresa.setid_tipo_garantia_empresa(idTipoGarantiaEmpresaActual);

				clienteLogic_Desde_TipoGarantiaEmpresa.setCliente(cliente_Desde_TipoGarantiaEmpresa);
				clienteLogic_Desde_TipoGarantiaEmpresa.saveCliente();
			}


			GarantiaClienteLogic garantiaclienteLogic_Desde_TipoGarantiaEmpresa=new GarantiaClienteLogic();
			garantiaclienteLogic_Desde_TipoGarantiaEmpresa.setGarantiaClientes(garantiaclientes);

			garantiaclienteLogic_Desde_TipoGarantiaEmpresa.setConnexion(this.getConnexion());
			garantiaclienteLogic_Desde_TipoGarantiaEmpresa.setDatosCliente(this.datosCliente);

			for(GarantiaCliente garantiacliente_Desde_TipoGarantiaEmpresa:garantiaclienteLogic_Desde_TipoGarantiaEmpresa.getGarantiaClientes()) {
				garantiacliente_Desde_TipoGarantiaEmpresa.setid_tipo_garantia_empresa(idTipoGarantiaEmpresaActual);
			}

			garantiaclienteLogic_Desde_TipoGarantiaEmpresa.saveGarantiaClientes();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGarantiaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGarantiaEmpresaConstantesFunciones.getClassesForeignKeysOfTipoGarantiaEmpresa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGarantiaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGarantiaEmpresaConstantesFunciones.getClassesRelationshipsOfTipoGarantiaEmpresa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

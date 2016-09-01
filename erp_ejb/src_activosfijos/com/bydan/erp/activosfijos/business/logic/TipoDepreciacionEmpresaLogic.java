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
import com.bydan.erp.activosfijos.util.TipoDepreciacionEmpresaConstantesFunciones;
import com.bydan.erp.activosfijos.util.TipoDepreciacionEmpresaParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.TipoDepreciacionEmpresaParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.TipoDepreciacionEmpresa;
//import com.bydan.erp.activosfijos.business.logic.TipoDepreciacionEmpresaLogicAdditional;
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
public class TipoDepreciacionEmpresaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoDepreciacionEmpresaLogic.class);
	
	protected TipoDepreciacionEmpresaDataAccess tipodepreciacionempresaDataAccess; 	
	protected TipoDepreciacionEmpresa tipodepreciacionempresa;
	protected List<TipoDepreciacionEmpresa> tipodepreciacionempresas;
	protected Object tipodepreciacionempresaObject;	
	protected List<Object> tipodepreciacionempresasObject;
	
	public static ClassValidator<TipoDepreciacionEmpresa> tipodepreciacionempresaValidator = new ClassValidator<TipoDepreciacionEmpresa>(TipoDepreciacionEmpresa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  TipoDepreciacionEmpresaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipodepreciacionempresaDataAccess = new TipoDepreciacionEmpresaDataAccess();
			
			this.tipodepreciacionempresas= new ArrayList<TipoDepreciacionEmpresa>();
			this.tipodepreciacionempresa= new TipoDepreciacionEmpresa();
			
			this.tipodepreciacionempresaObject=new Object();
			this.tipodepreciacionempresasObject=new ArrayList<Object>();
				
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
			
			this.tipodepreciacionempresaDataAccess.setConnexionType(this.connexionType);
			this.tipodepreciacionempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoDepreciacionEmpresaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipodepreciacionempresaDataAccess = new TipoDepreciacionEmpresaDataAccess();
			this.tipodepreciacionempresas= new ArrayList<TipoDepreciacionEmpresa>();
			this.tipodepreciacionempresa= new TipoDepreciacionEmpresa();
			this.tipodepreciacionempresaObject=new Object();
			this.tipodepreciacionempresasObject=new ArrayList<Object>();
			
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
			
			this.tipodepreciacionempresaDataAccess.setConnexionType(this.connexionType);
			this.tipodepreciacionempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoDepreciacionEmpresa getTipoDepreciacionEmpresa() throws Exception {	
		//TipoDepreciacionEmpresaLogicAdditional.checkTipoDepreciacionEmpresaToGet(tipodepreciacionempresa,this.datosCliente,this.arrDatoGeneral);
		//TipoDepreciacionEmpresaLogicAdditional.updateTipoDepreciacionEmpresaToGet(tipodepreciacionempresa,this.arrDatoGeneral);
		
		return tipodepreciacionempresa;
	}
		
	public void setTipoDepreciacionEmpresa(TipoDepreciacionEmpresa newTipoDepreciacionEmpresa) {
		this.tipodepreciacionempresa = newTipoDepreciacionEmpresa;
	}
	
	public TipoDepreciacionEmpresaDataAccess getTipoDepreciacionEmpresaDataAccess() {
		return tipodepreciacionempresaDataAccess;
	}
	
	public void setTipoDepreciacionEmpresaDataAccess(TipoDepreciacionEmpresaDataAccess newtipodepreciacionempresaDataAccess) {
		this.tipodepreciacionempresaDataAccess = newtipodepreciacionempresaDataAccess;
	}
	
	public List<TipoDepreciacionEmpresa> getTipoDepreciacionEmpresas() throws Exception {		
		this.quitarTipoDepreciacionEmpresasNulos();
		
		//TipoDepreciacionEmpresaLogicAdditional.checkTipoDepreciacionEmpresaToGets(tipodepreciacionempresas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoDepreciacionEmpresa tipodepreciacionempresaLocal: tipodepreciacionempresas ) {
			//TipoDepreciacionEmpresaLogicAdditional.updateTipoDepreciacionEmpresaToGet(tipodepreciacionempresaLocal,this.arrDatoGeneral);
		}
		
		return tipodepreciacionempresas;
	}
	
	public void setTipoDepreciacionEmpresas(List<TipoDepreciacionEmpresa> newTipoDepreciacionEmpresas) {
		this.tipodepreciacionempresas = newTipoDepreciacionEmpresas;
	}
	
	public Object getTipoDepreciacionEmpresaObject() {	
		this.tipodepreciacionempresaObject=this.tipodepreciacionempresaDataAccess.getEntityObject();
		return this.tipodepreciacionempresaObject;
	}
		
	public void setTipoDepreciacionEmpresaObject(Object newTipoDepreciacionEmpresaObject) {
		this.tipodepreciacionempresaObject = newTipoDepreciacionEmpresaObject;
	}
	
	public List<Object> getTipoDepreciacionEmpresasObject() {		
		this.tipodepreciacionempresasObject=this.tipodepreciacionempresaDataAccess.getEntitiesObject();
		return this.tipodepreciacionempresasObject;
	}
		
	public void setTipoDepreciacionEmpresasObject(List<Object> newTipoDepreciacionEmpresasObject) {
		this.tipodepreciacionempresasObject = newTipoDepreciacionEmpresasObject;
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
		
		if(this.tipodepreciacionempresaDataAccess!=null) {
			this.tipodepreciacionempresaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipodepreciacionempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipodepreciacionempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodepreciacionempresa=tipodepreciacionempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodepreciacionempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresa);
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
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		  		  
        try {
			
			tipodepreciacionempresa=tipodepreciacionempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodepreciacionempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodepreciacionempresa=tipodepreciacionempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodepreciacionempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresa);
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
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		  		  
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
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		  		  
        try {
			
			tipodepreciacionempresa=tipodepreciacionempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodepreciacionempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		  		  
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
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipodepreciacionempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipodepreciacionempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipodepreciacionempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipodepreciacionempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipodepreciacionempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipodepreciacionempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodepreciacionempresas = new  ArrayList<TipoDepreciacionEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodepreciacionempresas=tipodepreciacionempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDepreciacionEmpresa(tipodepreciacionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresas);
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
		tipodepreciacionempresas = new  ArrayList<TipoDepreciacionEmpresa>();
		  		  
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
		tipodepreciacionempresas = new  ArrayList<TipoDepreciacionEmpresa>();
		  		  
        try {			
			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodepreciacionempresas=tipodepreciacionempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoDepreciacionEmpresa(tipodepreciacionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipodepreciacionempresas = new  ArrayList<TipoDepreciacionEmpresa>();
		  		  
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
		tipodepreciacionempresas = new  ArrayList<TipoDepreciacionEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodepreciacionempresas=tipodepreciacionempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDepreciacionEmpresa(tipodepreciacionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresas);
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
		tipodepreciacionempresas = new  ArrayList<TipoDepreciacionEmpresa>();
		  		  
        try {
			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodepreciacionempresas=tipodepreciacionempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDepreciacionEmpresa(tipodepreciacionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresas);
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
		tipodepreciacionempresas = new  ArrayList<TipoDepreciacionEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodepreciacionempresas=tipodepreciacionempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDepreciacionEmpresa(tipodepreciacionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresas);
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
		tipodepreciacionempresas = new  ArrayList<TipoDepreciacionEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodepreciacionempresas=tipodepreciacionempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDepreciacionEmpresa(tipodepreciacionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodepreciacionempresa=tipodepreciacionempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDepreciacionEmpresa(tipodepreciacionempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresa);
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
		tipodepreciacionempresa = new  TipoDepreciacionEmpresa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodepreciacionempresa=tipodepreciacionempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDepreciacionEmpresa(tipodepreciacionempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoDepreciacionEmpresasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipodepreciacionempresas = new  ArrayList<TipoDepreciacionEmpresa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-getTodosTipoDepreciacionEmpresasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodepreciacionempresas=tipodepreciacionempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDepreciacionEmpresa(tipodepreciacionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresas);
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
	
	public  void  getTodosTipoDepreciacionEmpresas(String sFinalQuery,Pagination pagination)throws Exception {
		tipodepreciacionempresas = new  ArrayList<TipoDepreciacionEmpresa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodepreciacionempresas=tipodepreciacionempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDepreciacionEmpresa(tipodepreciacionempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoDepreciacionEmpresa(TipoDepreciacionEmpresa tipodepreciacionempresa) throws Exception {
		Boolean estaValidado=false;
		
		if(tipodepreciacionempresa.getIsNew() || tipodepreciacionempresa.getIsChanged()) { 
			this.invalidValues = tipodepreciacionempresaValidator.getInvalidValues(tipodepreciacionempresa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipodepreciacionempresa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoDepreciacionEmpresa(List<TipoDepreciacionEmpresa> TipoDepreciacionEmpresas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoDepreciacionEmpresa tipodepreciacionempresaLocal:tipodepreciacionempresas) {				
			estaValidadoObjeto=this.validarGuardarTipoDepreciacionEmpresa(tipodepreciacionempresaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoDepreciacionEmpresa(List<TipoDepreciacionEmpresa> TipoDepreciacionEmpresas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDepreciacionEmpresa(tipodepreciacionempresas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoDepreciacionEmpresa(TipoDepreciacionEmpresa TipoDepreciacionEmpresa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDepreciacionEmpresa(tipodepreciacionempresa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoDepreciacionEmpresa tipodepreciacionempresa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipodepreciacionempresa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoDepreciacionEmpresaConstantesFunciones.getTipoDepreciacionEmpresaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipodepreciacionempresa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoDepreciacionEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoDepreciacionEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoDepreciacionEmpresaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-saveTipoDepreciacionEmpresaWithConnection");connexion.begin();			
			
			//TipoDepreciacionEmpresaLogicAdditional.checkTipoDepreciacionEmpresaToSave(this.tipodepreciacionempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoDepreciacionEmpresaLogicAdditional.updateTipoDepreciacionEmpresaToSave(this.tipodepreciacionempresa,this.arrDatoGeneral);
			
			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodepreciacionempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoDepreciacionEmpresa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDepreciacionEmpresa(this.tipodepreciacionempresa)) {
				TipoDepreciacionEmpresaDataAccess.save(this.tipodepreciacionempresa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipodepreciacionempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoDepreciacionEmpresaLogicAdditional.checkTipoDepreciacionEmpresaToSaveAfter(this.tipodepreciacionempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDepreciacionEmpresa();
			
			connexion.commit();			
			
			if(this.tipodepreciacionempresa.getIsDeleted()) {
				this.tipodepreciacionempresa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoDepreciacionEmpresa()throws Exception {	
		try {	
			
			//TipoDepreciacionEmpresaLogicAdditional.checkTipoDepreciacionEmpresaToSave(this.tipodepreciacionempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoDepreciacionEmpresaLogicAdditional.updateTipoDepreciacionEmpresaToSave(this.tipodepreciacionempresa,this.arrDatoGeneral);
			
			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodepreciacionempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDepreciacionEmpresa(this.tipodepreciacionempresa)) {			
				TipoDepreciacionEmpresaDataAccess.save(this.tipodepreciacionempresa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipodepreciacionempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoDepreciacionEmpresaLogicAdditional.checkTipoDepreciacionEmpresaToSaveAfter(this.tipodepreciacionempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipodepreciacionempresa.getIsDeleted()) {
				this.tipodepreciacionempresa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoDepreciacionEmpresasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-saveTipoDepreciacionEmpresasWithConnection");connexion.begin();			
			
			//TipoDepreciacionEmpresaLogicAdditional.checkTipoDepreciacionEmpresaToSaves(tipodepreciacionempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoDepreciacionEmpresas();
			
			Boolean validadoTodosTipoDepreciacionEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDepreciacionEmpresa tipodepreciacionempresaLocal:tipodepreciacionempresas) {		
				if(tipodepreciacionempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoDepreciacionEmpresaLogicAdditional.updateTipoDepreciacionEmpresaToSave(tipodepreciacionempresaLocal,this.arrDatoGeneral);
	        	
				TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodepreciacionempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDepreciacionEmpresa(tipodepreciacionempresaLocal)) {
					TipoDepreciacionEmpresaDataAccess.save(tipodepreciacionempresaLocal, connexion);				
				} else {
					validadoTodosTipoDepreciacionEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoDepreciacionEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoDepreciacionEmpresaLogicAdditional.checkTipoDepreciacionEmpresaToSavesAfter(tipodepreciacionempresas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDepreciacionEmpresas();
			
			connexion.commit();		
			
			this.quitarTipoDepreciacionEmpresasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoDepreciacionEmpresas()throws Exception {				
		 try {	
			//TipoDepreciacionEmpresaLogicAdditional.checkTipoDepreciacionEmpresaToSaves(tipodepreciacionempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoDepreciacionEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDepreciacionEmpresa tipodepreciacionempresaLocal:tipodepreciacionempresas) {				
				if(tipodepreciacionempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoDepreciacionEmpresaLogicAdditional.updateTipoDepreciacionEmpresaToSave(tipodepreciacionempresaLocal,this.arrDatoGeneral);
	        	
				TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodepreciacionempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDepreciacionEmpresa(tipodepreciacionempresaLocal)) {				
					TipoDepreciacionEmpresaDataAccess.save(tipodepreciacionempresaLocal, connexion);				
				} else {
					validadoTodosTipoDepreciacionEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoDepreciacionEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoDepreciacionEmpresaLogicAdditional.checkTipoDepreciacionEmpresaToSavesAfter(tipodepreciacionempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoDepreciacionEmpresasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDepreciacionEmpresaParameterReturnGeneral procesarAccionTipoDepreciacionEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDepreciacionEmpresa> tipodepreciacionempresas,TipoDepreciacionEmpresaParameterReturnGeneral tipodepreciacionempresaParameterGeneral)throws Exception {
		 try {	
			TipoDepreciacionEmpresaParameterReturnGeneral tipodepreciacionempresaReturnGeneral=new TipoDepreciacionEmpresaParameterReturnGeneral();
	
			
			return tipodepreciacionempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDepreciacionEmpresaParameterReturnGeneral procesarAccionTipoDepreciacionEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDepreciacionEmpresa> tipodepreciacionempresas,TipoDepreciacionEmpresaParameterReturnGeneral tipodepreciacionempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-procesarAccionTipoDepreciacionEmpresasWithConnection");connexion.begin();			
			
			TipoDepreciacionEmpresaParameterReturnGeneral tipodepreciacionempresaReturnGeneral=new TipoDepreciacionEmpresaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipodepreciacionempresaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDepreciacionEmpresaParameterReturnGeneral procesarEventosTipoDepreciacionEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDepreciacionEmpresa> tipodepreciacionempresas,TipoDepreciacionEmpresa tipodepreciacionempresa,TipoDepreciacionEmpresaParameterReturnGeneral tipodepreciacionempresaParameterGeneral,Boolean isEsNuevoTipoDepreciacionEmpresa,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoDepreciacionEmpresaParameterReturnGeneral tipodepreciacionempresaReturnGeneral=new TipoDepreciacionEmpresaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodepreciacionempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipodepreciacionempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoDepreciacionEmpresaParameterReturnGeneral procesarEventosTipoDepreciacionEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDepreciacionEmpresa> tipodepreciacionempresas,TipoDepreciacionEmpresa tipodepreciacionempresa,TipoDepreciacionEmpresaParameterReturnGeneral tipodepreciacionempresaParameterGeneral,Boolean isEsNuevoTipoDepreciacionEmpresa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-procesarEventosTipoDepreciacionEmpresasWithConnection");connexion.begin();			
			
			TipoDepreciacionEmpresaParameterReturnGeneral tipodepreciacionempresaReturnGeneral=new TipoDepreciacionEmpresaParameterReturnGeneral();
	
			tipodepreciacionempresaReturnGeneral.setTipoDepreciacionEmpresa(tipodepreciacionempresa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodepreciacionempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipodepreciacionempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDepreciacionEmpresaParameterReturnGeneral procesarImportacionTipoDepreciacionEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoDepreciacionEmpresaParameterReturnGeneral tipodepreciacionempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-procesarImportacionTipoDepreciacionEmpresasWithConnection");connexion.begin();			
			
			TipoDepreciacionEmpresaParameterReturnGeneral tipodepreciacionempresaReturnGeneral=new TipoDepreciacionEmpresaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipodepreciacionempresas=new ArrayList<TipoDepreciacionEmpresa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipodepreciacionempresa=new TipoDepreciacionEmpresa();
				
				
				if(conColumnasBase) {this.tipodepreciacionempresa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipodepreciacionempresa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipodepreciacionempresa.setcodigo(arrColumnas[iColumn++]);
				this.tipodepreciacionempresa.setnombre(arrColumnas[iColumn++]);
				this.tipodepreciacionempresa.setes_linea_recta(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tipodepreciacionempresa.setes_mensual(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tipodepreciacionempresas.add(this.tipodepreciacionempresa);
			}
			
			this.saveTipoDepreciacionEmpresas();
			
			this.connexion.commit();
			
			tipodepreciacionempresaReturnGeneral.setConRetornoEstaProcesado(true);
			tipodepreciacionempresaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipodepreciacionempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoDepreciacionEmpresasEliminados() throws Exception {				
		
		List<TipoDepreciacionEmpresa> tipodepreciacionempresasAux= new ArrayList<TipoDepreciacionEmpresa>();
		
		for(TipoDepreciacionEmpresa tipodepreciacionempresa:tipodepreciacionempresas) {
			if(!tipodepreciacionempresa.getIsDeleted()) {
				tipodepreciacionempresasAux.add(tipodepreciacionempresa);
			}
		}
		
		tipodepreciacionempresas=tipodepreciacionempresasAux;
	}
	
	public void quitarTipoDepreciacionEmpresasNulos() throws Exception {				
		
		List<TipoDepreciacionEmpresa> tipodepreciacionempresasAux= new ArrayList<TipoDepreciacionEmpresa>();
		
		for(TipoDepreciacionEmpresa tipodepreciacionempresa : this.tipodepreciacionempresas) {
			if(tipodepreciacionempresa==null) {
				tipodepreciacionempresasAux.add(tipodepreciacionempresa);
			}
		}
		
		//this.tipodepreciacionempresas=tipodepreciacionempresasAux;
		
		this.tipodepreciacionempresas.removeAll(tipodepreciacionempresasAux);
	}
	
	public void getSetVersionRowTipoDepreciacionEmpresaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipodepreciacionempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipodepreciacionempresa.getIsDeleted() || (tipodepreciacionempresa.getIsChanged()&&!tipodepreciacionempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipodepreciacionempresaDataAccess.getSetVersionRowTipoDepreciacionEmpresa(connexion,tipodepreciacionempresa.getId());
				
				if(!tipodepreciacionempresa.getVersionRow().equals(timestamp)) {	
					tipodepreciacionempresa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipodepreciacionempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoDepreciacionEmpresa()throws Exception {	
		
		if(tipodepreciacionempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipodepreciacionempresa.getIsDeleted() || (tipodepreciacionempresa.getIsChanged()&&!tipodepreciacionempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipodepreciacionempresaDataAccess.getSetVersionRowTipoDepreciacionEmpresa(connexion,tipodepreciacionempresa.getId());
			
			try {							
				if(!tipodepreciacionempresa.getVersionRow().equals(timestamp)) {	
					tipodepreciacionempresa.setVersionRow(timestamp);
				}
				
				tipodepreciacionempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoDepreciacionEmpresasWithConnection()throws Exception {	
		if(tipodepreciacionempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoDepreciacionEmpresa tipodepreciacionempresaAux:tipodepreciacionempresas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipodepreciacionempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodepreciacionempresaAux.getIsDeleted() || (tipodepreciacionempresaAux.getIsChanged()&&!tipodepreciacionempresaAux.getIsNew())) {
						
						timestamp=tipodepreciacionempresaDataAccess.getSetVersionRowTipoDepreciacionEmpresa(connexion,tipodepreciacionempresaAux.getId());
						
						if(!tipodepreciacionempresa.getVersionRow().equals(timestamp)) {	
							tipodepreciacionempresaAux.setVersionRow(timestamp);
						}
								
						tipodepreciacionempresaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoDepreciacionEmpresas()throws Exception {	
		if(tipodepreciacionempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoDepreciacionEmpresa tipodepreciacionempresaAux:tipodepreciacionempresas) {
					if(tipodepreciacionempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodepreciacionempresaAux.getIsDeleted() || (tipodepreciacionempresaAux.getIsChanged()&&!tipodepreciacionempresaAux.getIsNew())) {
						
						timestamp=tipodepreciacionempresaDataAccess.getSetVersionRowTipoDepreciacionEmpresa(connexion,tipodepreciacionempresaAux.getId());
						
						if(!tipodepreciacionempresaAux.getVersionRow().equals(timestamp)) {	
							tipodepreciacionempresaAux.setVersionRow(timestamp);
						}
						
													
						tipodepreciacionempresaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoDepreciacionEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoDepreciacionEmpresaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoDepreciacionEmpresaParameterReturnGeneral  tipodepreciacionempresaReturnGeneral =new TipoDepreciacionEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoDepreciacionEmpresaWithConnection");connexion.begin();
			
			tipodepreciacionempresaReturnGeneral =new TipoDepreciacionEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodepreciacionempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipodepreciacionempresaReturnGeneral;
	}
	
	public TipoDepreciacionEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoDepreciacionEmpresa(String finalQueryGlobalEmpresa) throws Exception {
		TipoDepreciacionEmpresaParameterReturnGeneral  tipodepreciacionempresaReturnGeneral =new TipoDepreciacionEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipodepreciacionempresaReturnGeneral =new TipoDepreciacionEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodepreciacionempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipodepreciacionempresaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoDepreciacionEmpresaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			DepreciacionActivoFijoLogic depreciacionactivofijoLogic=new DepreciacionActivoFijoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoDepreciacionEmpresaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleActivoFijo.class));
			classes.add(new Classe(DepreciacionActivoFijo.class));
											
			

			detalleactivofijoLogic.setConnexion(this.getConnexion());
			detalleactivofijoLogic.setDatosCliente(this.datosCliente);
			detalleactivofijoLogic.setIsConRefrescarForeignKeys(true);

			depreciacionactivofijoLogic.setConnexion(this.getConnexion());
			depreciacionactivofijoLogic.setDatosCliente(this.datosCliente);
			depreciacionactivofijoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoDepreciacionEmpresa tipodepreciacionempresa:this.tipodepreciacionempresas) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleActivoFijoConstantesFunciones.getClassesForeignKeysOfDetalleActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleactivofijoLogic.setDetalleActivoFijos(tipodepreciacionempresa.detalleactivofijos);
				detalleactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DepreciacionActivoFijoConstantesFunciones.getClassesForeignKeysOfDepreciacionActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				depreciacionactivofijoLogic.setDepreciacionActivoFijos(tipodepreciacionempresa.depreciacionactivofijos);
				depreciacionactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoDepreciacionEmpresa tipodepreciacionempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoDepreciacionEmpresaLogicAdditional.updateTipoDepreciacionEmpresaToGet(tipodepreciacionempresa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodepreciacionempresa.setEmpresa(tipodepreciacionempresaDataAccess.getEmpresa(connexion,tipodepreciacionempresa));
		tipodepreciacionempresa.setDetalleActivoFijos(tipodepreciacionempresaDataAccess.getDetalleActivoFijos(connexion,tipodepreciacionempresa));
		tipodepreciacionempresa.setDepreciacionActivoFijos(tipodepreciacionempresaDataAccess.getDepreciacionActivoFijos(connexion,tipodepreciacionempresa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodepreciacionempresa.setEmpresa(tipodepreciacionempresaDataAccess.getEmpresa(connexion,tipodepreciacionempresa));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodepreciacionempresa.setDetalleActivoFijos(tipodepreciacionempresaDataAccess.getDetalleActivoFijos(connexion,tipodepreciacionempresa));

				if(this.isConDeep) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(this.connexion);
					detalleactivofijoLogic.setDetalleActivoFijos(tipodepreciacionempresa.getDetalleActivoFijos());
					ArrayList<Classe> classesLocal=DetalleActivoFijoConstantesFunciones.getClassesForeignKeysOfDetalleActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(detalleactivofijoLogic.getDetalleActivoFijos());
					tipodepreciacionempresa.setDetalleActivoFijos(detalleactivofijoLogic.getDetalleActivoFijos());
				}

				continue;
			}

			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodepreciacionempresa.setDepreciacionActivoFijos(tipodepreciacionempresaDataAccess.getDepreciacionActivoFijos(connexion,tipodepreciacionempresa));

				if(this.isConDeep) {
					DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(this.connexion);
					depreciacionactivofijoLogic.setDepreciacionActivoFijos(tipodepreciacionempresa.getDepreciacionActivoFijos());
					ArrayList<Classe> classesLocal=DepreciacionActivoFijoConstantesFunciones.getClassesForeignKeysOfDepreciacionActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					depreciacionactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(depreciacionactivofijoLogic.getDepreciacionActivoFijos());
					tipodepreciacionempresa.setDepreciacionActivoFijos(depreciacionactivofijoLogic.getDepreciacionActivoFijos());
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
			tipodepreciacionempresa.setEmpresa(tipodepreciacionempresaDataAccess.getEmpresa(connexion,tipodepreciacionempresa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleActivoFijo.class));
			tipodepreciacionempresa.setDetalleActivoFijos(tipodepreciacionempresaDataAccess.getDetalleActivoFijos(connexion,tipodepreciacionempresa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DepreciacionActivoFijo.class));
			tipodepreciacionempresa.setDepreciacionActivoFijos(tipodepreciacionempresaDataAccess.getDepreciacionActivoFijos(connexion,tipodepreciacionempresa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodepreciacionempresa.setEmpresa(tipodepreciacionempresaDataAccess.getEmpresa(connexion,tipodepreciacionempresa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodepreciacionempresa.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipodepreciacionempresa.setDetalleActivoFijos(tipodepreciacionempresaDataAccess.getDetalleActivoFijos(connexion,tipodepreciacionempresa));

		for(DetalleActivoFijo detalleactivofijo:tipodepreciacionempresa.getDetalleActivoFijos()) {
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
		}

		tipodepreciacionempresa.setDepreciacionActivoFijos(tipodepreciacionempresaDataAccess.getDepreciacionActivoFijos(connexion,tipodepreciacionempresa));

		for(DepreciacionActivoFijo depreciacionactivofijo:tipodepreciacionempresa.getDepreciacionActivoFijos()) {
			DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
			depreciacionactivofijoLogic.deepLoad(depreciacionactivofijo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodepreciacionempresa.setEmpresa(tipodepreciacionempresaDataAccess.getEmpresa(connexion,tipodepreciacionempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipodepreciacionempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodepreciacionempresa.setDetalleActivoFijos(tipodepreciacionempresaDataAccess.getDetalleActivoFijos(connexion,tipodepreciacionempresa));

				for(DetalleActivoFijo detalleactivofijo:tipodepreciacionempresa.getDetalleActivoFijos()) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
					detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodepreciacionempresa.setDepreciacionActivoFijos(tipodepreciacionempresaDataAccess.getDepreciacionActivoFijos(connexion,tipodepreciacionempresa));

				for(DepreciacionActivoFijo depreciacionactivofijo:tipodepreciacionempresa.getDepreciacionActivoFijos()) {
					DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
					depreciacionactivofijoLogic.deepLoad(depreciacionactivofijo,isDeep,deepLoadType,clases);
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
			tipodepreciacionempresa.setEmpresa(tipodepreciacionempresaDataAccess.getEmpresa(connexion,tipodepreciacionempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipodepreciacionempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleActivoFijo.class));
			tipodepreciacionempresa.setDetalleActivoFijos(tipodepreciacionempresaDataAccess.getDetalleActivoFijos(connexion,tipodepreciacionempresa));

			for(DetalleActivoFijo detalleactivofijo:tipodepreciacionempresa.getDetalleActivoFijos()) {
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DepreciacionActivoFijo.class));
			tipodepreciacionempresa.setDepreciacionActivoFijos(tipodepreciacionempresaDataAccess.getDepreciacionActivoFijos(connexion,tipodepreciacionempresa));

			for(DepreciacionActivoFijo depreciacionactivofijo:tipodepreciacionempresa.getDepreciacionActivoFijos()) {
				DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
				depreciacionactivofijoLogic.deepLoad(depreciacionactivofijo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoDepreciacionEmpresa tipodepreciacionempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDepreciacionEmpresa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipodepreciacionempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(tipodepreciacionempresa);
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
			this.deepLoad(this.tipodepreciacionempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDepreciacionEmpresa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipodepreciacionempresas!=null) {
				for(TipoDepreciacionEmpresa tipodepreciacionempresa:tipodepreciacionempresas) {
					this.deepLoad(tipodepreciacionempresa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(tipodepreciacionempresas);
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
			if(tipodepreciacionempresas!=null) {
				for(TipoDepreciacionEmpresa tipodepreciacionempresa:tipodepreciacionempresas) {
					this.deepLoad(tipodepreciacionempresa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(tipodepreciacionempresas);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoDepreciacionEmpresasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDepreciacionEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodepreciacionempresas=tipodepreciacionempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDepreciacionEmpresasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDepreciacionEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodepreciacionempresas=tipodepreciacionempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDepreciacionEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(this.tipodepreciacionempresas);
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
			if(TipoDepreciacionEmpresaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDepreciacionEmpresaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoDepreciacionEmpresa tipodepreciacionempresa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoDepreciacionEmpresaConstantesFunciones.ISCONAUDITORIA) {
				if(tipodepreciacionempresa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDepreciacionEmpresaDataAccess.TABLENAME, tipodepreciacionempresa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDepreciacionEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDepreciacionEmpresaLogic.registrarAuditoriaDetallesTipoDepreciacionEmpresa(connexion,tipodepreciacionempresa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipodepreciacionempresa.getIsDeleted()) {
					/*if(!tipodepreciacionempresa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoDepreciacionEmpresaDataAccess.TABLENAME, tipodepreciacionempresa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoDepreciacionEmpresaLogic.registrarAuditoriaDetallesTipoDepreciacionEmpresa(connexion,tipodepreciacionempresa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDepreciacionEmpresaDataAccess.TABLENAME, tipodepreciacionempresa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipodepreciacionempresa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDepreciacionEmpresaDataAccess.TABLENAME, tipodepreciacionempresa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDepreciacionEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDepreciacionEmpresaLogic.registrarAuditoriaDetallesTipoDepreciacionEmpresa(connexion,tipodepreciacionempresa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoDepreciacionEmpresa(Connexion connexion,TipoDepreciacionEmpresa tipodepreciacionempresa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipodepreciacionempresa.getIsNew()||!tipodepreciacionempresa.getid_empresa().equals(tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getid_empresa().toString();
				}
				if(tipodepreciacionempresa.getid_empresa()!=null)
				{
					strValorNuevo=tipodepreciacionempresa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipodepreciacionempresa.getIsNew()||!tipodepreciacionempresa.getcodigo().equals(tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getcodigo()!=null)
				{
					strValorActual=tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getcodigo();
				}
				if(tipodepreciacionempresa.getcodigo()!=null)
				{
					strValorNuevo=tipodepreciacionempresa.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDepreciacionEmpresaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipodepreciacionempresa.getIsNew()||!tipodepreciacionempresa.getnombre().equals(tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getnombre()!=null)
				{
					strValorActual=tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getnombre();
				}
				if(tipodepreciacionempresa.getnombre()!=null)
				{
					strValorNuevo=tipodepreciacionempresa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDepreciacionEmpresaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipodepreciacionempresa.getIsNew()||!tipodepreciacionempresa.getes_linea_recta().equals(tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getes_linea_recta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getes_linea_recta()!=null)
				{
					strValorActual=tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getes_linea_recta().toString();
				}
				if(tipodepreciacionempresa.getes_linea_recta()!=null)
				{
					strValorNuevo=tipodepreciacionempresa.getes_linea_recta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDepreciacionEmpresaConstantesFunciones.ESLINEARECTA,strValorActual,strValorNuevo);
			}	
			
			if(tipodepreciacionempresa.getIsNew()||!tipodepreciacionempresa.getes_mensual().equals(tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getes_mensual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getes_mensual()!=null)
				{
					strValorActual=tipodepreciacionempresa.getTipoDepreciacionEmpresaOriginal().getes_mensual().toString();
				}
				if(tipodepreciacionempresa.getes_mensual()!=null)
				{
					strValorNuevo=tipodepreciacionempresa.getes_mensual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDepreciacionEmpresaConstantesFunciones.ESMENSUAL,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDepreciacionEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDepreciacionEmpresaConstantesFunciones.getClassesForeignKeysOfTipoDepreciacionEmpresa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDepreciacionEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDepreciacionEmpresaConstantesFunciones.getClassesRelationshipsOfTipoDepreciacionEmpresa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

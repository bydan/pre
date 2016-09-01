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
import com.bydan.erp.produccion.util.TipoMaquinaEmpresaConstantesFunciones;
import com.bydan.erp.produccion.util.TipoMaquinaEmpresaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoMaquinaEmpresaParameterGeneral;
import com.bydan.erp.produccion.business.entity.TipoMaquinaEmpresa;
import com.bydan.erp.produccion.business.logic.TipoMaquinaEmpresaLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoMaquinaEmpresaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoMaquinaEmpresaLogic.class);
	
	protected TipoMaquinaEmpresaDataAccess tipomaquinaempresaDataAccess; 	
	protected TipoMaquinaEmpresa tipomaquinaempresa;
	protected List<TipoMaquinaEmpresa> tipomaquinaempresas;
	protected Object tipomaquinaempresaObject;	
	protected List<Object> tipomaquinaempresasObject;
	
	public static ClassValidator<TipoMaquinaEmpresa> tipomaquinaempresaValidator = new ClassValidator<TipoMaquinaEmpresa>(TipoMaquinaEmpresa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoMaquinaEmpresaLogicAdditional tipomaquinaempresaLogicAdditional=null;
	
	public TipoMaquinaEmpresaLogicAdditional getTipoMaquinaEmpresaLogicAdditional() {
		return this.tipomaquinaempresaLogicAdditional;
	}
	
	public void setTipoMaquinaEmpresaLogicAdditional(TipoMaquinaEmpresaLogicAdditional tipomaquinaempresaLogicAdditional) {
		try {
			this.tipomaquinaempresaLogicAdditional=tipomaquinaempresaLogicAdditional;
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
	
	
	
	
	public  TipoMaquinaEmpresaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipomaquinaempresaDataAccess = new TipoMaquinaEmpresaDataAccess();
			
			this.tipomaquinaempresas= new ArrayList<TipoMaquinaEmpresa>();
			this.tipomaquinaempresa= new TipoMaquinaEmpresa();
			
			this.tipomaquinaempresaObject=new Object();
			this.tipomaquinaempresasObject=new ArrayList<Object>();
				
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
			
			this.tipomaquinaempresaDataAccess.setConnexionType(this.connexionType);
			this.tipomaquinaempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoMaquinaEmpresaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipomaquinaempresaDataAccess = new TipoMaquinaEmpresaDataAccess();
			this.tipomaquinaempresas= new ArrayList<TipoMaquinaEmpresa>();
			this.tipomaquinaempresa= new TipoMaquinaEmpresa();
			this.tipomaquinaempresaObject=new Object();
			this.tipomaquinaempresasObject=new ArrayList<Object>();
			
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
			
			this.tipomaquinaempresaDataAccess.setConnexionType(this.connexionType);
			this.tipomaquinaempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoMaquinaEmpresa getTipoMaquinaEmpresa() throws Exception {	
		TipoMaquinaEmpresaLogicAdditional.checkTipoMaquinaEmpresaToGet(tipomaquinaempresa,this.datosCliente,this.arrDatoGeneral);
		TipoMaquinaEmpresaLogicAdditional.updateTipoMaquinaEmpresaToGet(tipomaquinaempresa,this.arrDatoGeneral);
		
		return tipomaquinaempresa;
	}
		
	public void setTipoMaquinaEmpresa(TipoMaquinaEmpresa newTipoMaquinaEmpresa) {
		this.tipomaquinaempresa = newTipoMaquinaEmpresa;
	}
	
	public TipoMaquinaEmpresaDataAccess getTipoMaquinaEmpresaDataAccess() {
		return tipomaquinaempresaDataAccess;
	}
	
	public void setTipoMaquinaEmpresaDataAccess(TipoMaquinaEmpresaDataAccess newtipomaquinaempresaDataAccess) {
		this.tipomaquinaempresaDataAccess = newtipomaquinaempresaDataAccess;
	}
	
	public List<TipoMaquinaEmpresa> getTipoMaquinaEmpresas() throws Exception {		
		this.quitarTipoMaquinaEmpresasNulos();
		
		TipoMaquinaEmpresaLogicAdditional.checkTipoMaquinaEmpresaToGets(tipomaquinaempresas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoMaquinaEmpresa tipomaquinaempresaLocal: tipomaquinaempresas ) {
			TipoMaquinaEmpresaLogicAdditional.updateTipoMaquinaEmpresaToGet(tipomaquinaempresaLocal,this.arrDatoGeneral);
		}
		
		return tipomaquinaempresas;
	}
	
	public void setTipoMaquinaEmpresas(List<TipoMaquinaEmpresa> newTipoMaquinaEmpresas) {
		this.tipomaquinaempresas = newTipoMaquinaEmpresas;
	}
	
	public Object getTipoMaquinaEmpresaObject() {	
		this.tipomaquinaempresaObject=this.tipomaquinaempresaDataAccess.getEntityObject();
		return this.tipomaquinaempresaObject;
	}
		
	public void setTipoMaquinaEmpresaObject(Object newTipoMaquinaEmpresaObject) {
		this.tipomaquinaempresaObject = newTipoMaquinaEmpresaObject;
	}
	
	public List<Object> getTipoMaquinaEmpresasObject() {		
		this.tipomaquinaempresasObject=this.tipomaquinaempresaDataAccess.getEntitiesObject();
		return this.tipomaquinaempresasObject;
	}
		
	public void setTipoMaquinaEmpresasObject(List<Object> newTipoMaquinaEmpresasObject) {
		this.tipomaquinaempresasObject = newTipoMaquinaEmpresasObject;
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
		
		if(this.tipomaquinaempresaDataAccess!=null) {
			this.tipomaquinaempresaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipomaquinaempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipomaquinaempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomaquinaempresa=tipomaquinaempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomaquinaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresa);
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
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		  		  
        try {
			
			tipomaquinaempresa=tipomaquinaempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomaquinaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomaquinaempresa=tipomaquinaempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomaquinaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresa);
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
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		  		  
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
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		  		  
        try {
			
			tipomaquinaempresa=tipomaquinaempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomaquinaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		  		  
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
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipomaquinaempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipomaquinaempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipomaquinaempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipomaquinaempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipomaquinaempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipomaquinaempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomaquinaempresas = new  ArrayList<TipoMaquinaEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMaquinaEmpresa(tipomaquinaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
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
		tipomaquinaempresas = new  ArrayList<TipoMaquinaEmpresa>();
		  		  
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
		tipomaquinaempresas = new  ArrayList<TipoMaquinaEmpresa>();
		  		  
        try {			
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoMaquinaEmpresa(tipomaquinaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipomaquinaempresas = new  ArrayList<TipoMaquinaEmpresa>();
		  		  
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
		tipomaquinaempresas = new  ArrayList<TipoMaquinaEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMaquinaEmpresa(tipomaquinaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
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
		tipomaquinaempresas = new  ArrayList<TipoMaquinaEmpresa>();
		  		  
        try {
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMaquinaEmpresa(tipomaquinaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
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
		tipomaquinaempresas = new  ArrayList<TipoMaquinaEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMaquinaEmpresa(tipomaquinaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
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
		tipomaquinaempresas = new  ArrayList<TipoMaquinaEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMaquinaEmpresa(tipomaquinaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomaquinaempresa=tipomaquinaempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMaquinaEmpresa(tipomaquinaempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresa);
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
		tipomaquinaempresa = new  TipoMaquinaEmpresa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomaquinaempresa=tipomaquinaempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMaquinaEmpresa(tipomaquinaempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomaquinaempresas = new  ArrayList<TipoMaquinaEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMaquinaEmpresa(tipomaquinaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
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
		tipomaquinaempresas = new  ArrayList<TipoMaquinaEmpresa>();
		  		  
        try {
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMaquinaEmpresa(tipomaquinaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoMaquinaEmpresasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipomaquinaempresas = new  ArrayList<TipoMaquinaEmpresa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getTodosTipoMaquinaEmpresasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoMaquinaEmpresa(tipomaquinaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
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
	
	public  void  getTodosTipoMaquinaEmpresas(String sFinalQuery,Pagination pagination)throws Exception {
		tipomaquinaempresas = new  ArrayList<TipoMaquinaEmpresa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoMaquinaEmpresa(tipomaquinaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoMaquinaEmpresa(TipoMaquinaEmpresa tipomaquinaempresa) throws Exception {
		Boolean estaValidado=false;
		
		if(tipomaquinaempresa.getIsNew() || tipomaquinaempresa.getIsChanged()) { 
			this.invalidValues = tipomaquinaempresaValidator.getInvalidValues(tipomaquinaempresa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipomaquinaempresa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoMaquinaEmpresa(List<TipoMaquinaEmpresa> TipoMaquinaEmpresas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoMaquinaEmpresa tipomaquinaempresaLocal:tipomaquinaempresas) {				
			estaValidadoObjeto=this.validarGuardarTipoMaquinaEmpresa(tipomaquinaempresaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoMaquinaEmpresa(List<TipoMaquinaEmpresa> TipoMaquinaEmpresas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoMaquinaEmpresa(tipomaquinaempresas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoMaquinaEmpresa(TipoMaquinaEmpresa TipoMaquinaEmpresa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoMaquinaEmpresa(tipomaquinaempresa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoMaquinaEmpresa tipomaquinaempresa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipomaquinaempresa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoMaquinaEmpresaConstantesFunciones.getTipoMaquinaEmpresaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipomaquinaempresa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoMaquinaEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoMaquinaEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoMaquinaEmpresaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-saveTipoMaquinaEmpresaWithConnection");connexion.begin();			
			
			TipoMaquinaEmpresaLogicAdditional.checkTipoMaquinaEmpresaToSave(this.tipomaquinaempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoMaquinaEmpresaLogicAdditional.updateTipoMaquinaEmpresaToSave(this.tipomaquinaempresa,this.arrDatoGeneral);
			
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomaquinaempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoMaquinaEmpresa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoMaquinaEmpresa(this.tipomaquinaempresa)) {
				TipoMaquinaEmpresaDataAccess.save(this.tipomaquinaempresa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipomaquinaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoMaquinaEmpresaLogicAdditional.checkTipoMaquinaEmpresaToSaveAfter(this.tipomaquinaempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoMaquinaEmpresa();
			
			connexion.commit();			
			
			if(this.tipomaquinaempresa.getIsDeleted()) {
				this.tipomaquinaempresa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoMaquinaEmpresa()throws Exception {	
		try {	
			
			TipoMaquinaEmpresaLogicAdditional.checkTipoMaquinaEmpresaToSave(this.tipomaquinaempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoMaquinaEmpresaLogicAdditional.updateTipoMaquinaEmpresaToSave(this.tipomaquinaempresa,this.arrDatoGeneral);
			
			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomaquinaempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoMaquinaEmpresa(this.tipomaquinaempresa)) {			
				TipoMaquinaEmpresaDataAccess.save(this.tipomaquinaempresa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipomaquinaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoMaquinaEmpresaLogicAdditional.checkTipoMaquinaEmpresaToSaveAfter(this.tipomaquinaempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipomaquinaempresa.getIsDeleted()) {
				this.tipomaquinaempresa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoMaquinaEmpresasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-saveTipoMaquinaEmpresasWithConnection");connexion.begin();			
			
			TipoMaquinaEmpresaLogicAdditional.checkTipoMaquinaEmpresaToSaves(tipomaquinaempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoMaquinaEmpresas();
			
			Boolean validadoTodosTipoMaquinaEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoMaquinaEmpresa tipomaquinaempresaLocal:tipomaquinaempresas) {		
				if(tipomaquinaempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoMaquinaEmpresaLogicAdditional.updateTipoMaquinaEmpresaToSave(tipomaquinaempresaLocal,this.arrDatoGeneral);
	        	
				TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomaquinaempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoMaquinaEmpresa(tipomaquinaempresaLocal)) {
					TipoMaquinaEmpresaDataAccess.save(tipomaquinaempresaLocal, connexion);				
				} else {
					validadoTodosTipoMaquinaEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoMaquinaEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoMaquinaEmpresaLogicAdditional.checkTipoMaquinaEmpresaToSavesAfter(tipomaquinaempresas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoMaquinaEmpresas();
			
			connexion.commit();		
			
			this.quitarTipoMaquinaEmpresasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoMaquinaEmpresas()throws Exception {				
		 try {	
			TipoMaquinaEmpresaLogicAdditional.checkTipoMaquinaEmpresaToSaves(tipomaquinaempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoMaquinaEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoMaquinaEmpresa tipomaquinaempresaLocal:tipomaquinaempresas) {				
				if(tipomaquinaempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoMaquinaEmpresaLogicAdditional.updateTipoMaquinaEmpresaToSave(tipomaquinaempresaLocal,this.arrDatoGeneral);
	        	
				TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomaquinaempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoMaquinaEmpresa(tipomaquinaempresaLocal)) {				
					TipoMaquinaEmpresaDataAccess.save(tipomaquinaempresaLocal, connexion);				
				} else {
					validadoTodosTipoMaquinaEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoMaquinaEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoMaquinaEmpresaLogicAdditional.checkTipoMaquinaEmpresaToSavesAfter(tipomaquinaempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoMaquinaEmpresasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoMaquinaEmpresaParameterReturnGeneral procesarAccionTipoMaquinaEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoMaquinaEmpresa> tipomaquinaempresas,TipoMaquinaEmpresaParameterReturnGeneral tipomaquinaempresaParameterGeneral)throws Exception {
		 try {	
			TipoMaquinaEmpresaParameterReturnGeneral tipomaquinaempresaReturnGeneral=new TipoMaquinaEmpresaParameterReturnGeneral();
	
			TipoMaquinaEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipomaquinaempresas,tipomaquinaempresaParameterGeneral,tipomaquinaempresaReturnGeneral);
			
			return tipomaquinaempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoMaquinaEmpresaParameterReturnGeneral procesarAccionTipoMaquinaEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoMaquinaEmpresa> tipomaquinaempresas,TipoMaquinaEmpresaParameterReturnGeneral tipomaquinaempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-procesarAccionTipoMaquinaEmpresasWithConnection");connexion.begin();			
			
			TipoMaquinaEmpresaParameterReturnGeneral tipomaquinaempresaReturnGeneral=new TipoMaquinaEmpresaParameterReturnGeneral();
	
			TipoMaquinaEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipomaquinaempresas,tipomaquinaempresaParameterGeneral,tipomaquinaempresaReturnGeneral);
			
			this.connexion.commit();
			
			return tipomaquinaempresaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoMaquinaEmpresaParameterReturnGeneral procesarEventosTipoMaquinaEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoMaquinaEmpresa> tipomaquinaempresas,TipoMaquinaEmpresa tipomaquinaempresa,TipoMaquinaEmpresaParameterReturnGeneral tipomaquinaempresaParameterGeneral,Boolean isEsNuevoTipoMaquinaEmpresa,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoMaquinaEmpresaParameterReturnGeneral tipomaquinaempresaReturnGeneral=new TipoMaquinaEmpresaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomaquinaempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoMaquinaEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipomaquinaempresas,tipomaquinaempresa,tipomaquinaempresaParameterGeneral,tipomaquinaempresaReturnGeneral,isEsNuevoTipoMaquinaEmpresa,clases);
			
			return tipomaquinaempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoMaquinaEmpresaParameterReturnGeneral procesarEventosTipoMaquinaEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoMaquinaEmpresa> tipomaquinaempresas,TipoMaquinaEmpresa tipomaquinaempresa,TipoMaquinaEmpresaParameterReturnGeneral tipomaquinaempresaParameterGeneral,Boolean isEsNuevoTipoMaquinaEmpresa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-procesarEventosTipoMaquinaEmpresasWithConnection");connexion.begin();			
			
			TipoMaquinaEmpresaParameterReturnGeneral tipomaquinaempresaReturnGeneral=new TipoMaquinaEmpresaParameterReturnGeneral();
	
			tipomaquinaempresaReturnGeneral.setTipoMaquinaEmpresa(tipomaquinaempresa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomaquinaempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoMaquinaEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipomaquinaempresas,tipomaquinaempresa,tipomaquinaempresaParameterGeneral,tipomaquinaempresaReturnGeneral,isEsNuevoTipoMaquinaEmpresa,clases);
			
			this.connexion.commit();
			
			return tipomaquinaempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoMaquinaEmpresaParameterReturnGeneral procesarImportacionTipoMaquinaEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoMaquinaEmpresaParameterReturnGeneral tipomaquinaempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-procesarImportacionTipoMaquinaEmpresasWithConnection");connexion.begin();			
			
			TipoMaquinaEmpresaParameterReturnGeneral tipomaquinaempresaReturnGeneral=new TipoMaquinaEmpresaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipomaquinaempresas=new ArrayList<TipoMaquinaEmpresa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipomaquinaempresa=new TipoMaquinaEmpresa();
				
				
				if(conColumnasBase) {this.tipomaquinaempresa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipomaquinaempresa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipomaquinaempresa.setcodigo(arrColumnas[iColumn++]);
				this.tipomaquinaempresa.setnombre(arrColumnas[iColumn++]);
				this.tipomaquinaempresa.setmarca(arrColumnas[iColumn++]);
				this.tipomaquinaempresa.setmodelo(arrColumnas[iColumn++]);
				this.tipomaquinaempresa.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.tipomaquinaempresa.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tipomaquinaempresas.add(this.tipomaquinaempresa);
			}
			
			this.saveTipoMaquinaEmpresas();
			
			this.connexion.commit();
			
			tipomaquinaempresaReturnGeneral.setConRetornoEstaProcesado(true);
			tipomaquinaempresaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipomaquinaempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoMaquinaEmpresasEliminados() throws Exception {				
		
		List<TipoMaquinaEmpresa> tipomaquinaempresasAux= new ArrayList<TipoMaquinaEmpresa>();
		
		for(TipoMaquinaEmpresa tipomaquinaempresa:tipomaquinaempresas) {
			if(!tipomaquinaempresa.getIsDeleted()) {
				tipomaquinaempresasAux.add(tipomaquinaempresa);
			}
		}
		
		tipomaquinaempresas=tipomaquinaempresasAux;
	}
	
	public void quitarTipoMaquinaEmpresasNulos() throws Exception {				
		
		List<TipoMaquinaEmpresa> tipomaquinaempresasAux= new ArrayList<TipoMaquinaEmpresa>();
		
		for(TipoMaquinaEmpresa tipomaquinaempresa : this.tipomaquinaempresas) {
			if(tipomaquinaempresa==null) {
				tipomaquinaempresasAux.add(tipomaquinaempresa);
			}
		}
		
		//this.tipomaquinaempresas=tipomaquinaempresasAux;
		
		this.tipomaquinaempresas.removeAll(tipomaquinaempresasAux);
	}
	
	public void getSetVersionRowTipoMaquinaEmpresaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipomaquinaempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipomaquinaempresa.getIsDeleted() || (tipomaquinaempresa.getIsChanged()&&!tipomaquinaempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipomaquinaempresaDataAccess.getSetVersionRowTipoMaquinaEmpresa(connexion,tipomaquinaempresa.getId());
				
				if(!tipomaquinaempresa.getVersionRow().equals(timestamp)) {	
					tipomaquinaempresa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipomaquinaempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoMaquinaEmpresa()throws Exception {	
		
		if(tipomaquinaempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipomaquinaempresa.getIsDeleted() || (tipomaquinaempresa.getIsChanged()&&!tipomaquinaempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipomaquinaempresaDataAccess.getSetVersionRowTipoMaquinaEmpresa(connexion,tipomaquinaempresa.getId());
			
			try {							
				if(!tipomaquinaempresa.getVersionRow().equals(timestamp)) {	
					tipomaquinaempresa.setVersionRow(timestamp);
				}
				
				tipomaquinaempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoMaquinaEmpresasWithConnection()throws Exception {	
		if(tipomaquinaempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoMaquinaEmpresa tipomaquinaempresaAux:tipomaquinaempresas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipomaquinaempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomaquinaempresaAux.getIsDeleted() || (tipomaquinaempresaAux.getIsChanged()&&!tipomaquinaempresaAux.getIsNew())) {
						
						timestamp=tipomaquinaempresaDataAccess.getSetVersionRowTipoMaquinaEmpresa(connexion,tipomaquinaempresaAux.getId());
						
						if(!tipomaquinaempresa.getVersionRow().equals(timestamp)) {	
							tipomaquinaempresaAux.setVersionRow(timestamp);
						}
								
						tipomaquinaempresaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoMaquinaEmpresas()throws Exception {	
		if(tipomaquinaempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoMaquinaEmpresa tipomaquinaempresaAux:tipomaquinaempresas) {
					if(tipomaquinaempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomaquinaempresaAux.getIsDeleted() || (tipomaquinaempresaAux.getIsChanged()&&!tipomaquinaempresaAux.getIsNew())) {
						
						timestamp=tipomaquinaempresaDataAccess.getSetVersionRowTipoMaquinaEmpresa(connexion,tipomaquinaempresaAux.getId());
						
						if(!tipomaquinaempresaAux.getVersionRow().equals(timestamp)) {	
							tipomaquinaempresaAux.setVersionRow(timestamp);
						}
						
													
						tipomaquinaempresaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoMaquinaEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoMaquinaEmpresaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito) throws Exception {
		TipoMaquinaEmpresaParameterReturnGeneral  tipomaquinaempresaReturnGeneral =new TipoMaquinaEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoMaquinaEmpresaWithConnection");connexion.begin();
			
			tipomaquinaempresaReturnGeneral =new TipoMaquinaEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipomaquinaempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tipomaquinaempresaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			tipomaquinaempresaReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			tipomaquinaempresaReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipomaquinaempresaReturnGeneral;
	}
	
	public TipoMaquinaEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoMaquinaEmpresa(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito) throws Exception {
		TipoMaquinaEmpresaParameterReturnGeneral  tipomaquinaempresaReturnGeneral =new TipoMaquinaEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipomaquinaempresaReturnGeneral =new TipoMaquinaEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipomaquinaempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tipomaquinaempresaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			tipomaquinaempresaReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			tipomaquinaempresaReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipomaquinaempresaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoMaquinaEmpresaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic=new ProductoOrdenDetaProduMaquinaLogic();
			ProductoProduMaquinaLogic productoprodumaquinaLogic=new ProductoProduMaquinaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoMaquinaEmpresaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ProductoOrdenDetaProduMaquina.class));
			classes.add(new Classe(ProductoProduMaquina.class));
											
			

			productoordendetaprodumaquinaLogic.setConnexion(this.getConnexion());
			productoordendetaprodumaquinaLogic.setDatosCliente(this.datosCliente);
			productoordendetaprodumaquinaLogic.setIsConRefrescarForeignKeys(true);

			productoprodumaquinaLogic.setConnexion(this.getConnexion());
			productoprodumaquinaLogic.setDatosCliente(this.datosCliente);
			productoprodumaquinaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoMaquinaEmpresa tipomaquinaempresa:this.tipomaquinaempresas) {
				

				classes=new ArrayList<Classe>();
				classes=ProductoOrdenDetaProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoordendetaprodumaquinaLogic.setProductoOrdenDetaProduMaquinas(tipomaquinaempresa.productoordendetaprodumaquinas);
				productoordendetaprodumaquinaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoprodumaquinaLogic.setProductoProduMaquinas(tipomaquinaempresa.productoprodumaquinas);
				productoprodumaquinaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoMaquinaEmpresa tipomaquinaempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoMaquinaEmpresaLogicAdditional.updateTipoMaquinaEmpresaToGet(tipomaquinaempresa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomaquinaempresa.setEmpresa(tipomaquinaempresaDataAccess.getEmpresa(connexion,tipomaquinaempresa));
		tipomaquinaempresa.setSucursal(tipomaquinaempresaDataAccess.getSucursal(connexion,tipomaquinaempresa));
		tipomaquinaempresa.setCuentaContableDebito(tipomaquinaempresaDataAccess.getCuentaContableDebito(connexion,tipomaquinaempresa));
		tipomaquinaempresa.setCuentaContableCredito(tipomaquinaempresaDataAccess.getCuentaContableCredito(connexion,tipomaquinaempresa));
		tipomaquinaempresa.setProductoOrdenDetaProduMaquinas(tipomaquinaempresaDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipomaquinaempresa));
		tipomaquinaempresa.setProductoProduMaquinas(tipomaquinaempresaDataAccess.getProductoProduMaquinas(connexion,tipomaquinaempresa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipomaquinaempresa.setEmpresa(tipomaquinaempresaDataAccess.getEmpresa(connexion,tipomaquinaempresa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tipomaquinaempresa.setSucursal(tipomaquinaempresaDataAccess.getSucursal(connexion,tipomaquinaempresa));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipomaquinaempresa.setCuentaContableDebito(tipomaquinaempresaDataAccess.getCuentaContableDebito(connexion,tipomaquinaempresa));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipomaquinaempresa.setCuentaContableCredito(tipomaquinaempresaDataAccess.getCuentaContableCredito(connexion,tipomaquinaempresa));
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomaquinaempresa.setProductoOrdenDetaProduMaquinas(tipomaquinaempresaDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipomaquinaempresa));

				if(this.isConDeep) {
					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(this.connexion);
					productoordendetaprodumaquinaLogic.setProductoOrdenDetaProduMaquinas(tipomaquinaempresa.getProductoOrdenDetaProduMaquinas());
					ArrayList<Classe> classesLocal=ProductoOrdenDetaProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoordendetaprodumaquinaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(productoordendetaprodumaquinaLogic.getProductoOrdenDetaProduMaquinas());
					tipomaquinaempresa.setProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinaLogic.getProductoOrdenDetaProduMaquinas());
				}

				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomaquinaempresa.setProductoProduMaquinas(tipomaquinaempresaDataAccess.getProductoProduMaquinas(connexion,tipomaquinaempresa));

				if(this.isConDeep) {
					ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(this.connexion);
					productoprodumaquinaLogic.setProductoProduMaquinas(tipomaquinaempresa.getProductoProduMaquinas());
					ArrayList<Classe> classesLocal=ProductoProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoprodumaquinaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(productoprodumaquinaLogic.getProductoProduMaquinas());
					tipomaquinaempresa.setProductoProduMaquinas(productoprodumaquinaLogic.getProductoProduMaquinas());
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
			tipomaquinaempresa.setEmpresa(tipomaquinaempresaDataAccess.getEmpresa(connexion,tipomaquinaempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipomaquinaempresa.setSucursal(tipomaquinaempresaDataAccess.getSucursal(connexion,tipomaquinaempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipomaquinaempresa.setCuentaContableDebito(tipomaquinaempresaDataAccess.getCuentaContableDebito(connexion,tipomaquinaempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipomaquinaempresa.setCuentaContableCredito(tipomaquinaempresaDataAccess.getCuentaContableCredito(connexion,tipomaquinaempresa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduMaquina.class));
			tipomaquinaempresa.setProductoOrdenDetaProduMaquinas(tipomaquinaempresaDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipomaquinaempresa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduMaquina.class));
			tipomaquinaempresa.setProductoProduMaquinas(tipomaquinaempresaDataAccess.getProductoProduMaquinas(connexion,tipomaquinaempresa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomaquinaempresa.setEmpresa(tipomaquinaempresaDataAccess.getEmpresa(connexion,tipomaquinaempresa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipomaquinaempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		tipomaquinaempresa.setSucursal(tipomaquinaempresaDataAccess.getSucursal(connexion,tipomaquinaempresa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tipomaquinaempresa.getSucursal(),isDeep,deepLoadType,clases);
				
		tipomaquinaempresa.setCuentaContableDebito(tipomaquinaempresaDataAccess.getCuentaContableDebito(connexion,tipomaquinaempresa));
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(tipomaquinaempresa.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		tipomaquinaempresa.setCuentaContableCredito(tipomaquinaempresaDataAccess.getCuentaContableCredito(connexion,tipomaquinaempresa));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(tipomaquinaempresa.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				

		tipomaquinaempresa.setProductoOrdenDetaProduMaquinas(tipomaquinaempresaDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipomaquinaempresa));

		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipomaquinaempresa.getProductoOrdenDetaProduMaquinas()) {
			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
			productoordendetaprodumaquinaLogic.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
		}

		tipomaquinaempresa.setProductoProduMaquinas(tipomaquinaempresaDataAccess.getProductoProduMaquinas(connexion,tipomaquinaempresa));

		for(ProductoProduMaquina productoprodumaquina:tipomaquinaempresa.getProductoProduMaquinas()) {
			ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
			productoprodumaquinaLogic.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipomaquinaempresa.setEmpresa(tipomaquinaempresaDataAccess.getEmpresa(connexion,tipomaquinaempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipomaquinaempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tipomaquinaempresa.setSucursal(tipomaquinaempresaDataAccess.getSucursal(connexion,tipomaquinaempresa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(tipomaquinaempresa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipomaquinaempresa.setCuentaContableDebito(tipomaquinaempresaDataAccess.getCuentaContableDebito(connexion,tipomaquinaempresa));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tipomaquinaempresa.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipomaquinaempresa.setCuentaContableCredito(tipomaquinaempresaDataAccess.getCuentaContableCredito(connexion,tipomaquinaempresa));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tipomaquinaempresa.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomaquinaempresa.setProductoOrdenDetaProduMaquinas(tipomaquinaempresaDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipomaquinaempresa));

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipomaquinaempresa.getProductoOrdenDetaProduMaquinas()) {
					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
					productoordendetaprodumaquinaLogic.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomaquinaempresa.setProductoProduMaquinas(tipomaquinaempresaDataAccess.getProductoProduMaquinas(connexion,tipomaquinaempresa));

				for(ProductoProduMaquina productoprodumaquina:tipomaquinaempresa.getProductoProduMaquinas()) {
					ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
					productoprodumaquinaLogic.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);
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
			tipomaquinaempresa.setEmpresa(tipomaquinaempresaDataAccess.getEmpresa(connexion,tipomaquinaempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipomaquinaempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipomaquinaempresa.setSucursal(tipomaquinaempresaDataAccess.getSucursal(connexion,tipomaquinaempresa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(tipomaquinaempresa.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipomaquinaempresa.setCuentaContableDebito(tipomaquinaempresaDataAccess.getCuentaContableDebito(connexion,tipomaquinaempresa));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tipomaquinaempresa.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipomaquinaempresa.setCuentaContableCredito(tipomaquinaempresaDataAccess.getCuentaContableCredito(connexion,tipomaquinaempresa));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tipomaquinaempresa.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduMaquina.class));
			tipomaquinaempresa.setProductoOrdenDetaProduMaquinas(tipomaquinaempresaDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipomaquinaempresa));

			for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipomaquinaempresa.getProductoOrdenDetaProduMaquinas()) {
				ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
				productoordendetaprodumaquinaLogic.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduMaquina.class));
			tipomaquinaempresa.setProductoProduMaquinas(tipomaquinaempresaDataAccess.getProductoProduMaquinas(connexion,tipomaquinaempresa));

			for(ProductoProduMaquina productoprodumaquina:tipomaquinaempresa.getProductoProduMaquinas()) {
				ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
				productoprodumaquinaLogic.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoMaquinaEmpresa tipomaquinaempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoMaquinaEmpresaLogicAdditional.updateTipoMaquinaEmpresaToSave(tipomaquinaempresa,this.arrDatoGeneral);
			
TipoMaquinaEmpresaDataAccess.save(tipomaquinaempresa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipomaquinaempresa.getEmpresa(),connexion);

		SucursalDataAccess.save(tipomaquinaempresa.getSucursal(),connexion);

		CuentaContableDataAccess.save(tipomaquinaempresa.getCuentaContableDebito(),connexion);

		CuentaContableDataAccess.save(tipomaquinaempresa.getCuentaContableCredito(),connexion);

		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipomaquinaempresa.getProductoOrdenDetaProduMaquinas()) {
			productoordendetaprodumaquina.setid_tipo_merma_empresa(tipomaquinaempresa.getId());
			ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
		}

		for(ProductoProduMaquina productoprodumaquina:tipomaquinaempresa.getProductoProduMaquinas()) {
			productoprodumaquina.setid_tipo_merma_empresa(tipomaquinaempresa.getId());
			ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipomaquinaempresa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tipomaquinaempresa.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipomaquinaempresa.getCuentaContableDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipomaquinaempresa.getCuentaContableCredito(),connexion);
				continue;
			}


			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipomaquinaempresa.getProductoOrdenDetaProduMaquinas()) {
					productoordendetaprodumaquina.setid_tipo_merma_empresa(tipomaquinaempresa.getId());
					ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMaquina productoprodumaquina:tipomaquinaempresa.getProductoProduMaquinas()) {
					productoprodumaquina.setid_tipo_merma_empresa(tipomaquinaempresa.getId());
					ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipomaquinaempresa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipomaquinaempresa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(tipomaquinaempresa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tipomaquinaempresa.getSucursal(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tipomaquinaempresa.getCuentaContableDebito(),connexion);
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(tipomaquinaempresa.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tipomaquinaempresa.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(tipomaquinaempresa.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				

		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipomaquinaempresa.getProductoOrdenDetaProduMaquinas()) {
			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
			productoordendetaprodumaquina.setid_tipo_merma_empresa(tipomaquinaempresa.getId());
			ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
			productoordendetaprodumaquinaLogic.deepSave(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
		}

		for(ProductoProduMaquina productoprodumaquina:tipomaquinaempresa.getProductoProduMaquinas()) {
			ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
			productoprodumaquina.setid_tipo_merma_empresa(tipomaquinaempresa.getId());
			ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
			productoprodumaquinaLogic.deepSave(productoprodumaquina,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipomaquinaempresa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipomaquinaempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tipomaquinaempresa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(tipomaquinaempresa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipomaquinaempresa.getCuentaContableDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tipomaquinaempresa.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipomaquinaempresa.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tipomaquinaempresa.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipomaquinaempresa.getProductoOrdenDetaProduMaquinas()) {
					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
					productoordendetaprodumaquina.setid_tipo_merma_empresa(tipomaquinaempresa.getId());
					ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
					productoordendetaprodumaquinaLogic.deepSave(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMaquina productoprodumaquina:tipomaquinaempresa.getProductoProduMaquinas()) {
					ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
					productoprodumaquina.setid_tipo_merma_empresa(tipomaquinaempresa.getId());
					ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
					productoprodumaquinaLogic.deepSave(productoprodumaquina,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoMaquinaEmpresa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipomaquinaempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(tipomaquinaempresa);
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
			this.deepLoad(this.tipomaquinaempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoMaquinaEmpresa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipomaquinaempresas!=null) {
				for(TipoMaquinaEmpresa tipomaquinaempresa:tipomaquinaempresas) {
					this.deepLoad(tipomaquinaempresa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(tipomaquinaempresas);
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
			if(tipomaquinaempresas!=null) {
				for(TipoMaquinaEmpresa tipomaquinaempresa:tipomaquinaempresas) {
					this.deepLoad(tipomaquinaempresa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(tipomaquinaempresas);
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
			this.getNewConnexionToDeep(TipoMaquinaEmpresa.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipomaquinaempresa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoMaquinaEmpresa.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipomaquinaempresas!=null) {
				for(TipoMaquinaEmpresa tipomaquinaempresa:tipomaquinaempresas) {
					this.deepSave(tipomaquinaempresa,isDeep,deepLoadType,clases);
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
			if(tipomaquinaempresas!=null) {
				for(TipoMaquinaEmpresa tipomaquinaempresa:tipomaquinaempresas) {
					this.deepSave(tipomaquinaempresa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoMaquinaEmpresasFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMaquinaEmpresasFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoMaquinaEmpresasFK_IdCuentaContableDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMaquinaEmpresasFK_IdCuentaContableDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoMaquinaEmpresasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMaquinaEmpresasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoMaquinaEmpresasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMaquinaEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMaquinaEmpresasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TipoMaquinaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomaquinaempresas=tipomaquinaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMaquinaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(this.tipomaquinaempresas);
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
			if(TipoMaquinaEmpresaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMaquinaEmpresaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoMaquinaEmpresa tipomaquinaempresa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoMaquinaEmpresaConstantesFunciones.ISCONAUDITORIA) {
				if(tipomaquinaempresa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMaquinaEmpresaDataAccess.TABLENAME, tipomaquinaempresa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoMaquinaEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoMaquinaEmpresaLogic.registrarAuditoriaDetallesTipoMaquinaEmpresa(connexion,tipomaquinaempresa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipomaquinaempresa.getIsDeleted()) {
					/*if(!tipomaquinaempresa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoMaquinaEmpresaDataAccess.TABLENAME, tipomaquinaempresa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoMaquinaEmpresaLogic.registrarAuditoriaDetallesTipoMaquinaEmpresa(connexion,tipomaquinaempresa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMaquinaEmpresaDataAccess.TABLENAME, tipomaquinaempresa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipomaquinaempresa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMaquinaEmpresaDataAccess.TABLENAME, tipomaquinaempresa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoMaquinaEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoMaquinaEmpresaLogic.registrarAuditoriaDetallesTipoMaquinaEmpresa(connexion,tipomaquinaempresa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoMaquinaEmpresa(Connexion connexion,TipoMaquinaEmpresa tipomaquinaempresa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipomaquinaempresa.getIsNew()||!tipomaquinaempresa.getid_empresa().equals(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getid_empresa().toString();
				}
				if(tipomaquinaempresa.getid_empresa()!=null)
				{
					strValorNuevo=tipomaquinaempresa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipomaquinaempresa.getIsNew()||!tipomaquinaempresa.getid_sucursal().equals(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getid_sucursal()!=null)
				{
					strValorActual=tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getid_sucursal().toString();
				}
				if(tipomaquinaempresa.getid_sucursal()!=null)
				{
					strValorNuevo=tipomaquinaempresa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(tipomaquinaempresa.getIsNew()||!tipomaquinaempresa.getid_cuenta_contable_debito().equals(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getid_cuenta_contable_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getid_cuenta_contable_debito()!=null)
				{
					strValorActual=tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getid_cuenta_contable_debito().toString();
				}
				if(tipomaquinaempresa.getid_cuenta_contable_debito()!=null)
				{
					strValorNuevo=tipomaquinaempresa.getid_cuenta_contable_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLEDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(tipomaquinaempresa.getIsNew()||!tipomaquinaempresa.getid_cuenta_contable_credito().equals(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getid_cuenta_contable_credito().toString();
				}
				if(tipomaquinaempresa.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=tipomaquinaempresa.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(tipomaquinaempresa.getIsNew()||!tipomaquinaempresa.getcodigo().equals(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getcodigo()!=null)
				{
					strValorActual=tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getcodigo();
				}
				if(tipomaquinaempresa.getcodigo()!=null)
				{
					strValorNuevo=tipomaquinaempresa.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMaquinaEmpresaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipomaquinaempresa.getIsNew()||!tipomaquinaempresa.getnombre().equals(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getnombre()!=null)
				{
					strValorActual=tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getnombre();
				}
				if(tipomaquinaempresa.getnombre()!=null)
				{
					strValorNuevo=tipomaquinaempresa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMaquinaEmpresaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipomaquinaempresa.getIsNew()||!tipomaquinaempresa.getmarca().equals(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getmarca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getmarca()!=null)
				{
					strValorActual=tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getmarca();
				}
				if(tipomaquinaempresa.getmarca()!=null)
				{
					strValorNuevo=tipomaquinaempresa.getmarca() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMaquinaEmpresaConstantesFunciones.MARCA,strValorActual,strValorNuevo);
			}	
			
			if(tipomaquinaempresa.getIsNew()||!tipomaquinaempresa.getmodelo().equals(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getmodelo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getmodelo()!=null)
				{
					strValorActual=tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getmodelo();
				}
				if(tipomaquinaempresa.getmodelo()!=null)
				{
					strValorNuevo=tipomaquinaempresa.getmodelo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMaquinaEmpresaConstantesFunciones.MODELO,strValorActual,strValorNuevo);
			}	
			
			if(tipomaquinaempresa.getIsNew()||!tipomaquinaempresa.getcosto().equals(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getcosto()!=null)
				{
					strValorActual=tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getcosto().toString();
				}
				if(tipomaquinaempresa.getcosto()!=null)
				{
					strValorNuevo=tipomaquinaempresa.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMaquinaEmpresaConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(tipomaquinaempresa.getIsNew()||!tipomaquinaempresa.getesta_activo().equals(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getesta_activo()!=null)
				{
					strValorActual=tipomaquinaempresa.getTipoMaquinaEmpresaOriginal().getesta_activo().toString();
				}
				if(tipomaquinaempresa.getesta_activo()!=null)
				{
					strValorNuevo=tipomaquinaempresa.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMaquinaEmpresaConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoMaquinaEmpresaRelacionesWithConnection(TipoMaquinaEmpresa tipomaquinaempresa,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoProduMaquina> productoprodumaquinas) throws Exception {

		if(!tipomaquinaempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoMaquinaEmpresaRelacionesBase(tipomaquinaempresa,productoordendetaprodumaquinas,productoprodumaquinas,true);
		}
	}

	public void saveTipoMaquinaEmpresaRelaciones(TipoMaquinaEmpresa tipomaquinaempresa,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoProduMaquina> productoprodumaquinas)throws Exception {

		if(!tipomaquinaempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoMaquinaEmpresaRelacionesBase(tipomaquinaempresa,productoordendetaprodumaquinas,productoprodumaquinas,false);
		}
	}

	public void saveTipoMaquinaEmpresaRelacionesBase(TipoMaquinaEmpresa tipomaquinaempresa,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoProduMaquina> productoprodumaquinas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoMaquinaEmpresa-saveRelacionesWithConnection");}
	
			tipomaquinaempresa.setProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinas);
			tipomaquinaempresa.setProductoProduMaquinas(productoprodumaquinas);

			this.setTipoMaquinaEmpresa(tipomaquinaempresa);

			if(TipoMaquinaEmpresaLogicAdditional.validarSaveRelaciones(tipomaquinaempresa,this)) {

				TipoMaquinaEmpresaLogicAdditional.updateRelacionesToSave(tipomaquinaempresa,this);

				if((tipomaquinaempresa.getIsNew()||tipomaquinaempresa.getIsChanged())&&!tipomaquinaempresa.getIsDeleted()) {
					this.saveTipoMaquinaEmpresa();
					this.saveTipoMaquinaEmpresaRelacionesDetalles(productoordendetaprodumaquinas,productoprodumaquinas);

				} else if(tipomaquinaempresa.getIsDeleted()) {
					this.saveTipoMaquinaEmpresaRelacionesDetalles(productoordendetaprodumaquinas,productoprodumaquinas);
					this.saveTipoMaquinaEmpresa();
				}

				TipoMaquinaEmpresaLogicAdditional.updateRelacionesToSaveAfter(tipomaquinaempresa,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProductoOrdenDetaProduMaquinaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinas,true,true);
			ProductoProduMaquinaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoProduMaquinas(productoprodumaquinas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoMaquinaEmpresaRelacionesDetalles(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoProduMaquina> productoprodumaquinas)throws Exception {
		try {
	

			Long idTipoMaquinaEmpresaActual=this.getTipoMaquinaEmpresa().getId();

			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic_Desde_TipoMaquinaEmpresa=new ProductoOrdenDetaProduMaquinaLogic();
			productoordendetaprodumaquinaLogic_Desde_TipoMaquinaEmpresa.setProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinas);

			productoordendetaprodumaquinaLogic_Desde_TipoMaquinaEmpresa.setConnexion(this.getConnexion());
			productoordendetaprodumaquinaLogic_Desde_TipoMaquinaEmpresa.setDatosCliente(this.datosCliente);

			for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina_Desde_TipoMaquinaEmpresa:productoordendetaprodumaquinaLogic_Desde_TipoMaquinaEmpresa.getProductoOrdenDetaProduMaquinas()) {
				productoordendetaprodumaquina_Desde_TipoMaquinaEmpresa.setid_tipo_merma_empresa(idTipoMaquinaEmpresaActual);
			}

			productoordendetaprodumaquinaLogic_Desde_TipoMaquinaEmpresa.saveProductoOrdenDetaProduMaquinas();

			ProductoProduMaquinaLogic productoprodumaquinaLogic_Desde_TipoMaquinaEmpresa=new ProductoProduMaquinaLogic();
			productoprodumaquinaLogic_Desde_TipoMaquinaEmpresa.setProductoProduMaquinas(productoprodumaquinas);

			productoprodumaquinaLogic_Desde_TipoMaquinaEmpresa.setConnexion(this.getConnexion());
			productoprodumaquinaLogic_Desde_TipoMaquinaEmpresa.setDatosCliente(this.datosCliente);

			for(ProductoProduMaquina productoprodumaquina_Desde_TipoMaquinaEmpresa:productoprodumaquinaLogic_Desde_TipoMaquinaEmpresa.getProductoProduMaquinas()) {
				productoprodumaquina_Desde_TipoMaquinaEmpresa.setid_tipo_merma_empresa(idTipoMaquinaEmpresaActual);
			}

			productoprodumaquinaLogic_Desde_TipoMaquinaEmpresa.saveProductoProduMaquinas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMaquinaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoMaquinaEmpresaConstantesFunciones.getClassesForeignKeysOfTipoMaquinaEmpresa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMaquinaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoMaquinaEmpresaConstantesFunciones.getClassesRelationshipsOfTipoMaquinaEmpresa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

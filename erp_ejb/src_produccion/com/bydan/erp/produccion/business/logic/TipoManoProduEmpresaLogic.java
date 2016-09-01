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
import com.bydan.erp.produccion.util.TipoManoProduEmpresaConstantesFunciones;
import com.bydan.erp.produccion.util.TipoManoProduEmpresaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoManoProduEmpresaParameterGeneral;
import com.bydan.erp.produccion.business.entity.TipoManoProduEmpresa;
import com.bydan.erp.produccion.business.logic.TipoManoProduEmpresaLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoManoProduEmpresaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoManoProduEmpresaLogic.class);
	
	protected TipoManoProduEmpresaDataAccess tipomanoproduempresaDataAccess; 	
	protected TipoManoProduEmpresa tipomanoproduempresa;
	protected List<TipoManoProduEmpresa> tipomanoproduempresas;
	protected Object tipomanoproduempresaObject;	
	protected List<Object> tipomanoproduempresasObject;
	
	public static ClassValidator<TipoManoProduEmpresa> tipomanoproduempresaValidator = new ClassValidator<TipoManoProduEmpresa>(TipoManoProduEmpresa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoManoProduEmpresaLogicAdditional tipomanoproduempresaLogicAdditional=null;
	
	public TipoManoProduEmpresaLogicAdditional getTipoManoProduEmpresaLogicAdditional() {
		return this.tipomanoproduempresaLogicAdditional;
	}
	
	public void setTipoManoProduEmpresaLogicAdditional(TipoManoProduEmpresaLogicAdditional tipomanoproduempresaLogicAdditional) {
		try {
			this.tipomanoproduempresaLogicAdditional=tipomanoproduempresaLogicAdditional;
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
	
	
	
	
	public  TipoManoProduEmpresaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipomanoproduempresaDataAccess = new TipoManoProduEmpresaDataAccess();
			
			this.tipomanoproduempresas= new ArrayList<TipoManoProduEmpresa>();
			this.tipomanoproduempresa= new TipoManoProduEmpresa();
			
			this.tipomanoproduempresaObject=new Object();
			this.tipomanoproduempresasObject=new ArrayList<Object>();
				
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
			
			this.tipomanoproduempresaDataAccess.setConnexionType(this.connexionType);
			this.tipomanoproduempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoManoProduEmpresaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipomanoproduempresaDataAccess = new TipoManoProduEmpresaDataAccess();
			this.tipomanoproduempresas= new ArrayList<TipoManoProduEmpresa>();
			this.tipomanoproduempresa= new TipoManoProduEmpresa();
			this.tipomanoproduempresaObject=new Object();
			this.tipomanoproduempresasObject=new ArrayList<Object>();
			
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
			
			this.tipomanoproduempresaDataAccess.setConnexionType(this.connexionType);
			this.tipomanoproduempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoManoProduEmpresa getTipoManoProduEmpresa() throws Exception {	
		TipoManoProduEmpresaLogicAdditional.checkTipoManoProduEmpresaToGet(tipomanoproduempresa,this.datosCliente,this.arrDatoGeneral);
		TipoManoProduEmpresaLogicAdditional.updateTipoManoProduEmpresaToGet(tipomanoproduempresa,this.arrDatoGeneral);
		
		return tipomanoproduempresa;
	}
		
	public void setTipoManoProduEmpresa(TipoManoProduEmpresa newTipoManoProduEmpresa) {
		this.tipomanoproduempresa = newTipoManoProduEmpresa;
	}
	
	public TipoManoProduEmpresaDataAccess getTipoManoProduEmpresaDataAccess() {
		return tipomanoproduempresaDataAccess;
	}
	
	public void setTipoManoProduEmpresaDataAccess(TipoManoProduEmpresaDataAccess newtipomanoproduempresaDataAccess) {
		this.tipomanoproduempresaDataAccess = newtipomanoproduempresaDataAccess;
	}
	
	public List<TipoManoProduEmpresa> getTipoManoProduEmpresas() throws Exception {		
		this.quitarTipoManoProduEmpresasNulos();
		
		TipoManoProduEmpresaLogicAdditional.checkTipoManoProduEmpresaToGets(tipomanoproduempresas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoManoProduEmpresa tipomanoproduempresaLocal: tipomanoproduempresas ) {
			TipoManoProduEmpresaLogicAdditional.updateTipoManoProduEmpresaToGet(tipomanoproduempresaLocal,this.arrDatoGeneral);
		}
		
		return tipomanoproduempresas;
	}
	
	public void setTipoManoProduEmpresas(List<TipoManoProduEmpresa> newTipoManoProduEmpresas) {
		this.tipomanoproduempresas = newTipoManoProduEmpresas;
	}
	
	public Object getTipoManoProduEmpresaObject() {	
		this.tipomanoproduempresaObject=this.tipomanoproduempresaDataAccess.getEntityObject();
		return this.tipomanoproduempresaObject;
	}
		
	public void setTipoManoProduEmpresaObject(Object newTipoManoProduEmpresaObject) {
		this.tipomanoproduempresaObject = newTipoManoProduEmpresaObject;
	}
	
	public List<Object> getTipoManoProduEmpresasObject() {		
		this.tipomanoproduempresasObject=this.tipomanoproduempresaDataAccess.getEntitiesObject();
		return this.tipomanoproduempresasObject;
	}
		
	public void setTipoManoProduEmpresasObject(List<Object> newTipoManoProduEmpresasObject) {
		this.tipomanoproduempresasObject = newTipoManoProduEmpresasObject;
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
		
		if(this.tipomanoproduempresaDataAccess!=null) {
			this.tipomanoproduempresaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipomanoproduempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipomanoproduempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomanoproduempresa=tipomanoproduempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomanoproduempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresa);
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
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		  		  
        try {
			
			tipomanoproduempresa=tipomanoproduempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomanoproduempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomanoproduempresa=tipomanoproduempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomanoproduempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresa);
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
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		  		  
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
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		  		  
        try {
			
			tipomanoproduempresa=tipomanoproduempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomanoproduempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		  		  
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
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipomanoproduempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipomanoproduempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipomanoproduempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipomanoproduempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipomanoproduempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipomanoproduempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomanoproduempresas = new  ArrayList<TipoManoProduEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomanoproduempresas=tipomanoproduempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoManoProduEmpresa(tipomanoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresas);
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
		tipomanoproduempresas = new  ArrayList<TipoManoProduEmpresa>();
		  		  
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
		tipomanoproduempresas = new  ArrayList<TipoManoProduEmpresa>();
		  		  
        try {			
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomanoproduempresas=tipomanoproduempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoManoProduEmpresa(tipomanoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipomanoproduempresas = new  ArrayList<TipoManoProduEmpresa>();
		  		  
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
		tipomanoproduempresas = new  ArrayList<TipoManoProduEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomanoproduempresas=tipomanoproduempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoManoProduEmpresa(tipomanoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresas);
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
		tipomanoproduempresas = new  ArrayList<TipoManoProduEmpresa>();
		  		  
        try {
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomanoproduempresas=tipomanoproduempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoManoProduEmpresa(tipomanoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresas);
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
		tipomanoproduempresas = new  ArrayList<TipoManoProduEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomanoproduempresas=tipomanoproduempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoManoProduEmpresa(tipomanoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresas);
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
		tipomanoproduempresas = new  ArrayList<TipoManoProduEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomanoproduempresas=tipomanoproduempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoManoProduEmpresa(tipomanoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomanoproduempresa=tipomanoproduempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoManoProduEmpresa(tipomanoproduempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresa);
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
		tipomanoproduempresa = new  TipoManoProduEmpresa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomanoproduempresa=tipomanoproduempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoManoProduEmpresa(tipomanoproduempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomanoproduempresas = new  ArrayList<TipoManoProduEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomanoproduempresas=tipomanoproduempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoManoProduEmpresa(tipomanoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresas);
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
		tipomanoproduempresas = new  ArrayList<TipoManoProduEmpresa>();
		  		  
        try {
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomanoproduempresas=tipomanoproduempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoManoProduEmpresa(tipomanoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoManoProduEmpresasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipomanoproduempresas = new  ArrayList<TipoManoProduEmpresa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-getTodosTipoManoProduEmpresasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomanoproduempresas=tipomanoproduempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoManoProduEmpresa(tipomanoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresas);
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
	
	public  void  getTodosTipoManoProduEmpresas(String sFinalQuery,Pagination pagination)throws Exception {
		tipomanoproduempresas = new  ArrayList<TipoManoProduEmpresa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomanoproduempresas=tipomanoproduempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoManoProduEmpresa(tipomanoproduempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoManoProduEmpresa(TipoManoProduEmpresa tipomanoproduempresa) throws Exception {
		Boolean estaValidado=false;
		
		if(tipomanoproduempresa.getIsNew() || tipomanoproduempresa.getIsChanged()) { 
			this.invalidValues = tipomanoproduempresaValidator.getInvalidValues(tipomanoproduempresa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipomanoproduempresa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoManoProduEmpresa(List<TipoManoProduEmpresa> TipoManoProduEmpresas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoManoProduEmpresa tipomanoproduempresaLocal:tipomanoproduempresas) {				
			estaValidadoObjeto=this.validarGuardarTipoManoProduEmpresa(tipomanoproduempresaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoManoProduEmpresa(List<TipoManoProduEmpresa> TipoManoProduEmpresas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoManoProduEmpresa(tipomanoproduempresas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoManoProduEmpresa(TipoManoProduEmpresa TipoManoProduEmpresa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoManoProduEmpresa(tipomanoproduempresa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoManoProduEmpresa tipomanoproduempresa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipomanoproduempresa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoManoProduEmpresaConstantesFunciones.getTipoManoProduEmpresaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipomanoproduempresa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoManoProduEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoManoProduEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoManoProduEmpresaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-saveTipoManoProduEmpresaWithConnection");connexion.begin();			
			
			TipoManoProduEmpresaLogicAdditional.checkTipoManoProduEmpresaToSave(this.tipomanoproduempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoManoProduEmpresaLogicAdditional.updateTipoManoProduEmpresaToSave(this.tipomanoproduempresa,this.arrDatoGeneral);
			
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomanoproduempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoManoProduEmpresa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoManoProduEmpresa(this.tipomanoproduempresa)) {
				TipoManoProduEmpresaDataAccess.save(this.tipomanoproduempresa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipomanoproduempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoManoProduEmpresaLogicAdditional.checkTipoManoProduEmpresaToSaveAfter(this.tipomanoproduempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoManoProduEmpresa();
			
			connexion.commit();			
			
			if(this.tipomanoproduempresa.getIsDeleted()) {
				this.tipomanoproduempresa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoManoProduEmpresa()throws Exception {	
		try {	
			
			TipoManoProduEmpresaLogicAdditional.checkTipoManoProduEmpresaToSave(this.tipomanoproduempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoManoProduEmpresaLogicAdditional.updateTipoManoProduEmpresaToSave(this.tipomanoproduempresa,this.arrDatoGeneral);
			
			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomanoproduempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoManoProduEmpresa(this.tipomanoproduempresa)) {			
				TipoManoProduEmpresaDataAccess.save(this.tipomanoproduempresa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipomanoproduempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoManoProduEmpresaLogicAdditional.checkTipoManoProduEmpresaToSaveAfter(this.tipomanoproduempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipomanoproduempresa.getIsDeleted()) {
				this.tipomanoproduempresa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoManoProduEmpresasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-saveTipoManoProduEmpresasWithConnection");connexion.begin();			
			
			TipoManoProduEmpresaLogicAdditional.checkTipoManoProduEmpresaToSaves(tipomanoproduempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoManoProduEmpresas();
			
			Boolean validadoTodosTipoManoProduEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoManoProduEmpresa tipomanoproduempresaLocal:tipomanoproduempresas) {		
				if(tipomanoproduempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoManoProduEmpresaLogicAdditional.updateTipoManoProduEmpresaToSave(tipomanoproduempresaLocal,this.arrDatoGeneral);
	        	
				TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomanoproduempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoManoProduEmpresa(tipomanoproduempresaLocal)) {
					TipoManoProduEmpresaDataAccess.save(tipomanoproduempresaLocal, connexion);				
				} else {
					validadoTodosTipoManoProduEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoManoProduEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoManoProduEmpresaLogicAdditional.checkTipoManoProduEmpresaToSavesAfter(tipomanoproduempresas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoManoProduEmpresas();
			
			connexion.commit();		
			
			this.quitarTipoManoProduEmpresasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoManoProduEmpresas()throws Exception {				
		 try {	
			TipoManoProduEmpresaLogicAdditional.checkTipoManoProduEmpresaToSaves(tipomanoproduempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoManoProduEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoManoProduEmpresa tipomanoproduempresaLocal:tipomanoproduempresas) {				
				if(tipomanoproduempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoManoProduEmpresaLogicAdditional.updateTipoManoProduEmpresaToSave(tipomanoproduempresaLocal,this.arrDatoGeneral);
	        	
				TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomanoproduempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoManoProduEmpresa(tipomanoproduempresaLocal)) {				
					TipoManoProduEmpresaDataAccess.save(tipomanoproduempresaLocal, connexion);				
				} else {
					validadoTodosTipoManoProduEmpresa=false;
				}
			}
			
			if(!validadoTodosTipoManoProduEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoManoProduEmpresaLogicAdditional.checkTipoManoProduEmpresaToSavesAfter(tipomanoproduempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoManoProduEmpresasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoManoProduEmpresaParameterReturnGeneral procesarAccionTipoManoProduEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoManoProduEmpresa> tipomanoproduempresas,TipoManoProduEmpresaParameterReturnGeneral tipomanoproduempresaParameterGeneral)throws Exception {
		 try {	
			TipoManoProduEmpresaParameterReturnGeneral tipomanoproduempresaReturnGeneral=new TipoManoProduEmpresaParameterReturnGeneral();
	
			TipoManoProduEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipomanoproduempresas,tipomanoproduempresaParameterGeneral,tipomanoproduempresaReturnGeneral);
			
			return tipomanoproduempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoManoProduEmpresaParameterReturnGeneral procesarAccionTipoManoProduEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoManoProduEmpresa> tipomanoproduempresas,TipoManoProduEmpresaParameterReturnGeneral tipomanoproduempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-procesarAccionTipoManoProduEmpresasWithConnection");connexion.begin();			
			
			TipoManoProduEmpresaParameterReturnGeneral tipomanoproduempresaReturnGeneral=new TipoManoProduEmpresaParameterReturnGeneral();
	
			TipoManoProduEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipomanoproduempresas,tipomanoproduempresaParameterGeneral,tipomanoproduempresaReturnGeneral);
			
			this.connexion.commit();
			
			return tipomanoproduempresaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoManoProduEmpresaParameterReturnGeneral procesarEventosTipoManoProduEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoManoProduEmpresa> tipomanoproduempresas,TipoManoProduEmpresa tipomanoproduempresa,TipoManoProduEmpresaParameterReturnGeneral tipomanoproduempresaParameterGeneral,Boolean isEsNuevoTipoManoProduEmpresa,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoManoProduEmpresaParameterReturnGeneral tipomanoproduempresaReturnGeneral=new TipoManoProduEmpresaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomanoproduempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoManoProduEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipomanoproduempresas,tipomanoproduempresa,tipomanoproduempresaParameterGeneral,tipomanoproduempresaReturnGeneral,isEsNuevoTipoManoProduEmpresa,clases);
			
			return tipomanoproduempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoManoProduEmpresaParameterReturnGeneral procesarEventosTipoManoProduEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoManoProduEmpresa> tipomanoproduempresas,TipoManoProduEmpresa tipomanoproduempresa,TipoManoProduEmpresaParameterReturnGeneral tipomanoproduempresaParameterGeneral,Boolean isEsNuevoTipoManoProduEmpresa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-procesarEventosTipoManoProduEmpresasWithConnection");connexion.begin();			
			
			TipoManoProduEmpresaParameterReturnGeneral tipomanoproduempresaReturnGeneral=new TipoManoProduEmpresaParameterReturnGeneral();
	
			tipomanoproduempresaReturnGeneral.setTipoManoProduEmpresa(tipomanoproduempresa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomanoproduempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoManoProduEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipomanoproduempresas,tipomanoproduempresa,tipomanoproduempresaParameterGeneral,tipomanoproduempresaReturnGeneral,isEsNuevoTipoManoProduEmpresa,clases);
			
			this.connexion.commit();
			
			return tipomanoproduempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoManoProduEmpresaParameterReturnGeneral procesarImportacionTipoManoProduEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoManoProduEmpresaParameterReturnGeneral tipomanoproduempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-procesarImportacionTipoManoProduEmpresasWithConnection");connexion.begin();			
			
			TipoManoProduEmpresaParameterReturnGeneral tipomanoproduempresaReturnGeneral=new TipoManoProduEmpresaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipomanoproduempresas=new ArrayList<TipoManoProduEmpresa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipomanoproduempresa=new TipoManoProduEmpresa();
				
				
				if(conColumnasBase) {this.tipomanoproduempresa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipomanoproduempresa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipomanoproduempresa.setnombre(arrColumnas[iColumn++]);
				this.tipomanoproduempresa.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipomanoproduempresas.add(this.tipomanoproduempresa);
			}
			
			this.saveTipoManoProduEmpresas();
			
			this.connexion.commit();
			
			tipomanoproduempresaReturnGeneral.setConRetornoEstaProcesado(true);
			tipomanoproduempresaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipomanoproduempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoManoProduEmpresasEliminados() throws Exception {				
		
		List<TipoManoProduEmpresa> tipomanoproduempresasAux= new ArrayList<TipoManoProduEmpresa>();
		
		for(TipoManoProduEmpresa tipomanoproduempresa:tipomanoproduempresas) {
			if(!tipomanoproduempresa.getIsDeleted()) {
				tipomanoproduempresasAux.add(tipomanoproduempresa);
			}
		}
		
		tipomanoproduempresas=tipomanoproduempresasAux;
	}
	
	public void quitarTipoManoProduEmpresasNulos() throws Exception {				
		
		List<TipoManoProduEmpresa> tipomanoproduempresasAux= new ArrayList<TipoManoProduEmpresa>();
		
		for(TipoManoProduEmpresa tipomanoproduempresa : this.tipomanoproduempresas) {
			if(tipomanoproduempresa==null) {
				tipomanoproduempresasAux.add(tipomanoproduempresa);
			}
		}
		
		//this.tipomanoproduempresas=tipomanoproduempresasAux;
		
		this.tipomanoproduempresas.removeAll(tipomanoproduempresasAux);
	}
	
	public void getSetVersionRowTipoManoProduEmpresaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipomanoproduempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipomanoproduempresa.getIsDeleted() || (tipomanoproduempresa.getIsChanged()&&!tipomanoproduempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipomanoproduempresaDataAccess.getSetVersionRowTipoManoProduEmpresa(connexion,tipomanoproduempresa.getId());
				
				if(!tipomanoproduempresa.getVersionRow().equals(timestamp)) {	
					tipomanoproduempresa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipomanoproduempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoManoProduEmpresa()throws Exception {	
		
		if(tipomanoproduempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipomanoproduempresa.getIsDeleted() || (tipomanoproduempresa.getIsChanged()&&!tipomanoproduempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipomanoproduempresaDataAccess.getSetVersionRowTipoManoProduEmpresa(connexion,tipomanoproduempresa.getId());
			
			try {							
				if(!tipomanoproduempresa.getVersionRow().equals(timestamp)) {	
					tipomanoproduempresa.setVersionRow(timestamp);
				}
				
				tipomanoproduempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoManoProduEmpresasWithConnection()throws Exception {	
		if(tipomanoproduempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoManoProduEmpresa tipomanoproduempresaAux:tipomanoproduempresas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipomanoproduempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomanoproduempresaAux.getIsDeleted() || (tipomanoproduempresaAux.getIsChanged()&&!tipomanoproduempresaAux.getIsNew())) {
						
						timestamp=tipomanoproduempresaDataAccess.getSetVersionRowTipoManoProduEmpresa(connexion,tipomanoproduempresaAux.getId());
						
						if(!tipomanoproduempresa.getVersionRow().equals(timestamp)) {	
							tipomanoproduempresaAux.setVersionRow(timestamp);
						}
								
						tipomanoproduempresaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoManoProduEmpresas()throws Exception {	
		if(tipomanoproduempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoManoProduEmpresa tipomanoproduempresaAux:tipomanoproduempresas) {
					if(tipomanoproduempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomanoproduempresaAux.getIsDeleted() || (tipomanoproduempresaAux.getIsChanged()&&!tipomanoproduempresaAux.getIsNew())) {
						
						timestamp=tipomanoproduempresaDataAccess.getSetVersionRowTipoManoProduEmpresa(connexion,tipomanoproduempresaAux.getId());
						
						if(!tipomanoproduempresaAux.getVersionRow().equals(timestamp)) {	
							tipomanoproduempresaAux.setVersionRow(timestamp);
						}
						
													
						tipomanoproduempresaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoManoProduEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoManoProduEmpresaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoManoProduEmpresaParameterReturnGeneral  tipomanoproduempresaReturnGeneral =new TipoManoProduEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoManoProduEmpresaWithConnection");connexion.begin();
			
			tipomanoproduempresaReturnGeneral =new TipoManoProduEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipomanoproduempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipomanoproduempresaReturnGeneral;
	}
	
	public TipoManoProduEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyTipoManoProduEmpresa(String finalQueryGlobalEmpresa) throws Exception {
		TipoManoProduEmpresaParameterReturnGeneral  tipomanoproduempresaReturnGeneral =new TipoManoProduEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipomanoproduempresaReturnGeneral =new TipoManoProduEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipomanoproduempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipomanoproduempresaReturnGeneral;
	}
	
	
	public void deepLoad(TipoManoProduEmpresa tipomanoproduempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoManoProduEmpresaLogicAdditional.updateTipoManoProduEmpresaToGet(tipomanoproduempresa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomanoproduempresa.setEmpresa(tipomanoproduempresaDataAccess.getEmpresa(connexion,tipomanoproduempresa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipomanoproduempresa.setEmpresa(tipomanoproduempresaDataAccess.getEmpresa(connexion,tipomanoproduempresa));
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
			tipomanoproduempresa.setEmpresa(tipomanoproduempresaDataAccess.getEmpresa(connexion,tipomanoproduempresa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomanoproduempresa.setEmpresa(tipomanoproduempresaDataAccess.getEmpresa(connexion,tipomanoproduempresa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipomanoproduempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipomanoproduempresa.setEmpresa(tipomanoproduempresaDataAccess.getEmpresa(connexion,tipomanoproduempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipomanoproduempresa.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tipomanoproduempresa.setEmpresa(tipomanoproduempresaDataAccess.getEmpresa(connexion,tipomanoproduempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipomanoproduempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoManoProduEmpresa tipomanoproduempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoManoProduEmpresaLogicAdditional.updateTipoManoProduEmpresaToSave(tipomanoproduempresa,this.arrDatoGeneral);
			
TipoManoProduEmpresaDataAccess.save(tipomanoproduempresa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipomanoproduempresa.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipomanoproduempresa.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipomanoproduempresa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipomanoproduempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipomanoproduempresa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipomanoproduempresa.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoManoProduEmpresa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipomanoproduempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(tipomanoproduempresa);
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
			this.deepLoad(this.tipomanoproduempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoManoProduEmpresa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipomanoproduempresas!=null) {
				for(TipoManoProduEmpresa tipomanoproduempresa:tipomanoproduempresas) {
					this.deepLoad(tipomanoproduempresa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(tipomanoproduempresas);
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
			if(tipomanoproduempresas!=null) {
				for(TipoManoProduEmpresa tipomanoproduempresa:tipomanoproduempresas) {
					this.deepLoad(tipomanoproduempresa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(tipomanoproduempresas);
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
			this.getNewConnexionToDeep(TipoManoProduEmpresa.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipomanoproduempresa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoManoProduEmpresa.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipomanoproduempresas!=null) {
				for(TipoManoProduEmpresa tipomanoproduempresa:tipomanoproduempresas) {
					this.deepSave(tipomanoproduempresa,isDeep,deepLoadType,clases);
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
			if(tipomanoproduempresas!=null) {
				for(TipoManoProduEmpresa tipomanoproduempresa:tipomanoproduempresas) {
					this.deepSave(tipomanoproduempresa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoManoProduEmpresasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoManoProduEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoManoProduEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomanoproduempresas=tipomanoproduempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoManoProduEmpresasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoManoProduEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoManoProduEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomanoproduempresas=tipomanoproduempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoManoProduEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesTipoManoProduEmpresa(this.tipomanoproduempresas);
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
			if(TipoManoProduEmpresaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoManoProduEmpresaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoManoProduEmpresa tipomanoproduempresa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoManoProduEmpresaConstantesFunciones.ISCONAUDITORIA) {
				if(tipomanoproduempresa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoManoProduEmpresaDataAccess.TABLENAME, tipomanoproduempresa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoManoProduEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoManoProduEmpresaLogic.registrarAuditoriaDetallesTipoManoProduEmpresa(connexion,tipomanoproduempresa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipomanoproduempresa.getIsDeleted()) {
					/*if(!tipomanoproduempresa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoManoProduEmpresaDataAccess.TABLENAME, tipomanoproduempresa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoManoProduEmpresaLogic.registrarAuditoriaDetallesTipoManoProduEmpresa(connexion,tipomanoproduempresa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoManoProduEmpresaDataAccess.TABLENAME, tipomanoproduempresa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipomanoproduempresa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoManoProduEmpresaDataAccess.TABLENAME, tipomanoproduempresa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoManoProduEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoManoProduEmpresaLogic.registrarAuditoriaDetallesTipoManoProduEmpresa(connexion,tipomanoproduempresa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoManoProduEmpresa(Connexion connexion,TipoManoProduEmpresa tipomanoproduempresa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipomanoproduempresa.getIsNew()||!tipomanoproduempresa.getid_empresa().equals(tipomanoproduempresa.getTipoManoProduEmpresaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomanoproduempresa.getTipoManoProduEmpresaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipomanoproduempresa.getTipoManoProduEmpresaOriginal().getid_empresa().toString();
				}
				if(tipomanoproduempresa.getid_empresa()!=null)
				{
					strValorNuevo=tipomanoproduempresa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoManoProduEmpresaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipomanoproduempresa.getIsNew()||!tipomanoproduempresa.getnombre().equals(tipomanoproduempresa.getTipoManoProduEmpresaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomanoproduempresa.getTipoManoProduEmpresaOriginal().getnombre()!=null)
				{
					strValorActual=tipomanoproduempresa.getTipoManoProduEmpresaOriginal().getnombre();
				}
				if(tipomanoproduempresa.getnombre()!=null)
				{
					strValorNuevo=tipomanoproduempresa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoManoProduEmpresaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipomanoproduempresa.getIsNew()||!tipomanoproduempresa.getdescripcion().equals(tipomanoproduempresa.getTipoManoProduEmpresaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomanoproduempresa.getTipoManoProduEmpresaOriginal().getdescripcion()!=null)
				{
					strValorActual=tipomanoproduempresa.getTipoManoProduEmpresaOriginal().getdescripcion();
				}
				if(tipomanoproduempresa.getdescripcion()!=null)
				{
					strValorNuevo=tipomanoproduempresa.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoManoProduEmpresaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoManoProduEmpresaRelacionesWithConnection(TipoManoProduEmpresa tipomanoproduempresa) throws Exception {

		if(!tipomanoproduempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoManoProduEmpresaRelacionesBase(tipomanoproduempresa,true);
		}
	}

	public void saveTipoManoProduEmpresaRelaciones(TipoManoProduEmpresa tipomanoproduempresa)throws Exception {

		if(!tipomanoproduempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoManoProduEmpresaRelacionesBase(tipomanoproduempresa,false);
		}
	}

	public void saveTipoManoProduEmpresaRelacionesBase(TipoManoProduEmpresa tipomanoproduempresa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoManoProduEmpresa-saveRelacionesWithConnection");}
	

			this.setTipoManoProduEmpresa(tipomanoproduempresa);

			if(TipoManoProduEmpresaLogicAdditional.validarSaveRelaciones(tipomanoproduempresa,this)) {

				TipoManoProduEmpresaLogicAdditional.updateRelacionesToSave(tipomanoproduempresa,this);

				if((tipomanoproduempresa.getIsNew()||tipomanoproduempresa.getIsChanged())&&!tipomanoproduempresa.getIsDeleted()) {
					this.saveTipoManoProduEmpresa();
					this.saveTipoManoProduEmpresaRelacionesDetalles();

				} else if(tipomanoproduempresa.getIsDeleted()) {
					this.saveTipoManoProduEmpresaRelacionesDetalles();
					this.saveTipoManoProduEmpresa();
				}

				TipoManoProduEmpresaLogicAdditional.updateRelacionesToSaveAfter(tipomanoproduempresa,this);

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
	
	
	private void saveTipoManoProduEmpresaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoManoProduEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoManoProduEmpresaConstantesFunciones.getClassesForeignKeysOfTipoManoProduEmpresa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoManoProduEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoManoProduEmpresaConstantesFunciones.getClassesRelationshipsOfTipoManoProduEmpresa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

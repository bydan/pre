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
import com.bydan.erp.cartera.util.TipoGlobalClienteConstantesFunciones;
import com.bydan.erp.cartera.util.TipoGlobalClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoGlobalClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoGlobalCliente;
//import com.bydan.erp.cartera.business.logic.TipoGlobalClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoGlobalClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoGlobalClienteLogic.class);
	
	protected TipoGlobalClienteDataAccess tipoglobalclienteDataAccess; 	
	protected TipoGlobalCliente tipoglobalcliente;
	protected List<TipoGlobalCliente> tipoglobalclientes;
	protected Object tipoglobalclienteObject;	
	protected List<Object> tipoglobalclientesObject;
	
	public static ClassValidator<TipoGlobalCliente> tipoglobalclienteValidator = new ClassValidator<TipoGlobalCliente>(TipoGlobalCliente.class);	
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
	
	
	
	
	public  TipoGlobalClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoglobalclienteDataAccess = new TipoGlobalClienteDataAccess();
			
			this.tipoglobalclientes= new ArrayList<TipoGlobalCliente>();
			this.tipoglobalcliente= new TipoGlobalCliente();
			
			this.tipoglobalclienteObject=new Object();
			this.tipoglobalclientesObject=new ArrayList<Object>();
				
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
			
			this.tipoglobalclienteDataAccess.setConnexionType(this.connexionType);
			this.tipoglobalclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoGlobalClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoglobalclienteDataAccess = new TipoGlobalClienteDataAccess();
			this.tipoglobalclientes= new ArrayList<TipoGlobalCliente>();
			this.tipoglobalcliente= new TipoGlobalCliente();
			this.tipoglobalclienteObject=new Object();
			this.tipoglobalclientesObject=new ArrayList<Object>();
			
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
			
			this.tipoglobalclienteDataAccess.setConnexionType(this.connexionType);
			this.tipoglobalclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoGlobalCliente getTipoGlobalCliente() throws Exception {	
		//TipoGlobalClienteLogicAdditional.checkTipoGlobalClienteToGet(tipoglobalcliente,this.datosCliente,this.arrDatoGeneral);
		//TipoGlobalClienteLogicAdditional.updateTipoGlobalClienteToGet(tipoglobalcliente,this.arrDatoGeneral);
		
		return tipoglobalcliente;
	}
		
	public void setTipoGlobalCliente(TipoGlobalCliente newTipoGlobalCliente) {
		this.tipoglobalcliente = newTipoGlobalCliente;
	}
	
	public TipoGlobalClienteDataAccess getTipoGlobalClienteDataAccess() {
		return tipoglobalclienteDataAccess;
	}
	
	public void setTipoGlobalClienteDataAccess(TipoGlobalClienteDataAccess newtipoglobalclienteDataAccess) {
		this.tipoglobalclienteDataAccess = newtipoglobalclienteDataAccess;
	}
	
	public List<TipoGlobalCliente> getTipoGlobalClientes() throws Exception {		
		this.quitarTipoGlobalClientesNulos();
		
		//TipoGlobalClienteLogicAdditional.checkTipoGlobalClienteToGets(tipoglobalclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoGlobalCliente tipoglobalclienteLocal: tipoglobalclientes ) {
			//TipoGlobalClienteLogicAdditional.updateTipoGlobalClienteToGet(tipoglobalclienteLocal,this.arrDatoGeneral);
		}
		
		return tipoglobalclientes;
	}
	
	public void setTipoGlobalClientes(List<TipoGlobalCliente> newTipoGlobalClientes) {
		this.tipoglobalclientes = newTipoGlobalClientes;
	}
	
	public Object getTipoGlobalClienteObject() {	
		this.tipoglobalclienteObject=this.tipoglobalclienteDataAccess.getEntityObject();
		return this.tipoglobalclienteObject;
	}
		
	public void setTipoGlobalClienteObject(Object newTipoGlobalClienteObject) {
		this.tipoglobalclienteObject = newTipoGlobalClienteObject;
	}
	
	public List<Object> getTipoGlobalClientesObject() {		
		this.tipoglobalclientesObject=this.tipoglobalclienteDataAccess.getEntitiesObject();
		return this.tipoglobalclientesObject;
	}
		
	public void setTipoGlobalClientesObject(List<Object> newTipoGlobalClientesObject) {
		this.tipoglobalclientesObject = newTipoGlobalClientesObject;
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
		
		if(this.tipoglobalclienteDataAccess!=null) {
			this.tipoglobalclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoglobalclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoglobalclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoglobalcliente = new  TipoGlobalCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoglobalcliente=tipoglobalclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoglobalcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalcliente);
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
		tipoglobalcliente = new  TipoGlobalCliente();
		  		  
        try {
			
			tipoglobalcliente=tipoglobalclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoglobalcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalcliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoglobalcliente = new  TipoGlobalCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoglobalcliente=tipoglobalclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoglobalcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalcliente);
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
		tipoglobalcliente = new  TipoGlobalCliente();
		  		  
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
		tipoglobalcliente = new  TipoGlobalCliente();
		  		  
        try {
			
			tipoglobalcliente=tipoglobalclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoglobalcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalcliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoglobalcliente = new  TipoGlobalCliente();
		  		  
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
		tipoglobalcliente = new  TipoGlobalCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoglobalclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoglobalcliente = new  TipoGlobalCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoglobalclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoglobalcliente = new  TipoGlobalCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoglobalclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoglobalcliente = new  TipoGlobalCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoglobalclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoglobalcliente = new  TipoGlobalCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoglobalclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoglobalcliente = new  TipoGlobalCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoglobalclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoglobalclientes = new  ArrayList<TipoGlobalCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoglobalclientes=tipoglobalclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGlobalCliente(tipoglobalclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalclientes);
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
		tipoglobalclientes = new  ArrayList<TipoGlobalCliente>();
		  		  
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
		tipoglobalclientes = new  ArrayList<TipoGlobalCliente>();
		  		  
        try {			
			TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoglobalclientes=tipoglobalclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoGlobalCliente(tipoglobalclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoglobalclientes = new  ArrayList<TipoGlobalCliente>();
		  		  
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
		tipoglobalclientes = new  ArrayList<TipoGlobalCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoglobalclientes=tipoglobalclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGlobalCliente(tipoglobalclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalclientes);
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
		tipoglobalclientes = new  ArrayList<TipoGlobalCliente>();
		  		  
        try {
			TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoglobalclientes=tipoglobalclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGlobalCliente(tipoglobalclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalclientes);
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
		tipoglobalclientes = new  ArrayList<TipoGlobalCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoglobalclientes=tipoglobalclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGlobalCliente(tipoglobalclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalclientes);
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
		tipoglobalclientes = new  ArrayList<TipoGlobalCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoglobalclientes=tipoglobalclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGlobalCliente(tipoglobalclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoglobalcliente = new  TipoGlobalCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoglobalcliente=tipoglobalclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGlobalCliente(tipoglobalcliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalcliente);
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
		tipoglobalcliente = new  TipoGlobalCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoglobalcliente=tipoglobalclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGlobalCliente(tipoglobalcliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalcliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoGlobalClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoglobalclientes = new  ArrayList<TipoGlobalCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-getTodosTipoGlobalClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoglobalclientes=tipoglobalclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGlobalCliente(tipoglobalclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalclientes);
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
	
	public  void  getTodosTipoGlobalClientes(String sFinalQuery,Pagination pagination)throws Exception {
		tipoglobalclientes = new  ArrayList<TipoGlobalCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoglobalclientes=tipoglobalclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGlobalCliente(tipoglobalclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoGlobalCliente(TipoGlobalCliente tipoglobalcliente) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoglobalcliente.getIsNew() || tipoglobalcliente.getIsChanged()) { 
			this.invalidValues = tipoglobalclienteValidator.getInvalidValues(tipoglobalcliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoglobalcliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoGlobalCliente(List<TipoGlobalCliente> TipoGlobalClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoGlobalCliente tipoglobalclienteLocal:tipoglobalclientes) {				
			estaValidadoObjeto=this.validarGuardarTipoGlobalCliente(tipoglobalclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoGlobalCliente(List<TipoGlobalCliente> TipoGlobalClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGlobalCliente(tipoglobalclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoGlobalCliente(TipoGlobalCliente TipoGlobalCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGlobalCliente(tipoglobalcliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoGlobalCliente tipoglobalcliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoglobalcliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoGlobalClienteConstantesFunciones.getTipoGlobalClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoglobalcliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoGlobalClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoGlobalClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoGlobalClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-saveTipoGlobalClienteWithConnection");connexion.begin();			
			
			//TipoGlobalClienteLogicAdditional.checkTipoGlobalClienteToSave(this.tipoglobalcliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoGlobalClienteLogicAdditional.updateTipoGlobalClienteToSave(this.tipoglobalcliente,this.arrDatoGeneral);
			
			TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoglobalcliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoGlobalCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGlobalCliente(this.tipoglobalcliente)) {
				TipoGlobalClienteDataAccess.save(this.tipoglobalcliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoglobalcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoGlobalClienteLogicAdditional.checkTipoGlobalClienteToSaveAfter(this.tipoglobalcliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGlobalCliente();
			
			connexion.commit();			
			
			if(this.tipoglobalcliente.getIsDeleted()) {
				this.tipoglobalcliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoGlobalCliente()throws Exception {	
		try {	
			
			//TipoGlobalClienteLogicAdditional.checkTipoGlobalClienteToSave(this.tipoglobalcliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoGlobalClienteLogicAdditional.updateTipoGlobalClienteToSave(this.tipoglobalcliente,this.arrDatoGeneral);
			
			TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoglobalcliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGlobalCliente(this.tipoglobalcliente)) {			
				TipoGlobalClienteDataAccess.save(this.tipoglobalcliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoglobalcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoGlobalClienteLogicAdditional.checkTipoGlobalClienteToSaveAfter(this.tipoglobalcliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoglobalcliente.getIsDeleted()) {
				this.tipoglobalcliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoGlobalClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-saveTipoGlobalClientesWithConnection");connexion.begin();			
			
			//TipoGlobalClienteLogicAdditional.checkTipoGlobalClienteToSaves(tipoglobalclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoGlobalClientes();
			
			Boolean validadoTodosTipoGlobalCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGlobalCliente tipoglobalclienteLocal:tipoglobalclientes) {		
				if(tipoglobalclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoGlobalClienteLogicAdditional.updateTipoGlobalClienteToSave(tipoglobalclienteLocal,this.arrDatoGeneral);
	        	
				TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoglobalclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGlobalCliente(tipoglobalclienteLocal)) {
					TipoGlobalClienteDataAccess.save(tipoglobalclienteLocal, connexion);				
				} else {
					validadoTodosTipoGlobalCliente=false;
				}
			}
			
			if(!validadoTodosTipoGlobalCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoGlobalClienteLogicAdditional.checkTipoGlobalClienteToSavesAfter(tipoglobalclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGlobalClientes();
			
			connexion.commit();		
			
			this.quitarTipoGlobalClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoGlobalClientes()throws Exception {				
		 try {	
			//TipoGlobalClienteLogicAdditional.checkTipoGlobalClienteToSaves(tipoglobalclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoGlobalCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGlobalCliente tipoglobalclienteLocal:tipoglobalclientes) {				
				if(tipoglobalclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoGlobalClienteLogicAdditional.updateTipoGlobalClienteToSave(tipoglobalclienteLocal,this.arrDatoGeneral);
	        	
				TipoGlobalClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoglobalclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGlobalCliente(tipoglobalclienteLocal)) {				
					TipoGlobalClienteDataAccess.save(tipoglobalclienteLocal, connexion);				
				} else {
					validadoTodosTipoGlobalCliente=false;
				}
			}
			
			if(!validadoTodosTipoGlobalCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoGlobalClienteLogicAdditional.checkTipoGlobalClienteToSavesAfter(tipoglobalclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoGlobalClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGlobalClienteParameterReturnGeneral procesarAccionTipoGlobalClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGlobalCliente> tipoglobalclientes,TipoGlobalClienteParameterReturnGeneral tipoglobalclienteParameterGeneral)throws Exception {
		 try {	
			TipoGlobalClienteParameterReturnGeneral tipoglobalclienteReturnGeneral=new TipoGlobalClienteParameterReturnGeneral();
	
			
			return tipoglobalclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGlobalClienteParameterReturnGeneral procesarAccionTipoGlobalClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGlobalCliente> tipoglobalclientes,TipoGlobalClienteParameterReturnGeneral tipoglobalclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-procesarAccionTipoGlobalClientesWithConnection");connexion.begin();			
			
			TipoGlobalClienteParameterReturnGeneral tipoglobalclienteReturnGeneral=new TipoGlobalClienteParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoglobalclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGlobalClienteParameterReturnGeneral procesarEventosTipoGlobalClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGlobalCliente> tipoglobalclientes,TipoGlobalCliente tipoglobalcliente,TipoGlobalClienteParameterReturnGeneral tipoglobalclienteParameterGeneral,Boolean isEsNuevoTipoGlobalCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoGlobalClienteParameterReturnGeneral tipoglobalclienteReturnGeneral=new TipoGlobalClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoglobalclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoglobalclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoGlobalClienteParameterReturnGeneral procesarEventosTipoGlobalClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGlobalCliente> tipoglobalclientes,TipoGlobalCliente tipoglobalcliente,TipoGlobalClienteParameterReturnGeneral tipoglobalclienteParameterGeneral,Boolean isEsNuevoTipoGlobalCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-procesarEventosTipoGlobalClientesWithConnection");connexion.begin();			
			
			TipoGlobalClienteParameterReturnGeneral tipoglobalclienteReturnGeneral=new TipoGlobalClienteParameterReturnGeneral();
	
			tipoglobalclienteReturnGeneral.setTipoGlobalCliente(tipoglobalcliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoglobalclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoglobalclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGlobalClienteParameterReturnGeneral procesarImportacionTipoGlobalClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoGlobalClienteParameterReturnGeneral tipoglobalclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-procesarImportacionTipoGlobalClientesWithConnection");connexion.begin();			
			
			TipoGlobalClienteParameterReturnGeneral tipoglobalclienteReturnGeneral=new TipoGlobalClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoglobalclientes=new ArrayList<TipoGlobalCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoglobalcliente=new TipoGlobalCliente();
				
				
				if(conColumnasBase) {this.tipoglobalcliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoglobalcliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoglobalcliente.setcodigo(arrColumnas[iColumn++]);
				this.tipoglobalcliente.setnombre(arrColumnas[iColumn++]);
				
				this.tipoglobalclientes.add(this.tipoglobalcliente);
			}
			
			this.saveTipoGlobalClientes();
			
			this.connexion.commit();
			
			tipoglobalclienteReturnGeneral.setConRetornoEstaProcesado(true);
			tipoglobalclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoglobalclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoGlobalClientesEliminados() throws Exception {				
		
		List<TipoGlobalCliente> tipoglobalclientesAux= new ArrayList<TipoGlobalCliente>();
		
		for(TipoGlobalCliente tipoglobalcliente:tipoglobalclientes) {
			if(!tipoglobalcliente.getIsDeleted()) {
				tipoglobalclientesAux.add(tipoglobalcliente);
			}
		}
		
		tipoglobalclientes=tipoglobalclientesAux;
	}
	
	public void quitarTipoGlobalClientesNulos() throws Exception {				
		
		List<TipoGlobalCliente> tipoglobalclientesAux= new ArrayList<TipoGlobalCliente>();
		
		for(TipoGlobalCliente tipoglobalcliente : this.tipoglobalclientes) {
			if(tipoglobalcliente==null) {
				tipoglobalclientesAux.add(tipoglobalcliente);
			}
		}
		
		//this.tipoglobalclientes=tipoglobalclientesAux;
		
		this.tipoglobalclientes.removeAll(tipoglobalclientesAux);
	}
	
	public void getSetVersionRowTipoGlobalClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoglobalcliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoglobalcliente.getIsDeleted() || (tipoglobalcliente.getIsChanged()&&!tipoglobalcliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoglobalclienteDataAccess.getSetVersionRowTipoGlobalCliente(connexion,tipoglobalcliente.getId());
				
				if(!tipoglobalcliente.getVersionRow().equals(timestamp)) {	
					tipoglobalcliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoglobalcliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoGlobalCliente()throws Exception {	
		
		if(tipoglobalcliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoglobalcliente.getIsDeleted() || (tipoglobalcliente.getIsChanged()&&!tipoglobalcliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoglobalclienteDataAccess.getSetVersionRowTipoGlobalCliente(connexion,tipoglobalcliente.getId());
			
			try {							
				if(!tipoglobalcliente.getVersionRow().equals(timestamp)) {	
					tipoglobalcliente.setVersionRow(timestamp);
				}
				
				tipoglobalcliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoGlobalClientesWithConnection()throws Exception {	
		if(tipoglobalclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoGlobalCliente tipoglobalclienteAux:tipoglobalclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoglobalclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoglobalclienteAux.getIsDeleted() || (tipoglobalclienteAux.getIsChanged()&&!tipoglobalclienteAux.getIsNew())) {
						
						timestamp=tipoglobalclienteDataAccess.getSetVersionRowTipoGlobalCliente(connexion,tipoglobalclienteAux.getId());
						
						if(!tipoglobalcliente.getVersionRow().equals(timestamp)) {	
							tipoglobalclienteAux.setVersionRow(timestamp);
						}
								
						tipoglobalclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoGlobalClientes()throws Exception {	
		if(tipoglobalclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoGlobalCliente tipoglobalclienteAux:tipoglobalclientes) {
					if(tipoglobalclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoglobalclienteAux.getIsDeleted() || (tipoglobalclienteAux.getIsChanged()&&!tipoglobalclienteAux.getIsNew())) {
						
						timestamp=tipoglobalclienteDataAccess.getSetVersionRowTipoGlobalCliente(connexion,tipoglobalclienteAux.getId());
						
						if(!tipoglobalclienteAux.getVersionRow().equals(timestamp)) {	
							tipoglobalclienteAux.setVersionRow(timestamp);
						}
						
													
						tipoglobalclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoGlobalClienteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DefinicionLogic definicionLogic=new DefinicionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGlobalCliente.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoGlobalClienteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Definicion.class));
											
			

			definicionLogic.setConnexion(this.getConnexion());
			definicionLogic.setDatosCliente(this.datosCliente);
			definicionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoGlobalCliente tipoglobalcliente:this.tipoglobalclientes) {
				

				classes=new ArrayList<Classe>();
				classes=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(new ArrayList<Classe>(),DeepLoadType.NONE);

				definicionLogic.setDefinicions(tipoglobalcliente.definicions);
				definicionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoGlobalCliente tipoglobalcliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoGlobalClienteLogicAdditional.updateTipoGlobalClienteToGet(tipoglobalcliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoglobalcliente.setDefinicions(tipoglobalclienteDataAccess.getDefinicions(connexion,tipoglobalcliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoglobalcliente.setDefinicions(tipoglobalclienteDataAccess.getDefinicions(connexion,tipoglobalcliente));

				if(this.isConDeep) {
					DefinicionLogic definicionLogic= new DefinicionLogic(this.connexion);
					definicionLogic.setDefinicions(tipoglobalcliente.getDefinicions());
					ArrayList<Classe> classesLocal=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(new ArrayList<Classe>(),DeepLoadType.NONE);
					definicionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(definicionLogic.getDefinicions());
					tipoglobalcliente.setDefinicions(definicionLogic.getDefinicions());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Definicion.class));
			tipoglobalcliente.setDefinicions(tipoglobalclienteDataAccess.getDefinicions(connexion,tipoglobalcliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipoglobalcliente.setDefinicions(tipoglobalclienteDataAccess.getDefinicions(connexion,tipoglobalcliente));

		for(Definicion definicion:tipoglobalcliente.getDefinicions()) {
			DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
			definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoglobalcliente.setDefinicions(tipoglobalclienteDataAccess.getDefinicions(connexion,tipoglobalcliente));

				for(Definicion definicion:tipoglobalcliente.getDefinicions()) {
					DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
					definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Definicion.class));
			tipoglobalcliente.setDefinicions(tipoglobalclienteDataAccess.getDefinicions(connexion,tipoglobalcliente));

			for(Definicion definicion:tipoglobalcliente.getDefinicions()) {
				DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
				definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoGlobalCliente tipoglobalcliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGlobalCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoglobalcliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(tipoglobalcliente);
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
			this.deepLoad(this.tipoglobalcliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(this.tipoglobalcliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGlobalCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoglobalclientes!=null) {
				for(TipoGlobalCliente tipoglobalcliente:tipoglobalclientes) {
					this.deepLoad(tipoglobalcliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(tipoglobalclientes);
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
			if(tipoglobalclientes!=null) {
				for(TipoGlobalCliente tipoglobalcliente:tipoglobalclientes) {
					this.deepLoad(tipoglobalcliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoGlobalClienteConstantesFunciones.refrescarForeignKeysDescripcionesTipoGlobalCliente(tipoglobalclientes);
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
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoGlobalClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGlobalClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoGlobalCliente tipoglobalcliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoGlobalClienteConstantesFunciones.ISCONAUDITORIA) {
				if(tipoglobalcliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGlobalClienteDataAccess.TABLENAME, tipoglobalcliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGlobalClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGlobalClienteLogic.registrarAuditoriaDetallesTipoGlobalCliente(connexion,tipoglobalcliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoglobalcliente.getIsDeleted()) {
					/*if(!tipoglobalcliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoGlobalClienteDataAccess.TABLENAME, tipoglobalcliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoGlobalClienteLogic.registrarAuditoriaDetallesTipoGlobalCliente(connexion,tipoglobalcliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGlobalClienteDataAccess.TABLENAME, tipoglobalcliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoglobalcliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGlobalClienteDataAccess.TABLENAME, tipoglobalcliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGlobalClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGlobalClienteLogic.registrarAuditoriaDetallesTipoGlobalCliente(connexion,tipoglobalcliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoGlobalCliente(Connexion connexion,TipoGlobalCliente tipoglobalcliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoglobalcliente.getIsNew()||!tipoglobalcliente.getcodigo().equals(tipoglobalcliente.getTipoGlobalClienteOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoglobalcliente.getTipoGlobalClienteOriginal().getcodigo()!=null)
				{
					strValorActual=tipoglobalcliente.getTipoGlobalClienteOriginal().getcodigo();
				}
				if(tipoglobalcliente.getcodigo()!=null)
				{
					strValorNuevo=tipoglobalcliente.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGlobalClienteConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoglobalcliente.getIsNew()||!tipoglobalcliente.getnombre().equals(tipoglobalcliente.getTipoGlobalClienteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoglobalcliente.getTipoGlobalClienteOriginal().getnombre()!=null)
				{
					strValorActual=tipoglobalcliente.getTipoGlobalClienteOriginal().getnombre();
				}
				if(tipoglobalcliente.getnombre()!=null)
				{
					strValorNuevo=tipoglobalcliente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGlobalClienteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGlobalCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGlobalClienteConstantesFunciones.getClassesForeignKeysOfTipoGlobalCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGlobalCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGlobalClienteConstantesFunciones.getClassesRelationshipsOfTipoGlobalCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

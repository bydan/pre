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
import com.bydan.erp.cartera.util.GarantiaClienteConstantesFunciones;
import com.bydan.erp.cartera.util.GarantiaClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.GarantiaClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.GarantiaCliente;
import com.bydan.erp.cartera.business.logic.GarantiaClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class GarantiaClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(GarantiaClienteLogic.class);
	
	protected GarantiaClienteDataAccess garantiaclienteDataAccess; 	
	protected GarantiaCliente garantiacliente;
	protected List<GarantiaCliente> garantiaclientes;
	protected Object garantiaclienteObject;	
	protected List<Object> garantiaclientesObject;
	
	public static ClassValidator<GarantiaCliente> garantiaclienteValidator = new ClassValidator<GarantiaCliente>(GarantiaCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected GarantiaClienteLogicAdditional garantiaclienteLogicAdditional=null;
	
	public GarantiaClienteLogicAdditional getGarantiaClienteLogicAdditional() {
		return this.garantiaclienteLogicAdditional;
	}
	
	public void setGarantiaClienteLogicAdditional(GarantiaClienteLogicAdditional garantiaclienteLogicAdditional) {
		try {
			this.garantiaclienteLogicAdditional=garantiaclienteLogicAdditional;
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
	
	
	
	
	public  GarantiaClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.garantiaclienteDataAccess = new GarantiaClienteDataAccess();
			
			this.garantiaclientes= new ArrayList<GarantiaCliente>();
			this.garantiacliente= new GarantiaCliente();
			
			this.garantiaclienteObject=new Object();
			this.garantiaclientesObject=new ArrayList<Object>();
				
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
			
			this.garantiaclienteDataAccess.setConnexionType(this.connexionType);
			this.garantiaclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  GarantiaClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.garantiaclienteDataAccess = new GarantiaClienteDataAccess();
			this.garantiaclientes= new ArrayList<GarantiaCliente>();
			this.garantiacliente= new GarantiaCliente();
			this.garantiaclienteObject=new Object();
			this.garantiaclientesObject=new ArrayList<Object>();
			
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
			
			this.garantiaclienteDataAccess.setConnexionType(this.connexionType);
			this.garantiaclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public GarantiaCliente getGarantiaCliente() throws Exception {	
		GarantiaClienteLogicAdditional.checkGarantiaClienteToGet(garantiacliente,this.datosCliente,this.arrDatoGeneral);
		GarantiaClienteLogicAdditional.updateGarantiaClienteToGet(garantiacliente,this.arrDatoGeneral);
		
		return garantiacliente;
	}
		
	public void setGarantiaCliente(GarantiaCliente newGarantiaCliente) {
		this.garantiacliente = newGarantiaCliente;
	}
	
	public GarantiaClienteDataAccess getGarantiaClienteDataAccess() {
		return garantiaclienteDataAccess;
	}
	
	public void setGarantiaClienteDataAccess(GarantiaClienteDataAccess newgarantiaclienteDataAccess) {
		this.garantiaclienteDataAccess = newgarantiaclienteDataAccess;
	}
	
	public List<GarantiaCliente> getGarantiaClientes() throws Exception {		
		this.quitarGarantiaClientesNulos();
		
		GarantiaClienteLogicAdditional.checkGarantiaClienteToGets(garantiaclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (GarantiaCliente garantiaclienteLocal: garantiaclientes ) {
			GarantiaClienteLogicAdditional.updateGarantiaClienteToGet(garantiaclienteLocal,this.arrDatoGeneral);
		}
		
		return garantiaclientes;
	}
	
	public void setGarantiaClientes(List<GarantiaCliente> newGarantiaClientes) {
		this.garantiaclientes = newGarantiaClientes;
	}
	
	public Object getGarantiaClienteObject() {	
		this.garantiaclienteObject=this.garantiaclienteDataAccess.getEntityObject();
		return this.garantiaclienteObject;
	}
		
	public void setGarantiaClienteObject(Object newGarantiaClienteObject) {
		this.garantiaclienteObject = newGarantiaClienteObject;
	}
	
	public List<Object> getGarantiaClientesObject() {		
		this.garantiaclientesObject=this.garantiaclienteDataAccess.getEntitiesObject();
		return this.garantiaclientesObject;
	}
		
	public void setGarantiaClientesObject(List<Object> newGarantiaClientesObject) {
		this.garantiaclientesObject = newGarantiaClientesObject;
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
		
		if(this.garantiaclienteDataAccess!=null) {
			this.garantiaclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			garantiaclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			garantiaclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		garantiacliente = new  GarantiaCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			garantiacliente=garantiaclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.garantiacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiacliente);
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
		garantiacliente = new  GarantiaCliente();
		  		  
        try {
			
			garantiacliente=garantiaclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.garantiacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		garantiacliente = new  GarantiaCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			garantiacliente=garantiaclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.garantiacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiacliente);
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
		garantiacliente = new  GarantiaCliente();
		  		  
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
		garantiacliente = new  GarantiaCliente();
		  		  
        try {
			
			garantiacliente=garantiaclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.garantiacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		garantiacliente = new  GarantiaCliente();
		  		  
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
		garantiacliente = new  GarantiaCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =garantiaclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		garantiacliente = new  GarantiaCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=garantiaclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		garantiacliente = new  GarantiaCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =garantiaclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		garantiacliente = new  GarantiaCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=garantiaclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		garantiacliente = new  GarantiaCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =garantiaclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		garantiacliente = new  GarantiaCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=garantiaclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		garantiaclientes = new  ArrayList<GarantiaCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGarantiaCliente(garantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
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
		garantiaclientes = new  ArrayList<GarantiaCliente>();
		  		  
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
		garantiaclientes = new  ArrayList<GarantiaCliente>();
		  		  
        try {			
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarGarantiaCliente(garantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		garantiaclientes = new  ArrayList<GarantiaCliente>();
		  		  
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
		garantiaclientes = new  ArrayList<GarantiaCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGarantiaCliente(garantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
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
		garantiaclientes = new  ArrayList<GarantiaCliente>();
		  		  
        try {
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGarantiaCliente(garantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
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
		garantiaclientes = new  ArrayList<GarantiaCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGarantiaCliente(garantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
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
		garantiaclientes = new  ArrayList<GarantiaCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGarantiaCliente(garantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		garantiacliente = new  GarantiaCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			garantiacliente=garantiaclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGarantiaCliente(garantiacliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiacliente);
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
		garantiacliente = new  GarantiaCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			garantiacliente=garantiaclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGarantiaCliente(garantiacliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		garantiaclientes = new  ArrayList<GarantiaCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			garantiaclientes=garantiaclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGarantiaCliente(garantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
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
		garantiaclientes = new  ArrayList<GarantiaCliente>();
		  		  
        try {
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			garantiaclientes=garantiaclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGarantiaCliente(garantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosGarantiaClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		garantiaclientes = new  ArrayList<GarantiaCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getTodosGarantiaClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGarantiaCliente(garantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
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
	
	public  void  getTodosGarantiaClientes(String sFinalQuery,Pagination pagination)throws Exception {
		garantiaclientes = new  ArrayList<GarantiaCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGarantiaCliente(garantiaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarGarantiaCliente(GarantiaCliente garantiacliente) throws Exception {
		Boolean estaValidado=false;
		
		if(garantiacliente.getIsNew() || garantiacliente.getIsChanged()) { 
			this.invalidValues = garantiaclienteValidator.getInvalidValues(garantiacliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(garantiacliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarGarantiaCliente(List<GarantiaCliente> GarantiaClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(GarantiaCliente garantiaclienteLocal:garantiaclientes) {				
			estaValidadoObjeto=this.validarGuardarGarantiaCliente(garantiaclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarGarantiaCliente(List<GarantiaCliente> GarantiaClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGarantiaCliente(garantiaclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarGarantiaCliente(GarantiaCliente GarantiaCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGarantiaCliente(garantiacliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(GarantiaCliente garantiacliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+garantiacliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=GarantiaClienteConstantesFunciones.getGarantiaClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"garantiacliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(GarantiaClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(GarantiaClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveGarantiaClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-saveGarantiaClienteWithConnection");connexion.begin();			
			
			GarantiaClienteLogicAdditional.checkGarantiaClienteToSave(this.garantiacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GarantiaClienteLogicAdditional.updateGarantiaClienteToSave(this.garantiacliente,this.arrDatoGeneral);
			
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.garantiacliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowGarantiaCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGarantiaCliente(this.garantiacliente)) {
				GarantiaClienteDataAccess.save(this.garantiacliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.garantiacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GarantiaClienteLogicAdditional.checkGarantiaClienteToSaveAfter(this.garantiacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGarantiaCliente();
			
			connexion.commit();			
			
			if(this.garantiacliente.getIsDeleted()) {
				this.garantiacliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveGarantiaCliente()throws Exception {	
		try {	
			
			GarantiaClienteLogicAdditional.checkGarantiaClienteToSave(this.garantiacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GarantiaClienteLogicAdditional.updateGarantiaClienteToSave(this.garantiacliente,this.arrDatoGeneral);
			
			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.garantiacliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGarantiaCliente(this.garantiacliente)) {			
				GarantiaClienteDataAccess.save(this.garantiacliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.garantiacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GarantiaClienteLogicAdditional.checkGarantiaClienteToSaveAfter(this.garantiacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.garantiacliente.getIsDeleted()) {
				this.garantiacliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveGarantiaClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-saveGarantiaClientesWithConnection");connexion.begin();			
			
			GarantiaClienteLogicAdditional.checkGarantiaClienteToSaves(garantiaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowGarantiaClientes();
			
			Boolean validadoTodosGarantiaCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GarantiaCliente garantiaclienteLocal:garantiaclientes) {		
				if(garantiaclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GarantiaClienteLogicAdditional.updateGarantiaClienteToSave(garantiaclienteLocal,this.arrDatoGeneral);
	        	
				GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),garantiaclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGarantiaCliente(garantiaclienteLocal)) {
					GarantiaClienteDataAccess.save(garantiaclienteLocal, connexion);				
				} else {
					validadoTodosGarantiaCliente=false;
				}
			}
			
			if(!validadoTodosGarantiaCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GarantiaClienteLogicAdditional.checkGarantiaClienteToSavesAfter(garantiaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGarantiaClientes();
			
			connexion.commit();		
			
			this.quitarGarantiaClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveGarantiaClientes()throws Exception {				
		 try {	
			GarantiaClienteLogicAdditional.checkGarantiaClienteToSaves(garantiaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosGarantiaCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GarantiaCliente garantiaclienteLocal:garantiaclientes) {				
				if(garantiaclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GarantiaClienteLogicAdditional.updateGarantiaClienteToSave(garantiaclienteLocal,this.arrDatoGeneral);
	        	
				GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),garantiaclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGarantiaCliente(garantiaclienteLocal)) {				
					GarantiaClienteDataAccess.save(garantiaclienteLocal, connexion);				
				} else {
					validadoTodosGarantiaCliente=false;
				}
			}
			
			if(!validadoTodosGarantiaCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GarantiaClienteLogicAdditional.checkGarantiaClienteToSavesAfter(garantiaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarGarantiaClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GarantiaClienteParameterReturnGeneral procesarAccionGarantiaClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GarantiaCliente> garantiaclientes,GarantiaClienteParameterReturnGeneral garantiaclienteParameterGeneral)throws Exception {
		 try {	
			GarantiaClienteParameterReturnGeneral garantiaclienteReturnGeneral=new GarantiaClienteParameterReturnGeneral();
	
			GarantiaClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,garantiaclientes,garantiaclienteParameterGeneral,garantiaclienteReturnGeneral);
			
			return garantiaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GarantiaClienteParameterReturnGeneral procesarAccionGarantiaClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GarantiaCliente> garantiaclientes,GarantiaClienteParameterReturnGeneral garantiaclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-procesarAccionGarantiaClientesWithConnection");connexion.begin();			
			
			GarantiaClienteParameterReturnGeneral garantiaclienteReturnGeneral=new GarantiaClienteParameterReturnGeneral();
	
			GarantiaClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,garantiaclientes,garantiaclienteParameterGeneral,garantiaclienteReturnGeneral);
			
			this.connexion.commit();
			
			return garantiaclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GarantiaClienteParameterReturnGeneral procesarEventosGarantiaClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GarantiaCliente> garantiaclientes,GarantiaCliente garantiacliente,GarantiaClienteParameterReturnGeneral garantiaclienteParameterGeneral,Boolean isEsNuevoGarantiaCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			GarantiaClienteParameterReturnGeneral garantiaclienteReturnGeneral=new GarantiaClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				garantiaclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GarantiaClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,garantiaclientes,garantiacliente,garantiaclienteParameterGeneral,garantiaclienteReturnGeneral,isEsNuevoGarantiaCliente,clases);
			
			return garantiaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public GarantiaClienteParameterReturnGeneral procesarEventosGarantiaClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GarantiaCliente> garantiaclientes,GarantiaCliente garantiacliente,GarantiaClienteParameterReturnGeneral garantiaclienteParameterGeneral,Boolean isEsNuevoGarantiaCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-procesarEventosGarantiaClientesWithConnection");connexion.begin();			
			
			GarantiaClienteParameterReturnGeneral garantiaclienteReturnGeneral=new GarantiaClienteParameterReturnGeneral();
	
			garantiaclienteReturnGeneral.setGarantiaCliente(garantiacliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				garantiaclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GarantiaClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,garantiaclientes,garantiacliente,garantiaclienteParameterGeneral,garantiaclienteReturnGeneral,isEsNuevoGarantiaCliente,clases);
			
			this.connexion.commit();
			
			return garantiaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GarantiaClienteParameterReturnGeneral procesarImportacionGarantiaClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,GarantiaClienteParameterReturnGeneral garantiaclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-procesarImportacionGarantiaClientesWithConnection");connexion.begin();			
			
			GarantiaClienteParameterReturnGeneral garantiaclienteReturnGeneral=new GarantiaClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.garantiaclientes=new ArrayList<GarantiaCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.garantiacliente=new GarantiaCliente();
				
				
				if(conColumnasBase) {this.garantiacliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.garantiacliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.garantiacliente.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.garantiacliente.setfecha_recepcion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.garantiacliente.setfecha_firma(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.garantiacliente.setfecha_devolucion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.garantiacliente.setbeneficiario(arrColumnas[iColumn++]);
				
				this.garantiaclientes.add(this.garantiacliente);
			}
			
			this.saveGarantiaClientes();
			
			this.connexion.commit();
			
			garantiaclienteReturnGeneral.setConRetornoEstaProcesado(true);
			garantiaclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return garantiaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarGarantiaClientesEliminados() throws Exception {				
		
		List<GarantiaCliente> garantiaclientesAux= new ArrayList<GarantiaCliente>();
		
		for(GarantiaCliente garantiacliente:garantiaclientes) {
			if(!garantiacliente.getIsDeleted()) {
				garantiaclientesAux.add(garantiacliente);
			}
		}
		
		garantiaclientes=garantiaclientesAux;
	}
	
	public void quitarGarantiaClientesNulos() throws Exception {				
		
		List<GarantiaCliente> garantiaclientesAux= new ArrayList<GarantiaCliente>();
		
		for(GarantiaCliente garantiacliente : this.garantiaclientes) {
			if(garantiacliente==null) {
				garantiaclientesAux.add(garantiacliente);
			}
		}
		
		//this.garantiaclientes=garantiaclientesAux;
		
		this.garantiaclientes.removeAll(garantiaclientesAux);
	}
	
	public void getSetVersionRowGarantiaClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(garantiacliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((garantiacliente.getIsDeleted() || (garantiacliente.getIsChanged()&&!garantiacliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=garantiaclienteDataAccess.getSetVersionRowGarantiaCliente(connexion,garantiacliente.getId());
				
				if(!garantiacliente.getVersionRow().equals(timestamp)) {	
					garantiacliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				garantiacliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowGarantiaCliente()throws Exception {	
		
		if(garantiacliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((garantiacliente.getIsDeleted() || (garantiacliente.getIsChanged()&&!garantiacliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=garantiaclienteDataAccess.getSetVersionRowGarantiaCliente(connexion,garantiacliente.getId());
			
			try {							
				if(!garantiacliente.getVersionRow().equals(timestamp)) {	
					garantiacliente.setVersionRow(timestamp);
				}
				
				garantiacliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowGarantiaClientesWithConnection()throws Exception {	
		if(garantiaclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(GarantiaCliente garantiaclienteAux:garantiaclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(garantiaclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(garantiaclienteAux.getIsDeleted() || (garantiaclienteAux.getIsChanged()&&!garantiaclienteAux.getIsNew())) {
						
						timestamp=garantiaclienteDataAccess.getSetVersionRowGarantiaCliente(connexion,garantiaclienteAux.getId());
						
						if(!garantiacliente.getVersionRow().equals(timestamp)) {	
							garantiaclienteAux.setVersionRow(timestamp);
						}
								
						garantiaclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowGarantiaClientes()throws Exception {	
		if(garantiaclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(GarantiaCliente garantiaclienteAux:garantiaclientes) {
					if(garantiaclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(garantiaclienteAux.getIsDeleted() || (garantiaclienteAux.getIsChanged()&&!garantiaclienteAux.getIsNew())) {
						
						timestamp=garantiaclienteDataAccess.getSetVersionRowGarantiaCliente(connexion,garantiaclienteAux.getId());
						
						if(!garantiaclienteAux.getVersionRow().equals(timestamp)) {	
							garantiaclienteAux.setVersionRow(timestamp);
						}
						
													
						garantiaclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public GarantiaClienteParameterReturnGeneral cargarCombosLoteForeignKeyGarantiaClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalTipoGarantiaEmpresa,String finalQueryGlobalEstadoGarantiaCliente) throws Exception {
		GarantiaClienteParameterReturnGeneral  garantiaclienteReturnGeneral =new GarantiaClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyGarantiaClienteWithConnection");connexion.begin();
			
			garantiaclienteReturnGeneral =new GarantiaClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			garantiaclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			garantiaclienteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			garantiaclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoGarantiaEmpresa> tipogarantiaempresasForeignKey=new ArrayList<TipoGarantiaEmpresa>();
			TipoGarantiaEmpresaLogic tipogarantiaempresaLogic=new TipoGarantiaEmpresaLogic();
			tipogarantiaempresaLogic.setConnexion(this.connexion);
			//tipogarantiaempresaLogic.getTipoGarantiaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGarantiaEmpresa.equals("NONE")) {
				tipogarantiaempresaLogic.getTodosTipoGarantiaEmpresas(finalQueryGlobalTipoGarantiaEmpresa,new Pagination());
				tipogarantiaempresasForeignKey=tipogarantiaempresaLogic.getTipoGarantiaEmpresas();
			}

			garantiaclienteReturnGeneral.settipogarantiaempresasForeignKey(tipogarantiaempresasForeignKey);


			List<EstadoGarantiaCliente> estadogarantiaclientesForeignKey=new ArrayList<EstadoGarantiaCliente>();
			EstadoGarantiaClienteLogic estadogarantiaclienteLogic=new EstadoGarantiaClienteLogic();
			estadogarantiaclienteLogic.setConnexion(this.connexion);
			estadogarantiaclienteLogic.getEstadoGarantiaClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoGarantiaCliente.equals("NONE")) {
				estadogarantiaclienteLogic.getTodosEstadoGarantiaClientes(finalQueryGlobalEstadoGarantiaCliente,new Pagination());
				estadogarantiaclientesForeignKey=estadogarantiaclienteLogic.getEstadoGarantiaClientes();
			}

			garantiaclienteReturnGeneral.setestadogarantiaclientesForeignKey(estadogarantiaclientesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return garantiaclienteReturnGeneral;
	}
	
	public GarantiaClienteParameterReturnGeneral cargarCombosLoteForeignKeyGarantiaCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalTipoGarantiaEmpresa,String finalQueryGlobalEstadoGarantiaCliente) throws Exception {
		GarantiaClienteParameterReturnGeneral  garantiaclienteReturnGeneral =new GarantiaClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			garantiaclienteReturnGeneral =new GarantiaClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			garantiaclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			garantiaclienteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			garantiaclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoGarantiaEmpresa> tipogarantiaempresasForeignKey=new ArrayList<TipoGarantiaEmpresa>();
			TipoGarantiaEmpresaLogic tipogarantiaempresaLogic=new TipoGarantiaEmpresaLogic();
			tipogarantiaempresaLogic.setConnexion(this.connexion);
			//tipogarantiaempresaLogic.getTipoGarantiaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGarantiaEmpresa.equals("NONE")) {
				tipogarantiaempresaLogic.getTodosTipoGarantiaEmpresas(finalQueryGlobalTipoGarantiaEmpresa,new Pagination());
				tipogarantiaempresasForeignKey=tipogarantiaempresaLogic.getTipoGarantiaEmpresas();
			}

			garantiaclienteReturnGeneral.settipogarantiaempresasForeignKey(tipogarantiaempresasForeignKey);


			List<EstadoGarantiaCliente> estadogarantiaclientesForeignKey=new ArrayList<EstadoGarantiaCliente>();
			EstadoGarantiaClienteLogic estadogarantiaclienteLogic=new EstadoGarantiaClienteLogic();
			estadogarantiaclienteLogic.setConnexion(this.connexion);
			estadogarantiaclienteLogic.getEstadoGarantiaClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoGarantiaCliente.equals("NONE")) {
				estadogarantiaclienteLogic.getTodosEstadoGarantiaClientes(finalQueryGlobalEstadoGarantiaCliente,new Pagination());
				estadogarantiaclientesForeignKey=estadogarantiaclienteLogic.getEstadoGarantiaClientes();
			}

			garantiaclienteReturnGeneral.setestadogarantiaclientesForeignKey(estadogarantiaclientesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return garantiaclienteReturnGeneral;
	}
	
	
	public void deepLoad(GarantiaCliente garantiacliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			GarantiaClienteLogicAdditional.updateGarantiaClienteToGet(garantiacliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		garantiacliente.setEmpresa(garantiaclienteDataAccess.getEmpresa(connexion,garantiacliente));
		garantiacliente.setSucursal(garantiaclienteDataAccess.getSucursal(connexion,garantiacliente));
		garantiacliente.setCliente(garantiaclienteDataAccess.getCliente(connexion,garantiacliente));
		garantiacliente.setTipoGarantiaEmpresa(garantiaclienteDataAccess.getTipoGarantiaEmpresa(connexion,garantiacliente));
		garantiacliente.setEstadoGarantiaCliente(garantiaclienteDataAccess.getEstadoGarantiaCliente(connexion,garantiacliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				garantiacliente.setEmpresa(garantiaclienteDataAccess.getEmpresa(connexion,garantiacliente));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				garantiacliente.setSucursal(garantiaclienteDataAccess.getSucursal(connexion,garantiacliente));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				garantiacliente.setCliente(garantiaclienteDataAccess.getCliente(connexion,garantiacliente));
				continue;
			}

			if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
				garantiacliente.setTipoGarantiaEmpresa(garantiaclienteDataAccess.getTipoGarantiaEmpresa(connexion,garantiacliente));
				continue;
			}

			if(clas.clas.equals(EstadoGarantiaCliente.class)) {
				garantiacliente.setEstadoGarantiaCliente(garantiaclienteDataAccess.getEstadoGarantiaCliente(connexion,garantiacliente));
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
			garantiacliente.setEmpresa(garantiaclienteDataAccess.getEmpresa(connexion,garantiacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			garantiacliente.setSucursal(garantiaclienteDataAccess.getSucursal(connexion,garantiacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			garantiacliente.setCliente(garantiaclienteDataAccess.getCliente(connexion,garantiacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			garantiacliente.setTipoGarantiaEmpresa(garantiaclienteDataAccess.getTipoGarantiaEmpresa(connexion,garantiacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoGarantiaCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			garantiacliente.setEstadoGarantiaCliente(garantiaclienteDataAccess.getEstadoGarantiaCliente(connexion,garantiacliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		garantiacliente.setEmpresa(garantiaclienteDataAccess.getEmpresa(connexion,garantiacliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(garantiacliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		garantiacliente.setSucursal(garantiaclienteDataAccess.getSucursal(connexion,garantiacliente));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(garantiacliente.getSucursal(),isDeep,deepLoadType,clases);
				
		garantiacliente.setCliente(garantiaclienteDataAccess.getCliente(connexion,garantiacliente));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(garantiacliente.getCliente(),isDeep,deepLoadType,clases);
				
		garantiacliente.setTipoGarantiaEmpresa(garantiaclienteDataAccess.getTipoGarantiaEmpresa(connexion,garantiacliente));
		TipoGarantiaEmpresaLogic tipogarantiaempresaLogic= new TipoGarantiaEmpresaLogic(connexion);
		tipogarantiaempresaLogic.deepLoad(garantiacliente.getTipoGarantiaEmpresa(),isDeep,deepLoadType,clases);
				
		garantiacliente.setEstadoGarantiaCliente(garantiaclienteDataAccess.getEstadoGarantiaCliente(connexion,garantiacliente));
		EstadoGarantiaClienteLogic estadogarantiaclienteLogic= new EstadoGarantiaClienteLogic(connexion);
		estadogarantiaclienteLogic.deepLoad(garantiacliente.getEstadoGarantiaCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				garantiacliente.setEmpresa(garantiaclienteDataAccess.getEmpresa(connexion,garantiacliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(garantiacliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				garantiacliente.setSucursal(garantiaclienteDataAccess.getSucursal(connexion,garantiacliente));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(garantiacliente.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				garantiacliente.setCliente(garantiaclienteDataAccess.getCliente(connexion,garantiacliente));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(garantiacliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
				garantiacliente.setTipoGarantiaEmpresa(garantiaclienteDataAccess.getTipoGarantiaEmpresa(connexion,garantiacliente));
				TipoGarantiaEmpresaLogic tipogarantiaempresaLogic= new TipoGarantiaEmpresaLogic(connexion);
				tipogarantiaempresaLogic.deepLoad(garantiacliente.getTipoGarantiaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoGarantiaCliente.class)) {
				garantiacliente.setEstadoGarantiaCliente(garantiaclienteDataAccess.getEstadoGarantiaCliente(connexion,garantiacliente));
				EstadoGarantiaClienteLogic estadogarantiaclienteLogic= new EstadoGarantiaClienteLogic(connexion);
				estadogarantiaclienteLogic.deepLoad(garantiacliente.getEstadoGarantiaCliente(),isDeep,deepLoadType,clases);				
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
			garantiacliente.setEmpresa(garantiaclienteDataAccess.getEmpresa(connexion,garantiacliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(garantiacliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			garantiacliente.setSucursal(garantiaclienteDataAccess.getSucursal(connexion,garantiacliente));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(garantiacliente.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			garantiacliente.setCliente(garantiaclienteDataAccess.getCliente(connexion,garantiacliente));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(garantiacliente.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			garantiacliente.setTipoGarantiaEmpresa(garantiaclienteDataAccess.getTipoGarantiaEmpresa(connexion,garantiacliente));
			TipoGarantiaEmpresaLogic tipogarantiaempresaLogic= new TipoGarantiaEmpresaLogic(connexion);
			tipogarantiaempresaLogic.deepLoad(garantiacliente.getTipoGarantiaEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoGarantiaCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			garantiacliente.setEstadoGarantiaCliente(garantiaclienteDataAccess.getEstadoGarantiaCliente(connexion,garantiacliente));
			EstadoGarantiaClienteLogic estadogarantiaclienteLogic= new EstadoGarantiaClienteLogic(connexion);
			estadogarantiaclienteLogic.deepLoad(garantiacliente.getEstadoGarantiaCliente(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(GarantiaCliente garantiacliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			GarantiaClienteLogicAdditional.updateGarantiaClienteToSave(garantiacliente,this.arrDatoGeneral);
			
GarantiaClienteDataAccess.save(garantiacliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(garantiacliente.getEmpresa(),connexion);

		SucursalDataAccess.save(garantiacliente.getSucursal(),connexion);

		ClienteDataAccess.save(garantiacliente.getCliente(),connexion);

		TipoGarantiaEmpresaDataAccess.save(garantiacliente.getTipoGarantiaEmpresa(),connexion);

		EstadoGarantiaClienteDataAccess.save(garantiacliente.getEstadoGarantiaCliente(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(garantiacliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(garantiacliente.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(garantiacliente.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
				TipoGarantiaEmpresaDataAccess.save(garantiacliente.getTipoGarantiaEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoGarantiaCliente.class)) {
				EstadoGarantiaClienteDataAccess.save(garantiacliente.getEstadoGarantiaCliente(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(garantiacliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(garantiacliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(garantiacliente.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(garantiacliente.getSucursal(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(garantiacliente.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(garantiacliente.getCliente(),isDeep,deepLoadType,clases);
				

		TipoGarantiaEmpresaDataAccess.save(garantiacliente.getTipoGarantiaEmpresa(),connexion);
		TipoGarantiaEmpresaLogic tipogarantiaempresaLogic= new TipoGarantiaEmpresaLogic(connexion);
		tipogarantiaempresaLogic.deepLoad(garantiacliente.getTipoGarantiaEmpresa(),isDeep,deepLoadType,clases);
				

		EstadoGarantiaClienteDataAccess.save(garantiacliente.getEstadoGarantiaCliente(),connexion);
		EstadoGarantiaClienteLogic estadogarantiaclienteLogic= new EstadoGarantiaClienteLogic(connexion);
		estadogarantiaclienteLogic.deepLoad(garantiacliente.getEstadoGarantiaCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(garantiacliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(garantiacliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(garantiacliente.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(garantiacliente.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(garantiacliente.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(garantiacliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
				TipoGarantiaEmpresaDataAccess.save(garantiacliente.getTipoGarantiaEmpresa(),connexion);
				TipoGarantiaEmpresaLogic tipogarantiaempresaLogic= new TipoGarantiaEmpresaLogic(connexion);
				tipogarantiaempresaLogic.deepSave(garantiacliente.getTipoGarantiaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoGarantiaCliente.class)) {
				EstadoGarantiaClienteDataAccess.save(garantiacliente.getEstadoGarantiaCliente(),connexion);
				EstadoGarantiaClienteLogic estadogarantiaclienteLogic= new EstadoGarantiaClienteLogic(connexion);
				estadogarantiaclienteLogic.deepSave(garantiacliente.getEstadoGarantiaCliente(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(GarantiaCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(garantiacliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(garantiacliente);
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
			this.deepLoad(this.garantiacliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(GarantiaCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(garantiaclientes!=null) {
				for(GarantiaCliente garantiacliente:garantiaclientes) {
					this.deepLoad(garantiacliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(garantiaclientes);
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
			if(garantiaclientes!=null) {
				for(GarantiaCliente garantiacliente:garantiaclientes) {
					this.deepLoad(garantiacliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(garantiaclientes);
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
			this.getNewConnexionToDeep(GarantiaCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(garantiacliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(GarantiaCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(garantiaclientes!=null) {
				for(GarantiaCliente garantiacliente:garantiaclientes) {
					this.deepSave(garantiacliente,isDeep,deepLoadType,clases);
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
			if(garantiaclientes!=null) {
				for(GarantiaCliente garantiacliente:garantiaclientes) {
					this.deepSave(garantiacliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getGarantiaClientesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,GarantiaClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGarantiaClientesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,GarantiaClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGarantiaClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GarantiaClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGarantiaClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GarantiaClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGarantiaClientesFK_IdEstadoGarantiaClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_garantia_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoGarantiaCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoGarantiaCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_garantia_cliente,GarantiaClienteConstantesFunciones.IDESTADOGARANTIACLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoGarantiaCliente);

			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoGarantiaCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGarantiaClientesFK_IdEstadoGarantiaCliente(String sFinalQuery,Pagination pagination,Long id_estado_garantia_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoGarantiaCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoGarantiaCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_garantia_cliente,GarantiaClienteConstantesFunciones.IDESTADOGARANTIACLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoGarantiaCliente);

			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoGarantiaCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGarantiaClientesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,GarantiaClienteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGarantiaClientesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,GarantiaClienteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGarantiaClientesFK_IdTipoGarantiaEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_garantia_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GarantiaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGarantiaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGarantiaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_garantia_empresa,GarantiaClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGarantiaEmpresa);

			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGarantiaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGarantiaClientesFK_IdTipoGarantiaEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_garantia_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGarantiaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGarantiaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_garantia_empresa,GarantiaClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGarantiaEmpresa);

			GarantiaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGarantiaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(this.garantiaclientes);
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
			if(GarantiaClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,GarantiaClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,GarantiaCliente garantiacliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(GarantiaClienteConstantesFunciones.ISCONAUDITORIA) {
				if(garantiacliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GarantiaClienteDataAccess.TABLENAME, garantiacliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GarantiaClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GarantiaClienteLogic.registrarAuditoriaDetallesGarantiaCliente(connexion,garantiacliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(garantiacliente.getIsDeleted()) {
					/*if(!garantiacliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,GarantiaClienteDataAccess.TABLENAME, garantiacliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////GarantiaClienteLogic.registrarAuditoriaDetallesGarantiaCliente(connexion,garantiacliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GarantiaClienteDataAccess.TABLENAME, garantiacliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(garantiacliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GarantiaClienteDataAccess.TABLENAME, garantiacliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GarantiaClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GarantiaClienteLogic.registrarAuditoriaDetallesGarantiaCliente(connexion,garantiacliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesGarantiaCliente(Connexion connexion,GarantiaCliente garantiacliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(garantiacliente.getIsNew()||!garantiacliente.getid_empresa().equals(garantiacliente.getGarantiaClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(garantiacliente.getGarantiaClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=garantiacliente.getGarantiaClienteOriginal().getid_empresa().toString();
				}
				if(garantiacliente.getid_empresa()!=null)
				{
					strValorNuevo=garantiacliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GarantiaClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(garantiacliente.getIsNew()||!garantiacliente.getid_sucursal().equals(garantiacliente.getGarantiaClienteOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(garantiacliente.getGarantiaClienteOriginal().getid_sucursal()!=null)
				{
					strValorActual=garantiacliente.getGarantiaClienteOriginal().getid_sucursal().toString();
				}
				if(garantiacliente.getid_sucursal()!=null)
				{
					strValorNuevo=garantiacliente.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GarantiaClienteConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(garantiacliente.getIsNew()||!garantiacliente.getid_cliente().equals(garantiacliente.getGarantiaClienteOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(garantiacliente.getGarantiaClienteOriginal().getid_cliente()!=null)
				{
					strValorActual=garantiacliente.getGarantiaClienteOriginal().getid_cliente().toString();
				}
				if(garantiacliente.getid_cliente()!=null)
				{
					strValorNuevo=garantiacliente.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GarantiaClienteConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(garantiacliente.getIsNew()||!garantiacliente.getid_tipo_garantia_empresa().equals(garantiacliente.getGarantiaClienteOriginal().getid_tipo_garantia_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(garantiacliente.getGarantiaClienteOriginal().getid_tipo_garantia_empresa()!=null)
				{
					strValorActual=garantiacliente.getGarantiaClienteOriginal().getid_tipo_garantia_empresa().toString();
				}
				if(garantiacliente.getid_tipo_garantia_empresa()!=null)
				{
					strValorNuevo=garantiacliente.getid_tipo_garantia_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GarantiaClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(garantiacliente.getIsNew()||!garantiacliente.getvalor().equals(garantiacliente.getGarantiaClienteOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(garantiacliente.getGarantiaClienteOriginal().getvalor()!=null)
				{
					strValorActual=garantiacliente.getGarantiaClienteOriginal().getvalor().toString();
				}
				if(garantiacliente.getvalor()!=null)
				{
					strValorNuevo=garantiacliente.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GarantiaClienteConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(garantiacliente.getIsNew()||!garantiacliente.getfecha_recepcion().equals(garantiacliente.getGarantiaClienteOriginal().getfecha_recepcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(garantiacliente.getGarantiaClienteOriginal().getfecha_recepcion()!=null)
				{
					strValorActual=garantiacliente.getGarantiaClienteOriginal().getfecha_recepcion().toString();
				}
				if(garantiacliente.getfecha_recepcion()!=null)
				{
					strValorNuevo=garantiacliente.getfecha_recepcion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GarantiaClienteConstantesFunciones.FECHARECEPCION,strValorActual,strValorNuevo);
			}	
			
			if(garantiacliente.getIsNew()||!garantiacliente.getfecha_firma().equals(garantiacliente.getGarantiaClienteOriginal().getfecha_firma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(garantiacliente.getGarantiaClienteOriginal().getfecha_firma()!=null)
				{
					strValorActual=garantiacliente.getGarantiaClienteOriginal().getfecha_firma().toString();
				}
				if(garantiacliente.getfecha_firma()!=null)
				{
					strValorNuevo=garantiacliente.getfecha_firma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GarantiaClienteConstantesFunciones.FECHAFIRMA,strValorActual,strValorNuevo);
			}	
			
			if(garantiacliente.getIsNew()||!garantiacliente.getfecha_devolucion().equals(garantiacliente.getGarantiaClienteOriginal().getfecha_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(garantiacliente.getGarantiaClienteOriginal().getfecha_devolucion()!=null)
				{
					strValorActual=garantiacliente.getGarantiaClienteOriginal().getfecha_devolucion().toString();
				}
				if(garantiacliente.getfecha_devolucion()!=null)
				{
					strValorNuevo=garantiacliente.getfecha_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GarantiaClienteConstantesFunciones.FECHADEVOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(garantiacliente.getIsNew()||!garantiacliente.getbeneficiario().equals(garantiacliente.getGarantiaClienteOriginal().getbeneficiario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(garantiacliente.getGarantiaClienteOriginal().getbeneficiario()!=null)
				{
					strValorActual=garantiacliente.getGarantiaClienteOriginal().getbeneficiario();
				}
				if(garantiacliente.getbeneficiario()!=null)
				{
					strValorNuevo=garantiacliente.getbeneficiario() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GarantiaClienteConstantesFunciones.BENEFICIARIO,strValorActual,strValorNuevo);
			}	
			
			if(garantiacliente.getIsNew()||!garantiacliente.getid_estado_garantia_cliente().equals(garantiacliente.getGarantiaClienteOriginal().getid_estado_garantia_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(garantiacliente.getGarantiaClienteOriginal().getid_estado_garantia_cliente()!=null)
				{
					strValorActual=garantiacliente.getGarantiaClienteOriginal().getid_estado_garantia_cliente().toString();
				}
				if(garantiacliente.getid_estado_garantia_cliente()!=null)
				{
					strValorNuevo=garantiacliente.getid_estado_garantia_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GarantiaClienteConstantesFunciones.IDESTADOGARANTIACLIENTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveGarantiaClienteRelacionesWithConnection(GarantiaCliente garantiacliente) throws Exception {

		if(!garantiacliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGarantiaClienteRelacionesBase(garantiacliente,true);
		}
	}

	public void saveGarantiaClienteRelaciones(GarantiaCliente garantiacliente)throws Exception {

		if(!garantiacliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGarantiaClienteRelacionesBase(garantiacliente,false);
		}
	}

	public void saveGarantiaClienteRelacionesBase(GarantiaCliente garantiacliente,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("GarantiaCliente-saveRelacionesWithConnection");}
	

			this.setGarantiaCliente(garantiacliente);

			if(GarantiaClienteLogicAdditional.validarSaveRelaciones(garantiacliente,this)) {

				GarantiaClienteLogicAdditional.updateRelacionesToSave(garantiacliente,this);

				if((garantiacliente.getIsNew()||garantiacliente.getIsChanged())&&!garantiacliente.getIsDeleted()) {
					this.saveGarantiaCliente();
					this.saveGarantiaClienteRelacionesDetalles();

				} else if(garantiacliente.getIsDeleted()) {
					this.saveGarantiaClienteRelacionesDetalles();
					this.saveGarantiaCliente();
				}

				GarantiaClienteLogicAdditional.updateRelacionesToSaveAfter(garantiacliente,this);

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
	
	
	private void saveGarantiaClienteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfGarantiaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GarantiaClienteConstantesFunciones.getClassesForeignKeysOfGarantiaCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGarantiaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GarantiaClienteConstantesFunciones.getClassesRelationshipsOfGarantiaCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
